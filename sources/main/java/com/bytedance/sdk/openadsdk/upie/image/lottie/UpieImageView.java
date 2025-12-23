package com.bytedance.sdk.openadsdk.upie.image.lottie;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bykv.vk.openvk.component.video.api.cw.xt;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.adsdk.lottie.g;
import com.bytedance.adsdk.lottie.kt;
import com.bytedance.adsdk.lottie.r;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.upie.xt;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class UpieImageView extends FrameLayout {
    private final Map<String, Integer> ae;
    private volatile LottieAnimationView cw;

    /* renamed from: g, reason: collision with root package name */
    private int f31866g;

    /* renamed from: j, reason: collision with root package name */
    private final Context f31867j;

    /* renamed from: m, reason: collision with root package name */
    private final Map<String, Bitmap> f31868m;
    private j oq;
    private long qv;

    /* renamed from: r, reason: collision with root package name */
    private String f31869r;
    private int tl;
    private Bitmap up;
    private ImageView xt;

    static /* synthetic */ int cw(UpieImageView upieImageView) {
        int i6 = upieImageView.f31866g;
        upieImageView.f31866g = i6 + 1;
        return i6;
    }

    static /* synthetic */ int tl(UpieImageView upieImageView) {
        int i6 = upieImageView.tl;
        upieImageView.tl = i6 + 1;
        return i6;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType != null) {
            if (this.cw != null) {
                this.cw.setScaleType(scaleType);
                return;
            }
            ImageView imageView = this.xt;
            if (imageView != null) {
                imageView.setScaleType(scaleType);
            }
        }
    }

    public UpieImageView(Context context, com.bytedance.sdk.openadsdk.upie.j jVar, j jVar2) {
        super(context);
        this.f31868m = new HashMap();
        this.ae = new HashMap();
        this.tl = 0;
        this.f31866g = 0;
        this.f31867j = context;
        this.oq = jVar2;
        j(jVar, jVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(final String str) {
        if (TextUtils.isEmpty(str)) {
            new xt(60008, 10002, "广告主图url为空");
        } else {
            com.bytedance.sdk.openadsdk.upie.xt.j().xt(str, new xt.j<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView.4
                @Override // com.bytedance.sdk.openadsdk.upie.xt.j
                public void j(Bitmap bitmap) {
                    UpieImageView.this.up = bitmap;
                    final Bitmap j6 = com.bytedance.sdk.component.adexpress.r.xt.j(UpieImageView.this.f31867j, UpieImageView.this.up, 25);
                    com.bytedance.sdk.openadsdk.upie.j.xt.xt(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (UpieImageView.this.cw != null) {
                                UpieImageView.this.cw.invalidate();
                            }
                            UpieImageView.this.xt.setImageBitmap(UpieImageView.this.up);
                            UpieImageView.this.xt.setScaleType(ImageView.ScaleType.FIT_CENTER);
                            if (j6 != null) {
                                UpieImageView.this.xt.setBackground(new BitmapDrawable(j6));
                            }
                        }
                    });
                }

                @Override // com.bytedance.sdk.openadsdk.upie.xt.j
                public void j(int i6, String str2) {
                    UpieImageView.tl(UpieImageView.this);
                    if (UpieImageView.this.tl <= 3) {
                        UpieImageView.this.xt(str);
                    } else {
                        new com.bykv.vk.openvk.component.video.api.cw.xt(60008, 10003, "广告主图url加载失败");
                    }
                }
            });
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.cw != null && this.f31869r != null) {
            this.cw.j();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.cw != null) {
            this.cw.m();
        }
    }

    public synchronized void j(final com.bytedance.sdk.openadsdk.upie.j jVar, j jVar2) {
        if (jVar == null) {
            return;
        }
        try {
            if (this.cw != null) {
                return;
            }
            this.oq = jVar2;
            final String cw = jVar.cw();
            String j6 = jVar.j();
            if (!TextUtils.isEmpty(j6)) {
                this.cw = new LottieAnimationView(this.f31867j);
                this.cw.setRepeatCount(-1);
                this.cw.setRepeatMode(1);
                this.cw.setClickable(false);
                this.cw.setImageAssetDelegate(new r() { // from class: com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView.1
                    @Override // com.bytedance.adsdk.lottie.r
                    public Bitmap j(g gVar) {
                        if (gVar != null) {
                            String vl = gVar.vl();
                            if (!TextUtils.isEmpty(vl)) {
                                if (vl.startsWith("${") && vl.endsWith("}")) {
                                    vl = com.bytedance.sdk.openadsdk.upie.j.j.j(vl, jVar.ae());
                                    if (TextUtils.isEmpty(vl)) {
                                        return null;
                                    }
                                    if (TextUtils.equals(cw, vl)) {
                                        Bitmap bitmap = UpieImageView.this.up;
                                        if (bitmap != null && (bitmap.getWidth() != gVar.j() || bitmap.getHeight() != gVar.xt())) {
                                            UpieImageView.this.up = Bitmap.createScaledBitmap(bitmap, gVar.j(), gVar.xt(), false);
                                        }
                                        return UpieImageView.this.up;
                                    }
                                }
                                Bitmap bitmap2 = (Bitmap) UpieImageView.this.f31868m.get(vl);
                                if (bitmap2 != null) {
                                    return bitmap2;
                                }
                                UpieImageView.this.j(vl, gVar.j(), gVar.xt());
                            }
                        }
                        return null;
                    }
                });
                this.cw.setTextDelegate(new kt(this.cw) { // from class: com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView.2
                    @Override // com.bytedance.adsdk.lottie.kt
                    public String j(String str) {
                        return com.bytedance.sdk.openadsdk.upie.j.j.j(str, jVar.ae());
                    }
                });
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            ImageView imageView = new ImageView(this.f31867j);
            this.xt = imageView;
            addView(imageView, layoutParams);
            if (this.cw != null) {
                addView(this.cw, layoutParams);
            }
            this.qv = SystemClock.elapsedRealtime();
            j(j6);
            xt(cw);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final String str) {
        if (TextUtils.isEmpty(str)) {
            j(10000, "lottieJsonUrl为空");
        } else {
            com.bytedance.sdk.openadsdk.upie.j.xt.cw(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView.3
                @Override // java.lang.Runnable
                public void run() {
                    String j6 = com.bytedance.sdk.openadsdk.upie.xt.j().j(str);
                    if (!TextUtils.isEmpty(j6)) {
                        UpieImageView.this.j(j6, str);
                    } else {
                        com.bytedance.sdk.openadsdk.upie.xt.j().j(str, new xt.j<String>() { // from class: com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView.3.1
                            @Override // com.bytedance.sdk.openadsdk.upie.xt.j
                            public void j(String str2) {
                                vl.j("UpieImageView", "--==-- lottie jsonStr ok");
                                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                UpieImageView.this.j(str2, str);
                            }

                            @Override // com.bytedance.sdk.openadsdk.upie.xt.j
                            public void j(int i6, String str2) {
                                vl.j("UpieImageView", "--==-- lottie jsonStr load fail: " + i6 + ", " + str2);
                                if (i6 == 10006) {
                                    UpieImageView.this.j(i6, str2);
                                    return;
                                }
                                UpieImageView.cw(UpieImageView.this);
                                if (UpieImageView.this.f31866g > 3) {
                                    UpieImageView.this.j(i6, str2);
                                } else {
                                    AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                    UpieImageView.this.j(str);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final String str, final int i6, final int i7) {
        Integer num = this.ae.get(str);
        if (num == null || num.intValue() != 1) {
            this.ae.put(str, 1);
            com.bytedance.sdk.openadsdk.upie.xt.j().j(this.f31867j, str, new xt.j<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView.5
                @Override // com.bytedance.sdk.openadsdk.upie.xt.j
                public void j(Bitmap bitmap) {
                    if (bitmap != null) {
                        if (bitmap.getWidth() != i6 || bitmap.getHeight() != i7) {
                            bitmap = Bitmap.createScaledBitmap(bitmap, i6, i7, false);
                        }
                        UpieImageView.this.f31868m.put(str, bitmap);
                        com.bytedance.sdk.openadsdk.upie.j.xt.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (UpieImageView.this.cw != null) {
                                    UpieImageView.this.cw.invalidate();
                                }
                            }
                        });
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.upie.xt.j
                public void j(int i8, String str2) {
                    UpieImageView.this.ae.put(str, 2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i6, String str) {
        j jVar = this.oq;
        if (jVar != null) {
            jVar.j(i6, str);
        }
        com.bytedance.sdk.openadsdk.upie.j.xt.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView.6
            @Override // java.lang.Runnable
            public void run() {
                if (UpieImageView.this.cw != null) {
                    UpieImageView upieImageView = UpieImageView.this;
                    upieImageView.removeView(upieImageView.cw);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(long j6) {
        if (this.oq != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("duration", Long.valueOf(j6 - this.qv));
            this.oq.j(hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final String str, final String str2) {
        this.f31869r = str;
        com.bytedance.sdk.openadsdk.upie.j.xt.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (UpieImageView.this.cw != null) {
                    UpieImageView.this.cw.j(str, str2);
                    UpieImageView.this.cw.j(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView.7.1
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                            UpieImageView.this.cw.xt(this);
                            UpieImageView.this.j(SystemClock.elapsedRealtime());
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                        }
                    });
                    UpieImageView.this.cw.j();
                }
            }
        });
    }
}
