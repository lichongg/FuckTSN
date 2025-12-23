package com.bytedance.adsdk.lottie.model.layer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
import com.bytedance.adsdk.lottie.tj;

/* loaded from: D:\Downloads\app\classes3.dex */
public class ws extends ae {

    /* renamed from: g, reason: collision with root package name */
    private int f23428g;
    private int oq;
    private Path tl;

    private static void j(View view, int i6, int i7) {
        view.layout(0, 0, i6, i7);
        view.measure(View.MeasureSpec.makeMeasureSpec(i6, 1073741824), View.MeasureSpec.makeMeasureSpec(i7, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.ae, com.bytedance.adsdk.lottie.model.layer.cw
    public void xt(Canvas canvas, Matrix matrix, int i6) {
        tj j6 = this.xt.j();
        View j7 = j6 != null ? j6.j("videoview:", null) : null;
        if (this.f23428g <= 0 || j7 == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        j(i6);
        float tl = tl();
        j(j7, this.f23428g, this.oq);
        j7.setAlpha(tl);
        canvas.clipPath(this.tl);
        j7.draw(canvas);
        canvas.restore();
    }

    public ws(com.bytedance.adsdk.lottie.tl tlVar, tl tlVar2, Context context) {
        super(tlVar, tlVar2);
        this.tl = null;
        this.f23428g = -1;
        this.oq = -1;
        if (((ae) this).ae != null) {
            float j6 = com.bytedance.adsdk.lottie.up.g.j();
            this.f23428g = (int) (((ae) this).ae.j() * j6);
            this.oq = (int) (((ae) this).ae.xt() * j6);
            RectF rectF = new RectF();
            rectF.set(0.0f, 0.0f, this.f23428g, this.oq);
            Path path = new Path();
            this.tl = path;
            float f6 = j6 * 40.0f;
            path.addRoundRect(rectF, f6, f6, Path.Direction.CW);
        }
    }
}
