package com.kwad.components.ad.feed.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.feed.d;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.k.a;
import com.kwad.components.core.liveEnd.AdLiveEndCommonResultData;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.video.a;
import com.kwad.components.core.webview.b;
import com.kwad.components.core.webview.jshandler.WebCardRegisterLiveMessageListener;
import com.kwad.components.core.webview.jshandler.WebCardRegisterLiveShopListener;
import com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler;
import com.kwad.components.core.webview.jshandler.ad;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.al;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.jshandler.as;
import com.kwad.components.core.webview.jshandler.at;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.ba;
import com.kwad.components.core.webview.jshandler.bb;
import com.kwad.components.core.webview.jshandler.be;
import com.kwad.components.core.widget.b;
import com.kwad.components.model.FeedType;
import com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveMessageListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveShopListener;
import com.kwad.components.offline.api.core.adlive.model.AdLiveMessageInfo;
import com.kwad.components.offline.api.core.adlive.model.AdLiveShopInfo;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.adlog.a;
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
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import com.kwad.sdk.utils.bz;
import com.kwad.sdk.widget.KSRelativeLayout;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class q extends com.kwad.components.core.widget.b<AdResultData, AdTemplate> implements View.OnClickListener, com.kwad.sdk.widget.d {
    private static final HashMap<Long, Double> iB = new HashMap<>(8);
    private KsAdVideoPlayConfig bU;
    private OfflineOnAudioConflictListener cB;
    private List<Integer> ck;
    private boolean cp;
    private com.kwad.sdk.core.video.videoview.a cq;
    private a.InterfaceC0692a cz;
    private int eR;
    private final AdLivePlayStateListener eh;
    private a.b fD;
    private View fF;
    private IAdLiveOfflineView fq;
    private com.kwad.components.core.o.a.b.a fr;
    private KSRelativeLayout hL;
    private ImageView hM;
    private com.kwad.components.core.video.e hN;
    private d hO;
    private final a.InterfaceC0635a hQ;
    private IAdLivePlayModule hR;
    private boolean hS;
    private d.InterfaceC0556d hg;
    private long ht;
    private float hu;
    private float hv;
    private WebCardRegisterLiveShopListener iA;
    private boolean iC;
    private String iD;
    private ba.b iE;
    private ba.a iF;
    private com.kwad.components.core.widget.b iG;
    private boolean iH;
    private a iI;
    private ViewGroup.MarginLayoutParams iJ;
    private Handler iK;
    private e iL;
    private at iM;
    private boolean iN;
    private boolean iO;
    private com.kwad.components.core.webview.b iP;
    private com.kwad.components.core.webview.c iQ;
    private b.a iR;
    private IAdLiveEndRequest iS;
    private boolean isNative;
    private RatioFrameLayout it;
    private double iu;
    private LinearLayout iv;
    private TextView iw;
    private be ix;
    private az iy;
    private WebCardRegisterLiveMessageListener iz;
    private KsAdWebView mAdWebView;

    @Nullable
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private boolean mIsAudioEnable;
    private final com.kwad.sdk.core.network.l<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData> mNetworking;
    private int mWidth;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.components.ad.feed.widget.q$12, reason: invalid class name */
    final class AnonymousClass12 extends com.kwad.components.core.webview.c {
        @Override // com.kwad.components.core.webview.c
        public final void a(com.kwad.components.core.webview.a aVar, com.kwad.sdk.core.webview.b bVar) {
            bVar.aMP = false;
            aVar.a(new com.kwad.components.core.webview.jshandler.h(q.this.mAdTemplate.loadType));
            q.this.ix = new be();
            aVar.a(q.this.ix);
            aVar.a(new aq(q.this.getOpenNewPageListener()));
            aVar.a(new WebCardVideoPositionHandler(new WebCardVideoPositionHandler.a() { // from class: com.kwad.components.ad.feed.widget.q.12.1
                @Override // com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler.a
                public final void a(WebCardVideoPositionHandler.VideoPosition videoPosition) {
                    if (q.this.mAdInfo != null) {
                        if (com.kwad.sdk.core.response.b.a.bc(q.this.mAdInfo) || q.this.hS) {
                            q qVar = q.this;
                            qVar.iJ = (ViewGroup.MarginLayoutParams) qVar.hL.getLayoutParams();
                            int ceil = (int) Math.ceil(q.this.iu);
                            int i6 = q.this.mWidth;
                            if (videoPosition.widthRation == 0.0d) {
                                videoPosition.widthRation = 0.9200000166893005d;
                                videoPosition.leftMarginRation = 0.03999999910593033d;
                            }
                            q.this.iJ.topMargin = (int) (videoPosition.topMarginRation * ceil);
                            double d6 = i6;
                            q.this.iJ.leftMargin = (int) (videoPosition.leftMarginRation * d6);
                            q.this.iJ.width = (int) (d6 * videoPosition.widthRation);
                            q.this.iJ.height = (int) (q.this.iJ.width * videoPosition.heightWidthRation);
                            q.this.hL.setRadius(videoPosition.borderRadius);
                            q.this.hL.setLayoutParams(q.this.iJ);
                            q.this.hL.setVisibility(0);
                            if (!(q.this.bU instanceof KSAdVideoPlayConfigImpl) || ((KSAdVideoPlayConfigImpl) q.this.bU).getVideoSoundValue() == 0) {
                                q qVar2 = q.this;
                                qVar2.mIsAudioEnable = com.kwad.sdk.core.response.b.a.ca(qVar2.mAdInfo);
                            } else {
                                q qVar3 = q.this;
                                qVar3.mIsAudioEnable = qVar3.bU.isVideoSoundEnable();
                            }
                            q.this.mAdTemplate.mIsAudioEnable = q.this.mIsAudioEnable;
                            q qVar4 = q.this;
                            qVar4.ck = com.kwad.sdk.core.response.b.a.bp(qVar4.mAdInfo);
                            if (!q.this.hS) {
                                q qVar5 = q.this;
                                qVar5.b(qVar5.bU);
                            } else if (q.this.hR != null) {
                                IAdLivePlayModule iAdLivePlayModule = q.this.hR;
                                q qVar6 = q.this;
                                iAdLivePlayModule.setAudioEnabled(qVar6.h(qVar6.mIsAudioEnable), false);
                            }
                        }
                    }
                }
            }));
            aVar.a(new ad(bVar, new ad.a() { // from class: com.kwad.components.ad.feed.widget.q.12.2
                @Override // com.kwad.components.core.webview.jshandler.ad.a
                public final void cK() {
                    q.this.iK.post(new bg() { // from class: com.kwad.components.ad.feed.widget.q.12.2.1
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            q.this.vW();
                        }
                    });
                }
            }));
            aVar.a(new bb(new bb.a() { // from class: com.kwad.components.ad.feed.widget.q.12.3
                @Override // com.kwad.components.core.webview.jshandler.bb.a
                public final void cL() {
                    q.d(q.this, true);
                    q.this.cF();
                }
            }));
            q.this.iM = new at();
            aVar.a(q.this.iM);
            if (q.this.hS) {
                aVar.a(new com.kwad.components.core.webview.jshandler.g(1, 1));
                q.this.iA = new WebCardRegisterLiveShopListener();
                q.this.iz = new WebCardRegisterLiveMessageListener();
                aVar.a(q.this.iA);
                aVar.a(q.this.iz);
                aVar.a(new ba(q.this.getRegisterLiveListener()));
            }
        }

        @Override // com.kwad.components.core.webview.c
        public final void b(ae.a aVar) {
            aVar.height = 0;
            aVar.width = q.this.mWidth;
        }

        AnonymousClass12() {
        }

        @Override // com.kwad.components.core.webview.c
        public final void h(int i6, String str) {
            q.this.a("1", 2, 5);
        }

        @Override // com.kwad.components.core.webview.c
        public final void onPageFinished() {
            com.kwad.components.ad.feed.monitor.b.a(q.this.mAdTemplate, com.kwad.sdk.core.response.b.b.cT(q.this.mAdTemplate), System.currentTimeMillis() - q.this.mAdWebView.getLoadTime());
        }

        @Override // com.kwad.components.core.webview.c
        public final void onAdShow() {
            super.onAdShow();
            bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.feed.widget.q.12.4
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    if (q.this.aig == null || q.this.isNative) {
                        return;
                    }
                    q.this.aig.onAdShow();
                    com.kwad.components.ad.feed.monitor.b.c(q.this.mAdTemplate, 2, 2);
                }
            });
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(az azVar) {
            q.this.iy = azVar;
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(al.a aVar) {
            if (q.this.isNative) {
                return;
            }
            q.this.mAdWebView.setVisibility(0);
            if (q.this.iu == 0.0d) {
                q.this.iu = aVar.height;
                q.this.it.setRatio((float) r0);
                q.iB.put(Long.valueOf(q.this.mAdTemplate.posId), Double.valueOf(aVar.height / q.this.mWidth));
            }
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            String str;
            q.this.cG();
            int i6 = aVar.adN;
            if (aVar.OU) {
                i6 = aVar.adL ? 1 : 2;
            }
            boolean bc = com.kwad.sdk.core.response.b.a.bc(q.this.mAdInfo);
            com.kwad.sdk.core.webview.d.b.d dVar = aVar.adO;
            if (dVar != null && !TextUtils.isEmpty(dVar.Pj)) {
                str = aVar.adO.Pj;
            } else {
                str = "";
            }
            com.kwad.components.core.e.d.a.a(new a.C0616a(q.this.getContext()).aB(q.this.mAdTemplate).b(q.this.mApkDownloadHelper).aq(q.a(q.this, aVar)).aB(i6).aA(aVar.mI).am(str).az(5).aw(aVar.OU).au(bc).A(q.this.hR == null ? 0L : q.this.hR.getPlayDuration()).as(true).a(new a.b() { // from class: com.kwad.components.ad.feed.widget.q.12.5
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    if (q.this.aig != null) {
                        q.this.aig.onAdClicked();
                    }
                }
            }));
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(as.a aVar) {
            if (q.this.iC) {
                return;
            }
            q.this.eR = aVar.status;
            if (q.this.eR == 1) {
                q.this.iK.removeCallbacksAndMessages(null);
                if (q.this.iG != null) {
                    q.this.iG.setVisibility(8);
                }
                q.this.mAdWebView.setVisibility(0);
                com.kwad.components.core.p.a.se().aI(q.this.mAdTemplate);
                if (q.this.iI != null) {
                    q.this.iI.d(2, "");
                    return;
                }
                return;
            }
            q.this.a("3", 3, 4);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void d(int i6, String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(final int i6) {
        cG();
        com.kwad.components.core.e.d.a.a(new a.C0616a(getContext()).aB(this.mAdTemplate).b(this.mApkDownloadHelper).aB(1).aq(true).aA(i6).az(5).as(false).au(true).a(new a.b() { // from class: com.kwad.components.ad.feed.widget.q.9
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                q.this.ba(i6);
            }
        }));
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void bd() {
        com.kwad.components.core.webview.b bVar = this.iP;
        if (bVar != null) {
            bVar.kz();
        }
        this.mAdWebView.setVisibility(4);
        this.mAdWebView.setBackgroundColor(0);
        this.iP = new com.kwad.components.core.webview.b();
        this.iP.a(new b.a().aM(this.mAdTemplate).aP(com.kwad.sdk.core.response.b.b.cT(this.mAdTemplate)).d(this.mAdWebView).k(this.it).f(this.mApkDownloadHelper).a(this.iQ));
        this.mAdWebView.loadUrl(com.kwad.sdk.core.response.b.b.cT(this.mAdTemplate));
        R r5 = this.mAdTemplate;
        com.kwad.components.ad.feed.monitor.b.a(r5, com.kwad.sdk.core.response.b.b.cT(r5));
        cE();
    }

    private void cE() {
        this.iK.postDelayed(new bg() { // from class: com.kwad.components.ad.feed.widget.q.13
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                q.this.mAdWebView.stopLoading();
                q.this.mAdWebView.setVisibility(8);
                q.this.a("0", 1, 6);
            }
        }, 2500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cF() {
        float cY = com.kwad.sdk.core.response.b.b.cY(this.mAdTemplate);
        d.InterfaceC0556d interfaceC0556d = new d.InterfaceC0556d() { // from class: com.kwad.components.ad.feed.widget.q.18
            @Override // com.kwad.components.ad.feed.d.InterfaceC0556d
            public final boolean b(final double d6) {
                if (!bz.o(q.this.it, (int) (com.kwad.sdk.core.config.e.FH() * 100.0f)) || !q.this.fq()) {
                    return false;
                }
                com.kwad.components.core.e.d.a.a(new a.C0616a(q.this.getContext()).aB(q.this.mAdTemplate).b(q.this.mApkDownloadHelper).aB(2).aq(false).as(false).aA(157).az(5).au(true).a(new a.b() { // from class: com.kwad.components.ad.feed.widget.q.18.1
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        com.kwad.sdk.core.d.c.d("FeedWebView", "convertEnable End" + com.kwad.sdk.core.response.b.e.ev(q.this.mAdTemplate));
                        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                        bVar.l(d6);
                        bVar.dd(157);
                        q.this.c(bVar);
                    }
                }));
                return true;
            }
        };
        this.hg = interfaceC0556d;
        com.kwad.components.ad.feed.d.a(cY, this.mContext, interfaceC0556d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cG() {
        if (this.iH) {
            return;
        }
        this.iH = true;
        com.kwad.components.ad.feed.monitor.b.a(this.mAdTemplate, 2, getStayTime());
    }

    private boolean cH() {
        return this.eR == 1;
    }

    private void cI() {
        this.fq.registerLiveMessageListener(new AdLiveMessageListener() { // from class: com.kwad.components.ad.feed.widget.q.4
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveMessageListener
            public final void handleAdLiveMessage(List<AdLiveMessageInfo> list) {
                if (q.this.iz != null) {
                    q.this.iz.o(list);
                }
            }
        });
        this.fq.registerLiveShopListener(new AdLiveShopListener() { // from class: com.kwad.components.ad.feed.widget.q.5
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveShopListener
            public final void handleAdLiveShop(AdLiveShopInfo adLiveShopInfo) {
                if (q.this.iA != null) {
                    q.this.iA.a(adLiveShopInfo);
                }
            }
        });
    }

    private boolean ct() {
        IAdLiveOfflineView iAdLiveOfflineView = this.fq;
        if (iAdLiveOfflineView == null || iAdLiveOfflineView.getView() == null || this.hR == null) {
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
            this.hR.setAudioEnabled(h(this.mIsAudioEnable), false);
            IAdLivePlayModule adLivePlayModule = this.fr.getAdLivePlayModule(this.fq, ServiceProvider.getAppId(), String.valueOf(com.kwad.sdk.core.response.b.a.cp(this.mAdInfo)), com.kwad.sdk.core.response.b.a.cq(this.mAdInfo), com.kwad.sdk.core.response.b.a.cr(this.mAdInfo));
            this.hR = adLivePlayModule;
            adLivePlayModule.registerAdLivePlayStateListener(this.eh);
        }
        this.hR.onResume();
        return true;
    }

    private void cv() {
        String url = com.kwad.sdk.core.response.b.a.bu(this.mAdInfo).getUrl();
        this.hM.setVisibility(0);
        this.fF.setVisibility(0);
        if (TextUtils.isEmpty(url)) {
            this.hM.setImageResource(R.drawable.ksad_ad_live_end);
        } else {
            this.hM.setImageDrawable(null);
            KSImageLoader.loadImage(this.hM, url, this.mAdTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.feed.widget.q.6
                @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
                    decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a.b getCurrentVoiceItem() {
        if (this.fD == null) {
            this.fD = new a.b(new a.c() { // from class: com.kwad.components.ad.feed.widget.q.2
                @Override // com.kwad.components.core.k.a.c
                public final void bF() {
                    if (!q.this.hS) {
                        if (q.this.cq != null) {
                            com.kwad.sdk.core.video.videoview.a aVar = q.this.cq;
                            q qVar = q.this;
                            aVar.setVideoSoundEnable(qVar.h(qVar.mIsAudioEnable));
                            return;
                        }
                        return;
                    }
                    if (q.this.hR == null) {
                        q qVar2 = q.this;
                        qVar2.hR = qVar2.cu();
                    }
                    IAdLivePlayModule iAdLivePlayModule = q.this.hR;
                    q qVar3 = q.this;
                    iAdLivePlayModule.setAudioEnabled(qVar3.h(qVar3.mIsAudioEnable), false);
                }
            });
        }
        return this.fD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public aq.a getOpenNewPageListener() {
        return new aq.a() { // from class: com.kwad.components.ad.feed.widget.q.19
            @Override // com.kwad.components.core.webview.jshandler.aq.a
            public final void a(com.kwad.components.core.webview.a.b bVar) {
                AdWebViewActivityProxy.launch(q.this.mContext, new AdWebViewActivityProxy.a.C0627a().az(bVar.title).aA(bVar.url).aF(true).aD(q.this.mAdTemplate).qW());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ba.c getRegisterLiveListener() {
        return new ba.c() { // from class: com.kwad.components.ad.feed.widget.q.15
            @Override // com.kwad.components.core.webview.jshandler.ba.c
            public final void a(ba.b bVar) {
                q.this.iE = bVar;
                if (q.this.iF != null) {
                    q.this.iE.a(q.this.iF);
                    q.this.iF = null;
                }
            }
        };
    }

    private a.b getVideoPlayCallback() {
        return new a.b() { // from class: com.kwad.components.ad.feed.widget.q.8
            private boolean eE = false;

            @Override // com.kwad.components.core.video.a.c
            public final void aq() {
                if (!this.eE) {
                    this.eE = true;
                    com.kwad.components.core.p.a.se().a(q.this.mAdTemplate, System.currentTimeMillis(), 1);
                }
                com.kwad.sdk.core.video.videoview.a aVar = q.this.cq;
                q qVar = q.this;
                aVar.setVideoSoundEnable(qVar.h(qVar.mIsAudioEnable));
            }

            @Override // com.kwad.components.core.video.a.c
            public final void ar() {
                com.kwad.sdk.core.adlog.c.bY(q.this.mAdTemplate);
                q.this.ix.bg(9);
                q.this.hL.setVisibility(8);
                if (com.kwad.components.ad.feed.a.b.cf() && q.this.hO == null && !q.this.iN) {
                    q.this.hO = new d(q.this.mContext);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    q qVar = q.this;
                    qVar.addView(qVar.hO, layoutParams);
                    q.this.hO.cy();
                }
            }

            @Override // com.kwad.components.core.video.a.c
            public final void d(long j6) {
                q.this.c(j6);
            }

            @Override // com.kwad.components.core.video.a.b
            public final void onVideoPlayError(int i6, int i7) {
                com.kwad.components.ad.feed.monitor.b.a(q.this.mAdTemplate, 2, 1, com.kwad.sdk.core.response.b.a.K(q.this.mAdInfo), i6 + " " + i7, SystemClock.elapsedRealtime() - q.this.ht);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
                com.kwad.components.core.k.a.qp().a(q.this.getCurrentVoiceItem());
                com.kwad.components.ad.feed.monitor.b.a(q.this.mAdTemplate, 1, 1, com.kwad.sdk.core.response.b.a.K(q.this.mAdInfo), null, SystemClock.elapsedRealtime() - q.this.ht);
                com.kwad.sdk.core.adlog.c.bX(q.this.mAdTemplate);
                q.this.ix.bg(3);
                if (q.this.hO != null && (q.this.hO.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) q.this.hO.getParent()).removeView(q.this.hO);
                    q.this.hO.cz();
                    q.this.hO = null;
                }
                if (q.this.iL == null && com.kwad.sdk.core.response.b.b.cW(q.this.mAdTemplate) && q.this.iN) {
                    q.this.iL = new e(q.this.mContext);
                    q.this.hL.addView(q.this.iL, new FrameLayout.LayoutParams(-1, -1));
                    q.this.iL.setOnViewEventListener(new com.kwad.sdk.widget.d() { // from class: com.kwad.components.ad.feed.widget.q.8.1
                        @Override // com.kwad.sdk.widget.d
                        public final void a(View view) {
                            if (com.kwad.sdk.core.response.b.b.cX(q.this.mAdTemplate)) {
                                return;
                            }
                            q.this.E(158);
                        }

                        @Override // com.kwad.sdk.widget.d
                        public final void b(View view) {
                            if (com.kwad.sdk.core.response.b.b.cX(q.this.mAdTemplate) || !com.kwad.sdk.core.response.b.d.ea(q.this.mAdTemplate)) {
                                return;
                            }
                            q.this.E(153);
                        }
                    });
                    q.this.iL.a(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.feed.widget.q.8.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public final void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            q.this.iM.bf(1);
                            q.this.hL.removeView(q.this.iL);
                        }
                    });
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h(boolean z5) {
        if (!z5) {
            return false;
        }
        if (this.fD != null) {
            com.kwad.components.core.k.a.qp();
            if (!com.kwad.components.core.k.a.b(this.fD)) {
                return false;
            }
        }
        if (!com.kwad.sdk.core.config.e.hC()) {
            return !com.kwad.components.core.t.a.aC(this.mContext).sX() ? com.kwad.components.core.t.a.aC(this.mContext).aQ(false) : !com.kwad.components.core.t.a.aC(this.mContext).sW();
        }
        if (!this.cp) {
            this.cp = com.kwad.components.core.t.a.aC(this.mContext).aQ(true);
        }
        return this.cp;
    }

    private void p(AdTemplate adTemplate) {
        if (this.iO) {
            return;
        }
        if (com.kwad.sdk.core.response.b.a.cR(com.kwad.sdk.core.response.b.e.el(adTemplate))) {
            this.mAdWebView = (KsAdWebView) findViewById(R.id.ksad_web_bottom_card_webView);
        } else {
            this.mAdWebView = (KsAdWebView) findViewById(R.id.ksad_web_default_bottom_card_webView);
        }
        this.iO = true;
    }

    private static float q(AdTemplate adTemplate) {
        int i6 = adTemplate.type;
        if (i6 == 1) {
            return 0.6013f;
        }
        return (i6 == 2 || i6 == 3) ? 0.283f : 0.968f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void r(AdTemplate adTemplate) {
        com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.mAdTemplate);
        this.mApkDownloadHelper = cVar;
        cVar.setOnShowListener(this);
        this.mApkDownloadHelper.setOnDismissListener(this);
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.el(adTemplate);
        if (iB.get(Long.valueOf(this.mAdTemplate.posId)) != null) {
            this.it.setRatio(r5.floatValue());
        } else if (com.kwad.sdk.core.response.b.b.db(this.mAdTemplate) > 0.0d) {
            this.it.setRatio(com.kwad.sdk.core.response.b.b.db(this.mAdTemplate));
        } else if (this.it.getRatio() == 0.0d) {
            this.it.setRatio(q(this.mAdTemplate));
        }
        com.kwad.components.core.o.a.b.a aVar = (com.kwad.components.core.o.a.b.a) com.kwad.sdk.components.d.f(com.kwad.components.core.o.a.b.a.class);
        this.fr = aVar;
        if (aVar != null && aVar.qu() && com.kwad.sdk.core.response.b.a.cR(this.mAdInfo)) {
            this.hS = true;
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void W() {
        az azVar;
        b.a aVar;
        if (!this.mAdTemplate.mPvReported && (aVar = this.aig) != null && this.isNative) {
            aVar.onAdShow();
            com.kwad.components.ad.feed.monitor.b.c(this.mAdTemplate, 1, 2);
        }
        if (this.isNative || (azVar = this.iy) == null) {
            return;
        }
        azVar.uG();
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void aa() {
        super.aa();
        if (this.hg != null) {
            com.kwad.components.ad.feed.d.a(com.kwad.sdk.core.response.b.b.cY(this.mAdTemplate), this.mContext, this.hg);
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void ab() {
        super.ab();
        this.iK.removeCallbacksAndMessages(null);
        com.kwad.sdk.utils.n.eK(this.mAdTemplate);
        d.InterfaceC0556d interfaceC0556d = this.hg;
        if (interfaceC0556d != null) {
            com.kwad.components.ad.feed.d.a(interfaceC0556d);
        }
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
        this.iE = null;
        this.iF = null;
    }

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        return R.layout.ksad_feed_webview;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.View
    public final void onWindowFocusChanged(boolean z5) {
        IAdLivePlayModule iAdLivePlayModule;
        ViewGroup viewGroup;
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
            if (aVar != null && (viewGroup = (ViewGroup) aVar.getParent()) != this.hL) {
                viewGroup.removeView(this.cq);
                if (this.hL.getTag() != null) {
                    KSRelativeLayout kSRelativeLayout = this.hL;
                    kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
                    this.hL.setTag(null);
                }
                this.hL.addView(this.cq);
                this.hL.setTag(this.cq);
                this.cq.setVideoSoundEnable(this.mIsAudioEnable);
                this.hN.setVideoPlayCallback(getVideoPlayCallback());
                this.hN.setAdClickListener(this.hQ);
                this.hN.getAdTemplate().mAdWebVideoPageShowing = false;
                this.hN.tU();
                this.hN.setAutoRelease(true);
            }
            AdInfo adInfo = this.mAdInfo;
            if (adInfo != null) {
                AdVideoPlayerViewCache.getInstance().remove(com.kwad.sdk.core.response.b.a.K(adInfo));
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final void setPreloadListener(a aVar) {
        a aVar2 = this.iI;
        if (aVar2 != null) {
            aVar2.d(this.eR == 1 ? 2 : 1, "");
        }
        this.iI = aVar;
    }

    public final void setVideoPlayConfig(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        com.kwad.components.core.video.e eVar;
        IAdLivePlayModule iAdLivePlayModule;
        this.bU = ksAdVideoPlayConfig;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoSoundValue() != 0) {
                boolean isVideoSoundEnable = kSAdVideoPlayConfigImpl.isVideoSoundEnable();
                this.mIsAudioEnable = isVideoSoundEnable;
                R r5 = this.mAdTemplate;
                if (r5 != 0) {
                    r5.mIsAudioEnable = isVideoSoundEnable;
                }
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
            }
            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() == 0 || (eVar = this.hN) == null) {
                return;
            }
            eVar.setDataAutoStart(kSAdVideoPlayConfigImpl.isDataFlowAutoStart());
        }
    }

    public final void setWidth(int i6) {
        if (i6 <= 0) {
            i6 = getContext().getResources().getDisplayMetrics().widthPixels;
        }
        this.mWidth = i6;
    }

    public q(@NonNull Context context) {
        super(context);
        this.eR = -1;
        this.mIsAudioEnable = false;
        this.isNative = false;
        this.iK = new Handler(Looper.getMainLooper());
        this.iN = false;
        this.iO = false;
        this.cB = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.feed.widget.q.1
            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                q.a(q.this, false);
                if (q.this.cq != null) {
                    q.this.cq.setVideoSoundEnable(false);
                }
                if (q.this.hR != null) {
                    q.this.hR.setAudioEnabled(false, false);
                }
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
            }
        };
        this.iQ = new AnonymousClass12();
        this.iR = new b.a() { // from class: com.kwad.components.ad.feed.widget.q.14
            @Override // com.kwad.components.core.widget.b.a
            public final void onAdClicked() {
                if (q.this.aig != null) {
                    q.this.aig.onAdClicked();
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onAdShow() {
                if (q.this.aig != null && q.this.isNative) {
                    q.this.aig.onAdShow();
                }
                if (q.this.isNative) {
                    com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                    a.C0675a c0675a = new a.C0675a();
                    FeedType fromInt = FeedType.fromInt(q.this.mAdTemplate.type, q.this.mAdTemplate.defaultType);
                    if (fromInt == FeedType.FEED_TYPE_TEXT_NEW) {
                        fromInt = FeedType.FEED_TYPE_TEXT_BELOW;
                    }
                    c0675a.templateId = String.valueOf(fromInt.getType());
                    bVar.b(c0675a);
                    bVar.w((int) Math.ceil(q.this.iu), q.this.mWidth);
                    com.kwad.components.core.t.b.sY().a(q.this.mAdTemplate, null, bVar);
                    com.kwad.components.ad.feed.monitor.b.c(q.this.mAdTemplate, 1, 2);
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDislikeClicked() {
                if (q.this.aig != null) {
                    q.this.aig.onDislikeClicked();
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDownloadTipsDialogDismiss() {
                if (q.this.aig != null) {
                    q.this.aig.onDownloadTipsDialogDismiss();
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDownloadTipsDialogShow() {
                if (q.this.aig != null) {
                    q.this.aig.onDownloadTipsDialogShow();
                }
            }
        };
        this.mNetworking = new com.kwad.sdk.core.network.l<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData>() { // from class: com.kwad.components.ad.feed.widget.q.16
            @Override // com.kwad.sdk.core.network.l
            public final boolean isPostByJson() {
                return false;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: cM, reason: merged with bridge method [inline-methods] */
            public com.kwad.components.core.liveEnd.a createRequest() {
                return new com.kwad.components.core.liveEnd.a(q.this.iS);
            }

            @NonNull
            private static AdLiveEndCommonResultData u(String str) {
                AdLiveEndCommonResultData adLiveEndCommonResultData = new AdLiveEndCommonResultData();
                adLiveEndCommonResultData.parseJson(new JSONObject(str));
                return adLiveEndCommonResultData;
            }

            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ AdLiveEndCommonResultData parseData(String str) {
                return u(str);
            }
        };
        this.eh = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.feed.widget.q.17
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayEnd() {
                super.onLivePlayEnd();
                String bh = com.kwad.sdk.core.response.b.a.bh(q.this.mAdInfo);
                if (!TextUtils.isEmpty(bh)) {
                    com.kwad.components.core.o.a.b.a aVar = (com.kwad.components.core.o.a.b.a) com.kwad.sdk.components.d.f(com.kwad.components.core.o.a.b.a.class);
                    if (aVar != null) {
                        q.this.iS = aVar.getAdLiveEndRequest(bh);
                    }
                    q.this.mNetworking.request(new com.kwad.sdk.core.network.o<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData>() { // from class: com.kwad.components.ad.feed.widget.q.17.1
                        /* JADX INFO: Access modifiers changed from: private */
                        @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                        /* renamed from: a, reason: merged with bridge method [inline-methods] */
                        public void onStartRequest(@NonNull com.kwad.components.core.liveEnd.a aVar2) {
                            super.onStartRequest(aVar2);
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                        /* renamed from: a, reason: merged with bridge method [inline-methods] */
                        public void onSuccess(@NonNull com.kwad.components.core.liveEnd.a aVar2, @NonNull AdLiveEndCommonResultData adLiveEndCommonResultData) {
                            super.onSuccess(aVar2, adLiveEndCommonResultData);
                            ba.a aVar3 = new ba.a();
                            aVar3.status = 9;
                            aVar3.totalWatchingDuration = adLiveEndCommonResultData.totalWatchingDuration;
                            aVar3.watchingUserCount = adLiveEndCommonResultData.watchingUserCount;
                            aVar3.displayWatchingUserCount = adLiveEndCommonResultData.displayWatchingUserCount;
                            aVar3.likeUserCount = adLiveEndCommonResultData.likeUserCount;
                            aVar3.displayLikeUserCount = adLiveEndCommonResultData.displayLikeUserCount;
                            aVar3.liveDuration = adLiveEndCommonResultData.liveDuration;
                            if (q.this.iE != null) {
                                q.this.iE.a(aVar3);
                            } else {
                                q.this.iF = aVar3;
                            }
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                        /* renamed from: a, reason: merged with bridge method [inline-methods] */
                        public void onError(@NonNull com.kwad.components.core.liveEnd.a aVar2, int i6, String str) {
                            super.onError(aVar2, i6, str);
                        }
                    });
                }
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayProgress(long j6) {
                super.onLivePlayProgress(j6);
                q.this.c(j6);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayResume() {
                com.kwad.components.core.k.a.qp().a(q.this.getCurrentVoiceItem());
                super.onLivePlayResume();
                IAdLivePlayModule iAdLivePlayModule = q.this.hR;
                q qVar = q.this;
                iAdLivePlayModule.setAudioEnabled(qVar.h(qVar.mIsAudioEnable), false);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayStart() {
                com.kwad.components.core.k.a.qp().a(q.this.getCurrentVoiceItem());
                super.onLivePlayStart();
                IAdLivePlayModule iAdLivePlayModule = q.this.hR;
                q qVar = q.this;
                iAdLivePlayModule.setAudioEnabled(qVar.h(qVar.mIsAudioEnable), false);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePrepared() {
                super.onLivePrepared();
                q.this.hR.setAudioEnabled(false, false);
            }
        };
        this.hQ = new a.InterfaceC0635a() { // from class: com.kwad.components.ad.feed.widget.q.11
            @Override // com.kwad.components.core.video.a.InterfaceC0635a
            public final void a(int i6, aj.a aVar) {
                int i7;
                int i8 = 2;
                boolean z5 = false;
                if (i6 == 1) {
                    i7 = 13;
                } else if (i6 == 2) {
                    i7 = 82;
                } else if (i6 != 3) {
                    i7 = 108;
                } else {
                    i7 = 83;
                    i8 = 1;
                    z5 = true;
                }
                q.this.cG();
                com.kwad.components.core.e.d.a.a(new a.C0616a(q.this.getContext()).aB(q.this.mAdTemplate).b(q.this.mApkDownloadHelper).aB(i8).aq(z5).as(true).aA(i7).d(aVar).au(true).a(new a.b() { // from class: com.kwad.components.ad.feed.widget.q.11.1
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        q.this.vV();
                    }
                }));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IAdLivePlayModule cu() {
        cv();
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
        bw.postOnUiThread(new bg() { // from class: com.kwad.components.ad.feed.widget.q.3
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                q.this.d(view);
            }
        });
        cI();
        if (this.mIsAudioEnable) {
            com.kwad.components.core.t.a.aC(this.mContext).a(this.cB);
        }
        return adLivePlayModule;
    }

    static /* synthetic */ boolean d(q qVar, boolean z5) {
        qVar.iN = true;
        return true;
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.j.c
    public final void bt() {
        super.bt();
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
    public final void bw() {
        com.kwad.components.ad.feed.monitor.b.ci();
        this.it = (RatioFrameLayout) findViewById(R.id.ksad_container);
        this.hL = (KSRelativeLayout) findViewById(R.id.ksad_feed_ad_video_container);
        this.iv = (LinearLayout) findViewById(R.id.ksad_video_immerse_text_container);
        this.iw = (TextView) findViewById(R.id.ksad_video_immerse_text);
        this.hM = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
        this.fF = findViewById(R.id.ksad_live_end_bg_mantle);
    }

    @Override // com.kwad.components.core.widget.b
    public final void cq() {
        super.cq();
        if (this.eR != 1 && !this.iC) {
            this.mAdWebView.stopLoading();
            this.mAdWebView.setVisibility(8);
            a("0", 1, 3);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (com.kwad.sdk.core.config.e.FM() && com.kwad.sdk.core.response.b.d.ea(this.mAdTemplate)) {
            if (com.kwad.sdk.core.response.b.b.cs(this.mAdTemplate) == null) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            b(motionEvent);
            if ((action == 2 || action == 3) && this.mAdWebView != null && !this.isNative && Math.abs(motionEvent.getX() - this.hu) > 0.0f) {
                this.mAdWebView.requestDisallowInterceptTouchEvent(true);
                double abs = Math.abs(motionEvent.getX() - this.hu);
                double abs2 = Math.abs(motionEvent.getY() - this.hv);
                if (Math.tan(r1.maxRange) * abs < abs2 || Math.tan(r1.minRange) * abs < abs2) {
                    this.mAdWebView.requestDisallowInterceptTouchEvent(false);
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private void b(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 0) {
            return;
        }
        this.hu = motionEvent.getX();
        this.hv = motionEvent.getY();
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

    @Override // com.kwad.components.core.widget.b
    public final void d(@NonNull AdResultData adResultData) {
        AdTemplate r5 = com.kwad.sdk.core.response.b.c.r(adResultData);
        p(r5);
        r5.realShowType = 2;
        super.d((q) adResultData);
        if (this.iC) {
            com.kwad.components.core.widget.b bVar = this.iG;
            if (bVar != null) {
                bVar.d(adResultData);
                com.kwad.components.core.widget.b bVar2 = this.iG;
                if (bVar2 instanceof c) {
                    ((c) bVar2).b(this.bU);
                    return;
                }
                return;
            }
            return;
        }
        if (!com.kwad.sdk.core.response.b.b.dc(this.mAdTemplate)) {
            a("0", 0, 1);
            return;
        }
        if (!cH()) {
            r(this.mAdTemplate);
        }
        try {
            String str = this.iD;
            if (str == null || !str.equals(r5.mOriginJString)) {
                if (cH()) {
                    this.mAdWebView.reload();
                } else {
                    this.eR = -2;
                    bd();
                }
            }
        } catch (Throwable unused) {
            a("0", 0, 2);
        }
        this.iD = r5.mOriginJString;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(@androidx.annotation.NonNull com.kwad.sdk.api.KsAdVideoPlayConfig r11) {
        /*
            Method dump skipped, instructions count: 392
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.feed.widget.q.b(com.kwad.sdk.api.KsAdVideoPlayConfig):void");
    }

    static /* synthetic */ boolean a(q qVar, com.kwad.sdk.core.webview.d.b.a aVar) {
        return b(aVar);
    }

    static /* synthetic */ boolean a(q qVar, boolean z5) {
        qVar.cp = false;
        return false;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
    }

    @Override // com.kwad.components.core.widget.b
    public final void setMargin(int i6) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i6, int i7) {
        int i8;
        com.kwad.sdk.core.d.c.d("FeedWebView", "handleWebViewError " + str);
        this.iK.removeCallbacksAndMessages(null);
        if (this.iC) {
            return;
        }
        this.iC = true;
        if (this.mAdWebView != null) {
            R r5 = this.mAdTemplate;
            com.kwad.components.ad.feed.monitor.b.a(r5, com.kwad.sdk.core.response.b.b.cT(r5), System.currentTimeMillis() - this.mAdWebView.getLoadTime(), i6);
        }
        com.kwad.components.core.p.a se = com.kwad.components.core.p.a.se();
        AdTemplate adTemplate = this.mAdTemplate;
        se.b(adTemplate, com.kwad.sdk.core.response.b.b.cT(adTemplate), str);
        try {
            i8 = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            com.kwad.sdk.core.d.c.d("FeedWebView", "handleWebViewError errorCode exception" + str);
            i8 = 0;
        }
        com.kwad.components.ad.feed.monitor.b.a(i8, com.kwad.sdk.core.response.b.a.be(this.mAdInfo), this.mAdTemplate, i7);
        a aVar = this.iI;
        if (aVar != null) {
            aVar.d(1, str);
        }
        this.iI = null;
        if (this.iG == null) {
            this.isNative = true;
            com.kwad.components.core.widget.b.c(this);
            int be = com.kwad.sdk.core.response.b.a.be(this.mAdInfo);
            IAdLivePlayModule iAdLivePlayModule = this.hR;
            if (iAdLivePlayModule != null) {
                iAdLivePlayModule.setAudioEnabled(false, false);
                this.hR.onDestroy();
                this.hR = null;
            }
            IAdLiveOfflineView iAdLiveOfflineView = this.fq;
            if (iAdLiveOfflineView != null) {
                iAdLiveOfflineView.onDestroy();
                this.fq = null;
            }
            Context context = this.mContext;
            R r6 = this.mAdTemplate;
            com.kwad.components.core.widget.b a6 = com.kwad.components.ad.feed.b.a(context, FeedType.fromInt(r6.type, r6.defaultType), be);
            this.iG = a6;
            if (a6 != null) {
                this.iG.setMargin(com.kwad.sdk.c.a.a.a(this.mContext, 16.0f));
                this.it.removeAllViews();
                this.it.setRatio(0.0d);
                KsAdWebView ksAdWebView = this.mAdWebView;
                if (ksAdWebView != null) {
                    ksAdWebView.setVisibility(8);
                }
                this.hL.setVisibility(8);
                this.iG.setInnerAdInteractionListener(this.iR);
                this.it.addView(this.iG);
                this.iG.d(this.mAdResultData);
                com.kwad.components.core.widget.b bVar = this.iG;
                if (bVar instanceof c) {
                    ((c) bVar).b(this.bU);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(View view) {
        int width = this.hL.getWidth();
        int height = this.hL.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (height * 0.5625f), height);
        layoutParams.addRule(13, -1);
        view.setLayoutParams(layoutParams);
    }

    @Override // com.kwad.sdk.widget.d
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.ea(this.mAdTemplate)) {
            if (view == this.hL || view == this.iw) {
                a(this.cq, 153);
            }
        }
    }

    private static boolean b(com.kwad.sdk.core.webview.d.b.a aVar) {
        if (aVar.OU) {
            return aVar.adL;
        }
        return aVar.adN == 1;
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view) {
        if (view == this.hL) {
            if (this.cq.isIdle()) {
                com.kwad.sdk.utils.n.eL(this.mAdTemplate);
                this.cq.setKsPlayLogParam(com.kwad.sdk.contentalliance.a.a.a.bQ(this.mAdTemplate));
                this.cq.start();
                return;
            }
            a(this.cq, 100);
            return;
        }
        if (view == this.iw) {
            a(this.cq, 25);
        }
    }

    private void a(com.kwad.sdk.core.video.videoview.a aVar, final int i6) {
        if (aVar != null) {
            String K = com.kwad.sdk.core.response.b.a.K(this.mAdInfo);
            this.hN.setAutoRelease(false);
            AdVideoPlayerViewCache.getInstance().a(K, this.cq);
            R r5 = this.mAdTemplate;
            FeedType.fromInt(r5.type, r5.defaultType);
            cG();
            com.kwad.components.core.e.d.a.a(new a.C0616a(getContext()).aB(this.mAdTemplate).b(this.mApkDownloadHelper).aB(2).au(com.kwad.sdk.core.response.b.a.bc(this.mAdInfo)).a(new a.b() { // from class: com.kwad.components.ad.feed.widget.q.10
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    q.this.ba(i6);
                }
            }));
        }
    }
}
