package com.baidu.mobads.sdk.internal.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.internal.widget.ViewPager2;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
final class ScrollEventAdapter extends RecyclerView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    private static final int f11132a = 0;

    /* renamed from: b, reason: collision with root package name */
    private static final int f11133b = 1;

    /* renamed from: c, reason: collision with root package name */
    private static final int f11134c = 2;

    /* renamed from: d, reason: collision with root package name */
    private static final int f11135d = 3;

    /* renamed from: e, reason: collision with root package name */
    private static final int f11136e = 4;

    /* renamed from: f, reason: collision with root package name */
    private static final int f11137f = -1;

    /* renamed from: g, reason: collision with root package name */
    private ViewPager2.OnPageChangeCallback f11138g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    private final ViewPager2 f11139h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    private final RecyclerView f11140i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    private final LinearLayoutManager f11141j;

    /* renamed from: k, reason: collision with root package name */
    private int f11142k;

    /* renamed from: l, reason: collision with root package name */
    private int f11143l;

    /* renamed from: m, reason: collision with root package name */
    private ScrollEventValues f11144m;

    /* renamed from: n, reason: collision with root package name */
    private int f11145n;

    /* renamed from: o, reason: collision with root package name */
    private int f11146o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f11147p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f11148q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f11149r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f11150s;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Retention(RetentionPolicy.SOURCE)
    private @interface AdapterState {
    }

    private void a(boolean z5) {
        this.f11150s = z5;
        this.f11142k = z5 ? 4 : 1;
        int i6 = this.f11146o;
        if (i6 != -1) {
            this.f11145n = i6;
            this.f11146o = -1;
        } else if (this.f11145n == -1) {
            this.f11145n = l();
        }
        a(1);
    }

    private void i() {
        this.f11142k = 0;
        this.f11143l = 0;
        this.f11144m.a();
        this.f11145n = -1;
        this.f11146o = -1;
        this.f11147p = false;
        this.f11148q = false;
        this.f11150s = false;
        this.f11149r = false;
    }

    void b() {
        this.f11142k = 4;
        a(true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001d, code lost:
    
        if ((r5 < 0) == r3.f11139h.c()) goto L12;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onScrolled(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView r4, int r5, int r6) {
        /*
            r3 = this;
            r4 = 1
            r3.f11148q = r4
            r3.j()
            boolean r0 = r3.f11147p
            r1 = -1
            r2 = 0
            if (r0 == 0) goto L37
            r3.f11147p = r2
            if (r6 > 0) goto L1f
            if (r6 != 0) goto L29
            if (r5 >= 0) goto L16
            r5 = 1
            goto L17
        L16:
            r5 = 0
        L17:
            com.baidu.mobads.sdk.internal.widget.ViewPager2 r6 = r3.f11139h
            boolean r6 = r6.c()
            if (r5 != r6) goto L29
        L1f:
            com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.f11144m
            int r6 = r5.f11153c
            if (r6 == 0) goto L29
            int r5 = r5.f11151a
            int r5 = r5 + r4
            goto L2d
        L29:
            com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.f11144m
            int r5 = r5.f11151a
        L2d:
            r3.f11146o = r5
            int r6 = r3.f11145n
            if (r6 == r5) goto L45
            r3.b(r5)
            goto L45
        L37:
            int r5 = r3.f11142k
            if (r5 != 0) goto L45
            com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.f11144m
            int r5 = r5.f11151a
            if (r5 != r1) goto L42
            r5 = 0
        L42:
            r3.b(r5)
        L45:
            com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.f11144m
            int r6 = r5.f11151a
            if (r6 != r1) goto L4c
            r6 = 0
        L4c:
            float r0 = r5.f11152b
            int r5 = r5.f11153c
            r3.a(r6, r0, r5)
            com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.f11144m
            int r6 = r5.f11151a
            int r0 = r3.f11146o
            if (r6 == r0) goto L5d
            if (r0 != r1) goto L6b
        L5d:
            int r5 = r5.f11153c
            if (r5 != 0) goto L6b
            int r5 = r3.f11143l
            if (r5 == r4) goto L6b
            r3.a(r2)
            r3.i()
        L6b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter.onScrolled(androidx.recyclerview.widget.RecyclerView, int, int):void");
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class ScrollEventValues {

        /* renamed from: a, reason: collision with root package name */
        int f11151a;

        /* renamed from: b, reason: collision with root package name */
        float f11152b;

        /* renamed from: c, reason: collision with root package name */
        int f11153c;

        void a() {
            this.f11151a = -1;
            this.f11152b = 0.0f;
            this.f11153c = 0;
        }

        ScrollEventValues() {
        }
    }

    private void j() {
        int top2;
        ScrollEventValues scrollEventValues = this.f11144m;
        int findFirstVisibleItemPosition = this.f11141j.findFirstVisibleItemPosition();
        scrollEventValues.f11151a = findFirstVisibleItemPosition;
        if (findFirstVisibleItemPosition == -1) {
            scrollEventValues.a();
            return;
        }
        View findViewByPosition = this.f11141j.findViewByPosition(findFirstVisibleItemPosition);
        if (findViewByPosition == null) {
            scrollEventValues.a();
            return;
        }
        int leftDecorationWidth = this.f11141j.getLeftDecorationWidth(findViewByPosition);
        int rightDecorationWidth = this.f11141j.getRightDecorationWidth(findViewByPosition);
        int topDecorationHeight = this.f11141j.getTopDecorationHeight(findViewByPosition);
        int bottomDecorationHeight = this.f11141j.getBottomDecorationHeight(findViewByPosition);
        ViewGroup.LayoutParams layoutParams = findViewByPosition.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            leftDecorationWidth += marginLayoutParams.leftMargin;
            rightDecorationWidth += marginLayoutParams.rightMargin;
            topDecorationHeight += marginLayoutParams.topMargin;
            bottomDecorationHeight += marginLayoutParams.bottomMargin;
        }
        int height = findViewByPosition.getHeight() + topDecorationHeight + bottomDecorationHeight;
        int width = findViewByPosition.getWidth() + leftDecorationWidth + rightDecorationWidth;
        if (this.f11141j.getOrientation() == 0) {
            top2 = (findViewByPosition.getLeft() - leftDecorationWidth) - this.f11140i.getPaddingLeft();
            if (this.f11139h.c()) {
                top2 = -top2;
            }
            height = width;
        } else {
            top2 = (findViewByPosition.getTop() - topDecorationHeight) - this.f11140i.getPaddingTop();
        }
        int i6 = -top2;
        scrollEventValues.f11153c = i6;
        if (i6 >= 0) {
            scrollEventValues.f11152b = height == 0 ? 0.0f : i6 / height;
        } else {
            if (!new AnimateLayoutChangeDetector(this.f11141j).a()) {
                throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", Integer.valueOf(scrollEventValues.f11153c)));
            }
            throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
        }
    }

    private boolean k() {
        int i6 = this.f11142k;
        return i6 == 1 || i6 == 4;
    }

    private int l() {
        return this.f11141j.findFirstVisibleItemPosition();
    }

    int d() {
        return this.f11143l;
    }

    boolean e() {
        return this.f11143l == 0;
    }

    boolean f() {
        return this.f11143l == 1;
    }

    boolean g() {
        return this.f11150s;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i6) {
        if (!(this.f11142k == 1 && this.f11143l == 1) && i6 == 1) {
            a(false);
            return;
        }
        if (k() && i6 == 2) {
            if (this.f11148q) {
                a(2);
                this.f11147p = true;
                return;
            }
            return;
        }
        if (k() && i6 == 0) {
            j();
            if (this.f11148q) {
                ScrollEventValues scrollEventValues = this.f11144m;
                if (scrollEventValues.f11153c == 0) {
                    int i7 = this.f11145n;
                    int i8 = scrollEventValues.f11151a;
                    if (i7 != i8) {
                        b(i8);
                    }
                }
            } else {
                int i9 = this.f11144m.f11151a;
                if (i9 != -1) {
                    a(i9, 0.0f, 0);
                }
            }
            a(0);
            i();
        }
        if (this.f11142k == 2 && i6 == 0 && this.f11149r) {
            j();
            ScrollEventValues scrollEventValues2 = this.f11144m;
            if (scrollEventValues2.f11153c == 0) {
                int i10 = this.f11146o;
                int i11 = scrollEventValues2.f11151a;
                if (i10 != i11) {
                    if (i11 == -1) {
                        i11 = 0;
                    }
                    b(i11);
                }
                a(0);
                i();
            }
        }
    }

    ScrollEventAdapter(@NonNull ViewPager2 viewPager2) {
        this.f11139h = viewPager2;
        RecyclerView recyclerView = viewPager2.f11163j;
        this.f11140i = recyclerView;
        this.f11141j = (LinearLayoutManager) recyclerView.getLayoutManager();
        this.f11144m = new ScrollEventValues();
        i();
    }

    private void b(int i6) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.f11138g;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageSelected(i6);
        }
    }

    void c() {
        if (f() && !this.f11150s) {
            return;
        }
        this.f11150s = false;
        j();
        ScrollEventValues scrollEventValues = this.f11144m;
        if (scrollEventValues.f11153c == 0) {
            int i6 = scrollEventValues.f11151a;
            if (i6 != this.f11145n) {
                b(i6);
            }
            a(0);
            i();
            return;
        }
        a(2);
    }

    double h() {
        j();
        ScrollEventValues scrollEventValues = this.f11144m;
        return scrollEventValues.f11151a + scrollEventValues.f11152b;
    }

    void a() {
        this.f11149r = true;
    }

    void a(int i6, boolean z5) {
        this.f11142k = z5 ? 2 : 3;
        this.f11150s = false;
        boolean z6 = this.f11146o != i6;
        this.f11146o = i6;
        a(2);
        if (z6) {
            b(i6);
        }
    }

    void a(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.f11138g = onPageChangeCallback;
    }

    private void a(int i6) {
        if ((this.f11142k == 3 && this.f11143l == 0) || this.f11143l == i6) {
            return;
        }
        this.f11143l = i6;
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.f11138g;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageScrollStateChanged(i6);
        }
    }

    private void a(int i6, float f6, int i7) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.f11138g;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageScrolled(i6, f6, i7);
        }
    }
}
