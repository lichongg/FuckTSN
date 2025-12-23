package com.scwang.smartrefresh.header;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.scwang.smartrefresh.header.internal.MaterialProgressDrawable;
import com.scwang.smartrefresh.header.waterdrop.WaterDropView;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import m2.e;
import m2.g;
import m2.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class WaterDropHeader extends ViewGroup implements e {

    /* renamed from: g, reason: collision with root package name */
    private static final float f37032g = 0.8f;

    /* renamed from: a, reason: collision with root package name */
    private RefreshState f37033a;

    /* renamed from: b, reason: collision with root package name */
    private ImageView f37034b;

    /* renamed from: c, reason: collision with root package name */
    private WaterDropView f37035c;

    /* renamed from: d, reason: collision with root package name */
    private com.scwang.smartrefresh.layout.internal.a f37036d;

    /* renamed from: e, reason: collision with root package name */
    private MaterialProgressDrawable f37037e;

    /* renamed from: f, reason: collision with root package name */
    private int f37038f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends AnimatorListenerAdapter {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.scwang.smartrefresh.header.WaterDropHeader$a$a, reason: collision with other inner class name */
        class C0724a extends AnimatorListenerAdapter {
            C0724a() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                WaterDropHeader.this.f37035c.setVisibility(8);
                WaterDropHeader.this.f37035c.setAlpha(1.0f);
            }
        }

        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            WaterDropHeader.this.f37035c.animate().alpha(0.0f).setListener(new C0724a());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f37041a;

        b(h hVar) {
            this.f37041a = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            WaterDropHeader waterDropHeader = WaterDropHeader.this;
            waterDropHeader.f37038f = (waterDropHeader.f37038f + 30) % 360;
            WaterDropHeader.this.invalidate();
            if (WaterDropHeader.this.f37033a == RefreshState.Refreshing || WaterDropHeader.this.f37033a == RefreshState.RefreshReleased) {
                this.f37041a.getLayout().postDelayed(this, 100L);
            }
        }
    }

    public WaterDropHeader(Context context) {
        super(context);
        this.f37038f = 0;
        B(context);
    }

    @Override // m2.f
    public int d(h hVar, boolean z5) {
        return 0;
    }

    @Override // m2.f
    public boolean j() {
        return false;
    }

    @Override // m2.f
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (iArr.length > 0) {
            this.f37035c.setIndicatorColor(iArr[0]);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f37043a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            f37043a = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f37043a[RefreshState.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f37043a[RefreshState.PullDownCanceled.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f37043a[RefreshState.ReleaseToRefresh.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f37043a[RefreshState.Refreshing.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f37043a[RefreshState.RefreshFinish.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private void B(Context context) {
        com.scwang.smartrefresh.layout.util.c cVar = new com.scwang.smartrefresh.layout.util.c();
        WaterDropView waterDropView = new WaterDropView(context);
        this.f37035c = waterDropView;
        addView(waterDropView, -1, -1);
        this.f37035c.e(0);
        com.scwang.smartrefresh.layout.internal.a aVar = new com.scwang.smartrefresh.layout.internal.a();
        this.f37036d = aVar;
        aVar.setBounds(0, 0, cVar.a(20.0f), cVar.a(20.0f));
        this.f37034b = new ImageView(context);
        MaterialProgressDrawable materialProgressDrawable = new MaterialProgressDrawable(context, this.f37034b);
        this.f37037e = materialProgressDrawable;
        materialProgressDrawable.f(-1);
        this.f37037e.setAlpha(255);
        this.f37037e.g(-1, -16737844, -48060, -10053376, -5609780, -30720);
        this.f37034b.setImageDrawable(this.f37037e);
        addView(this.f37034b, cVar.a(30.0f), cVar.a(30.0f));
    }

    @Override // m2.e
    public void g(float f6, int i6, int i7, int i8) {
        RefreshState refreshState = this.f37033a;
        if (refreshState == RefreshState.Refreshing || refreshState == RefreshState.RefreshReleased) {
            return;
        }
        this.f37035c.f(Math.max(i6, 0), i7 + i8);
        this.f37035c.postInvalidate();
    }

    @Override // m2.f
    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.Scale;
    }

    @Override // m2.e
    public void w(h hVar, int i6, int i7) {
        Animator a6 = this.f37035c.a();
        a6.addListener(new a());
        a6.start();
        hVar.getLayout().postDelayed(new b(hVar), 100L);
    }

    @Override // n2.f
    public void x(h hVar, RefreshState refreshState, RefreshState refreshState2) {
        this.f37033a = refreshState2;
        int i6 = c.f37043a[refreshState2.ordinal()];
        if (i6 == 1) {
            this.f37035c.setVisibility(0);
            return;
        }
        if (i6 == 2) {
            this.f37035c.setVisibility(0);
        } else if (i6 == 4) {
            this.f37035c.setVisibility(0);
        } else {
            if (i6 != 6) {
                return;
            }
            this.f37035c.setVisibility(8);
        }
    }

    @Override // m2.e
    public void y(float f6, int i6, int i7, int i8) {
        this.f37035c.f(i6, i8 + i7);
        this.f37035c.postInvalidate();
        float f7 = i7;
        float max = (((float) Math.max(Math.min(1.0f, Math.abs((i6 * 1.0f) / f7)) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        double max2 = Math.max(0.0f, Math.min(Math.abs(i6) - i7, f7 * 2.0f) / f7) / 4.0f;
        float pow = ((float) (max2 - Math.pow(max2, 2.0d))) * 2.0f;
        float f8 = max * f37032g;
        this.f37037e.m(true);
        this.f37037e.k(0.0f, Math.min(f37032g, f8));
        this.f37037e.e(Math.min(1.0f, max));
        this.f37037e.h((((0.4f * max) - 0.25f) + (pow * 2.0f)) * 0.5f);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f37033a == RefreshState.Refreshing) {
            canvas.save();
            canvas.translate((getWidth() / 2) - (this.f37036d.e() / 2), (this.f37035c.getMaxCircleRadius() + this.f37035c.getPaddingTop()) - (this.f37036d.b() / 2));
            canvas.rotate(this.f37038f, this.f37036d.e() / 2, this.f37036d.b() / 2);
            this.f37036d.draw(canvas);
            canvas.restore();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = this.f37035c.getMeasuredWidth();
        int i10 = measuredWidth / 2;
        int i11 = measuredWidth2 / 2;
        int i12 = i10 - i11;
        this.f37035c.layout(i12, 0, i12 + measuredWidth2, this.f37035c.getMeasuredHeight());
        int measuredWidth3 = this.f37034b.getMeasuredWidth();
        int measuredHeight = this.f37034b.getMeasuredHeight();
        int i13 = measuredWidth3 / 2;
        int i14 = i10 - i13;
        int i15 = i11 - i13;
        int i16 = (measuredWidth2 - measuredWidth3) / 2;
        if (i15 + measuredHeight > this.f37035c.getBottom() - i16) {
            i15 = (this.f37035c.getBottom() - i16) - measuredHeight;
        }
        this.f37034b.layout(i14, i15, measuredWidth3 + i14, measuredHeight + i15);
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        super.onMeasure(i6, i7);
        ViewGroup.LayoutParams layoutParams = this.f37034b.getLayoutParams();
        this.f37034b.measure(View.MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824), View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824));
        this.f37035c.measure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i6), Integer.MIN_VALUE), i7);
        setMeasuredDimension(View.resolveSize(Math.max(this.f37034b.getMeasuredWidth(), this.f37035c.getMeasuredHeight()), i6), View.resolveSize(Math.max(this.f37034b.getMeasuredHeight(), this.f37035c.getMeasuredHeight()), i7));
    }

    public WaterDropHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f37038f = 0;
        B(context);
    }

    public WaterDropHeader(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f37038f = 0;
        B(context);
    }

    @RequiresApi(21)
    public WaterDropHeader(Context context, AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
        this.f37038f = 0;
        B(context);
    }

    @Override // m2.f
    @NonNull
    public View getView() {
        return this;
    }

    @Override // m2.f
    public void h(h hVar, int i6, int i7) {
    }

    @Override // m2.f
    public void i(float f6, int i6, int i7) {
    }

    @Override // m2.f
    public void q(g gVar, int i6, int i7) {
    }
}
