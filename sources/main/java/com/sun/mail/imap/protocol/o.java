package com.sun.mail.imap.protocol;

import io.netty.util.internal.StringUtil;
import java.util.Vector;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    public int f39486a;

    /* renamed from: b, reason: collision with root package name */
    public int f39487b;

    public o() {
    }

    public static int c(o[] oVarArr) {
        if (oVarArr == null) {
            return 0;
        }
        int i6 = 0;
        for (o oVar : oVarArr) {
            i6 += oVar.b();
        }
        return i6;
    }

    public o(int i6, int i7) {
        this.f39486a = i6;
        this.f39487b = i7;
    }

    public static o[] a(int[] iArr) {
        Vector vector = new Vector();
        int i6 = 0;
        while (i6 < iArr.length) {
            o oVar = new o();
            oVar.f39486a = iArr[i6];
            do {
                i6++;
                if (i6 >= iArr.length) {
                    break;
                }
                oVar.f39487b = iArr[i6 - 1];
                vector.addElement(oVar);
            } while (iArr[i6] == iArr[i6 - 1] + 1);
            oVar.f39487b = iArr[i6 - 1];
            vector.addElement(oVar);
        }
        o[] oVarArr = new o[vector.size()];
        vector.copyInto(oVarArr);
        return oVarArr;
    }

    public static String d(o[] oVarArr) {
        if (oVarArr == null || oVarArr.length == 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int length = oVarArr.length;
        int i6 = 0;
        while (true) {
            o oVar = oVarArr[i6];
            int i7 = oVar.f39486a;
            int i8 = oVar.f39487b;
            if (i8 > i7) {
                stringBuffer.append(i7);
                stringBuffer.append(':');
                stringBuffer.append(i8);
            } else {
                stringBuffer.append(i7);
            }
            i6++;
            if (i6 >= length) {
                return stringBuffer.toString();
            }
            stringBuffer.append(StringUtil.COMMA);
        }
    }

    public int b() {
        return (this.f39487b - this.f39486a) + 1;
    }
}
