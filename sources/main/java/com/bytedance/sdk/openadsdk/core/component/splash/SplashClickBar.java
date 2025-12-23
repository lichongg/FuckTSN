package com.bytedance.sdk.openadsdk.core.component.splash;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.v;

/* loaded from: D:\Downloads\app\classes4.dex */
public class SplashClickBar extends FrameLayout {
    private boolean ae;
    private int cw;

    /* renamed from: g, reason: collision with root package name */
    private SplashClickBarBtn f28550g;

    /* renamed from: j, reason: collision with root package name */
    private int f28551j;

    /* renamed from: m, reason: collision with root package name */
    private String f28552m;

    /* renamed from: r, reason: collision with root package name */
    private int f28553r;
    private int tl;
    private int up;
    private int xt;

    public void j(Context context, n nVar) {
        setClipChildren(false);
        SplashClickBarBtn splashClickBarBtn = new SplashClickBarBtn(getContext(), nVar);
        this.f28550g = splashClickBarBtn;
        addView(splashClickBarBtn);
        this.f28550g.setClipChildren(false);
    }

    public void setBtnLayout(boolean z5) {
        int cw;
        int i6 = this.xt + 150;
        if (this.f28551j <= i6 && this.tl != 4) {
            this.f28551j = i6;
        }
        int i7 = z5 ? this.cw : this.f28553r;
        if (i7 < 0) {
            i7 = 0;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f28550g.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        int i8 = this.tl;
        if (i8 != 4) {
            if (i8 == 5) {
                layoutParams.height = -50;
                layoutParams.width = -50;
                cw = ed.cw(getContext(), 10.0f);
            } else if (i8 != 7) {
                layoutParams.height = ed.cw(v.getContext(), this.xt);
                layoutParams.width = ed.cw(v.getContext(), this.f28551j);
            } else {
                layoutParams.height = -50;
                layoutParams.width = -50;
                cw = ed.cw(getContext(), 20.0f);
            }
            i7 += cw;
        } else {
            layoutParams.height = -50;
            layoutParams.width = -50;
        }
        layoutParams.bottomMargin = ed.cw(v.getContext(), i7);
        layoutParams.gravity = 81;
        this.f28550g.setLayoutParams(layoutParams);
    }

    public SplashClickBar(Context context, n nVar) {
        super(context);
        j(context, nVar);
    }

    public void j(n nVar) {
        this.f28551j = nVar.ri();
        this.xt = nVar.uc();
        this.cw = nVar.ki();
        this.f28553r = nVar.t();
        this.up = nVar.im();
        this.f28552m = nVar.y();
        this.tl = nVar.uq();
        this.ae = nVar.nt();
        SplashClickBarBtn splashClickBarBtn = this.f28550g;
        if (splashClickBarBtn != null) {
            splashClickBarBtn.setShakeValue(nVar.si());
            this.f28550g.setDeepShakeValue(nVar.ho());
            this.f28550g.setWriggleValue(nVar.km());
            this.f28550g.setTwistConfig(nVar.mt());
            this.f28550g.setShakeInteractConf(nVar.xn());
            this.f28550g.setTwistInteractConf(nVar.lr());
            this.f28550g.setCalculationTwistMethod(nVar.qo());
            this.f28550g.setCalculationMethod(nVar.wo());
        }
        this.f28550g.j(nVar.gr());
        if (this.up == 1 && this.ae) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public void j(com.bytedance.sdk.openadsdk.core.xt.j jVar) {
        this.f28550g.j(jVar);
    }
}
