package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.bytedance.sdk.component.adexpress.dynamic.r.qv;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.component.utils.l;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class AnimationText extends TextSwitcher implements ViewSwitcher.ViewFactory, l.j {
    private int ae;
    private int cw;

    /* renamed from: g, reason: collision with root package name */
    private float f25865g;

    /* renamed from: j, reason: collision with root package name */
    Animation.AnimationListener f25866j;
    private int jy;

    /* renamed from: m, reason: collision with root package name */
    private TextView f25867m;
    private int oq;
    private int qv;

    /* renamed from: r, reason: collision with root package name */
    private final int f25868r;
    private int tl;
    private Context up;
    private int vl;
    private Handler ws;
    private List<String> xt;

    public void j() {
        int i6 = this.vl;
        if (i6 == 1) {
            setInAnimation(getContext(), kt.vl(this.up, "tt_text_animation_y_in"));
            setOutAnimation(getContext(), kt.vl(this.up, "tt_text_animation_y_out"));
        } else if (i6 == 0) {
            setInAnimation(getContext(), kt.vl(this.up, "tt_text_animation_x_in"));
            setOutAnimation(getContext(), kt.vl(this.up, "tt_text_animation_x_in"));
            getInAnimation().setInterpolator(new LinearInterpolator());
            getOutAnimation().setInterpolator(new LinearInterpolator());
            getInAnimation().setAnimationListener(this.f25866j);
            getOutAnimation().setAnimationListener(this.f25866j);
        }
        this.ws.sendEmptyMessage(1);
    }

    @Override // android.widget.ViewSwitcher.ViewFactory
    public View makeView() {
        TextView textView = new TextView(getContext());
        this.f25867m = textView;
        textView.setTextColor(this.tl);
        this.f25867m.setTextSize(this.f25865g);
        this.f25867m.setMaxLines(this.oq);
        this.f25867m.setTextAlignment(this.jy);
        return this.f25867m;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i6, int i7) {
        try {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(qv.xt(this.xt.get(this.qv), this.f25865g, false)[0], 1073741824), i6);
        } catch (Exception unused) {
            super.onMeasure(i6, i7);
        }
    }

    public void setAnimationDuration(int i6) {
        this.ae = i6;
    }

    public void setAnimationText(List<String> list) {
        this.xt = list;
    }

    public void setAnimationType(int i6) {
        this.vl = i6;
    }

    public void setMaxLines(int i6) {
        this.oq = i6;
    }

    public void setTextColor(int i6) {
        this.tl = i6;
    }

    public void setTextSize(float f6) {
        this.f25865g = f6;
    }

    public void xt() {
        List<String> list = this.xt;
        if (list == null || list.size() <= 0) {
            return;
        }
        int i6 = this.cw;
        this.cw = i6 + 1;
        this.qv = i6;
        setText(this.xt.get(i6));
        if (this.cw > this.xt.size() - 1) {
            this.cw = 0;
        }
    }

    public AnimationText(Context context, int i6, float f6, int i7, int i8) {
        super(context);
        this.xt = new ArrayList();
        this.cw = 0;
        this.f25868r = 1;
        this.ws = new l(Looper.getMainLooper(), this);
        this.f25866j = new Animation.AnimationListener() { // from class: com.bytedance.sdk.component.adexpress.widget.AnimationText.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (AnimationText.this.f25867m != null) {
                    AnimationText.this.f25867m.setText("");
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        };
        this.up = context;
        this.tl = i6;
        this.f25865g = f6;
        this.oq = i7;
        this.jy = i8;
        cw();
    }

    private void cw() {
        setFactory(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.ws.sendEmptyMessageDelayed(1, this.ae);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.ws.removeMessages(1);
    }

    @Override // com.bytedance.sdk.component.utils.l.j
    public void j(Message message) {
        if (message.what != 1) {
            return;
        }
        xt();
        this.ws.sendEmptyMessageDelayed(1, this.ae);
    }
}
