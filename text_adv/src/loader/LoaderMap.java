package loader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import map.Map;
import map.Tile;

public class LoaderMap {
	
	public Map[] loadMaps(String[] path){
		BufferedReader reader = null;
		Map[] maps = new Map[path.length];
		
		for(int i = 0; i < path.length; i++){
			File[] files = new File(path[i]).listFiles();
			char[][][] charset = null;
			
			int width = 0, height = 0;
			String name = "";
			
			for(int md = 0; md < files.length; md++){
				if(files[md].getName().contains("mapinfo")){
					try {
						Scanner scan = new Scanner(files[md]);
						while(scan.hasNext()){
							String sline = scan.nextLine();
							if(sline.charAt(0) == 'w'){
								width = Integer.parseInt(sline.split(" ")[1]);
							}else if(sline.charAt(0) == 'h'){
								height = Integer.parseInt(sline.split(" ")[1]);
							}else if(sline.charAt(0) == 'n'){
								name = sline.split(" ")[1];
							}
						}
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				}
			}
			
			charset = new char[4][height][width + 1];
			
			for(int a = 0; a < charset.length; a++){
				for(int b = 0; b < charset[a].length; b++){
					for(int c = 0; c < charset[a][b].length; c++){
						charset[a][b][c] = ' ';
					}
				}
			}
			
			for(int f = 0; f < files.length; f++){
				
				if(files[f].getName().contains(".txt")){
					try {
						 reader = new BufferedReader(new FileReader(files[f]));
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					
					String line = "";
					int currentline = 0;
					try {
						while((line = reader.readLine()) != null){
							if(files[f].getName().contains("fg")){
								char[] readline = line.toCharArray();
								
								for(int x = 0; x < readline.length; x++){
									charset[3][currentline][x] = readline[x];
								}
								currentline++;
							}else if(files[f].getName().contains("mg")){
								char[] readline = line.toCharArray();
								
								for(int x = 0; x < readline.length; x++){
									charset[2][currentline][x] = readline[x];
								}
								currentline++;
							}else if(files[f].getName().contains("bg")){
								char[] readline = line.toCharArray();
								
								for(int x = 0; x < readline.length; x++){
									charset[1][currentline][x] = readline[x];
								}
								currentline++;
							}else if(files[f].getName().contains("data")){
								char[] readline = line.toCharArray();
								
								for(int x = 0; x < readline.length; x++){
									charset[0][currentline][x] = readline[x];
								}
								currentline++;
							}
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			
			Tile[][] tiles = new Tile[charset[0].length][charset[0][0].length];
			
			for(int y = 0; y < charset[0].length; y++){
				for(int x = 0; x < charset[0][y].length; x++){
					tiles[y][x] = new Tile(charset[3][y][x], charset[2][y][x], charset[1][y][x], 0, false, false);
				}
			}
			
			maps[i] = new Map(name, tiles);
			
		}
		
		return maps;
	}
}
