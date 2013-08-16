import java.awt.EventQueue;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import logic.*;
import Data.*;


public class Start {

	private JFrame frame;
	private JTextField txtCustomerName;
	private JTextField txtStartTime;
	private JTextField txtEndTime;
	private JTextField txtNote;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start window = new Start();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Start() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		DefaultTableModel model = Util.CreateTableHeader(
				new String[]{"id", "Customer Name","Start Time","End Time", "Note"}
			);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 786, 471);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtCustomerName = new JTextField();
		txtCustomerName.setBounds(11, 112, 146, 22);
		frame.getContentPane().add(txtCustomerName);
		txtCustomerName.setColumns(10);
		
		JLabel lblCustomerName = new JLabel("Customer Name:");
		lblCustomerName.setBounds(32, 83, 104, 28);
		frame.getContentPane().add(lblCustomerName);
		
		txtStartTime = new JTextField();
		txtStartTime.setBounds(11, 160, 146, 22);
		frame.getContentPane().add(txtStartTime);
		txtStartTime.setColumns(10);
		
		JLabel lblCallStart = new JLabel("Call Start:");
		lblCallStart.setBounds(44, 135, 80, 22);
		frame.getContentPane().add(lblCallStart);
		
		txtEndTime = new JTextField();
		txtEndTime.setBounds(11, 211, 146, 22);
		frame.getContentPane().add(txtEndTime);
		txtEndTime.setColumns(10);
		
		JLabel lblCallEnd = new JLabel("Call End:");
		lblCallEnd.setBounds(53, 182, 62, 22);
		frame.getContentPane().add(lblCallEnd);
		
		txtNote = new JTextField();
		txtNote.setBounds(11, 265, 146, 70);
		frame.getContentPane().add(txtNote);
		txtNote.setColumns(10);
		
		JLabel lblNotes = new JLabel("Notes:");
		lblNotes.setBounds(53, 234, 62, 28);
		frame.getContentPane().add(lblNotes);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(191, 66, 554, 324);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable(model);
		table.setLocation(78, 0);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(36, 348, 97, 25);
		frame.getContentPane().add(btnSubmit);
		
		textField = new JTextField();
		textField.setBounds(389, 35, 242, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblSearch = new JLabel("Search:");
		lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSearch.setBounds(323, 37, 62, 16);
		frame.getContentPane().add(lblSearch);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnFile.add(mntmExit);
		
		JMenu mnDatabase = new JMenu("Database");
		menuBar.add(mnDatabase);
		
		JMenuItem mntmLoad = new JMenuItem("Load");
		mnDatabase.add(mntmLoad);
		
		JMenuItem mntmSaveItems = new JMenuItem("Save Items");
		mnDatabase.add(mntmSaveItems);
	}
}
