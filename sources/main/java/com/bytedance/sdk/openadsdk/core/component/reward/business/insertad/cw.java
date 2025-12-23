package com.bytedance.sdk.openadsdk.core.component.reward.business.insertad;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw {
    JSONArray ae;
    int cw;

    /* renamed from: g, reason: collision with root package name */
    String f28106g;

    /* renamed from: j, reason: collision with root package name */
    String f28107j;

    /* renamed from: m, reason: collision with root package name */
    boolean f28108m;
    int oq;
    private boolean qv;

    /* renamed from: r, reason: collision with root package name */
    int f28109r;
    boolean tl;
    boolean up;
    int xt;

    /* renamed from: com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.cw$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class j {
        int ae;
        int cw;

        /* renamed from: g, reason: collision with root package name */
        boolean f28110g;

        /* renamed from: j, reason: collision with root package name */
        String f28111j;

        /* renamed from: m, reason: collision with root package name */
        boolean f28112m;
        com.bytedance.sdk.openadsdk.core.component.reward.business.xt.j oq;

        /* renamed from: r, reason: collision with root package name */
        boolean f28113r;
        int tl;
        JSONArray up;
        int xt;

        public j cw(int i6) {
            this.ae = i6;
            return this;
        }

        public cw j() {
            return new cw(this.f28111j, this.xt, this.cw, this.tl, this.f28113r, this.up, this.f28112m, this.oq, this.ae, this.f28110g, null);
        }

        public j xt(int i6) {
            this.cw = i6;
            return this;
        }

        public j cw(boolean z5) {
            this.f28110g = z5;
            return this;
        }

        public j j(String str) {
            this.f28111j = str;
            return this;
        }

        public j r(int i6) {
            this.tl = i6;
            return this;
        }

        public j xt(boolean z5) {
            this.f28112m = z5;
            return this;
        }

        public j j(int i6) {
            this.xt = i6;
            return this;
        }

        public j j(boolean z5) {
            this.f28113r = z5;
            return this;
        }

        public j j(Set<Integer> set) {
            this.up = new JSONArray((Collection) set);
            return this;
        }

        public j j(com.bytedance.sdk.openadsdk.core.component.reward.business.xt.j jVar) {
            this.oq = jVar;
            return this;
        }
    }

    /* synthetic */ cw(String str, int i6, int i7, int i8, boolean z5, JSONArray jSONArray, boolean z6, com.bytedance.sdk.openadsdk.core.component.reward.business.xt.j jVar, int i9, boolean z7, AnonymousClass1 anonymousClass1) {
        this(str, i6, i7, i8, z5, jSONArray, z6, jVar, i9, z7);
    }

    private cw(String str, int i6, int i7, int i8, boolean z5, JSONArray jSONArray, boolean z6, com.bytedance.sdk.openadsdk.core.component.reward.business.xt.j jVar, int i9, boolean z7) {
        this.f28107j = str;
        this.xt = i6;
        this.cw = i7;
        this.f28109r = i8;
        this.up = z5;
        this.ae = jSONArray;
        this.tl = z6;
        this.f28106g = jVar.tl();
        this.oq = i9;
        this.qv = z7;
    }

    public int ae() {
        return this.oq;
    }

    public int cw() {
        return this.cw;
    }

    public JSONObject g() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("meta_md5", this.f28107j);
            jSONObject.put("consume_time", this.xt);
            jSONObject.put("reduce_time", this.cw);
            jSONObject.put("is_video_completed", this.up);
            jSONObject.put("is_user_interacted", this.f28108m);
            jSONObject.put("reward_verify_array", this.ae);
            jSONObject.put("is_mute", this.tl);
            jSONObject.put("play_again_string", this.f28106g);
            jSONObject.put("carousel_type", this.oq);
            jSONObject.put("eternal_global_time", this.f28109r);
            jSONObject.put("first_ad_is_video", this.qv);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public String j() {
        return this.f28107j;
    }

    public String m() {
        return this.f28106g;
    }

    public int oq() {
        return this.f28109r;
    }

    public boolean qv() {
        return this.qv;
    }

    public boolean r() {
        return this.up;
    }

    public Map<Integer, Boolean> tl() {
        HashMap hashMap = new HashMap();
        for (int i6 = 0; i6 < this.ae.length(); i6++) {
            try {
                hashMap.put((Integer) this.ae.get(i6), Boolean.TRUE);
            } catch (Exception unused) {
            }
        }
        return hashMap;
    }

    public boolean up() {
        return this.tl;
    }

    public int xt() {
        return this.xt;
    }

    public cw(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f28107j = jSONObject.optString("meta_md5");
            this.xt = jSONObject.optInt("consume_time");
            this.cw = jSONObject.optInt("reduce_time");
            this.up = jSONObject.optBoolean("is_video_completed");
            this.ae = jSONObject.optJSONArray("reward_verify_array");
            this.tl = jSONObject.optBoolean("is_mute");
            this.f28106g = jSONObject.optString("play_again_string");
            this.oq = jSONObject.optInt("carousel_type");
            this.f28109r = jSONObject.optInt("eternal_global_time");
            this.qv = jSONObject.optBoolean("first_ad_is_video");
        } catch (Exception unused) {
        }
    }
}
