package com.kwad.components.ad.fullscreen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.ad.reward.j;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.proxy.PageCreateStage;
import com.kwad.components.offline.api.core.adlive.listener.OnAdLiveResumeInterceptor;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.FeedDownloadActivity;
import com.kwad.sdk.api.proxy.app.KsFullScreenLandScapeVideoActivity;
import com.kwad.sdk.api.proxy.app.KsFullScreenVideoActivity;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.bv;
import com.kwad.sdk.utils.n;
import com.stub.StubApp;
import java.io.Serializable;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsAdSdkDynamicImpl(FeedDownloadActivity.class)
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public class KsFullScreenVideoActivityProxy extends com.kwad.components.core.m.b<com.kwad.components.ad.reward.g> implements OnAdLiveResumeInterceptor {
    public static final String KEY_AD_RESULT_CACHE_IDX = "key_ad_result_cache_idx";
    public static final String KEY_TEMPLATE = "key_template_json";
    public static final String KEY_VIDEO_PLAY_CONFIG = "key_video_play_config";
    public static final String KEY_VIDEO_PLAY_CONFIG_JSON = "key_video_play_config_json";
    private static final String TAG = "FullScreenVideo";
    private static final HashMap<String, c> sHashMap = new HashMap<>();
    private AdInfo mAdInfo;
    private AdResultData mAdResultData;
    private AdTemplate mAdTemplate;
    private com.kwad.components.ad.fullscreen.c.b mFullScreenPresenter;
    private c mInteractionListener;
    private boolean mIsBackEnable;
    private boolean mPageDismissCalled;
    public long mPageEnterTime;
    private JSONObject mReportExtData;
    private AdBaseFrameLayout mRootContainer;
    public int mScreenOrientation;
    private bv mTimerHelper;
    private KsVideoPlayConfig mVideoPlayConfig;
    private b model;
    private boolean mReportedPageResume = false;
    private com.kwad.components.ad.reward.e.g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.fullscreen.KsFullScreenVideoActivityProxy.1
        @Override // com.kwad.components.ad.reward.e.g
        public final void cX() {
            KsFullScreenVideoActivityProxy.this.mIsBackEnable = true;
        }
    };
    private d mAdOpenInteractionListener = new d() { // from class: com.kwad.components.ad.fullscreen.KsFullScreenVideoActivityProxy.2
        @Override // com.kwad.components.ad.fullscreen.d, com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
        public final void i(boolean z5) {
            if (KsFullScreenVideoActivityProxy.this.notifyPageDismiss()) {
                super.i(z5);
            }
        }
    };

    private static void reportSubPageCreate(String str, AdTemplate adTemplate) {
        com.kwad.components.ad.reward.monitor.c.c(false, adTemplate, str);
    }

    @Override // com.kwad.components.core.proxy.f
    public boolean needAdaptionScreen() {
        return true;
    }

    private static String getListenerKey(AdTemplate adTemplate) {
        return adTemplate == null ? "" : String.valueOf(com.kwad.sdk.core.response.b.e.el(adTemplate).adBaseInfo.creativeId);
    }

    private bv getTimerHelper() {
        if (this.mTimerHelper == null) {
            bv bvVar = new bv();
            this.mTimerHelper = bvVar;
            bvVar.startTiming();
        }
        return this.mTimerHelper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean notifyPageDismiss() {
        if (this.mPageDismissCalled) {
            return false;
        }
        this.mPageDismissCalled = true;
        if (this.mAdTemplate != null && this.mAdInfo != null) {
            long time = getTimerHelper().getTime();
            com.kwad.sdk.a.a.c.CU().CX();
            com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, 6, time, this.mReportExtData);
            if (com.kwad.sdk.core.response.b.a.cS(this.mAdInfo) && !((com.kwad.components.ad.reward.g) this.mCallerContext).mw) {
                com.kwad.sdk.core.adlog.c.m(this.model.getAdTemplate(), (int) Math.ceil(time / 1000.0f));
            }
        }
        return true;
    }

    @InvokeBy(invokerClass = com.kwad.sdk.service.c.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        com.kwad.sdk.service.c.a(KsFullScreenVideoActivity.class, KsFullScreenVideoActivityProxy.class);
        com.kwad.sdk.service.c.a(FeedDownloadActivity.class, KsFullScreenVideoActivityProxy.class);
    }

    @Override // com.kwad.components.core.proxy.f
    public int getLayoutId() {
        b bVar = this.model;
        return (bVar == null || !bVar.jk) ? R.layout.ksad_activity_fullscreen_video_legacy : R.layout.ksad_activity_fullscreen_tk;
    }

    @Override // com.kwad.components.core.proxy.f
    public String getPageName() {
        return "KsFullScreenVideoActivityProxy";
    }

    @Override // com.kwad.components.offline.api.core.adlive.listener.OnAdLiveResumeInterceptor
    public boolean handledAdLiveOnResume() {
        return ((com.kwad.components.ad.reward.g) this.mCallerContext).gG();
    }

    @Override // com.kwad.components.core.proxy.f
    public void initView() {
        this.mRootContainer = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        com.kwad.components.ad.fullscreen.c.b bVar = this.mFullScreenPresenter;
        if ((bVar == null || !bVar.onBackPressed()) && this.mIsBackEnable) {
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.kwad.components.core.m.b
    public com.kwad.components.ad.reward.g onCreateCallerContext() {
        com.kwad.components.ad.reward.g gVar = new com.kwad.components.ad.reward.g(this);
        gVar.a(this.mAdResultData);
        gVar.mPageEnterTime = this.mPageEnterTime;
        gVar.rC = false;
        gVar.rD = this.mAdOpenInteractionListener;
        gVar.mScreenOrientation = this.mScreenOrientation;
        gVar.mVideoPlayConfig = this.mVideoPlayConfig;
        gVar.mReportExtData = this.mReportExtData;
        gVar.mRootContainer = this.mRootContainer;
        if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
            gVar.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate, this.mReportExtData);
        }
        gVar.rG = new RewardActionBarControl(gVar, this.mContext, this.mAdTemplate);
        gVar.b(this.mPlayEndPageListener);
        if (com.kwad.sdk.core.response.b.b.cL(this.mAdTemplate)) {
            gVar.rH = new j(gVar, this.mReportExtData, null);
        }
        if (com.kwad.sdk.core.response.b.a.bK(this.mAdInfo)) {
            gVar.rF = new com.kwad.components.core.playable.a((KsAdWebView) findViewById(R.id.ksad_playable_webview));
        }
        gVar.rS = false;
        gVar.sq = com.kwad.sdk.core.response.b.a.bK(this.mAdInfo) ? com.kwad.sdk.core.response.b.a.ar(this.mAdInfo) : com.kwad.sdk.core.response.b.a.am(this.mAdInfo);
        gVar.mTimerHelper = getTimerHelper();
        gVar.rE = new com.kwad.components.ad.reward.m.e(gVar);
        return gVar;
    }

    @Override // com.kwad.components.core.m.b
    public Presenter onCreatePresenter() {
        getActivity();
        com.kwad.components.ad.fullscreen.c.b bVar = new com.kwad.components.ad.fullscreen.c.b(this, this.mRootContainer, this.model, (com.kwad.components.ad.reward.g) this.mCallerContext);
        this.mFullScreenPresenter = bVar;
        return bVar;
    }

    private void initVideoPlayConfig(@NonNull KsVideoPlayConfig ksVideoPlayConfig) {
        if (!TextUtils.isEmpty(ksVideoPlayConfig.getShowScene())) {
            this.mReportExtData = null;
            JSONObject jSONObject = new JSONObject();
            this.mReportExtData = jSONObject;
            aa.putValue(jSONObject, "ext_showscene", ksVideoPlayConfig.getShowScene());
        }
    }

    public static void launch(@NonNull Context context, @NonNull AdResultData adResultData, @NonNull KsVideoPlayConfig ksVideoPlayConfig, c cVar) {
        Intent intent;
        AdTemplate r5 = com.kwad.sdk.core.response.b.c.r(adResultData);
        com.kwad.components.ad.reward.monitor.c.i(false, r5);
        n.eL(r5);
        if (ksVideoPlayConfig.isShowLandscape()) {
            com.kwad.sdk.service.c.a(KsFullScreenLandScapeVideoActivity.class, KsFullScreenLandScapeVideoActivityProxy.class);
            intent = new Intent(context, (Class<?>) KsFullScreenLandScapeVideoActivity.class);
        } else {
            com.kwad.sdk.service.c.a(FeedDownloadActivity.class, KsFullScreenVideoActivityProxy.class);
            intent = new Intent(context, (Class<?>) FeedDownloadActivity.class);
        }
        intent.setFlags(268435456);
        intent.putExtra("key_ad_result_cache_idx", com.kwad.components.core.c.f.ol().l(adResultData));
        intent.putExtra("key_video_play_config", ksVideoPlayConfig);
        intent.putExtra("key_video_play_config_json", com.kwad.components.core.internal.api.e.a(ksVideoPlayConfig));
        sHashMap.put(getListenerKey(r5), cVar);
        try {
            context.startActivity(intent);
            com.kwad.sdk.a.a.c.CU().bm(true);
            reportSubPageCreate(PageCreateStage.END_LAUNCH.getStage(), r5);
        } catch (Throwable th) {
            com.kwad.components.ad.reward.monitor.c.a(false, r5, PageCreateStage.ERROR_START_ACTIVITY.getStage(), th.getMessage());
            throw th;
        }
    }

    @Override // com.kwad.components.core.proxy.f
    public boolean checkIntentData(@Nullable Intent intent) {
        if (com.kwad.sdk.core.config.e.Gg()) {
            this.mVideoPlayConfig = com.kwad.components.core.internal.api.e.b(getIntent().getStringExtra("key_video_play_config_json"), true);
        } else {
            Serializable serializableExtra = getIntent().getSerializableExtra("key_video_play_config");
            if (serializableExtra instanceof KsVideoPlayConfig) {
                this.mVideoPlayConfig = (KsVideoPlayConfig) serializableExtra;
            }
        }
        AdResultData d6 = com.kwad.components.core.c.f.ol().d(getIntent().getIntExtra("key_ad_result_cache_idx", 0), true);
        this.mAdResultData = d6;
        if (d6 == null) {
            return false;
        }
        AdTemplate r5 = com.kwad.sdk.core.response.b.c.r(d6);
        this.mAdTemplate = r5;
        this.model = new b(r5);
        this.mAdOpenInteractionListener.setAdTemplate(this.mAdTemplate);
        if (this.mVideoPlayConfig != null && this.mAdTemplate != null) {
            return true;
        }
        return false;
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void finish() {
        super.finish();
        this.mAdOpenInteractionListener.i(false);
    }

    @Override // com.kwad.components.core.proxy.f
    public void initData() {
        int i6;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.mPageEnterTime = elapsedRealtime;
        com.kwad.components.ad.reward.monitor.c.a(false, this.mAdTemplate, elapsedRealtime);
        com.kwad.components.ad.reward.monitor.c.g(false, this.mAdTemplate);
        c cVar = sHashMap.get(getListenerKey(this.mAdTemplate));
        this.mInteractionListener = cVar;
        this.mAdOpenInteractionListener.a(cVar);
        this.mAdInfo = com.kwad.sdk.core.response.b.e.el(this.mAdTemplate);
        this.mScreenOrientation = this.mVideoPlayConfig.isShowLandscape() ? 1 : 0;
        AdTemplate adTemplate = this.mAdTemplate;
        if (this.mVideoPlayConfig.isVideoSoundEnable()) {
            i6 = 2;
        } else {
            i6 = 1;
        }
        adTemplate.mInitVoiceStatus = i6;
        initVideoPlayConfig(this.mVideoPlayConfig);
    }

    @Override // com.kwad.components.core.m.b, com.kwad.components.core.proxy.f
    public void onActivityCreate() {
        super.onActivityCreate();
        com.kwad.sdk.commercial.d.c.bL(this.mAdTemplate);
    }

    @Override // com.kwad.components.core.proxy.f
    public void onCreateCaughtException(Throwable th) {
        super.onCreateCaughtException(th);
        com.kwad.components.ad.reward.monitor.b.b(false, this.mAdTemplate);
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.components.core.proxy.a.c
    public void onCreateStageChange(PageCreateStage pageCreateStage) {
        super.onCreateStageChange(pageCreateStage);
        reportSubPageCreate(pageCreateStage.getStage(), this.mAdTemplate);
    }

    @Override // com.kwad.components.core.m.b, com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        try {
            super.onDestroy();
            this.mAdOpenInteractionListener.i(false);
            AdInfo adInfo = this.mAdInfo;
            if (adInfo != null) {
                String K = com.kwad.sdk.core.response.b.a.K(adInfo);
                if (!TextUtils.isEmpty(K)) {
                    com.kwad.sdk.core.videocache.c.a.bR(StubApp.getOrigApplicationContext(this.mContext.getApplicationContext())).eM(K);
                }
            }
            T t5 = this.mCallerContext;
            if (t5 != 0 && ((com.kwad.components.ad.reward.g) t5).rE != null && ((com.kwad.components.ad.reward.g) t5).rE.kW()) {
                ((com.kwad.components.ad.reward.g) this.mCallerContext).rE.kX().removeInterceptor(this);
            }
            sHashMap.remove(getListenerKey(this.mAdTemplate));
            this.mInteractionListener = null;
            com.kwad.components.core.g.a.a(com.kwad.sdk.commercial.d.be(this.mAdTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.core.m.b, com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        try {
            super.onPause();
            getTimerHelper().Sm();
            T t5 = this.mCallerContext;
            if (t5 != 0) {
                ((com.kwad.components.ad.reward.g) t5).mPageEnterTime = -1L;
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPreCreate(@Nullable Bundle bundle) {
        super.onPreCreate(bundle);
        try {
            getIntent().removeExtra("key_template");
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.components.core.m.b, com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        try {
            super.onResume();
            getTimerHelper().Sl();
            if (!this.mReportedPageResume) {
                com.kwad.components.ad.reward.monitor.c.f(false, this.mAdTemplate);
                this.mReportedPageResume = true;
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
