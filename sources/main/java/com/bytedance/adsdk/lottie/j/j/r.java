package com.bytedance.adsdk.lottie.j.j;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.bytedance.adsdk.lottie.j.xt.j;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class r implements jy, up, j.InterfaceC0316j {
    private final boolean ae;
    private final Matrix cw;

    /* renamed from: g, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.tl f23268g;

    /* renamed from: j, reason: collision with root package name */
    private final Paint f23269j;

    /* renamed from: m, reason: collision with root package name */
    private final String f23270m;
    private List<jy> oq;
    private com.bytedance.adsdk.lottie.j.xt.av qv;

    /* renamed from: r, reason: collision with root package name */
    private final Path f23271r;
    private final List<cw> tl;
    private final RectF up;
    private final RectF xt;

    public r(com.bytedance.adsdk.lottie.tl tlVar, com.bytedance.adsdk.lottie.model.layer.cw cwVar, com.bytedance.adsdk.lottie.model.xt.av avVar, com.bytedance.adsdk.lottie.m mVar) {
        this(tlVar, cwVar, avVar.j(), avVar.cw(), j(tlVar, mVar, cwVar, avVar.xt()), j(avVar.xt()));
    }

    private static List<cw> j(com.bytedance.adsdk.lottie.tl tlVar, com.bytedance.adsdk.lottie.m mVar, com.bytedance.adsdk.lottie.model.layer.cw cwVar, List<com.bytedance.adsdk.lottie.model.xt.cw> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i6 = 0; i6 < list.size(); i6++) {
            cw j6 = list.get(i6).j(tlVar, mVar, cwVar);
            if (j6 != null) {
                arrayList.add(j6);
            }
        }
        return arrayList;
    }

    private boolean up() {
        int i6 = 0;
        for (int i7 = 0; i7 < this.tl.size(); i7++) {
            if ((this.tl.get(i7) instanceof up) && (i6 = i6 + 1) >= 2) {
                return true;
            }
        }
        return false;
    }

    Matrix cw() {
        com.bytedance.adsdk.lottie.j.xt.av avVar = this.qv;
        if (avVar != null) {
            return avVar.r();
        }
        this.cw.reset();
        return this.cw;
    }

    @Override // com.bytedance.adsdk.lottie.j.j.jy
    public Path r() {
        this.cw.reset();
        com.bytedance.adsdk.lottie.j.xt.av avVar = this.qv;
        if (avVar != null) {
            this.cw.set(avVar.r());
        }
        this.f23271r.reset();
        if (this.ae) {
            return this.f23271r;
        }
        for (int size = this.tl.size() - 1; size >= 0; size--) {
            cw cwVar = this.tl.get(size);
            if (cwVar instanceof jy) {
                this.f23271r.addPath(((jy) cwVar).r(), this.cw);
            }
        }
        return this.f23271r;
    }

    List<jy> xt() {
        if (this.oq == null) {
            this.oq = new ArrayList();
            for (int i6 = 0; i6 < this.tl.size(); i6++) {
                cw cwVar = this.tl.get(i6);
                if (cwVar instanceof jy) {
                    this.oq.add((jy) cwVar);
                }
            }
        }
        return this.oq;
    }

    r(com.bytedance.adsdk.lottie.tl tlVar, com.bytedance.adsdk.lottie.model.layer.cw cwVar, String str, boolean z5, List<cw> list, com.bytedance.adsdk.lottie.model.j.vl vlVar) {
        this.f23269j = new com.bytedance.adsdk.lottie.j.j();
        this.xt = new RectF();
        this.cw = new Matrix();
        this.f23271r = new Path();
        this.up = new RectF();
        this.f23270m = str;
        this.f23268g = tlVar;
        this.ae = z5;
        this.tl = list;
        if (vlVar != null) {
            com.bytedance.adsdk.lottie.j.xt.av oq = vlVar.oq();
            this.qv = oq;
            oq.j(cwVar);
            this.qv.j(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            cw cwVar2 = list.get(size);
            if (cwVar2 instanceof oq) {
                arrayList.add((oq) cwVar2);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((oq) arrayList.get(size2)).j(list.listIterator(list.size()));
        }
    }

    static com.bytedance.adsdk.lottie.model.j.vl j(List<com.bytedance.adsdk.lottie.model.xt.cw> list) {
        for (int i6 = 0; i6 < list.size(); i6++) {
            com.bytedance.adsdk.lottie.model.xt.cw cwVar = list.get(i6);
            if (cwVar instanceof com.bytedance.adsdk.lottie.model.j.vl) {
                return (com.bytedance.adsdk.lottie.model.j.vl) cwVar;
            }
        }
        return null;
    }

    @Override // com.bytedance.adsdk.lottie.j.xt.j.InterfaceC0316j
    public void j() {
        this.f23268g.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.lottie.j.j.cw
    public void j(List<cw> list, List<cw> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.tl.size());
        arrayList.addAll(list);
        for (int size = this.tl.size() - 1; size >= 0; size--) {
            cw cwVar = this.tl.get(size);
            cwVar.j(arrayList, this.tl.subList(0, size));
            arrayList.add(cwVar);
        }
    }

    @Override // com.bytedance.adsdk.lottie.j.j.up
    public void j(Canvas canvas, Matrix matrix, int i6) {
        if (this.ae) {
            return;
        }
        this.cw.set(matrix);
        com.bytedance.adsdk.lottie.j.xt.av avVar = this.qv;
        if (avVar != null) {
            this.cw.preConcat(avVar.r());
            i6 = (int) (((((this.qv.j() == null ? 100 : this.qv.j().ae().intValue()) / 100.0f) * i6) / 255.0f) * 255.0f);
        }
        boolean z5 = this.f23268g.oq() && up() && i6 != 255;
        if (z5) {
            this.xt.set(0.0f, 0.0f, 0.0f, 0.0f);
            j(this.xt, this.cw, true);
            this.f23269j.setAlpha(i6);
            com.bytedance.adsdk.lottie.up.g.j(canvas, this.xt, this.f23269j);
        }
        if (z5) {
            i6 = 255;
        }
        for (int size = this.tl.size() - 1; size >= 0; size--) {
            cw cwVar = this.tl.get(size);
            if (cwVar instanceof up) {
                ((up) cwVar).j(canvas, this.cw, i6);
            }
        }
        if (z5) {
            canvas.restore();
        }
    }

    @Override // com.bytedance.adsdk.lottie.j.j.up
    public void j(RectF rectF, Matrix matrix, boolean z5) {
        this.cw.set(matrix);
        com.bytedance.adsdk.lottie.j.xt.av avVar = this.qv;
        if (avVar != null) {
            this.cw.preConcat(avVar.r());
        }
        this.up.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.tl.size() - 1; size >= 0; size--) {
            cw cwVar = this.tl.get(size);
            if (cwVar instanceof up) {
                ((up) cwVar).j(this.up, this.cw, z5);
                rectF.union(this.up);
            }
        }
    }
}
