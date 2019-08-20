package br.senai.sp.informatica.servlets.libs;

import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class MessageImage {
	public static BufferedImage makeMessageImage(String message, String fontName, int fontSize) {
		Font font = new Font(fontName, Font.PLAIN, fontSize);
		FontMetrics metrics = getFontMetrics(font);
		int messageWidth = metrics.stringWidth(message);
		int baselineX = messageWidth / 10;
		int width = messageWidth + 2 * (baselineX + fontSize);
		int height = fontSize * 7 / 2;
		int baselineY = height * 8 / 10;
		
		BufferedImage messageImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = (Graphics2D) messageImage.getGraphics();
		g2d.setBackground(Color.white);
		g2d.clearRect(0, 0, width, height);
		g2d.setFont(font);
		g2d.translate(baselineX, baselineY);
		g2d.setPaint(Color.lightGray);
		
		AffineTransform origTransform = g2d.getTransform();
		g2d.shear(-0.95, 0);
		g2d.scale(1, 3);
		g2d.drawString(message, 0, 0);
		g2d.setTransform(origTransform);
		g2d.setPaint(Color.black);
		g2d.drawString(message, 0, 0);
		
		return (messageImage);
	}

	public static void writeJPEG(BufferedImage image, OutputStream out) {
		try {
			ImageIO.write(image, "jpg", out);
		} catch (IOException ioe) {
			System.err.println("Error outputting JPEG: " + ioe);
		}
	}

	public static void writeJPEG(BufferedImage image, File file) {
		try {
			ImageIO.write(image, "jpg", file);
		} catch (IOException ioe) {
			System.err.println("Error writing JPEG file: " + ioe);
		}
	}

	public static String[] getFontNames() {
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		return (env.getAvailableFontFamilyNames());
	}

	private static FontMetrics getFontMetrics(Font font) {
		BufferedImage tempImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = (Graphics2D) tempImage.getGraphics();
		return (g2d.getFontMetrics(font));
	}
}
