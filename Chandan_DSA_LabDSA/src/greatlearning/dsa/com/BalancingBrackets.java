package greatlearning.dsa.com;
import java.util.ArrayDeque;
import java.util.Deque;

public class BalancingBrackets {
	static boolean chkBalanceBrackets(String expr) {
		Deque<Character> stack = new ArrayDeque<Character>();
		for (int i = 0; i < expr.length(); i++) {
			char x = expr.charAt(i);
			if (x == '(' || x == '[' || x == '{') {
				stack.push(x);
				continue;
			}
			if (stack.isEmpty())
				return false;
			char check;
			switch (x) {
			case ')':
				check = stack.pop();
				if (check == '{' || check == '[')
					return false;
				break;

			case '}':
				check = stack.pop();
				if (check == '(' || check == '[')
					return false;
				break;

			case ']':
				check = stack.pop();
				if (check == '(' || check == '{')
					return false;
				break;
			}
		}


		return (stack.isEmpty());

	}
	public static void main(String[] args) {
		
		//input is hard-coded here as per question
		
		final String expr="( [ [ { } ] ] )";
		
		/* if the user wants to dynamically enter the
		 * brackets then it can be used
		 * String expr = null;  //string value is initialized here as null
		 * try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the brackets::");
			expr = sc.next();		
			System.out.println("Print Brackets "+expr);
		}
		catch(Exception e) {
			System.out.println("Please check !");
		} */
		
		
		/*check balanced bracket is called for to check whether
		 * brackets are balanced or unbalanced
		*/
		if (chkBalanceBrackets(expr))
            System.out.println("The entered String has Balanced Brackets.");
        else
            System.out.println("The entered Strings do not contain Balanced Brackets.");
	}
}