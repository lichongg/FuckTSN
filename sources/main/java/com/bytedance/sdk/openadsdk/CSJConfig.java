package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class CSJConfig implements AdConfig {
    private boolean ae;
    private boolean av;
    private int az;
    private boolean cw;

    /* renamed from: g, reason: collision with root package name */
    private int[] f27499g;

    /* renamed from: i, reason: collision with root package name */
    private IMediationConfig f27500i;

    /* renamed from: j, reason: collision with root package name */
    private String f27501j;
    private int jy;

    /* renamed from: m, reason: collision with root package name */
    private int f27502m;
    private boolean oq;
    private Map<String, Object> qv;

    /* renamed from: r, reason: collision with root package name */
    private String f27503r;
    private boolean tl;
    private String up;
    private TTCustomController vl;
    private int ws;
    private String xt;

    static class j {
        private IMediationConfig av;
        private boolean az;

        /* renamed from: g, reason: collision with root package name */
        private int[] f27504g;

        /* renamed from: j, reason: collision with root package name */
        private String f27506j;
        private TTCustomController qv;

        /* renamed from: r, reason: collision with root package name */
        private String f27508r;
        private String up;
        private int vl;
        private String xt;
        private boolean cw = false;

        /* renamed from: m, reason: collision with root package name */
        private int f27507m = 0;
        private boolean ae = true;
        private boolean tl = false;
        private boolean oq = false;
        private int jy = 2;
        private int ws = 0;

        /* renamed from: i, reason: collision with root package name */
        private Map<String, Object> f27505i = null;

        public j cw(String str) {
            this.f27508r = str;
            return this;
        }

        public j j(String str) {
            this.f27506j = str;
            return this;
        }

        public j r(String str) {
            this.up = str;
            return this;
        }

        public j up(boolean z5) {
            this.az = z5;
            return this;
        }

        public j xt(String str) {
            this.xt = str;
            return this;
        }

        j() {
        }

        public j cw(boolean z5) {
            this.tl = z5;
            return this;
        }

        public j j(boolean z5) {
            this.cw = z5;
            return this;
        }

        public j r(boolean z5) {
            this.oq = z5;
            return this;
        }

        public j xt(boolean z5) {
            this.ae = z5;
            return this;
        }

        public j cw(int i6) {
            this.jy = i6;
            return this;
        }

        public j j(int i6) {
            this.f27507m = i6;
            return this;
        }

        public j r(int i6) {
            this.ws = i6;
            return this;
        }

        public j xt(int i6) {
            this.vl = i6;
            return this;
        }

        public j j(int... iArr) {
            this.f27504g = iArr;
            return this;
        }

        public j j(TTCustomController tTCustomController) {
            this.qv = tTCustomController;
            return this;
        }

        public j j(IMediationConfig iMediationConfig) {
            this.av = iMediationConfig;
            return this;
        }

        public j j(String str, Object obj) {
            if (this.f27505i == null) {
                this.f27505i = new HashMap();
            }
            this.f27505i.put(str, obj);
            return this;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getAgeGroup() {
        return this.az;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getAppId() {
        return this.f27501j;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getAppName() {
        return this.xt;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public TTCustomController getCustomController() {
        return this.vl;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getData() {
        return this.up;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int[] getDirectDownloadNetworkType() {
        return this.f27499g;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public Object getExtra(String str) {
        Map<String, Object> map = this.qv;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public Map<String, Object> getInitExtra() {
        return this.qv;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getKeywords() {
        return this.f27503r;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public IMediationConfig getMediationConfig() {
        return this.f27500i;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getPluginUpdateConfig() {
        return this.ws;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getThemeStatus() {
        return this.jy;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getTitleBarTheme() {
        return this.f27502m;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isAllowShowNotify() {
        return this.ae;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isDebug() {
        return this.tl;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isPaid() {
        return this.cw;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isSupportMultiProcess() {
        return this.oq;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isUseMediation() {
        return this.av;
    }

    public void setAgeGroup(int i6) {
        this.az = i6;
    }

    public void setAllowShowNotify(boolean z5) {
        this.ae = z5;
    }

    public void setAppId(String str) {
        this.f27501j = str;
    }

    public void setAppName(String str) {
        this.xt = str;
    }

    public void setCustomController(TTCustomController tTCustomController) {
        this.vl = tTCustomController;
    }

    public void setData(String str) {
        this.up = str;
    }

    public void setDebug(boolean z5) {
        this.tl = z5;
    }

    public void setDirectDownloadNetworkType(int... iArr) {
        this.f27499g = iArr;
    }

    public void setKeywords(String str) {
        this.f27503r = str;
    }

    public void setPaid(boolean z5) {
        this.cw = z5;
    }

    public void setSupportMultiProcess(boolean z5) {
        this.oq = z5;
    }

    public void setThemeStatus(int i6) {
        this.jy = i6;
    }

    public void setTitleBarTheme(int i6) {
        this.f27502m = i6;
    }

    CSJConfig(j jVar) {
        this.cw = false;
        this.f27502m = 0;
        this.ae = true;
        this.tl = false;
        this.oq = false;
        this.f27501j = jVar.f27506j;
        this.xt = jVar.xt;
        this.cw = jVar.cw;
        this.f27503r = jVar.f27508r;
        this.up = jVar.up;
        this.f27502m = jVar.f27507m;
        this.ae = jVar.ae;
        this.tl = jVar.tl;
        this.f27499g = jVar.f27504g;
        this.oq = jVar.oq;
        this.vl = jVar.qv;
        this.jy = jVar.vl;
        this.az = jVar.ws;
        this.ws = jVar.jy;
        this.av = jVar.az;
        this.f27500i = jVar.av;
        this.qv = jVar.f27505i;
    }
}
