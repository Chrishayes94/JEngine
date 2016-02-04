package core.world.map;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

public class MapData {
	
	

	public static void encodeFile(String location, int index) {
		try {
			FileInputStream fin = new FileInputStream(location);
			
			FileOutputStream fout = new FileOutputStream("maps/map_data_pack_" + index + ".dat");
			DeflaterOutputStream out = new DeflaterOutputStream(fout);
			
			int i;
			while ((i = fin.read()) != -1) {
				out.write(streamIn(i));
				out.flush();
			}
			
			fin.close();
			out.close();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
	
	public static File decodeFile(String location) {
		try {
			FileInputStream fin = new FileInputStream(location);
			InflaterInputStream in = new InflaterInputStream(fin);
			
			FileOutputStream fout = new FileOutputStream("raw_maps/temporary.txt");
			
			int i;
			while ((i = in.read()) != -1) {
				fout.write(streamOut(i));
				fout.flush();
			}
			
			fin.close();
			fout.close();
			in.close();
			return new File("temporary.txt");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	protected static byte streamIn(int i) {
		
		double extraBytes = Math.log10(i);
		return (byte) ((byte) i + extraBytes);
	}
	
	protected static byte streamOut(int i) {
		double extraBytes = Math.pow(10, i);
		return (byte) ((byte) i - extraBytes);
	}
}
