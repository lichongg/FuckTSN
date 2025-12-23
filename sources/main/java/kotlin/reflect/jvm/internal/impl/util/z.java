package kotlin.reflect.jvm.internal.impl.util;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class z<K, V> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final ConcurrentHashMap<String, Integer> f47466a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final AtomicInteger f47467b = new AtomicInteger(0);

    public abstract int c(@NotNull ConcurrentHashMap<String, Integer> concurrentHashMap, @NotNull String str, @NotNull Function1<? super String, Integer> function1);

    /* JADX INFO: Access modifiers changed from: private */
    public static final int g(z zVar, String it) {
        g0.p(it, "it");
        return zVar.f47467b.getAndIncrement();
    }

    @NotNull
    public final Map<String, Integer> b() {
        return this.f47466a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final <T extends V, KK extends K> n<K, V, T> d(@NotNull kotlin.reflect.d<KK> kClass) {
        g0.p(kClass, "kClass");
        return new n<>(f(kClass));
    }

    public final int e(@NotNull String keyQualifiedName) {
        g0.p(keyQualifiedName, "keyQualifiedName");
        return c(this.f47466a, keyQualifiedName, new y(this));
    }

    public final <T extends K> int f(@NotNull kotlin.reflect.d<T> kClass) {
        g0.p(kClass, "kClass");
        String x5 = kClass.x();
        g0.m(x5);
        return e(x5);
    }

    @NotNull
    protected final Collection<Integer> h() {
        Collection<Integer> values = this.f47466a.values();
        g0.o(values, "<get-values>(...)");
        return values;
    }
}
