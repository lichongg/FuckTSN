package com.acse.ottn;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class v1 {
    public static Map<String, String> b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            HashMap hashMap = new HashMap();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, (String) jSONObject.get(next));
            }
            return hashMap;
        } catch (Exception e6) {
            e6.printStackTrace();
            c2.a("JsonMapUtil", "getShowAdActivityPackageName samon--> Exception e =" + e6.getMessage());
            return null;
        }
    }

    public static List<Map<String, String>> a(String str) {
        Exception e6;
        ArrayList arrayList;
        try {
            JSONArray jSONArray = new JSONArray(str);
            arrayList = new ArrayList();
            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                try {
                    arrayList.add(b(jSONArray.getJSONObject(i6).toString()));
                } catch (Exception e7) {
                    e6 = e7;
                    e6.printStackTrace();
                    return arrayList;
                }
            }
            return arrayList;
        } catch (Exception e8) {
            e6 = e8;
            arrayList = null;
        }
    }
}
