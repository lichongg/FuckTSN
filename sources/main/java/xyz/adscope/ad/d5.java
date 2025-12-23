package xyz.adscope.ad;

import android.content.Context;
import xyz.adscope.ad.model.impl.resp.cfg.root.ConfigResponseModel;
import xyz.adscope.ad.publish.ASNPInitConfig;
import xyz.adscope.common.analyse.model.IBaseEventReportModel;
import xyz.adscope.common.analyse.model.IStringEventEnum;
import xyz.adscope.common.v2.dev.IDeviceInterface;
import xyz.adscope.common.v2.dev.info.PackageUtil;
import xyz.adscope.common.v2.model.IBaseMacrosMappingModel;
import xyz.adscope.common.v2.model.IDeepCopyModel;
import xyz.adscope.common.v2.model.annotation.MacrosReplace;
import xyz.adscope.common.v2.tool.json.JsonUtil;
import xyz.adscope.common.v2.tool.str.SerialUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
class d5 extends IBaseEventReportModel {

    /* renamed from: a, reason: collision with root package name */
    private f f54992a;

    /* renamed from: b, reason: collision with root package name */
    private b f54993b;

    /* renamed from: c, reason: collision with root package name */
    private i f54994c;

    /* renamed from: d, reason: collision with root package name */
    private d f54995d;

    /* renamed from: e, reason: collision with root package name */
    private h f54996e;

    /* renamed from: f, reason: collision with root package name */
    private a f54997f;

    /* renamed from: g, reason: collision with root package name */
    private g f54998g;

    /* renamed from: h, reason: collision with root package name */
    private e f54999h;

    /* renamed from: i, reason: collision with root package name */
    private c f55000i;

    /* renamed from: j, reason: collision with root package name */
    @MacrosReplace(macros = "__LOG_TIME__")
    private final String f55001j;

    /* renamed from: k, reason: collision with root package name */
    @MacrosReplace(macros = "__EVENT_ID__")
    private final String f55002k;

    /* renamed from: l, reason: collision with root package name */
    @MacrosReplace(macros = "__EVENT_VERSION__")
    private final String f55003l;

    /* renamed from: m, reason: collision with root package name */
    @MacrosReplace(macros = "__EVENT_CODE__")
    private final String f55004m;

    /* renamed from: n, reason: collision with root package name */
    @MacrosReplace(macros = "__EVENT_SPACE__")
    private final String f55005n;

