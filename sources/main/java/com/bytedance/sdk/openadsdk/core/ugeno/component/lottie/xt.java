package com.bytedance.sdk.openadsdk.core.ugeno.component.lottie;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.adsdk.lottie.g;
import com.bytedance.adsdk.lottie.r;
import com.bytedance.adsdk.ugeno.j;
import com.bytedance.adsdk.ugeno.m.tl;
import com.bytedance.adsdk.ugeno.xt.cw;
import java.util.HashMap;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt extends cw<UgenLottieView> {

    /* renamed from: d, reason: collision with root package name */
    private int f30640d;
    private float fx;

    /* renamed from: j, reason: collision with root package name */
    protected String f30641j;
    protected HashMap<String, Bitmap> ll;
    protected ImageView.ScaleType oy;
    private boolean px;
    private String qe;
    private float tk;
    private boolean wi;

    @Deprecated
    private boolean xw;
    protected ImageView.ScaleType yl;

    /* renamed from: com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.xt$1, reason: invalid class name */
    class AnonymousClass1 implements r {
        @Override // com.bytedance.adsdk.lottie.r
        public Bitmap j(final g gVar) {
            final String str;
            if (gVar == null) {
                return null;
            }
            String jy = gVar.jy();
            String vl = gVar.vl();
            if (!TextUtils.isEmpty(jy) && TextUtils.isEmpty(vl)) {
                str = com.bytedance.adsdk.ugeno.r.xt.j(jy, ((cw) xt.this).f23872r);
            } else if (!TextUtils.isEmpty(vl) && TextUtils.isEmpty(jy)) {
                str = com.bytedance.adsdk.ugeno.r.xt.j(vl, ((cw) xt.this).f23872r);
            } else if (TextUtils.isEmpty(vl) || TextUtils.isEmpty(jy)) {
                str = null;
            } else {
                str = com.bytedance.adsdk.ugeno.r.xt.j(jy, ((cw) xt.this).f23872r) + com.bytedance.adsdk.ugeno.r.xt.j(vl, ((cw) xt.this).f23872r);
            }
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Bitmap bitmap = xt.this.ll.get(str);
            if (bitmap != null) {
                return bitmap;
            }
            com.bytedance.adsdk.ugeno.r.j().xt().j(((cw) xt.this).f23861g, str, new j.InterfaceC0320j() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.xt.1.1
                @Override // com.bytedance.adsdk.ugeno.j.InterfaceC0320j
                public void j(Bitmap bitmap2) {
                    if (bitmap2 != null) {
                        final Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap2, gVar.j(), gVar.xt(), false);
                        xt.this.ll.put(str, createScaledBitmap);
                        tl.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.xt.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ((UgenLottieView) ((cw) xt.this).up).j(gVar.qv(), createScaledBitmap);
                            }
                        });
                    }
                }
            });
            return xt.this.ll.get(str);
        }

        AnonymousClass1() {
        }
    }

    private ImageView.ScaleType jy(String str) {
        ImageView.ScaleType scaleType;
        scaleType = ImageView.ScaleType.FIT_XY;
        str.getClass();
        switch (str) {
            case "center":
            case "none":
                return ImageView.ScaleType.CENTER;
            case "fit":
                return ImageView.ScaleType.FIT_CENTER;
            case "crop":
                return ImageView.ScaleType.CENTER_CROP;
            default:
                return scaleType;
        }
    }

    private ImageView.ScaleType vl(String str) {
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

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    /* renamed from: ae, reason: merged with bridge method [inline-methods] */
    public UgenLottieView j() {
        UgenLottieView ugenLottieView = new UgenLottieView(this.xt);
        ugenLottieView.j(this);
        return ugenLottieView;
    }

    protected void tl() {
        ((UgenLottieView) this.up).j();
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    public void xt() {
        super.xt();
        ((UgenLottieView) this.up).setProgress(this.tk);
        if (this.fx <= 0.0f) {
            this.fx = 1.0f;
        }
        ((UgenLottieView) this.up).setSpeed(this.fx);
        if (this.f30641j.startsWith("local")) {
            ((UgenLottieView) this.up).setAnimation(qv(this.f30641j));
            ((UgenLottieView) this.up).setImageAssetsFolder(this.qe);
        } else {
            ((UgenLottieView) this.up).setAnimationFromUrl(this.f30641j);
        }
        ((UgenLottieView) this.up).setImageAssetDelegate(new AnonymousClass1());
        if (p()) {
            ((UgenLottieView) this.up).setScaleType(this.yl);
        } else {
            ((UgenLottieView) this.up).setScaleType(this.oy);
        }
        if (p()) {
            ((UgenLottieView) this.up).setRepeatCount(this.f30640d);
        } else {
            ((UgenLottieView) this.up).j(this.xw);
        }
        tl();
    }

    public xt(Context context) {
        super(context);
        this.qe = "images";
        this.fx = 1.0f;
        this.oy = ImageView.ScaleType.FIT_CENTER;
        this.yl = ImageView.ScaleType.FIT_XY;
        this.ll = new HashMap<>();
    }

    private String qv(String str) {
        if (TextUtils.isEmpty(str) || !str.contains("local")) {
            return "";
        }
        if (str.contains("shake_phone")) {
            return "lottie_json/shake_phone.json";
        }
        if (!str.contains("swipe_right")) {
            return "";
        }
        return "lottie_json/swipe_right.json";
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
                this.yl = jy(str2);
                break;
            case "scaleType":
                this.oy = vl(str2);
                break;
            case "progress":
                this.tk = com.bytedance.adsdk.ugeno.m.cw.j(str2, 0.0f);
                break;
            case "imagePath":
                this.qe = str2;
                break;
            case "autoReverse":
                this.px = com.bytedance.adsdk.ugeno.m.cw.j(str2, false);
                break;
            case "src":
                this.f30641j = str2;
                break;
            case "loop":
                if (p()) {
                    this.f30640d = com.bytedance.adsdk.ugeno.m.cw.j(str2, 0);
                    break;
                } else {
                    this.xw = com.bytedance.adsdk.ugeno.m.cw.j(str2, false);
                    break;
                }
            case "speed":
                this.fx = com.bytedance.adsdk.ugeno.m.cw.j(str2, 1.0f);
                break;
            case "autoPlay":
                this.wi = com.bytedance.adsdk.ugeno.m.cw.j(str2, false);
                break;
            case "autoplay":
                this.wi = com.bytedance.adsdk.ugeno.m.cw.j(str2, true);
                break;
        }
    }
}
