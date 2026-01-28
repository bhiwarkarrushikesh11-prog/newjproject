package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class AddSavingsAccount extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	public AddSavingsAccount() {
		setTitle("Add Savings Account");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAddSavingsAccount = new JLabel("Add Savings Account");
		lblAddSavingsAccount.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAddSavingsAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddSavingsAccount.setBounds(10, 11, 414, 34);
		contentPane.add(lblAddSavingsAccount);

		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblName.setBounds(10, 72, 124, 14);
		contentPane.add(lblName);

		textField = new JTextField();
		textField.setBounds(144, 69, 254, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblBalance = new JLabel("Balance:");
		lblBalance.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblBalance.setBounds(10, 118, 124, 14);
		contentPane.add(lblBalance);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(144, 115, 254, 20);
		contentPane.add(textField_1);

		JLabel lblMaxWithdraw = new JLabel("Maximum Withdraw:");
		lblMaxWithdraw.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMaxWithdraw.setBounds(10, 163, 124, 14);
		contentPane.add(lblMaxWithdraw);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(144, 160, 254, 20);
		contentPane.add(textField_2);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				String balanceText = textField_1.getText();
				String maxWithdrawText = textField_2.getText();

				if(name.isEmpty() || balanceText.isEmpty() || maxWithdrawText.isEmpty()) {
					JOptionPane.showMessageDialog(getComponent(0), "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				double bal = 0, maxWithdraw = 0;
				try {
					bal = Double.parseDouble(balanceText);
					maxWithdraw = Double.parseDouble(maxWithdrawText);
				} catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(getComponent(0), "Balance and Maximum Withdraw must be numbers", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				if(bal < 5000) {
					JOptionPane.showMessageDialog(getComponent(0), "Minimum Balance 5000", "Warning", JOptionPane.WARNING_MESSAGE);
					return;
				}

				int ch = JOptionPane.showConfirmDialog(getComponent(0), "Confirm?");
				if(ch == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(getComponent(0),
							"Account added successfully!\nName: " + name + "\nBalance: " + bal + "\nMax Withdraw: " + maxWithdraw);
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
				} else {
					JOptionPane.showMessageDialog(getComponent(0), "Operation cancelled");
				}
			}
		});
		btnAdd.setBounds(86, 209, 89, 23);
		contentPane.add(btnAdd);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
			}
		});
		btnReset.setBounds(309, 209, 89, 23);
		contentPane.add(btnReset);
	}
}