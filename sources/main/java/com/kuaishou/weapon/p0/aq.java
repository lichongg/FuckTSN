package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class aq {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f35738a;

    public String a(String str) {
        JSONObject jSONObject = this.f35738a;
        if (jSONObject != null) {
            try {
                return jSONObject.optString(str, null);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public Set b(String str) {
        JSONObject jSONObject = this.f35738a;
        if (jSONObject != null) {
            try {
                String optString = jSONObject.optString(str, null);
                if (!TextUtils.isEmpty(optString) && optString.length() > 3) {
                    HashSet hashSet = new HashSet();
                    JSONArray jSONArray = new JSONArray(optString);
                    for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                        Integer valueOf = Integer.valueOf((String) jSONArray.get(i6), 16);
                        valueOf.intValue();
                        hashSet.add(valueOf);
                    }
                    return hashSet;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public aq(Context context, int i6) {
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(ck.f35870c).intValue(), 3, i6, "");
                if (!TextUtils.isEmpty(pqr)) {
                    this.f35738a = new JSONObject(pqr);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
