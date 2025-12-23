package com.bytedance.sdk.component.tl.xt.xt.xt;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.tl.j.g;
import com.bytedance.sdk.component.tl.j.up;
import com.bytedance.sdk.component.tl.xt.cw;
import com.bytedance.sdk.component.tl.xt.j.j.r;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {

    /* renamed from: j, reason: collision with root package name */
    public static cw f26848j;
    private up cw;

    /* renamed from: r, reason: collision with root package name */
    private g f26849r;
    private String xt;

    private up j() {
        if (this.cw == null) {
            this.cw = com.bytedance.sdk.component.tl.xt.j.cw(this.xt).cw();
        }
        return this.cw;
    }

    private g xt() {
        if (this.f26849r == null) {
            this.f26849r = com.bytedance.sdk.component.tl.xt.j.cw(this.xt).r();
        }
        return this.f26849r;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    private static String cw(up upVar) {
        return r.j(upVar) + "/ad_log_event/";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0042, code lost:
    
        if (r2.equals("adLogStop") == false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String getType(android.net.Uri r13) {
        /*
            r12 = this;
            r12.j()
            com.bytedance.sdk.component.tl.j.g r0 = r12.xt()
            r1 = 0
            if (r0 != 0) goto Lb
            return r1
        Lb:
            java.lang.String r2 = r13.getPath()
            java.lang.String r3 = "/"
            java.lang.String[] r2 = r2.split(r3)
            r3 = 2
            r2 = r2[r3]
            r2.getClass()
            int r4 = r2.hashCode()
            r5 = 0
            r6 = -1
            switch(r4) {
                case -482705237: goto L50;
                case -171493183: goto L45;
                case 964299715: goto L3c;
                case 1025736635: goto L31;
                case 1131732929: goto L26;
                default: goto L24;
            }
        L24:
            r3 = -1
            goto L5a
        L26:
            java.lang.String r3 = "trackAdUrl"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L2f
            goto L24
        L2f:
            r3 = 4
            goto L5a
        L31:
            java.lang.String r3 = "adLogDispatch"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L3a
            goto L24
        L3a:
            r3 = 3
            goto L5a
        L3c:
            java.lang.String r4 = "adLogStop"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L5a
            goto L24
        L45:
            java.lang.String r3 = "adLogStart"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L4e
            goto L24
        L4e:
            r3 = 1
            goto L5a
        L50:
            java.lang.String r3 = "trackAdFailed"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L59
            goto L24
        L59:
            r3 = 0
        L5a:
            java.lang.String r2 = "did"
            switch(r3) {
                case 0: goto Le1;
                case 1: goto Lda;
                case 2: goto Ld6;
                case 3: goto Lb5;
                case 4: goto L61;
                default: goto L5f;
            }
        L5f:
            goto Lf0
        L61:
            r12.j()
            java.lang.String r7 = r13.getQueryParameter(r2)     // Catch: java.lang.Throwable -> Lf0
            java.lang.String r0 = "replace"
            java.lang.String r0 = r13.getQueryParameter(r0)     // Catch: java.lang.Throwable -> Lf0
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch: java.lang.Throwable -> Lf0
            boolean r9 = r0.booleanValue()     // Catch: java.lang.Throwable -> Lf0
            java.lang.String r0 = "track"
            java.lang.String r13 = r13.getQueryParameter(r0)     // Catch: java.lang.Throwable -> Lf0
            java.lang.String r13 = com.bytedance.sdk.component.tl.xt.j.j.cw.xt(r13)     // Catch: java.lang.Throwable -> Lf0
            java.lang.String r0 = ","
            java.lang.String[] r13 = r13.split(r0)     // Catch: java.lang.Throwable -> Lf0
            int r0 = r13.length     // Catch: java.lang.Throwable -> Lf0
            if (r0 <= 0) goto Lf0
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lf0
            r8.<init>()     // Catch: java.lang.Throwable -> Lf0
            int r0 = r13.length     // Catch: java.lang.Throwable -> Lf0
        L8f:
            if (r5 >= r0) goto La3
            r2 = r13[r5]     // Catch: java.lang.Throwable -> Lf0
            java.lang.String r2 = com.bytedance.sdk.component.tl.xt.j.j.cw.xt(r2)     // Catch: java.lang.Throwable -> Lf0
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> Lf0
            if (r3 != 0) goto La0
            r8.add(r2)     // Catch: java.lang.Throwable -> Lf0
        La0:
            int r5 = r5 + 1
            goto L8f
        La3:
            com.bytedance.sdk.component.tl.j.up r13 = r12.j()     // Catch: java.lang.Throwable -> Lf0
            com.bytedance.sdk.component.tl.xt.m.xt r6 = com.bytedance.sdk.component.tl.xt.m.j.j(r13)     // Catch: java.lang.Throwable -> Lf0
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch: java.lang.Throwable -> Lf0
            r11.<init>()     // Catch: java.lang.Throwable -> Lf0
            r10 = 0
            r6.j(r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> Lf0
            goto Lf0
        Lb5:
            r12.j()
            java.lang.String r0 = "event"
            java.lang.String r13 = r13.getQueryParameter(r0)
            boolean r0 = android.text.TextUtils.isEmpty(r13)
            if (r0 != 0) goto Lf0
            java.lang.String r13 = com.bytedance.sdk.component.tl.xt.j.j.cw.xt(r13)
            com.bytedance.sdk.component.tl.j.xt r13 = com.bytedance.sdk.component.tl.xt.r.j.j.r(r13)
            if (r13 == 0) goto Lf0
            com.bytedance.sdk.component.tl.j.g r0 = r12.xt()
            r0.j(r13)
            goto Lf0
        Ld6:
            r12.j()
            goto Lf0
        Lda:
            r12.j()
            r0.j()
            goto Lf0
        Le1:
            java.lang.String r13 = r13.getQueryParameter(r2)
            com.bytedance.sdk.component.tl.j.up r0 = r12.j()
            com.bytedance.sdk.component.tl.xt.m.xt r0 = com.bytedance.sdk.component.tl.xt.m.j.j(r0)
            r0.j(r13)
        Lf0:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.tl.xt.xt.xt.xt.getType(android.net.Uri):java.lang.String");
    }

    public static cw j(up upVar) {
        try {
            if (f26848j == null) {
                f26848j = upVar.r().qv();
            }
        } catch (Exception unused) {
        }
        return f26848j;
    }

    public static void xt(up upVar) {
        if (upVar == null) {
            return;
        }
        try {
            cw j6 = j(upVar);
            if (j6 != null) {
                j6.getType(Uri.parse(cw(upVar) + "adLogStart"));
            }
        } catch (Throwable unused) {
        }
    }

    public static void j(com.bytedance.sdk.component.tl.j.xt xtVar, up upVar) {
        if (xtVar == null || upVar == null) {
            return;
        }
        try {
            cw j6 = j(upVar);
            if (j6 != null) {
                j6.getType(Uri.parse(cw(upVar) + "adLogDispatch?event=" + com.bytedance.sdk.component.tl.xt.j.j.cw.j(xtVar.m())));
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.tl.xt.cw.cw.cw("dispatch event Throwable:" + th.toString(), upVar);
        }
    }

    public static void j(String str, List<String> list, boolean z5, up upVar) {
        if (list == null || list.isEmpty() || upVar == null) {
            return;
        }
        try {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                sb.append(com.bytedance.sdk.component.tl.xt.j.j.cw.j(it.next()));
                sb.append(",");
            }
            String str2 = "?did=" + String.valueOf(str) + "&track=" + String.valueOf(com.bytedance.sdk.component.tl.xt.j.j.cw.j(sb.toString())) + "&replace=" + String.valueOf(z5);
            cw j6 = j(upVar);
            if (j6 != null) {
                j6.getType(Uri.parse(cw(upVar) + "trackAdUrl" + str2));
            }
        } catch (Throwable unused) {
        }
    }

    public static void j(String str, up upVar) {
        if (TextUtils.isEmpty(str) || upVar == null) {
            return;
        }
        try {
            cw j6 = j(upVar);
            if (j6 != null) {
                j6.getType(Uri.parse(cw(upVar) + "trackAdFailed?did=" + String.valueOf(str)));
            }
        } catch (Throwable unused) {
        }
    }
}
