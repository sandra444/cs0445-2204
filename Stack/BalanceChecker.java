import java.util.Scanner;

public class BalanceChecker{

  public static void main(String[] args){
      new BalanceChecker();
  }

  public BalanceChecker(){
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter a string to check its balanace:");
    String input = scan.nextLine();
    System.out.println(checkBalance(input));
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

}
