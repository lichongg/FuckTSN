package com.kwad.components.ad.reward;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.n;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.exception.KSAdPreCreateException;
import com.kwad.components.core.proxy.PageCreateStage;
import com.kwad.components.core.t.c;
import com.kwad.components.offline.api.core.adlive.listener.OnAdLiveResumeInterceptor;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.KSRewardLandScapeVideoActivity;
import com.kwad.sdk.api.proxy.app.KsRewardVideoActivity;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bv;
import com.kwad.sdk.utils.bw;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsAdSdkDynamicImpl(KsRewardVideoActivity.class)
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public class KSRewardVideoActivityProxy extends com.kwad.components.core.m.b<g> implements g.b, n.a, c.b, OnAdLiveResumeInterceptor {
    public static final String KEY_AD_RESULT_CACHE_IDX = "key_ad_result_cache_idx";
    public static final String KEY_REWARD_TYPE = "key_template_reward_type";
    public static final String KEY_TEMPLATE = "key_template_json";
    public static final String KEY_VIDEO_PLAY_CONFIG = "key_video_play_config";
    public static final String KEY_VIDEO_PLAY_CONFIG_JSON = "key_video_play_config_json";
    private static final String TAG = "RewardVideo";
    private String listenerKey;
    private boolean mIsBackEnable;
    private com.kwad.components.ad.reward.model.c mModel;
    private boolean mPageDismissCalled;
    private long mPageEnterTime;
    private n mRewardPresenter;
    private AdBaseFrameLayout mRootContainer;
    private bv mTimerHelper;
    private boolean mReportedPageResume = false;
    private boolean mIsFinishVideoLookStep = false;
    private final com.kwad.components.ad.reward.e.l mRewardVerifyListener = new com.kwad.components.ad.reward.e.l() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.1
        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            if (KSRewardVideoActivityProxy.this.mModel.it() && ((g) KSRewardVideoActivityProxy.this.mCallerContext).mCheckExposureResult && ((g) KSRewardVideoActivityProxy.this.mCallerContext).sc != 2) {
                KSRewardVideoActivityProxy.this.markOpenNsCompleted();
                KSRewardVideoActivityProxy.this.notifyRewardVerify();
                KSRewardVideoActivityProxy.this.notifyRewardVerifyStepByStep();
            }
        }
    };
    private com.kwad.components.ad.reward.e.i mAdOpenInteractionListener = new com.kwad.components.ad.reward.e.i() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.2
        @Override // com.kwad.components.ad.reward.e.i, com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
        public final void i(boolean z5) {
            if (KSRewardVideoActivityProxy.this.notifyPageDismiss(z5)) {
                com.kwad.sdk.a.a.c.CU().CX();
                super.i(z5);
            }
        }

        @Override // com.kwad.components.ad.reward.e.i, com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
        public final void onRewardVerify() {
            if (!((g) KSRewardVideoActivityProxy.this.mCallerContext).mCheckExposureResult || ((g) KSRewardVideoActivityProxy.this.mCallerContext).sc == 2) {
                return;
            }
            KSRewardVideoActivityProxy.this.notifyRewardVerify();
            KSRewardVideoActivityProxy.this.notifyRewardVerifyStepByStep();
        }

        @Override // com.kwad.components.ad.reward.e.i, com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
        public final void cW() {
            super.cW();
            ((g) KSRewardVideoActivityProxy.this.mCallerContext).iH = true;
            ((g) KSRewardVideoActivityProxy.this.mCallerContext).gN();
        }
    };
    private com.kwad.components.ad.reward.e.g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.3
        @Override // com.kwad.components.ad.reward.e.g
        public final void cX() {
            KSRewardVideoActivityProxy.this.mIsBackEnable = true;
        }
    };
    private com.kwad.components.ad.reward.e.d mAdRewardStepListener = new com.kwad.components.ad.reward.e.d() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.4
        @Override // com.kwad.components.ad.reward.e.d
        public final void gp() {
            KSRewardVideoActivityProxy.this.notifyRewardVerifyStepByStep();
        }
    };

    @Override // com.kwad.components.core.proxy.f
    public boolean needAdaptionScreen() {
        return true;
    }

    @Override // com.kwad.components.ad.reward.n.a
    public void onUnbind() {
        this.mIsBackEnable = false;
        ((g) this.mCallerContext).F(false);
        ((g) this.mCallerContext).rX = false;
    }

    private bv getTimerHelper() {
        if (this.mTimerHelper == null) {
            bv bvVar = new bv();
            this.mTimerHelper = bvVar;
            bvVar.startTiming();
        }
        return this.mTimerHelper;
    }

    private String getUniqueId() {
        return this.listenerKey;
    }

    private void handleNotifyVerify(boolean z5) {
        this.mAdOpenInteractionListener.setCallerContext((g) this.mCallerContext);
        ((g) this.mCallerContext).F(true);
        this.mModel.getAdTemplate().mRewardVerifyCalled = true;
        if (z5 || ((g) this.mCallerContext).sc == 0) {
            e.gy().L(this.mModel.getAdTemplate());
        }
        com.kwad.sdk.core.adlog.c.i(this.mModel.getAdTemplate(), isNeoScan());
        if (!((g) this.mCallerContext).mAdTemplate.converted) {
            com.kwad.components.ad.reward.c.a.hV().hW().aa(com.kwad.components.ad.reward.c.b.ul);
        }
        bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.7
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                if (KSRewardVideoActivityProxy.this.mAdOpenInteractionListener.ib()) {
                    com.kwad.components.ad.reward.monitor.c.a(KSRewardVideoActivityProxy.this.mModel.getAdTemplate(), 0, -1, true);
                }
            }
        });
        if (com.kwad.sdk.core.response.b.a.cY(this.mModel.cU())) {
            T t5 = this.mCallerContext;
            if (((g) t5).mAdTemplate.converted || ((g) t5).rT || ((g) t5).gU()) {
                return;
            }
            g.a(getActivity(), (g) this.mCallerContext);
        }
    }

    private boolean isLaunchTaskCompleted() {
        T t5 = this.mCallerContext;
        return ((g) t5).sm != null && ((g) t5).sm.isCompleted();
    }

    private boolean isNeoScan() {
        return this.mModel.iy() != null && this.mModel.iy().neoPageType == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void markOpenNsCompleted() {
        T t5 = this.mCallerContext;
        if (((g) t5).sn != null) {
            ((g) t5).sn.markOpenNsCompleted();
        }
    }

    private boolean needHandledOnResume() {
        return ((g) this.mCallerContext).gV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean notifyPageDismiss(boolean z5) {
        com.kwad.components.ad.reward.model.c cVar;
        if (this.mPageDismissCalled || this.mCallerContext == 0 || (cVar = this.mModel) == null) {
            return false;
        }
        this.mPageDismissCalled = true;
        if (!com.kwad.sdk.core.response.b.a.cS(cVar.cU()) || !((g) this.mCallerContext).gT()) {
            com.kwad.sdk.core.adlog.c.m(this.mModel.getAdTemplate(), (int) Math.ceil(getTimerHelper().getTime() / 1000.0f));
        }
        if (z5) {
            if (this.mModel.iy() == null || this.mModel.iy().neoPageType != 1) {
                com.kwad.sdk.core.adlog.c.a(this.mModel.getAdTemplate(), 1, getTimerHelper().getTime(), ((g) this.mCallerContext).mReportExtData);
            }
        } else if (this.mModel.iy() == null || this.mModel.iy().neoPageType != 1) {
            com.kwad.sdk.core.adlog.c.a(this.mModel.getAdTemplate(), 6, getTimerHelper().getTime(), this.mModel.ix());
        }
        return true;
    }

    private void notifyRewardStep(final int i6, final int i7) {
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        if (cVar == null || com.kwad.sdk.core.response.b.e.ew(cVar.getAdTemplate()) || ((g) this.mCallerContext).rZ.contains(Integer.valueOf(i7))) {
            return;
        }
        ((g) this.mCallerContext).rZ.add(Integer.valueOf(i7));
        o.a(i6, i7, (g) this.mCallerContext, this.mModel);
        bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.6
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                try {
                    if (KSRewardVideoActivityProxy.this.mAdOpenInteractionListener.i(i6, i7)) {
                        com.kwad.components.ad.reward.monitor.c.a(KSRewardVideoActivityProxy.this.mModel.getAdTemplate(), i6, i7, false);
                    }
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRewardVerify() {
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        if (cVar == null || !((g) this.mCallerContext).mCheckExposureResult || com.kwad.sdk.core.response.b.e.ew(cVar.getAdTemplate()) || ((g) this.mCallerContext).gW()) {
            return;
        }
        if (this.mModel.is()) {
            T t5 = this.mCallerContext;
            if (((g) t5).sm == null || !((g) t5).sm.isCompleted()) {
                return;
            }
            handleNotifyVerify(true);
            return;
        }
        if (!this.mModel.it()) {
            handleNotifyVerify(false);
            return;
        }
        T t6 = this.mCallerContext;
        if (((g) t6).sn == null || !((g) t6).sn.isCompleted()) {
            return;
        }
        handleNotifyVerify(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRewardVerifyStepByStep() {
        if (this.mModel.is()) {
            notifyRewardStep(2, 0);
            if (isLaunchTaskCompleted()) {
                notifyRewardStep(2, 2);
                return;
            }
            return;
        }
        if (!this.mModel.it()) {
            if (this.mIsFinishVideoLookStep) {
                return;
            }
            this.mIsFinishVideoLookStep = true;
            notifyRewardStep(0, 0);
            return;
        }
        T t5 = this.mCallerContext;
        boolean z5 = ((g) t5).sn != null && ((g) t5).sn.isCompleted();
        notifyRewardStep(1, 0);
        if (z5) {
            notifyRewardStep(1, 1);
        }
    }

    @InvokeBy(invokerClass = com.kwad.sdk.service.c.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        com.kwad.sdk.service.c.a(KsRewardVideoActivity.class, KSRewardVideoActivityProxy.class);
    }

    private void reportSubPageCreate(String str) {
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        com.kwad.components.ad.reward.monitor.c.c(true, cVar != null ? cVar.getAdTemplate() : null, str);
    }

    @Override // com.kwad.components.core.proxy.f
    public int getLayoutId() {
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        return (cVar == null || !cVar.jk) ? R.layout.ksad_activity_reward_video_legacy : R.layout.ksad_activity_reward_neo;
    }

    @Override // com.kwad.components.core.proxy.f
    public String getPageName() {
        return "KSRewardLandScapeVideoActivityProxy";
    }

    @Override // com.kwad.components.core.proxy.f
    public void initData() {
        this.listenerKey = this.mModel.getAdTemplate().getUniqueId();
        this.mAdOpenInteractionListener.setAdTemplate(this.mModel.getAdTemplate());
        this.mAdOpenInteractionListener.R(getUniqueId());
        this.mPageEnterTime = SystemClock.elapsedRealtime();
        com.kwad.components.ad.reward.monitor.c.a(true, this.mModel.getAdTemplate(), this.mPageEnterTime, this.mModel.iy());
        com.kwad.components.ad.reward.monitor.c.g(true, this.mModel.getAdTemplate());
        com.kwad.components.core.t.c.sZ().a(this);
        b.gk().a(this.mRewardVerifyListener);
    }

    @Override // com.kwad.components.core.proxy.f
    public void initView() {
        this.mRootContainer = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        n nVar = this.mRewardPresenter;
        if (nVar == null) {
            super.onBackPressed();
            return;
        }
        BackPressHandleResult hx = nVar.hx();
        if (hx.equals(BackPressHandleResult.HANDLED)) {
            return;
        }
        if (hx.equals(BackPressHandleResult.HANDLED_CLOSE)) {
            super.onBackPressed();
            this.mAdOpenInteractionListener.i(false);
        } else if (this.mIsBackEnable) {
            this.mAdOpenInteractionListener.i(false);
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.kwad.components.core.m.b
    public g onCreateCallerContext() {
        AdResultData iu = this.mModel.iu();
        AdTemplate adTemplate = this.mModel.getAdTemplate();
        AdInfo cU = this.mModel.cU();
        final g gVar = new g(this);
        gVar.mPageEnterTime = this.mPageEnterTime;
        gVar.rC = this.mModel.iw() == 2;
        gVar.rD = this.mAdOpenInteractionListener;
        gVar.mAdRewardStepListener = this.mAdRewardStepListener;
        gVar.mScreenOrientation = this.mModel.getScreenOrientation();
        gVar.mVideoPlayConfig = this.mModel.iv();
        gVar.mReportExtData = this.mModel.ix();
        gVar.mRootContainer = this.mRootContainer;
        gVar.a(iu);
        gVar.sx = com.kwad.sdk.core.response.b.b.em(cU) ? LoadStrategy.FULL_TK : LoadStrategy.MULTI;
        gVar.a(this);
        if (com.kwad.sdk.core.response.b.a.aF(cU)) {
            gVar.mApkDownloadHelper = new com.kwad.components.core.e.d.c(adTemplate, this.mModel.ix());
        }
        gVar.rG = new RewardActionBarControl(gVar, this.mContext, adTemplate);
        gVar.b(this.mPlayEndPageListener);
        if (com.kwad.sdk.core.response.b.b.cL(adTemplate)) {
            j jVar = new j(gVar, this.mModel.ix(), null);
            gVar.rH = jVar;
            jVar.a(new com.kwad.components.ad.reward.c.d() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.5
                @Override // com.kwad.components.ad.reward.c.d
                public final void a(com.kwad.components.ad.reward.c.b bVar) {
                    gVar.b(bVar);
                }
            });
        }
        if (com.kwad.sdk.core.response.b.a.as(cU)) {
            gVar.rI = new com.kwad.components.ad.l.a().ah(true);
        }
        gVar.rS = true;
        if (com.kwad.sdk.core.response.b.a.bK(cU)) {
            gVar.rF = new com.kwad.components.core.playable.a((KsAdWebView) findViewById(R.id.ksad_playable_webview));
        }
        gVar.sq = 0L;
        if (this.mModel.cU() != null) {
            gVar.sq = com.kwad.sdk.core.response.b.a.bK(this.mModel.cU()) ? com.kwad.sdk.core.response.b.a.ar(this.mModel.cU()) : com.kwad.sdk.core.response.b.a.am(this.mModel.cU());
        }
        gVar.mTimerHelper = getTimerHelper();
        gVar.rE = new com.kwad.components.ad.reward.m.e(gVar);
        gVar.jk = this.mModel.jk;
        return gVar;
    }

    @Override // com.kwad.components.core.m.b
    public Presenter onCreatePresenter() {
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        if (cVar == null) {
            return null;
        }
        n nVar = new n(this, this.mContext, this.mRootContainer, cVar, (g) this.mCallerContext);
        this.mRewardPresenter = nVar;
        nVar.a(this);
        return this.mRewardPresenter;
    }

    public static void launch(Activity activity, AdResultData adResultData, @NonNull KsVideoPlayConfig ksVideoPlayConfig, KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener, com.kwad.components.core.j.d dVar, int i6) {
        Intent intent;
        AdTemplate r5 = com.kwad.sdk.core.response.b.c.r(adResultData);
        com.kwad.components.ad.reward.monitor.c.i(true, r5);
        AdGlobalConfigInfo adGlobalConfigInfo = adResultData.adGlobalConfigInfo;
        com.kwad.sdk.utils.n.eL(r5);
        if (adGlobalConfigInfo != null && adGlobalConfigInfo.neoPageType == 1) {
            ksVideoPlayConfig.setShowLandscape(false);
        }
        if (ksVideoPlayConfig.isShowLandscape()) {
            com.kwad.sdk.service.c.a(KSRewardLandScapeVideoActivity.class, KSRewardLandScapeVideoActivityProxy.class);
            intent = new Intent(activity, (Class<?>) KSRewardLandScapeVideoActivity.class);
        } else {
            com.kwad.sdk.service.c.a(KsRewardVideoActivity.class, KSRewardVideoActivityProxy.class);
            intent = new Intent(activity, (Class<?>) KsRewardVideoActivity.class);
        }
        intent.setFlags(268435456);
        intent.putExtra("key_template_json", r5.toJson().toString());
        intent.putExtra("key_ad_result_cache_idx", com.kwad.components.core.c.f.ol().l(adResultData));
        intent.putExtra("key_video_play_config", ksVideoPlayConfig);
        intent.putExtra("key_video_play_config_json", com.kwad.components.core.internal.api.e.a(ksVideoPlayConfig));
        intent.putExtra(KEY_REWARD_TYPE, i6);
        String uniqueId = r5.getUniqueId();
        com.kwad.components.ad.reward.e.f.a(uniqueId, rewardAdInteractionListener, dVar);
        com.kwad.components.ad.reward.e.f.O(uniqueId);
        try {
            activity.startActivity(intent);
            com.kwad.sdk.a.a.c.CU().bm(true);
            com.kwad.components.ad.reward.monitor.c.c(true, r5, PageCreateStage.END_LAUNCH.getStage());
        } catch (Throwable th) {
            com.kwad.components.ad.reward.monitor.c.a(true, r5, PageCreateStage.ERROR_START_ACTIVITY.getStage(), th.getMessage());
            ServiceProvider.reportSdkCaughtException(new KSAdPreCreateException("ksad_pre_create_exception_error_start_activity", th));
            throw th;
        }
    }

    @Override // com.kwad.components.core.proxy.f
    public boolean checkIntentData(@Nullable Intent intent) {
        com.kwad.components.ad.reward.model.c a6 = com.kwad.components.ad.reward.model.c.a(intent);
        this.mModel = a6;
        if (a6 == null) {
            return false;
        }
        return true;
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void finish() {
        super.finish();
        this.mAdOpenInteractionListener.i(false);
    }

    @Override // com.kwad.components.offline.api.core.adlive.listener.OnAdLiveResumeInterceptor
    public boolean handledAdLiveOnResume() {
        return needHandledOnResume();
    }

    @Override // com.kwad.components.ad.reward.g.b
    public boolean interceptPlayCardResume() {
        return needHandledOnResume();
    }

    @Override // com.kwad.components.core.m.b, com.kwad.components.core.proxy.f
    public void onActivityCreate() {
        super.onActivityCreate();
        com.kwad.sdk.commercial.d.c.bL(this.mModel.getAdTemplate());
    }

    @Override // com.kwad.components.core.proxy.f
    public void onCreateCaughtException(Throwable th) {
        AdTemplate adTemplate;
        super.onCreateCaughtException(th);
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        if (cVar != null) {
            adTemplate = cVar.getAdTemplate();
        } else {
            adTemplate = null;
        }
        com.kwad.components.ad.reward.monitor.b.b(true, adTemplate);
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.components.core.proxy.a.c
    public void onCreateStageChange(PageCreateStage pageCreateStage) {
        super.onCreateStageChange(pageCreateStage);
        com.kwad.sdk.core.d.c.d(TAG, "onCreateStageChange: " + pageCreateStage.getStage());
        reportSubPageCreate(pageCreateStage.getStage());
    }

    @Override // com.kwad.components.core.m.b, com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        try {
            b.gk().b(this.mRewardVerifyListener);
            super.onDestroy();
            this.mAdOpenInteractionListener.i(false);
            if (this.mCallerContext != 0) {
                i.hs().H(String.valueOf(((g) this.mCallerContext).mAdTemplate));
                com.kwad.components.ad.reward.e.f.Q(getUniqueId());
            }
            com.kwad.components.ad.reward.model.c cVar = this.mModel;
            if (cVar != null) {
                String K = com.kwad.sdk.core.response.b.a.K(cVar.cU());
                if (!TextUtils.isEmpty(K)) {
                    com.kwad.sdk.core.videocache.c.a.bR(StubApp.getOrigApplicationContext(this.mContext.getApplicationContext())).eM(K);
                }
                com.kwad.components.core.g.a.a(com.kwad.sdk.commercial.d.be(this.mModel.getAdTemplate()));
            }
            com.kwad.components.core.t.c.sZ().b(this);
            this.listenerKey = null;
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.core.t.c.b
    public void onPageClose() {
        finish();
    }

    @Override // com.kwad.components.core.m.b, com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        super.onPause();
        T t5 = this.mCallerContext;
        if (t5 != 0) {
            ((g) t5).mPageEnterTime = -1L;
        }
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPreCreate(@Nullable Bundle bundle) {
        super.onPreCreate(bundle);
        try {
            getIntent().removeExtra("key_template");
        } catch (Throwable unused) {
        }
        reportSubPageCreate(PageCreateStage.END_CHILD_ON_PRE_CREATE.getStage());
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPreDestroy() {
        super.onPreDestroy();
        com.kwad.components.core.webview.tachikoma.e.c.vO().vP();
    }

    @Override // com.kwad.components.core.m.b, com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        try {
            super.onResume();
            com.kwad.components.ad.reward.model.c cVar = this.mModel;
            if (cVar != null) {
                AdTemplate adTemplate = cVar.getAdTemplate();
                com.kwad.sdk.core.local.a.Hq();
                com.kwad.sdk.core.local.a.ch(adTemplate);
            }
            if (!this.mReportedPageResume) {
                com.kwad.components.ad.reward.monitor.c.f(true, this.mModel.getAdTemplate());
                this.mReportedPageResume = true;
            }
            com.kwad.components.ad.reward.c.a.hV().R(this.mContext);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
