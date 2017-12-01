package intro_to_file_io;

import java.io.FileWriter;
import java.io.IOException;

public class CopyrightAdder {
		public static void main(String[] args) {
			String copyright = "//copyright © isaac 2017 stan 24k";
			try {
				FileWriter fw = new FileWriter("src/intro_to_file_io/MessageReader.java",true);
				fw.write(copyright);
				fw.close();
				fw = new FileWriter("src/intro_to_file_io/MessageSaver.java",true);
				fw.write(copyright);
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}
