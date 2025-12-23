package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class h4 {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a {
        String A;

        /* renamed from: a, reason: collision with root package name */
        String f6405a;

        /* renamed from: b, reason: collision with root package name */
        String f6406b;

        /* renamed from: c, reason: collision with root package name */
        String f6407c;

        /* renamed from: d, reason: collision with root package name */
        String f6408d;

        /* renamed from: e, reason: collision with root package name */
        String f6409e;

        /* renamed from: f, reason: collision with root package name */
        String f6410f;

        /* renamed from: g, reason: collision with root package name */
        String f6411g;

        /* renamed from: h, reason: collision with root package name */
        String f6412h;

        /* renamed from: i, reason: collision with root package name */
        String f6413i;

        /* renamed from: j, reason: collision with root package name */
        String f6414j;

        /* renamed from: k, reason: collision with root package name */
        String f6415k;

        /* renamed from: l, reason: collision with root package name */
        String f6416l;

        /* renamed from: m, reason: collision with root package name */
        String f6417m;

        /* renamed from: n, reason: collision with root package name */
        String f6418n;

        /* renamed from: o, reason: collision with root package name */
        String f6419o;

        /* renamed from: p, reason: collision with root package name */
        String f6420p;

        /* renamed from: q, reason: collision with root package name */
        String f6421q;

        /* renamed from: r, reason: collision with root package name */
        String f6422r;

        /* renamed from: s, reason: collision with root package name */
        String f6423s;

        /* renamed from: t, reason: collision with root package name */
        String f6424t;

        /* renamed from: u, reason: collision with root package name */
        String f6425u;

        /* renamed from: v, reason: collision with root package name */
        String f6426v;

        /* renamed from: w, reason: collision with root package name */
        String f6427w;

        /* renamed from: x, reason: collision with root package name */
        String f6428x;

        /* renamed from: y, reason: collision with root package name */
        String f6429y;

        /* renamed from: z, reason: collision with root package name */
        String f6430z;

        private a() {
        }

        /* synthetic */ a(byte b6) {
            this();
        }
    }

    public static String a() {
        try {
            String valueOf = String.valueOf(System.currentTimeMillis());
            String str = f4.d() ? "1" : "0";
            int length = valueOf.length();
            return valueOf.substring(0, length - 2) + str + valueOf.substring(length - 1);
        } catch (Throwable th) {
            r5.e(th, "CI", "TS");
            return null;
        }
    }

    private static byte[] j(a aVar) {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Throwable th) {
            th = th;
            byteArrayOutputStream = null;
        }
        try {
            e(byteArrayOutputStream, aVar.f6405a);
            e(byteArrayOutputStream, aVar.f6406b);
            e(byteArrayOutputStream, aVar.f6407c);
            e(byteArrayOutputStream, aVar.f6408d);
            e(byteArrayOutputStream, aVar.f6409e);
            e(byteArrayOutputStream, aVar.f6410f);
            e(byteArrayOutputStream, aVar.f6411g);
            e(byteArrayOutputStream, aVar.f6412h);
            e(byteArrayOutputStream, aVar.f6413i);
            e(byteArrayOutputStream, aVar.f6414j);
            e(byteArrayOutputStream, aVar.f6415k);
            e(byteArrayOutputStream, aVar.f6416l);
            e(byteArrayOutputStream, aVar.f6417m);
            e(byteArrayOutputStream, aVar.f6418n);
            e(byteArrayOutputStream, aVar.f6419o);
            e(byteArrayOutputStream, aVar.f6420p);
            e(byteArrayOutputStream, aVar.f6421q);
            e(byteArrayOutputStream, aVar.f6422r);
            e(byteArrayOutputStream, aVar.f6423s);
            e(byteArrayOutputStream, aVar.f6424t);
            e(byteArrayOutputStream, aVar.f6425u);
            e(byteArrayOutputStream, aVar.f6426v);
            e(byteArrayOutputStream, aVar.f6427w);
            e(byteArrayOutputStream, aVar.f6428x);
            e(byteArrayOutputStream, aVar.f6429y);
            e(byteArrayOutputStream, aVar.f6430z);
            e(byteArrayOutputStream, aVar.A);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            new String(byteArray);
            byte[] k6 = k(q4.t(byteArray));
            try {
                byteArrayOutputStream.close();
                return k6;
            } catch (Throwable th2) {
                th2.printStackTrace();
                return k6;
            }
        } catch (Throwable th3) {
            th = th3;
            try {
                r5.e(th, "CI", "gzx");
                return null;
            } finally {
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                }
            }
        }
    }

    private static String l(Context context) {
        try {
            return d(h(context, false, false));
        } catch (Throwable th) {
            r5.e(th, "CI", "gCXi");
            return null;
        }
    }

    public static String b(Context context) {
        try {
            a aVar = new a((byte) 0);
            aVar.f6408d = f4.g(context);
            aVar.f6413i = f4.h(context);
            return d(aVar);
        } catch (Throwable th) {
            r5.e(th, "CI", "IX");
            return null;
        }
    }

    public static String c(Context context, String str, String str2) {
        try {
            return m4.d(f4.i(context) + ":" + str.substring(0, str.length() - 3) + ":" + str2);
        } catch (Throwable th) {
            r5.e(th, "CI", "Sco");
            return null;
        }
    }

    private static a h(Context context, boolean z5, boolean z6) {
        a aVar = new a((byte) 0);
        aVar.f6405a = i4.P();
        aVar.f6406b = i4.I();
        String F = i4.F(context);
        if (F == null) {
            F = "";
        }
        aVar.f6407c = F;
        aVar.f6408d = f4.g(context);
        aVar.f6409e = Build.MODEL;
        aVar.f6410f = Build.MANUFACTURER;
        aVar.f6411g = Build.DEVICE;
        aVar.f6412h = f4.e(context);
        aVar.f6413i = f4.h(context);
        aVar.f6414j = String.valueOf(Build.VERSION.SDK_INT);
        aVar.f6415k = i4.U();
        aVar.f6416l = i4.T(context);
        StringBuilder sb = new StringBuilder();
        sb.append(i4.M(context));
        aVar.f6417m = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i4.K(context));
        aVar.f6418n = sb2.toString();
        aVar.f6419o = i4.e0(context);
        aVar.f6420p = i4.J(context);
        aVar.f6421q = "";
        aVar.f6422r = "";
        if (z5) {
            aVar.f6423s = "";
            aVar.f6424t = "";
        } else {
            String[] L = i4.L();
            aVar.f6423s = L[0];
            aVar.f6424t = L[1];
        }
        aVar.f6427w = i4.n();
        String o5 = i4.o(context);
        if (TextUtils.isEmpty(o5)) {
            aVar.f6428x = "";
        } else {
            aVar.f6428x = o5;
        }
        aVar.f6429y = "aid=" + i4.G();
        if ((z6 && f5.f6178e) || f5.f6179f) {
            String D = i4.D(context);
            if (!TextUtils.isEmpty(D)) {
                aVar.f6429y += "|oaid=" + D;
            }
        }
        String N = i4.N();
        if (!TextUtils.isEmpty(N)) {
            aVar.f6429y += "|multiImeis=" + N;
        }
        String S = i4.S();
        if (!TextUtils.isEmpty(S)) {
            aVar.f6429y += "|meid=" + S;
        }
        aVar.f6429y += "|serial=" + i4.E();
        String v5 = i4.v();
        if (!TextUtils.isEmpty(v5)) {
            aVar.f6429y += "|adiuExtras=" + v5;
        }
        aVar.f6429y += "|storage=" + i4.W() + "|ram=" + i4.c0(context) + "|arch=" + i4.Y();
        String b6 = q5.a().b();
        if (TextUtils.isEmpty(b6)) {
            aVar.f6430z = "";
        } else {
            aVar.f6430z = b6;
        }
        if (z5) {
            String b7 = w4.a(context).b();
            if (!TextUtils.isEmpty(b7)) {
                aVar.A = b7;
            }
        }
        return aVar;
    }

    private static String d(a aVar) {
        return j4.f(j(aVar));
    }

    private static void e(ByteArrayOutputStream byteArrayOutputStream, String str) {
        byte length;
        if (!TextUtils.isEmpty(str)) {
            if (str.getBytes().length > 255) {
                length = -1;
            } else {
                length = (byte) str.getBytes().length;
            }
            q4.j(byteArrayOutputStream, length, q4.o(str));
            return;
        }
        q4.j(byteArrayOutputStream, (byte) 0, new byte[0]);
    }

    public static byte[] f(Context context, boolean z5, boolean z6) {
        try {
            return j(h(context, z5, z6));
        } catch (Throwable th) {
            r5.e(th, "CI", "gz");
            return null;
        }
    }

    public static byte[] g(byte[] bArr) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        return j4.b(bArr);
    }

    public static String i(Context context) {
        return l(context);
    }

    private static byte[] k(byte[] bArr) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        PublicKey x5 = q4.x();
        if (bArr.length > 117) {
            byte[] bArr2 = new byte[117];
            System.arraycopy(bArr, 0, bArr2, 0, 117);
            byte[] c6 = j4.c(bArr2, x5);
            byte[] bArr3 = new byte[bArr.length + 11];
            System.arraycopy(c6, 0, bArr3, 0, 128);
            System.arraycopy(bArr, 117, bArr3, 128, bArr.length - 117);
            return bArr3;
        }
        return j4.c(bArr, x5);
    }
}
