package com.bytedance.adsdk.lottie.j.j;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.bytedance.adsdk.lottie.j.xt.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* loaded from: D:\Downloads\app\classes3.dex */
public class av implements jy, oq, qv, up, j.InterfaceC0316j {
    private final com.bytedance.adsdk.lottie.j.xt.j<Float, Float> ae;
    private final com.bytedance.adsdk.lottie.tl cw;

    /* renamed from: g, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.j.xt.av f23244g;

    /* renamed from: m, reason: collision with root package name */
    private final boolean f23246m;
    private r oq;

    /* renamed from: r, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.model.layer.cw f23247r;
    private final com.bytedance.adsdk.lottie.j.xt.j<Float, Float> tl;
    private final String up;

    /* renamed from: j, reason: collision with root package name */
    private final Matrix f23245j = new Matrix();
    private final Path xt = new Path();

    @Override // com.bytedance.adsdk.lottie.j.j.oq
    public void j(ListIterator<cw> listIterator) {
        if (this.oq != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.oq = new r(this.cw, this.f23247r, "Repeater", this.f23246m, arrayList, null);
    }

    @Override // com.bytedance.adsdk.lottie.j.j.jy
    public Path r() {
        Path r5 = this.oq.r();
        this.xt.reset();
        float floatValue = this.ae.ae().floatValue();
        float floatValue2 = this.tl.ae().floatValue();
        for (int i6 = ((int) floatValue) - 1; i6 >= 0; i6--) {
            this.f23245j.set(this.f23244g.xt(i6 + floatValue2));
            this.xt.addPath(r5, this.f23245j);
        }
        return this.xt;
    }

    public av(com.bytedance.adsdk.lottie.tl tlVar, com.bytedance.adsdk.lottie.model.layer.cw cwVar, com.bytedance.adsdk.lottie.model.xt.vl vlVar) {
        this.cw = tlVar;
        this.f23247r = cwVar;
        this.up = vlVar.j();
        this.f23246m = vlVar.up();
        com.bytedance.adsdk.lottie.j.xt.j<Float, Float> j6 = vlVar.xt().j();
        this.ae = j6;
        cwVar.j(j6);
        j6.j(this);
        com.bytedance.adsdk.lottie.j.xt.j<Float, Float> j7 = vlVar.cw().j();
        this.tl = j7;
        cwVar.j(j7);
        j7.j(this);
        com.bytedance.adsdk.lottie.j.xt.av oq = vlVar.r().oq();
        this.f23244g = oq;
        oq.j(cwVar);
        oq.j(this);
    }

    @Override // com.bytedance.adsdk.lottie.j.j.cw
    public void j(List<cw> list, List<cw> list2) {
        this.oq.j(list, list2);
    }

    @Override // com.bytedance.adsdk.lottie.j.j.up
    public void j(Canvas canvas, Matrix matrix, int i6) {
        float floatValue = this.ae.ae().floatValue();
        float floatValue2 = this.tl.ae().floatValue();
        float floatValue3 = this.f23244g.xt().ae().floatValue() / 100.0f;
        float floatValue4 = this.f23244g.cw().ae().floatValue() / 100.0f;
        for (int i7 = ((int) floatValue) - 1; i7 >= 0; i7--) {
            this.f23245j.set(matrix);
            float f6 = i7;
            this.f23245j.preConcat(this.f23244g.xt(f6 + floatValue2));
            this.oq.j(canvas, this.f23245j, (int) (i6 * com.bytedance.adsdk.lottie.up.tl.j(floatValue3, floatValue4, f6 / floatValue)));
        }
    }

    @Override // com.bytedance.adsdk.lottie.j.j.up
    public void j(RectF rectF, Matrix matrix, boolean z5) {
        this.oq.j(rectF, matrix, z5);
    }

    @Override // com.bytedance.adsdk.lottie.j.xt.j.InterfaceC0316j
    public void j() {
        this.cw.invalidateSelf();
    }
}
