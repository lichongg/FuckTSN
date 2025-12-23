package com.baidu.mobads.sdk.internal;

import android.content.Context;
import com.baidu.mobads.sdk.api.IPromoteInstallAdInfo;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class ap implements IPromoteInstallAdInfo {

    /* renamed from: a, reason: collision with root package name */
    private final aq f10614a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f10615b;

    /* renamed from: c, reason: collision with root package name */
    private String f10616c;

    /* renamed from: d, reason: collision with root package name */
    private String f10617d;

    /* renamed from: e, reason: collision with root package name */
    private String f10618e;

    /* renamed from: f, reason: collision with root package name */
    private String f10619f;

    /* renamed from: g, reason: collision with root package name */
    private String f10620g;

    /* renamed from: h, reason: collision with root package name */
    private String f10621h;

    /* renamed from: i, reason: collision with root package name */
    private String f10622i;

    /* renamed from: j, reason: collision with root package name */
    private String f10623j;

    /* renamed from: k, reason: collision with root package name */
    private String f10624k;

    /* renamed from: l, reason: collision with root package name */
    private String f10625l;

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public String getAppPublisher() {
        return this.f10621h;
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public String getAppVersion() {
        return this.f10622i;
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public String getBrandName() {
        return this.f10618e;
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public String getECPMLevel() {
        return this.f10619f;
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public String getFunctionUrl() {
        return this.f10625l;
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public String getIconUrl() {
        return this.f10617d;
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public String getPECPM() {
        return this.f10620g;
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public String getPermissionUrl() {
        return this.f10624k;
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public String getPrivacyUrl() {
        return this.f10623j;
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public String getUnionLogoUrl() {
        return "https://union.baidu.com";
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public void handleAdInstall() {
        aq aqVar = this.f10614a;
        if (aqVar != null) {
            aqVar.a(this.f10615b, this.f10616c);
        }
    }

    public ap(JSONObject jSONObject, Context context, aq aqVar) {
        this.f10614a = aqVar;
        this.f10615b = context;
        try {
            this.f10616c = jSONObject.optString(com.umeng.analytics.pro.d.S);
            this.f10617d = jSONObject.optString("icon");
            this.f10618e = jSONObject.optString("appname");
            this.f10619f = jSONObject.optString("bidlayer");
            this.f10620g = jSONObject.optString("enc_bid_price");
            this.f10621h = jSONObject.optString("publisher");
            this.f10622i = jSONObject.optString("app_version");
            this.f10623j = jSONObject.optString("privacy_link");
            this.f10624k = jSONObject.optString("permission_link");
            this.f10625l = jSONObject.optString("function_link");
        } catch (Throwable unused) {
        }
    }
}
