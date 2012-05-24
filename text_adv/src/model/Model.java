package model;

import java.util.ArrayList;

import javax.swing.JFrame;

import sprite.Drawable;
import sprite.Sprite;
import view.Canvas;

import loader.LoaderMap;
import map.Map;

public class Model {
	//main vars
	private final String[] mapPaths = {"res/maps/level1/", "res/maps/level2/"};
	private Map[] maps;
	private JFrame frame;
	private int width = 800, height = 400;
	
	private Thread loop;
	private LoaderMap loader;
	private ArrayList<Drawable> drawList;
	private ArrayList<Update> updateList;
	private Canvas canvas;
	
	public Model(){
		
		loader = new LoaderMap();
		maps = loader.loadMaps(mapPaths);
		//render = new Render();
		
		drawList = new ArrayList<Drawable>();
		updateList = new ArrayList<Update>();
		
		frame = new JFrame();
		frame.setSize(width, height);
		frame.setTitle("ascii adv.");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		canvas = new Canvas("fixedsys.ttf", drawList);
		canvas.repaint();
		
		frame.add(canvas);
		frame.setVisible(true);
		
		Sprite spr = new Sprite("null");
		Intro intro = new Intro(spr, this);
		
		updateList.add(intro);
		drawList.add(spr);
		
		start();
		
		loop = new Thread(new Loop(this));
		loop.start();
	}
	
	char[][] cl = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}};
	Sprite spr = new Sprite(cl);
	public void start(){
		drawList.clear();
		updateList.clear();
		
		drawList.add(spr);
		updateList.add(spr);
		spr.setY(height / 2);
	}
	
	public void update(double delta){
		for(int i = 0; i < updateList.size(); i++){
			updateList.get(i).update(delta);
		}
		
		if(spr.getX() < (width / 2) - 45){
			spr.setxAcc(0.001);
		}else{
			spr.setxAcc(-0.001);
		}
	}
	
	public void render(){
		canvas.repaint();
	}
}