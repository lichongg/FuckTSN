package com.bytedance.adsdk.j.j.j;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.bytedance.adsdk.j.j.xt.ae;
import com.bytedance.adsdk.j.j.xt.m;

/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class tl<R extends com.bytedance.adsdk.j.j.xt.m, W extends com.bytedance.adsdk.j.j.xt.ae> {
    protected final R ae;

    /* renamed from: g, reason: collision with root package name */
    public int f23163g;
    public int oq;
    public int qv;
    public int tl;
    public int vl;
    protected final Rect jy = new Rect();
    protected final Rect ws = new Rect();

    public abstract Bitmap j(Canvas canvas, Paint paint, int i6, Bitmap bitmap, W w5);

    public tl(R r5) {
        this.ae = r5;
    }
}
