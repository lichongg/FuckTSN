package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.b;
import com.bumptech.glide.request.target.k;
import com.bumptech.glide.request.target.r;
import com.stub.StubApp;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class d extends ContextWrapper {

    /* renamed from: k, reason: collision with root package name */
    @VisibleForTesting
    static final j<?, ?> f14724k = new a();

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.b f14725a;

    /* renamed from: b, reason: collision with root package name */
    private final Registry f14726b;

    /* renamed from: c, reason: collision with root package name */
    private final k f14727c;

    /* renamed from: d, reason: collision with root package name */
    private final b.a f14728d;

    /* renamed from: e, reason: collision with root package name */
    private final List<com.bumptech.glide.request.g<Object>> f14729e;

    /* renamed from: f, reason: collision with root package name */
    private final Map<Class<?>, j<?, ?>> f14730f;

    /* renamed from: g, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.k f14731g;

    /* renamed from: h, reason: collision with root package name */
    private final e f14732h;

    /* renamed from: i, reason: collision with root package name */
    private final int f14733i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    @GuardedBy("this")
    private com.bumptech.glide.request.h f14734j;

    public synchronized com.bumptech.glide.request.h d() {
        try {
            if (this.f14734j == null) {
                this.f14734j = this.f14728d.build().m0();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f14734j;
    }

    @NonNull
    public <X> r<ImageView, X> a(@NonNull ImageView imageView, @NonNull Class<X> cls) {
        return this.f14727c.a(imageView, cls);
    }

    @NonNull
    public com.bumptech.glide.load.engine.bitmap_recycle.b b() {
        return this.f14725a;
    }

    public List<com.bumptech.glide.request.g<Object>> c() {
        return this.f14729e;
    }

    @NonNull
    public <T> j<?, T> e(@NonNull Class<T> cls) {
        j<?, T> jVar = (j) this.f14730f.get(cls);
        if (jVar == null) {
            for (Map.Entry<Class<?>, j<?, ?>> entry : this.f14730f.entrySet()) {
                if (entry.getKey().isAssignableFrom(cls)) {
                    jVar = (j) entry.getValue();
                }
            }
        }
        return jVar == null ? (j<?, T>) f14724k : jVar;
    }

    @NonNull
    public com.bumptech.glide.load.engine.k f() {
        return this.f14731g;
    }

    public e g() {
        return this.f14732h;
    }

    public int h() {
        return this.f14733i;
    }

    @NonNull
    public Registry i() {
        return this.f14726b;
    }

    public d(@NonNull Context context, @NonNull com.bumptech.glide.load.engine.bitmap_recycle.b bVar, @NonNull Registry registry, @NonNull k kVar, @NonNull b.a aVar, @NonNull Map<Class<?>, j<?, ?>> map, @NonNull List<com.bumptech.glide.request.g<Object>> list, @NonNull com.bumptech.glide.load.engine.k kVar2, @NonNull e eVar, int i6) {
        super(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        this.f14725a = bVar;
        this.f14726b = registry;
        this.f14727c = kVar;
        this.f14728d = aVar;
        this.f14729e = list;
        this.f14730f = map;
        this.f14731g = kVar2;
        this.f14732h = eVar;
        this.f14733i = i6;
    }
}
