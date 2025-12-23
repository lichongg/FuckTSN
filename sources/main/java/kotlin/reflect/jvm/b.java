package kotlin.reflect.jvm;

import kotlin.jvm.JvmName;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.h0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "KClassesJvm")
/* loaded from: D:\Downloads\app\classes8.dex */
public final class b {
    @NotNull
    public static final String a(@NotNull kotlin.reflect.d<?> dVar) {
        g0.p(dVar, "<this>");
        String name = ((h0) dVar).c().getName();
        g0.o(name, "getName(...)");
        return name;
    }
}
