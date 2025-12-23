package org.repackage.com.meizu.flyme.openidsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.text.TextUtils;

/* loaded from: D:\Downloads\app\classes7.dex */
class b {

    /* renamed from: e, reason: collision with root package name */
    private static volatile b f51595e;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f51596f;

    /* renamed from: h, reason: collision with root package name */
    private BroadcastReceiver f51602h;

    /* renamed from: a, reason: collision with root package name */
    OpenId f51597a = new OpenId("udid");

    /* renamed from: b, reason: collision with root package name */
    OpenId f51598b = new OpenId("oaid");

    /* renamed from: d, reason: collision with root package name */
    OpenId f51600d = new OpenId("vaid");

    /* renamed from: c, reason: collision with root package name */
    OpenId f51599c = new OpenId("aaid");

    /* renamed from: g, reason: collision with root package name */
    private SupportInfo f51601g = new SupportInfo();

    /* JADX WARN: Removed duplicated region for block: B:15:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String b(android.content.Context r9, org.repackage.com.meizu.flyme.openidsdk.OpenId r10) {
        /*
            r8 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "queryId : "
            r0.<init>(r1)
            java.lang.String r1 = r10.f51586c
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            a(r0)
            java.lang.String r0 = "content://com.meizu.flyme.openidsdk/"
            android.net.Uri r2 = android.net.Uri.parse(r0)
            r7 = 0
            android.content.ContentResolver r1 = r9.getContentResolver()     // Catch: java.lang.Throwable -> L9e java.lang.Exception -> La1
            java.lang.String r0 = r10.f51586c     // Catch: java.lang.Throwable -> L9e java.lang.Exception -> La1
            java.lang.String[] r5 = new java.lang.String[]{r0}     // Catch: java.lang.Throwable -> L9e java.lang.Exception -> La1
            r6 = 0
            r3 = 0
            r4 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L9e java.lang.Exception -> La1
            r0 = 1
            r2 = 0
            if (r1 == 0) goto L87
            org.repackage.com.meizu.flyme.openidsdk.ValueData r3 = a(r1)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L82
            java.lang.String r7 = r3.f51592a     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L82
            r10.a(r7)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L82
            long r4 = r3.f51594c     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L82
            r10.a(r4)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L82
            int r4 = r3.f51593b     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L82
            r10.a(r4)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L82
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L82
            r4.<init>()     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L82
            java.lang.String r5 = r10.f51586c     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L82
            r4.append(r5)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L82
            java.lang.String r5 = " errorCode : "
            r4.append(r5)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L82
            int r10 = r10.f51587d     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L82
            r4.append(r10)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L82
            java.lang.String r10 = r4.toString()     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L82
            a(r10)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L82
            int r10 = r3.f51593b     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L82
            r3 = 1000(0x3e8, float:1.401E-42)
            if (r10 == r3) goto L98
            r8.b(r9)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L82
            boolean r10 = r8.a(r9, r2)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L82
            if (r10 != 0) goto L98
            boolean r9 = r8.a(r9, r0)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L82
            java.lang.String r10 = "not support, forceQuery isSupported: "
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L82
        L76:
            java.lang.String r9 = r10.concat(r9)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L82
            a(r9)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L82
            goto L98
        L7e:
            r0 = move-exception
            r9 = r0
            r7 = r1
            goto Lbf
        L82:
            r0 = move-exception
            r9 = r0
            r10 = r7
            r7 = r1
            goto La4
        L87:
            boolean r10 = r8.a(r9, r2)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L82
            if (r10 == 0) goto L98
            boolean r9 = r8.a(r9, r0)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L82
            java.lang.String r10 = "forceQuery isSupported : "
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L82
            goto L76
        L98:
            if (r1 == 0) goto L9d
            r1.close()
        L9d:
            return r7
        L9e:
            r0 = move-exception
            r9 = r0
            goto Lbf
        La1:
            r0 = move-exception
            r9 = r0
            r10 = r7
        La4:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9e
            java.lang.String r1 = "queryId, Exception : "
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L9e
            java.lang.String r9 = r9.getMessage()     // Catch: java.lang.Throwable -> L9e
            r0.append(r9)     // Catch: java.lang.Throwable -> L9e
            java.lang.String r9 = r0.toString()     // Catch: java.lang.Throwable -> L9e
            a(r9)     // Catch: java.lang.Throwable -> L9e
            if (r7 == 0) goto Lbe
            r7.close()
        Lbe:
            return r10
        Lbf:
            if (r7 == 0) goto Lc4
            r7.close()
        Lc4:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.repackage.com.meizu.flyme.openidsdk.b.b(android.content.Context, org.repackage.com.meizu.flyme.openidsdk.OpenId):java.lang.String");
    }

    final String a(Context context, OpenId openId) {
        String str;
        if (openId == null) {
            str = "getId, openId = null.";
        } else {
            if (openId.a()) {
                return openId.f51585b;
            }
            if (a(context, true)) {
                return b(context, openId);
            }
            str = "getId, isSupported = false.";
        }
        a(str);
        return null;
    }

    private static String a(PackageManager packageManager, String str) {
        ProviderInfo resolveContentProvider;
        if (packageManager == null || (resolveContentProvider = packageManager.resolveContentProvider(str, 0)) == null || (resolveContentProvider.applicationInfo.flags & 1) == 0) {
            return null;
        }
        return resolveContentProvider.packageName;
    }

    private static String b(PackageManager packageManager, String str) {
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
            return null;
        } catch (Exception e6) {
            e6.printStackTrace();
            a("getAppVersion, Exception : " + e6.getMessage());
            return null;
        }
    }

    private b() {
    }

    private static ValueData a(Cursor cursor) {
        ValueData valueData = new ValueData(null, 0);
        if (cursor == null) {
            a("parseValue fail, cursor is null.");
            return valueData;
        }
        if (cursor.isClosed()) {
            a("parseValue fail, cursor is closed.");
            return valueData;
        }
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex("value");
        if (columnIndex >= 0) {
            valueData.f51592a = cursor.getString(columnIndex);
        } else {
            a("parseValue fail, index < 0.");
        }
        int columnIndex2 = cursor.getColumnIndex("code");
        if (columnIndex2 >= 0) {
            valueData.f51593b = cursor.getInt(columnIndex2);
        } else {
            a("parseCode fail, index < 0.");
        }
        int columnIndex3 = cursor.getColumnIndex("expired");
        if (columnIndex3 >= 0) {
            valueData.f51594c = cursor.getLong(columnIndex3);
            return valueData;
        }
        a("parseExpired fail, index < 0.");
        return valueData;
    }

    private synchronized void b(Context context) {
        if (this.f51602h != null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE");
        a aVar = new a();
        this.f51602h = aVar;
        context.registerReceiver(aVar, intentFilter, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", null);
    }

    public static final b a() {
        if (f51595e == null) {
            synchronized (b.class) {
                try {
                    if (f51595e == null) {
                        f51595e = new b();
                    }
                } finally {
                }
            }
        }
        return f51595e;
    }

    static void a(String str) {
    }

    public static void a(boolean z5) {
        f51596f = z5;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0040, code lost:
    
        if (r8 != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0042, code lost:
    
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005e, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005b, code lost:
    
        if (r8 == null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0032, code lost:
    
        if ("0".equals(r9.f51592a) != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(android.content.Context r9) {
        /*
            java.lang.String r0 = "querySupport version : 1.0.8"
            a(r0)
            java.lang.String r0 = "content://com.meizu.flyme.openidsdk/"
            android.net.Uri r2 = android.net.Uri.parse(r0)
            r7 = 0
            r8 = 0
            android.content.ContentResolver r1 = r9.getContentResolver()     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L38
            java.lang.String r9 = "supported"
            java.lang.String[] r5 = new java.lang.String[]{r9}     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L38
            r6 = 0
            r3 = 0
            r4 = 0
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L38
            if (r8 == 0) goto L40
            org.repackage.com.meizu.flyme.openidsdk.ValueData r9 = a(r8)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L38
            int r0 = r9.f51593b     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L38
            r1 = 1000(0x3e8, float:1.401E-42)
            if (r1 != r0) goto L3b
            java.lang.String r0 = "0"
            java.lang.String r9 = r9.f51592a     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L38
            boolean r9 = r0.equals(r9)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L38
            if (r9 == 0) goto L3c
            goto L3b
        L35:
            r0 = move-exception
            r9 = r0
            goto L5f
        L38:
            r0 = move-exception
            r9 = r0
            goto L46
        L3b:
            r7 = 1
        L3c:
            r8.close()
            return r7
        L40:
            if (r8 == 0) goto L5e
        L42:
            r8.close()
            goto L5e
        L46:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L35
            java.lang.String r1 = "querySupport, Exception : "
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L35
            java.lang.String r9 = r9.getMessage()     // Catch: java.lang.Throwable -> L35
            r0.append(r9)     // Catch: java.lang.Throwable -> L35
            java.lang.String r9 = r0.toString()     // Catch: java.lang.Throwable -> L35
            a(r9)     // Catch: java.lang.Throwable -> L35
            if (r8 == 0) goto L5e
            goto L42
        L5e:
            return r7
        L5f:
            if (r8 == 0) goto L64
            r8.close()
        L64:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.repackage.com.meizu.flyme.openidsdk.b.a(android.content.Context):boolean");
    }

    final boolean a(Context context, boolean z5) {
        if (this.f51601g.a() && !z5) {
            return this.f51601g.b();
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        String a6 = a(packageManager, "com.meizu.flyme.openidsdk");
        if (TextUtils.isEmpty(a6)) {
            return false;
        }
        String b6 = b(packageManager, a6);
        if (this.f51601g.a() && this.f51601g.a(b6)) {
            a("use same version cache, safeVersion : ".concat(String.valueOf(b6)));
            return this.f51601g.b();
        }
        this.f51601g.b(b6);
        boolean a7 = a(context);
        a("query support, result : ".concat(String.valueOf(a7)));
        this.f51601g.a(a7);
        return a7;
    }
}
