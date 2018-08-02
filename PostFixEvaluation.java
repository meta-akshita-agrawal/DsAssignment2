
public class PostFixEvaluation {

	String inputExpression;
	
	PostFixEvaluation(String inputExpression){
		this.inputExpression = inputExpression;
	}
	
	public Character[] parseExpression() {
		
		String[] str = this.inputExpression.split(" ");
		Character[] tokens = new Character[str.length];
		
		for(int i=0;i<tokens.length;i++) {
			tokens[i] = str[i].charAt(0);
		}
		
		return tokens;		
	}
	
	public int evaluate() {
		
		StackList stack = new StackList();
		
		Character[] tokens = parseExpression();
		
		for(int i=0;i<tokens.length;i++) {
			
			if(Character.isDigit(tokens[i])) {
				stack.push(tokens[i] - '0');
			}
			
			else {
				
				 int val1 = stack.pop();
	             int val2 = stack.pop();
				
				switch(tokens[i])
                {
                    case '+':
                    stack.push(val2+val1);
                    break;
                     
                    case '-':
                    stack.push(val2- val1);
                    break;
                     
                    case '/':
                    stack.push(val2/val1);
                    break;
                     
                    case '*':
                    stack.push(val2*val1);
                    break;
              }
				
			}
		}
		return stack.pop();
	}
	
}
