package kotlin.uuid;

import java.security.SecureRandom;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f48058a = new a();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final SecureRandom f48059b = new SecureRandom();

    @NotNull
    public final SecureRandom a() {
        return f48059b;
    }

    private a() {
    }
}
