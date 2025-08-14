package com.mateusnavarro77.algoritmos.validador_de_expressoes;

public class ExpressionValidator {

    public static boolean validate(String expression) {
        StaticStack<String> stack = new StaticStack<String>(expression.length());
        char openParenthesis = '(';
        char closedParenthesis = ')';
        boolean containsParenthesis = false;
        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);
            if(currentChar==openParenthesis){
                stack.push("(");
                containsParenthesis = true;
            }else if(expression.charAt(i)==closedParenthesis){
                if(stack.isEmpty()) return false;
                stack.pop();
                containsParenthesis = true;
            }
        }
        return containsParenthesis && stack.isEmpty();
    }
}