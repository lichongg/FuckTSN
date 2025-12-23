package com.baidu.mobads.sdk.internal.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.internal.concrete.ViewCompatDelegate;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class ViewPager2 extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    public static final int f11154a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static final int f11155b = 1;

    /* renamed from: c, reason: collision with root package name */
    public static final int f11156c = 0;

    /* renamed from: d, reason: collision with root package name */
    public static final int f11157d = 1;

    /* renamed from: e, reason: collision with root package name */
    public static final int f11158e = 2;

    /* renamed from: f, reason: collision with root package name */
    public static final int f11159f = -1;

    /* renamed from: g, reason: collision with root package name */
    static boolean f11160g = true;
    private boolean A;
    private int B;

    /* renamed from: h, reason: collision with root package name */
    int f11161h;

    /* renamed from: i, reason: collision with root package name */
    boolean f11162i;

    /* renamed from: j, reason: collision with root package name */
    RecyclerView f11163j;

    /* renamed from: k, reason: collision with root package name */
    ScrollEventAdapter f11164k;

    /* renamed from: l, reason: collision with root package name */
    AccessibilityProvider f11165l;

    /* renamed from: m, reason: collision with root package name */
    private final Rect f11166m;

    /* renamed from: n, reason: collision with root package name */
    private final Rect f11167n;

    /* renamed from: o, reason: collision with root package name */
    private final int[] f11168o;

    /* renamed from: p, reason: collision with root package name */
    private CompositeOnPageChangeCallback f11169p;

    /* renamed from: q, reason: collision with root package name */
    private RecyclerView.AdapterDataObserver f11170q;

    /* renamed from: r, reason: collision with root package name */
    private LinearLayoutManager f11171r;

    /* renamed from: s, reason: collision with root package name */
    private int f11172s;

    /* renamed from: t, reason: collision with root package name */
    private Parcelable f11173t;

    /* renamed from: u, reason: collision with root package name */
    private PagerSnapHelper f11174u;

    /* renamed from: v, reason: collision with root package name */
    private CompositeOnPageChangeCallback f11175v;

    /* renamed from: w, reason: collision with root package name */
    private FakeDrag f11176w;

    /* renamed from: x, reason: collision with root package name */
    private PageTransformerAdapter f11177x;

    /* renamed from: y, reason: collision with root package name */
    private RecyclerView.ItemAnimator f11178y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f11179z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private abstract class AccessibilityProvider {
        private AccessibilityProvider() {
        }

        void a(@NonNull AccessibilityEvent accessibilityEvent) {
        }

        void b(@Nullable RecyclerView.Adapter<?> adapter) {
        }

        boolean handlesLmPerformAccessibilityAction(int i6) {
            return false;
        }

        boolean handlesRvGetAccessibilityClassName() {
            return false;
        }

        void a(AccessibilityNodeInfo accessibilityNodeInfo) {
        }

        String b() {
            throw new IllegalStateException("Not implemented.");
        }

        boolean onLmPerformAccessibilityAction(int i6) {
            throw new IllegalStateException("Not implemented.");
        }

        CharSequence onRvGetAccessibilityClassName() {
            throw new IllegalStateException("Not implemented.");
        }

        void a(@Nullable RecyclerView.Adapter<?> adapter) {
        }

        boolean b(int i6, Bundle bundle) {
            throw new IllegalStateException("Not implemented.");
        }

        void a(@NonNull CompositeOnPageChangeCallback compositeOnPageChangeCallback, @NonNull RecyclerView recyclerView) {
        }

        boolean a() {
            return false;
        }

        boolean a(int i6, Bundle bundle) {
            return false;
        }

        void c() {
        }

        void d() {
        }

        void e() {
        }

        void f() {
        }

        void g() {
        }

        void onLmInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class BasicAccessibilityProvider extends AccessibilityProvider {
        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.AccessibilityProvider
        public boolean handlesRvGetAccessibilityClassName() {
            return true;
        }

        BasicAccessibilityProvider() {
            super();
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.AccessibilityProvider
        public boolean handlesLmPerformAccessibilityAction(int i6) {
            return (i6 == 8192 || i6 == 4096) && !ViewPager2.this.isUserInputEnabled();
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.AccessibilityProvider
        public void onLmInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (ViewPager2.this.isUserInputEnabled()) {
                return;
            }
            accessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
            accessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
            accessibilityNodeInfoCompat.setScrollable(false);
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.AccessibilityProvider
        public boolean onLmPerformAccessibilityAction(int i6) {
            if (handlesLmPerformAccessibilityAction(i6)) {
                return false;
            }
            throw new IllegalStateException();
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.AccessibilityProvider
        public CharSequence onRvGetAccessibilityClassName() {
            if (handlesRvGetAccessibilityClassName()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class DataSetChangeObserver extends RecyclerView.AdapterDataObserver {
        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public abstract void onChanged();

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i6, int i7) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i6, int i7, @Nullable Object obj) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeInserted(int i6, int i7) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeMoved(int i6, int i7, int i8) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeRemoved(int i6, int i7) {
            onChanged();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class LinearLayoutManagerImpl extends LinearLayoutManager {
        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean requestChildRectangleOnScreen(@NonNull RecyclerView recyclerView, @NonNull View view, @NonNull Rect rect, boolean z5, boolean z6) {
            return false;
        }

        LinearLayoutManagerImpl(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        protected int getExtraLayoutSpace(RecyclerView.State state) {
            int offscreenPageLimit = ViewPager2.this.getOffscreenPageLimit();
            return offscreenPageLimit == -1 ? super.getExtraLayoutSpace(state) : ViewPager2.this.b() * offscreenPageLimit;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean performAccessibilityAction(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state, int i6, @Nullable Bundle bundle) {
            return ViewPager2.this.f11165l.handlesLmPerformAccessibilityAction(i6) ? ViewPager2.this.f11165l.onLmPerformAccessibilityAction(i6) : super.performAccessibilityAction(recycler, state, i6, bundle);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void onInitializeAccessibilityNodeInfo(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(recycler, state, accessibilityNodeInfoCompat);
            ViewPager2.this.f11165l.onLmInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @IntRange(from = 1)
    @Retention(RetentionPolicy.SOURCE)
    public @interface OffscreenPageLimit {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface OnOverScrollListener {
        void onOverScrollEnd();

        void onOverScrollStart();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Orientation {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface PageTransformer {
        void transformPage(@NonNull View view, float f6);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class PagerSnapHelperImpl extends PagerSnapHelper {
        PagerSnapHelperImpl() {
        }

        @Override // com.baidu.mobads.sdk.internal.widget.PagerSnapHelper, androidx.recyclerview.widget.SnapHelper
        @Nullable
        public View findSnapView(RecyclerView.LayoutManager layoutManager) {
            if (ViewPager2.this.isFakeDragging()) {
                return null;
            }
            return super.findSnapView(layoutManager);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class RecyclerViewImpl extends RecyclerView {
        RecyclerViewImpl(@NonNull Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, androidx.core.view.NestedScrollingChild2
        public boolean dispatchNestedScroll(int i6, int i7, int i8, int i9, int[] iArr, int i10) {
            ViewPager2.this.f11168o[1] = ViewPager2.this.f11168o[0];
            if (1 == ViewPager2.this.getOrientation()) {
                ViewPager2.this.f11168o[0] = i9;
            } else {
                ViewPager2.this.f11168o[0] = i8;
            }
            return super.dispatchNestedScroll(i6, i7, i8, i9, iArr, i10);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
        @RequiresApi(23)
        public CharSequence getAccessibilityClassName() {
            return ViewPager2.this.f11165l.handlesRvGetAccessibilityClassName() ? ViewPager2.this.f11165l.onRvGetAccessibilityClassName() : super.getAccessibilityClassName();
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.isUserInputEnabled() && super.onInterceptTouchEvent(motionEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.isUserInputEnabled() && super.onTouchEvent(motionEvent);
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setFromIndex(ViewPager2.this.f11161h);
            accessibilityEvent.setToIndex(ViewPager2.this.f11161h);
            ViewPager2.this.f11165l.a(accessibilityEvent);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ScrollState {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class SmoothScrollToPosition implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final int f11198a;

        /* renamed from: b, reason: collision with root package name */
        private final RecyclerView f11199b;

        @Override // java.lang.Runnable
        public void run() {
            this.f11199b.smoothScrollToPosition(this.f11198a);
        }

        SmoothScrollToPosition(int i6, RecyclerView recyclerView) {
            this.f11198a = i6;
            this.f11199b = recyclerView;
        }
    }

    public ViewPager2(@NonNull Context context) {
        super(context);
        this.f11166m = new Rect();
        this.f11167n = new Rect();
        this.f11168o = new int[2];
        this.f11169p = new CompositeOnPageChangeCallback(3);
        this.f11162i = false;
        this.f11170q = new DataSetChangeObserver() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.1
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                ViewPager2 viewPager2 = ViewPager2.this;
                viewPager2.f11162i = true;
                viewPager2.f11164k.a();
            }
        };
        this.f11172s = -1;
        this.f11178y = null;
        this.f11179z = false;
        this.A = true;
        this.B = -1;
        a(context, (AttributeSet) null);
    }

    private void b(@Nullable RecyclerView.Adapter<?> adapter) {
        if (adapter != null) {
            adapter.unregisterAdapterDataObserver(this.f11170q);
        }
    }

    public void addItemDecoration(@NonNull RecyclerView.ItemDecoration itemDecoration) {
        this.f11163j.addItemDecoration(itemDecoration);
    }

    public void setCurrentItem(int i6) {
        setCurrentItem(i6, true);
    }

    public void setOffscreenPageLimit(int i6) {
        if (i6 < 1 && i6 != -1) {
            throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
        }
        this.B = i6;
        this.f11163j.requestLayout();
    }

    public void setPageTransformer(@Nullable PageTransformer pageTransformer) {
        if (pageTransformer != null) {
            if (!this.f11179z) {
                this.f11178y = this.f11163j.getItemAnimator();
                this.f11179z = true;
            }
            this.f11163j.setItemAnimator(null);
        } else if (this.f11179z) {
            this.f11163j.setItemAnimator(this.f11178y);
            this.f11178y = null;
            this.f11179z = false;
        }
        if (pageTransformer == this.f11177x.a()) {
            return;
        }
        this.f11177x.a(pageTransformer);
        requestTransform();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class SavedState extends View.BaseSavedState {

        /* renamed from: d, reason: collision with root package name */
        public static final Parcelable.Creator<SavedState> f11194d = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.SavedState.1
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i6) {
                return new SavedState[i6];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                if (Build.VERSION.SDK_INT >= 24) {
                    return new SavedState(parcel, classLoader);
                }
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return createFromParcel(parcel, (ClassLoader) null);
            }
        };

        /* renamed from: a, reason: collision with root package name */
        int f11195a;

        /* renamed from: b, reason: collision with root package name */
        int f11196b;

        /* renamed from: c, reason: collision with root package name */
        Parcelable f11197c;

        @RequiresApi(24)
        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            a(parcel, classLoader);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            a(parcel, null);
        }

        private void a(Parcel parcel, ClassLoader classLoader) {
            this.f11195a = parcel.readInt();
            this.f11196b = parcel.readInt();
            this.f11197c = parcel.readParcelable(classLoader);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            super.writeToParcel(parcel, i6);
            parcel.writeInt(this.f11195a);
            parcel.writeInt(this.f11196b);
            parcel.writeParcelable(this.f11197c, i6);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.f11165l = new BasicAccessibilityProvider();
        RecyclerViewImpl recyclerViewImpl = new RecyclerViewImpl(context);
        this.f11163j = recyclerViewImpl;
        recyclerViewImpl.setId(ViewCompatDelegate.generateViewId());
        this.f11163j.setDescendantFocusability(131072);
        LinearLayoutManagerImpl linearLayoutManagerImpl = new LinearLayoutManagerImpl(context);
        this.f11171r = linearLayoutManagerImpl;
        this.f11163j.setLayoutManager(linearLayoutManagerImpl);
        this.f11163j.setScrollingTouchSlop(1);
        setOrientation(0);
        this.f11163j.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f11163j.addOnChildAttachStateChangeListener(e());
        ScrollEventAdapter scrollEventAdapter = new ScrollEventAdapter(this);
        this.f11164k = scrollEventAdapter;
        this.f11176w = new FakeDrag(this, scrollEventAdapter, this.f11163j);
        PagerSnapHelperImpl pagerSnapHelperImpl = new PagerSnapHelperImpl();
        this.f11174u = pagerSnapHelperImpl;
        pagerSnapHelperImpl.attachToRecyclerView(this.f11163j);
        this.f11163j.addOnScrollListener(this.f11164k);
        CompositeOnPageChangeCallback compositeOnPageChangeCallback = new CompositeOnPageChangeCallback(3);
        this.f11175v = compositeOnPageChangeCallback;
        this.f11164k.a(compositeOnPageChangeCallback);
        OnPageChangeCallback onPageChangeCallback = new OnPageChangeCallback() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.2
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int i6) {
                if (i6 == 0) {
                    ViewPager2.this.a();
                }
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i6) {
                ViewPager2 viewPager2 = ViewPager2.this;
                if (viewPager2.f11161h != i6) {
                    viewPager2.f11161h = i6;
                    viewPager2.f11165l.e();
                }
            }
        };
        OnPageChangeCallback onPageChangeCallback2 = new OnPageChangeCallback() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.3
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i6) {
                ViewPager2.this.clearFocus();
                if (ViewPager2.this.hasFocus()) {
                    ViewPager2.this.f11163j.requestFocus(2);
                }
            }
        };
        this.f11175v.a(onPageChangeCallback);
        this.f11175v.a(onPageChangeCallback2);
        this.f11165l.a(this.f11175v, this.f11163j);
        this.f11175v.a(this.f11169p);
        PageTransformerAdapter pageTransformerAdapter = new PageTransformerAdapter(this.f11171r);
        this.f11177x = pageTransformerAdapter;
        this.f11175v.a(pageTransformerAdapter);
        RecyclerView recyclerView = this.f11163j;
        attachViewToParent(recyclerView, 0, recyclerView.getLayoutParams());
    }

    private RecyclerView.OnChildAttachStateChangeListener e() {
        return new RecyclerView.OnChildAttachStateChangeListener() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.4
            @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
            public void onChildViewAttachedToWindow(@NonNull View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                if (((ViewGroup.MarginLayoutParams) layoutParams).width == -1 && ((ViewGroup.MarginLayoutParams) layoutParams).height == -1) {
                } else {
                    throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
            public void onChildViewDetachedFromWindow(@NonNull View view) {
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void f() {
        RecyclerView.Adapter adapter;
        if (this.f11172s == -1 || (adapter = getAdapter()) == 0) {
            return;
        }
        Parcelable parcelable = this.f11173t;
        if (parcelable != null) {
            if (adapter instanceof StatefulAdapter) {
                ((StatefulAdapter) adapter).restoreState(parcelable);
            }
            this.f11173t = null;
        }
        int max = Math.max(0, Math.min(this.f11172s, adapter.getItemCount() - 1));
        this.f11161h = max;
        this.f11172s = -1;
        this.f11163j.scrollToPosition(max);
        this.f11165l.c();
    }

    public void addItemDecoration(@NonNull RecyclerView.ItemDecoration itemDecoration, int i6) {
        this.f11163j.addItemDecoration(itemDecoration, i6);
    }

    int b() {
        int height;
        int paddingBottom;
        RecyclerView recyclerView = this.f11163j;
        if (getOrientation() == 0) {
            height = recyclerView.getWidth() - recyclerView.getPaddingLeft();
            paddingBottom = recyclerView.getPaddingRight();
        } else {
            height = recyclerView.getHeight() - recyclerView.getPaddingTop();
            paddingBottom = recyclerView.getPaddingBottom();
        }
        return height - paddingBottom;
    }

    public boolean beginFakeDrag() {
        return this.f11176w.b();
    }

    boolean c() {
        return this.f11171r.getLayoutDirection() == 1;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i6) {
        return this.f11163j.canScrollHorizontally(i6);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i6) {
        return this.f11163j.canScrollVertically(i6);
    }

    void d() {
        View findSnapView = this.f11174u.findSnapView(this.f11171r);
        if (findSnapView == null) {
            return;
        }
        int[] calculateDistanceToFinalSnap = this.f11174u.calculateDistanceToFinalSnap(this.f11171r, findSnapView);
        int i6 = calculateDistanceToFinalSnap[0];
        if (i6 == 0 && calculateDistanceToFinalSnap[1] == 0) {
            return;
        }
        this.f11163j.smoothScrollBy(i6, calculateDistanceToFinalSnap[1]);
    }

    public boolean endFakeDrag() {
        return this.f11176w.c();
    }

    public boolean fakeDragBy(@Px @SuppressLint({"SupportAnnotationUsage"}) float f6) {
        return this.f11176w.a(f6);
    }

    @Override // android.view.ViewGroup, android.view.View
    @RequiresApi(23)
    public CharSequence getAccessibilityClassName() {
        return this.f11165l.a() ? this.f11165l.b() : super.getAccessibilityClassName();
    }

    @Nullable
    public RecyclerView.Adapter getAdapter() {
        return this.f11163j.getAdapter();
    }

    public int getCurrentItem() {
        return this.f11161h;
    }

    @NonNull
    public RecyclerView.ItemDecoration getItemDecorationAt(int i6) {
        return this.f11163j.getItemDecorationAt(i6);
    }

    public int getItemDecorationCount() {
        return this.f11163j.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.B;
    }

    public int getOrientation() {
        return this.f11171r.getOrientation();
    }

    public int getOverScrolledDirection() {
        int[] iArr = this.f11168o;
        int i6 = iArr[0];
        return i6 == 0 ? iArr[1] : i6;
    }

    public int getScrollState() {
        return this.f11164k.d();
    }

    public void invalidateItemDecorations() {
        this.f11163j.invalidateItemDecorations();
    }

    public boolean isFakeDragging() {
        return this.f11176w.a();
    }

    public boolean isUserInputEnabled() {
        return this.A;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        int measuredWidth = this.f11163j.getMeasuredWidth();
        int measuredHeight = this.f11163j.getMeasuredHeight();
        this.f11166m.left = getPaddingLeft();
        this.f11166m.right = (i8 - i6) - getPaddingRight();
        this.f11166m.top = getPaddingTop();
        this.f11166m.bottom = (i9 - i7) - getPaddingBottom();
        Gravity.apply(8388659, measuredWidth, measuredHeight, this.f11166m, this.f11167n);
        RecyclerView recyclerView = this.f11163j;
        Rect rect = this.f11167n;
        recyclerView.layout(rect.left, rect.top, rect.right, rect.bottom);
        if (this.f11162i) {
            a();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        measureChild(this.f11163j, i6, i7);
        int measuredWidth = this.f11163j.getMeasuredWidth();
        int measuredHeight = this.f11163j.getMeasuredHeight();
        int measuredState = this.f11163j.getMeasuredState();
        int paddingLeft = measuredWidth + getPaddingLeft() + getPaddingRight();
        int paddingTop = measuredHeight + getPaddingTop() + getPaddingBottom();
        setMeasuredDimension(View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i6, measuredState), View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i7, measuredState << 16));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f11172s = savedState.f11196b;
        this.f11173t = savedState.f11197c;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        throw new IllegalStateException(getClass().getSimpleName() + " does not support direct child views");
    }

    @Override // android.view.View
    @RequiresApi(16)
    public boolean performAccessibilityAction(int i6, Bundle bundle) {
        return this.f11165l.a(i6, bundle) ? this.f11165l.b(i6, bundle) : super.performAccessibilityAction(i6, bundle);
    }

    public void registerOnPageChangeCallback(@NonNull OnPageChangeCallback onPageChangeCallback) {
        this.f11169p.a(onPageChangeCallback);
    }

    public void removeItemDecoration(@NonNull RecyclerView.ItemDecoration itemDecoration) {
        this.f11163j.removeItemDecoration(itemDecoration);
    }

    public void removeItemDecorationAt(int i6) {
        this.f11163j.removeItemDecorationAt(i6);
    }

    public void requestTransform() {
        if (this.f11177x.a() == null) {
            return;
        }
        double h6 = this.f11164k.h();
        int i6 = (int) h6;
        float f6 = (float) (h6 - i6);
        this.f11177x.onPageScrolled(i6, f6, Math.round(b() * f6));
    }

    public void setAdapter(@Nullable RecyclerView.Adapter adapter) {
        RecyclerView.Adapter adapter2 = this.f11163j.getAdapter();
        this.f11165l.b(adapter2);
        b(adapter2);
        this.f11163j.setAdapter(adapter);
        this.f11161h = 0;
        f();
        this.f11165l.a((RecyclerView.Adapter<?>) adapter);
        a((RecyclerView.Adapter<?>) adapter);
    }

    public void setCurrentItem(int i6, boolean z5) {
        if (isFakeDragging()) {
            throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
        }
        a(i6, z5);
    }

    public void setOnOverScrollListener(final OnOverScrollListener onOverScrollListener) {
        if (onOverScrollListener == null) {
            return;
        }
        registerOnPageChangeCallback(new OnPageChangeCallback() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.5

            /* renamed from: a, reason: collision with root package name */
            boolean f11184a = false;

            /* renamed from: b, reason: collision with root package name */
            boolean f11185b = false;

            /* renamed from: c, reason: collision with root package name */
            boolean f11186c = false;

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int i6) {
                if (i6 != 0) {
                    if (i6 == 1) {
                        this.f11186c = true;
                        return;
                    } else {
                        if (i6 != 2) {
                            return;
                        }
                        this.f11184a = false;
                        this.f11185b = false;
                        return;
                    }
                }
                RecyclerView.Adapter adapter = ViewPager2.this.getAdapter();
                if (adapter == null || adapter.getItemCount() <= 0 || !this.f11186c) {
                    return;
                }
                if (1 == ViewPager2.this.getOrientation()) {
                    if (!ViewPager2.this.canScrollVertically(-1) && ViewPager2.this.getOverScrolledDirection() < 0) {
                        onOverScrollListener.onOverScrollStart();
                    } else if (!ViewPager2.this.canScrollVertically(1) && ViewPager2.this.getOverScrolledDirection() > 0) {
                        onOverScrollListener.onOverScrollEnd();
                    }
                } else if (ViewPager2.this.getOrientation() == 0) {
                    if (!ViewPager2.this.canScrollHorizontally(-1) && ViewPager2.this.getOverScrolledDirection() < 0) {
                        onOverScrollListener.onOverScrollStart();
                    } else if (!ViewPager2.this.canScrollHorizontally(1) && ViewPager2.this.getOverScrolledDirection() > 0) {
                        onOverScrollListener.onOverScrollEnd();
                    }
                }
                this.f11186c = false;
            }
        });
    }

    public void setOrientation(int i6) {
        this.f11171r.setOrientation(i6);
        this.f11165l.d();
    }

    public void setUserInputEnabled(boolean z5) {
        this.A = z5;
        this.f11165l.f();
    }

    public void unregisterOnPageChangeCallback(@NonNull OnPageChangeCallback onPageChangeCallback) {
        this.f11169p.b(onPageChangeCallback);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Parcelable parcelable = sparseArray.get(getId());
        if (parcelable instanceof SavedState) {
            int i6 = ((SavedState) parcelable).f11195a;
            sparseArray.put(this.f11163j.getId(), sparseArray.get(i6));
            sparseArray.remove(i6);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        f();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.f11165l.a(accessibilityNodeInfo);
    }

    @Override // android.view.View
    @Nullable
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f11195a = this.f11163j.getId();
        int i6 = this.f11172s;
        if (i6 == -1) {
            i6 = this.f11161h;
        }
        savedState.f11196b = i6;
        Parcelable parcelable = this.f11173t;
        if (parcelable != null) {
            savedState.f11197c = parcelable;
            return savedState;
        }
        Object adapter = this.f11163j.getAdapter();
        if (adapter instanceof StatefulAdapter) {
            savedState.f11197c = ((StatefulAdapter) adapter).saveState();
        }
        return savedState;
    }

    @Override // android.view.View
    @RequiresApi(17)
    public void setLayoutDirection(int i6) {
        super.setLayoutDirection(i6);
        this.f11165l.g();
    }

    public ViewPager2(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11166m = new Rect();
        this.f11167n = new Rect();
        this.f11168o = new int[2];
        this.f11169p = new CompositeOnPageChangeCallback(3);
        this.f11162i = false;
        this.f11170q = new DataSetChangeObserver() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.1
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                ViewPager2 viewPager2 = ViewPager2.this;
                viewPager2.f11162i = true;
                viewPager2.f11164k.a();
            }
        };
        this.f11172s = -1;
        this.f11178y = null;
        this.f11179z = false;
        this.A = true;
        this.B = -1;
        a(context, attributeSet);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class OnPageChangeCallback {
        public void onPageScrollStateChanged(int i6) {
        }

        public void onPageSelected(int i6) {
        }

        public void onPageScrolled(int i6, float f6, @Px int i7) {
        }
    }

    public ViewPager2(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f11166m = new Rect();
        this.f11167n = new Rect();
        this.f11168o = new int[2];
        this.f11169p = new CompositeOnPageChangeCallback(3);
        this.f11162i = false;
        this.f11170q = new DataSetChangeObserver() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.1
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                ViewPager2 viewPager2 = ViewPager2.this;
                viewPager2.f11162i = true;
                viewPager2.f11164k.a();
            }
        };
        this.f11172s = -1;
        this.f11178y = null;
        this.f11179z = false;
        this.A = true;
        this.B = -1;
        a(context, attributeSet);
    }

    private void a(@Nullable RecyclerView.Adapter<?> adapter) {
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.f11170q);
        }
    }

    void a() {
        PagerSnapHelper pagerSnapHelper = this.f11174u;
        if (pagerSnapHelper != null) {
            View findSnapView = pagerSnapHelper.findSnapView(this.f11171r);
            if (findSnapView == null) {
                return;
            }
            int position = this.f11171r.getPosition(findSnapView);
            if (position != this.f11161h && getScrollState() == 0) {
                this.f11175v.onPageSelected(position);
            }
            this.f11162i = false;
            return;
        }
        throw new IllegalStateException("Design assumption violated.");
    }

    void a(int i6, boolean z5) {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter == null) {
            if (this.f11172s != -1) {
                this.f11172s = Math.max(i6, 0);
                return;
            }
            return;
        }
        if (adapter.getItemCount() <= 0) {
            return;
        }
        int min = Math.min(Math.max(i6, 0), adapter.getItemCount() - 1);
        if (min == this.f11161h && this.f11164k.e()) {
            return;
        }
        int i7 = this.f11161h;
        if (min == i7 && z5) {
            return;
        }
        double d6 = i7;
        this.f11161h = min;
        this.f11165l.e();
        if (!this.f11164k.e()) {
            d6 = this.f11164k.h();
        }
        this.f11164k.a(min, z5);
        if (!z5) {
            this.f11163j.scrollToPosition(min);
            return;
        }
        double d7 = min;
        if (Math.abs(d7 - d6) > 3.0d) {
            this.f11163j.scrollToPosition(d7 > d6 ? min - 3 : min + 3);
            RecyclerView recyclerView = this.f11163j;
            recyclerView.post(new SmoothScrollToPosition(min, recyclerView));
            return;
        }
        this.f11163j.smoothScrollToPosition(min);
    }

    @RequiresApi(21)
    public ViewPager2(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
        this.f11166m = new Rect();
        this.f11167n = new Rect();
        this.f11168o = new int[2];
        this.f11169p = new CompositeOnPageChangeCallback(3);
        this.f11162i = false;
        this.f11170q = new DataSetChangeObserver() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.1
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                ViewPager2 viewPager2 = ViewPager2.this;
                viewPager2.f11162i = true;
                viewPager2.f11164k.a();
            }
        };
        this.f11172s = -1;
        this.f11178y = null;
        this.f11179z = false;
        this.A = true;
        this.B = -1;
        a(context, attributeSet);
    }
}
