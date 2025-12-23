package io.reactivex.internal.util;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class AtomicThrowable extends AtomicReference<Throwable> {
    private static final long serialVersionUID = 3949248817947090603L;

    public boolean addThrowable(Throwable th) {
        return ExceptionHelper.addThrowable(this, th);
    }

    public boolean isTerminated() {
        if (get() == ExceptionHelper.TERMINATED) {
            return true;
        }
        return false;
    }

    public Throwable terminate() {
        return ExceptionHelper.terminate(this);
    }
}
