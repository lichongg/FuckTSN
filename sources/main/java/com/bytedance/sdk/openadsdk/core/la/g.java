package com.bytedance.sdk.openadsdk.core.la;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.vl;
import com.huawei.hms.common.util.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class g {
    private final JSONObject cw;

    /* renamed from: j, reason: collision with root package name */
    private final Map<String, List<String>> f29432j;

    /* renamed from: m, reason: collision with root package name */
    private String f29433m;

    /* renamed from: r, reason: collision with root package name */
    private final String f29434r;
    private String up;
    private final String xt;

    public void j(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        List<String> list = this.f29432j.get(str);
        if (list != null) {
            list.add(str2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        this.f29432j.put(str, arrayList);
    }

    public String xt() {
        return this.xt;
    }

    public String cw() {
        try {
            String optString = this.cw.optString("expandParams");
            String str = "apppackage=" + this.up + "|appsign=" + this.f29433m;
            if (!TextUtils.isEmpty(optString)) {
                str = optString + Logger.f33116c + str;
            }
            this.cw.put("expandParams", str);
        } catch (Exception e6) {
            vl.j(e6);
        }
        JSONObject jSONObject = this.cw;
        return jSONObject == null ? "" : jSONObject.toString();
    }

    public String r() {
        return this.f29434r;
    }

    public void xt(String str) {
        this.f29433m = str;
    }

    public g(String str, String str2, Map<String, List<String>> map, JSONObject jSONObject) {
        this.xt = str;
        this.f29434r = str2;
        this.f29432j = map;
        this.cw = jSONObject;
    }

    public Map<String, List<String>> j() {
        return this.f29432j;
    }

    public void j(String str) {
        this.up = str;
    }
}
