package com.beizi.fusion.e;

import java.util.Stack;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class c {
    private static boolean a(char c6) {
        return c6 == '+' || c6 == '-' || c6 == '*' || c6 == '/' || c6 == '%';
    }

    public static int a(String str) {
        char charAt;
        Stack stack = new Stack();
        Stack stack2 = new Stack();
        int length = str.length();
        int i6 = 0;
        while (i6 < length) {
            char charAt2 = str.charAt(i6);
            if (charAt2 >= '0' && charAt2 <= '9') {
                String str2 = "" + charAt2;
                while (true) {
                    int i7 = i6 + 1;
                    if (i7 >= length || (charAt = str.charAt(i7)) < '0' || charAt > '9') {
                        break;
                    }
                    str2 = str2 + charAt;
                    i6 = i7;
                }
                stack.push(str2);
            } else if (charAt2 == '(') {
                stack2.push("" + charAt2);
            } else if (charAt2 == ')') {
                while (!((String) stack2.peek()).equals("(")) {
                    stack.push("" + a(Integer.parseInt((String) stack.pop()), (String) stack2.pop(), Integer.parseInt((String) stack.pop())));
                }
                stack2.pop();
            } else {
                if (!a(charAt2)) {
                    throw new RuntimeException("无法识别" + charAt2);
                }
                if (stack2.empty()) {
                    stack2.push("" + charAt2);
                } else {
                    String str3 = "" + charAt2;
                    if (b(str3) > b((String) stack2.peek())) {
                        stack2.push(str3);
                    } else {
                        while (!stack2.empty() && b(str3) <= b((String) stack2.peek())) {
                            stack.push("" + a(Integer.parseInt((String) stack.pop()), (String) stack2.pop(), Integer.parseInt((String) stack.pop())));
                        }
                        stack2.push(str3);
                    }
                }
            }
            i6++;
        }
        while (!stack2.empty()) {
            stack.push("" + a(Integer.parseInt((String) stack.pop()), (String) stack2.pop(), Integer.parseInt((String) stack.pop())));
        }
        return Integer.parseInt((String) stack.pop());
    }

    private static float b(String str) {
        str.getClass();
        switch (str) {
            case "%":
            case "*":
            case "/":
                return 2.0f;
            case "(":
                return 0.0f;
            case "+":
            case "-":
                return 1.0f;
            default:
                return -1.0f;
        }
    }

    private static int a(int i6, String str, int i7) {
        str.getClass();
        switch (str) {
            case "%":
                return i6 % i7;
            case "*":
                return i6 * i7;
            case "+":
                return i6 + i7;
            case "-":
                return i6 - i7;
            case "/":
                return i6 / i7;
            default:
                return 0;
        }
    }
}
