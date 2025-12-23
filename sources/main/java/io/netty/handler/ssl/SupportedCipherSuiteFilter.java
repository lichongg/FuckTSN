package io.netty.handler.ssl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class SupportedCipherSuiteFilter implements CipherSuiteFilter {
    public static final SupportedCipherSuiteFilter INSTANCE = new SupportedCipherSuiteFilter();

    @Override // io.netty.handler.ssl.CipherSuiteFilter
    public String[] filterCipherSuites(Iterable<String> iterable, List<String> list, Set<String> set) {
        ArrayList arrayList;
        String next;
        if (list == null) {
            throw new NullPointerException("defaultCiphers");
        }
        if (set == null) {
            throw new NullPointerException("supportedCiphers");
        }
        if (iterable == null) {
            arrayList = new ArrayList(list.size());
            iterable = list;
        } else {
            arrayList = new ArrayList(set.size());
        }
        Iterator<String> it = iterable.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            if (set.contains(next)) {
                arrayList.add(next);
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    private SupportedCipherSuiteFilter() {
    }
}
