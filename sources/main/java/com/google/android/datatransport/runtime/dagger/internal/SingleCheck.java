package com.google.android.datatransport.runtime.dagger.internal;

import javax.inject.Provider;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class SingleCheck<T> implements Provider<T> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Object UNINITIALIZED = new Object();
    private volatile Object instance = UNINITIALIZED;
    private volatile Provider<T> provider;

    public static <P extends Provider<T>, T> Provider<T> provider(P p5) {
        return !(p5 instanceof SingleCheck) ? p5 instanceof DoubleCheck ? p5 : new SingleCheck((Provider) Preconditions.checkNotNull(p5)) : p5;
    }

    @Override // javax.inject.Provider
    public T get() {
        T t5 = (T) this.instance;
        if (t5 != UNINITIALIZED) {
            return t5;
        }
        Provider<T> provider = this.provider;
        if (provider == null) {
            return (T) this.instance;
        }
        T t6 = provider.get();
        this.instance = t6;
        this.provider = null;
        return t6;
    }

    private SingleCheck(Provider<T> provider) {
        this.provider = provider;
    }
}
