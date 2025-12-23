package com.bytedance.embedapplog;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class ri {

    /* renamed from: j, reason: collision with root package name */
    private static String f24041j = ":push";

    public static boolean j(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static boolean xt() {
        ae h6;
        tl vl = j.vl();
        if (vl == null || (h6 = vl.h()) == null) {
            return false;
        }
        return h6.cw();
    }

    public static boolean j(JSONObject jSONObject, JSONObject jSONObject2) {
        return (jSONObject == null || jSONObject2 == null) ? j((Object) jSONObject, (Object) jSONObject2) : jSONObject.toString().equals(jSONObject2.toString());
    }

    public static String cw() {
        ae h6;
        tl vl = j.vl();
        if (vl != null && (h6 = vl.h()) != null) {
            return h6.xt();
        }
        return "";
    }

    public static boolean r() {
        ae h6;
        tl vl = j.vl();
        if (vl != null && (h6 = vl.h()) != null) {
            return h6.r();
        }
        return false;
    }

    public static String j(Context context) {
        ae h6;
        tl vl = j.vl();
        if (vl != null && (h6 = vl.h()) != null) {
            return h6.j(context);
        }
        return "";
    }

    public static Looper xt(rn rnVar) {
        tl hh;
        ae h6;
        if (rnVar == null || (hh = rnVar.hh()) == null || (h6 = hh.h()) == null) {
            return null;
        }
        return h6.m();
    }

    public static boolean xt(Context context) {
        String j6 = j(context);
        return j6 != null && j6.endsWith(f24041j);
    }

    public static boolean j() {
        tl vl = j.vl();
        if (vl != null) {
            return vl.s();
        }
        return true;
    }

    public static JSONObject xt(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject.put(next, jSONObject2.opt(next));
            }
            return jSONObject;
        } catch (JSONException e6) {
            uc.xt(e6);
            return jSONObject;
        }
    }

    public static JSONObject j(JSONObject jSONObject) {
        ae h6;
        tl vl = j.vl();
        return (vl == null || (h6 = vl.h()) == null) ? jSONObject : h6.j(jSONObject);
    }

    public static Looper j(rn rnVar) {
        tl hh;
        ae h6;
        if (rnVar == null || (hh = rnVar.hh()) == null || (h6 = hh.h()) == null) {
            return null;
        }
        return h6.up();
    }

    public static JSONObject xt(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        xt(jSONObject2, jSONObject);
        try {
            String j6 = wo.j(jSONObject2.optJSONObject("oaid"));
            if (!TextUtils.isEmpty(j6)) {
                jSONObject2.put("oaid", j6);
            }
        } catch (Exception e6) {
            uc.xt(e6);
        }
        return jSONObject2;
    }

    public static String j(String str, HashMap<String, String> hashMap, String str2) {
        StringBuilder sb = new StringBuilder(str);
        for (String str3 : hashMap.keySet()) {
            String j6 = j(str3, str2);
            String str4 = hashMap.get(str3);
            String j7 = str4 != null ? j(str4, str2) : "";
            if (sb.length() > 0) {
                sb.append(ContainerUtils.FIELD_DELIMITER);
            }
            sb.append(j6);
            sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb.append(j7);
        }
        return sb.toString();
    }

    private static String j(String str, String str2) {
        if (str2 == null) {
            str2 = org.apache.commons.net.ftp.b.T;
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public static void j(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Throwable th) {
                uc.j(th);
            }
        }
    }

    public static void j(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.endTransaction();
            } catch (Throwable th) {
                uc.xt(th);
            }
        }
    }

    public static String j(String str) {
        ae h6;
        tl vl = j.vl();
        if (vl != null && (h6 = vl.h()) != null) {
            return h6.j(str);
        }
        return "";
    }
}
