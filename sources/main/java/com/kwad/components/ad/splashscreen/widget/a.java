package com.kwad.components.ad.splashscreen.widget;

import android.content.Context;
import com.kwad.sdk.utils.ak;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    private float IE;
    private int JR;
    private int JS;
    private int JT;
    private int JU;
    private int JV;
    private int JW;
    private Context mContext;

    private a(Context context) {
        this.JR = 24;
        this.JS = 12;
        this.JT = 16;
        this.JU = 12;
        this.JV = 6;
        this.JW = 4;
        this.IE = 1.0f;
        this.mContext = context;
    }

    public static a ai(Context context) {
        return new a(context);
    }

    public static a aj(Context context) {
        return new a(context, 17, 10, 12, 8, 4, 3);
    }

    public final void d(float f6) {
        this.IE = f6;
    }

    public final ak mR() {
        return new ak(0, (int) (com.kwad.sdk.c.a.a.a(this.mContext, this.JR) * this.IE));
    }

    public final int no() {
        return (int) (((this.JR - this.JT) / 2) * this.IE);
    }

    public final int np() {
        return (int) (this.JU * this.IE);
    }

    public final ak nq() {
        int a6 = (int) (com.kwad.sdk.c.a.a.a(this.mContext, this.JV) * this.IE);
        int a7 = (int) (com.kwad.sdk.c.a.a.a(this.mContext, this.JW) * this.IE);
        ak akVar = new ak(0, 0);
        akVar.eT(a6);
        akVar.eU(a7);
        return akVar;
    }

    public final int nr() {
        return (int) (com.kwad.sdk.c.a.a.b(this.mContext, this.JS) * this.IE);
    }

    public final float ns() {
        return (com.kwad.sdk.c.a.a.a(this.mContext, this.JR) * this.IE) / 2.0f;
    }

    public final ak nt() {
        int a6 = (int) (com.kwad.sdk.c.a.a.a(this.mContext, this.JT) * this.IE);
        return new ak(a6, a6);
    }

    private a(Context context, int i6, int i7, int i8, int i9, int i10, int i11) {
        this.IE = 1.0f;
        this.mContext = context;
        this.JR = 17;
        this.JS = 10;
        this.JT = 12;
        this.JU = 8;
        this.JV = 4;
        this.JW = 3;
    }
}
