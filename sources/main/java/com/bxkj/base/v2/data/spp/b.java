package com.bxkj.base.v2.data.spp;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class b {
    public static boolean b(Context context, String str, String str2) {
        return c(context, str, str2, false);
    }

    public static int f(Context context, String str, String str2) {
        return g(context, str, str2, -1);
    }

    private static Uri a(Context context, int i6, String str, String str2, Object obj) {
        String j6 = c.j(context, PreferencesProvider.f17022k, PreferencesProvider.f17021j);
        switch (i6) {
            case 100:
                return Uri.parse("content://" + j6 + "/string/" + str + "/" + str2 + "/" + obj);
            case 101:
                return Uri.parse("content://" + j6 + "/integer/" + str + "/" + str2 + "/" + obj);
            case 102:
                return Uri.parse("content://" + j6 + "/long/" + str + "/" + str2 + "/" + obj);
            case 103:
            default:
                return null;
            case 104:
                return Uri.parse("content://" + j6 + "/float/" + str + "/" + str2 + "/" + obj);
            case 105:
                return Uri.parse("content://" + j6 + "/boolean/" + str + "/" + str2 + "/" + obj);
            case 106:
                return Uri.parse("content://" + j6 + "/delete/" + str + "/" + str2);
            case 107:
                return Uri.parse("content://" + j6 + "/puts");
        }
    }

    public static boolean c(Context context, String str, String str2, boolean z5) {
        Cursor query = context.getContentResolver().query(a(context, 105, str, str2, Boolean.valueOf(z5)), null, null, null, null);
        return (query != null && query.moveToNext()) ? Boolean.valueOf(query.getString(query.getColumnIndex(PreferencesProvider.f17020i))).booleanValue() : z5;
    }

    public static float d(Context context, String str, String str2) {
        return e(context, str, str2, -1.0f);
    }

    public static float e(Context context, String str, String str2, float f6) {
        Cursor query = context.getContentResolver().query(a(context, 104, str, str2, Float.valueOf(f6)), null, null, null, null);
        return (query != null && query.moveToNext()) ? query.getFloat(query.getColumnIndex(PreferencesProvider.f17020i)) : f6;
    }

    public static int g(Context context, String str, String str2, int i6) {
        Cursor query = context.getContentResolver().query(a(context, 101, str, str2, Integer.valueOf(i6)), null, null, null, null);
        return (query != null && query.moveToNext()) ? query.getInt(query.getColumnIndex(PreferencesProvider.f17020i)) : i6;
    }

    public static long h(Context context, String str, String str2) {
        return i(context, str, str2, -1L);
    }

    public static long i(Context context, String str, String str2, long j6) {
        Cursor query = context.getContentResolver().query(a(context, 102, str, str2, Long.valueOf(j6)), null, null, null, null);
        return (query != null && query.moveToNext()) ? query.getLong(query.getColumnIndex(PreferencesProvider.f17020i)) : j6;
    }

    public static String j(Context context, String str, String str2) {
        return k(context, str, str2, "");
    }

    public static String k(Context context, String str, String str2, String str3) {
        Cursor query = context.getContentResolver().query(a(context, 100, str, str2, str3), null, null, null, null);
        return (query != null && query.moveToNext()) ? query.getString(query.getColumnIndex(PreferencesProvider.f17020i)) : str3;
    }

    public static boolean l(Context context, String str, ContentValues contentValues) {
        try {
            context.getContentResolver().insert(a(context, 107, str, null, null), contentValues);
            return true;
        } catch (Exception e6) {
            e6.printStackTrace();
            return false;
        }
    }

    public static boolean m(Context context, String str, String str2, boolean z5) {
        Uri a6 = a(context, 105, str, str2, Boolean.valueOf(z5));
        ContentResolver contentResolver = context.getContentResolver();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(str2, Boolean.valueOf(z5));
            contentResolver.insert(a6, contentValues);
            return true;
        } catch (Exception e6) {
            e6.printStackTrace();
            return false;
        }
    }

    public static boolean n(Context context, String str, String str2, float f6) {
        Uri a6 = a(context, 104, str, str2, Float.valueOf(f6));
        ContentResolver contentResolver = context.getContentResolver();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(str2, Float.valueOf(f6));
            contentResolver.insert(a6, contentValues);
            return true;
        } catch (Exception e6) {
            e6.printStackTrace();
            return false;
        }
    }

    public static boolean o(Context context, String str, String str2, int i6) {
        Uri a6 = a(context, 101, str, str2, Integer.valueOf(i6));
        ContentResolver contentResolver = context.getContentResolver();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(str2, Integer.valueOf(i6));
            contentResolver.insert(a6, contentValues);
            return true;
        } catch (Exception e6) {
            e6.printStackTrace();
            return false;
        }
    }

    public static boolean p(Context context, String str, String str2, long j6) {
        Uri a6 = a(context, 102, str, str2, Long.valueOf(j6));
        ContentResolver contentResolver = context.getContentResolver();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(str2, Long.valueOf(j6));
            contentResolver.insert(a6, contentValues);
            return true;
        } catch (Exception e6) {
            e6.printStackTrace();
            return false;
        }
    }

    public static boolean q(Context context, String str, String str2, String str3) {
        Uri a6 = a(context, 100, str, str2, str3);
        ContentResolver contentResolver = context.getContentResolver();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(str2, str3);
            contentResolver.insert(a6, contentValues);
            return true;
        } catch (Exception e6) {
            e6.printStackTrace();
            return false;
        }
    }

    public static boolean r(Context context, String str, String str2) {
        try {
            context.getContentResolver().delete(a(context, 106, str, str2, null), null, null);
            return true;
        } catch (Exception e6) {
            e6.printStackTrace();
            return false;
        }
    }
}
