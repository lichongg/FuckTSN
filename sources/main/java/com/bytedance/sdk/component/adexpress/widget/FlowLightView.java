package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.view.View;
import com.bytedance.sdk.component.utils.kt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class FlowLightView extends View {
    private int ae;
    private final List<j> az;
    private int cw;

    /* renamed from: g, reason: collision with root package name */
    private int[] f25913g;

    /* renamed from: j, reason: collision with root package name */
    Rect f25914j;
    private PorterDuff.Mode jy;

    /* renamed from: m, reason: collision with root package name */
    private int f25915m;
    private Bitmap oq;
    private Paint qv;

    /* renamed from: r, reason: collision with root package name */
    private int f25916r;
    private int tl;
    private int up;
    private Xfermode vl;
    private LinearGradient ws;
    Rect xt;

    public static class j {

        /* renamed from: j, reason: collision with root package name */
        private final int f25917j;
        private int xt = 0;

        public void j() {
            this.xt += this.f25917j;
        }

        public j(int i6) {
            this.f25917j = i6;
        }
    }

    private void j() {
        this.cw = kt.up(getContext(), "tt_splash_unlock_image_arrow");
        this.f25916r = Color.parseColor("#00ffffff");
        this.up = Color.parseColor("#ffffffff");
        int parseColor = Color.parseColor("#00ffffff");
        this.f25915m = parseColor;
        this.ae = 10;
        this.tl = 40;
        this.f25913g = new int[]{this.f25916r, this.up, parseColor};
        setLayerType(1, null);
        this.qv = new Paint(1);
        this.oq = BitmapFactory.decodeResource(getResources(), this.cw);
        this.vl = new PorterDuffXfermode(this.jy);
    }

    public FlowLightView(Context context) {
        super(context);
        this.jy = PorterDuff.Mode.DST_IN;
        this.az = new ArrayList();
        j();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(this.oq, this.f25914j, this.xt, this.qv);
        canvas.save();
        Iterator<j> it = this.az.iterator();
        while (it.hasNext()) {
            j next = it.next();
            this.ws = new LinearGradient(next.xt, 0.0f, next.xt + this.tl, this.ae, this.f25913g, (float[]) null, Shader.TileMode.CLAMP);
            this.qv.setColor(-1);
            this.qv.setShader(this.ws);
            Canvas canvas2 = canvas;
            canvas2.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.qv);
            this.qv.setShader(null);
            next.j();
            if (next.xt > getWidth()) {
                it.remove();
            }
            canvas = canvas2;
        }
        Canvas canvas3 = canvas;
        this.qv.setXfermode(this.vl);
        canvas3.drawBitmap(this.oq, this.f25914j, this.xt, this.qv);
        this.qv.setXfermode(null);
        canvas3.restore();
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        if (this.oq == null) {
            return;
        }
        this.f25914j = new Rect(0, 0, this.oq.getWidth(), this.oq.getHeight());
        this.xt = new Rect(0, 0, getWidth(), getHeight());
    }

    public void j(int i6) {
        this.az.add(new j(i6));
        postInvalidate();
    }
}
