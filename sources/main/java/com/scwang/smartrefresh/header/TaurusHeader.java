package com.scwang.smartrefresh.header;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import m2.e;
import m2.g;
import m2.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class TaurusHeader extends View implements e {
    private static final int A = 4;
    private static final int B = 2;
    private static final int C = 50;
    private static final int D = 300;
    private static final int E = 1000;
    private static final int F = 2000;
    private static final int G = 5;

    /* renamed from: q, reason: collision with root package name */
    private static final float f36999q = 0.5f;

    /* renamed from: r, reason: collision with root package name */
    private static final int f37000r = 1000;

    /* renamed from: s, reason: collision with root package name */
    private static final float f37001s = 0.6f;

    /* renamed from: t, reason: collision with root package name */
    private static final float f37002t = 1.0f;

    /* renamed from: u, reason: collision with root package name */
    private static final float f37003u = 0.8f;

    /* renamed from: v, reason: collision with root package name */
    private static final float f37004v = 1.0f;

    /* renamed from: w, reason: collision with root package name */
    private static final Interpolator f37005w = new AccelerateDecelerateInterpolator();

    /* renamed from: x, reason: collision with root package name */
    private static final int f37006x = 80;

    /* renamed from: y, reason: collision with root package name */
    private static final int f37007y = 6;

    /* renamed from: z, reason: collision with root package name */
    private static final int f37008z = 10;

    /* renamed from: a, reason: collision with root package name */
    private com.scwang.smartrefresh.layout.internal.pathview.b f37009a;

    /* renamed from: b, reason: collision with root package name */
    private com.scwang.smartrefresh.layout.internal.pathview.b f37010b;

    /* renamed from: c, reason: collision with root package name */
    private Matrix f37011c;

    /* renamed from: d, reason: collision with root package name */
    private float f37012d;

    /* renamed from: e, reason: collision with root package name */
    private int f37013e;

    /* renamed from: f, reason: collision with root package name */
    private Animation f37014f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f37015g;

    /* renamed from: h, reason: collision with root package name */
    private float f37016h;

    /* renamed from: i, reason: collision with root package name */
    private float f37017i;

    /* renamed from: j, reason: collision with root package name */
    private Random f37018j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f37019k;

    /* renamed from: l, reason: collision with root package name */
    private Map<Float, Float> f37020l;

    /* renamed from: m, reason: collision with root package name */
    private Paint f37021m;

    /* renamed from: n, reason: collision with root package name */
    private float f37022n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f37023o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f37024p;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends Animation {
        a() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f6, @NonNull Transformation transformation) {
            TaurusHeader.this.setLoadingAnimationTime(f6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private enum c {
        FIRST,
        SECOND,
        THIRD,
        FOURTH
    }

    public TaurusHeader(Context context) {
        super(context);
        this.f37015g = false;
        F(context, null);
    }

    private void C(Canvas canvas, float f6, float f7, int i6) {
        float f8 = i6;
        float f9 = (f8 + f7) / 13.0f;
        float f10 = this.f37016h;
        if (this.f37017i - f10 > 0.0f) {
            this.f37024p = true;
            f10 = 13.0f - f10;
        } else {
            this.f37023o = true;
            this.f37024p = false;
        }
        float f11 = (f8 - (f10 * f9)) + f7;
        float f12 = this.f37022n;
        float f13 = f11 - f12;
        canvas.drawLine(f13, f6, f13 + f12, f6, this.f37021m);
    }

    @Override // m2.f
    public int d(h hVar, boolean z5) {
        this.f37015g = false;
        this.f37019k = true;
        clearAnimation();
        return 0;
    }

    @Override // m2.f
    public void h(h hVar, int i6, int i7) {
        this.f37015g = true;
        startAnimation(this.f37014f);
    }

    @Override // m2.f
    public boolean j() {
        return false;
    }

    @Override // m2.f
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        setBackgroundColor(iArr[0]);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f37026a;

        static {
            int[] iArr = new int[c.values().length];
            f37026a = iArr;
            try {
                iArr[c.FIRST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f37026a[c.SECOND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f37026a[c.THIRD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f37026a[c.FOURTH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private void A(Canvas canvas, int i6, int i7) {
        float f6;
        boolean z5;
        float f7;
        float D2;
        float D3;
        Matrix matrix = this.f37011c;
        matrix.reset();
        float min = Math.min(1.0f, Math.abs(this.f37012d));
        if (isInEditMode()) {
            this.f37013e = i7;
            min = 1.0f;
        }
        float f8 = this.f37012d;
        boolean z6 = true;
        if (f8 > 1.0f) {
            f6 = Math.abs(1.0f - f8);
            z5 = true;
        } else {
            f6 = 0.0f;
            z5 = false;
        }
        float f9 = min - 0.5f;
        float f10 = f37003u;
        if (f9 > 0.0f) {
            f10 = f37003u + ((f9 / 0.5f) * 0.19999999f);
        }
        int i8 = this.f37013e;
        float f11 = i8 * min;
        float f12 = i8 - (this.f37010b.f() / 2);
        if (f11 > f12) {
            f7 = f11 - f12;
        } else {
            f7 = 0.0f;
            z6 = false;
        }
        float n6 = (i6 / 2) - (this.f37010b.n() / 2);
        float f13 = f11 - (z6 ? (this.f37010b.f() / 2) + f7 : this.f37010b.f() / 2);
        float f14 = z5 ? (f6 / 4.0f) + f10 : f10;
        float f15 = z5 ? (f6 / 2.0f) + f10 : f10;
        if (this.f37015g && !z5) {
            c cVar = c.FIRST;
            if (f(cVar)) {
                D3 = D(cVar);
            } else {
                c cVar2 = c.SECOND;
                if (f(cVar2)) {
                    D3 = D(cVar2);
                } else {
                    c cVar3 = c.THIRD;
                    if (f(cVar3)) {
                        D2 = D(cVar3);
                    } else {
                        c cVar4 = c.FOURTH;
                        if (f(cVar4)) {
                            D2 = D(cVar4);
                        }
                        f15 = f14;
                    }
                    f14 = ((D2 / 80.0f) / 6.0f) + f10;
                    f15 = f14;
                }
            }
            f14 = f10 - ((D3 / 80.0f) / 8.0f);
            f15 = f14;
        }
        matrix.postScale(f14, f15, this.f37010b.n() / 2, 0.0f);
        float f16 = i7 + 2;
        if ((this.f37010b.f() * f15) + f13 < f16) {
            f13 = f16 - (f15 * this.f37010b.f());
        }
        int saveCount = canvas.getSaveCount();
        canvas.save();
        canvas.translate(n6, f13);
        canvas.concat(matrix);
        this.f37010b.draw(canvas);
        canvas.restoreToCount(saveCount);
    }

    private void B(Canvas canvas, int i6, int i7) {
        float D2;
        float D3;
        Matrix matrix = this.f37011c;
        matrix.reset();
        com.scwang.smartrefresh.layout.internal.pathview.b bVar = this.f37010b;
        float min = Math.min(1.0f, Math.abs(this.f37012d));
        if (isInEditMode()) {
            this.f37013e = i7;
            min = 1.0f;
        }
        float f6 = min - 0.5f;
        float f7 = f6 > 0.0f ? 0.6f + ((f6 / 0.5f) * 0.39999998f) : 0.6f;
        float f8 = this.f37013e * (1.0f - min);
        float n6 = 0 - (bVar.n() / 2);
        float n7 = i6 - (bVar.n() / 2);
        if (this.f37015g) {
            c cVar = c.FIRST;
            if (f(cVar)) {
                n6 -= (D(cVar) * 2.0f) / 4.0f;
                D3 = D(cVar);
            } else {
                c cVar2 = c.SECOND;
                if (f(cVar2)) {
                    n6 -= (D(cVar2) * 2.0f) / 4.0f;
                    D3 = D(cVar2);
                } else {
                    c cVar3 = c.THIRD;
                    if (f(cVar3)) {
                        n6 -= D(cVar3) / 4.0f;
                        D3 = D(cVar3) * 2.0f;
                    } else {
                        c cVar4 = c.FOURTH;
                        if (f(cVar4)) {
                            n6 -= D(cVar4) / 2.0f;
                            D2 = (D(cVar4) * 2.0f) / 4.0f;
                            n7 += D2;
                        }
                    }
                }
            }
            D2 = D3 / 2.0f;
            n7 += D2;
        }
        float f9 = i7 + 2;
        float f10 = (((float) bVar.f()) * f7) + f8 < f9 ? f9 - (bVar.f() * f7) : f8;
        if ((bVar.f() * f7) + f8 < f9) {
            f8 = f9 - (bVar.f() * f7);
        }
        int saveCount = canvas.getSaveCount();
        canvas.save();
        canvas.translate(n6, f10);
        matrix.postScale(f7, f7, (bVar.n() * 3) / 4, bVar.f());
        canvas.concat(matrix);
        bVar.setAlpha(100);
        bVar.draw(canvas);
        bVar.setAlpha(255);
        canvas.restoreToCount(saveCount);
        canvas.save();
        canvas.translate(n7, f8);
        matrix.postScale(f7, f7, 0.0f, bVar.f());
        canvas.concat(matrix);
        bVar.setAlpha(100);
        bVar.draw(canvas);
        bVar.setAlpha(255);
        canvas.restoreToCount(saveCount);
    }

    private float D(c cVar) {
        float f6;
        float E2;
        int i6 = b.f37026a[cVar.ordinal()];
        if (i6 == 1) {
            return this.f37016h;
        }
        if (i6 == 2) {
            c cVar2 = c.FOURTH;
            return E(cVar2) - (this.f37016h - E(cVar2));
        }
        if (i6 == 3) {
            f6 = this.f37016h;
            E2 = E(c.SECOND);
        } else {
            if (i6 != 4) {
                return 0.0f;
            }
            f6 = E(c.THIRD);
            E2 = this.f37016h - E(c.FOURTH);
        }
        return f6 - E2;
    }

    private int E(c cVar) {
        int i6 = b.f37026a[cVar.ordinal()];
        if (i6 != 2) {
            return i6 != 3 ? i6 != 4 ? 0 : 20 : E(c.FOURTH) * 3;
        }
        return 40;
    }

    private void F(Context context, AttributeSet attributeSet) {
        setMinimumHeight(com.scwang.smartrefresh.layout.util.c.b(100.0f));
        this.f37011c = new Matrix();
        this.f37020l = new HashMap();
        this.f37018j = new Random();
        Paint paint = new Paint();
        this.f37021m = paint;
        paint.setColor(-1);
        this.f37021m.setStrokeWidth(com.scwang.smartrefresh.layout.util.c.b(3.0f));
        this.f37021m.setAlpha(50);
        H();
        I();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TaurusHeader);
        int color = obtainStyledAttributes.getColor(R.styleable.TaurusHeader_thPrimaryColor, 0);
        if (color != 0) {
            setBackgroundColor(color);
        } else {
            setBackgroundColor(-15614977);
        }
        obtainStyledAttributes.recycle();
    }

    private float G(int i6, int i7) {
        return this.f37018j.nextInt((i7 - i6) + 1) + i6;
    }

    private void H() {
        a aVar = new a();
        this.f37014f = aVar;
        aVar.setRepeatCount(-1);
        this.f37014f.setRepeatMode(2);
        this.f37014f.setInterpolator(f37005w);
        this.f37014f.setDuration(1000L);
    }

    private void I() {
        com.scwang.smartrefresh.layout.util.c cVar = new com.scwang.smartrefresh.layout.util.c();
        com.scwang.smartrefresh.layout.internal.pathview.b bVar = new com.scwang.smartrefresh.layout.internal.pathview.b();
        this.f37009a = bVar;
        bVar.i("m23.01,81.48c-0.21,-0.3 -0.38,-0.83 -0.38,-1.19 0,-0.55 0.24,-0.78 1.5,-1.48 1.78,-0.97 2.62,-1.94 2.24,-2.57 -0.57,-0.93 -1.97,-1.24 -11.64,-2.59 -5.35,-0.74 -10.21,-1.44 -10.82,-1.54l-1.09,-0.18 1.19,-0.91c0.99,-0.76 1.38,-0.91 2.35,-0.91 0.64,0 6.39,0.33 12.79,0.74 6.39,0.41 12.09,0.71 12.65,0.67l1.03,-0.07 -1.24,-2.19C30.18,66.77 15.91,42 15.13,40.68l-0.51,-0.87 4.19,-1.26c2.3,-0.69 4.27,-1.26 4.37,-1.26 0.1,0 5.95,3.85 13,8.55 14.69,9.81 17.1,11.31 19.7,12.31 4.63,1.78 6.45,1.69 12.94,-0.64 13.18,-4.73 25.22,-9.13 25.75,-9.4 0.69,-0.36 3.6,1.33 -24.38,-14.22L50.73,23.07 46.74,16.42 42.75,9.77 43.63,8.89c0.83,-0.83 0.91,-0.86 1.46,-0.52 0.32,0.2 3.72,3.09 7.55,6.44 3.83,3.34 7.21,6.16 7.5,6.27 0.29,0.11 13.6,2.82 29.58,6.03 15.98,3.21 31.86,6.4 35.3,7.1l6.26,1.26 3.22,-1.13c41.63,-14.63 67.88,-23.23 85.38,-28 14.83,-4.04 23.75,-4.75 32.07,-2.57 7.04,1.84 9.87,4.88 7.71,8.27 -1.6,2.5 -4.6,4.63 -10.61,7.54 -5.94,2.88 -10.22,4.46 -25.4,9.41 -8.15,2.66 -16.66,5.72 -39.01,14.02 -66.79,24.82 -88.49,31.25 -121.66,36.07 -14.56,2.11 -24.17,2.95 -34.08,2.95 -5.43,0 -5.52,-0.01 -5.89,-0.54z");
        this.f37009a.setBounds(0, 0, cVar.a(65.0f), cVar.a(20.0f));
        this.f37009a.h(-1);
        com.scwang.smartrefresh.layout.internal.pathview.b bVar2 = new com.scwang.smartrefresh.layout.internal.pathview.b();
        this.f37010b = bVar2;
        bVar2.i("M551.81,1.01A65.42,65.42 0,0 0,504.38 21.5A50.65,50.65 0,0 0,492.4 20A50.65,50.65 0,0 0,441.75 70.65A50.65,50.65 0,0 0,492.4 121.3A50.65,50.65 0,0 0,511.22 117.64A65.42,65.42 0,0 0,517.45 122L586.25,122A65.42,65.42 0,0 0,599.79 110.78A59.79,59.79 0,0 0,607.81 122L696.34,122A59.79,59.79 0,0 0,711.87 81.9A59.79,59.79 0,0 0,652.07 22.11A59.79,59.79 0,0 0,610.93 38.57A65.42,65.42 0,0 0,551.81 1.01zM246.2,1.71A54.87,54.87 0,0 0,195.14 36.64A46.78,46.78 0,0 0,167.77 27.74A46.78,46.78 0,0 0,120.99 74.52A46.78,46.78 0,0 0,167.77 121.3A46.78,46.78 0,0 0,208.92 96.74A54.87,54.87 0,0 0,246.2 111.45A54.87,54.87 0,0 0,268.71 106.54A39.04,39.04 0,0 0,281.09 122L327.6,122A39.04,39.04 0,0 0,343.38 90.7A39.04,39.04 0,0 0,304.34 51.66A39.04,39.04 0,0 0,300.82 51.85A54.87,54.87 0,0 0,246.2 1.71z", "m506.71,31.37a53.11,53.11 0,0 0,-53.11 53.11,53.11 53.11,0 0,0 15.55,37.5h75.12a53.11,53.11 0,0 0,1.88 -2.01,28.49 28.49,0 0,0 0.81,2.01h212.96a96.72,96.72 0,0 0,-87.09 -54.85,96.72 96.72,0 0,0 -73.14,33.52 28.49,28.49 0,0 0,-26.74 -18.74,28.49 28.49,0 0,0 -13.16,3.23 53.11,53.11 0,0 0,0.03 -0.66,53.11 53.11,0 0,0 -53.11,-53.11zM206.23,31.81a53.81,53.81 0,0 0,-49.99 34.03,74.91 74.91,0 0,0 -47.45,-17 74.91,74.91 0,0 0,-73.54 60.82,31.3 31.3,0 0,0 -10.17,-1.73 31.3,31.3 0,0 0,-26.09 14.05L300.86,121.98a37.63,37.63 0,0 0,0.2 -3.85,37.63 37.63,0 0,0 -37.63,-37.63 37.63,37.63 0,0 0,-3.65 0.21,53.81 53.81,0 0,0 -53.54,-48.9z", "m424.05,36.88a53.46,53.46 0,0 0,-40.89 19.02,53.46 53.46,0 0,0 -1.34,1.76 62.6,62.6 0,0 0,-5.39 -0.27,62.6 62.6,0 0,0 -61.36,50.17 62.6,62.6 0,0 0,-0.53 3.51,15.83 15.83,0 0,0 -10.33,-3.84 15.83,15.83 0,0 0,-8.06 2.23,21.1 21.1,0 0,0 -18.31,-10.67 21.1,21.1 0,0 0,-19.47 12.97,21.81 21.81,0 0,0 -6.56,-1.01 21.81,21.81 0,0 0,-19.09 11.32L522.84,122.07a43.61,43.61 0,0 0,-43.11 -37.35,43.61 43.61,0 0,0 -2.57,0.09 53.46,53.46 0,0 0,-53.11 -47.93zM129.08,38.4a50.29,50.29 0,0 0,-50.29 50.29,50.29 50.29,0 0,0 2.37,15.06 15.48,15.83 0,0 0,-5.87 1.68,15.48 15.83,0 0,0 -0.98,0.58 16.53,16.18 0,0 0,-0.19 -0.21,16.53 16.18,0 0,0 -11.86,-4.91 16.53,16.18 0,0 0,-16.38 14.13,20.05 16.18,0 0,0 -14.97,7.04L223.95,122.07a42.56,42.56 0,0 0,1.14 -9.56,42.56 42.56,0 0,0 -42.56,-42.56 42.56,42.56 0,0 0,-6.58 0.54,50.29 50.29,0 0,0 -0,-0.01 50.29,50.29 0,0 0,-46.88 -32.07zM631.67,82.61a64.01,64.01 0,0 0,-44.9 18.42,26.73 26.73,0 0,0 -10.67,-2.24 26.73,26.73 0,0 0,-22.72 12.71,16.88 16.88,0 0,0 -0.25,-0.12 16.88,16.88 0,0 0,-6.57 -1.33,16.88 16.88,0 0,0 -16.15,12.03h160.36a64.01,64.01 0,0 0,-59.1 -39.46z");
        this.f37010b.h(-1429742351, -571935747, -131587);
        this.f37010b.setBounds(0, 0, cVar.a(260.0f), cVar.a(45.0f));
    }

    private boolean f(c cVar) {
        int i6 = b.f37026a[cVar.ordinal()];
        return i6 != 1 ? (i6 == 2 || i6 == 3) ? this.f37016h < ((float) E(cVar)) : i6 == 4 && this.f37016h > ((float) E(c.THIRD)) : this.f37016h < ((float) E(c.FOURTH));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadingAnimationTime(float f6) {
        this.f37016h = (f6 / 6.0f) * 80.0f;
        invalidate();
    }

    private void z(Canvas canvas, int i6, int i7) {
        float f6;
        float D2;
        float D3;
        Matrix matrix = this.f37011c;
        matrix.reset();
        float f7 = this.f37012d;
        if (isInEditMode()) {
            this.f37013e = i7;
            f7 = 1.0f;
        }
        if (f7 > 1.0f) {
            f6 = ((float) (1.0d - Math.pow(100.0d, (-(f7 - 1.0f)) / 2.0f))) * 20.0f;
            f7 = 1.0f;
        } else {
            f6 = 0.0f;
        }
        float f8 = i6;
        float n6 = ((f8 * f7) / 2.0f) - (this.f37009a.n() / 2);
        float f9 = (this.f37013e * (1.0f - (f7 / 2.0f))) - (this.f37009a.f() / 2);
        if (this.f37019k) {
            n6 = ((i6 / 2) + ((f8 * (1.0f - f7)) / 2.0f)) - (this.f37009a.n() / 2);
            f9 = (f7 * ((this.f37013e / 2) + ((this.f37009a.f() * 3) / 2))) - (this.f37009a.f() * 2);
        }
        if (this.f37015g) {
            c cVar = c.FIRST;
            if (f(cVar)) {
                D3 = D(cVar);
            } else {
                c cVar2 = c.SECOND;
                if (f(cVar2)) {
                    D3 = D(cVar2);
                } else {
                    c cVar3 = c.THIRD;
                    if (f(cVar3)) {
                        D2 = D(cVar3);
                    } else {
                        c cVar4 = c.FOURTH;
                        if (f(cVar4)) {
                            D2 = D(cVar4);
                        }
                    }
                    f9 += D2;
                }
            }
            f9 -= D3;
        }
        if (f6 > 0.0f) {
            matrix.postRotate(f6, this.f37009a.n() / 2, this.f37009a.f() / 2);
        }
        int saveCount = canvas.getSaveCount();
        canvas.save();
        canvas.translate(n6, f9);
        canvas.concat(matrix);
        this.f37009a.draw(canvas);
        canvas.restoreToCount(saveCount);
    }

    @Override // m2.e
    public void g(float f6, int i6, int i7, int i8) {
        this.f37012d = f6;
        this.f37013e = i7;
    }

    @Override // m2.f
    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.Scale;
    }

    @Override // m2.e
    public void y(float f6, int i6, int i7, int i8) {
        this.f37012d = f6;
        this.f37019k = false;
        this.f37013e = i7;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float f6;
        int width = getWidth();
        int height = getHeight();
        if (this.f37015g) {
            while (this.f37020l.size() < 10) {
                float random = (float) (this.f37013e / (Math.random() * 5.0d));
                float G2 = G(1000, 2000);
                if (this.f37020l.size() > 1) {
                    while (true) {
                        f6 = 0.0f;
                        while (f6 == 0.0f) {
                            float random2 = (float) (this.f37013e / (Math.random() * 5.0d));
                            Iterator<Map.Entry<Float, Float>> it = this.f37020l.entrySet().iterator();
                            while (it.hasNext()) {
                                if (Math.abs(it.next().getKey().floatValue() - random2) > this.f37013e / 5) {
                                    f6 = random2;
                                }
                            }
                        }
                    }
                    random = f6;
                }
                this.f37020l.put(Float.valueOf(random), Float.valueOf(G2));
                C(canvas, random, G2, width);
            }
            if (this.f37020l.size() >= 10) {
                for (Map.Entry<Float, Float> entry : this.f37020l.entrySet()) {
                    C(canvas, entry.getKey().floatValue(), entry.getValue().floatValue(), width);
                }
            }
            if (this.f37024p && this.f37023o) {
                this.f37020l.clear();
                this.f37023o = false;
                this.f37022n = G(50, 300);
            }
            this.f37017i = this.f37016h;
        }
        z(canvas, width, height);
        B(canvas, width, height);
        A(canvas, width, height);
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        setMeasuredDimension(View.resolveSize(getSuggestedMinimumWidth(), i6), View.resolveSize(getSuggestedMinimumHeight(), i7));
    }

    public TaurusHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f37015g = false;
        F(context, attributeSet);
    }

    public TaurusHeader(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f37015g = false;
        F(context, attributeSet);
    }

    @RequiresApi(21)
    public TaurusHeader(Context context, @Nullable AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
        this.f37015g = false;
        F(context, attributeSet);
    }

    @Override // m2.f
    @NonNull
    public View getView() {
        return this;
    }

    @Override // m2.f
    public void i(float f6, int i6, int i7) {
    }

    @Override // m2.f
    public void q(g gVar, int i6, int i7) {
    }

    @Override // m2.e
    public void w(h hVar, int i6, int i7) {
    }

    @Override // n2.f
    public void x(h hVar, RefreshState refreshState, RefreshState refreshState2) {
    }
}
