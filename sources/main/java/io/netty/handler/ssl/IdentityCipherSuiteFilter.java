package io.netty.handler.ssl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class IdentityCipherSuiteFilter implements CipherSuiteFilter {
    public static final IdentityCipherSuiteFilter INSTANCE = new IdentityCipherSuiteFilter(true);
    public static final IdentityCipherSuiteFilter INSTANCE_DEFAULTING_TO_SUPPORTED_CIPHERS = new IdentityCipherSuiteFilter(false);
    private final boolean defaultToDefaultCiphers;

    @Override // io.netty.handler.ssl.CipherSuiteFilter
    public String[] filterCipherSuites(Iterable<String> iterable, List<String> list, Set<String> set) {
        String next;
        if (iterable == null) {
            return this.defaultToDefaultCiphers ? (String[]) list.toArray(new String[0]) : (String[]) set.toArray(new String[0]);
        }
        ArrayList arrayList = new ArrayList(set.size());
        Iterator<String> it = iterable.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            arrayList.add(next);
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    private IdentityCipherSuiteFilter(boolean z5) {
        this.defaultToDefaultCiphers = z5;
    }
}
