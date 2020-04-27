package bookapp;

import java.awt.EventQueue;

import view.AdminApp;
import view.EmployeesApp;

public class BookApp {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminApp window = new AdminApp();
					window.frmAdminApp.setVisible(true);
					EmployeesApp window2 = new EmployeesApp();
					window2.frmEmployeesApp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
