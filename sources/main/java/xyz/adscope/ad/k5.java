package xyz.adscope.ad;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.bn;
import com.umeng.analytics.pro.au;
import com.umeng.analytics.pro.bi;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import xyz.adscope.common.v2.dev.IDeviceInterface;
import xyz.adscope.common.v2.model.annotation.JsonParseNode;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class k5 extends t {

    /* renamed from: a, reason: collision with root package name */
    @JsonParseNode(key = "type")
    private int f55319a;

    /* renamed from: b, reason: collision with root package name */
    @JsonParseNode(key = au.f40899d)
    private String f55320b;

    /* renamed from: c, reason: collision with root package name */
    @JsonParseNode(key = "lmt")
    private int f55321c;

    /* renamed from: d, reason: collision with root package name */
    @JsonParseNode(key = "make")
    private String f55322d;

    /* renamed from: e, reason: collision with root package name */
    @JsonParseNode(key = bn.f10754j)
    private String f55323e;

    /* renamed from: f, reason: collision with root package name */
    @JsonParseNode(key = bn.f10753i)
    private String f55324f;

    /* renamed from: g, reason: collision with root package name */
    @JsonParseNode(key = "os")
    private int f55325g;

    /* renamed from: h, reason: collision with root package name */
    @JsonParseNode(key = "osv")
    private String f55326h;

    /* renamed from: i, reason: collision with root package name */
    @JsonParseNode(key = "h")
    private int f55327i;

    /* renamed from: j, reason: collision with root package name */
    @JsonParseNode(key = IAdInterListener.AdReqParam.WIDTH)
    private int f55328j;

    /* renamed from: k, reason: collision with root package name */
    @JsonParseNode(key = "ppi")
    private String f55329k;

    /* renamed from: l, reason: collision with root package name */
    @JsonParseNode(key = "pxratio")
    private String f55330l;

    /* renamed from: m, reason: collision with root package name */
    @JsonParseNode(key = "lang")
    private String f55331m;

    /* renamed from: n, reason: collision with root package name */
    @JsonParseNode(key = bi.P)
    private String f55332n;

    /* renamed from: o, reason: collision with root package name */
    @JsonParseNode(key = "contype")
    private String f55333o;

    /* renamed from: p, reason: collision with root package name */
    @JsonParseNode(key = "hmsCoreVersion")
    private String f55334p;

    /* renamed from: q, reason: collision with root package name */
    @JsonParseNode(key = "tzone")
    private String f55335q;

    /* renamed from: r, reason: collision with root package name */
    @JsonParseNode(key = "hmsStoreVersion")
    private String f55336r;

    /* renamed from: s, reason: collision with root package name */
    @JsonParseNode(key = "country")
    private String f55337s;

    /* renamed from: t, reason: collision with root package name */
    @JsonParseNode(key = SocializeProtocolConstants.PROTOCOL_KEY_EXTEND)
    private i5 f55338t;

    /* renamed from: u, reason: collision with root package name */
    @JsonParseNode(key = "geo")
    private j5 f55339u;

    public void a(int i6) {
        this.f55321c = i6;
    }

    public void a(i5 i5Var) {
        this.f55338t = i5Var;
    }

    public k5(IDeviceInterface iDeviceInterface) {
        if (iDeviceInterface != null) {
            this.f55319a = iDeviceInterface.getDeviceType();
            this.f55320b = iDeviceInterface.getUserAgent();
            this.f55322d = iDeviceInterface.getManufacturer();
            this.f55323e = iDeviceInterface.getBrand();
            this.f55324f = iDeviceInterface.getModel();
            this.f55325g = iDeviceInterface.getOs();
            this.f55326h = iDeviceInterface.getAndroidRelease();
            this.f55328j = iDeviceInterface.getScreenWidthPX();
            this.f55327i = iDeviceInterface.getScreenHeightPX();
            this.f55329k = String.valueOf(iDeviceInterface.getDensityDpi());
            this.f55330l = String.valueOf(iDeviceInterface.getDensity());
            this.f55331m = iDeviceInterface.getLanguage();
            this.f55332n = iDeviceInterface.getCarrier();
            this.f55333o = String.valueOf(iDeviceInterface.getConnectType());
            this.f55334p = iDeviceInterface.getHmsCoreVersion();
            this.f55335q = iDeviceInterface.getTimeZone();
            this.f55336r = iDeviceInterface.getHmsStoreVersion();
            this.f55337s = iDeviceInterface.getCountryCode();
        }
    }

    public void a(j5 j5Var) {
        this.f55339u = j5Var;
    }
}
