package androidx.core.util;

import android.util.LruCache;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class LruCacheKt {
    @NotNull
    public static final <K, V> LruCache<K, V> lruCache(int i6, @NotNull Function2<? super K, ? super V, Integer> function2, @NotNull Function1<? super K, ? extends V> function1, @NotNull Function4<? super Boolean, ? super K, ? super V, ? super V, n1> function4) {
        return new LruCacheKt$lruCache$4(i6, function2, function1, function4);
    }

    public static /* synthetic */ LruCache lruCache$default(int i6, Function2 function2, Function1 function1, Function4 function4, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            function2 = new Function2<Object, Object, Integer>() { // from class: androidx.core.util.LruCacheKt$lruCache$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function2
                @NotNull
                public final Integer invoke(@NotNull Object obj2, @NotNull Object obj3) {
                    return 1;
                }
            };
        }
        if ((i7 & 4) != 0) {
            function1 = new Function1<Object, Object>() { // from class: androidx.core.util.LruCacheKt$lruCache$2
                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Object invoke(@NotNull Object obj2) {
                    return null;
                }
            };
        }
        if ((i7 & 8) != 0) {
            function4 = new Function4<Boolean, Object, Object, Object, n1>() { // from class: androidx.core.util.LruCacheKt$lruCache$3
                public final void invoke(boolean z5, @NotNull Object obj2, @NotNull Object obj3, @Nullable Object obj4) {
                }

                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ n1 invoke(Boolean bool, Object obj2, Object obj3, Object obj4) {
                    invoke(bool.booleanValue(), obj2, obj3, obj4);
                    return n1.f44123a;
                }
            };
        }
        return new LruCacheKt$lruCache$4(i6, function2, function1, function4);
    }
}
