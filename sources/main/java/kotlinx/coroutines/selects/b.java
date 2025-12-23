package kotlinx.coroutines.selects;

import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.a1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class b {
    /* JADX WARN: Multi-variable type inference failed */
    @ExperimentalCoroutinesApi
    public static final <R> void a(@NotNull c<? super R> cVar, long j6, @NotNull Function1<? super kotlin.coroutines.e<? super R>, ? extends Object> function1) {
        cVar.a(new a(j6).b(), function1);
    }

    @ExperimentalCoroutinesApi
    public static final <R> void b(@NotNull c<? super R> cVar, long j6, @NotNull Function1<? super kotlin.coroutines.e<? super R>, ? extends Object> function1) {
        a(cVar, a1.e(j6), function1);
    }
}
