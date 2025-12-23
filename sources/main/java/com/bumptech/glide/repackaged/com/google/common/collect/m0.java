package com.bumptech.glide.repackaged.com.google.common.collect;

import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class m0 {
    static boolean a(Set<?> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    static int b(Set<?> set) {
        int i6;
        int i7 = 0;
        for (Object obj : set) {
            if (obj != null) {
                i6 = obj.hashCode();
            } else {
                i6 = 0;
            }
            i7 = ~(~(i7 + i6));
        }
        return i7;
    }
}
