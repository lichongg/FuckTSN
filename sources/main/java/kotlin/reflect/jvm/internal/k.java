package kotlin.reflect.jvm.internal;

import java.lang.ref.SoftReference;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nCacheByClass.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CacheByClass.kt\nkotlin/reflect/jvm/internal/ClassValueCache\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,98:1\n1#2:99\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
final class k<V> extends a<V> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private volatile l<V> f47509a;

    public k(@NotNull Function1<? super Class<?>, ? extends V> compute) {
        kotlin.jvm.internal.g0.p(compute, "compute");
        this.f47509a = new l<>(compute);
    }

    @Override // kotlin.reflect.jvm.internal.a
    public void a() {
        this.f47509a = this.f47509a.b();
    }

    @Override // kotlin.reflect.jvm.internal.a
    public V b(@NotNull Class<?> key) {
        Object obj;
        Object obj2;
        kotlin.jvm.internal.g0.p(key, "key");
        l<V> lVar = this.f47509a;
        obj = lVar.get(key);
        V v5 = (V) ((SoftReference) obj).get();
        if (v5 != null) {
            return v5;
        }
        lVar.remove(key);
        obj2 = lVar.get(key);
        V v6 = (V) ((SoftReference) obj2).get();
        return v6 != null ? v6 : lVar.f47515a.invoke(key);
    }
}
