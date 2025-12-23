package io.netty.resolver.dns;

import androidx.concurrent.futures.a;
import io.netty.channel.EventLoop;
import io.netty.util.internal.PlatformDependent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
abstract class Cache<E> {
    private final ConcurrentMap<String, Cache<E>.Entries> resolveCache = PlatformDependent.newConcurrentHashMap();
    private static final AtomicReferenceFieldUpdater<Entries, ScheduledFuture> FUTURE_UPDATER = AtomicReferenceFieldUpdater.newUpdater(Entries.class, ScheduledFuture.class, "expirationFuture");
    private static final ScheduledFuture<?> CANCELLED = new ScheduledFuture<Object>() { // from class: io.netty.resolver.dns.Cache.1
        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z5) {
            return false;
        }

        @Override // java.util.concurrent.Future
        public Object get() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return true;
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return true;
        }

        @Override // java.lang.Comparable
        public int compareTo(Delayed delayed) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.concurrent.Future
        public Object get(long j6, TimeUnit timeUnit) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.concurrent.Delayed
        public long getDelay(TimeUnit timeUnit) {
            return Long.MIN_VALUE;
        }
    };
    static final int MAX_SUPPORTED_TTL_SECS = (int) TimeUnit.DAYS.toSeconds(730);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class Entries extends AtomicReference<List<E>> implements Runnable {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        volatile ScheduledFuture<?> expirationFuture;
        private final String hostname;

        Entries(String str) {
            super(Collections.EMPTY_LIST);
            this.hostname = str;
        }

        void add(E e6, int i6, EventLoop eventLoop) {
            E e7;
            if (Cache.this.shouldReplaceAll(e6)) {
                set(Collections.singletonList(e6));
                scheduleCacheExpirationIfNeeded(i6, eventLoop);
                return;
            }
            while (true) {
                List<E> list = get();
                if (!list.isEmpty()) {
                    int i7 = 0;
                    if (!Cache.this.shouldReplaceAll(list.get(0))) {
                        ArrayList arrayList = new ArrayList(list.size() + 1);
                        while (true) {
                            e7 = list.get(i7);
                            if (Cache.this.equals(e6, e7)) {
                                arrayList.add(e6);
                                while (true) {
                                    i7++;
                                    if (i7 >= list.size()) {
                                        break;
                                    } else {
                                        arrayList.add(list.get(i7));
                                    }
                                }
                            } else {
                                arrayList.add(e7);
                                i7++;
                                if (i7 >= list.size()) {
                                    e7 = null;
                                    break;
                                }
                            }
                        }
                        if (e7 == null) {
                            arrayList.add(e6);
                        }
                        Cache.this.sortEntries(this.hostname, arrayList);
                        if (compareAndSet(list, Collections.unmodifiableList(arrayList))) {
                            scheduleCacheExpirationIfNeeded(i6, eventLoop);
                            return;
                        }
                    } else if (compareAndSet(list, Collections.singletonList(e6))) {
                        scheduleCacheExpirationIfNeeded(i6, eventLoop);
                        return;
                    }
                } else if (compareAndSet(list, Collections.singletonList(e6))) {
                    scheduleCacheExpirationIfNeeded(i6, eventLoop);
                    return;
                }
            }
        }

        boolean clearAndCancel() {
            if (getAndSet(Collections.EMPTY_LIST).isEmpty()) {
                return false;
            }
            ScheduledFuture scheduledFuture = (ScheduledFuture) Cache.FUTURE_UPDATER.getAndSet(this, Cache.CANCELLED);
            if (scheduledFuture == null) {
                return true;
            }
            scheduledFuture.cancel(false);
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            Cache.this.resolveCache.remove(this.hostname, this);
            clearAndCancel();
        }

        private void scheduleCacheExpirationIfNeeded(int i6, EventLoop eventLoop) {
            while (true) {
                ScheduledFuture scheduledFuture = (ScheduledFuture) Cache.FUTURE_UPDATER.get(this);
                if (scheduledFuture == null || scheduledFuture.getDelay(TimeUnit.SECONDS) > i6) {
                    io.netty.util.concurrent.ScheduledFuture<?> schedule = eventLoop.schedule((Runnable) this, i6, TimeUnit.SECONDS);
                    if (a.a(Cache.FUTURE_UPDATER, this, scheduledFuture, schedule)) {
                        if (scheduledFuture != null) {
                            scheduledFuture.cancel(true);
                            return;
                        }
                        return;
                    }
                    schedule.cancel(true);
                } else {
                    return;
                }
            }
        }
    }

    final void clear() {
        while (!this.resolveCache.isEmpty()) {
            Iterator<Map.Entry<String, Cache<E>.Entries>> it = this.resolveCache.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, Cache<E>.Entries> next = it.next();
                it.remove();
                next.getValue().clearAndCancel();
            }
        }
    }

    protected abstract boolean equals(E e6, E e7);

    protected abstract boolean shouldReplaceAll(E e6);

    final void cache(String str, E e6, int i6, EventLoop eventLoop) {
        Cache<E>.Entries putIfAbsent;
        Cache<E>.Entries entries = this.resolveCache.get(str);
        if (entries == null && (putIfAbsent = this.resolveCache.putIfAbsent(str, (entries = new Entries(str)))) != null) {
            entries = putIfAbsent;
        }
        entries.add(e6, i6, eventLoop);
    }

    final List<? extends E> get(String str) {
        Cache<E>.Entries entries = this.resolveCache.get(str);
        if (entries == null) {
            return null;
        }
        return entries.get();
    }

    final int size() {
        return this.resolveCache.size();
    }

    Cache() {
    }

    final boolean clear(String str) {
        Cache<E>.Entries remove = this.resolveCache.remove(str);
        return remove != null && remove.clearAndCancel();
    }

    protected void sortEntries(String str, List<E> list) {
    }
}
