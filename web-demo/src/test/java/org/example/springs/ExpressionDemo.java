package org.example.springs;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @author: liuxuan
 * @date: 2022-06-25 10:20
 **/
public class ExpressionDemo {
    public static void main(String[] args) {
        //将一整个语句直接定义了字符串 ,其中对字符串的开始索引与结束索引使用替代变量
        //变量前需要加#
        String str = "#var + 2";
        //1定义一个专属的表达式解析工具
        ExpressionParser parser = new SpelExpressionParser() ;
        //2定义一个表达式处理类
        Expression exp = parser.parseExpression(str);
        //3进行最终的表达式计算，这个上下文用来传参
        EvaluationContext context = new StandardEvaluationContext() ;
        context.setVariable("var", 5);
        //4通过表达式进行结果计算
        System.out.println(exp.getValue(context, Integer.class));
    }
}
