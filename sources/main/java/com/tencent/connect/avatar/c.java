package com.tencent.connect.avatar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class c extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    final String f40338a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f40339b;

    /* renamed from: c, reason: collision with root package name */
    private Matrix f40340c;

    /* renamed from: d, reason: collision with root package name */
    private Matrix f40341d;

    /* renamed from: e, reason: collision with root package name */
    private int f40342e;

    /* renamed from: f, reason: collision with root package name */
    private float f40343f;

    /* renamed from: g, reason: collision with root package name */
    private float f40344g;

    /* renamed from: h, reason: collision with root package name */
    private Bitmap f40345h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f40346i;

    /* renamed from: j, reason: collision with root package name */
    private float f40347j;

    /* renamed from: k, reason: collision with root package name */
    private float f40348k;

    /* renamed from: l, reason: collision with root package name */
    private PointF f40349l;

    /* renamed from: m, reason: collision with root package name */
    private PointF f40350m;

    /* renamed from: n, reason: collision with root package name */
    private float f40351n;

    /* renamed from: o, reason: collision with root package name */
    private float f40352o;

    /* renamed from: p, reason: collision with root package name */
    private Rect f40353p;

    private void a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Animation animation;
        if (this.f40345h == null) {
            return;
        }
        float width = this.f40353p.width();
        float height = this.f40353p.height();
        float[] fArr = new float[9];
        this.f40340c.getValues(fArr);
        float f6 = fArr[2];
        float f7 = fArr[5];
        boolean z5 = false;
        float f8 = fArr[0];
        float f9 = this.f40343f;
        if (f8 > f9) {
            float f10 = f9 / f8;
            this.f40352o = f10;
            Matrix matrix = this.f40340c;
            PointF pointF = this.f40350m;
            matrix.postScale(f10, f10, pointF.x, pointF.y);
            setImageMatrix(this.f40340c);
            float f11 = this.f40352o;
            float f12 = 1.0f / f11;
            float f13 = 1.0f / f11;
            PointF pointF2 = this.f40350m;
            animation = new ScaleAnimation(f12, 1.0f, f13, 1.0f, pointF2.x, pointF2.y);
        } else {
            float f14 = this.f40344g;
            if (f8 < f14) {
                float f15 = f14 / f8;
                this.f40352o = f15;
                Matrix matrix2 = this.f40340c;
                PointF pointF3 = this.f40350m;
                matrix2.postScale(f15, f15, pointF3.x, pointF3.y);
                float f16 = this.f40352o;
                PointF pointF4 = this.f40350m;
                animation = new ScaleAnimation(1.0f, f16, 1.0f, f16, pointF4.x, pointF4.y);
            } else {
                float width2 = this.f40345h.getWidth() * f8;
                float height2 = this.f40345h.getHeight() * f8;
                Rect rect = this.f40353p;
                int i6 = rect.left;
                float f17 = i6 - f6;
                int i7 = rect.top;
                float f18 = i7 - f7;
                if (f17 < 0.0f) {
                    f6 = i6;
                    z5 = true;
                }
                if (f18 < 0.0f) {
                    f7 = i7;
                    z5 = true;
                }
                float f19 = height2 - f18;
                if (width2 - f17 < width) {
                    f6 = i6 - (width2 - width);
                    z5 = true;
                }
                if (f19 < height) {
                    f7 = i7 - (height2 - height);
                    z5 = true;
                }
                if (z5) {
                    float f20 = fArr[2] - f6;
                    float f21 = fArr[5] - f7;
                    fArr[2] = f6;
                    fArr[5] = f7;
                    this.f40340c.setValues(fArr);
                    setImageMatrix(this.f40340c);
                    animation = new TranslateAnimation(f20, 0.0f, f21, 0.0f);
                } else {
                    setImageMatrix(this.f40340c);
                    animation = null;
                }
            }
        }
        if (animation != null) {
            this.f40346i = true;
            animation.setDuration(300L);
            startAnimation(animation);
            new Thread(new Runnable() { // from class: com.tencent.connect.avatar.c.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Thread.sleep(300L);
                    } catch (InterruptedException e6) {
                        e6.printStackTrace();
                    }
                    c.this.post(new Runnable() { // from class: com.tencent.connect.avatar.c.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.clearAnimation();
                            c.this.b();
                        }
                    });
                    c.this.f40346i = false;
                }
            }).start();
        }
    }

    private void c() {
        if (this.f40345h == null) {
            return;
        }
        float[] fArr = {r1, 0.0f, this.f40347j, 0.0f, r1, r2, 0.0f, 0.0f, 0.0f};
        this.f40340c.getValues(fArr);
        float max = Math.max(this.f40353p.width() / this.f40345h.getWidth(), this.f40353p.height() / this.f40345h.getHeight());
        this.f40347j = this.f40353p.left - (((this.f40345h.getWidth() * max) - this.f40353p.width()) / 2.0f);
        float height = this.f40353p.top - (((this.f40345h.getHeight() * max) - this.f40353p.height()) / 2.0f);
        this.f40348k = height;
        this.f40340c.setValues(fArr);
        float min = Math.min(2048.0f / this.f40345h.getWidth(), 2048.0f / this.f40345h.getHeight());
        this.f40343f = min;
        this.f40344g = max;
        if (min < max) {
            this.f40343f = max;
        }
        setImageMatrix(this.f40340c);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0019, code lost:
    
        if (r0 != 6) goto L28;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            boolean r0 = r5.f40346i
            r1 = 1
            if (r0 == 0) goto L6
            return r1
        L6:
            int r0 = r6.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            if (r0 == 0) goto L90
            if (r0 == r1) goto L89
            r2 = 1092616192(0x41200000, float:10.0)
            r3 = 2
            if (r0 == r3) goto L37
            r4 = 5
            if (r0 == r4) goto L1d
            r6 = 6
            if (r0 == r6) goto L89
            goto Laf
        L1d:
            float r6 = r5.a(r6)
            r5.f40351n = r6
            int r6 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r6 <= 0) goto Laf
            android.graphics.Matrix r6 = r5.f40341d
            android.graphics.Matrix r0 = r5.f40340c
            r6.set(r0)
            android.graphics.PointF r6 = r5.f40350m
            r5.a(r6)
            r5.f40342e = r3
            goto Laf
        L37:
            int r0 = r5.f40342e
            if (r0 != r1) goto L5f
            android.graphics.Matrix r0 = r5.f40340c
            android.graphics.Matrix r2 = r5.f40341d
            r0.set(r2)
            float r0 = r6.getX()
            android.graphics.PointF r2 = r5.f40349l
            float r2 = r2.x
            float r0 = r0 - r2
            float r6 = r6.getY()
            android.graphics.PointF r2 = r5.f40349l
            float r2 = r2.y
            float r6 = r6 - r2
            android.graphics.Matrix r2 = r5.f40340c
            r2.postTranslate(r0, r6)
            android.graphics.Matrix r6 = r5.f40340c
            r5.setImageMatrix(r6)
            goto Laf
        L5f:
            if (r0 != r3) goto Laf
            android.graphics.Matrix r0 = r5.f40340c
            r0.set(r0)
            float r6 = r5.a(r6)
            int r0 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r0 <= 0) goto L83
            android.graphics.Matrix r0 = r5.f40340c
            android.graphics.Matrix r2 = r5.f40341d
            r0.set(r2)
            float r0 = r5.f40351n
            float r6 = r6 / r0
            android.graphics.Matrix r0 = r5.f40340c
            android.graphics.PointF r2 = r5.f40350m
            float r3 = r2.x
            float r2 = r2.y
            r0.postScale(r6, r6, r3, r2)
        L83:
            android.graphics.Matrix r6 = r5.f40340c
            r5.setImageMatrix(r6)
            goto Laf
        L89:
            r5.b()
            r6 = 0
            r5.f40342e = r6
            goto Laf
        L90:
            android.graphics.Matrix r0 = r5.f40340c
            android.graphics.Matrix r2 = r5.getImageMatrix()
            r0.set(r2)
            android.graphics.Matrix r0 = r5.f40341d
            android.graphics.Matrix r2 = r5.f40340c
            r0.set(r2)
            android.graphics.PointF r0 = r5.f40349l
            float r2 = r6.getX()
            float r6 = r6.getY()
            r0.set(r2, r6)
            r5.f40342e = r1
        Laf:
            r5.f40339b = r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.avatar.c.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public c(Context context) {
        super(context);
        this.f40340c = new Matrix();
        this.f40341d = new Matrix();
        this.f40342e = 0;
        this.f40343f = 1.0f;
        this.f40344g = 1.0f;
        this.f40346i = false;
        this.f40338a = "TouchView";
        this.f40349l = new PointF();
        this.f40350m = new PointF();
        this.f40351n = 1.0f;
        this.f40352o = 0.0f;
        this.f40339b = false;
        Rect rect = new Rect();
        this.f40353p = rect;
        getDrawingRect(rect);
        a();
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.f40345h = bitmap;
        if (bitmap != null) {
            this.f40345h = bitmap;
        }
    }

    private float a(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() < 2) {
            return 0.0f;
        }
        float x5 = motionEvent.getX(0) - motionEvent.getX(1);
        float y5 = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x5 * x5) + (y5 * y5));
    }

    public void a(Rect rect) {
        this.f40353p = rect;
        if (this.f40345h != null) {
            c();
        }
    }

    private void a(PointF pointF) {
        if (this.f40345h == null) {
            return;
        }
        float[] fArr = new float[9];
        this.f40340c.getValues(fArr);
        float f6 = fArr[2];
        float f7 = fArr[5];
        float f8 = fArr[0];
        float width = this.f40345h.getWidth() * f8;
        float height = this.f40345h.getHeight() * f8;
        Rect rect = this.f40353p;
        float f9 = rect.left - f6;
        if (f9 <= 1.0f) {
            f9 = 1.0f;
        }
        float f10 = (f6 + width) - rect.right;
        if (f10 <= 1.0f) {
            f10 = 1.0f;
        }
        float width2 = (rect.width() * f9) / (f10 + f9);
        Rect rect2 = this.f40353p;
        float f11 = width2 + rect2.left;
        float f12 = rect2.top - f7;
        float f13 = (f7 + height) - rect2.bottom;
        if (f12 <= 1.0f) {
            f12 = 1.0f;
        }
        pointF.set(f11, ((rect2.height() * f12) / ((f13 > 1.0f ? f13 : 1.0f) + f12)) + this.f40353p.top);
    }
}
