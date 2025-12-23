package com.kwad.components.core.video;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.kwad.components.core.video.f;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bu;
import com.kwad.sdk.widget.KSRelativeLayout;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"ViewConstructor"})
@Deprecated
/* loaded from: D:\Downloads\app\classes6.dex */
public class a extends com.kwad.sdk.core.video.videoview.b implements View.OnClickListener {
    protected ImageView Dh;
    protected TextView Di;
    private c ZA;
    private InterfaceC0635a ZB;
    protected com.kwad.components.core.video.a.a ZC;
    protected View ZD;
    protected final com.kwad.sdk.core.download.a.a ZE;
    protected boolean Zl;
    private boolean Zm;
    protected boolean Zn;
    private int Zo;
    private int Zp;
    private boolean Zq;
    private KSRelativeLayout Zr;
    private RelativeLayout Zs;
    private boolean Zt;
    private boolean Zu;
    private LinearLayout Zv;
    private LinearLayout Zw;
    private ImageView Zx;
    public ViewGroup Zy;
    protected TextView Zz;
    protected AdInfo mAdInfo;

    @NonNull
    protected AdTemplate mAdTemplate;
    protected com.kwad.components.core.e.d.c mApkDownloadHelper;
    protected Context mContext;
    protected TextView pA;
    private ProgressBar pU;
    private boolean pX;
    protected ImageView pz;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.components.core.video.a$a, reason: collision with other inner class name */
    public interface InterfaceC0635a {
        void a(int i6, aj.a aVar);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b extends c {
        void onVideoPlayError(int i6, int i7);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface c {
        void aq();

        void ar();

        void d(long j6);

        void onVideoPlayStart();
    }

    public final void ty() {
        this.Zu = true;
        this.pU.setVisibility(8);
    }

    private void ba(int i6) {
        try {
            InterfaceC0635a interfaceC0635a = this.ZB;
            if (interfaceC0635a != null) {
                interfaceC0635a.a(i6, this.Zr.getTouchCoords());
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private void fB() {
        ViewGroup viewGroup = this.Zy;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    private void init() {
        this.ZD = com.kwad.sdk.o.m.inflate(this.mContext, R.layout.ksad_feed_video_palyer_controller, this);
        this.Zr = (KSRelativeLayout) findViewById(R.id.ksad_video_root_container);
        this.Zs = (RelativeLayout) findViewById(R.id.ksad_data_flow_container);
        this.pA = (TextView) findViewById(R.id.ksad_data_flow_play_tip);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_data_flow_play_btn);
        this.pz = imageView;
        imageView.setOnClickListener(this);
        this.Zv = (LinearLayout) findViewById(R.id.ksad_video_network_unavailable);
        this.Zw = (LinearLayout) findViewById(R.id.ksad_video_error_container);
        this.pU = (ProgressBar) findViewById(R.id.ksad_video_progress);
        this.Zx = (ImageView) findViewById(R.id.ksad_video_thumb_image);
        String url = com.kwad.sdk.core.response.b.a.bu(this.mAdInfo).getUrl();
        if (TextUtils.isEmpty(url)) {
            this.Zx.setVisibility(8);
        } else {
            this.Zx.setImageDrawable(null);
            KSImageLoader.loadImage(this.Zx, url, this.mAdTemplate);
            this.Zx.setVisibility(0);
        }
        this.pA.setText(bu.aq(com.kwad.sdk.core.response.b.a.L(this.mAdInfo) * 1000));
        this.ZC = com.kwad.components.core.video.a.d.a(this.mAdTemplate, this.aKI.getMediaPlayerType(), false);
        tq();
    }

    private void setTopBottomVisible(boolean z5) {
        if (this.Zu) {
            return;
        }
        this.pU.setVisibility(z5 ? 0 : 8);
        this.Zt = z5;
    }

    private void tu() {
        this.Zs.setVisibility(8);
    }

    public final void aL(String str) {
        TextView textView = (TextView) findViewById(R.id.ksad_app_download);
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }

    public final void aR(boolean z5) {
        if (this.Zu) {
            return;
        }
        if (!z5) {
            this.pU.setVisibility(8);
        } else if (this.Zt) {
            this.pU.setVisibility(0);
        }
    }

    protected void ac() {
        if (!this.aKI.isIdle()) {
            if (this.aKI.isPaused() || this.aKI.Ke()) {
                tv();
                this.aKI.restart();
                return;
            }
            return;
        }
        com.kwad.components.core.video.a.a aVar = this.ZC;
        if (aVar != null) {
            aVar.onStart();
        }
        if (!ao.isNetworkConnected(this.mContext)) {
            tr();
            return;
        }
        ts();
        if (this.Zn) {
            tv();
            this.aKI.start();
            return;
        }
        if (this.Zm && ao.isWifiConnected(this.mContext)) {
            tv();
            this.aKI.start();
        } else if (!this.Zm || (!this.pX && !this.Zl)) {
            tt();
        } else {
            tv();
            this.aKI.start();
        }
    }

    protected void fA() {
        try {
            if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
                LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ksad_video_complete_app_container);
                this.Dh = (ImageView) findViewById(R.id.ksad_video_complete_app_icon);
                this.Di = (TextView) findViewById(R.id.ksad_app_name);
                this.Zz = (TextView) findViewById(R.id.ksad_app_download);
                KSImageLoader.loadAppIcon(this.Dh, com.kwad.sdk.core.response.b.e.eq(this.mAdTemplate), this.mAdTemplate, 12);
                this.Di.setText(com.kwad.sdk.core.response.b.a.cl(this.mAdInfo));
                this.Zz.setText(com.kwad.sdk.core.response.b.a.aE(this.mAdInfo));
                this.Zy = linearLayout;
                this.Dh.setOnClickListener(this);
                this.Di.setOnClickListener(this);
                this.Zz.setOnClickListener(this);
                com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.mAdTemplate);
                this.mApkDownloadHelper = cVar;
                cVar.b(this.ZE);
            } else {
                LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.ksad_video_complete_h5_container);
                TextView textView = (TextView) findViewById(R.id.ksad_h5_open);
                this.Zz = textView;
                textView.setText(com.kwad.sdk.core.response.b.a.aE(this.mAdInfo));
                this.Zz.setOnClickListener(this);
                this.Zy = linearLayout2;
            }
            this.Zy.setOnClickListener(this);
            this.Zy.setVisibility(0);
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
        }
    }

