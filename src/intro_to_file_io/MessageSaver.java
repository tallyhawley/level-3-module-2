package intro_to_file_io;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class MessageSaver {	
	public static void main(String[] args) {
		try {
			FileWriter fw = new FileWriter("src/intro_to_file_io/message.txt",true);
			
			String message=JOptionPane.showInputDialog("what do u want to say?");
			fw.write(message);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
//copyright © isaac 2017 stan 24k