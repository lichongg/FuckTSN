package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtIncompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public class UncheckedTimeoutException extends RuntimeException {
    private static final long serialVersionUID = 0;

    public UncheckedTimeoutException() {
    }

    public UncheckedTimeoutException(@NullableDecl String str) {
        super(str);
    }

    public UncheckedTimeoutException(@NullableDecl Throwable th) {
        super(th);
    }

    public UncheckedTimeoutException(@NullableDecl String str, @NullableDecl Throwable th) {
        super(str, th);
    }
}
