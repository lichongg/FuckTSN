package com.bytedance.sdk.component.adexpress.dynamic.cw;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.acse.ottn.adapter.AutoScrollViewPager;
import com.baidu.mobads.sdk.api.PrerollVideoResponse;
import com.beizi.fusion.widget.ScrollClickView;
import com.bytedance.sdk.component.adexpress.dynamic.r.qv;
import java.util.List;
import org.json.JSONObject;
import xyz.adscope.amps.common.AMPSConstants;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ae {
    private String ae;
    public String cw;

    /* renamed from: j, reason: collision with root package name */
    public int f25589j;

    /* renamed from: m, reason: collision with root package name */
    private up f25590m;

    /* renamed from: r, reason: collision with root package name */
    public JSONObject f25591r;
    private m up;
    public String xt;

    public int j() {
        return (int) this.up.ws();
    }

    public int xt() {
        return (int) this.up.i();
    }

    public static float[] xt(String str) {
        String[] split = str.substring(str.indexOf("(") + 1, str.indexOf(")")).split(",");
        return (split == null || split.length != 4) ? new float[]{0.0f, 0.0f, 0.0f, 0.0f} : new float[]{Float.parseFloat(split[0]), Float.parseFloat(split[1]), Float.parseFloat(split[2]), Float.parseFloat(split[3])};
    }

    public int a() {
        String c6 = this.up.c();
        if ("skip-with-time-skip-btn".equals(this.f25590m.getType()) || "skip".equals(this.f25590m.getType()) || TextUtils.equals("skip-with-countdowns-skip-btn", this.f25590m.getType())) {
            return 6;
        }
        if (!"skip-with-time-countdown".equals(this.f25590m.getType()) && !"skip-with-time".equals(this.f25590m.getType())) {
            if (this.f25589j == 10 && TextUtils.equals(this.up.gx(), AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_CLICK)) {
                return 5;
            }
            if (ri() && ki()) {
                return 0;
            }
            if (ri()) {
                return 7;
            }
            if ("feedback-dislike".equals(this.f25590m.getType())) {
                return 3;
            }
            if (!TextUtils.isEmpty(c6) && !c6.equals("none")) {
                if (c6.equals("video") || (this.f25590m.j() == 7 && TextUtils.equals(c6, PrerollVideoResponse.NORMAL))) {
                    return (com.bytedance.sdk.component.adexpress.r.j() && this.f25590m.up() != null && this.f25590m.up().gr()) ? 11 : 4;
                }
                if (c6.equals(PrerollVideoResponse.NORMAL)) {
                    return 1;
                }
                return (c6.equals("creative") || "slide".equals(this.up.gx())) ? 2 : 0;
            }
        }
        return 0;
    }

    public int ae() {
        return j(this.up.f());
    }

    public int aq() {
        return this.up.yl();
    }

    public int av() {
        return j(this.up.s());
    }

    public float az() {
        return this.up.qv();
    }

    public int b() {
        return this.up.ki();
    }

    public boolean c() {
        return this.up.pz();
    }

    public String ch() {
        return this.up.jl();
    }

    public int cw() {
        return (int) this.up.az();
    }

    public boolean e() {
        return this.up.ll();
    }

    public String ed() {
        return this.up.gx();
    }

    public boolean f() {
        return this.up.rh();
    }

    public int ff() {
        return this.up.gq();
    }

    public int gq() {
        return this.up.up();
    }

    public int gx() {
        return this.up.wf();
    }

    public int h() {
        return this.up.cw();
    }

    public int hh() {
        return this.up.d();
    }

    public int hl() {
        return this.up.qo();
    }

    public float i() {
        return this.up.vl();
    }

    public String im() {
        return this.up.ch();
    }

    public void j(float f6) {
        this.up.j(f6);
    }

    public double jy() {
        if (this.f25589j == 11) {
            try {
                return !com.bytedance.sdk.component.adexpress.r.j() ? (int) r0 : Double.parseDouble(this.xt);
            } catch (NumberFormatException unused) {
            }
        }
        return -1.0d;
    }

    public String k() {
        return this.up.h();
    }

    public double kc() {
        return this.up.uf();
    }

    public boolean kt() {
        return this.up.tk();
    }

    public int l() {
        return j(this.up.v());
    }

    public int la() {
        return this.up.xt();
    }

    public int ln() {
        return this.up.ik();
    }

    public String m() {
        return this.f25589j == 0 ? !TextUtils.isEmpty(this.xt) ? this.xt : this.f25591r.optString(com.bytedance.sdk.component.adexpress.r.tl.r(com.bytedance.sdk.component.adexpress.r.getContext())) : "";
    }

    public int mi() {
        return this.up.fx();
    }

    public int n() {
        return this.up.qa();
    }

    public String nd() {
        return this.up.ed();
    }

    public List<String> nt() {
        return this.up.o();
    }

    public int ol() {
        return this.up.ae();
    }

    public String oq() {
        int i6 = this.f25589j;
        return (i6 == 2 || i6 == 13) ? this.xt : "";
    }

    public double p() {
        return this.up.tl();
    }

    public boolean pz() {
        return this.up.uq();
    }

    public String q() {
        return this.up.p();
    }

    public int qa() {
        return this.up.u();
    }

    public String qb() {
        return this.up.oy();
    }

    public String qv() {
        int i6 = this.f25589j;
        return (i6 == 1 || i6 == 29) ? this.xt : "";
    }

    public int r() {
        return (int) this.up.av();
    }

    public boolean rh() {
        return this.up.wo();
    }

    public int rn() {
        return this.up.r();
    }

    public String rr() {
        return this.up.zs();
    }

    public int ry() {
        return this.up.rn();
    }

    public long s() {
        return this.up.ig();
    }

    public boolean sm() {
        return this.up.jy();
    }

    public String st() {
        return this.up.t();
    }

    public String tj() {
        return this.up.x();
    }

    public int tl() {
        String tj = this.up.tj();
        if (ScrollClickView.DIR_LEFT.equals(tj)) {
            return 17;
        }
        if (AutoScrollViewPager.f4187g.equals(tj)) {
            return 4;
        }
        return "right".equals(tj) ? 3 : 2;
    }

    public boolean uc() {
        return this.up.el();
    }

    public String uf() {
        return this.up.oq();
    }

    public float up() {
        return this.up.w();
    }

    public int v() {
        return this.up.ol();
    }

    public String vl() {
        return this.ae;
    }

    public int w() {
        return this.up.wi();
    }

    public int wf() {
        return this.up.ka();
    }

    public int wq() {
        return this.up.g();
    }

    public double ws() {
        return this.up.mi();
    }

    public String x() {
        return this.up.c();
    }

    public boolean xp() {
        return this.up.ll();
    }

    public boolean xq() {
        return this.up.la();
    }

    public String y() {
        return this.f25589j == 29 ? this.cw : "";
    }

    public String ya() {
        return this.up.ov();
    }

    public int z() {
        return this.up.et();
    }

    public double zz() {
        return this.up.wq();
    }

    public ae(up upVar) {
        this.f25590m = upVar;
        this.f25589j = upVar.j();
        this.xt = upVar.xt();
        this.cw = upVar.cw();
        this.f25591r = upVar.up().rr();
        this.ae = upVar.r();
        if (com.bytedance.sdk.component.adexpress.r.xt() == 1) {
            this.up = upVar.ae();
        } else {
            this.up = upVar.up();
        }
        if (com.bytedance.sdk.component.adexpress.r.j()) {
            this.up = upVar.up();
        }
    }

    public static int j(String str) {
        String[] split;
        if (TextUtils.isEmpty(str)) {
            return ViewCompat.MEASURED_STATE_MASK;
        }
        if (str.equals("transparent")) {
            return 0;
        }
        if (str.charAt(0) == '#' && str.length() == 7) {
            return Color.parseColor(str);
        }
        if (str.charAt(0) == '#' && str.length() == 9) {
            return Color.parseColor(str);
        }
        if (str.startsWith("rgba") && (split = str.substring(str.indexOf("(") + 1, str.indexOf(")")).split(",")) != null) {
            try {
                if (split.length == 4) {
                    return (((int) ((Float.parseFloat(split[3]) * 255.0f) + 0.5f)) << 24) | (((int) Float.parseFloat(split[0])) << 16) | (((int) Float.parseFloat(split[1])) << 8) | ((int) Float.parseFloat(split[2]));
                }
            } catch (NumberFormatException unused) {
                return 0;
            }
        }
        return ViewCompat.MEASURED_STATE_MASK;
    }

    private boolean ki() {
        if (com.bytedance.sdk.component.adexpress.r.j()) {
            return false;
        }
        if ((TextUtils.isEmpty(this.xt) || !this.xt.contains("adx:")) && !qv.xt()) {
            return false;
        }
        return true;
    }

    private boolean ri() {
        if ((com.bytedance.sdk.component.adexpress.r.j() && (this.f25590m.getType().contains("logo-union") || this.f25590m.getType().contains("logounion") || this.f25590m.getType().contains("logoad"))) || "logo-union".equals(this.f25590m.getType()) || "logounion".equals(this.f25590m.getType()) || "logoad".equals(this.f25590m.getType())) {
            return true;
        }
        return false;
    }

    public int g() {
        int tl = tl();
        if (tl == 4) {
            return 17;
        }
        if (tl == 3) {
            return GravityCompat.END;
        }
        return GravityCompat.START;
    }

    public boolean j(int i6) {
        up upVar = this.f25590m;
        if (upVar == null) {
            return false;
        }
        if (i6 == 1) {
            this.up = upVar.ae();
        } else {
            this.up = upVar.up();
        }
        return this.up != null;
    }
}
