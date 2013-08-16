import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import logic.*;

import Data.CallRepository;


public class Start {

	private JFrame frame;
	private JTextField txtCustomerName;
	private JTextField txtStartTime;
	private JTextField txtEndTime;
	private JTable tblData;
	private JTextField textField;
	private JButton btnStartCall;
	private JButton btnEndCall;
	private JTextArea txtNote;
	
	private DefaultTableModel dataModel;

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
		
		dataModel = Util.CreateTableHeader(
				new String[] {"Id", "Customer Name", "Start Time", "End Time", "Notes"}
				);
				
		UpdateModel(CallRepository.LoadCalls());
		frame = new JFrame();
		frame.setBounds(100, 100, 786, 510);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtCustomerName = new JTextField();
		txtCustomerName.setBounds(10, 95, 146, 22);
		frame.getContentPane().add(txtCustomerName);
		txtCustomerName.setColumns(10);
		
		JLabel lblCustomerName = new JLabel("Customer Name:");
		lblCustomerName.setBounds(10, 66, 104, 28);
		frame.getContentPane().add(lblCustomerName);
		
		txtStartTime = new JTextField();
		txtStartTime.setBackground(Color.WHITE);
		txtStartTime.setEditable(false);
		txtStartTime.setBounds(10, 136, 146, 22);
		frame.getContentPane().add(txtStartTime);
		txtStartTime.setColumns(10);
		
		JLabel lblCallStart = new JLabel("Call Start:");
		lblCallStart.setBounds(10, 117, 80, 22);
		frame.getContentPane().add(lblCallStart);
		
		txtEndTime = new JTextField();
		txtEndTime.setBackground(Color.WHITE);
		txtEndTime.setEditable(false);
		txtEndTime.setBounds(10, 220, 146, 22);
		frame.getContentPane().add(txtEndTime);
		txtEndTime.setColumns(10);
		
		JLabel lblCallEnd = new JLabel("Call End:");
		lblCallEnd.setBounds(10, 203, 62, 22);
		frame.getContentPane().add(lblCallEnd);
		
		JLabel lblNotes = new JLabel("Notes:");
		lblNotes.setBounds(10, 266, 62, 28);
		frame.getContentPane().add(lblNotes);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(191, 66, 554, 324);
		frame.getContentPane().add(scrollPane);
		
		tblData = new JTable(dataModel);
		tblData.setLocation(78, 0);
		tblData.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblData);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			
			
			
			public void actionPerformed(ActionEvent e) {
				
				CallRepository.AddCall(CallerFactory.CreateCaller(txtCustomerName.getText(), txtStartTime.getText(), txtEndTime.getText(), txtNote.getText()));
				ResetForm();
			}
		});
		btnSubmit.setBounds(36, 397, 97, 25);
		frame.getContentPane().add(btnSubmit);
		
		textField = new JTextField();
		textField.setBounds(389, 35, 242, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblSearch = new JLabel("Search:");
		lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSearch.setBounds(323, 37, 62, 16);
		frame.getContentPane().add(lblSearch);
		
		btnStartCall = new JButton("Start Call");
		btnStartCall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Date start = new Date();
				DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
				txtStartTime.setText(dateFormat.format(start));
				btnStartCall.setEnabled(false);
				btnEndCall.setEnabled(true);
				
			}
		});
		btnStartCall.setBounds(10, 169, 104, 23);
		frame.getContentPane().add(btnStartCall);
		
		btnEndCall = new JButton("End Call");
		btnEndCall.setEnabled(false);
		btnEndCall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Date end = new Date();
				DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
				txtEndTime.setText(dateFormat.format(end));
				btnEndCall.setEnabled(false);
			}
		});
		btnEndCall.setBounds(10, 245, 104, 23);
		frame.getContentPane().add(btnEndCall);
		
		txtNote = new JTextArea();
		txtNote.setBounds(10, 291, 146, 99);
		frame.getContentPane().add(txtNote);
		
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
	
	private void ResetForm()
	{
		txtCustomerName.setText("");
		txtStartTime.setText("");
		txtEndTime.setText("");
		txtNote.setText("");
		btnStartCall.setEnabled(true);
		btnEndCall.setEnabled(false);
	}
	
	private void UpdateModel(ArrayList<Caller> callers)
	{
		dataModel.setRowCount(0);
		
		for(Caller c: callers)
		{
			dataModel.addRow(new Object[]{
				c.getID(),
				c.getCustomerName(),
				c.getStartTime().toString(),
				c.getEndTime().toString(),
				c.getNote()
			});
		}
		
	}
}
