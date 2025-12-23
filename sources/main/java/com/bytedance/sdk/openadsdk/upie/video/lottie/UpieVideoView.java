package com.bytedance.sdk.openadsdk.upie.video.lottie;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bykv.vk.openvk.component.video.api.renderview.SSRenderTextureView;
import com.bykv.vk.openvk.component.video.api.renderview.xt;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.adsdk.lottie.kt;
import com.bytedance.adsdk.lottie.r;
import com.bytedance.adsdk.lottie.tj;
import com.bytedance.sdk.openadsdk.upie.xt;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class UpieVideoView extends FrameLayout implements com.bykv.vk.openvk.component.video.api.renderview.xt {
    private xt.j ae;
    private final Map<String, Bitmap> cw;

    /* renamed from: j, reason: collision with root package name */
    private final com.bykv.vk.openvk.component.video.api.renderview.xt f31890j;

    /* renamed from: m, reason: collision with root package name */
    private final Runnable f31891m;

    /* renamed from: r, reason: collision with root package name */
    private final Map<String, Integer> f31892r;
    private final Handler up;
    private final LottieAnimationView xt;

    @Override // com.bykv.vk.openvk.component.video.api.renderview.xt
    public SurfaceHolder getHolder() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cw() {
        this.up.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        cw();
        if (this.xt != null) {
            this.up.postDelayed(this.f31891m, 40L);
        }
    }

    public LottieAnimationView getLottieAnimationView() {
        return this.xt;
    }

    public void setWindowVisibilityChangedListener(xt.j jVar) {
        this.ae = jVar;
    }

    public void xt() {
        com.bytedance.sdk.openadsdk.upie.j.xt.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                UpieVideoView.this.cw();
            }
        });
    }

    public UpieVideoView(final Context context, final com.bytedance.sdk.openadsdk.upie.j jVar) {
        super(context);
        this.cw = new HashMap();
        this.f31892r = new HashMap();
        this.up = new Handler(Looper.getMainLooper());
        this.f31891m = new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                if (UpieVideoView.this.xt != null && UpieVideoView.this.xt.up()) {
                    UpieVideoView.this.xt.invalidate();
                }
                UpieVideoView.this.up.postDelayed(UpieVideoView.this.f31891m, 40L);
            }
        };
        SSRenderTextureView sSRenderTextureView = new SSRenderTextureView(context);
        this.f31890j = sSRenderTextureView;
        addView(sSRenderTextureView.getView());
        sSRenderTextureView.getView().setTranslationX(2.1474836E9f);
        LottieAnimationView lottieAnimationView = new LottieAnimationView(context);
        this.xt = lottieAnimationView;
        lottieAnimationView.setImageAssetDelegate(new r() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.1
            /* JADX WARN: Code restructure failed: missing block: B:14:0x0035, code lost:
            
                if (r1.startsWith(master.flame.danmaku.danmaku.parser.b.f50154a) != false) goto L17;
             */
            @Override // com.bytedance.adsdk.lottie.r
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public android.graphics.Bitmap j(com.bytedance.adsdk.lottie.g r6) {
                /*
                    r5 = this;
                    r0 = 0
                    if (r6 == 0) goto L56
                    java.lang.String r1 = r6.vl()
                    boolean r2 = android.text.TextUtils.isEmpty(r1)
                    if (r2 != 0) goto L56
                    java.lang.String r2 = "${"
                    boolean r2 = r1.startsWith(r2)
                    if (r2 == 0) goto L38
                    java.lang.String r2 = "}"
                    boolean r2 = r1.endsWith(r2)
                    if (r2 == 0) goto L38
                    com.bytedance.sdk.openadsdk.upie.j r2 = r2
                    if (r2 == 0) goto L37
                    org.json.JSONObject r2 = r2.ae()
                    java.lang.String r1 = com.bytedance.sdk.openadsdk.upie.j.j.j(r1, r2)
                    boolean r2 = android.text.TextUtils.isEmpty(r1)
                    if (r2 != 0) goto L37
                    java.lang.String r2 = "http"
                    boolean r2 = r1.startsWith(r2)
                    if (r2 != 0) goto L38
                L37:
                    return r0
                L38:
                    com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView r2 = com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.this
                    java.util.Map r2 = com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.j(r2)
                    java.lang.Object r2 = r2.get(r1)
                    android.graphics.Bitmap r2 = (android.graphics.Bitmap) r2
                    if (r2 == 0) goto L47
                    return r2
                L47:
                    com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView r2 = com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.this
                    android.content.Context r3 = r3
                    int r4 = r6.j()
                    int r6 = r6.xt()
                    com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.j(r2, r3, r1, r4, r6)
                L56:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.AnonymousClass1.j(com.bytedance.adsdk.lottie.g):android.graphics.Bitmap");
            }
        });
        lottieAnimationView.setTextDelegate(new kt(lottieAnimationView) { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.2
            @Override // com.bytedance.adsdk.lottie.kt
            public String j(String str) {
                com.bytedance.sdk.openadsdk.upie.j jVar2 = jVar;
                return com.bytedance.sdk.openadsdk.upie.j.j.j(str, jVar2 != null ? jVar2.ae() : null);
            }
        });
        lottieAnimationView.setViewDelegate(new tj() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.3
            @Override // com.bytedance.adsdk.lottie.tj
            public View j(String str, Map<String, Object> map) {
                if ("videoview:".equals(str)) {
                    return UpieVideoView.this.f31890j.getView();
                }
                return null;
            }
        });
        lottieAnimationView.setRepeatMode(1);
        lottieAnimationView.setRepeatCount(-1);
        lottieAnimationView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        lottieAnimationView.setClickable(false);
        lottieAnimationView.j(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (UpieVideoView.this.xt != null) {
                    UpieVideoView.this.xt.xt(this);
                }
                UpieVideoView.this.r();
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
        lottieAnimationView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.5
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (UpieVideoView.this.xt == view) {
                    UpieVideoView.this.cw();
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
            }
        });
        addView(lottieAnimationView, new FrameLayout.LayoutParams(-1, -2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Context context, final String str, final int i6, final int i7) {
        Integer num = this.f31892r.get(str);
        if (num == null || num.intValue() != 1) {
            this.f31892r.put(str, 1);
            com.bytedance.sdk.openadsdk.upie.xt.j().j(context, str, new xt.j<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.7
                @Override // com.bytedance.sdk.openadsdk.upie.xt.j
                public void j(Bitmap bitmap) {
                    if (bitmap != null) {
                        if (bitmap.getWidth() != i6 || bitmap.getHeight() != i7) {
                            bitmap = Bitmap.createScaledBitmap(bitmap, i6, i7, false);
                        }
                        UpieVideoView.this.cw.put(str, bitmap);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.upie.xt.j
                public void j(int i8, String str2) {
                    UpieVideoView.this.f31892r.put(str, 2);
                }
            });
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        super.onLayout(z5, i6, i7, i8, i9);
        LottieAnimationView lottieAnimationView = this.xt;
        if (lottieAnimationView != null) {
            lottieAnimationView.invalidate();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i6) {
        super.onWindowVisibilityChanged(i6);
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.xt
    public void j(com.bykv.vk.openvk.component.video.api.renderview.j jVar) {
        com.bykv.vk.openvk.component.video.api.renderview.xt xtVar = this.f31890j;
        if (xtVar != null) {
            xtVar.j(jVar);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.xt
    public void j(int i6, int i7) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i7;
        layoutParams.width = i6;
        setLayoutParams(layoutParams);
    }

    public void j() {
        com.bytedance.sdk.openadsdk.upie.j.xt.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                UpieVideoView.this.r();
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.xt
    public View getView() {
        return this;
    }
}
