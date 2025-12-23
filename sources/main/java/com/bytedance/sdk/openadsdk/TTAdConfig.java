package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.openadsdk.CSJConfig;
import com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class TTAdConfig extends CSJConfig {

    /* renamed from: com.bytedance.sdk.openadsdk.TTAdConfig$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {

        /* renamed from: j, reason: collision with root package name */
        private CSJConfig.j f27509j = new CSJConfig.j();

        public Builder addExtra(String str, Object obj) {
            this.f27509j.j(str, obj);
            return this;
        }

        public Builder allowShowNotify(boolean z5) {
            this.f27509j.xt(z5);
            return this;
        }

        public Builder appId(String str) {
            this.f27509j.j(str);
            return this;
        }

        public Builder appName(String str) {
            this.f27509j.xt(str);
            return this;
        }

        public TTAdConfig build() {
            return new TTAdConfig(this.f27509j, null);
        }

        public Builder customController(TTCustomController tTCustomController) {
            this.f27509j.j(tTCustomController);
            return this;
        }

        public Builder data(String str) {
            this.f27509j.r(str);
            return this;
        }

        public Builder debug(boolean z5) {
            this.f27509j.cw(z5);
            return this;
        }

        public Builder directDownloadNetworkType(int... iArr) {
            this.f27509j.j(iArr);
            return this;
        }

        public Builder keywords(String str) {
            this.f27509j.cw(str);
            return this;
        }

        public Builder paid(boolean z5) {
            this.f27509j.j(z5);
            return this;
        }

        public Builder setAgeGroup(int i6) {
            this.f27509j.r(i6);
            return this;
        }

        public Builder setMediationConfig(IMediationConfig iMediationConfig) {
            this.f27509j.j(iMediationConfig);
            return this;
        }

        public Builder setPluginUpdateConfig(int i6) {
            this.f27509j.cw(i6);
            return this;
        }

        public Builder supportMultiProcess(boolean z5) {
            this.f27509j.r(z5);
            return this;
        }

        public Builder themeStatus(int i6) {
            this.f27509j.xt(i6);
            return this;
        }

        public Builder titleBarTheme(int i6) {
            this.f27509j.j(i6);
            return this;
        }

        public Builder useMediation(boolean z5) {
            this.f27509j.up(z5);
            return this;
        }
    }

    /* synthetic */ TTAdConfig(CSJConfig.j jVar, AnonymousClass1 anonymousClass1) {
        this(jVar);
    }

    private TTAdConfig(CSJConfig.j jVar) {
        super(jVar);
    }
}
