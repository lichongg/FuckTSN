package i4;

import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "ProcessKt")
/* loaded from: D:\Downloads\app\classes7.dex */
public final class a {
    @InlineOnly
    private static final Void a(int i6) {
        System.exit(i6);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }
}
