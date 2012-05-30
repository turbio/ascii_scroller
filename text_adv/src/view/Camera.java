package view;

import sprite.Sprite;

public class Camera extends Sprite{
	public double zoom;
	
	public void setZoom(double d){
		zoom = d;
	}
	
	public double getZoom(){
		return zoom;
	}
}
