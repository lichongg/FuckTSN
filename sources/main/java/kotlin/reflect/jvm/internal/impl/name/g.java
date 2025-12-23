package kotlin.reflect.jvm.internal.impl.name;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.g0;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f46352a = new g();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Regex f46353b = new Regex("[^\\p{L}\\p{Digit}]");

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final String f46354c = "$context_receiver";

    @JvmStatic
    @NotNull
    public static final f a(int i6) {
        f h6 = f.h(f46354c + '_' + i6);
        g0.o(h6, "identifier(...)");
        return h6;
    }

    @JvmStatic
    @NotNull
    public static final String b(@NotNull String name) {
        g0.p(name, "name");
        return f46353b.replace(name, "_");
    }

    private g() {
    }
}
