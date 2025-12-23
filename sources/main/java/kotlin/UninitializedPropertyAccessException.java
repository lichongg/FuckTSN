package kotlin;

import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class UninitializedPropertyAccessException extends RuntimeException {
    public UninitializedPropertyAccessException() {
    }

    public UninitializedPropertyAccessException(@Nullable String str) {
        super(str);
    }

    public UninitializedPropertyAccessException(@Nullable String str, @Nullable Throwable th) {
        super(str, th);
    }

    public UninitializedPropertyAccessException(@Nullable Throwable th) {
        super(th);
    }
}
