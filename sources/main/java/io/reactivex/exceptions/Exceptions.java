package io.reactivex.exceptions;

import io.reactivex.internal.util.ExceptionHelper;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class Exceptions {
    public static void throwIfFatal(Throwable th) {
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        }
        if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        }
        if (th instanceof LinkageError) {
            throw ((LinkageError) th);
        }
    }

    private Exceptions() {
        throw new IllegalStateException("No instances!");
    }

    public static RuntimeException propagate(Throwable th) {
        throw ExceptionHelper.wrapOrThrow(th);
    }
}
