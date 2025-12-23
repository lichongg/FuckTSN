package com.kwad.components.ad.splashscreen.presenter;

import android.annotation.SuppressLint;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.kwad.components.ad.splashscreen.widget.SkipView;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.i;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class t extends e implements com.kwad.sdk.core.j.c {
    private SkipView HU;
    private ImageView ke;
    private AdInfo mAdInfo;
    private volatile boolean HR = false;
    private boolean HS = false;
    private boolean HT = false;
    private i.a kf = new i.a() { // from class: com.kwad.components.ad.splashscreen.presenter.t.1
        @Override // com.kwad.sdk.utils.i.a
        public final void onAudioBeOccupied() {
            t.this.HR = false;
            if (t.this.ke != null) {
                t.this.ke.post(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.t.1.1
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        t tVar = t.this;
                        com.kwad.components.ad.splashscreen.d.a aVar = tVar.Gf.Fq;
                        if (aVar != null) {
                            aVar.setAudioEnabled(tVar.HR, false);
                        }
                        com.kwad.components.ad.splashscreen.h hVar = t.this.Gf;
                        if (hVar != null) {
                            AdInfo el = com.kwad.sdk.core.response.b.e.el(hVar.mAdTemplate);
                            String str = t.this.HR ? el.adSplashInfo.speakerIconUrl : el.adSplashInfo.speakerMuteIconUrl;
                            if (TextUtils.isEmpty(str)) {
                                t.this.ke.setImageDrawable(t.this.getContext().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                            } else {
                                KSImageLoader.loadImage(t.this.ke, str, t.this.Gf.mAdTemplate);
                            }
                            t.this.ke.setSelected(false);
                        }
                    }
                });
            }
        }

        @Override // com.kwad.sdk.utils.i.a
        public final void onAudioBeReleased() {
        }
    };
    private com.kwad.components.core.video.l HV = new com.kwad.components.core.video.m() { // from class: com.kwad.components.ad.splashscreen.presenter.t.2
        private boolean HY = false;
        private String HZ = com.kwad.sdk.core.config.e.a(com.kwad.components.ad.splashscreen.b.a.FN);

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayCompleted() {
            if (this.HY) {
                return;
            }
            t.this.Gf.lQ();
            this.HY = true;
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayError(int i6, int i7) {
            com.kwad.components.ad.splashscreen.h hVar;
            com.kwad.components.ad.splashscreen.h hVar2 = t.this.Gf;
            if (hVar2 != null && hVar2.Fq != null) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                com.kwad.components.ad.splashscreen.monitor.b.lZ();
                com.kwad.components.ad.splashscreen.h hVar3 = t.this.Gf;
                AdTemplate adTemplate = hVar3.mAdTemplate;
                com.kwad.components.ad.splashscreen.d.a aVar = hVar3.Fq;
                com.kwad.components.ad.splashscreen.monitor.b.b(adTemplate, 1, aVar.Gl, 2, elapsedRealtime - aVar.Jm, elapsedRealtime - adTemplate.showTime);
            }
            if (t.this.HT || (hVar = t.this.Gf) == null) {
                return;
            }
            hVar.c(0, "onMediaPlayError");
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j6, long j7) {
            AnonymousClass2 anonymousClass2;
            final long j8;
            t.this.Gf.al(((int) j7) / 1000);
            final int min = Math.min(t.this.mAdInfo.adSplashInfo.videoDisplaySecond, ((int) j6) / 1000);
            final String str = this.HZ;
            t tVar = t.this;
            if (t.a(tVar, tVar.mAdInfo)) {
                anonymousClass2 = this;
                j8 = j7;
                t.this.HU.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.t.2.1
                    @Override // java.lang.Runnable
                    @SuppressLint({"SetTextI18n"})
                    public final void run() {
                        int i6 = (int) (((min * 1000) - j8) / 1000);
                        if (i6 <= 0) {
                            i6 = 1;
                        }
                        t.this.HU.ac(str + i6);
                    }
                });
            } else {
                anonymousClass2 = this;
                j8 = j7;
            }
            float f6 = j8 / 1000.0f;
            if (min <= 0 || f6 + 0.5d <= min - 1 || anonymousClass2.HY) {
                return;
            }
            t tVar2 = t.this;
            if (t.a(tVar2, tVar2.mAdInfo)) {
                t.this.Gf.lQ();
                anonymousClass2.HY = true;
            }
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayStart() {
            t tVar = t.this;
            com.kwad.components.ad.splashscreen.d.a aVar = tVar.Gf.Fq;
            if (aVar != null) {
                aVar.setAudioEnabled(tVar.HR, false);
            }
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlaying() {
            if (t.this.HS) {
                return;
            }
            t.this.Gf.af(false);
            com.kwad.components.ad.splashscreen.d.a aVar = t.this.Gf.Fq;
            if (aVar != null) {
                aVar.ag(true);
                t tVar = t.this;
                tVar.Gf.Fq.setAudioEnabled(tVar.HR, true);
            }
            t.b(t.this, true);
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayPaused() {
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.l
        public final void onVideoPlayBufferingPaused() {
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.l
        public final void onVideoPlayBufferingPlaying() {
        }
    };

    static /* synthetic */ boolean a(t tVar, AdInfo adInfo) {
        return u(adInfo);
    }

    static /* synthetic */ boolean b(t tVar, boolean z5) {
        tVar.HS = true;
        return true;
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bu() {
        com.kwad.components.ad.splashscreen.d.a aVar = this.Gf.Fq;
        if (aVar != null) {
            aVar.pause();
        }
    }

    private static boolean u(AdInfo adInfo) {
        if (!com.kwad.sdk.core.response.b.a.cB(adInfo)) {
            return true;
        }
        return false;
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void at() {
        int i6;
        String str;
        super.at();
        this.mAdInfo = com.kwad.sdk.core.response.b.e.el(this.Gf.mAdTemplate);
        DetailVideoView detailVideoView = (DetailVideoView) this.Gf.mRootContainer.findViewById(R.id.ksad_splash_video_player);
        detailVideoView.setVisibility(0);
        if (com.kwad.sdk.core.response.b.a.dn(this.mAdInfo)) {
            a(detailVideoView);
        }
        com.kwad.components.ad.splashscreen.d.a aVar = this.Gf.Fq;
        if (aVar != null) {
            aVar.b(this.HV);
        }
        this.Gf.Fs.a(this);
        AdBaseFrameLayout adBaseFrameLayout = this.Gf.mRootContainer;
        if (com.kwad.components.ad.splashscreen.e.c.z(this.mAdInfo)) {
            i6 = R.id.ksad_splash_skip_right_view;
        } else {
            i6 = R.id.ksad_splash_skip_left_view;
        }
        this.HU = (SkipView) adBaseFrameLayout.findViewById(i6);
        if (u(this.mAdInfo)) {
            a(this.HU, this.mAdInfo);
        }
        int i7 = this.mAdInfo.adSplashInfo.mute;
        boolean z5 = true;
        if (i7 != 2) {
            if (i7 != 3) {
                this.HR = false;
            } else {
                if (com.kwad.sdk.utils.m.cH(this.Gf.mRootContainer.getContext()) <= 0) {
                    z5 = false;
                }
                this.HR = z5;
            }
        } else {
            this.HR = true;
        }
        if (com.kwad.components.core.t.a.aC(getContext()).sW()) {
            this.HR = false;
        }
        com.kwad.components.ad.splashscreen.d.a aVar2 = this.Gf.Fq;
        if (aVar2 != null) {
            aVar2.setAudioEnabled(this.HR, false);
            this.Gf.Fq.a(this.kf);
        }
        this.ke = (ImageView) this.Gf.mRootContainer.findViewById(R.id.ksad_splash_sound);
        if (com.kwad.components.ad.splashscreen.e.c.z(this.mAdInfo)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ke.getLayoutParams();
            layoutParams.gravity = 51;
            this.ke.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.ke.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
                marginLayoutParams.topMargin = com.kwad.sdk.c.a.a.a(this.ke.getContext(), 32.0f);
                marginLayoutParams.leftMargin = com.kwad.sdk.c.a.a.a(this.ke.getContext(), 16.0f);
            }
        }
        this.ke.setVisibility(0);
        if (this.HR) {
            str = this.mAdInfo.adSplashInfo.speakerIconUrl;
        } else {
            str = this.mAdInfo.adSplashInfo.speakerMuteIconUrl;
        }
        if (!TextUtils.isEmpty(str)) {
            KSImageLoader.loadImage(this.ke, str, this.Gf.mAdTemplate);
        } else {
            this.ke.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
        }
        this.ke.setSelected(this.HR);
        this.ke.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.presenter.t.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                t.this.HR = !r4.HR;
                String str2 = t.this.HR ? t.this.mAdInfo.adSplashInfo.speakerIconUrl : t.this.mAdInfo.adSplashInfo.speakerMuteIconUrl;
                if (TextUtils.isEmpty(str2)) {
                    t.this.ke.setImageDrawable(t.this.getContext().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                } else {
                    KSImageLoader.loadImage(t.this.ke, str2, t.this.Gf.mAdTemplate);
                }
                t.this.ke.setSelected(t.this.HR);
                t tVar = t.this;
                tVar.Gf.Fq.setAudioEnabled(tVar.HR, true);
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        this.HT = true;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.splashscreen.d.a aVar = this.Gf.Fq;
        if (aVar != null) {
            aVar.a(this.HV);
            this.Gf.Fq.b(this.kf);
        }
        if (this.HU.getHandler() != null) {
            this.HU.getHandler().removeCallbacksAndMessages(null);
        }
        this.Gf.Fs.b(this);
    }

    private void a(final DetailVideoView detailVideoView) {
        final View findViewById = findViewById(R.id.splash_play_card_view);
        findViewById.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.t.3
            @Override // java.lang.Runnable
            public final void run() {
                float width = findViewById.getWidth();
                float height = findViewById.getHeight();
                if (width <= 0.0f || height <= 0.0f) {
                    return;
                }
                if (com.kwad.sdk.core.response.b.a.aV(t.this.mAdInfo).videoWidth > 0) {
                    com.kwad.sdk.c.a.a.a(detailVideoView, r0.width, r0.height);
                }
            }
        });
    }

    private static void a(SkipView skipView, AdInfo adInfo) {
        skipView.setTimerBtnVisible(com.kwad.sdk.core.response.b.a.cE(adInfo));
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bt() {
    }
}
