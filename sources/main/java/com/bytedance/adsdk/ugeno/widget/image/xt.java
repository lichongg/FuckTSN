package com.bytedance.adsdk.ugeno.widget.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.adsdk.lottie.model.layer.a;
import com.bytedance.adsdk.lottie.model.layer.b;
import com.bytedance.adsdk.ugeno.cw.ae;
import com.bytedance.adsdk.ugeno.cw.ws;
import com.bytedance.adsdk.ugeno.j;
import com.bytedance.adsdk.ugeno.m.r;
import com.bytedance.adsdk.ugeno.m.tl;
import com.bytedance.adsdk.ugeno.xt.cw;
import com.bytedance.sdk.component.utils.vl;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt extends cw<RoundImageView> {

    /* renamed from: j, reason: collision with root package name */
    protected String f23826j;
    protected ImageView.ScaleType ll;
    protected boolean oy;
    private float px;
    private int qe;
    private float xw;
    protected String yl;

    private void qb() {
        if (TextUtils.isEmpty(this.f23826j)) {
            return;
        }
        ((RoundImageView) this.up).setImageDrawable(null);
        if (this.f23826j.startsWith("local://")) {
            try {
                String replace = this.f23826j.replace("local://", "");
                if (TextUtils.equals(ae(), ResIdentify.RES_TYPE_RAW)) {
                    ((RoundImageView) this.up).setImageResource(r.j(this.xt, replace));
                    return;
                } else {
                    ((RoundImageView) this.up).setImageResource(r.xt(this.xt, replace));
                    return;
                }
            } catch (Throwable unused) {
                return;
            }
        }
        if (!this.f23826j.startsWith("@")) {
            ya();
            return;
        }
        try {
            ((RoundImageView) this.up).setImageResource(Integer.parseInt(this.f23826j.substring(1)));
        } catch (Exception e6) {
            vl.j(e6);
        }
    }

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

    private void ya() {
        if (this.px > 0.0f) {
            ae aeVar = this.ik;
            if (aeVar != null) {
                aeVar.j();
            }
            com.bytedance.adsdk.ugeno.r.j().xt().j(this.f23861g, this.f23826j, new j.InterfaceC0320j() { // from class: com.bytedance.adsdk.ugeno.widget.image.xt.1
                @Override // com.bytedance.adsdk.ugeno.j.InterfaceC0320j
                public void j(Bitmap bitmap) {
                    if (bitmap == null) {
                        if (((cw) xt.this).ik != null) {
                            ae aeVar2 = ((cw) xt.this).ik;
                            xt xtVar = xt.this;
                            aeVar2.xt(xtVar, xtVar.f23826j);
                            return;
                        }
                        return;
                    }
                    if (((cw) xt.this).ik != null) {
                        ae aeVar3 = ((cw) xt.this).ik;
                        xt xtVar2 = xt.this;
                        aeVar3.j(xtVar2, xtVar2.f23826j);
                    }
                    final Bitmap j6 = tl.j(((cw) xt.this).xt, bitmap, (int) xt.this.px);
                    if (j6 != null) {
                        tl.j(new Runnable() { // from class: com.bytedance.adsdk.ugeno.widget.image.xt.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ((RoundImageView) ((cw) xt.this).up).setImageBitmap(j6);
                            }
                        });
                    }
                    xt xtVar3 = xt.this;
                    if (xtVar3.oy || xtVar3.xw > 0.0f) {
                        Bitmap j7 = tl.j(((cw) xt.this).xt, bitmap, xt.this.xw > 0.0f ? (int) xt.this.xw : 10);
                        if (j7 != null) {
                            final BitmapDrawable bitmapDrawable = new BitmapDrawable(((cw) xt.this).xt.getResources(), j7);
                            tl.j(new Runnable() { // from class: com.bytedance.adsdk.ugeno.widget.image.xt.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    ((RoundImageView) ((cw) xt.this).up).setBackground(bitmapDrawable);
                                }
                            });
                        }
                    }
                }
            });
            return;
        }
        ae aeVar2 = this.ik;
        if (aeVar2 != null) {
            aeVar2.j();
        }
        com.bytedance.adsdk.ugeno.j xt = com.bytedance.adsdk.ugeno.r.j().xt();
        ws wsVar = this.f23861g;
        String str = this.f23826j;
        T t5 = this.up;
        xt.j(wsVar, str, (ImageView) t5, ((RoundImageView) t5).getWidth(), ((RoundImageView) this.up).getHeight(), new j.InterfaceC0320j() { // from class: com.bytedance.adsdk.ugeno.widget.image.xt.2
            @Override // com.bytedance.adsdk.ugeno.j.InterfaceC0320j
            public void j(Bitmap bitmap) {
                if (bitmap == null) {
                    if (((cw) xt.this).ik != null) {
                        ae aeVar3 = ((cw) xt.this).ik;
                        xt xtVar = xt.this;
                        aeVar3.xt(xtVar, xtVar.f23826j);
                        return;
                    }
                    return;
                }
                if (((cw) xt.this).ik != null) {
                    ae aeVar4 = ((cw) xt.this).ik;
                    xt xtVar2 = xt.this;
                    aeVar4.j(xtVar2, xtVar2.f23826j);
                }
            }
        });
        if (this.oy || this.xw > 0.0f) {
            com.bytedance.adsdk.ugeno.r.j().xt().j(this.f23861g, this.f23826j, new j.InterfaceC0320j() { // from class: com.bytedance.adsdk.ugeno.widget.image.xt.3
                @Override // com.bytedance.adsdk.ugeno.j.InterfaceC0320j
                public void j(Bitmap bitmap) {
                    if (bitmap == null) {
                        return;
                    }
                    final Bitmap j6 = tl.j(((cw) xt.this).xt, bitmap, xt.this.xw > 0.0f ? (int) xt.this.xw : 10);
                    tl.j(new Runnable() { // from class: com.bytedance.adsdk.ugeno.widget.image.xt.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (j6 != null) {
                                ((RoundImageView) ((cw) xt.this).up).setBackground(new BitmapDrawable(((cw) xt.this).xt.getResources(), j6));
                            }
                        }
                    });
                }
            });
        }
    }

    protected String ae() {
        return this.yl;
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw, com.bytedance.adsdk.ugeno.cw
    public void m() {
        super.m();
        Drawable drawable = ((RoundImageView) this.up).getDrawable();
        if (Build.VERSION.SDK_INT < 28 || !a.a(drawable)) {
            return;
        }
        b.a(drawable).stop();
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    /* renamed from: tl, reason: merged with bridge method [inline-methods] */
    public RoundImageView j() {
        RoundImageView roundImageView = new RoundImageView(this.xt);
        roundImageView.j(this);
        return roundImageView;
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw, com.bytedance.adsdk.ugeno.cw
    public void up() {
        super.up();
        ((RoundImageView) this.up).post(new Runnable() { // from class: com.bytedance.adsdk.ugeno.widget.image.xt.4
            @Override // java.lang.Runnable
            public void run() {
                Drawable drawable = ((RoundImageView) ((cw) xt.this).up).getDrawable();
                if (Build.VERSION.SDK_INT < 28 || !a.a(drawable)) {
                    return;
                }
                b.a(drawable).start();
            }
        });
    }

    public void vl(String str) {
        this.f23826j = str;
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    public void xt() {
        super.xt();
        qb();
        ((RoundImageView) this.up).setScaleType(this.ll);
        ((RoundImageView) this.up).setBorderColor(this.xq);
        ((RoundImageView) this.up).setCornerRadius(this.ol);
        ((RoundImageView) this.up).setBorderWidth(this.sm);
        int i6 = this.qe;
        if (i6 != -1) {
            ((RoundImageView) this.up).setColorFilter(i6);
        }
    }

    public xt(Context context) {
        super(context);
        this.ll = ImageView.ScaleType.FIT_XY;
        this.qe = -1;
        this.px = -1.0f;
        this.xw = -1.0f;
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
                this.ll = qv(str2);
                break;
            case "imageBlur":
                this.px = com.bytedance.adsdk.ugeno.m.cw.j(str2, -1.0f);
                break;
            case "isBgGaussianBlur":
                this.oy = com.bytedance.adsdk.ugeno.m.cw.j(str2, false);
                break;
            case "src":
                this.f23826j = str2;
                break;
            case "tintColor":
                this.qe = com.bytedance.adsdk.ugeno.m.j.j(str2);
                break;
            case "imageBgBlur":
                this.xw = com.bytedance.adsdk.ugeno.m.cw.j(str2, -1.0f);
                break;
        }
    }

    public void xt(Drawable drawable) {
        ((RoundImageView) this.up).setImageDrawable(drawable);
    }
}
