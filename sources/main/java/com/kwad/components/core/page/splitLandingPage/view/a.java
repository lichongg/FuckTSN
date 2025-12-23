package com.kwad.components.core.page.splitLandingPage.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.t.o;
import com.kwad.components.core.video.a;
import com.kwad.components.core.video.e;
import com.kwad.components.core.video.g;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.h;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.core.video.videoview.a;
import com.kwad.sdk.o.m;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    private ViewGroup Cc;
    private ImageView No;

    @Nullable
    private WindowManager Vl;
    private com.kwad.components.core.page.splitLandingPage.a.a Vm;
    private FrameLayout Vn;
    private FrameLayout Vo;
    private e Vp;
    private final WindowManager.LayoutParams Vq = new WindowManager.LayoutParams();
    private InterfaceC0630a Vr;
    private com.kwad.sdk.core.video.videoview.a cq;
    private a.InterfaceC0692a cz;
    private ImageView hM;
    private Context mContext;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.components.core.page.splitLandingPage.view.a$a, reason: collision with other inner class name */
    public interface InterfaceC0630a {
        boolean rK();
    }

    private void c(@NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        final AdTemplate adTemplate = this.Vm.getAdTemplate();
        AdInfo el = com.kwad.sdk.core.response.b.e.el(adTemplate);
        String url = com.kwad.sdk.core.response.b.a.bu(el).getUrl();
        if (TextUtils.isEmpty(url)) {
            this.hM.setVisibility(8);
        } else {
            this.hM.setImageDrawable(null);
            KSImageLoader.loadImage(this.hM, url, adTemplate);
            this.hM.setVisibility(0);
        }
        String K = com.kwad.sdk.core.response.b.a.K(el);
        if (TextUtils.isEmpty(K)) {
            return;
        }
        com.kwad.sdk.core.video.videoview.a eF = AdVideoPlayerViewCache.getInstance().eF(K);
        this.cq = eF;
        if (eF == null) {
            this.cq = new com.kwad.sdk.core.video.videoview.a(this.mContext);
            com.kwad.sdk.core.response.b.a.ab(el);
            this.cq.a(new b.a(adTemplate).a(adTemplate.mVideoPlayerStatus).dg(com.kwad.sdk.core.response.b.e.en(adTemplate)).dh(h.b(com.kwad.sdk.core.response.b.e.em(adTemplate))).b(new com.kwad.sdk.contentalliance.a.a.a(adTemplate, System.currentTimeMillis())).El(), null);
            a.InterfaceC0692a interfaceC0692a = new a.InterfaceC0692a() { // from class: com.kwad.components.core.page.splitLandingPage.view.a.3
                @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0692a
                public final c a(b bVar) {
                    if (!((Boolean) com.kwad.sdk.core.config.e.b(com.kwad.sdk.core.config.c.aBS)).booleanValue() || !((Boolean) com.kwad.sdk.core.config.e.b(com.kwad.sdk.core.config.c.aBT)).booleanValue()) {
                        return null;
                    }
                    g gVar = new g(bVar, adTemplate);
                    if (g.isWaynePlayerReady()) {
                        return gVar;
                    }
                    return null;
                }
            };
            this.cz = interfaceC0692a;
            this.cq.setExternalPlayerListener(interfaceC0692a);
            this.cq.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
            e eVar = new e(this.mContext, adTemplate, this.cq, ksAdVideoPlayConfig);
            this.Vp = eVar;
            eVar.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
            this.cq.setController(this.Vp);
            this.Vp.setAutoRelease(false);
        } else {
            e eVar2 = (e) eF.getController();
            this.Vp = eVar2;
            eVar2.setAutoRelease(false);
            this.Vp.getAdTemplate().mAdWebVideoPageShowing = true;
        }
        this.cq.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
        if (this.cq.getParent() != null) {
            ((ViewGroup) this.cq.getParent()).removeView(this.cq);
        }
        if (this.Vo.getTag() != null) {
            FrameLayout frameLayout = this.Vo;
            frameLayout.removeView((View) frameLayout.getTag());
            this.Vo.setTag(null);
        }
        this.Vo.addView(this.cq);
        this.Vo.setTag(this.cq);
        this.Vp.setAlpha(0.01f);
        this.Vp.setVideoPlayCallback(new a.c() { // from class: com.kwad.components.core.page.splitLandingPage.view.a.4
            @Override // com.kwad.components.core.video.a.c
            public final void ar() {
                a.this.rJ();
                a.this.aK(false).start();
            }

            @Override // com.kwad.components.core.video.a.c
            public final void aq() {
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
            }

            @Override // com.kwad.components.core.video.a.c
            public final void d(long j6) {
            }
        });
    }

    public final void a(InterfaceC0630a interfaceC0630a) {
        this.Vr = interfaceC0630a;
    }

    public final Animator aK(boolean z5) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(o.h(this.Cc, z5), o.h(this.hM, z5));
        return animatorSet;
    }

    public final boolean isVisible() {
        return this.Cc.getAlpha() > 0.0f;
    }

    public final void rJ() {
        this.Vp.ab();
    }

    public final boolean rM() {
        if (this.Vm == null || this.Vl == null) {
            return false;
        }
        c(new KsAdVideoPlayConfig.Builder().videoSoundEnable(this.Vm.getAdTemplate().mIsAudioEnable).build());
        AdInfo el = com.kwad.sdk.core.response.b.e.el(this.Vm.getAdTemplate());
        int R = com.kwad.sdk.core.response.b.a.R(el);
        int Q = com.kwad.sdk.core.response.b.a.Q(el);
        Rect rect = new Rect();
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        if (R > Q) {
            int i6 = displayMetrics.widthPixels;
            rect.right = i6;
            rect.left = i6 - com.kwad.sdk.c.a.a.a(this.mContext, 86.0f);
            int a6 = displayMetrics.heightPixels - com.kwad.sdk.c.a.a.a(this.mContext, 252.0f);
            rect.bottom = a6;
            rect.top = a6 - com.kwad.sdk.c.a.a.a(this.mContext, 154.0f);
        } else {
            int i7 = displayMetrics.widthPixels;
            rect.right = i7;
            rect.left = i7 - com.kwad.sdk.c.a.a.a(this.mContext, 154.0f);
            int a7 = displayMetrics.heightPixels - com.kwad.sdk.c.a.a.a(this.mContext, 252.0f);
            rect.bottom = a7;
            rect.top = a7 - com.kwad.sdk.c.a.a.a(this.mContext, 86.0f);
        }
        rect.left -= com.kwad.sdk.c.a.a.a(this.mContext, 12.0f);
        int a8 = rect.right - com.kwad.sdk.c.a.a.a(this.mContext, 12.0f);
        rect.right = a8;
        WindowManager.LayoutParams layoutParams = this.Vq;
        layoutParams.type = 1003;
        layoutParams.flags = 8;
        layoutParams.gravity = 51;
        layoutParams.format = 1;
        layoutParams.width = displayMetrics.widthPixels;
        layoutParams.height = displayMetrics.heightPixels;
        int i8 = rect.left;
        layoutParams.x = i8;
        layoutParams.y = rect.top;
        layoutParams.width = (a8 - i8) + com.kwad.sdk.c.a.a.a(this.mContext, 12.0f);
        this.Vq.height = (rect.bottom - rect.top) + com.kwad.sdk.c.a.a.a(this.mContext, 12.0f);
        float f6 = (rect.left * displayMetrics.widthPixels) / ((r0 + r4) - rect.right);
        float f7 = (rect.top * displayMetrics.heightPixels) / ((r0 + r3) - rect.bottom);
        this.Cc.setPivotX(f6);
        this.Cc.setPivotY(f7);
        this.Cc.setAlpha(0.0f);
        if (this.Vl != null) {
            try {
                if (this.Cc.getWindowToken() == null) {
                    this.Vl.addView(this.Cc, this.Vq);
                }
            } catch (Exception e6) {
                com.kwad.components.core.d.a.reportSdkCaughtException(e6);
                com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
            }
        }
        this.No.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.splitLandingPage.view.a.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a.this.rJ();
                a.this.aK(false).start();
            }
        });
        return true;
    }

    public final void rN() {
        com.kwad.sdk.core.video.videoview.a aVar = this.cq;
        if (aVar == null || aVar.isPlaying()) {
            return;
        }
        this.Vp.tT();
    }

    @SuppressLint({"ClickableViewAccessibility", "InflateParams"})
    public a(Context context, com.kwad.components.core.page.splitLandingPage.a.a aVar) {
        if (context != null) {
            Context wrapContextIfNeed = m.wrapContextIfNeed(context);
            this.mContext = wrapContextIfNeed;
            this.Vm = aVar;
            WindowManager windowManager = (WindowManager) wrapContextIfNeed.getSystemService("window");
            this.Vl = windowManager;
            if (windowManager == null) {
                return;
            }
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.ksad_split_mini_video, (ViewGroup) null);
            this.Cc = viewGroup;
            this.Vn = (FrameLayout) viewGroup.findViewById(R.id.ksad_split_texture);
            this.Vo = (FrameLayout) this.Cc.findViewById(R.id.ksad_video_container);
            this.hM = (ImageView) this.Cc.findViewById(R.id.ksad_video_first_frame_container);
            this.No = (ImageView) this.Cc.findViewById(R.id.ksad_split_mini_close_btn);
            this.Vn.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.core.page.splitLandingPage.view.a.1
                float Vs = 0.0f;
                float Vt = 0.0f;

                /* renamed from: top, reason: collision with root package name */
                float f36343top = 0.0f;
                float left = 0.0f;
                long Vu = 0;

                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (a.this.Vq == null) {
                        return false;
                    }
                    if (motionEvent.getActionMasked() == 0) {
                        this.Vs = motionEvent.getRawX();
                        this.Vt = motionEvent.getRawY();
                        this.left = a.this.Vq.x;
                        this.f36343top = a.this.Vq.y;
                        this.Vu = SystemClock.elapsedRealtime();
                        System.out.getClass();
                    } else {
                        if (motionEvent.getActionMasked() == 2) {
                            float rawX = motionEvent.getRawX() - this.Vs;
                            float rawY = motionEvent.getRawY() - this.Vt;
                            if (Math.sqrt((rawX * rawX) + (rawY * rawY)) > 15.0d) {
                                a.this.Vq.x = (int) (this.left + rawX);
                                a.this.Vq.y = (int) (this.f36343top + rawY);
                                if (a.this.Vl != null) {
                                    try {
                                        a.this.Vl.updateViewLayout(a.this.Cc, a.this.Vq);
                                    } catch (Exception e6) {
                                        com.kwad.components.core.d.a.reportSdkCaughtException(e6);
                                        com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
                                    }
                                }
                            }
                            return true;
                        }
                        if (motionEvent.getActionMasked() == 1) {
                            float rawX2 = motionEvent.getRawX() - this.Vs;
                            float rawY2 = motionEvent.getRawY() - this.Vt;
                            float elapsedRealtime = SystemClock.elapsedRealtime() - this.Vu;
                            if (Math.sqrt((rawX2 * rawX2) + (rawY2 * rawY2)) < 15.0d && elapsedRealtime > 30.0f && elapsedRealtime < 300.0f && a.this.Vr != null && a.this.Vm != null && com.kwad.sdk.core.response.b.a.aF(com.kwad.sdk.core.response.b.e.el(a.this.Vm.getAdTemplate()))) {
                                a.this.Vr.rK();
                            }
                        }
                    }
                    return true;
                }
            });
        }
    }
}
