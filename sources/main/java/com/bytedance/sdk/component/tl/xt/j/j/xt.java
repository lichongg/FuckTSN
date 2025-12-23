package com.bytedance.sdk.component.tl.xt.j.j;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.tl.j.up;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {
    public static void insert(Context context, String str, ContentValues contentValues, up upVar) {
        if (contentValues == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            j.j(context).j().insert(upVar, str, (String) null, contentValues);
        } catch (Throwable unused) {
        }
    }

    public static int update(Context context, String str, ContentValues contentValues, String str2, String[] strArr, up upVar) {
        if (contentValues != null && !TextUtils.isEmpty(str)) {
            try {
                return j.j(context).j().update(upVar, str, contentValues, str2, strArr);
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    public static int delete(Context context, String str, String str2, String[] strArr, up upVar) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return j.j(context).j().delete(upVar, str, str2, strArr);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static void insert(Context context, String str, List<com.bytedance.sdk.component.tl.j.xt> list, up upVar) {
        if (list == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            j.j(context).j().insert(upVar, str, (String) null, list);
        } catch (Throwable unused) {
        }
    }

    public static String j(Context context, String str, up upVar) {
        if (TextUtils.isEmpty(str)) {
            return "sql is null";
        }
        try {
            j.j(context).j().j(upVar, Uri.decode(str));
            return "execSql ok";
        } catch (Throwable th) {
            return "exec sql exception:" + th.getMessage();
        }
    }

    public static Cursor query(Context context, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, up upVar) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return j.j(context).j().query(upVar, str, strArr, str2, strArr2, null, null, str5);
        } catch (Throwable unused) {
            return null;
        }
    }
}
