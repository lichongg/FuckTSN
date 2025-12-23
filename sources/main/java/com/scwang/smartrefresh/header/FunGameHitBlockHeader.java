package com.scwang.smartrefresh.header;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.scwang.smartrefresh.header.fungame.FunGameView;
import com.scwang.smartrefresh.layout.util.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class FunGameHitBlockHeader extends FunGameView {
    private static final int G0 = 5;
    private static final int H0 = 3;
    private static final float I0 = 0.01806f;
    private static final float J0 = 0.8f;
    private static final float K0 = 0.08f;
    private static final int L0 = 30;
    static final float M0 = 1.0f;
    private static final int N0 = 3;
    private int F0;
    private float Q;
    private float R;
    private float S;
    private Paint T;
    private float U;
    private float V;
    private float W;

    /* renamed from: a0, reason: collision with root package name */
    private float f36926a0;

    /* renamed from: b0, reason: collision with root package name */
    private List<Point> f36927b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f36928c0;

    /* renamed from: k0, reason: collision with root package name */
    private int f36929k0;

    /* renamed from: p0, reason: collision with root package name */
    private int f36930p0;

    public FunGameHitBlockHeader(Context context) {
        super(context);
        H(context, null);
    }

    private void Y(Canvas canvas) {
        Canvas canvas2;
        int i6 = 0;
        while (true) {
            int i7 = this.f36930p0;
            if (i6 >= i7 * 5) {
                return;
            }
            int i8 = i6 / i7;
            int i9 = i6 % i7;
            Iterator<Point> it = this.f36927b0.iterator();
            while (true) {
                if (!it.hasNext()) {
                    this.T.setColor(com.scwang.smartrefresh.layout.util.a.A(this.B, 255 / (i9 + 1)));
                    float f6 = this.U;
                    float f7 = this.R;
                    float f8 = f6 + (i9 * (f7 + 1.0f));
                    float f9 = i8;
                    float f10 = this.Q;
                    float f11 = (f9 * (f10 + 1.0f)) + 1.0f;
                    canvas2 = canvas;
                    canvas2.drawRect(f8, f11, f8 + f7, f11 + f10, this.T);
                    break;
                }
                if (it.next().equals(i9, i8)) {
                    canvas2 = canvas;
                    break;
                }
            }
            i6++;
            canvas = canvas2;
        }
    }

    private void H(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FunGameHitBlockHeader);
        this.f36930p0 = obtainStyledAttributes.getInt(R.styleable.FunGameHitBlockHeader_fgvBlockHorizontalNum, 3);
        this.F0 = obtainStyledAttributes.getInt(R.styleable.FunGameHitBlockHeader_fgvBallSpeed, c.b(3.0f));
        obtainStyledAttributes.recycle();
        Paint paint = new Paint(1);
        this.T = paint;
        paint.setStyle(Paint.Style.FILL);
        this.S = c.b(4.0f);
    }

    private boolean W(float f6, float f7) {
        boolean z5;
        int i6 = (int) ((((f6 - this.U) - this.S) - this.F0) / this.R);
        if (i6 == this.f36930p0) {
            i6--;
        }
        int i7 = (int) (f7 / this.Q);
        if (i7 == 5) {
            i7--;
        }
        Point point = new Point();
        point.set(i6, i7);
        Iterator<Point> it = this.f36927b0.iterator();
        while (true) {
            if (!it.hasNext()) {
                z5 = false;
                break;
            }
            if (it.next().equals(point.x, point.y)) {
                z5 = true;
                break;
            }
        }
        if (!z5) {
            this.f36927b0.add(point);
        }
        return !z5;
    }

    private boolean X(float f6) {
        float f7 = f6 - this.f37120y;
        return f7 >= 0.0f && f7 <= ((float) this.f37121z);
    }

    private void Z(Canvas canvas) {
        this.f37118w.setColor(this.C);
        float f6 = this.V;
        float f7 = this.f37120y;
        canvas.drawRect(f6, f7, f6 + this.R, f7 + this.f37121z, this.f37118w);
    }

    private void a0(Canvas canvas, int i6) {
        this.f37118w.setColor(this.D);
        float f6 = this.W;
        if (f6 <= this.U + (this.f36930p0 * this.R) + ((r2 - 1) * 1.0f) + this.S && W(f6, this.f36926a0)) {
            this.f36928c0 = false;
        }
        float f7 = this.W;
        float f8 = this.U;
        float f9 = this.S;
        if (f7 <= f8 + f9) {
            this.f36928c0 = false;
        }
        float f10 = f7 + f9;
        float f11 = this.V;
        if (f10 < f11 || f7 - f9 >= f11 + this.R) {
            if (f7 > i6) {
                this.A = 2;
            }
        } else if (X(this.f36926a0)) {
            if (this.f36927b0.size() == this.f36930p0 * 5) {
                this.A = 2;
                return;
            }
            this.f36928c0 = true;
        }
        float f12 = this.f36926a0;
        float f13 = this.S;
        if (f12 <= f13 + 1.0f) {
            this.f36929k0 = 150;
        } else if (f12 >= (this.f37096b - f13) - 1.0f) {
            this.f36929k0 = 210;
        }
        if (this.f36928c0) {
            this.W -= this.F0;
        } else {
            this.W += this.F0;
        }
        float tan = f12 - (((float) Math.tan(Math.toRadians(this.f36929k0))) * this.F0);
        this.f36926a0 = tan;
        canvas.drawCircle(this.W, tan, this.S, this.f37118w);
        invalidate();
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameView
    protected void V() {
        this.W = this.V - (this.S * 3.0f);
        this.f36926a0 = (int) (this.f37096b * 0.5f);
        this.f37120y = 1.0f;
        this.f36929k0 = 30;
        this.f36928c0 = true;
        List<Point> list = this.f36927b0;
        if (list == null) {
            this.f36927b0 = new ArrayList();
        } else {
            list.clear();
        }
    }

    public FunGameHitBlockHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        H(context, attributeSet);
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameView
    protected void M(Canvas canvas, int i6, int i7) {
        Y(canvas);
        Z(canvas);
        int i8 = this.A;
        if (i8 != 1 && i8 != 3 && i8 != 4 && !isInEditMode()) {
            return;
        }
        a0(canvas, i6);
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameView
    protected void R() {
        int measuredWidth = getMeasuredWidth();
        float f6 = (this.f37096b / 5) - 1.0f;
        this.Q = f6;
        float f7 = measuredWidth;
        this.R = I0 * f7;
        this.U = K0 * f7;
        this.V = f7 * J0;
        this.f37121z = (int) (f6 * 1.6f);
    }

    public FunGameHitBlockHeader(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        H(context, attributeSet);
    }

    @RequiresApi(21)
    public FunGameHitBlockHeader(Context context, @Nullable AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
        H(context, attributeSet);
    }
}
