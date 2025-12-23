package com.hp.hpl.sparta.xpath;

import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class XPathException extends Exception {
    private Throwable cause_;

    public XPathException(c0 c0Var, String str) {
        super(c0Var + " " + str);
        this.cause_ = null;
    }

    private static String toString(s sVar) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(tokenToString(sVar));
            if (sVar.f32892a != -1) {
                sVar.a();
                stringBuffer.append(tokenToString(sVar));
                sVar.c();
            }
            return stringBuffer.toString();
        } catch (IOException e6) {
            return "(cannot get  info: " + e6 + ")";
        }
    }

    private static String tokenToString(s sVar) {
        int i6 = sVar.f32892a;
        if (i6 == -3) {
            return sVar.f32894c;
        }
        if (i6 == -2) {
            return sVar.f32893b + "";
        }
        if (i6 == -1) {
            return "<end of expression>";
        }
        return ((char) sVar.f32892a) + "";
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause_;
    }

    XPathException(c0 c0Var, String str, s sVar, String str2) {
        this(c0Var, str + " got \"" + toString(sVar) + "\" instead of expected " + str2);
    }

    XPathException(c0 c0Var, Exception exc) {
        super(c0Var + " " + exc);
        this.cause_ = exc;
    }
}
