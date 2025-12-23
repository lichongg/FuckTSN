package kotlin.reflect.jvm.internal;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nCacheByClass.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CacheByClass.kt\nkotlin/reflect/jvm/internal/ConcurrentHashMapCache\n+ 2 MapsJVM.kt\nkotlin/collections/MapsKt__MapsJVMKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,98:1\n72#2,2:99\n1#3:101\n*S KotlinDebug\n*F\n+ 1 CacheByClass.kt\nkotlin/reflect/jvm/internal/ConcurrentHashMapCache\n*L\n92#1:99,2\n92#1:101\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
final class m<V> extends a<V> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final Function1<Class<?>, V> f47520a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final ConcurrentHashMap<Class<?>, V> f47521b;

    /* JADX WARN: Multi-variable type inference failed */
    public m(@NotNull Function1<? super Class<?>, ? extends V> compute) {
        kotlin.jvm.internal.g0.p(compute, "compute");
        this.f47520a = compute;
        this.f47521b = new ConcurrentHashMap<>();
    }

    @Override // kotlin.reflect.jvm.internal.a
    public void a() {
        this.f47521b.clear();
    }

    @Override // kotlin.reflect.jvm.internal.a
    public V b(@NotNull Class<?> key) {
        kotlin.jvm.internal.g0.p(key, "key");
        ConcurrentHashMap<Class<?>, V> concurrentHashMap = this.f47521b;
        V v5 = (V) concurrentHashMap.get(key);
        if (v5 != null) {
            return v5;
        }
        V invoke = this.f47520a.invoke(key);
        V v6 = (V) concurrentHashMap.putIfAbsent(key, invoke);
        return v6 == null ? invoke : v6;
    }
}
