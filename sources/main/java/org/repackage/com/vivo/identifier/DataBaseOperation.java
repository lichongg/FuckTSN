package org.repackage.com.vivo.identifier;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DataBaseOperation {

    /* renamed from: a, reason: collision with root package name */
    private static final String f51622a = "VMS_SDK_DB";

    /* renamed from: b, reason: collision with root package name */
    private static final String f51623b = "content://com.vivo.vms.IdProvider/IdentifierId";

    /* renamed from: c, reason: collision with root package name */
    private static final String f51624c = "content://com.vivo.abe.exidentifier/guid";

    /* renamed from: d, reason: collision with root package name */
    private static final String f51625d = "value";

    /* renamed from: e, reason: collision with root package name */
    private static final String f51626e = "OAID";

    /* renamed from: f, reason: collision with root package name */
    private static final String f51627f = "AAID";

    /* renamed from: g, reason: collision with root package name */
    private static final String f51628g = "VAID";

    /* renamed from: h, reason: collision with root package name */
    private static final String f51629h = "OAIDBLACK";

    /* renamed from: i, reason: collision with root package name */
    private static final String f51630i = "OAIDSTATUS";

    /* renamed from: j, reason: collision with root package name */
    private static final String f51631j = "STATISTICS";

    /* renamed from: k, reason: collision with root package name */
    private static final int f51632k = 0;

    /* renamed from: l, reason: collision with root package name */
    private static final int f51633l = 1;

    /* renamed from: m, reason: collision with root package name */
    private static final int f51634m = 2;

    /* renamed from: n, reason: collision with root package name */
    private static final int f51635n = 3;

    /* renamed from: o, reason: collision with root package name */
    private static final int f51636o = 4;

    /* renamed from: p, reason: collision with root package name */
    private static final int f51637p = 5;

    /* renamed from: q, reason: collision with root package name */
    private static final int f51638q = 6;

    /* renamed from: r, reason: collision with root package name */
    private static final int f51639r = 7;

    /* renamed from: s, reason: collision with root package name */
    private static final String f51640s = "UDID";

    /* renamed from: t, reason: collision with root package name */
    private Context f51641t;

    boolean a(int i6, String str, ContentValues[] contentValuesArr) {
        Uri parse;
        if (i6 == 6) {
            parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAIDBLACK_" + str);
        } else if (i6 != 7) {
            parse = null;
        } else {
            parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/STATISTICS_" + str);
        }
        if (parse == null) {
            return false;
        }
        return this.f51641t.getContentResolver().bulkInsert(parse, contentValuesArr) != 0;
    }

    DataBaseOperation(Context context) {
        this.f51641t = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x006e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    java.lang.String a(int r9, java.lang.String r10) {
        /*
            r8 = this;
            r1 = 0
            if (r9 == 0) goto L65
            r0 = 1
            if (r9 == r0) goto L4f
            r0 = 2
            if (r9 == r0) goto L39
            r0 = 3
            if (r9 == r0) goto L32
            r0 = 4
            if (r9 == r0) goto L1c
            r10 = 5
            if (r9 == r10) goto L14
            r3 = r1
            goto L6c
        L14:
            java.lang.String r9 = "content://com.vivo.abe.exidentifier/guid"
            android.net.Uri r9 = android.net.Uri.parse(r9)
        L1a:
            r3 = r9
            goto L6c
        L1c:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "content://com.vivo.vms.IdProvider/IdentifierId/OAIDSTATUS_"
            r9.append(r0)
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            android.net.Uri r9 = android.net.Uri.parse(r9)
            goto L1a
        L32:
            java.lang.String r9 = "content://com.vivo.vms.IdProvider/IdentifierId/UDID"
            android.net.Uri r9 = android.net.Uri.parse(r9)
            goto L1a
        L39:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "content://com.vivo.vms.IdProvider/IdentifierId/AAID_"
            r9.append(r0)
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            android.net.Uri r9 = android.net.Uri.parse(r9)
            goto L1a
        L4f:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "content://com.vivo.vms.IdProvider/IdentifierId/VAID_"
            r9.append(r0)
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            android.net.Uri r9 = android.net.Uri.parse(r9)
            goto L1a
        L65:
            java.lang.String r9 = "content://com.vivo.vms.IdProvider/IdentifierId/OAID"
            android.net.Uri r9 = android.net.Uri.parse(r9)
            goto L1a
        L6c:
            if (r3 != 0) goto L6f
            return r1
        L6f:
            android.content.Context r9 = r8.f51641t     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9f
            android.content.ContentResolver r2 = r9.getContentResolver()     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9f
            r6 = 0
            r7 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r9 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9f
            if (r9 == 0) goto L96
            boolean r10 = r9.moveToNext()     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L94
            if (r10 == 0) goto L96
            java.lang.String r10 = "value"
            int r10 = r9.getColumnIndex(r10)     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L94
            java.lang.String r1 = r9.getString(r10)     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L94
            goto L96
        L90:
            r0 = move-exception
            r10 = r0
            r1 = r9
            goto La2
        L94:
            goto La8
        L96:
            if (r9 == 0) goto L9b
            r9.close()
        L9b:
            return r1
        L9c:
            r0 = move-exception
            r10 = r0
            goto La2
        L9f:
            r9 = r1
            goto La8
        La2:
            if (r1 == 0) goto La7
            r1.close()
        La7:
            throw r10
        La8:
            if (r9 == 0) goto Lad
            r9.close()
        Lad:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.repackage.com.vivo.identifier.DataBaseOperation.a(int, java.lang.String):java.lang.String");
    }

    boolean a(int i6, String str, String str2, String str3) {
        Uri parse;
        if (i6 != 6) {
            parse = null;
        } else {
            parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAIDBLACK_" + str);
        }
        if (parse == null) {
            return false;
        }
        return this.f51641t.getContentResolver().delete(parse, "packageName=? and uid=?", new String[]{str2, str3}) != 0;
    }
}
