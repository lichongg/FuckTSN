package com.bytedance.sdk.openadsdk.mediation.ad;

import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class MediationNativeAdAppInfo {
    private String ae;
    private long cw;

    /* renamed from: g, reason: collision with root package name */
    private Map<String, Object> f31643g;

    /* renamed from: j, reason: collision with root package name */
    private String f31644j;

    /* renamed from: m, reason: collision with root package name */
    private String f31645m;
    private String oq;

    /* renamed from: r, reason: collision with root package name */
    private String f31646r;
    private String tl;
    private Map<String, String> up;
    private String xt;

    public Map<String, Object> getAppInfoExtra() {
        return this.f31643g;
    }

    public String getAppName() {
        return this.f31644j;
    }

    public String getAuthorName() {
        return this.xt;
    }

    public String getFunctionDescUrl() {
        return this.tl;
    }

    public long getPackageSizeBytes() {
        return this.cw;
    }

    public Map<String, String> getPermissionsMap() {
        return this.up;
    }

    public String getPermissionsUrl() {
        return this.f31646r;
    }

    public String getPrivacyAgreement() {
        return this.f31645m;
    }

    public String getRegUrl() {
        return this.oq;
    }

    public String getVersionName() {
        return this.ae;
    }

    public void setAppInfoExtra(Map<String, Object> map) {
        this.f31643g = map;
    }

    public void setAppName(String str) {
        this.f31644j = str;
    }

    public void setAuthorName(String str) {
        this.xt = str;
    }

    public void setFunctionDescUrl(String str) {
        this.tl = str;
    }

    public void setPackageSizeBytes(long j6) {
        this.cw = j6;
    }

    public void setPermissionsMap(Map<String, String> map) {
        this.up = map;
    }

    public void setPermissionsUrl(String str) {
        this.f31646r = str;
    }

    public void setPrivacyAgreement(String str) {
        this.f31645m = str;
    }

    public void setRegUrl(String str) {
        this.oq = str;
    }

    public void setVersionName(String str) {
        this.ae = str;
    }
}
