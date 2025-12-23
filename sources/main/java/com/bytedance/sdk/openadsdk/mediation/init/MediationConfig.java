package com.bytedance.sdk.openadsdk.mediation.init;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class MediationConfig implements IMediationConfig {
    private boolean ae;
    private MediationConfigUserInfoForSegment cw;

    /* renamed from: g, reason: collision with root package name */
    private boolean f31707g;

    /* renamed from: j, reason: collision with root package name */
    private String f31708j;

    /* renamed from: m, reason: collision with root package name */
    private JSONObject f31709m;
    private boolean oq;
    private String qv;

    /* renamed from: r, reason: collision with root package name */
    private Map<String, Object> f31710r;
    private String tl;
    private boolean up;
    private boolean xt;

    /* renamed from: com.bytedance.sdk.openadsdk.mediation.init.MediationConfig$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private boolean ae;
        private MediationConfigUserInfoForSegment cw;

        /* renamed from: g, reason: collision with root package name */
        private boolean f31711g;

        /* renamed from: j, reason: collision with root package name */
        private String f31712j;

        /* renamed from: m, reason: collision with root package name */
        private JSONObject f31713m;
        private boolean oq;
        private String qv;

        /* renamed from: r, reason: collision with root package name */
        private Map<String, Object> f31714r;
        private String tl;
        private boolean up;
        private boolean xt;

        public MediationConfig build() {
            MediationConfig mediationConfig = new MediationConfig(null);
            mediationConfig.f31708j = this.f31712j;
            mediationConfig.xt = this.xt;
            mediationConfig.cw = this.cw;
            mediationConfig.f31710r = this.f31714r;
            mediationConfig.up = this.up;
            mediationConfig.f31709m = this.f31713m;
            mediationConfig.ae = this.ae;
            mediationConfig.tl = this.tl;
            mediationConfig.f31707g = this.f31711g;
            mediationConfig.oq = this.oq;
            mediationConfig.qv = this.qv;
            return mediationConfig;
        }

        public Builder setCustomLocalConfig(JSONObject jSONObject) {
            this.f31713m = jSONObject;
            return this;
        }

        public Builder setHttps(boolean z5) {
            this.up = z5;
            return this;
        }

        @Deprecated
        public Builder setLocalExtra(Map<String, Object> map) {
            this.f31714r = map;
            return this;
        }

        public Builder setMediationConfigUserInfoForSegment(MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment) {
            this.cw = mediationConfigUserInfoForSegment;
            return this;
        }

        public Builder setOpenAdnTest(boolean z5) {
            this.xt = z5;
            return this;
        }

        public Builder setOpensdkVer(String str) {
            this.tl = str;
            return this;
        }

        public Builder setPublisherDid(String str) {
            this.f31712j = str;
            return this;
        }

        public Builder setSupportH265(boolean z5) {
            this.f31711g = z5;
            return this;
        }

        public Builder setSupportSplashZoomout(boolean z5) {
            this.oq = z5;
            return this;
        }

        public Builder setWxAppId(String str) {
            this.qv = str;
            return this;
        }

        public Builder setWxInstalled(boolean z5) {
            this.ae = z5;
            return this;
        }
    }

    /* synthetic */ MediationConfig(AnonymousClass1 anonymousClass1) {
        this();
    }

    private MediationConfig() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public JSONObject getCustomLocalConfig() {
        return this.f31709m;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean getHttps() {
        return this.up;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public Map<String, Object> getLocalExtra() {
        return this.f31710r;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public MediationConfigUserInfoForSegment getMediationConfigUserInfoForSegment() {
        return this.cw;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public String getOpensdkVer() {
        return this.tl;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public String getPublisherDid() {
        return this.f31708j;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isOpenAdnTest() {
        return this.xt;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isSupportH265() {
        return this.f31707g;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isSupportSplashZoomout() {
        return this.oq;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isWxInstalled() {
        return this.ae;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public String wxAppId() {
        return this.qv;
    }
}
