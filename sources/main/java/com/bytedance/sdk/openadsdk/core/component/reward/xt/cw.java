package com.bytedance.sdk.openadsdk.core.component.reward.xt;

import android.os.Bundle;
import android.view.View;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.jy.j;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.oq;
import com.bytedance.sdk.openadsdk.core.tj.qv;
import com.bytedance.sdk.openadsdk.core.tj.tj;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw {
    private String cw;

    /* renamed from: j, reason: collision with root package name */
    private final TTBaseVideoActivity f28499j;

    /* renamed from: r, reason: collision with root package name */
    private boolean f28500r = false;
    private View up;
    private n xt;

    private static class j implements com.bytedance.sdk.openadsdk.m.j.j {
        private final JSONObject cw;

        /* renamed from: j, reason: collision with root package name */
        private final int f28506j;
        private final long xt;

        @Override // com.bytedance.sdk.openadsdk.m.j.j
        public void j(JSONObject jSONObject) throws JSONException {
            JSONObject jSONObject2 = this.cw;
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            jSONObject2.put("group_pos", this.f28506j);
            jSONObject2.put("duration", this.xt);
            jSONObject.put("ad_extra_data", jSONObject2.toString());
        }

        j(int i6, long j6, JSONObject jSONObject) {
            this.f28506j = i6;
            this.xt = j6;
            this.cw = jSONObject;
        }
    }

    public void cw() {
        final JSONObject j6 = j(new JSONObject());
        com.bytedance.sdk.openadsdk.core.jy.cw.j(this.xt, this.cw, "reward_arrived_begin", new com.bytedance.sdk.openadsdk.m.j.j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xt.cw.3
            @Override // com.bytedance.sdk.openadsdk.m.j.j
            public void j(JSONObject jSONObject) throws JSONException {
                com.bytedance.sdk.openadsdk.up.j.j(j6, cw.this.xt);
                jSONObject.put("ad_extra_data", j6);
            }
        });
    }

    public void xt() {
        final JSONObject j6 = j(new JSONObject());
        com.bytedance.sdk.openadsdk.core.jy.cw.j(this.xt, this.cw, "skip_endcard", new com.bytedance.sdk.openadsdk.m.j.j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xt.cw.2
            @Override // com.bytedance.sdk.openadsdk.m.j.j
            public void j(JSONObject jSONObject) throws JSONException {
                com.bytedance.sdk.openadsdk.up.j.j(j6, cw.this.xt);
                jSONObject.put("ad_extra_data", j6);
            }
        });
    }

    private boolean up() {
        n nVar = this.xt;
        return nVar == null || tj.qv(nVar) != 1;
    }

    public void j(n nVar, String str, View view) {
        if (this.f28500r) {
            return;
        }
        this.f28500r = true;
        this.xt = nVar;
        this.cw = str;
        this.up = view;
    }

    @DungeonFlag
    protected JSONObject r() {
        try {
            long ws = this.f28499j.hl().ws();
            int az = this.f28499j.hl().az();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("duration", ws);
                jSONObject.put("percent", az);
                return jSONObject;
            } catch (Throwable unused) {
                return jSONObject;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public cw(TTBaseVideoActivity tTBaseVideoActivity) {
        this.f28499j = tTBaseVideoActivity;
    }

    @DungeonFlag
    private void cw(View view, qv qvVar) {
        if (up() || this.xt == null || view == null) {
            return;
        }
        if (view.getId() == 2114387615 || view.getId() == 2114387636 || view.getId() == 2114387881 || view.getId() == 2114387799 || view.getId() == 2114387655 || view.getId() == 2114387931 || view.getId() == 2114387964 || view.getId() == 2114387836 || view.getId() == 2114387648 || view.getId() == 2114387870) {
            int tl = ed.tl(v.getContext());
            com.bytedance.sdk.openadsdk.core.jy.cw.j("click_other", this.xt, new oq.j().m(qvVar.ws()).up(qvVar.az()).r(qvVar.av()).cw(qvVar.i()).xt(System.currentTimeMillis()).j(0L).xt(ed.j(this.up)).j(ed.j((View) null)).cw(ed.cw(this.up)).r(ed.cw((View) null)).cw(qvVar.xt()).r(qvVar.cw()).up(qvVar.r()).j(qvVar.oq()).xt(com.bytedance.sdk.openadsdk.core.oq.i().cw() ? 1 : 2).j(tl).j(ed.m(v.getContext())).xt(ed.ae(v.getContext())).j(), this.cw, true, this.f28499j.nd(), -1, false);
        }
    }

    @DungeonFlag
    private void xt(View view, qv qvVar) {
        if (view == null) {
            return;
        }
        if (view.getId() == 2114387615) {
            j("click_play_star_level", (JSONObject) null);
        } else if (view.getId() == 2114387636) {
            j("click_play_star_nums", (JSONObject) null);
        } else if (view.getId() == 2114387881) {
            j("click_play_source", (JSONObject) null);
        } else if (view.getId() == 2114387799) {
            j("click_play_logo", (JSONObject) null);
        } else if (view.getId() != 2114387655 && view.getId() != 2114387931 && view.getId() != 2114387964) {
            if (view.getId() == 2114387648) {
                j("click_video", r());
            } else if (view.getId() == 2114387870) {
                j("fallback_endcard_click", r());
            }
        } else {
            j("click_start_play_bar", r());
        }
        cw(view, qvVar);
    }

    public JSONObject j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            if (this.f28499j.e() == null) {
                return jSONObject;
            }
            jSONObject.put("reward_full_scene_type", this.f28499j.e().p());
            this.f28499j.e().j(jSONObject);
            return jSONObject;
        } catch (Exception e6) {
            vl.j(e6);
            return jSONObject;
        }
    }

    public void j(Map<String, Object> map) {
        if (map == null || this.f28499j.e() == null) {
            return;
        }
        map.put("reward_full_scene_type", Integer.valueOf(this.f28499j.e().p()));
        this.f28499j.e().j(map);
    }

    public void j() {
        final JSONObject j6 = j(new JSONObject());
        com.bytedance.sdk.openadsdk.core.jy.cw.j(this.xt, this.cw, "skip", new com.bytedance.sdk.openadsdk.m.j.j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xt.cw.1
            @Override // com.bytedance.sdk.openadsdk.m.j.j
            public void j(JSONObject jSONObject) throws JSONException {
                com.bytedance.sdk.openadsdk.up.j.j(j6, cw.this.xt);
                jSONObject.put("ad_extra_data", j6);
            }
        });
    }

    public void j(Bundle bundle) {
        int i6 = bundle.getInt("callback_extra_key_reward_type");
        boolean z5 = bundle.getBoolean("callback_extra_key_reward_valid");
        int i7 = bundle.getInt("callback_extra_key_error_code");
        String string = bundle.getString("callback_extra_key_error_msg");
        boolean z6 = bundle.getBoolean("callback_extra_key_is_server_verify");
        String str = z5 ? "reward_arrived_success" : "reward_arrived_failed";
        final JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("isRewardVerify", z5);
            jSONObject2.put("isServerCallback", z6);
            jSONObject2.put(MediationConstant.KEY_REWARD_TYPE, i6);
            jSONObject2.put("errorCode", i7);
            jSONObject2.put(MediationConstant.KEY_ERROR_MSG, string);
            jSONObject.put("reward_data_bundle", jSONObject2);
        } catch (Exception e6) {
            vl.r("RewardFullEventManager", e6.getMessage());
        }
        com.bytedance.sdk.openadsdk.core.jy.cw.j(this.xt, this.cw, str, new com.bytedance.sdk.openadsdk.m.j.j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xt.cw.4
            @Override // com.bytedance.sdk.openadsdk.m.j.j
            public void j(JSONObject jSONObject3) throws JSONException {
                com.bytedance.sdk.openadsdk.up.j.j(jSONObject, cw.this.xt);
                jSONObject3.put("ad_extra_data", cw.this.j(jSONObject));
            }
        });
    }

    public void j(String str, int i6, String str2) {
        final JSONObject j6 = j(new JSONObject());
        try {
            j6.put("dialog_type", i6);
            j6.put("template_url", str2);
        } catch (JSONException e6) {
            vl.j(e6);
        }
        com.bytedance.sdk.openadsdk.core.jy.cw.j(this.xt, this.cw, str, new com.bytedance.sdk.openadsdk.m.j.j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xt.cw.5
            @Override // com.bytedance.sdk.openadsdk.m.j.j
            public void j(JSONObject jSONObject) throws JSONException {
                com.bytedance.sdk.openadsdk.up.j.j(j6, cw.this.xt);
                jSONObject.put("ad_extra_data", cw.this.j(j6));
            }
        });
    }

    public void j(boolean z5, int i6, long j6) {
        new j.C0460j().up(this.xt.fs()).j(this.cw).xt(z5 ? "scroll_up" : "scroll_down").r(this.xt.os()).j(new j(i6, j6, j(new JSONObject())));
    }

    public void j(View view, qv qvVar) {
        try {
            xt(view, qvVar);
        } catch (Exception e6) {
            vl.r("RewardFullEventManager", "onClickReport error :" + e6.getMessage());
        }
    }

    public void j(String str, JSONObject jSONObject) {
        n nVar = this.xt;
        String str2 = this.cw;
        if (!this.f28499j.ch()) {
            jSONObject = null;
        }
        com.bytedance.sdk.openadsdk.core.jy.cw.j(nVar, str2, str, jSONObject);
    }
}
