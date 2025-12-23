package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.col.s.r2;
import java.io.InputStream;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class i3 {
    static byte[] f(r2 r2Var, String str) {
        r2.e eVar;
        byte[] bArr = new byte[0];
        InputStream inputStream = null;
        try {
            eVar = r2Var.a(str);
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
                        g2.o(th, "sui", "rdS");
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

    public static c3 a(WeakReference<c3> weakReference) {
        if (weakReference == null || weakReference.get() == null) {
            weakReference = new WeakReference<>(new c3());
        }
        return weakReference.get();
    }

    public static String c(Context context, i1 i1Var) {
        StringBuilder sb = new StringBuilder();
        try {
            String v5 = c1.v();
            sb.append("\"sim\":\"");
            sb.append(v5);
            sb.append("\",\"sdkversion\":\"");
            sb.append(i1Var.f());
            sb.append("\",\"product\":\"");
            sb.append(i1Var.d());
            sb.append("\",\"ed\":\"");
            sb.append(i1Var.g());
            sb.append("\",\"nt\":\"");
            sb.append(c1.r(context));
            sb.append("\",\"np\":\"");
            sb.append(c1.p(context));
            sb.append("\",\"mnc\":\"");
            sb.append(c1.u());
            sb.append("\",\"ant\":\"");
            sb.append(c1.t(context));
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

    public static String b() {
        return j1.b(System.currentTimeMillis());
    }

    public static void e(Context context, c3 c3Var, String str, int i6, int i7, String str2) {
        c3Var.f7931a = e2.i(context, str);
        c3Var.f7934d = i6;
        c3Var.f7932b = i7;
        c3Var.f7933c = str2;
    }
}
