package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class cv {

    /* renamed from: a, reason: collision with root package name */
    public static String f35937a = "appkey";

    /* renamed from: b, reason: collision with root package name */
    public static String f35938b = "secretkey";

    /* renamed from: c, reason: collision with root package name */
    public static String f35939c = "pver";

    /* renamed from: d, reason: collision with root package name */
    public static String f35940d = "sdkver";

    /* renamed from: e, reason: collision with root package name */
    public static String f35941e = "ksid";

    /* renamed from: f, reason: collision with root package name */
    public static String f35942f = "timestamp";

    /* renamed from: g, reason: collision with root package name */
    public static String f35943g = "sign";

    public static String a(Map<String, String> map) {
        String str = "";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            str = str + ContainerUtils.FIELD_DELIMITER + entry.getKey() + ContainerUtils.KEY_VALUE_DELIMITER + entry.getValue();
        }
        return str.substring(1);
    }

    public static JSONObject b(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            a(context, jSONObject);
            jSONObject.put("sdkver", WeaponHI.sKSSdkver);
            jSONObject.put("pluginver", "5.3.9");
            jSONObject.put("device_id", cm.b(context));
            jSONObject.put("iv", "v1");
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONObject c(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("k", bt.a(context));
            jSONObject.put("hp", context.getPackageName());
            jSONObject.put("hv", bh.q(context));
            try {
                String b6 = h.a(context, "re_po_rt").b(df.f35996i, bq.f35804e);
                if (TextUtils.isEmpty(b6)) {
                    b6 = bq.f35804e;
                }
                jSONObject.put("pver", b6);
            } catch (Exception unused) {
                jSONObject.put("pver", bq.f35804e);
            }
            jSONObject.put("platform", 1);
            jSONObject.put(com.umeng.analytics.pro.d.S, bq.f35806g);
            jSONObject.put("sdkver", WeaponHI.sKSSdkver);
            jSONObject.put("pluginver", "5.3.9");
            jSONObject.put("device_id", cm.b(context));
            jSONObject.put("iv", "v1");
            return jSONObject;
        } catch (Exception unused2) {
            return null;
        }
    }

    private static Map d(Context context) {
        try {
            String str = WeaponHI.sKSAppkey;
            String str2 = WeaponHI.sKSSecKey;
            HashMap hashMap = new HashMap();
            hashMap.put(f35937a, str);
            hashMap.put(f35938b, str2);
            hashMap.put(f35942f, String.valueOf(System.currentTimeMillis() / 1000));
            hashMap.put(f35943g, b(hashMap));
            return hashMap;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a(Context context) {
        Map d6 = d(context);
        if (d6 == null || d6.size() <= 0) {
            return null;
        }
        String str = "";
        for (Map.Entry entry : d6.entrySet()) {
            str = str + ContainerUtils.FIELD_DELIMITER + ((String) entry.getKey()) + ContainerUtils.KEY_VALUE_DELIMITER + ((String) entry.getValue());
        }
        return str.substring(1);
    }

    private static String b(Map map) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(map.get(f35937a));
            sb.append(map.get(f35938b));
            sb.append(map.get(f35942f));
            return f.a(sb.toString());
        } catch (Exception unused) {
            return null;
        }
    }

    private static void a(Context context, JSONObject jSONObject) {
        try {
            jSONObject.put("k", bt.a(context));
            jSONObject.put("hp", context.getPackageName());
            jSONObject.put("hv", bh.q(context));
            jSONObject.put("dpver", h.a(context, "re_po_rt").b(df.f35994g, bq.f35804e));
            jSONObject.put("platform", 1);
            jSONObject.put(com.umeng.analytics.pro.d.S, bq.f35806g);
        } catch (Exception unused) {
        }
    }
}
