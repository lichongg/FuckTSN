package com.huawei.hms.scankit.p;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class m {

    /* renamed from: a, reason: collision with root package name */
    private final Map<Integer, Integer> f34532a = new HashMap();

    void a(int i6) {
        Integer num = this.f34532a.get(Integer.valueOf(i6));
        if (num == null) {
            num = 0;
        }
        this.f34532a.put(Integer.valueOf(i6), Integer.valueOf(num.intValue() + 1));
    }

    m() {
    }

    int[] a() {
        ArrayList arrayList = new ArrayList();
        int i6 = -1;
        for (Map.Entry<Integer, Integer> entry : this.f34532a.entrySet()) {
            if (entry.getValue().intValue() > i6) {
                i6 = entry.getValue().intValue();
                arrayList.clear();
                arrayList.add(entry.getKey());
            } else if (entry.getValue().intValue() == i6) {
                arrayList.add(entry.getKey());
            }
        }
        return n5.a(arrayList);
    }
}
