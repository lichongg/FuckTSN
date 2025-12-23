package com.amap.api.col.p0003l;

import android.content.Context;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class o4 {
    public static Proxy c(Context context) {
        try {
            return d(context, new URI("http://restsdk.amap.com"));
        } catch (Throwable th) {
            v5.p(th, "pu", "gp");
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x0091, code lost:
    
        if (r11 == (-1)) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00c0, code lost:
    
        r16 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00bd, code lost:
    
        if (r11 == (-1)) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0150, code lost:
    
        if (r9 != null) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x00c7, code lost:
    
        if (r9 != null) goto L123;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0156 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0105 A[Catch: all -> 0x00f0, TryCatch #6 {all -> 0x00f0, blocks: (B:92:0x00db, B:66:0x00fa, B:68:0x0105, B:70:0x0119, B:72:0x011f, B:76:0x0129, B:81:0x0133, B:83:0x0139, B:85:0x013f, B:89:0x0149), top: B:4:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00e5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v14, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v22 */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v25 */
    /* JADX WARN: Type inference failed for: r10v26 */
    /* JADX WARN: Type inference failed for: r10v27 */
    /* JADX WARN: Type inference failed for: r10v28 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v30 */
    /* JADX WARN: Type inference failed for: r10v31 */
    /* JADX WARN: Type inference failed for: r10v34 */
    /* JADX WARN: Type inference failed for: r10v35 */
    /* JADX WARN: Type inference failed for: r10v36 */
    /* JADX WARN: Type inference failed for: r10v37, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v39 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v41 */
    /* JADX WARN: Type inference failed for: r10v42 */
    /* JADX WARN: Type inference failed for: r10v47 */
    /* JADX WARN: Type inference failed for: r10v48 */
    /* JADX WARN: Type inference failed for: r10v49 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v50 */
    /* JADX WARN: Type inference failed for: r10v51 */
    /* JADX WARN: Type inference failed for: r10v52 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v0, types: [android.content.ContentResolver, android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.net.Proxy f(android.content.Context r20) {
        /*
            Method dump skipped, instructions count: 386
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.o4.f(android.content.Context):java.net.Proxy");
    }

    private static String a() {
        String str;
        try {
            str = android.net.Proxy.getDefaultHost();
        } catch (Throwable th) {
            v5.p(th, "pu", "gdh");
            str = null;
        }
        if (str == null) {
            return "null";
        }
        return str;
    }

    private static String b(String str) {
        return q4.u(str);
    }

    private static Proxy d(Context context, URI uri) {
        Proxy proxy;
        if (g(context)) {
            try {
                List<Proxy> select = ProxySelector.getDefault().select(uri);
                if (select != null && !select.isEmpty() && (proxy = select.get(0)) != null) {
                    if (proxy.type() != Proxy.Type.DIRECT) {
                        return proxy;
                    }
                }
                return null;
            } catch (Throwable th) {
                v5.p(th, "pu", "gpsc");
            }
        }
        return null;
    }

    private static int e() {
        try {
            return android.net.Proxy.getDefaultPort();
        } catch (Throwable th) {
            v5.p(th, "pu", "gdp");
            return -1;
        }
    }

    private static boolean g(Context context) {
        if (i4.M(context) == 0) {
            return true;
        }
        return false;
    }
}
