package com.bytedance.sdk.openadsdk.core.multipro.j;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.multipro.up;
import com.bytedance.sdk.openadsdk.core.v;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {
    private static ContentResolver j(Context context) {
        if (context == null) {
            try {
                context = v.getContext();
            } catch (Throwable unused) {
                return null;
            }
        }
        return context.getContentResolver();
    }

    public static int update(Context context, String str, ContentValues contentValues, String str2, String[] strArr) {
        if (contentValues != null && !TextUtils.isEmpty(str)) {
            try {
                ContentResolver j6 = j(context);
                if (j6 != null) {
                    return j6.update(Uri.parse(j() + str), contentValues, str2, strArr);
                }
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    public static void insert(Context context, String str, ContentValues contentValues) {
        if (contentValues == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ContentResolver j6 = j(context);
            if (j6 != null) {
                j6.insert(Uri.parse(j() + str), contentValues);
            }
        } catch (Throwable unused) {
        }
    }

    public static int delete(Context context, String str, String str2, String[] strArr) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            ContentResolver j6 = j(context);
            if (j6 != null) {
                return j6.delete(Uri.parse(j() + str), str2, strArr);
            }
        } catch (Throwable unused) {
        }
        return 0;
    }

    private static String j() {
        return up.xt + "/t_db/ttopensdk.db/";
    }

    public static Cursor query(Context context, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            ContentResolver j6 = j(context);
            if (j6 != null) {
                return j6.query(Uri.parse(j() + str), strArr, str2, strArr2, str5);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static void j(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ContentResolver j6 = j(context);
            if (j6 != null) {
                j6.getType(Uri.parse(j() + "unknown/execSQL?sql=" + Uri.encode(str)));
            }
        } catch (Throwable unused) {
        }
    }
}
