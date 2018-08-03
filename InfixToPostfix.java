
public class InfixToPostfix {

	public int precedence(String operator) {
		switch(operator) {
		
		case "!":
			return 7;
		case "*":
		case "/":
			return 6;
		case "+":
		case "-":
			return 5;
		case "<":
		case "<=":
		case ">":
		case ">=":
			return 4;
		case "!=":
		case "==":
			return 3;
		case "&&":
			return 2;
		case "||":
			return 1;
		default:
			return 0;
		}
	}
	
	public String[] parser(String expression) {
		
		String[] tokens = expression.split(" ");
		return tokens;
	}
	
	public String changingToPostFix(String expression) {
	
		StackList stack = new StackList();
		
		String resultPostfix = "";
		String[] tokens = parser(expression);
		
		for(int i=0;i<tokens.length;i++) {
			
			 // If the scanned character is an operand, add it to output.
            if (Character.isLetterOrDigit(tokens[i].charAt(0)))
                resultPostfix += tokens[i].charAt(0);
              
            // If the scanned character is an '(', push it to the stack.
            else if (tokens[i] == "(")
                stack.push(tokens[i]);
             
            //  If the scanned character is an ')', pop and output from the stack 
            // until an '(' is encountered.
            else if (tokens[i] == ")")
            {
                while (!stack.isEmpty() && stack.top() != "(")
                    resultPostfix += stack.pop();
                 
                if (!stack.isEmpty() && stack.top() != "(")
                    return "Invalid Expression"; // invalid expression                
                else
                    stack.pop();
            }
            else // an operator is encountered
            {
                while (!stack.isEmpty() && precedence(tokens[i]) <= precedence(stack.top()))
                    resultPostfix += stack.pop();
                stack.push(tokens[i]);
            }
		}
		
		// pop all the operators from the stack
        while (!stack.isEmpty())
            resultPostfix += stack.pop();
      
        return resultPostfix;
	}
	
}
