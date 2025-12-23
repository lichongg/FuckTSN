package com.bytedance.sdk.openadsdk.core.activity.base;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.core.component.reward.view.ugen.UgenBanner;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.tj.i;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.up;
import com.bytedance.sdk.openadsdk.core.ugeno.m.j;
import com.bytedance.sdk.openadsdk.core.xt.xt;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.tencent.open.SocialConstants;

/* loaded from: D:\Downloads\app\classes4.dex */
public class BaseLandingPageActivity extends BaseThemeActivity {
    private boolean ae;
    protected String cw;

    /* renamed from: j, reason: collision with root package name */
    protected String f27817j;

    /* renamed from: m, reason: collision with root package name */
    private UgenBanner f27818m;

    /* renamed from: r, reason: collision with root package name */
    protected int f27819r;
    protected String xt;

    private j j() {
        i m111if = this.up.m111if();
        if (m111if == null) {
            return null;
        }
        String m6 = m111if.m();
        if (TextUtils.isEmpty(m6)) {
            return null;
        }
        j jVar = new j();
        jVar.cw(m6);
        jVar.xt(m111if.ae());
        jVar.j(m6);
        return jVar;
    }

    private boolean xt() {
        i m111if = this.up.m111if();
        if (m111if == null) {
            return false;
        }
        m111if.j(true);
        int cw = m111if.cw();
        return (cw == 1 || cw == 2) && !this.ae;
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseThemeActivity, android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.cw = intent.getStringExtra("event_tag");
        this.f27817j = intent.getStringExtra(MediationConstant.EXTRA_ADID);
        this.xt = intent.getStringExtra(MediationConstant.EXTRA_LOG_EXTRA);
        this.f27819r = intent.getIntExtra(SocialConstants.PARAM_SOURCE, -1);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        i m111if;
        super.onDestroy();
        UgenBanner ugenBanner = this.f27818m;
        if (ugenBanner != null) {
            ugenBanner.j();
        }
        n nVar = this.up;
        if (nVar != null && (m111if = nVar.m111if()) != null) {
            m111if.j(false);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        String rs;
        super.onResume();
        if (this.up != null && xt()) {
            if (this.f27818m == null) {
                this.f27818m = new UgenBanner(this);
            }
            addContentView(this.f27818m, new ViewGroup.LayoutParams(-1, -2));
            this.ae = true;
            up by = this.up.by();
            if (by != null) {
                rs = by.cw();
            } else {
                rs = this.up.rs();
            }
            String str = rs;
            this.f27818m.setTopMargin(ed.cw(this, 50.0f));
            this.f27818m.j(j(), this.up, new xt(this, this.up, this.cw, this.f27819r), str, this.up.hw(), "立即打开", true);
        }
    }
}
