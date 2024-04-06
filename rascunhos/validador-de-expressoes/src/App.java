public class App {
    public static void main(String[] args) throws Exception {
        String validParenthesis1 = "((1+2)*(3-4))";
        String validParenthesis2 = "((1+2)*(3-4)+2**(3**2*(1+(40-50))))";
        String invalidParenthesis1 = "((1+2)*(3-4)";
        String invalidParenthesis2 = "((1+2)*(3-4)+2**(3**2*(1+(40-50))))))";
        String invalidParenthesis3 = "((1+2)*(3-4)+2**(3**2*(1+(40-50))))(";
        String invalidParenthesis4 = "";
        String invalidParenthesis5 = ")";
        System.out.println(ExpressionValidator.validate(validParenthesis1));
        System.out.println(ExpressionValidator.validate(validParenthesis2));
        System.out.println(ExpressionValidator.validate(invalidParenthesis1));
        System.out.println(ExpressionValidator.validate(invalidParenthesis2));
        System.out.println(ExpressionValidator.validate(invalidParenthesis3));
        System.out.println(ExpressionValidator.validate(invalidParenthesis4));
        System.out.println(ExpressionValidator.validate(invalidParenthesis5));
        
    }
}
