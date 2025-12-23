package com.kwad.sdk.utils;

import android.content.Context;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class l<T> {
    protected boolean aYS = false;
    protected boolean enable;

    @Nullable
    protected abstract T cD(Context context);

    @Nullable
    public final T cC(Context context) {
        if (!this.enable || this.aYS) {
            return null;
        }
        try {
            return cD(context);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return null;
        }
    }

    public final void ca(boolean z5) {
        this.enable = z5;
    }

    public l(boolean z5) {
        this.enable = z5;
    }
}
