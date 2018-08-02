
public class PostfixEvaluationTest {

	public static void main(String[] args) {
		
		String input = "2 3 1 * + 9 -";
		
		PostFixEvaluation obj = new PostFixEvaluation(input);
		
 		
		int result = obj.evaluate();
		System.out.println(result);
	}
}
