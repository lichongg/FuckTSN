package androidx.core.util;

import android.util.LruCache;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nLruCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LruCache.kt\nandroidx/core/util/LruCacheKt$lruCache$4\n*L\n1#1,54:1\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class LruCacheKt$lruCache$4<K, V> extends LruCache<K, V> {
    final /* synthetic */ Function1<K, V> $create;
    final /* synthetic */ Function4<Boolean, K, V, V, n1> $onEntryRemoved;
    final /* synthetic */ Function2<K, V, Integer> $sizeOf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LruCacheKt$lruCache$4(int i6, Function2<? super K, ? super V, Integer> function2, Function1<? super K, ? extends V> function1, Function4<? super Boolean, ? super K, ? super V, ? super V, n1> function4) {
        super(i6);
        this.$sizeOf = function2;
        this.$create = function1;
        this.$onEntryRemoved = function4;
    }

    @Override // android.util.LruCache
    @Nullable
    protected V create(@NotNull K k6) {
        return this.$create.invoke(k6);
    }

    @Override // android.util.LruCache
    protected void entryRemoved(boolean z5, @NotNull K k6, @NotNull V v5, @Nullable V v6) {
        this.$onEntryRemoved.invoke(Boolean.valueOf(z5), k6, v5, v6);
    }

    @Override // android.util.LruCache
    protected int sizeOf(@NotNull K k6, @NotNull V v5) {
        return this.$sizeOf.invoke(k6, v5).intValue();
    }
}
