package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public class UncheckedExecutionException extends RuntimeException {
    private static final long serialVersionUID = 0;

    protected UncheckedExecutionException() {
    }

    protected UncheckedExecutionException(@NullableDecl String str) {
        super(str);
    }

    public UncheckedExecutionException(@NullableDecl String str, @NullableDecl Throwable th) {
        super(str, th);
    }

    public UncheckedExecutionException(@NullableDecl Throwable th) {
        super(th);
    }
}
