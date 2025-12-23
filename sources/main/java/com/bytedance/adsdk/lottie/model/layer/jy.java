package com.bytedance.adsdk.lottie.model.layer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import com.bytedance.adsdk.lottie.tj;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class jy extends ae {

    /* renamed from: g, reason: collision with root package name */
    private int f23394g;
    private final Map<String, Object> oq;
    private int tl;

    private static void j(View view, int i6, int i7) {
        view.layout(0, 0, i6, i7);
        view.measure(View.MeasureSpec.makeMeasureSpec(i6, 1073741824), View.MeasureSpec.makeMeasureSpec(i7, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.ae, com.bytedance.adsdk.lottie.model.layer.cw
    public void xt(Canvas canvas, Matrix matrix, int i6) {
        tj j6 = this.xt.j();
        View j7 = j6 != null ? j6.j("view:", this.oq) : null;
        if (this.tl <= 0 || j7 == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        j(i6);
        float tl = tl();
        j(j7, this.tl, this.f23394g);
        j7.setAlpha(tl);
        j7.draw(canvas);
        canvas.restore();
    }

    public jy(com.bytedance.adsdk.lottie.tl tlVar, tl tlVar2, Context context) {
        super(tlVar, tlVar2);
        this.tl = -1;
        this.f23394g = -1;
        HashMap hashMap = new HashMap();
        this.oq = hashMap;
        if (((ae) this).ae != null) {
            float j6 = com.bytedance.adsdk.lottie.up.g.j();
            this.tl = (int) (((ae) this).ae.j() * j6);
            this.f23394g = (int) (((ae) this).ae.xt() * j6);
            hashMap.put("ugen_url", ((ae) this).ae.r());
            hashMap.put("ugen_md5", ((ae) this).ae.up());
            hashMap.put("ugen_v", ((ae) this).ae.m());
            hashMap.put("ugen_w", Integer.valueOf(this.tl));
            hashMap.put("ugen_h", Integer.valueOf(this.f23394g));
        }
    }
}