    /* renamed from: o, reason: collision with root package name */
    @MacrosReplace(macros = "__EVENT_TIME__")
    private final String f55006o;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a extends IBaseMacrosMappingModel implements IDeepCopyModel {

        /* renamed from: a, reason: collision with root package name */
        @MacrosReplace(macros = "__SESSION_ID__")
        private final String f55007a;

        /* renamed from: b, reason: collision with root package name */
        @MacrosReplace(macros = "__COST_TIME__")
        private final String f55008b;

        /* renamed from: c, reason: collision with root package name */
        @MacrosReplace(macros = "__SPACE_ID__")
        private final String f55009c;

        /* renamed from: d, reason: collision with root package name */
        @MacrosReplace(macros = "__AD_SPACE_TYPE__")
        private final String f55010d;

        /* renamed from: e, reason: collision with root package name */
        @MacrosReplace(macros = "__DSP_ID__")
        private final String f55011e;

        /* renamed from: f, reason: collision with root package name */
        @MacrosReplace(macros = "__PRICE__")
        private final String f55012f;

        /* renamed from: g, reason: collision with root package name */
        @MacrosReplace(macros = "__ADN_RENDER_ID__")
        private final String f55013g;

        /* renamed from: h, reason: collision with root package name */
        @MacrosReplace(macros = "__ADN_INTERACTION_ID__")
        private final String f55014h;

        /* renamed from: i, reason: collision with root package name */
        @MacrosReplace(macros = "__CLICK_TYPE__")
        private final String f55015i;

        /* renamed from: j, reason: collision with root package name */
        @MacrosReplace(macros = "__AD_ERROR_CODE__")
        private final String f55016j;

        /* renamed from: k, reason: collision with root package name */
        @MacrosReplace(macros = "__AD_ERROR_INFO__")
        private final String f55017k;

        /* renamed from: l, reason: collision with root package name */
        @MacrosReplace(macros = "__ORDER_ID__")
        private final String f55018l;

        /* renamed from: m, reason: collision with root package name */
        @MacrosReplace(macros = "__MATERIAL_ID__")
        private final String f55019m;

        /* renamed from: n, reason: collision with root package name */
        @MacrosReplace(macros = "__MAX_WAIT_TIME__")
        private final String f55020n;

        /* renamed from: o, reason: collision with root package name */
        @MacrosReplace(macros = "__AD_TYPE__")
        private final String f55021o;

        /* renamed from: p, reason: collision with root package name */
        @MacrosReplace(macros = "__CURRENCY__")
        private final String f55022p;

        /* renamed from: q, reason: collision with root package name */
        @MacrosReplace(macros = "__IS_WIN__")
        private final String f55023q;

        /* renamed from: r, reason: collision with root package name */
        @MacrosReplace(macros = "__WIN_PRICE__")
        private final String f55024r;

        /* renamed from: s, reason: collision with root package name */
        @MacrosReplace(macros = "__EXP_PRICE__")
        private final String f55025s;

        /* renamed from: t, reason: collision with root package name */
        @MacrosReplace(macros = "__QUANTITY__")
        private final String f55026t;

        /* renamed from: u, reason: collision with root package name */
        @MacrosReplace(macros = "__CREATIVE_ID__")
        private final String f55027u;

        /* renamed from: v, reason: collision with root package name */
        @MacrosReplace(macros = "__COMPLAIN__")
        private final String f55028v;

        a(b1 b1Var) {
            String str;
            String str2;
            this.f55028v = b1Var.e();
            this.f55027u = b1Var.f();
            this.f55026t = b1Var.s() + "";
            this.f55025s = b1Var.q() + "";
            this.f55024r = b1Var.y();
            this.f55023q = b1Var.c();
            this.f55022p = b1Var.g();
            this.f55021o = b1Var.b().c();
            this.f55020n = b1Var.o() + "";
            this.f55019m = b1Var.n();
            this.f55018l = b1Var.p();
            this.f55017k = b1Var.k();
            if (b1Var.j() != -1) {
                str = b1Var.j() + "";
            } else {
                str = "";
            }
            this.f55016j = str;
            if (b1Var.m() == -1) {
                str2 = "";
            } else {
                str2 = b1Var.m() + "";
            }
            this.f55015i = str2;
            this.f55014h = b1Var.u();
            this.f55013g = b1Var.u();
            this.f55012f = b1Var.q() + "";
            this.f55011e = b1Var.i();
            this.f55010d = b1Var.b().c();
            this.f55009c = b1Var.w();
            this.f55008b = b1Var.h() + "";
            this.f55007a = b1Var.t();
        }

        @Override // xyz.adscope.common.v2.model.IDeepCopyModel
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a deepCopy() {
            return new a(this);
        }

        private a(a aVar) {
            this.f55007a = aVar.f55007a;
            this.f55008b = aVar.f55008b;
            this.f55009c = aVar.f55009c;
            this.f55010d = aVar.f55010d;
            this.f55011e = aVar.f55011e;
            this.f55012f = aVar.f55012f;
            this.f55013g = aVar.f55013g;
            this.f55014h = aVar.f55014h;
            this.f55015i = aVar.f55015i;
            this.f55016j = aVar.f55016j;
            this.f55017k = aVar.f55017k;
            this.f55018l = aVar.f55018l;
            this.f55019m = aVar.f55019m;
            this.f55020n = aVar.f55020n;
            this.f55021o = aVar.f55021o;
            this.f55022p = aVar.f55022p;
            this.f55023q = aVar.f55023q;
            this.f55024r = aVar.f55024r;
            this.f55025s = aVar.f55025s;
            this.f55026t = aVar.f55026t;
            this.f55027u = aVar.f55027u;
            this.f55028v = aVar.f55028v;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class g extends IBaseMacrosMappingModel implements IDeepCopyModel {

        /* renamed from: a, reason: collision with root package name */
        @MacrosReplace(macros = "__UPDATE_MD5__")
        private final String f55071a;

        /* renamed from: b, reason: collision with root package name */
        @MacrosReplace(macros = "__REQUESTURL_MD5__")
        private final String f55072b;

        /* renamed from: c, reason: collision with root package name */
        @MacrosReplace(macros = "__STRATEGY_MD5__")
        private final String f55073c;

        /* renamed from: d, reason: collision with root package name */
        @MacrosReplace(macros = "__TEMPLATE_MD5__")
        private final String f55074d;

        /* renamed from: e, reason: collision with root package name */
        @MacrosReplace(macros = "__STATISTICS_MD5__")
        private final String f55075e;

        g(ConfigResponseModel configResponseModel) {
            this.f55071a = configResponseModel.o();
            this.f55072b = configResponseModel.g();
            this.f55073c = configResponseModel.k();
            this.f55074d = configResponseModel.l();
            this.f55075e = configResponseModel.i();
        }

        @Override // xyz.adscope.common.v2.model.IDeepCopyModel
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public g deepCopy() {
            return new g(this);
        }

        private g(g gVar) {
            this.f55071a = gVar.f55071a;
            this.f55072b = gVar.f55072b;
            this.f55073c = gVar.f55073c;
            this.f55074d = gVar.f55074d;
            this.f55075e = gVar.f55075e;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class h extends IBaseMacrosMappingModel implements IDeepCopyModel {

        /* renamed from: a, reason: collision with root package name */
        @MacrosReplace(macros = "__START_ID__")
        private final String f55076a;

        /* renamed from: b, reason: collision with root package name */
        @MacrosReplace(macros = "__COST_TIME__")
        private final String f55077b;

        @Override // xyz.adscope.common.v2.model.IDeepCopyModel
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public h deepCopy() {
            return new h(this.f55076a, this.f55077b);
        }

        h(String str, String str2) {
            this.f55076a = str;
            this.f55077b = str2;
        }
    }

    void a(f fVar) {
        this.f54992a = fVar;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b extends IBaseMacrosMappingModel {

        /* renamed from: a, reason: collision with root package name */
        @MacrosReplace(macros = "__APP_VERSION__")
        private final String f55029a;

        /* renamed from: b, reason: collision with root package name */
        @MacrosReplace(macros = "__APP_NAME__")
        private final String f55030b;

        /* renamed from: c, reason: collision with root package name */
        @MacrosReplace(macros = "__BUNDLE_ID__")
        private final String f55031c;

        /* renamed from: d, reason: collision with root package name */
        @MacrosReplace(macros = "__INSTALL_TIME__")
        private final String f55032d;

        /* renamed from: e, reason: collision with root package name */
        @MacrosReplace(macros = "__UPDATE_TIME__")
        private final String f55033e;

        b(Context context) {
            this.f55029a = PackageUtil.getAppVersionName(context);
            this.f55030b = PackageUtil.getAppName(context);
            this.f55031c = context.getPackageName();
            this.f55032d = PackageUtil.getAppInstallDate(context) + "";
            this.f55033e = PackageUtil.getAppLastUpdateTime(context) + "";
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class c extends IBaseMacrosMappingModel {

        /* renamed from: a, reason: collision with root package name */
        @MacrosReplace(macros = "__APP_INSTALLS__")
        private final String f55034a;

        c(String str) {
            this.f55034a = str;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class d extends IBaseMacrosMappingModel {

        /* renamed from: a, reason: collision with root package name */
        @MacrosReplace(macros = "__SAID__")
        private final String f55035a;

        /* renamed from: c, reason: collision with root package name */
        @MacrosReplace(macros = "__ACCESS_TYPE__")
        private final String f55037c = f0.d();

        /* renamed from: d, reason: collision with root package name */
        @MacrosReplace(macros = "__AD_SDK_VERSION__")
        private final String f55038d = f0.c();

        /* renamed from: b, reason: collision with root package name */
        @MacrosReplace(macros = "__ACCESS_KEY__")
        private final String f55036b = f0.a();

        /* renamed from: e, reason: collision with root package name */
        @MacrosReplace(macros = "__CUSTOM_LOGGER__")
        private final String f55039e = f0.b();

        /* renamed from: f, reason: collision with root package name */
        @MacrosReplace(macros = "__CUSTOM_ID__")
        private final String f55040f = f0.e();

        /* renamed from: g, reason: collision with root package name */
        @MacrosReplace(macros = "__LOG_VERSION__")
        private final String f55041g = f0.f();

        /* renamed from: h, reason: collision with root package name */
        @MacrosReplace(macros = "__ORG_KEY__")
        private final String f55042h = f0.a();

        d(Context context) {
            this.f55035a = f0.a(context);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class e extends IBaseMacrosMappingModel {

        /* renamed from: a, reason: collision with root package name */
        @MacrosReplace(macros = "__AFFILIATED__")
        private final String f55043a;

        /* renamed from: b, reason: collision with root package name */
        @MacrosReplace(macros = "__EXCEPTION__")
        private final String f55044b;

        e(m1 m1Var) {
            this.f55043a = m1Var.a();
            this.f55044b = m1Var.b();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class f extends IBaseMacrosMappingModel {

        /* renamed from: a, reason: collision with root package name */
        @MacrosReplace(macros = "__OAID__")
        private final String f55045a;

        /* renamed from: b, reason: collision with root package name */
        @MacrosReplace(macros = "__GAID__")
        private final String f55046b;

        /* renamed from: c, reason: collision with root package name */
        @MacrosReplace(macros = "__OOAID__")
        private final String f55047c;

        /* renamed from: d, reason: collision with root package name */
        @MacrosReplace(macros = "__OGAID__")
        private final String f55048d;

        /* renamed from: e, reason: collision with root package name */
        @MacrosReplace(macros = "__DEVICE_NAME__")
        private final String f55049e;

        /* renamed from: f, reason: collision with root package name */
        @MacrosReplace(macros = "__DEVICE_TYPE__")
        private final String f55050f;

        /* renamed from: g, reason: collision with root package name */
        @MacrosReplace(macros = "__MAKE__")
        private final String f55051g;

        /* renamed from: h, reason: collision with root package name */
        @MacrosReplace(macros = "__BRAND__")
        private final String f55052h;

        /* renamed from: i, reason: collision with root package name */
        @MacrosReplace(macros = "__MODEL__")
        private final String f55053i;

        /* renamed from: j, reason: collision with root package name */
        @MacrosReplace(macros = "__PHYSICAL_MEMORY__")
        private final String f55054j;

        /* renamed from: k, reason: collision with root package name */
        @MacrosReplace(macros = "__HARD_DISK_SIZE__")
        private final String f55055k;

        /* renamed from: l, reason: collision with root package name */
        @MacrosReplace(macros = "__W__")
        private final String f55056l;

        /* renamed from: m, reason: collision with root package name */
        @MacrosReplace(macros = "__H__")
        private final String f55057m;

        /* renamed from: n, reason: collision with root package name */
        @MacrosReplace(macros = "__DENSITY__")
        private final String f55058n;

        /* renamed from: o, reason: collision with root package name */
        @MacrosReplace(macros = "__ORIENTATION__")
        private final String f55059o;

        /* renamed from: p, reason: collision with root package name */
        @MacrosReplace(macros = "__OS__")
        private final String f55060p;

        /* renamed from: q, reason: collision with root package name */
        @MacrosReplace(macros = "__OSV__")
        private final String f55061q;

        /* renamed from: r, reason: collision with root package name */
        @MacrosReplace(macros = "__USER_AGENT__")
        private final String f55062r;

        /* renamed from: s, reason: collision with root package name */
        @MacrosReplace(macros = "__ZONE__")
        private final String f55063s;

        /* renamed from: t, reason: collision with root package name */
        @MacrosReplace(macros = "__LANG__")
        private final String f55064t;

        /* renamed from: u, reason: collision with root package name */
        @MacrosReplace(macros = "__COUNTRY__")
        private final String f55065u;

        /* renamed from: v, reason: collision with root package name */
        @MacrosReplace(macros = "__CARRIER__")
        private final String f55066v;

        /* renamed from: w, reason: collision with root package name */
        @MacrosReplace(macros = "__UPDATE_MARK__")
        private final String f55067w;

        /* renamed from: x, reason: collision with root package name */
        @MacrosReplace(macros = "__FILE_MARK__")
        private final String f55068x;

        /* renamed from: y, reason: collision with root package name */
        @MacrosReplace(macros = "__CONNECTION_TYPE__")
        private final String f55069y;

        /* renamed from: z, reason: collision with root package name */
        @MacrosReplace(macros = "__ROMVERSION__")
        private final String f55070z;

        f(IDeviceInterface iDeviceInterface) {
            this.f55045a = iDeviceInterface.getOAID();
            this.f55046b = iDeviceInterface.getGAID();
            this.f55047c = iDeviceInterface.getOAID();
            this.f55048d = iDeviceInterface.getGAID();
            this.f55049e = iDeviceInterface.getDeviceName();
            this.f55050f = iDeviceInterface.getDeviceType() + "";
            this.f55051g = iDeviceInterface.getManufacturer();
            this.f55052h = iDeviceInterface.getBrand();
            this.f55053i = iDeviceInterface.getModel();
            this.f55054j = iDeviceInterface.getPhysicalMemory();
            this.f55055k = iDeviceInterface.getHardDisk();
            this.f55056l = iDeviceInterface.getResolutionWidth() + "";
            this.f55057m = iDeviceInterface.getResolutionHeight() + "";
            this.f55058n = iDeviceInterface.getDensity() + "";
            this.f55059o = iDeviceInterface.getOrientation() + "";
            this.f55060p = iDeviceInterface.getOs() + "";
            this.f55061q = iDeviceInterface.getAndroidRelease();
            this.f55062r = iDeviceInterface.getUserAgent();
            this.f55063s = iDeviceInterface.getTimeZone();
            this.f55064t = iDeviceInterface.getLanguage();
            this.f55065u = iDeviceInterface.getCountryCode();
            this.f55066v = iDeviceInterface.getCarrier();
            this.f55067w = iDeviceInterface.getDeviceUpdateMark();
            this.f55068x = iDeviceInterface.getFileMark();
            this.f55069y = iDeviceInterface.getConnectType() + "";
            this.f55070z = iDeviceInterface.getOMERomVersion();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class i extends IBaseMacrosMappingModel {

        /* renamed from: a, reason: collision with root package name */
        @MacrosReplace(macros = "__USER_ID__")
        private final String f55078a;

        /* renamed from: b, reason: collision with root package name */
        @MacrosReplace(macros = "__COAID__")
        private final String f55079b;

        /* renamed from: c, reason: collision with root package name */
        @MacrosReplace(macros = "__CGAID__")
        private final String f55080c;

        /* renamed from: d, reason: collision with root package name */
        @MacrosReplace(macros = "__LMT__")
        private final String f55081d;

        /* renamed from: e, reason: collision with root package name */
        @MacrosReplace(macros = "__USER_CUSTOM_DATA__")
        private final String f55082e;

        /* renamed from: f, reason: collision with root package name */
        @MacrosReplace(macros = "__APP_ID__")
        private final String f55083f;

        i(ASNPInitConfig aSNPInitConfig) {
            this.f55078a = aSNPInitConfig.getUserId();
            boolean canUseOAIDInfo = aSNPInitConfig.canUseOAIDInfo();
            this.f55079b = aSNPInitConfig.getCustomOAID();
            this.f55080c = aSNPInitConfig.getCustomGAID();
            this.f55081d = (canUseOAIDInfo ? 1 : 0) + "";
            this.f55082e = a(aSNPInitConfig);
            this.f55083f = aSNPInitConfig.getAppId();
        }

        String a(ASNPInitConfig aSNPInitConfig) {
            return JsonUtil.parseMap2JsonStr(aSNPInitConfig.getOptionFields());
        }
    }

    void a(b bVar) {
        this.f54993b = bVar;
    }

    d5(IStringEventEnum iStringEventEnum) {
        super(iStringEventEnum);
        this.f55003l = "";
        this.f55004m = getEventCode();
        this.f55005n = "NSDK";
        String str = System.currentTimeMillis() + "";
        this.f55001j = str;
        this.f55006o = str;
        this.f55002k = SerialUtil.generateReportEventID();
    }

    void a(i iVar) {
        this.f54994c = iVar;
    }

    void a(d dVar) {
        this.f54995d = dVar;
    }

    void a(h hVar) {
        this.f54996e = hVar;
    }

    void a(a aVar) {
        this.f54997f = aVar;
    }

    void a(g gVar) {
        this.f54998g = gVar;
    }

    void a(e eVar) {
        this.f54999h = eVar;
    }

    void a(c cVar) {
        this.f55000i = cVar;
    }

    @Override // xyz.adscope.common.v2.model.IDeepCopyModel
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public d5 deepCopy() {
        d5 d5Var = new d5(this.event);
        f fVar = this.f54992a;
        if (fVar != null) {
            d5Var.f54992a = fVar;
        }
        b bVar = this.f54993b;
        if (bVar != null) {
            d5Var.f54993b = bVar;
        }
        i iVar = this.f54994c;
        if (iVar != null) {
            d5Var.f54994c = iVar;
        }
        d dVar = this.f54995d;
        if (dVar != null) {
            d5Var.f54995d = dVar;
        }
        h hVar = this.f54996e;
        if (hVar != null) {
            d5Var.f54996e = hVar.deepCopy();
        }
        a aVar = this.f54997f;
        if (aVar != null) {
            d5Var.f54997f = aVar.deepCopy();
        }
        g gVar = this.f54998g;
        if (gVar != null) {
            d5Var.f54998g = gVar.deepCopy();
        }
        e eVar = this.f54999h;
        if (eVar != null) {
            d5Var.f54999h = eVar;
        }
        c cVar = this.f55000i;
        if (cVar != null) {
            d5Var.f55000i = cVar;
        }
        return d5Var;
    }
}
