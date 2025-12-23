package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;

/* loaded from: D:\Downloads\app\classes4.dex */
public class RewardFullBaseLayout extends FrameLayout {
    private FrameLayout ae;
    private int av;
    private int az;
    float cw;

    /* renamed from: g, reason: collision with root package name */
    private FrameLayout f28303g;

    /* renamed from: i, reason: collision with root package name */
    private int f28304i;

    /* renamed from: j, reason: collision with root package name */
    protected TTProgressBar f28305j;
    private FrameLayout jy;

    /* renamed from: m, reason: collision with root package name */
    private FrameLayout f28306m;
    private FrameLayout oq;
    private FrameLayout qv;

    /* renamed from: r, reason: collision with root package name */
    long f28307r;
    private FrameLayout tl;
    j up;
    private FrameLayout vl;
    private int ws;
    protected TTProgressBar xt;

    public interface j {
        void j();
    }

    public void j(com.bytedance.sdk.openadsdk.core.component.reward.r.j jVar) {
        FrameLayout up = up();
        this.f28306m = up;
        up.setPadding(this.ws, this.az, this.av, this.f28304i);
        this.f28306m.setClipChildren(false);
        this.f28306m.addView(xt());
        this.f28306m.addView(cw());
        this.f28306m.addView(r());
        addView(this.f28306m);
        this.ae.addView(jVar.g());
        this.f28303g.addView(jVar.oq());
        this.oq.addView(jVar.qv());
    }

    private FrameLayout up() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    public FrameLayout getEasyPlayableContainer() {
        return this.qv;
    }

    public FrameLayout getEndCardFrameContainer() {
        return this.f28303g;
    }

    public FrameLayout getExpressFrameContainer() {
        return this.tl;
    }

    public FrameLayout getSceneFrame() {
        return this.vl;
    }

    public FrameLayout getSceneFrameContainer() {
        return this.jy;
    }

    public FrameLayout getTopFrameContainer() {
        return this.oq;
    }

    public FrameLayout getWidgetFrameContainer() {
        return this.ae;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.up == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.cw = motionEvent.getY();
            this.f28307r = System.currentTimeMillis();
        } else if (action == 1) {
            float y5 = motionEvent.getY();
            float f6 = this.cw;
            if (y5 < f6 && Math.abs(y5 - f6) > ed.cw(getContext(), 30.0f)) {
                this.up.j();
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public RewardFullBaseLayout(Context context) {
        super(context);
    }

    private FrameLayout cw() {
        FrameLayout up = up();
        this.f28303g = up;
        return up;
    }

    private FrameLayout r() {
        FrameLayout up = up();
        this.oq = up;
        return up;
    }

    private FrameLayout xt() {
        this.jy = up();
        FrameLayout up = up();
        this.vl = up;
        this.jy.addView(up);
        FrameLayout up2 = up();
        this.ae = up2;
        up2.setVisibility(8);
        this.vl.addView(this.ae);
        FrameLayout up3 = up();
        this.tl = up3;
        up3.setVisibility(8);
        this.vl.addView(this.tl);
        this.qv = up();
        return this.jy;
    }

    public void j(int i6) {
        if (this.f28305j == null) {
            this.f28305j = new TTProgressBar(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(120, 120);
            layoutParams.gravity = 17;
            this.f28305j.setLayoutParams(layoutParams);
            try {
                this.f28305j.setIndeterminateDrawable(kt.cw(getContext(), "tt_video_loading_progress_bar"));
            } catch (Throwable unused) {
            }
            addView(this.f28305j);
        }
        this.f28305j.setVisibility(i6);
    }

    public void j(int i6, TTProgressBar tTProgressBar) {
        TTProgressBar tTProgressBar2 = this.xt;
        if (tTProgressBar2 != null) {
            tTProgressBar2.setVisibility(8);
            removeView(this.xt);
        }
        if (tTProgressBar == null) {
            return;
        }
        this.xt = tTProgressBar;
        addView(tTProgressBar);
        this.xt.setVisibility(i6);
    }

    public void j(j jVar) {
        this.up = jVar;
    }

    public void j() {
        this.up = null;
    }

    public void j(int i6, int i7, int i8, int i9) {
        this.ws = i6;
        this.az = i7;
        this.av = i8;
        this.f28304i = i9;
    }
}
