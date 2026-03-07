package string;

import java.util.HashMap;
import java.util.Map;

public class ParenthesisChecker {

    private static Map<String, String> PARANTHESIS_MAP = new HashMap<>(10);


    public static void main(String[] args) {
//        PARANTHESIS_MAP.put("[", "]");
//        PARANTHESIS_MAP.put("{", "}");
//        PARANTHESIS_MAP.put("(", ")");
        // Map of closing → opening brackets
        PARANTHESIS_MAP.put(")", "(");
        PARANTHESIS_MAP.put("}", "{");
        PARANTHESIS_MAP.put("]", "[");

        // Test cases
        String[] inputs = {
                // ✅ Positive Cases — perfectly balanced
                "()",
                "[]",
                "{}",
                "[{()}]",
                "[()()]{}",
                "{[()()]()}",
                "(((())))",
                "[[[[]]]]",
                "{{{{}}}}",
                "{[({[]})]}",
                "()[]{}",
                "({[]})",
                "([]{})",
                "([{}([])])",
                "{([])()[]}",

                // 🔍 Edge-case positive
                // empty string → valid
                "()",  // simplest valid

                // ❌ Negative Cases — clearly incorrect
                "(",
                ")",
                "[",
                "]",
                "{",
                "}",
                "([)]",         // wrong order
                "(]",           // mismatch
                "([)",          // partial mismatch
                "([]",          // missing closing
                "([{}]))",      // extra closing
                "([{]})",       // incorrect closing in between
                "((((()))",     // one missing )
                "([{})",        // wrong bracket inside
                "}{",           // starts with closing
                "][]",          // starts with ]
                "())",          // extra )
                "((())",        // missing )

                // 🔥 Complex negative
                "{[()]}]",       // extra ]
                "[{()}]]]",      // multiple wrong closings
                "[[[[]]]",       // missing ]
                "{[(])}",        // classic mismatch example

                // ⚠️ Strings with non-bracket chars (common in real-world)
                "a(b)c",         // Actually valid if ignoring chars
                "[a+(b*c)-{d/e}]", // Valid if ignoring chars
                "(a[b{c}])",     // valid
                "(a[b{c])}",     // invalid: mismatched
        };

        for (String input : inputs) {
            boolean result = checkValidParenthesis(
                    input.charAt(0) + "",
                    input.substring(1)
            );
            System.out.println("Input: " + input + " -> Result: " + result);
        }
    }

    public static boolean checkValidParenthesis(String processedParenthesis, String inputString) {

//        System.out.println("---- " + processedParenthesis + ":: inputString == " + inputString);

//        s =  "([{]})"
        if (inputString.isEmpty() && processedParenthesis.isEmpty()) {
            return Boolean.TRUE;
        }

        if (inputString.isEmpty()) {
            return Boolean.FALSE;
        }

        var bracket = inputString.charAt(0) + "";


        if (!processedParenthesis.isEmpty()
                && (processedParenthesis.charAt(processedParenthesis.length() - 1) + "").equals(PARANTHESIS_MAP.get(bracket))) {
            processedParenthesis = processedParenthesis.substring(0, processedParenthesis.length()-1);
        }else {
            processedParenthesis = processedParenthesis + bracket;
        }


        return checkValidParenthesis(processedParenthesis, inputString.substring(1));
    }
}
