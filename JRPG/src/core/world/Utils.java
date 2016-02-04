package core.world;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Utils {
	
	public static String[][] readMapData(String file) {
		String[][] mapData = null;
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			String dataString;
			
			// Determine the length of the mapdata
			// Quick loop for number of lines and width
			int length = 0;
			int cols = 0;
			
			String check;
			while ((check = in.readLine()) != null) {
				length = check.length();
				cols++;
			}
					
			mapData = new String[length][cols];
			
			int row = 0, column = 0;
			while ((dataString = in.readLine()) != null) {
				// Separate the strings determining the sheets and sprites required
				// Example map data file, {0:139:0} : 
				/// First string refers to the spritesheet
				/// Second string refers to the sprite number
				/// Third string refers to the z Offset.
				while (dataString.contains("{") && dataString.contains("}")) {
					int startIndex = dataString.indexOf("{");
					int endIndex = dataString.indexOf("}");
					
					String mapDataString = dataString.substring(startIndex, endIndex - 1) ;
					dataString.replace(mapDataString, "");
					
					mapData[row][column] = mapDataString;
					column++;
				}
				row++;
			}
			in.close();
		} catch (IOException e) {
			
		}
		return mapData;
	}
}
