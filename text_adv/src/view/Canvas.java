package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JPanel;
import sprite.Drawable;

public class Canvas extends JPanel{
	private Font font;
	private Color black = new Color(0, 0, 0), white = new Color(200, 200, 200);
	private ArrayList<Drawable> drawList;
	private Camera cam;
	private int width = 800,  height = 400;
	FontMetrics fontMetrics;
	
	public Canvas(String s, Camera c, ArrayList<Drawable> dl){
		cam = c;
		try {
			font = Font.createFont( Font.TRUETYPE_FONT, new FileInputStream(s)).deriveFont(Font.PLAIN, 16);
		} catch (FileNotFoundException e) {}
		catch (FontFormatException e) {}
		catch (IOException e) {}
		drawList = dl;
	}
	
	public void paint(Graphics g){
		fontMetrics = g.getFontMetrics();
		
		g.setFont(font);
		
		g.setColor(black);
		g.fillRect(0, 0, super.getWidth(), super.getHeight());
		
		g.setColor(white);
		
		for(int i = 0; i < drawList.size(); i++){
			if(drawList.get(i).getCharSet() != null){
				for(int y = 0; y < drawList.get(i).getCharSet().length; y++){
					for(int x = 0; x < drawList.get(i).getCharSet()[y].length; x++){
						try{
							if(drawList.get(i).getCharSet()[y][x] != ' ' 
									&& (int)((drawList.get(i).getX() + (x * 8)) / drawList.get(i).getZ()) > -8
									&& (int)((drawList.get(i).getX() + (x * 8)) / drawList.get(i).getZ()) < width
									&& (int)((drawList.get(i).getY() + ((y * fontMetrics.getHeight()) + fontMetrics.getHeight())) / drawList.get(i).getZ()) > 0
									&& (int)((drawList.get(i).getY() + ((y * fontMetrics.getHeight()) + fontMetrics.getHeight())) / drawList.get(i).getZ()) < height){
								g.drawString(drawList.get(i).getCharSet()[y][x] + "",
									(int)((drawList.get(i).getX() + (x * 8)) / drawList.get(i).getZ()),
									(int)((drawList.get(i).getY() + ((y * fontMetrics.getHeight()) + fontMetrics.getHeight())) / drawList.get(i).getZ()));
							}
						}catch(Exception e){}
					}
				}
			}
		}
	}
}
