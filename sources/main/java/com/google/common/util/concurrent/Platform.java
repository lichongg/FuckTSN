package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible(emulated = true)
/* loaded from: D:\Downloads\app\classes5.dex */
final class Platform {
    private Platform() {
    }

    static boolean isInstanceOfThrowableClass(@NullableDecl Throwable th, Class<? extends Throwable> cls) {
        return cls.isInstance(th);
    }
}
