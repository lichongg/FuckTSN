package com.google.firebase.components;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
class OptionalProvider<T> implements Provider<T>, Deferred<T> {
    private static final Provider<Object> EMPTY_PROVIDER;
    private static final Deferred.DeferredHandler<Object> NOOP_HANDLER;
    private volatile Provider<T> delegate;

    @GuardedBy("this")
    private Deferred.DeferredHandler<T> handler;

    static /* synthetic */ Object lambda$static$1() {
        return null;
    }

    static <T> OptionalProvider<T> empty() {
        return new OptionalProvider<>(NOOP_HANDLER, EMPTY_PROVIDER);
    }

    static <T> OptionalProvider<T> of(Provider<T> provider) {
        return new OptionalProvider<>(null, provider);
    }

    @Override // com.google.firebase.inject.Provider
    public T get() {
        return this.delegate.get();
    }

    void set(Provider<T> provider) {
        Deferred.DeferredHandler<T> deferredHandler;
        if (this.delegate != EMPTY_PROVIDER) {
            throw new IllegalStateException("provide() can be called only once.");
        }
        synchronized (this) {
            deferredHandler = this.handler;
            this.handler = null;
            this.delegate = provider;
        }
        deferredHandler.handle(provider);
    }

    @Override // com.google.firebase.inject.Deferred
    public void whenAvailable(@NonNull Deferred.DeferredHandler<T> deferredHandler) {
        Provider<T> provider;
        Provider<T> provider2;
        Provider<T> provider3 = this.delegate;
        Provider<Object> provider4 = EMPTY_PROVIDER;
        if (provider3 != provider4) {
            deferredHandler.handle(provider3);
            return;
        }
        synchronized (this) {
            provider = this.delegate;
            if (provider != provider4) {
                provider2 = provider;
            } else {
                this.handler = OptionalProvider$$Lambda$1.lambdaFactory$(this.handler, deferredHandler);
                provider2 = null;
            }
        }
        if (provider2 != null) {
            deferredHandler.handle(provider);
        }
    }

    static {
        Deferred.DeferredHandler<Object> deferredHandler;
        deferredHandler = OptionalProvider$$Lambda$4.instance;
        NOOP_HANDLER = deferredHandler;
        EMPTY_PROVIDER = OptionalProvider$$Lambda$5.instance;
    }

    private OptionalProvider(Deferred.DeferredHandler<T> deferredHandler, Provider<T> provider) {
        this.handler = deferredHandler;
        this.delegate = provider;
    }

    static /* synthetic */ void lambda$whenAvailable$2(Deferred.DeferredHandler deferredHandler, Deferred.DeferredHandler deferredHandler2, Provider provider) {
        deferredHandler.handle(provider);
        deferredHandler2.handle(provider);
    }

    static /* synthetic */ void lambda$static$0(Provider provider) {
    }
}
