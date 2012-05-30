package model;

import java.util.ArrayList;

import javax.swing.JFrame;

import sprite.Drawable;
import sprite.Sprite;
import view.Camera;
import view.Canvas;

import loader.LoaderMap;
import map.Map;
import menu.Menu;

public class Model {
	//main vars
	private final String[] mapPaths = {"res/maps/level1/", "res/maps/level2/", "res/menubg/"};
	private Map[] maps;
	private JFrame frame;
	public int width = 800, height = 400;
	
	private Thread loop;
	//private LoaderMap loader;
	private ArrayList<Drawable> drawList;
	private ArrayList<Update> updateList;
	private Canvas canvas;
	private Menu menu;
	private Camera camera;
	
	//fps
	private long startTime = System.currentTimeMillis(), frames = 1;
	private Sprite fps = new Sprite("fps: 0");
	
	public Model(){
		
		//loader = new LoaderMap();
		maps = new LoaderMap().loadMaps(mapPaths);
		//render = new Render();
		
		drawList = new ArrayList<Drawable>();
		updateList = new ArrayList<Update>();
		
		frame = new JFrame();
		frame.setSize(width, height);
		frame.setTitle("ascii adv.");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		camera = new Camera();
		
		canvas = new Canvas("fixedsys.ttf", camera, drawList);
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
	
	char[][] cl = {{' ', ' ', '/', '\\', ' ', ' '}, {' ', '/', 'X', 'X', '\\', ' '}, {'/', 'X', 'x', 'x', 'X', '\\'}, {' ', ' ', '|', '|', ' ', ' '}};
	Sprite spr = new Sprite(cl);
	
	public void start(){
		drawList.clear();
		updateList.clear();
		
		menu = new Menu(this, "Join", "Host", "Options");
		
		fps.setX(0);
		fps.setY(0);
		//fps.setxAcc(0.001f);
		drawList.add(fps);
		updateList.add(fps);
		
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
		
		frames++;
		fps.setString("frames: " + frames + "  fps: " + ((float)frames / (float)((System.currentTimeMillis() - startTime))));
		if(frames >= 10000000){
			frames = 1;
			startTime = System.currentTimeMillis();
			menu.next();
		}
		
		menu.update(delta);
	}
	
	public void render(){
		canvas.repaint();
	}
	
	public ArrayList<Drawable> getDrawList(){
		return drawList;
	}
	
	public ArrayList<Update> getUpdateList(){
		return updateList;
	}
	
	public Map getMap(String name){
		for(int i = 0; i < maps.length; i++){
			if(maps[i].getName().toLowerCase().contains(name.toLowerCase())){
				return maps[i];
			}
		}
		return null;
	}
}