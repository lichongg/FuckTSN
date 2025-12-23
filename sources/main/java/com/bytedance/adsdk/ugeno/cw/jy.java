package com.bytedance.adsdk.ugeno.cw;

import android.animation.AnimatorSet;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: D:\Downloads\app\classes3.dex */
public class jy {
    private String ae;
    private AnimatorSet cw = new AnimatorSet();

    /* renamed from: j, reason: collision with root package name */
    Paint f23613j;

    /* renamed from: m, reason: collision with root package name */
    private int f23614m;

    /* renamed from: r, reason: collision with root package name */
    private View f23615r;
    private int up;
    private j xt;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0161, code lost:
    
        if (r2.equals("accelerate") == false) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void j() {
        /*
            Method dump skipped, instructions count: 502
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.cw.jy.j():void");
    }

    public void xt() {
        AnimatorSet animatorSet = this.cw;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public jy(View view, j jVar) {
        this.f23615r = view;
        this.xt = jVar;
        Paint paint = new Paint();
        this.f23613j = paint;
        paint.setAntiAlias(true);
    }

    public void j(Canvas canvas, up upVar) {
        try {
            if (upVar.getRipple() == 0.0f || TextUtils.isEmpty(this.ae)) {
                return;
            }
            this.f23613j.setColor(com.bytedance.adsdk.ugeno.m.j.j(this.ae));
            this.f23613j.setAlpha(90);
            ((ViewGroup) this.f23615r.getParent()).setClipChildren(true);
            canvas.drawCircle(this.up, this.f23614m, Math.min(r0, r2) * 2 * upVar.getRipple(), this.f23613j);
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public void j(int i6, int i7) {
        this.up = i6 / 2;
        this.f23614m = i7 / 2;
    }
}
