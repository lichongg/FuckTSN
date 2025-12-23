package com.mcxtzhang.swipemenulib;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class SwipeMenuLayout extends ViewGroup {

    /* renamed from: u, reason: collision with root package name */
    private static final String f36357u = "zxt/SwipeMenuLayout";

    /* renamed from: v, reason: collision with root package name */
    private static SwipeMenuLayout f36358v;

    /* renamed from: w, reason: collision with root package name */
    private static boolean f36359w;

    /* renamed from: a, reason: collision with root package name */
    private int f36360a;

    /* renamed from: b, reason: collision with root package name */
    private int f36361b;

    /* renamed from: c, reason: collision with root package name */
    private int f36362c;

    /* renamed from: d, reason: collision with root package name */
    private int f36363d;

    /* renamed from: e, reason: collision with root package name */
    private int f36364e;

    /* renamed from: f, reason: collision with root package name */
    private int f36365f;

    /* renamed from: g, reason: collision with root package name */
    private View f36366g;

    /* renamed from: h, reason: collision with root package name */
    private PointF f36367h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f36368i;

    /* renamed from: j, reason: collision with root package name */
    private PointF f36369j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f36370k;

    /* renamed from: l, reason: collision with root package name */
    private VelocityTracker f36371l;

    /* renamed from: m, reason: collision with root package name */
    private Log f36372m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f36373n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f36374o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f36375p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f36376q;

    /* renamed from: r, reason: collision with root package name */
    private ValueAnimator f36377r;

    /* renamed from: s, reason: collision with root package name */
    private ValueAnimator f36378s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f36379t;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SwipeMenuLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SwipeMenuLayout.this.f36379t = true;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SwipeMenuLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SwipeMenuLayout.this.f36379t = false;
        }
    }

    public SwipeMenuLayout(Context context) {
        this(context, null);
    }

    public void m() {
        f36358v = null;
        View view = this.f36366g;
        if (view != null) {
            view.setLongClickable(true);
        }
        c();
        ValueAnimator ofInt = ValueAnimator.ofInt(getScrollX(), 0);
        this.f36378s = ofInt;
        ofInt.addUpdateListener(new c());
        this.f36378s.setInterpolator(new AccelerateInterpolator());
        this.f36378s.addListener(new d());
        this.f36378s.setDuration(300L).start();
    }

    public SwipeMenuLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void b(MotionEvent motionEvent) {
        if (this.f36371l == null) {
            this.f36371l = VelocityTracker.obtain();
        }
        this.f36371l.addMovement(motionEvent);
    }

    private void c() {
        ValueAnimator valueAnimator = this.f36378s;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f36378s.cancel();
        }
        ValueAnimator valueAnimator2 = this.f36377r;
        if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
            return;
        }
        this.f36377r.cancel();
    }

    public static SwipeMenuLayout getViewCache() {
        return f36358v;
    }

    private void j() {
        VelocityTracker velocityTracker = this.f36371l;
        if (velocityTracker != null) {
            velocityTracker.clear();
            this.f36371l.recycle();
            this.f36371l = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
    
        if (r1 != 3) goto L69;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r6) {
        /*
            Method dump skipped, instructions count: 325
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mcxtzhang.swipemenulib.SwipeMenuLayout.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean f() {
        return this.f36374o;
    }

    public boolean g() {
        return this.f36376q;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public boolean h() {
        return this.f36373n;
    }

    public void i() {
        if (this == f36358v) {
            c();
            f36358v.scrollTo(0, 0);
            f36358v = null;
        }
    }

    public SwipeMenuLayout k(boolean z5) {
        this.f36374o = z5;
        return this;
    }

    public SwipeMenuLayout l(boolean z5) {
        this.f36376q = z5;
        return this;
    }

    public void n() {
        f36358v = this;
        View view = this.f36366g;
        if (view != null) {
            view.setLongClickable(false);
        }
        c();
        ValueAnimator ofInt = ValueAnimator.ofInt(getScrollX(), this.f36376q ? this.f36364e : -this.f36364e);
        this.f36377r = ofInt;
        ofInt.addUpdateListener(new a());
        this.f36377r.setInterpolator(new OvershootInterpolator());
        this.f36377r.addListener(new b());
        this.f36377r.setDuration(300L).start();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        SwipeMenuLayout swipeMenuLayout = f36358v;
        if (this == swipeMenuLayout) {
            swipeMenuLayout.m();
            f36358v = null;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f36373n) {
            int action = motionEvent.getAction();
            if (action == 1) {
                if (this.f36376q) {
                    if (getScrollX() > this.f36360a && motionEvent.getX() < getWidth() - getScrollX()) {
                        if (this.f36368i) {
                            m();
                        }
                        return true;
                    }
                } else if ((-getScrollX()) > this.f36360a && motionEvent.getX() > (-getScrollX())) {
                    if (this.f36368i) {
                        m();
                    }
                    return true;
                }
                if (this.f36370k) {
                    return true;
                }
            } else if (action == 2 && Math.abs(motionEvent.getRawX() - this.f36369j.x) > this.f36360a) {
                return true;
            }
            if (this.f36375p) {
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setSwipeEnable(boolean z5) {
        this.f36373n = z5;
    }

    public SwipeMenuLayout(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f36367h = new PointF();
        this.f36368i = true;
        this.f36369j = new PointF();
        e(context, attributeSet, i6);
    }

    private void d(int i6, int i7) {
        int i8;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        int i9 = 0;
        while (i9 < i6) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                if (marginLayoutParams.height == -1) {
                    int i10 = marginLayoutParams.width;
                    marginLayoutParams.width = childAt.getMeasuredWidth();
                    i8 = i7;
                    measureChildWithMargins(childAt, i8, 0, makeMeasureSpec, 0);
                    marginLayoutParams.width = i10;
                    i9++;
                    i7 = i8;
                }
            }
            i8 = i7;
            i9++;
            i7 = i8;
        }
    }

    private void e(Context context, AttributeSet attributeSet, int i6) {
        this.f36360a = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f36361b = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
        this.f36373n = true;
        this.f36374o = true;
        this.f36376q = true;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SwipeMenuLayout, i6, 0);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i7 = 0; i7 < indexCount; i7++) {
            int index = obtainStyledAttributes.getIndex(i7);
            if (index == R.styleable.SwipeMenuLayout_swipeEnable) {
                this.f36373n = obtainStyledAttributes.getBoolean(index, true);
            } else if (index == R.styleable.SwipeMenuLayout_ios) {
                this.f36374o = obtainStyledAttributes.getBoolean(index, true);
            } else if (index == R.styleable.SwipeMenuLayout_leftSwipe) {
                this.f36376q = obtainStyledAttributes.getBoolean(index, true);
            }
        }
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        int measuredWidth;
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingLeft2 = getPaddingLeft();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                if (i10 == 0) {
                    childAt.layout(paddingLeft, getPaddingTop(), childAt.getMeasuredWidth() + paddingLeft, getPaddingTop() + childAt.getMeasuredHeight());
                    measuredWidth = childAt.getMeasuredWidth();
                } else if (this.f36376q) {
                    childAt.layout(paddingLeft, getPaddingTop(), childAt.getMeasuredWidth() + paddingLeft, getPaddingTop() + childAt.getMeasuredHeight());
                    measuredWidth = childAt.getMeasuredWidth();
                } else {
                    childAt.layout(paddingLeft2 - childAt.getMeasuredWidth(), getPaddingTop(), paddingLeft2, getPaddingTop() + childAt.getMeasuredHeight());
                    paddingLeft2 -= childAt.getMeasuredWidth();
                }
                paddingLeft += measuredWidth;
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        boolean z5;
        super.onMeasure(i6, i7);
        setClickable(true);
        this.f36364e = 0;
        this.f36363d = 0;
        int childCount = getChildCount();
        if (View.MeasureSpec.getMode(i7) != 1073741824) {
            z5 = true;
        } else {
            z5 = false;
        }
        int i8 = 0;
        boolean z6 = false;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            childAt.setClickable(true);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i6, i7);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                this.f36363d = Math.max(this.f36363d, childAt.getMeasuredHeight());
                if (z5 && marginLayoutParams.height == -1) {
                    z6 = true;
                }
                if (i9 > 0) {
                    this.f36364e += childAt.getMeasuredWidth();
                } else {
                    this.f36366g = childAt;
                    i8 = childAt.getMeasuredWidth();
                }
            }
        }
        setMeasuredDimension(getPaddingLeft() + getPaddingRight() + i8, this.f36363d + getPaddingTop() + getPaddingBottom());
        this.f36365f = (this.f36364e * 4) / 10;
        if (z6) {
            d(childCount, i6);
        }
    }

    @Override // android.view.View
    public boolean performLongClick() {
        if (Math.abs(getScrollX()) > this.f36360a) {
            return false;
        }
        return super.performLongClick();
    }
}
