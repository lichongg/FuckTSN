package com.bytedance.sdk.openadsdk.core.activity.base;

import android.os.Bundle;
import android.view.View;
import com.bykv.vk.openvk.component.video.api.r.cw;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.r;
import com.bytedance.sdk.openadsdk.res.up;
import com.bytedance.sdk.openadsdk.widget.TTScrollView;
import com.stub.StubApp;

/* loaded from: D:\Downloads\app\classes4.dex */
public class TTVideoScrollWebPageActivity extends TTVideoWebPageActivity {

    /* renamed from: g, reason: collision with root package name */
    private TTScrollView f27876g;

    /* renamed from: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoScrollWebPageActivity$1, reason: invalid class name */
    class AnonymousClass1 implements TTScrollView.j {
        AnonymousClass1() {
        }

        @Override // com.bytedance.sdk.openadsdk.widget.TTScrollView.j
        public void j(boolean z5) {
            try {
                cw cwVar = TTVideoScrollWebPageActivity.this.tl;
                if (cwVar != null && (cwVar instanceof r)) {
                    if (!z5 || cwVar.kt()) {
                        TTVideoScrollWebPageActivity.this.tl.m();
                    } else {
                        ((r) TTVideoScrollWebPageActivity.this.tl).m(false);
                    }
                }
            } catch (Throwable th) {
                vl.cw("TTVideoScrollWebPageActivity", "onCreate isShow error", th);
            }
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoScrollWebPageActivity$2, reason: invalid class name */
    class AnonymousClass2 implements cw.InterfaceC0306cw {
        AnonymousClass2() {
        }

        @Override // com.bykv.vk.openvk.component.video.api.r.cw.InterfaceC0306cw
        public void q_() {
            cw cwVar;
            if (TTVideoScrollWebPageActivity.this.f27876g == null || TTVideoScrollWebPageActivity.this.f27876g.j() || (cwVar = TTVideoScrollWebPageActivity.this.tl) == null) {
                return;
            }
            cwVar.ae();
        }

        @Override // com.bykv.vk.openvk.component.video.api.r.cw.InterfaceC0306cw
        public void r_() {
        }

        @Override // com.bykv.vk.openvk.component.video.api.r.cw.InterfaceC0306cw
        public void s_() {
        }

        @Override // com.bykv.vk.openvk.component.video.api.r.cw.InterfaceC0306cw
        public void t_() {
        }

        @Override // com.bykv.vk.openvk.component.video.api.r.cw.InterfaceC0306cw
        public void j(long j6, long j7) {
        }
    }

    static {
        StubApp.interface11(22642);
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity, com.bytedance.sdk.openadsdk.core.activity.base.BaseLandingPageActivity, com.bytedance.sdk.openadsdk.core.activity.base.BaseThemeActivity, android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    public void setContentView(View view) {
        super.setContentView(up.ed(this));
    }
}
