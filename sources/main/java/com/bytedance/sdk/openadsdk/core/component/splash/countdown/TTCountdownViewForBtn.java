package com.bytedance.sdk.openadsdk.core.component.splash.countdown;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\Downloads\app\classes4.dex */
public class TTCountdownViewForBtn extends LinearLayout implements l.j, r {
    private int ae;
    private TextView cw;

    /* renamed from: g, reason: collision with root package name */
    private boolean f28607g;

    /* renamed from: j, reason: collision with root package name */
    protected final l f28608j;

    /* renamed from: m, reason: collision with root package name */
    private AtomicBoolean f28609m;

    /* renamed from: r, reason: collision with root package name */
    private TextView f28610r;
    private int tl;
    private j up;
    private Context xt;

    private void r() {
        setOrientation(0);
        setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#99333333"));
        int cw = ed.cw(this.xt, 14.0f);
        gradientDrawable.setCornerRadius(cw);
        int i6 = cw * 2;
        gradientDrawable.setSize(i6, i6);
        setBackground(gradientDrawable);
        this.cw = new TextView(this.xt);
        int cw2 = ed.cw(this.xt, 6.0f);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.cw.setTextColor(-1);
        this.cw.setTextSize(2, 14.0f);
        addView(this.cw, layoutParams);
        View view = new View(this.xt);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.width = ed.cw(this.xt, 1.0f);
        layoutParams2.height = ed.cw(this.xt, 12.0f);
        layoutParams2.leftMargin = cw2;
        layoutParams2.rightMargin = cw2;
        view.setBackgroundColor(-1);
        addView(view, layoutParams2);
        this.f28610r = new TextView(this.xt);
        ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        this.f28610r.setTextColor(-1);
        this.f28610r.setTextSize(2, 14.0f);
        this.f28610r.setText("跳过");
        addView(this.f28610r, layoutParams3);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.r
    public void j() {
        if (this.f28607g) {
            return;
        }
        up();
        m();
    }

    private void ae() {
        if (this.cw != null) {
            StringBuilder sb = new StringBuilder();
            int i6 = this.tl;
            int i7 = this.ae;
            sb.append(i6 <= i7 ? i7 - i6 : 0);
            sb.append("s");
            this.cw.setText(sb.toString());
        }
    }

    private void m() {
        try {
            if (!this.f28607g && this.cw != null) {
                ae();
                int i6 = this.tl;
                if (i6 < this.ae + 1) {
                    this.tl = i6 + 1;
                    this.f28608j.sendEmptyMessageDelayed(1, 1000L);
                } else {
                    j jVar = this.up;
                    if (jVar != null) {
                        jVar.j();
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    private void up() {
        l lVar = this.f28608j;
        if (lVar != null) {
            lVar.removeMessages(1);
        }
        this.tl = 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.r
    public void setCountDownTime(int i6) {
        this.ae = i6;
        ae();
        up();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.r
    public void setCountdownListener(j jVar) {
        this.up = jVar;
        this.f28609m.get();
    }

    public void xt() {
        try {
            l lVar = this.f28608j;
            if (lVar != null) {
                lVar.removeMessages(1);
            }
        } catch (Throwable unused) {
        }
    }

    public TTCountdownViewForBtn(Context context) {
        super(context);
        this.f28609m = new AtomicBoolean(true);
        this.f28608j = new l(Looper.getMainLooper(), this);
        this.ae = 5;
        this.tl = 1;
        this.f28607g = false;
        this.xt = context;
        r();
    }

    public void cw() {
        try {
            m();
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        up();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z5) {
        super.onWindowFocusChanged(z5);
        this.f28609m.set(z5);
        if (this.f28607g) {
            return;
        }
        if (!this.f28609m.get()) {
            xt();
        } else {
            cw();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.r
    public void j(boolean z5) {
        this.f28607g = z5;
        if (z5) {
            up();
        }
    }

    @Override // com.bytedance.sdk.component.utils.l.j
    public void j(Message message) {
        if (message.what == 1) {
            m();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.r
    public View getView() {
        return this;
    }
}
