package com.bytedance.adsdk.lottie.model.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

/* loaded from: D:\Downloads\app\classes3.dex */
public class ae extends cw {
    protected final com.bytedance.adsdk.lottie.g ae;

    /* renamed from: g, reason: collision with root package name */
    private final Rect f23369g;
    private final Rect oq;
    private com.bytedance.adsdk.lottie.j.xt.j<ColorFilter, ColorFilter> qv;
    private final Paint tl;
    private com.bytedance.adsdk.lottie.j.xt.j<Bitmap, Bitmap> vl;

    private Bitmap ws() {
        Bitmap ae;
        com.bytedance.adsdk.lottie.j.xt.j<Bitmap, Bitmap> jVar = this.vl;
        if (jVar != null && (ae = jVar.ae()) != null) {
            return ae;
        }
        Bitmap up = this.xt.up(this.cw.ae());
        if (up != null) {
            return up;
        }
        com.bytedance.adsdk.lottie.g gVar = this.ae;
        if (gVar != null) {
            return gVar.ws();
        }
        return null;
    }

    ae(com.bytedance.adsdk.lottie.tl tlVar, tl tlVar2) {
        super(tlVar, tlVar2);
        this.tl = new com.bytedance.adsdk.lottie.j.j(3);
        this.f23369g = new Rect();
        this.oq = new Rect();
        this.ae = tlVar.m(tlVar2.ae());
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.cw, com.bytedance.adsdk.lottie.j.j.up
    public void j(RectF rectF, Matrix matrix, boolean z5) {
        super.j(rectF, matrix, z5);
        if (this.ae != null) {
            float j6 = com.bytedance.adsdk.lottie.up.g.j();
            rectF.set(0.0f, 0.0f, this.ae.j() * j6, this.ae.xt() * j6);
            this.f23375j.mapRect(rectF);
        }
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.cw
    public void xt(Canvas canvas, Matrix matrix, int i6) {
        super.xt(canvas, matrix, i6);
        Bitmap ws = ws();
        if (ws != null && !ws.isRecycled() && this.ae != null) {
            float j6 = com.bytedance.adsdk.lottie.up.g.j();
            this.tl.setAlpha(i6);
            com.bytedance.adsdk.lottie.j.xt.j<ColorFilter, ColorFilter> jVar = this.qv;
            if (jVar != null) {
                this.tl.setColorFilter(jVar.ae());
            }
            canvas.save();
            canvas.concat(matrix);
            this.f23369g.set(0, 0, ws.getWidth(), ws.getHeight());
            if (this.xt.m()) {
                this.oq.set(0, 0, (int) (this.ae.j() * j6), (int) (this.ae.xt() * j6));
            } else {
                this.oq.set(0, 0, (int) (ws.getWidth() * j6), (int) (ws.getHeight() * j6));
            }
            canvas.drawBitmap(ws, this.f23369g, this.oq, this.tl);
            canvas.restore();
        }
    }
}
