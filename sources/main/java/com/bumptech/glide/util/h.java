package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class h<T, Y> {

    /* renamed from: a, reason: collision with root package name */
    private final Map<T, a<Y>> f16330a = new LinkedHashMap(100, 0.75f, true);

    /* renamed from: b, reason: collision with root package name */
    private final long f16331b;

    /* renamed from: c, reason: collision with root package name */
    private long f16332c;

    /* renamed from: d, reason: collision with root package name */
    private long f16333d;

    public synchronized void c(float f6) {
        if (f6 < 0.0f) {
            throw new IllegalArgumentException("Multiplier must be >= 0");
        }
        this.f16332c = Math.round(this.f16331b * f6);
        h();
    }

    public synchronized boolean g(@NonNull T t5) {
        return this.f16330a.containsKey(t5);
    }

    public synchronized long getCurrentSize() {
        return this.f16333d;
    }

    public synchronized long getMaxSize() {
        return this.f16332c;
    }

    @Nullable
    public synchronized Y i(@NonNull T t5) {
        a<Y> aVar;
        aVar = this.f16330a.get(t5);
        return aVar != null ? aVar.f16334a : null;
    }

    protected synchronized int j() {
        return this.f16330a.size();
    }

    protected int k(@Nullable Y y5) {
        return 1;
    }

    @Nullable
    public synchronized Y m(@NonNull T t5, @Nullable Y y5) {
        int k6 = k(y5);
        long j6 = k6;
        if (j6 >= this.f16332c) {
            l(t5, y5);
            return null;
        }
        if (y5 != null) {
            this.f16333d += j6;
        }
        a<Y> put = this.f16330a.put(t5, y5 == null ? null : new a<>(y5, k6));
        if (put != null) {
            this.f16333d -= put.f16335b;
            if (!put.f16334a.equals(y5)) {
                l(t5, put.f16334a);
            }
        }
        h();
        return put != null ? put.f16334a : null;
    }

    @Nullable
    public synchronized Y n(@NonNull T t5) {
        a<Y> remove = this.f16330a.remove(t5);
        if (remove == null) {
            return null;
        }
        this.f16333d -= remove.f16335b;
        return remove.f16334a;
    }

    protected synchronized void o(long j6) {
        while (this.f16333d > j6) {
            Iterator<Map.Entry<T, a<Y>>> it = this.f16330a.entrySet().iterator();
            Map.Entry<T, a<Y>> next = it.next();
            a<Y> value = next.getValue();
            this.f16333d -= value.f16335b;
            T key = next.getKey();
            it.remove();
            l(key, value.f16334a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<Y> {

        /* renamed from: a, reason: collision with root package name */
        final Y f16334a;

        /* renamed from: b, reason: collision with root package name */
        final int f16335b;

        a(Y y5, int i6) {
            this.f16334a = y5;
            this.f16335b = i6;
        }
    }

    private void h() {
        o(this.f16332c);
    }

    public void b() {
        o(0L);
    }

    public h(long j6) {
        this.f16331b = j6;
        this.f16332c = j6;
    }

    protected void l(@NonNull T t5, @Nullable Y y5) {
    }
}
