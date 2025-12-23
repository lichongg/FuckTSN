package com.hp.hpl.sparta;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class ParseException extends Exception {
    private Throwable cause_;
    private int lineNumber_;

    public ParseException(String str) {
        super(str);
        this.lineNumber_ = -1;
        this.cause_ = null;
    }

    static String charRepr(int i6) {
        if (i6 == -1) {
            return "EOF";
        }
        return "" + ((char) i6);
    }

    private static String toMessage(String str, int i6, int i7, String str2, String str3) {
        return str + "(" + i6 + "): \n" + str2 + "\nLast character read was '" + charRepr(i7) + "'\n" + str3;
    }

    private static String toString(char[] cArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(cArr[0]);
        for (int i6 = 1; i6 < cArr.length; i6++) {
            stringBuffer.append("or " + cArr[i6]);
        }
        return stringBuffer.toString();
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause_;
    }

    public int getLineNumber() {
        return this.lineNumber_;
    }

    public ParseException(String str, Throwable th) {
        super(str + " " + th);
        this.lineNumber_ = -1;
        this.cause_ = th;
    }

    public ParseException(String str, int i6, int i7, String str2, String str3) {
        super(toMessage(str, i6, i7, str2, str3));
        this.cause_ = null;
        this.lineNumber_ = i6;
    }

    public ParseException(n nVar, String str, int i6, int i7, String str2, String str3) {
        this(str, i6, i7, str2, str3);
        nVar.c(str3, str, i6);
    }

    public ParseException(l lVar, String str) {
        this(lVar.f(), lVar.getSystemId(), lVar.getLineNumber(), lVar.e(), lVar.d(), str);
    }

    public ParseException(l lVar, char c6, char c7) {
        this(lVar, "got '" + c6 + "' instead of expected '" + c7 + "'");
    }

    public ParseException(l lVar, char c6, char[] cArr) {
        this(lVar, "got '" + c6 + "' instead of " + toString(cArr));
    }

    public ParseException(l lVar, char c6, String str) {
        this(lVar, "got '" + c6 + "' instead of " + str + " as expected");
    }

    public ParseException(l lVar, String str, String str2) {
        this(lVar, "got \"" + str + "\" instead of \"" + str2 + "\" as expected");
    }

    public ParseException(l lVar, String str, char[] cArr) {
        this(lVar, str, new String(cArr));
    }
}
