package cn.jiguang.af;

import android.content.Context;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private Context f1492a;

    /* JADX WARN: Removed duplicated region for block: B:11:0x0058 A[Catch: Exception -> 0x0028, TryCatch #0 {Exception -> 0x0028, blocks: (B:9:0x0048, B:11:0x0058, B:13:0x005e, B:14:0x0069, B:17:0x006d, B:19:0x000d, B:20:0x0022, B:21:0x002b, B:22:0x0041), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006d A[Catch: Exception -> 0x0028, TRY_LEAVE, TryCatch #0 {Exception -> 0x0028, blocks: (B:9:0x0048, B:11:0x0058, B:13:0x005e, B:14:0x0069, B:17:0x006d, B:19:0x000d, B:20:0x0022, B:21:0x002b, B:22:0x0041), top: B:2:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(int r10, java.lang.String r11) {
        /*
            r9 = this;
            java.lang.String r1 = "VivoDB"
            r2 = 0
            if (r10 == 0) goto L41
            r0 = 1
            if (r10 == r0) goto L2b
            r0 = 2
            if (r10 == r0) goto Ld
            r4 = r2
            goto L48
        Ld:
            java.lang.String r10 = "HDjJBOCwNx0aZi+Z7p83oR6X29bt13JSzReihhERik1FXRr9EgPkoDQnyVgIu2tARnCHNUAAn6DU1ZkzxwPHKA=="
            java.lang.String r10 = cn.jiguang.d.a.c(r10)     // Catch: java.lang.Exception -> L28
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L28
            r0.<init>()     // Catch: java.lang.Exception -> L28
            r0.append(r10)     // Catch: java.lang.Exception -> L28
            r0.append(r11)     // Catch: java.lang.Exception -> L28
            java.lang.String r10 = r0.toString()     // Catch: java.lang.Exception -> L28
        L22:
            android.net.Uri r10 = android.net.Uri.parse(r10)     // Catch: java.lang.Exception -> L28
            r4 = r10
            goto L48
        L28:
            r0 = move-exception
            r10 = r0
            goto L73
        L2b:
            java.lang.String r10 = "HDjJBOCwNx0aZi+Z7p83oR6X29bt13JSzReihhERik1mRRRjMzvkebo9eb3zqoVhCi2GjcOItUY/+C68T3lxGg=="
            java.lang.String r10 = cn.jiguang.d.a.c(r10)     // Catch: java.lang.Exception -> L28
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L28
            r0.<init>()     // Catch: java.lang.Exception -> L28
            r0.append(r10)     // Catch: java.lang.Exception -> L28
            r0.append(r11)     // Catch: java.lang.Exception -> L28
            java.lang.String r10 = r0.toString()     // Catch: java.lang.Exception -> L28
            goto L22
        L41:
            java.lang.String r10 = "HDjJBOCwNx0aZi+Z7p83oR6X29bt13JSzReihhERik1zTqeaHqknpahXd0Fww8QTTjy7MHX7/1f2JKNuxQ9omA=="
            java.lang.String r10 = cn.jiguang.d.a.c(r10)     // Catch: java.lang.Exception -> L28
            goto L22
        L48:
            android.content.Context r10 = r9.f1492a     // Catch: java.lang.Exception -> L28
            android.content.ContentResolver r3 = r10.getContentResolver()     // Catch: java.lang.Exception -> L28
            r7 = 0
            r8 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r10 = r3.query(r4, r5, r6, r7, r8)     // Catch: java.lang.Exception -> L28
            if (r10 == 0) goto L6d
            boolean r11 = r10.moveToNext()     // Catch: java.lang.Exception -> L28
            if (r11 == 0) goto L69
            java.lang.String r11 = "value"
            int r11 = r10.getColumnIndex(r11)     // Catch: java.lang.Exception -> L28
            java.lang.String r2 = r10.getString(r11)     // Catch: java.lang.Exception -> L28
        L69:
            r10.close()     // Catch: java.lang.Exception -> L28
            return r2
        L6d:
            java.lang.String r10 = "return cursor is null,return"
            cn.jiguang.bb.f.c(r1, r10)     // Catch: java.lang.Exception -> L28
            return r2
        L73:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "get id error: "
            r11.append(r0)
            java.lang.String r10 = r10.getMessage()
            r11.append(r10)
            java.lang.String r10 = r11.toString()
            cn.jiguang.bb.f.i(r1, r10)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.af.a.a(int, java.lang.String):java.lang.String");
    }

    public a(Context context) {
        this.f1492a = context;
    }
}
