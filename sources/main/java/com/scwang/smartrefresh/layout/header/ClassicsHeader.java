package com.scwang.smartrefresh.layout.header;

import android.R;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.internal.pathview.b;
import com.scwang.smartrefresh.layout.util.c;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import m2.e;
import m2.g;
import m2.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class ClassicsHeader extends RelativeLayout implements e {

    /* renamed from: r, reason: collision with root package name */
    public static String f37368r = "下拉可以刷新";

    /* renamed from: s, reason: collision with root package name */
    public static String f37369s = "正在刷新...";

    /* renamed from: t, reason: collision with root package name */
    public static String f37370t = "正在加载...";

    /* renamed from: u, reason: collision with root package name */
    public static String f37371u = "释放立即刷新";

    /* renamed from: v, reason: collision with root package name */
    public static String f37372v = "刷新完成";

    /* renamed from: w, reason: collision with root package name */
    public static String f37373w = "刷新失败";

    /* renamed from: x, reason: collision with root package name */
    public static String f37374x = "上次更新 M-d HH:mm";

    /* renamed from: y, reason: collision with root package name */
    public static String f37375y = "释放进入二楼";

    /* renamed from: a, reason: collision with root package name */
    protected String f37376a;

    /* renamed from: b, reason: collision with root package name */
    protected Date f37377b;

    /* renamed from: c, reason: collision with root package name */
    protected TextView f37378c;

    /* renamed from: d, reason: collision with root package name */
    protected TextView f37379d;

    /* renamed from: e, reason: collision with root package name */
    protected ImageView f37380e;

    /* renamed from: f, reason: collision with root package name */
    protected ImageView f37381f;

    /* renamed from: g, reason: collision with root package name */
    protected SharedPreferences f37382g;

    /* renamed from: h, reason: collision with root package name */
    protected g f37383h;

    /* renamed from: i, reason: collision with root package name */
    protected b f37384i;

    /* renamed from: j, reason: collision with root package name */
    protected com.scwang.smartrefresh.layout.internal.a f37385j;

    /* renamed from: k, reason: collision with root package name */
    protected SpinnerStyle f37386k;

    /* renamed from: l, reason: collision with root package name */
    protected DateFormat f37387l;

    /* renamed from: m, reason: collision with root package name */
    protected int f37388m;

    /* renamed from: n, reason: collision with root package name */
    protected int f37389n;

    /* renamed from: o, reason: collision with root package name */
    protected int f37390o;

    /* renamed from: p, reason: collision with root package name */
    protected int f37391p;

    /* renamed from: q, reason: collision with root package name */
    protected boolean f37392q;

    public ClassicsHeader(Context context) {
        super(context);
        this.f37376a = "LAST_UPDATE_TIME";
        this.f37386k = SpinnerStyle.Translate;
        this.f37387l = new SimpleDateFormat(f37374x, Locale.CHINA);
        this.f37388m = 500;
        this.f37390o = 20;
        this.f37391p = 20;
        this.f37392q = true;
        a(context, null);
    }

    public ClassicsHeader A(Bitmap bitmap) {
        this.f37384i = null;
        this.f37380e.setImageBitmap(bitmap);
        return this;
    }

    public ClassicsHeader B(Drawable drawable) {
        this.f37384i = null;
        this.f37380e.setImageDrawable(drawable);
        return this;
    }

    public ClassicsHeader C(@DrawableRes int i6) {
        this.f37384i = null;
        this.f37380e.setImageResource(i6);
        return this;
    }

    public ClassicsHeader N(CharSequence charSequence) {
        this.f37377b = null;
        this.f37379d.setText(charSequence);
        return this;
    }

    public ClassicsHeader R(Bitmap bitmap) {
        this.f37385j = null;
        this.f37381f.setImageBitmap(bitmap);
        return this;
    }

    public ClassicsHeader S(Drawable drawable) {
        this.f37385j = null;
        this.f37381f.setImageDrawable(drawable);
        return this;
    }

    public ClassicsHeader T(@DrawableRes int i6) {
        this.f37385j = null;
        this.f37381f.setImageResource(i6);
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
            if (!(getBackground() instanceof BitmapDrawable)) {
                P(iArr[0]);
            }
            if (iArr.length > 1) {
                f(iArr[1]);
            } else {
                f(iArr[0] == -1 ? -10066330 : -1);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f37393a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            f37393a = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f37393a[RefreshState.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f37393a[RefreshState.Refreshing.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f37393a[RefreshState.RefreshReleased.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f37393a[RefreshState.ReleaseToRefresh.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f37393a[RefreshState.ReleaseToTwoLevel.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f37393a[RefreshState.Loading.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private void a(Context context, AttributeSet attributeSet) {
        FragmentManager supportFragmentManager;
        List<Fragment> fragments;
        c cVar = new c();
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setId(R.id.widget_frame);
        linearLayout.setGravity(1);
        linearLayout.setOrientation(1);
        TextView textView = new TextView(context);
        this.f37378c = textView;
        textView.setText(f37368r);
        this.f37378c.setTextColor(-10066330);
        TextView textView2 = new TextView(context);
        this.f37379d = textView2;
        textView2.setTextColor(-8618884);
        linearLayout.addView(this.f37378c, new LinearLayout.LayoutParams(-2, -2));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        linearLayout.addView(this.f37379d, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        addView(linearLayout, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(cVar.a(20.0f), cVar.a(20.0f));
        layoutParams3.addRule(15);
        layoutParams3.addRule(0, R.id.widget_frame);
        ImageView imageView = new ImageView(context);
        this.f37380e = imageView;
        addView(imageView, layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((ViewGroup.LayoutParams) layoutParams3);
        layoutParams4.addRule(15);
        layoutParams4.addRule(0, R.id.widget_frame);
        ImageView imageView2 = new ImageView(context);
        this.f37381f = imageView2;
        imageView2.animate().setInterpolator(new LinearInterpolator());
        addView(this.f37381f, layoutParams4);
        if (isInEditMode()) {
            this.f37380e.setVisibility(8);
            this.f37378c.setText(f37369s);
        } else {
            this.f37381f.setVisibility(8);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader);
        layoutParams.topMargin = obtainStyledAttributes.getDimensionPixelSize(com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader_srlTextTimeMarginTop, cVar.a(0.0f));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(com.scwang.smartrefresh.layout.R.styleable.ClassicsFooter_srlDrawableMarginRight, cVar.a(20.0f));
        layoutParams4.rightMargin = dimensionPixelSize;
        layoutParams3.rightMargin = dimensionPixelSize;
        int i6 = com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader_srlDrawableArrowSize;
        layoutParams3.width = obtainStyledAttributes.getLayoutDimension(i6, layoutParams3.width);
        layoutParams3.height = obtainStyledAttributes.getLayoutDimension(i6, layoutParams3.height);
        int i7 = com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader_srlDrawableProgressSize;
        layoutParams4.width = obtainStyledAttributes.getLayoutDimension(i7, layoutParams4.width);
        layoutParams4.height = obtainStyledAttributes.getLayoutDimension(i7, layoutParams4.height);
        int i8 = com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader_srlDrawableSize;
        layoutParams3.width = obtainStyledAttributes.getLayoutDimension(i8, layoutParams3.width);
        layoutParams3.height = obtainStyledAttributes.getLayoutDimension(i8, layoutParams3.height);
        layoutParams4.width = obtainStyledAttributes.getLayoutDimension(i8, layoutParams4.width);
        layoutParams4.height = obtainStyledAttributes.getLayoutDimension(i8, layoutParams4.height);
        this.f37388m = obtainStyledAttributes.getInt(com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader_srlFinishDuration, this.f37388m);
        this.f37392q = obtainStyledAttributes.getBoolean(com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader_srlEnableLastTime, this.f37392q);
        this.f37386k = SpinnerStyle.values()[obtainStyledAttributes.getInt(com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader_srlClassicsSpinnerStyle, this.f37386k.ordinal())];
        this.f37379d.setVisibility(this.f37392q ? 0 : 8);
        int i9 = com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader_srlDrawableArrow;
        if (obtainStyledAttributes.hasValue(i9)) {
            this.f37380e.setImageDrawable(obtainStyledAttributes.getDrawable(i9));
        } else {
            b bVar = new b();
            this.f37384i = bVar;
            bVar.h(-10066330);
            this.f37384i.i("M20,12l-1.41,-1.41L13,16.17V4h-2v12.17l-5.58,-5.59L4,12l8,8 8,-8z");
            this.f37380e.setImageDrawable(this.f37384i);
        }
        int i10 = com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader_srlDrawableProgress;
        if (obtainStyledAttributes.hasValue(i10)) {
            this.f37381f.setImageDrawable(obtainStyledAttributes.getDrawable(i10));
        } else {
            com.scwang.smartrefresh.layout.internal.a aVar = new com.scwang.smartrefresh.layout.internal.a();
            this.f37385j = aVar;
            aVar.c(-10066330);
            this.f37381f.setImageDrawable(this.f37385j);
        }
        if (obtainStyledAttributes.hasValue(com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader_srlTextSizeTitle)) {
            this.f37378c.setTextSize(0, obtainStyledAttributes.getDimensionPixelSize(r1, c.b(16.0f)));
        } else {
            this.f37378c.setTextSize(16.0f);
        }
        if (obtainStyledAttributes.hasValue(com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader_srlTextSizeTime)) {
            this.f37379d.setTextSize(0, obtainStyledAttributes.getDimensionPixelSize(r1, c.b(12.0f)));
        } else {
            this.f37379d.setTextSize(12.0f);
        }
        int i11 = com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader_srlPrimaryColor;
        if (obtainStyledAttributes.hasValue(i11)) {
            P(obtainStyledAttributes.getColor(i11, 0));
        }
        int i12 = com.scwang.smartrefresh.layout.R.styleable.ClassicsHeader_srlAccentColor;
        if (obtainStyledAttributes.hasValue(i12)) {
            f(obtainStyledAttributes.getColor(i12, 0));
        }
        obtainStyledAttributes.recycle();
        if (getPaddingTop() == 0) {
            if (getPaddingBottom() == 0) {
                int paddingLeft = getPaddingLeft();
                int a6 = cVar.a(20.0f);
                this.f37390o = a6;
                int paddingRight = getPaddingRight();
                int a7 = cVar.a(20.0f);
                this.f37391p = a7;
                setPadding(paddingLeft, a6, paddingRight, a7);
            } else {
                int paddingLeft2 = getPaddingLeft();
                int a8 = cVar.a(20.0f);
                this.f37390o = a8;
                int paddingRight2 = getPaddingRight();
                int paddingBottom = getPaddingBottom();
                this.f37391p = paddingBottom;
                setPadding(paddingLeft2, a8, paddingRight2, paddingBottom);
            }
        } else if (getPaddingBottom() == 0) {
            int paddingLeft3 = getPaddingLeft();
            int paddingTop = getPaddingTop();
            this.f37390o = paddingTop;
            int paddingRight3 = getPaddingRight();
            int a9 = cVar.a(20.0f);
            this.f37391p = a9;
            setPadding(paddingLeft3, paddingTop, paddingRight3, a9);
        } else {
            this.f37390o = getPaddingTop();
            this.f37391p = getPaddingBottom();
        }
        try {
            if ((context instanceof FragmentActivity) && (supportFragmentManager = ((FragmentActivity) context).getSupportFragmentManager()) != null && (fragments = supportFragmentManager.getFragments()) != null && fragments.size() > 0) {
                O(new Date());
                return;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f37376a += context.getClass().getName();
        this.f37382g = context.getSharedPreferences("ClassicsHeader", 0);
        O(new Date(this.f37382g.getLong(this.f37376a, System.currentTimeMillis())));
    }

    public ClassicsHeader E(int i6) {
        ViewGroup.LayoutParams layoutParams = this.f37380e.getLayoutParams();
        layoutParams.width = i6;
        layoutParams.height = i6;
        this.f37380e.setLayoutParams(layoutParams);
        return this;
    }

    public ClassicsHeader G(int i6) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f37380e.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f37381f.getLayoutParams();
        marginLayoutParams2.rightMargin = i6;
        marginLayoutParams.rightMargin = i6;
        this.f37380e.setLayoutParams(marginLayoutParams);
        this.f37381f.setLayoutParams(marginLayoutParams2);
        return this;
    }

    public ClassicsHeader I(int i6) {
        ViewGroup.LayoutParams layoutParams = this.f37381f.getLayoutParams();
        layoutParams.width = i6;
        layoutParams.height = i6;
        this.f37381f.setLayoutParams(layoutParams);
        return this;
    }

    public ClassicsHeader K(int i6) {
        ViewGroup.LayoutParams layoutParams = this.f37380e.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.f37381f.getLayoutParams();
        layoutParams2.width = i6;
        layoutParams.width = i6;
        layoutParams2.height = i6;
        layoutParams.height = i6;
        this.f37380e.setLayoutParams(layoutParams);
        this.f37381f.setLayoutParams(layoutParams2);
        return this;
    }

    public ClassicsHeader L(boolean z5) {
        this.f37392q = z5;
        this.f37379d.setVisibility(z5 ? 0 : 8);
        g gVar = this.f37383h;
        if (gVar != null) {
            gVar.a();
        }
        return this;
    }

    public ClassicsHeader M(int i6) {
        this.f37388m = i6;
        return this;
    }

    public ClassicsHeader O(Date date) {
        this.f37377b = date;
        this.f37379d.setText(this.f37387l.format(date));
        if (this.f37382g != null && !isInEditMode()) {
            this.f37382g.edit().putLong(this.f37376a, date.getTime()).apply();
        }
        return this;
    }

    public ClassicsHeader P(@ColorInt int i6) {
        this.f37389n = i6;
        setBackgroundColor(i6);
        g gVar = this.f37383h;
        if (gVar != null) {
            gVar.f(this.f37389n);
        }
        return this;
    }

    public ClassicsHeader U(SpinnerStyle spinnerStyle) {
        this.f37386k = spinnerStyle;
        return this;
    }

    public ClassicsHeader V(float f6) {
        this.f37379d.setTextSize(f6);
        g gVar = this.f37383h;
        if (gVar != null) {
            gVar.a();
        }
        return this;
    }

    public ClassicsHeader W(int i6, float f6) {
        this.f37379d.setTextSize(i6, f6);
        g gVar = this.f37383h;
        if (gVar != null) {
            gVar.a();
        }
        return this;
    }

    public ClassicsHeader X(float f6) {
        this.f37378c.setTextSize(f6);
        g gVar = this.f37383h;
        if (gVar != null) {
            gVar.a();
        }
        return this;
    }

    public ClassicsHeader Y(int i6, float f6) {
        this.f37378c.setTextSize(i6, f6);
        g gVar = this.f37383h;
        if (gVar != null) {
            gVar.a();
        }
        return this;
    }

    public ClassicsHeader a0(int i6) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f37379d.getLayoutParams();
        marginLayoutParams.topMargin = i6;
        this.f37379d.setLayoutParams(marginLayoutParams);
        return this;
    }

    public ClassicsHeader b0(DateFormat dateFormat) {
        this.f37387l = dateFormat;
        Date date = this.f37377b;
        if (date != null) {
            this.f37379d.setText(dateFormat.format(date));
        }
        return this;
    }

    @Override // m2.f
    public int d(h hVar, boolean z5) {
        com.scwang.smartrefresh.layout.internal.a aVar = this.f37385j;
        if (aVar != null) {
            aVar.stop();
        } else {
            Object drawable = this.f37381f.getDrawable();
            if (drawable instanceof Animatable) {
                ((Animatable) drawable).stop();
            } else {
                this.f37381f.animate().rotation(0.0f).setDuration(300L);
            }
        }
        this.f37381f.setVisibility(8);
        if (z5) {
            this.f37378c.setText(f37372v);
            if (this.f37377b != null) {
                O(new Date());
            }
        } else {
            this.f37378c.setText(f37373w);
        }
        return this.f37388m;
    }

    public ClassicsHeader f(@ColorInt int i6) {
        b bVar = this.f37384i;
        if (bVar != null) {
            bVar.h(i6);
        }
        com.scwang.smartrefresh.layout.internal.a aVar = this.f37385j;
        if (aVar != null) {
            aVar.c(i6);
        }
        this.f37378c.setTextColor(i6);
        this.f37379d.setTextColor((i6 & 16777215) | (-872415232));
        return this;
    }

    public ImageView getArrowView() {
        return this.f37380e;
    }

    public TextView getLastUpdateText() {
        return this.f37379d;
    }

    public ImageView getProgressView() {
        return this.f37381f;
    }

    @Override // m2.f
    public SpinnerStyle getSpinnerStyle() {
        return this.f37386k;
    }

    public TextView getTitleText() {
        return this.f37378c;
    }

    @Override // m2.f
    public void q(g gVar, int i6, int i7) {
        this.f37383h = gVar;
        gVar.f(this.f37389n);
    }

    @Override // m2.e
    public void w(h hVar, int i6, int i7) {
        com.scwang.smartrefresh.layout.internal.a aVar = this.f37385j;
        if (aVar != null) {
            aVar.start();
            return;
        }
        Object drawable = this.f37381f.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        } else {
            this.f37381f.animate().rotation(36000.0f).setDuration(100000L);
        }
    }

    @Override // n2.f
    public void x(h hVar, RefreshState refreshState, RefreshState refreshState2) {
        switch (a.f37393a[refreshState2.ordinal()]) {
            case 1:
                this.f37379d.setVisibility(this.f37392q ? 0 : 8);
                break;
            case 2:
                break;
            case 3:
            case 4:
                this.f37378c.setText(f37369s);
                this.f37381f.setVisibility(0);
                this.f37380e.setVisibility(8);
                return;
            case 5:
                this.f37378c.setText(f37371u);
                this.f37380e.animate().rotation(180.0f);
                return;
            case 6:
                this.f37378c.setText(f37375y);
                this.f37380e.animate().rotation(0.0f);
                return;
            case 7:
                this.f37380e.setVisibility(8);
                this.f37381f.setVisibility(8);
                this.f37379d.setVisibility(8);
                this.f37378c.setText(f37370t);
                return;
            default:
                return;
        }
        this.f37378c.setText(f37368r);
        this.f37380e.setVisibility(0);
        this.f37381f.setVisibility(8);
        this.f37380e.animate().rotation(0.0f);
    }

    public ClassicsHeader D(float f6) {
        return E(c.b(f6));
    }

    public ClassicsHeader F(float f6) {
        return G(c.b(f6));
    }

    public ClassicsHeader H(float f6) {
        return I(c.b(f6));
    }

    public ClassicsHeader J(float f6) {
        return K(c.b(f6));
    }

    public ClassicsHeader Q(@ColorRes int i6) {
        P(ContextCompat.getColor(getContext(), i6));
        return this;
    }

    public ClassicsHeader Z(float f6) {
        return a0(c.b(f6));
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i6, int i7) {
        if (View.MeasureSpec.getMode(i7) == 1073741824) {
            setPadding(getPaddingLeft(), 0, getPaddingRight(), 0);
        } else {
            setPadding(getPaddingLeft(), this.f37390o, getPaddingRight(), this.f37391p);
        }
        super.onMeasure(i6, i7);
    }

    public ClassicsHeader z(@ColorRes int i6) {
        f(ContextCompat.getColor(getContext(), i6));
        return this;
    }

    public ClassicsHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f37376a = "LAST_UPDATE_TIME";
        this.f37386k = SpinnerStyle.Translate;
        this.f37387l = new SimpleDateFormat(f37374x, Locale.CHINA);
        this.f37388m = 500;
        this.f37390o = 20;
        this.f37391p = 20;
        this.f37392q = true;
        a(context, attributeSet);
    }

    public ClassicsHeader(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f37376a = "LAST_UPDATE_TIME";
        this.f37386k = SpinnerStyle.Translate;
        this.f37387l = new SimpleDateFormat(f37374x, Locale.CHINA);
        this.f37388m = 500;
        this.f37390o = 20;
        this.f37391p = 20;
        this.f37392q = true;
        a(context, attributeSet);
    }

    @Override // m2.f
    @NonNull
    public View getView() {
        return this;
    }

    @RequiresApi(21)
    public ClassicsHeader(Context context, @Nullable AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
        this.f37376a = "LAST_UPDATE_TIME";
        this.f37386k = SpinnerStyle.Translate;
        this.f37387l = new SimpleDateFormat(f37374x, Locale.CHINA);
        this.f37388m = 500;
        this.f37390o = 20;
        this.f37391p = 20;
        this.f37392q = true;
        a(context, attributeSet);
    }

    @Override // m2.f
    public void h(h hVar, int i6, int i7) {
    }

    @Override // m2.f
    public void i(float f6, int i6, int i7) {
    }

    @Override // m2.e
    public void g(float f6, int i6, int i7, int i8) {
    }

    @Override // m2.e
    public void y(float f6, int i6, int i7, int i8) {
    }
}
