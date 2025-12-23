package com.amap.api.col.s;

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
public final class a1 {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a {
        String A;

        /* renamed from: a, reason: collision with root package name */
        String f7833a;

        /* renamed from: b, reason: collision with root package name */
        String f7834b;

        /* renamed from: c, reason: collision with root package name */
        String f7835c;

        /* renamed from: d, reason: collision with root package name */
        String f7836d;

        /* renamed from: e, reason: collision with root package name */
        String f7837e;

        /* renamed from: f, reason: collision with root package name */
        String f7838f;

        /* renamed from: g, reason: collision with root package name */
        String f7839g;

        /* renamed from: h, reason: collision with root package name */
        String f7840h;

        /* renamed from: i, reason: collision with root package name */
        String f7841i;

        /* renamed from: j, reason: collision with root package name */
        String f7842j;

        /* renamed from: k, reason: collision with root package name */
        String f7843k;

        /* renamed from: l, reason: collision with root package name */
        String f7844l;

        /* renamed from: m, reason: collision with root package name */
        String f7845m;

        /* renamed from: n, reason: collision with root package name */
        String f7846n;

        /* renamed from: o, reason: collision with root package name */
        String f7847o;

        /* renamed from: p, reason: collision with root package name */
        String f7848p;

        /* renamed from: q, reason: collision with root package name */
        String f7849q;

        /* renamed from: r, reason: collision with root package name */
        String f7850r;

        /* renamed from: s, reason: collision with root package name */
        String f7851s;

        /* renamed from: t, reason: collision with root package name */
        String f7852t;

        /* renamed from: u, reason: collision with root package name */
        String f7853u;

        /* renamed from: v, reason: collision with root package name */
        String f7854v;

        /* renamed from: w, reason: collision with root package name */
        String f7855w;

        /* renamed from: x, reason: collision with root package name */
        String f7856x;

        /* renamed from: y, reason: collision with root package name */
        String f7857y;

        /* renamed from: z, reason: collision with root package name */
        String f7858z;

        private a() {
        }

        /* synthetic */ a(byte b6) {
            this();
        }
    }

    public static String a() {
        try {
            String valueOf = String.valueOf(System.currentTimeMillis());
            String str = x0.c() ? "1" : "0";
            int length = valueOf.length();
            return valueOf.substring(0, length - 2) + str + valueOf.substring(length - 1);
        } catch (Throwable th) {
            d2.e(th, "CI", "TS");
            return null;
        }
    }

