package dangod.wechat.service.impl;

import dangod.wechat.service.CalculateService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CalculateServiceImpl implements CalculateService{
    @Override
    public String cal(String str) {
        try {
            List<Object> list = trans(str);

            Stack<Double> result = new Stack<Double>();
            double res = f(list, result);
            return ""+res;
        } catch (Exception e) {
            return "表达式不合法!";
        }
    }

    private static double f(List<Object> list, Stack<Double> result) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String m = it.next().toString();
            if (m.equals("+") || m.equals("-") || m.equals("*") || m.equals("/")) {
                double b = result.pop();

                double a = result.pop();
                double v = g(a, b, m);
                result.push(v);
            } else {
                result.push(Double.valueOf(m));
            }
        }
        return (result.pop());
    }

    private static double g(double a, double b, String m) {
        double v = 0;
        switch (m) {
            case "+":
                v = a + b;
                break;
            case "-":
                v = a - b;
                break;
            case "*":
                v = a * b;
                break;
            case "/":
                v = a / b;
                break;
        }
        return v;

    }

    private static List<Object> trans(String s) {
        Stack<Character> op = new Stack<Character>();
        ArrayList<Object> list = new ArrayList<Object>();
        Pattern P = Pattern.compile("[0-9]+(\\.[0-9]+)?");   //正则表达式来处理带小数点的数字
        int i = 0;

        while (i < s.length()) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                String s1 = s.substring(i);
                Matcher m = P.matcher(s1);
                if (m.find()) {    //取匹配到的第一个数字
                    s1 = m.group();

                    list.add(s1);
                }
                i = i + s1.length();
                continue;
            } else if (c == '(') {
                op.push(c);
            } else if (c == ')') {
                char p = op.pop();
                while (p != '(') {
                    list.add(p);
                    p = op.pop();
                }
            } else if (c == '+' || c == '-') {
                while (!op.isEmpty() && (op.peek() == '+' || op.peek() == '-' ||
                        op.peek() == '*' || op.peek() == '/')) {

                    list.add(op.pop());
                }
                op.push(c);
            } else if (c == '*' || c == '/') {
                while (!op.isEmpty() && (op.peek() == '*' || op.peek() == '/')) {
                    list.add(op.pop());
                }
                op.push(c);
            }
            i++;
        }

        while (!op.isEmpty()) {
            list.add(op.pop());
        }
        return list;
    }

}
