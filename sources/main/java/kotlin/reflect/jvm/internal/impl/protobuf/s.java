package kotlin.reflect.jvm.internal.impl.protobuf;

import com.huawei.hms.framework.common.ContainerUtils;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import kotlin.reflect.jvm.internal.impl.protobuf.g;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
class s<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: a, reason: collision with root package name */
    private final int f46539a;

    /* renamed from: b, reason: collision with root package name */
    private List<s<K, V>.c> f46540b;

    /* renamed from: c, reason: collision with root package name */
    private Map<K, V> f46541c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f46542d;

    /* renamed from: e, reason: collision with root package name */
    private volatile s<K, V>.e f46543e;

    /* JADX INFO: Add missing generic type declarations: [FieldDescriptorType] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a<FieldDescriptorType> extends s<FieldDescriptorType, Object> {
        a(int i6) {
            super(i6, null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.s, java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
            return super.put((g.b) obj, obj2);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
        public void m() {
            if (!l()) {
                for (int i6 = 0; i6 < i(); i6++) {
                    Map.Entry<FieldDescriptorType, Object> h6 = h(i6);
                    if (((g.b) h6.getKey()).H()) {
                        h6.setValue(Collections.unmodifiableList((List) h6.getValue()));
                    }
                }
                for (Map.Entry<FieldDescriptorType, Object> entry : j()) {
                    if (((g.b) entry.getKey()).H()) {
                        entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                    }
                }
            }
            super.m();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final Iterator<Object> f46544a = new a();

        /* renamed from: b, reason: collision with root package name */
        private static final Iterable<Object> f46545b = new C0907b();

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static class a implements Iterator<Object> {
            @Override // java.util.Iterator
            public boolean hasNext() {
                return false;
            }

            @Override // java.util.Iterator
            public Object next() {
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }

            a() {
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: kotlin.reflect.jvm.internal.impl.protobuf.s$b$b, reason: collision with other inner class name */
        static class C0907b implements Iterable<Object> {
            C0907b() {
            }

            @Override // java.lang.Iterable
            public Iterator<Object> iterator() {
                return b.f46544a;
            }
        }

        static <T> Iterable<T> b() {
            return (Iterable<T>) f46545b;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class c implements Comparable<s<K, V>.c>, Map.Entry<K, V> {

        /* renamed from: a, reason: collision with root package name */
        private final K f46546a;

        /* renamed from: b, reason: collision with root package name */
        private V f46547b;

        c(s sVar, Map.Entry<K, V> entry) {
            this(entry.getKey(), entry.getValue());
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return b(this.f46546a, entry.getKey()) && b(this.f46547b, entry.getValue());
        }

        c(K k6, V v5) {
            this.f46546a = k6;
            this.f46547b = v5;
        }

        private boolean b(Object obj, Object obj2) {
            return obj == null ? obj2 == null : obj.equals(obj2);
        }

        @Override // java.util.Map.Entry
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public K getKey() {
            return this.f46546a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f46547b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k6 = this.f46546a;
            int hashCode = k6 == null ? 0 : k6.hashCode();
            V v5 = this.f46547b;
            return hashCode ^ (v5 != null ? v5.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v5) {
            s.this.f();
            V v6 = this.f46547b;
            this.f46547b = v5;
            return v6;
        }

        public String toString() {
            String valueOf = String.valueOf(this.f46546a);
            String valueOf2 = String.valueOf(this.f46547b);
            StringBuilder sb = new StringBuilder(valueOf.length() + 1 + valueOf2.length());
            sb.append(valueOf);
            sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb.append(valueOf2);
            return sb.toString();
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(s<K, V>.c cVar) {
            return getKey().compareTo(cVar.getKey());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class d implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a, reason: collision with root package name */
        private int f46549a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f46550b;

        /* renamed from: c, reason: collision with root package name */
        private Iterator<Map.Entry<K, V>> f46551c;

        private d() {
            this.f46549a = -1;
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            this.f46550b = true;
            int i6 = this.f46549a + 1;
            this.f46549a = i6;
            return i6 < s.this.f46540b.size() ? (Map.Entry) s.this.f46540b.get(this.f46549a) : a().next();
        }

        private Iterator<Map.Entry<K, V>> a() {
            if (this.f46551c == null) {
                this.f46551c = s.this.f46541c.entrySet().iterator();
            }
            return this.f46551c;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f46549a + 1 < s.this.f46540b.size() || a().hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f46550b) {
                throw new IllegalStateException("remove() was called before next()");
            }
            this.f46550b = false;
            s.this.f();
            if (this.f46549a >= s.this.f46540b.size()) {
                a().remove();
                return;
            }
            s sVar = s.this;
            int i6 = this.f46549a;
            this.f46549a = i6 - 1;
            sVar.p(i6);
        }

        /* synthetic */ d(s sVar, a aVar) {
            this();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class e extends AbstractSet<Map.Entry<K, V>> {
        private e() {
        }

        /* synthetic */ e(s sVar, a aVar) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            s.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = s.this.get(entry.getKey());
            Object value = entry.getValue();
            if (obj2 != value) {
                return obj2 != null && obj2.equals(value);
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new d(s.this, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            s.this.remove(entry.getKey());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return s.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry<K, V> entry) {
            if (!contains(entry)) {
                s.this.put(entry.getKey(), entry.getValue());
                return true;
            }
            return false;
        }
    }

    /* synthetic */ s(int i6, a aVar) {
        this(i6);
    }

    private s(int i6) {
        this.f46539a = i6;
        this.f46540b = Collections.EMPTY_LIST;
        this.f46541c = Collections.EMPTY_MAP;
    }

    private int e(K k6) {
        int i6;
        int size = this.f46540b.size();
        int i7 = size - 1;
        if (i7 >= 0) {
            int compareTo = k6.compareTo(this.f46540b.get(i7).getKey());
            if (compareTo > 0) {
                i6 = size + 1;
                return -i6;
            }
            if (compareTo == 0) {
                return i7;
            }
        }
        int i8 = 0;
        while (i8 <= i7) {
            int i9 = (i8 + i7) / 2;
            int compareTo2 = k6.compareTo(this.f46540b.get(i9).getKey());
            if (compareTo2 < 0) {
                i7 = i9 - 1;
            } else {
                if (compareTo2 <= 0) {
                    return i9;
                }
                i8 = i9 + 1;
            }
        }
        i6 = i8 + 1;
        return -i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.f46542d) {
            throw new UnsupportedOperationException();
        }
    }

    static <FieldDescriptorType extends g.b<FieldDescriptorType>> s<FieldDescriptorType, Object> n(int i6) {
        return new a(i6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return e(comparable) >= 0 || this.f46541c.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f46543e == null) {
            this.f46543e = new e(this, null);
        }
        return this.f46543e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int e6 = e(comparable);
        return e6 >= 0 ? this.f46540b.get(e6).getValue() : this.f46541c.get(comparable);
    }

    public Map.Entry<K, V> h(int i6) {
        return this.f46540b.get(i6);
    }

    public int i() {
        return this.f46540b.size();
    }

    public Iterable<Map.Entry<K, V>> j() {
        return this.f46541c.isEmpty() ? b.b() : this.f46541c.entrySet();
    }

    public boolean l() {
        return this.f46542d;
    }

    public void m() {
        if (this.f46542d) {
            return;
        }
        this.f46541c = this.f46541c.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.f46541c);
        this.f46542d = true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f46540b.size() + this.f46541c.size();
    }

    private void g() {
        f();
        if (this.f46540b.isEmpty() && !(this.f46540b instanceof ArrayList)) {
            this.f46540b = new ArrayList(this.f46539a);
        }
    }

    private SortedMap<K, V> k() {
        f();
        if (this.f46541c.isEmpty() && !(this.f46541c instanceof TreeMap)) {
            this.f46541c = new TreeMap();
        }
        return (SortedMap) this.f46541c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V p(int i6) {
        f();
        V value = this.f46540b.remove(i6).getValue();
        if (!this.f46541c.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = k().entrySet().iterator();
            this.f46540b.add(new c(this, it.next()));
            it.remove();
        }
        return value;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        f();
        if (!this.f46540b.isEmpty()) {
            this.f46540b.clear();
        }
        if (!this.f46541c.isEmpty()) {
            this.f46541c.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public V put(K k6, V v5) {
        f();
        int e6 = e(k6);
        if (e6 >= 0) {
            return this.f46540b.get(e6).setValue(v5);
        }
        g();
        int i6 = -(e6 + 1);
        if (i6 >= this.f46539a) {
            return k().put(k6, v5);
        }
        int size = this.f46540b.size();
        int i7 = this.f46539a;
        if (size == i7) {
            s<K, V>.c remove = this.f46540b.remove(i7 - 1);
            k().put(remove.getKey(), remove.getValue());
        }
        this.f46540b.add(i6, new c(k6, v5));
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        f();
        Comparable comparable = (Comparable) obj;
        int e6 = e(comparable);
        if (e6 >= 0) {
            return (V) p(e6);
        }
        if (this.f46541c.isEmpty()) {
            return null;
        }
        return this.f46541c.remove(comparable);
    }
}
