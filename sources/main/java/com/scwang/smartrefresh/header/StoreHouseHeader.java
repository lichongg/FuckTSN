package com.scwang.smartrefresh.header;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Transformation;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.util.c;
import java.util.ArrayList;
import m2.e;
import m2.g;
import m2.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class StoreHouseHeader extends View implements e {

    /* renamed from: u, reason: collision with root package name */
    private static final float f36968u = 0.7f;

    /* renamed from: v, reason: collision with root package name */
    private static final float f36969v = 0.4f;

    /* renamed from: w, reason: collision with root package name */
    private static final float f36970w = 1.0f;

    /* renamed from: x, reason: collision with root package name */
    private static final float f36971x = 0.4f;

    /* renamed from: y, reason: collision with root package name */
    private static final int f36972y = 400;

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<com.scwang.smartrefresh.header.storehouse.a> f36973a;

    /* renamed from: b, reason: collision with root package name */
    private int f36974b;

    /* renamed from: c, reason: collision with root package name */
    private float f36975c;

    /* renamed from: d, reason: collision with root package name */
    private int f36976d;

    /* renamed from: e, reason: collision with root package name */
    private int f36977e;

    /* renamed from: f, reason: collision with root package name */
    private float f36978f;

    /* renamed from: g, reason: collision with root package name */
    private int f36979g;

    /* renamed from: h, reason: collision with root package name */
    private int f36980h;

    /* renamed from: i, reason: collision with root package name */
    private int f36981i;

    /* renamed from: j, reason: collision with root package name */
    private int f36982j;

    /* renamed from: k, reason: collision with root package name */
    private int f36983k;

    /* renamed from: l, reason: collision with root package name */
    private int f36984l;

    /* renamed from: m, reason: collision with root package name */
    private Transformation f36985m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f36986n;

    /* renamed from: o, reason: collision with root package name */
    private b f36987o;

    /* renamed from: p, reason: collision with root package name */
    private int f36988p;

    /* renamed from: q, reason: collision with root package name */
    private int f36989q;

    /* renamed from: r, reason: collision with root package name */
    private Matrix f36990r;

    /* renamed from: s, reason: collision with root package name */
    private g f36991s;

    /* renamed from: t, reason: collision with root package name */
    private Runnable f36992t;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private int f36993a;

        /* renamed from: b, reason: collision with root package name */
        private int f36994b;

        /* renamed from: c, reason: collision with root package name */
        private int f36995c;

        /* renamed from: d, reason: collision with root package name */
        private int f36996d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f36997e;

        private b() {
            this.f36993a = 0;
            this.f36994b = 0;
            this.f36995c = 0;
            this.f36996d = 0;
            this.f36997e = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            this.f36997e = true;
            this.f36993a = 0;
            this.f36996d = StoreHouseHeader.this.f36983k / StoreHouseHeader.this.f36973a.size();
            this.f36994b = StoreHouseHeader.this.f36984l / this.f36996d;
            this.f36995c = (StoreHouseHeader.this.f36973a.size() / this.f36994b) + 1;
            run();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d() {
            this.f36997e = false;
            StoreHouseHeader.this.removeCallbacks(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            int i6 = this.f36993a % this.f36994b;
            for (int i7 = 0; i7 < this.f36995c; i7++) {
                int i8 = (this.f36994b * i7) + i6;
                if (i8 <= this.f36993a) {
                    com.scwang.smartrefresh.header.storehouse.a aVar = StoreHouseHeader.this.f36973a.get(i8 % StoreHouseHeader.this.f36973a.size());
                    aVar.setFillAfter(false);
                    aVar.setFillEnabled(true);
                    aVar.setFillBefore(false);
                    aVar.setDuration(400L);
                    aVar.g(1.0f, 0.4f);
                }
            }
            this.f36993a++;
            if (!this.f36997e || StoreHouseHeader.this.f36991s == null) {
                return;
            }
            StoreHouseHeader.this.f36991s.c().getLayout().postDelayed(this, this.f36996d);
        }

        /* synthetic */ b(StoreHouseHeader storeHouseHeader, a aVar) {
            this();
        }
    }

    public StoreHouseHeader(Context context) {
        super(context);
        this.f36973a = new ArrayList<>();
        this.f36974b = -1;
        this.f36975c = 1.0f;
        this.f36976d = -1;
        this.f36977e = -1;
        this.f36978f = 0.0f;
        this.f36979g = 0;
        this.f36980h = 0;
        this.f36981i = 0;
        this.f36982j = 0;
        this.f36983k = 1000;
        this.f36984l = 1000;
        this.f36985m = new Transformation();
        this.f36986n = false;
        this.f36987o = new b(this, null);
        this.f36988p = -1;
        this.f36989q = 0;
        this.f36990r = new Matrix();
        B(context, null);
    }

    private void A() {
        this.f36986n = true;
        this.f36987o.c();
        invalidate();
    }

    private void G() {
        this.f36986n = false;
        this.f36987o.d();
    }

    public StoreHouseHeader E(String str, int i6) {
        C(com.scwang.smartrefresh.header.storehouse.b.c(str, i6 * 0.01f, 14));
        return this;
    }

    @Override // m2.f
    public boolean j() {
        return false;
    }

    @Override // m2.f
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (iArr.length > 0) {
            int i6 = iArr[0];
            this.f36989q = i6;
            g gVar = this.f36991s;
            if (gVar != null) {
                gVar.f(i6);
            }
            if (iArr.length > 1) {
                N(iArr[1]);
            }
        }
    }

    private void B(Context context, AttributeSet attributeSet) {
        c cVar = new c();
        this.f36974b = cVar.a(1.0f);
        this.f36976d = cVar.a(40.0f);
        this.f36977e = Resources.getSystem().getDisplayMetrics().widthPixels / 2;
        this.f36989q = -13421773;
        N(-3355444);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.StoreHouseHeader);
        this.f36974b = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.StoreHouseHeader_shhLineWidth, this.f36974b);
        this.f36976d = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.StoreHouseHeader_shhDropHeight, this.f36976d);
        int i6 = R.styleable.StoreHouseHeader_shhText;
        if (obtainStyledAttributes.hasValue(i6)) {
            D(obtainStyledAttributes.getString(i6));
        } else {
            D("StoreHouse");
        }
        obtainStyledAttributes.recycle();
        setMinimumHeight(this.f36980h + c.b(40.0f));
    }

    private void I() {
        Runnable runnable = this.f36992t;
        if (runnable != null) {
            runnable.run();
            this.f36992t = null;
        }
    }

    private void setProgress(float f6) {
        this.f36978f = f6;
    }

    public StoreHouseHeader C(ArrayList<float[]> arrayList) {
        boolean z5 = this.f36973a.size() > 0;
        this.f36973a.clear();
        c cVar = new c();
        float f6 = 0.0f;
        float f7 = 0.0f;
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            float[] fArr = arrayList.get(i6);
            PointF pointF = new PointF(cVar.a(fArr[0]) * this.f36975c, cVar.a(fArr[1]) * this.f36975c);
            PointF pointF2 = new PointF(cVar.a(fArr[2]) * this.f36975c, cVar.a(fArr[3]) * this.f36975c);
            f6 = Math.max(Math.max(f6, pointF.x), pointF2.x);
            f7 = Math.max(Math.max(f7, pointF.y), pointF2.y);
            com.scwang.smartrefresh.header.storehouse.a aVar = new com.scwang.smartrefresh.header.storehouse.a(i6, pointF, pointF2, this.f36988p, this.f36974b);
            aVar.b(this.f36977e);
            this.f36973a.add(aVar);
        }
        this.f36979g = (int) Math.ceil(f6);
        this.f36980h = (int) Math.ceil(f7);
        if (z5) {
            requestLayout();
        }
        return this;
    }

    public StoreHouseHeader D(String str) {
        E(str, 25);
        return this;
    }

    public StoreHouseHeader J(int i6) {
        this.f36976d = i6;
        return this;
    }

    public StoreHouseHeader K(int i6) {
        this.f36974b = i6;
        for (int i7 = 0; i7 < this.f36973a.size(); i7++) {
            this.f36973a.get(i7).f(i6);
        }
        return this;
    }

    public StoreHouseHeader L(int i6) {
        this.f36983k = i6;
        this.f36984l = i6;
        return this;
    }

    public StoreHouseHeader M(float f6) {
        this.f36975c = f6;
        return this;
    }

    public StoreHouseHeader N(@ColorInt int i6) {
        this.f36988p = i6;
        for (int i7 = 0; i7 < this.f36973a.size(); i7++) {
            this.f36973a.get(i7).e(i6);
        }
        return this;
    }

    public int getLoadingAniDuration() {
        return this.f36983k;
    }

    public float getScale() {
        return this.f36975c;
    }

    @Override // m2.f
    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.Translate;
    }

    @Override // m2.f
    public void q(g gVar, int i6, int i7) {
        int i8 = this.f36989q;
        if (i8 != 0) {
            gVar.f(i8);
        }
        this.f36991s = gVar;
    }

    @Override // n2.f
    public void x(h hVar, RefreshState refreshState, RefreshState refreshState2) {
        if (refreshState2 == RefreshState.ReleaseToRefresh) {
            H(hVar);
        } else if (refreshState2 == RefreshState.None) {
            I();
        }
    }

    private int getBottomOffset() {
        return getPaddingBottom() + c.b(10.0f);
    }

    private int getTopOffset() {
        return getPaddingTop() + c.b(10.0f);
    }

    public StoreHouseHeader F(int i6) {
        String[] stringArray = getResources().getStringArray(i6);
        ArrayList<float[]> arrayList = new ArrayList<>();
        for (String str : stringArray) {
            String[] split = str.split(",");
            float[] fArr = new float[4];
            for (int i7 = 0; i7 < 4; i7++) {
                fArr[i7] = Float.parseFloat(split[i7]);
            }
            arrayList.add(fArr);
        }
        C(arrayList);
        return this;
    }

    @Override // m2.f
    public int d(h hVar, boolean z5) {
        G();
        for (int i6 = 0; i6 < this.f36973a.size(); i6++) {
            this.f36973a.get(i6).b(this.f36977e);
        }
        return 0;
    }

    @Override // m2.e
    public void g(float f6, int i6, int i7, int i8) {
        setProgress(f6 * 0.8f);
        invalidate();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f36991s = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f6 = this.f36978f;
        int save = canvas.save();
        int size = this.f36973a.size();
        if (isInEditMode()) {
            f6 = 1.0f;
        }
        for (int i6 = 0; i6 < size; i6++) {
            canvas.save();
            com.scwang.smartrefresh.header.storehouse.a aVar = this.f36973a.get(i6);
            float f7 = this.f36981i;
            PointF pointF = aVar.f37191a;
            float f8 = f7 + pointF.x;
            float f9 = this.f36982j + pointF.y;
            if (this.f36986n) {
                aVar.getTransformation(getDrawingTime(), this.f36985m);
                canvas.translate(f8, f9);
            } else {
                float f10 = 0.0f;
                if (f6 == 0.0f) {
                    aVar.b(this.f36977e);
                } else {
                    float f11 = (i6 * 0.3f) / size;
                    float f12 = 0.3f - f11;
                    if (f6 != 1.0f && f6 < 1.0f - f12) {
                        if (f6 > f11) {
                            f10 = Math.min(1.0f, (f6 - f11) / 0.7f);
                        }
                        float f13 = 1.0f - f10;
                        this.f36990r.reset();
                        this.f36990r.postRotate(360.0f * f10);
                        this.f36990r.postScale(f10, f10);
                        this.f36990r.postTranslate(f8 + (aVar.f37192b * f13), f9 + ((-this.f36976d) * f13));
                        aVar.c(f10 * 0.4f);
                        canvas.concat(this.f36990r);
                    } else {
                        canvas.translate(f8, f9);
                        aVar.c(0.4f);
                    }
                }
            }
            aVar.a(canvas);
            canvas.restore();
        }
        if (this.f36986n) {
            invalidate();
        }
        canvas.restoreToCount(save);
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        setMeasuredDimension(View.resolveSize(getSuggestedMinimumWidth(), i6), View.resolveSize(getSuggestedMinimumHeight(), i7));
        this.f36981i = (getMeasuredWidth() - this.f36979g) / 2;
        this.f36982j = (getMeasuredHeight() - this.f36980h) / 2;
        this.f36976d = getMeasuredHeight() / 2;
    }

    @Override // m2.e
    public void w(h hVar, int i6, int i7) {
        A();
    }

    @Override // m2.e
    public void y(float f6, int i6, int i7, int i8) {
        setProgress(f6 * 0.8f);
        invalidate();
    }

    @Override // m2.f
    @NonNull
    public View getView() {
        return this;
    }

    public StoreHouseHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f36973a = new ArrayList<>();
        this.f36974b = -1;
        this.f36975c = 1.0f;
        this.f36976d = -1;
        this.f36977e = -1;
        this.f36978f = 0.0f;
        this.f36979g = 0;
        this.f36980h = 0;
        this.f36981i = 0;
        this.f36982j = 0;
        this.f36983k = 1000;
        this.f36984l = 1000;
        this.f36985m = new Transformation();
        this.f36986n = false;
        this.f36987o = new b(this, null);
        this.f36988p = -1;
        this.f36989q = 0;
        this.f36990r = new Matrix();
        B(context, attributeSet);
    }

    private void H(h hVar) {
    }

    public StoreHouseHeader(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f36973a = new ArrayList<>();
        this.f36974b = -1;
        this.f36975c = 1.0f;
        this.f36976d = -1;
        this.f36977e = -1;
        this.f36978f = 0.0f;
        this.f36979g = 0;
        this.f36980h = 0;
        this.f36981i = 0;
        this.f36982j = 0;
        this.f36983k = 1000;
        this.f36984l = 1000;
        this.f36985m = new Transformation();
        this.f36986n = false;
        this.f36987o = new b(this, null);
        this.f36988p = -1;
        this.f36989q = 0;
        this.f36990r = new Matrix();
        B(context, attributeSet);
    }

    @RequiresApi(21)
    public StoreHouseHeader(Context context, @Nullable AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
        this.f36973a = new ArrayList<>();
        this.f36974b = -1;
        this.f36975c = 1.0f;
        this.f36976d = -1;
        this.f36977e = -1;
        this.f36978f = 0.0f;
        this.f36979g = 0;
        this.f36980h = 0;
        this.f36981i = 0;
        this.f36982j = 0;
        this.f36983k = 1000;
        this.f36984l = 1000;
        this.f36985m = new Transformation();
        this.f36986n = false;
        this.f36987o = new b(this, null);
        this.f36988p = -1;
        this.f36989q = 0;
        this.f36990r = new Matrix();
        B(context, attributeSet);
    }

    @Override // m2.f
    public void h(h hVar, int i6, int i7) {
    }

    @Override // m2.f
    public void i(float f6, int i6, int i7) {
    }
}
