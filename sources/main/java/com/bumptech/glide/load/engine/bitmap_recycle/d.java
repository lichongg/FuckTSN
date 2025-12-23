package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.load.engine.bitmap_recycle.n;
import java.util.Queue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
abstract class d<T extends n> {

    /* renamed from: b, reason: collision with root package name */
    private static final int f15012b = 20;

    /* renamed from: a, reason: collision with root package name */
    private final Queue<T> f15013a = com.bumptech.glide.util.l.f(20);

    abstract T a();

    T b() {
        T poll = this.f15013a.poll();
        return poll == null ? a() : poll;
    }

    public void c(T t5) {
        if (this.f15013a.size() < 20) {
            this.f15013a.offer(t5);
        }
    }

    d() {
    }
}
