package com.bytedance.sdk.component.adexpress.dynamic.cw;

import com.alibaba.fastjson.parser.JSONLexer;
import com.beizi.fusion.widget.ScrollClickView;
import com.bytedance.sdk.component.utils.vl;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import io.netty.util.internal.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.text.v0;
import org.json.JSONArray;
import org.json.JSONObject;
import xyz.adscope.amps.common.AMPSConstants;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private int f25601a;
    private float ae;
    private int aq;
    private String av;
    private String az;

    /* renamed from: b, reason: collision with root package name */
    private int f25602b;

    /* renamed from: c, reason: collision with root package name */
    private int f25603c;
    private boolean ch;
    private float cw;

    /* renamed from: d, reason: collision with root package name */
    private int f25604d;

    /* renamed from: e, reason: collision with root package name */
    private String f25605e;
    private int ed;
    private String el;
    private int et;

    /* renamed from: f, reason: collision with root package name */
    private String f25606f;
    private int ff;
    private String fp;
    private int fx;

    /* renamed from: g, reason: collision with root package name */
    private float f25607g;
    private String gq;
    private String gr;
    private int gx;

    /* renamed from: h, reason: collision with root package name */
    private String f25608h;
    private boolean hh;
    private boolean hl;
    private List<String> hu;

    /* renamed from: i, reason: collision with root package name */
    private String f25609i;
    private String ig;
    private boolean ik;
    private int im;

    /* renamed from: j, reason: collision with root package name */
    private float f25610j;
    private String jl;
    private String jy;

    /* renamed from: k, reason: collision with root package name */
    private JSONObject f25611k;
    private boolean ka;
    private int kc;
    private int ki;
    private String kt;

    /* renamed from: l, reason: collision with root package name */
    private double f25612l;
    private String la;
    private JSONObject ll;
    private boolean ln;
    private boolean lx;

    /* renamed from: m, reason: collision with root package name */
    private float f25613m;
    private String mi;

    /* renamed from: n, reason: collision with root package name */
    private int f25614n;
    private int na;
    private int nd;
    private List<j> nt;
    private String nu;

    /* renamed from: o, reason: collision with root package name */
    private String f25615o;
    private int ol;
    private boolean om;
    private float oq;
    private boolean ov;
    private JSONObject oy;

    /* renamed from: p, reason: collision with root package name */
    private double f25616p;
    private boolean px;
    private int pz;

    /* renamed from: q, reason: collision with root package name */
    private boolean f25617q;
    private String qa;
    private boolean qb;
    private String qe;
    private int qg;
    private double qo;
    private double qv;

    /* renamed from: r, reason: collision with root package name */
    private float f25618r;
    private double rh;
    private int ri;
    private String rn;
    private int rr;
    private int rs;
    private boolean ry;

    /* renamed from: s, reason: collision with root package name */
    private int f25619s;
    private boolean sm;
    private int st;

    /* renamed from: t, reason: collision with root package name */
    private int f25620t;
    private String tj;
    private int tk;
    private float tl;

    /* renamed from: u, reason: collision with root package name */
    private int f25621u;
    private int uc;
    private boolean uf;
    private boolean up;
    private boolean uq;

    /* renamed from: v, reason: collision with root package name */
    private String f25622v;
    private double vl;

    /* renamed from: w, reason: collision with root package name */
    private String f25623w;
    private String wf;
    private int wi;
    private boolean wo;
    private String wq;
    private String ws;

    /* renamed from: x, reason: collision with root package name */
    private String f25624x;
    private int xp;
    private String xq;
    private float xt;
    private JSONObject xw;

    /* renamed from: y, reason: collision with root package name */
    private int f25625y;
    private boolean ya;
    private long yb = -1;
    private int yl;

    /* renamed from: z, reason: collision with root package name */
    private int f25626z;
    private int zs;
    private int zz;

    public static m j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        m mVar = new m();
        mVar.xt(jSONObject.optString("adType", "embeded"));
        mVar.az(jSONObject.optString("clickArea", "creative"));
        mVar.av(jSONObject.optString("clickTigger", AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_CLICK));
        mVar.cw(jSONObject.optString("fontFamily", "PingFangSC"));
        mVar.r(jSONObject.optString("textAlign", ScrollClickView.DIR_LEFT));
        mVar.up(jSONObject.optString("color", "#999999"));
        mVar.m(jSONObject.optString("bgColor", "transparent"));
        mVar.ae(jSONObject.optString("bgImgUrl", ""));
        mVar.l(jSONObject.optString("bgImgData", ""));
        mVar.tl(jSONObject.optString("borderColor", "#000000"));
        mVar.g(jSONObject.optString("borderStyle", "solid"));
        mVar.oq(jSONObject.optString("heightMode", "auto"));
        mVar.qv(jSONObject.optString("widthMode", "fixed"));
        mVar.vl(jSONObject.optString("interactText", ""));
        mVar.cw(jSONObject.optBoolean("isShowBgControl", false));
        mVar.jy(jSONObject.optString("interactBgColor", ""));
        JSONObject optJSONObject = jSONObject.optJSONObject("interactPosition");
        if (optJSONObject != null) {
            mVar.ae(optJSONObject.optInt("translateY", 0));
            mVar.tl(optJSONObject.optInt("translateX", 0));
            mVar.r(optJSONObject.optDouble("scaleX", 0.0d));
            mVar.up(optJSONObject.optDouble("scaleY", 0.0d));
        }
        mVar.ws(jSONObject.optString("interactType", ""));
        mVar.up(jSONObject.optInt("interactSlideDirection", -1));
        mVar.i(jSONObject.optString("justifyHorizontal", "space-around"));
        mVar.w(jSONObject.optString("justifyVertical", "flex-start"));
        mVar.xt(jSONObject.optDouble("timingStart"));
        mVar.cw(jSONObject.optDouble("timingEnd"));
        mVar.r((float) jSONObject.optDouble("width", 0.0d));
        mVar.cw((float) jSONObject.optDouble("height", 0.0d));
        mVar.j((float) jSONObject.optDouble("borderRadius", 0.0d));
        mVar.xt((float) jSONObject.optDouble("borderSize", 0.0d));
        mVar.xt(jSONObject.optBoolean("interactValidate", false));
        mVar.g((float) jSONObject.optDouble("fontSize", 0.0d));
        mVar.up((float) jSONObject.optDouble("paddingBottom", 0.0d));
        mVar.m((float) jSONObject.optDouble("paddingLeft", 0.0d));
        mVar.ae((float) jSONObject.optDouble("paddingRight", 0.0d));
        mVar.tl((float) jSONObject.optDouble("paddingTop", 0.0d));
        mVar.r(jSONObject.optBoolean("lineFeed", false));
        mVar.g(jSONObject.optInt("lineCount", 0));
        mVar.m(jSONObject.optDouble("lineHeight", 1.2d));
        mVar.ws(jSONObject.optInt("letterSpacing", 0));
        mVar.up(jSONObject.optBoolean("isDataFixed", false));
        mVar.az(jSONObject.optInt("fontWeight"));
        mVar.m(jSONObject.optBoolean("lineLimit"));
        mVar.av(jSONObject.optInt("position"));
        mVar.mi(jSONObject.optString("align"));
        mVar.ae(jSONObject.optBoolean("useLeft"));
        mVar.tl(jSONObject.optBoolean("useRight"));
        mVar.g(jSONObject.optBoolean("useTop"));
        mVar.oq(jSONObject.optBoolean("useBottom"));
        mVar.kt(jSONObject.optString("data"));
        mVar.xt(jSONObject.optJSONObject("i18n"));
        mVar.vl(jSONObject.optInt("marginLeft"));
        mVar.jy(jSONObject.optInt("marginRight"));
        mVar.oq(jSONObject.optInt("marginTop"));
        mVar.qv(jSONObject.optInt("marginBottom"));
        mVar.i(jSONObject.optInt("tagMaxCount"));
        mVar.qv(jSONObject.optBoolean("allowTextFlow"));
        mVar.w(jSONObject.optInt("textFlowType"));
        mVar.mi(jSONObject.optInt("textFlowDuration"));
        mVar.kt(jSONObject.optInt(ScrollClickView.DIR_LEFT));
        mVar.tj(jSONObject.optInt("right"));
        mVar.f(jSONObject.optInt("top"));
        mVar.v(jSONObject.optInt("bottom"));
        mVar.tj(jSONObject.optString("alignItems", "flex-start"));
        mVar.f(jSONObject.optString("direction", ""));
        mVar.j(jSONObject.optBoolean("loop", false));
        mVar.x(jSONObject.optInt("zIndex"));
        mVar.p(jSONObject.optInt("interactVisibleTime"));
        mVar.ch(jSONObject.optInt("interactHiddenTime"));
        mVar.jy(jSONObject.optBoolean("interactEnableMask"));
        mVar.ws(jSONObject.optBoolean("interactWontHide"));
        mVar.j(jSONObject.optString("bgGradient"));
        mVar.la(jSONObject.optInt("areaType"));
        mVar.gq(jSONObject.optInt("interactSlideThreshold", 0));
        mVar.uf(jSONObject.optInt("interactBottomDistance", com.bytedance.sdk.component.adexpress.r.j() ? 0 : 120));
        mVar.w(jSONObject.optBoolean("openPlayableLandingPage", false));
        mVar.cw(jSONObject.optJSONObject("video"));
        mVar.r(jSONObject.optJSONObject(SocializeProtocolConstants.IMAGE));
        mVar.rn(jSONObject.optInt("borderShadowExtent"));
        mVar.az(jSONObject.optBoolean("bgGauseBlur"));
        mVar.wq(jSONObject.optInt("bgGauseBlurRadius"));
        mVar.av(jSONObject.optBoolean("showTimeProgress", false));
        mVar.i(jSONObject.optBoolean("showPlayButton", false));
        mVar.j(jSONObject.optDouble("bgColorCg", 0.0d));
        mVar.m(jSONObject.optInt("bgMaterialCenterCalcColor", 0));
        mVar.xt(jSONObject.optInt("borderTopLeftRadius", 0));
        mVar.j(jSONObject.optInt("borderTopRightRadius", 0));
        mVar.r(jSONObject.optInt("borderBottomLeftRadius", 0));
        mVar.cw(jSONObject.optInt("borderBottomRightRadius", 0));
        mVar.up(jSONObject.optJSONObject("interactI18n"));
        mVar.x(jSONObject.optString("imageObjectFit"));
        mVar.ch(jSONObject.optString("interactTitle"));
        mVar.h(jSONObject.optInt("interactTextPositionTop"));
        mVar.v(jSONObject.optString("imageLottieTosPath"));
        mVar.vl(jSONObject.optBoolean("animationsLoop"));
        mVar.s(jSONObject.optInt("lottieAppNameMaxLength"));
        mVar.l(jSONObject.optInt("lottieAdDescMaxLength"));
        mVar.a(jSONObject.optInt("lottieAdTitleMaxLength"));
        mVar.a(jSONObject.optString("imageFlipSlideType"));
        mVar.mi(jSONObject.optBoolean("isClickEventIntercept"));
        if (jSONObject.has("filterColor")) {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("filterColor");
            if (optJSONArray != null) {
                for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                    arrayList.add(optJSONArray.optString(i6));
                }
                mVar.xt(arrayList);
            }
        }
        try {
            JSONArray optJSONArray2 = jSONObject.optJSONArray("animations");
            if (optJSONArray2 != null) {
                ArrayList arrayList2 = new ArrayList();
                for (int i7 = 0; i7 < optJSONArray2.length(); i7++) {
                    JSONObject jSONObject2 = optJSONArray2.getJSONObject(i7);
                    j jVar = new j();
                    jVar.cw(jSONObject2.optString("animationType"));
                    jVar.j(jSONObject2.optDouble("animationDuration"));
                    jVar.xt(jSONObject2.optDouble("animationScaleX"));
                    jVar.cw(jSONObject2.optDouble("animationScaleY"));
                    jVar.r(jSONObject2.optString("animationTimeFunction"));
                    jVar.r(jSONObject2.optDouble("animationDelay"));
                    jVar.m(jSONObject2.optInt("animationIterationCount"));
                    jVar.up(jSONObject2.optString("animationDirection"));
                    jVar.up(jSONObject2.optDouble("animationInterval"));
                    jVar.j(jSONObject2.optInt("animationBorderWidth"));
                    jVar.j(jSONObject2.optLong("key"));
                    jVar.xt(jSONObject2.optInt("animationEffectWidth"));
                    jVar.cw(jSONObject2.optInt("animationSwing", 1));
                    jVar.r(jSONObject2.optInt("animationTranslateX"));
                    jVar.up(jSONObject2.optInt("animationTranslateY"));
                    jVar.xt(jSONObject2.optString("animationRippleBackgroundColor"));
                    jVar.j(jSONObject2.optString("animationScaleDirection"));
                    jVar.ae(jSONObject2.optInt("animationFadeStart"));
                    jVar.tl(jSONObject2.optInt("animationFadeEnd"));
                    jVar.m(jSONObject2.optString("animationFillMode"));
                    jVar.g(jSONObject2.optInt("animationBounceHeight"));
                    if (mVar.mi() > 0.0d) {
                        jVar.r(jVar.ws() + mVar.mi());
                    }
                    arrayList2.add(jVar);
                }
                mVar.j(arrayList2);
            }
            if (jSONObject.has("triggerSlideMinDistance")) {
                mVar.s(jSONObject.optString("triggerSlideDirection", "0"));
                mVar.j(jSONObject.optLong("triggerSlideMinDistance", 0L));
            }
            return mVar;
        } catch (Exception e6) {
            vl.j(e6);
            return mVar;
        }
    }

    private void l(String str) {
        this.f25615o = str;
    }

    public String a() {
        return this.tj;
    }

    public int ae() {
        return this.yl;
    }

    public float av() {
        return this.tl;
    }

    public float az() {
        return this.ae;
    }

    public String ch() {
        return this.f25615o;
    }

    public int cw() {
        return this.tk;
    }

    public String f() {
        return this.av;
    }

    public int g() {
        return this.f25604d;
    }

    public int gq() {
        return this.f25619s;
    }

    public String h() {
        return this.f25624x;
    }

    public float i() {
        return this.f25607g;
    }

    public boolean jy() {
        return this.up;
    }

    public double kt() {
        return this.vl;
    }

    public boolean la() {
        return this.ch;
    }

    public JSONObject m() {
        return this.xw;
    }

    public double mi() {
        return this.qv;
    }

    public String oq() {
        return this.fp;
    }

    public String p() {
        return this.f25622v;
    }

    public float qv() {
        return this.f25610j;
    }

    public int r() {
        return this.fx;
    }

    public int rn() {
        return this.f25601a;
    }

    public String s() {
        return this.mi;
    }

    public String tj() {
        return this.az;
    }

    public double tl() {
        return this.qo;
    }

    public double uf() {
        return this.f25616p;
    }

    public int up() {
        return this.na;
    }

    public String v() {
        return this.f25609i;
    }

    public float vl() {
        return this.xt;
    }

    public float w() {
        return this.oq;
    }

    public double wq() {
        return this.f25612l;
    }

    public float ws() {
        return this.f25613m;
    }

    public String x() {
        return this.f25623w;
    }

    public int xt() {
        return this.wi;
    }

    public void a(int i6) {
        this.qg = i6;
    }

    public void ae(float f6) {
        this.tl = f6;
    }

    public String aq() {
        return this.xq;
    }

    public void av(String str) {
        this.gq = str;
    }

    public void az(String str) {
        this.la = str;
    }

    public int b() {
        return this.nd;
    }

    public String c() {
        return this.la;
    }

    public void ch(int i6) {
        this.im = i6;
    }

    public void cw(int i6) {
        this.fx = i6;
    }

    public int d() {
        return this.ri;
    }

    public double e() {
        return this.rh;
    }

    public String ed() {
        return this.f25608h;
    }

    public boolean el() {
        return this.lx;
    }

    public int et() {
        return this.f25621u;
    }

    public void f(int i6) {
        this.st = i6;
    }

    public boolean ff() {
        return this.f25617q;
    }

    public int fx() {
        return this.f25620t;
    }

    public void g(float f6) {
        this.oq = f6;
    }

    public void gq(int i6) {
        this.ri = i6;
    }

    public boolean gr() {
        return this.ka;
    }

    public String gx() {
        return this.gq;
    }

    public void h(int i6) {
        this.et = i6;
    }

    public int hh() {
        return this.f25603c;
    }

    public int hl() {
        return this.f25614n;
    }

    public void i(String str) {
        this.rn = str;
    }

    public long ig() {
        return this.yb;
    }

    public int ik() {
        return this.zs;
    }

    public int im() {
        return this.st;
    }

    public String jl() {
        return this.ig;
    }

    public void jy(String str) {
        this.f25624x = str;
    }

    public String k() {
        return this.f25605e;
    }

    public int ka() {
        return this.qg;
    }

    public boolean kc() {
        return this.sm;
    }

    public int ki() {
        return this.im;
    }

    public void kt(String str) {
        this.xq = str;
    }

    public String l() {
        return this.f25606f;
    }

    public void la(int i6) {
        this.uc = i6;
    }

    public boolean ll() {
        return this.px;
    }

    public int ln() {
        return this.aq;
    }

    public void m(int i6) {
        this.f25604d = i6;
    }

    public void mi(String str) {
        this.f25605e = str;
    }

    public String n() {
        return this.rn;
    }

    public boolean na() {
        return this.ik;
    }

    public String nd() {
        return this.wq;
    }

    public String nt() {
        return this.qa;
    }

    public boolean nu() {
        return this.wo;
    }

    public List<String> o() {
        return this.hu;
    }

    public int ol() {
        return this.ed;
    }

    public JSONObject om() {
        return this.oy;
    }

    public void oq(String str) {
        this.tj = str;
    }

    public String ov() {
        return this.qe;
    }

    public String oy() {
        return this.gr;
    }

    public void p(int i6) {
        this.f25625y = i6;
    }

    public int px() {
        List<j> list = this.nt;
        if (list == null) {
            return 0;
        }
        for (j jVar : list) {
            if ("translate".equals(jVar.g()) && jVar.ae() < 0) {
                return -jVar.ae();
            }
        }
        return 0;
    }

    public boolean pz() {
        return this.ry;
    }

    public int q() {
        return this.ol;
    }

    public int qa() {
        return this.zz;
    }

    public boolean qb() {
        return this.hh;
    }

    public List<j> qe() {
        return this.nt;
    }

    public void qg() {
        j(this, this.ll);
    }

    public int qo() {
        return this.f25625y;
    }

    public void qv(String str) {
        this.f25606f = str;
    }

    public void r(int i6) {
        this.na = i6;
    }

    public boolean rh() {
        return this.uf;
    }

    public int ri() {
        return this.xp;
    }

    public void rn(int i6) {
        this.ki = i6;
    }

    public JSONObject rr() {
        return this.f25611k;
    }

    public void rs() {
        j(this, this.oy);
    }

    public boolean ry() {
        return this.qb;
    }

    public void s(int i6) {
        this.zs = i6;
    }

    public boolean sm() {
        return this.hl;
    }

    public int st() {
        return this.ff;
    }

    public String t() {
        return this.nu;
    }

    public void tj(int i6) {
        this.rr = i6;
    }

    public boolean tk() {
        return this.uq;
    }

    public void tl(float f6) {
        this.f25607g = f6;
    }

    public int u() {
        return this.rs;
    }

    public String uc() {
        return this.wf;
    }

    public void uf(int i6) {
        this.f25621u = i6;
    }

    public void up(int i6) {
        this.yl = i6;
    }

    public boolean uq() {
        return this.om;
    }

    public void v(int i6) {
        this.pz = i6;
    }

    public void vl(String str) {
        this.f25622v = str;
    }

    public void w(String str) {
        this.wq = str;
    }

    public int wf() {
        return this.kc;
    }

    public int wi() {
        return this.ki;
    }

    public boolean wo() {
        return this.ov;
    }

    public void wq(int i6) {
        this.f25620t = i6;
    }

    public void ws(String str) {
        this.f25608h = str;
    }

    public void x(int i6) {
        this.xp = i6;
    }

    public int xp() {
        return this.rr;
    }

    public int xq() {
        return this.f25602b;
    }

    public void xt(int i6) {
        this.tk = i6;
    }

    public int xw() {
        return this.uc;
    }

    public int y() {
        return this.pz;
    }

    public int ya() {
        return this.f25626z;
    }

    public String yb() {
        return ("flip".equals(this.el) || "slide".equals(this.el)) ? this.el : "slide";
    }

    public int yl() {
        return this.et;
    }

    public int z() {
        return this.gx;
    }

    public String zs() {
        return this.jl;
    }

    public boolean zz() {
        return this.ya;
    }

    public void a(String str) {
        this.el = str;
    }

    public void ae(String str) {
        this.f25623w = str;
    }

    public void av(int i6) {
        this.f25602b = i6;
    }

    public void az(int i6) {
        this.f25626z = i6;
    }

    public void ch(String str) {
        this.jl = str;
    }

    public void cw(float f6) {
        this.cw = f6;
    }

    public void f(String str) {
        this.wf = str;
    }

    public void g(String str) {
        this.kt = str;
    }

    public void i(int i6) {
        this.ff = i6;
    }

    public void jy(int i6) {
        this.nd = i6;
    }

    public void kt(int i6) {
        this.aq = i6;
    }

    public void l(int i6) {
        this.rs = i6;
    }

    public void m(float f6) {
        this.ae = f6;
    }

    public void mi(int i6) {
        this.kc = i6;
    }

    public void oq(int i6) {
        this.f25603c = i6;
    }

    public void qv(int i6) {
        this.gx = i6;
    }

    public void r(float f6) {
        this.f25618r = f6;
    }

    public void s(String str) {
        this.ig = str;
    }

    public void tj(String str) {
        this.qa = str;
    }

    public void tl(String str) {
        this.mi = str;
    }

    public void up(float f6) {
        this.f25613m = f6;
    }

    public void v(String str) {
        this.nu = str;
    }

    public void vl(int i6) {
        this.f25614n = i6;
    }

    public void w(int i6) {
        this.zz = i6;
    }

    public void ws(int i6) {
        this.ol = i6;
    }

    public void x(String str) {
        this.gr = str;
    }

    public void xt(float f6) {
        this.xt = f6;
    }

    public void ae(int i6) {
        this.f25619s = i6;
    }

    public void av(boolean z5) {
        this.ik = z5;
    }

    public void az(boolean z5) {
        this.uq = z5;
    }

    public void cw(double d6) {
        this.vl = d6;
    }

    public void g(int i6) {
        this.ed = i6;
    }

    public void i(boolean z5) {
        this.ka = z5;
    }

    public void jy(boolean z5) {
        this.ov = z5;
    }

    public void m(String str) {
        this.f25609i = str;
    }

    public void mi(boolean z5) {
        this.lx = z5;
    }

    public void oq(boolean z5) {
        this.sm = z5;
    }

    public void qv(boolean z5) {
        this.ry = z5;
    }

    public void r(String str) {
        this.az = str;
    }

    public void tl(int i6) {
        this.f25601a = i6;
    }

    public void up(String str) {
        this.av = str;
    }

    public void vl(boolean z5) {
        this.om = z5;
    }

    public void w(boolean z5) {
        this.wo = z5;
    }

    public void ws(boolean z5) {
        this.px = z5;
    }

    public void xt(boolean z5) {
        this.up = z5;
    }

    public void ae(boolean z5) {
        this.f25617q = z5;
    }

    public void cw(String str) {
        this.ws = str;
    }

    public void g(boolean z5) {
        this.ya = z5;
    }

    public void m(double d6) {
        this.rh = d6;
    }

    public void r(double d6) {
        this.f25612l = d6;
    }

    public void tl(boolean z5) {
        this.qb = z5;
    }

    public void up(double d6) {
        this.f25616p = d6;
    }

    public void xt(double d6) {
        this.qv = d6;
    }

    public void cw(boolean z5) {
        this.ch = z5;
    }

    public void m(boolean z5) {
        this.hl = z5;
    }

    public void r(boolean z5) {
        this.uf = z5;
    }

    public void up(boolean z5) {
        this.hh = z5;
    }

    public void xt(String str) {
        this.jy = str;
    }

    public void cw(JSONObject jSONObject) {
        this.ll = jSONObject;
    }

    public void r(JSONObject jSONObject) {
        this.oy = jSONObject;
    }

    public void up(JSONObject jSONObject) {
        this.xw = jSONObject;
    }

    public void xt(JSONObject jSONObject) {
        this.f25611k = jSONObject;
    }

    public void xt(List<String> list) {
        this.hu = list;
    }

    public boolean j() {
        return this.ln;
    }

    public void j(boolean z5) {
        this.ln = z5;
    }

    public void j(int i6) {
        this.wi = i6;
    }

    public void j(double d6) {
        this.qo = d6;
    }

    public void j(String str) {
        this.fp = str;
    }

    public void j(float f6) {
        this.f25610j = f6;
    }

    public void j(List<j> list) {
        this.nt = list;
    }

    public void j(long j6) {
        this.yb = j6;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void j(m mVar, JSONObject jSONObject) {
        if (mVar == null || jSONObject == null) {
            return;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            next.getClass();
            char c6 = 65535;
            switch (next.hashCode()) {
                case -2067713583:
                    if (next.equals("isShowBgControl")) {
                        c6 = 0;
                        break;
                    }
                    break;
                case -1965619659:
                    if (next.equals("clickArea")) {
                        c6 = 1;
                        break;
                    }
                    break;
                case -1912831834:
                    if (next.equals("triggerSlideDirection")) {
                        c6 = 2;
                        break;
                    }
                    break;
                case -1885934767:
                    if (next.equals("bgImgUrl")) {
                        c6 = 3;
                        break;
                    }
                    break;
                case -1822062213:
                    if (next.equals("lineCount")) {
                        c6 = 4;
                        break;
                    }
                    break;
                case -1821293778:
                    if (next.equals("openPlayableLandingPage")) {
                        c6 = 5;
                        break;
                    }
                    break;
                case -1813937113:
                    if (next.equals("lineLimit")) {
                        c6 = 6;
                        break;
                    }
                    break;
                case -1578250488:
                    if (next.equals("interactBgColor")) {
                        c6 = 7;
                        break;
                    }
                    break;
                case -1501175880:
                    if (next.equals("paddingLeft")) {
                        c6 = '\b';
                        break;
                    }
                    break;
                case -1422965251:
                    if (next.equals("adType")) {
                        c6 = '\t';
                        break;
                    }
                    break;
                case -1383228885:
                    if (next.equals("bottom")) {
                        c6 = '\n';
                        break;
                    }
                    break;
                case -1224696685:
                    if (next.equals("fontFamily")) {
                        c6 = 11;
                        break;
                    }
                    break;
                case -1221029593:
                    if (next.equals("height")) {
                        c6 = '\f';
                        break;
                    }
                    break;
                case -1065511464:
                    if (next.equals("textAlign")) {
                        c6 = StringUtil.CARRIAGE_RETURN;
                        break;
                    }
                    break;
                case -1063257157:
                    if (next.equals("alignItems")) {
                        c6 = 14;
                        break;
                    }
                    break;
                case -1046708884:
                    if (next.equals("interactValidate")) {
                        c6 = 15;
                        break;
                    }
                    break;
                case -1044792121:
                    if (next.equals("marginTop")) {
                        c6 = 16;
                        break;
                    }
                    break;
                case -1019884910:
                    if (next.equals("useBottom")) {
                        c6 = 17;
                        break;
                    }
                    break;
                case -1005195314:
                    if (next.equals("triggerSlideMinDistance")) {
                        c6 = 18;
                        break;
                    }
                    break;
                case -962590849:
                    if (next.equals("direction")) {
                        c6 = 19;
                        break;
                    }
                    break;
                case -912366651:
                    if (next.equals("tagMaxCount")) {
                        c6 = 20;
                        break;
                    }
                    break;
                case -848877971:
                    if (next.equals("interactHiddenTime")) {
                        c6 = 21;
                        break;
                    }
                    break;
                case -836058546:
                    if (next.equals("useTop")) {
                        c6 = 22;
                        break;
                    }
                    break;
                case -734428249:
                    if (next.equals("fontWeight")) {
                        c6 = 23;
                        break;
                    }
                    break;
                case -731417480:
                    if (next.equals("zIndex")) {
                        c6 = 24;
                        break;
                    }
                    break;
                case -709393864:
                    if (next.equals("timingStart")) {
                        c6 = 25;
                        break;
                    }
                    break;
                case -515807685:
                    if (next.equals("lineHeight")) {
                        c6 = JSONLexer.EOI;
                        break;
                    }
                    break;
                case -321658193:
                    if (next.equals("textFlowDuration")) {
                        c6 = 27;
                        break;
                    }
                    break;
                case -295409451:
                    if (next.equals("useRight")) {
                        c6 = 28;
                        break;
                    }
                    break;
                case -289173127:
                    if (next.equals("marginBottom")) {
                        c6 = 29;
                        break;
                    }
                    break;
                case -204859874:
                    if (next.equals("bgColor")) {
                        c6 = 30;
                        break;
                    }
                    break;
                case -191748762:
                    if (next.equals("isClickEventIntercept")) {
                        c6 = 31;
                        break;
                    }
                    break;
                case -148259282:
                    if (next.equals("useLeft")) {
                        c6 = ' ';
                        break;
                    }
                    break;
                case -51738487:
                    if (next.equals("widthMode")) {
                        c6 = '!';
                        break;
                    }
                    break;
                case 115029:
                    if (next.equals("top")) {
                        c6 = '\"';
                        break;
                    }
                    break;
                case 3076010:
                    if (next.equals("data")) {
                        c6 = '#';
                        break;
                    }
                    break;
                case 3317767:
                    if (next.equals(ScrollClickView.DIR_LEFT)) {
                        c6 = v0.f47959c;
                        break;
                    }
                    break;
                case 3327652:
                    if (next.equals("loop")) {
                        c6 = '%';
                        break;
                    }
                    break;
                case 90130308:
                    if (next.equals("paddingTop")) {
                        c6 = v0.f47960d;
                        break;
                    }
                    break;
                case 92903173:
                    if (next.equals("align")) {
                        c6 = '\'';
                        break;
                    }
                    break;
                case 94842723:
                    if (next.equals("color")) {
                        c6 = '(';
                        break;
                    }
                    break;
                case 108511772:
                    if (next.equals("right")) {
                        c6 = ')';
                        break;
                    }
                    break;
                case 113126854:
                    if (next.equals("width")) {
                        c6 = '*';
                        break;
                    }
                    break;
                case 164611121:
                    if (next.equals("timingEnd")) {
                        c6 = '+';
                        break;
                    }
                    break;
                case 202355100:
                    if (next.equals("paddingBottom")) {
                        c6 = StringUtil.COMMA;
                        break;
                    }
                    break;
                case 247204452:
                    if (next.equals("allowTextFlow")) {
                        c6 = '-';
                        break;
                    }
                    break;
                case 302841174:
                    if (next.equals("interactWontHide")) {
                        c6 = '.';
                        break;
                    }
                    break;
                case 365601008:
                    if (next.equals("fontSize")) {
                        c6 = '/';
                        break;
                    }
                    break;
                case 428975654:
                    if (next.equals("justifyVertical")) {
                        c6 = '0';
                        break;
                    }
                    break;
                case 439444041:
                    if (next.equals("interactVisibleTime")) {
                        c6 = '1';
                        break;
                    }
                    break;
                case 713848971:
                    if (next.equals("paddingRight")) {
                        c6 = '2';
                        break;
                    }
                    break;
                case 722830999:
                    if (next.equals("borderColor")) {
                        c6 = '3';
                        break;
                    }
                    break;
                case 737768677:
                    if (next.equals("borderStyle")) {
                        c6 = '4';
                        break;
                    }
                    break;
                case 747804969:
                    if (next.equals("position")) {
                        c6 = '5';
                        break;
                    }
                    break;
                case 791643104:
                    if (next.equals("isDataFixed")) {
                        c6 = '6';
                        break;
                    }
                    break;
                case 975087886:
                    if (next.equals("marginRight")) {
                        c6 = '7';
                        break;
                    }
                    break;
                case 1110826708:
                    if (next.equals("justifyHorizontal")) {
                        c6 = '8';
                        break;
                    }
                    break;
                case 1122368895:
                    if (next.equals("interactPosition")) {
                        c6 = '9';
                        break;
                    }
                    break;
                case 1188229042:
                    if (next.equals("lineFeed")) {
                        c6 = ':';
                        break;
                    }
                    break;
                case 1332036739:
                    if (next.equals("interactText")) {
                        c6 = ';';
                        break;
                    }
                    break;
                case 1332055696:
                    if (next.equals("interactType")) {
                        c6 = v0.f47961e;
                        break;
                    }
                    break;
                case 1349188574:
                    if (next.equals("borderRadius")) {
                        c6 = '=';
                        break;
                    }
                    break;
                case 1360828714:
                    if (next.equals("clickTigger")) {
                        c6 = v0.f47962f;
                        break;
                    }
                    break;
                case 1490178922:
                    if (next.equals("heightMode")) {
                        c6 = '?';
                        break;
                    }
                    break;
                case 1761274325:
                    if (next.equals("textFlowType")) {
                        c6 = '@';
                        break;
                    }
                    break;
                case 1824903757:
                    if (next.equals("borderSize")) {
                        c6 = 'A';
                        break;
                    }
                    break;
                case 1970934485:
                    if (next.equals("marginLeft")) {
                        c6 = 'B';
                        break;
                    }
                    break;
                case 2111078717:
                    if (next.equals("letterSpacing")) {
                        c6 = 'C';
                        break;
                    }
                    break;
            }
            switch (c6) {
                case 0:
                    mVar.cw(jSONObject.optBoolean(next, false));
                    break;
                case 1:
                    mVar.az(jSONObject.optString(next));
                    break;
                case 2:
                    mVar.s(jSONObject.optString(next));
                    break;
                case 3:
                    mVar.ae(jSONObject.optString(next));
                    break;
                case 4:
                    mVar.g(jSONObject.optInt(next));
                    break;
                case 5:
                    mVar.w(jSONObject.optBoolean(next));
                    break;
                case 6:
                    mVar.m(jSONObject.optBoolean(next));
                    break;
                case 7:
                    mVar.jy(jSONObject.optString(next));
                    break;
                case '\b':
                    mVar.m((float) jSONObject.optDouble(next));
                    break;
                case '\t':
                    mVar.xt(jSONObject.optString(next));
                    break;
                case '\n':
                    mVar.v(jSONObject.optInt(next));
                    break;
                case 11:
                    mVar.cw(jSONObject.optString(next));
                    break;
                case '\f':
                    mVar.cw((float) jSONObject.optDouble(next));
                    break;
                case '\r':
                    mVar.r(jSONObject.optString(next));
                    break;
                case 14:
                    mVar.tj(jSONObject.optString(next));
                    break;
                case 15:
                    mVar.xt(jSONObject.optBoolean(next));
                    break;
                case 16:
                    mVar.oq(jSONObject.optInt(next));
                    break;
                case 17:
                    mVar.oq(jSONObject.optBoolean(next));
                    break;
                case 18:
                    mVar.j(jSONObject.optLong(next));
                    break;
                case 19:
                    mVar.f(jSONObject.optString(next));
                    break;
                case 20:
                    mVar.i(jSONObject.optInt(next));
                    break;
                case 21:
                    mVar.ch(jSONObject.optInt(next));
                    break;
                case 22:
                    mVar.g(jSONObject.optBoolean(next));
                    break;
                case 23:
                    mVar.az(jSONObject.optInt(next));
                    break;
                case 24:
                    mVar.x(jSONObject.optInt(next));
                    break;
                case 25:
                    mVar.xt(jSONObject.optDouble(next));
                    break;
                case 26:
                    mVar.m(jSONObject.optDouble(next));
                    break;
                case 27:
                    mVar.mi(jSONObject.optInt(next));
                    break;
                case 28:
                    mVar.tl(jSONObject.optBoolean(next));
                    break;
                case 29:
                    mVar.qv(jSONObject.optInt(next));
                    break;
                case 30:
                    mVar.m(jSONObject.optString(next));
                    break;
                case 31:
                    mVar.ws(jSONObject.optBoolean(next));
                    break;
                case ' ':
                    mVar.ae(jSONObject.optBoolean(next));
                    break;
                case '!':
                    mVar.qv(jSONObject.optString(next));
                    break;
                case '\"':
                    mVar.f(jSONObject.optInt(next));
                    break;
                case '#':
                    mVar.kt(jSONObject.optString(next));
                    break;
                case '$':
                    mVar.kt(jSONObject.optInt(next));
                    break;
                case '%':
                    mVar.j(jSONObject.optBoolean(next));
                    break;
                case '&':
                    mVar.tl((float) jSONObject.optDouble(next));
                    break;
                case '\'':
                    mVar.mi(jSONObject.optString(next));
                    break;
                case '(':
                    mVar.up(jSONObject.optString(next));
                    break;
                case ')':
                    mVar.tj(jSONObject.optInt(next));
                    break;
                case '*':
                    mVar.r((float) jSONObject.optDouble(next));
                    break;
                case '+':
                    mVar.cw(jSONObject.optDouble(next));
                    break;
                case ',':
                    mVar.up((float) jSONObject.optDouble(next));
                    break;
                case '-':
                    mVar.qv(jSONObject.optBoolean(next));
                    break;
                case '.':
                    mVar.ws(jSONObject.optBoolean(next));
                    break;
                case '/':
                    mVar.g((float) jSONObject.optDouble(next));
                    break;
                case '0':
                    mVar.w(jSONObject.optString(next));
                    break;
                case '1':
                    mVar.p(jSONObject.optInt(next));
                    break;
                case '2':
                    mVar.ae((float) jSONObject.optDouble(next));
                    break;
                case '3':
                    mVar.tl(jSONObject.optString(next));
                    break;
                case '4':
                    mVar.g(jSONObject.optString(next));
                    break;
                case '5':
                    mVar.av(jSONObject.optInt(next));
                    break;
                case '6':
                    mVar.up(jSONObject.optBoolean(next));
                    break;
                case '7':
                    mVar.jy(jSONObject.optInt(next));
                    break;
                case '8':
                    mVar.i(jSONObject.optString(next));
                    break;
                case '9':
                    JSONObject optJSONObject = jSONObject.optJSONObject(next);
                    if (optJSONObject == null) {
                        break;
                    } else {
                        mVar.ae(optJSONObject.optInt("translateY", 0));
                        mVar.tl(optJSONObject.optInt("translateX", 0));
                        mVar.r(optJSONObject.optDouble("scaleX", 0.0d));
                        mVar.up(optJSONObject.optDouble("scaleY", 0.0d));
                        break;
                    }
                case ':':
                    mVar.r(jSONObject.optBoolean(next));
                    break;
                case ';':
                    mVar.vl(jSONObject.optString(next));
                    break;
                case '<':
                    mVar.ws(jSONObject.optString(next));
                    break;
                case '=':
                    mVar.j((float) jSONObject.optDouble(next));
                    break;
                case '>':
                    mVar.av(jSONObject.optString(next));
                    break;
                case '?':
                    mVar.oq(jSONObject.optString(next));
                    break;
                case '@':
                    mVar.w(jSONObject.optInt(next));
                    break;
                case 'A':
                    mVar.xt((float) jSONObject.optDouble(next));
                    break;
                case 'B':
                    mVar.vl(jSONObject.optInt(next));
                    break;
                case 'C':
                    mVar.ws(jSONObject.optInt(next));
                    break;
            }
        }
    }
}
