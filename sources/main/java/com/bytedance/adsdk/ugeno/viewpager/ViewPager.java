package com.bytedance.adsdk.ugeno.viewpager;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import com.bytedance.sdk.component.utils.vl;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class ViewPager extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    private int f23775a;
    private final ArrayList<xt> ae;
    private int av;
    private m az;

    /* renamed from: b, reason: collision with root package name */
    private boolean f23776b;

    /* renamed from: c, reason: collision with root package name */
    private int f23777c;
    private boolean ch;
    com.bytedance.adsdk.ugeno.viewpager.xt cw;

    /* renamed from: e, reason: collision with root package name */
    private boolean f23778e;
    private float ed;

    /* renamed from: f, reason: collision with root package name */
    private int f23779f;
    private up ff;

    /* renamed from: g, reason: collision with root package name */
    private final Rect f23780g;
    private int gq;
    private VelocityTracker gx;

    /* renamed from: h, reason: collision with root package name */
    private int f23781h;
    private boolean hh;
    private EdgeEffect hl;

    /* renamed from: i, reason: collision with root package name */
    private Drawable f23782i;

    /* renamed from: j, reason: collision with root package name */
    private int f23783j;
    private Scroller jy;

    /* renamed from: k, reason: collision with root package name */
    private List<Object> f23784k;
    private ArrayList<View> kc;
    private float kt;

    /* renamed from: l, reason: collision with root package name */
    private boolean f23785l;
    private int la;
    private int mi;

    /* renamed from: n, reason: collision with root package name */
    private int f23786n;
    private int nd;
    private int ol;
    private int oq;

    /* renamed from: p, reason: collision with root package name */
    private boolean f23787p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f23788q;
    private int qb;
    private Parcelable qv;

    /* renamed from: r, reason: collision with root package name */
    int f23789r;
    private int rh;
    private float rn;
    private final Runnable rr;
    private int ry;

    /* renamed from: s, reason: collision with root package name */
    private boolean f23790s;
    private r sm;
    private int st;
    private float tj;
    private final xt tl;
    private float uf;

    /* renamed from: v, reason: collision with root package name */
    private int f23791v;
    private ClassLoader vl;

    /* renamed from: w, reason: collision with root package name */
    private int f23792w;
    private float wq;
    private boolean ws;

    /* renamed from: x, reason: collision with root package name */
    private boolean f23793x;
    private r xq;
    private List<r> ya;

    /* renamed from: z, reason: collision with root package name */
    private EdgeEffect f23794z;
    private int zz;
    static final int[] xt = {R.attr.layout_gravity};
    private static final Comparator<xt> up = new Comparator<xt>() { // from class: com.bytedance.adsdk.ugeno.viewpager.ViewPager.1
        @Override // java.util.Comparator
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public int compare(xt xtVar, xt xtVar2) {
            return xtVar.xt - xtVar2.xt;
        }
    };

    /* renamed from: m, reason: collision with root package name */
    private static final Interpolator f23774m = new Interpolator() { // from class: com.bytedance.adsdk.ugeno.viewpager.ViewPager.2
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f6) {
            float f7 = f6 - 1.0f;
            return (f7 * f7 * f7 * f7 * f7) + 1.0f;
        }
    };
    private static final tl aq = new tl();

    public static class ae extends com.bytedance.adsdk.ugeno.viewpager.j {
        public static final Parcelable.Creator<ae> CREATOR = new Parcelable.ClassLoaderCreator<ae>() { // from class: com.bytedance.adsdk.ugeno.viewpager.ViewPager.ae.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public ae createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new ae(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public ae createFromParcel(Parcel parcel) {
                return new ae(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public ae[] newArray(int i6) {
                return new ae[i6];
            }
        };
        Parcelable cw;

        /* renamed from: r, reason: collision with root package name */
        ClassLoader f23796r;
        int xt;

        public ae(Parcelable parcelable) {
            super(parcelable);
        }

        ae(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.xt = parcel.readInt();
            this.cw = parcel.readParcelable(classLoader);
            this.f23796r = classLoader;
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.xt + "}";
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.j, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            super.writeToParcel(parcel, i6);
            parcel.writeInt(this.xt);
            parcel.writeParcelable(this.cw, i6);
        }
    }

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface j {
    }

    private class m extends DataSetObserver {
        m() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            ViewPager.this.xt();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ViewPager.this.xt();
        }
    }

    public interface r {
        void g(int i6);

        void j(int i6, float f6, int i7);

        void tl(int i6);
    }

    public interface up {
        void j(View view, float f6);
    }

    private void m() {
        int i6 = 0;
        while (i6 < getChildCount()) {
            if (!((cw) getChildAt(i6).getLayoutParams()).f23797j) {
                removeViewAt(i6);
                i6--;
            }
            i6++;
        }
    }

    private void oq() {
        this.f23785l = false;
        this.f23787p = false;
        VelocityTracker velocityTracker = this.gx;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.gx = null;
        }
    }

    private boolean r(int i6) {
        if (this.ae.size() == 0) {
            if (this.f23776b) {
                return false;
            }
            this.f23788q = false;
            j(0, 0.0f, 0);
            if (this.f23788q) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        xt g6 = g();
        int clientWidth = getClientWidth();
        int i7 = this.av;
        int i8 = clientWidth + i7;
        float f6 = clientWidth;
        int i9 = g6.xt;
        float f7 = ((i6 / f6) - g6.up) / (g6.f23802r + (i7 / f6));
        this.f23788q = false;
        j(i9, f7, (int) (i8 * f7));
        if (this.f23788q) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private boolean tl() {
        this.f23777c = -1;
        oq();
        this.f23794z.onRelease();
        this.hl.onRelease();
        return this.f23794z.isFinished() || this.hl.isFinished();
    }

    private void up(int i6) {
        r rVar = this.sm;
        if (rVar != null) {
            rVar.tl(i6);
        }
        List<r> list = this.ya;
        if (list != null) {
            int size = list.size();
            for (int i7 = 0; i7 < size; i7++) {
                r rVar2 = this.ya.get(i7);
                if (rVar2 != null) {
                    rVar2.tl(i6);
                }
            }
        }
        r rVar3 = this.xq;
        if (rVar3 != null) {
            rVar3.tl(i6);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        xt j6;
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() == 0 && (j6 = j(childAt)) != null && j6.xt == this.f23789r) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        this.ws = true;
        if (this.jy.isFinished() || !this.jy.computeScrollOffset()) {
            j(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.jy.getCurrX();
        int currY = this.jy.getCurrY();
        if (scrollX != currX || scrollY != currY) {
            scrollTo(currX, currY);
            if (!r(currX)) {
                this.jy.abortAnimation();
                scrollTo(0, currY);
            }
        }
        postInvalidateOnAnimation();
    }

    void cw() {
        j(this.f23789r);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    void j() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.jy = new Scroller(context, f23774m);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f6 = context.getResources().getDisplayMetrics().density;
        this.gq = viewConfiguration.getScaledPagingTouchSlop();
        this.f23786n = (int) (400.0f * f6);
        this.nd = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f23794z = new EdgeEffect(context);
        this.hl = new EdgeEffect(context);
        this.rh = (int) (25.0f * f6);
        this.ol = (int) (2.0f * f6);
        this.f23781h = (int) (f6 * 16.0f);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0088  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r14, int r15) {
        /*
            Method dump skipped, instructions count: 243
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.viewpager.ViewPager.onMeasure(int, int):void");
    }

    public void setCurrentItem(int i6) {
        this.f23790s = false;
        j(i6, !this.f23776b, false);
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.f23782i = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    void xt() {
        int j6 = this.cw.j();
        this.f23783j = j6;
        boolean z5 = this.ae.size() < (this.f23775a * 2) + 1 && this.ae.size() < j6;
        int i6 = this.f23789r;
        int i7 = 0;
        while (i7 < this.ae.size()) {
            xt xtVar = this.ae.get(i7);
            int j7 = this.cw.j(xtVar.f23801j);
            if (j7 != -1) {
                if (j7 == -2) {
                    this.ae.remove(i7);
                    i7--;
                    this.cw.j((ViewGroup) this, xtVar.xt, xtVar.f23801j);
                    int i8 = this.f23789r;
                    if (i8 == xtVar.xt) {
                        i6 = Math.max(0, Math.min(i8, j6 - 1));
                    }
                } else {
                    int i9 = xtVar.xt;
                    if (i9 != j7) {
                        if (i9 == this.f23789r) {
                            i6 = j7;
                        }
                        xtVar.xt = j7;
                    }
                }
                z5 = true;
            }
            i7++;
        }
        Collections.sort(this.ae, up);
        if (z5) {
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                cw cwVar = (cw) getChildAt(i10).getLayoutParams();
                if (!cwVar.f23797j) {
                    cwVar.cw = 0.0f;
                }
            }
            j(i6, false, true);
            requestLayout();
        }
    }

    public static class cw extends ViewGroup.LayoutParams {
        float cw;

        /* renamed from: j, reason: collision with root package name */
        public boolean f23797j;

        /* renamed from: m, reason: collision with root package name */
        int f23798m;

        /* renamed from: r, reason: collision with root package name */
        boolean f23799r;
        int up;
        public int xt;

        public cw() {
            super(-1, -1);
            this.cw = 0.0f;
        }

        public cw(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.cw = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.xt);
            this.xt = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    static class tl implements Comparator<View> {
        tl() {
        }

        @Override // java.util.Comparator
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            cw cwVar = (cw) view.getLayoutParams();
            cw cwVar2 = (cw) view2.getLayoutParams();
            boolean z5 = cwVar.f23797j;
            if (z5 != cwVar2.f23797j) {
                if (z5) {
                    return 1;
                }
                return -1;
            }
            return cwVar.up - cwVar2.up;
        }
    }

    static class xt {
        boolean cw;

        /* renamed from: j, reason: collision with root package name */
        Object f23801j;

        /* renamed from: r, reason: collision with root package name */
        float f23802r;
        float up;
        int xt;

        xt() {
        }
    }

    private void ae() {
        if (this.zz != 0) {
            ArrayList<View> arrayList = this.kc;
            if (arrayList == null) {
                this.kc = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                this.kc.add(getChildAt(i6));
            }
            Collections.sort(this.kc, aq);
        }
    }

    private static boolean cw(View view) {
        return view.getClass().getAnnotation(j.class) != null;
    }

    private void setScrollingCacheEnabled(boolean z5) {
        if (this.ch != z5) {
            this.ch = z5;
        }
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i6) {
        if (this.cw == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        return i6 < 0 ? scrollX > ((int) (((float) clientWidth) * this.kt)) : i6 > 0 && scrollX < ((int) (((float) clientWidth) * this.tj));
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof cw) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new cw();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new cw(getContext(), attributeSet);
    }

    public com.bytedance.adsdk.ugeno.viewpager.xt getAdapter() {
        return this.cw;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i6, int i7) {
        if (this.zz == 2) {
            i7 = (i6 - 1) - i7;
        }
        return ((cw) this.kc.get(i7).getLayoutParams()).f23798m;
    }

    public int getCurrentItem() {
        return this.f23789r;
    }

    public int getOffscreenPageLimit() {
        return this.f23775a;
    }

    public int getPageMargin() {
        return this.av;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.rr);
        Scroller scroller = this.jy;
        if (scroller != null && !scroller.isFinished()) {
            this.jy.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i6;
        float f6;
        int i7;
        super.onDraw(canvas);
        if (this.av <= 0 || this.f23782i == null || this.ae.size() <= 0 || this.cw == null) {
            return;
        }
        int scrollX = getScrollX();
        float width = getWidth();
        float f7 = this.av / width;
        int i8 = 0;
        xt xtVar = this.ae.get(0);
        float f8 = xtVar.up;
        int size = this.ae.size();
        int i9 = xtVar.xt;
        int i10 = this.ae.get(size - 1).xt;
        while (i9 < i10) {
            while (true) {
                i6 = xtVar.xt;
                if (i9 <= i6 || i8 >= size) {
                    break;
                }
                i8++;
                xtVar = this.ae.get(i8);
            }
            if (i9 == i6) {
                float f9 = xtVar.up;
                float f10 = xtVar.f23802r;
                f6 = (f9 + f10) * width;
                f8 = f9 + f10 + f7;
            } else {
                float j6 = this.cw.j(i9);
                f6 = (f8 + j6) * width;
                f8 += j6 + f7;
            }
            if (this.av + f6 > scrollX) {
                i7 = scrollX;
                this.f23782i.setBounds(Math.round(f6), this.f23792w, Math.round(this.av + f6), this.mi);
                this.f23782i.draw(canvas);
            } else {
                i7 = scrollX;
            }
            if (f6 > i7 + r2) {
                return;
            }
            i9++;
            scrollX = i7;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0094  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.viewpager.ViewPager.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ae)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ae aeVar = (ae) parcelable;
        super.onRestoreInstanceState(aeVar.j());
        if (this.cw != null) {
            j(aeVar.xt, false, true);
            return;
        }
        this.oq = aeVar.xt;
        this.qv = aeVar.cw;
        this.vl = aeVar.f23796r;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        com.bytedance.adsdk.ugeno.viewpager.xt xtVar;
        int findPointerIndex;
        if (this.hh) {
            return true;
        }
        boolean z5 = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (xtVar = this.cw) == null || xtVar.j() == 0) {
            return false;
        }
        if (this.gx == null) {
            this.gx = VelocityTracker.obtain();
        }
        this.gx.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.jy.abortAnimation();
            this.f23790s = false;
            cw();
            float x5 = motionEvent.getX();
            this.uf = x5;
            this.rn = x5;
            float y5 = motionEvent.getY();
            this.ed = y5;
            this.wq = y5;
            this.f23777c = motionEvent.getPointerId(0);
        } else if (action != 1) {
            if (action == 2) {
                if (!this.f23785l) {
                    int findPointerIndex2 = motionEvent.findPointerIndex(this.f23777c);
                    if (findPointerIndex2 == -1) {
                        z5 = tl();
                    } else {
                        float x6 = motionEvent.getX(findPointerIndex2);
                        float abs = Math.abs(x6 - this.rn);
                        float y6 = motionEvent.getY(findPointerIndex2);
                        float abs2 = Math.abs(y6 - this.wq);
                        if (abs > this.gq && abs > abs2) {
                            this.f23785l = true;
                            cw(true);
                            float f6 = this.uf;
                            this.rn = x6 - f6 > 0.0f ? f6 + this.gq : f6 - this.gq;
                            this.wq = y6;
                            setScrollState(1);
                            setScrollingCacheEnabled(true);
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                }
                if (this.f23785l && (findPointerIndex = motionEvent.findPointerIndex(this.f23777c)) != -1) {
                    z5 = xt(motionEvent.getX(findPointerIndex));
                }
            } else if (action != 3) {
                if (action == 5) {
                    int actionIndex = motionEvent.getActionIndex();
                    if (actionIndex != -1) {
                        this.rn = motionEvent.getX(actionIndex);
                        this.f23777c = motionEvent.getPointerId(actionIndex);
                    }
                } else if (action == 6) {
                    j(motionEvent);
                    int findPointerIndex3 = motionEvent.findPointerIndex(this.f23777c);
                    if (findPointerIndex3 != -1) {
                        this.rn = motionEvent.getX(findPointerIndex3);
                    }
                }
            } else if (this.f23785l) {
                j(this.f23789r, true, 0, false);
                z5 = tl();
            }
        } else if (this.f23785l) {
            VelocityTracker velocityTracker = this.gx;
            velocityTracker.computeCurrentVelocity(1000, this.nd);
            int xVelocity = (int) velocityTracker.getXVelocity(this.f23777c);
            this.f23790s = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            xt g6 = g();
            float f7 = clientWidth;
            int i6 = g6.xt;
            float f8 = ((scrollX / f7) - g6.up) / (g6.f23802r + (this.av / f7));
            int findPointerIndex4 = motionEvent.findPointerIndex(this.f23777c);
            if (findPointerIndex4 != -1) {
                j(j(i6, f8, xVelocity, (int) (motionEvent.getX(findPointerIndex4) - this.uf)), true, true, xVelocity);
                z5 = tl();
            }
        }
        if (z5) {
            postInvalidateOnAnimation();
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.f23793x) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(com.bytedance.adsdk.ugeno.viewpager.xt xtVar) {
        com.bytedance.adsdk.ugeno.viewpager.xt xtVar2 = this.cw;
        if (xtVar2 != null) {
            xtVar2.j((DataSetObserver) null);
            for (int i6 = 0; i6 < this.ae.size(); i6++) {
                xt xtVar3 = this.ae.get(i6);
                this.cw.j((ViewGroup) this, xtVar3.xt, xtVar3.f23801j);
            }
            this.ae.clear();
            m();
            this.f23789r = 0;
            scrollTo(0, 0);
        }
        this.cw = xtVar;
        this.f23783j = 0;
        if (xtVar != null) {
            if (this.az == null) {
                this.az = new m();
            }
            this.cw.j((DataSetObserver) this.az);
            this.f23790s = false;
            boolean z5 = this.f23776b;
            this.f23776b = true;
            this.f23783j = this.cw.j();
            int i7 = this.oq;
            if (i7 >= 0) {
                j(i7, false, true);
                this.oq = -1;
                this.qv = null;
                this.vl = null;
            } else if (z5) {
                requestLayout();
            } else {
                cw();
            }
        }
        List<Object> list = this.f23784k;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.f23784k.size();
        for (int i8 = 0; i8 < size; i8++) {
            this.f23784k.get(i8);
        }
    }

    public void setOffscreenPageLimit(int i6) {
        if (i6 <= 0) {
            vl.xt("ViewPager", "Requested offscreen page limit " + i6 + " too small; defaulting to 1");
            i6 = 1;
        }
        if (i6 != this.f23775a) {
            this.f23775a = i6;
            cw();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(r rVar) {
        this.sm = rVar;
    }

    public void setPageMargin(int i6) {
        int i7 = this.av;
        this.av = i6;
        int width = getWidth();
        j(width, width, i6, i7);
        requestLayout();
    }

    void setScrollState(int i6) {
        if (this.st == i6) {
            return;
        }
        this.st = i6;
        if (this.ff != null) {
            xt(i6 != 0);
        }
        m(i6);
    }

    public void setScroller(Scroller scroller) {
        this.jy = scroller;
    }

    public ViewPager(Context context) {
        super(context);
        this.ae = new ArrayList<>();
        this.tl = new xt();
        this.f23780g = new Rect();
        this.oq = -1;
        this.qv = null;
        this.vl = null;
        this.kt = -3.4028235E38f;
        this.tj = Float.MAX_VALUE;
        this.f23775a = 1;
        this.f23777c = -1;
        this.f23776b = true;
        this.f23778e = false;
        this.rr = new Runnable() { // from class: com.bytedance.adsdk.ugeno.viewpager.ViewPager.3
            @Override // java.lang.Runnable
            public void run() {
                ViewPager.this.setScrollState(0);
                ViewPager.this.cw();
            }
        };
        this.st = 0;
        j();
    }

    private xt g() {
        float f6;
        float f7;
        int i6;
        int clientWidth = getClientWidth();
        float f8 = 0.0f;
        if (clientWidth > 0) {
            f6 = getScrollX() / clientWidth;
        } else {
            f6 = 0.0f;
        }
        if (clientWidth > 0) {
            f7 = this.av / clientWidth;
        } else {
            f7 = 0.0f;
        }
        xt xtVar = null;
        float f9 = 0.0f;
        int i7 = -1;
        int i8 = 0;
        boolean z5 = true;
        while (i8 < this.ae.size()) {
            xt xtVar2 = this.ae.get(i8);
            if (!z5 && xtVar2.xt != (i6 = i7 + 1)) {
                xtVar2 = this.tl;
                xtVar2.up = f8 + f9 + f7;
                xtVar2.xt = i6;
                xtVar2.f23802r = this.cw.j(i6);
                i8--;
            }
            xt xtVar3 = xtVar2;
            f8 = xtVar3.up;
            float f10 = xtVar3.f23802r + f8 + f7;
            if (!z5 && f6 < f8) {
                break;
            }
            if (f6 >= f10 && i8 != this.ae.size() - 1) {
                int i9 = xtVar3.xt;
                float f11 = xtVar3.f23802r;
                i8++;
                i7 = i9;
                f9 = f11;
                xtVar = xtVar3;
                z5 = false;
            } else {
                return xtVar3;
            }
        }
        return xtVar;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i6, int i7) {
        xt j6;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i8 = 0; i8 < getChildCount(); i8++) {
                View childAt = getChildAt(i8);
                if (childAt.getVisibility() == 0 && (j6 = j(childAt)) != null && j6.xt == this.f23789r) {
                    childAt.addFocusables(arrayList, i6, i7);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if ((i7 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i6, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        cw cwVar = (cw) layoutParams;
        boolean cw2 = cwVar.f23797j | cw(view);
        cwVar.f23797j = cw2;
        if (this.f23793x) {
            if (!cw2) {
                cwVar.f23799r = true;
                addViewInLayout(view, i6, layoutParams);
                return;
            }
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
        super.addView(view, i6, layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!super.dispatchKeyEvent(keyEvent) && !j(keyEvent)) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        xt j6;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() == 0 && (j6 = j(childAt)) != null && j6.xt == this.f23789r && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        com.bytedance.adsdk.ugeno.viewpager.xt xtVar;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean z5 = false;
        if (overScrollMode != 0 && (overScrollMode != 1 || (xtVar = this.cw) == null || xtVar.j() <= 1)) {
            this.f23794z.finish();
            this.hl.finish();
        } else {
            if (!this.f23794z.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), this.kt * width);
                this.f23794z.setSize(height, width);
                z5 = this.f23794z.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.hl.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.tj + 1.0f)) * width2);
                this.hl.setSize(height2, width2);
                z5 |= this.hl.draw(canvas);
                canvas.restoreToCount(save2);
            }
        }
        if (z5) {
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f23782i;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f23776b = true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int findPointerIndex;
        float f6;
        int action = motionEvent.getAction() & 255;
        if (action != 3 && action != 1) {
            if (action != 0) {
                if (this.f23785l) {
                    return true;
                }
                if (this.f23787p) {
                    return false;
                }
            }
            if (action != 0) {
                if (action != 2) {
                    if (action == 6) {
                        j(motionEvent);
                    }
                } else {
                    int i6 = this.f23777c;
                    if (i6 != -1 && (findPointerIndex = motionEvent.findPointerIndex(i6)) != -1) {
                        float x5 = motionEvent.getX(findPointerIndex);
                        float f7 = x5 - this.rn;
                        float abs = Math.abs(f7);
                        float y5 = motionEvent.getY(findPointerIndex);
                        float abs2 = Math.abs(y5 - this.ed);
                        if (f7 != 0.0f && !j(this.rn, f7) && j(this, false, (int) f7, (int) x5, (int) y5)) {
                            this.rn = x5;
                            this.wq = y5;
                            this.f23787p = true;
                            return false;
                        }
                        int i7 = this.gq;
                        if (abs > i7 && abs * 0.5f > abs2) {
                            this.f23785l = true;
                            cw(true);
                            setScrollState(1);
                            if (f7 > 0.0f) {
                                f6 = this.uf + this.gq;
                            } else {
                                f6 = this.uf - this.gq;
                            }
                            this.rn = f6;
                            this.wq = y5;
                            setScrollingCacheEnabled(true);
                        } else if (abs2 > i7) {
                            this.f23787p = true;
                        }
                        if (this.f23785l && xt(x5)) {
                            postInvalidateOnAnimation();
                        }
                    }
                }
            } else {
                float x6 = motionEvent.getX();
                this.uf = x6;
                this.rn = x6;
                float y6 = motionEvent.getY();
                this.ed = y6;
                this.wq = y6;
                this.f23777c = motionEvent.getPointerId(0);
                this.f23787p = false;
                this.ws = true;
                this.jy.computeScrollOffset();
                if (this.st == 2 && Math.abs(this.jy.getFinalX() - this.jy.getCurrX()) > this.ol) {
                    this.jy.abortAnimation();
                    this.f23790s = false;
                    cw();
                    this.f23785l = true;
                    cw(true);
                    setScrollState(1);
                } else {
                    j(false);
                    this.f23785l = false;
                }
            }
            if (this.gx == null) {
                this.gx = VelocityTracker.obtain();
            }
            this.gx.addMovement(motionEvent);
            return this.f23785l;
        }
        tl();
        return false;
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i6, Rect rect) {
        int i7;
        int i8;
        int i9;
        xt j6;
        int childCount = getChildCount();
        if ((i6 & 2) != 0) {
            i8 = childCount;
            i7 = 0;
            i9 = 1;
        } else {
            i7 = childCount - 1;
            i8 = -1;
            i9 = -1;
        }
        while (i7 != i8) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() == 0 && (j6 = j(childAt)) != null && j6.xt == this.f23789r && childAt.requestFocus(i6, rect)) {
                return true;
            }
            i7 += i9;
        }
        return false;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        ae aeVar = new ae(super.onSaveInstanceState());
        aeVar.xt = this.f23789r;
        com.bytedance.adsdk.ugeno.viewpager.xt xtVar = this.cw;
        if (xtVar != null) {
            aeVar.cw = xtVar.xt();
        }
        return aeVar;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        if (i6 != i8) {
            int i10 = this.av;
            j(i6, i8, i10, i10);
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        if (!super.verifyDrawable(drawable) && drawable != this.f23782i) {
            return false;
        }
        return true;
    }

    private void cw(boolean z5) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z5);
        }
    }

    public void setPageMarginDrawable(int i6) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i6));
    }

    private void m(int i6) {
        r rVar = this.sm;
        if (rVar != null) {
            rVar.g(i6);
        }
        List<r> list = this.ya;
        if (list != null) {
            int size = list.size();
            for (int i7 = 0; i7 < size; i7++) {
                r rVar2 = this.ya.get(i7);
                if (rVar2 != null) {
                    rVar2.g(i6);
                }
            }
        }
        r rVar3 = this.xq;
        if (rVar3 != null) {
            rVar3.g(i6);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00b4, code lost:
    
        if (r5 != 2) goto L39;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean cw(int r5) {
        /*
            r4 = this;
            android.view.View r0 = r4.findFocus()
            r1 = 0
            if (r0 != r4) goto L9
        L7:
            r0 = r1
            goto L60
        L9:
            if (r0 == 0) goto L60
            android.view.ViewParent r2 = r0.getParent()
        Lf:
            boolean r3 = r2 instanceof android.view.ViewGroup
            if (r3 == 0) goto L1b
            if (r2 != r4) goto L16
            goto L60
        L16:
            android.view.ViewParent r2 = r2.getParent()
            goto Lf
        L1b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.Class r3 = r0.getClass()
            java.lang.String r3 = r3.getSimpleName()
            r2.append(r3)
            android.view.ViewParent r0 = r0.getParent()
        L2f:
            boolean r3 = r0 instanceof android.view.ViewGroup
            if (r3 == 0) goto L48
            java.lang.String r3 = " => "
            r2.append(r3)
            java.lang.Class r3 = r0.getClass()
            java.lang.String r3 = r3.getSimpleName()
            r2.append(r3)
            android.view.ViewParent r0 = r0.getParent()
            goto L2f
        L48:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "arrowScroll tried to find focus based on non-child current focused view "
            r0.<init>(r3)
            java.lang.String r2 = r2.toString()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "ViewPager"
            com.bytedance.sdk.component.utils.vl.r(r2, r0)
            goto L7
        L60:
            android.view.FocusFinder r1 = android.view.FocusFinder.getInstance()
            android.view.View r1 = r1.findNextFocus(r4, r0, r5)
            r2 = 66
            r3 = 17
            if (r1 == 0) goto Lab
            if (r1 == r0) goto Lab
            if (r5 != r3) goto L90
            android.graphics.Rect r2 = r4.f23780g
            android.graphics.Rect r2 = r4.j(r2, r1)
            int r2 = r2.left
            android.graphics.Rect r3 = r4.f23780g
            android.graphics.Rect r3 = r4.j(r3, r0)
            int r3 = r3.left
            if (r0 == 0) goto L8b
            if (r2 < r3) goto L8b
            boolean r0 = r4.r()
            goto Lc2
        L8b:
            boolean r0 = r1.requestFocus()
            goto Lc2
        L90:
            if (r5 != r2) goto Lb7
            android.graphics.Rect r2 = r4.f23780g
            android.graphics.Rect r2 = r4.j(r2, r1)
            int r2 = r2.left
            android.graphics.Rect r3 = r4.f23780g
            android.graphics.Rect r3 = r4.j(r3, r0)
            int r3 = r3.left
            if (r0 == 0) goto La6
            if (r2 <= r3) goto Lb9
        La6:
            boolean r0 = r1.requestFocus()
            goto Lc2
        Lab:
            if (r5 == r3) goto Lbe
            r0 = 1
            if (r5 != r0) goto Lb1
            goto Lbe
        Lb1:
            if (r5 == r2) goto Lb9
            r0 = 2
            if (r5 != r0) goto Lb7
            goto Lb9
        Lb7:
            r0 = 0
            goto Lc2
        Lb9:
            boolean r0 = r4.up()
            goto Lc2
        Lbe:
            boolean r0 = r4.r()
        Lc2:
            if (r0 == 0) goto Lcb
            int r5 = android.view.SoundEffectConstants.getContantForFocusDirection(r5)
            r4.playSoundEffect(r5)
        Lcb:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.viewpager.ViewPager.cw(int):boolean");
    }

    boolean up() {
        com.bytedance.adsdk.ugeno.viewpager.xt xtVar = this.cw;
        if (xtVar == null || this.f23789r >= xtVar.j() - 1) {
            return false;
        }
        j(this.f23789r + 1, true);
        return true;
    }

    public void j(int i6, boolean z5) {
        this.f23790s = false;
        j(i6, z5, false);
    }

    boolean r() {
        int i6 = this.f23789r;
        if (i6 <= 0) {
            return false;
        }
        j(i6 - 1, true);
        return true;
    }

    void j(int i6, boolean z5, boolean z6) {
        j(i6, z5, z6, 0);
    }

    void j(int i6, boolean z5, boolean z6, int i7) {
        com.bytedance.adsdk.ugeno.viewpager.xt xtVar = this.cw;
        if (xtVar != null && xtVar.j() > 0) {
            if (!z6 && this.f23789r == i6 && this.ae.size() != 0) {
                setScrollingCacheEnabled(false);
                return;
            }
            if (i6 < 0) {
                i6 = 0;
            } else if (i6 >= this.cw.j()) {
                i6 = this.cw.j() - 1;
            }
            int i8 = this.f23775a;
            int i9 = this.f23789r;
            if (i6 > i9 + i8 || i6 < i9 - i8) {
                for (int i10 = 0; i10 < this.ae.size(); i10++) {
                    this.ae.get(i10).cw = true;
                }
            }
            boolean z7 = this.f23789r != i6;
            if (this.f23776b) {
                this.f23789r = i6;
                if (z7) {
                    up(i6);
                }
                requestLayout();
                return;
            }
            j(i6);
            j(i6, z5, i7, z7);
            return;
        }
        setScrollingCacheEnabled(false);
    }

    xt xt(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent != this) {
                if (parent == null || !(parent instanceof View)) {
                    return null;
                }
                view = (View) parent;
            } else {
                return j(view);
            }
        }
    }

    xt xt(int i6) {
        for (int i7 = 0; i7 < this.ae.size(); i7++) {
            xt xtVar = this.ae.get(i7);
            if (xtVar.xt == i6) {
                return xtVar;
            }
        }
        return null;
    }

    private void xt(int i6, float f6, int i7) {
        r rVar = this.sm;
        if (rVar != null) {
            rVar.j(i6, f6, i7);
        }
        List<r> list = this.ya;
        if (list != null) {
            int size = list.size();
            for (int i8 = 0; i8 < size; i8++) {
                r rVar2 = this.ya.get(i8);
                if (rVar2 != null) {
                    rVar2.j(i6, f6, i7);
                }
            }
        }
        r rVar3 = this.xq;
        if (rVar3 != null) {
            rVar3.j(i6, f6, i7);
        }
    }

    private void j(int i6, boolean z5, int i7, boolean z6) {
        xt xt2 = xt(i6);
        int clientWidth = xt2 != null ? (int) (getClientWidth() * Math.max(this.kt, Math.min(xt2.up, this.tj))) : 0;
        if (z5) {
            j(clientWidth, 0, i7);
            if (z6) {
                up(i6);
                return;
            }
            return;
        }
        if (z6) {
            up(i6);
        }
        j(false);
        scrollTo(clientWidth, 0);
        r(clientWidth);
    }

    private void xt(boolean z5) {
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            getChildAt(i6).setLayerType(z5 ? this.ry : 0, null);
        }
    }

    private boolean xt(float f6) {
        boolean z5;
        boolean z6;
        float f7 = this.rn - f6;
        this.rn = f6;
        float scrollX = getScrollX() + f7;
        float clientWidth = getClientWidth();
        float f8 = this.kt * clientWidth;
        float f9 = this.tj * clientWidth;
        boolean z7 = false;
        xt xtVar = this.ae.get(0);
        ArrayList<xt> arrayList = this.ae;
        xt xtVar2 = arrayList.get(arrayList.size() - 1);
        if (xtVar.xt != 0) {
            f8 = xtVar.up * clientWidth;
            z5 = false;
        } else {
            z5 = true;
        }
        if (xtVar2.xt != this.cw.j() - 1) {
            f9 = xtVar2.up * clientWidth;
            z6 = false;
        } else {
            z6 = true;
        }
        if (scrollX < f8) {
            if (z5) {
                this.f23794z.onPull(Math.abs(f8 - scrollX) / clientWidth);
                z7 = true;
            }
            scrollX = f8;
        } else if (scrollX > f9) {
            if (z6) {
                this.hl.onPull(Math.abs(scrollX - f9) / clientWidth);
                z7 = true;
            }
            scrollX = f9;
        }
        int i6 = (int) scrollX;
        this.rn += scrollX - i6;
        scrollTo(i6, getScrollY());
        r(i6);
        return z7;
    }

    public void j(r rVar) {
        if (this.ya == null) {
            this.ya = new ArrayList();
        }
        this.ya.add(rVar);
    }

    public void j(boolean z5, up upVar) {
        j(z5, upVar, 2);
    }

    public void j(boolean z5, up upVar, int i6) {
        boolean z6 = upVar != null;
        boolean z7 = z6 != (this.ff != null);
        this.ff = upVar;
        setChildrenDrawingOrderEnabled(z6);
        if (z6) {
            this.zz = z5 ? 2 : 1;
            this.ry = i6;
        } else {
            this.zz = 0;
        }
        if (z7) {
            cw();
        }
    }

    float j(float f6) {
        return (float) Math.sin((f6 - 0.5f) * 0.47123894f);
    }

    void j(int i6, int i7, int i8) {
        int scrollX;
        int abs;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.jy;
        if (scroller != null && !scroller.isFinished()) {
            scrollX = this.ws ? this.jy.getCurrX() : this.jy.getStartX();
            this.jy.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            scrollX = getScrollX();
        }
        int i9 = scrollX;
        int scrollY = getScrollY();
        int i10 = i6 - i9;
        int i11 = i7 - scrollY;
        if (i10 == 0 && i11 == 0) {
            j(false);
            cw();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i12 = clientWidth / 2;
        float f6 = clientWidth;
        float f7 = i12;
        float j6 = f7 + (j(Math.min(1.0f, (Math.abs(i10) * 1.0f) / f6)) * f7);
        int abs2 = Math.abs(i8);
        if (abs2 > 0) {
            abs = Math.round(Math.abs(j6 / abs2) * 1000.0f) * 4;
        } else {
            abs = (int) (((Math.abs(i10) / ((f6 * this.cw.j(this.f23789r)) + this.av)) + 1.0f) * 100.0f);
        }
        int min = Math.min(abs, 600);
        this.ws = false;
        this.jy.startScroll(i9, scrollY, i10, i11, min);
        postInvalidateOnAnimation();
    }

    xt j(int i6, int i7) {
        xt xtVar = new xt();
        xtVar.xt = i6;
        xtVar.f23801j = this.cw.j((ViewGroup) this, i6);
        xtVar.f23802r = this.cw.j(i6);
        if (i7 >= 0 && i7 < this.ae.size()) {
            this.ae.add(i7, xtVar);
            return xtVar;
        }
        this.ae.add(xtVar);
        return xtVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x005c, code lost:
    
        if (r9 == r10) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void j(int r18) {
        /*
            Method dump skipped, instructions count: 591
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.viewpager.ViewPager.j(int):void");
    }

    private void j(xt xtVar, int i6, xt xtVar2) {
        int i7;
        int i8;
        xt xtVar3;
        xt xtVar4;
        int j6 = this.cw.j();
        int clientWidth = getClientWidth();
        float f6 = clientWidth > 0 ? this.av / clientWidth : 0.0f;
        if (xtVar2 != null) {
            int i9 = xtVar2.xt;
            int i10 = xtVar.xt;
            if (i9 < i10) {
                float f7 = xtVar2.up + xtVar2.f23802r + f6;
                int i11 = i9 + 1;
                int i12 = 0;
                while (i11 <= xtVar.xt && i12 < this.ae.size()) {
                    xt xtVar5 = this.ae.get(i12);
                    while (true) {
                        xtVar4 = xtVar5;
                        if (i11 <= xtVar4.xt || i12 >= this.ae.size() - 1) {
                            break;
                        }
                        i12++;
                        xtVar5 = this.ae.get(i12);
                    }
                    while (i11 < xtVar4.xt) {
                        f7 += this.cw.j(i11) + f6;
                        i11++;
                    }
                    xtVar4.up = f7;
                    f7 += xtVar4.f23802r + f6;
                    i11++;
                }
            } else if (i9 > i10) {
                int size = this.ae.size() - 1;
                float f8 = xtVar2.up;
                while (true) {
                    i9--;
                    if (i9 < xtVar.xt || size < 0) {
                        break;
                    }
                    xt xtVar6 = this.ae.get(size);
                    while (true) {
                        xtVar3 = xtVar6;
                        if (i9 >= xtVar3.xt || size <= 0) {
                            break;
                        }
                        size--;
                        xtVar6 = this.ae.get(size);
                    }
                    while (i9 > xtVar3.xt) {
                        f8 -= this.cw.j(i9) + f6;
                        i9--;
                    }
                    f8 -= xtVar3.f23802r + f6;
                    xtVar3.up = f8;
                }
            }
        }
        int size2 = this.ae.size();
        float f9 = xtVar.up;
        int i13 = xtVar.xt;
        int i14 = i13 - 1;
        this.kt = i13 == 0 ? f9 : -3.4028235E38f;
        int i15 = j6 - 1;
        this.tj = i13 == i15 ? (xtVar.f23802r + f9) - 1.0f : Float.MAX_VALUE;
        int i16 = i6 - 1;
        while (i16 >= 0) {
            xt xtVar7 = this.ae.get(i16);
            while (true) {
                i8 = xtVar7.xt;
                if (i14 <= i8) {
                    break;
                }
                f9 -= this.cw.j(i14) + f6;
                i14--;
            }
            f9 -= xtVar7.f23802r + f6;
            xtVar7.up = f9;
            if (i8 == 0) {
                this.kt = f9;
            }
            i16--;
            i14--;
        }
        float f10 = xtVar.up + xtVar.f23802r + f6;
        int i17 = xtVar.xt + 1;
        int i18 = i6 + 1;
        while (i18 < size2) {
            xt xtVar8 = this.ae.get(i18);
            while (true) {
                i7 = xtVar8.xt;
                if (i17 >= i7) {
                    break;
                }
                f10 += this.cw.j(i17) + f6;
                i17++;
            }
            if (i7 == i15) {
                this.tj = (xtVar8.f23802r + f10) - 1.0f;
            }
            xtVar8.up = f10;
            f10 += xtVar8.f23802r + f6;
            i18++;
            i17++;
        }
        this.f23778e = false;
    }

    xt j(View view) {
        for (int i6 = 0; i6 < this.ae.size(); i6++) {
            xt xtVar = this.ae.get(i6);
            if (this.cw.j(view, xtVar.f23801j)) {
                return xtVar;
            }
        }
        return null;
    }

    private void j(int i6, int i7, int i8, int i9) {
        if (i7 > 0 && !this.ae.isEmpty()) {
            if (!this.jy.isFinished()) {
                this.jy.setFinalX(getCurrentItem() * getClientWidth());
                return;
            } else {
                scrollTo((int) ((getScrollX() / (((i7 - getPaddingLeft()) - getPaddingRight()) + i9)) * (((i6 - getPaddingLeft()) - getPaddingRight()) + i8)), getScrollY());
                return;
            }
        }
        xt xt2 = xt(this.f23789r);
        int min = (int) ((xt2 != null ? Math.min(xt2.up, this.tj) : 0.0f) * ((i6 - getPaddingLeft()) - getPaddingRight()));
        if (min != getScrollX()) {
            j(false);
            scrollTo(min, getScrollY());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void j(int r13, float r14, int r15) {
        /*
            r12 = this;
            int r0 = r12.qb
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L6b
            int r0 = r12.getScrollX()
            int r3 = r12.getPaddingLeft()
            int r4 = r12.getPaddingRight()
            int r5 = r12.getWidth()
            int r6 = r12.getChildCount()
            r7 = 0
        L1b:
            if (r7 >= r6) goto L6b
            android.view.View r8 = r12.getChildAt(r7)
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            com.bytedance.adsdk.ugeno.viewpager.ViewPager$cw r9 = (com.bytedance.adsdk.ugeno.viewpager.ViewPager.cw) r9
            boolean r10 = r9.f23797j
            if (r10 == 0) goto L68
            int r9 = r9.xt
            r9 = r9 & 7
            if (r9 == r2) goto L4f
            r10 = 3
            if (r9 == r10) goto L49
            r10 = 5
            if (r9 == r10) goto L39
            r9 = r3
            goto L5c
        L39:
            int r9 = r5 - r4
            int r10 = r8.getMeasuredWidth()
            int r9 = r9 - r10
            int r10 = r8.getMeasuredWidth()
            int r4 = r4 + r10
        L45:
            r11 = r9
            r9 = r3
            r3 = r11
            goto L5c
        L49:
            int r9 = r8.getWidth()
            int r9 = r9 + r3
            goto L5c
        L4f:
            int r9 = r8.getMeasuredWidth()
            int r9 = r5 - r9
            int r9 = r9 / 2
            int r9 = java.lang.Math.max(r9, r3)
            goto L45
        L5c:
            int r3 = r3 + r0
            int r10 = r8.getLeft()
            int r3 = r3 - r10
            if (r3 == 0) goto L67
            r8.offsetLeftAndRight(r3)
        L67:
            r3 = r9
        L68:
            int r7 = r7 + 1
            goto L1b
        L6b:
            r12.xt(r13, r14, r15)
            com.bytedance.adsdk.ugeno.viewpager.ViewPager$up r13 = r12.ff
            if (r13 == 0) goto L9e
            int r13 = r12.getScrollX()
            int r14 = r12.getChildCount()
        L7a:
            if (r1 >= r14) goto L9e
            android.view.View r15 = r12.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r0 = r15.getLayoutParams()
            com.bytedance.adsdk.ugeno.viewpager.ViewPager$cw r0 = (com.bytedance.adsdk.ugeno.viewpager.ViewPager.cw) r0
            boolean r0 = r0.f23797j
            if (r0 != 0) goto L9b
            int r0 = r15.getLeft()
            int r0 = r0 - r13
            float r0 = (float) r0
            int r3 = r12.getClientWidth()
            float r3 = (float) r3
            float r0 = r0 / r3
            com.bytedance.adsdk.ugeno.viewpager.ViewPager$up r3 = r12.ff
            r3.j(r15, r0)
        L9b:
            int r1 = r1 + 1
            goto L7a
        L9e:
            r12.f23788q = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.viewpager.ViewPager.j(int, float, int):void");
    }

    private void j(boolean z5) {
        boolean z6 = this.st == 2;
        if (z6) {
            setScrollingCacheEnabled(false);
            if (!this.jy.isFinished()) {
                this.jy.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.jy.getCurrX();
                int currY = this.jy.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        r(currX);
                    }
                }
            }
        }
        this.f23790s = false;
        for (int i6 = 0; i6 < this.ae.size(); i6++) {
            xt xtVar = this.ae.get(i6);
            if (xtVar.cw) {
                xtVar.cw = false;
                z6 = true;
            }
        }
        if (z6) {
            if (z5) {
                postOnAnimation(this.rr);
            } else {
                this.rr.run();
            }
        }
    }

    private boolean j(float f6, float f7) {
        if (f6 >= this.la || f7 <= 0.0f) {
            return f6 > ((float) (getWidth() - this.la)) && f7 < 0.0f;
        }
        return true;
    }

    private int j(int i6, float f6, int i7, int i8) {
        if (Math.abs(i8) <= this.rh || Math.abs(i7) <= this.f23786n) {
            i6 += (int) (f6 + (i6 >= this.f23789r ? 0.4f : 0.6f));
        } else if (i7 <= 0) {
            i6++;
        }
        if (this.ae.size() <= 0) {
            return i6;
        }
        return Math.max(this.ae.get(0).xt, Math.min(i6, this.ae.get(r4.size() - 1).xt));
    }

    private void j(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f23777c) {
            int i6 = actionIndex == 0 ? 1 : 0;
            this.rn = motionEvent.getX(i6);
            this.f23777c = motionEvent.getPointerId(i6);
            VelocityTracker velocityTracker = this.gx;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    protected boolean j(View view, boolean z5, int i6, int i7, int i8) {
        int i9;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i10 = i7 + scrollX;
                if (i10 >= childAt.getLeft() && i10 < childAt.getRight() && (i9 = i8 + scrollY) >= childAt.getTop() && i9 < childAt.getBottom() && j(childAt, true, i6, i10 - childAt.getLeft(), i9 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z5 && view.canScrollHorizontally(-i6);
    }

    public boolean j(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 21) {
            if (keyEvent.hasModifiers(2)) {
                return r();
            }
            return cw(17);
        }
        if (keyCode == 22) {
            if (keyEvent.hasModifiers(2)) {
                return up();
            }
            return cw(66);
        }
        if (keyCode != 61) {
            return false;
        }
        if (keyEvent.hasNoModifiers()) {
            return cw(2);
        }
        if (keyEvent.hasModifiers(1)) {
            return cw(1);
        }
        return false;
    }

    private Rect j(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }
}
