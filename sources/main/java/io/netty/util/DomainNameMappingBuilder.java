package io.netty.util;

import io.netty.util.internal.ObjectUtil;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class DomainNameMappingBuilder<V> {
    private final V defaultValue;
    private final Map<String, V> map;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.util.DomainNameMappingBuilder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class ImmutableDomainNameMapping<V> extends DomainNameMapping<V> {
        private static final int REPR_CONST_PART_LENGTH = 46;
        private static final String REPR_HEADER = "ImmutableDomainNameMapping(default: ";
        private static final String REPR_MAP_CLOSING = "})";
        private static final String REPR_MAP_OPENING = ", map: {";
        private final String[] domainNamePatterns;
        private final Map<String, V> map;
        private final V[] values;

        /* synthetic */ ImmutableDomainNameMapping(Object obj, Map map, AnonymousClass1 anonymousClass1) {
            this(obj, map);
        }

        private StringBuilder appendMapping(StringBuilder sb, int i6) {
            return appendMapping(sb, this.domainNamePatterns[i6], this.values[i6].toString());
        }

        private ImmutableDomainNameMapping(V v5, Map<String, V> map) {
            super((Map) null, v5);
            Set<Map.Entry<String, V>> entrySet = map.entrySet();
            int size = entrySet.size();
            this.domainNamePatterns = new String[size];
            this.values = (V[]) new Object[size];
            LinkedHashMap linkedHashMap = new LinkedHashMap(map.size());
            int i6 = 0;
            for (Map.Entry<String, V> entry : entrySet) {
                String normalizeHostname = DomainNameMapping.normalizeHostname(entry.getKey());
                V value = entry.getValue();
                this.domainNamePatterns[i6] = normalizeHostname;
                this.values[i6] = value;
                linkedHashMap.put(normalizeHostname, value);
                i6++;
            }
            this.map = Collections.unmodifiableMap(linkedHashMap);
        }

        private static StringBuilder appendMapping(StringBuilder sb, String str, String str2) {
            sb.append(str);
            sb.append('=');
            sb.append(str2);
            return sb;
        }

        private static int estimateBufferSize(int i6, int i7, int i8) {
            return REPR_CONST_PART_LENGTH + i6 + ((int) (i8 * i7 * 1.1d));
        }

        @Override // io.netty.util.DomainNameMapping
        @Deprecated
        public DomainNameMapping<V> add(String str, V v5) {
            throw new UnsupportedOperationException("Immutable DomainNameMapping does not support modification after initial creation");
        }

        @Override // io.netty.util.DomainNameMapping
        public Map<String, V> asMap() {
            return this.map;
        }

        @Override // io.netty.util.DomainNameMapping, io.netty.util.Mapping
        public V map(String str) {
            if (str != null) {
                String normalizeHostname = DomainNameMapping.normalizeHostname(str);
                int length = this.domainNamePatterns.length;
                for (int i6 = 0; i6 < length; i6++) {
                    if (DomainNameMapping.matches(this.domainNamePatterns[i6], normalizeHostname)) {
                        return this.values[i6];
                    }
                }
            }
            return this.defaultValue;
        }

        @Override // io.netty.util.DomainNameMapping
        public String toString() {
            String obj = this.defaultValue.toString();
            String[] strArr = this.domainNamePatterns;
            int length = strArr.length;
            if (length == 0) {
                return REPR_HEADER + obj + REPR_MAP_OPENING + REPR_MAP_CLOSING;
            }
            String str = strArr[0];
            String obj2 = this.values[0].toString();
            StringBuilder sb = new StringBuilder(estimateBufferSize(obj.length(), length, str.length() + obj2.length() + 3));
            sb.append(REPR_HEADER);
            sb.append(obj);
            sb.append(REPR_MAP_OPENING);
            appendMapping(sb, str, obj2);
            for (int i6 = 1; i6 < length; i6++) {
                sb.append(", ");
                appendMapping(sb, i6);
            }
            sb.append(REPR_MAP_CLOSING);
            return sb.toString();
        }
    }

    public DomainNameMappingBuilder(V v5) {
        this(4, v5);
    }

    public DomainNameMappingBuilder(int i6, V v5) {
        this.defaultValue = (V) ObjectUtil.checkNotNull(v5, "defaultValue");
        this.map = new LinkedHashMap(i6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DomainNameMappingBuilder<V> add(String str, V v5) {
        this.map.put(ObjectUtil.checkNotNull(str, "hostname"), ObjectUtil.checkNotNull(v5, "output"));
        return this;
    }

    public DomainNameMapping<V> build() {
        return new ImmutableDomainNameMapping(this.defaultValue, this.map, null);
    }
}
