package loader;

public class LoadText {

	public LoadText(){
		
	}
	
	public void load(String path){
		long s = System.currentTimeMillis();
		for(int i = 0; i < 500; i++){
			System.out.println("proccesed");
		}
		System.out.println(System.currentTimeMillis() - s);
	}
}
