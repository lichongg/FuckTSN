package com.bytedance.sdk.openadsdk.core.ugeno.component.gif;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.adsdk.ugeno.r;
import com.bytedance.adsdk.ugeno.xt.cw;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j extends cw<UgenGif> {

    /* renamed from: j, reason: collision with root package name */
    protected String f30576j;
    protected ImageView.ScaleType ll;

    private ImageView.ScaleType qv(String str) {
        ImageView.ScaleType scaleType;
        scaleType = ImageView.ScaleType.FIT_XY;
        str.getClass();
        switch (str) {
            case "center":
                return ImageView.ScaleType.CENTER;
            case "fitEnd":
                return ImageView.ScaleType.FIT_END;
            case "fitStart":
                return ImageView.ScaleType.FIT_START;
            case "centerInside":
                return ImageView.ScaleType.CENTER_INSIDE;
            case "fitCenter":
                return ImageView.ScaleType.FIT_CENTER;
            case "centerCrop":
                return ImageView.ScaleType.CENTER_CROP;
            default:
                return scaleType;
        }
    }

    private void tl() {
        if (TextUtils.isEmpty(this.f30576j)) {
            return;
        }
        if (!this.f30576j.startsWith("local://")) {
            r.j().xt().j(this.f23861g, this.f30576j, (ImageView) this.up, null);
        } else {
            ((UgenGif) this.up).j(com.bytedance.adsdk.ugeno.m.r.xt(this.xt, this.f30576j.replace("local://", "")), false);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    /* renamed from: ae, reason: merged with bridge method [inline-methods] */
    public UgenGif j() {
        UgenGif ugenGif = new UgenGif(this.xt);
        this.up = ugenGif;
        ugenGif.j(this);
        return (UgenGif) this.up;
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    public void j(String str, String str2) {
        super.j(str, str2);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        str.getClass();
        if (str.equals("scaleType")) {
            this.ll = qv(str2);
        } else if (str.equals("src")) {
            this.f30576j = str2;
        }
    }

    public j(Context context) {
        super(context);
        this.ll = ImageView.ScaleType.FIT_CENTER;
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw, com.bytedance.adsdk.ugeno.cw
    public void up() {
        super.up();
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    public void xt() {
        super.xt();
        tl();
        ((UgenGif) this.up).setScaleType(this.ll);
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw, com.bytedance.adsdk.ugeno.cw
    public void j(boolean z5) {
        super.j(z5);
        if (z5) {
            xt();
        }
    }
}
