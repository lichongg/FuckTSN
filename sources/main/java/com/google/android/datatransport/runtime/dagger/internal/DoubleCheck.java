package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.Lazy;
import javax.inject.Provider;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class DoubleCheck<T> implements Provider<T>, Lazy<T> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Object UNINITIALIZED = new Object();
    private volatile Object instance = UNINITIALIZED;
    private volatile Provider<T> provider;

    public static <P extends Provider<T>, T> Lazy<T> lazy(P p5) {
        return p5 instanceof Lazy ? (Lazy) p5 : new DoubleCheck((Provider) Preconditions.checkNotNull(p5));
    }

    public static Object reentrantCheck(Object obj, Object obj2) {
        if (obj == UNINITIALIZED || (obj instanceof MemoizedSentinel)) {
            return obj2;
        }
        if (obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    @Override // javax.inject.Provider
    public T get() {
        T t5;
        T t6 = (T) this.instance;
        Object obj = UNINITIALIZED;
        if (t6 != obj) {
            return t6;
        }
        synchronized (this) {
            try {
                t5 = (T) this.instance;
                if (t5 == obj) {
                    t5 = this.provider.get();
                    this.instance = reentrantCheck(this.instance, t5);
                    this.provider = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return t5;
    }

    private DoubleCheck(Provider<T> provider) {
        this.provider = provider;
    }

    public static <P extends Provider<T>, T> Provider<T> provider(P p5) {
        Preconditions.checkNotNull(p5);
        if (p5 instanceof DoubleCheck) {
            return p5;
        }
        return new DoubleCheck(p5);
    }
}
