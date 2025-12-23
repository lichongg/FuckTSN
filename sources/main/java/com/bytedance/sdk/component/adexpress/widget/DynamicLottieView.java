package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.adsdk.lottie.cw;
import com.bytedance.adsdk.lottie.g;
import com.bytedance.adsdk.lottie.kt;
import com.bytedance.adsdk.lottie.r;
import com.bytedance.sdk.component.m.av;
import com.bytedance.sdk.component.m.qv;
import com.bytedance.sdk.component.m.tl;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.tencent.open.SocialConstants;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class DynamicLottieView extends LottieAnimationView {
    private int ae;
    private boolean cw;

    /* renamed from: j, reason: collision with root package name */
    private Map<String, Bitmap> f25898j;

    /* renamed from: m, reason: collision with root package name */
    private int f25899m;

    /* renamed from: r, reason: collision with root package name */
    private boolean f25900r;
    private Map<String, String> tl;
    private int up;
    private String xt;

    private void oq() {
        setAnimationFromUrl("https://sf3-fe-tos.pglstatp-toutiao.com/obj/ad-pattern/static/lotties/" + this.xt + ".json");
        setImageAssetDelegate(new r() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicLottieView.1
            @Override // com.bytedance.adsdk.lottie.r
            public Bitmap j(final g gVar) {
                final String vl;
                vl = gVar.vl();
                vl.getClass();
                switch (vl) {
                    case "{appIcon}":
                        if (DynamicLottieView.this.tl != null) {
                            vl = (String) DynamicLottieView.this.tl.get("icon");
                            break;
                        }
                        break;
                    case "{adImage}":
                    case "{slot}":
                        if (DynamicLottieView.this.tl != null) {
                            vl = (String) DynamicLottieView.this.tl.get("imageUrl");
                            break;
                        }
                        break;
                }
                Bitmap bitmap = (Bitmap) DynamicLottieView.this.f25898j.get(vl);
                if (bitmap != null) {
                    return bitmap;
                }
                com.bytedance.sdk.component.adexpress.j.j.j.j().up().j(vl).cw(2).j(new tl() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicLottieView.1.2
                    @Override // com.bytedance.sdk.component.m.tl
                    @ATSMethod(1)
                    public Bitmap j(Bitmap bitmap2) {
                        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap2, gVar.j(), gVar.xt(), false);
                        DynamicLottieView.this.f25898j.put(vl, createScaledBitmap);
                        return createScaledBitmap;
                    }
                }).j(new av<Bitmap>() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicLottieView.1.1
                    @Override // com.bytedance.sdk.component.m.av
                    @ATSMethod(2)
                    public void j(int i6, String str, Throwable th) {
                    }

                    @Override // com.bytedance.sdk.component.m.av
                    @ATSMethod(1)
                    public void j(qv<Bitmap> qvVar) {
                        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(qvVar.cw(), gVar.j(), gVar.xt(), false);
                        DynamicLottieView.this.f25898j.put(vl, createScaledBitmap);
                        DynamicLottieView.this.j(gVar.qv(), createScaledBitmap);
                    }
                });
                return (Bitmap) DynamicLottieView.this.f25898j.get(vl);
            }
        });
        if (this.tl != null) {
            kt ktVar = new kt(this);
            String str = this.tl.get("app_name");
            String str2 = this.tl.get(SocialConstants.PARAM_COMMENT);
            String str3 = this.tl.get("title");
            if (this.up > 0 && str.length() > this.up) {
                str = str.substring(0, this.up - 1) + "...";
            } else if (this.up <= 0) {
                str = "";
            }
            if (this.f25899m > 0 && str3.length() > this.f25899m) {
                str3 = str3.substring(0, this.f25899m - 1) + "...";
            } else if (this.up <= 0) {
                str3 = "";
            }
            if (this.ae > 0 && str2.length() > this.ae) {
                str2 = str2.substring(0, this.ae - 1) + "...";
            } else if (this.up <= 0) {
                str2 = "";
            }
            ktVar.xt("{appName}", str);
            ktVar.xt("{adTitle}", str3);
            ktVar.xt("{adDesc}", str2);
            setTextDelegate(ktVar);
            setFontAssetDelegate(new cw() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicLottieView.2
                @Override // com.bytedance.adsdk.lottie.cw
                public String xt(String str4) {
                    return null;
                }

                @Override // com.bytedance.adsdk.lottie.cw
                public Typeface j(String str4) {
                    return Typeface.MONOSPACE;
                }
            });
        }
        j();
    }

    private void qv() {
        setAnimationFromUrl(this.xt);
        setImageAssetDelegate(new r() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicLottieView.3
            @Override // com.bytedance.adsdk.lottie.r
            public Bitmap j(final g gVar) {
                if (gVar == null) {
                    return null;
                }
                final String jy = gVar.jy();
                String vl = gVar.vl();
                if (TextUtils.isEmpty(jy) || !TextUtils.isEmpty(vl)) {
                    if (!TextUtils.isEmpty(vl) && TextUtils.isEmpty(jy)) {
                        jy = vl;
                    } else if (TextUtils.isEmpty(vl) || TextUtils.isEmpty(jy)) {
                        jy = "";
                    } else {
                        jy = jy + vl;
                    }
                }
                if (TextUtils.isEmpty(jy)) {
                    return null;
                }
                Bitmap bitmap = DynamicLottieView.this.f25898j == null ? null : (Bitmap) DynamicLottieView.this.f25898j.get(jy);
                if (bitmap != null) {
                    return bitmap;
                }
                com.bytedance.sdk.component.adexpress.j.j.j.j().up().j(jy).j(new tl() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicLottieView.3.2
                    @Override // com.bytedance.sdk.component.m.tl
                    @ATSMethod(1)
                    public Bitmap j(Bitmap bitmap2) {
                        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap2, gVar.j(), gVar.xt(), false);
                        if (DynamicLottieView.this.f25898j != null) {
                            DynamicLottieView.this.f25898j.put(jy, createScaledBitmap);
                        }
                        return createScaledBitmap;
                    }
                }).j(new av<Bitmap>() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicLottieView.3.1
                    @Override // com.bytedance.sdk.component.m.av
                    @ATSMethod(2)
                    public void j(int i6, String str, Throwable th) {
                    }

                    @Override // com.bytedance.sdk.component.m.av
                    @ATSMethod(1)
                    public void j(qv<Bitmap> qvVar) {
                        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(qvVar.cw(), gVar.j(), gVar.xt(), false);
                        if (DynamicLottieView.this.f25898j != null) {
                            DynamicLottieView.this.f25898j.put(jy, createScaledBitmap);
                        }
                        DynamicLottieView.this.j(gVar.qv(), createScaledBitmap);
                    }
                });
                if (DynamicLottieView.this.f25898j == null) {
                    return null;
                }
                return (Bitmap) DynamicLottieView.this.f25898j.get(jy);
            }
        });
        j();
    }

    public void g() {
        if (TextUtils.isEmpty(this.xt)) {
            return;
        }
        setProgress(0.0f);
        j(this.cw);
        if (this.f25900r) {
            qv();
        } else {
            oq();
        }
    }

    public void setAnimationsLoop(boolean z5) {
        this.cw = z5;
    }

    public void setData(Map<String, String> map) {
        this.tl = map;
    }

    public void setImageLottieTosPath(String str) {
        this.xt = str;
    }

    public void setLottieAdDescMaxLength(int i6) {
        this.ae = i6;
    }

    public void setLottieAdTitleMaxLength(int i6) {
        this.f25899m = i6;
    }

    public void setLottieAppNameMaxLength(int i6) {
        this.up = i6;
    }

    public void setOnlyLoadNetImage(boolean z5) {
        this.f25900r = z5;
    }

    public DynamicLottieView(Context context) {
        super(context);
        this.f25898j = new HashMap();
    }

    @Override // com.bytedance.adsdk.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        g();
    }

    @Override // com.bytedance.adsdk.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m();
    }
}
