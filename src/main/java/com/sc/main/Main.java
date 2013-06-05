package com.sc.main;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import com.sc.db.Database;



public class Main extends JFrame implements ActionListener {

	private Vis mainPanel;
	private static final String M = "MALE";
	private static final String F = "FEMALE";
	private Database db;


	public Main() {

		JMenuBar mb = setupMenu();
		setJMenuBar(mb);

		db = new Database();
		mainPanel = new Vis(db);
		setContentPane(mainPanel);
		
	
		setPreferredSize(new Dimension(800,600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Honolulu Marathon");
		pack();
		setVisible(true);
	}
	
	private JMenuBar setupMenu() {
		//instantiate menubar, menus, and menu options
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		
		JMenu gender = new JMenu("Gender");
		JMenuItem male = new JMenuItem("Male");
		JMenuItem female = new JMenuItem("Female");

		//no hook them all together
		gender.add(male);
		gender.add(female);

		fileMenu.add(gender);
		menuBar.add(fileMenu);

		//setup action listeners
		male.setActionCommand(M);
		male.addActionListener(this);
		female.setActionCommand(F);
		female.addActionListener(this);
		
		return menuBar;
	}

	public void actionPerformed(ActionEvent ae) {
		String command = ae.getActionCommand();
		db.query(command);
		System.out.println("Action Event Command: " + command);
		mainPanel.repaint();
	}
	
	public static void main(String[] args) {

		//this makes the GUI adopt the look-n-feel of the windowing system (Windows/X/Mac)
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) { }

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Main();
			}
		});
	}
}
