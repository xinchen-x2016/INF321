package Calculator;
import java.util.Stack;

public class Calculator {
	public Stack<Double> numbers= new Stack<Double>();
	public Stack<Instruction> instructions = new Stack<Instruction>();
	public Stack<Double> results = new Stack<Double>();
	public boolean isNumber, hasDot;
	private int mantisse, np = 0;
	
	public String toString(){
		String st = "";
		if(numbers.isEmpty()) st += "[ ";
		else{
			st = "[" + numbers.pop().toString();
			while (! numbers.empty()) st = st + ", " + numbers.pop().toString();
		}
		if (instructions.isEmpty()){
			st += "]\n[ ]";
			return st;
		}
		else{
			st += "]\n[" + instructions.pop().toString();
			while (! instructions.isEmpty()) st = st + ", " + instructions.pop().toString();
			st += "]";
			return st;
		}
	}
	
	private void read(int s){
		if(numbers.isEmpty()){
			numbers.push((double)s);
			isNumber = true;
		}
		else{
			if(isNumber){
				double d = numbers.pop();
				if(hasDot){
					d += s * Math.pow(10, -mantisse-1);
					mantisse ++;
				}
				else d = d*10 + s;
				numbers.push(d);
			}
			else{
				numbers.push((double)s);
				isNumber = true;
			}
		}
	}
	
	private void read() throws ParsingException{
		if(hasDot) throw new ParsingException(numbers.peek());
		if(! isNumber) numbers.push((double)0);
		hasDot = true;
		mantisse = 0;
		isNumber = true;
	}
	
	private void read(Instruction a) throws ParsingException{
		if (a == Instruction.CLEAR) initial();
		else if (a == Instruction.CLOSE){
			while (! instructions.isEmpty() && instructions.peek()!= Instruction.OPEN) excute();
			instructions.pop();
		}
		else if (a == Instruction.UMINUS || a == Instruction.OPEN) instructions.push(a);
		else{
			while((! instructions.isEmpty()) && !precedence(instructions.peek(),a) && instructions.peek() != Instruction.OPEN) excute();
			instructions.push(a);
		}
		isNumber = false;
		mantisse = 0;
		hasDot = false;
	}
	
	public void read(char s) throws ParsingException{
		if('0'<=s && s<='9') read(Character.getNumericValue(s));
		else if (s == '.') read();
		else if ((! isNumber) && s == '-') read(Instruction.UMINUS);
		else{
			if (s == '+') read(Instruction.PLUS);
			else if (s == '-') read(Instruction.MINUS);
			else if (s == '*') read(Instruction.MULT);
			else if (s == '/') read(Instruction.DIV);
			else if (s == '='){
				if(np > 0) throw new ParsingException(false);
				while (! instructions.isEmpty()) excute();
				results.add(numbers.pop());
//				assert instructions.isEmpty();
//				assert numbers.size() == 1;
			}
			else if (s == 'C') read(Instruction.CLEAR);
			else if (s == '('){
				read(Instruction.OPEN);
				np ++;
			}
			else if (s == ')'){
				if(np == 0) throw new ParsingException(true);
				read(Instruction.CLOSE);
				np --;
			}
			else if (s == '$') read(Instruction.VAR);
			else{
				if(s != ' ') throw new ParsingException(s);
			}
		}
	}
	
	public void initial(){
		while(! instructions.isEmpty()) instructions.pop();
		while(! numbers.isEmpty()) numbers.pop();
		while(! results.isEmpty()) results.pop();
	}
	
	private boolean precedence(Instruction x, Instruction y){
		if((x==Instruction.MINUS || x==Instruction.PLUS) && (y==Instruction.MULT || y==Instruction.DIV))
			return true;
		if (y == Instruction.VAR) return true;
		return false;
	}
	
	public void excute() throws ParsingException{
		double a, b;
		if(! instructions.isEmpty()){
			Instruction m = instructions.pop();
			if (numbers.isEmpty()) a = 0.0;
			else a = numbers.pop();
			if (m == Instruction.UMINUS) numbers.push(-a);
			else if (m == Instruction.VAR){
				if(a != (int)a || a < 1 || a > results.size()) throw new ParsingException(a);
				numbers.push(results.get((int)a - 1));
			}
			else{
				if (numbers.isEmpty()) throw new ParsingException(m);
				else b = numbers.pop();
				if (m == Instruction.PLUS) numbers.push(a+b);
				if (m == Instruction.MULT) numbers.push(a*b);
				if (m == Instruction.MINUS) numbers.push(b-a);
				if (m == Instruction.DIV) numbers.push(b/a);
				
			}
		}
//		System.out.println(instructions.peek());
	}
	
	private void parse(String S) throws ParsingException{
		char[] c = S.toCharArray();
		for(int i=0; i<S.length(); i++) read(c[i]);
		isNumber = false;
		mantisse = 0;
		hasDot = false;
	}
	
	public double getResult(){
		if(results.isEmpty()) return 0.0;
		else return results.pop();
	}
	
	public void interpret(String[] m) throws ParsingException{
		for(String S : m) parse(S);
		System.out.println(getResult());
	}
	
	public static void main(String[] args) throws ParsingException{
//		assert false;
		Calculator c = new Calculator();
		c.parse("(2 + 12.34 ) * 5 =");
		c.read('C');
		c.parse("-(2 - ((-.3) * 4)/ -2)=");
		c.read('C');
//		c.parse("1.2.3 + 4 = ");
//		c.parse("1x +4 =");
//		c.parse("2*(3+4)) = ");
//		c.parse("(2*(3+4)=");
//		c.parse("1+*2=");
		c.parse("1+2*3= $1+$1+1= $2-$1=");
		System.out.println(c.getResult());
	}
}
