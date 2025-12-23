package com.bytedance.sdk.openadsdk.core.component.reward.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.bytedance.component.sdk.annotation.HungeonFlag;
import com.bytedance.sdk.component.tl.j.cw;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.a;
import com.bytedance.sdk.openadsdk.core.activity.base.BaseThemeActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.layout.up;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.kt.j.xt;
import com.bytedance.sdk.openadsdk.core.kt.ws;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.core.tj.e;
import com.bytedance.sdk.openadsdk.core.tj.kt;
import com.bytedance.sdk.openadsdk.core.tj.la;
import com.bytedance.sdk.openadsdk.core.tj.rh;
import com.bytedance.sdk.openadsdk.core.tj.z;
import com.bytedance.sdk.openadsdk.core.tl.r;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.vl.j.j;
import com.tencent.connect.common.Constants;
import com.umeng.socialize.common.SocializeConstants;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.amps.common.AMPSConstants;

/* loaded from: D:\Downloads\app\classes4.dex */
public class TTRewardVideoActivity extends TTBaseVideoActivity {
    private cw im;
    private int ln;
    private String pz;
    private String qa;
    private String wf;
    private final int ry = Constants.REQUEST_JOIN_GROUP;
    private final int zz = Constants.REQUEST_BIND_GROUP;
    private final int kc = Constants.REQUEST_GUILD;
    private final int aq = Constants.REQUEST_COMMON_CHANNEL;
    private final int rr = 10115;
    private final int st = 10116;
    private final AtomicBoolean xp = new AtomicBoolean();

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public boolean ch() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    @HungeonFlag
    @DungeonFlag
    public void r(final int i6) {
        if (!this.f28070w.getAndSet(true)) {
            this.ff.r();
        }
        if (this.f28063m.containsKey(Integer.valueOf(i6))) {
            return;
        }
        this.f28063m.put(Integer.valueOf(i6), Boolean.TRUE);
        this.gx.cw();
        boolean ch = e.ch(this.up);
        final int l6 = l();
        final String p5 = p();
        int rr = rr();
        boolean z5 = rr == 0;
        if (z5 && ch) {
            cw(i6, true);
            v.j().j(xt(i6, true), new s.up() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity.2
                @Override // com.bytedance.sdk.openadsdk.core.s.up
                public void j(int i7, String str) {
                    TTRewardVideoActivity.this.cw(TTRewardVideoActivity.this.j(i6, false, i7, str, l6, p5, false));
                }

                @Override // com.bytedance.sdk.openadsdk.core.s.up
                public void j(a.r rVar) {
                    int j6 = rVar.cw.j();
                    String xt = rVar.cw.xt();
                    TTRewardVideoActivity.this.cw(rVar.xt ? TTRewardVideoActivity.this.j(i6, true, Constants.REQUEST_JOIN_GROUP, "reward failed", j6, xt, true) : TTRewardVideoActivity.this.j(i6, false, Constants.REQUEST_BIND_GROUP, "server refuse", j6, xt, true));
                }
            });
        } else {
            cw(j(i6, z5, rr, "reward failed", l6, p5, false));
            cw(i6, z5);
        }
    }

    public void ry() {
        if (la.xt(ch(), this.up, true)) {
            if (this.f28061k.j() > this.f28064n.uf()) {
                this.f28061k.j(false);
            }
            int max = Math.max(this.f28064n.m(true) - this.f28061k.j(), 0);
            int m6 = this.f28064n.m(false) - this.f28061k.j();
            if (this.f28063m.containsKey(0)) {
                max = 999;
                m6 = 999;
            }
            oq(m6);
            qv(max);
            if (this.f28063m.containsKey(0)) {
                cw(0, true);
            }
            this.f28061k.j(this.f28065p);
        }
    }

    private boolean aq() {
        if (TextUtils.isEmpty(this.up.ej())) {
            return false;
        }
        return this.xp.get();
    }

    private void kc() {
        up upVar;
        if (e.ae(this.up) && this.ed.tj() >= e.oq(this.up)) {
            if (!this.f28064n.ae() || (upVar = this.la) == null || upVar.g() != 0) {
                ed.j(this.nd, e.g(this.up), 0);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("toast_text", e.g(this.up));
                this.la.j("showToast", jSONObject);
            } catch (JSONException e6) {
                vl.j(e6);
            }
        }
    }

    @DungeonFlag
    private int rr() {
        final int i6 = 0;
        if (e.r(this.up)) {
            if (this.av.get()) {
                i6 = 10116;
            } else if (!aq()) {
                i6 = Constants.REQUEST_JOIN_GROUP;
            }
        }
        if (v.xt().lo() == 0) {
            return i6;
        }
        boolean m6 = com.bytedance.sdk.openadsdk.core.rn.v.m();
        int j6 = com.bytedance.sdk.openadsdk.core.rn.v.j(this.up.lw() + "_" + this.up.nv());
        if (m6) {
            i6 = 10115;
        } else if (j6 == com.bytedance.sdk.openadsdk.core.rn.v.xt) {
            i6 = Constants.REQUEST_COMMON_CHANNEL;
        } else if (j6 == com.bytedance.sdk.openadsdk.core.rn.v.cw) {
            i6 = Constants.REQUEST_GUILD;
        }
        ws.j().xt(new j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity.6
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                xt<xt> xt = xt.xt();
                xt.j("armor_reward");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("errorCode", i6);
                xt.xt(jSONObject.toString());
                return xt;
            }
        }, "armor_reward");
        return i6;
    }

    private void st() {
        this.la.j("cancelClickLandingRewardTip", (JSONObject) null);
    }

    @DungeonFlag
    private JSONObject xt(int i6, boolean z5) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("oversea_version_type", 0);
            jSONObject.put(MediationConstant.REWARD_NAME, p());
            jSONObject.put(MediationConstant.REWARD_AMOUNT, l());
            jSONObject.put("network", com.bytedance.sdk.component.utils.ws.cw(v.getContext()));
            jSONObject.put("sdk_version", h.cw);
            jSONObject.put("user_agent", uf.ae());
            jSONObject.put(JThirdPlatFormInterface.KEY_EXTRA, this.up.ot());
            jSONObject.put("media_extra", this.pz);
            jSONObject.put("video_duration", this.ed.l());
            jSONObject.put("play_start_ts", this.hl);
            jSONObject.put("play_end_ts", System.currentTimeMillis() / 1000);
            jSONObject.put("duration", this.ed.tj());
            jSONObject.put(SocializeConstants.TENCENT_UID, this.qa);
            jSONObject.put("trans_id", UUID.randomUUID().toString().replace("-", ""));
            jSONObject.put("reward_type", i6);
            if (e.r(this.up)) {
                jSONObject.put("show_result", z5 ? 1 : 0);
            }
            com.bytedance.sdk.openadsdk.av.xt.j(jSONObject);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public boolean a() {
        return this.ff.j() || this.f28061k.r();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    protected void cw() {
        cw cwVar = new cw() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity.1
            @Override // com.bytedance.sdk.component.tl.j.cw
            public void j(String str, String str2) {
                if (((BaseThemeActivity) TTRewardVideoActivity.this).up != null) {
                    String ej = ((BaseThemeActivity) TTRewardVideoActivity.this).up.ej();
                    if (TextUtils.equals(AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_SHOW, str) && TextUtils.equals(str2, ej)) {
                        TTRewardVideoActivity.this.xp.set(true);
                    }
                }
            }
        };
        this.im = cwVar;
        com.bytedance.sdk.component.tl.xt.j.j(cwVar);
        super.cw();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public String h() {
        if (this.ff.j() && !TextUtils.isEmpty(this.ff.ae()) && !TextUtils.isEmpty(this.ff.m())) {
            return this.ff.ae();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(l());
        return sb.toString();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public int l() {
        if (this.ln != 0 && !TextUtils.isEmpty(this.wf)) {
            return this.ln;
        }
        if (e.xt(this.up) == 0 || TextUtils.isEmpty(e.j(this.up))) {
            return 0;
        }
        return e.xt(this.up);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public String la() {
        if (this.ff.j() && !TextUtils.isEmpty(this.ff.ae()) && !TextUtils.isEmpty(this.ff.m())) {
            return this.ff.m();
        }
        return p();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public void ol() {
        super.ol();
        if (e.i(this.up) || this.wq.p() || kt.r(this.up)) {
            return;
        }
        if (this.ed.rn()) {
            this.rn.j(false, null, null, true, true);
            return;
        }
        int m6 = this.f28064n.m(true);
        int m7 = this.f28064n.m(la.xt(ch(), this.up, true));
        String str = "已领取奖励";
        if (zz() || this.f28064n.i()) {
            com.bytedance.sdk.openadsdk.core.component.reward.xt.up upVar = this.rn;
            if (m7 > 0) {
                str = m7 + "s";
            }
            upVar.j(false, str, "跳过", false, true);
        } else {
            com.bytedance.sdk.openadsdk.core.component.reward.xt.up upVar2 = this.rn;
            if (m7 > 0) {
                str = m7 + "s";
            }
            upVar2.j(false, str, null, false, false);
        }
        this.f28064n.xt(m6);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public String p() {
        return (this.ln == 0 || TextUtils.isEmpty(this.wf)) ? (e.xt(this.up) == 0 || TextUtils.isEmpty(e.j(this.up))) ? "" : e.j(this.up) : this.wf;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    protected void s() {
        if (this.cw.getAndSet(true) || this.ff.j() || la.xt(ch(), this.up, true)) {
            return;
        }
        r("onAdClose");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public void tl(int i6) {
        if (!this.f28063m.containsKey(0)) {
            this.xt.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity.3
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.component.utils.a.j(TTRewardVideoActivity.this.nd, "当前不满足条件，下次记得看完视频哦～", 1);
                }
            });
        } else if (z.j(this.up)) {
            this.xt.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity.4
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.component.utils.a.j(TTRewardVideoActivity.this.nd, "非常抱歉，当前不支持再看一个", 1);
                }
            });
        } else {
            this.ff.cw(i6);
        }
    }

    public boolean zz() {
        return Math.round(((float) (this.ed.h() + (((long) this.f28064n.z()) * 1000))) / 1000.0f) >= this.f28064n.hl();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public void mi() {
        super.mi();
        ry();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i6, int i7, Intent intent) {
        super.onActivityResult(i6, i7, intent);
        if (this.wq.rn()) {
            return;
        }
        this.f28064n.j(i6, i7, intent);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity, android.app.Activity
    protected void onDestroy() {
        cw cwVar;
        super.onDestroy();
        this.ff.cw();
        List<cw> j6 = com.bytedance.sdk.component.tl.xt.j.j();
        if (j6 != null && j6.size() != 0 && (cwVar = this.im) != null) {
            j6.remove(cwVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        if (e.i(this.up)) {
            this.f28064n.r(r.xt);
            r.cw = false;
            r.xt = 0;
            r.f30512j = this.f28064n.c();
            cw(0);
        }
        if (e.mi(this.up) && r.f30514r) {
            st();
            r(4);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    protected boolean v() {
        if (!super.v() && !this.ff.up()) {
            return false;
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    protected void j(Intent intent) {
        super.j(intent);
        if (intent == null) {
            return;
        }
        this.pz = intent.getStringExtra("media_extra");
        this.qa = intent.getStringExtra(SocializeConstants.TENCENT_UID);
        this.wf = intent.getStringExtra(MediationConstant.REWARD_NAME);
        this.ln = intent.getIntExtra(MediationConstant.REWARD_AMOUNT, 0);
        this.ff.j(intent.getBooleanExtra("is_play_again", false));
        this.ff.j(intent.getIntExtra("play_again_count", 0));
        this.ff.xt(intent.getBooleanExtra("custom_play_again", false));
        this.ff.xt(intent.getIntExtra("source_rit_id", 0));
        this.ff.j(intent.getStringExtra("reward_again_name"));
        this.ff.xt(intent.getStringExtra("reward_again_amount"));
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    @HungeonFlag
    @DungeonFlag
    public void cw(int i6) {
        if (i6 != 0) {
            r(i6);
            return;
        }
        if (this.f28064n.uf() > 0) {
            return;
        }
        if ((!e.s(this.up) || this.tl.get()) && this.f28064n.la()) {
            r(i6);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    protected void cw(boolean z5) {
        int i6;
        if (this.ch) {
            if (v.xt().mp() == 1) {
                i6 = 2000;
            }
            i6 = -1;
        } else {
            if (z5) {
                i6 = 0;
            }
            i6 = -1;
        }
        int i7 = this.ff.j() ? -1 : i6;
        if (i7 < 0 || this.f28056f.get()) {
            return;
        }
        if (i7 == 0) {
            if (this.f28056f.getAndSet(true)) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.component.reward.j.up.j().j(String.valueOf(this.rh));
            return;
        }
        this.xt.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity.5
            @Override // java.lang.Runnable
            public void run() {
                if (TTRewardVideoActivity.this.f28056f.getAndSet(true)) {
                    return;
                }
                com.bytedance.sdk.openadsdk.core.component.reward.j.up.j().j(String.valueOf(TTRewardVideoActivity.this.rh));
            }
        }, i7);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    protected boolean j(Bundle bundle) {
        com.bytedance.sdk.component.r.j.xt j6 = com.bytedance.sdk.openadsdk.core.xt.j();
        j6.j("is_reward_deep_link_to_live", false);
        j6.j("click_to_live_duration", System.currentTimeMillis());
        return super.j(bundle);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    protected void r(String str) {
        j(str, (Bundle) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cw(Bundle bundle) {
        int i6 = bundle.getInt("callback_extra_key_reward_type");
        if (i6 == 0) {
            j("onRewardVerify", bundle);
        }
        j("onRewardArrived", bundle);
        this.gx.j(bundle);
        this.f28064n.j(i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @DungeonFlag
    public Bundle j(int i6, boolean z5, int i7, String str, int i8, String str2, boolean z6) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("callback_extra_key_reward_valid", z5);
        bundle.putInt("callback_extra_key_reward_type", i6);
        bundle.putInt("callback_extra_key_reward_amount", i8);
        bundle.putString("callback_extra_key_reward_name", str2);
        bundle.putFloat("callback_extra_key_reward_propose", e.j(this.up, i6));
        bundle.putBoolean("callback_extra_key_is_server_verify", z6);
        if (!z5) {
            bundle.putInt("callback_extra_key_error_code", i7);
            bundle.putString("callback_extra_key_error_msg", str);
        }
        if (i6 == 0 && e.ae(this.up) && this.ed.tj() >= e.oq(this.up)) {
            bundle.putBoolean("callback_extra_key_video_complete_reward", true);
        }
        return bundle;
    }

    private void cw(int i6, boolean z5) {
        if (i6 == 0) {
            this.la.jy();
            this.f28054c.xt(z5);
            kc();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public void j() {
        if (!this.f28061k.up() && this.f28063m.containsKey(0) && this.ff.cw(2)) {
            return;
        }
        super.j();
    }

    private void j(String str, Bundle bundle) {
        com.bytedance.sdk.openadsdk.core.component.reward.j.j(0, this.ff.j() ? rh.j(this.ol) : this.ol, str, bundle);
    }
}
