package macthingBracket;
import java.util.*;

public class matchingBrackets {
      static boolean isParenthesisMatching(String str) {
    	  Stack<Character>s=new Stack<>();
    	  for(int i=0;i<str.length();i++) {
    		  char current=str.charAt(i);
    		   if (current == '(' || current == '[' || current == '{') {
                   // Push the element in the stack
                   s.push(current);
                   continue;
               }
    		  
    		  
    		  if (s.isEmpty())
                  return false;
              char check;
              switch (current) {
              case ')':
                  check = s.pop();
                  if (check == '{' || check == '[')
                      return false;
                  break;
   
              case '}':
                  check = s.pop();
                  if (check == '(' || check == '[')
                      return false;
                  break;
   
              case ']':
                  check = s.pop();
                  if (check == '(' || check == '{')
                      return false;
                  break;
              }
    	  }
    	  
          
          return (s.isEmpty());
      
      }
    public static void main(String[] args){
          Scanner sc=new Scanner(System.in);
          System.out.println("enter the string to check");
    	  String bracketStatment=sc.next();
    	   if(isParenthesisMatching(bracketStatment)) {
    		   System.out.println("string is matching");
    	   }
    	   else {
    		   System.out.println("string is not matching");

    	   }
      }
  
}

 