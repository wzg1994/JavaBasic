package algorithm.stack;

/**
 * @author wangzhiguo
 */
public class ArrayStack {

    //栈的大小
    private int maxSize;

    //栈本身
    private int[] stack;

    //栈顶指针
    private int top;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
        top = -1;
    }

    // 判断栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    // 判断栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int num){
        if (isFull()) {
            return;
        }
        stack[top = top + 1] = num;
    }

    //出栈
    public int pop(){
        if (isEmpty()) {
            throw new RuntimeException("栈为空！");
        }
        int i = stack[top];
        top--;
        return i;
    }

    // 查看栈顶元素
    public int peek() {
        if(isEmpty()) {
            throw new RuntimeException("栈为空！");
        }
        return stack[top];
    }

    // 遍历栈
    public void list() {
        if(isEmpty()) {
            System.out.println("栈为空！");
            return;
        }
        for(int i=top; i>=0; i--) {
            System.out.printf("stack[%d]=%d\n", i,stack[i]);
        }
    }






    // 返回运算符优先级
    public int priority(int oper) {
        if(oper == '*' || oper == '/') {
            return 1;
        }else if(oper == '+' || oper == '-') {
            return 0;
        }else {
            // 表示非法字符
            return -1;
        }
    }
    // 判断是否为运算符
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }
    // 计算
    public int cal(int num1,int num2,int oper) {
        int result = 0;
        switch(oper) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num2 - num1;   // 注意出栈的顺序与实际顺序是反着的
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num2 / num1;
                break;
        }

        return result;
    }
}
