package io.netty.util;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.net.IDN;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DomainNameMapping<V> implements Mapping<String, V> {
    final V defaultValue;
    private final Map<String, V> map;
    private final Map<String, V> unmodifiableMap;

    @Deprecated
    public DomainNameMapping(V v5) {
        this(4, v5);
    }

    @Deprecated
    public DomainNameMapping(int i6, V v5) {
        this(new LinkedHashMap(i6), v5);
    }

    static boolean matches(String str, String str2) {
        return str.startsWith("*.") ? str.regionMatches(2, str2, 0, str2.length()) || StringUtil.commonSuffixOfLength(str2, str, str.length() - 1) : str.equals(str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public DomainNameMapping<V> add(String str, V v5) {
        this.map.put(normalizeHostname((String) ObjectUtil.checkNotNull(str, "hostname")), ObjectUtil.checkNotNull(v5, "output"));
        return this;
    }

    public Map<String, V> asMap() {
        return this.unmodifiableMap;
    }

    @Override // io.netty.util.Mapping
    public V map(String str) {
        if (str != null) {
            String normalizeHostname = normalizeHostname(str);
            for (Map.Entry<String, V> entry : this.map.entrySet()) {
                if (matches(entry.getKey(), normalizeHostname)) {
                    return entry.getValue();
                }
            }
        }
        return this.defaultValue;
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + "(default: " + this.defaultValue + ", map: " + this.map + ')';
    }

    DomainNameMapping(Map<String, V> map, V v5) {
        this.defaultValue = (V) ObjectUtil.checkNotNull(v5, "defaultValue");
        this.map = map;
        this.unmodifiableMap = map != null ? Collections.unmodifiableMap(map) : null;
    }

    private static boolean needsNormalization(String str) {
        int length = str.length();
        for (int i6 = 0; i6 < length; i6++) {
            if (str.charAt(i6) > 127) {
                return true;
            }
        }
        return false;
    }

    static String normalizeHostname(String str) {
        if (needsNormalization(str)) {
            str = IDN.toASCII(str, 1);
        }
        return str.toLowerCase(Locale.US);
    }
}
