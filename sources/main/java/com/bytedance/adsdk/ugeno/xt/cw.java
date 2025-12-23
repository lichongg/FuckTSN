package com.bytedance.adsdk.ugeno.xt;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.activity.k;
import com.alibaba.fastjson.parser.JSONLexer;
import com.bytedance.adsdk.ugeno.cw.ae;
import com.bytedance.adsdk.ugeno.cw.av;
import com.bytedance.adsdk.ugeno.cw.f;
import com.bytedance.adsdk.ugeno.cw.g;
import com.bytedance.adsdk.ugeno.cw.i;
import com.bytedance.adsdk.ugeno.cw.jy;
import com.bytedance.adsdk.ugeno.cw.kt;
import com.bytedance.adsdk.ugeno.cw.oq;
import com.bytedance.adsdk.ugeno.cw.w;
import com.bytedance.adsdk.ugeno.cw.ws;
import com.bytedance.adsdk.ugeno.cw.xt.m;
import com.bytedance.adsdk.ugeno.cw.xt.r;
import com.bytedance.adsdk.ugeno.cw.xt.up;
import com.bytedance.adsdk.ugeno.j;
import com.bytedance.adsdk.ugeno.m.j;
import com.bytedance.adsdk.ugeno.m.tl;
import com.bytedance.adsdk.ugeno.up.g;
import com.bytedance.adsdk.ugeno.xt.j;
import com.bytedance.sdk.component.utils.vl;
import com.umeng.analytics.pro.d;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import io.netty.util.internal.StringUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.text.v0;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.amps.common.AMPSConstants;

