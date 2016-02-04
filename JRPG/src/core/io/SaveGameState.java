package core.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import core.player.Player;

public class SaveGameState {

	public static void save(Player p) throws IOException {
		String saveLocation = "JRPG/saves/" + p.getName() + ".character";
		
		// Create the list string of all possible save
		List<String> saveInformation = new ArrayList<String>();
		
		/// Player Information
		saveInformation.add("[PLAYER]");
		saveInformation.add("name=" + p.getName());
		saveInformation.add("x=" + p.getX());
		saveInformation.add("y=" + p.getY());
	
		// Create a binary file (encoded)
		List<byte[]> bytes = getBytes(saveInformation);
		
		FileOutputStream out = new FileOutputStream(saveLocation);
		for (byte[] byteStr : bytes) {
			out.write(byteStr);
		}
		out.close();
	}
	
	protected static List<byte[]> getBytes(List<String> listStr) {
		List<byte[]> bytes = new ArrayList<byte[]>();
		for (String str : listStr) {
			byte[] bytesStr = new byte[str.length()];
			
			int index = 0;
			for (char c : str.toCharArray()) {
				bytesStr[index] = (byte)c;
			}
			
			bytes.add(bytesStr);
		}
		return bytes;
	}
}
