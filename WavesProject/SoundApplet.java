import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.*;
import java.applet.*;
import java.util.Vector;
import java.net.*;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;

public class SoundApplet extends Applet{

	Graphics2D g2;

	public void init()
	{
		Frame f = new Frame();
		final FileDialog fileDialog = new FileDialog(f,"Select file");
      	Button showFileDialogButton = new Button("Open File");
     	 showFileDialogButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            fileDialog.setVisible(true);
            try
        {
        	
        	AudioClip clip = Applet.newAudioClip(new File(fileDialog.getDirectory() + fileDialog.getFile()).toURI().toURL());
           clip.play();
	        AudiotoWave awc = new AudiotoWave(fileDialog.getDirectory() + fileDialog.getFile(),g2);
	        awc.createAudioInputStream();
	        repaint();
        }catch(Exception ex)
        {	
        	System.out.println(ex.toString());
        }
         }
      });
     	 add(showFileDialogButton);
	}
	public void paint(Graphics g)
	{
		g2 = (Graphics2D)g.create();
		g2.clearRect(0,0,600,600);
	}
}

class AudiotoWave{
    AudioInputStream audioInputStream;
    Vector<Line2D.Double> lines = new Vector<Line2D.Double>();
    String errStr;
    Capture capture = new Capture();
    double duration, seconds;
    File file;
    String fileName;
    SamplingGraph samplingGraph;
    Graphics2D g2;
    String waveformFilename;
    Color imageBackgroundColor = new Color(20,20,20);

            int w = 1200;
            int h = 600;

    public AudiotoWave(String fileName, Graphics2D g2) throws UnsupportedAudioFileException, IOException {
        file = new File(fileName);
        this.g2 = g2;
    }

    public void createAudioInputStream() throws Exception {
        if (file != null && file.isFile()) {
            try {
                errStr = null;
                audioInputStream = AudioSystem.getAudioInputStream(file);
                fileName = file.getName();
                long milliseconds = (long)((audioInputStream.getFrameLength() * 1000) / audioInputStream.getFormat().getFrameRate());
                duration = milliseconds / 1000.0;
                samplingGraph = new SamplingGraph();
                samplingGraph.createWaveForm(null);                
            } catch (Exception ex) { 
                reportStatus(ex.toString());
                throw ex;
            }
        } else {
            reportStatus("Audio file required.");
        }
    }
    class SamplingGraph implements Runnable {

        private Thread thread;
        private Font font10 = new Font("serif", Font.PLAIN, 10);
        private Font font12 = new Font("serif", Font.PLAIN, 12);
        Color jfcBlue = new Color(000, 000, 255);
        Color pink = new Color(75, 0, 130);


        public SamplingGraph() {
        }


        public void createWaveForm(byte[] audioBytes) {

            lines.removeAllElements();

            AudioFormat format = audioInputStream.getFormat();
            if (audioBytes == null) {
                try {
                    audioBytes = new byte[
                        (int) (audioInputStream.getFrameLength() 
                        * format.getFrameSize())];
                    audioInputStream.read(audioBytes);
                } catch (Exception ex) { 
                    reportStatus(ex.getMessage());
                    return; 
                }
            }
            int[] audioData = null;
            if (format.getSampleSizeInBits() == 16) {
                 int nlengthInSamples = audioBytes.length / 2;
                 audioData = new int[nlengthInSamples];
                 if (format.isBigEndian()) {
                    for (int i = 0; i < nlengthInSamples; i++) {
                         int MSB = (int) audioBytes[2*i];
                         int LSB = (int) audioBytes[2*i+1];
                         audioData[i] = MSB << 8 | (255 & LSB);
                     }
                 } else {
                     for (int i = 0; i < nlengthInSamples; i++) {
                         int LSB = (int) audioBytes[2*i];
                         int MSB = (int) audioBytes[2*i+1];
                         audioData[i] = MSB << 8 | (255 & LSB);
                     }
                 }
             } else if (format.getSampleSizeInBits() == 8) {
                 int nlengthInSamples = audioBytes.length;
                 audioData = new int[nlengthInSamples];
                 if (format.getEncoding().toString().startsWith("PCM_SIGN")) {
                     for (int i = 0; i < audioBytes.length; i++) {
                         audioData[i] = audioBytes[i];
                     }
                 } else {
                     for (int i = 0; i < audioBytes.length; i++) {
                         audioData[i] = audioBytes[i] - 128;
                     }
                 }
            }

            int frames_per_pixel = audioBytes.length / format.getFrameSize()/w;
            byte my_byte = 0;
            double y_last = 0;
            int numChannels = format.getChannels();
            for (double x = 0; x < w && audioData != null; x++) {
                int idx = (int) (frames_per_pixel * numChannels * x);
                if (format.getSampleSizeInBits() == 8) {
                     my_byte = (byte) audioData[idx];
                } else {
                     my_byte = (byte) (128 * audioData[idx] / 32768 );
                }
                double y_new = (double) (h * (128 - my_byte) / 256);
                lines.add(new Line2D.Double(x, y_last, x, y_new));
                y_last = y_new;
            }
            saveToFile(waveformFilename);
        }


        public void saveToFile(String filename) {            
            int INFOPAD = 15;

            createSampleOnGraphicsContext(w, h, INFOPAD, g2);            
            g2.dispose();
        }


