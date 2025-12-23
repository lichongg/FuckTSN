package com.bumptech.glide.request.target;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class r<T extends View, Z> extends com.bumptech.glide.request.target.b<Z> {

    /* renamed from: g, reason: collision with root package name */
    private static final String f16261g = "ViewTarget";

    /* renamed from: h, reason: collision with root package name */
    private static boolean f16262h;

    /* renamed from: i, reason: collision with root package name */
    private static int f16263i = R.id.glide_custom_view_target_tag;

    /* renamed from: b, reason: collision with root package name */
    protected final T f16264b;

    /* renamed from: c, reason: collision with root package name */
    private final b f16265c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private View.OnAttachStateChangeListener f16266d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f16267e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f16268f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements View.OnAttachStateChangeListener {
        a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            r.this.m();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            r.this.l();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @VisibleForTesting
    static final class b {

        /* renamed from: e, reason: collision with root package name */
        private static final int f16270e = 0;

        /* renamed from: f, reason: collision with root package name */
        @Nullable
        @VisibleForTesting
        static Integer f16271f;

        /* renamed from: a, reason: collision with root package name */
        private final View f16272a;

        /* renamed from: b, reason: collision with root package name */
        private final List<o> f16273b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        boolean f16274c;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        private a f16275d;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        private static final class a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: a, reason: collision with root package name */
            private final WeakReference<b> f16276a;

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                Log.isLoggable(r.f16261g, 2);
                b bVar = this.f16276a.get();
                if (bVar == null) {
                    return true;
                }
                bVar.a();
                return true;
            }

            a(@NonNull b bVar) {
                this.f16276a = new WeakReference<>(bVar);
            }
        }

        private static int c(@NonNull Context context) {
            if (f16271f == null) {
                Display defaultDisplay = ((WindowManager) com.bumptech.glide.util.k.d((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f16271f = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f16271f.intValue();
        }

        private int e(int i6, int i7, int i8) {
            int i9 = i7 - i8;
            if (i9 > 0) {
                return i9;
            }
            if (this.f16274c && this.f16272a.isLayoutRequested()) {
                return 0;
            }
            int i10 = i6 - i8;
            if (i10 > 0) {
                return i10;
            }
            if (this.f16272a.isLayoutRequested() || i7 != -2) {
                return 0;
            }
            Log.isLoggable(r.f16261g, 4);
            return c(this.f16272a.getContext());
        }

        private int f() {
            int paddingTop = this.f16272a.getPaddingTop() + this.f16272a.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f16272a.getLayoutParams();
            return e(this.f16272a.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        private int g() {
            int paddingLeft = this.f16272a.getPaddingLeft() + this.f16272a.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f16272a.getLayoutParams();
            return e(this.f16272a.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        private boolean h(int i6) {
            return i6 > 0 || i6 == Integer.MIN_VALUE;
        }

        private void j(int i6, int i7) {
            Iterator it = new ArrayList(this.f16273b).iterator();
            while (it.hasNext()) {
                ((o) it.next()).d(i6, i7);
            }
        }

        void a() {
            if (this.f16273b.isEmpty()) {
                return;
            }
            int g6 = g();
            int f6 = f();
            if (i(g6, f6)) {
                j(g6, f6);
                b();
            }
        }

        void b() {
            ViewTreeObserver viewTreeObserver = this.f16272a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f16275d);
            }
            this.f16275d = null;
            this.f16273b.clear();
        }

        void k(@NonNull o oVar) {
            this.f16273b.remove(oVar);
        }

        b(@NonNull View view) {
            this.f16272a = view;
        }

        private boolean i(int i6, int i7) {
            if (h(i6) && h(i7)) {
                return true;
            }
            return false;
        }

        void d(@NonNull o oVar) {
            int g6 = g();
            int f6 = f();
            if (i(g6, f6)) {
                oVar.d(g6, f6);
                return;
            }
            if (!this.f16273b.contains(oVar)) {
                this.f16273b.add(oVar);
            }
            if (this.f16275d == null) {
                ViewTreeObserver viewTreeObserver = this.f16272a.getViewTreeObserver();
                a aVar = new a(this);
                this.f16275d = aVar;
                viewTreeObserver.addOnPreDrawListener(aVar);
            }
        }
    }

    public r(@NonNull T t5) {
        this.f16264b = (T) com.bumptech.glide.util.k.d(t5);
        this.f16265c = new b(t5);
    }

    private void p(@Nullable Object obj) {
        f16262h = true;
        this.f16264b.setTag(f16263i, obj);
    }

    @Nullable
    private Object f() {
        return this.f16264b.getTag(f16263i);
    }

    private void i() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f16266d;
        if (onAttachStateChangeListener == null || this.f16268f) {
            return;
        }
        this.f16264b.addOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f16268f = true;
    }

    private void k() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f16266d;
        if (onAttachStateChangeListener == null || !this.f16268f) {
            return;
        }
        this.f16264b.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f16268f = false;
    }

    @Deprecated
    public static void r(int i6) {
        if (f16262h) {
            throw new IllegalArgumentException("You cannot set the tag id more than once or change the tag id after the first request has been made");
        }
        f16263i = i6;
    }

    @Override // com.bumptech.glide.request.target.p
    @CallSuper
    public void b(@NonNull o oVar) {
        this.f16265c.k(oVar);
    }

    @NonNull
    public final r<T, Z> e() {
        if (this.f16266d != null) {
            return this;
        }
        this.f16266d = new a();
        i();
        return this;
    }

    @NonNull
    public T getView() {
        return this.f16264b;
    }

    @Override // com.bumptech.glide.request.target.p
    @CallSuper
    public void q(@NonNull o oVar) {
        this.f16265c.d(oVar);
    }

    @NonNull
    public final r<T, Z> s() {
        this.f16265c.f16274c = true;
        return this;
    }

    public String toString() {
        return "Target for: " + this.f16264b;
    }

    @Override // com.bumptech.glide.request.target.b, com.bumptech.glide.request.target.p
    @Nullable
    public com.bumptech.glide.request.e d() {
        Object f6 = f();
        if (f6 != null) {
            if (f6 instanceof com.bumptech.glide.request.e) {
                return (com.bumptech.glide.request.e) f6;
            }
            throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
        }
        return null;
    }

    @Override // com.bumptech.glide.request.target.b, com.bumptech.glide.request.target.p
    @CallSuper
    public void g(@Nullable Drawable drawable) {
        super.g(drawable);
        this.f16265c.b();
        if (!this.f16267e) {
            k();
        }
    }

    @Override // com.bumptech.glide.request.target.b, com.bumptech.glide.request.target.p
    @CallSuper
    public void j(@Nullable Drawable drawable) {
        super.j(drawable);
        i();
    }

    void l() {
        com.bumptech.glide.request.e d6 = d();
        if (d6 != null) {
            this.f16267e = true;
            d6.clear();
            this.f16267e = false;
        }
    }

    void m() {
        com.bumptech.glide.request.e d6 = d();
        if (d6 != null && d6.e()) {
            d6.h();
        }
    }

    @Override // com.bumptech.glide.request.target.b, com.bumptech.glide.request.target.p
    public void n(@Nullable com.bumptech.glide.request.e eVar) {
        p(eVar);
    }

    @Deprecated
    public r(@NonNull T t5, boolean z5) {
        this(t5);
        if (z5) {
            s();
        }
    }
}
