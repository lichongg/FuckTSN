package com.bytedance.sdk.component.adexpress.dynamic.cw;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.vl;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw {

    /* renamed from: j, reason: collision with root package name */
    private HashMap<String, Object> f25592j = new HashMap<>();
    private JSONObject xt;

    public Object j(String str) {
        if (this.f25592j.containsKey(str)) {
            return this.f25592j.get(str);
        }
        return null;
    }

    public boolean xt(String str) {
        return this.f25592j.containsKey(str);
    }

    public cw(JSONObject jSONObject) {
        this.xt = jSONObject;
    }

    public void j() {
        Iterator<String> keys = this.xt.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object opt = this.xt.opt(next);
            int i6 = 0;
            if (TextUtils.equals(SocializeProtocolConstants.IMAGE, next)) {
                if (opt instanceof JSONArray) {
                    while (true) {
                        JSONArray jSONArray = (JSONArray) opt;
                        if (i6 < jSONArray.length()) {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i6);
                            if (optJSONObject != null) {
                                Iterator<String> keys2 = optJSONObject.keys();
                                while (keys2.hasNext()) {
                                    String next2 = keys2.next();
                                    Object opt2 = optJSONObject.opt(next2);
                                    this.f25592j.put(next + "." + i6 + "." + next2, opt2);
                                }
                            }
                            i6++;
                        }
                    }
                }
            } else if (TextUtils.equals("dynamic_creative", next)) {
                if (opt instanceof String) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) opt);
                        Iterator<String> keys3 = jSONObject.keys();
                        while (keys3.hasNext()) {
                            String next3 = keys3.next();
                            Object opt3 = jSONObject.opt(next3);
                            if ((opt3 instanceof JSONArray) && !TextUtils.equals(next3, "short_phrase") && !TextUtils.equals(next3, "long_phrase")) {
                                for (int i7 = 0; i7 < ((JSONArray) opt3).length(); i7++) {
                                    this.f25592j.put(next + "." + next3 + "." + i7, ((JSONArray) opt3).opt(i7));
                                }
                            } else if ((opt3 instanceof JSONObject) && TextUtils.equals(next3, "coupon")) {
                                Iterator<String> keys4 = ((JSONObject) opt3).keys();
                                while (keys4.hasNext()) {
                                    String next4 = keys4.next();
                                    Object opt4 = ((JSONObject) opt3).opt(next4);
                                    this.f25592j.put(next + "." + next3 + "." + next4, opt4);
                                }
                            } else if ((opt3 instanceof JSONObject) && TextUtils.equals(next3, "live_room_data")) {
                                j(next, next3, opt3);
                            } else {
                                this.f25592j.put(next + "." + next3, opt3);
                            }
                        }
                    } catch (JSONException e6) {
                        vl.j(e6);
                    }
                }
            } else if (opt instanceof JSONObject) {
                JSONObject jSONObject2 = (JSONObject) opt;
                Iterator<String> keys5 = jSONObject2.keys();
                while (keys5.hasNext()) {
                    String next5 = keys5.next();
                    Object opt5 = jSONObject2.opt(next5);
                    this.f25592j.put(next + "." + next5, opt5);
                }
            } else {
                this.f25592j.put(next, opt);
                if (opt instanceof String) {
                    this.f25592j.put(next, opt);
                }
            }
        }
    }

    private void j(String str, String str2, Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object opt = jSONObject.opt(next);
            if ((opt instanceof JSONArray) && TextUtils.equals(next, "product_infos")) {
                int i6 = 0;
                while (true) {
                    JSONArray jSONArray = (JSONArray) opt;
                    if (i6 < jSONArray.length()) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i6);
                        Iterator<String> keys2 = optJSONObject.keys();
                        while (keys2.hasNext()) {
                            String next2 = keys2.next();
                            Object opt2 = optJSONObject.opt(next2);
                            this.f25592j.put(str + "." + str2 + "." + next + "." + i6 + "." + next2, opt2);
                        }
                        i6++;
                    }
                }
            } else {
                this.f25592j.put(str + "." + str2 + "." + next, opt);
            }
        }
    }
}
