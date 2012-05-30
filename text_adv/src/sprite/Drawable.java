package sprite;

public interface Drawable {
	
	public double getX();
	
	public double getY();
	
	public double getZ();
	
	public char[][] getCharSet();
	
	public int getIndex();
	
	public boolean fill();
}
