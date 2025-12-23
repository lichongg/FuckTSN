package com.kwad.sdk.i;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class c {
    static void putValue(JSONObject jSONObject, String str, List<k> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    JSONArray jSONArray = new JSONArray();
                    Iterator<k> it = list.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next().toJson());
                    }
                    jSONObject.put(str, jSONArray);
                }
            } catch (Throwable unused) {
                j.Nn();
            }
        }
    }

    static void a(JSONObject jSONObject, String str, Object obj) {
        if (obj == null || jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject.put(str, obj);
        } catch (Throwable unused) {
            j.Nn();
        }
    }

    static void putValue(JSONObject jSONObject, String str, String str2) {
        try {
            jSONObject.put(str, str2);
        } catch (Throwable unused) {
            j.Nn();
        }
    }

    static void putValue(JSONObject jSONObject, String str, long j6) {
        try {
            jSONObject.put(str, j6);
        } catch (Throwable unused) {
            j.Nn();
        }
    }
}
