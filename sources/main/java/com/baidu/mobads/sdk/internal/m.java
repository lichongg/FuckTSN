package com.baidu.mobads.sdk.internal;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mobads.sdk.api.ArticleInfo;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class m {
    public static JSONArray a(double[] dArr) {
        JSONArray jSONArray = null;
        if (dArr != null) {
            try {
                JSONArray jSONArray2 = new JSONArray();
                for (double d6 : dArr) {
                    try {
                        jSONArray2.put(d6);
                    } catch (Exception e6) {
                        e = e6;
                        jSONArray = jSONArray2;
                        bu.a().a(e);
                        return jSONArray;
                    }
                }
                return jSONArray2;
            } catch (Exception e7) {
                e = e7;
            }
        }
        return jSONArray;
    }

    public static JSONArray a(List<String[]> list) {
        JSONArray jSONArray = new JSONArray();
        for (int i6 = 0; i6 < list.size(); i6++) {
            try {
                JSONArray jSONArray2 = new JSONArray();
                for (int i7 = 0; i7 < list.get(i6).length; i7++) {
                    jSONArray2.put(list.get(i6)[i7]);
                }
                jSONArray.put(jSONArray2);
            } catch (Exception e6) {
                bu.a().a(e6);
                return jSONArray;
            }
        }
        return jSONArray;
    }

    public static HashMap<String, String> a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.optString(next));
            }
            return hashMap;
        } catch (Exception unused) {
            bu.a().a("json2HashMap error");
            return hashMap;
        }
    }

    public static JSONObject a(HashMap<String, Object> hashMap) {
        if (hashMap != null && !hashMap.isEmpty()) {
            try {
                return new JSONObject(hashMap);
            } catch (Exception unused) {
                bu.a().a("hashMap2Json error");
            }
        }
        return null;
    }

    public static JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject2 != null && jSONObject2.length() > 0) {
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject.put(next, jSONObject2.opt(next));
            }
        }
        return jSONObject;
    }

    public static Object a(JSONObject jSONObject, String str) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return "";
        }
        return jSONObject.opt(str);
    }

    @TargetApi(8)
    public static Bitmap a(String str) {
        try {
            byte[] decode = Base64.decode(str, 0);
            return BitmapFactory.decodeByteArray(decode, 0, decode.length);
        } catch (Exception e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public static HashMap<String, String> a(Map<String, String> map) {
        int length;
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    HashMap hashMap = new HashMap(map);
                    HashMap<String, String> hashMap2 = new HashMap<>();
                    int i6 = 0;
                    for (String str : ArticleInfo.PREDEFINED_KEYS) {
                        if (hashMap.containsKey(str)) {
                            String str2 = (String) hashMap.remove(str);
                            if (!TextUtils.isEmpty(str2) && (length = str2.length() + i6) < 150) {
                                hashMap2.put(str, str2);
                                i6 = length;
                            }
                        }
                    }
                    if (!hashMap.isEmpty()) {
                        Set<String> keySet = hashMap.keySet();
                        JSONArray jSONArray = new JSONArray();
                        for (String str3 : keySet) {
                            if (!TextUtils.isEmpty(str3)) {
                                String str4 = (String) hashMap.get(str3);
                                if (!TextUtils.isEmpty(str4)) {
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("k", str3);
                                    jSONObject.put("v", str4);
                                    jSONArray.put(jSONObject);
                                }
                            }
                        }
                        if (jSONArray.length() > 0) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(SocializeProtocolConstants.PROTOCOL_KEY_EXTEND, jSONArray.toString());
                            if (jSONObject2.toString().length() < 3000) {
                                hashMap2.put(SocializeProtocolConstants.PROTOCOL_KEY_EXTEND, jSONObject2.toString());
                            }
                        }
                    }
                    return hashMap2;
                }
            } catch (Throwable unused) {
                return new HashMap<>();
            }
        }
        return new HashMap<>();
    }
}
