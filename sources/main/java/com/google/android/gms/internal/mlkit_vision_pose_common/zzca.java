package com.google.android.gms.internal.mlkit_vision_pose_common;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzca {
    static boolean zzc(Set set, Iterator it) {
        boolean z5 = false;
        while (it.hasNext()) {
            z5 |= set.remove(it.next());
        }
        return z5;
    }

    static int zza(Set set) {
        int i6;
        int i7 = 0;
        for (Object obj : set) {
            if (obj != null) {
                i6 = obj.hashCode();
            } else {
                i6 = 0;
            }
            i7 += i6;
        }
        return i7;
    }

    static boolean zzb(Set set, Collection collection) {
        collection.getClass();
        if (collection instanceof zzbs) {
            collection = ((zzbs) collection).zza();
        }
        if ((collection instanceof Set) && collection.size() > set.size()) {
            Iterator it = set.iterator();
            boolean z5 = false;
            while (it.hasNext()) {
                if (collection.contains(it.next())) {
                    it.remove();
                    z5 = true;
                }
            }
            return z5;
        }
        return zzc(set, collection.iterator());
    }
}
