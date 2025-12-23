package com.scwang.smartrefresh.header.fungame;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.ViewCompat;
import com.scwang.smartrefresh.header.R;
import com.scwang.smartrefresh.layout.util.a;
import com.scwang.smartrefresh.layout.util.c;
import m2.g;
import m2.h;
import org.apache.commons.net.ftp.l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class FunGameView extends FunGameHeader {
    protected static final int G = 0;
    protected static final int H = 1;
    protected static final int I = 2;
    protected static final int J = 3;
    protected static final int K = 4;
    protected static final float L = 0.161f;
    public static String M = "游戏结束";
    public static String N = "玩个游戏解解闷";
    public static String O = "刷新完成";
    public static String P = "刷新失败";
    protected int A;
    protected int B;
    protected int C;
    protected int D;
    protected int E;
    protected int F;

    /* renamed from: w, reason: collision with root package name */
    protected Paint f37118w;

    /* renamed from: x, reason: collision with root package name */
    protected TextPaint f37119x;

    /* renamed from: y, reason: collision with root package name */
    protected float f37120y;

    /* renamed from: z, reason: collision with root package name */
    protected int f37121z;

    public FunGameView(Context context) {
        super(context);
        this.A = 0;
        this.F = -10461088;
        H(context, null);
    }

    private void U(Canvas canvas, String str, int i6, int i7) {
        canvas.drawText(str, (i6 - this.f37119x.measureText(str)) * 0.5f, (i7 * 0.5f) - ((this.f37119x.ascent() + this.f37119x.descent()) * 0.5f), this.f37119x);
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameHeader
    protected void I() {
        T(1);
    }

    protected abstract void M(Canvas canvas, int i6, int i7);

    protected abstract void R();

    protected abstract void V();

    @Override // com.scwang.smartrefresh.header.fungame.FunGameBase
    protected void f(float f6, int i6, int i7, int i8) {
        S(Math.max(i6, 0));
    }

    private void H(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FunGameView);
        this.E = obtainStyledAttributes.getColor(R.styleable.FunGameView_fgvBackColor, 0);
        this.B = obtainStyledAttributes.getColor(R.styleable.FunGameView_fgvLeftColor, Color.rgb(0, 0, 0));
        this.D = obtainStyledAttributes.getColor(R.styleable.FunGameView_fgvMiddleColor, ViewCompat.MEASURED_STATE_MASK);
        this.C = obtainStyledAttributes.getColor(R.styleable.FunGameView_fgvRightColor, Color.parseColor("#A5A5A5"));
        int i6 = R.styleable.FunGameView_fgvTextGameOver;
        if (obtainStyledAttributes.hasValue(i6)) {
            M = obtainStyledAttributes.getString(i6);
        }
        if (obtainStyledAttributes.hasValue(i6)) {
            N = obtainStyledAttributes.getString(R.styleable.FunGameView_fgvTextLoading);
        }
        if (obtainStyledAttributes.hasValue(i6)) {
            O = obtainStyledAttributes.getString(R.styleable.FunGameView_fgvTextLoadingFinished);
        }
        obtainStyledAttributes.recycle();
        Q();
        P();
        R();
    }

    private void L(Canvas canvas, int i6, int i7) {
        this.f37118w.setColor(this.E);
        float f6 = i6;
        float f7 = i7;
        canvas.drawRect(0.0f, 0.0f, f6, f7, this.f37118w);
        this.f37118w.setColor(this.F);
        canvas.drawLine(0.0f, 0.0f, f6, 0.0f, this.f37118w);
        float f8 = this.f37106l;
        canvas.drawLine(0.0f, f7 - f8, f6, f7 - f8, this.f37118w);
    }

    private void N(Canvas canvas, int i6, int i7) {
        int i8 = this.A;
        if (i8 == 0 || i8 == 1) {
            this.f37119x.setTextSize(c.b(25.0f));
            U(canvas, N, i6, i7);
            return;
        }
        if (i8 == 2) {
            this.f37119x.setTextSize(c.b(25.0f));
            U(canvas, M, i6, i7);
        } else if (i8 == 3) {
            this.f37119x.setTextSize(c.b(20.0f));
            U(canvas, O, i6, i7);
        } else {
            if (i8 != 4) {
                return;
            }
            this.f37119x.setTextSize(c.b(20.0f));
            U(canvas, P, i6, i7);
        }
    }

    private DisplayMetrics O(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    protected void P() {
        this.f37120y = this.f37106l;
    }

    protected void Q() {
        TextPaint textPaint = new TextPaint(1);
        this.f37119x = textPaint;
        textPaint.setColor(Color.parseColor("#C1C2C2"));
        Paint paint = new Paint(1);
        this.f37118w = paint;
        paint.setStrokeWidth(this.f37106l);
    }

    public void S(float f6) {
        float f7 = (this.f37096b - (this.f37106l * 2.0f)) - this.f37121z;
        if (f6 > f7) {
            f6 = f7;
        }
        this.f37120y = f6;
        postInvalidate();
    }

    public void T(int i6) {
        this.A = i6;
        if (i6 == 0) {
            V();
        }
        postInvalidate();
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameHeader, com.scwang.smartrefresh.header.fungame.FunGameBase, m2.f
    public int d(h hVar, boolean z5) {
        if (this.f37101g) {
            T(z5 ? 3 : 4);
        } else {
            T(0);
        }
        return super.d(hVar, z5);
    }

    public int getCurrStatus() {
        return this.A;
    }

    public String getTextGameOver() {
        return M;
    }

    public String getTextLoading() {
        return N;
    }

    public String getTextLoadingFinished() {
        return O;
    }

    public void setTextGameOver(String str) {
        M = str;
    }

    public void setTextLoading(String str) {
        N = str;
    }

    public void setTextLoadingFinished(String str) {
        O = str;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int width = getWidth();
        int i6 = this.f37096b;
        L(canvas, width, i6);
        N(canvas, width, i6);
        M(canvas, width, i6);
        super.dispatchDraw(canvas);
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameHeader, com.scwang.smartrefresh.header.fungame.FunGameBase, m2.f
    public void q(g gVar, int i6, int i7) {
        super.q(gVar, i6, i7);
        R();
        T(0);
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameHeader, com.scwang.smartrefresh.header.fungame.FunGameBase, m2.f
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        super.setPrimaryColors(iArr);
        if (iArr.length > 0) {
            int i6 = iArr[0];
            this.E = i6;
            this.F = i6;
            if (i6 == 0 || i6 == -1) {
                this.F = -10461088;
            }
            if (iArr.length > 1) {
                int i7 = iArr[1];
                this.D = i7;
                this.B = a.A(i7, l.f50687n);
                this.C = a.A(iArr[1], 200);
                this.f37119x.setColor(a.A(iArr[1], 150));
            }
        }
    }

    public FunGameView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.A = 0;
        this.F = -10461088;
        H(context, attributeSet);
    }

    public FunGameView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.A = 0;
        this.F = -10461088;
        H(context, attributeSet);
    }

    @RequiresApi(21)
    public FunGameView(Context context, @Nullable AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
        this.A = 0;
        this.F = -10461088;
        H(context, attributeSet);
    }
}
