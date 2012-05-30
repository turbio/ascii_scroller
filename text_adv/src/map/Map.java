package map;

public class Map {
	private Tile[][] mapData;
	private int width, height;
	private String name;
	private boolean triggered;
	
	public Map(String n){
		name = n;
	}
	
	public Map(String n, Tile[][] t){
		name = n;
		mapData = t;
	}
	
	public void setMap(Tile[][] t){
		mapData = t;
	}
	
	
	public Tile[][] getMap(){
		return mapData;
	}
	
	public Tile getMap(int x, int y){
		return mapData[y][x];
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public void setWidth(int w){
		width = w;
	}
	
	public void setHeight(int h){
		height = h;
	}
	
	public String getName(){
		return name;
	}
	
	public void setTrigger(boolean b){
		triggered = b;
	}
	
	public boolean isTriggered(){
		return triggered;
	}
	
	public char[][][] getRaw(){
		char[][][] chardata = new char[3][mapData.length][mapData[0].length];
		
		for(int y = 0; y < mapData.length; y++){
			for(int x = 0; x < mapData[y].length; x++){
				chardata[0][y][x] = mapData[y][x].getFG();
				chardata[1][y][x] = mapData[y][x].getMG();
				chardata[2][y][x] = mapData[y][x].getBG();
			}
		}
		
		return chardata;
	}
}
