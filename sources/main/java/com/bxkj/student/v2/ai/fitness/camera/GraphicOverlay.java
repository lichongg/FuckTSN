package com.bxkj.student.v2.ai.fitness.camera;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import com.google.common.base.Preconditions;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class GraphicOverlay extends View {

    /* renamed from: a, reason: collision with root package name */
    private final Object f20500a;

    /* renamed from: b, reason: collision with root package name */
    private final List<a> f20501b;

    /* renamed from: c, reason: collision with root package name */
    private final Matrix f20502c;

    /* renamed from: d, reason: collision with root package name */
    private int f20503d;

    /* renamed from: e, reason: collision with root package name */
    private int f20504e;

    /* renamed from: f, reason: collision with root package name */
    private float f20505f;

    /* renamed from: g, reason: collision with root package name */
    private float f20506g;

    /* renamed from: h, reason: collision with root package name */
    private float f20507h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f20508i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f20509j;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class a {

        /* renamed from: a, reason: collision with root package name */
        private GraphicOverlay f20510a;

        public abstract void a(Canvas canvas);

        public Context b() {
            return StubApp.getOrigApplicationContext(this.f20510a.getContext().getApplicationContext());
        }

        public Matrix c() {
            return this.f20510a.f20502c;
        }

        public boolean d() {
            return this.f20510a.f20508i;
        }

        public void e() {
            this.f20510a.postInvalidate();
        }

        public float f(float imagePixel) {
            return imagePixel * this.f20510a.f20505f;
        }

        public float g(float x5) {
            return this.f20510a.f20508i ? this.f20510a.getWidth() - (f(x5) - this.f20510a.f20506g) : f(x5) - this.f20510a.f20506g;
        }

        public a(GraphicOverlay overlay) {
            this.f20510a = overlay;
        }

        public float h(float y5) {
            return f(y5) - this.f20510a.f20507h;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(View view, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
        this.f20509j = true;
    }

    public void k(int imageWidth, int imageHeight, boolean isFlipped) {
        Preconditions.checkState(imageWidth > 0, "image width must be positive");
        Preconditions.checkState(imageHeight > 0, "image height must be positive");
        synchronized (this.f20500a) {
            this.f20503d = imageWidth;
            this.f20504e = imageHeight;
            this.f20508i = isFlipped;
            this.f20509j = true;
        }
        postInvalidate();
    }

    private void l() {
        if (!this.f20509j || this.f20503d <= 0 || this.f20504e <= 0) {
            return;
        }
        float width = getWidth() / getHeight();
        float f6 = this.f20503d / this.f20504e;
        this.f20506g = 0.0f;
        this.f20507h = 0.0f;
        if (width > f6) {
            this.f20505f = getWidth() / this.f20503d;
            this.f20507h = ((getWidth() / f6) - getHeight()) / 2.0f;
        } else {
            this.f20505f = getHeight() / this.f20504e;
            this.f20506g = ((getHeight() * f6) - getWidth()) / 2.0f;
        }
        this.f20502c.reset();
        Matrix matrix = this.f20502c;
        float f7 = this.f20505f;
        matrix.setScale(f7, f7);
        this.f20502c.postTranslate(-this.f20506g, -this.f20507h);
        if (this.f20508i) {
            this.f20502c.postScale(-1.0f, 1.0f, getWidth() / 2.0f, getHeight() / 2.0f);
        }
        this.f20509j = false;
    }

    public void g(a graphic) {
        synchronized (this.f20500a) {
            this.f20501b.add(graphic);
        }
    }

    public int getImageHeight() {
        return this.f20504e;
    }

    public int getImageWidth() {
        return this.f20503d;
    }

    public void h() {
        synchronized (this.f20500a) {
            this.f20501b.clear();
        }
        postInvalidate();
    }

    public void j(a graphic) {
        synchronized (this.f20500a) {
            this.f20501b.remove(graphic);
        }
        postInvalidate();
    }

    public GraphicOverlay(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f20500a = new Object();
        this.f20501b = new ArrayList();
        this.f20502c = new Matrix();
        this.f20505f = 1.0f;
        this.f20509j = true;
        addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.bxkj.student.v2.ai.fitness.camera.h
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
                GraphicOverlay.this.i(view, i6, i7, i8, i9, i10, i11, i12, i13);
            }
        });
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        synchronized (this.f20500a) {
            try {
                l();
                Iterator<a> it = this.f20501b.iterator();
                while (it.hasNext()) {
                    it.next().a(canvas);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
