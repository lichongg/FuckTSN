package com.bytedance.msdk.cw.m.xt;

import android.text.TextUtils;
import com.bytedance.msdk.core.oq.oq;
import com.bytedance.msdk.core.oq.tl;
import com.bytedance.msdk.j.up.m;
import com.bytedance.msdk.xt.cw;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt implements j {
    private boolean ae;
    private String cw;

    /* renamed from: g, reason: collision with root package name */
    private int f25033g;

    /* renamed from: j, reason: collision with root package name */
    private oq f25034j;

    /* renamed from: m, reason: collision with root package name */
    private int f25035m;

    /* renamed from: r, reason: collision with root package name */
    private String f25036r;
    private long tl = -1;
    private int up;
    private com.bytedance.msdk.cw.xt.xt.j xt;

    public int cw() {
        return this.f25033g;
    }

    public void xt(int i6) {
        this.f25035m = i6;
    }

    public static xt j(oq oqVar, com.bytedance.msdk.cw.xt.xt.j jVar) {
        xt xtVar = new xt();
        xtVar.f25034j = oqVar;
        xtVar.xt = jVar;
        return xtVar;
    }

    public int a() {
        oq oqVar = this.f25034j;
        if (oqVar != null) {
            return oqVar.j();
        }
        return 0;
    }

    public int ae() {
        return this.up;
    }

    public String av() {
        oq oqVar = this.f25034j;
        return oqVar != null ? oqVar.s() : "";
    }

    public int az() {
        oq oqVar = this.f25034j;
        if (oqVar != null) {
            return oqVar.m();
        }
        return 0;
    }

    public void cw(int i6) {
        this.up = i6;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0024 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int ed() {
        /*
            r7 = this;
            com.bytedance.msdk.core.oq.oq r0 = r7.f25034j
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            int r0 = r0.m()
            com.bytedance.msdk.core.oq.oq r2 = r7.f25034j
            int r2 = r2.jy()
            r3 = 20001(0x4e21, float:2.8027E-41)
            r4 = 20002(0x4e22, float:2.8029E-41)
            r5 = 20004(0x4e24, float:2.8032E-41)
            r6 = 20003(0x4e23, float:2.803E-41)
            switch(r2) {
                case 1: goto L45;
                case 2: goto L44;
                case 3: goto L41;
                case 4: goto L1b;
                case 5: goto L32;
                case 6: goto L1b;
                case 7: goto L27;
                case 8: goto L26;
                case 9: goto L25;
                case 10: goto L1c;
                default: goto L1b;
            }
        L1b:
            goto L24
        L1c:
            r2 = 1
            if (r0 != r2) goto L20
            return r5
        L20:
            r2 = 2
            if (r0 != r2) goto L24
            return r6
        L24:
            return r1
        L25:
            return r4
        L26:
            return r6
        L27:
            r1 = 6
            r2 = 20006(0x4e26, float:2.8034E-41)
            if (r0 != r1) goto L2d
            return r2
        L2d:
            r1 = 7
            if (r0 != r1) goto L31
            return r6
        L31:
            return r2
        L32:
            r1 = 4
            r2 = 20005(0x4e25, float:2.8033E-41)
            if (r0 != r1) goto L38
            return r2
        L38:
            r1 = 5
            if (r0 != r1) goto L3c
            return r4
        L3c:
            r1 = 3
            if (r0 != r1) goto L40
            return r3
        L40:
            return r2
        L41:
            r0 = 20007(0x4e27, float:2.8036E-41)
            return r0
        L44:
            return r5
        L45:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.cw.m.xt.xt.ed():int");
    }

    public String f() {
        oq oqVar = this.f25034j;
        return oqVar != null ? oqVar.az() : "";
    }

    public void g() {
        m.j(new Runnable() { // from class: com.bytedance.msdk.cw.m.xt.xt.3
            @Override // java.lang.Runnable
            public void run() {
                if (xt.this.xt != null) {
                    xt.this.xt.j();
                }
            }
        });
    }

    public String gq() {
        oq oqVar = this.f25034j;
        return oqVar != null ? oqVar.ws() : "";
    }

    public double h() {
        oq oqVar = this.f25034j;
        if (oqVar != null) {
            return oqVar.f();
        }
        return 0.0d;
    }

    public String i() {
        return this.cw;
    }

    public String jy() {
        oq oqVar = this.f25034j;
        return oqVar != null ? oqVar.az() : "";
    }

    public int kt() {
        oq oqVar = this.f25034j;
        if (oqVar != null) {
            return oqVar.x();
        }
        return 0;
    }

    public tl la() {
        oq oqVar = this.f25034j;
        if (oqVar != null) {
            return oqVar.l();
        }
        return null;
    }

    public int m() {
        return this.f25035m;
    }

    public int mi() {
        oq oqVar = this.f25034j;
        if (oqVar != null) {
            return oqVar.mi();
        }
        return 0;
    }

    public boolean oq() {
        oq oqVar = this.f25034j;
        if (oqVar != null) {
            return oqVar.c();
        }
        return false;
    }

    public double p() {
        oq oqVar = this.f25034j;
        if (oqVar != null) {
            return oqVar.tj();
        }
        return 0.0d;
    }

    public boolean qv() {
        oq oqVar = this.f25034j;
        if (oqVar != null) {
            return TextUtils.equals(oqVar.az(), MediationConstant.ADN_PANGLE);
        }
        return false;
    }

    public long r() {
        return this.tl;
    }

    public int rn() {
        oq oqVar = this.f25034j;
        if (oqVar != null) {
            return oqVar.g();
        }
        return 0;
    }

    public int s() {
        oq oqVar = this.f25034j;
        if (oqVar != null) {
            return oqVar.jy();
        }
        return 0;
    }

    public int tj() {
        oq oqVar = this.f25034j;
        if (oqVar != null) {
            return oqVar.ch();
        }
        return 0;
    }

    public oq tl() {
        return this.f25034j;
    }

    public boolean up() {
        return this.ae;
    }

    public boolean v() {
        oq oqVar = this.f25034j;
        return oqVar != null && oqVar.mi() == 2;
    }

    public String vl() {
        oq oqVar = this.f25034j;
        return oqVar != null ? oqVar.w() : "";
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00d0, code lost:
    
        if (r2 == 2) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00db, code lost:
    
        if (r2 != 7) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00e6, code lost:
    
        if (r2 == 3) goto L79;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String w() {
        /*
            Method dump skipped, instructions count: 342
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.cw.m.xt.xt.w():java.lang.String");
    }

    public String wq() {
        oq oqVar = this.f25034j;
        return oqVar != null ? oqVar.ed() : "";
    }

    public int ws() {
        oq oqVar = this.f25034j;
        if (oqVar != null) {
            return oqVar.oq();
        }
        return 0;
    }

    public boolean x() {
        oq oqVar = this.f25034j;
        return oqVar != null && oqVar.mi() == 3;
    }

    public void xt(String str) {
        this.f25036r = str;
    }

    private xt() {
    }

    public String ch() {
        if (!v() || la() == null) {
            return "";
        }
        return la().oq();
    }

    public double l() {
        oq oqVar;
        if (!v() && !j() && !x() && (oqVar = this.f25034j) != null) {
            return oqVar.v();
        }
        return 0.0d;
    }

    public Object uf() {
        if (!v() || la() == null) {
            return null;
        }
        return la().xt();
    }

    @Override // com.bytedance.msdk.cw.m.xt.j
    public String xt() {
        return this.f25036r;
    }

    public void j(int i6) {
        this.f25033g = i6;
    }

    public void j(long j6) {
        this.tl = j6;
    }

    public void j(boolean z5) {
        this.ae = z5;
    }

    public void j(final List<cw> list, final oq oqVar) {
        m.j(new Runnable() { // from class: com.bytedance.msdk.cw.m.xt.xt.1
            @Override // java.lang.Runnable
            public void run() {
                if (xt.this.xt != null) {
                    xt.this.xt.j(list, oqVar);
                }
            }
        });
    }

    public void j(final com.bytedance.msdk.api.j jVar, final oq oqVar) {
        m.j(new Runnable() { // from class: com.bytedance.msdk.cw.m.xt.xt.2
            @Override // java.lang.Runnable
            public void run() {
                if (xt.this.xt != null) {
                    xt.this.xt.j(jVar, oqVar);
                }
            }
        });
    }

    public void j(String str) {
        this.cw = str;
    }

    @Override // com.bytedance.msdk.cw.m.xt.j
    public boolean j() {
        oq oqVar = this.f25034j;
        return oqVar != null && oqVar.mi() == 1;
    }
}
