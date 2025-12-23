package com.bytedance.sdk.openadsdk.core.tj;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class rh {
    private String cw;

    /* renamed from: j, reason: collision with root package name */
    private int f30416j;

    /* renamed from: m, reason: collision with root package name */
    private ArrayList<qa> f30417m;

    /* renamed from: r, reason: collision with root package name */
    private String f30418r;
    private String up;
    private String xt;

    public static boolean xt(n nVar) {
        rh m6 = m(nVar);
        if (m6 == null) {
            return false;
        }
        int i6 = m6.f30416j;
        return (i6 == 1 || i6 == 3) && j(nVar);
    }

    public void j(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("again_type", this.f30416j);
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
        try {
            jSONObject2.put("entrance_prefix", this.cw);
        } catch (JSONException e7) {
            com.bytedance.sdk.component.utils.vl.j(e7);
        }
        try {
            jSONObject2.put("entrance_suffix", this.f30418r);
        } catch (JSONException e8) {
            com.bytedance.sdk.component.utils.vl.j(e8);
        }
        try {
            jSONObject2.put("pre_sessions", this.xt);
        } catch (JSONException e9) {
            com.bytedance.sdk.component.utils.vl.j(e9);
        }
        try {
            jSONObject2.put("play_again_rit", this.up);
        } catch (JSONException e10) {
            com.bytedance.sdk.component.utils.vl.j(e10);
        }
        try {
            JSONArray jSONArray = new JSONArray();
            ArrayList<qa> arrayList = this.f30417m;
            if (arrayList != null && arrayList.size() != 0) {
                Iterator<qa> it = this.f30417m.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().j());
                }
            }
            jSONObject2.put("again_dialog_config", jSONArray);
            try {
                jSONObject.put("play_again", jSONObject2);
            } catch (JSONException e11) {
                com.bytedance.sdk.component.utils.vl.j(e11);
            }
        } catch (JSONException e12) {
            throw new RuntimeException(e12);
        }
    }

    private static rh m(n nVar) {
        if (nVar == null) {
            return null;
        }
        return nVar.lv();
    }

    public rh(JSONObject jSONObject) {
        JSONObject optJSONObject;
        this.f30416j = 0;
        this.cw = "再看一个获取";
        this.f30418r = "更多奖励";
        this.f30417m = new ArrayList<>();
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("play_again")) != null) {
            this.f30416j = optJSONObject.optInt("again_type", 0);
            this.cw = optJSONObject.optString("entrance_prefix", "再看一个获取");
            this.f30418r = optJSONObject.optString("entrance_suffix", "更多奖励");
            this.xt = optJSONObject.optString("pre_sessions");
            this.up = optJSONObject.optString("play_again_rit");
            JSONArray optJSONArray = optJSONObject.optJSONArray("again_dialog_config");
            if (optJSONArray != null) {
                this.f30417m = new ArrayList<>();
                for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i6);
                    if (optJSONObject2 != null) {
                        this.f30417m.add(new qa(optJSONObject2));
                    }
                }
            }
        }
    }

    public static String cw(n nVar) {
        rh m6 = m(nVar);
        if (m6 == null) {
            return null;
        }
        return m6.xt;
    }

    public static String r(n nVar) {
        rh m6 = m(nVar);
        if (m6 == null) {
            return null;
        }
        return m6.up;
    }

    public static ArrayList<qa> up(n nVar) {
        rh m6 = m(nVar);
        if (m6 != null) {
            return m6.f30417m;
        }
        return new ArrayList<>();
    }

    public static String xt(String str) {
        return str + "custom_again";
    }

    public static boolean j(n nVar) {
        rh m6 = m(nVar);
        if (m6 == null || z.j(nVar)) {
            return false;
        }
        int i6 = m6.f30416j;
        return (i6 == 1 || i6 == 2 || i6 == 3) && !TextUtils.isEmpty(m6.xt);
    }

    public static String j(String str) {
        return str + "again";
    }

    public static String j(n nVar, String str, String str2) {
        rh m6 = m(nVar);
        if (m6 == null) {
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                return "再看一个获取更多奖励";
            }
            return "再看一个获取" + str2 + str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(TextUtils.isEmpty(m6.cw) ? "再看一个获取" : m6.cw);
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            sb.append(TextUtils.isEmpty(m6.f30418r) ? "更多奖励" : m6.f30418r);
        } else {
            sb.append(str2);
            sb.append(str);
        }
        return sb.toString();
    }
}
