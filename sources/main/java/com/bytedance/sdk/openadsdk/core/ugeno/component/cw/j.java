package com.bytedance.sdk.openadsdk.core.ugeno.component.cw;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.adsdk.ugeno.xt.cw;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j extends cw<UpieImageView> {

    /* renamed from: j, reason: collision with root package name */
    protected ImageView.ScaleType f30574j;
    protected boolean ll;

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
            case "fit":
            case "fitCenter":
                return ImageView.ScaleType.FIT_CENTER;
            case "crop":
            case "centerCrop":
                return ImageView.ScaleType.CENTER_CROP;
            default:
                return scaleType;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    /* renamed from: ae, reason: merged with bridge method [inline-methods] */
    public UpieImageView j() {
        return new UpieImageView(this.xt, null, null);
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    public void j(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        super.j(str, str2);
        str.getClass();
        switch (str) {
            case "scaleMode":
            case "scaleType":
                this.f30574j = qv(str2);
                break;
            case "isBgGaussianBlur":
                this.ll = com.bytedance.adsdk.ugeno.m.cw.j(str2, false);
                break;
        }
    }

    public j(Context context) {
        super(context);
        this.f30574j = ImageView.ScaleType.FIT_XY;
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    public void xt() {
        super.xt();
        n j6 = com.bytedance.sdk.openadsdk.core.j.j(this.f23872r);
        if (j6 != null) {
            ((UpieImageView) this.up).j(com.bytedance.sdk.openadsdk.up.j.j(j6, this.f23872r), com.bytedance.sdk.openadsdk.up.j.oq(j6));
            ((UpieImageView) this.up).setScaleType(this.f30574j);
        }
    }
}
