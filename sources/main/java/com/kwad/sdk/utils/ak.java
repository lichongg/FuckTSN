package com.kwad.sdk.utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ak extends bm {
    private int aZL;
    private int aZM;
    private int aZN;
    private int aZO;

    public static ak a(int i6, int i7, int i8, int i9, int i10, int i11) {
        ak akVar = new ak(i6, i7);
        akVar.eT(0);
        akVar.eU(0);
        akVar.eR(i9);
        akVar.eS(0);
        return akVar;
    }

    private int QS() {
        return this.aZL;
    }

    private int QT() {
        return this.aZM;
    }

    private int QU() {
        return this.aZN;
    }

    private int QV() {
        return this.aZO;
    }

    private void eS(int i6) {
        this.aZM = i6;
    }

    public final ak c(Context context, float f6) {
        ak akVar = new ak(com.kwad.sdk.c.a.a.a(context, this.mWidth * f6), com.kwad.sdk.c.a.a.a(context, this.mHeight * f6));
        akVar.aZN = com.kwad.sdk.c.a.a.a(context, this.aZN * f6);
        akVar.aZM = com.kwad.sdk.c.a.a.a(context, this.aZM * f6);
        akVar.aZO = com.kwad.sdk.c.a.a.a(context, this.aZO * f6);
        akVar.aZL = com.kwad.sdk.c.a.a.a(context, this.aZL * f6);
        return akVar;
    }

    public final void eR(int i6) {
        this.aZL = i6;
    }

    public final void eT(int i6) {
        this.aZN = i6;
    }

    public final void eU(int i6) {
        this.aZO = i6;
    }

    public ak(int i6, int i7) {
        super(i6, i7);
    }

    public static void a(View view, ak akVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (akVar.getHeight() > 0) {
            layoutParams.height = akVar.getHeight();
        }
        if (akVar.getWidth() > 0) {
            layoutParams.width = akVar.getWidth();
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (akVar.QU() > 0) {
                marginLayoutParams.leftMargin = akVar.QU();
            }
            if (akVar.QT() > 0) {
                marginLayoutParams.bottomMargin = akVar.QT();
            }
            if (akVar.QV() > 0) {
                marginLayoutParams.rightMargin = akVar.QV();
            }
            if (akVar.QS() > 0) {
                marginLayoutParams.topMargin = akVar.QS();
            }
        }
        view.setLayoutParams(layoutParams);
    }
}
