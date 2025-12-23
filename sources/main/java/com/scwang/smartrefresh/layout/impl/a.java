package com.scwang.smartrefresh.layout.impl;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.ScrollingView;
import androidx.core.widget.NestedScrollView;
import androidx.legacy.widget.Space;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.appbar.AppBarLayout;
import java.util.Collections;
import java.util.concurrent.LinkedBlockingQueue;
import m2.g;
import m2.h;
import m2.i;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class a implements m2.c {

    /* renamed from: c, reason: collision with root package name */
    protected View f37420c;

    /* renamed from: d, reason: collision with root package name */
    protected View f37421d;

    /* renamed from: e, reason: collision with root package name */
    protected View f37422e;

    /* renamed from: f, reason: collision with root package name */
    protected View f37423f;

    /* renamed from: g, reason: collision with root package name */
    protected View f37424g;

    /* renamed from: j, reason: collision with root package name */
    protected MotionEvent f37427j;

    /* renamed from: a, reason: collision with root package name */
    protected int f37418a = Integer.MAX_VALUE;

    /* renamed from: b, reason: collision with root package name */
    protected int f37419b = Integer.MAX_VALUE - 1;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f37425h = true;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f37426i = true;

    /* renamed from: k, reason: collision with root package name */
    protected d f37428k = new d();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.scwang.smartrefresh.layout.impl.a$a, reason: collision with other inner class name */
    class C0726a implements AppBarLayout.OnOffsetChangedListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f37429a;

        C0726a(h hVar) {
            this.f37429a = hVar;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i6) {
            a aVar = a.this;
            boolean z5 = false;
            aVar.f37425h = i6 >= 0;
            if (this.f37429a.z() && appBarLayout.getTotalScrollRange() + i6 <= 0) {
                z5 = true;
            }
            aVar.f37426i = z5;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        int f37431a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f37432b;

        b(int i6) {
            this.f37432b = i6;
            this.f37431a = i6;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            try {
                View view = a.this.f37422e;
                if (view instanceof AbsListView) {
                    a.v((AbsListView) view, intValue - this.f37431a);
                } else {
                    view.scrollBy(0, intValue - this.f37431a);
                }
            } catch (Throwable unused) {
            }
            this.f37431a = intValue;
        }
    }

    public a(View view) {
        this.f37421d = view;
        this.f37420c = view;
    }

    protected void b(View view, g gVar) {
        this.f37422e = null;
        while (true) {
            View view2 = this.f37422e;
            if (view2 != null && (!(view2 instanceof NestedScrollingParent) || (view2 instanceof NestedScrollingChild))) {
                return;
            }
            view = s(view, view2 == null);
            if (view == this.f37422e) {
                return;
            }
            try {
                if (view instanceof CoordinatorLayout) {
                    gVar.c().t(false);
                    w((ViewGroup) view, gVar.c());
                }
            } catch (Throwable unused) {
            }
            this.f37422e = view;
        }
    }

    @Override // m2.c
    public void p() {
        this.f37427j = null;
    }

    @Override // m2.c
    public void a(i iVar) {
        if (iVar instanceof d) {
            this.f37428k = (d) iVar;
        } else {
            this.f37428k.e(iVar);
        }
    }

    @Override // m2.c
    public void c(boolean z5) {
        this.f37428k.d(z5);
    }

    @Override // m2.c
    public ValueAnimator.AnimatorUpdateListener e(int i6) {
        View view = this.f37422e;
        if (view == null || i6 == 0) {
            return null;
        }
        if ((i6 >= 0 || !com.scwang.smartrefresh.layout.util.d.c(view)) && (i6 <= 0 || !com.scwang.smartrefresh.layout.util.d.e(this.f37422e))) {
            return null;
        }
        return new b(i6);
    }

    @Override // m2.c
    public int f() {
        return this.f37420c.getMeasuredWidth();
    }

    @Override // m2.c
    public void g(int i6, int i7) {
        this.f37420c.measure(i6, i7);
    }

    @Override // m2.c
    public ViewGroup.LayoutParams getLayoutParams() {
        return this.f37420c.getLayoutParams();
    }

    @Override // m2.c
    @NonNull
    public View getView() {
        return this.f37420c;
    }

    @Override // m2.c
    public int h() {
        return this.f37420c.getMeasuredHeight();
    }

    @Override // m2.c
    public void i(int i6) {
        this.f37421d.setTranslationY(i6);
        View view = this.f37423f;
        if (view != null) {
            view.setTranslationY(Math.max(0, i6));
        }
        View view2 = this.f37424g;
        if (view2 != null) {
            view2.setTranslationY(Math.min(0, i6));
        }
    }

    @Override // m2.c
    public void j(int i6, int i7) {
        this.f37418a = i6;
        this.f37419b = i7;
    }

    @Override // m2.c
    public void k(int i6, int i7, int i8, int i9) {
        this.f37420c.layout(i6, i7, i8, i9);
    }

    @Override // m2.c
    public View l() {
        return this.f37422e;
    }

    @Override // m2.c
    public void m(int i6) {
        View view = this.f37422e;
        if (view instanceof ScrollView) {
            ((ScrollView) view).fling(i6);
            return;
        }
        if (view instanceof AbsListView) {
            ((AbsListView) view).fling(i6);
            return;
        }
        if (view instanceof WebView) {
            ((WebView) view).flingScroll(0, i6);
        } else if (view instanceof RecyclerView) {
            ((RecyclerView) view).fling(0, i6);
        } else if (view instanceof NestedScrollView) {
            ((NestedScrollView) view).fling(i6);
        }
    }

    @Override // m2.c
    public boolean n() {
        return this.f37425h && this.f37428k.b(this.f37420c);
    }

    @Override // m2.c
    public void o(g gVar, View view, View view2) {
        b(this.f37420c, gVar);
        if (view == null && view2 == null) {
            return;
        }
        this.f37423f = view;
        this.f37424g = view2;
        FrameLayout frameLayout = new FrameLayout(this.f37420c.getContext());
        gVar.c().getLayout().removeView(this.f37420c);
        ViewGroup.LayoutParams layoutParams = this.f37420c.getLayoutParams();
        frameLayout.addView(this.f37420c, -1, -1);
        gVar.c().getLayout().addView(frameLayout, layoutParams);
        this.f37420c = frameLayout;
        if (view != null) {
            view.setClickable(true);
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            int indexOfChild = viewGroup.indexOfChild(view);
            viewGroup.removeView(view);
            layoutParams2.height = u(view);
            viewGroup.addView(new Space(this.f37420c.getContext()), indexOfChild, layoutParams2);
            frameLayout.addView(view);
        }
        if (view2 != null) {
            view2.setClickable(true);
            ViewGroup.LayoutParams layoutParams3 = view2.getLayoutParams();
            ViewGroup viewGroup2 = (ViewGroup) view2.getParent();
            int indexOfChild2 = viewGroup2.indexOfChild(view2);
            viewGroup2.removeView(view2);
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(layoutParams3);
            layoutParams3.height = u(view2);
            viewGroup2.addView(new Space(this.f37420c.getContext()), indexOfChild2, layoutParams3);
            layoutParams4.gravity = 80;
            frameLayout.addView(view2, layoutParams4);
        }
    }

    @Override // m2.c
    public boolean q() {
        return this.f37426i && this.f37428k.a(this.f37420c);
    }

    protected View r(View view, MotionEvent motionEvent, View view2) {
        if ((view instanceof ViewGroup) && motionEvent != null) {
            ViewGroup viewGroup = (ViewGroup) view;
            PointF pointF = new PointF();
            for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount - 1);
                if (com.scwang.smartrefresh.layout.util.d.f(viewGroup, childAt, motionEvent.getX(), motionEvent.getY(), pointF)) {
                    if (!(childAt instanceof ViewPager) && t(childAt)) {
                        return childAt;
                    }
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    obtain.offsetLocation(pointF.x, pointF.y);
                    return r(childAt, obtain, view2);
                }
            }
        }
        return view2;
    }

    protected View s(View view, boolean z5) {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(Collections.singletonList(view));
        View view2 = null;
        while (!linkedBlockingQueue.isEmpty() && view2 == null) {
            View view3 = (View) linkedBlockingQueue.poll();
            if (view3 != null) {
                if ((z5 || view3 != view) && t(view3)) {
                    view2 = view3;
                } else if (view3 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view3;
                    for (int i6 = 0; i6 < viewGroup.getChildCount(); i6++) {
                        linkedBlockingQueue.add(viewGroup.getChildAt(i6));
                    }
                }
            }
        }
        return view2 == null ? view : view2;
    }

    protected boolean t(View view) {
        return (view instanceof AbsListView) || (view instanceof ScrollView) || (view instanceof ScrollingView) || (view instanceof NestedScrollingChild) || (view instanceof NestedScrollingParent) || (view instanceof WebView) || (view instanceof ViewPager);
    }

    protected static int u(View view) {
        int makeMeasureSpec;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
        int i6 = layoutParams.height;
        if (i6 > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, makeMeasureSpec);
        return view.getMeasuredHeight();
    }

    protected static void v(@NonNull AbsListView absListView, int i6) {
        absListView.scrollListBy(i6);
    }

    @Override // m2.c
    public void d(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        this.f37427j = obtain;
        obtain.offsetLocation(-this.f37420c.getLeft(), -this.f37420c.getTop());
        this.f37428k.c(this.f37427j);
        this.f37422e = r(this.f37420c, this.f37427j, this.f37422e);
    }

    protected void w(ViewGroup viewGroup, h hVar) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt instanceof AppBarLayout) {
                ((AppBarLayout) childAt).addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new C0726a(hVar));
            }
        }
    }

    public a(Context context) {
        View view = new View(context);
        this.f37421d = view;
        this.f37420c = view;
    }
}
