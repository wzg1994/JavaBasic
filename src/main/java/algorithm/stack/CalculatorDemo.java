package algorithm.stack;



/**
 * @author wangzhiguo
 */
public class CalculatorDemo {

    static int f(int n) {
        if (n == 1) return 1;
        return f(n-1) + 1;
    }

    public static void main(String[] args) {

        int f = f(3);

        // 表达式字符串，需要替换成你用的
        String exp = "700-400+20*60-40/2*2";
        // 数栈和符号栈
        ArrayStack numStack = new ArrayStack(20);
        ArrayStack operStack = new ArrayStack(20);

        int index = 0;
        // 运算数和运算符
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        // 中间结果
        int result = 0;
        char ch = ' ';
        // 多位数字字符串
        String num="";

        // 遍历表达式
        while(index < exp.length()) {
            // 截取字符
            ch = exp.substring(index, index+1).charAt(0);
            // 判断该字符是数字还是运算符
            if(operStack.isOper(ch)) {
                // 判断符号栈是否为空
                if(!operStack.isEmpty()) {
                    // 如果当前运算符的优先级 <= 栈顶运算符的优先级
                    if(operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        // 取出数栈最上面的两个数
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        // 取出符号栈的栈顶运算符
                        oper = operStack.pop();
                        // 进行运算
                        result = numStack.cal(num1, num2, oper);
                        // 运算结果入数栈
                        numStack.push(result);
                        // 当前运算符入符号栈
                        operStack.push(ch);

                    }else {
                        // 如果当前运算符的优先级 > 栈顶运算符，直接入栈
                        operStack.push(ch);
                    }
                }else {
                    // 如果当前符号栈为空，直接入栈
                    operStack.push(ch);
                }
            }else {
                // 如果是数字，不能直接入栈，因为它可能不止一位
                // 拼接字符
                num += ch;

                // 如果是最后一位数字，就没必要判断了，直接入栈好了
                if(index == exp.length()-1) {
                    numStack.push(Integer.parseInt(num));
                }else {
                    // 判断当前位置的下一位是不是数字，如果是运算符，就可以入栈了；否则继续循环
                    if( operStack.isOper(exp.substring(index+1,index+2).charAt(0) ) ){
                        numStack.push(Integer.parseInt(num));
                        // 然后把字符串清空
                        num = "";
                    }
                }

            }

            index++;
        }   // 表达式遍历结束

        // 顺序从数栈和符号栈取出 运算数和运算符进行运算，最终符号栈为空，数栈中只剩下最终结果
        while(true) {
            if(operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            result = numStack.cal(num1, num2, oper);
            numStack.push(result);
        }

        // 输出最终结果
        System.out.printf("%s = %d\n", exp, numStack.pop());


//        String exp = "700-400+20*60-40/2*2";
//
//        ArrayStack numStack = new ArrayStack(10);
//        ArrayStack opStack = new ArrayStack(10);
//
//


    }
}
