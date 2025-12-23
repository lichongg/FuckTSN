package com.bytedance.sdk.component.tl.xt.xt.xt;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.tl.j.ae;
import com.bytedance.sdk.component.tl.j.g;
import com.bytedance.sdk.component.tl.j.up;
import com.bytedance.sdk.component.tl.xt.j.j.cw;
import com.bytedance.sdk.component.tl.xt.j.j.r;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {
    private up cw;

    /* renamed from: j, reason: collision with root package name */
    private String f26846j;

    /* renamed from: r, reason: collision with root package name */
    private g f26847r;
    private Context xt;

    private g cw() {
        if (this.f26847r == null) {
            this.f26847r = com.bytedance.sdk.component.tl.xt.j.cw(this.f26846j).r();
        }
        return this.f26847r;
    }

    public static void j(up upVar) {
        if (upVar == null) {
            return;
        }
        try {
            ContentResolver xt = xt(upVar);
            if (xt != null) {
                xt.getType(Uri.parse(cw(upVar) + "adLogStart"));
            }
        } catch (Throwable unused) {
        }
    }

    private up xt() {
        if (this.cw == null) {
            this.cw = com.bytedance.sdk.component.tl.xt.j.cw(this.f26846j).cw();
        }
        return this.cw;
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

    public j(String str) {
        this.f26846j = str;
        ae cw = com.bytedance.sdk.component.tl.xt.j.cw(str);
        this.cw = cw.cw();
        this.f26847r = cw.r();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x004b, code lost:
    
        if (r2.equals("adLogStop") == false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String getType(android.net.Uri r13) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.tl.xt.xt.xt.j.getType(android.net.Uri):java.lang.String");
    }

    private static String cw(up upVar) {
        String j6 = r.j(upVar);
        StringBuilder sb = new StringBuilder();
        sb.append(j6);
        sb.append("/");
        sb.append("csj_mediation".equals(upVar.up()) ? "gromore_ad_log_event" : "ad_log_event");
        sb.append("/");
        return sb.toString();
    }

    public static void j(com.bytedance.sdk.component.tl.j.xt xtVar, up upVar) {
        if (xtVar == null) {
            return;
        }
        try {
            ContentResolver xt = xt(upVar);
            if (xt != null) {
                xt.getType(Uri.parse(cw(upVar) + "adLogDispatch?event=" + cw.j(xtVar.m())));
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.tl.xt.cw.cw.cw("dispatch event Throwable:" + th.toString(), upVar);
        }
    }

    private static ContentResolver xt(up upVar) {
        try {
            if (upVar.getContext() != null) {
                return upVar.getContext().getContentResolver();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void j(String str, List<String> list, boolean z5, up upVar, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
            return;
        }
        try {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                sb.append(cw.j(it.next()));
                sb.append(",");
            }
            String j6 = cw.j(sb.toString());
            String str2 = "?did=" + String.valueOf(str) + "&track=" + String.valueOf(j6) + "&replace=" + String.valueOf(z5) + "&extraMate=" + cw.j(jSONObject.toString());
            ContentResolver xt = xt(upVar);
            if (xt != null) {
                xt.getType(Uri.parse(cw(upVar) + "trackAdUrl" + str2));
            }
        } catch (Throwable unused) {
        }
    }

    public static void j(String str, up upVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ContentResolver xt = xt(upVar);
            if (xt != null) {
                xt.getType(Uri.parse(cw(upVar) + "trackAdFailed?did=" + String.valueOf(str)));
            }
        } catch (Throwable unused) {
        }
    }

    public void j(Context context) {
        this.xt = context;
    }

    public String j() {
        return "csj_mediation".equals(this.f26846j) ? "gromore_ad_log_event" : "ad_log_event";
    }
}
