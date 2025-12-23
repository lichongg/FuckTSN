package com.bytedance.sdk.component.adexpress.dynamic.r;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.dynamic.r.xt;
import com.bytedance.sdk.component.adexpress.xt.jy;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up {
    private com.bytedance.sdk.component.adexpress.dynamic.cw.tl cw;

    /* renamed from: j, reason: collision with root package name */
    public com.bytedance.sdk.component.adexpress.dynamic.cw.xt f25795j;

    /* renamed from: r, reason: collision with root package name */
    private j f25796r;
    protected xt xt;

    public void j(j jVar) {
        this.f25796r = jVar;
    }

    static class j {
        float cw;

        /* renamed from: j, reason: collision with root package name */
        float f25797j;
        float xt;

        j() {
        }
    }

    public void j() {
        this.xt.j();
    }

    public up(double d6, int i6, double d7, String str, jy jyVar) {
        this.xt = new xt(d6, i6, d7, str, jyVar);
    }

    public void j(com.bytedance.sdk.component.adexpress.dynamic.cw.tl tlVar, float f6, float f7) {
        if (tlVar != null) {
            this.cw = tlVar;
        }
        com.bytedance.sdk.component.adexpress.dynamic.cw.tl tlVar2 = this.cw;
        float tl = tlVar2.tl();
        float g6 = tlVar2.g();
        float f8 = TextUtils.equals(tlVar2.oq().up().a(), "fixed") ? g6 : 65536.0f;
        this.xt.j();
        this.xt.cw(tlVar2, tl, f8);
        xt.cw j6 = this.xt.j(tlVar2);
        com.bytedance.sdk.component.adexpress.dynamic.cw.xt xtVar = new com.bytedance.sdk.component.adexpress.dynamic.cw.xt();
        xtVar.f25641j = f6;
        xtVar.xt = f7;
        if (j6 != null) {
            tl = j6.f25802j;
        }
        xtVar.cw = tl;
        if (j6 != null) {
            g6 = j6.xt;
        }
        xtVar.f25643r = g6;
        xtVar.up = "root";
        xtVar.f25640g = 1280.0f;
        xtVar.f25642m = tlVar2;
        tlVar2.cw(f6);
        xtVar.f25642m.r(xtVar.xt);
        xtVar.f25642m.up(xtVar.cw);
        xtVar.f25642m.m(xtVar.f25643r);
        com.bytedance.sdk.component.adexpress.dynamic.cw.xt j7 = j(xtVar, 0.0f);
        this.f25795j = j7;
        j(j7);
    }

    public void j(com.bytedance.sdk.component.adexpress.dynamic.cw.xt xtVar) {
        if (xtVar == null) {
            return;
        }
        xtVar.f25642m.oq().getType();
        List<List<com.bytedance.sdk.component.adexpress.dynamic.cw.xt>> list = xtVar.ae;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (List<com.bytedance.sdk.component.adexpress.dynamic.cw.xt> list2 : list) {
            if (list2 != null && list2.size() > 0) {
                Iterator<com.bytedance.sdk.component.adexpress.dynamic.cw.xt> it = list2.iterator();
                while (it.hasNext()) {
                    j(it.next());
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x027d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.bytedance.sdk.component.adexpress.dynamic.cw.xt j(com.bytedance.sdk.component.adexpress.dynamic.cw.xt r38, float r39) {
        /*
            Method dump skipped, instructions count: 1010
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.dynamic.r.up.j(com.bytedance.sdk.component.adexpress.dynamic.cw.xt, float):com.bytedance.sdk.component.adexpress.dynamic.cw.xt");
    }

    private com.bytedance.sdk.component.adexpress.dynamic.cw.g j(com.bytedance.sdk.component.adexpress.dynamic.cw.m mVar, xt.cw cwVar, xt.cw cwVar2) {
        float ln = mVar.ln();
        float im = mVar.im();
        float xp = mVar.xp();
        float y5 = mVar.y();
        boolean ff = mVar.ff();
        boolean ry = mVar.ry();
        boolean zz = mVar.zz();
        boolean kc = mVar.kc();
        if (!ff) {
            if (ry) {
                float f6 = this.f25796r.f25797j;
                ln = ((f6 != 0.0f ? Math.min(f6, cwVar.f25802j) : cwVar.f25802j) - xp) - cwVar2.f25802j;
            } else {
                ln = 0.0f;
            }
        }
        if (!zz) {
            if (kc) {
                float f7 = this.f25796r.xt;
                if (f7 == 0.0f) {
                    f7 = cwVar.xt;
                }
                im = (f7 - y5) - cwVar2.xt;
            } else {
                im = 0.0f;
            }
        }
        return new com.bytedance.sdk.component.adexpress.dynamic.cw.g(ln, im);
    }

    private com.bytedance.sdk.component.adexpress.dynamic.cw.g j(com.bytedance.sdk.component.adexpress.dynamic.cw.xt xtVar, com.bytedance.sdk.component.adexpress.dynamic.cw.m mVar, float f6, float f7) {
        float f8;
        float f9;
        float f10 = xtVar.f25641j;
        float f11 = xtVar.xt;
        float ln = mVar.ln();
        float im = mVar.im();
        float xp = mVar.xp();
        float y5 = mVar.y();
        boolean ff = mVar.ff();
        boolean ry = mVar.ry();
        boolean zz = mVar.zz();
        boolean kc = mVar.kc();
        String k6 = mVar.k();
        float f12 = xtVar.cw;
        float f13 = xtVar.f25643r;
        if (TextUtils.equals(k6, "0")) {
            if (ff) {
                f10 = xtVar.f25641j + ln;
            } else if (ry) {
                f10 = ((xtVar.f25641j + f12) - xp) - f6;
            }
            if (zz) {
                f9 = xtVar.xt;
                f11 = f9 + im;
            } else if (kc) {
                f8 = xtVar.xt;
                f11 = ((f8 + f13) - y5) - f7;
            }
        } else if (TextUtils.equals(k6, "1")) {
            f10 = xtVar.f25641j + ((f12 - f6) / 2.0f);
            if (zz) {
                f9 = xtVar.xt;
                f11 = f9 + im;
            } else if (kc) {
                f8 = xtVar.xt;
                f11 = ((f8 + f13) - y5) - f7;
            }
        } else if (TextUtils.equals(k6, "2")) {
            f11 = xtVar.xt + ((f13 - f7) / 2.0f);
            if (ff) {
                f10 = xtVar.f25641j + ln;
            } else if (ry) {
                f10 = ((xtVar.f25641j + f12) - xp) - f6;
            }
        } else if (TextUtils.equals(k6, "3")) {
            f10 = xtVar.f25641j + ((f12 - f6) / 2.0f);
            f11 = xtVar.xt + ((f13 - f7) / 2.0f);
        }
        return new com.bytedance.sdk.component.adexpress.dynamic.cw.g(f10, f11);
    }
}
