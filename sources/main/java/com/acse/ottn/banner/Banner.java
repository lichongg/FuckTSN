package com.acse.ottn.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import com.acse.ottn.R;
import com.acse.ottn.banner.util.BannerLifecycleObserverAdapter;
import com.acse.ottn.banner.util.ScrollSpeedManger;
import com.acse.ottn.d2;
import com.acse.ottn.f2;
import com.acse.ottn.p1;
import com.acse.ottn.q1;
import com.acse.ottn.t;
import com.acse.ottn.u;
import com.acse.ottn.w3;
import com.acse.ottn.x;
import com.acse.ottn.x2;
import com.acse.ottn.y;
import com.acse.ottn.y2;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class Banner<T, BA extends t> extends FrameLayout implements x {
    public static final int I = -1;
    public static final int J = 0;
    public static final int K = 1;
    public int A;
    public float B;
    public float C;
    public boolean D;
    public boolean E;
    public Paint F;
    public Paint G;
    public RecyclerView.AdapterDataObserver H;

    /* renamed from: a, reason: collision with root package name */
    public ViewPager2 f4268a;

    /* renamed from: b, reason: collision with root package name */
    public b f4269b;

    /* renamed from: c, reason: collision with root package name */
    public y2 f4270c;

    /* renamed from: d, reason: collision with root package name */
    public BA f4271d;

    /* renamed from: e, reason: collision with root package name */
    public p1 f4272e;

    /* renamed from: f, reason: collision with root package name */
    public CompositePageTransformer f4273f;

    /* renamed from: g, reason: collision with root package name */
    public Banner<T, BA>.c f4274g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f4275h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f4276i;

    /* renamed from: j, reason: collision with root package name */
    public long f4277j;

    /* renamed from: k, reason: collision with root package name */
    public int f4278k;

    /* renamed from: l, reason: collision with root package name */
    public int f4279l;

    /* renamed from: m, reason: collision with root package name */
    public float f4280m;

    /* renamed from: n, reason: collision with root package name */
    public int f4281n;

    /* renamed from: o, reason: collision with root package name */
    public int f4282o;

    /* renamed from: p, reason: collision with root package name */
    public int f4283p;

    /* renamed from: q, reason: collision with root package name */
    public int f4284q;

    /* renamed from: r, reason: collision with root package name */
    public int f4285r;

    /* renamed from: s, reason: collision with root package name */
    public int f4286s;

    /* renamed from: t, reason: collision with root package name */
    public int f4287t;

    /* renamed from: u, reason: collision with root package name */
    public int f4288u;

    /* renamed from: v, reason: collision with root package name */
    public int f4289v;

    /* renamed from: w, reason: collision with root package name */
    public int f4290w;

    /* renamed from: x, reason: collision with root package name */
    public int f4291x;

    /* renamed from: y, reason: collision with root package name */
    public int f4292y;

    /* renamed from: z, reason: collision with root package name */
    public int f4293z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a extends RecyclerView.AdapterDataObserver {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            if (Banner.this.getItemCount() <= 1) {
                Banner.this.i();
            } else {
                Banner.this.h();
            }
            Banner.this.f();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<Banner> f4295a;

        @Override // java.lang.Runnable
        public void run() {
            int itemCount;
            Banner banner = this.f4295a.get();
            if (banner == null || !banner.f4276i || (itemCount = banner.getItemCount()) == 0) {
                return;
            }
            banner.b((banner.getCurrentItem() + 1) % itemCount);
            banner.postDelayed(banner.f4269b, banner.f4277j);
        }

        public b(Banner banner) {
            this.f4295a = new WeakReference<>(banner);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class c extends ViewPager2.OnPageChangeCallback {

        /* renamed from: a, reason: collision with root package name */
        public int f4296a = -1;

        /* renamed from: b, reason: collision with root package name */
        public boolean f4297b;

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i6) {
            if (i6 == 1 || i6 == 2) {
                this.f4297b = true;
            } else if (i6 == 0) {
                this.f4297b = false;
                if (this.f4296a != -1 && Banner.this.f4275h) {
                    int i7 = this.f4296a;
                    if (i7 == 0) {
                        Banner banner = Banner.this;
                        banner.a(banner.getRealCount(), false);
                    } else if (i7 == Banner.this.getItemCount() - 1) {
                        Banner.this.a(1, false);
                    }
                }
            }
            if (Banner.this.f4270c != null) {
                Banner.this.f4270c.onPageScrollStateChanged(i6);
            }
            if (Banner.this.f4272e != null) {
                Banner.this.f4272e.onPageScrollStateChanged(i6);
            }
        }

        public c() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i6, float f6, int i7) {
            int a6 = y.a(Banner.this.d(), i6, Banner.this.getRealCount());
            if (Banner.this.f4270c != null) {
                Banner.this.f4270c.onPageScrolled(a6, f6, i7);
            }
            if (Banner.this.f4272e != null) {
                Banner.this.f4272e.onPageScrolled(a6, f6, i7);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i6) {
            if (this.f4297b) {
                this.f4296a = i6;
                int a6 = y.a(Banner.this.d(), i6, Banner.this.getRealCount());
                if (Banner.this.f4270c != null) {
                    Banner.this.f4270c.onPageSelected(a6);
                }
                if (Banner.this.f4272e != null) {
                    Banner.this.f4272e.onPageSelected(a6);
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface d {
    }

    public Banner(Context context) {
        this(context, null);
    }

    public final void g() {
        if (!d()) {
            a(false);
        }
        o(d() ? 1 : 0);
    }

    public Banner h() {
        if (this.f4276i) {
            i();
            postDelayed(this.f4269b, this.f4277j);
        }
        return this;
    }

    public Banner i() {
        if (this.f4276i) {
            removeCallbacks(this.f4269b);
        }
        return this;
    }

    public Banner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void a(Context context) {
        this.A = ViewConfiguration.get(context).getScaledTouchSlop() / 2;
        this.f4273f = new CompositePageTransformer();
        this.f4274g = new c();
        this.f4269b = new b(this);
        ViewPager2 viewPager2 = new ViewPager2(context);
        this.f4268a = viewPager2;
        viewPager2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f4268a.setOffscreenPageLimit(1);
        this.f4268a.registerOnPageChangeCallback(this.f4274g);
        this.f4268a.setPageTransformer(this.f4273f);
        ScrollSpeedManger.a(this);
        addView(this.f4268a);
        Paint paint = new Paint();
        this.F = paint;
        paint.setColor(-1);
        this.F.setAntiAlias(true);
        this.F.setStyle(Paint.Style.FILL);
        this.F.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Paint paint2 = new Paint();
        this.G = paint2;
        paint2.setXfermode(null);
    }

    public final void b(Canvas canvas) {
        int height = getHeight();
        int width = getWidth();
        Path path = new Path();
        float f6 = width;
        float f7 = height;
        path.moveTo(f6 - this.f4280m, f7);
        path.lineTo(f6, f7);
        path.lineTo(f6, f7 - this.f4280m);
        float f8 = this.f4280m * 2.0f;
        path.arcTo(new RectF(f6 - f8, f7 - f8, f6, f7), 0.0f, 90.0f);
        path.close();
        canvas.drawPath(path, this.F);
    }

    public final void c() {
        int i6 = this.f4287t;
        if (i6 != 0) {
            a(new q1.b(i6));
        } else {
            int i7 = this.f4288u;
            if (i7 != 0 || this.f4289v != 0 || this.f4290w != 0 || this.f4291x != 0) {
                a(new q1.b(i7, this.f4289v, this.f4290w, this.f4291x));
            }
        }
        int i8 = this.f4286s;
        if (i8 > 0) {
            l(i8);
        }
        int i9 = this.f4285r;
        if (i9 != 1) {
            c(i9);
        }
        int i10 = this.f4281n;
        if (i10 > 0) {
            g(i10);
        }
        int i11 = this.f4282o;
        if (i11 > 0) {
            k(i11);
        }
        int i12 = this.f4292y;
        if (i12 > 0) {
            d(i12);
        }
        int i13 = this.f4293z;
        if (i13 > 0) {
            h(i13);
        }
        e(this.f4283p);
        i(this.f4284q);
    }

    public final void d(Canvas canvas) {
        int width = getWidth();
        Path path = new Path();
        float f6 = width;
        path.moveTo(f6 - this.f4280m, 0.0f);
        path.lineTo(f6, 0.0f);
        path.lineTo(f6, this.f4280m);
        float f7 = this.f4280m * 2.0f;
        path.arcTo(new RectF(f6 - f7, 0.0f, f6, f7), 0.0f, -90.0f);
        path.close();
        canvas.drawPath(path, this.F);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        if (this.f4280m <= 0.0f) {
            super.dispatchDraw(canvas);
            return;
        }
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.G, 31);
        super.dispatchDraw(canvas);
        c(canvas);
        d(canvas);
        a(canvas);
        b(canvas);
        canvas.restore();
    }

    public Banner e() {
        p1 p1Var = this.f4272e;
        if (p1Var != null) {
            removeView(p1Var.getIndicatorView());
        }
        return this;
    }

    public Banner f() {
        if (this.f4272e != null) {
            this.f4272e.a(getRealCount(), y.a(d(), getCurrentItem(), getRealCount()));
        }
        return this;
    }

    public BA getAdapter() {
        if (this.f4271d == null) {
            d2.b(getContext().getString(R.string.banner_adapter_use_error));
        }
        return this.f4271d;
    }

    public p1 getIndicator() {
        if (this.f4272e == null) {
            d2.b(getContext().getString(R.string.indicator_null_error));
        }
        return this.f4272e;
    }

    public int getScrollTime() {
        return this.f4278k;
    }

    public ViewPager2 getViewPager2() {
        return this.f4268a;
    }

    public Banner k(int i6) {
        p1 p1Var = this.f4272e;
        if (p1Var != null) {
            p1Var.getIndicatorConfig().j(i6);
        }
        return this;
    }

    public Banner l(int i6) {
        p1 p1Var = this.f4272e;
        if (p1Var != null) {
            p1Var.getIndicatorConfig().e(i6);
        }
        return this;
    }

    public Banner n(int i6) {
        this.f4278k = i6;
        return this;
    }

    public Banner o(int i6) {
        this.f4279l = i6;
        return this;
    }

    public Banner p(int i6) {
        this.A = i6;
        return this;
    }

    public Banner(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f4275h = true;
        this.f4276i = true;
        this.f4277j = 3000L;
        this.f4278k = 600;
        this.f4279l = 1;
        this.f4280m = 0.0f;
        this.f4281n = u.f5360g;
        this.f4282o = u.f5361h;
        this.f4283p = u.f5358e;
        this.f4284q = u.f5359f;
        this.f4285r = 1;
        this.f4292y = u.f5364k;
        this.f4293z = u.f5365l;
        this.E = true;
        this.H = new a();
        a(context);
        a(context, attributeSet);
    }

    private void setRecyclerViewPadding(int i6) {
        c(i6, i6);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!getViewPager2().isUserInputEnabled()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 1 && actionMasked != 3 && actionMasked != 4) {
            if (actionMasked == 0) {
                i();
            }
        } else {
            h();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public int getCurrentItem() {
        return getViewPager2().getCurrentItem();
    }

    public q1 getIndicatorConfig() {
        if (getIndicator() != null) {
            return getIndicator().getIndicatorConfig();
        }
        return null;
    }

    public int getItemCount() {
        if (getAdapter() == null) {
            return 0;
        }
        return getAdapter().getItemCount();
    }

    public int getRealCount() {
        return getAdapter().a();
    }

    public Banner i(@ColorInt int i6) {
        p1 p1Var = this.f4272e;
        if (p1Var != null) {
            p1Var.getIndicatorConfig().i(i6);
        }
        return this;
    }

    public Banner j(@ColorRes int i6) {
        i(ContextCompat.getColor(getContext(), i6));
        return this;
    }

    public Banner m(int i6) {
        getViewPager2().setOrientation(i6);
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        h();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001e, code lost:
    
        if (r0 != 3) goto L35;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            androidx.viewpager2.widget.ViewPager2 r0 = r5.getViewPager2()
            boolean r0 = r0.isUserInputEnabled()
            if (r0 == 0) goto L8a
            boolean r0 = r5.E
            if (r0 != 0) goto L10
            goto L8a
        L10:
            int r0 = r6.getAction()
            r1 = 1
            if (r0 == 0) goto L72
            r2 = 0
            if (r0 == r1) goto L6a
            r3 = 2
            if (r0 == r3) goto L21
            r1 = 3
            if (r0 == r1) goto L6a
            goto L85
        L21:
            float r0 = r6.getX()
            float r3 = r6.getY()
            float r4 = r5.B
            float r0 = r0 - r4
            float r0 = java.lang.Math.abs(r0)
            float r4 = r5.C
            float r3 = r3 - r4
            float r3 = java.lang.Math.abs(r3)
            androidx.viewpager2.widget.ViewPager2 r4 = r5.getViewPager2()
            int r4 = r4.getOrientation()
            if (r4 != 0) goto L51
            int r4 = r5.A
            float r4 = (float) r4
            int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r4 <= 0) goto L4d
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L4d
            goto L4e
        L4d:
            r1 = 0
        L4e:
            r5.D = r1
            goto L60
        L51:
            int r4 = r5.A
            float r4 = (float) r4
            int r4 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r4 <= 0) goto L5d
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 <= 0) goto L5d
            goto L5e
        L5d:
            r1 = 0
        L5e:
            r5.D = r1
        L60:
            android.view.ViewParent r0 = r5.getParent()
            boolean r1 = r5.D
            r0.requestDisallowInterceptTouchEvent(r1)
            goto L85
        L6a:
            android.view.ViewParent r0 = r5.getParent()
            r0.requestDisallowInterceptTouchEvent(r2)
            goto L85
        L72:
            float r0 = r6.getX()
            r5.B = r0
            float r0 = r6.getY()
            r5.C = r0
            android.view.ViewParent r0 = r5.getParent()
            r0.requestDisallowInterceptTouchEvent(r1)
        L85:
            boolean r6 = super.onInterceptTouchEvent(r6)
            return r6
        L8a:
            boolean r6 = super.onInterceptTouchEvent(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.acse.ottn.banner.Banner.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public Banner e(@ColorInt int i6) {
        p1 p1Var = this.f4272e;
        if (p1Var != null) {
            p1Var.getIndicatorConfig().f(i6);
        }
        return this;
    }

    public Banner g(int i6) {
        p1 p1Var = this.f4272e;
        if (p1Var != null) {
            p1Var.getIndicatorConfig().g(i6);
        }
        return this;
    }

    public Banner<T, BA> h(int i6) {
        p1 p1Var = this.f4272e;
        if (p1Var != null) {
            p1Var.getIndicatorConfig().h(i6);
        }
        return this;
    }

    public Banner f(@ColorRes int i6) {
        e(ContextCompat.getColor(getContext(), i6));
        return this;
    }

    public boolean d() {
        return this.f4275h;
    }

    public final void b() {
        if (this.f4272e == null || getAdapter() == null) {
            return;
        }
        if (this.f4272e.getIndicatorConfig().l()) {
            e();
            addView(this.f4272e.getIndicatorView());
        }
        c();
        f();
    }

    public Banner<T, BA> d(int i6) {
        p1 p1Var = this.f4272e;
        if (p1Var != null) {
            p1Var.getIndicatorConfig().c(i6);
        }
        return this;
    }

    public Banner d(LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner != null) {
            lifecycleOwner.getLifecycle().addObserver(new BannerLifecycleObserverAdapter(lifecycleOwner, this));
        }
        return this;
    }

    public Banner b(boolean z5) {
        this.E = z5;
        return this;
    }

    public Banner b(int i6) {
        return a(i6, true);
    }

    public Banner b(ViewPager2.PageTransformer pageTransformer) {
        this.f4273f.removeTransformer(pageTransformer);
        return this;
    }

    public final void a(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Banner);
        this.f4280m = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_banner_radius, 0);
        this.f4277j = obtainStyledAttributes.getInt(R.styleable.Banner_banner_loop_time, 3000);
        this.f4276i = obtainStyledAttributes.getBoolean(R.styleable.Banner_banner_auto_loop, true);
        this.f4275h = obtainStyledAttributes.getBoolean(R.styleable.Banner_banner_infinite_loop, true);
        this.f4281n = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_banner_indicator_normal_width, u.f5360g);
        this.f4282o = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_banner_indicator_selected_width, u.f5361h);
        this.f4283p = obtainStyledAttributes.getColor(R.styleable.Banner_banner_indicator_normal_color, u.f5358e);
        this.f4284q = obtainStyledAttributes.getColor(R.styleable.Banner_banner_indicator_selected_color, u.f5359f);
        this.f4285r = obtainStyledAttributes.getInt(R.styleable.Banner_banner_indicator_gravity, 1);
        this.f4286s = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_banner_indicator_space, 0);
        this.f4287t = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_banner_indicator_margin, 0);
        this.f4288u = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_banner_indicator_marginLeft, 0);
        this.f4289v = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_banner_indicator_marginTop, 0);
        this.f4290w = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_banner_indicator_marginRight, 0);
        this.f4291x = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_banner_indicator_marginBottom, 0);
        this.f4292y = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_banner_indicator_height, u.f5364k);
        this.f4293z = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_banner_indicator_radius, u.f5365l);
        m(obtainStyledAttributes.getInt(R.styleable.Banner_banner_orientation, 0));
        g();
        obtainStyledAttributes.recycle();
    }

    @RequiresApi(api = 21)
    public Banner b(float f6) {
        y.a(this, f6);
        return this;
    }

    public final void c(Canvas canvas) {
        Path path = new Path();
        path.moveTo(0.0f, this.f4280m);
        path.lineTo(0.0f, 0.0f);
        path.lineTo(this.f4280m, 0.0f);
        float f6 = this.f4280m * 2.0f;
        path.arcTo(new RectF(0.0f, 0.0f, f6, f6), -90.0f, -90.0f);
        path.close();
        canvas.drawPath(path, this.F);
    }

    public Banner b(int i6, int i7) {
        p1 p1Var = this.f4272e;
        if (p1Var != null) {
            p1Var.getIndicatorConfig().g(i6);
            this.f4272e.getIndicatorConfig().j(i7);
        }
        return this;
    }

    @Override // com.acse.ottn.x
    public void b(LifecycleOwner lifecycleOwner) {
        h();
    }

    public final void c(int i6, int i7) {
        RecyclerView recyclerView = (RecyclerView) getViewPager2().getChildAt(0);
        if (getViewPager2().getOrientation() == 1) {
            recyclerView.setPadding(0, i6, 0, i7);
        } else {
            recyclerView.setPadding(i6, 0, i7, 0);
        }
        recyclerView.setClipToPadding(false);
    }

    public Banner c(boolean z5) {
        getViewPager2().setUserInputEnabled(z5);
        return this;
    }

    public Banner c(@Nullable ViewPager2.PageTransformer pageTransformer) {
        getViewPager2().setPageTransformer(pageTransformer);
        return this;
    }

    public Banner c(int i6) {
        p1 p1Var = this.f4272e;
        if (p1Var != null && p1Var.getIndicatorConfig().l()) {
            this.f4272e.getIndicatorConfig().b(i6);
            this.f4272e.getIndicatorView().postInvalidate();
        }
        return this;
    }

    @Override // com.acse.ottn.x
    public void c(LifecycleOwner lifecycleOwner) {
        i();
    }

    public final void a(Canvas canvas) {
        int height = getHeight();
        Path path = new Path();
        float f6 = height;
        path.moveTo(0.0f, f6 - this.f4280m);
        path.lineTo(0.0f, f6);
        path.lineTo(this.f4280m, f6);
        float f7 = this.f4280m * 2.0f;
        path.arcTo(new RectF(0.0f, f6 - f7, f7, f6), 90.0f, 90.0f);
        path.close();
        canvas.drawPath(path, this.F);
    }

    public Banner a(int i6, boolean z5) {
        getViewPager2().setCurrentItem(i6, z5);
        return this;
    }

    public Banner a(@Nullable ViewPager2.PageTransformer pageTransformer) {
        this.f4273f.addTransformer(pageTransformer);
        return this;
    }

    public Banner a(RecyclerView.ItemDecoration itemDecoration) {
        getViewPager2().addItemDecoration(itemDecoration);
        return this;
    }

    public Banner a(RecyclerView.ItemDecoration itemDecoration, int i6) {
        getViewPager2().addItemDecoration(itemDecoration, i6);
        return this;
    }

    public Banner a(boolean z5) {
        this.f4276i = z5;
        return this;
    }

    public Banner a(long j6) {
        this.f4277j = j6;
        return this;
    }

    public void a() {
        if (getViewPager2() != null && this.f4274g != null) {
            getViewPager2().unregisterOnPageChangeCallback(this.f4274g);
            this.f4274g = null;
        }
        i();
    }

    public Banner a(BA ba) {
        if (ba != null) {
            this.f4271d = ba;
            if (!d()) {
                this.f4271d.c(0);
            }
            this.f4271d.registerAdapterDataObserver(this.H);
            this.f4268a.setAdapter(ba);
            a(this.f4279l, false);
            b();
            return this;
        }
        throw new NullPointerException(getContext().getString(R.string.banner_adapter_null_error));
    }

    public Banner a(BA ba, boolean z5) {
        this.f4275h = z5;
        g();
        a((Banner<T, BA>) ba);
        return this;
    }

    public Banner a(List<T> list) {
        if (getAdapter() != null) {
            getAdapter().a(list);
            getAdapter().notifyDataSetChanged();
            a(this.f4279l, false);
            f();
            h();
        }
        return this;
    }

    public Banner a(x2 x2Var) {
        if (getAdapter() != null) {
            getAdapter().a(x2Var);
        }
        return this;
    }

    public Banner a(y2 y2Var) {
        this.f4270c = y2Var;
        return this;
    }

    public Banner a(float f6) {
        this.f4280m = f6;
        return this;
    }

    public Banner a(int i6, int i7) {
        return a(i6, i7, 0.85f);
    }

    public Banner a(int i6, int i7, int i8) {
        return a(i6, i7, i8, 0.85f);
    }

    public Banner a(int i6, int i7, float f6) {
        return a(i6, i6, i7, f6);
    }

    public Banner a(int i6, int i7, int i8, float f6) {
        if (i8 > 0) {
            a(new MarginPageTransformer((int) y.a(i8)));
        }
        if (f6 < 1.0f && f6 > 0.0f) {
            a(new w3(f6));
        }
        c(i6 > 0 ? (int) y.a(i6 + i8) : 0, i7 > 0 ? (int) y.a(i7 + i8) : 0);
        return this;
    }

    public Banner a(int i6) {
        return a(i6, 0.88f);
    }

    public Banner a(int i6, float f6) {
        if (f6 < 1.0f && f6 > 0.0f) {
            a(new f2(f6));
        }
        setRecyclerViewPadding((int) y.a(i6));
        return this;
    }

    public Banner a(p1 p1Var) {
        return a(p1Var, true);
    }

    public Banner a(p1 p1Var, boolean z5) {
        e();
        p1Var.getIndicatorConfig().a(z5);
        this.f4272e = p1Var;
        b();
        return this;
    }

    public Banner a(q1.b bVar) {
        p1 p1Var = this.f4272e;
        if (p1Var != null && p1Var.getIndicatorConfig().l()) {
            this.f4272e.getIndicatorConfig().a(bVar);
            this.f4272e.getIndicatorView().requestLayout();
        }
        return this;
    }

    @Override // com.acse.ottn.x
    public void a(LifecycleOwner lifecycleOwner) {
        a();
    }
}
