package com.baidu.liantian.core;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.liantian.ac.Callback;
import com.baidu.liantian.ac.F;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class e {
    public static void a(final Context context, final int i6, boolean z5) {
        try {
            d.f10404c = z5;
            com.baidu.liantian.b.e.l(context);
            if (z5) {
                new Thread(new Runnable() { // from class: com.baidu.liantian.core.e.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            Context context2 = context;
                            d.f10403b = context2;
                            if (!com.baidu.liantian.b.e.a(context2, true)) {
                                com.baidu.liantian.b.a();
                                return;
                            }
                            if (!com.baidu.liantian.b.e.a(context)) {
                                com.baidu.liantian.b.a();
                                return;
                            }
                            d a6 = d.a(context);
                            com.baidu.liantian.b.g.a(context);
                            try {
                                if (i6 > 0) {
                                    Thread.sleep(r2 * 1000);
                                }
                            } catch (Throwable unused) {
                                com.baidu.liantian.b.e.a();
                            }
                            new com.baidu.liantian.e(context).a(1);
                            d.a(1);
                            a6.a((Callback) null);
                        } catch (Throwable unused2) {
                            com.baidu.liantian.b.e.a();
                        }
                    }
                }).start();
            }
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
        }
    }

    private static String b(Context context) {
        com.baidu.liantian.e eVar;
        String string;
        String[] split;
        byte[] re;
        try {
            eVar = new com.baidu.liantian.e(context);
            string = eVar.f10458b.getString("xytk", "");
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
        }
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        String a6 = com.baidu.liantian.b.g.a(context);
        if (!TextUtils.isEmpty(a6) && (split = a6.split("\\|")) != null && split.length == 2 && !TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1]) && (re = F.getInstance().re(split[1].getBytes(), split[0].getBytes())) != null) {
            String str = split[0] + com.baidu.liantian.b.e.a(re);
            eVar.f10460d.putString("xytk", str);
            eVar.f10460d.commit();
            return str;
        }
        return "74FFB5E615AA72E0B057EE43E3D5A23A|440049145074113";
    }

    private static Pair<Integer, Object> a(int i6, String str, Class<?>[] clsArr, Object... objArr) {
        try {
            Context context = d.f10403b;
            if (context == null) {
                return new Pair<>(4, null);
            }
            if (!com.baidu.liantian.b.e.a(context, false)) {
                com.baidu.liantian.b.a();
                return new Pair<>(11, null);
            }
            String b6 = com.baidu.liantian.b.e.b(d.f10403b);
            if (TextUtils.isEmpty(b6)) {
                if (com.baidu.liantian.b.e.b(d.f10403b.getPackageName())) {
                    return new Pair<>(5, null);
                }
                com.baidu.liantian.b.a();
                return d.a(context).a(i6, str, clsArr, objArr);
            }
            if (com.baidu.liantian.b.e.b(b6)) {
                com.baidu.liantian.b.a();
                return a(d.f10403b, i6, str, clsArr, objArr);
            }
            com.baidu.liantian.b.a();
            return d.a(context).a(i6, str, clsArr, objArr);
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
            return new Pair<>(3, null);
        }
    }

    public static boolean a(final int i6, final String str, final Callback callback, final Class<?>[] clsArr, final Object... objArr) {
        try {
            Context context = d.f10403b;
            if (context == null) {
                com.baidu.liantian.b.a();
                if (callback != null) {
                    callback.onError(4);
                }
                return false;
            }
            if (!com.baidu.liantian.b.e.a(context, false)) {
                com.baidu.liantian.b.a();
                if (callback != null) {
                    callback.onError(11);
                }
                return false;
            }
            String b6 = com.baidu.liantian.b.e.b(d.f10403b);
            if (TextUtils.isEmpty(b6)) {
                if (com.baidu.liantian.b.e.b(d.f10403b.getPackageName())) {
                    if (callback != null) {
                        callback.onError(5);
                    }
                    return false;
                }
                com.baidu.liantian.b.a();
                d.a(context).a(i6, str, callback, clsArr, objArr);
                return true;
            }
            if (com.baidu.liantian.b.e.b(b6)) {
                com.baidu.liantian.b.a();
                final Context context2 = d.f10403b;
                try {
                    if (!TextUtils.isEmpty(str)) {
                        new Thread() { // from class: com.baidu.liantian.core.e.3
                            @Override // java.lang.Thread, java.lang.Runnable
                            public final void run() {
                                super.run();
                                Callback callback2 = Callback.this;
                                if (callback2 != null) {
                                    callback2.onBegin(new Object[0]);
                                }
                                Pair<Integer, Object> a6 = e.a(context2, i6, 0, str, clsArr, objArr);
                                if (Callback.this != null) {
                                    if (((Integer) a6.first).intValue() != 0) {
                                        Callback.this.onError(a6.first);
                                    } else {
                                        Callback.this.onEnd(a6.second);
                                    }
                                }
                            }
                        }.start();
                    } else if (callback != null) {
                        callback.onError(1);
                    }
                } catch (Throwable unused) {
                    if (callback != null) {
                        try {
                            callback.onError(3);
                        } catch (Throwable unused2) {
                        }
                    }
                    com.baidu.liantian.b.e.a();
                }
                return true;
            }
            com.baidu.liantian.b.a();
            d.a(context).a(i6, str, callback, clsArr, objArr);
            return true;
        } catch (Throwable unused3) {
            com.baidu.liantian.b.e.a();
            return false;
        }
    }

    public static String a(Context context) {
        try {
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
        }
        if (!com.baidu.liantian.b.e.a(context, false)) {
            com.baidu.liantian.b.a();
            return "";
        }
        String b6 = com.baidu.liantian.b.e.b(context);
        if (TextUtils.isEmpty(b6)) {
            if (com.baidu.liantian.b.e.b(context.getPackageName())) {
                return "";
            }
            com.baidu.liantian.b.a();
            return b(context);
        }
        if (com.baidu.liantian.b.e.b(b6)) {
            com.baidu.liantian.b.a();
            Pair<Integer, Object> a6 = a(context, 0, "gz", (Class<?>[]) null, new Object[0]);
            if (a6 != null) {
                if (((Integer) a6.first).intValue() == 0) {
                    return (String) a6.second;
                }
                com.baidu.liantian.b.a();
                return "";
            }
            return "";
        }
        com.baidu.liantian.b.a();
        return b(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x006b A[Catch: all -> 0x00b9, TRY_LEAVE, TryCatch #3 {all -> 0x00b9, blocks: (B:9:0x002a, B:11:0x0039, B:13:0x003e, B:14:0x0065, B:16:0x006b, B:19:0x0077, B:20:0x0087, B:21:0x009a, B:23:0x00a4, B:26:0x00a8, B:28:0x004c, B:30:0x004f), top: B:8:0x002a, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a4 A[Catch: all -> 0x00b9, TryCatch #3 {all -> 0x00b9, blocks: (B:9:0x002a, B:11:0x0039, B:13:0x003e, B:14:0x0065, B:16:0x006b, B:19:0x0077, B:20:0x0087, B:21:0x009a, B:23:0x00a4, B:26:0x00a8, B:28:0x004c, B:30:0x004f), top: B:8:0x002a, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a8 A[Catch: all -> 0x00b9, TRY_LEAVE, TryCatch #3 {all -> 0x00b9, blocks: (B:9:0x002a, B:11:0x0039, B:13:0x003e, B:14:0x0065, B:16:0x006b, B:19:0x0077, B:20:0x0087, B:21:0x009a, B:23:0x00a4, B:26:0x00a8, B:28:0x004c, B:30:0x004f), top: B:8:0x002a, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.os.Bundle a(android.content.Context r18, java.lang.String r19, android.os.Bundle r20) {
        /*
            Method dump skipped, instructions count: 426
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.core.e.a(android.content.Context, java.lang.String, android.os.Bundle):android.os.Bundle");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0038 A[Catch: all -> 0x00d7, TryCatch #0 {all -> 0x00d7, blocks: (B:3:0x0006, B:5:0x000c, B:8:0x0016, B:10:0x001e, B:14:0x002b, B:16:0x0038, B:17:0x003c, B:19:0x003f, B:21:0x0047, B:23:0x0053, B:25:0x006f, B:27:0x0067, B:30:0x0072, B:31:0x0074, B:33:0x00a5, B:35:0x00aa, B:37:0x00be, B:38:0x00c8, B:41:0x00d2, B:43:0x00d0), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a5 A[Catch: all -> 0x00d7, TryCatch #0 {all -> 0x00d7, blocks: (B:3:0x0006, B:5:0x000c, B:8:0x0016, B:10:0x001e, B:14:0x002b, B:16:0x0038, B:17:0x003c, B:19:0x003f, B:21:0x0047, B:23:0x0053, B:25:0x006f, B:27:0x0067, B:30:0x0072, B:31:0x0074, B:33:0x00a5, B:35:0x00aa, B:37:0x00be, B:38:0x00c8, B:41:0x00d2, B:43:0x00d0), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00aa A[Catch: all -> 0x00d7, TryCatch #0 {all -> 0x00d7, blocks: (B:3:0x0006, B:5:0x000c, B:8:0x0016, B:10:0x001e, B:14:0x002b, B:16:0x0038, B:17:0x003c, B:19:0x003f, B:21:0x0047, B:23:0x0053, B:25:0x006f, B:27:0x0067, B:30:0x0072, B:31:0x0074, B:33:0x00a5, B:35:0x00aa, B:37:0x00be, B:38:0x00c8, B:41:0x00d2, B:43:0x00d0), top: B:2:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static android.util.Pair<java.lang.Integer, java.lang.Object> a(android.content.Context r5, int r6, int r7, java.lang.String r8, java.lang.Class<?>[] r9, java.lang.Object... r10) {
        /*
            r0 = 3
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1 = 0
            boolean r2 = android.text.TextUtils.isEmpty(r8)     // Catch: java.lang.Throwable -> Ld7
            if (r2 == 0) goto L16
            r5 = 1
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> Ld7
            android.util.Pair r5 = android.util.Pair.create(r5, r1)     // Catch: java.lang.Throwable -> Ld7
            return r5
        L16:
            java.lang.String r2 = "gzfi"
            boolean r2 = r2.equals(r8)     // Catch: java.lang.Throwable -> Ld7
            if (r2 != 0) goto L2a
            java.lang.String r2 = "gz"
            boolean r2 = r2.equals(r8)     // Catch: java.lang.Throwable -> Ld7
            if (r2 == 0) goto L27
            goto L2a
        L27:
            java.lang.String r2 = "invokeMethod"
            goto L2b
        L2a:
            r2 = r8
        L2b:
            com.baidu.liantian.core.c r3 = new com.baidu.liantian.core.c     // Catch: java.lang.Throwable -> Ld7
            r3.<init>()     // Catch: java.lang.Throwable -> Ld7
            r3.f10397a = r6     // Catch: java.lang.Throwable -> Ld7
            r3.f10399c = r8     // Catch: java.lang.Throwable -> Ld7
            r3.f10398b = r7     // Catch: java.lang.Throwable -> Ld7
            if (r9 == 0) goto L74
            int r6 = r9.length     // Catch: java.lang.Throwable -> Ld7
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch: java.lang.Throwable -> Ld7
            r7 = 0
        L3c:
            int r8 = r9.length     // Catch: java.lang.Throwable -> Ld7
            if (r7 >= r8) goto L72
            r8 = r9[r7]     // Catch: java.lang.Throwable -> Ld7
            boolean r8 = r8.isPrimitive()     // Catch: java.lang.Throwable -> Ld7
            if (r8 == 0) goto L67
            r8 = r9[r7]     // Catch: java.lang.Throwable -> Ld7
            java.lang.String r8 = com.baidu.liantian.b.e.a(r8)     // Catch: java.lang.Throwable -> Ld7
            boolean r4 = android.text.TextUtils.isEmpty(r8)     // Catch: java.lang.Throwable -> Ld7
            if (r4 != 0) goto L6f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ld7
            r4.<init>()     // Catch: java.lang.Throwable -> Ld7
            r4.append(r8)     // Catch: java.lang.Throwable -> Ld7
            java.lang.String r8 = "@@"
            r4.append(r8)     // Catch: java.lang.Throwable -> Ld7
            java.lang.String r8 = r4.toString()     // Catch: java.lang.Throwable -> Ld7
            r6[r7] = r8     // Catch: java.lang.Throwable -> Ld7
            goto L6f
        L67:
            r8 = r9[r7]     // Catch: java.lang.Throwable -> Ld7
            java.lang.String r8 = r8.getCanonicalName()     // Catch: java.lang.Throwable -> Ld7
            r6[r7] = r8     // Catch: java.lang.Throwable -> Ld7
        L6f:
            int r7 = r7 + 1
            goto L3c
        L72:
            r3.f10400d = r6     // Catch: java.lang.Throwable -> Ld7
        L74:
            r3.f10401e = r10     // Catch: java.lang.Throwable -> Ld7
            android.os.Bundle r6 = new android.os.Bundle     // Catch: java.lang.Throwable -> Ld7
            r6.<init>()     // Catch: java.lang.Throwable -> Ld7
            java.lang.String r7 = "args"
            r6.putParcelable(r7, r3)     // Catch: java.lang.Throwable -> Ld7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ld7
            java.lang.String r8 = "content://"
            r7.<init>(r8)     // Catch: java.lang.Throwable -> Ld7
            java.lang.String r8 = r5.getPackageName()     // Catch: java.lang.Throwable -> Ld7
            r7.append(r8)     // Catch: java.lang.Throwable -> Ld7
            java.lang.String r8 = ".liantian.ac.provider"
            r7.append(r8)     // Catch: java.lang.Throwable -> Ld7
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> Ld7
            android.net.Uri r7 = android.net.Uri.parse(r7)     // Catch: java.lang.Throwable -> Ld7
            android.content.ContentResolver r5 = r5.getContentResolver()     // Catch: java.lang.Throwable -> Ld7
            android.os.Bundle r5 = r5.call(r7, r2, r1, r6)     // Catch: java.lang.Throwable -> Ld7
            if (r5 != 0) goto Laa
            android.util.Pair r5 = android.util.Pair.create(r0, r1)     // Catch: java.lang.Throwable -> Ld7
            return r5
        Laa:
            java.lang.Class<com.baidu.liantian.core.c> r6 = com.baidu.liantian.core.c.class
            java.lang.ClassLoader r6 = r6.getClassLoader()     // Catch: java.lang.Throwable -> Ld7
            r5.setClassLoader(r6)     // Catch: java.lang.Throwable -> Ld7
            java.lang.String r6 = "status"
            int r6 = r5.getInt(r6)     // Catch: java.lang.Throwable -> Ld7
            com.baidu.liantian.b.a()     // Catch: java.lang.Throwable -> Ld7
            if (r6 != 0) goto Lc7
            java.lang.String r7 = "result"
            android.os.Parcelable r5 = r5.getParcelable(r7)     // Catch: java.lang.Throwable -> Ld7
            com.baidu.liantian.core.c r5 = (com.baidu.liantian.core.c) r5     // Catch: java.lang.Throwable -> Ld7
            goto Lc8
        Lc7:
            r5 = r1
        Lc8:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> Ld7
            if (r5 != 0) goto Ld0
            r5 = r1
            goto Ld2
        Ld0:
            java.lang.Object r5 = r5.f10402f     // Catch: java.lang.Throwable -> Ld7
        Ld2:
            android.util.Pair r5 = android.util.Pair.create(r6, r5)     // Catch: java.lang.Throwable -> Ld7
            return r5
        Ld7:
            com.baidu.liantian.b.e.a()
            android.util.Pair r5 = android.util.Pair.create(r0, r1)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.core.e.a(android.content.Context, int, int, java.lang.String, java.lang.Class[], java.lang.Object[]):android.util.Pair");
    }

    private static Pair<Integer, Object> a(Context context, int i6, String str, Class<?>[] clsArr, Object... objArr) {
        return a(context, i6, 1, str, clsArr, objArr);
    }
}
