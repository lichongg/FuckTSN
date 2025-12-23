package com.bytedance.sdk.component.ae.cw.j;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {
    private static String cw() {
        return up.xt + "/t_sp/";
    }

    public static boolean j() {
        return com.bytedance.sdk.component.ae.cw.getContext() != null;
    }

    private static ContentResolver xt() {
        try {
            if (j()) {
                return com.bytedance.sdk.component.ae.cw.getContext().getContentResolver();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String cw(String str) {
        return TextUtils.isEmpty(str) ? "" : "?sp_file_name=".concat(String.valueOf(str));
    }

    public static synchronized void j(String str, String str2, Boolean bool) {
        synchronized (xt.class) {
            if (j()) {
                try {
                    ContentResolver xt = xt();
                    if (xt != null) {
                        Uri parse = Uri.parse(cw("boolean", str2, str));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("value", bool);
                        xt.update(parse, contentValues, null, null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static Context getContext() {
        return com.bytedance.sdk.component.ae.cw.getContext();
    }

    public static String xt(String str, String str2, String str3) {
        String type;
        if (j()) {
            try {
                ContentResolver xt = xt();
                if (xt != null && (type = xt.getType(Uri.parse(cw(ResIdentify.RES_TYPE_STRING, str2, str)))) != null && !type.equals("null")) {
                    if (!TextUtils.isEmpty(type)) {
                        return type;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return str3;
    }

    private static String cw(String str, String str2, String str3) {
        return cw() + str + "/" + str2 + cw(str3);
    }

    @TargetApi(11)
    public static Set<String> xt(String str, String str2, Set<String> set) {
        String type;
        if (j()) {
            try {
                ContentResolver xt = xt();
                if (xt != null && (type = xt.getType(Uri.parse(cw("string_set", str2, str)))) != null && !type.equals("null") && !TextUtils.isEmpty(type) && type.matches("\\[.*\\]")) {
                    String substring = type.substring(1, type.length() - 1);
                    String[] split = substring.split(", ");
                    HashSet hashSet = new HashSet();
                    if (!TextUtils.isEmpty(substring)) {
                        for (String str3 : split) {
                            hashSet.add(str3.replace("__COMMA__", ", "));
                        }
                    }
                    return hashSet;
                }
            } catch (Throwable unused) {
            }
        }
        return set;
    }

    public static synchronized void j(String str, String str2, String str3) {
        synchronized (xt.class) {
            if (j()) {
                try {
                    ContentResolver xt = xt();
                    if (xt != null) {
                        Uri parse = Uri.parse(cw(ResIdentify.RES_TYPE_STRING, str2, str));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("value", str3);
                        xt.update(parse, contentValues, null, null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static synchronized void j(String str, String str2, Integer num) {
        synchronized (xt.class) {
            if (j()) {
                try {
                    ContentResolver xt = xt();
                    if (xt != null) {
                        Uri parse = Uri.parse(cw(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL, str2, str));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("value", num);
                        xt.update(parse, contentValues, null, null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static void xt(String str, String str2) {
        if (j()) {
            try {
                ContentResolver xt = xt();
                if (xt != null) {
                    xt.delete(Uri.parse(cw("long", str2, str)), null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.util.HashSet, java.util.Set] */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.lang.Float] */
    /* JADX WARN: Type inference failed for: r8v8, types: [java.lang.Long] */
    public static Map<String, ?> xt(String str) {
        Cursor cursor;
        String str2;
        if (!j()) {
            return null;
        }
        try {
            ContentResolver xt = xt();
            if (xt != null) {
                cursor = xt.query(Uri.parse(cw() + "get_all" + cw(str)), null, null, null, null);
                try {
                    HashMap hashMap = new HashMap();
                    if (cursor != null && cursor.moveToFirst()) {
                        int columnIndex = cursor.getColumnIndex("cursor_name");
                        int columnIndex2 = cursor.getColumnIndex("cursor_type");
                        int columnIndex3 = cursor.getColumnIndex("cursor_value");
                        do {
                            String string = cursor.getString(columnIndex);
                            String string2 = cursor.getString(columnIndex2);
                            if (string2.equalsIgnoreCase(ResIdentify.RES_TYPE_STRING)) {
                                String string3 = cursor.getString(columnIndex3);
                                boolean contains = string3.contains("__COMMA__");
                                str2 = string3;
                                if (contains) {
                                    boolean matches = string3.matches("\\[.*\\]");
                                    str2 = string3;
                                    if (matches) {
                                        String substring = string3.substring(1, string3.length() - 1);
                                        String[] split = substring.split(", ");
                                        ?? hashSet = new HashSet();
                                        if (!TextUtils.isEmpty(substring)) {
                                            for (String str3 : split) {
                                                hashSet.add(str3.replace("__COMMA__", ", "));
                                            }
                                        }
                                        str2 = hashSet;
                                    }
                                }
                            } else if (string2.equalsIgnoreCase("boolean")) {
                                str2 = cursor.getString(columnIndex3);
                            } else if (string2.equalsIgnoreCase(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL)) {
                                str2 = Integer.valueOf(cursor.getInt(columnIndex3));
                            } else if (string2.equalsIgnoreCase("long")) {
                                str2 = Long.valueOf(cursor.getLong(columnIndex3));
                            } else if (string2.equalsIgnoreCase("float")) {
                                str2 = Float.valueOf(cursor.getFloat(columnIndex3));
                            } else {
                                str2 = string2.equalsIgnoreCase("string_set") ? cursor.getString(columnIndex3) : null;
                            }
                            hashMap.put(string, str2);
                        } while (cursor.moveToNext());
                    }
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    return hashMap;
                } catch (Throwable unused) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    return null;
                }
            }
        } catch (Throwable unused2) {
            cursor = null;
        }
        return null;
    }

    public static synchronized void j(String str, String str2, Long l6) {
        synchronized (xt.class) {
            if (j()) {
                try {
                    ContentResolver xt = xt();
                    if (xt != null) {
                        Uri parse = Uri.parse(cw("long", str2, str));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("value", l6);
                        xt.update(parse, contentValues, null, null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static synchronized void j(String str, String str2, Float f6) {
        synchronized (xt.class) {
            if (j()) {
                try {
                    ContentResolver xt = xt();
                    if (xt != null) {
                        Uri parse = Uri.parse(cw("float", str2, str));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("value", f6);
                        xt.update(parse, contentValues, null, null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static synchronized void j(String str, String str2, Set<String> set) {
        synchronized (xt.class) {
            if (j()) {
                try {
                    ContentResolver xt = xt();
                    if (xt != null) {
                        Uri parse = Uri.parse(cw("string_set", str2, str));
                        ContentValues contentValues = new ContentValues();
                        HashSet hashSet = new HashSet();
                        Iterator<String> it = set.iterator();
                        while (it.hasNext()) {
                            hashSet.add(it.next().replace(",", "__COMMA__"));
                        }
                        contentValues.put("value", hashSet.toString());
                        xt.update(parse, contentValues, null, null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static int j(String str, String str2, int i6) {
        String type;
        if (j()) {
            try {
                ContentResolver xt = xt();
                if (xt != null && (type = xt.getType(Uri.parse(cw(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL, str2, str)))) != null && !type.equals("null") && !TextUtils.isEmpty(type)) {
                    return Integer.parseInt(type);
                }
            } catch (Throwable unused) {
            }
        }
        return i6;
    }

    public static float j(String str, String str2, float f6) {
        String type;
        if (j()) {
            try {
                ContentResolver xt = xt();
                if (xt != null && (type = xt.getType(Uri.parse(cw("float", str2, str)))) != null && !type.equals("null") && !TextUtils.isEmpty(type)) {
                    return Float.parseFloat(type);
                }
            } catch (Throwable unused) {
            }
        }
        return f6;
    }

    public static boolean j(String str, String str2, boolean z5) {
        String type;
        if (j()) {
            try {
                ContentResolver xt = xt();
                if (xt != null && (type = xt.getType(Uri.parse(cw("boolean", str2, str)))) != null && !type.equals("null") && !TextUtils.isEmpty(type)) {
                    return Boolean.parseBoolean(type);
                }
            } catch (Throwable unused) {
            }
        }
        return z5;
    }

    public static long j(String str, String str2, long j6) {
        String type;
        if (j()) {
            try {
                ContentResolver xt = xt();
                if (xt != null && (type = xt.getType(Uri.parse(cw("long", str2, str)))) != null && !type.equals("null") && !TextUtils.isEmpty(type)) {
                    return Long.parseLong(type);
                }
            } catch (Throwable unused) {
            }
        }
        return j6;
    }

    public static boolean j(String str, String str2) {
        String type;
        if (!j()) {
            return false;
        }
        try {
            ContentResolver xt = xt();
            if (xt != null && (type = xt.getType(Uri.parse(cw("contain", str2, str)))) != null && !type.equals("null") && !TextUtils.isEmpty(type)) {
                return Boolean.parseBoolean(type);
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static void j(String str) {
        if (j()) {
            try {
                ContentResolver xt = xt();
                if (xt != null) {
                    xt.delete(Uri.parse(cw() + "clean" + cw(str)), null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
