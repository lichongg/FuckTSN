package com.bumptech.glide.load.engine.cache;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
final class c {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, a> f15077a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final b f15078b = new b();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b {

        /* renamed from: b, reason: collision with root package name */
        private static final int f15081b = 10;

        /* renamed from: a, reason: collision with root package name */
        private final Queue<a> f15082a = new ArrayDeque();

        a a() {
            a poll;
            synchronized (this.f15082a) {
                poll = this.f15082a.poll();
            }
            return poll == null ? new a() : poll;
        }

        void b(a aVar) {
            synchronized (this.f15082a) {
                try {
                    if (this.f15082a.size() < 10) {
                        this.f15082a.offer(aVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        b() {
        }
    }

    void a(String str) {
        a aVar;
        synchronized (this) {
            try {
                aVar = this.f15077a.get(str);
                if (aVar == null) {
                    aVar = this.f15078b.a();
                    this.f15077a.put(str, aVar);
                }
                aVar.f15080b++;
            } catch (Throwable th) {
                throw th;
            }
        }
        aVar.f15079a.lock();
    }

    void b(String str) {
        a aVar;
        synchronized (this) {
            try {
                aVar = (a) com.bumptech.glide.util.k.d(this.f15077a.get(str));
                int i6 = aVar.f15080b;
                if (i6 < 1) {
                    throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + aVar.f15080b);
                }
                int i7 = i6 - 1;
                aVar.f15080b = i7;
                if (i7 == 0) {
                    a remove = this.f15077a.remove(str);
                    if (!remove.equals(aVar)) {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + remove + ", safeKey: " + str);
                    }
                    this.f15078b.b(remove);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        aVar.f15079a.unlock();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        final Lock f15079a = new ReentrantLock();

        /* renamed from: b, reason: collision with root package name */
        int f15080b;

        a() {
        }
    }

    c() {
    }
}
