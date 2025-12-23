package com.sun.mail.imap.protocol;

import io.netty.util.internal.StringUtil;
import java.util.Vector;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class w {

    /* renamed from: a, reason: collision with root package name */
    public long f39511a;

    /* renamed from: b, reason: collision with root package name */
    public long f39512b;

    public w() {
    }

    public w(long j6, long j7) {
        this.f39511a = j6;
        this.f39512b = j7;
    }

    public static w[] a(long[] jArr) {
        Vector vector = new Vector();
        int i6 = 0;
        while (i6 < jArr.length) {
            w wVar = new w();
            wVar.f39511a = jArr[i6];
            do {
                i6++;
                if (i6 >= jArr.length) {
                    break;
                }
                wVar.f39512b = jArr[i6 - 1];
                vector.addElement(wVar);
            } while (jArr[i6] == jArr[i6 - 1] + 1);
            wVar.f39512b = jArr[i6 - 1];
            vector.addElement(wVar);
        }
        w[] wVarArr = new w[vector.size()];
        vector.copyInto(wVarArr);
        return wVarArr;
    }

    public static long c(w[] wVarArr) {
        long j6 = 0;
        if (wVarArr == null) {
            return 0L;
        }
        for (w wVar : wVarArr) {
            j6 += wVar.b();
        }
        return j6;
    }

    public static String d(w[] wVarArr) {
        if (wVarArr == null || wVarArr.length == 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int length = wVarArr.length;
        int i6 = 0;
        while (true) {
            w wVar = wVarArr[i6];
            long j6 = wVar.f39511a;
            long j7 = wVar.f39512b;
            if (j7 > j6) {
                stringBuffer.append(j6);
                stringBuffer.append(':');
                stringBuffer.append(j7);
            } else {
                stringBuffer.append(j6);
            }
            i6++;
            if (i6 >= length) {
                return stringBuffer.toString();
            }
            stringBuffer.append(StringUtil.COMMA);
        }
    }

    public long b() {
        return (this.f39512b - this.f39511a) + 1;
    }
}
