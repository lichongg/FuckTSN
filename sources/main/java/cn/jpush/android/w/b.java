package cn.jpush.android.w;

import android.content.Context;
import cn.jpush.android.ad.m;
import io.netty.handler.codec.http.HttpConstants;
import java.io.InputStream;
import java.util.HashMap;
import okio.Utf8;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final String f3941a = cn.jpush.android.ad.d.b(new byte[]{32, 0, 14, 41, 38, 38, Utf8.REPLACEMENT_BYTE, 1, 23, 43});

    /* renamed from: b, reason: collision with root package name */
    private static final String f3942b = cn.jpush.android.ad.d.b(new byte[]{62, 82, 38, 113, 19, 93, 73, 85, 84, 2, 23, 92, HttpConstants.COLON, 34, 40, 115, 19, 47, 78, 84, 32, 3, 19, 40, 57, 83, 32, 114, 23, 93, 49, 82});

    /* renamed from: c, reason: collision with root package name */
    private static HashMap<String, String> f3943c = new HashMap<>();

    /* JADX WARN: Removed duplicated region for block: B:43:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0146 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0100 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r17, java.lang.String r18, java.lang.String r19, int r20, long r21) {
        /*
            Method dump skipped, instructions count: 338
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.w.b.a(android.content.Context, java.lang.String, java.lang.String, int, long):java.lang.String");
    }

    public static void b(String str) {
        try {
            HashMap<String, String> hashMap = f3943c;
            if (hashMap != null) {
                hashMap.remove(str);
            }
        } catch (Throwable unused) {
        }
    }

    public static String a(String str) {
        HashMap<String, String> hashMap = f3943c;
        if (hashMap == null || hashMap.size() <= 0 || !f3943c.containsKey(str)) {
            return null;
        }
        return f3943c.get(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:107:0x00ee, code lost:
    
        if (r11 == null) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00b2, code lost:
    
        if (r9 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00b4, code lost:
    
        r9.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01b4, code lost:
    
        if (r11 == null) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x00f0, code lost:
    
        r11.disconnect();
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x012b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0120  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] b(android.content.Context r15, java.lang.String r16, java.lang.String r17, int r18, long r19) {
        /*
            Method dump skipped, instructions count: 466
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.w.b.b(android.content.Context, java.lang.String, java.lang.String, int, long):byte[]");
    }

    public static byte[] a(Context context, String str, String str2, int i6, int i7) {
        return a(context, str, str2, i6, i7, false);
    }

    public static byte[] a(Context context, String str, String str2, int i6, int i7, boolean z5) {
        byte[] bArr = null;
        for (int i8 = 0; i8 < i6; i8++) {
            bArr = a(context, str, str2, i7, z5);
            if (bArr != null) {
                return bArr;
            }
        }
        return bArr;
    }

    public static byte[] a(Context context, String str, String str2, int i6, long j6, int i7) {
        byte[] bArr = null;
        for (int i8 = 0; i8 < i7; i8++) {
            bArr = b(context, str, str2, i6, j6);
            if (bArr != null) {
                return bArr;
            }
        }
        return bArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x0179, code lost:
    
        if (r2 == null) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0158, code lost:
    
        r2.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0156, code lost:
    
        if (r2 == null) goto L86;
     */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0169: IF  (r5 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:89:0x016e, block:B:88:0x0169 */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0161 A[Catch: all -> 0x015c, TRY_ENTER, TRY_LEAVE, TryCatch #9 {all -> 0x015c, blocks: (B:63:0x0139, B:55:0x0161), top: B:9:0x003e }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0176 A[Catch: all -> 0x017c, TRY_ENTER, TRY_LEAVE, TryCatch #10 {all -> 0x017c, blocks: (B:49:0x0129, B:50:0x012c, B:65:0x0153, B:59:0x0158, B:57:0x0176), top: B:9:0x003e }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0153 A[Catch: all -> 0x017c, TRY_ENTER, TryCatch #10 {all -> 0x017c, blocks: (B:49:0x0129, B:50:0x012c, B:65:0x0153, B:59:0x0158, B:57:0x0176), top: B:9:0x003e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static byte[] a(android.content.Context r13, java.lang.String r14, java.lang.String r15, int r16, boolean r17) {
        /*
            Method dump skipped, instructions count: 381
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.w.b.a(android.content.Context, java.lang.String, java.lang.String, int, boolean):byte[]");
    }

    public static byte[] a(InputStream inputStream) {
        return m.b(inputStream);
    }
}
