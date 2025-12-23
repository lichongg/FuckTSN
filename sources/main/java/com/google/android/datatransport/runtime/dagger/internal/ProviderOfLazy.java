package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.Lazy;
import javax.inject.Provider;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class ProviderOfLazy<T> implements Provider<Lazy<T>> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<T> provider;

    public static <T> Provider<Lazy<T>> create(Provider<T> provider) {
        return new ProviderOfLazy((Provider) Preconditions.checkNotNull(provider));
    }

    @Override // javax.inject.Provider
    public Lazy<T> get() {
        return DoubleCheck.lazy(this.provider);
    }

    private ProviderOfLazy(Provider<T> provider) {
        this.provider = provider;
    }
}
