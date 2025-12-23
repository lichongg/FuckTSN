package com.scwang.smartrefresh.layout.footer;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.internal.pathview.b;
import com.scwang.smartrefresh.layout.util.c;
import m2.d;
import m2.g;
import m2.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class ClassicsFooter extends RelativeLayout implements d {

    /* renamed from: m, reason: collision with root package name */
    public static String f37326m = "上拉加载更多";

    /* renamed from: n, reason: collision with root package name */
    public static String f37327n = "释放立即加载";

    /* renamed from: o, reason: collision with root package name */
    public static String f37328o = "正在加载...";

    /* renamed from: p, reason: collision with root package name */
    public static String f37329p = "正在刷新...";

    /* renamed from: q, reason: collision with root package name */
    public static String f37330q = "加载完成";

    /* renamed from: r, reason: collision with root package name */
    public static String f37331r = "加载失败";

    /* renamed from: s, reason: collision with root package name */
    public static String f37332s = "全部加载完成";

    /* renamed from: a, reason: collision with root package name */
    protected TextView f37333a;

    /* renamed from: b, reason: collision with root package name */
    protected ImageView f37334b;

    /* renamed from: c, reason: collision with root package name */
    protected ImageView f37335c;

    /* renamed from: d, reason: collision with root package name */
    protected b f37336d;

    /* renamed from: e, reason: collision with root package name */
    protected com.scwang.smartrefresh.layout.internal.a f37337e;

    /* renamed from: f, reason: collision with root package name */
    protected SpinnerStyle f37338f;

    /* renamed from: g, reason: collision with root package name */
    protected g f37339g;

    /* renamed from: h, reason: collision with root package name */
    protected int f37340h;

    /* renamed from: i, reason: collision with root package name */
    protected int f37341i;

    /* renamed from: j, reason: collision with root package name */
    protected boolean f37342j;

    /* renamed from: k, reason: collision with root package name */
    protected int f37343k;

    /* renamed from: l, reason: collision with root package name */
    protected int f37344l;

    public ClassicsFooter(Context context) {
        super(context);
        this.f37338f = SpinnerStyle.Translate;
        this.f37340h = 500;
        this.f37341i = 0;
        this.f37342j = false;
        this.f37343k = 20;
        this.f37344l = 20;
        a(context, null, 0);
    }

    public ClassicsFooter A(Bitmap bitmap) {
        this.f37336d = null;
        this.f37334b.setImageBitmap(bitmap);
        return this;
    }

    public ClassicsFooter B(Drawable drawable) {
        this.f37336d = null;
        this.f37334b.setImageDrawable(drawable);
        return this;
    }

    public ClassicsFooter C(@DrawableRes int i6) {
        this.f37336d = null;
        this.f37334b.setImageResource(i6);
        return this;
    }

    public ClassicsFooter O(Bitmap bitmap) {
        this.f37337e = null;
        this.f37335c.setImageBitmap(bitmap);
        return this;
    }

    public ClassicsFooter P(Drawable drawable) {
        this.f37337e = null;
        this.f37335c.setImageDrawable(drawable);
        return this;
    }

    public ClassicsFooter Q(@DrawableRes int i6) {
        this.f37337e = null;
        this.f37335c.setImageResource(i6);
        return this;
    }

    @Override // m2.f
    public boolean j() {
        return false;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f37345a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            f37345a = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f37345a[RefreshState.PullToUpLoad.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f37345a[RefreshState.Loading.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f37345a[RefreshState.LoadReleased.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f37345a[RefreshState.ReleaseToLoad.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f37345a[RefreshState.Refreshing.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private void a(Context context, AttributeSet attributeSet, int i6) {
        c cVar = new c();
        TextView textView = new TextView(context);
        this.f37333a = textView;
        textView.setId(R.id.widget_frame);
        this.f37333a.setTextColor(-10066330);
        this.f37333a.setText(f37326m);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.f37333a, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(cVar.a(20.0f), cVar.a(20.0f));
        layoutParams2.addRule(15);
        layoutParams2.addRule(0, R.id.widget_frame);
        ImageView imageView = new ImageView(context);
        this.f37334b = imageView;
        addView(imageView, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((ViewGroup.LayoutParams) layoutParams2);
        layoutParams3.addRule(15);
        layoutParams3.addRule(0, R.id.widget_frame);
        ImageView imageView2 = new ImageView(context);
        this.f37335c = imageView2;
        imageView2.animate().setInterpolator(new LinearInterpolator());
        addView(this.f37335c, layoutParams3);
        if (isInEditMode()) {
            this.f37334b.setVisibility(8);
        } else {
            this.f37335c.setVisibility(8);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.scwang.smartrefresh.layout.R.styleable.ClassicsFooter);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(com.scwang.smartrefresh.layout.R.styleable.ClassicsFooter_srlDrawableMarginRight, cVar.a(20.0f));
        layoutParams3.rightMargin = dimensionPixelSize;
        layoutParams2.rightMargin = dimensionPixelSize;
        int i7 = com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader_srlDrawableArrowSize;
        layoutParams2.width = obtainStyledAttributes.getLayoutDimension(i7, layoutParams2.width);
        layoutParams2.height = obtainStyledAttributes.getLayoutDimension(i7, layoutParams2.height);
        int i8 = com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader_srlDrawableProgressSize;
        layoutParams3.width = obtainStyledAttributes.getLayoutDimension(i8, layoutParams3.width);
        layoutParams3.height = obtainStyledAttributes.getLayoutDimension(i8, layoutParams3.height);
        int i9 = com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader_srlDrawableSize;
        layoutParams2.width = obtainStyledAttributes.getLayoutDimension(i9, layoutParams2.width);
        layoutParams2.height = obtainStyledAttributes.getLayoutDimension(i9, layoutParams2.height);
        layoutParams3.width = obtainStyledAttributes.getLayoutDimension(i9, layoutParams3.width);
        layoutParams3.height = obtainStyledAttributes.getLayoutDimension(i9, layoutParams3.height);
        this.f37340h = obtainStyledAttributes.getInt(com.scwang.smartrefresh.layout.R.styleable.ClassicsFooter_srlFinishDuration, this.f37340h);
        this.f37338f = SpinnerStyle.values()[obtainStyledAttributes.getInt(com.scwang.smartrefresh.layout.R.styleable.ClassicsFooter_srlClassicsSpinnerStyle, this.f37338f.ordinal())];
        int i10 = com.scwang.smartrefresh.layout.R.styleable.ClassicsFooter_srlDrawableArrow;
        if (obtainStyledAttributes.hasValue(i10)) {
            this.f37334b.setImageDrawable(obtainStyledAttributes.getDrawable(i10));
        } else {
            b bVar = new b();
            this.f37336d = bVar;
            bVar.h(-10066330);
            this.f37336d.i("M20,12l-1.41,-1.41L13,16.17V4h-2v12.17l-5.58,-5.59L4,12l8,8 8,-8z");
            this.f37334b.setImageDrawable(this.f37336d);
        }
        int i11 = com.scwang.smartrefresh.layout.R.styleable.ClassicsFooter_srlDrawableProgress;
        if (obtainStyledAttributes.hasValue(i11)) {
            this.f37335c.setImageDrawable(obtainStyledAttributes.getDrawable(i11));
        } else {
            com.scwang.smartrefresh.layout.internal.a aVar = new com.scwang.smartrefresh.layout.internal.a();
            this.f37337e = aVar;
            aVar.c(-10066330);
            this.f37335c.setImageDrawable(this.f37337e);
        }
        if (obtainStyledAttributes.hasValue(com.scwang.smartrefresh.layout.R.styleable.ClassicsFooter_srlTextSizeTitle)) {
            this.f37333a.setTextSize(0, obtainStyledAttributes.getDimensionPixelSize(r9, c.b(16.0f)));
        } else {
            this.f37333a.setTextSize(16.0f);
        }
        int i12 = com.scwang.smartrefresh.layout.R.styleable.ClassicsFooter_srlPrimaryColor;
        if (obtainStyledAttributes.hasValue(i12)) {
            M(obtainStyledAttributes.getColor(i12, 0));
        }
        int i13 = com.scwang.smartrefresh.layout.R.styleable.ClassicsFooter_srlAccentColor;
        if (obtainStyledAttributes.hasValue(i13)) {
            f(obtainStyledAttributes.getColor(i13, 0));
        }
        obtainStyledAttributes.recycle();
        if (getPaddingTop() != 0) {
            if (getPaddingBottom() != 0) {
                this.f37343k = getPaddingTop();
                this.f37344l = getPaddingBottom();
                return;
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            this.f37343k = paddingTop;
            int paddingRight = getPaddingRight();
            int a6 = cVar.a(20.0f);
            this.f37344l = a6;
            setPadding(paddingLeft, paddingTop, paddingRight, a6);
            return;
        }
        if (getPaddingBottom() == 0) {
            int paddingLeft2 = getPaddingLeft();
            int a7 = cVar.a(20.0f);
            this.f37343k = a7;
            int paddingRight2 = getPaddingRight();
            int a8 = cVar.a(20.0f);
            this.f37344l = a8;
            setPadding(paddingLeft2, a7, paddingRight2, a8);
            return;
        }
        int paddingLeft3 = getPaddingLeft();
        int a9 = cVar.a(20.0f);
        this.f37343k = a9;
        int paddingRight3 = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        this.f37344l = paddingBottom;
        setPadding(paddingLeft3, a9, paddingRight3, paddingBottom);
    }

    public ClassicsFooter E(int i6) {
        ViewGroup.LayoutParams layoutParams = this.f37334b.getLayoutParams();
        layoutParams.width = i6;
        layoutParams.height = i6;
        this.f37334b.setLayoutParams(layoutParams);
        return this;
    }

    public ClassicsFooter G(int i6) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f37334b.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f37335c.getLayoutParams();
        marginLayoutParams2.rightMargin = i6;
        marginLayoutParams.rightMargin = i6;
        this.f37334b.setLayoutParams(marginLayoutParams);
        this.f37335c.setLayoutParams(marginLayoutParams2);
        return this;
    }

    public ClassicsFooter I(int i6) {
        ViewGroup.LayoutParams layoutParams = this.f37335c.getLayoutParams();
        layoutParams.width = i6;
        layoutParams.height = i6;
        this.f37335c.setLayoutParams(layoutParams);
        return this;
    }

    public ClassicsFooter K(int i6) {
        ViewGroup.LayoutParams layoutParams = this.f37334b.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.f37335c.getLayoutParams();
        layoutParams2.width = i6;
        layoutParams.width = i6;
        layoutParams2.height = i6;
        layoutParams.height = i6;
        this.f37334b.setLayoutParams(layoutParams);
        this.f37335c.setLayoutParams(layoutParams2);
        return this;
    }

    public ClassicsFooter L(int i6) {
        this.f37340h = i6;
        return this;
    }

    public ClassicsFooter M(@ColorInt int i6) {
        this.f37341i = i6;
        setBackgroundColor(i6);
        g gVar = this.f37339g;
        if (gVar != null) {
            gVar.n(this.f37341i);
        }
        return this;
    }

    public ClassicsFooter R(SpinnerStyle spinnerStyle) {
        this.f37338f = spinnerStyle;
        return this;
    }

    public ClassicsFooter S(float f6) {
        this.f37333a.setTextSize(f6);
        g gVar = this.f37339g;
        if (gVar != null) {
            gVar.o();
        }
        return this;
    }

    public ClassicsFooter T(int i6, float f6) {
        this.f37333a.setTextSize(i6, f6);
        g gVar = this.f37339g;
        if (gVar != null) {
            gVar.o();
        }
        return this;
    }

    @Override // m2.d
    public boolean b(boolean z5) {
        if (this.f37342j == z5) {
            return true;
        }
        this.f37342j = z5;
        if (z5) {
            this.f37333a.setText(f37332s);
            this.f37334b.setVisibility(8);
        } else {
            this.f37333a.setText(f37326m);
            this.f37334b.setVisibility(0);
        }
        com.scwang.smartrefresh.layout.internal.a aVar = this.f37337e;
        if (aVar != null) {
            aVar.stop();
        } else {
            this.f37335c.animate().rotation(0.0f).setDuration(300L);
        }
        this.f37335c.setVisibility(8);
        return true;
    }

    @Override // m2.f
    public int d(h hVar, boolean z5) {
        if (this.f37342j) {
            return 0;
        }
        com.scwang.smartrefresh.layout.internal.a aVar = this.f37337e;
        if (aVar != null) {
            aVar.stop();
        } else {
            this.f37335c.animate().rotation(0.0f).setDuration(300L);
        }
        this.f37335c.setVisibility(8);
        if (z5) {
            this.f37333a.setText(f37330q);
        } else {
            this.f37333a.setText(f37331r);
        }
        return this.f37340h;
    }

    public ClassicsFooter f(@ColorInt int i6) {
        this.f37333a.setTextColor(i6);
        com.scwang.smartrefresh.layout.internal.a aVar = this.f37337e;
        if (aVar != null) {
            aVar.c(i6);
        }
        b bVar = this.f37336d;
        if (bVar != null) {
            bVar.h(i6);
        }
        return this;
    }

    public ImageView getArrowView() {
        return this.f37334b;
    }

    public ImageView getProgressView() {
        return this.f37335c;
    }

    @Override // m2.f
    public SpinnerStyle getSpinnerStyle() {
        return this.f37338f;
    }

    public TextView getTitleText() {
        return this.f37333a;
    }

    @Override // m2.d
    public void k(h hVar, int i6, int i7) {
        if (this.f37342j) {
            return;
        }
        this.f37335c.setVisibility(0);
        com.scwang.smartrefresh.layout.internal.a aVar = this.f37337e;
        if (aVar != null) {
            aVar.start();
        } else {
            this.f37335c.animate().rotation(36000.0f).setDuration(100000L);
        }
    }

    @Override // m2.f
    public void q(g gVar, int i6, int i7) {
        this.f37339g = gVar;
        gVar.n(this.f37341i);
    }

    @Override // m2.f
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (this.f37338f != SpinnerStyle.FixedBehind || iArr.length <= 0) {
            return;
        }
        if (!(getBackground() instanceof BitmapDrawable)) {
            M(iArr[0]);
        }
        if (iArr.length > 1) {
            f(iArr[1]);
        } else {
            f(iArr[0] == -1 ? -10066330 : -1);
        }
    }

    @Override // n2.f
    public void x(h hVar, RefreshState refreshState, RefreshState refreshState2) {
        if (this.f37342j) {
            return;
        }
        switch (a.f37345a[refreshState2.ordinal()]) {
            case 1:
                this.f37334b.setVisibility(0);
                break;
            case 2:
                break;
            case 3:
            case 4:
                this.f37334b.setVisibility(8);
                this.f37333a.setText(f37328o);
                return;
            case 5:
                this.f37333a.setText(f37327n);
                this.f37334b.animate().rotation(0.0f);
                return;
            case 6:
                this.f37333a.setText(f37329p);
                this.f37335c.setVisibility(8);
                this.f37334b.setVisibility(8);
                return;
            default:
                return;
        }
        this.f37333a.setText(f37326m);
        this.f37334b.animate().rotation(180.0f);
    }

    public ClassicsFooter D(float f6) {
        return E(c.b(f6));
    }

    public ClassicsFooter F(float f6) {
        return G(c.b(f6));
    }

    public ClassicsFooter H(float f6) {
        return I(c.b(f6));
    }

    public ClassicsFooter J(float f6) {
        return K(c.b(f6));
    }

    public ClassicsFooter N(@ColorRes int i6) {
        M(ContextCompat.getColor(getContext(), i6));
        return this;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i6, int i7) {
        if (View.MeasureSpec.getMode(i7) == 1073741824) {
            setPadding(getPaddingLeft(), 0, getPaddingRight(), 0);
        } else {
            setPadding(getPaddingLeft(), this.f37343k, getPaddingRight(), this.f37344l);
        }
        super.onMeasure(i6, i7);
    }

    public ClassicsFooter z(@ColorRes int i6) {
        f(ContextCompat.getColor(getContext(), i6));
        return this;
    }

    public ClassicsFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f37338f = SpinnerStyle.Translate;
        this.f37340h = 500;
        this.f37341i = 0;
        this.f37342j = false;
        this.f37343k = 20;
        this.f37344l = 20;
        a(context, attributeSet, 0);
    }

    public ClassicsFooter(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f37338f = SpinnerStyle.Translate;
        this.f37340h = 500;
        this.f37341i = 0;
        this.f37342j = false;
        this.f37343k = 20;
        this.f37344l = 20;
        a(context, attributeSet, i6);
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

    @Override // m2.d
    public void c(float f6, int i6, int i7, int i8) {
    }

    @Override // m2.d
    public void v(float f6, int i6, int i7, int i8) {
    }
}
