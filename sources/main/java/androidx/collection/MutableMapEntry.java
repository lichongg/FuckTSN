package androidx.collection;

import java.util.Map;
import kotlin.jvm.internal.g0;
import m3.g;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final class MutableMapEntry<K, V> implements Map.Entry<K, V>, g.a {
    private final int index;

    @NotNull
    private final Object[] keys;

    @NotNull
    private final Object[] values;

    public MutableMapEntry(@NotNull Object[] keys, @NotNull Object[] values, int i6) {
        g0.p(keys, "keys");
        g0.p(values, "values");
        this.keys = keys;
        this.values = values;
        this.index = i6;
    }

    public final int getIndex() {
        return this.index;
    }

    @Override // java.util.Map.Entry
    public K getKey() {
        return (K) this.keys[this.index];
    }

    @NotNull
    public final Object[] getKeys() {
        return this.keys;
    }

    @Override // java.util.Map.Entry
    public V getValue() {
        return (V) this.values[this.index];
    }

    @NotNull
    public final Object[] getValues() {
        return this.values;
    }

    @Override // java.util.Map.Entry
    public V setValue(V v5) {
        Object[] objArr = this.values;
        int i6 = this.index;
        V v6 = (V) objArr[i6];
        objArr[i6] = v5;
        return v6;
    }

    public static /* synthetic */ void getKey$annotations() {
    }

    public static /* synthetic */ void getValue$annotations() {
    }
}
