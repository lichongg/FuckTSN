package kotlin.jvm;

import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class KotlinReflectionNotSupportedError extends Error {
    public KotlinReflectionNotSupportedError() {
        super("Kotlin reflection implementation is not found at runtime. Make sure you have kotlin-reflect.jar in the classpath");
    }

    public KotlinReflectionNotSupportedError(@Nullable String str) {
        super(str);
    }

    public KotlinReflectionNotSupportedError(@Nullable String str, @Nullable Throwable th) {
        super(str, th);
    }

    public KotlinReflectionNotSupportedError(@Nullable Throwable th) {
        super(th);
    }
}
