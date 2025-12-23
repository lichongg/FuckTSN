package com.kwad.sdk.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.by;
import com.kwad.sdk.utils.m;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class i {
    private final by aLS;
    private final k bdG;
    private boolean bdI;
    private boolean bdJ;
    private ViewTreeObserver.OnScrollChangedListener bdL;
    private final View mView;
    private final int oC;
    private float bdH = 0.1f;
    private boolean bdK = true;

    private void KG() {
        if (this.bdL == null) {
            this.bdL = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.kwad.sdk.widget.i.1
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    if (i.this.SR()) {
                        i.this.aT();
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = this.mView.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnScrollChangedListener(this.bdL);
            }
        }
    }

    private void KH() {
        if (this.bdL == null) {
            return;
        }
        try {
            ViewTreeObserver viewTreeObserver = this.mView.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnScrollChangedListener(this.bdL);
            }
            this.bdL = null;
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTrace(e6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean SR() {
        if (this.aLS.So() && Math.abs(this.aLS.bbF.height() - this.mView.getHeight()) <= this.mView.getHeight() * (1.0f - this.bdH) && this.mView.getHeight() > 0 && this.mView.getWidth() > 0) {
            Rect rect = this.aLS.bbF;
            if (rect.bottom > 0 && rect.top < this.oC) {
                return true;
            }
        }
        return false;
    }

    private void qm() {
        if (this.bdK) {
            SQ();
        }
    }

    public final void SP() {
        if (this.bdJ) {
            qm();
        }
    }

    public final void b(int i6, int i7, int i8, int i9) {
        this.bdJ = false;
        if (this.bdI || (i8 | i9) != 0 || (i6 | i7) == 0) {
            return;
        }
        this.bdJ = true;
        this.bdI = true;
    }

    public final void co(boolean z5) {
        this.bdK = z5;
    }

    public final float getVisiblePercent() {
        return this.bdH;
    }

    public final void setVisiblePercent(float f6) {
        this.bdH = f6;
    }

    public i(View view, k kVar) {
        this.mView = view;
        this.bdG = kVar;
        this.aLS = new by(view);
        this.oC = m.getScreenHeight(view.getContext());
    }

    private void SQ() {
        if (SR()) {
            aT();
        } else {
            KH();
            KG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aT() {
        try {
            KH();
            k kVar = this.bdG;
            if (kVar != null) {
                kVar.E(this.mView);
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final void onAttachedToWindow() {
        KG();
    }

    public final void onDetachedFromWindow() {
        KH();
        this.bdI = false;
    }
}
