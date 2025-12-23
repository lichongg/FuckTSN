package com.bytedance.sdk.openadsdk.core.tj;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ae {

    /* renamed from: j, reason: collision with root package name */
    private String f30216j;
    private List<String> xt;

    public String j() {
        return this.f30216j;
    }

    public List<String> xt() {
        return this.xt;
    }

    public ae(Map<String, Object> map) {
        this.f30216j = "";
        this.xt = new ArrayList();
        try {
            this.f30216j = (String) map.get("auto_test_param");
            String str = (String) map.get("auto_test_hosts");
            if (!TextUtils.isEmpty(str)) {
                JSONArray jSONArray = new JSONArray(str);
                this.xt = new ArrayList();
                for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                    this.xt.add(jSONArray.optString(i6));
                }
            }
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }
}
