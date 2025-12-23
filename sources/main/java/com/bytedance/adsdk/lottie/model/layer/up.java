package com.bytedance.adsdk.lottie.model.layer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.adsdk.lottie.g;
import com.bytedance.adsdk.lottie.tj;

/* loaded from: D:\Downloads\app\classes3.dex */
public class up extends ae {

    /* renamed from: g, reason: collision with root package name */
    private float f23414g;
    private VideoFrame oq;
    private LottieAnimationView qv;
    private float tl;
    private g.j.C0314j vl;

    private static void j(View view, int i6, int i7) {
        view.layout(0, 0, i6, i7);
        view.measure(View.MeasureSpec.makeMeasureSpec(i6, 1073741824), View.MeasureSpec.makeMeasureSpec(i7, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ws() {
        VideoFrame videoFrame = this.oq;
        if (videoFrame != null) {
            ViewParent parent = videoFrame.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.oq);
            }
            ViewParent parent2 = this.qv.getParent();
            if (parent2 instanceof ViewGroup) {
                this.oq.setTranslationX(2.1474836E9f);
                ((ViewGroup) parent2).addView(this.oq);
            }
        }
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.ae, com.bytedance.adsdk.lottie.model.layer.cw
    public void xt(Canvas canvas, Matrix matrix, int i6) {
        if (this.tl <= 0.0f || this.oq == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        j(i6);
        float tl = tl();
        j(this.oq, (int) this.tl, (int) this.f23414g);
        this.oq.setAlpha(tl);
        this.oq.draw(canvas);
        canvas.restore();
    }

    public up(com.bytedance.adsdk.lottie.tl tlVar, tl tlVar2, Context context, g.j.C0314j c0314j) {
        super(tlVar, tlVar2);
        this.tl = -1.0f;
        this.f23414g = -1.0f;
        this.vl = c0314j;
        if (((ae) this).ae != null && tlVar != null) {
            LottieAnimationView xt = tlVar.xt();
            this.qv = xt;
            if (xt != null) {
                float j6 = com.bytedance.adsdk.lottie.up.g.j();
                this.tl = (int) (((ae) this).ae.j() * j6);
                this.f23414g = (int) (((ae) this).ae.xt() * j6);
                tj j7 = tlVar.j();
                View j8 = j7 != null ? j7.j("videoview:", null) : null;
                if (j8 instanceof TextureView) {
                    this.oq = new VideoFrame(context, (TextureView) j8, c0314j);
                }
                this.qv.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.adsdk.lottie.model.layer.up.1
                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewAttachedToWindow(View view) {
                        if (up.this.qv == view) {
                            up.this.ws();
                        }
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewDetachedFromWindow(View view) {
                    }
                });
                ws();
            }
        }
    }
}
