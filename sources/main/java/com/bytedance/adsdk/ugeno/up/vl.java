package com.bytedance.adsdk.ugeno.up;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.up.m;
import java.util.HashMap;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class vl {
    public static m.j j(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        m.j jVar = new m.j();
        String j6 = com.bytedance.adsdk.ugeno.r.xt.j(str, jSONObject);
        Uri parse = Uri.parse(j6);
        if (parse == null) {
            return null;
        }
        jVar.cw(j6);
        if (!TextUtils.isEmpty(parse.getScheme())) {
            jVar.j(parse.getScheme());
        }
        String authority = parse.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            authority = parse.getPath();
        }
        jVar.xt(authority);
        jVar.r(jVar.j() + "://" + jVar.xt());
        HashMap hashMap = new HashMap();
        Set<String> queryParameterNames = parse.getQueryParameterNames();
        if (queryParameterNames != null && queryParameterNames.size() > 0) {
            for (String str2 : queryParameterNames) {
                hashMap.put(str2, com.bytedance.adsdk.ugeno.r.xt.j(parse.getQueryParameter(str2), jSONObject));
            }
        }
        jVar.j(hashMap);
        return jVar;
    }
}