/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class cw<T extends View> implements View.OnTouchListener, com.bytedance.adsdk.ugeno.cw, w.j, w.xt {

    /* renamed from: a, reason: collision with root package name */
    protected float f23855a;
    protected j<ViewGroup> ae;
    protected com.bytedance.adsdk.ugeno.j.j aq;
    protected float av;
    protected float az;

    /* renamed from: b, reason: collision with root package name */
    protected float f23856b;

    /* renamed from: c, reason: collision with root package name */
    protected String f23857c;
    protected boolean ch;
    protected JSONObject cw;

    /* renamed from: d, reason: collision with root package name */
    private boolean f23858d;
    private boolean dj;

    /* renamed from: e, reason: collision with root package name */
    protected boolean f23859e;
    protected int ed;
    private boolean el;

    @Deprecated
    private m et;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f23860f;
    protected int ff;
    private boolean fp;
    private GradientDrawable fx;

    /* renamed from: g, reason: collision with root package name */
    protected ws f23861g;
    protected boolean gq;
    private com.bytedance.adsdk.ugeno.cw.j gr;
    protected ImageView.ScaleType gx;

    /* renamed from: h, reason: collision with root package name */
    protected float f23862h;
    protected float hh;
    protected float hl;
    private boolean hu;
    private com.bytedance.adsdk.ugeno.up.j.j hw;

    /* renamed from: i, reason: collision with root package name */
    protected float f23863i;
    private boolean ig;
    protected ae ik;
    protected float im;

    /* renamed from: j, reason: collision with root package name */
    private boolean f23864j;
    private boolean ja;
    private boolean jl;
    protected float jy;

    /* renamed from: k, reason: collision with root package name */
    protected String f23865k;
    protected Map<Integer, av> ka;
    protected ViewGroup.LayoutParams kc;
    protected oq ki;
    private boolean kk;
    protected float kt;

    /* renamed from: l, reason: collision with root package name */
    protected float f23866l;
    protected boolean la;
    private boolean ll;
    protected float ln;
    private boolean lx;

    /* renamed from: m, reason: collision with root package name */
    protected j<ViewGroup> f23867m;
    protected float mi;

    /* renamed from: n, reason: collision with root package name */
    protected float f23868n;
    private String na;
    protected boolean nd;
    protected float nt;

    @Deprecated
    private com.bytedance.adsdk.ugeno.cw.xt.cw nu;

    /* renamed from: o, reason: collision with root package name */
    private boolean f23869o;
    protected float ol;

    @Deprecated
    private up om;
    protected boolean oq;

    @Deprecated
    private com.bytedance.adsdk.ugeno.cw.xt.xt ov;
    private boolean oy;

    /* renamed from: p, reason: collision with root package name */
    protected float f23870p;
    private boolean px;
    protected float pz;

    /* renamed from: q, reason: collision with root package name */
    protected boolean f23871q;
    protected float qa;
    protected boolean qb;
    private boolean qe;
    private jy qg;
    protected g qo;
    protected String qv;

    /* renamed from: r, reason: collision with root package name */
    protected JSONObject f23872r;
    protected boolean rh;
    protected float ri;
    protected boolean rn;
    protected com.bytedance.adsdk.ugeno.j.m rr;
    private String rs;
    protected float ry;

    /* renamed from: s, reason: collision with root package name */
    protected float f23873s;
    private float sf;
    protected float sm;
    protected float st;

    /* renamed from: t, reason: collision with root package name */
    protected w f23874t;
    protected float tj;
    private boolean tk;
    protected g.j tl;

    /* renamed from: u, reason: collision with root package name */
    protected boolean f23875u;
    protected float uc;
    protected boolean uf;
    protected T up;
    protected kt uq;

    /* renamed from: v, reason: collision with root package name */
    protected boolean f23876v;
    protected String vl;

    /* renamed from: w, reason: collision with root package name */
    protected float f23877w;
    protected float wf;
    private boolean wi;
    protected j.C0322j wo;
    protected boolean wq;
    protected float ws;

    /* renamed from: x, reason: collision with root package name */
    protected boolean f23878x;
    protected float xp;
    protected int xq;
    protected Context xt;
    private boolean xw;

    /* renamed from: y, reason: collision with root package name */
    protected float f23879y;
    protected boolean ya;
    private f yb;
    private boolean yl;
    private JSONObject ym;

    /* renamed from: z, reason: collision with root package name */
    protected float f23880z;
    private long zk;

    @Deprecated
    private r.j zs;
    protected boolean zz;

    public cw(Context context) {
        this(context, null);
    }

    private void ae() {
        if (this.f23864j) {
            this.up.setTranslationX(this.pz);
        }
        if (this.ll) {
            this.up.setTranslationY(this.qa);
        }
        if (this.oy) {
            this.up.setScaleX(this.ln);
        }
        if (this.yl) {
            this.up.setScaleY(this.xp);
        }
        if (this.qe) {
            this.up.setRotation(this.im);
        }
        if (this.px) {
            this.up.setRotationX(this.f23879y);
        }
        if (this.xw) {
            this.up.setRotationY(-this.nt);
        }
        if (this.f23858d) {
            this.up.setAlpha(this.ri);
        }
        float f6 = this.uc;
        if (f6 != 0.0f) {
            this.up.setRotation(f6);
        }
        if (this.qe || this.px || this.xw) {
            this.up.setCameraDistance(10000.0f);
        }
    }

    @Deprecated
    private void tl() {
        r r5;
        this.up.setVisibility(this.ff);
        float f6 = this.uc;
        if (f6 != 0.0f) {
            this.up.setRotation(f6);
        }
        g.j jVar = this.tl;
        if (jVar != null && TextUtils.isEmpty(jVar.xt())) {
            this.up.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.adsdk.ugeno.xt.cw.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    cw cwVar = cw.this;
                    if (cwVar.ki == null || !cwVar.fp) {
                        return;
                    }
                    cw cwVar2 = cw.this;
                    cwVar2.ki.j(cwVar2);
                }
            });
        } else if (j(1) && !this.jl) {
            this.up.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.adsdk.ugeno.xt.cw.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    cw cwVar = cw.this;
                    if (cwVar.f23874t == null || !cwVar.fp) {
                        return;
                    }
                    cw cwVar2 = cw.this;
                    w wVar = cwVar2.f23874t;
                    av avVar = cwVar2.ka.get(1);
                    cw cwVar3 = cw.this;
                    wVar.j(avVar, cwVar3, cwVar3);
                }
            });
        }
        if (this.f23874t != null && j(4)) {
            if (j(1)) {
                this.ig = true;
                this.om = new up(this.xt, this.ka.get(4), this.ka.get(1), this.ig, q());
            } else {
                this.om = new up(this.xt, this.ka.get(4), this.ig, q());
            }
        }
        if (this.f23874t != null && j(1) && this.jl) {
            this.nu = new com.bytedance.adsdk.ugeno.cw.xt.cw(this.xt, this.ka.get(1));
        }
        qb();
        if (this.f23874t != null && j(3) && (r5 = com.bytedance.adsdk.ugeno.r.j().r()) != null) {
            r.j jVar2 = this.zs;
            if (jVar2 != null) {
                jVar2.xt();
            }
            r.j j6 = r5.j(this.xt, this);
            this.zs = j6;
            j6.j(this.sf);
            this.zs.j();
            this.zs.j(new r.xt() { // from class: com.bytedance.adsdk.ugeno.xt.cw.3
                @Override // com.bytedance.adsdk.ugeno.cw.xt.r.xt
                public void j(int i6) {
                    cw cwVar;
                    w wVar;
                    cw.this.zs.xt();
                    if (cw.this.up.isShown() && (wVar = (cwVar = cw.this).f23874t) != null && i6 == 1) {
                        av avVar = cwVar.ka.get(3);
                        cw cwVar2 = cw.this;
                        wVar.j(avVar, cwVar2, cwVar2);
                    }
                }
            });
        }
        if (this.f23874t != null && j(9)) {
            m mVar = new m(this.xt, this.ka.get(9), this);
            this.et = mVar;
            mVar.j(this.f23874t);
        }
        if (j(10)) {
            com.bytedance.adsdk.ugeno.cw.xt.xt xtVar = new com.bytedance.adsdk.ugeno.cw.xt.xt(this.xt, this.ka.get(10), this);
            this.ov = xtVar;
            xtVar.j(this.f23874t);
        }
    }

    public T g() {
        return this.up;
    }

    public T j() {
        return null;
    }

    public void m() {
        jy jyVar = this.qg;
        if (jyVar != null) {
            jyVar.xt();
        }
        com.bytedance.adsdk.ugeno.j.j jVar = this.aq;
        if (jVar != null) {
            jVar.cw();
        }
        com.bytedance.adsdk.ugeno.j.m mVar = this.rr;
        if (mVar != null) {
            mVar.cw();
        }
        f fVar = this.yb;
        if (fVar != null) {
            fVar.up();
        }
        r.j jVar2 = this.zs;
        if (jVar2 != null) {
            jVar2.xt();
        }
    }

    public JSONObject oq() {
        return this.f23872r;
    }

    public void qv() {
        this.ja = this.f23872r.optBoolean("gesture_through_enable", false);
    }

    public void up() {
        com.bytedance.adsdk.ugeno.cw.j jVar = this.gr;
        if (jVar != null) {
            jy jyVar = new jy(this.up, jVar);
            this.qg = jyVar;
            jyVar.j();
        }
        com.bytedance.adsdk.ugeno.j.j jVar2 = this.aq;
        if (jVar2 != null) {
            jVar2.j();
        }
        com.bytedance.adsdk.ugeno.j.m mVar = this.rr;
        if (mVar != null) {
            mVar.xt();
        }
        f fVar = this.yb;
        if (fVar != null) {
            fVar.r();
        }
        com.bytedance.adsdk.ugeno.up.g gVar = this.qo;
        if (gVar != null) {
            gVar.up();
        }
        if (this.ov != null && j(10)) {
            this.ov.j();
        }
        if (this.et != null && j(9)) {
            this.et.j();
        }
        up upVar = this.om;
        if (upVar != null) {
            upVar.j();
        }
        this.zk = System.currentTimeMillis();
    }

    protected void vl() {
        this.up.setPadding((int) (this.gq ? this.f23855a : this.f23873s), (int) (this.wq ? this.f23870p : this.f23873s), (int) (this.rn ? this.f23866l : this.f23873s), (int) (this.uf ? this.f23862h : this.f23873s));
    }

    public void xt(JSONObject jSONObject) {
        this.f23872r = jSONObject;
        qv();
    }

    public cw(Context context, j<ViewGroup> jVar) {
        this.jy = -2.0f;
        this.ws = -2.0f;
        this.f23865k = "solid";
        this.ff = 0;
        this.zz = true;
        this.st = 0.0f;
        this.pz = 0.0f;
        this.qa = 0.0f;
        this.wf = 1.0f;
        this.ln = 1.0f;
        this.xp = 1.0f;
        this.im = 0.0f;
        this.f23879y = 0.0f;
        this.nt = 0.0f;
        this.uc = 0.0f;
        this.ri = 1.0f;
        this.wi = true;
        this.fp = true;
        this.dj = false;
        this.kk = false;
        this.ja = false;
        this.sf = 12.0f;
        this.xt = context;
        this.f23867m = jVar;
        this.ka = new HashMap();
        this.fx = new GradientDrawable();
        this.up = j();
    }

    private void qb() {
        av avVar;
        if (this.f23874t == null || !j(18) || (avVar = this.ka.get(18)) == null) {
            return;
        }
        JSONObject cw = avVar.cw();
        if (cw != null) {
            try {
                cw.put("rotateZ", com.bytedance.adsdk.ugeno.r.xt.j(cw.optString("rotateZ"), this.f23872r));
            } catch (JSONException unused) {
            }
        }
        this.f23874t.j(avVar, this, this);
    }

    private ImageView.ScaleType qv(String str) {
        str.getClass();
        switch (str) {
            case "center":
                this.gx = ImageView.ScaleType.CENTER;
                break;
            case "fit":
                this.gx = ImageView.ScaleType.FIT_CENTER;
                break;
            case "crop":
                this.gx = ImageView.ScaleType.CENTER_CROP;
                break;
            default:
                this.gx = ImageView.ScaleType.FIT_XY;
                break;
        }
        return this.gx;
    }

    private void sm() {
        if (TextUtils.equals("dashed", this.f23865k)) {
            GradientDrawable gradientDrawable = this.fx;
            float f6 = this.sm;
            gradientDrawable.setStroke((int) f6, this.xq, 3.0f * f6, f6);
        } else {
            if (!TextUtils.equals("dotted", this.f23865k)) {
                this.fx.setStroke((int) this.sm, this.xq);
                return;
            }
            GradientDrawable gradientDrawable2 = this.fx;
            float f7 = this.sm;
            gradientDrawable2.setStroke((int) f7, this.xq, f7 / 2.0f, f7);
        }
    }

    private void xq() {
        float f6 = this.f23859e ? this.hh : this.ol;
        float f7 = this.f23871q ? this.hl : this.ol;
        float f8 = this.qb ? this.f23880z : this.ol;
        float f9 = this.ya ? this.f23856b : this.ol;
        this.fx.setCornerRadii(new float[]{f6, f6, f7, f7, f9, f9, f8, f8});
    }

    private void ya() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.qv);
        this.up.setContentDescription(sb);
    }

    public ViewGroup.LayoutParams a() {
        return this.kc;
    }

    public float av() {
        return this.xp;
    }

    public float az() {
        return this.ln;
    }

    public float b() {
        T t5 = this.up;
        if (t5 instanceof com.bytedance.adsdk.ugeno.j.ae) {
            return ((com.bytedance.adsdk.ugeno.j.ae) t5).getRubIn();
        }
        return 0.0f;
    }

    public int c() {
        return this.ed;
    }

    protected void ch() {
        BitmapDrawable bitmapDrawable;
        BitmapDrawable bitmapDrawable2;
        if (TextUtils.isEmpty(this.f23857c)) {
            if (this.f23875u) {
                j(this.wo);
                return;
            } else {
                this.fx.setColor(this.ed);
                cw(this.ed);
                return;
            }
        }
        if (!this.f23857c.startsWith("local://")) {
            s();
            return;
        }
        String replace = this.f23857c.replace("local://", "");
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = this.nd ? Bitmap.Config.ARGB_4444 : Bitmap.Config.RGB_565;
            options.inPurgeable = true;
            options.inInputShareable = true;
            Bitmap decodeStream = BitmapFactory.decodeStream(this.xt.getResources().openRawResource(com.bytedance.adsdk.ugeno.m.r.xt(this.xt, replace)), null, options);
            if (this.nd) {
                Bitmap j6 = tl.j(this.xt, decodeStream, (int) this.f23868n);
                if (j6 != null) {
                    bitmapDrawable2 = new BitmapDrawable(this.xt.getResources(), j6);
                    j(bitmapDrawable2);
                }
                bitmapDrawable = new BitmapDrawable(this.xt.getResources(), decodeStream);
            } else {
                bitmapDrawable = new BitmapDrawable(this.xt.getResources(), decodeStream);
            }
            bitmapDrawable2 = bitmapDrawable;
            j(bitmapDrawable2);
        } catch (Throwable unused) {
        }
    }

    public void cw(JSONObject jSONObject) {
        this.cw = jSONObject;
    }

    public boolean e() {
        return this.tk;
    }

    public boolean ed() {
        return this.zz;
    }

    public w f() {
        return this.f23874t;
    }

    public List<com.bytedance.adsdk.ugeno.up.cw.xt> g(String str) {
        com.bytedance.adsdk.ugeno.up.g gVar;
        if (TextUtils.isEmpty(str) || (gVar = this.qo) == null) {
            return null;
        }
        return gVar.j(str);
    }

    public String gq() {
        return this.vl;
    }

    public com.bytedance.adsdk.ugeno.up.j.j gx() {
        return this.hw;
    }

    public j h() {
        return this.f23867m;
    }

    public float hh() {
        T t5 = this.up;
        if (t5 instanceof com.bytedance.adsdk.ugeno.j.ae) {
            return ((com.bytedance.adsdk.ugeno.j.ae) t5).getRipple();
        }
        return 0.0f;
    }

    public float hl() {
        T t5 = this.up;
        if (t5 instanceof com.bytedance.adsdk.ugeno.j.ae) {
            return ((com.bytedance.adsdk.ugeno.j.ae) t5).getStretch();
        }
        return 0.0f;
    }

    public float i() {
        return this.f23879y;
    }

    public void j(JSONObject jSONObject) {
        this.f23872r = jSONObject;
        qv();
        JSONObject jSONObject2 = this.cw;
        if (jSONObject2 == null) {
            return;
        }
        Iterator<String> keys = jSONObject2.keys();
        j.C0328j tl = k.a(this.f23867m) ? this.f23867m.tl() : null;
        while (keys.hasNext()) {
            String next = keys.next();
            String j6 = com.bytedance.adsdk.ugeno.r.xt.j(this.cw.optString(next), jSONObject);
            j(next, j6);
            if (tl != null) {
                tl.j(this.xt, next, j6);
            }
        }
        if (tl != null) {
            j(tl.j());
        }
        if (this.ym == null || this.f23872r == null) {
            return;
        }
        try {
            if (!p()) {
                this.f23872r.put("i18n", this.ym);
                return;
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("i18n", this.ym);
            this.f23872r.put("xNode", jSONObject3);
        } catch (JSONException e6) {
            vl.j(e6);
        }
    }

    public float jy() {
        return this.pz;
    }

    public float kt() {
        return this.ri;
    }

    public g.j l() {
        return this.tl;
    }

    public String la() {
        return this.qv;
    }

    public float mi() {
        return this.uc;
    }

    public boolean ol() {
        return this.ry > 0.0f;
    }

    public com.bytedance.adsdk.ugeno.j.j oq(String str) {
        com.bytedance.adsdk.ugeno.j.j jVar = this.aq;
        if (jVar != null && TextUtils.equals(str, jVar.up())) {
            return this.aq;
        }
        com.bytedance.adsdk.ugeno.j.m mVar = this.rr;
        if (mVar != null) {
            return mVar.j(str);
        }
        return null;
    }

    public boolean p() {
        return this.oq;
    }

    public boolean q() {
        return this.ja;
    }

    public cw<T> r(String str) {
        return j(str);
    }

    public void rh() {
        up upVar = this.om;
        if (upVar != null) {
            upVar.xt();
        }
    }

    public int rn() {
        return (int) this.jy;
    }

    protected void s() {
        ae aeVar = this.ik;
        if (aeVar != null) {
            aeVar.j();
        }
        com.bytedance.adsdk.ugeno.r.j().xt().j(this.f23861g, this.f23857c, new j.InterfaceC0320j() { // from class: com.bytedance.adsdk.ugeno.xt.cw.4
            @Override // com.bytedance.adsdk.ugeno.j.InterfaceC0320j
            public void j(final Bitmap bitmap) {
                if (bitmap == null) {
                    cw cwVar = cw.this;
                    ae aeVar2 = cwVar.ik;
                    if (aeVar2 != null) {
                        aeVar2.xt(cwVar, cwVar.f23857c);
                        return;
                    }
                    return;
                }
                cw cwVar2 = cw.this;
                ae aeVar3 = cwVar2.ik;
                if (aeVar3 != null) {
                    aeVar3.j(cwVar2, cwVar2.f23857c);
                }
                cw cwVar3 = cw.this;
                if (!cwVar3.nd) {
                    tl.j(new Runnable() { // from class: com.bytedance.adsdk.ugeno.xt.cw.4.2
                        @Override // java.lang.Runnable
                        public void run() {
                            cw.this.j(new BitmapDrawable(bitmap));
                        }
                    });
                    return;
                }
                final Bitmap j6 = tl.j(cwVar3.xt, bitmap, (int) cwVar3.f23868n);
                if (j6 != null) {
                    tl.j(new Runnable() { // from class: com.bytedance.adsdk.ugeno.xt.cw.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            cw.this.j(new BitmapDrawable(j6));
                        }
                    });
                }
            }
        });
    }

    public float tj() {
        return this.ol;
    }

    public ws uf() {
        return this.f23861g;
    }

    public long v() {
        return this.zk;
    }

    public float w() {
        return this.nt;
    }

    public int wq() {
        return (int) this.ws;
    }

    public float ws() {
        return this.qa;
    }

    public JSONObject x() {
        return this.cw;
    }

    public float z() {
        T t5 = this.up;
        if (t5 instanceof com.bytedance.adsdk.ugeno.j.ae) {
            return ((com.bytedance.adsdk.ugeno.j.ae) t5).getShine();
        }
        return 0.0f;
    }

    protected void cw(int i6) {
        this.fx.setShape(0);
        this.fx.setColor(i6);
        xq();
        sm();
        this.up.setBackground(this.fx);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        up upVar;
        w wVar;
        com.bytedance.adsdk.ugeno.cw.xt.cw cwVar;
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 || action == 3) {
                nd();
            }
        } else {
            n();
        }
        kt ktVar = this.uq;
        if (ktVar != null) {
            ktVar.j(this, motionEvent);
        }
        if (j(17) && motionEvent.getAction() == 0) {
            this.f23874t.j(this.ka.get(17), this, this);
        }
        if (j(1) && this.jl && (wVar = this.f23874t) != null && (cwVar = this.nu) != null) {
            return cwVar.j(wVar, this, motionEvent);
        }
        w wVar2 = this.f23874t;
        if (wVar2 != null && (upVar = this.om) != null) {
            return upVar.j(wVar2, this, motionEvent, q());
        }
        com.bytedance.adsdk.ugeno.up.g gVar = this.qo;
        if (gVar != null) {
            return gVar.j(motionEvent);
        }
        return false;
    }

    @Override // com.bytedance.adsdk.ugeno.cw
    public void r() {
        if (this.yb == null || this.hu) {
            return;
        }
        this.hu = true;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void xt() {
        ch();
        vl();
        xt(this.ff);
        ae();
        tl();
        com.bytedance.adsdk.ugeno.up.g gVar = this.qo;
        if (gVar != null) {
            gVar.j();
            this.qo.xt();
            this.qo.cw();
        }
        this.up.setOnTouchListener(this);
        ya();
        ViewGroup viewGroup = (ViewGroup) this.up.getParent();
        if (viewGroup != null) {
            viewGroup.setClipChildren(!this.wi);
        }
        com.bytedance.adsdk.ugeno.j.j jVar = this.aq;
        if (jVar != null) {
            jVar.r();
        }
        com.bytedance.adsdk.ugeno.j.m mVar = this.rr;
        if (mVar != null) {
            mVar.j();
        }
        com.bytedance.adsdk.ugeno.up.g gVar2 = this.qo;
        if (gVar2 != null) {
            gVar2.r();
        }
        if (this.f23874t == null || !j(22)) {
            return;
        }
        this.f23874t.j(this.ka.get(22), this, this);
    }

    private boolean vl(String str) {
        return TextUtils.isEmpty(str) || !TextUtils.equals(str, "hidden");
    }

    public void r(int i6) {
        if (p()) {
            T t5 = this.up;
            if (t5 instanceof xt) {
                ((xt) t5).j(i6);
                return;
            }
            ViewParent viewParent = (ViewGroup) t5.getParent();
            if (viewParent instanceof xt) {
                ((xt) viewParent).j(this.up, i6);
                return;
            }
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.up.getLayoutParams();
        layoutParams.width = i6;
        this.up.setLayoutParams(layoutParams);
    }

    protected cw<T> cw(String str) {
        if (oq(str) != null) {
            return this;
        }
        return null;
    }

    public void cw(boolean z5) {
        this.oq = z5;
    }

    @Override // com.bytedance.adsdk.ugeno.cw
    public void cw() {
        if (this.yb == null || this.f23869o) {
            return;
        }
        this.f23869o = true;
    }

    public cw<T> m(String str) {
        return cw(str);
    }

    public cw<T> up(String str) {
        return xt(str);
    }

    protected void n() {
    }

    protected void nd() {
    }

    public void up(int i6) {
        if (p()) {
            T t5 = this.up;
            if (t5 instanceof xt) {
                ((xt) t5).xt(i6);
                return;
            }
            ViewParent viewParent = (ViewGroup) t5.getParent();
            if (viewParent instanceof xt) {
                ((xt) viewParent).xt(this.up, i6);
                return;
            }
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.up.getLayoutParams();
        layoutParams.height = i6;
        this.up.setLayoutParams(layoutParams);
    }

    public void ae(String str) {
        this.qv = str;
    }

    public void j(f fVar) {
        this.yb = fVar;
    }

    @Override // com.bytedance.adsdk.ugeno.cw
    public void j(boolean z5) {
        f fVar = this.yb;
        if (fVar != null) {
            fVar.j(z5);
        }
    }

    public boolean j(int i6) {
        Map<Integer, av> map = this.ka;
        return map != null && map.containsKey(Integer.valueOf(i6));
    }

    public void j(kt ktVar) {
        this.uq = ktVar;
    }

    public void xt(boolean z5) {
        this.jl = z5;
    }

    public void j(w wVar) {
        this.f23874t = wVar;
    }

    public void xt(int i6) {
        ViewParent viewParent = (ViewGroup) this.up.getParent();
        if (viewParent instanceof xt) {
            ((xt) viewParent).cw(this.up, i6);
        } else {
            this.up.setVisibility(i6);
        }
    }

    protected void j(j.C0322j c0322j) {
        if (c0322j == null) {
            return;
        }
        this.fx.setShape(0);
        this.fx.setOrientation(c0322j.f23709j);
        if (Build.VERSION.SDK_INT >= 29) {
            this.fx.setColors(c0322j.xt, c0322j.cw);
        } else {
            this.fx.setColors(c0322j.xt);
        }
        xq();
        sm();
        this.up.setBackground(this.fx);
    }

    protected cw<T> xt(String str) {
        if (TextUtils.isEmpty(this.vl) || !TextUtils.equals(this.vl, str)) {
            return null;
        }
        return this;
    }

    protected void xt(String str, String str2) {
        if (TextUtils.isEmpty(str2) || this.ka == null) {
            return;
        }
        try {
            int type = i.j(str).getType();
            av avVar = new av();
            avVar.j(type);
            avVar.j(this);
            JSONObject jSONObject = new JSONObject(str2);
            if (type == 3) {
                try {
                    this.sf = Float.parseFloat(com.bytedance.adsdk.ugeno.r.xt.j(jSONObject.optString("shakeAmplitude"), this.f23872r));
                } catch (NumberFormatException unused) {
                    this.sf = 12.0f;
                }
            }
            w wVar = this.f23874t;
            if (!(wVar instanceof com.bytedance.adsdk.ugeno.cw.j.xt)) {
                j(type, jSONObject, avVar);
            } else if (!((com.bytedance.adsdk.ugeno.cw.j.xt) wVar).j()) {
                j(type, jSONObject, avVar);
            } else {
                avVar.j(jSONObject);
                this.ka.put(Integer.valueOf(type), avVar);
            }
        } catch (JSONException unused2) {
        }
    }

    public void tl(String str) {
        this.vl = str;
    }

    protected void j(Drawable drawable) {
        this.up.setBackground(drawable);
    }

    public void j(ViewGroup.LayoutParams layoutParams) {
        T t5 = this.up;
        if (t5 != null) {
            t5.setLayoutParams(layoutParams);
        }
        this.kc = layoutParams;
    }

    public void j(boolean z5, boolean z6) {
        if (this.up != null) {
            j(this.kc);
            if (z5) {
                r((int) this.jy);
            }
            if (z6) {
                up((int) this.ws);
            }
        }
    }

    public void j(g.j jVar) {
        this.tl = jVar;
    }

    protected cw<T> j(String str) {
        if (TextUtils.isEmpty(this.qv) || !TextUtils.equals(this.qv, str)) {
            return null;
        }
        return this;
    }

    public void j(j jVar) {
        this.f23867m = jVar;
    }

    public void j(ws wsVar) {
        this.f23861g = wsVar;
    }

    public void j(oq oqVar) {
        this.ki = oqVar;
    }

    @Override // com.bytedance.adsdk.ugeno.cw
    public void xt(int i6, int i7, int i8, int i9) {
        jy jyVar = this.qg;
        if (jyVar != null) {
            jyVar.j(i6, i7);
        }
        com.bytedance.adsdk.ugeno.j.j jVar = this.aq;
        if (jVar != null) {
            jVar.j(i6, i7);
        }
        com.bytedance.adsdk.ugeno.j.m mVar = this.rr;
        if (mVar != null) {
            mVar.j(i6, i7);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void j(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        str.getClass();
        char c6 = 65535;
        switch (str.hashCode()) {
            case -1964681502:
                if (str.equals("clickable")) {
                    c6 = 0;
                    break;
                }
                break;
            case -1901681170:
                if (str.equals("onRenderSuccess")) {
                    c6 = 1;
                    break;
                }
                break;
            case -1721943862:
                if (str.equals("translateX")) {
                    c6 = 2;
                    break;
                }
                break;
            case -1721943861:
                if (str.equals("translateY")) {
                    c6 = 3;
                    break;
                }
                break;
            case -1501175880:
                if (str.equals("paddingLeft")) {
                    c6 = 4;
                    break;
                }
                break;
            case -1375815020:
                if (str.equals("minWidth")) {
                    c6 = 5;
                    break;
                }
                break;
            case -1351184668:
                if (str.equals("onDelay")) {
                    c6 = 6;
                    break;
                }
                break;
            case -1337252761:
                if (str.equals("onShake")) {
                    c6 = 7;
                    break;
                }
                break;
            case -1337126126:
                if (str.equals("onSlide")) {
                    c6 = '\b';
                    break;
                }
                break;
            case -1336288090:
                if (str.equals("onTimer")) {
                    c6 = '\t';
                    break;
                }
                break;
            case -1335874424:
                if (str.equals("onTwist")) {
                    c6 = '\n';
                    break;
                }
                break;
            case -1332194002:
                if (str.equals("background")) {
                    c6 = 11;
                    break;
                }
                break;
            case -1291329255:
                if (str.equals(d.ax)) {
                    c6 = '\f';
                    break;
                }
                break;
            case -1267206133:
                if (str.equals("opacity")) {
                    c6 = StringUtil.CARRIAGE_RETURN;
                    break;
                }
                break;
            case -1228066334:
                if (str.equals("borderTopLeftRadius")) {
                    c6 = 14;
                    break;
                }
                break;
            case -1221029593:
                if (str.equals("height")) {
                    c6 = 15;
                    break;
                }
                break;
            case -1081309778:
                if (str.equals("margin")) {
                    c6 = 16;
                    break;
                }
                break;
            case -1044792121:
                if (str.equals("marginTop")) {
                    c6 = 17;
                    break;
                }
                break;
            case -1013407967:
                if (str.equals("onDown")) {
                    c6 = 18;
                    break;
                }
                break;
            case -933876756:
                if (str.equals("backgroundDrawable")) {
                    c6 = 19;
                    break;
                }
                break;
            case -925180581:
                if (str.equals("rotate")) {
                    c6 = 20;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c6 = 21;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c6 = 22;
                    break;
                }
                break;
            case -806339567:
                if (str.equals("padding")) {
                    c6 = 23;
                    break;
                }
                break;
            case -681357156:
                if (str.equals("triggerFunc")) {
                    c6 = 24;
                    break;
                }
                break;
            case -289173127:
                if (str.equals("marginBottom")) {
                    c6 = 25;
                    break;
                }
                break;
            case -133587431:
                if (str.equals("minHeight")) {
                    c6 = JSONLexer.EOI;
                    break;
                }
                break;
            case 3355:
                if (str.equals("id")) {
                    c6 = 27;
                    break;
                }
                break;
            case 3176990:
                if (str.equals("i18n")) {
                    c6 = 28;
                    break;
                }
                break;
            case 3373707:
                if (str.equals(CommonNetImpl.NAME)) {
                    c6 = 29;
                    break;
                }
                break;
            case 87811796:
                if (str.equals("backgroundImageBlur")) {
                    c6 = 30;
                    break;
                }
                break;
            case 90130308:
                if (str.equals("paddingTop")) {
                    c6 = 31;
                    break;
                }
                break;
            case 94750088:
                if (str.equals(AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_CLICK)) {
                    c6 = ' ';
                    break;
                }
                break;
            case 105871684:
                if (str.equals("onTap")) {
                    c6 = '!';
                    break;
                }
                break;
            case 108285963:
                if (str.equals("ratio")) {
                    c6 = '\"';
                    break;
                }
                break;
            case 109250890:
                if (str.equals("scale")) {
                    c6 = '#';
                    break;
                }
                break;
            case 113126854:
                if (str.equals("width")) {
                    c6 = v0.f47959c;
                    break;
                }
                break;
            case 202355100:
                if (str.equals("paddingBottom")) {
                    c6 = '%';
                    break;
                }
                break;
            case 314070383:
                if (str.equals("animations")) {
                    c6 = v0.f47960d;
                    break;
                }
                break;
            case 320386138:
                if (str.equals("onLoadMore")) {
                    c6 = '\'';
                    break;
                }
                break;
            case 333432965:
                if (str.equals("borderTopRightRadius")) {
                    c6 = '(';
                    break;
                }
                break;
            case 529642498:
                if (str.equals("overflow")) {
                    c6 = ')';
                    break;
                }
                break;
            case 581268560:
                if (str.equals("borderBottomLeftRadius")) {
                    c6 = '*';
                    break;
                }
                break;
            case 588239831:
                if (str.equals("borderBottomRightRadius")) {
                    c6 = '+';
                    break;
                }
                break;
            case 713848971:
                if (str.equals("paddingRight")) {
                    c6 = StringUtil.COMMA;
                    break;
                }
                break;
            case 722830999:
                if (str.equals("borderColor")) {
                    c6 = '-';
                    break;
                }
                break;
            case 737768677:
                if (str.equals("borderStyle")) {
                    c6 = '.';
                    break;
                }
                break;
            case 741115130:
                if (str.equals("borderWidth")) {
                    c6 = '/';
                    break;
                }
                break;
            case 843948038:
                if (str.equals("onExposure")) {
                    c6 = '0';
                    break;
                }
                break;
            case 975087886:
                if (str.equals("marginRight")) {
                    c6 = '1';
                    break;
                }
                break;
            case 1052832078:
                if (str.equals("translate")) {
                    c6 = '2';
                    break;
                }
                break;
            case 1087723621:
                if (str.equals("onAnimation")) {
                    c6 = '3';
                    break;
                }
                break;
            case 1118509956:
                if (str.equals("animation")) {
                    c6 = '4';
                    break;
                }
                break;
            case 1151851515:
                if (str.equals("animatorSet")) {
                    c6 = '5';
                    break;
                }
                break;
            case 1158381436:
                if (str.equals("onPullToRefresh")) {
                    c6 = '6';
                    break;
                }
                break;
            case 1287124693:
                if (str.equals("backgroundColor")) {
                    c6 = '7';
                    break;
                }
                break;
            case 1292595405:
                if (str.equals("backgroundImage")) {
                    c6 = '8';
                    break;
                }
                break;
            case 1301532860:
                if (str.equals("backgroundScale")) {
                    c6 = '9';
                    break;
                }
                break;
            case 1349188574:
                if (str.equals("borderRadius")) {
                    c6 = ':';
                    break;
                }
                break;
            case 1384173149:
                if (str.equals("rotateX")) {
                    c6 = ';';
                    break;
                }
                break;
            case 1384173150:
                if (str.equals("rotateY")) {
                    c6 = v0.f47961e;
                    break;
                }
                break;
            case 1384173151:
                if (str.equals("rotateZ")) {
                    c6 = '=';
                    break;
                }
                break;
            case 1490730380:
                if (str.equals("onScroll")) {
                    c6 = v0.f47962f;
                    break;
                }
                break;
            case 1671308008:
                if (str.equals("disable")) {
                    c6 = '?';
                    break;
                }
                break;
            case 1685004456:
                if (str.equals("onLongTap")) {
                    c6 = '@';
                    break;
                }
                break;
            case 1941332754:
                if (str.equals("visibility")) {
                    c6 = 'A';
                    break;
                }
                break;
            case 1970934485:
                if (str.equals("marginLeft")) {
                    c6 = 'B';
                    break;
                }
                break;
            case 1997542747:
                if (str.equals("availability")) {
                    c6 = 'C';
                    break;
                }
                break;
        }
        switch (c6) {
            case 0:
                this.fp = com.bytedance.adsdk.ugeno.m.cw.j(str2, true);
                break;
            case 1:
            case 6:
            case 7:
            case '\b':
            case '\t':
            case '\n':
            case 18:
            case '!':
            case '\'':
            case '0':
            case '3':
            case '6':
            case '>':
            case '@':
                xt(str, str2);
                break;
            case 2:
                this.f23864j = true;
                this.pz = tl.j(this.xt, com.bytedance.adsdk.ugeno.m.cw.j(str2, 0.0f));
                break;
            case 3:
                this.ll = true;
                this.qa = tl.j(this.xt, com.bytedance.adsdk.ugeno.m.cw.j(str2, 0.0f));
                break;
            case 4:
                this.f23855a = tl.j(this.xt, str2);
                this.gq = true;
                break;
            case 5:
                this.kt = com.bytedance.adsdk.ugeno.m.cw.j(str2, 0.0f);
                break;
            case 11:
            case '7':
                if (com.bytedance.adsdk.ugeno.m.j.cw(str2)) {
                    this.f23875u = true;
                    this.wo = com.bytedance.adsdk.ugeno.m.j.xt(str2);
                    break;
                } else {
                    this.ed = com.bytedance.adsdk.ugeno.m.j.j(str2, 0);
                    this.f23875u = false;
                    break;
                }
            case '\f':
                this.qo = com.bytedance.adsdk.ugeno.up.g.j(this, str2);
                break;
            case '\r':
                this.f23858d = true;
                this.ri = com.bytedance.adsdk.ugeno.m.cw.j(str2, 1.0f);
                break;
            case 14:
                this.hh = tl.j(this.xt, str2);
                this.f23859e = true;
                break;
            case 15:
                if (TextUtils.equals(str2, "match_parent")) {
                    this.ws = -1.0f;
                } else if (TextUtils.equals(str2, "wrap_content")) {
                    this.ws = -2.0f;
                } else {
                    this.ws = tl.j(this.xt, str2);
                }
                this.kk = true;
                break;
            case 16:
                this.az = tl.j(this.xt, str2);
                break;
            case 17:
                this.f23877w = tl.j(this.xt, str2);
                this.f23878x = true;
                break;
            case 19:
            case '8':
                this.f23857c = str2;
                break;
            case 20:
                this.qe = true;
                this.im = com.bytedance.adsdk.ugeno.m.cw.j(str2, 0.0f);
                break;
            case 21:
                this.oy = true;
                this.ln = com.bytedance.adsdk.ugeno.m.cw.j(str2, 0.0f);
                break;
            case 22:
                this.yl = true;
                this.xp = com.bytedance.adsdk.ugeno.m.cw.j(str2, 0.0f);
                break;
            case 23:
                this.f23873s = tl.j(this.xt, str2);
                this.la = true;
                break;
            case 24:
                this.rs = str2;
                break;
            case 25:
                this.mi = tl.j(this.xt, str2);
                this.ch = true;
                break;
            case 26:
                this.tj = com.bytedance.adsdk.ugeno.m.cw.j(str2, 0.0f);
                break;
            case 27:
                this.qv = str2;
                break;
            case 28:
                this.ym = com.bytedance.adsdk.ugeno.m.xt.j(str2, (JSONObject) null);
                break;
            case 29:
                this.vl = str2;
                break;
            case 30:
                float j6 = com.bytedance.adsdk.ugeno.m.cw.j(str2, 0.0f);
                this.f23868n = j6;
                if (j6 > 0.0f) {
                    this.nd = true;
                    break;
                }
                break;
            case 31:
                this.f23870p = tl.j(this.xt, str2);
                this.wq = true;
                break;
            case ' ':
                this.na = str2;
                break;
            case '\"':
                this.ry = com.bytedance.adsdk.ugeno.m.cw.j(str2, 0.0f);
                break;
            case '#':
                this.oy = true;
                this.yl = true;
                float[] cw = com.bytedance.adsdk.ugeno.j.r.cw(str2);
                this.ln = cw[0];
                this.xp = cw[1];
                break;
            case '$':
                if (TextUtils.equals(str2, "match_parent")) {
                    this.jy = -1.0f;
                } else if (TextUtils.equals(str2, "wrap_content")) {
                    this.jy = -2.0f;
                } else {
                    this.jy = tl.j(this.xt, str2);
                }
                this.dj = true;
                break;
            case '%':
                this.f23862h = tl.j(this.xt, str2);
                this.uf = true;
                break;
            case '&':
                List<com.bytedance.adsdk.ugeno.j.cw> j7 = com.bytedance.adsdk.ugeno.j.r.j(str2, this.f23872r);
                if (j7 != null && !j7.isEmpty()) {
                    this.rr = new com.bytedance.adsdk.ugeno.j.m(this.xt, this, j7);
                    break;
                }
                break;
            case '(':
                this.hl = tl.j(this.xt, str2);
                this.f23871q = true;
                break;
            case ')':
                this.wi = vl(str2);
                break;
            case '*':
                this.f23880z = tl.j(this.xt, str2);
                this.qb = true;
                break;
            case '+':
                this.f23856b = tl.j(this.xt, str2);
                this.ya = true;
                break;
            case ',':
                this.f23866l = tl.j(this.xt, str2);
                this.rn = true;
                break;
            case '-':
                this.xq = com.bytedance.adsdk.ugeno.m.j.j(str2);
                break;
            case '.':
                this.f23865k = str2;
                break;
            case '/':
                this.sm = tl.j(this.xt, str2);
                break;
            case '1':
                this.f23863i = tl.j(this.xt, str2);
                this.f23876v = true;
                break;
            case '2':
                this.f23864j = true;
                this.ll = true;
                float[] cw2 = com.bytedance.adsdk.ugeno.j.r.cw(str2);
                this.pz = tl.j(this.xt, cw2[0]);
                this.qa = tl.j(this.xt, cw2[1]);
                break;
            case '4':
                try {
                    this.aq = new com.bytedance.adsdk.ugeno.j.j(this.xt, this, com.bytedance.adsdk.ugeno.j.r.j(new JSONObject(str2), this.f23872r));
                    break;
                } catch (JSONException e6) {
                    vl.j(e6);
                    return;
                }
            case '5':
                this.gr = com.bytedance.adsdk.ugeno.cw.j.j(str2, this);
                break;
            case '9':
                this.rh = true;
                this.gx = qv(str2);
                break;
            case ':':
                this.ol = tl.j(this.xt, str2);
                break;
            case ';':
                this.px = true;
                this.f23879y = com.bytedance.adsdk.ugeno.m.cw.j(str2, 0.0f);
                break;
            case '<':
                this.xw = true;
                this.nt = com.bytedance.adsdk.ugeno.m.cw.j(str2, 0.0f);
                break;
            case '=':
                this.uc = com.bytedance.adsdk.ugeno.m.cw.j(str2, 0.0f);
                break;
            case '?':
                this.tk = com.bytedance.adsdk.ugeno.m.cw.j(str2, false);
                break;
            case 'A':
                if (TextUtils.equals("visible", str2)) {
                    this.ff = 0;
                } else if (TextUtils.equals("invisible", str2)) {
                    this.ff = 4;
                } else if (TextUtils.equals("gone", str2) || TextUtils.equals("hidden", str2)) {
                    this.ff = 8;
                }
                this.up.setVisibility(this.ff);
                break;
            case 'B':
                this.av = tl.j(this.xt, str2);
                this.f23860f = true;
                break;
            case 'C':
                this.zz = !TextUtils.equals(str2, "unavailable");
                break;
        }
    }

    public cw xt(cw cwVar) {
        return (cwVar.h() == null && (cwVar instanceof j)) ? cwVar : xt(cwVar.h());
    }

    @Deprecated
    protected void j(int i6, JSONObject jSONObject, av avVar) {
        JSONObject optJSONObject = jSONObject.optJSONObject("success");
        if (optJSONObject != null) {
            av avVar2 = new av();
            avVar2.j(optJSONObject);
            avVar2.j(this);
            avVar.j(avVar2);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject(CommonNetImpl.FAIL);
        if (optJSONObject2 != null) {
            av avVar3 = new av();
            avVar3.j(optJSONObject2);
            avVar3.j(this);
            avVar.xt(avVar3);
        }
        avVar.j(jSONObject);
        this.ka.put(Integer.valueOf(i6), avVar);
    }

    @Override // com.bytedance.adsdk.ugeno.cw
    public int[] j(int i6, int i7) {
        if (this.ry > 0.0f) {
            if (this.dj) {
                int size = View.MeasureSpec.getSize(i6);
                float f6 = this.ry;
                if (f6 != 0.0f) {
                    i7 = View.MeasureSpec.makeMeasureSpec((int) (size / f6), 1073741824);
                }
            } else if (this.kk) {
                int size2 = View.MeasureSpec.getSize(i7);
                float f7 = this.ry;
                if (f7 != 0.0f) {
                    i6 = View.MeasureSpec.makeMeasureSpec((int) (size2 * f7), 1073741824);
                }
            }
        }
        if (this.yb != null && !this.el) {
            this.el = true;
        }
        return new int[]{i6, i7};
    }

    @Override // com.bytedance.adsdk.ugeno.cw
    public void j(int i6, int i7, int i8, int i9) {
        if (this.yb == null || this.lx) {
            return;
        }
        this.lx = true;
    }

    @Override // com.bytedance.adsdk.ugeno.cw
    public void j(Canvas canvas, com.bytedance.adsdk.ugeno.cw.up upVar) {
        jy jyVar = this.qg;
        if (jyVar != null) {
            jyVar.j(canvas, upVar);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.cw
    public void j(Canvas canvas) {
        com.bytedance.adsdk.ugeno.j.j jVar = this.aq;
        if (jVar != null) {
            jVar.j(canvas);
        }
        com.bytedance.adsdk.ugeno.j.m mVar = this.rr;
        if (mVar != null) {
            mVar.j(canvas);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.cw.w.xt
    public void j(av avVar) {
        j<ViewGroup> jVar;
        cw<T> r5;
        if (avVar == null || avVar.cw() == null) {
            return;
        }
        r.j jVar2 = this.zs;
        if (jVar2 != null) {
            jVar2.xt();
        }
        if (TextUtils.equals(avVar.cw().optString("type"), "onDismiss")) {
            String optString = avVar.cw().optString("nodeId");
            xt(8);
            this.ae = (j) xt(this);
            if (TextUtils.isEmpty(optString) || (jVar = this.ae) == null || (r5 = jVar.r(optString)) == null) {
                return;
            }
            r5.xt(8);
        }
    }

    public void j(com.bytedance.adsdk.ugeno.up.j.j jVar) {
        this.hw = jVar;
    }

    public void j(String str, Object... objArr) {
        List<com.bytedance.adsdk.ugeno.up.cw.xt> g6 = g(str);
        if (g6 == null || g6.isEmpty()) {
            return;
        }
        for (com.bytedance.adsdk.ugeno.up.cw.xt xtVar : g6) {
            xtVar.j(this.qo);
            xtVar.j(objArr);
        }
    }

    public void j(com.bytedance.adsdk.ugeno.cw.m mVar) {
        com.bytedance.adsdk.ugeno.up.g gVar = this.qo;
        if (gVar != null) {
            gVar.j(mVar);
        }
    }

    public void j(ae aeVar) {
        this.ik = aeVar;
    }
}
