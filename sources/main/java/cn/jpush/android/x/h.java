package cn.jpush.android.x;

/* loaded from: D:\Downloads\app\classes2.dex */
public class h {
    /* JADX WARN: Removed duplicated region for block: B:31:0x009b A[Catch: Exception -> 0x0088, TryCatch #0 {Exception -> 0x0088, blocks: (B:23:0x0079, B:27:0x0081, B:31:0x009b, B:32:0x00a4, B:34:0x00aa, B:35:0x00ae, B:38:0x00a0, B:39:0x008a), top: B:22:0x0079 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00aa A[Catch: Exception -> 0x0088, TryCatch #0 {Exception -> 0x0088, blocks: (B:23:0x0079, B:27:0x0081, B:31:0x009b, B:32:0x00a4, B:34:0x00aa, B:35:0x00ae, B:38:0x00a0, B:39:0x008a), top: B:22:0x0079 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a0 A[Catch: Exception -> 0x0088, TryCatch #0 {Exception -> 0x0088, blocks: (B:23:0x0079, B:27:0x0081, B:31:0x009b, B:32:0x00a4, B:34:0x00aa, B:35:0x00ae, B:38:0x00a0, B:39:0x008a), top: B:22:0x0079 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(java.util.ArrayList<java.lang.String> r16, android.content.Context r17, java.lang.String r18, java.lang.String r19, boolean r20) {
        /*
            r7 = r18
            r8 = r19
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "action:loadHtmlImageResources - urlPrefix:"
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            java.lang.String r9 = "RichHelper"
            cn.jpush.android.helper.Logger.v(r9, r0)
            boolean r0 = cn.jpush.android.ad.a.c(r7)
            r10 = 1
            if (r0 == 0) goto Le9
            if (r17 == 0) goto Le9
            int r0 = r16.size()
            if (r0 <= 0) goto Le9
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            if (r0 != 0) goto Le9
            java.util.Iterator r11 = r16.iterator()
            r0 = 1
        L34:
            boolean r1 = r11.hasNext()
            if (r1 == 0) goto Le8
            java.lang.Object r1 = r11.next()
            r12 = r1
            java.lang.String r12 = (java.lang.String) r12
            java.lang.String r13 = "https://"
            java.lang.String r14 = "http://"
            if (r12 == 0) goto L64
            boolean r1 = r12.startsWith(r14)
            if (r1 != 0) goto L64
            boolean r1 = r12.startsWith(r13)
            if (r1 != 0) goto L64
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r7)
            r1.append(r12)
            java.lang.String r1 = r1.toString()
            r2 = r1
            goto L65
        L64:
            r2 = r12
        L65:
            r15 = 0
            boolean r1 = cn.jpush.android.ad.a.a(r2, r15)
            if (r1 == 0) goto Le5
            r4 = 5
            r5 = 5000(0x1388, double:2.4703E-320)
            java.lang.String r3 = "notify_h_img"
            r1 = r17
            byte[] r2 = cn.jpush.android.w.b.b(r1, r2, r3, r4, r5)
            if (r2 == 0) goto Lde
            java.lang.String r3 = ""
            boolean r4 = r12.startsWith(r14)     // Catch: java.lang.Exception -> L88
            if (r4 != 0) goto L8a
            boolean r4 = r12.startsWith(r13)     // Catch: java.lang.Exception -> L88
            if (r4 == 0) goto L99
            goto L8a
        L88:
            r0 = move-exception
            goto Ld6
        L8a:
            java.lang.String r3 = "/"
            int r3 = r12.lastIndexOf(r3)     // Catch: java.lang.Exception -> L88
            int r3 = r3 + r10
            java.lang.String r3 = r12.substring(r15, r3)     // Catch: java.lang.Exception -> L88
            java.lang.String r12 = cn.jpush.android.ad.c.a(r12, r15)     // Catch: java.lang.Exception -> L88
        L99:
            if (r20 != 0) goto La0
            java.lang.String r4 = cn.jpush.android.ad.c.b(r1, r8)     // Catch: java.lang.Exception -> L88
            goto La4
        La0:
            java.lang.String r4 = cn.jpush.android.ad.c.c(r1, r8)     // Catch: java.lang.Exception -> L88
        La4:
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Exception -> L88
            if (r5 != 0) goto Lae
            java.lang.String r4 = r3.replaceAll(r7, r4)     // Catch: java.lang.Exception -> L88
        Lae:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L88
            r3.<init>()     // Catch: java.lang.Exception -> L88
            r3.append(r4)     // Catch: java.lang.Exception -> L88
            r3.append(r12)     // Catch: java.lang.Exception -> L88
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Exception -> L88
            cn.jpush.android.ad.c.a(r3, r2)     // Catch: java.lang.Exception -> L88
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L88
            r2.<init>()     // Catch: java.lang.Exception -> L88
            java.lang.String r4 = "Succeed to load image - "
            r2.append(r4)     // Catch: java.lang.Exception -> L88
            r2.append(r3)     // Catch: java.lang.Exception -> L88
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> L88
            cn.jpush.android.helper.Logger.v(r9, r2)     // Catch: java.lang.Exception -> L88
            goto L34
        Ld6:
            java.lang.String r2 = "Write storage error,  create img file fail."
            cn.jpush.android.helper.Logger.ww(r9, r2, r0)
        Ldb:
            r0 = 0
            goto L34
        Lde:
            r2 = 1020(0x3fc, double:5.04E-321)
            r0 = 0
            cn.jpush.android.helper.c.a(r8, r2, r0, r1)
            goto Ldb
        Le5:
            r1 = r17
            goto Ldb
        Le8:
            return r0
        Le9:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.x.h.a(java.util.ArrayList, android.content.Context, java.lang.String, java.lang.String, boolean):boolean");
    }
}
