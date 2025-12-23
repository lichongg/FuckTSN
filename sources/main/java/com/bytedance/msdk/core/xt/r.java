package com.bytedance.msdk.core.xt;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class r {

    /* renamed from: j, reason: collision with root package name */
    private final String f24826j;

    /* renamed from: r, reason: collision with root package name */
    private final String f24828r;
    private String[] up;
    private final String xt;
    private final Map<String, Float> cw = new ConcurrentHashMap();

    /* renamed from: m, reason: collision with root package name */
    private final Map<String, up> f24827m = new ConcurrentHashMap();

    public String[] cw() {
        return this.up;
    }

    public String j() {
        return this.f24826j;
    }

    public String r() {
        return this.f24828r;
    }

    public Map<String, up> up() {
        return this.f24827m;
    }

    public Map<String, Float> xt() {
        return this.cw;
    }

    public r(String str, String str2, @NonNull JSONObject jSONObject) {
        this.f24826j = str;
        this.xt = str2;
        this.f24828r = jSONObject.optString("symbol");
        JSONArray optJSONArray = jSONObject.optJSONArray("score_fit_type");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            this.up = new String[optJSONArray.length()];
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                String optString = optJSONArray.optString(i6);
                if (!TextUtils.isEmpty(optString)) {
                    this.up[i6] = optString;
                    JSONObject optJSONObject = jSONObject.optJSONObject(optString);
                    if (optJSONObject != null && optJSONObject.length() > 0) {
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray("range");
                        JSONArray optJSONArray3 = optJSONObject.optJSONArray("value");
                        if (optJSONArray2 != null && optJSONArray2.length() > 0 && optJSONArray3 != null && optJSONArray3.length() > 0) {
                            this.f24827m.put(optString, new up(optString, optJSONArray2, optJSONArray3));
                        }
                    }
                }
            }
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("rule_exc_mode");
        if (optJSONObject2 != null && optJSONObject2.length() > 0) {
            Iterator<String> keys = optJSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                this.cw.put(next, Float.valueOf((float) optJSONObject2.optDouble(next, 0.0d)));
            }
        }
    }
}
