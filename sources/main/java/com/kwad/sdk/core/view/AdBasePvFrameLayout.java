package com.kwad.sdk.core.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.by;
import com.kwad.sdk.utils.m;
import com.kwad.sdk.widget.l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class AdBasePvFrameLayout extends AdBaseFrameLayout {
    private long aLM;
    private float aLN;
    private boolean aLO;
    private boolean aLP;
    private ViewTreeObserver.OnScrollChangedListener aLQ;
    private ViewTreeObserver aLR;
    private by aLS;
    private l eF;
    private int oC;

    public AdBasePvFrameLayout(@NonNull Context context) {
        super(context);
        this.aLM = 500L;
        this.aLN = 0.1f;
        this.aLP = true;
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean KF() {
        if (!this.aLS.So() || Math.abs(this.aLS.bbF.height() - getHeight()) > getHeight() * (1.0f - this.aLN) || getHeight() <= 0 || getWidth() <= 0) {
            return false;
        }
        Rect rect = this.aLS.bbF;
        return rect.bottom > 0 && rect.top < this.oC;
    }

    private void KG() {
        if (this.aLQ == null) {
            this.aLQ = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.kwad.sdk.core.view.AdBasePvFrameLayout.1
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    if (AdBasePvFrameLayout.this.KF()) {
                        AdBasePvFrameLayout.this.KE();
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            this.aLR = viewTreeObserver;
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnScrollChangedListener(this.aLQ);
            }
        }
    }

    private void KH() {
        ViewTreeObserver viewTreeObserver;
        try {
            if (this.aLQ != null && (viewTreeObserver = this.aLR) != null && viewTreeObserver.isAlive()) {
                this.aLR.removeOnScrollChangedListener(this.aLQ);
            }
            this.aLQ = null;
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTrace(e6);
        }
    }

    private void init() {
        this.aLS = new by(this);
        this.oC = m.getScreenHeight(getContext());
        this.aLP = true;
    }

    private void qm() {
        if (this.aLP) {
            KD();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i6, int i7, int i8, int i9) {
        boolean z5;
        if (this.aLO || (i8 | i9) != 0 || (i6 | i7) == 0) {
            z5 = false;
        } else {
            z5 = true;
            this.aLO = true;
        }
        super.onSizeChanged(i6, i7, i8, i9);
        if (z5) {
            qm();
        }
    }

    public void setCheckDefaultImpressionLogThreshold(float f6) {
        this.aLN = f6;
    }

    public void setVisibleListener(l lVar) {
        this.eF = lVar;
    }

    private void KD() {
        if (KF()) {
            KE();
        } else {
            KG();
        }
    }

    protected final void KE() {
        KH();
        l lVar = this.eF;
        if (lVar != null) {
            lVar.aT();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        KG();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        KH();
        this.aLO = false;
    }

    public AdBasePvFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aLM = 500L;
        this.aLN = 0.1f;
        this.aLP = true;
        init();
    }

    public AdBasePvFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.aLM = 500L;
        this.aLN = 0.1f;
        this.aLP = true;
        init();
    }
}
