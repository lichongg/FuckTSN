package com.bytedance.sdk.openadsdk.core.component.reward.swiper;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView;
import com.bytedance.sdk.openadsdk.core.component.reward.xt.m;
import com.bytedance.sdk.openadsdk.core.kt.ws;
import com.bytedance.sdk.openadsdk.core.nativeexpress.qv;
import com.bytedance.sdk.openadsdk.core.rn.a;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.z;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.video.xt.j;
import com.bytedance.sdk.openadsdk.res.up;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;
import com.stub.StubApp;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class FullSwiperItemView extends FrameLayout implements l.j, qv {
    public TTProgressBar ae;
    private boolean av;
    private boolean az;
    public FrameLayout cw;

    /* renamed from: g, reason: collision with root package name */
    private float f28388g;

    /* renamed from: i, reason: collision with root package name */
    private final l f28389i;

    /* renamed from: j, reason: collision with root package name */
    public ViewGroup f28390j;
    private com.bytedance.sdk.openadsdk.core.component.reward.m.j jy;
    private int kt;

    /* renamed from: m, reason: collision with root package name */
    public FrameLayout f28391m;
    private boolean mi;
    private com.bytedance.sdk.openadsdk.core.component.reward.swiper.j oq;
    private FullRewardExpressView qv;

    /* renamed from: r, reason: collision with root package name */
    public FrameLayout f28392r;
    private xt tj;
    private float tl;
    public FrameLayout up;
    private Context vl;

    /* renamed from: w, reason: collision with root package name */
    private j f28393w;
    private int ws;
    public FrameLayout xt;

    private static class cw implements j.InterfaceC0494j {
        private boolean cw = false;

        /* renamed from: j, reason: collision with root package name */
        private final j.InterfaceC0494j f28397j;

        /* renamed from: r, reason: collision with root package name */
        private final int f28398r;
        private final l up;
        private final j xt;

        interface j {
            void j();

            void j(long j6, long j7);
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.xt.j.InterfaceC0494j
        public void j() {
            this.cw = false;
            j.InterfaceC0494j interfaceC0494j = this.f28397j;
            if (interfaceC0494j != null) {
                interfaceC0494j.j();
            }
            j jVar = this.xt;
            if (jVar != null) {
                jVar.j();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.xt.j.InterfaceC0494j
        public void cw() {
            j.InterfaceC0494j interfaceC0494j = this.f28397j;
            if (interfaceC0494j != null) {
                interfaceC0494j.cw();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.xt.j.InterfaceC0494j
        public void xt() {
            j.InterfaceC0494j interfaceC0494j = this.f28397j;
            if (interfaceC0494j != null) {
                interfaceC0494j.xt();
            }
        }

        cw(j.InterfaceC0494j interfaceC0494j, int i6, j jVar, l lVar) {
            this.f28397j = interfaceC0494j;
            this.xt = jVar;
            this.f28398r = i6;
            this.up = lVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.xt.j.InterfaceC0494j
        public void j(int i6, String str) {
            this.cw = false;
            j.InterfaceC0494j interfaceC0494j = this.f28397j;
            if (interfaceC0494j != null) {
                interfaceC0494j.j(i6, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.xt.j.InterfaceC0494j
        public void j(long j6, long j7) {
            this.up.removeMessages(102);
            j.InterfaceC0494j interfaceC0494j = this.f28397j;
            if (interfaceC0494j != null) {
                interfaceC0494j.j(j6, j7);
            }
            j jVar = this.xt;
            if (jVar != null) {
                jVar.j(j6, j7);
            }
        }
    }

    public interface j {
        void j();
    }

    public interface xt {
        void j(View view, float f6, float f7);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void j(float f6) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void xt(int i6) {
    }

    public void av() {
        com.bytedance.sdk.openadsdk.core.component.reward.m.j jVar = this.jy;
        if (jVar == null) {
            return;
        }
        jVar.m();
    }

    public void az() {
        if (this.jy != null && this.az) {
            this.oq.oq();
            this.qv.av();
            this.av = true;
            if (n.xt(this.oq.j())) {
                this.f28389i.sendEmptyMessageDelayed(102, 5000L);
            }
            this.oq.j(this.qv);
            if (this.qv.tj()) {
                return;
            }
            this.jy.j(this.oq.qv());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public int cw() {
        com.bytedance.sdk.openadsdk.core.component.reward.m.j jVar = this.jy;
        if (jVar == null) {
            return 0;
        }
        return (int) (jVar.qv() / 1000);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public long getActualPlayDuration() {
        return 0L;
    }

    public void i() {
        com.bytedance.sdk.openadsdk.core.component.reward.m.j jVar = this.jy;
        if (jVar != null) {
            jVar.tl();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void j(float f6, float f7, float f8, float f9, int i6) {
    }

    public void jy() {
        n j6 = this.oq.j();
        if (j6 == null) {
            return;
        }
        float uo = j6.uo();
        int zw = j6.zw();
        float bh = j6.bh();
        float[] j7 = com.bytedance.sdk.openadsdk.core.component.reward.up.xt.j(StubApp.getOrigApplicationContext(this.vl.getApplicationContext()), j6.uo(), j6.zw());
        float f6 = j7[0];
        float f7 = j7[1];
        if (uo == 100.0f) {
            this.tl = f6;
            this.f28388g = f7;
            return;
        }
        int[] j8 = com.bytedance.sdk.openadsdk.core.component.reward.up.xt.j(StubApp.getOrigApplicationContext(this.vl.getApplicationContext()), uo, bh, zw);
        int i6 = j8[0];
        int i7 = j8[1];
        int i8 = j8[2];
        int i9 = j8[3];
        this.tl = (int) ((f6 - i6) - i8);
        this.f28388g = (int) ((f7 - i7) - i9);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
    }

    public void mi() {
        FullRewardExpressView fullRewardExpressView = this.qv;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.jy();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.m.j jVar = this.jy;
        if (jVar != null) {
            jVar.g();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void oq() {
        com.bytedance.sdk.openadsdk.core.component.reward.r.j e6;
        j jVar = this.f28393w;
        if (jVar != null) {
            jVar.j();
        }
        Context context = this.vl;
        if (!(context instanceof TTBaseVideoActivity) || (e6 = ((TTBaseVideoActivity) context).e()) == null || e6.j() == null) {
            return;
        }
        e6.j().cw();
    }

    public void setOnSwiperItemInteractListener(j jVar) {
        this.f28393w = jVar;
    }

    public void setOnSwiperItemRenderResultListener(xt xtVar) {
        this.tj = xtVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void tl() {
        j jVar = this.f28393w;
        if (jVar != null) {
            jVar.j();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            n j6 = this.oq.j();
            if (j6 != null && j6.ng() != null) {
                jSONObject.put("refresh_num", this.oq.j().ng().cw());
            }
        } catch (JSONException e6) {
            vl.j(e6);
        }
        ws.j().j(this.oq.j(), "stats_reward_full_click_express_close", jSONObject);
        Context context = this.vl;
        if (context instanceof Activity) {
            ((Activity) context).finish();
        }
    }

    public void vl() {
        View qv = up.qv(this.vl);
        addView(qv);
        this.f28390j = (ViewGroup) qv.findViewById(2114387898);
        this.xt = (FrameLayout) qv.findViewById(2114387784);
        this.cw = (FrameLayout) qv.findViewById(2114387818);
        this.f28392r = (FrameLayout) qv.findViewById(2114387676);
        this.up = (FrameLayout) qv.findViewById(2114387827);
        this.f28391m = (FrameLayout) qv.findViewById(2114387685);
        this.ae = (TTProgressBar) qv.findViewById(2114387773);
    }

    public void w() {
        l lVar = this.f28389i;
        if (lVar != null) {
            lVar.removeMessages(102);
        }
    }

    public void ws() {
        if (this.oq == null) {
            return;
        }
        this.ae.setVisibility(0);
        this.qv.setExpressInteractionListener(new com.bytedance.sdk.openadsdk.core.nativeexpress.j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperItemView.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.j
            public void j(View view, float f6, float f7) {
                if (FullSwiperItemView.this.tj != null) {
                    FullSwiperItemView.this.tj.j(view, f6, f7);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.j
            public void j(View view, int i6) {
                super.j(view, i6);
            }
        });
        this.qv.setExpressVideoListenerProxy(this);
        this.qv.setInteractListener(this.f28393w);
        this.qv.setOnVideoSizeChangeListener(new FullRewardExpressView.j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperItemView.2
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView.j
            public void j(int i6) {
                FullSwiperItemView.this.ws = i6;
            }
        });
        if (this.qv.getParent() != null) {
            ((ViewGroup) this.qv.getParent()).removeView(this.qv);
        }
        this.up.addView(this.qv);
        this.jy = new com.bytedance.sdk.openadsdk.core.component.reward.m.j(this.f28390j.getContext(), this.cw, this.oq.j(), null);
        this.jy.j(new cw(this.oq.up(), z.cw(this.oq.j()), new cw.j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperItemView.3
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperItemView.cw.j
            public void j() {
                if (FullSwiperItemView.this.vl instanceof TTBaseVideoActivity) {
                    ((TTBaseVideoActivity) FullSwiperItemView.this.vl).k();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperItemView.cw.j
            public void j(long j6, long j7) {
                m hl;
                if (FullSwiperItemView.this.qv == null || !(FullSwiperItemView.this.vl instanceof TTBaseVideoActivity) || (hl = ((TTBaseVideoActivity) FullSwiperItemView.this.vl).hl()) == null) {
                    return;
                }
                hl.xt(j6);
                FullSwiperItemView.this.qv.j(String.valueOf(hl.p()), (int) (hl.h() / 1000), 0, j6 == j7 || hl.rn());
            }
        }, this.f28389i));
        this.jy.xt(this.mi);
        this.qv.setVideoController(this.jy);
        this.oq.j(this.cw, this.f28392r, this.qv);
        this.qv.i();
        this.qv.w();
    }

    public FullSwiperItemView(Context context, com.bytedance.sdk.openadsdk.core.component.reward.swiper.j jVar, float f6, float f7) {
        super(context);
        this.f28389i = new l(Looper.getMainLooper(), this);
        this.oq = jVar;
        this.tl = f6;
        this.f28388g = f7;
        this.vl = context;
        setBackgroundColor(0);
        vl();
        this.kt = uf.g(jVar.j());
        this.mi = v.xt().j(jVar.j(), this.kt);
        jy();
        this.qv = new FullRewardExpressView(this.f28390j.getContext(), this.oq.j(), a.j(8, String.valueOf(this.kt), this.tl, this.f28388g), this.oq.xt(), this.mi);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void ae() {
        ws.j().cw(this.oq.j(), "stats_reward_full_click_express_close");
        Context context = this.vl;
        if (context instanceof TTBaseVideoActivity) {
            ((TTBaseVideoActivity) context).e().j().j();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            n j6 = this.oq.j();
            if (j6 != null && j6.ng() != null) {
                jSONObject.put("refresh_num", this.oq.j().ng().cw());
            }
        } catch (JSONException e6) {
            vl.j(e6);
        }
        ws.j().j(this.oq.j(), "stats_reward_full_click_native_close", jSONObject);
        j jVar = this.f28393w;
        if (jVar != null) {
            jVar.j();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void j(int i6) {
    }

    public void xt(boolean z5) {
        FullRewardExpressView fullRewardExpressView = this.qv;
        if (fullRewardExpressView == null) {
            return;
        }
        if (fullRewardExpressView.tj()) {
            Context context = this.vl;
            if (context instanceof TTBaseVideoActivity) {
                ((TTBaseVideoActivity) context).w();
            }
        } else {
            this.qv.j((ViewGroup) this.xt, false);
        }
        this.az = true;
        this.oq.cw(z5);
        az();
        this.ae.setVisibility(8);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void j(int i6, String str) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void j(boolean z5) {
        if (this.mi != z5) {
            this.mi = z5;
            com.bytedance.sdk.openadsdk.core.component.reward.m.j jVar = this.jy;
            if (jVar != null) {
                jVar.xt(z5);
            }
            Context context = this.vl;
            if (context instanceof TTBaseVideoActivity) {
                ((TTBaseVideoActivity) context).e().j().xt();
            }
            j jVar2 = this.f28393w;
            if (jVar2 != null) {
                jVar2.j();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public int xt() {
        com.bytedance.sdk.openadsdk.core.component.reward.m.j jVar = this.jy;
        if (jVar == null || !this.av) {
            return 2;
        }
        if (jVar.ya()) {
            return 5;
        }
        if (this.jy.f()) {
            return 1;
        }
        if (this.jy.sm()) {
            return 2;
        }
        this.jy.x();
        return 3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public long j() {
        return this.jy.qv();
    }

    @Override // com.bytedance.sdk.component.utils.l.j
    public void j(Message message) {
        if (message.what != 102) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.reward.swiper.j jVar = this.oq;
        if (jVar != null) {
            jVar.tl();
        }
        Context context = this.vl;
        if (context instanceof TTBaseVideoActivity) {
            ((TTBaseVideoActivity) context).oq();
        }
        j jVar2 = this.f28393w;
        if (jVar2 != null) {
            jVar2.j();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void g() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void m() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void qv() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void r() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void up() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void setPauseFromExpressView(boolean z5) {
    }
}
