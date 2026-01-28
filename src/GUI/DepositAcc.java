package GUI;

import javax.swing.*;
import Data.FileIO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DepositAcc extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField textFieldAcc;
    private JTextField textFieldAmt;

    public DepositAcc() {
        setTitle("Deposit Amount");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 400, 200);
        getContentPane().setLayout(null);

        JLabel lblAccNum = new JLabel("Account Number:");
        lblAccNum.setBounds(10, 30, 120, 20);
        getContentPane().add(lblAccNum);

        textFieldAcc = new JTextField();
        textFieldAcc.setBounds(140, 30, 200, 20);
        getContentPane().add(textFieldAcc);

        JLabel lblAmount = new JLabel("Amount:");
        lblAmount.setBounds(10, 70, 120, 20);
        getContentPane().add(lblAmount);

        textFieldAmt = new JTextField();
        textFieldAmt.setBounds(140, 70, 200, 20);
        getContentPane().add(textFieldAmt);

        JButton btnDeposit = new JButton("Deposit");
        btnDeposit.setBounds(80, 120, 100, 25);
        getContentPane().add(btnDeposit);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(220, 120, 100, 25);
        getContentPane().add(btnCancel);

        btnDeposit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String accNum = textFieldAcc.getText();
                double amt = Double.parseDouble(textFieldAmt.getText());
                try {
                    // If deposit() no longer throws InvalidAmount/AccNotFound, catch general Exception
                    FileIO.bank.deposit(accNum, amt);
                    JOptionPane.showMessageDialog(getComponent(0), "Amount Deposited Successfully");
                    dispose();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(getComponent(0), "Failed to Deposit");
                }
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}