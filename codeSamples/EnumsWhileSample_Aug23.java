import java.util.Scanner;

class Main {
	/*
	+ 0 1 -> 1
	- 0 1 -> -1
	*/
	
  public static int addition(int inputA, int inputB){
  	return inputA + inputB;
  }
  
  public static int subtraction(int inputA, int inputB){
  	return inputA - inputB;
  }
  
  public static int division(int inputA, int inputB){
  	return inputA / inputB;
  }
  
  public static int multiplication(int inputA, int inputB){
  	return inputA * inputB;
  }
  
  enum Operations {
  	ADDITION,
  	SUBTRACTION,
  	MULTIPLICATION,
  	DIVISION
  }
  public static void main(String[] args) {
  	 String operator = readOperator(); 
  	 promptUser("Enter first number: ");
  	 String firstNumber = readString();
  	 promptUser("Enter second number: ");
  	 String secondNumber = readString();
  	 System.out.println("Entered: " + operator + " " + firstNumber + " " + secondNumber);
  	 
  	 int result = 0;
  	 
  	 int inputA = Integer.parseInt(firstNumber);
  	 int inputB = Integer.parseInt(secondNumber);
  	 Operations operatorToRun = convertStringToOperation(operator);
  	 switch (operatorToRun) {
  	 	case MULTIPLICATION:
  	 		result = multiplication(inputA, inputB);
  	 		break;
   		case SUBTRACTION:
   			result = subtraction(inputA, inputB);
   			break;
   		case DIVISION:
   			result = division(inputA, inputB);
   			break;
   		case ADDITION:
   			result = addition(inputA, inputB);
   			break;
  	 }
  	 System.out.println("Result: " + result);
  }
  
  public static Operations convertStringToOperation(String operator) {
  	if( operator.equals("+")){
  		return Operations.ADDITION;
  	} 
  	
  	if( operator.equals("-")){
  		return Operations.SUBTRACTION;
  	}
  	if( operator.equals("*")){
  		return Operations.MULTIPLICATION;
  	} 
  	
  	if( operator.equals("/")){
  		return Operations.DIVISION;
  	}
  	return null;
  }
  
  public static void promptUser(String prompt){
  	System.out.println(prompt);
  }
  
  public static String readOperator() {
  	 promptUser("Enter a operation: ");
  	 String userInput = readString();
  	 Operations operator = convertStringToOperation(userInput);
  	 while ( operator == null){
  	 	promptUser("You messed up. Try again: ");
  	 	userInput = readString();
  	 	operator = convertStringToOperation(userInput);
  	 }
  	 return userInput;
  }
  
  public static String readString(){
  	 Scanner scanner = new Scanner(System.in);
  	 return scanner.next();
  }
}













