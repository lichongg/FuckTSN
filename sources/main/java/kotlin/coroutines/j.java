package kotlin.coroutines;

import kotlin.ExperimentalStdlibApi;
import kotlin.SinceKotlin;
import kotlin.coroutines.i;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class j {
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @Nullable
    public static final <E extends i.b> E a(@NotNull i.b bVar, @NotNull i.c<E> key) {
        g0.p(bVar, "<this>");
        g0.p(key, "key");
        if (!(key instanceof b)) {
            if (bVar.getKey() == key) {
                return bVar;
            }
            return null;
        }
        b bVar2 = (b) key;
        if (bVar2.a(bVar.getKey())) {
            E e6 = (E) bVar2.b(bVar);
            if (androidx.activity.k.a(e6)) {
                return e6;
            }
        }
        return null;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @NotNull
    public static final i b(@NotNull i.b bVar, @NotNull i.c<?> key) {
        g0.p(bVar, "<this>");
        g0.p(key, "key");
        if (!(key instanceof b)) {
            return bVar.getKey() == key ? EmptyCoroutineContext.INSTANCE : bVar;
        }
        b bVar2 = (b) key;
        return (!bVar2.a(bVar.getKey()) || bVar2.b(bVar) == null) ? bVar : EmptyCoroutineContext.INSTANCE;
    }
}
