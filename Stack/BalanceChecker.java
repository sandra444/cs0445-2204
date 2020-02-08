import java.util.Scanner;

public class BalanceChecker{

  public static void main(String[] args){
      new BalanceChecker();
  }

  public BalanceChecker(){
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter a string to check its balanace:");
    String input = scan.nextLine();
    if(!checkBalance(input)){
      System.out.println("Unbalanced brackets!");
    } else{
      System.out.println(evaluateInfix(input));
    }
  }

  private Double evaluateInfix(String infix){
    StackInterface<Character> operatorStack =
          new LinkedStack<Character>();
    StackInterface<Double> operandStack =
      new LinkedStack<Double>();

    for(int i=0; i<infix.length(); i++){
      char c = infix.charAt(i);
      if(isOperand(c)){
        operandStack.push(Double.valueOf(c));
      } else if(isOperator(c)){
        if(c == ')'){
          while(!operatorStack.isEmpty()){
            char operator = operatorStack.pop();
            if(operator == '('){
              break;
            }
            Double secondOperand = operandStack.pop();
            Double firstOperand = operandStack.pop();
            Double result = compute(operator, firstOperand, secondOperand);
            operandStack.push(result);
          }
        } else if(c == '(' || c == '^' || operatorStack.isEmpty()){
          operatorStack.push(c);
        } else {
          //TO-O Pop until top of the operator stack is of lower precedence

        }

      }
    }
    //TODO Pop until operator stack is empty
    return null;
  }

  private boolean checkBalance(String input){
    boolean balanced = true;
    StackInterface<Character> stack =
        new LinkedStack<Character>();

    for(int i=0; i<input.length(); i++){
      if(isOpeninngParen(input.charAt(i))){
        stack.push(input.charAt(i));
      }
      if(isClosingParen(input.charAt(i))){
        if(!stack.isEmpty()){
          char c = stack.pop();
          if(!isMatching(c, input.charAt(i))){
            balanced = false;
            break;
          }
        } else{
          balanced = false;
          break;
        }
      }
    }
    if(!stack.isEmpty()){
      balanced = false;
    }
    return balanced;
  }

  private boolean isOpeninngParen(char c){
    return c == '{' || c == '[' || c == '(';
  }

  private boolean isClosingParen(char c){
    return c == '}' || c == ']' || c == ')';
  }

  private boolean isMatching(char open, char close){
    return (open == '{' && close == '}') ||
           (open == '[' && close == ']') ||
           (open == '(' && close == ')');
  }

  private boolean isOperand(char c){
    return c == '0' || c == '1' || c == '2' ||
           c == '3' || c == '4' || c == '5' ||
           c == '6' || c == '7' || c == '8' || c == '9';
  }

  private boolean isOperator(char c){
    return c == '(' || c == ')' || c == '+' ||
           c == '-' || c == '*' || c == '/' || c == '^';
  }

  private Double compute(char operator,
                         Double firstOperand,
                         Double secondOperand){
    Double result = null;
    switch(operator){
      case '+':
        result = firstOperand + secondOperand;
      case '-':
        result = firstOperand - secondOperand;
      case '*':
        result = firstOperand * secondOperand;
      case '/':
        result = firstOperand / secondOperand;
      case '^':
        result = Math.pow(firstOperand, secondOperand);
      default:
        System.out.println("Unknown operator");
    }
    return result;
  }
}
