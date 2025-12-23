package com.bytedance.adsdk.lottie.model.layer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.LongSparseArray;
import com.bytedance.adsdk.lottie.model.layer.tl;
import com.bytedance.component.sdk.annotation.FloatRange;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class r extends cw {
    private com.bytedance.adsdk.lottie.j.xt.j<Float, Float> ae;

    /* renamed from: g, reason: collision with root package name */
    private final RectF f23397g;
    private final RectF oq;
    private final Paint qv;
    private final List<cw> tl;
    private boolean vl;

    @Override // com.bytedance.adsdk.lottie.model.layer.cw
    public void j(boolean z5) {
        super.j(z5);
        Iterator<cw> it = this.tl.iterator();
        while (it.hasNext()) {
            it.next().j(z5);
        }
    }

    public void xt(boolean z5) {
        this.vl = z5;
    }

    /* renamed from: com.bytedance.adsdk.lottie.model.layer.r$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: j, reason: collision with root package name */
        static final /* synthetic */ int[] f23398j;

        static {
            int[] iArr = new int[tl.xt.values().length];
            f23398j = iArr;
            try {
                iArr[tl.xt.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23398j[tl.xt.INVERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public List<cw> ws() {
        return this.tl;
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.cw
    public void xt(Canvas canvas, Matrix matrix, int i6) {
        super.xt(canvas, matrix, i6);
        com.bytedance.adsdk.lottie.up.j("CompositionLayer#draw");
        this.oq.set(0.0f, 0.0f, this.cw.tl(), this.cw.g());
        matrix.mapRect(this.oq);
        boolean z5 = this.xt.oq() && this.tl.size() > 1 && i6 != 255;
        if (z5) {
            this.qv.setAlpha(i6);
            com.bytedance.adsdk.lottie.up.g.j(canvas, this.oq, this.qv);
        } else {
            canvas.save();
        }
        if (z5) {
            i6 = 255;
        }
        for (int size = this.tl.size() - 1; size >= 0; size--) {
            if (((this.vl || !"__container".equals(this.cw.m())) && !this.oq.isEmpty()) ? canvas.clipRect(this.oq) : true) {
                this.tl.get(size).j(canvas, matrix, i6);
            }
        }
        canvas.restore();
        com.bytedance.adsdk.lottie.up.xt("CompositionLayer#draw");
    }

    public r(com.bytedance.adsdk.lottie.tl tlVar, tl tlVar2, List<tl> list, com.bytedance.adsdk.lottie.m mVar, Context context) {
        super(tlVar, tlVar2);
        int i6;
        cw cwVar;
        tl.xt vl;
        int i7;
        this.tl = new ArrayList();
        this.f23397g = new RectF();
        this.oq = new RectF();
        this.qv = new Paint();
        this.vl = true;
        com.bytedance.adsdk.lottie.model.j.xt tj = tlVar2.tj();
        if (tj != null) {
            com.bytedance.adsdk.lottie.j.xt.j<Float, Float> j6 = tj.j();
            this.ae = j6;
            j(j6);
            this.ae.j(this);
        } else {
            this.ae = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(mVar.ws().size());
        int size = list.size() - 1;
        cw cwVar2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            tl tlVar3 = list.get(size);
            cw j7 = cw.j(this, tlVar3, tlVar, mVar, context);
            if (j7 != null) {
                longSparseArray.put(j7.r().up(), j7);
                if (cwVar2 != null) {
                    cwVar2.j(j7);
                    cwVar2 = null;
                } else {
                    this.tl.add(0, j7);
                    if (tlVar3 != null && (vl = tlVar3.vl()) != null && ((i7 = AnonymousClass1.f23398j[vl.ordinal()]) == 1 || i7 == 2)) {
                        cwVar2 = j7;
                    }
                }
            }
            size--;
        }
        for (i6 = 0; i6 < longSparseArray.size(); i6++) {
            cw cwVar3 = (cw) longSparseArray.get(longSparseArray.keyAt(i6));
            if (cwVar3 != null && (cwVar = (cw) longSparseArray.get(cwVar3.r().jy())) != null) {
                cwVar3.xt(cwVar);
            }
        }
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.cw, com.bytedance.adsdk.lottie.j.j.up
    public void j(RectF rectF, Matrix matrix, boolean z5) {
        super.j(rectF, matrix, z5);
        for (int size = this.tl.size() - 1; size >= 0; size--) {
            this.f23397g.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.tl.get(size).j(this.f23397g, this.f23375j, true);
            rectF.union(this.f23397g);
        }
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.cw
    public void j(@FloatRange(from = 0.0d, to = 1.0d) float f6) {
        super.j(f6);
        if (this.ae != null) {
            f6 = ((this.ae.ae().floatValue() * this.cw.j().jy()) - this.cw.j().m()) / (this.xt.a().w() + 0.01f);
        }
        if (this.ae == null) {
            f6 -= this.cw.cw();
        }
        if (this.cw.xt() != 0.0f && !"__container".equals(this.cw.m())) {
            f6 /= this.cw.xt();
        }
        for (int size = this.tl.size() - 1; size >= 0; size--) {
            this.tl.get(size).j(f6);
        }
    }
}
