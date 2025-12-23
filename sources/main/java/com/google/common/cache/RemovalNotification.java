package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.AbstractMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public final class RemovalNotification<K, V> extends AbstractMap.SimpleImmutableEntry<K, V> {
    private static final long serialVersionUID = 0;
    private final RemovalCause cause;

    public static <K, V> RemovalNotification<K, V> create(@NullableDecl K k6, @NullableDecl V v5, RemovalCause removalCause) {
        return new RemovalNotification<>(k6, v5, removalCause);
    }

    public RemovalCause getCause() {
        return this.cause;
    }

    public boolean wasEvicted() {
        return this.cause.wasEvicted();
    }

    private RemovalNotification(@NullableDecl K k6, @NullableDecl V v5, RemovalCause removalCause) {
        super(k6, v5);
        this.cause = (RemovalCause) Preconditions.checkNotNull(removalCause);
    }
}
