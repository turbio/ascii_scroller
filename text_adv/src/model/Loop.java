package model;

public class Loop implements Runnable{
	private boolean running = true;
	private Model model;
	
	public Loop(Model m){
		model = m;
	}
	
	public void stop(){
		running = false;
	}
	
	public void run(){
		double startTime, updateTime, renderTime, delta = 0;
		
		while(running){
			startTime = ((double)System.nanoTime() / 1000000d);
			
			model.update(delta);
			updateTime = ((double)System.nanoTime() / 1000000d) - startTime;
			
			model.render();
			renderTime = (((double)System.nanoTime() / 1000000d) - startTime) - updateTime;
			
			delta = (updateTime + renderTime);
		}
	}

}
