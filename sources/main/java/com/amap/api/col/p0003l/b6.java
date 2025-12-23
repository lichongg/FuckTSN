package com.amap.api.col.p0003l;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.p0003l.p4;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class b6 {

    /* renamed from: a, reason: collision with root package name */
    private p4 f5721a;

    private static p4 a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            String optString = jSONObject.optString("a");
            String optString2 = jSONObject.optString("b");
            String optString3 = jSONObject.optString("c");
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("d");
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                arrayList.add(optJSONArray.getString(i6));
            }
            return new p4.a(optString, optString2, optString).a(optString3).b((String[]) arrayList.toArray(new String[0])).c();
        } catch (Throwable unused) {
            return null;
        }
    }

    public final List<p4> b(Context context) {
        p4 p4Var;
        try {
            JSONArray jSONArray = new JSONArray(a6.a(context, this.f5721a, "rbck"));
            if (jSONArray.length() == 0) {
                return new ArrayList();
            }
            ArrayList arrayList = new ArrayList();
            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                try {
                    p4Var = a(jSONArray.getJSONObject(i6));
                } catch (JSONException unused) {
                    p4Var = null;
                }
                if (p4Var != null) {
                    arrayList.add(p4Var);
                }
            }
            return arrayList;
        } catch (JSONException unused2) {
            return new ArrayList();
        }
    }

    public final void c(Context context, p4 p4Var) {
        JSONArray jSONArray;
        if (p4Var == null) {
            return;
        }
        ArrayList<p4> arrayList = new ArrayList();
        arrayList.add(p4Var);
        if (arrayList.size() == 0) {
            jSONArray = new JSONArray();
        } else {
            jSONArray = new JSONArray();
            for (p4 p4Var2 : arrayList) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("a", p4Var2.a());
                    jSONObject.put("b", p4Var2.e());
                    jSONObject.put("c", p4Var2.f());
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i6 = 0; p4Var2.i() != null && i6 < p4Var2.i().length; i6++) {
                        jSONArray2.put(p4Var2.i()[i6]);
                    }
                    jSONObject.put("d", jSONArray2);
                } catch (JSONException e6) {
                    e6.printStackTrace();
                }
                jSONArray.put(jSONObject);
            }
        }
        String jSONArray3 = jSONArray.toString();
        if (TextUtils.isEmpty(jSONArray3)) {
            return;
        }
        a6.b(context, this.f5721a, "rbck", jSONArray3);
    }

    public b6(String str) {
        this.f5721a = null;
        try {
            this.f5721a = new p4.a(str, "1.0", "1.0.0").b(new String[]{"info"}).c();
        } catch (fk unused) {
        }
    }
}