    private static String i(Context context) {
        try {
            return d(h(context, false));
        } catch (Throwable th) {
            d2.e(th, "CI", "gCXi");
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
            e(byteArrayOutputStream, aVar.f7833a);
            e(byteArrayOutputStream, aVar.f7834b);
            e(byteArrayOutputStream, aVar.f7835c);
            e(byteArrayOutputStream, aVar.f7836d);
            e(byteArrayOutputStream, aVar.f7837e);
            e(byteArrayOutputStream, aVar.f7838f);
            e(byteArrayOutputStream, aVar.f7839g);
            e(byteArrayOutputStream, aVar.f7840h);
            e(byteArrayOutputStream, aVar.f7841i);
            e(byteArrayOutputStream, aVar.f7842j);
            e(byteArrayOutputStream, aVar.f7843k);
            e(byteArrayOutputStream, aVar.f7844l);
            e(byteArrayOutputStream, aVar.f7845m);
            e(byteArrayOutputStream, aVar.f7846n);
            e(byteArrayOutputStream, aVar.f7847o);
            e(byteArrayOutputStream, aVar.f7848p);
            e(byteArrayOutputStream, aVar.f7849q);
            e(byteArrayOutputStream, aVar.f7850r);
            e(byteArrayOutputStream, aVar.f7851s);
            e(byteArrayOutputStream, aVar.f7852t);
            e(byteArrayOutputStream, aVar.f7853u);
            e(byteArrayOutputStream, aVar.f7854v);
            e(byteArrayOutputStream, aVar.f7855w);
            e(byteArrayOutputStream, aVar.f7856x);
            e(byteArrayOutputStream, aVar.f7857y);
            e(byteArrayOutputStream, aVar.f7858z);
            e(byteArrayOutputStream, aVar.A);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            new String(byteArray);
            byte[] k6 = k(j1.s(byteArray));
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
                d2.e(th, "CI", "gzx");
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

    public static String c(Context context, String str, String str2) {
        try {
            return g1.a(x0.h(context) + ":" + str.substring(0, str.length() - 3) + ":" + str2);
        } catch (Throwable th) {
            d2.e(th, "CI", "Sco");
            return null;
        }
    }

    private static a h(Context context, boolean z5) {
        a aVar = new a((byte) 0);
        aVar.f7833a = c1.H();
        aVar.f7834b = c1.C();
        String y5 = c1.y(context);
        if (y5 == null) {
            y5 = "";
        }
        aVar.f7835c = y5;
        aVar.f7836d = x0.f(context);
        aVar.f7837e = Build.MODEL;
        aVar.f7838f = Build.MANUFACTURER;
        aVar.f7839g = Build.DEVICE;
        aVar.f7840h = x0.d(context);
        aVar.f7841i = x0.g(context);
        aVar.f7842j = String.valueOf(Build.VERSION.SDK_INT);
        aVar.f7843k = c1.M();
        aVar.f7844l = c1.G(context);
        StringBuilder sb = new StringBuilder();
        sb.append(c1.D(context));
        aVar.f7845m = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(c1.B(context));
        aVar.f7846n = sb2.toString();
        aVar.f7847o = c1.O(context);
        aVar.f7848p = c1.A(context);
        aVar.f7849q = "";
        aVar.f7850r = "";
        String[] E = c1.E();
        aVar.f7851s = E[0];
        aVar.f7852t = E[1];
        aVar.f7855w = c1.i();
        String j6 = c1.j(context);
        if (TextUtils.isEmpty(j6)) {
            aVar.f7856x = "";
        } else {
            aVar.f7856x = j6;
        }
        aVar.f7857y = "aid=" + c1.z();
        if ((z5 && s1.f8430e) || s1.f8431f) {
            String w5 = c1.w(context);
            if (!TextUtils.isEmpty(w5)) {
                aVar.f7857y += "|oaid=" + w5;
            }
        }
        String F = c1.F();
        if (!TextUtils.isEmpty(F)) {
            aVar.f7857y += "|multiImeis=" + F;
        }
        String J = c1.J();
        if (!TextUtils.isEmpty(J)) {
            aVar.f7857y += "|meid=" + J;
        }
        aVar.f7857y += "|serial=" + c1.x();
        String o5 = c1.o();
        if (!TextUtils.isEmpty(o5)) {
            aVar.f7857y += "|adiuExtras=" + o5;
        }
        aVar.f7857y += "|storage=" + c1.N() + "|ram=" + c1.L(context) + "|arch=" + c1.P();
        String b6 = c2.a().b();
        if (TextUtils.isEmpty(b6)) {
            aVar.f7858z = "";
            return aVar;
        }
        aVar.f7858z = b6;
        return aVar;
    }

    public static String b(Context context) {
        return i(context);
    }

    private static String d(a aVar) {
        return d1.f(j(aVar));
    }

    private static void e(ByteArrayOutputStream byteArrayOutputStream, String str) {
        byte length;
        if (!TextUtils.isEmpty(str)) {
            if (str.getBytes().length > 255) {
                length = -1;
            } else {
                length = (byte) str.getBytes().length;
            }
            j1.j(byteArrayOutputStream, length, j1.o(str));
            return;
        }
        j1.j(byteArrayOutputStream, (byte) 0, new byte[0]);
    }

    public static byte[] f(Context context, boolean z5) {
        try {
            return j(h(context, z5));
        } catch (Throwable th) {
            d2.e(th, "CI", "gz");
            return null;
        }
    }

    public static byte[] g(byte[] bArr) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        return d1.b(bArr);
    }

    private static byte[] k(byte[] bArr) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        PublicKey w5 = j1.w();
        if (bArr.length > 117) {
            byte[] bArr2 = new byte[117];
            System.arraycopy(bArr, 0, bArr2, 0, 117);
            byte[] c6 = d1.c(bArr2, w5);
            byte[] bArr3 = new byte[bArr.length + 11];
            System.arraycopy(c6, 0, bArr3, 0, 128);
            System.arraycopy(bArr, 117, bArr3, 128, bArr.length - 117);
            return bArr3;
        }
        return d1.c(bArr, w5);
    }
}
