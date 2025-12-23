package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class au {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f35744a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f35745b;

    public String a(String str) {
        JSONObject jSONObject = this.f35744a;
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getString(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public List b(String str) {
        JSONObject jSONObject = this.f35744a;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            if (TextUtils.isEmpty(string) || string.length() <= 3) {
                return null;
            }
            String a6 = i.a("98bb0a15913e0654348b", "0805");
            JSONArray jSONArray = new JSONArray(string);
            ArrayList arrayList = new ArrayList();
            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                String string2 = jSONArray.getString(i6);
                if (string2.contains(a6)) {
                    this.f35745b = true;
                } else {
                    arrayList.add(string2);
                }
            }
            if (arrayList.size() > 0) {
                return arrayList;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public au(Context context) {
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(ck.f35874g).intValue(), 0, 200, "");
                if (!TextUtils.isEmpty(pqr)) {
                    this.f35744a = new JSONObject(pqr);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public boolean a() {
        return this.f35745b;
    }
}
