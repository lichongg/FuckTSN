package cn.bluemobi.dylan.base.utils;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    private Context f1243a;

    /* renamed from: b, reason: collision with root package name */
    private String f1244b;

    public r(String str) {
        this.f1244b = str;
    }

    public void a() {
        SharedPreferences.Editor edit = this.f1243a.getSharedPreferences(this.f1244b, 0).edit();
        edit.clear();
        edit.commit();
    }

    public void c(String str) {
        SharedPreferences.Editor edit = this.f1243a.getSharedPreferences(this.f1244b, 0).edit();
        edit.remove(str);
        edit.commit();
    }

    public r(Context context) {
        this.f1244b = "share_date";
        this.f1243a = context;
    }

    public Object b(String str, Object obj) {
        String simpleName = obj.getClass().getSimpleName();
        SharedPreferences sharedPreferences = this.f1243a.getSharedPreferences(this.f1244b, 0);
        if ("String".equals(simpleName)) {
            return sharedPreferences.getString(str, (String) obj);
        }
        if ("Integer".equals(simpleName)) {
            return Integer.valueOf(sharedPreferences.getInt(str, ((Integer) obj).intValue()));
        }
        if ("Boolean".equals(simpleName)) {
            return Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) obj).booleanValue()));
        }
        if ("Float".equals(simpleName)) {
            return Float.valueOf(sharedPreferences.getFloat(str, ((Float) obj).floatValue()));
        }
        if ("Long".equals(simpleName)) {
            return Long.valueOf(sharedPreferences.getLong(str, ((Long) obj).longValue()));
        }
        return null;
    }

    public void d(String str, Object obj) {
        String simpleName = obj.getClass().getSimpleName();
        SharedPreferences.Editor edit = this.f1243a.getSharedPreferences(this.f1244b, 0).edit();
        if ("String".equals(simpleName)) {
            edit.putString(str, obj.toString());
        } else if ("Integer".equals(simpleName)) {
            edit.putInt(str, ((Integer) obj).intValue());
        } else if ("Boolean".equals(simpleName)) {
            edit.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if ("Float".equals(simpleName)) {
            edit.putFloat(str, ((Float) obj).floatValue());
        } else if ("Long".equals(simpleName)) {
            edit.putLong(str, ((Long) obj).longValue());
        }
        edit.commit();
    }
}
