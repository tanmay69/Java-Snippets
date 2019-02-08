package test.frequency;

import java.io.*;
import java.text.*;
import java.util.*;
import java.awt.image.*;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.Line2D;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;

public class Waves {
    
	Vector<Line2D.Double> lines = new Vector<Line2D.Double>();   
	File soundFile;
	String soundPath, pngPath;
	AudioInputStream audioInputStream;
	double duration,seconds;
	Sample sample;
	Capture capture;
	int pngHeight=1000,pngWidth=1500;
	

    Color imageBackgroundColor = new Color(255,255,255);
	
	Waves(String soundPath,String pngPath)
	{
		soundFile = new File(soundPath);
		this.pngPath = pngPath;
	}
	
	public void createAudioStream() {
		if(soundFile != null && soundFile.isFile()) {
			try {
				audioInputStream = AudioSystem.getAudioInputStream(soundFile);
				long time = (long) ((audioInputStream.getFrameLength()*1000) / audioInputStream.getFormat().getFrameRate());
				duration = time / 1000;
			}  catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Audio File Not Found" + soundPath);
		}
	}
	
	class Sample implements Runnable {

		Thread thread;
	    private Font font12 = new Font("serif", Font.PLAIN, 12);
	    Color jfcBlue = new Color(000, 000, 255);
	    Color pink = new Color(255, 175, 175);

	        
		public void createWaveForm(byte[] audioBytes) {

            lines.removeAllElements();  // clear the old vector

            AudioFormat format = audioInputStream.getFormat();
            if (audioBytes == null) {
                try {
                    audioBytes = new byte[
                        (int) (audioInputStream.getFrameLength() 
                        * format.getFrameSize())];
                    audioInputStream.read(audioBytes);
                } catch (Exception ex) { 
                    ex.printStackTrace();
                    return; 
                }
            }

            int[] audioData = null;
            if (format.getSampleSizeInBits() == 16) {
                 int nlengthInSamples = audioBytes.length / 2;
                 audioData = new int[nlengthInSamples];
                 if (format.isBigEndian()) {
                    for (int i = 0; i < nlengthInSamples; i++) {
                         /* First byte is MSB (high order) */
                         int MSB = (int) audioBytes[2*i];
                         /* Second byte is LSB (low order) */
                         int LSB = (int) audioBytes[2*i+1];
                         audioData[i] = MSB << 8 | (255 & LSB);
                     }
                 } else {
                     for (int i = 0; i < nlengthInSamples; i++) {
                         /* First byte is LSB (low order) */
                         int LSB = (int) audioBytes[2*i];
                         /* Second byte is MSB (high order) */
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

            int frames_per_pixel = audioBytes.length / format.getFrameSize()/pngWidth;
            byte my_byte = 0;
            double y_last = 0;
            int numChannels = format.getChannels();
            for (double x = 0; x < pngWidth && audioData != null; x++) {
                int idx = (int) (frames_per_pixel * numChannels * x);
                if (format.getSampleSizeInBits() == 8) {
                     my_byte = (byte) audioData[idx];
                } else {
                     my_byte = (byte) (128 * audioData[idx] / 32768 );
                }
                double y_new = (double) (pngHeight * (128 - my_byte) / 256);
                lines.add(new Line2D.Double(x, y_last, x, y_new));
                y_last = y_new;
            }
            saveToFile(soundPath);
        }


        public void saveToFile(String filename) {     
        	
            int INFOPAD = 15;

            BufferedImage bufferedImage = new BufferedImage(pngWidth, pngHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2 = bufferedImage.createGraphics();

            createSampleOnGraphicsContext(pngWidth, pngHeight, INFOPAD, g2);            
            g2.dispose();
            // Write generated image to a file
            try {
                // Save as PNG
                File file = new File(filename);
                ImageIO.write(bufferedImage, "png", file);
            } catch (IOException e) {
            }
        }


        private void createSampleOnGraphicsContext(int w, int h, int INFOPAD, Graphics2D g2) {            
            g2.setBackground(imageBackgroundColor);
            g2.clearRect(0, 0, w, h);
            g2.setColor(Color.white);
            g2.fillRect(0, h-INFOPAD, w, INFOPAD);

            if (capture.thread != null) {
                g2.setColor(Color.black);
                g2.setFont(font12);
                //g2.drawString("Length: " + String.valueOf(seconds), 3, h-4);
            } else {
                g2.setColor(Color.black);
                g2.setFont(font12);
                g2.drawString("File: " + soundPath + "  Length: " + String.valueOf(duration) + "  Position: " + String.valueOf(seconds), 3, h-4);

                if (audioInputStream != null) {
                    // .. render sampling graph ..
                    g2.setColor(jfcBlue);
                    for (int i = 1; i < lines.size(); i++) {
                        g2.draw((Line2D) lines.get(i));
                    }

                    // .. draw current position ..
                    if (seconds != 0) {
                        double loc = seconds/duration*w;
                        g2.setColor(pink);
                        g2.setStroke(new BasicStroke(3));
                        g2.draw(new Line2D.Double(loc, 0, loc, h-INFOPAD-2));
                    }
                }
            }
        }
		
		public void start()
		{
			thread = new Thread(this);
			thread.setName("Sampling");
			thread.start();
			seconds = 0;
		}
		
		public void stop()
		{
			if(thread != null)
				thread.interrupt();
			thread = null;
		}
		
		@Override
		public void run() {
			seconds = 0;
			while(thread!=null) {
				if((capture.line != null) && (capture.line.isActive()))
				{
					long mili = capture.line.getMicrosecondPosition() / 1000;
					seconds = mili / 1000;
				}
				
				try
				{
					thread.sleep(100);
				} catch(Exception e)
				{
					e.printStackTrace();
					break;
				}
				
				while(capture.line != null && !capture.line.isActive())
				{
					try {
						thread.sleep(10);
					} catch (Exception e) {
						e.printStackTrace();
						break;
					}
				}
			}
		}
		
	}
	
	class Capture implements Runnable {

		Thread thread;
		TargetDataLine line;
		
		public void start()
		{
			thread = new Thread(this);
			thread.setName("Capture");
			thread.start();
		}
		
		public void stop()
		{
			if(thread != null)
				thread.interrupt();
			thread = null;
		}
		
		public void shutdown(String str)
		{
			thread = null;
			sample.stop();
			System.err.print(str);
		}
		
		@Override
		public void run() {
			duration = 0;
			audioInputStream = null;
			
			AudioFormat format = audioInputStream.getFormat();
			DataLine.Info info = new DataLine.Info(TargetDataLine.class,format);
			if(AudioSystem.isLineSupported(info))
			{
				shutdown("Line not Suported");
			}
			
			try {
				line = (TargetDataLine) AudioSystem.getLine(info);
				line.open(format,line.getBufferSize());
			} catch(Exception e)
			{
				shutdown(e.toString());
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
	        
	        try
	        {
	        	out.flush();
	        	out.close();
	        }catch(Exception e)
	        {
	        	e.printStackTrace();
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

            sample.createWaveForm(audioBytes);
		}
	}
	
	public static void main(String srgs[])
	{
		Waves waves = new Waves("C:\\Users\\Tanmay Ghosh\\Documents\\temp.wav","C:\\Users\\Tanmay Ghosh\\Documents\\temp.png");
		waves.createAudioStream();
	}
}
