package com.bytedance.sdk.openadsdk.core.ugeno.oq;

import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.cw.az;
import com.bytedance.adsdk.ugeno.xt.cw;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.core.ugeno.component.skip.xt;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements l.j {
    private cw ae;
    private boolean av;
    private int az;
    private cw cw;

    /* renamed from: g, reason: collision with root package name */
    private int f30770g;

    /* renamed from: i, reason: collision with root package name */
    private int f30771i;

    /* renamed from: j, reason: collision with root package name */
    protected final l f30772j = new l(Looper.getMainLooper(), this);
    private int jy;

    /* renamed from: m, reason: collision with root package name */
    private cw f30773m;
    private int oq;
    private int qv;

    /* renamed from: r, reason: collision with root package name */
    private cw f30774r;
    private cw tl;
    private cw up;
    private int vl;

    /* renamed from: w, reason: collision with root package name */
    private int f30775w;
    private int ws;
    private az xt;

    public void j(az azVar, cw cwVar) {
        this.xt = azVar;
        this.cw = cwVar;
    }

    private void cw() {
        int i6;
        int i7;
        cw cwVar;
        if (this.av) {
            i6 = this.qv;
            i7 = this.jy;
        } else {
            i6 = this.oq;
            i7 = this.vl;
        }
        az azVar = this.xt;
        boolean z5 = true;
        if (azVar != null && (cwVar = this.cw) != null) {
            azVar.j(cwVar, "videoProgress", Integer.valueOf(i7));
        }
        int i8 = i7 + this.ws;
        int max = Math.max(0, i6 - i8);
        if (i8 < this.f30770g && max != 0) {
            z5 = false;
        }
        cw cwVar2 = this.f30774r;
        if (cwVar2 instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.j) {
            cwVar2.xt(0);
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.j) this.f30774r).j(max, i8, this.az);
        }
        cw cwVar3 = this.up;
        if (cwVar3 instanceof xt) {
            ((xt) cwVar3).r(z5);
        }
        cw cwVar4 = this.ae;
        if (cwVar4 instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.xt) {
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.xt) cwVar4).j(i6, i8, max, z5);
        }
        cw cwVar5 = this.tl;
        if (cwVar5 instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.cw) {
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.cw) cwVar5).j(max, i8, this.az);
        }
        cw cwVar6 = this.ae;
        if (cwVar6 instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.xt) {
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.xt) cwVar6).j(i6, i8, max, z5);
        }
        cw cwVar7 = this.f30773m;
        if (cwVar7 instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.skip.j) {
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.skip.j) cwVar7).xt(this.f30771i, this.f30775w);
        }
    }

    private boolean r() {
        return (this.f30774r == null && this.up == null && this.ae == null && this.f30773m == null) ? false : true;
    }

    public void xt() {
        this.f30772j.removeCallbacksAndMessages(null);
    }

    public j(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("xCreative");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("xSetting");
            String optString = jSONObject.optString("dynamic_configs", "");
            if (optJSONObject != null) {
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("video");
                if (optJSONObject3 != null) {
                    this.oq = optJSONObject3.optInt("video_duration");
                }
                int optInt = optJSONObject.optInt("reward_full_time_type", 0);
                int optInt2 = optJSONObject.optInt("reward_full_play_time", 0);
                if (optInt == 1) {
                    this.qv = optInt2;
                    this.av = true;
                }
            }
            if (optJSONObject2 != null) {
                if (optJSONObject2.optInt("ad_slot_type", 0) == 8) {
                    this.f30770g = optJSONObject2.optInt("iv_skip_time", 0);
                } else {
                    this.f30770g = optJSONObject2.optInt("rv_skip_time", 0);
                }
            }
            if (!TextUtils.isEmpty(optString)) {
                try {
                    if (new JSONObject(optString).optBoolean("is_show_video_duration", false)) {
                        this.av = false;
                    }
                } catch (JSONException unused) {
                }
            }
        }
    }

    public void j(cw cwVar, cw cwVar2, cw cwVar3, cw cwVar4, cw cwVar5) {
        this.f30774r = cwVar;
        this.up = cwVar2;
        this.ae = cwVar3;
        this.tl = cwVar4;
        this.f30773m = cwVar5;
    }

    @Override // com.bytedance.sdk.component.utils.l.j
    public void j(Message message) {
        if (message.what != 100) {
            return;
        }
        this.f30772j.sendEmptyMessageDelayed(100, 200L);
        cw();
    }

    public void j() {
        if (r()) {
            this.f30772j.sendEmptyMessage(100);
        }
    }

    public void j(int i6, int i7, int i8, int i9) {
        this.vl = i6;
        this.jy = i7;
        this.ws = i8;
        this.az = i9;
    }

    public void j(int i6, int i7) {
        this.f30771i = i6;
        this.f30775w = i7;
    }
}
