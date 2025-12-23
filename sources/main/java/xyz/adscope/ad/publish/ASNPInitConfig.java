package xyz.adscope.ad.publish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import xyz.adscope.ad.publish.ASNPConstants;
import xyz.adscope.ad.publish.loc.ASNPLocation;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class ASNPInitConfig {
    public static final String AD_SCOPE_ADN = "AdScopeADN";

    /* renamed from: a, reason: collision with root package name */
    private final String f55812a;

    /* renamed from: b, reason: collision with root package name */
    private final String f55813b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f55814c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f55815d;

    /* renamed from: e, reason: collision with root package name */
    private final String f55816e;

    /* renamed from: f, reason: collision with root package name */
    private final List<String> f55817f;

    /* renamed from: g, reason: collision with root package name */
    private final int f55818g;

    /* renamed from: h, reason: collision with root package name */
    private final ASNPConstants.UiModel f55819h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f55820i;

    /* renamed from: j, reason: collision with root package name */
    private final IASNPCustomController f55821j;

    /* renamed from: k, reason: collision with root package name */
    private final Map<String, Object> f55822k;

    /* renamed from: l, reason: collision with root package name */
    private final Map<String, String> f55823l;

    /* renamed from: m, reason: collision with root package name */
    private final String f55824m;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.ad.publish.ASNPInitConfig$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface ASNPExtraConfig {
        public static final String KEY_CUSTOM_USER_AGENT = "customUserAgent";
        public static final String KEY_HANDLE_EXCEPTION = "isCanHandleUncaughtException";
        public static final String KEY_INIT_NETWORK_OFF = "initOffLine";
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private final String f55825a;

        /* renamed from: b, reason: collision with root package name */
        private String f55826b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f55827c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f55828d;

        /* renamed from: e, reason: collision with root package name */
        private String f55829e;

        /* renamed from: f, reason: collision with root package name */
        private final List<String> f55830f;

        /* renamed from: h, reason: collision with root package name */
        private boolean f55832h;

        /* renamed from: j, reason: collision with root package name */
        private IASNPCustomController f55834j;

        /* renamed from: k, reason: collision with root package name */
        private Map<String, Object> f55835k;

        /* renamed from: l, reason: collision with root package name */
        private String f55836l;

        /* renamed from: m, reason: collision with root package name */
        private Map<String, String> f55837m;

        /* renamed from: g, reason: collision with root package name */
        private int f55831g = 1;

        /* renamed from: i, reason: collision with root package name */
        private ASNPConstants.UiModel f55833i = ASNPConstants.UiModel.UI_MODEL_LIGHT;

        public Builder addCurrency(String... strArr) {
            if (strArr != null) {
                this.f55830f.addAll(Arrays.asList(strArr));
            }
            return this;
        }

        public ASNPInitConfig build() {
            return new ASNPInitConfig(this, null);
        }

        public Builder setAdCustomController(IASNPCustomController iASNPCustomController) {
            this.f55834j = iASNPCustomController;
            return this;
        }

        public Builder setAppName(String str) {
            this.f55826b = str;
            return this;
        }

        public Builder setCountryCN(int i6) {
            this.f55831g = i6;
            return this;
        }

        public Builder setCustomExtra(String str) {
            this.f55836l = str;
            return this;
        }

        public Builder setDebugSetting(boolean z5) {
            this.f55827c = z5;
            return this;
        }

        public Builder setExtraConfig(Map<String, Object> map) {
            this.f55835k = map;
            return this;
        }

        public Builder setIsTestAd(boolean z5) {
            this.f55832h = z5;
            return this;
        }

        public Builder setOptionFields(Map<String, String> map) {
            this.f55837m = map;
            return this;
        }

        public Builder setUiModel(ASNPConstants.UiModel uiModel) {
            this.f55833i = uiModel;
            return this;
        }

        public Builder setUseHttps(boolean z5) {
            this.f55828d = z5;
            return this;
        }

        public Builder setUserId(String str) {
            this.f55829e = str;
            return this;
        }

        public Builder(String str) {
            this.f55825a = str;
            ArrayList arrayList = new ArrayList();
            this.f55830f = arrayList;
            arrayList.add("CNY");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface OptionFieldKey {
        public static final String KEY_COLOR_DARK = "darkColor";
        public static final String KEY_COLOR_LIGHT = "lightColor";
    }

    /* synthetic */ ASNPInitConfig(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private ASNPInitConfig(Builder builder) {
        this.f55812a = builder.f55825a;
        this.f55813b = builder.f55826b;
        this.f55814c = builder.f55827c;
        this.f55815d = builder.f55828d;
        this.f55816e = builder.f55829e;
        this.f55817f = builder.f55830f;
        this.f55818g = builder.f55831g;
        this.f55820i = builder.f55832h;
        this.f55821j = builder.f55834j;
        this.f55819h = builder.f55833i;
        this.f55822k = builder.f55835k;
        this.f55824m = builder.f55836l;
        this.f55823l = builder.f55837m;
    }

    private boolean a() {
        IASNPCustomController iASNPCustomController = this.f55821j;
        return iASNPCustomController == null || iASNPCustomController.isCanGatherOAID();
    }

    private boolean b() {
        IASNPCustomController iASNPCustomController = this.f55821j;
        return iASNPCustomController == null || iASNPCustomController.isSupportPersonalized();
    }

    public boolean canUpdateLocation() {
        IASNPCustomController iASNPCustomController = this.f55821j;
        return iASNPCustomController == null || iASNPCustomController.isCanUpdateLocation();
    }

    public String getAppId() {
        return this.f55812a;
    }

    public String getAppName() {
        return this.f55813b;
    }

    public int getCCPAAuthorise() {
        IASNPCustomController iASNPCustomController = this.f55821j;
        return (iASNPCustomController == null || iASNPCustomController.getUnderageTag().getCode() != 1) ? 0 : 1;
    }

    public int getCOPPAAuthorise() {
        IASNPCustomController iASNPCustomController = this.f55821j;
        return (iASNPCustomController == null || iASNPCustomController.getUnderageTag().getCode() != 1) ? 0 : 1;
    }

    public int getCountryCN() {
        return this.f55818g;
    }

    public List<String> getCurrency() {
        return this.f55817f;
    }

    public String getCustomGAID() {
        IASNPCustomController iASNPCustomController = this.f55821j;
        return iASNPCustomController != null ? iASNPCustomController.getGAID() : "";
    }

    public ASNPLocation getCustomLocation() {
        IASNPCustomController iASNPCustomController = this.f55821j;
        if (iASNPCustomController != null) {
            return iASNPCustomController.getASNPLocation();
        }
        return null;
    }

    public String getCustomOAID() {
        IASNPCustomController iASNPCustomController = this.f55821j;
        return iASNPCustomController != null ? iASNPCustomController.getOAID() : "";
    }

    public String getDarkColor() {
        Map<String, String> map = this.f55823l;
        return map != null ? map.get(OptionFieldKey.KEY_COLOR_DARK) : "";
    }

    public Map<String, Object> getExtConfig() {
        return this.f55822k;
    }

    public int getGDPRAuthorise() {
        IASNPCustomController iASNPCustomController = this.f55821j;
        return (iASNPCustomController == null || iASNPCustomController.getUnderageTag().getCode() != 1) ? 0 : 1;
    }

    public boolean getIsTestAd() {
        return this.f55820i;
    }

    public String getLightColor() {
        Map<String, String> map = this.f55823l;
        return map != null ? map.get(OptionFieldKey.KEY_COLOR_LIGHT) : "";
    }

    public Map<String, String> getOptionFields() {
        return this.f55823l;
    }

    public String getOptionInfoJson() {
        return this.f55824m;
    }

    public ASNPConstants.UiModel getUiModel() {
        return this.f55819h;
    }

    public String getUserId() {
        return this.f55816e;
    }

    public boolean isDebugSetting() {
        return this.f55814c;
    }

    public boolean isSupportSensor() {
        IASNPCustomController iASNPCustomController = this.f55821j;
        return iASNPCustomController == null || iASNPCustomController.isCanUseSensor();
    }

    public boolean isUseHttps() {
        return this.f55815d;
    }

    public boolean canUseOAIDInfo() {
        if (a() && b()) {
            return true;
        }
        return false;
    }
}
