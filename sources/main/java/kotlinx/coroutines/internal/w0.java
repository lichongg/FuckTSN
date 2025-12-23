package kotlinx.coroutines.internal;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final /* synthetic */ class w0 {

    /* renamed from: a, reason: collision with root package name */
    private static final int f49314a = Runtime.getRuntime().availableProcessors();

    public static final int a() {
        return f49314a;
    }

    @Nullable
    public static final String b(@NotNull String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }
}
