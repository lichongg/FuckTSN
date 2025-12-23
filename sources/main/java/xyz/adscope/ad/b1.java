package xyz.adscope.ad;

import java.util.List;
import xyz.adscope.ad.i4;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.BidModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.MediaModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.AdModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.DisplayModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.ext.DisplayExtModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.NativeModel;
import xyz.adscope.ad.publish.ASNPInitConfig;
import xyz.adscope.common.v2.model.IDeepCopyModel;
import xyz.adscope.common.v2.tool.str.SerialUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class b1 implements IDeepCopyModel {

    /* renamed from: a, reason: collision with root package name */
    private final int f54838a;

    /* renamed from: b, reason: collision with root package name */
    private final String f54839b;

    /* renamed from: c, reason: collision with root package name */
    private final String f54840c;

    /* renamed from: d, reason: collision with root package name */
    private long f54841d;

    /* renamed from: e, reason: collision with root package name */
    private String f54842e;

    /* renamed from: f, reason: collision with root package name */
    private final c f54843f;

    /* renamed from: g, reason: collision with root package name */
    private final long f54844g;

    /* renamed from: h, reason: collision with root package name */
    private String f54845h;

    /* renamed from: i, reason: collision with root package name */
    private long f54846i;

    /* renamed from: j, reason: collision with root package name */
    private long f54847j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f54848k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f54849l;

    /* renamed from: m, reason: collision with root package name */
    private String f54850m;

    /* renamed from: n, reason: collision with root package name */
    private String f54851n;

    /* renamed from: o, reason: collision with root package name */
    private String f54852o;

    /* renamed from: p, reason: collision with root package name */
    private String f54853p;

    /* renamed from: q, reason: collision with root package name */
    private String f54854q;

    /* renamed from: r, reason: collision with root package name */
    private y0 f54855r;

    /* renamed from: s, reason: collision with root package name */
    private double f54856s;

    /* renamed from: t, reason: collision with root package name */
    private String f54857t;

    /* renamed from: u, reason: collision with root package name */
    private int f54858u;

    /* renamed from: v, reason: collision with root package name */
    private String f54859v;

    /* renamed from: w, reason: collision with root package name */
    private String f54860w;

    /* renamed from: x, reason: collision with root package name */
    private String f54861x;

    /* renamed from: y, reason: collision with root package name */
    private i4 f54862y;

    /* renamed from: z, reason: collision with root package name */
    private int f54863z;

    public b1(a2 a2Var) {
        this.f54841d = -1L;
        this.f54846i = 0L;
        this.f54847j = 0L;
        this.f54848k = false;
        this.f54849l = false;
        this.f54858u = -1;
        this.f54843f = a2Var.getAdType();
        this.f54840c = a2Var.getApiKey();
        this.f54839b = a2Var.getSpaceID();
        this.f54838a = a2Var.getAdCount();
        this.f54844g = a2Var.getTimeoutMillion();
        this.f54842e = SerialUtil.generateAdRequestSessionID();
    }

    public void D() {
        this.f54848k = true;
    }

    public void E() {
        this.f54849l = true;
    }

    public void a(long j6) {
        this.f54841d = j6;
    }

    public c b() {
        return this.f54843f;
    }

    public void c(String str) {
        this.f54845h = str;
    }

    public void d(String str) {
        this.f54860w = str;
    }

    public void e(String str) {
        this.f54842e = str;
    }

    public boolean A() {
        return this.f54849l;
    }

    public void B() {
        if (this.f54847j == 0) {
            this.f54847j = System.currentTimeMillis();
        }
    }

    public void C() {
        if (this.f54846i == 0) {
            this.f54846i = System.currentTimeMillis();
        }
    }

    @Override // xyz.adscope.common.v2.model.IDeepCopyModel
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public b1 deepCopy() {
        return new b1(this);
    }

    public void b(String str) {
        this.f54852o = str;
    }

    public String c() {
        return this.f54861x;
    }

    public int d() {
        return this.f54863z;
    }

    public String e() {
        return this.f54852o;
    }

    public String f() {
        return this.f54853p;
    }

    public String g() {
        return this.f54851n;
    }

    public long h() {
        if (this.f54841d != -1) {
            return System.currentTimeMillis() - this.f54841d;
        }
        return -1L;
    }

    public String i() {
        return this.f54857t;
    }

    public int j() {
        y0 y0Var = this.f54855r;
        if (y0Var != null) {
            return y0Var.b();
        }
        return -1;
    }

    public String k() {
        y0 y0Var = this.f54855r;
        return y0Var != null ? y0Var.c() : "";
    }

    public long l() {
        return this.f54847j;
    }

    public int m() {
        return this.f54858u;
    }

    public String n() {
        return this.f54850m;
    }

    public long o() {
        return this.f54844g;
    }

    public String p() {
        return this.f54854q;
    }

    public double q() {
        return this.f54856s;
    }

    public String r() {
        return this.f54845h;
    }

    public int s() {
        return this.f54838a;
    }

    public String t() {
        return this.f54842e;
    }

    public String u() {
        return this.f54859v;
    }

    public long v() {
        return this.f54846i;
    }

    public String w() {
        return this.f54839b;
    }

    public i4.b x() {
        i4 i4Var = this.f54862y;
        if (i4Var != null) {
            return i4Var.a();
        }
        return null;
    }

    public String y() {
        return this.f54860w;
    }

    public boolean z() {
        return this.f54848k;
    }

    private void b(BidModel bidModel) {
        AdModel a6;
        if (bidModel != null) {
            this.f54856s = bidModel.e();
            this.f54857t = bidModel.a();
            MediaModel d6 = bidModel.d();
            if (d6 == null || (a6 = d6.a()) == null) {
                return;
            }
            this.f54854q = a6.c();
            DisplayModel b6 = a6.b();
            if (b6 != null) {
                this.f54853p = b6.c();
                DisplayExtModel b7 = b6.b();
                if (b7 != null) {
                    this.f54850m = b7.a();
                }
                NativeModel d7 = b6.d();
                if (d7 != null) {
                    this.f54859v = d7.f();
                }
            }
        }
    }

    public void a(BidModel bidModel) {
        b(bidModel);
    }

    public void a(i4 i4Var) {
        this.f54862y = i4Var;
    }

    public void a(ASNPInitConfig aSNPInitConfig) {
        String str;
        List<String> currency = aSNPInitConfig.getCurrency();
        if (currency != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (String str2 : currency) {
                sb.append("\"");
                sb.append(str2);
                sb.append("\"");
                sb.append(",");
            }
            sb.replace(sb.length() - 1, sb.length(), "]");
            str = sb.toString();
        } else {
            str = "[\"CNY\"]";
        }
        this.f54851n = str;
    }

    private b1(b1 b1Var) {
        this.f54841d = -1L;
        this.f54846i = 0L;
        this.f54847j = 0L;
        this.f54848k = false;
        this.f54849l = false;
        this.f54858u = -1;
        this.f54843f = b1Var.f54843f;
        this.f54844g = b1Var.f54844g;
        this.f54838a = b1Var.f54838a;
        this.f54839b = b1Var.f54839b;
        this.f54840c = b1Var.f54840c;
        this.f54841d = b1Var.f54841d;
        this.f54842e = b1Var.f54842e;
        this.f54845h = b1Var.f54845h;
        this.f54846i = b1Var.f54846i;
        this.f54847j = b1Var.f54847j;
        this.f54848k = b1Var.f54848k;
        this.f54849l = b1Var.f54849l;
        this.f54850m = b1Var.f54850m;
        this.f54851n = b1Var.f54851n;
        this.f54852o = b1Var.f54852o;
        this.f54853p = b1Var.f54853p;
        this.f54854q = b1Var.f54854q;
        this.f54855r = b1Var.f54855r;
        this.f54856s = b1Var.f54856s;
        this.f54857t = b1Var.f54857t;
        this.f54858u = b1Var.f54858u;
        this.f54859v = b1Var.f54859v;
        this.f54860w = b1Var.f54860w;
        this.f54861x = b1Var.f54861x;
        this.f54862y = b1Var.f54862y;
        this.f54863z = b1Var.f54863z;
    }

    public void a(y0 y0Var) {
        this.f54855r = y0Var;
    }

    public void b(int i6) {
        this.f54858u = i6;
    }

    public void a(String str) {
        this.f54861x = str;
    }

    public void a(int i6) {
        this.f54863z = i6;
    }
}
