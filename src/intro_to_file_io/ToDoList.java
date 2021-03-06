package intro_to_file_io;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements MouseListener{
	
	public ToDoList() {
		setupGUI();
	}
	
	JFrame frame;
	JPanel panel;
	JLabel label;
	JButton addTask;
	JButton removeTask;
	JButton saveList;
	JButton loadList;
	int savenum =0;
	String all;
	ArrayList<String> tasks;
	
	private void setupGUI() {
		tasks = new ArrayList<String>();
		frame = new JFrame("to do");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout());
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(420,420));
		addTask = new JButton();
		addTask.setText("add task");
		removeTask = new JButton();
		removeTask.setText("remove task");
		saveList = new JButton();
		saveList.setText("save");
		loadList = new JButton();
		loadList.setText("load");
		label = new JLabel();
		panel.setOpaque(true);
		addTask.setOpaque(true);
		removeTask.setOpaque(true);
		saveList.setOpaque(true);
		loadList.setOpaque(true);
		frame.getContentPane().add(panel);
		panel.add(addTask);
		panel.add(removeTask);
		panel.add(saveList);
		panel.add(loadList);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		
		addTask.addMouseListener(this);
		removeTask.addMouseListener(this);
		saveList.addMouseListener(this);
		loadList.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==addTask) {
			String task = JOptionPane.showInputDialog("enter a task:");
			tasks.add(task);
			
			String[] array = new String[tasks.size()];
			for(int i=0;i<tasks.size();i++) {
				String temp = "<html>" + (i+1) + ". " + tasks.get(i) + "<br><html>";
				array[i] = temp;
			}
			all = array[0];
			for(int i=1;i<array.length;i++) {
				all += array[i];
			}
			label.setText(all);
			label.setOpaque(true);
			panel.add(label);
			frame.pack();
		}
		else if(e.getSource()==removeTask) {
			String task = JOptionPane.showInputDialog("enter the number you want to remove:");
			int index = Integer.parseInt(task);
			try {
				tasks.remove(index-1);
			}catch(IndexOutOfBoundsException g) {
			
			}
			if(tasks.size()!=0) {
			String[] array = new String[tasks.size()];
			for(int i=0;i<tasks.size();i++) {
				String temp = "<html>" + (i+1) + ". " + tasks.get(i) + "<br><html>";
				array[i] = temp;
			}
			all = array[0];
			for(int i=1;i<array.length;i++) {
				all += array[i];
			}
			label.setText(all);
			label.setOpaque(true);
			panel.add(label);
			frame.pack();
			}
			else {
				label.setText(null);
				label.setOpaque(true);
				panel.add(label);
				frame.pack();
			}
		}
		else if(e.getSource()==saveList) {
			savenum++;
			String filename = "src/intro_to_file_io/save_n" + savenum +".txt";
			try {
				FileWriter fw = new FileWriter(filename);
				String codeNeeded="";
				for(int i =0;i<tasks.size();i++) {
					codeNeeded+=(tasks.get(i)+"\n");
				}
				fw.write(codeNeeded);
				fw.close();
				JOptionPane.showMessageDialog(null, "saved!");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==loadList) {
			String fileName = null;
			try {
				JFileChooser jfc = new JFileChooser();
				int returnVal = jfc.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					fileName = jfc.getSelectedFile().getAbsolutePath();
					System.out.println(fileName);
				}
				BufferedReader br = new BufferedReader(new FileReader(fileName));
				tasks.clear();
				String line = br.readLine();
				while(line != null){
					tasks.add(line);
					line = br.readLine();
				}
				br.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			String[] array = new String[tasks.size()];
			for(int i=0;i<tasks.size();i++) {
				String temp = "<html>" + (i+1) + ". " + tasks.get(i) + "<br><html>";
				array[i] = temp;
			}
			all = array[0];
			for(int i=1;i<array.length;i++) {
				all += array[i];
			}
			label.setText(all);
			label.setOpaque(true);
			panel.add(label);
			frame.pack();
			}
			else {
				label.setText(null);
				label.setOpaque(true);
				panel.add(label);
				frame.pack();
			}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
