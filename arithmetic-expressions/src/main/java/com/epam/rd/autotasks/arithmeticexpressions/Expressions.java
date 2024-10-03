package com.epam.rd.autotasks.arithmeticexpressions;

import java.util.StringJoiner;

public class Expressions {

    public static Variable var(String name, int value) {
        return new Variable(name, value);
    }

    public static Expression val(int value) {
        Expression expression = new Expression() {
            @Override
            public int evaluate() {
                return value;
            }

            @Override
            public String toExpressionString() {
                if (value < 0) {
                    return "(" + value + ")";
                } else {
                    return String.valueOf(value);
                }
            }
        };
        return expression;
    }

    public static Expression sum(Expression... members) {
        Expression expression = new Expression() {
            @Override
            public int evaluate() {
                int sum = 0;
                for (Expression member : members) {
                    sum += member.evaluate();
                }
                return sum;
            }

            @Override
            public String toExpressionString() {
                String output = "(";
                for (int i = 0; i < members.length; i++) {
                    output += members[i].toExpressionString();
                    if (i < members.length - 1) {
                        output += " + ";
                    }
                }
                output += ")";
                return output;
            }
        };
        return expression;
    }

    public static Expression product(Expression... members) {
        Expression expression = new Expression() {
            @Override
            public int evaluate() {
                int product = members[0].evaluate();
                for (int i = 1; i < members.length; i++){
                    product *= members[i].evaluate();
                }

                return product;
            }

            @Override
            public String toExpressionString() {
                String output = "(";
                for (int i = 0; i < members.length; i++) {
                    output += members[i].toExpressionString();
                    if (i < members.length - 1) {
                        output += " * ";
                    }
                }
                output += ")";
                return output;
            }
        };
        return expression;
    }

    public static Expression difference(Expression minuend, Expression subtrahend) {
        Expression expression = new Expression() {
            @Override
            public int evaluate() {
                return minuend.evaluate() - subtrahend.evaluate();
            }

            @Override
            public String toExpressionString() {
                return "(" + minuend.toExpressionString() + " - " + subtrahend.toExpressionString() + ")";
            }
        };
        return expression;
    }

    public static Expression fraction(Expression dividend, Expression divisor) {
        Expression expression = new Expression() {
            @Override
            public int evaluate() {
                return dividend.evaluate() / divisor.evaluate();
            }

            @Override
            public String toExpressionString() {
                return "(" + dividend.toExpressionString() + " / " + divisor.toExpressionString() + ")";
            }
        };
        return expression;
    }

}
