package com.jg.ids.k;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.jg.ids.IdsHelper;

/* loaded from: D:\Downloads\app\classes10.dex */
public final class a extends com.jg.ids.a {

    /* renamed from: b, reason: collision with root package name */
    private String f35555b;

    /* renamed from: c, reason: collision with root package name */
    private ContentObserver f35556c;

    /* renamed from: d, reason: collision with root package name */
    private ContentObserver f35557d;

    /* renamed from: e, reason: collision with root package name */
    private ContentObserver f35558e;

    public a(Context context, String str) {
        super(context, "vivo_thread");
        this.f35556c = null;
        this.f35557d = null;
        this.f35558e = null;
        this.f35555b = str;
        try {
            this.f35556c = new b(this, null, str, 0);
            this.f35557d = new b(this, null, str, 1);
            this.f35558e = new b(this, null, str, 2);
            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, this.f35556c);
            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str), true, this.f35557d);
            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + str), true, this.f35558e);
        } catch (Throwable th) {
        }
    }

    @Override // com.jg.ids.f, com.jg.ids.i
    public final String a(Context context) {
        String a6 = super.a(context);
        if (TextUtils.isEmpty(a6)) {
            b(1, this.f35555b);
        }
        return a6;
    }

    @Override // com.jg.ids.f, com.jg.ids.i
    public final String b(Context context) {
        String str;
        try {
            Cursor query = context.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
            if (query == null) {
                return "";
            }
            if (!query.moveToNext()) {
                str = "";
            } else {
                str = query.getString(query.getColumnIndex("value"));
            }
            try {
                query.close();
                return str;
            } catch (Throwable th) {
                return str;
            }
        } catch (Throwable th2) {
            return "";
        }
    }

    @Override // com.jg.ids.f, com.jg.ids.i
    public final String c(Context context) {
        String c6 = super.c(context);
        if (TextUtils.isEmpty(c6)) {
            b(2, this.f35555b);
        }
        return c6;
    }

    @Override // com.jg.ids.a
    protected final void b() {
        b(1, this.f35555b);
        b(2, this.f35555b);
        b(0, this.f35555b);
    }

    @Override // com.jg.ids.a
    protected final void a(Message message) {
        if (message != null) {
            try {
                if (message.what == 0) {
                    int i6 = message.getData().getInt("type", -1);
                    a(i6, a(IdsHelper.CONTEXT, i6, message.getData().getString("appid", "")));
                }
            } catch (Throwable th) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i6, String str) {
        try {
            Message a6 = a();
            a6.what = 0;
            Bundle bundle = new Bundle();
            bundle.putInt("type", i6);
            bundle.putString("appid", str);
            a6.setData(bundle);
            b(a6);
        } catch (Throwable th) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(android.content.Context r8, int r9, java.lang.String r10) {
        /*
            r7 = 0
            java.lang.String r6 = ""
            switch(r9) {
                case 0: goto Lc;
                case 1: goto L13;
                case 2: goto L27;
                default: goto L6;
            }
        L6:
            r1 = r7
        L7:
            if (r1 != 0) goto L3b
            java.lang.String r0 = ""
        Lb:
            return r0
        Lc:
            java.lang.String r0 = "content://com.vivo.vms.IdProvider/IdentifierId/OAID"
            android.net.Uri r1 = android.net.Uri.parse(r0)     // Catch: java.lang.Throwable -> L60 java.lang.Throwable -> L69
            goto L7
        L13:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L60 java.lang.Throwable -> L69
            java.lang.String r1 = "content://com.vivo.vms.IdProvider/IdentifierId/VAID_"
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L60 java.lang.Throwable -> L69
            java.lang.StringBuilder r0 = r0.append(r10)     // Catch: java.lang.Throwable -> L60 java.lang.Throwable -> L69
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L60 java.lang.Throwable -> L69
            android.net.Uri r1 = android.net.Uri.parse(r0)     // Catch: java.lang.Throwable -> L60 java.lang.Throwable -> L69
            goto L7
        L27:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L60 java.lang.Throwable -> L69
            java.lang.String r1 = "content://com.vivo.vms.IdProvider/IdentifierId/AAID_"
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L60 java.lang.Throwable -> L69
            java.lang.StringBuilder r0 = r0.append(r10)     // Catch: java.lang.Throwable -> L60 java.lang.Throwable -> L69
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L60 java.lang.Throwable -> L69
            android.net.Uri r1 = android.net.Uri.parse(r0)     // Catch: java.lang.Throwable -> L60 java.lang.Throwable -> L69
            goto L7
        L3b:
            android.content.ContentResolver r0 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L60 java.lang.Throwable -> L69
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L60 java.lang.Throwable -> L69
            if (r1 == 0) goto L78
            boolean r0 = r1.moveToNext()     // Catch: java.lang.Throwable -> L70 java.lang.Throwable -> L73
            if (r0 == 0) goto L78
            java.lang.String r0 = "value"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L70 java.lang.Throwable -> L73
            java.lang.String r6 = r1.getString(r0)     // Catch: java.lang.Throwable -> L70 java.lang.Throwable -> L73
            r0 = r6
        L5a:
            if (r1 == 0) goto Lb
            r1.close()
            goto Lb
        L60:
            r0 = move-exception
            r0 = r7
        L62:
            if (r0 == 0) goto L76
            r0.close()
            r0 = r6
            goto Lb
        L69:
            r0 = move-exception
        L6a:
            if (r7 == 0) goto L6f
            r7.close()
        L6f:
            throw r0
        L70:
            r0 = move-exception
            r7 = r1
            goto L6a
        L73:
            r0 = move-exception
            r0 = r1
            goto L62
        L76:
            r0 = r6
            goto Lb
        L78:
            r0 = r6
            goto L5a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jg.ids.k.a.a(android.content.Context, int, java.lang.String):java.lang.String");
    }
}
