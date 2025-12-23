package com.bytedance.sdk.openadsdk.mediation.ad;

import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class MediationAdSlot implements IMediationAdSlot {
    private boolean ae;
    private MediationSplashRequestInfo av;
    private String az;
    private String cw;

    /* renamed from: g, reason: collision with root package name */
    private boolean f31635g;

    /* renamed from: j, reason: collision with root package name */
    private boolean f31636j;
    private float jy;

    /* renamed from: m, reason: collision with root package name */
    private boolean f31637m;
    private String oq;
    private boolean qv;

    /* renamed from: r, reason: collision with root package name */
    private int f31638r;
    private Map<String, Object> tl;
    private float up;
    private MediationNativeToBannerListener vl;
    private float ws;
    private boolean xt;

    /* renamed from: com.bytedance.sdk.openadsdk.mediation.ad.MediationAdSlot$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private boolean ae;
        private MediationSplashRequestInfo av;
        private String az;
        private boolean cw;

        /* renamed from: j, reason: collision with root package name */
        private boolean f31640j;
        private int oq;
        private boolean qv;

        /* renamed from: r, reason: collision with root package name */
        private float f31642r;
        private String tl;
        private boolean up;
        private MediationNativeToBannerListener vl;
        private boolean xt;

        /* renamed from: m, reason: collision with root package name */
        private Map<String, Object> f31641m = new HashMap();

        /* renamed from: g, reason: collision with root package name */
        private String f31639g = "";
        private float jy = 80.0f;
        private float ws = 80.0f;

        public MediationAdSlot build() {
            MediationAdSlot mediationAdSlot = new MediationAdSlot(null);
            mediationAdSlot.f31636j = this.f31640j;
            mediationAdSlot.xt = this.xt;
            mediationAdSlot.ae = this.cw;
            mediationAdSlot.up = this.f31642r;
            mediationAdSlot.f31637m = this.up;
            mediationAdSlot.tl = this.f31641m;
            mediationAdSlot.f31635g = this.ae;
            mediationAdSlot.oq = this.tl;
            mediationAdSlot.cw = this.f31639g;
            mediationAdSlot.f31638r = this.oq;
            mediationAdSlot.qv = this.qv;
            mediationAdSlot.vl = this.vl;
            mediationAdSlot.jy = this.jy;
            mediationAdSlot.ws = this.ws;
            mediationAdSlot.az = this.az;
            mediationAdSlot.av = this.av;
            return mediationAdSlot;
        }

        public Builder setAllowShowCloseBtn(boolean z5) {
            this.qv = z5;
            return this;
        }

        public Builder setBidNotify(boolean z5) {
            this.ae = z5;
            return this;
        }

        public Builder setExtraObject(String str, Object obj) {
            Map<String, Object> map = this.f31641m;
            if (map != null) {
                map.put(str, obj);
            }
            return this;
        }

        public Builder setMediationNativeToBannerListener(MediationNativeToBannerListener mediationNativeToBannerListener) {
            this.vl = mediationNativeToBannerListener;
            return this;
        }

        public Builder setMediationSplashRequestInfo(MediationSplashRequestInfo mediationSplashRequestInfo) {
            this.av = mediationSplashRequestInfo;
            return this;
        }

        public Builder setMuted(boolean z5) {
            this.cw = z5;
            return this;
        }

        @Deprecated
        public Builder setRewardAmount(int i6) {
            this.oq = i6;
            return this;
        }

        @Deprecated
        public Builder setRewardName(String str) {
            this.f31639g = str;
            return this;
        }

        public Builder setScenarioId(String str) {
            this.tl = str;
            return this;
        }

        public Builder setShakeViewSize(float f6, float f7) {
            this.jy = f6;
            this.ws = f7;
            return this;
        }

        public Builder setSplashPreLoad(boolean z5) {
            this.xt = z5;
            return this;
        }

        public Builder setSplashShakeButton(boolean z5) {
            this.f31640j = z5;
            return this;
        }

        public Builder setUseSurfaceView(boolean z5) {
            this.up = z5;
            return this;
        }

        public Builder setVolume(float f6) {
            this.f31642r = f6;
            return this;
        }

        public Builder setWxAppId(String str) {
            this.az = str;
            return this;
        }
    }

    /* synthetic */ MediationAdSlot(AnonymousClass1 anonymousClass1) {
        this();
    }

    private MediationAdSlot() {
        this.cw = "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public Map<String, Object> getExtraObject() {
        return this.tl;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public MediationNativeToBannerListener getMediationNativeToBannerListener() {
        return this.vl;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public MediationSplashRequestInfo getMediationSplashRequestInfo() {
        return this.av;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public int getRewardAmount() {
        return this.f31638r;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public String getRewardName() {
        return this.cw;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public String getScenarioId() {
        return this.oq;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public float getShakeViewHeight() {
        return this.ws;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public float getShakeViewWidth() {
        return this.jy;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public float getVolume() {
        return this.up;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public String getWxAppId() {
        return this.az;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isAllowShowCloseBtn() {
        return this.qv;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isBidNotify() {
        return this.f31635g;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isMuted() {
        return this.ae;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isSplashPreLoad() {
        return this.xt;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isSplashShakeButton() {
        return this.f31636j;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isUseSurfaceView() {
        return this.f31637m;
    }
}
