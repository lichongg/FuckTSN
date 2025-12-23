package com.uyumao;

import android.content.Context;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f42561a;

    public b(Context context) {
        this.f42561a = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0070  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            r7 = this;
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> L4b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4b
            r1.<init>()     // Catch: java.lang.Throwable -> L4b
            android.content.Context r2 = r7.f42561a     // Catch: java.lang.Throwable -> L4b
            java.io.File r2 = r2.getCacheDir()     // Catch: java.lang.Throwable -> L4b
            r1.append(r2)     // Catch: java.lang.Throwable -> L4b
            java.lang.String r2 = java.io.File.separator     // Catch: java.lang.Throwable -> L4b
            r1.append(r2)     // Catch: java.lang.Throwable -> L4b
            java.lang.String r2 = "net_change"
            r1.append(r2)     // Catch: java.lang.Throwable -> L4b
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L4b
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L4b
            java.lang.String r0 = com.uyumao.e.b(r0)     // Catch: java.lang.Throwable -> L4b
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L4b
            r2 = 0
            if (r1 != 0) goto L4d
            java.lang.String r1 = "\n"
            java.lang.String[] r0 = r0.split(r1)     // Catch: java.lang.Throwable -> L4b
            int r1 = r0.length     // Catch: java.lang.Throwable -> L4b
            if (r1 <= 0) goto L4d
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L4b
            r1.<init>()     // Catch: java.lang.Throwable -> L4b
            int r3 = r0.length     // Catch: java.lang.Throwable -> L4b
            r4 = 0
        L3c:
            if (r4 >= r3) goto L4e
            r5 = r0[r4]     // Catch: java.lang.Throwable -> L4b
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L4b
            r6.<init>(r5)     // Catch: java.lang.Throwable -> L4b
            r1.put(r6)     // Catch: java.lang.Throwable -> L4b
            int r4 = r4 + 1
            goto L3c
        L4b:
            r0 = move-exception
            goto L75
        L4d:
            r1 = 0
        L4e:
            android.content.Context r0 = r7.f42561a     // Catch: java.lang.Throwable -> L4b
            android.content.Context r3 = com.uyumao.j.f42597a     // Catch: java.lang.Throwable -> L4b
            if (r3 != 0) goto L60
            if (r0 == 0) goto L60
            android.content.Context r0 = r0.getApplicationContext()     // Catch: java.lang.Throwable -> L4b
            android.content.Context r0 = com.stub.StubApp.getOrigApplicationContext(r0)     // Catch: java.lang.Throwable -> L4b
            com.uyumao.j.f42597a = r0     // Catch: java.lang.Throwable -> L4b
        L60:
            com.uyumao.j r0 = com.uyumao.j.a.f42598a     // Catch: java.lang.Throwable -> L4b
            com.uyumao.i r0 = r0.a()     // Catch: java.lang.Throwable -> L4b
            android.content.Context r3 = r7.f42561a     // Catch: java.lang.Throwable -> L4b
            org.json.JSONObject r0 = com.uyumao.c.a(r3, r0, r1)     // Catch: java.lang.Throwable -> L4b
            android.content.Context r3 = r7.f42561a     // Catch: java.lang.Throwable -> L4b
            if (r1 == 0) goto L71
            r2 = 1
        L71:
            com.uyumao.c.a(r3, r0, r2)     // Catch: java.lang.Throwable -> L4b
            return
        L75:
            r0.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uyumao.b.run():void");
    }
}
