package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class as extends dg {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f35740a;

    public JSONObject a() {
        return this.f35740a;
    }

    public String a(String str) {
        JSONObject jSONObject = this.f35740a;
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getString(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public String b(String str) {
        JSONObject jSONObject = this.f35740a;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            return !TextUtils.isEmpty(string) ? string.replace(com.snail.antifake.deviceid.e.f37542d, "").replace("\t", " ") : string;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONArray c(String str) {
        JSONObject jSONObject = this.f35740a;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            if (TextUtils.isEmpty(string) || string.length() <= 3) {
                return null;
            }
            String replaceAll = string.replaceAll("\\n", "");
            if (!TextUtils.isEmpty(replaceAll)) {
                string = replaceAll;
            }
            JSONArray jSONArray = new JSONArray(string);
            if (jSONArray.length() > 1) {
                return jSONArray;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject d(String str) {
        JSONObject jSONObject = this.f35740a;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            if (TextUtils.isEmpty(string) || string.length() <= 2) {
                return null;
            }
            JSONObject jSONObject2 = new JSONObject(string);
            if (jSONObject2.length() > 1) {
                return jSONObject2;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public String e(String str) {
        JSONObject jSONObject = this.f35740a;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            if (string.length() > 2) {
                return string;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public as(Context context, int i6) {
        if (Engine.loadSuccess) {
            try {
                Engine engine = Engine.getInstance(context);
                int intValue = Integer.valueOf(ck.f35870c).intValue();
                String a6 = a(context);
                if (!TextUtils.isEmpty(a6)) {
                    String eopq = engine.eopq(intValue, 0, i6, a6);
                    if (!TextUtils.isEmpty(eopq)) {
                        this.f35740a = new JSONObject(eopq);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    private String a(Context context) {
        try {
            StringBuilder sb = new StringBuilder();
            h a6 = h.a(context, "re_po_rt");
            sb.append(a6.b(df.aa, 1));
            sb.append(a6.b(df.X, 1));
            sb.append(a6.b(df.V, 1));
            sb.append(a6.b(df.Z, 1));
            sb.append(a6.b(df.ab, 1));
            sb.append(a6.b(df.aj, 1));
            sb.append(a6.b(df.Y, 1));
            sb.append(a6.b(df.U, 1));
            sb.append(a6.b(df.am, 1));
            sb.append(a6.b(df.ak, 1));
            sb.append(a6.b(df.al, 1));
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }
}
