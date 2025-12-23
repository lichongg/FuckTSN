package com.bytedance.adsdk.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.bytedance.adsdk.lottie.model.xt.av;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class oq extends cw {
    private final com.bytedance.adsdk.lottie.j.j.r ae;
    private final r tl;

    oq(com.bytedance.adsdk.lottie.tl tlVar, tl tlVar2, r rVar, com.bytedance.adsdk.lottie.m mVar) {
        super(tlVar, tlVar2);
        this.tl = rVar;
        com.bytedance.adsdk.lottie.j.j.r rVar2 = new com.bytedance.adsdk.lottie.j.j.r(tlVar, this, new av("__container", tlVar2.ws(), false), mVar);
        this.ae = rVar2;
        List<com.bytedance.adsdk.lottie.j.j.cw> list = Collections.EMPTY_LIST;
        rVar2.j(list, list);
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.cw, com.bytedance.adsdk.lottie.j.j.up
    public void j(RectF rectF, Matrix matrix, boolean z5) {
        super.j(rectF, matrix, z5);
        this.ae.j(rectF, this.f23375j, z5);
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.cw
    public com.bytedance.adsdk.lottie.r.oq jy() {
        com.bytedance.adsdk.lottie.r.oq jy = super.jy();
        if (jy != null) {
            return jy;
        }
        return this.tl.jy();
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.cw
    public com.bytedance.adsdk.lottie.model.xt.j vl() {
        com.bytedance.adsdk.lottie.model.xt.j vl = super.vl();
        if (vl != null) {
            return vl;
        }
        return this.tl.vl();
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.cw
    public void xt(Canvas canvas, Matrix matrix, int i6) {
        super.xt(canvas, matrix, i6);
        this.ae.j(canvas, matrix, i6);
    }
}
