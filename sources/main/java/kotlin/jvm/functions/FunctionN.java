package kotlin.jvm.functions;

import kotlin.SinceKotlin;
import kotlin.jvm.internal.c0;
import kotlin.n;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "1.3")
/* loaded from: D:\Downloads\app\classes8.dex */
public interface FunctionN<R> extends n<R>, c0<R> {
    @Override // kotlin.jvm.internal.c0
    int getArity();

    R invoke(@NotNull Object... objArr);
}
