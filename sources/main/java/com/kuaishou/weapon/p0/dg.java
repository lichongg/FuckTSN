package com.kuaishou.weapon.p0;

import android.text.TextUtils;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class dg {
    public JSONArray a(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            if (TextUtils.isEmpty(string) || string.length() <= 2) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(string);
            HashSet hashSet = new HashSet();
            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                hashSet.add((String) jSONArray.get(i6));
            }
            if (hashSet.size() > 0) {
                return new JSONArray((Collection) hashSet);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONArray b(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(string);
            HashSet hashSet = new HashSet();
            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                String str2 = (String) jSONArray.get(i6);
                if (str2.contains("frida")) {
                    hashSet.add(str2);
                }
            }
            if (hashSet.size() > 0) {
                return new JSONArray((Collection) hashSet);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONArray c(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(string);
            HashSet hashSet = new HashSet();
            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                String str2 = (String) jSONArray.get(i6);
                if (str2.contains("substrate") || str2.contains(".jar") || str2.contains("xposed")) {
                    hashSet.add(str2);
                }
            }
            if (hashSet.size() > 0) {
                return new JSONArray((Collection) hashSet);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONArray a(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray != null) {
            if (jSONArray.length() > 0 && jSONArray2 != null && jSONArray2.length() > 0) {
                Set a6 = dl.a(jSONArray);
                Set a7 = dl.a(jSONArray2);
                if (a6 != null && a7 != null) {
                    a6.removeAll(a7);
                    if (a6.size() > 0) {
                        return new JSONArray((Collection) a6);
                    }
                    return null;
                }
            }
        }
        return jSONArray;
    }
}
