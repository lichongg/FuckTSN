package com.bytedance.sdk.component.j;

import java.lang.reflect.Type;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
class tl {

    /* renamed from: j, reason: collision with root package name */
    private vl f26508j;

    static tl j(vl vlVar) {
        return new tl(vlVar);
    }

    <T> T j(String str, Type type) throws JSONException {
        j(str);
        return (type.equals(JSONObject.class) || ((type instanceof Class) && JSONObject.class.isAssignableFrom((Class) type))) ? (T) new JSONObject(str) : (T) this.f26508j.j(str, type);
    }

    private tl(vl vlVar) {
        this.f26508j = vlVar;
    }

    <T> String j(T t5) {
        String obj;
        if (t5 == null) {
            return "{}";
        }
        if (!(t5 instanceof JSONObject) && !(t5 instanceof JSONArray)) {
            obj = this.f26508j.j(t5);
        } else {
            obj = t5.toString();
        }
        j(obj);
        return obj;
    }

    private static void j(String str) {
        if (str.startsWith("{") && str.endsWith("}")) {
            return;
        }
        g.j(new IllegalArgumentException("Param is not allowed to be List or JSONArray, rawString:\n ".concat(str)));
    }
}
