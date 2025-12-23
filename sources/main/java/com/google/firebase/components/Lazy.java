package com.google.firebase.components;

import androidx.annotation.VisibleForTesting;
import com.google.firebase.inject.Provider;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class Lazy<T> implements Provider<T> {
    private static final Object UNINITIALIZED = new Object();
    private volatile Object instance;
    private volatile Provider<T> provider;

    Lazy(T t5) {
        this.instance = UNINITIALIZED;
        this.instance = t5;
    }

    @Override // com.google.firebase.inject.Provider
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
                    this.instance = t5;
                    this.provider = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return t5;
    }

    @VisibleForTesting
    boolean isInitialized() {
        return this.instance != UNINITIALIZED;
    }

    public Lazy(Provider<T> provider) {
        this.instance = UNINITIALIZED;
        this.provider = provider;
    }
}
