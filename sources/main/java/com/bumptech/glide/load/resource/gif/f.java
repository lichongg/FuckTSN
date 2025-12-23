package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.engine.j;
import com.bumptech.glide.util.k;
import com.bumptech.glide.util.l;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
class f {

    /* renamed from: a, reason: collision with root package name */
    private final GifDecoder f15726a;

    /* renamed from: b, reason: collision with root package name */
    private final Handler f15727b;

    /* renamed from: c, reason: collision with root package name */
    private final List<b> f15728c;

    /* renamed from: d, reason: collision with root package name */
    final com.bumptech.glide.i f15729d;

    /* renamed from: e, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.e f15730e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f15731f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f15732g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f15733h;

    /* renamed from: i, reason: collision with root package name */
    private com.bumptech.glide.h<Bitmap> f15734i;

    /* renamed from: j, reason: collision with root package name */
    private a f15735j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f15736k;

    /* renamed from: l, reason: collision with root package name */
    private a f15737l;

    /* renamed from: m, reason: collision with root package name */
    private Bitmap f15738m;

    /* renamed from: n, reason: collision with root package name */
    private com.bumptech.glide.load.i<Bitmap> f15739n;

    /* renamed from: o, reason: collision with root package name */
    private a f15740o;

    /* renamed from: p, reason: collision with root package name */
    @Nullable
    private d f15741p;

    /* renamed from: q, reason: collision with root package name */
    private int f15742q;

    /* renamed from: r, reason: collision with root package name */
    private int f15743r;

    /* renamed from: s, reason: collision with root package name */
    private int f15744s;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @VisibleForTesting
    static class a extends com.bumptech.glide.request.target.e<Bitmap> {

        /* renamed from: d, reason: collision with root package name */
        private final Handler f15745d;

        /* renamed from: e, reason: collision with root package name */
        final int f15746e;

        /* renamed from: f, reason: collision with root package name */
        private final long f15747f;

        /* renamed from: g, reason: collision with root package name */
        private Bitmap f15748g;

        @Override // com.bumptech.glide.request.target.p
        public void g(@Nullable Drawable drawable) {
            this.f15748g = null;
        }

        Bitmap a() {
            return this.f15748g;
        }

        @Override // com.bumptech.glide.request.target.p
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void h(@NonNull Bitmap bitmap, @Nullable com.bumptech.glide.request.transition.f<? super Bitmap> fVar) {
            this.f15748g = bitmap;
            this.f15745d.sendMessageAtTime(this.f15745d.obtainMessage(1, this), this.f15747f);
        }

