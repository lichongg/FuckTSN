package com.bytedance.adsdk.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

/* loaded from: D:\Downloads\app\classes3.dex */
public class qv extends cw {
    private final RectF ae;

    /* renamed from: g, reason: collision with root package name */
    private final float[] f23396g;
    private final Path oq;
    private final tl qv;
    private final Paint tl;
    private com.bytedance.adsdk.lottie.j.xt.j<ColorFilter, ColorFilter> vl;

    qv(com.bytedance.adsdk.lottie.tl tlVar, tl tlVar2) {
        super(tlVar, tlVar2);
        this.ae = new RectF();
        com.bytedance.adsdk.lottie.j.j jVar = new com.bytedance.adsdk.lottie.j.j();
        this.tl = jVar;
        this.f23396g = new float[8];
        this.oq = new Path();
        this.qv = tlVar2;
        jVar.setAlpha(0);
        jVar.setStyle(Paint.Style.FILL);
        jVar.setColor(tlVar2.av());
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.cw, com.bytedance.adsdk.lottie.j.j.up
    public void j(RectF rectF, Matrix matrix, boolean z5) {
        super.j(rectF, matrix, z5);
        this.ae.set(0.0f, 0.0f, this.qv.w(), this.qv.i());
        this.f23375j.mapRect(this.ae);
        rectF.set(this.ae);
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.cw
    public void xt(Canvas canvas, Matrix matrix, int i6) {
        int intValue;
        super.xt(canvas, matrix, i6);
        int alpha = Color.alpha(this.qv.av());
        if (alpha != 0) {
            if (this.f23379r.j() == null) {
                intValue = 100;
            } else {
                intValue = this.f23379r.j().ae().intValue();
            }
            int i7 = (int) ((i6 / 255.0f) * (((alpha / 255.0f) * intValue) / 100.0f) * 255.0f);
            this.tl.setAlpha(i7);
            com.bytedance.adsdk.lottie.j.xt.j<ColorFilter, ColorFilter> jVar = this.vl;
            if (jVar != null) {
                this.tl.setColorFilter(jVar.ae());
            }
            if (i7 > 0) {
                float[] fArr = this.f23396g;
                fArr[0] = 0.0f;
                fArr[1] = 0.0f;
                fArr[2] = this.qv.w();
                float[] fArr2 = this.f23396g;
                fArr2[3] = 0.0f;
                fArr2[4] = this.qv.w();
                this.f23396g[5] = this.qv.i();
                float[] fArr3 = this.f23396g;
                fArr3[6] = 0.0f;
                fArr3[7] = this.qv.i();
                matrix.mapPoints(this.f23396g);
                this.oq.reset();
                Path path = this.oq;
                float[] fArr4 = this.f23396g;
                path.moveTo(fArr4[0], fArr4[1]);
                Path path2 = this.oq;
                float[] fArr5 = this.f23396g;
                path2.lineTo(fArr5[2], fArr5[3]);
                Path path3 = this.oq;
                float[] fArr6 = this.f23396g;
                path3.lineTo(fArr6[4], fArr6[5]);
                Path path4 = this.oq;
                float[] fArr7 = this.f23396g;
                path4.lineTo(fArr7[6], fArr7[7]);
                Path path5 = this.oq;
                float[] fArr8 = this.f23396g;
                path5.lineTo(fArr8[0], fArr8[1]);
                this.oq.close();
                canvas.drawPath(this.oq, this.tl);
            }
        }
    }
}
