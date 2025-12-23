package com.beizi.fusion.widget;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.beizi.fusion.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class ShakeView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    ImageView f13933a;

    /* renamed from: b, reason: collision with root package name */
    TextView f13934b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f13935c;

    /* renamed from: d, reason: collision with root package name */
    private String f13936d;

    /* renamed from: e, reason: collision with root package name */
    private AnimationDrawable f13937e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f13938f;

    public ShakeView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f13935c = false;
        init(context);
    }

    public void init(Context context) {
        if (this.f13935c) {
            return;
        }
        this.f13935c = true;
        ImageView imageView = new ImageView(context);
        this.f13933a = imageView;
        imageView.setBackgroundResource(R.drawable.anim_shake);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        setOrientation(1);
        addView(this.f13933a, layoutParams);
        this.f13937e = (AnimationDrawable) this.f13933a.getBackground();
    }

    public void setTitleText(String str) {
        this.f13936d = str;
        TextView textView = this.f13934b;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void startShake() {
        AnimationDrawable animationDrawable = this.f13937e;
        if (animationDrawable != null) {
            animationDrawable.start();
        }
    }

    public void stopShake() {
        AnimationDrawable animationDrawable = this.f13937e;
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
    }

    private void a() {
        removeAllViews();
        ImageView imageView = new ImageView(getContext());
        this.f13933a = imageView;
        imageView.setBackgroundResource(R.drawable.anim_shake_download);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        setOrientation(1);
        addView(this.f13933a, layoutParams);
        this.f13937e = (AnimationDrawable) this.f13933a.getBackground();
    }

    public void setDownloadApp(Boolean bool) {
        boolean booleanValue = bool.booleanValue();
        this.f13938f = booleanValue;
        if (booleanValue) {
            a();
        }
    }

    public void updateTwistRollAnim() {
        removeAllViews();
        ImageView imageView = new ImageView(getContext());
        this.f13933a = imageView;
        imageView.setBackgroundResource(R.drawable.beizi_twist_roll);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        setOrientation(1);
        addView(this.f13933a, layoutParams);
        this.f13937e = (AnimationDrawable) this.f13933a.getBackground();
    }

    public ShakeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13935c = false;
        init(context);
    }

    public ShakeView(Context context) {
        super(context);
        this.f13935c = false;
        init(context);
    }
}
