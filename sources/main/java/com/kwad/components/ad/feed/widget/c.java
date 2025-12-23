package com.kwad.components.ad.feed.widget;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.ad.widget.DownloadProgressView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.k.a;
import com.kwad.components.core.video.a;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.model.FeedType;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.core.video.videoview.a;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import com.kwad.sdk.widget.KSRelativeLayout;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class c extends a implements View.OnClickListener, com.kwad.sdk.widget.d {
    private KsAdVideoPlayConfig bU;
    private a.b cA;
    private OfflineOnAudioConflictListener cB;
    private List<Integer> ck;
    private boolean cp;
    private com.kwad.sdk.core.video.videoview.a cq;
    private a.InterfaceC0692a cz;
    private volatile boolean eE;
    private com.kwad.sdk.widget.l eF;
    private TextView ee;
    private final AdLivePlayStateListener eh;
    private a.b fD;
    private View fF;
    private IAdLiveOfflineView fq;
    private com.kwad.components.core.o.a.b.a fr;
    private TextView gD;
    private ImageView gw;
    private TextView hA;
    private ImageView hC;
    private TextView hE;
    private TextView hF;
    private View hG;
    private DownloadProgressView hH;
    private boolean hI;
    private int hJ;
    protected KSRelativeLayout hL;
    private ImageView hM;
    private com.kwad.components.core.video.e hN;
    private d hO;
    private TextView hP;
    private final a.InterfaceC0635a hQ;
    private IAdLivePlayModule hR;
    private boolean hS;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private boolean mIsAudioEnable;
    private KsLogoView mLogoView;

    static /* synthetic */ boolean b(c cVar, boolean z5) {
        cVar.cp = false;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j6) {
        int ceil = (int) Math.ceil(j6 / 1000.0f);
        List<Integer> list = this.ck;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.ck.iterator();
        while (it.hasNext()) {
            if (ceil >= it.next().intValue()) {
                com.kwad.sdk.core.adlog.c.a((AdTemplate) this.mAdTemplate, ceil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }

    private void cm() {
        this.hF = (TextView) findViewById(R.id.ksad_h5_desc);
        this.gD = (TextView) findViewById(R.id.ksad_h5_open_btn);
        this.hG = findViewById(R.id.ksad_h5_open_cover);
        this.hF.setText(com.kwad.components.ad.feed.f.l(this.mAdTemplate));
        this.gD.setText(com.kwad.sdk.core.response.b.a.aE(this.mAdInfo));
        this.hG.setOnClickListener(this);
        this.hF.setOnClickListener(this);
        this.gD.setOnClickListener(this);
        new com.kwad.sdk.widget.h(getContext(), this.hG, this);
        new com.kwad.sdk.widget.h(getContext(), this.hF, this);
        new com.kwad.sdk.widget.h(getContext(), this.gD, this);
    }

    private void cn() {
        this.gw = (ImageView) findViewById(R.id.ksad_app_icon);
        this.ee = (TextView) findViewById(R.id.ksad_app_title);
        TextView textView = (TextView) findViewById(R.id.ksad_app_desc);
        this.hE = textView;
        com.kwad.sdk.c.a.a.a(this, this.gw, this.ee, textView);
        new com.kwad.sdk.widget.h(getContext(), this.gw, this);
        new com.kwad.sdk.widget.h(getContext(), this.ee, this);
        new com.kwad.sdk.widget.h(getContext(), this.hE, this);
        if (cw()) {
            this.ee.setText(com.kwad.sdk.core.response.b.a.cl(this.mAdInfo));
        } else {
            this.ee.setText(com.kwad.sdk.core.response.b.a.av(this.mAdInfo));
        }
        this.gw.setImageResource(R.drawable.ksad_default_app_icon);
        KSImageLoader.loadAppIcon(this.gw, com.kwad.sdk.core.response.b.a.co(this.mAdInfo), this.mAdTemplate, this.hJ);
        this.hE.setText(com.kwad.components.ad.feed.f.l(this.mAdTemplate));
        if (this.hI) {
            ck();
        }
    }

    private void cs() {
        com.kwad.components.core.o.a.b.a aVar = (com.kwad.components.core.o.a.b.a) com.kwad.sdk.components.d.f(com.kwad.components.core.o.a.b.a.class);
        this.fr = aVar;
        if (aVar != null && aVar.qu() && com.kwad.sdk.core.response.b.a.cR(this.mAdInfo)) {
            this.hS = true;
            cv();
        }
    }

    private boolean ct() {
        IAdLiveOfflineView iAdLiveOfflineView = this.fq;
        if (iAdLiveOfflineView == null || iAdLiveOfflineView.getView() == null || !this.hS) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) this.fq.getView().getParent();
        if (viewGroup != this.hL) {
            viewGroup.removeView(this.fq.getView());
            if (this.hL.getTag() != null) {
                KSRelativeLayout kSRelativeLayout = this.hL;
                kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
                this.hL.setTag(null);
            }
            this.hL.addView(this.fq.getView());
            this.hL.setTag(this.fq.getView());
            IAdLivePlayModule adLivePlayModule = this.fr.getAdLivePlayModule(this.fq, ServiceProvider.getAppId(), String.valueOf(com.kwad.sdk.core.response.b.a.cp(this.mAdInfo)), com.kwad.sdk.core.response.b.a.cq(this.mAdInfo), com.kwad.sdk.core.response.b.a.cr(this.mAdInfo));
            this.hR = adLivePlayModule;
            adLivePlayModule.setAudioEnabled(this.mIsAudioEnable, false);
            this.hR.registerAdLivePlayStateListener(this.eh);
        }
        IAdLivePlayModule iAdLivePlayModule = this.hR;
        if (iAdLivePlayModule == null) {
            return true;
        }
        iAdLivePlayModule.onResume();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IAdLivePlayModule cu() {
        IAdLiveOfflineView a6 = com.kwad.components.ad.j.c.a(this.fr, this.mContext, 3);
        this.fq = a6;
        if (a6 == null) {
            return null;
        }
        IAdLivePlayModule adLivePlayModule = this.fr.getAdLivePlayModule(a6, ServiceProvider.getSDKConfig().appId, String.valueOf(com.kwad.sdk.core.response.b.a.cp(this.mAdInfo)), com.kwad.sdk.core.response.b.a.cq(this.mAdInfo), com.kwad.sdk.core.response.b.a.cr(this.mAdInfo));
        adLivePlayModule.setAudioEnabled(h(this.mIsAudioEnable), false);
        adLivePlayModule.registerAdLivePlayStateListener(this.eh);
        final View view = this.fq.getView();
        if (this.hL.getTag() != null) {
            KSRelativeLayout kSRelativeLayout = this.hL;
            kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
            this.hL.setTag(null);
        }
        this.hL.addView(view);
        this.hL.setTag(view);
        bw.postOnUiThread(new bg() { // from class: com.kwad.components.ad.feed.widget.c.5
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                c.this.d(view);
            }
        });
        if (this.mIsAudioEnable) {
            com.kwad.components.core.t.a.aC(this.mContext).a(this.cB);
        }
        return adLivePlayModule;
    }

    private void cv() {
        String url = com.kwad.sdk.core.response.b.a.bu(this.mAdInfo).getUrl();
        this.hM.setVisibility(0);
        this.fF.setVisibility(0);
        if (TextUtils.isEmpty(url)) {
            this.hM.setImageResource(R.drawable.ksad_ad_live_end);
        } else {
            this.hM.setImageDrawable(null);
            KSImageLoader.loadImage(this.hM, url, this.mAdTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.feed.widget.c.6
                @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
                    decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                    return true;
                }
            });
        }
    }

    private void cx() {
        this.hH.at(this.mAdTemplate);
        this.hH.setOnClickListener(this);
        new com.kwad.sdk.widget.h(getContext(), this.hH, this);
        com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.mAdTemplate, null, this.hH.getAppDownloadListener());
        this.mApkDownloadHelper = cVar;
        cVar.d(this.hH.getAppDownloadListener());
        this.mApkDownloadHelper.setOnShowListener(this);
        this.mApkDownloadHelper.setOnDismissListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a.b getCurrentVoiceItem() {
        if (this.fD == null) {
            this.fD = new a.b(new a.c() { // from class: com.kwad.components.ad.feed.widget.c.3
                @Override // com.kwad.components.core.k.a.c
                public final void bF() {
                    if (!c.this.hS) {
                        if (c.this.cq != null) {
                            com.kwad.sdk.core.video.videoview.a aVar = c.this.cq;
                            c cVar = c.this;
                            aVar.setVideoSoundEnable(cVar.h(cVar.mIsAudioEnable));
                            return;
                        }
                        return;
                    }
                    if (c.this.hR == null) {
                        c cVar2 = c.this;
                        cVar2.hR = cVar2.cu();
                    }
                    if (c.this.hR != null) {
                        IAdLivePlayModule iAdLivePlayModule = c.this.hR;
                        c cVar3 = c.this;
                        iAdLivePlayModule.setAudioEnabled(cVar3.h(cVar3.mIsAudioEnable), false);
                    }
                }
            });
        }
        return this.fD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h(boolean z5) {
        if (!z5) {
            return false;
        }
        if (!com.kwad.sdk.core.config.e.hC()) {
            return !com.kwad.components.core.t.a.aC(this.mContext).sX() ? com.kwad.components.core.t.a.aC(this.mContext).aQ(false) : !com.kwad.components.core.t.a.aC(this.mContext).sW();
        }
        if (!this.cp) {
            this.cp = com.kwad.components.core.t.a.aC(this.mContext).aQ(true);
        }
        return this.cp;
    }

    @Override // com.kwad.components.core.widget.b
    public void bw() {
        this.hA = (TextView) findViewById(R.id.ksad_ad_desc);
        this.hL = (KSRelativeLayout) findViewById(R.id.ksad_feed_ad_video_container);
        cr();
        this.hC = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.hM = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_ad_dislike_logo);
        this.hH = (DownloadProgressView) findViewById(R.id.ksad_app_download_btn);
        this.hP = (TextView) findViewById(R.id.ksad_live_end_text);
        this.fF = findViewById(R.id.ksad_live_end_bg_mantle);
    }

    protected void cr() {
        this.hL.setRatio(0.56f);
    }

    protected final boolean cw() {
        if (FeedType.isNewVerticalType(com.kwad.sdk.core.response.b.e.eG(this.mAdTemplate))) {
            return com.kwad.sdk.core.response.b.e.eH(this.mAdTemplate) == FeedType.FeedDefaultType.FEED_VERTICAL_NOVEL_DEFAULT.getDefaultType() || com.kwad.sdk.core.response.b.e.eH(this.mAdTemplate) == FeedType.FeedDefaultType.FEED_VERTICAL_BISERIAL_DEFAULT.getDefaultType();
        }
        return false;
    }

    @Override // com.kwad.components.core.widget.b
    public final void d(@NonNull AdResultData adResultData) {
        super.d((c) adResultData);
        this.hA.setText(com.kwad.components.ad.feed.f.l(this.mAdTemplate));
        this.mLogoView.aP(this.mAdTemplate);
        cs();
        if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
            findViewById(R.id.ksad_ad_download_container).setVisibility(0);
            findViewById(R.id.ksad_ad_h5_container).setVisibility(8);
            cn();
            cx();
        } else {
            findViewById(R.id.ksad_ad_h5_container).setVisibility(0);
            findViewById(R.id.ksad_ad_download_container).setVisibility(8);
            if (cw()) {
                cn();
            }
            cm();
        }
        this.hA.setOnClickListener(this);
        this.hL.setOnClickListener(this);
        this.hC.setOnClickListener(this);
        new com.kwad.sdk.widget.h(getContext(), this.hA, this);
        new com.kwad.sdk.widget.h(getContext(), this.hL, this);
        new com.kwad.sdk.widget.h(getContext(), this.hC, this);
        setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i6;
        com.kwad.sdk.core.video.videoview.a aVar;
        if (view == this.hC) {
            vW();
            return;
        }
        if (view == this.hL && (aVar = this.cq) != null && aVar.isIdle()) {
            com.kwad.sdk.utils.n.eL(this.mAdTemplate);
            this.cq.setKsPlayLogParam(com.kwad.sdk.contentalliance.a.a.a.bQ(this.mAdTemplate));
            this.cq.start();
            return;
        }
        if (view == this.hA) {
            i6 = 25;
        } else {
            if (view != this.hL) {
                if (view == this.hH || view == this.gD || view == this.hG) {
                    i6 = 1;
                } else if (view == this.gw) {
                    i6 = 13;
                } else if (view == this.ee) {
                    i6 = 14;
                } else if (view == this.hE || view == this.hF) {
                    i6 = 101;
                } else if (view != this.cq) {
                    i6 = 35;
                }
            }
            i6 = 100;
        }
        a(this.cq, view == this.hH, i6);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.View
    public void onWindowFocusChanged(boolean z5) {
        IAdLivePlayModule iAdLivePlayModule;
        try {
            if (this.mAdInfo == null) {
                return;
            }
            super.onWindowFocusChanged(z5);
            if (!z5) {
                IAdLiveOfflineView iAdLiveOfflineView = this.fq;
                if (iAdLiveOfflineView == null || iAdLiveOfflineView.getView() == null || (iAdLivePlayModule = this.hR) == null) {
                    return;
                }
                iAdLivePlayModule.onPause();
                return;
            }
            if (ct()) {
                return;
            }
            com.kwad.sdk.core.video.videoview.a aVar = this.cq;
            if (aVar != null && this.hN != null) {
                ViewGroup viewGroup = (ViewGroup) aVar.getParent();
                if (this.cq.getParent() != this.hL) {
                    viewGroup.removeView(this.cq);
                    if (this.hL.getTag() != null) {
                        KSRelativeLayout kSRelativeLayout = this.hL;
                        kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
                        this.hL.setTag(null);
                    }
                    this.hL.addView(this.cq);
                    this.hL.setTag(this.cq);
                    this.cq.setVideoSoundEnable(this.mIsAudioEnable);
                    this.mAdTemplate.mIsAudioEnable = this.mIsAudioEnable;
                    this.hN.setAdClickListener(this.hQ);
                    this.hN.getAdTemplate().mAdWebVideoPageShowing = false;
                    this.hN.tU();
                    this.hN.setAutoRelease(true);
                }
            }
            AdInfo adInfo = this.mAdInfo;
            if (adInfo != null) {
                AdVideoPlayerViewCache.getInstance().remove(com.kwad.sdk.core.response.b.a.K(adInfo));
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public void setRadiusDp(int i6) {
        this.hJ = i6;
    }

    public void setVideoPlayConfig(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        com.kwad.components.core.video.e eVar;
        IAdLivePlayModule iAdLivePlayModule;
        this.bU = ksAdVideoPlayConfig;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoSoundValue() != 0) {
                this.mIsAudioEnable = kSAdVideoPlayConfigImpl.isVideoSoundEnable();
            } else {
                this.mIsAudioEnable = com.kwad.sdk.core.response.b.a.ca(this.mAdInfo);
            }
            this.mAdTemplate.mIsAudioEnable = this.mIsAudioEnable;
            IAdLiveOfflineView iAdLiveOfflineView = this.fq;
            if (iAdLiveOfflineView == null || iAdLiveOfflineView.getView() == null || (iAdLivePlayModule = this.hR) == null) {
                com.kwad.sdk.core.video.videoview.a aVar = this.cq;
                if (aVar != null) {
                    aVar.setVideoSoundEnable(h(this.mIsAudioEnable));
                }
            } else {
                iAdLivePlayModule.setAudioEnabled(h(this.mIsAudioEnable), false);
            }
            if (this.mIsAudioEnable) {
                com.kwad.components.core.t.a.aC(this.mContext).a(this.cB);
            }
            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() == 0 || (eVar = this.hN) == null) {
                return;
            }
            eVar.setDataAutoStart(kSAdVideoPlayConfigImpl.isDataFlowAutoStart());
        }
    }

    public void setmIsShowComplianceView(boolean z5) {
        this.hI = z5;
    }

    public c(@NonNull Context context) {
        super(context);
        this.mIsAudioEnable = false;
        this.eE = false;
        this.hI = true;
        this.hJ = 8;
        this.eF = new com.kwad.sdk.widget.l() { // from class: com.kwad.components.ad.feed.widget.c.1
            @Override // com.kwad.sdk.widget.l
            public final void aT() {
                com.kwad.sdk.utils.n.eM(c.this.mAdTemplate);
            }
        };
        this.hQ = new a.InterfaceC0635a() { // from class: com.kwad.components.ad.feed.widget.c.4
            @Override // com.kwad.components.core.video.a.InterfaceC0635a
            public final void a(int i6, aj.a aVar) {
                int i7;
                int i8 = 2;
                boolean z5 = false;
                if (i6 == 1) {
                    i7 = 15;
                } else if (i6 == 2) {
                    i7 = 16;
                } else if (i6 != 3) {
                    i7 = 35;
                } else {
                    i7 = 39;
                    i8 = 1;
                    z5 = true;
                }
                c.this.cj();
                com.kwad.components.core.e.d.a.a(new a.C0616a(c.this.getContext()).aB(c.this.mAdTemplate).b(c.this.mApkDownloadHelper).aB(i8).aq(z5).as(true).az(5).aA(i7).d(aVar).au(true).a(new a.b() { // from class: com.kwad.components.ad.feed.widget.c.4.1
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        c.this.vV();
                    }
                }));
            }
        };
        this.eh = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.feed.widget.c.8
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayEnd() {
                super.onLivePlayEnd();
                c.this.hP.setVisibility(0);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayProgress(long j6) {
                super.onLivePlayProgress(j6);
                c.this.c(j6);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayResume() {
                super.onLivePlayResume();
                if (c.this.hR != null) {
                    com.kwad.components.core.k.a.qp().a(c.this.getCurrentVoiceItem());
                    IAdLivePlayModule iAdLivePlayModule = c.this.hR;
                    c cVar = c.this;
                    iAdLivePlayModule.setAudioEnabled(cVar.h(cVar.mIsAudioEnable), false);
                }
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayStart() {
                super.onLivePlayStart();
                if (c.this.hR != null) {
                    com.kwad.components.core.k.a.qp().a(c.this.getCurrentVoiceItem());
                    IAdLivePlayModule iAdLivePlayModule = c.this.hR;
                    c cVar = c.this;
                    iAdLivePlayModule.setAudioEnabled(cVar.h(cVar.mIsAudioEnable), false);
                }
            }
        };
        this.cB = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.feed.widget.c.10
            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                c.b(c.this, false);
                if (c.this.cq != null) {
                    c.this.cq.setVideoSoundEnable(false);
                }
                if (c.this.hR != null) {
                    c.this.hR.setAudioEnabled(false, false);
                }
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
            }
        };
        this.cA = new a.b() { // from class: com.kwad.components.ad.feed.widget.c.2
            @Override // com.kwad.components.core.video.a.c
            public final void aq() {
                com.kwad.sdk.core.video.videoview.a aVar = c.this.cq;
                c cVar = c.this;
                aVar.setVideoSoundEnable(cVar.h(cVar.mIsAudioEnable));
            }

            @Override // com.kwad.components.core.video.a.c
            public final void d(long j6) {
                c.this.c(j6);
            }

            @Override // com.kwad.components.core.video.a.b
            public final void onVideoPlayError(int i6, int i7) {
                com.kwad.components.ad.feed.monitor.b.a(c.this.mAdTemplate, 2, 1, com.kwad.sdk.core.response.b.a.K(c.this.mAdInfo), i6 + " " + i7, SystemClock.elapsedRealtime() - c.this.ht);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void ar() {
                if (com.kwad.components.ad.feed.a.b.cf() && c.this.hO == null) {
                    c.this.hO = new d(c.this.getContext());
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    c cVar = c.this;
                    cVar.addView(cVar.hO, layoutParams);
                    c.this.hO.cy();
                }
                if (c.this.hN.Zy != null && c.this.cw()) {
                    ((ViewGroup) c.this.hN.Zy.getParent()).removeView(c.this.hN.Zy);
                    c cVar2 = c.this;
                    cVar2.hL.addView(cVar2.hN.Zy);
                }
                com.kwad.sdk.core.adlog.c.bY(c.this.mAdTemplate);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
                com.kwad.components.core.k.a.qp().a(c.this.getCurrentVoiceItem());
                if (c.this.hO != null && (c.this.hO.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) c.this.hO.getParent()).removeView(c.this.hO);
                    c.this.hO.cz();
                    c.this.hO = null;
                }
                com.kwad.components.ad.feed.monitor.b.a(c.this.mAdTemplate, 1, 1, com.kwad.sdk.core.response.b.a.K(c.this.mAdInfo), null, SystemClock.elapsedRealtime() - c.this.ht);
                com.kwad.sdk.core.adlog.c.bX(c.this.mAdTemplate);
            }
        };
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void aa() {
        DownloadProgressView downloadProgressView;
        super.aa();
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null && (downloadProgressView = this.hH) != null) {
            cVar.b(downloadProgressView.getAppDownloadListener());
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void ab() {
        super.ab();
        com.kwad.sdk.utils.n.eK(this.mAdTemplate);
        IAdLivePlayModule iAdLivePlayModule = this.hR;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.onDestroy();
            this.hR = null;
        }
        IAdLiveOfflineView iAdLiveOfflineView = this.fq;
        if (iAdLiveOfflineView != null) {
            iAdLiveOfflineView.onDestroy();
            this.fq = null;
        }
        com.kwad.components.core.k.a.qp().c(this.fD);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(@androidx.annotation.NonNull com.kwad.sdk.api.KsAdVideoPlayConfig r10) {
        /*
            Method dump skipped, instructions count: 460
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.feed.widget.c.b(com.kwad.sdk.api.KsAdVideoPlayConfig):void");
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.j.c
    public final void bt() {
        super.bt();
        com.kwad.components.core.video.e eVar = this.hN;
        if (eVar != null) {
            eVar.setVideoPlayCallback(this.cA);
        }
        com.kwad.components.core.k.a.qp().a(getCurrentVoiceItem());
        if (!this.hS) {
            return;
        }
        IAdLivePlayModule iAdLivePlayModule = this.hR;
        if (iAdLivePlayModule == null) {
            this.hR = cu();
        } else {
            iAdLivePlayModule.onResume();
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.j.c
    public final void bu() {
        super.bu();
        IAdLivePlayModule iAdLivePlayModule = this.hR;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.onPause();
        }
        com.kwad.components.core.k.a.qp().c(this.fD);
    }

    @Override // com.kwad.components.core.widget.b
    public final void cq() {
        super.cq();
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this.hH.getAppDownloadListener());
        }
        if (this.mIsAudioEnable) {
            com.kwad.components.core.t.a.aC(this.mContext).b(this.cB);
        }
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view) {
        onClick(view);
    }

    private void a(com.kwad.sdk.core.video.videoview.a aVar, boolean z5, final int i6) {
        com.kwad.components.core.video.e eVar;
        if (aVar != null || this.hS) {
            String K = com.kwad.sdk.core.response.b.a.K(this.mAdInfo);
            if (!this.hS && (eVar = this.hN) != null) {
                eVar.setAutoRelease(false);
            }
            int i7 = z5 ? 1 : 2;
            if (!this.hS) {
                AdVideoPlayerViewCache.getInstance().a(K, this.cq);
            }
            cj();
            a.C0616a aq = new a.C0616a(getContext()).aB(this.mAdTemplate).b(this.mApkDownloadHelper).aq(z5);
            IAdLivePlayModule iAdLivePlayModule = this.hR;
            com.kwad.components.core.e.d.a.a(aq.A(iAdLivePlayModule == null ? 0L : iAdLivePlayModule.getPlayDuration()).aB(i7).au(true).a(new a.b() { // from class: com.kwad.components.ad.feed.widget.c.11
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    c.this.ba(i6);
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final View view) {
        view.post(new bg() { // from class: com.kwad.components.ad.feed.widget.c.7
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                int width = c.this.hL.getWidth();
                int height = c.this.hL.getHeight();
                if (width == 0 || height == 0) {
                    return;
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (height * 0.5625f), height);
                layoutParams.addRule(13, -1);
                view.setLayoutParams(layoutParams);
            }
        });
    }

    @Override // com.kwad.sdk.widget.d
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.ea(this.mAdTemplate)) {
            a(this.cq, view == this.hH, 153);
        }
    }
}
