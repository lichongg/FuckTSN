package com.bytedance.sdk.component.adexpress.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.text.TextUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ClickSlideUpView2 extends SlideUpView {
    private ImageView cw;

    /* renamed from: j, reason: collision with root package name */
    private TextView f25892j;

    /* renamed from: m, reason: collision with root package name */
    private AnimatorSet f25893m;

    /* renamed from: r, reason: collision with root package name */
    private ImageView f25894r;
    private int up;
    private ImageView xt;

    private void r() {
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this, "alphaColor", 0, 60);
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.setDuration(2000L);
        ofInt.setRepeatCount(-1);
        ofInt.start();
    }

    private void xt(Context context) {
        addView(com.bytedance.sdk.component.adexpress.cw.j.xt(context));
        this.xt = (ImageView) findViewById(2097610751);
        this.cw = (ImageView) findViewById(2097610750);
        this.f25894r = (ImageView) findViewById(2097610749);
        this.f25892j = (TextView) findViewById(2097610748);
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.SlideUpView
    protected void j(Context context) {
    }

    public float getAlphaColor() {
        return this.up;
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.SlideUpView
    public void j() {
        r();
    }

    public void setAlphaColor(int i6) {
        if (i6 < 0 || i6 > 60) {
            return;
        }
        int i7 = i6 + MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO;
        ImageView imageView = this.f25894r;
        int rgb = Color.rgb(i7, i7, i7);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        imageView.setColorFilter(rgb, mode);
        int i8 = ((i6 + 20) % 60) + MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO;
        this.cw.setColorFilter(Color.rgb(i8, i8, i8), mode);
        int i9 = ((i6 + 40) % 60) + MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO;
        this.xt.setColorFilter(Color.rgb(i9, i9, i9), mode);
    }

    public void setButtonText(String str) {
        if (this.f25892j == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f25892j.setText(str);
    }

    public ClickSlideUpView2(Context context) {
        super(context);
        this.f25893m = new AnimatorSet();
        xt(context);
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.SlideUpView
    public void xt() {
        this.f25893m.cancel();
    }
}
