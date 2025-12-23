package com.bxkj.base.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class WaveView extends View {

    /* renamed from: a, reason: collision with root package name */
    private float f17212a;

    /* renamed from: b, reason: collision with root package name */
    private float f17213b;

    /* renamed from: c, reason: collision with root package name */
    private float f17214c;

    /* renamed from: d, reason: collision with root package name */
    private long f17215d;

    /* renamed from: e, reason: collision with root package name */
    private int f17216e;

    /* renamed from: f, reason: collision with root package name */
    private Interpolator f17217f;

    /* renamed from: g, reason: collision with root package name */
    private List f17218g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f17219h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f17220i;

    /* renamed from: j, reason: collision with root package name */
    private Paint f17221j;

    /* renamed from: k, reason: collision with root package name */
    private long f17222k;

    /* renamed from: l, reason: collision with root package name */
    private Runnable f17223l;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (WaveView.this.f17219h) {
                WaveView.this.j();
                WaveView waveView = WaveView.this;
                waveView.postDelayed(waveView.f17223l, WaveView.this.f17216e);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class b {

        /* renamed from: a, reason: collision with root package name */
        private long f17225a = System.currentTimeMillis();

        public b() {
        }

        public int b() {
            return (int) ((1.0f - WaveView.this.f17217f.getInterpolation(((System.currentTimeMillis() - this.f17225a) * 1.0f) / WaveView.this.f17215d)) * 255.0f);
        }

        public float c() {
            return WaveView.this.f17212a + (WaveView.this.f17217f.getInterpolation(((System.currentTimeMillis() - this.f17225a) * 1.0f) / WaveView.this.f17215d) * (WaveView.this.f17214c - WaveView.this.f17212a));
        }
    }

    public WaveView(Context context) {
        this(context, null);
    }

    public void l() {
        this.f17219h = false;
    }

    public WaveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17213b = 0.85f;
        this.f17215d = 2000L;
        this.f17216e = 500;
        this.f17217f = new LinearInterpolator();
        this.f17218g = new ArrayList();
        this.f17223l = new a();
        this.f17221j = new Paint(1);
        setStyle(Paint.Style.FILL);
    }

    public boolean i() {
        return this.f17219h;
    }

    public void k() {
        if (this.f17219h) {
            return;
        }
        this.f17219h = true;
        this.f17223l.run();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Iterator it = this.f17218g.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (System.currentTimeMillis() - bVar.f17225a < this.f17215d) {
                this.f17221j.setAlpha(bVar.b());
                canvas.drawCircle(getWidth() / 2, getHeight() / 2, bVar.c(), this.f17221j);
            } else {
                it.remove();
            }
        }
        if (this.f17218g.size() > 0) {
            postInvalidateDelayed(10L);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i6, int i7, int i8, int i9) {
        if (this.f17220i) {
            return;
        }
        this.f17214c = (Math.min(i6, i7) * this.f17213b) / 2.0f;
    }

    public void setColor(int i6) {
        this.f17221j.setColor(i6);
    }

    public void setDuration(long j6) {
        this.f17215d = j6;
    }

    public void setInitialRadius(float f6) {
        this.f17212a = f6;
    }

    public void setInterpolator(Interpolator interpolator) {
        this.f17217f = interpolator;
        if (interpolator == null) {
            this.f17217f = new LinearInterpolator();
        }
    }

    public void setMaxRadius(float f6) {
        this.f17214c = f6;
        this.f17220i = true;
    }

    public void setMaxRadiusRate(float f6) {
        this.f17213b = f6;
    }

    public void setSpeed(int i6) {
        this.f17216e = i6;
    }

    public void setStyle(Paint.Style style) {
        this.f17221j.setStyle(style);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f17222k < this.f17216e) {
            return;
        }
        this.f17218g.add(new b());
        invalidate();
        this.f17222k = currentTimeMillis;
    }
}
