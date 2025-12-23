package com.bytedance.sdk.component.adexpress.dynamic.r;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.xt.jy;
import com.bytedance.sdk.component.utils.vl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {
    private double ae;

    /* renamed from: g, reason: collision with root package name */
    private jy f25798g;

    /* renamed from: m, reason: collision with root package name */
    private int f25800m;
    private String tl;
    private double up;

    /* renamed from: j, reason: collision with root package name */
    public Map<String, cw> f25799j = new HashMap();
    public Map<String, cw> xt = new HashMap();
    public Map<String, cw> cw = new HashMap();

    /* renamed from: r, reason: collision with root package name */
    private double f25801r = Math.random();

    static class cw {

        /* renamed from: j, reason: collision with root package name */
        float f25802j;
        float xt;

        public cw() {
        }

        public cw(float f6, float f7) {
            this.f25802j = f6;
            this.xt = f7;
        }

        public String toString() {
            return "UnitSize{width=" + this.f25802j + ", height=" + this.xt + '}';
        }
    }

    /* renamed from: com.bytedance.sdk.component.adexpress.dynamic.r.xt$xt, reason: collision with other inner class name */
    static class C0396xt {
        int cw;

        /* renamed from: j, reason: collision with root package name */
        float f25804j;

        /* renamed from: r, reason: collision with root package name */
        double f25805r;
        float up;
        int xt;

        static JSONObject j(C0396xt c0396xt) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("fontSize", c0396xt.f25804j);
                jSONObject.put("letterSpacing", c0396xt.xt);
                jSONObject.put("lineHeight", c0396xt.f25805r);
                jSONObject.put("maxWidth", c0396xt.up);
                jSONObject.put("fontWeight", c0396xt.cw);
                return jSONObject;
            } catch (JSONException e6) {
                vl.j(e6);
                return jSONObject;
            }
        }

        C0396xt() {
        }
    }

    private cw up(com.bytedance.sdk.component.adexpress.dynamic.cw.tl tlVar, float f6, float f7) {
        String str = tlVar.cw() + "_" + f6 + "_" + f7;
        if (this.cw.containsKey(str)) {
            return this.cw.get(str);
        }
        cw m6 = m(tlVar, f6, f7);
        this.cw.put(str, m6);
        return m6;
    }

    public cw cw(com.bytedance.sdk.component.adexpress.dynamic.cw.tl tlVar, float f6, float f7) {
        if (tlVar == null) {
            return null;
        }
        cw j6 = j(tlVar);
        if (j6 != null && (j6.f25802j != 0.0f || j6.xt != 0.0f)) {
            return j6;
        }
        cw r5 = r(tlVar, f6, f7);
        j(tlVar, r5);
        return r5;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.bytedance.sdk.component.adexpress.dynamic.r.xt.cw j(com.bytedance.sdk.component.adexpress.dynamic.cw.tl r13, float r14, float r15) {
        /*
            r12 = this;
            com.bytedance.sdk.component.adexpress.dynamic.cw.up r0 = r13.oq()
            java.lang.String r0 = r0.xt()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r1 = 0
            if (r0 == 0) goto L23
            com.bytedance.sdk.component.adexpress.dynamic.cw.up r0 = r13.oq()
            com.bytedance.sdk.component.adexpress.dynamic.cw.m r0 = r0.up()
            java.lang.String r0 = r0.aq()
            if (r0 != 0) goto L23
            com.bytedance.sdk.component.adexpress.dynamic.r.xt$cw r13 = new com.bytedance.sdk.component.adexpress.dynamic.r.xt$cw
            r13.<init>(r1, r1)
            return r13
        L23:
            com.bytedance.sdk.component.adexpress.dynamic.cw.up r0 = r13.oq()
            java.lang.String r0 = r0.getType()
            java.lang.String r2 = "creative-playable-bait"
            boolean r0 = android.text.TextUtils.equals(r0, r2)
            if (r0 == 0) goto L39
            com.bytedance.sdk.component.adexpress.dynamic.r.xt$cw r13 = new com.bytedance.sdk.component.adexpress.dynamic.r.xt$cw
            r13.<init>(r1, r1)
            return r13
        L39:
            float r0 = r13.tl()
            float r1 = r13.g()
            com.bytedance.sdk.component.adexpress.dynamic.cw.up r2 = r13.oq()
            com.bytedance.sdk.component.adexpress.dynamic.cw.m r2 = r2.up()
            java.lang.String r3 = r2.l()
            java.lang.String r2 = r2.a()
            int r4 = r13.jy()
            float r4 = (float) r4
            int r5 = r13.ws()
            float r5 = (float) r5
            float r6 = r13.az()
            float r7 = r13.av()
            java.lang.String r8 = "fixed"
            boolean r9 = android.text.TextUtils.equals(r3, r8)
            java.lang.String r10 = "flex"
            java.lang.String r11 = "auto"
            if (r9 == 0) goto L86
            float r14 = java.lang.Math.min(r0, r14)
            boolean r0 = android.text.TextUtils.equals(r2, r11)
            if (r0 == 0) goto Lb7
            float r0 = r14 - r6
            float r1 = r15 - r7
            com.bytedance.sdk.component.adexpress.dynamic.r.xt$cw r13 = r12.xt(r13, r0, r1)
            float r13 = r13.xt
        L83:
            float r1 = r13 + r7
            goto Lb7
        L86:
            boolean r9 = android.text.TextUtils.equals(r3, r11)
            if (r9 == 0) goto L9f
            float r14 = r14 - r6
            float r0 = r15 - r7
            com.bytedance.sdk.component.adexpress.dynamic.r.xt$cw r13 = r12.xt(r13, r14, r0)
            float r14 = r13.f25802j
            float r14 = r14 + r6
            boolean r0 = android.text.TextUtils.equals(r2, r11)
            if (r0 == 0) goto Lb7
            float r13 = r13.xt
            goto L83
        L9f:
            boolean r3 = android.text.TextUtils.equals(r3, r10)
            if (r3 == 0) goto Lb6
            boolean r0 = android.text.TextUtils.equals(r2, r11)
            if (r0 == 0) goto Lb7
            float r0 = r14 - r6
            float r1 = r15 - r7
            com.bytedance.sdk.component.adexpress.dynamic.r.xt$cw r13 = r12.xt(r13, r0, r1)
            float r13 = r13.xt
            goto L83
        Lb6:
            r14 = r0
        Lb7:
            java.lang.String r13 = "scale"
            boolean r13 = android.text.TextUtils.equals(r2, r13)
            if (r13 == 0) goto Lda
            float r13 = r14 - r4
            float r13 = r13 / r1
            int r13 = java.lang.Math.round(r13)
            float r13 = (float) r13
            float r13 = r13 + r5
            int r0 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r0 <= 0) goto Ld8
            float r13 = r15 - r5
            float r13 = r13 * r1
            int r13 = java.lang.Math.round(r13)
            float r13 = (float) r13
            float r14 = r13 + r4
            goto Lee
        Ld8:
            r15 = r13
            goto Lee
        Lda:
            boolean r13 = android.text.TextUtils.equals(r2, r8)
            if (r13 == 0) goto Le6
            float r1 = r1 + r5
            float r15 = java.lang.Math.min(r1, r15)
            goto Lee
        Le6:
            boolean r13 = android.text.TextUtils.equals(r2, r10)
            if (r13 == 0) goto Led
            goto Lee
        Led:
            r15 = r1
        Lee:
            com.bytedance.sdk.component.adexpress.dynamic.r.xt$cw r13 = new com.bytedance.sdk.component.adexpress.dynamic.r.xt$cw
            r13.<init>()
            r13.f25802j = r14
            r13.xt = r15
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.dynamic.r.xt.j(com.bytedance.sdk.component.adexpress.dynamic.cw.tl, float, float):com.bytedance.sdk.component.adexpress.dynamic.r.xt$cw");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x011a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.bytedance.sdk.component.adexpress.dynamic.r.xt.cw r(com.bytedance.sdk.component.adexpress.dynamic.cw.tl r22, float r23, float r24) {
        /*
            Method dump skipped, instructions count: 343
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.dynamic.r.xt.r(com.bytedance.sdk.component.adexpress.dynamic.cw.tl, float, float):com.bytedance.sdk.component.adexpress.dynamic.r.xt$cw");
    }

    public cw xt(com.bytedance.sdk.component.adexpress.dynamic.cw.tl tlVar, float f6, float f7) {
        cw cwVar = new cw();
        if (tlVar.oq().up() == null) {
            return cwVar;
        }
        cw up = up(tlVar, f6, f7);
        float f8 = up.f25802j;
        float f9 = up.xt;
        cwVar.f25802j = Math.min(f8, f6);
        cwVar.xt = Math.min(f9, f7);
        return cwVar;
    }

    static class j implements Cloneable {
        float cw;

        /* renamed from: j, reason: collision with root package name */
        float f25803j;
        boolean xt;

        j() {
        }

        public Object clone() {
            try {
                return (j) super.clone();
            } catch (CloneNotSupportedException e6) {
                vl.j(e6);
                return null;
            }
        }
    }

    public xt(double d6, int i6, double d7, String str, jy jyVar) {
        this.up = d6;
        this.f25800m = i6;
        this.ae = d7;
        this.tl = str;
        this.f25798g = jyVar;
    }

    private cw m(com.bytedance.sdk.component.adexpress.dynamic.cw.tl tlVar, float f6, float f7) {
        com.bytedance.sdk.component.adexpress.dynamic.cw.m up = tlVar.oq().up();
        float w5 = up.w();
        int q5 = up.q();
        double e6 = up.e();
        int ya = up.ya();
        boolean rh = up.rh();
        boolean sm = up.sm();
        int ol = up.ol();
        C0396xt c0396xt = new C0396xt();
        c0396xt.f25804j = w5;
        c0396xt.xt = q5;
        c0396xt.cw = ya;
        c0396xt.f25805r = e6;
        c0396xt.up = f6;
        return j(tlVar.oq().xt(), c0396xt, rh, sm, ol, tlVar);
    }

    private cw cw(List<com.bytedance.sdk.component.adexpress.dynamic.cw.tl> list, float f6, float f7) {
        float f8;
        r(list);
        cw cwVar = new cw();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (com.bytedance.sdk.component.adexpress.dynamic.cw.tl tlVar : list) {
            com.bytedance.sdk.component.adexpress.dynamic.cw.m up = tlVar.oq().up();
            if (up.xq() == 1 || up.xq() == 2) {
                arrayList.add(tlVar);
            }
            if (up.xq() != 1 && up.xq() != 2) {
                arrayList2.add(tlVar);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            cw((com.bytedance.sdk.component.adexpress.dynamic.cw.tl) it.next(), f6, f7);
        }
        if (arrayList2.size() <= 0) {
            return cwVar;
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.cw.tl> it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            arrayList3.add(Float.valueOf(cw(it2.next(), f6, f7).f25802j));
        }
        ArrayList arrayList4 = new ArrayList();
        int i6 = 0;
        while (true) {
            if (i6 >= arrayList2.size()) {
                break;
            }
            com.bytedance.sdk.component.adexpress.dynamic.cw.tl tlVar2 = arrayList2.get(i6);
            String l6 = tlVar2.oq().up().l();
            float tl = tlVar2.tl();
            boolean equals = TextUtils.equals(l6, "flex");
            if (TextUtils.equals(l6, "auto")) {
                List<List<com.bytedance.sdk.component.adexpress.dynamic.cw.tl>> i7 = tlVar2.i();
                if (i7 != null && i7.size() > 0) {
                    Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.cw.tl>> it3 = i7.iterator();
                    while (it3.hasNext()) {
                        if (xt(it3.next())) {
                            equals = true;
                            break;
                        }
                    }
                }
                equals = false;
            }
            j jVar = new j();
            if (!equals) {
                tl = ((Float) arrayList3.get(i6)).floatValue();
            }
            jVar.f25803j = tl;
            jVar.xt = !equals;
            if (equals) {
                f8 = ((Float) arrayList3.get(i6)).floatValue();
            }
            jVar.cw = f8;
            arrayList4.add(jVar);
            i6++;
        }
        j(arrayList4, f6, arrayList2);
        List<j> j6 = oq.j(f6, arrayList4);
        float f9 = 0.0f;
        for (int i8 = 0; i8 < arrayList2.size(); i8++) {
            f9 += j6.get(i8).f25803j;
            if (((Float) arrayList3.get(i8)).floatValue() != j6.get(i8).f25803j) {
                r(arrayList2.get(i8));
            }
        }
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.cw.tl> it4 = arrayList2.iterator();
        int i9 = 0;
        boolean z5 = false;
        while (true) {
            if (!it4.hasNext()) {
                break;
            }
            i9++;
            if (!xt(it4.next())) {
                z5 = false;
                break;
            }
            if (i9 == arrayList2.size()) {
                z5 = true;
            }
        }
        f8 = z5 ? f7 : 0.0f;
        ArrayList arrayList5 = new ArrayList();
        for (int i10 = 0; i10 < arrayList2.size(); i10++) {
            com.bytedance.sdk.component.adexpress.dynamic.cw.tl tlVar3 = arrayList2.get(i10);
            cw cw2 = cw(tlVar3, j6.get(i10).f25803j, f7);
            if (!xt(tlVar3)) {
                f8 = Math.max(f8, cw2.xt);
            }
            arrayList5.add(cw2);
        }
        ArrayList arrayList6 = new ArrayList();
        Iterator it5 = arrayList5.iterator();
        while (it5.hasNext()) {
            arrayList6.add(Float.valueOf(((cw) it5.next()).xt));
        }
        if (!z5) {
            for (int i11 = 0; i11 < arrayList2.size(); i11++) {
                com.bytedance.sdk.component.adexpress.dynamic.cw.tl tlVar4 = arrayList2.get(i11);
                if (xt(tlVar4) && ((Float) arrayList6.get(i11)).floatValue() != f8) {
                    r(tlVar4);
                    cw(tlVar4, j6.get(i11).f25803j, f8);
                }
            }
        }
        cwVar.f25802j = f9;
        cwVar.xt = f8;
        return cwVar;
    }

    private boolean xt(List<com.bytedance.sdk.component.adexpress.dynamic.cw.tl> list) {
        List<List<com.bytedance.sdk.component.adexpress.dynamic.cw.tl>> i6;
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.cw.tl> it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().oq().up().l(), "flex")) {
                return true;
            }
        }
        while (true) {
            boolean z5 = false;
            for (com.bytedance.sdk.component.adexpress.dynamic.cw.tl tlVar : list) {
                if (TextUtils.equals(tlVar.oq().up().l(), "auto") && (i6 = tlVar.i()) != null) {
                    int i7 = 0;
                    for (List<com.bytedance.sdk.component.adexpress.dynamic.cw.tl> list2 : i6) {
                        i7++;
                        if (!xt(list2)) {
                            break;
                        }
                        if (i7 == list2.size()) {
                            z5 = true;
                        }
                    }
                }
            }
            return z5;
        }
    }

    private String up(com.bytedance.sdk.component.adexpress.dynamic.cw.tl tlVar) {
        return tlVar.cw();
    }

    private cw xt(List<com.bytedance.sdk.component.adexpress.dynamic.cw.tl> list, float f6, float f7) {
        cw j6 = j(list);
        if (j6 != null && (j6.f25802j != 0.0f || j6.xt != 0.0f)) {
            return j6;
        }
        cw cw2 = cw(list, f6, f7);
        j(list, cw2);
        return cw2;
    }

    private boolean xt(com.bytedance.sdk.component.adexpress.dynamic.cw.tl tlVar) {
        if (tlVar == null) {
            return false;
        }
        if (TextUtils.equals(tlVar.oq().up().a(), "flex")) {
            return true;
        }
        return cw(tlVar);
    }

    private cw j(String str, C0396xt c0396xt, boolean z5, boolean z6, int i6, com.bytedance.sdk.component.adexpress.dynamic.cw.tl tlVar) {
        return qv.j(str, tlVar.oq().getType(), C0396xt.j(c0396xt).toString(), z5, z6, i6, tlVar, this.up, this.f25800m, this.ae, this.tl, this.f25798g);
    }

    private void j(List<List<com.bytedance.sdk.component.adexpress.dynamic.cw.tl>> list, float f6, float f7) {
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.cw.tl>> it = list.iterator();
        boolean z5 = false;
        while (it.hasNext()) {
            if (j(it.next(), false)) {
                z5 = true;
            }
        }
        ArrayList arrayList = new ArrayList();
        for (List<com.bytedance.sdk.component.adexpress.dynamic.cw.tl> list2 : list) {
            j jVar = new j();
            boolean j6 = j(list2, !z5);
            jVar.f25803j = j6 ? 1.0f : xt(list2, f6, f7).xt;
            jVar.xt = !j6;
            arrayList.add(jVar);
        }
        List<j> j7 = oq.j(f7, arrayList);
        for (int i6 = 0; i6 < list.size(); i6++) {
            if (((j) arrayList.get(i6)).f25803j != j7.get(i6).f25803j) {
                List<com.bytedance.sdk.component.adexpress.dynamic.cw.tl> list3 = list.get(i6);
                cw(list3);
                xt(list3, f6, j7.get(i6).f25803j);
            }
        }
    }

    private void r(com.bytedance.sdk.component.adexpress.dynamic.cw.tl tlVar) {
        this.f25799j.remove(up(tlVar));
        List<List<com.bytedance.sdk.component.adexpress.dynamic.cw.tl>> i6 = tlVar.i();
        if (i6 == null || i6.size() <= 0) {
            return;
        }
        Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.cw.tl>> it = i6.iterator();
        while (it.hasNext()) {
            cw(it.next());
        }
    }

    private String r(List<com.bytedance.sdk.component.adexpress.dynamic.cw.tl> list) {
        StringBuilder sb = new StringBuilder();
        for (int i6 = 0; i6 < list.size(); i6++) {
            String cw2 = list.get(i6).cw();
            if (i6 < list.size() - 1) {
                sb.append(cw2);
                sb.append("-");
            } else {
                sb.append(cw2);
            }
        }
        return sb.toString();
    }

    private boolean j(List<com.bytedance.sdk.component.adexpress.dynamic.cw.tl> list, boolean z5) {
        for (com.bytedance.sdk.component.adexpress.dynamic.cw.tl tlVar : list) {
            com.bytedance.sdk.component.adexpress.dynamic.cw.m up = tlVar.oq().up();
            String a6 = up.a();
            if (TextUtils.equals(a6, "flex") || (z5 && ((TextUtils.equals(up.l(), "flex") && TextUtils.equals(up.a(), "scale") && com.bytedance.sdk.component.adexpress.dynamic.cw.up.f25637j.get(tlVar.oq().getType()).intValue() == 7) || TextUtils.equals(a6, "flex")))) {
                return true;
            }
        }
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.cw.tl> it = list.iterator();
        while (it.hasNext()) {
            if (cw(it.next())) {
                return true;
            }
        }
        return false;
    }

    private boolean cw(com.bytedance.sdk.component.adexpress.dynamic.cw.tl tlVar) {
        List<List<com.bytedance.sdk.component.adexpress.dynamic.cw.tl>> i6;
        if (!tlVar.w() && TextUtils.equals(tlVar.oq().up().a(), "auto") && (i6 = tlVar.i()) != null && i6.size() > 0) {
            if (i6.size() == 1) {
                Iterator<com.bytedance.sdk.component.adexpress.dynamic.cw.tl> it = i6.get(0).iterator();
                while (it.hasNext()) {
                    if (!xt(it.next())) {
                        return false;
                    }
                }
                return true;
            }
            Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.cw.tl>> it2 = i6.iterator();
            while (it2.hasNext()) {
                if (j(it2.next(), true)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void j(List<j> list, float f6, List<com.bytedance.sdk.component.adexpress.dynamic.cw.tl> list2) {
        float f7 = 0.0f;
        for (j jVar : list) {
            if (jVar.xt) {
                f7 += jVar.f25803j;
            }
        }
        if (f7 > f6) {
            int i6 = 0;
            for (int i7 = 0; i7 < list2.size(); i7++) {
                if (list.get(i7).xt && list2.get(i7).f()) {
                    i6++;
                }
            }
            if (i6 > 0) {
                float ceil = (float) (Math.ceil(((f7 - f6) / i6) * 1000.0f) / 1000.0d);
                for (int i8 = 0; i8 < list2.size(); i8++) {
                    j jVar2 = list.get(i8);
                    if (jVar2.xt && list2.get(i8).f()) {
                        jVar2.f25803j -= ceil;
                    }
                }
            }
        }
    }

    private void cw(List<com.bytedance.sdk.component.adexpress.dynamic.cw.tl> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.xt.remove(r(list));
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.cw.tl> it = list.iterator();
        while (it.hasNext()) {
            r(it.next());
        }
    }

    public void j() {
        this.cw.clear();
        this.f25799j.clear();
        this.xt.clear();
    }

    public cw j(com.bytedance.sdk.component.adexpress.dynamic.cw.tl tlVar) {
        return this.f25799j.get(up(tlVar));
    }

    public cw j(List<com.bytedance.sdk.component.adexpress.dynamic.cw.tl> list) {
        return this.xt.get(r(list));
    }

    private void j(com.bytedance.sdk.component.adexpress.dynamic.cw.tl tlVar, cw cwVar) {
        this.f25799j.put(up(tlVar), cwVar);
    }

    private void j(List<com.bytedance.sdk.component.adexpress.dynamic.cw.tl> list, cw cwVar) {
        this.xt.put(r(list), cwVar);
    }
}
