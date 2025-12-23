package io.netty.handler.ssl;

import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class ApplicationProtocolUtil {
    private static final int DEFAULT_LIST_SIZE = 2;

    static List<String> toList(Iterable<String> iterable) {
        return toList(2, iterable);
    }

    static List<String> toList(int i6, Iterable<String> iterable) {
        if (iterable == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(i6);
        for (String str : iterable) {
            if (str == null || str.isEmpty()) {
                throw new IllegalArgumentException("protocol cannot be null or empty");
            }
            arrayList.add(str);
        }
        if (arrayList.isEmpty()) {
            throw new IllegalArgumentException("protocols cannot empty");
        }
        return arrayList;
    }

    private ApplicationProtocolUtil() {
    }

    static List<String> toList(String... strArr) {
        return toList(2, strArr);
    }

    static List<String> toList(int i6, String... strArr) {
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(i6);
        for (String str : strArr) {
            if (str != null && !str.isEmpty()) {
                arrayList.add(str);
            } else {
                throw new IllegalArgumentException("protocol cannot be null or empty");
            }
        }
        if (arrayList.isEmpty()) {
            throw new IllegalArgumentException("protocols cannot empty");
        }
        return arrayList;
    }
}
