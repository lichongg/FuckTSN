package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.Lazy;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class InstanceFactory<T> implements Factory<T>, Lazy<T> {
    private static final InstanceFactory<Object> NULL_INSTANCE_FACTORY = new InstanceFactory<>(null);
    private final T instance;

    public static <T> Factory<T> create(T t5) {
        return new InstanceFactory(Preconditions.checkNotNull(t5, "instance cannot be null"));
    }

    public static <T> Factory<T> createNullable(T t5) {
        return t5 == null ? nullInstanceFactory() : new InstanceFactory(t5);
    }

    private static <T> InstanceFactory<T> nullInstanceFactory() {
        return (InstanceFactory<T>) NULL_INSTANCE_FACTORY;
    }

    @Override // javax.inject.Provider
    public T get() {
        return this.instance;
    }

    private InstanceFactory(T t5) {
        this.instance = t5;
    }
}
