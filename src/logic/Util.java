package logic;

import javax.swing.table.DefaultTableModel;

public class Util {
	
	public static DefaultTableModel CreateTableHeader(String[] columnNames){
		DefaultTableModel model = new DefaultTableModel ();
		for (String str:columnNames){
			model.addColumn((Object) str);
		}
		return model;
	}
}
