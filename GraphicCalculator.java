package Calculator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GraphicCalculator extends JFrame implements ActionListener{
	Calculator calculator;
	JLabel L;
	
	public GraphicCalculator(){
		super("Calculator");
		calculator = new Calculator();
		L = new JLabel("0.0");
		L.setFont(new Font("Dialog", 0, 20));
		int a=360, b =360;
		setSize(a, b);
		getContentPane().add(L);
		setLayout(null);
		
		JButton[] B = new JButton[20];
		for (int i = 0; i< 10; i++) B[i] = new JButton(String.valueOf(i));
		B[10] = new JButton(".");
		B[11] = new JButton("C");
		B[12] = new JButton("+");
		B[13] = new JButton("-");
		B[14] = new JButton("*");
		B[15] = new JButton("/");
		B[16] = new JButton("(");
		B[17] = new JButton(")");
		B[18] = new JButton("$");
		B[19] = new JButton("=");

		for(int i=0; i<20; i++){
			B[i].setFont(new Font("Dialog", 1, 25));
			@SuppressWarnings("deprecation")
			char c = B[i].getLabel().charAt(0);
			B[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					update(c);
				}
			});
		}

		L.setBounds(0, 0, 2*a/3, b/9);
		JPanel P[] = new JPanel[3];
		for(int i=0; i<3; i++){
			P[i] = new JPanel();
			getContentPane().add(P[i]);
			P[i].setVisible(true);
		}
		P[0].setLayout(new GridLayout(4, 3));
		P[0].setBounds(0, b/9, 2*a/3, 5*b/9);
		for(int i=1; i<10; i++) P[0].add(B[i]);
		P[0].add(B[0]);
		P[0].add(B[10]);
		P[0].add(B[11]);
		
		P[1].setLayout(new GridLayout(4, 1));
		P[1].setBounds(13*a/18, b/9, 2*a/9, 5*b/9);
		for(int i=12; i<16; i++){
			P[1].add(B[i]);
			B[i].setBackground(Color.orange);
		}
		
		P[2].setLayout(new GridLayout(1, 3));
		P[2].setBounds(0, 13*b/18, 2*a/3, 25*b/180);
		for(int i=16; i<19; i++){
			P[2].add(B[i]);
			B[i].setBackground(Color.lightGray);
		}
		
		getContentPane().add(B[19]);
		B[19].setBounds(13*a/18, 13*b/18, 2*a/9, 25*b/180);
		B[19].setVisible(true);
		B[19].setBackground(Color.GREEN);
	}
	
	public void update(char c){
		try {
			calculator.read(c);
			if('0'<=c && c<='9'){
				if (! calculator.hasDot) L.setText(String.valueOf(calculator.numbers.peek().intValue()));
				else L.setText(Double.toString(calculator.numbers.peek()));
			}
			else if (c == '.') L.setText(L.getText() + ".");
			else if ((! calculator.isNumber) && c == '-') L.setText("-");
			else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')' || c == '$') L.setText(String.valueOf(c));
			else if (c == '=') L.setText(Double.toString(calculator.getResult()));
			else if (c == 'C') L.setText("0.0");
		} catch (ParsingException e) {
			// TODO Auto-generated catch block
			L.setText("Error");
		}
	}
	
	public static void main(String[] args) {
		GraphicCalculator gui = new GraphicCalculator();
		gui.setVisible(true);
		KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
		manager.addKeyEventDispatcher(new KeyEventDispatcher() { 
		@Override
		public boolean dispatchKeyEvent(KeyEvent e) {
			try{
				if (e.getID() == KeyEvent.KEY_TYPED) gui.update(e.getKeyChar());
			}catch(Exception e2){
				gui.L.setText("Error");
			}
			return false;
		}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
