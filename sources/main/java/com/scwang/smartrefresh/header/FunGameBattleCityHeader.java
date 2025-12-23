package com.scwang.smartrefresh.header;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.scwang.smartrefresh.header.fungame.FunGameView;
import com.scwang.smartrefresh.layout.util.c;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class FunGameBattleCityHeader extends FunGameView {
    private static int J0 = 3;
    private static final float K0 = 0.33333334f;
    private static final int L0 = 360;
    private static final int M0 = 60;
    private static final int N0 = 8;
    private int F0;
    private int G0;
    private int H0;
    private boolean I0;
    private SparseArray<Queue<RectF>> Q;
    private Queue<Point> R;
    private Point S;
    private Random T;
    private float U;
    private int V;
    private int W;

    /* renamed from: a0, reason: collision with root package name */
    private int f36921a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f36922b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f36923c0;

    /* renamed from: k0, reason: collision with root package name */
    private int f36924k0;

    /* renamed from: p0, reason: collision with root package name */
    private int f36925p0;

    public FunGameBattleCityHeader(Context context) {
        super(context);
        this.f36922b0 = 1;
        this.f36923c0 = 4;
        this.I0 = true;
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameView
    protected void V() {
        this.A = 0;
        this.f37120y = this.f37106l;
        this.f36922b0 = c.b(1.0f);
        this.f36923c0 = c.b(4.0f);
        this.G0 = 8;
        this.H0 = 0;
        this.I0 = true;
        this.V = this.f37121z + this.f36921a0 + 60;
        this.W = 360;
        this.Q = new SparseArray<>();
        for (int i6 = 0; i6 < J0; i6++) {
            this.Q.put(i6, new LinkedList());
        }
        this.R = new LinkedList();
    }

    private int W() {
        return this.T.nextInt(J0);
    }

    private boolean X(int i6, float f6, float f7) {
        RectF peek = this.Q.get(i6).peek();
        return peek != null && peek.contains(f6, f7);
    }

    private boolean Y(Point point) {
        int e02 = e0(point.y);
        RectF peek = this.Q.get(e02).peek();
        if (peek == null || !peek.contains(point.x, point.y)) {
            return false;
        }
        int i6 = this.H0 + 1;
        this.H0 = i6;
        if (i6 == this.G0) {
            g0();
        }
        this.Q.get(e02).poll();
        return true;
    }

    private void Z(Canvas canvas, Point point) {
        int i6 = point.x - this.f36923c0;
        point.x = i6;
        canvas.drawCircle(i6, point.y, this.U, this.f37118w);
    }

    private void a0(Canvas canvas, int i6) {
        this.f37118w.setColor(this.B);
        int i7 = this.f36924k0 + this.f36922b0;
        this.f36924k0 = i7;
        if (i7 / this.V == 1 || this.I0) {
            this.f36924k0 = 0;
            this.I0 = false;
        }
        int W = W();
        boolean z5 = false;
        for (int i8 = 0; i8 < J0; i8++) {
            Queue<RectF> queue = this.Q.get(i8);
            if (this.f36924k0 == 0 && i8 == W) {
                queue.offer(d0(i8));
            }
            Iterator<RectF> it = queue.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                RectF next = it.next();
                if (next.left >= i6) {
                    int i9 = this.F0 + 1;
                    this.F0 = i9;
                    if (i9 >= 8) {
                        this.A = 2;
                        z5 = true;
                        break;
                    }
                    z5 = true;
                } else {
                    c0(canvas, next);
                }
            }
            if (this.A == 2) {
                break;
            }
            if (z5) {
                queue.poll();
                z5 = false;
            }
        }
        invalidate();
    }

    private void b0(Canvas canvas, int i6) {
        this.f37118w.setColor(this.C);
        boolean X = X(e0((int) this.f37120y), i6 - this.f37121z, this.f37120y);
        boolean X2 = X(e0((int) (this.f37120y + this.f37121z)), i6 - r4, this.f37120y + this.f37121z);
        if (X || X2) {
            this.A = 2;
        }
        int i7 = this.f37121z;
        float f6 = this.f37120y;
        float f7 = this.f37106l;
        canvas.drawRect(i6 - i7, f6 + f7, i6, f6 + i7 + f7, this.f37118w);
        int i8 = this.f37121z;
        int i9 = this.f36921a0;
        float f8 = this.f37120y;
        canvas.drawRect((i6 - i8) - i9, f8 + ((i8 - i9) * 0.5f), i6 - i8, f8 + ((i8 - i9) * 0.5f) + i9, this.f37118w);
    }

    private void c0(Canvas canvas, RectF rectF) {
        float f6 = rectF.left;
        int i6 = this.f36922b0;
        rectF.set(f6 + i6, rectF.top, rectF.right + i6, rectF.bottom);
        canvas.drawRect(rectF, this.f37118w);
        float f7 = rectF.top;
        int i7 = this.f37121z;
        int i8 = this.f36921a0;
        float f8 = f7 + ((i7 - i8) * 0.5f);
        float f9 = rectF.right;
        canvas.drawRect(f9, f8, f9 + i8, f8 + i8, this.f37118w);
    }

    private RectF d0(int i6) {
        float f6 = -(this.f36921a0 + this.f37121z);
        float f7 = (i6 * r0) + this.f37106l;
        return new RectF(f6, f7, (this.f36921a0 * 2.5f) + f6, this.f37121z + f7);
    }

    private int e0(int i6) {
        int i7 = this.f37096b;
        int i8 = J0;
        int i9 = i6 / (i7 / i8);
        if (i9 >= i8) {
            i9 = i8 - 1;
        }
        if (i9 < 0) {
            return 0;
        }
        return i9;
    }

    private void f0(Canvas canvas, int i6) {
        this.f37118w.setColor(this.D);
        int i7 = this.f36925p0 + this.f36923c0;
        this.f36925p0 = i7;
        boolean z5 = false;
        if (i7 / this.W == 1) {
            this.f36925p0 = 0;
        }
        if (this.f36925p0 == 0) {
            Point point = new Point();
            int i8 = this.f37121z;
            point.x = (i6 - i8) - this.f36921a0;
            point.y = (int) (this.f37120y + (i8 * 0.5f));
            this.R.offer(point);
        }
        for (Point point2 : this.R) {
            if (Y(point2)) {
                this.S = point2;
            } else {
                if (point2.x + this.U <= 0.0f) {
                    z5 = true;
                }
                Z(canvas, point2);
            }
        }
        if (z5) {
            this.R.poll();
        }
        this.R.remove(this.S);
        this.S = null;
    }

    private void g0() {
        this.G0 += 8;
        this.f36922b0 += c.b(1.0f);
        this.f36923c0 += c.b(1.0f);
        this.H0 = 0;
        int i6 = this.V;
        if (i6 > 12) {
            this.V = i6 - 12;
        }
        int i7 = this.W;
        if (i7 > 30) {
            this.W = i7 - 30;
        }
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameView
    protected void R() {
        this.T = new Random();
        this.f37121z = this.f37096b / J0;
        int floor = (int) Math.floor((r0 * K0) + 0.5f);
        this.f36921a0 = floor;
        this.U = (floor - (this.f37106l * 2.0f)) * 0.5f;
        V();
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameView
    protected void M(Canvas canvas, int i6, int i7) {
        b0(canvas, i6);
        int i8 = this.A;
        if (i8 == 1 || i8 == 3 || i8 == 4) {
            a0(canvas, i6);
            f0(canvas, i6);
        }
        if (isInEditMode()) {
            int i9 = this.f37121z;
            c0(canvas, new RectF(i9, 0.0f, i9 * 2, i9));
            int i10 = this.f37121z;
            c0(canvas, new RectF(0.0f, i10, i10, i10 * 2));
            int i11 = this.f37121z;
            c0(canvas, new RectF(i11 * 3, i11 * 2, i11 * 4, i11 * 3));
        }
    }

    public FunGameBattleCityHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f36922b0 = 1;
        this.f36923c0 = 4;
        this.I0 = true;
    }

    public FunGameBattleCityHeader(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f36922b0 = 1;
        this.f36923c0 = 4;
        this.I0 = true;
    }

    @RequiresApi(21)
    public FunGameBattleCityHeader(Context context, @Nullable AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
        this.f36922b0 = 1;
        this.f36923c0 = 4;
        this.I0 = true;
    }
}
