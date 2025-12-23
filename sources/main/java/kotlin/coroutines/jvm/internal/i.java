package kotlin.coroutines.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class i {
    @SinceKotlin(version = "1.3")
    public static final void a(@NotNull Function1<? super kotlin.coroutines.e<? super n1>, ? extends Object> block) {
        g0.p(block, "block");
        h hVar = new h();
        kotlin.coroutines.g.h(block, hVar);
        hVar.b();
    }
}
