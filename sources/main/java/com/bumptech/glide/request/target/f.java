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
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class f<T extends View, Z> implements p<Z> {

    /* renamed from: f, reason: collision with root package name */
    private static final String f16224f = "CustomViewTarget";

    /* renamed from: g, reason: collision with root package name */
    @IdRes
    private static final int f16225g = R.id.glide_custom_view_target_tag;

    /* renamed from: a, reason: collision with root package name */
    private final b f16226a;

    /* renamed from: b, reason: collision with root package name */
    protected final T f16227b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private View.OnAttachStateChangeListener f16228c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f16229d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f16230e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements View.OnAttachStateChangeListener {
        a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            f.this.p();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            f.this.m();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @VisibleForTesting
    static final class b {

        /* renamed from: e, reason: collision with root package name */
        private static final int f16232e = 0;

        /* renamed from: f, reason: collision with root package name */
        @Nullable
        @VisibleForTesting
        static Integer f16233f;

        /* renamed from: a, reason: collision with root package name */
        private final View f16234a;

        /* renamed from: b, reason: collision with root package name */
        private final List<o> f16235b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        boolean f16236c;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        private a f16237d;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        private static final class a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: a, reason: collision with root package name */
            private final WeakReference<b> f16238a;

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                Log.isLoggable(f.f16224f, 2);
                b bVar = this.f16238a.get();
                if (bVar == null) {
                    return true;
                }
                bVar.a();
                return true;
            }

            a(@NonNull b bVar) {
                this.f16238a = new WeakReference<>(bVar);
            }
        }

        private static int c(@NonNull Context context) {
            if (f16233f == null) {
                Display defaultDisplay = ((WindowManager) com.bumptech.glide.util.k.d((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f16233f = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f16233f.intValue();
        }

        private int e(int i6, int i7, int i8) {
            int i9 = i7 - i8;
            if (i9 > 0) {
                return i9;
            }
            if (this.f16236c && this.f16234a.isLayoutRequested()) {
                return 0;
            }
            int i10 = i6 - i8;
            if (i10 > 0) {
                return i10;
            }
            if (this.f16234a.isLayoutRequested() || i7 != -2) {
                return 0;
            }
            Log.isLoggable(f.f16224f, 4);
            return c(this.f16234a.getContext());
        }

        private int f() {
            int paddingTop = this.f16234a.getPaddingTop() + this.f16234a.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f16234a.getLayoutParams();
            return e(this.f16234a.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        private int g() {
            int paddingLeft = this.f16234a.getPaddingLeft() + this.f16234a.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f16234a.getLayoutParams();
            return e(this.f16234a.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        private boolean h(int i6) {
            return i6 > 0 || i6 == Integer.MIN_VALUE;
        }

        private void j(int i6, int i7) {
            Iterator it = new ArrayList(this.f16235b).iterator();
            while (it.hasNext()) {
                ((o) it.next()).d(i6, i7);
            }
        }

        void a() {
            if (this.f16235b.isEmpty()) {
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
            ViewTreeObserver viewTreeObserver = this.f16234a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f16237d);
            }
            this.f16237d = null;
            this.f16235b.clear();
        }

        void k(@NonNull o oVar) {
            this.f16235b.remove(oVar);
        }

        b(@NonNull View view) {
            this.f16234a = view;
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
            if (!this.f16235b.contains(oVar)) {
                this.f16235b.add(oVar);
            }
            if (this.f16237d == null) {
                ViewTreeObserver viewTreeObserver = this.f16234a.getViewTreeObserver();
                a aVar = new a(this);
                this.f16237d = aVar;
                viewTreeObserver.addOnPreDrawListener(aVar);
            }
        }
    }

    protected abstract void k(@Nullable Drawable drawable);

    @Nullable
    private Object c() {
        return this.f16227b.getTag(f16225g);
    }

    private void f() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f16228c;
        if (onAttachStateChangeListener == null || this.f16230e) {
            return;
        }
        this.f16227b.addOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f16230e = true;
    }

    private void i() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f16228c;
        if (onAttachStateChangeListener == null || !this.f16230e) {
            return;
        }
        this.f16227b.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f16230e = false;
    }

    private void r(@Nullable Object obj) {
        this.f16227b.setTag(f16225g, obj);
    }

    @NonNull
    public final f<T, Z> a() {
        if (this.f16228c != null) {
            return this;
        }
        this.f16228c = new a();
        f();
        return this;
    }

    @Override // com.bumptech.glide.request.target.p
    public final void b(@NonNull o oVar) {
        this.f16226a.k(oVar);
    }

    @NonNull
    public final T e() {
        return this.f16227b;
    }

    @Override // com.bumptech.glide.request.target.p
    public final void g(@Nullable Drawable drawable) {
        this.f16226a.b();
        k(drawable);
        if (this.f16229d) {
            return;
        }
        i();
    }

    @Override // com.bumptech.glide.request.target.p
    public final void q(@NonNull o oVar) {
        this.f16226a.d(oVar);
    }

    @NonNull
    public final f<T, Z> t() {
        this.f16226a.f16236c = true;
        return this;
    }

    public String toString() {
        return "Target for: " + this.f16227b;
    }

    public f(@NonNull T t5) {
        this.f16227b = (T) com.bumptech.glide.util.k.d(t5);
        this.f16226a = new b(t5);
    }

    @Override // com.bumptech.glide.request.target.p
    @Nullable
    public final com.bumptech.glide.request.e d() {
        Object c6 = c();
        if (c6 != null) {
            if (c6 instanceof com.bumptech.glide.request.e) {
                return (com.bumptech.glide.request.e) c6;
            }
            throw new IllegalArgumentException("You must not pass non-R.id ids to setTag(id)");
        }
        return null;
    }

    @Override // com.bumptech.glide.request.target.p
    public final void j(@Nullable Drawable drawable) {
        f();
        l(drawable);
    }

    final void m() {
        com.bumptech.glide.request.e d6 = d();
        if (d6 != null) {
            this.f16229d = true;
            d6.clear();
            this.f16229d = false;
        }
    }

    @Override // com.bumptech.glide.request.target.p
    public final void n(@Nullable com.bumptech.glide.request.e eVar) {
        r(eVar);
    }

    final void p() {
        com.bumptech.glide.request.e d6 = d();
        if (d6 != null && d6.e()) {
            d6.h();
        }
    }

    protected void l(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.manager.m
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.m
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.m
    public void onStop() {
    }

    @Deprecated
    public final f<T, Z> s(@IdRes int i6) {
        return this;
    }
}
