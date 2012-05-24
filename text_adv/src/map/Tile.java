package map;

public class Tile {
	private char foreground, middleground, background;
	private int hit = -1;
	private boolean trigger, reactor;
	
	public Tile(char f, char m, char b, int h, boolean trig, boolean react){
		foreground = f;
		middleground = m;
		background = b;
		hit = h;
		trigger = trig;
		reactor = react;
	}
	
	//get method
	public char getFG(){
		return foreground;
	}
	public char getMG(){
		return middleground;
	}
	public char getBG(){
		return background;
	}
	
	public boolean isSolide(){
		if(hit == -1) return false;
		else return true;
	}
	
	public int getHitDir(){
		return hit;
	}
	
	public boolean isTrigger(){
		return trigger;
	}
	public boolean isReactor(){
		return reactor;
	}
}
