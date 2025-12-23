package xyz.adscope.common.analyse2.base.model.init;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.bn;
import com.shockwave.pdfium.BuildConfig;
import com.tencent.connect.common.Constants;
import com.umeng.analytics.pro.au;
import com.umeng.analytics.pro.bi;
import com.umeng.socialize.common.SocializeConstants;
import org.json.JSONObject;
import xyz.adscope.common.analyse2.base.model.AnalyseBasicReceiveLog;
import xyz.adscope.common.v2.dev.DeviceObtainManager;
import xyz.adscope.common.v2.dev.IDeviceInterface;
import xyz.adscope.common.v2.dev.info.PackageUtil;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;
import xyz.adscope.common.v2.tool.json.JsonUtil;
import xyz.adscope.common.v2.tool.str.SerialUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AnalyseInitConfigModel extends AnalyseBasicReceiveLog {

    /* renamed from: a, reason: collision with root package name */
    private c f56244a;

    @JsonParseNode(key = "access_key")
    private final String accessKey;

    /* renamed from: b, reason: collision with root package name */
    private f f56245b;

    /* renamed from: c, reason: collision with root package name */
    private b f56246c;

    @JsonParseNode(key = "config_version_md5")
    private String configVersionMd5;

    /* renamed from: d, reason: collision with root package name */
    private e f56247d;

    /* renamed from: e, reason: collision with root package name */
    private d f56248e;

    @JsonParseNode(key = "lastUpdateTime")
    private String lastUpdateTime;

    @JsonParseNode(key = "log_version")
    private final String logVersion;

    @JsonParseNode(key = "app_id")
    private String mAppID;

    @JsonParseNode(key = "custom_id")
    private String mBizID;

    @JsonParseNode(key = "hex_id")
    private String mHex;

    @JsonParseNode(key = "start_id")
    private String mStartID;

    @JsonParseNode(key = "sdk")
    private AnalyseSDKModel sdkModel;

    @JsonParseNode(key = "logStrategy")
    private AnalyseLogStrategyModel strategyModel;

    @JsonParseNode(key = au.f40908m)
    private AnalyseUserModel userModel;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class b extends xyz.adscope.common.a {

        /* renamed from: a, reason: collision with root package name */
        @JsonParseNode(key = "app_version")
        private String f56249a;

        /* renamed from: b, reason: collision with root package name */
        @JsonParseNode(key = "app_name")
        private String f56250b;

        /* renamed from: c, reason: collision with root package name */
        @JsonParseNode(key = "bundle_id")
        private String f56251c;

        /* renamed from: d, reason: collision with root package name */
        @JsonParseNode(key = "install_time")
        private String f56252d;

        /* renamed from: e, reason: collision with root package name */
        @JsonParseNode(key = "update_time")
        private String f56253e;

        /* synthetic */ b(Context context, a aVar) {
            this(context);
        }

        private b(Context context) {
            this.f56250b = PackageUtil.getAppName(context);
            this.f56249a = PackageUtil.getAppVersionName(context);
            this.f56251c = context.getPackageName();
            this.f56252d = PackageUtil.getAppInstallDate(context) + "";
            this.f56253e = PackageUtil.getAppLastUpdateTime(context) + "";
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class c extends xyz.adscope.common.a {

        /* renamed from: a, reason: collision with root package name */
        @JsonParseNode(key = "version")
        private String f56254a;

        /* renamed from: b, reason: collision with root package name */
        @JsonParseNode(key = "custom_data")
        private String f56255b;

        /* synthetic */ c(String str, String str2, a aVar) {
            this(str, str2);
        }

        private c(String str, String str2) {
            this.f56254a = str;
            this.f56255b = str2;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class d extends xyz.adscope.common.a {

        /* renamed from: a, reason: collision with root package name */
        @JsonParseNode(key = bi.J)
        private String f56256a;

        /* renamed from: b, reason: collision with root package name */
        @JsonParseNode(key = bi.ai)
        private String f56257b;

        /* renamed from: c, reason: collision with root package name */
        @JsonParseNode(key = "said")
        private String f56258c;

        /* renamed from: d, reason: collision with root package name */
        @JsonParseNode(key = "os")
        private String f56259d;

        /* renamed from: e, reason: collision with root package name */
        @JsonParseNode(key = "country")
        private String f56260e;

        /* renamed from: f, reason: collision with root package name */
        @JsonParseNode(key = "zone")
        private String f56261f;

        /* renamed from: g, reason: collision with root package name */
        @JsonParseNode(key = "lang")
        private String f56262g;

        /* renamed from: h, reason: collision with root package name */
        @JsonParseNode(key = "connection_type")
        private String f56263h;

        /* renamed from: i, reason: collision with root package name */
        @JsonParseNode(key = bi.P)
        private String f56264i;

        /* renamed from: j, reason: collision with root package name */
        @JsonParseNode(key = "osv")
        private String f56265j;

        /* renamed from: k, reason: collision with root package name */
        @JsonParseNode(key = "oaid")
        private String f56266k;

        /* renamed from: l, reason: collision with root package name */
        @JsonParseNode(key = bn.f10753i)
        private String f56267l;

        /* renamed from: m, reason: collision with root package name */
        @JsonParseNode(key = IAdInterListener.AdReqParam.WIDTH)
        private String f56268m;

        /* renamed from: n, reason: collision with root package name */
        @JsonParseNode(key = "h")
        private String f56269n;

        /* renamed from: o, reason: collision with root package name */
        @JsonParseNode(key = "make")
        private String f56270o;

        /* renamed from: p, reason: collision with root package name */
        @JsonParseNode(key = bn.f10754j)
        private String f56271p;

        /* renamed from: q, reason: collision with root package name */
        @JsonParseNode(key = "update_mark")
        private String f56272q;

        /* renamed from: r, reason: collision with root package name */
        @JsonParseNode(key = "file_mark")
        private String f56273r;

        /* renamed from: s, reason: collision with root package name */
        @JsonParseNode(key = "hard_disk_size")
        private String f56274s;

        /* renamed from: t, reason: collision with root package name */
        @JsonParseNode(key = "user_agent")
        private String f56275t;

        /* renamed from: u, reason: collision with root package name */
        @JsonParseNode(key = "physical_memory")
        private String f56276u;

        /* synthetic */ d(IDeviceInterface iDeviceInterface, String str, String str2, a aVar) {
            this(iDeviceInterface, str, str2);
        }

        private d(IDeviceInterface iDeviceInterface, String str, String str2) {
            this.f56256a = iDeviceInterface.getDeviceName();
            this.f56257b = iDeviceInterface.getDeviceType() + "";
            this.f56258c = str2;
            this.f56259d = iDeviceInterface.getOs() + "";
            this.f56260e = iDeviceInterface.getCountryCode();
            this.f56261f = iDeviceInterface.getTimeZone();
            this.f56262g = iDeviceInterface.getLanguage();
            this.f56263h = iDeviceInterface.getConnectType() + "";
            this.f56264i = iDeviceInterface.getCarrier();
            this.f56265j = iDeviceInterface.getAndroidRelease();
            this.f56266k = str;
            this.f56267l = iDeviceInterface.getModel();
            this.f56268m = iDeviceInterface.getScreenWidthPX() + "";
            this.f56269n = iDeviceInterface.getScreenHeightPX() + "";
            this.f56270o = iDeviceInterface.getManufacturer();
            this.f56271p = iDeviceInterface.getBrand();
            this.f56272q = iDeviceInterface.getDeviceUpdateMark();
            this.f56273r = iDeviceInterface.getFileMark();
            this.f56274s = iDeviceInterface.getHardDisk();
            this.f56275t = iDeviceInterface.getUserAgent();
            this.f56276u = iDeviceInterface.getPhysicalMemory();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class e extends xyz.adscope.common.a {

        /* renamed from: a, reason: collision with root package name */
        @JsonParseNode(key = "version")
        private String f56277a;

        /* synthetic */ e(String str, a aVar) {
            this(str);
        }

        private e(String str) {
            this.f56277a = str;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class f extends xyz.adscope.common.a {

        /* renamed from: a, reason: collision with root package name */
        @JsonParseNode(key = SocializeConstants.TENCENT_UID)
        private String f56278a;

        /* renamed from: b, reason: collision with root package name */
        @JsonParseNode(key = "user_custom_data")
        private String f56279b;

        /* renamed from: c, reason: collision with root package name */
        @JsonParseNode(key = "lmt")
        private String f56280c;

        /* synthetic */ f(String str, String str2, String str3, a aVar) {
            this(str, str2, str3);
        }

        private f(String str, String str2, String str3) {
            this.f56278a = str;
            this.f56279b = str2;
            this.f56280c = str3;
        }
    }

    public JSONObject a(Context context) {
        JSONObject a6;
        synchronized (this) {
            try {
                if (TextUtils.isEmpty(this.mHex)) {
                    this.mHex = SerialUtil.generateCRCHex(this.mStartID) + "";
                }
                a aVar = null;
                if (this.f56244a == null) {
                    AnalyseLogStrategyModel analyseLogStrategyModel = this.strategyModel;
                    String f6 = analyseLogStrategyModel != null ? analyseLogStrategyModel.f() : "";
                    AnalyseLogStrategyModel analyseLogStrategyModel2 = this.strategyModel;
                    this.f56244a = new c(f6, analyseLogStrategyModel2 != null ? analyseLogStrategyModel2.d() : "", aVar);
                }
                if (this.f56245b == null) {
                    AnalyseUserModel analyseUserModel = this.userModel;
                    String e6 = analyseUserModel != null ? analyseUserModel.e() : "";
                    AnalyseUserModel analyseUserModel2 = this.userModel;
                    String d6 = analyseUserModel2 != null ? analyseUserModel2.d() : "";
                    AnalyseUserModel analyseUserModel3 = this.userModel;
                    this.f56245b = new f(e6, d6, analyseUserModel3 != null ? analyseUserModel3.f() : "", aVar);
                }
                if (this.f56246c == null) {
                    this.f56246c = new b(context, aVar);
                }
                if (this.f56247d == null) {
                    AnalyseSDKModel analyseSDKModel = this.sdkModel;
                    this.f56247d = new e(analyseSDKModel != null ? analyseSDKModel.b() : "", aVar);
                }
                if (this.f56248e == null) {
                    IDeviceInterface orCreateImplement = DeviceObtainManager.getInstance().getOrCreateImplement(context);
                    AnalyseUserModel analyseUserModel4 = this.userModel;
                    String b6 = analyseUserModel4 != null ? analyseUserModel4.b() : "";
                    AnalyseUserModel analyseUserModel5 = this.userModel;
                    this.f56248e = new d(orCreateImplement, b6, analyseUserModel5 != null ? analyseUserModel5.c() : "", aVar);
                }
                a6 = super.a();
                JsonUtil.putObject(a6, ConstantHelper.LOG_DE, this.f56248e.getAnalyseJsonObject());
                JsonUtil.putObject(a6, Constants.JumpUrlConstants.SRC_TYPE_APP, this.f56246c.getAnalyseJsonObject());
                JsonUtil.putObject(a6, au.f40908m, this.f56245b.getAnalyseJsonObject());
                JsonUtil.putObject(a6, "sdk", this.f56247d.getAnalyseJsonObject());
                JsonUtil.putObject(a6, "configuration", this.f56244a.getAnalyseJsonObject());
            } catch (Throwable th) {
                throw th;
            }
        }
        return a6;
    }

    public String b() {
        return this.mStartID;
    }

    public AnalyseLogStrategyModel c() {
        return this.strategyModel;
    }

    public AnalyseInitConfigModel(JSONObject jSONObject) {
        super(jSONObject);
        this.logVersion = BuildConfig.f37486f;
        this.accessKey = "sdk";
    }
}