        private void createSampleOnGraphicsContext(int w, int h, int INFOPAD, Graphics2D g2) {            
            g2.setBackground(imageBackgroundColor);
            g2.clearRect(0, 0, w, h);
            g2.setColor(Color.white);
            g2.fillRect(0, h-INFOPAD, w, INFOPAD);

            if (errStr != null) {
                g2.setColor(jfcBlue);
                g2.setFont(new Font("serif", Font.BOLD, 18));
                g2.drawString("ERROR", 5, 20);
                AttributedString as = new AttributedString(errStr);
                as.addAttribute(TextAttribute.FONT, font12, 0, errStr.length());
                AttributedCharacterIterator aci = as.getIterator();
                FontRenderContext frc = g2.getFontRenderContext();
                LineBreakMeasurer lbm = new LineBreakMeasurer(aci, frc);
                float x = 5, y = 25;
                lbm.setPosition(0);
                while (lbm.getPosition() < errStr.length()) {
                    TextLayout tl = lbm.nextLayout(w-x-5);
                    if (!tl.isLeftToRight()) {
                        x = w - tl.getAdvance();
                    }
                    tl.draw(g2, x, y += tl.getAscent());
                    y += tl.getDescent() + tl.getLeading();
                }
            } else if (capture.thread != null) {
                g2.setColor(Color.black);
                g2.setFont(font12);
            } else {
                g2.setColor(Color.black);
                g2.setFont(font12);
               
                if (audioInputStream != null) {
                    for (int i = 1; i < lines.size(); i++) {
                    	if(Math.abs(lines.get(i).y1 - lines.get(i).y2) < 100)
                  		  g2.setColor(pink);
                  		else
                    		g2.setColor(jfcBlue);


                        g2.draw((Line2D) lines.get(i));
                        try{
                        	long milliseconds = (long)((audioInputStream.getFrameLength() * 1000) / audioInputStream.getFormat().getFrameRate());
                           int dur = (int) milliseconds / w;
                       	 thread.sleep(dur);	
                        }catch(Exception e)
                        {

                        }
                    }

                    if (seconds != 0) {
                        double loc = seconds/duration*w;
                        g2.setColor(pink);
                        g2.setStroke(new BasicStroke(3));
                        g2.draw(new Line2D.Double(loc, 0, loc, h-INFOPAD-2));
                    }
                }
            }
            try{
                        	 thread.sleep(2000);	
                        }catch(Exception e)
                        {

                        }
        }

        public void start() {
            thread = new Thread(this);
            thread.setName("SamplingGraph");
            thread.start();
            seconds = 0;
        }

        public void stop() {
            if (thread != null) {
                thread.interrupt();
            }
            thread = null;
        }

        public void run() {
            seconds = 0;
            while (thread != null) {
                if ( (capture.line != null) && (capture.line.isActive()) ) {
                    long milliseconds = (long)(capture.line.getMicrosecondPosition() / 1000);
                    seconds =  milliseconds / 1000.0;
                }
                try { thread.sleep(100); } catch (Exception e) { break; }                              
                while ((capture.line != null && !capture.line.isActive())) 
                {
                    try { thread.sleep(10); } catch (Exception e) { break; }
                }
            }
            seconds = 0;
        }
    }

    class Capture implements Runnable {

        TargetDataLine line;
        Thread thread;

        public void start() {
            errStr = null;
            thread = new Thread(this);
            thread.setName("Capture");
            thread.start();
        }

        public void stop() {
            thread = null;
        }

        private void shutDown(String message) {
            if ((errStr = message) != null && thread != null) {
                thread = null;
                samplingGraph.stop();                
                System.err.println(errStr);
            }
        }

        public void run() {

            duration = 0;
            audioInputStream = null;

            AudioFormat format = audioInputStream.getFormat();
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, 
                format);

            if (!AudioSystem.isLineSupported(info)) {
                shutDown("Line matching " + info + " not supported.");
                return;
            }

            try {
                line = (TargetDataLine) AudioSystem.getLine(info);
                line.open(format, line.getBufferSize());
            } catch (LineUnavailableException ex) { 
                shutDown("Unable to open the line: " + ex);
                return;
            } catch (SecurityException ex) { 
                shutDown(ex.toString());
                return;
            } catch (Exception ex) { 
                shutDown(ex.toString());
                return;
            }

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int frameSizeInBytes = format.getFrameSize();
            int bufferLengthInFrames = line.getBufferSize() / 8;
            int bufferLengthInBytes = bufferLengthInFrames * frameSizeInBytes;
            byte[] data = new byte[bufferLengthInBytes];
            int numBytesRead;

            line.start();

            while (thread != null) {
                if((numBytesRead = line.read(data, 0, bufferLengthInBytes)) == -1) {
                    break;
                }
                out.write(data, 0, numBytesRead);
            }

            line.stop();
            line.close();
            line = null;

            try {
                out.flush();
                out.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            byte audioBytes[] = out.toByteArray();
            ByteArrayInputStream bais = new ByteArrayInputStream(audioBytes);
            audioInputStream = new AudioInputStream(bais, format, audioBytes.length / frameSizeInBytes);

            long milliseconds = (long)((audioInputStream.getFrameLength() * 1000) / format.getFrameRate());
            duration = milliseconds / 1000.0;

            try {
                audioInputStream.reset();
            } catch (Exception ex) { 
                ex.printStackTrace(); 
                return;
            }

            samplingGraph.createWaveForm(audioBytes);
        }
    }  
    // public static void main(String [] args) throws Exception {
    //     if (args.length != 1) {
    //         System.out.println("Enter FileName as Argument");
    //         System.exit(1);
    //     }                
    //     AudioWaveformCreator awc = new AudioWaveformCreator("../Input/" + args[0] + ".wav","../Output/" + args[0] + ".png");
    //     awc.createAudioInputStream();
    // }


    private void reportStatus(String msg) {
        if ((errStr = msg) != null) {
            System.out.println(errStr);            
        }
    }
}