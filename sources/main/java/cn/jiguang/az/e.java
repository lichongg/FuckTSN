package cn.jiguang.az;

import android.content.Context;
import android.content.SharedPreferences;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import okio.Utf8;

/* loaded from: D:\Downloads\app\classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static final String f1845a = cn.jiguang.ax.a.b(new byte[]{Utf8.REPLACEMENT_BYTE, 85, 88, 109, 75, 121, Byte.MAX_VALUE, 86, 73, 126});

    /* renamed from: b, reason: collision with root package name */
    public static final String f1846b = cn.jiguang.ax.a.b(new byte[]{116, 72, 84, 52});

    /* renamed from: c, reason: collision with root package name */
    public static final String f1847c = cn.jiguang.ax.a.b(new byte[]{32, 2, 69, 45, 61, 32, 38, 87, 25, 40, 99, 37, 37, 66, 22, 46});

    /* renamed from: d, reason: collision with root package name */
    public static final String f1848d = cn.jiguang.ax.a.b(new byte[]{BinaryMemcacheOpcodes.SASL_AUTH, 1, 16, 43, 56, 37, BinaryMemcacheOpcodes.SASL_AUTH, 4, 16, HttpConstants.COMMA, 56, 32, BinaryMemcacheOpcodes.SASL_AUTH, 7, 16, BinaryMemcacheOpcodes.SASL_AUTH});

    /* renamed from: e, reason: collision with root package name */
    public static final String f1849e = cn.jiguang.ax.a.b(new byte[]{85, 118, 97, BinaryMemcacheOpcodes.SASL_AUTH, 60, 84, 32, 0, 98, 46, 73, 85, 85, 116, 18, HttpConstants.COMMA});

    /* renamed from: f, reason: collision with root package name */
    private static SharedPreferences f1850f;

    public static String a(Context context, int i6, String str) {
        if (f1850f == null) {
            f1850f = context.getSharedPreferences(f1845a, 0);
        }
        String string = f1850f.getString(f1846b + str + "-" + i6, "");
        StringBuilder sb = new StringBuilder();
        sb.append("g1:");
        sb.append(string);
        cn.jiguang.ay.b.b("JC", sb.toString());
        if (!"".equals(string)) {
            try {
                string = new String(i.a(string, f1847c, f1848d));
            } catch (Exception unused) {
                cn.jiguang.ay.b.b("JC", "decrypt plugin failed");
            }
        }
        cn.jiguang.ay.b.b("JC", "g2:" + string);
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r9, int r10, java.lang.String r11, java.lang.String r12, boolean r13) {
        /*
            java.lang.String r7 = "JC"
            if (r13 == 0) goto L1a
            cn.jiguang.av.c r0 = cn.jiguang.av.c.a()
            int r3 = r0.a(r9, r10)
            cn.jiguang.dy.c r0 = cn.jiguang.dy.c.a()
            cn.jiguang.aw.a r4 = cn.jiguang.aw.a.f1799j
            r5 = 0
            r6 = 0
            r1 = r9
            r2 = r10
            r0.a(r1, r2, r3, r4, r5, r6)
            goto L1b
        L1a:
            r3 = -1
        L1b:
            android.content.SharedPreferences r0 = cn.jiguang.az.e.f1850f
            if (r0 != 0) goto L28
            java.lang.String r0 = cn.jiguang.az.e.f1845a
            r2 = 0
            android.content.SharedPreferences r0 = r9.getSharedPreferences(r0, r2)
            cn.jiguang.az.e.f1850f = r0
        L28:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L61
            r0.<init>()     // Catch: java.lang.Throwable -> L61
            java.lang.String r2 = "s1:"
            r0.append(r2)     // Catch: java.lang.Throwable -> L61
            r0.append(r12)     // Catch: java.lang.Throwable -> L61
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L61
            cn.jiguang.ay.b.b(r7, r0)     // Catch: java.lang.Throwable -> L61
            byte[] r0 = r12.getBytes()     // Catch: java.lang.Throwable -> L61
            java.lang.String r4 = cn.jiguang.az.e.f1847c     // Catch: java.lang.Throwable -> L61
            java.lang.String r5 = cn.jiguang.az.e.f1848d     // Catch: java.lang.Throwable -> L61
            java.lang.String r2 = cn.jiguang.az.i.a(r0, r4, r5)     // Catch: java.lang.Throwable -> L61
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5e
            r0.<init>()     // Catch: java.lang.Throwable -> L5e
            java.lang.String r4 = "s2:"
            r0.append(r4)     // Catch: java.lang.Throwable -> L5e
            r0.append(r2)     // Catch: java.lang.Throwable -> L5e
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L5e
            cn.jiguang.ay.b.b(r7, r0)     // Catch: java.lang.Throwable -> L5e
            r8 = r2
            goto L8e
        L5e:
            r0 = move-exception
            r8 = r2
            goto L63
        L61:
            r0 = move-exception
            r8 = r12
        L63:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "aesEncrypt error , msg :"
            r2.append(r4)
            java.lang.String r4 = r0.getMessage()
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            cn.jiguang.ay.b.g(r7, r2)
            if (r13 == 0) goto L8e
            r2 = r0
            cn.jiguang.dy.c r0 = cn.jiguang.dy.c.a()
            cn.jiguang.aw.a r4 = cn.jiguang.aw.a.f1799j
            r5 = 2
            java.lang.String r6 = r2.getMessage()
            r1 = r9
            r2 = r10
            r0.a(r1, r2, r3, r4, r5, r6)
        L8e:
            android.content.SharedPreferences r0 = cn.jiguang.az.e.f1850f
            android.content.SharedPreferences$Editor r0 = r0.edit()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = cn.jiguang.az.e.f1846b
            r1.append(r4)
            r1.append(r11)
            java.lang.String r4 = "-"
            r1.append(r4)
            r1.append(r10)
            java.lang.String r1 = r1.toString()
            r0.putString(r1, r8)
            r0.commit()
            if (r13 == 0) goto Lcb
            cn.jiguang.dy.c r0 = cn.jiguang.dy.c.a()
            cn.jiguang.aw.a r4 = cn.jiguang.aw.a.f1799j
            r5 = 1
            r6 = 0
            r1 = r9
            r2 = r10
            r0.a(r1, r2, r3, r4, r5, r6)
            cn.jiguang.dy.c r0 = cn.jiguang.dy.c.a()
            cn.jiguang.aw.a r4 = cn.jiguang.aw.a.f1795f
            r0.a(r1, r2, r3, r4, r5, r6)
        Lcb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.az.e.a(android.content.Context, int, java.lang.String, java.lang.String, boolean):void");
    }
}
