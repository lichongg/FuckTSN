package com.amap.api.col.p0003l;

import android.content.Context;
import com.amap.api.col.p0003l.o6;
import java.io.InputStream;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class j7 {
    static byte[] g(o6 o6Var, String str) {
        o6.e eVar;
        byte[] bArr = new byte[0];
        InputStream inputStream = null;
        try {
            eVar = o6Var.a(str);
            if (eVar != null) {
                try {
                    InputStream a6 = eVar.a();
                    if (a6 != null) {
                        bArr = new byte[a6.available()];
                        a6.read(bArr);
                        try {
                            a6.close();
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        try {
                            eVar.close();
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                        return bArr;
                    }
                    if (a6 != null) {
                        try {
                            a6.close();
                        } catch (Throwable th3) {
                            th3.printStackTrace();
                        }
                    }
                    try {
                        eVar.close();
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                } catch (Throwable th5) {
                    th = th5;
                    try {
                        v5.p(th, "sui", "rdS");
                        if (0 != 0) {
                            try {
                                inputStream.close();
                            } catch (Throwable th6) {
                                th6.printStackTrace();
                            }
                        }
                        if (eVar != null) {
                            try {
                                eVar.close();
                            } catch (Throwable th7) {
                                th7.printStackTrace();
                            }
                        }
                        return bArr;
                    } finally {
                    }
                }
            } else if (eVar != null) {
                try {
                    eVar.close();
                    return bArr;
                } catch (Throwable th8) {
                    th8.printStackTrace();
                }
            }
            return bArr;
        } catch (Throwable th9) {
            th = th9;
            eVar = null;
        }
    }

    public static c7 a(WeakReference<c7> weakReference) {
        if (weakReference == null || weakReference.get() == null) {
            weakReference = new WeakReference<>(new c7());
        }
        return weakReference.get();
    }

    public static String c(Context context, p4 p4Var) {
        StringBuilder sb = new StringBuilder();
        try {
            String C = i4.C();
            sb.append("\"sim\":\"");
            sb.append(C);
            sb.append("\",\"sdkversion\":\"");
            sb.append(p4Var.f());
            sb.append("\",\"product\":\"");
            sb.append(p4Var.a());
            sb.append("\",\"ed\":\"");
            sb.append(p4Var.g());
            sb.append("\",\"nt\":\"");
            sb.append(i4.y(context));
            sb.append("\",\"np\":\"");
            sb.append(i4.w(context));
            sb.append("\",\"mnc\":\"");
            sb.append(i4.B());
            sb.append("\",\"ant\":\"");
            sb.append(i4.A(context));
            sb.append("\"");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }

    public static String d(String str, String str2, int i6, String str3, String str4) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(",\"timestamp\":\"");
        stringBuffer.append(str2);
        stringBuffer.append("\",\"et\":\"");
        stringBuffer.append(i6);
        stringBuffer.append("\",\"classname\":\"");
        stringBuffer.append(str3);
        stringBuffer.append("\",");
        stringBuffer.append("\"detail\":\"");
        stringBuffer.append(str4);
        stringBuffer.append("\"");
        return stringBuffer.toString();
    }

    public static String e(String str, String str2, String str3, String str4) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(",\"timestamp\":\"");
        stringBuffer.append(str2);
        stringBuffer.append("\",\"et\":\"");
        stringBuffer.append(1);
        stringBuffer.append("\",\"classname\":\"");
        stringBuffer.append(str3);
        stringBuffer.append("\",");
        stringBuffer.append("\"detail\":\"");
        stringBuffer.append(str4);
        stringBuffer.append("\"");
        return stringBuffer.toString();
    }

    public static String b() {
        return q4.b(System.currentTimeMillis());
    }

    public static void f(Context context, c7 c7Var, String str, int i6, int i7, String str2) {
        c7Var.f5849a = s5.i(context, str);
        c7Var.f5852d = i6;
        c7Var.f5850b = i7;
        c7Var.f5851c = str2;
    }
}
