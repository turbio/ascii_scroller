package menu;

import java.util.ArrayList;

import sprite.Sprite;
import model.Model;

public class Menu {
	private Sprite pointer, border, bg, bg2;
	private ArrayList<MenuItem> options = new ArrayList<MenuItem>();
	private int select = 0;
	private Model model;
	
	public Menu(Model m, String... opt){
		model = m;
		
		for(int i = 0; i < opt.length; i++){
			options.add(new MenuItem(opt[i]));
			options.get(i).setX(model.width / 2);
			options.get(i).setY((i * 25) + ((model.height / 2) - (opt.length * 25)));
		}
		
		pointer = new Sprite(">>");
		
		char[][] bset = new char[10][50];
		
		for(int y = 0; y < bset.length; y++){
			for(int x = 0; x < bset[y].length; x++){
				if(x == 0 || x == bset[y].length - 1){
					bset[y][x] = '|';
					if(y == 0 || y == bset.length - 1){
						bset[y][x] = '+';
					}
				}else if(y == 0 || y == bset.length - 1){
					bset[y][x] = '-';
				}else{
					bset[y][x] = ' ';
				}
			}
		}
		
		border = new Sprite(bset);
		border.setX(options.get(0).getX() - 50);
		border.setY(options.get(0).getY() - 25);
		
		pointer.setX(options.get(select).getX() - (pointer.getCharSet().length * 25));
		pointer.setY(options.get(select).getY());
		
		bg = new Sprite(model.getMap("menu").getRaw()[2]);
		bg2 = new Sprite(model.getMap("menu").getRaw()[2]);
		
		bg2.setX(-bg.getCharSet().length * 24);
		
		bg.setXVel(0.01);
		bg2.setXVel(0.01);
		
		model.getDrawList().add(bg);
		model.getDrawList().add(bg2);
		
		m.getDrawList().add(border);
		m.getDrawList().add(pointer);
		m.getDrawList().addAll(options);
	}
	
	public void setOptions(){
		
	}
	
	public void next(){
		if(select >= options.size() - 1){
			select = 0;
		}else{
			select++;
		}
		
		pointer.setX(options.get(select).getX() - (pointer.getCharSet().length * 25));
		pointer.setY(options.get(select).getY());
	}
	
	public void prev(){
		if(select <= 0){
			select = options.size() - 1;
		}else{
			select--;
		}
		
		pointer.setX(options.get(select).getX() - (pointer.getCharSet().length * 25));
		pointer.setY(options.get(select).getY());
	}
	
	public void refresh(){
		
	}
	
	public void update(double delta){
		bg.update(delta);
		bg2.update(delta);
		
		if(bg.getX() > bg2.getCharSet().length * 24){
			bg.setX(-bg.getCharSet().length * 24);
		}
		if(bg2.getX() > bg.getCharSet().length * 24){
			bg2.setX(-bg2.getCharSet().length * 24);
		}
	}
}
