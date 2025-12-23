package xyz.adscope.ad;

import android.content.Context;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import xyz.adscope.ad.publish.ASNPInitConfig;
import xyz.adscope.common.v2.dev.DeviceInfoConstants;
import xyz.adscope.common.v2.dev.IDeviceInterface;
import xyz.adscope.common.v2.dev.info.PackageUtil;
import xyz.adscope.common.v2.location.ILocation;
import xyz.adscope.common.v2.location.LocationManager;
import xyz.adscope.common.v2.tool.json.JsonUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class z0 implements p2 {

    /* renamed from: a, reason: collision with root package name */
    private a2 f56198a;

    /* renamed from: b, reason: collision with root package name */
    private ASNPInitConfig f56199b;

    /* renamed from: c, reason: collision with root package name */
    private final Context f56200c;

    /* renamed from: d, reason: collision with root package name */
    private String f56201d;

    /* renamed from: e, reason: collision with root package name */
    private IDeviceInterface f56202e;

    /* renamed from: f, reason: collision with root package name */
    private c f56203f;

    public void a(a2 a2Var, ASNPInitConfig aSNPInitConfig, c cVar, String str) {
        this.f56198a = a2Var;
        this.f56199b = aSNPInitConfig;
        this.f56201d = str;
        this.f56203f = cVar;
    }

    private g5 c() {
        g5 g5Var = new g5();
        g5Var.a(b());
        return g5Var;
    }

    private f5 d() {
        f5 f5Var = new f5();
        ASNPInitConfig aSNPInitConfig = this.f56199b;
        f5Var.a(aSNPInitConfig != null ? aSNPInitConfig.getAppId() : "");
        f5Var.b(this.f56200c.getPackageName());
        f5Var.a(PackageUtil.getAppInstallDate(this.f56200c));
        f5Var.c(PackageUtil.getAppName(this.f56200c));
        f5Var.b(PackageUtil.getAppLastUpdateTime(this.f56200c));
        f5Var.d(PackageUtil.getAppVersionName(this.f56200c));
        return f5Var;
    }

    private h5 e() {
        h5 h5Var = new h5();
        h5Var.a(d());
        h5Var.a(c());
        h5Var.a(f());
        h5Var.a(h());
        h5Var.a(i());
        return h5Var;
    }

    private k5 f() {
        k5 k5Var = new k5(this.f56202e);
        k5Var.a(a(this.f56202e));
        ILocation lastKnownLocation = LocationManager.getInstance().getOrCreateImplement(this.f56200c).getLastKnownLocation();
        if (lastKnownLocation != null) {
            k5Var.a(new j5(lastKnownLocation));
        }
        ASNPInitConfig aSNPInitConfig = this.f56199b;
        if (aSNPInitConfig == null || !aSNPInitConfig.canUseOAIDInfo()) {
            k5Var.a(1);
            return k5Var;
        }
        k5Var.a(0);
        return k5Var;
    }

    private List<l5> g() {
        ArrayList arrayList = new ArrayList();
        if (this.f56199b != null) {
            l5 l5Var = new l5();
            l5Var.a(1);
            a2 a2Var = this.f56198a;
            l5Var.a(a2Var != null ? a2Var.getTimeoutMillion() : 5000L);
            a2 a2Var2 = this.f56198a;
            l5Var.b(a2Var2 != null ? a2Var2.getAdCount() : 1);
            l5Var.a(k());
            arrayList.add(l5Var);
        }
        return arrayList;
    }

    private m5 h() {
        m5 m5Var = new m5();
        ASNPInitConfig aSNPInitConfig = this.f56199b;
        if (aSNPInitConfig != null) {
            m5Var.a(aSNPInitConfig.getCCPAAuthorise());
            m5Var.b(this.f56199b.getCOPPAAuthorise());
            m5Var.c(this.f56199b.getGDPRAuthorise());
        }
        return m5Var;
    }

    private p5 i() {
        p5 p5Var = new p5();
        ASNPInitConfig aSNPInitConfig = this.f56199b;
        p5Var.a(aSNPInitConfig != null ? aSNPInitConfig.getUserId() : "");
        p5Var.a(a(this.f56199b));
        ASNPInitConfig aSNPInitConfig2 = this.f56199b;
        p5Var.a((aSNPInitConfig2 == null || !aSNPInitConfig2.isSupportSensor()) ? 1 : 0);
        return p5Var;
    }

    private n5 j() {
        n5 n5Var = new n5();
        l0 orCreateImplement = m0.a().getOrCreateImplement(this.f56200c);
        if (orCreateImplement != null) {
            n5Var.a(orCreateImplement.b(this.f56203f));
        }
        return n5Var;
    }

    private o5 k() {
        o5 o5Var = new o5();
        o5Var.a(j());
        o5Var.a(f0.a());
        o5Var.b(f0.c());
        a2 a2Var = this.f56198a;
        o5Var.c(a2Var != null ? a2Var.getSpaceID() : "");
        return o5Var;
    }

    public z0(Context context) {
        this.f56200c = context;
        j orCreateImplement = k.a().getOrCreateImplement(context);
        if (orCreateImplement != null) {
            this.f56202e = orCreateImplement.b();
        }
    }

    private List<e5> b() {
        List<c1> a6 = k.a().getOrCreateImplement(this.f56200c).a();
        if (a6 != null && !a6.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (c1 c1Var : a6) {
                e5 e5Var = new e5();
                e5Var.a(c1Var.d());
                e5Var.b(c1Var.b());
                e5Var.a(c1Var.c());
                arrayList.add(e5Var);
            }
            return arrayList;
        }
        return null;
    }

    @Override // xyz.adscope.ad.p2
    public String a() {
        int countryCN;
        if (this.f56198a != null && this.f56199b != null) {
            a1 a1Var = new a1();
            a1Var.a(1);
            a1Var.a(e());
            a1Var.a(this.f56199b.getCurrency());
            a1Var.a(this.f56201d);
            a1Var.b(g());
            ASNPInitConfig aSNPInitConfig = this.f56199b;
            if (aSNPInitConfig != null) {
                countryCN = aSNPInitConfig.getCountryCN();
            } else {
                IDeviceInterface iDeviceInterface = this.f56202e;
                countryCN = iDeviceInterface != null ? iDeviceInterface.getCountryCN() : DeviceInfoConstants.CountryType.COUNTRY_CHINA_TYPE.getCode();
            }
            a1Var.c(countryCN);
            ASNPInitConfig aSNPInitConfig2 = this.f56199b;
            a1Var.d((aSNPInitConfig2 == null || !aSNPInitConfig2.getIsTestAd()) ? 0 : 1);
            a1Var.b(5000);
            return a1Var.toJsonString();
        }
        return "";
    }

    private JSONArray a(ASNPInitConfig aSNPInitConfig) {
        Map<String, String> optionFields;
        if (aSNPInitConfig != null && (optionFields = aSNPInitConfig.getOptionFields()) != null && !optionFields.isEmpty()) {
            return JsonUtil.parseMap2JsonByKeys(optionFields, "id", CommonNetImpl.NAME);
        }
        return JsonUtil.emptyJSONArray();
    }

    private i5 a(IDeviceInterface iDeviceInterface) {
        if (iDeviceInterface == null) {
            return null;
        }
        i5 i5Var = new i5();
        i5Var.b(iDeviceInterface.getDeviceName());
        i5Var.c(iDeviceInterface.getFileMark());
        i5Var.g(iDeviceInterface.getPhysicalMemory());
        i5Var.j(iDeviceInterface.getDeviceUpdateMark());
        i5Var.d(iDeviceInterface.getHardDisk());
        i5Var.i(f0.a(this.f56200c));
        i5Var.e(iDeviceInterface.getHonorOAID());
        i5Var.a(iDeviceInterface.getDeveloperTag());
        i5Var.b(iDeviceInterface.getPromptTag());
        i5Var.h(iDeviceInterface.getOMERomVersion());
        ASNPInitConfig aSNPInitConfig = this.f56199b;
        if (aSNPInitConfig != null && aSNPInitConfig.canUseOAIDInfo()) {
            i5Var.f(iDeviceInterface.getOAID());
        } else {
            i5Var.f("");
        }
        i5Var.a(this.f56199b.getCustomOAID());
        return i5Var;
    }
}
