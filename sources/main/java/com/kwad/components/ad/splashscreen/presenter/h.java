package com.kwad.components.ad.splashscreen.presenter;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.kwad.components.ad.splashscreen.SplashPreloadManager;
import com.kwad.components.ad.splashscreen.presenter.playcard.SplashPlayDefaultInfoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import java.io.File;
import java.io.InputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class h extends e {
    private ImageView Gh;
    private ImageView Gi;
    private int Gl;
    private long Gn;
    private View Go;
    private ViewGroup Gp;
    private SplashPlayDefaultInfoView Gq;
    private AdInfo mAdInfo;
    private boolean Gj = false;
    private boolean Gk = false;
    private int Gm = 1;
    Runnable Gr = new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.h.5
        @Override // java.lang.Runnable
        public final void run() {
            h.this.ml();
        }
    };

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.components.ad.splashscreen.presenter.h$1, reason: invalid class name */
    final class AnonymousClass1 implements ImageLoadingListener {
        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
            return false;
        }

        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingComplete(String str, View view, final DecodedResult decodedResult) {
            if (com.kwad.sdk.core.config.e.a(com.kwad.components.ad.splashscreen.b.a.FQ)) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                com.kwad.components.ad.splashscreen.monitor.b.lZ();
                h hVar = h.this;
                com.kwad.components.ad.splashscreen.monitor.b.a(hVar.Gf.mAdTemplate, 2, hVar.Gl, h.this.Gm, elapsedRealtime - h.this.Gn, elapsedRealtime - h.this.Gf.mAdTemplate.showTime);
            }
            h.this.mm();
            h.this.Gi.setVisibility(0);
            GlobalThreadPools.Jo().submit(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.h.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    final Bitmap stackBlur = BlurUtils.stackBlur(decodedResult.mBitmap, 20, false);
                    h.this.Gi.post(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.h.1.1.1
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            h.this.Gi.setImageDrawable(new BitmapDrawable(h.this.getContext().getResources(), stackBlur));
                        }
                    });
                }
            });
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingFailed(String str, View view, FailReason failReason) {
            h.this.ml();
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingCancelled(String str, View view) {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingStarted(String str, View view) {
        }
    }

    private void l(String str, int i6) {
        if (i6 == 0) {
            this.Gh.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.Gh.setVisibility(0);
            KSImageLoader.loadImage(this.Gh, str, this.Gf.mAdTemplate, new AnonymousClass1());
        } else {
            this.Gi.setVisibility(0);
            if (com.kwad.sdk.core.config.e.a(com.kwad.components.ad.splashscreen.b.a.FP)) {
                a(this.Gi, this.mAdInfo);
            } else {
                a(this.Gi);
            }
            KSImageLoader.loadImage(this.Gi, str, this.Gf.mAdTemplate, new ImageLoadingListener() { // from class: com.kwad.components.ad.splashscreen.presenter.h.2
                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                    return false;
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final void onLoadingComplete(String str2, View view, DecodedResult decodedResult) {
                    if (com.kwad.sdk.core.config.e.a(com.kwad.components.ad.splashscreen.b.a.FQ)) {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        com.kwad.components.ad.splashscreen.monitor.b.lZ();
                        h hVar = h.this;
                        com.kwad.components.ad.splashscreen.monitor.b.a(hVar.Gf.mAdTemplate, 2, hVar.Gl, h.this.Gm, elapsedRealtime - h.this.Gn, elapsedRealtime - h.this.Gf.mAdTemplate.showTime);
                    }
                    h.this.mm();
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final void onLoadingFailed(String str2, View view, FailReason failReason) {
                    h.this.ml();
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final void onLoadingCancelled(String str2, View view) {
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final void onLoadingStarted(String str2, View view) {
                }
            });
        }
    }

    private void a(final ImageView imageView, final AdInfo adInfo) {
        ((FrameLayout) this.Gf.mRootContainer.findViewById(R.id.splash_play_card_view)).setClipChildren(false);
        final AdInfo.CutRuleInfo ct = com.kwad.sdk.core.response.b.a.ct(adInfo);
        imageView.post(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.h.3
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                int height = imageView.getHeight();
                int width = imageView.getWidth();
                double d6 = com.kwad.sdk.core.response.b.a.aU(adInfo).width;
                AdInfo.CutRuleInfo cutRuleInfo = ct;
                double d7 = cutRuleInfo.picHeight;
                double d8 = cutRuleInfo.viewTopMargin;
                double d9 = cutRuleInfo.safeAreaHeight;
                if (d7 <= 0.0d || d9 <= 0.0d) {
                    return;
                }
                double d10 = width / d6;
                double d11 = d8 / (d7 - d9);
                double d12 = d8 * d10;
                double d13 = (d7 * d10) - height;
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                marginLayoutParams.topMargin = (int) (((d13 / 2.0d) - (d12 - (d12 - (d11 * d13)))) * 2.0d);
                imageView.setLayoutParams(marginLayoutParams);
            }
        });
    }

    private void mk() {
        if (com.kwad.sdk.core.config.e.a(com.kwad.components.ad.splashscreen.b.a.FQ)) {
            this.Gn = SystemClock.elapsedRealtime();
            com.kwad.components.ad.splashscreen.monitor.b.lZ();
            com.kwad.components.ad.splashscreen.monitor.b.e(this.Gf.mAdTemplate, 2, this.Gl);
            bw.runOnUiThreadDelay(this.Gr, com.kwad.sdk.core.config.e.a(com.kwad.components.ad.splashscreen.b.a.FR));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ml() {
        if (this.Gj) {
            return;
        }
        if (com.kwad.sdk.core.config.e.a(com.kwad.components.ad.splashscreen.b.a.FQ)) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            com.kwad.components.ad.splashscreen.monitor.b.lZ();
            AdTemplate adTemplate = this.Gf.mAdTemplate;
            com.kwad.components.ad.splashscreen.monitor.b.b(adTemplate, 2, this.Gl, this.Gm, elapsedRealtime - this.Gn, elapsedRealtime - adTemplate.showTime);
        }
        this.Gj = true;
        this.Go.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.h.6
            @Override // java.lang.Runnable
            public final void run() {
                h.this.Gp.setVisibility(0);
                h.this.Gq.a(h.this.Gf.mAdTemplate, com.kwad.sdk.c.a.a.px2dip(h.this.getContext(), h.this.Go.getHeight()) / 414.0f);
            }
        });
        this.Gh.setVisibility(8);
        this.Gi.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mm() {
        if (this.Gk) {
            return;
        }
        this.Gk = true;
        if (com.kwad.sdk.core.config.e.a(com.kwad.components.ad.splashscreen.b.a.FQ)) {
            bw.c(this.Gr);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void at() {
        int i6;
        super.at();
        this.Go = findViewById(R.id.ksad_splash_root_container);
        this.Gi = (ImageView) findViewById(R.id.ksad_splash_background);
        this.Gh = (ImageView) findViewById(R.id.ksad_splash_foreground);
        this.mAdInfo = com.kwad.sdk.core.response.b.e.el(this.Gf.mAdTemplate);
        this.Gp = (ViewGroup) findViewById(R.id.ksad_splash_default_image_view_container);
        this.Gq = (SplashPlayDefaultInfoView) findViewById(R.id.ksad_splash_default_image_view);
        if (com.kwad.components.ad.splashscreen.h.ac(this.Gf.mAdTemplate)) {
            i6 = 2;
        } else {
            i6 = 1;
        }
        this.Gl = i6;
        String str = com.kwad.sdk.core.response.b.a.aU(this.mAdInfo).materialUrl;
        this.Gi.setVisibility(0);
        int i7 = com.kwad.sdk.core.response.b.a.aU(this.mAdInfo).source;
        mk();
        if (getContext() != null) {
            SplashPreloadManager.lD();
            File aa = SplashPreloadManager.aa(this.mAdInfo.adPreloadInfo.preloadId);
            if (aa != null && aa.exists() && aa.length() > 0) {
                this.Gm = 2;
                str = Uri.fromFile(aa).toString();
            }
            l(str, i7);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        mm();
    }

    private void a(final ImageView imageView) {
        ((FrameLayout) this.Gf.mRootContainer.findViewById(R.id.splash_play_card_view)).setClipChildren(false);
        imageView.post(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.h.4
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                float width = imageView.getWidth() / 1080.0f;
                float f6 = ((width * 880.0f) * 1152.0f) / 880.0f;
                float f7 = width * 2340.0f;
                float height = imageView.getHeight();
                float f8 = (f7 - height) / 2.0f;
                float f9 = f7 - f6;
                float f10 = (0.44107744f * f9) - f8;
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                marginLayoutParams.topMargin = (int) (((((f9 * 0.5589225f) - f8) - f10) / 2.0f) - (height * 0.03f));
                imageView.setLayoutParams(marginLayoutParams);
            }
        });
    }
}
