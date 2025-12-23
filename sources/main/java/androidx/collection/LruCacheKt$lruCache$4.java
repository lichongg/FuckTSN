package androidx.collection;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nLruCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LruCache.kt\nandroidx/collection/LruCacheKt$lruCache$4\n*L\n1#1,355:1\n*E\n"})
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

    @Override // androidx.collection.LruCache
    @Nullable
    protected V create(@NotNull K key) {
        g0.p(key, "key");
        return this.$create.invoke(key);
    }

    @Override // androidx.collection.LruCache
    protected void entryRemoved(boolean z5, @NotNull K key, @NotNull V oldValue, @Nullable V v5) {
        g0.p(key, "key");
        g0.p(oldValue, "oldValue");
        this.$onEntryRemoved.invoke(Boolean.valueOf(z5), key, oldValue, v5);
    }

    @Override // androidx.collection.LruCache
    protected int sizeOf(@NotNull K key, @NotNull V value) {
        g0.p(key, "key");
        g0.p(value, "value");
        return this.$sizeOf.invoke(key, value).intValue();
    }
}
