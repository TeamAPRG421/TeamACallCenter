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


public class Start {

	private JFrame frame;
	private JTextField txtCustomerName;
	private JTextField txtStartTime;
	private JTextField txtEndTime;
	private JTextField txtNote;
	private JTable table;

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
		frame = new JFrame();
		frame.setBounds(100, 100, 675, 423);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtCustomerName = new JTextField();
		txtCustomerName.setBounds(15, 58, 146, 22);
		frame.getContentPane().add(txtCustomerName);
		txtCustomerName.setColumns(10);
		
		JLabel lblCustomerName = new JLabel("Customer Name:");
		lblCustomerName.setBounds(36, 26, 104, 28);
		frame.getContentPane().add(lblCustomerName);
		
		txtStartTime = new JTextField();
		txtStartTime.setBounds(15, 115, 146, 22);
		frame.getContentPane().add(txtStartTime);
		txtStartTime.setColumns(10);
		
		JLabel lblCallStart = new JLabel("Call Start:");
		lblCallStart.setBounds(48, 86, 80, 22);
		frame.getContentPane().add(lblCallStart);
		
		txtEndTime = new JTextField();
		txtEndTime.setBounds(15, 166, 146, 22);
		frame.getContentPane().add(txtEndTime);
		txtEndTime.setColumns(10);
		
		JLabel lblCallEnd = new JLabel("Call End:");
		lblCallEnd.setBounds(57, 143, 62, 22);
		frame.getContentPane().add(lblCallEnd);
		
		txtNote = new JTextField();
		txtNote.setBounds(15, 226, 146, 70);
		frame.getContentPane().add(txtNote);
		txtNote.setColumns(10);
		
		JLabel lblNotes = new JLabel("Notes:");
		lblNotes.setBounds(57, 195, 62, 28);
		frame.getContentPane().add(lblNotes);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(191, 42, 452, 295);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(36, 309, 97, 25);
		frame.getContentPane().add(btnSubmit);
		
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
	}
}
