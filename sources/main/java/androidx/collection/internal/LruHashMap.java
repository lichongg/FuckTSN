package androidx.collection.internal;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class LruHashMap<K, V> {

    @NotNull
    private final LinkedHashMap<K, V> map;

    public LruHashMap() {
        this(0, 0.0f, 3, null);
    }

    public LruHashMap(int i6, float f6) {
        this.map = new LinkedHashMap<>(i6, f6, true);
    }

    @Nullable
    public final V get(@NotNull K key) {
        g0.p(key, "key");
        return this.map.get(key);
    }

    @NotNull
    public final Set<Map.Entry<K, V>> getEntries() {
        Set<Map.Entry<K, V>> entrySet = this.map.entrySet();
        g0.o(entrySet, "map.entries");
        return entrySet;
    }

    public final boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Nullable
    public final V put(@NotNull K key, @NotNull V value) {
        g0.p(key, "key");
        g0.p(value, "value");
        return this.map.put(key, value);
    }

    @Nullable
    public final V remove(@NotNull K key) {
        g0.p(key, "key");
        return this.map.remove(key);
    }

    public /* synthetic */ LruHashMap(int i6, float f6, int i7, v vVar) {
        this((i7 & 1) != 0 ? 16 : i6, (i7 & 2) != 0 ? 0.75f : f6);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LruHashMap(@NotNull LruHashMap<? extends K, V> original) {
        this(0, 0.0f, 3, null);
        g0.p(original, "original");
        for (Map.Entry<? extends K, V> entry : original.getEntries()) {
            put(entry.getKey(), entry.getValue());
        }
    }
}
