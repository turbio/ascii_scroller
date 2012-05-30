package model;

import sprite.Sprite;

public class Intro implements Update{
	private Sprite sprite;
	private double time = 0;
	private int curStep = 0;
	private Model model;
	
	private double[] stepTime = {0.5, 1.0, 1.5, 2.0, 2.05, 2.1, 2.15, 2.2, 2.25, 2.3, 2.35, 2.4, 2.45, 2.7, 3.0, 3.05, 3.1, 3.15, 3.2, 3.25,
			3.3, 3.35, 3.4, 3.45, 3.5, 3.55, 3.6, 3.65, 3.7, 3.75, 4.0, 5.0, 5.05, 5.2, 5.25, 5.3, 5.35, 5.4, 5.45, 5.5, 5.55, 5.6, 5.65, 5.7, 5.75, 6.5, 7.0,
			7.1, 7.2, 7.3, 7.5, 9.0, 11.0, 13.0, 15.0, 17.0, 19.0, 21.0, 21.5, 21.6, 21.7, 22.0, 22.5, 23.0, 23.5, 24.0, 24.5};
	private String[][] stepText = {{"loading."}, {"loading.."}, {"loading..."}, {"loading...."}, {"a"}, {"as"}, {"asc"}, {"asci"}, {"ascii"}, {"ascii "},
			{"ascii a"}, {"ascii ad"}, {"ascii adv"}, {"ascii adv."}, {"ascii adv. "}, {"ascii adv. ["}, {"ascii adv. [V"}, {"ascii adv. [Ve"},
			{"ascii adv. [Ver"}, {"ascii adv. [Vers"}, {"ascii adv. [Versi"}, {"ascii adv. [Versio"}, {"ascii adv. [Version"}, {"ascii adv. [Version "},
			{"ascii adv. [Version 1"}, {"ascii adv. [Version 1."}, {"ascii adv. [Version 1.0"}, {"ascii adv. [Version 1.0."}, {"ascii adv. [Version 1.0.0"},
			{"ascii adv. [Version 1.0.00"}, {"ascii adv. [Version 1.0.00]"}, {"ascii adv. [Version 1.0.00]", "", "C:\\users\\" + System.getProperty("user.name") + ">"},
			{"ascii adv. [Version 1.0.00]", "", "C:\\users\\" + System.getProperty("user.name") + ">e"}, {"ascii adv. [Version 1.0.00]", "", "C:\\users\\" + System.getProperty("user.name") + ">ec"},
			{"ascii adv. [Version 1.0.00]", "", "C:\\users\\" + System.getProperty("user.name") + ">ech"}, {"ascii adv. [Version 1.0.00]", "", "C:\\users\\" + System.getProperty("user.name") + ">echo"},
			{"ascii adv. [Version 1.0.00]", "", "C:\\users\\" + System.getProperty("user.name") + ">echo h"}, {"ascii adv. [Version 1.0.00]", "", "C:\\users\\" + System.getProperty("user.name") + ">echo he"},
			{"ascii adv. [Version 1.0.00]", "", "C:\\users\\" + System.getProperty("user.name") + ">echo hel"}, {"ascii adv. [Version 1.0.00]", "", "C:\\users\\" + System.getProperty("user.name") + ">echo hell"},
			{"ascii adv. [Version 1.0.00]", "", "C:\\users\\" + System.getProperty("user.name") + ">echo hello"}, {"ascii adv. [Version 1.0.00]", "", "C:\\users\\" + System.getProperty("user.name") + ">echo hello w"},
			{"ascii adv. [Version 1.0.00]", "", "C:\\users\\" + System.getProperty("user.name") + ">echo hello wo"}, {"ascii adv. [Version 1.0.00]", "", "C:\\users\\" + System.getProperty("user.name") + ">echo hello wor"},
			{"ascii adv. [Version 1.0.00]", "", "C:\\users\\" + System.getProperty("user.name") + ">echo hello worl"}, {"ascii adv. [Version 1.0.00]", "", "C:\\users\\" + System.getProperty("user.name") + ">echo hello world"},
			{"ascii adv. [Version 1.0.00]", "", "C:\\users\\" + System.getProperty("user.name") + ">echo hello world", "hi", "", "C:\\users\\" + System.getProperty("user.name") + ">"},
			{"ascii adv. [Version 1.0.00]", "", "C:\\users\\" + System.getProperty("user.name") + ">echo hello world", "hi", "", "C:\\users\\" + System.getProperty("user.name") + ">ec"},
			{"ascii adv. [Version 1.0.00]", "", "C:\\users\\" + System.getProperty("user.name") + ">echo hello world", "hi", "", "C:\\users\\" + System.getProperty("user.name") + ">echo"},
			{"ascii adv. [Version 1.0.00]", "", "C:\\users\\" + System.getProperty("user.name") + ">echo hello world", "hi", "", "C:\\users\\" + System.getProperty("user.name") + ">echo w"},
			{"ascii adv. [Version 1.0.00]", "", "C:\\users\\" + System.getProperty("user.name") + ">echo hello world", "hi", "", "C:\\users\\" + System.getProperty("user.name") + ">echo what"},
			{"ascii adv. [Version 1.0.00]", "", "C:\\users\\" + System.getProperty("user.name") + ">echo hello world", "hi", "", "C:\\users\\" + System.getProperty("user.name") + ">echo what", "hey", "", "C:\\users\\" + System.getProperty("user.name") + ">"},
			{"ascii adv. [Version 1.0.00]", "", "C:\\users\\" + System.getProperty("user.name") + ">echo hello world", "hi", "", "C:\\users\\" + System.getProperty("user.name") + ">echo what", "hey", "", "C:\\users\\" + System.getProperty("user.name") + ">who are you"},
			{"ascii adv. [Version 1.0.00]", "", "C:\\users\\" + System.getProperty("user.name") + ">echo hello world", "hi", "", "C:\\users\\" + System.getProperty("user.name") + ">echo what", "hey", "", "C:\\users\\" + System.getProperty("user.name") + ">who are you", "the world, duh", "", "C:\\users\\" + System.getProperty("user.name") + ">"},
			{"ascii adv. [Version 1.0.00]", "", "C:\\users\\" + System.getProperty("user.name") + ">echo hello world", "hi", "", "C:\\users\\" + System.getProperty("user.name") + ">echo what", "hey", "", "C:\\users\\" + System.getProperty("user.name") + ">who are you", "the world, duh", "", "C:\\users\\" + System.getProperty("user.name") + ">echo who is this really"},
			{"ascii adv. [Version 1.0.00]", "", "C:\\users\\" + System.getProperty("user.name") + ">echo hello world", "hi", "", "C:\\users\\" + System.getProperty("user.name") + ">echo what", "hey", "", "C:\\users\\" + System.getProperty("user.name") + ">who are you", "the world, duh", "", "C:\\users\\" + System.getProperty("user.name") + ">echo who is this really", "the world, as i said before", "", "C:\\users\\" + System.getProperty("user.name") + ">"},
			{"ascii adv. [Version 1.0.00]", "", "C:\\users\\" + System.getProperty("user.name") + ">echo hello world", "hi", "", "C:\\users\\" + System.getProperty("user.name") + ">echo what", "hey", "", "C:\\users\\" + System.getProperty("user.name") + ">who are you", "the world, duh", "", "C:\\users\\" + System.getProperty("user.name") + ">echo who is this really", "the world, as i said before", "", "C:\\users\\" + System.getProperty("user.name") + ">exit"},
			{"ascii adv. [Version 1.0.00]", "", "C:\\users\\" + System.getProperty("user.name") + ">echo hello world", "hi", "", "C:\\users\\" + System.getProperty("user.name") + ">echo what", "hey", "", "C:\\users\\" + System.getProperty("user.name") + ">who are you", "the world, duh", "", "C:\\users\\" + System.getProperty("user.name") + ">echo who is this really", "the world, as i said before", "", "C:\\users\\" + System.getProperty("user.name") + ">exit", "ha ha, nice try"},
			{"ascii adv. [Version 1.0.00]", "", "C:\\users\\" + System.getProperty("user.name") + ">echo hello world", "hi", "", "C:\\users\\" + System.getProperty("user.name") + ">echo what", "hey", "", "C:\\users\\" + System.getProperty("user.name") + ">who are you", "the world, duh", "", "C:\\users\\" + System.getProperty("user.name") + ">echo who is this really", "the world, as i said before", "", "C:\\users\\" + System.getProperty("user.name") + ">exit", "ha ha, nice try", "see if you can get yourself out of this one..."},
			{"a c i a v [ e s o 1 0 0 ]", "", "C \\ s r \\" + System.getProperty("user.name") + " e h h l o w r d", " i", "", " : u e s " + System.getProperty("user.name") + " e h w a ", "h y", "", " : u e s " + System.getProperty("user.name") + "> h a e y u", " h w r d d h ", "", " : u e s " + System.getProperty("user.name") + " e h w o i t i r a l ", "t e o l , a i s i b f r ", "", "C \\ s r \\" + System.getProperty("user.name") + ">e i ", " a h , n c t y", " e i y u c n g t y u s l o t f t i o e ."},
			{"a   i   v   e   o   0   ]", "", "C   s   \\" + System.getProperty("user.name") + " e   h   o   r  ", " i", "", " :   e   " + System.getProperty("user.name") + " e   w   ", "h  ", "", " :   e   " + System.getProperty("user.name") + "  h   e   u", " h   r   d   ", "", " :   e   " + System.getProperty("user.name") + " e   w   i   i   a   ", "t   o   ,   i   i   f   ", "", "C   s   \\" + System.getProperty("user.name") + ">e   ", " a   , n   t  ", " e   y   c   g   y   s   o   f   i   e"},
			{"_"}, {""}, {"_"}, {""}, {"_"}, {""}};
			
	
	public Intro(Sprite spr, Model m){
		sprite = spr;
		updateText();
		model = m;
	}
	
	public void update(double delta) {
		time += delta / 1000;
		sprite.update(delta);
		step();
		
		if(time > 24.5){
			model.start();
			sprite.setChar(null);
		}
	}
	
	public void step(){
		if(curStep >= stepTime.length - 1){
			return;
		}
		
		if(time > stepTime[curStep]){
			curStep++;
			updateText();
		}
	}
	
	public void updateText(){
		int max = 0;
		for(int i = 0; i < stepText[curStep].length; i++){
			if(stepText[curStep][i].length() > max){
				max = stepText[curStep][i].length();
			}
		}
		char[][] clist = new char[stepText[curStep].length][max];
		
		for(int y = 0; y < clist.length; y++){
			for(int x = 0; x < clist[y].length; x++){
				clist[y][x] = ' ';
			}
		}
		
		for(int i = 0; i < stepText[curStep].length; i++){
			char[] cur = stepText[curStep][i].toCharArray();
			for(int x = 0; x < cur.length; x++){
				clist[i][x] = cur[x];
			}
		}
		
		sprite.setChar(clist);
	}
}