    public AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.core.video.videoview.b
    public final void o(int i6, int i7) {
        this.Zp = i7;
        this.Zo = i6;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.pz) {
            this.Zl = true;
            this.Zm = true;
            ac();
        } else {
            if (view == this.Dh) {
                ba(1);
                return;
            }
            if (view == this.Di) {
                ba(2);
            } else if (view == this.Zz) {
                ba(3);
            } else {
                ba(4);
            }
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.b
    public final void onPlayStateChanged(int i6) {
        com.kwad.components.core.video.a.a aVar;
        com.kwad.sdk.core.d.c.d("AdVideoPlayerController", "onPlayStateChanged playState=" + i6);
        if (i6 == -1) {
            tE();
            setTopBottomVisible(false);
            this.Zv.setVisibility(8);
            this.Zw.setVisibility(0);
            c cVar = this.ZA;
            if (cVar instanceof f.a) {
                ((f.a) cVar).onVideoPlayError(this.Zo, this.Zp);
            }
            c cVar2 = this.ZA;
            if (cVar2 instanceof b) {
                ((b) cVar2).onVideoPlayError(this.Zo, this.Zp);
            }
            com.kwad.components.core.p.a.se().g(this.mAdTemplate, this.Zo, this.Zp);
            com.kwad.components.core.video.a.a aVar2 = this.ZC;
            if (aVar2 != null) {
                aVar2.onMediaPlayError(this.Zo, this.Zp);
                return;
            }
            return;
        }
        if (i6 == 9) {
            tE();
            this.mAdTemplate.setmCurPlayTime(-1L);
            setTopBottomVisible(false);
            if (!this.Zq) {
                KSImageLoader.loadImage(this.Zx, com.kwad.sdk.core.response.b.a.X(this.mAdInfo), this.mAdTemplate);
                this.Zx.setVisibility(0);
                fA();
            }
            c cVar3 = this.ZA;
            if (cVar3 != null) {
                cVar3.ar();
            }
            com.kwad.components.core.video.a.a aVar3 = this.ZC;
            if (aVar3 != null) {
                aVar3.onMediaPlayCompleted();
                return;
            }
            return;
        }
        if (i6 == 1) {
            tu();
            this.Zv.setVisibility(8);
            this.Zw.setVisibility(8);
            this.pU.setVisibility(8);
            fB();
            return;
        }
        if (i6 == 2) {
            c cVar4 = this.ZA;
            if (cVar4 != null) {
                cVar4.onVideoPlayStart();
            }
            com.kwad.components.core.video.a.a aVar4 = this.ZC;
            if (aVar4 != null) {
                aVar4.onMediaPlayStart();
            }
            setTopBottomVisible(true);
            tD();
            return;
        }
        if (i6 == 4) {
            c cVar5 = this.ZA;
            if (cVar5 != null) {
                cVar5.aq();
            }
            this.Zx.setVisibility(8);
            com.kwad.components.core.video.a.a aVar5 = this.ZC;
            if (aVar5 != null) {
                aVar5.qm();
                this.ZC.onMediaPlaying();
                return;
            }
            return;
        }
        if (i6 == 5) {
            com.kwad.components.core.video.a.a aVar6 = this.ZC;
            if (aVar6 != null) {
                aVar6.onMediaPlayPaused();
                return;
            }
            return;
        }
        if (i6 != 6) {
            if (i6 == 7 && (aVar = this.ZC) != null) {
                aVar.onVideoPlayBufferingPaused();
                return;
            }
            return;
        }
        com.kwad.components.core.video.a.a aVar7 = this.ZC;
        if (aVar7 != null) {
            aVar7.onVideoPlayBufferingPlaying();
        }
    }

    public void release() {
        this.aKI.release();
        com.kwad.components.core.video.a.a aVar = this.ZC;
        if (aVar != null) {
            aVar.onRelease();
        }
    }

    public void setAdClickListener(InterfaceC0635a interfaceC0635a) {
        this.ZB = interfaceC0635a;
    }

    public void setCanControlPlay(boolean z5) {
        this.Zn = z5;
    }

    public void setDataAutoStart(boolean z5) {
        this.Zm = z5;
    }

    public void setDataFlowAutoStart(boolean z5) {
        this.pX = z5;
    }

    public void setHideEnd(boolean z5) {
        this.Zq = z5;
    }

    public void setVideoPlayCallback(c cVar) {
        this.ZA = cVar;
    }

    protected final void tr() {
        this.Zv.setVisibility(0);
    }

    protected final void ts() {
        this.Zv.setVisibility(8);
    }

    protected final void tt() {
        this.Zs.setVisibility(0);
        this.Zx.setVisibility(0);
        this.mAdTemplate.mVideoPlayerStatus.setVideoPlayerBehavior(2);
    }

    protected final void tv() {
        this.aKI.setKsPlayLogParam(com.kwad.sdk.contentalliance.a.a.a.bQ(this.mAdTemplate));
    }

    protected void tw() {
        this.aKI.pause();
    }

    @Override // com.kwad.sdk.core.video.videoview.b
    public final void tx() {
        long currentPosition = this.aKI.getCurrentPosition();
        long duration = this.aKI.getDuration();
        this.pU.setSecondaryProgress(this.aKI.getBufferPercentage());
        this.mAdTemplate.setmCurPlayTime(currentPosition);
        this.pU.setProgress((int) ((currentPosition * 100.0f) / duration));
        c cVar = this.ZA;
        if (cVar != null) {
            cVar.d(currentPosition);
        }
    }

    public a(Context context, @NonNull AdTemplate adTemplate, @NonNull com.kwad.sdk.core.video.videoview.c cVar) {
        super(context, cVar);
        this.Zm = true;
        this.Zn = false;
        this.Zu = false;
        this.ZE = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.video.a.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                a aVar = a.this;
                aVar.Zz.setText(com.kwad.sdk.core.response.b.a.aE(aVar.mAdInfo));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                a aVar = a.this;
                aVar.Zz.setText(com.kwad.sdk.core.response.b.a.cl(aVar.mAdTemplate));
            }

            @Override // com.kwad.sdk.core.download.a.a, com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadStarted() {
                a.this.Zz.setText(com.kwad.sdk.core.response.b.a.dF(0));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                a aVar = a.this;
                aVar.aL(com.kwad.sdk.core.response.b.a.aE(aVar.mAdInfo));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                a aVar = a.this;
                aVar.Zz.setText(com.kwad.sdk.core.response.b.a.ac(aVar.mAdInfo));
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i6) {
                a.this.Zz.setText(com.kwad.sdk.core.response.b.a.IQ());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i6) {
                a.this.Zz.setText(com.kwad.sdk.core.response.b.a.dF(i6));
            }
        };
        this.mContext = context;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.el(adTemplate);
        init();
    }

    @Override // com.kwad.sdk.core.video.videoview.b
    @UiThread
    public final void reset() {
        tE();
        this.pU.setProgress(0);
        this.pU.setSecondaryProgress(0);
        tu();
        this.Zv.setVisibility(8);
        this.Zw.setVisibility(8);
        this.pU.setVisibility(8);
        this.Zx.setVisibility(8);
        this.Zs.setVisibility(8);
        this.mAdTemplate.mVideoPlayerStatus.setVideoPlayerBehavior(1);
        fB();
    }

    protected void tq() {
    }
}
