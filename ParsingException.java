package Calculator;
public class ParsingException extends Exception{
	public ParsingException(Instruction i){
		super("operande manquant pour l'operateur " + i);
	}
	
	public ParsingException(boolean b){
		super("parenthese " + (b ? "ouvrante" : "fermante") + " manquante");
	}
	
	public ParsingException(double d){
		super("point inattendu apres le nombre " + d);
	}
	
	public ParsingException(char c){
		super("caractere '" + c + "' inconnu");
	}
	
	public ParsingException(String s){
		super("variable $" + s + " inexistante");
	}
}
