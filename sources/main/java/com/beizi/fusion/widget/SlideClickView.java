package com.beizi.fusion.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.beizi.fusion.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class SlideClickView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private boolean f13951a;

    /* renamed from: b, reason: collision with root package name */
    private ImageView f13952b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f13953c;

    /* renamed from: d, reason: collision with root package name */
    private String f13954d;

    /* renamed from: e, reason: collision with root package name */
    private int f13955e;

    /* renamed from: f, reason: collision with root package name */
    private int f13956f;

    /* renamed from: g, reason: collision with root package name */
    private int f13957g;

    /* renamed from: h, reason: collision with root package name */
    private AnimationDrawable f13958h;

    public SlideClickView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f13951a = false;
        this.f13956f = 45;
        this.f13957g = 45;
        init(context);
    }

    private void a() {
        AnimationDrawable animationDrawable = new AnimationDrawable();
        this.f13958h = animationDrawable;
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.slide_down_one), 600);
        this.f13958h.addFrame(getResources().getDrawable(R.drawable.slide_down_two), 600);
        this.f13958h.addFrame(getResources().getDrawable(R.drawable.slide_down_three), 600);
        this.f13958h.setOneShot(false);
        ImageView imageView = this.f13952b;
        if (imageView != null) {
            imageView.setImageDrawable(this.f13958h);
        }
    }

    public void init(Context context) {
        if (this.f13951a) {
            return;
        }
        this.f13951a = true;
        TextView textView = new TextView(context);
        this.f13953c = textView;
        textView.setGravity(17);
        this.f13952b = new ImageView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        setOrientation(1);
        setGravity(17);
        addView(this.f13953c, layoutParams);
        addView(this.f13952b, layoutParams2);
        a();
    }

    public void setImageWidthAndHeight(int i6, int i7) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i6, i7);
        ImageView imageView = this.f13952b;
        if (imageView != null) {
            imageView.setLayoutParams(layoutParams);
        }
    }

    public void setTitleFont(int i6) {
        TextView textView;
        this.f13955e = i6;
        if (i6 == 0 || (textView = this.f13953c) == null) {
            return;
        }
        textView.setTextSize(2, i6);
    }

    public void setTitleText(String str) {
        TextView textView;
        this.f13954d = str;
        if (TextUtils.isEmpty(str) || (textView = this.f13953c) == null) {
            return;
        }
        textView.setText(str);
        this.f13953c.setTypeface(Typeface.DEFAULT, 1);
        this.f13953c.setTextColor(Color.parseColor("#FFFFFFFF"));
        this.f13953c.setShadowLayer(5.0f, 1.0f, 1.0f, Color.parseColor("#80000000"));
    }

    public void startAnim() {
        AnimationDrawable animationDrawable = this.f13958h;
        if (animationDrawable != null) {
            animationDrawable.start();
        }
    }

    public void stopAnim() {
        AnimationDrawable animationDrawable = this.f13958h;
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
    }

    public SlideClickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13951a = false;
        this.f13956f = 45;
        this.f13957g = 45;
        init(context);
    }

    public SlideClickView(Context context) {
        super(context);
        this.f13951a = false;
        this.f13956f = 45;
        this.f13957g = 45;
        init(context);
    }
}
