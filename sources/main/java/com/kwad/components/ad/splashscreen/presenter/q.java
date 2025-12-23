package com.kwad.components.ad.splashscreen.presenter;

import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class q extends e {
    private KsSplashSlidePathView GK;
    private double GQ;
    private AdMatrixInfo.SplashSlideInfo GR;
    private com.kwad.components.ad.splashscreen.e.a Gy;
    private TextView HA;
    private ImageView HB;
    private com.kwad.components.ad.splashscreen.widget.d HC;
    private com.kwad.components.core.e.d.c Hx;
    private TextView ko;
    private AdInfo mAdInfo;
    private long mStartTime;

    private void initView() {
        AdMatrixInfo.SplashSlideInfo splashSlideInfo = this.mAdInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.slideInfo;
        this.GR = splashSlideInfo;
        this.GQ = splashSlideInfo.convertDistance;
        int i6 = splashSlideInfo.style;
        com.kwad.components.ad.splashscreen.widget.d dVar = new com.kwad.components.ad.splashscreen.widget.d(getContext(), i6);
        this.HC = dVar;
        this.HB.setImageDrawable(dVar);
        this.HB.post(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.q.3
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                q.this.my();
                if (q.this.HC != null) {
                    q.this.HC.start();
                }
            }
        });
        if (!TextUtils.isEmpty(this.GR.title)) {
            this.ko.setText(this.GR.title);
        } else if (i6 == 0) {
            this.ko.setText("向上滑动");
        } else if (i6 == 1) {
            this.ko.setText("向左滑动");
        } else if (i6 == 2) {
            this.ko.setText("向右滑动");
        }
        if (!TextUtils.isEmpty(this.GR.subtitle)) {
            this.HA.setText(this.GR.subtitle);
        } else if (!com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
            this.HA.setText("跳转详情页或者第三方应用");
        } else {
            this.HA.setText(com.kwad.components.ad.splashscreen.d.a(this.Gf.mAdTemplate, this.mAdInfo, this.Hx.pB(), 0));
        }
    }

    private void mw() {
        com.kwad.components.ad.splashscreen.e.a aVar = this.Gy;
        if (aVar != null) {
            aVar.setAdTemplate(this.Gf.mAdTemplate);
            return;
        }
        com.kwad.components.ad.splashscreen.e.a aVar2 = new com.kwad.components.ad.splashscreen.e.a(getContext(), this.Gf.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.presenter.q.4
            {
                super(r3);
            }

            @Override // com.kwad.components.ad.splashscreen.e.a
            public final void j(int i6, String str) {
                q.this.HA.setText(str);
            }
        };
        this.Gy = aVar2;
        this.Hx.b(aVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void my() {
        if (this.GR != null) {
            com.kwad.sdk.core.adlog.c.d(this.Gf.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().dn(this.GR.style).df(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME));
            com.kwad.components.core.webview.tachikoma.e.a.vI().bm(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        if (this.Gf != null) {
            bw.postOnUiThread(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.q.2
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    q.this.Gf.FH = SystemClock.elapsedRealtime() - q.this.mStartTime;
                }
            });
            this.mAdInfo = com.kwad.sdk.core.response.b.e.el(this.Gf.mAdTemplate);
            this.Hx = this.Gf.mApkDownloadHelper;
            initView();
            if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
                mw();
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mStartTime = SystemClock.elapsedRealtime();
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_slide_layout);
        if (viewStub != null) {
            viewStub.inflate();
        }
        this.ko = (TextView) findViewById(R.id.ksad_splash_slide_title);
        this.HA = (TextView) findViewById(R.id.ksad_splash_slide_actiontext);
        this.HB = (ImageView) findViewById(R.id.ksad_splash_slideView);
        ViewStub viewStub2 = (ViewStub) findViewById(R.id.ksad_splash_slideTouchView);
        if (viewStub2 != null) {
            this.GK = (KsSplashSlidePathView) viewStub2.inflate();
        } else {
            this.GK = (KsSplashSlidePathView) findViewById(R.id.ksad_splash_slideview_root);
        }
        KsSplashSlidePathView ksSplashSlidePathView = this.GK;
        if (ksSplashSlidePathView != null) {
            ksSplashSlidePathView.setOnSlideTouchListener(new KsSplashSlidePathView.a() { // from class: com.kwad.components.ad.splashscreen.presenter.q.1
                @Override // com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.a
                public final void a(float f6, float f7, float f8, float f9) {
                    q qVar;
                    com.kwad.components.ad.splashscreen.h hVar;
                    final float px2dip = com.kwad.sdk.c.a.a.px2dip(q.this.getContext(), (float) Math.sqrt(Math.pow(f8 - f6, 2.0d) + Math.pow(f9 - f7, 2.0d)));
                    if (px2dip < q.this.GQ || (hVar = (qVar = q.this).Gf) == null) {
                        return;
                    }
                    hVar.a(1, qVar.getContext(), 153, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.presenter.q.1.1
                        @Override // com.kwad.components.ad.splashscreen.h.a
                        public final void b(@NonNull com.kwad.sdk.core.adlog.c.b bVar) {
                            bVar.dn(q.this.GR.style);
                            bVar.m120do((int) px2dip);
                        }
                    });
                }

                @Override // com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.a
                public final void c(MotionEvent motionEvent) {
                    q qVar;
                    com.kwad.components.ad.splashscreen.h hVar;
                    if (!com.kwad.components.ad.splashscreen.h.n(q.this.mAdInfo) || (hVar = (qVar = q.this).Gf) == null) {
                        return;
                    }
                    hVar.c(1, qVar.getContext(), 53, 2);
                }
            });
        }
    }
}
