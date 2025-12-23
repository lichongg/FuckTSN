package androidx.collection;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class LruCacheKt {
    @NotNull
    public static final <K, V> LruCache<K, V> lruCache(int i6, @NotNull Function2<? super K, ? super V, Integer> sizeOf, @NotNull Function1<? super K, ? extends V> create, @NotNull Function4<? super Boolean, ? super K, ? super V, ? super V, n1> onEntryRemoved) {
        g0.p(sizeOf, "sizeOf");
        g0.p(create, "create");
        g0.p(onEntryRemoved, "onEntryRemoved");
        return new LruCacheKt$lruCache$4(i6, sizeOf, create, onEntryRemoved);
    }

    public static /* synthetic */ LruCache lruCache$default(int i6, Function2 sizeOf, Function1 create, Function4 onEntryRemoved, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            sizeOf = new Function2<Object, Object, Integer>() { // from class: androidx.collection.LruCacheKt$lruCache$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function2
                @NotNull
                public final Integer invoke(@NotNull Object obj2, @NotNull Object obj3) {
                    g0.p(obj2, "<anonymous parameter 0>");
                    g0.p(obj3, "<anonymous parameter 1>");
                    return 1;
                }
            };
        }
        if ((i7 & 4) != 0) {
            create = new Function1<Object, Object>() { // from class: androidx.collection.LruCacheKt$lruCache$2
                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Object invoke(@NotNull Object it) {
                    g0.p(it, "it");
                    return null;
                }
            };
        }
        if ((i7 & 8) != 0) {
            onEntryRemoved = new Function4<Boolean, Object, Object, Object, n1>() { // from class: androidx.collection.LruCacheKt$lruCache$3
                public final void invoke(boolean z5, @NotNull Object obj2, @NotNull Object obj3, @Nullable Object obj4) {
                    g0.p(obj2, "<anonymous parameter 1>");
                    g0.p(obj3, "<anonymous parameter 2>");
                }

                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ n1 invoke(Boolean bool, Object obj2, Object obj3, Object obj4) {
                    invoke(bool.booleanValue(), obj2, obj3, obj4);
                    return n1.f44123a;
                }
            };
        }
        g0.p(sizeOf, "sizeOf");
        g0.p(create, "create");
        g0.p(onEntryRemoved, "onEntryRemoved");
        return new LruCacheKt$lruCache$4(i6, sizeOf, create, onEntryRemoved);
    }
}
