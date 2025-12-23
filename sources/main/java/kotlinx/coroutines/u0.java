package kotlinx.coroutines;

import kotlin.Result;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nDebugStrings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugStrings.kt\nkotlinx/coroutines/DebugStringsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,22:1\n1#2:23\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class u0 {
    @NotNull
    public static final String c(@NotNull kotlin.coroutines.e<?> eVar) {
        Object m130constructorimpl;
        if (eVar instanceof kotlinx.coroutines.internal.l) {
            return eVar.toString();
        }
        try {
            Result.a aVar = Result.Companion;
            m130constructorimpl = Result.m130constructorimpl(eVar + '@' + b(eVar));
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            m130constructorimpl = Result.m130constructorimpl(kotlin.g0.a(th));
        }
        if (Result.m133exceptionOrNullimpl(m130constructorimpl) != null) {
            m130constructorimpl = eVar.getClass().getName() + '@' + b(eVar);
        }
        return (String) m130constructorimpl;
    }

    @NotNull
    public static final String a(@NotNull Object obj) {
        return obj.getClass().getSimpleName();
    }

    @NotNull
    public static final String b(@NotNull Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }
}
