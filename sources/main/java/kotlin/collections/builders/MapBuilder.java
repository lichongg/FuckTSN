package kotlin.collections.builders;

import java.io.InvalidObjectException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.ranges.t;
import m3.g;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nMapBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MapBuilder.kt\nkotlin/collections/builders/MapBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,751:1\n1#2:752\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class MapBuilder<K, V> implements Map<K, V>, Serializable, g {

    @NotNull
    public static final a Companion = new a(null);

    @NotNull
    private static final MapBuilder Empty;
    private static final int INITIAL_CAPACITY = 8;
    private static final int INITIAL_MAX_PROBE_DISTANCE = 2;
    private static final int MAGIC = -1640531527;
    private static final int TOMBSTONE = -1;

    @Nullable
    private kotlin.collections.builders.c<K, V> entriesView;

    @NotNull
    private int[] hashArray;
    private int hashShift;
    private boolean isReadOnly;

    @NotNull
    private K[] keysArray;

    @Nullable
    private kotlin.collections.builders.d<K> keysView;
    private int length;
    private int maxProbeDistance;
    private int modCount;

    @NotNull
    private int[] presenceArray;
    private int size;

    @Nullable
    private V[] valuesArray;

    @Nullable
    private kotlin.collections.builders.e<V> valuesView;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(v vVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int c(int i6) {
            return Integer.highestOneBit(t.u(i6, 1) * 3);
        }

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int d(int i6) {
            return Integer.numberOfLeadingZeros(i6) + 1;
        }

        @NotNull
        public final MapBuilder e() {
            return MapBuilder.Empty;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b<K, V> extends d<K, V> implements Iterator<Map.Entry<K, V>>, m3.d {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull MapBuilder<K, V> map) {
            super(map);
            g0.p(map, "map");
        }

        public final void k(@NotNull StringBuilder sb) {
            g0.p(sb, "sb");
            if (c() >= ((MapBuilder) f()).length) {
                throw new NoSuchElementException();
            }
            int c6 = c();
            h(c6 + 1);
            i(c6);
            Object obj = ((MapBuilder) f()).keysArray[e()];
            if (obj == f()) {
                sb.append("(this Map)");
            } else {
                sb.append(obj);
            }
            sb.append('=');
            Object[] objArr = ((MapBuilder) f()).valuesArray;
            g0.m(objArr);
            Object obj2 = objArr[e()];
            if (obj2 == f()) {
                sb.append("(this Map)");
            } else {
                sb.append(obj2);
            }
            g();
        }

        @Override // java.util.Iterator
        @NotNull
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public c<K, V> next() {
            a();
            if (c() < ((MapBuilder) f()).length) {
                int c6 = c();
                h(c6 + 1);
                i(c6);
                c<K, V> cVar = new c<>(f(), e());
                g();
                return cVar;
            }
            throw new NoSuchElementException();
        }

        public final int m() {
            int i6;
            if (c() < ((MapBuilder) f()).length) {
                int c6 = c();
                h(c6 + 1);
                i(c6);
                Object obj = ((MapBuilder) f()).keysArray[e()];
                int i7 = 0;
                if (obj != null) {
                    i6 = obj.hashCode();
                } else {
                    i6 = 0;
                }
                Object[] objArr = ((MapBuilder) f()).valuesArray;
                g0.m(objArr);
                Object obj2 = objArr[e()];
                if (obj2 != null) {
                    i7 = obj2.hashCode();
                }
                int i8 = i6 ^ i7;
                g();
                return i8;
            }
            throw new NoSuchElementException();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class c<K, V> implements Map.Entry<K, V>, g.a {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final MapBuilder<K, V> f43615a;

        /* renamed from: b, reason: collision with root package name */
        private final int f43616b;

        /* renamed from: c, reason: collision with root package name */
        private final int f43617c;

        public c(@NotNull MapBuilder<K, V> map, int i6) {
            g0.p(map, "map");
            this.f43615a = map;
            this.f43616b = i6;
            this.f43617c = ((MapBuilder) map).modCount;
        }

        private final void a() {
            if (((MapBuilder) this.f43615a).modCount != this.f43617c) {
                throw new ConcurrentModificationException("The backing map has been modified after this entry was obtained.");
            }
        }

        @Override // java.util.Map.Entry
        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return g0.g(entry.getKey(), getKey()) && g0.g(entry.getValue(), getValue());
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getKey());
            sb.append('=');
            sb.append(getValue());
            return sb.toString();
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            a();
            return (K) ((MapBuilder) this.f43615a).keysArray[this.f43616b];
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            a();
            Object[] objArr = ((MapBuilder) this.f43615a).valuesArray;
            g0.m(objArr);
            return (V) objArr[this.f43616b];
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            int i6;
            K key = getKey();
            int i7 = 0;
            if (key != null) {
                i6 = key.hashCode();
            } else {
                i6 = 0;
            }
            V value = getValue();
            if (value != null) {
                i7 = value.hashCode();
            }
            return i6 ^ i7;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v5) {
            a();
            this.f43615a.checkIsMutable$kotlin_stdlib();
            Object[] allocateValuesArray = this.f43615a.allocateValuesArray();
            int i6 = this.f43616b;
            V v6 = (V) allocateValuesArray[i6];
            allocateValuesArray[i6] = v5;
            return v6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nMapBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MapBuilder.kt\nkotlin/collections/builders/MapBuilder$Itr\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,751:1\n1#2:752\n*E\n"})
    public static class d<K, V> {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final MapBuilder<K, V> f43618a;

        /* renamed from: b, reason: collision with root package name */
        private int f43619b;

        /* renamed from: c, reason: collision with root package name */
        private int f43620c;

        /* renamed from: d, reason: collision with root package name */
        private int f43621d;

        public d(@NotNull MapBuilder<K, V> map) {
            g0.p(map, "map");
            this.f43618a = map;
            this.f43620c = -1;
            this.f43621d = ((MapBuilder) map).modCount;
            g();
        }

        public final void a() {
            if (((MapBuilder) this.f43618a).modCount != this.f43621d) {
                throw new ConcurrentModificationException();
            }
        }

        public final int c() {
            return this.f43619b;
        }

        public final int e() {
            return this.f43620c;
        }

        @NotNull
        public final MapBuilder<K, V> f() {
            return this.f43618a;
        }

        public final void g() {
            while (this.f43619b < ((MapBuilder) this.f43618a).length) {
                int[] iArr = ((MapBuilder) this.f43618a).presenceArray;
                int i6 = this.f43619b;
                if (iArr[i6] >= 0) {
                    return;
                } else {
                    this.f43619b = i6 + 1;
                }
            }
        }

        public final void h(int i6) {
            this.f43619b = i6;
        }

        public final boolean hasNext() {
            return this.f43619b < ((MapBuilder) this.f43618a).length;
        }

        public final void i(int i6) {
            this.f43620c = i6;
        }

        public final void remove() {
            a();
            if (this.f43620c != -1) {
                this.f43618a.checkIsMutable$kotlin_stdlib();
                this.f43618a.removeEntryAt(this.f43620c);
                this.f43620c = -1;
                this.f43621d = ((MapBuilder) this.f43618a).modCount;
                return;
            }
            throw new IllegalStateException("Call next() before removing element from the iterator.");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class e<K, V> extends d<K, V> implements Iterator<K>, m3.d {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(@NotNull MapBuilder<K, V> map) {
            super(map);
            g0.p(map, "map");
        }

        @Override // java.util.Iterator
        public K next() {
            a();
            if (c() < ((MapBuilder) f()).length) {
                int c6 = c();
                h(c6 + 1);
                i(c6);
                K k6 = (K) ((MapBuilder) f()).keysArray[e()];
                g();
                return k6;
            }
            throw new NoSuchElementException();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class f<K, V> extends d<K, V> implements Iterator<V>, m3.d {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(@NotNull MapBuilder<K, V> map) {
            super(map);
            g0.p(map, "map");
        }

        @Override // java.util.Iterator
        public V next() {
            a();
            if (c() < ((MapBuilder) f()).length) {
                int c6 = c();
                h(c6 + 1);
                i(c6);
                Object[] objArr = ((MapBuilder) f()).valuesArray;
                g0.m(objArr);
                V v5 = (V) objArr[e()];
                g();
                return v5;
            }
            throw new NoSuchElementException();
        }
    }

    private MapBuilder(K[] kArr, V[] vArr, int[] iArr, int[] iArr2, int i6, int i7) {
        this.keysArray = kArr;
        this.valuesArray = vArr;
        this.presenceArray = iArr;
        this.hashArray = iArr2;
        this.maxProbeDistance = i6;
        this.length = i7;
        this.hashShift = Companion.d(getHashSize());
    }

    static {
        MapBuilder mapBuilder = new MapBuilder(0);
        mapBuilder.isReadOnly = true;
        Empty = mapBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final V[] allocateValuesArray() {
        V[] vArr = this.valuesArray;
        if (vArr != null) {
            return vArr;
        }
        V[] vArr2 = (V[]) kotlin.collections.builders.b.d(getCapacity$kotlin_stdlib());
        this.valuesArray = vArr2;
        return vArr2;
    }

    private final void compact(boolean z5) {
        int i6;
        V[] vArr = this.valuesArray;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            i6 = this.length;
            if (i7 >= i6) {
                break;
            }
            int[] iArr = this.presenceArray;
            int i9 = iArr[i7];
            if (i9 >= 0) {
                K[] kArr = this.keysArray;
                kArr[i8] = kArr[i7];
                if (vArr != null) {
                    vArr[i8] = vArr[i7];
                }
                if (z5) {
                    iArr[i8] = i9;
                    this.hashArray[i9] = i8 + 1;
                }
                i8++;
            }
            i7++;
        }
        kotlin.collections.builders.b.g(this.keysArray, i8, i6);
        if (vArr != null) {
            kotlin.collections.builders.b.g(vArr, i8, this.length);
        }
        this.length = i8;
    }

    private final void ensureCapacity(int i6) {
        if (i6 < 0) {
            throw new OutOfMemoryError();
        }
        if (i6 > getCapacity$kotlin_stdlib()) {
            int e6 = kotlin.collections.d.Companion.e(getCapacity$kotlin_stdlib(), i6);
            this.keysArray = (K[]) kotlin.collections.builders.b.e(this.keysArray, e6);
            V[] vArr = this.valuesArray;
            this.valuesArray = vArr != null ? (V[]) kotlin.collections.builders.b.e(vArr, e6) : null;
            int[] copyOf = Arrays.copyOf(this.presenceArray, e6);
            g0.o(copyOf, "copyOf(...)");
            this.presenceArray = copyOf;
            int c6 = Companion.c(e6);
            if (c6 > getHashSize()) {
                rehash(c6);
            }
        }
    }

    private final int findValue(V v5) {
        int i6 = this.length;
        while (true) {
            i6--;
            if (i6 < 0) {
                return -1;
            }
            if (this.presenceArray[i6] >= 0) {
                V[] vArr = this.valuesArray;
                g0.m(vArr);
                if (g0.g(vArr[i6], v5)) {
                    return i6;
                }
            }
        }
    }

    private final int getHashSize() {
        return this.hashArray.length;
    }

    private final int hash(K k6) {
        return ((k6 != null ? k6.hashCode() : 0) * MAGIC) >>> this.hashShift;
    }

    private final boolean putRehash(int i6) {
        int hash = hash(this.keysArray[i6]);
        int i7 = this.maxProbeDistance;
        while (true) {
            int[] iArr = this.hashArray;
            if (iArr[hash] == 0) {
                iArr[hash] = i6 + 1;
                this.presenceArray[i6] = hash;
                return true;
            }
            i7--;
            if (i7 < 0) {
                return false;
            }
            hash = hash == 0 ? getHashSize() - 1 : hash - 1;
        }
    }

    private final void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    private final void registerModification() {
        this.modCount++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeEntryAt(int i6) {
        kotlin.collections.builders.b.f(this.keysArray, i6);
        V[] vArr = this.valuesArray;
        if (vArr != null) {
            kotlin.collections.builders.b.f(vArr, i6);
        }
        removeHashAt(this.presenceArray[i6]);
        this.presenceArray[i6] = -1;
        this.size = size() - 1;
        registerModification();
    }

    private final void removeHashAt(int i6) {
        int B = t.B(this.maxProbeDistance * 2, getHashSize() / 2);
        int i7 = 0;
        int i8 = i6;
        do {
            i6 = i6 == 0 ? getHashSize() - 1 : i6 - 1;
            i7++;
            if (i7 > this.maxProbeDistance) {
                this.hashArray[i8] = 0;
                return;
            }
            int[] iArr = this.hashArray;
            int i9 = iArr[i6];
            if (i9 == 0) {
                iArr[i8] = 0;
                return;
            }
            if (i9 < 0) {
                iArr[i8] = -1;
            } else {
                int i10 = i9 - 1;
                if (((hash(this.keysArray[i10]) - i6) & (getHashSize() - 1)) >= i7) {
                    this.hashArray[i8] = i9;
                    this.presenceArray[i10] = i8;
                }
                B--;
            }
            i8 = i6;
            i7 = 0;
            B--;
        } while (B >= 0);
        this.hashArray[i8] = -1;
    }

    private final Object writeReplace() {
        if (this.isReadOnly) {
            return new kotlin.collections.builders.f(this);
        }
        throw new NotSerializableException("The map cannot be serialized while it is being built.");
    }

    public final void checkIsMutable$kotlin_stdlib() {
        if (this.isReadOnly) {
            throw new UnsupportedOperationException();
        }
    }

    public final boolean containsAllEntries$kotlin_stdlib(@NotNull Collection<?> m6) {
        g0.p(m6, "m");
        for (Object obj : m6) {
            if (obj != null) {
                try {
                    if (!containsEntry$kotlin_stdlib((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    public final boolean containsEntry$kotlin_stdlib(@NotNull Map.Entry<? extends K, ? extends V> entry) {
        g0.p(entry, "entry");
        int findKey = findKey(entry.getKey());
        if (findKey < 0) {
            return false;
        }
        V[] vArr = this.valuesArray;
        g0.m(vArr);
        return g0.g(vArr[findKey], entry.getValue());
    }

    @NotNull
    public final b<K, V> entriesIterator$kotlin_stdlib() {
        return new b<>(this);
    }

    @Override // java.util.Map
    public boolean equals(@Nullable Object obj) {
        if (obj != this) {
            return (obj instanceof Map) && contentEquals((Map) obj);
        }
        return true;
    }

    public final int getCapacity$kotlin_stdlib() {
        return this.keysArray.length;
    }

    @NotNull
    public Set<Map.Entry<K, V>> getEntries() {
        kotlin.collections.builders.c<K, V> cVar = this.entriesView;
        if (cVar != null) {
            return cVar;
        }
        kotlin.collections.builders.c<K, V> cVar2 = new kotlin.collections.builders.c<>(this);
        this.entriesView = cVar2;
        return cVar2;
    }

    @NotNull
    public Set<K> getKeys() {
        kotlin.collections.builders.d<K> dVar = this.keysView;
        if (dVar != null) {
            return dVar;
        }
        kotlin.collections.builders.d<K> dVar2 = new kotlin.collections.builders.d<>(this);
        this.keysView = dVar2;
        return dVar2;
    }

    public int getSize() {
        return this.size;
    }

    @NotNull
    public Collection<V> getValues() {
        kotlin.collections.builders.e<V> eVar = this.valuesView;
        if (eVar != null) {
            return eVar;
        }
        kotlin.collections.builders.e<V> eVar2 = new kotlin.collections.builders.e<>(this);
        this.valuesView = eVar2;
        return eVar2;
    }

    public final boolean isReadOnly$kotlin_stdlib() {
        return this.isReadOnly;
    }

    @NotNull
    public final e<K, V> keysIterator$kotlin_stdlib() {
        return new e<>(this);
    }

    @Override // java.util.Map
    public void putAll(@NotNull Map<? extends K, ? extends V> from) {
        g0.p(from, "from");
        checkIsMutable$kotlin_stdlib();
        putAllEntries(from.entrySet());
    }

    public final boolean removeEntry$kotlin_stdlib(@NotNull Map.Entry<? extends K, ? extends V> entry) {
        g0.p(entry, "entry");
        checkIsMutable$kotlin_stdlib();
        int findKey = findKey(entry.getKey());
        if (findKey < 0) {
            return false;
        }
        V[] vArr = this.valuesArray;
        g0.m(vArr);
        if (!g0.g(vArr[findKey], entry.getValue())) {
            return false;
        }
        removeEntryAt(findKey);
        return true;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder((size() * 3) + 2);
        sb.append("{");
        b<K, V> entriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        int i6 = 0;
        while (entriesIterator$kotlin_stdlib.hasNext()) {
            if (i6 > 0) {
                sb.append(", ");
            }
            entriesIterator$kotlin_stdlib.k(sb);
            i6++;
        }
        sb.append("}");
        String sb2 = sb.toString();
        g0.o(sb2, "toString(...)");
        return sb2;
    }

    @NotNull
    public final f<K, V> valuesIterator$kotlin_stdlib() {
        return new f<>(this);
    }

    private final boolean contentEquals(Map<?, ?> map) {
        if (size() == map.size() && containsAllEntries$kotlin_stdlib(map.entrySet())) {
            return true;
        }
        return false;
    }

    private final void ensureExtraCapacity(int i6) {
        if (shouldCompact(i6)) {
            compact(true);
        } else {
            ensureCapacity(this.length + i6);
        }
    }

    private final int findKey(K k6) {
        int hash = hash(k6);
        int i6 = this.maxProbeDistance;
        while (true) {
            int i7 = this.hashArray[hash];
            if (i7 == 0) {
                return -1;
            }
            if (i7 > 0) {
                int i8 = i7 - 1;
                if (g0.g(this.keysArray[i8], k6)) {
                    return i8;
                }
            }
            i6--;
            if (i6 < 0) {
                return -1;
            }
            int i9 = hash - 1;
            if (hash == 0) {
                hash = getHashSize() - 1;
            } else {
                hash = i9;
            }
        }
    }

    private final boolean putAllEntries(Collection<? extends Map.Entry<? extends K, ? extends V>> collection) {
        boolean z5 = false;
        if (collection.isEmpty()) {
            return false;
        }
        ensureExtraCapacity(collection.size());
        Iterator<? extends Map.Entry<? extends K, ? extends V>> it = collection.iterator();
        while (it.hasNext()) {
            if (putEntry(it.next())) {
                z5 = true;
            }
        }
        return z5;
    }

    private final boolean putEntry(Map.Entry<? extends K, ? extends V> entry) {
        int addKey$kotlin_stdlib = addKey$kotlin_stdlib(entry.getKey());
        V[] allocateValuesArray = allocateValuesArray();
        if (addKey$kotlin_stdlib >= 0) {
            allocateValuesArray[addKey$kotlin_stdlib] = entry.getValue();
            return true;
        }
        int i6 = (-addKey$kotlin_stdlib) - 1;
        if (!g0.g(entry.getValue(), allocateValuesArray[i6])) {
            allocateValuesArray[i6] = entry.getValue();
            return true;
        }
        return false;
    }

    private final void rehash(int i6) {
        registerModification();
        int i7 = 0;
        if (this.length > size()) {
            compact(false);
        }
        this.hashArray = new int[i6];
        this.hashShift = Companion.d(i6);
        while (i7 < this.length) {
            int i8 = i7 + 1;
            if (putRehash(i7)) {
                i7 = i8;
            } else {
                throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            }
        }
    }

    private final boolean shouldCompact(int i6) {
        int capacity$kotlin_stdlib = getCapacity$kotlin_stdlib();
        int i7 = this.length;
        int i8 = capacity$kotlin_stdlib - i7;
        int size = i7 - size();
        if (i8 < i6 && i8 + size >= i6 && size >= getCapacity$kotlin_stdlib() / 4) {
            return true;
        }
        return false;
    }

    public final int addKey$kotlin_stdlib(K k6) {
        checkIsMutable$kotlin_stdlib();
        while (true) {
            int hash = hash(k6);
            int B = t.B(this.maxProbeDistance * 2, getHashSize() / 2);
            int i6 = 0;
            while (true) {
                int i7 = this.hashArray[hash];
                if (i7 <= 0) {
                    if (this.length >= getCapacity$kotlin_stdlib()) {
                        ensureExtraCapacity(1);
                    } else {
                        int i8 = this.length;
                        int i9 = i8 + 1;
                        this.length = i9;
                        this.keysArray[i8] = k6;
                        this.presenceArray[i8] = hash;
                        this.hashArray[hash] = i9;
                        this.size = size() + 1;
                        registerModification();
                        if (i6 > this.maxProbeDistance) {
                            this.maxProbeDistance = i6;
                        }
                        return i8;
                    }
                } else {
                    if (g0.g(this.keysArray[i7 - 1], k6)) {
                        return -i7;
                    }
                    i6++;
                    if (i6 > B) {
                        rehash(getHashSize() * 2);
                        break;
                    }
                    int i10 = hash - 1;
                    if (hash == 0) {
                        hash = getHashSize() - 1;
                    } else {
                        hash = i10;
                    }
                }
            }
        }
    }

    @NotNull
    public final Map<K, V> build() {
        checkIsMutable$kotlin_stdlib();
        this.isReadOnly = true;
        if (size() > 0) {
            return this;
        }
        MapBuilder mapBuilder = Empty;
        g0.n(mapBuilder, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.builders.MapBuilder, V of kotlin.collections.builders.MapBuilder>");
        return mapBuilder;
    }

    @Override // java.util.Map
    public void clear() {
        checkIsMutable$kotlin_stdlib();
        int i6 = this.length - 1;
        if (i6 >= 0) {
            int i7 = 0;
            while (true) {
                int[] iArr = this.presenceArray;
                int i8 = iArr[i7];
                if (i8 >= 0) {
                    this.hashArray[i8] = 0;
                    iArr[i7] = -1;
                }
                if (i7 == i6) {
                    break;
                } else {
                    i7++;
                }
            }
        }
        kotlin.collections.builders.b.g(this.keysArray, 0, this.length);
        V[] vArr = this.valuesArray;
        if (vArr != null) {
            kotlin.collections.builders.b.g(vArr, 0, this.length);
        }
        this.size = 0;
        this.length = 0;
        registerModification();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        if (findKey(obj) >= 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        if (findValue(obj) >= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @Nullable
    public V get(Object obj) {
        int findKey = findKey(obj);
        if (findKey < 0) {
            return null;
        }
        V[] vArr = this.valuesArray;
        g0.m(vArr);
        return vArr[findKey];
    }

    @Override // java.util.Map
    public int hashCode() {
        b<K, V> entriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        int i6 = 0;
        while (entriesIterator$kotlin_stdlib.hasNext()) {
            i6 += entriesIterator$kotlin_stdlib.m();
        }
        return i6;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return getKeys();
    }

    @Override // java.util.Map
    @Nullable
    public V put(K k6, V v5) {
        checkIsMutable$kotlin_stdlib();
        int addKey$kotlin_stdlib = addKey$kotlin_stdlib(k6);
        V[] allocateValuesArray = allocateValuesArray();
        if (addKey$kotlin_stdlib < 0) {
            int i6 = (-addKey$kotlin_stdlib) - 1;
            V v6 = allocateValuesArray[i6];
            allocateValuesArray[i6] = v5;
            return v6;
        }
        allocateValuesArray[addKey$kotlin_stdlib] = v5;
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @Nullable
    public V remove(Object obj) {
        checkIsMutable$kotlin_stdlib();
        int findKey = findKey(obj);
        if (findKey < 0) {
            return null;
        }
        V[] vArr = this.valuesArray;
        g0.m(vArr);
        V v5 = vArr[findKey];
        removeEntryAt(findKey);
        return v5;
    }

    public final boolean removeKey$kotlin_stdlib(K k6) {
        checkIsMutable$kotlin_stdlib();
        int findKey = findKey(k6);
        if (findKey < 0) {
            return false;
        }
        removeEntryAt(findKey);
        return true;
    }

    public final boolean removeValue$kotlin_stdlib(V v5) {
        checkIsMutable$kotlin_stdlib();
        int findValue = findValue(v5);
        if (findValue < 0) {
            return false;
        }
        removeEntryAt(findValue);
        return true;
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    public MapBuilder() {
        this(8);
    }

    public MapBuilder(int i6) {
        this(kotlin.collections.builders.b.d(i6), null, new int[i6], new int[Companion.c(i6)], 2, 0);
    }
}
