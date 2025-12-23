package com.qq.e.ads.nativ;

import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class NativeUnifiedADAppInfoImpl implements NativeUnifiedADAppMiitInfo {

    /* renamed from: a, reason: collision with root package name */
    private final String f36665a;

    /* renamed from: b, reason: collision with root package name */
    private final String f36666b;

    /* renamed from: c, reason: collision with root package name */
    private final long f36667c;

    /* renamed from: d, reason: collision with root package name */
    private final String f36668d;

    /* renamed from: e, reason: collision with root package name */
    private final String f36669e;

    /* renamed from: f, reason: collision with root package name */
    private final String f36670f;

    /* renamed from: g, reason: collision with root package name */
    private final String f36671g;

    /* renamed from: h, reason: collision with root package name */
    private final String f36672h;

    /* renamed from: i, reason: collision with root package name */
    private final String f36673i;

    /* renamed from: j, reason: collision with root package name */
    private final String f36674j;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private interface Keys {
        public static final String APP_NAME = "app_name";
        public static final String AUTHOR_NAME = "author_name";
        public static final String DESCRIPTION_URL = "description_url";
        public static final String ICP_INFO_URL = "icp_info_url";
        public static final String ICP_NUMBER = "icp_number";
        public static final String PACKAGE_SIZE = "package_size";
        public static final String PERMISSION_URL = "permission_url";
        public static final String PRIVACY_AGREEMENT = "privacy_agreement";
        public static final String SUITABLE_AGE = "suitable_age";
        public static final String VERSION_NAME = "version_name";
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getAppName() {
        return this.f36665a;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getAuthorName() {
        return this.f36666b;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getDescriptionUrl() {
        return this.f36671g;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getIcpInfoUrl() {
        return this.f36674j;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getIcpNumber() {
        return this.f36672h;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public long getPackageSizeBytes() {
        return this.f36667c;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getPermissionsUrl() {
        return this.f36668d;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getPrivacyAgreement() {
        return this.f36669e;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getSuitableAge() {
        return this.f36673i;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getVersionName() {
        return this.f36670f;
    }

    public NativeUnifiedADAppInfoImpl(JSONObject jSONObject) {
        this.f36665a = jSONObject.optString("app_name");
        this.f36666b = jSONObject.optString(Keys.AUTHOR_NAME);
        this.f36667c = jSONObject.optLong(Keys.PACKAGE_SIZE);
        this.f36668d = jSONObject.optString(Keys.PERMISSION_URL);
        this.f36669e = jSONObject.optString(Keys.PRIVACY_AGREEMENT);
        this.f36670f = jSONObject.optString(Keys.VERSION_NAME);
        this.f36671g = jSONObject.optString(Keys.DESCRIPTION_URL);
        this.f36672h = jSONObject.optString(Keys.ICP_NUMBER);
        this.f36673i = jSONObject.optString(Keys.SUITABLE_AGE);
        this.f36674j = jSONObject.optString(Keys.ICP_INFO_URL);
    }
}
