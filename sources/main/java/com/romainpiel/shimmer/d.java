package com.romainpiel.shimmer;

import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class d {

    /* renamed from: k, reason: collision with root package name */
    private static final int f36835k = -1;

    /* renamed from: a, reason: collision with root package name */
    private View f36836a;

    /* renamed from: b, reason: collision with root package name */
    private Paint f36837b;

    /* renamed from: c, reason: collision with root package name */
    private float f36838c;

    /* renamed from: d, reason: collision with root package name */
    private LinearGradient f36839d;

    /* renamed from: e, reason: collision with root package name */
    private Matrix f36840e;

    /* renamed from: f, reason: collision with root package name */
    private int f36841f;

    /* renamed from: g, reason: collision with root package name */
    private int f36842g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f36843h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f36844i;

    /* renamed from: j, reason: collision with root package name */
    private a f36845j;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a(View view);
    }

    private void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes;
        this.f36842g = -1;
        if (attributeSet != null && (obtainStyledAttributes = this.f36836a.getContext().obtainStyledAttributes(attributeSet, R.styleable.ShimmerView, 0, 0)) != null) {
            try {
                this.f36842g = obtainStyledAttributes.getColor(R.styleable.ShimmerView_reflectionColor, -1);
            } catch (Exception unused) {
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
            obtainStyledAttributes.recycle();
        }
        this.f36840e = new Matrix();
    }

    private void i() {
        float f6 = -this.f36836a.getWidth();
        int i6 = this.f36841f;
        LinearGradient linearGradient = new LinearGradient(f6, 0.0f, 0.0f, 0.0f, new int[]{i6, this.f36842g, i6}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
        this.f36839d = linearGradient;
        this.f36837b.setShader(linearGradient);
    }

    public float a() {
        return this.f36838c;
    }

    public int b() {
        return this.f36841f;
    }

    public int c() {
        return this.f36842g;
    }

    public boolean e() {
        return this.f36844i;
    }

    public boolean f() {
        return this.f36843h;
    }

    public void g() {
        if (!this.f36843h) {
            this.f36837b.setShader(null);
            return;
        }
        if (this.f36837b.getShader() == null) {
            this.f36837b.setShader(this.f36839d);
        }
        this.f36840e.setTranslate(this.f36838c * 2.0f, 0.0f);
        this.f36839d.setLocalMatrix(this.f36840e);
    }

    public void j(a aVar) {
        this.f36845j = aVar;
    }

    public void k(float f6) {
        this.f36838c = f6;
        this.f36836a.invalidate();
    }

    public void l(int i6) {
        this.f36841f = i6;
        if (this.f36844i) {
            i();
        }
    }

    public void m(int i6) {
        this.f36842g = i6;
        if (this.f36844i) {
            i();
        }
    }

    public void n(boolean z5) {
        this.f36843h = z5;
    }

    public d(View view, Paint paint, AttributeSet attributeSet) {
        this.f36836a = view;
        this.f36837b = paint;
        d(attributeSet);
    }

    protected void h() {
        i();
        if (!this.f36844i) {
            this.f36844i = true;
            a aVar = this.f36845j;
            if (aVar != null) {
                aVar.a(this.f36836a);
            }
        }
    }
}
