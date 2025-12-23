package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.sdk.component.adexpress.dynamic.cw.oq;
import com.bytedance.sdk.component.utils.f;
import com.stub.StubApp;

/* loaded from: D:\Downloads\app\classes4.dex */
public class WriggleGuideAnimationView extends LinearLayout {
    private LottieAnimationView ae;
    private f cw;

    /* renamed from: g, reason: collision with root package name */
    private boolean f25999g;

    /* renamed from: j, reason: collision with root package name */
    public int f26000j;

    /* renamed from: m, reason: collision with root package name */
    private LinearLayout f26001m;

    /* renamed from: r, reason: collision with root package name */
    private TextView f26002r;
    private oq tl;
    private j up;
    private TextView xt;

    public interface j {
        void j();
    }

    private void j(Context context, View view) {
        setClipChildren(false);
        addView(view);
        this.f26001m = (LinearLayout) findViewById(2097610722);
        this.xt = (TextView) findViewById(2097610719);
        this.f26002r = (TextView) findViewById(2097610718);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(2097610706);
        this.ae = lottieAnimationView;
        lottieAnimationView.setAnimation("lottie_json/twist_multi_angle.json");
        this.ae.setImageAssetsFolder("images/");
        this.ae.j(true);
    }

    public TextView getTopTextView() {
        return this.xt;
    }

    public LinearLayout getWriggleLayout() {
        return this.f26001m;
    }

    public View getWriggleProgressIv() {
        return this.ae;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z5) {
        f fVar = this.cw;
        if (fVar != null) {
            if (z5) {
                fVar.j(this.f26000j);
            } else {
                fVar.xt(this.f26000j);
            }
        }
    }

    public void setOnShakeViewListener(j jVar) {
        this.up = jVar;
    }

    public void setShakeText(String str) {
        this.f26002r.setText(str);
    }

    public WriggleGuideAnimationView(Context context, View view, oq oqVar, boolean z5, int i6) {
        super(context);
        this.tl = oqVar;
        this.f25999g = z5;
        this.f26000j = i6;
        j(context, view);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isShown()) {
            if (this.cw == null) {
                this.cw = new f(StubApp.getOrigApplicationContext(getContext().getApplicationContext()), 2, this.f25999g);
            }
            this.cw.j(new f.j() { // from class: com.bytedance.sdk.component.adexpress.widget.WriggleGuideAnimationView.2
                @Override // com.bytedance.sdk.component.utils.f.j
                public void j(int i6) {
                    if (i6 == 2 && WriggleGuideAnimationView.this.isShown() && WriggleGuideAnimationView.this.up != null) {
                        WriggleGuideAnimationView.this.up.j();
                    }
                }
            });
            if (this.tl != null) {
                this.cw.xt(r0.cw());
                this.cw.m(this.tl.up());
                this.cw.j(this.tl.m());
                this.cw.xt(this.tl.tl());
            }
            this.cw.j(this.f26000j);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f fVar = this.cw;
        if (fVar != null) {
            fVar.xt(this.f26000j);
        }
        try {
            LottieAnimationView lottieAnimationView = this.ae;
            if (lottieAnimationView != null) {
                lottieAnimationView.m();
            }
        } catch (Exception unused) {
        }
    }

    public void j() {
        postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.WriggleGuideAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WriggleGuideAnimationView.this.ae.j();
                } catch (Throwable unused) {
                }
            }
        }, 500L);
    }
}
