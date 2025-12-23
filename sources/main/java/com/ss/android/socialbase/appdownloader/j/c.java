package com.ss.android.socialbase.appdownloader.j;

import android.content.Context;

/* loaded from: D:\Downloads\app\classes6.dex */
public class c extends d {

    /* renamed from: d, reason: collision with root package name */
    private String f38462d;

    /* renamed from: e, reason: collision with root package name */
    private String f38463e;

    /* JADX WARN: Removed duplicated region for block: B:20:0x00a4  */
    @Override // com.ss.android.socialbase.appdownloader.j.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.content.Intent xt() {
        /*
            r10 = this;
            com.ss.android.socialbase.downloader.jy.j r0 = r10.f38465b
            java.lang.String r1 = "s"
            java.lang.String r0 = r0.cw(r1)
            com.ss.android.socialbase.downloader.jy.j r1 = r10.f38465b
            java.lang.String r2 = "ak"
            java.lang.String r1 = r1.cw(r2)
            java.lang.String r1 = com.ss.android.socialbase.appdownloader.m.a.b(r1, r0)
            com.ss.android.socialbase.downloader.jy.j r2 = r10.f38465b
            java.lang.String r3 = "am"
            java.lang.String r2 = r2.cw(r3)
            java.lang.String r2 = com.ss.android.socialbase.appdownloader.m.a.b(r2, r0)
            com.ss.android.socialbase.downloader.jy.j r3 = r10.f38465b
            java.lang.String r4 = "an"
            java.lang.String r3 = r3.cw(r4)
            java.lang.String r3 = com.ss.android.socialbase.appdownloader.m.a.b(r3, r0)
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            r5 = 0
            if (r4 != 0) goto Ld3
            java.lang.String r4 = ","
            java.lang.String[] r6 = r3.split(r4)
            int r6 = r6.length
            r7 = 2
            if (r6 == r7) goto L3f
            goto Ld3
        L3f:
            java.lang.String[] r3 = r3.split(r4)
            com.ss.android.socialbase.downloader.jy.j r6 = r10.f38465b
            java.lang.String r8 = "al"
            java.lang.String r6 = r6.cw(r8)
            java.lang.String r6 = com.ss.android.socialbase.appdownloader.m.a.b(r6, r0)
            com.ss.android.socialbase.downloader.jy.j r8 = r10.f38465b
            java.lang.String r9 = "ao"
            java.lang.String r8 = r8.cw(r9)
            java.lang.String r0 = com.ss.android.socialbase.appdownloader.m.a.b(r8, r0)
            boolean r8 = android.text.TextUtils.isEmpty(r0)
            if (r8 != 0) goto Ld3
            java.lang.String[] r8 = r0.split(r4)
            int r8 = r8.length
            if (r8 == r7) goto L69
            goto Ld3
        L69:
            java.lang.String[] r0 = r0.split(r4)
            com.ss.android.socialbase.downloader.jy.j r4 = r10.f38465b
            java.lang.String r7 = "download_dir"
            org.json.JSONObject r4 = r4.r(r7)
            r7 = 1
            r8 = 0
            if (r4 == 0) goto Lad
            java.lang.String r5 = "dir_name"
            java.lang.String r4 = r4.optString(r5)
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 != 0) goto L99
            java.lang.String r5 = "%s"
            boolean r5 = r4.contains(r5)
            if (r5 == 0) goto L99
            java.lang.String r5 = r10.f38463e     // Catch: java.lang.Throwable -> L99
            java.lang.Object[] r9 = new java.lang.Object[r7]     // Catch: java.lang.Throwable -> L99
            r9[r8] = r5     // Catch: java.lang.Throwable -> L99
            java.lang.String r4 = java.lang.String.format(r4, r9)     // Catch: java.lang.Throwable -> L99
        L97:
            r5 = r4
            goto L9c
        L99:
            java.lang.String r4 = r10.f38463e
            goto L97
        L9c:
            int r4 = r5.length()
            r9 = 255(0xff, float:3.57E-43)
            if (r4 <= r9) goto Lad
            int r4 = r5.length()
            int r4 = r4 - r9
            java.lang.String r5 = r6.substring(r4)
        Lad:
            android.content.Intent r4 = new android.content.Intent
            r4.<init>(r1)
            r1 = r0[r8]
            r0 = r0[r7]
            r4.putExtra(r1, r0)
            java.lang.String r0 = r10.f38462d
            r4.putExtra(r2, r0)
            r4.putExtra(r6, r5)
            r0 = r3[r8]
            r1 = r3[r7]
            int r1 = java.lang.Integer.parseInt(r1)
            r4.putExtra(r0, r1)
            r0 = 268468224(0x10008000, float:2.5342157E-29)
            r4.addFlags(r0)
            return r4
        Ld3:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.j.c.xt():android.content.Intent");
    }

    public c(Context context, com.ss.android.socialbase.downloader.jy.j jVar, String str, String str2, String str3) {
        super(context, jVar, str);
        this.f38462d = str2;
        this.f38463e = str3;
    }
}
