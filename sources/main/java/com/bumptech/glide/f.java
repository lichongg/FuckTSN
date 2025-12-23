package com.bumptech.glide;

import android.graphics.drawable.Drawable;
import android.widget.AbsListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.target.o;
import com.bumptech.glide.request.target.p;
import com.bumptech.glide.util.l;
import java.util.List;
import java.util.Queue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class f<T> implements AbsListView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    private final int f14789a;

    /* renamed from: b, reason: collision with root package name */
    private final d f14790b;

    /* renamed from: c, reason: collision with root package name */
    private final i f14791c;

    /* renamed from: d, reason: collision with root package name */
    private final a<T> f14792d;

    /* renamed from: e, reason: collision with root package name */
    private final b<T> f14793e;

    /* renamed from: f, reason: collision with root package name */
    private int f14794f;

    /* renamed from: g, reason: collision with root package name */
    private int f14795g;

    /* renamed from: i, reason: collision with root package name */
    private int f14797i;

    /* renamed from: h, reason: collision with root package name */
    private int f14796h = -1;

    /* renamed from: j, reason: collision with root package name */
    private boolean f14798j = true;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a<U> {
        @NonNull
        List<U> a(int i6);

        @Nullable
        h<?> b(@NonNull U u5);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b<T> {
        @Nullable
        int[] a(@NonNull T t5, int i6, int i7);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class c implements p<Object> {

        /* renamed from: a, reason: collision with root package name */
        int f14799a;

        /* renamed from: b, reason: collision with root package name */
        int f14800b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        private com.bumptech.glide.request.e f14801c;

        @Override // com.bumptech.glide.request.target.p
        @Nullable
        public com.bumptech.glide.request.e d() {
            return this.f14801c;
        }

        @Override // com.bumptech.glide.request.target.p
        public void n(@Nullable com.bumptech.glide.request.e eVar) {
            this.f14801c = eVar;
        }

        @Override // com.bumptech.glide.request.target.p
        public void q(@NonNull o oVar) {
            oVar.d(this.f14800b, this.f14799a);
        }

        c() {
        }

        @Override // com.bumptech.glide.request.target.p
        public void b(@NonNull o oVar) {
        }

        @Override // com.bumptech.glide.request.target.p
        public void g(@Nullable Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.p
        public void j(@Nullable Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.p
        public void o(@Nullable Drawable drawable) {
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

        @Override // com.bumptech.glide.request.target.p
        public void h(@NonNull Object obj, @Nullable com.bumptech.glide.request.transition.f<? super Object> fVar) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class d {

        /* renamed from: a, reason: collision with root package name */
        final Queue<c> f14802a;

        public c a(int i6, int i7) {
            c poll = this.f14802a.poll();
            this.f14802a.offer(poll);
            poll.f14800b = i6;
            poll.f14799a = i7;
            return poll;
        }

        d(int i6) {
            this.f14802a = l.f(i6);
            for (int i7 = 0; i7 < i6; i7++) {
                this.f14802a.offer(new c());
            }
        }
    }

    private void a() {
        for (int i6 = 0; i6 < this.f14790b.f14802a.size(); i6++) {
            this.f14791c.z(this.f14790b.a(0, 0));
        }
    }

    private void b(int i6, int i7) {
        int min;
        int i8;
        if (i6 < i7) {
            i8 = Math.max(this.f14794f, i6);
            min = i7;
        } else {
            min = Math.min(this.f14795g, i6);
            i8 = i7;
        }
        int min2 = Math.min(this.f14797i, min);
        int min3 = Math.min(this.f14797i, Math.max(0, i8));
        if (i6 < i7) {
            for (int i9 = min3; i9 < min2; i9++) {
                d(this.f14792d.a(i9), i9, true);
            }
        } else {
            for (int i10 = min2 - 1; i10 >= min3; i10--) {
                d(this.f14792d.a(i10), i10, false);
            }
        }
        this.f14795g = min3;
        this.f14794f = min2;
    }

    private void c(int i6, boolean z5) {
        if (this.f14798j != z5) {
            this.f14798j = z5;
            a();
        }
        b(i6, (z5 ? this.f14789a : -this.f14789a) + i6);
    }

    private void e(@Nullable T t5, int i6, int i7) {
        int[] a6;
        h<?> b6;
        if (t5 == null || (a6 = this.f14793e.a(t5, i6, i7)) == null || (b6 = this.f14792d.b(t5)) == null) {
            return;
        }
        b6.j1(this.f14790b.a(a6[0], a6[1]));
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i6, int i7, int i8) {
        this.f14797i = i8;
        int i9 = this.f14796h;
        if (i6 > i9) {
            c(i7 + i6, true);
        } else if (i6 < i9) {
            c(i6, false);
        }
        this.f14796h = i6;
    }

    public f(@NonNull i iVar, @NonNull a<T> aVar, @NonNull b<T> bVar, int i6) {
        this.f14791c = iVar;
        this.f14792d = aVar;
        this.f14793e = bVar;
        this.f14789a = i6;
        this.f14790b = new d(i6 + 1);
    }

    private void d(List<T> list, int i6, boolean z5) {
        int size = list.size();
        if (z5) {
            for (int i7 = 0; i7 < size; i7++) {
                e(list.get(i7), i6, i7);
            }
            return;
        }
        for (int i8 = size - 1; i8 >= 0; i8--) {
            e(list.get(i8), i6, i8);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i6) {
    }
}