        a(Handler handler, int i6, long j6) {
            this.f15745d = handler;
            this.f15746e = i6;
            this.f15747f = j6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        void a();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class c implements Handler.Callback {

        /* renamed from: b, reason: collision with root package name */
        static final int f15749b = 1;

        /* renamed from: c, reason: collision with root package name */
        static final int f15750c = 2;

        c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i6 = message.what;
            if (i6 == 1) {
                f.this.o((a) message.obj);
                return true;
            }
            if (i6 != 2) {
                return false;
            }
            f.this.f15729d.z((a) message.obj);
            return false;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @VisibleForTesting
    interface d {
        void a();
    }

    f(com.bumptech.glide.b bVar, GifDecoder gifDecoder, int i6, int i7, com.bumptech.glide.load.i<Bitmap> iVar, Bitmap bitmap) {
        this(bVar.h(), com.bumptech.glide.b.D(bVar.getContext()), gifDecoder, null, k(com.bumptech.glide.b.D(bVar.getContext()), i6, i7), iVar, bitmap);
    }

    private void u() {
        this.f15731f = false;
    }

    private static com.bumptech.glide.load.c g() {
        return new com.bumptech.glide.signature.e(Double.valueOf(Math.random()));
    }

    private void n() {
        if (!this.f15731f || this.f15732g) {
            return;
        }
        if (this.f15733h) {
            k.a(this.f15740o == null, "Pending target must be null when starting from the first frame");
            this.f15726a.d();
            this.f15733h = false;
        }
        a aVar = this.f15740o;
        if (aVar != null) {
            this.f15740o = null;
            o(aVar);
            return;
        }
        this.f15732g = true;
        long uptimeMillis = SystemClock.uptimeMillis() + this.f15726a.m();
        this.f15726a.i();
        this.f15737l = new a(this.f15727b, this.f15726a.e(), uptimeMillis);
        this.f15734i.b(com.bumptech.glide.request.h.q1(g())).i(this.f15726a).j1(this.f15737l);
    }

    private void p() {
        Bitmap bitmap = this.f15738m;
        if (bitmap != null) {
            this.f15730e.d(bitmap);
            this.f15738m = null;
        }
    }

    private void t() {
        if (this.f15731f) {
            return;
        }
        this.f15731f = true;
        this.f15736k = false;
        n();
    }

    void a() {
        this.f15728c.clear();
        p();
        u();
        a aVar = this.f15735j;
        if (aVar != null) {
            this.f15729d.z(aVar);
            this.f15735j = null;
        }
        a aVar2 = this.f15737l;
        if (aVar2 != null) {
            this.f15729d.z(aVar2);
            this.f15737l = null;
        }
        a aVar3 = this.f15740o;
        if (aVar3 != null) {
            this.f15729d.z(aVar3);
            this.f15740o = null;
        }
        this.f15726a.clear();
        this.f15736k = true;
    }

    ByteBuffer b() {
        return this.f15726a.getData().asReadOnlyBuffer();
    }

    Bitmap c() {
        a aVar = this.f15735j;
        return aVar != null ? aVar.a() : this.f15738m;
    }

    int d() {
        a aVar = this.f15735j;
        if (aVar != null) {
            return aVar.f15746e;
        }
        return -1;
    }

    Bitmap e() {
        return this.f15738m;
    }

    int f() {
        return this.f15726a.j();
    }

    com.bumptech.glide.load.i<Bitmap> h() {
        return this.f15739n;
    }

    int i() {
        return this.f15744s;
    }

    int j() {
        return this.f15726a.l();
    }

    int l() {
        return this.f15726a.g() + this.f15742q;
    }

    int m() {
        return this.f15743r;
    }

    @VisibleForTesting
    void o(a aVar) {
        d dVar = this.f15741p;
        if (dVar != null) {
            dVar.a();
        }
        this.f15732g = false;
        if (this.f15736k) {
            this.f15727b.obtainMessage(2, aVar).sendToTarget();
            return;
        }
        if (!this.f15731f) {
            if (this.f15733h) {
                this.f15727b.obtainMessage(2, aVar).sendToTarget();
                return;
            } else {
                this.f15740o = aVar;
                return;
            }
        }
        if (aVar.a() != null) {
            p();
            a aVar2 = this.f15735j;
            this.f15735j = aVar;
            for (int size = this.f15728c.size() - 1; size >= 0; size--) {
                this.f15728c.get(size).a();
            }
            if (aVar2 != null) {
                this.f15727b.obtainMessage(2, aVar2).sendToTarget();
            }
        }
        n();
    }

    void r() {
        k.a(!this.f15731f, "Can't restart a running animation");
        this.f15733h = true;
        a aVar = this.f15740o;
        if (aVar != null) {
            this.f15729d.z(aVar);
            this.f15740o = null;
        }
    }

    @VisibleForTesting
    void s(@Nullable d dVar) {
        this.f15741p = dVar;
    }

    void v(b bVar) {
        if (this.f15736k) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        }
        if (this.f15728c.contains(bVar)) {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        boolean isEmpty = this.f15728c.isEmpty();
        this.f15728c.add(bVar);
        if (isEmpty) {
            t();
        }
    }

    void w(b bVar) {
        this.f15728c.remove(bVar);
        if (this.f15728c.isEmpty()) {
            u();
        }
    }

    private static com.bumptech.glide.h<Bitmap> k(com.bumptech.glide.i iVar, int i6, int i7) {
        return iVar.u().b(com.bumptech.glide.request.h.Z0(j.f15240b).S0(true).I0(true).x0(i6, i7));
    }

    void q(com.bumptech.glide.load.i<Bitmap> iVar, Bitmap bitmap) {
        this.f15739n = (com.bumptech.glide.load.i) k.d(iVar);
        this.f15738m = (Bitmap) k.d(bitmap);
        this.f15734i = this.f15734i.b(new com.bumptech.glide.request.h().L0(iVar));
        this.f15742q = l.h(bitmap);
        this.f15743r = bitmap.getWidth();
        this.f15744s = bitmap.getHeight();
    }

    f(com.bumptech.glide.load.engine.bitmap_recycle.e eVar, com.bumptech.glide.i iVar, GifDecoder gifDecoder, Handler handler, com.bumptech.glide.h<Bitmap> hVar, com.bumptech.glide.load.i<Bitmap> iVar2, Bitmap bitmap) {
        this.f15728c = new ArrayList();
        this.f15729d = iVar;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new c()) : handler;
        this.f15730e = eVar;
        this.f15727b = handler;
        this.f15734i = hVar;
        this.f15726a = gifDecoder;
        q(iVar2, bitmap);
    }
}
