package sist.com.homework;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class BasicFrame extends JFrame implements ActionListener{
	
	private JPanel displayPanel;
	private JPanel buttonPanel;
	private JPanel debugPanel;
	private JTextField display;
	private JButton[] buttons; // 0 ~ 9
	private JButton btnPlus;
	private JButton btnMinus;
	private JButton btnProduct;
	private JButton btnDivide;
	private JButton btnEqual;
	private JButton btnCE;

	private JLabel prev;
	private JLabel operator;
	private JLabel flag;
	
	public BasicFrame() {
		this.setSize(300,400);
		this.setTitle("����");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLayout(new BorderLayout());
		
		
		// 3�� panel ��ü ����, ���� layout
		displayPanel = new JPanel();
		buttonPanel = new JPanel();
		debugPanel = new JPanel();
		
		displayPanel.setLayout(new FlowLayout());
		buttonPanel.setLayout(new GridLayout(0,4,5,5));
		debugPanel.setLayout(new FlowLayout());
		
		
		// displayPanel�� component�� ���� ���̱�
		display = new JTextField(11);
		display.setText("0");
		display.setHorizontalAlignment(JTextField.RIGHT);
		
		Font font = new Font("Serif", Font.BOLD, 30);
		display.setFont(font);
		displayPanel.add(display);

		
		// ���� buttonpanel�� component ����, ���̱�
		Font fontBtn=new Font("Serif",Font.BOLD,20);
		
		buttons = new JButton[10]; //0~9 ��ư
		for(int i=0; i<buttons.length; i++)	{
		buttons[i] = new JButton(Integer.toString(i));
		buttons[i].setFont(fontBtn);

		buttons[i].addActionListener(this);
		}
		
		// ������ buttonpanel�� component ����, ���̱�
		btnPlus = new JButton("+");
		btnMinus = new JButton("-");
		btnProduct = new JButton("*");
		btnDivide = new JButton("/");
		btnEqual = new JButton("=");
		btnCE = new JButton("CE");
		
		// addActionListener
		btnPlus.addActionListener(this);
		btnMinus.addActionListener(this);
		btnProduct.addActionListener(this);
		btnDivide.addActionListener(this);
		btnEqual.addActionListener(this);
		btnCE.addActionListener(this);
		
		buttonPanel.add(buttons[7]);
		buttonPanel.add(buttons[8]);
		buttonPanel.add(buttons[9]);
		buttonPanel.add(btnProduct);
		
		buttonPanel.add(buttons[4]);
		buttonPanel.add(buttons[5]);
		buttonPanel.add(buttons[6]);
		buttonPanel.add(btnMinus);
		
		buttonPanel.add(buttons[1]);
		buttonPanel.add(buttons[2]);
		buttonPanel.add(buttons[3]);
		buttonPanel.add(btnPlus);
		
		buttonPanel.add(btnDivide);
		buttonPanel.add(buttons[0]);
		buttonPanel.add(btnCE);
		buttonPanel.add(btnEqual);
		
		//JLabel ����, ���̱�
		prev = new JLabel("");
		operator = new JLabel("");
		flag = new JLabel("");
		
		debugPanel.add(new JLabel("PREV:"));
		debugPanel.add(prev);
		
		debugPanel.add(new JLabel("OPERATOR"));
		debugPanel.add(operator);
		
		debugPanel.add(new JLabel("FLAG"));
		debugPanel.add(flag);
		
		// �����ӿ� panel ���̱�
		this.add(displayPanel,BorderLayout.NORTH);		
		this.add(buttonPanel,BorderLayout.CENTER);
		this.add(debugPanel,BorderLayout.SOUTH);
		
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		for(int i=0; i<buttons.length; i++)	{

		if(e.getSource() == buttons[i])	{

		if(display.getText().equals("0")) {
		display.setText(""+i);
		}else {

		if(operator.getText().equals("")) {
		display.setText(  display.getText() + i);
		}else {

		if(flag.getText().equals("")) {
		display.setText(""+i);
		flag.setText("#");
		}else {

		display.setText(  display.getText() + i);

		}

		}

		}

		}

		}
		 
		if(e.getSource() == btnEqual) { //�����ư

		double op1, op2, result;
		op1 = Double.parseDouble(prev.getText());  //����->����(double)
		op2 = Double.parseDouble(display.getText());

		if(operator.getText().equals("+")) {
		result = op1 + op2;
		display.setText("" + result);
		}

		if(operator.getText().equals("-")) {
		result = op1 - op2;
		display.setText("" + result);
		}

		if(operator.getText().equals("*")) {
		result = op1 * op2;
		display.setText("" + result);
		}

		if(operator.getText().equals("/")) {
		result = op1 / op2;
		display.setText("" + result);
		}

		}

		if(e.getSource() == btnPlus) {
		prev.setText( display.getText() );
		operator.setText("+");
		flag.setText("");
		}

		if(e.getSource() == btnMinus) {
		prev.setText( display.getText() );
		operator.setText("-");
		flag.setText("");
		}

		if(e.getSource() == btnProduct)	{
		prev.setText( display.getText() );
		operator.setText("*");
		flag.setText("");
		}

		if(e.getSource() == btnDivide) {
		prev.setText( display.getText() );
		operator.setText("/");
		flag.setText("");
		}

		if(e.getSource() == btnCE) {
		display.setText("0");
		prev.setText("");
		operator.setText("");
		flag.setText("");
		}

		}
		
		
	}


	public class Calculator{

	public static void main(String[] args) {
		
		BasicFrame frame=new BasicFrame();
	}
}




