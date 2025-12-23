package com.google.firebase.components;

import com.google.firebase.inject.Provider;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
class LazySet<T> implements Provider<Set<T>> {
    private volatile Set<T> actualSet = null;
    private volatile Set<Provider<T>> providers = Collections.newSetFromMap(new ConcurrentHashMap());

    private synchronized void updateSet() {
        try {
            Iterator<Provider<T>> it = this.providers.iterator();
            while (it.hasNext()) {
                this.actualSet.add(it.next().get());
            }
            this.providers = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    synchronized void add(Provider<T> provider) {
        try {
            if (this.actualSet == null) {
                this.providers.add(provider);
            } else {
                this.actualSet.add(provider.get());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    static LazySet<?> fromCollection(Collection<Provider<?>> collection) {
        return new LazySet<>((Set) collection);
    }

    @Override // com.google.firebase.inject.Provider
    public Set<T> get() {
        if (this.actualSet == null) {
            synchronized (this) {
                try {
                    if (this.actualSet == null) {
                        this.actualSet = Collections.newSetFromMap(new ConcurrentHashMap());
                        updateSet();
                    }
                } finally {
                }
            }
        }
        return Collections.unmodifiableSet(this.actualSet);
    }

    LazySet(Collection<Provider<T>> collection) {
        this.providers.addAll(collection);
    }
}
