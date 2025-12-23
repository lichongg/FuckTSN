package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class i extends j {

    /* renamed from: e, reason: collision with root package name */
    private final n f46504e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b<K> implements Map.Entry<K, Object> {

        /* renamed from: a, reason: collision with root package name */
        private Map.Entry<K, i> f46505a;

        private b(Map.Entry<K, i> entry) {
            this.f46505a = entry;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f46505a.getKey();
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            i value = this.f46505a.getValue();
            if (value == null) {
                return null;
            }
            return value.e();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (obj instanceof n) {
                return this.f46505a.getValue().d((n) obj);
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class c<K> implements Iterator<Map.Entry<K, Object>> {

        /* renamed from: a, reason: collision with root package name */
        private Iterator<Map.Entry<K, Object>> f46506a;

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, Object> next() {
            Map.Entry<K, Object> next = this.f46506a.next();
            return next.getValue() instanceof i ? new b(next) : next;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f46506a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f46506a.remove();
        }

        public c(Iterator<Map.Entry<K, Object>> it) {
            this.f46506a = it;
        }
    }

    public n e() {
        return c(this.f46504e);
    }

    public boolean equals(Object obj) {
        return e().equals(obj);
    }

    public int hashCode() {
        return e().hashCode();
    }

    public String toString() {
        return e().toString();
    }
}
