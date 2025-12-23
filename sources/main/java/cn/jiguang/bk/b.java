package cn.jiguang.bk;

import android.content.Context;
import cn.jiguang.bb.f;
import cn.jiguang.bz.u;
import cn.jiguang.bz.v;
import cn.jiguang.internal.JConstants;
import java.nio.ByteBuffer;
import java.security.SecureRandom;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static Integer f2308a;

    public static int a() {
        Integer num = f2308a;
        if (num != null) {
            return num.intValue();
        }
        Integer valueOf = Integer.valueOf(Math.abs(new SecureRandom().nextInt()));
        f2308a = valueOf;
        return valueOf.intValue();
    }

    public static String a(Context context) {
        long f6 = cn.jiguang.d.a.f(context);
        return f6 > 0 ? v.a(f6) : v.a(a());
    }

    public static String a(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[byteBuffer.getShort()];
        byteBuffer.get(bArr);
        try {
            return new String(bArr, "UTF-8");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static byte[] a(long j6, int i6, long j7, short s5, int i7, int i8, int i9) {
        cn.jiguang.bn.b bVar = new cn.jiguang.bn.b(20480);
        bVar.b(0);
        bVar.a(8);
        bVar.a(2);
        bVar.b(j6);
        bVar.a(i6);
        bVar.b(j7);
        bVar.a(s5);
        bVar.a(i7);
        bVar.b(i8);
        bVar.a(i9);
        bVar.b(bVar.a(), 0);
        return bVar.b();
    }

    public static byte[] a(long j6, long j7, String str, String str2, String str3, long j8, byte b6, int i6, String str4, String str5, String str6, String str7, int i7, int i8, String str8) {
        cn.jiguang.bn.b bVar = new cn.jiguang.bn.b(20480);
        bVar.b(0);
        bVar.a(27);
        bVar.a(1);
        bVar.b(j6);
        bVar.a(0L);
        bVar.b(j7);
        bVar.a(97);
        bVar.a(0);
        bVar.b(0);
        bVar.a(str);
        bVar.a(str3);
        bVar.a(str2);
        bVar.a(0);
        bVar.a(j8);
        bVar.a((int) b6);
        bVar.a(i6);
        bVar.a(str4);
        bVar.a(str5);
        bVar.a(str6);
        bVar.a(str7);
        bVar.a(i7);
        bVar.a(i8);
        bVar.a(str8);
        bVar.b(bVar.a(), 0);
        return bVar.b();
    }

    public static byte[] a(long j6, String str, String str2, String str3, String str4, long j7, String str5) {
        int a6 = a();
        cn.jiguang.bn.b bVar = new cn.jiguang.bn.b(20480);
        bVar.b(0);
        bVar.a(29);
        bVar.a(0);
        bVar.b(j6);
        bVar.a(a6);
        bVar.b(0L);
        bVar.a(str);
        bVar.a(str2);
        bVar.a(str3);
        bVar.a(0);
        bVar.a(str4);
        bVar.a(j7);
        bVar.a(str5);
        bVar.b(bVar.a(), 0);
        return bVar.b();
    }

    public static byte[] a(Context context, int i6, int i7, long j6, byte[] bArr, long j7) {
        cn.jiguang.bn.b bVar = new cn.jiguang.bn.b(20480);
        bVar.b(0);
        bVar.a(i7);
        bVar.a(i6);
        bVar.b(j6);
        bVar.a(JConstants.tcpSessionId);
        if (j7 == 0) {
            j7 = cn.jiguang.d.a.f(context);
        }
        bVar.b(j7);
        bVar.a(bArr);
        bVar.b(bVar.a(), 0);
        return a(context, bVar.b());
    }

    public static byte[] a(Context context, byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        int length = bArr.length - 24;
        byte[] bArr2 = new byte[24];
        byte[] bArr3 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, 24);
        System.arraycopy(bArr, 24, bArr3, 0, length);
        String a6 = a(context);
        try {
            byte b6 = JConstants.tcpAlgorithm;
            byte[] a7 = b6 == 2 ? new u().a(bArr3, a6) : v.a(bArr3, a6, a6.substring(0, 16), true);
            int length2 = a7.length + 24;
            byte[] bArr4 = new byte[length2];
            System.arraycopy(bArr2, 0, bArr4, 0, 24);
            System.arraycopy(a7, 0, bArr4, 24, a7.length);
            byte b7 = (byte) ((length2 >>> 8) & 255);
            bArr4[0] = b7;
            bArr4[1] = (byte) (length2 & 255);
            bArr4[0] = (byte) (b7 | 128);
            bArr4[4] = b6;
            return bArr4;
        } catch (Exception e6) {
            f.i("CorePackage", "e:" + e6);
            f.j("CorePackage", "encrpt data failed");
            return null;
        }
    }

    public static byte[] a(short s5, short s6, String str) {
        cn.jiguang.bn.b bVar = new cn.jiguang.bn.b(20480);
        bVar.a((int) s5);
        bVar.a((int) s6);
        bVar.a(str);
        return bVar.b();
    }
}
