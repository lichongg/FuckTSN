package com.beizi.fusion.tool;

import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class ak {

    /* renamed from: a, reason: collision with root package name */
    private static volatile ak f13642a;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, Long> f13643b = new HashMap();

    public static ak a() {
        if (f13642a == null) {
            synchronized (ak.class) {
                try {
                    if (f13642a == null) {
                        f13642a = new ak();
                    }
                } finally {
                }
            }
        }
        return f13642a;
    }

    public long b(String str) {
        if (this.f13643b.containsKey(str)) {
            return this.f13643b.get(str).longValue();
        }
        return 0L;
    }

    public void a(String str, long j6) {
        this.f13643b.put(str, Long.valueOf(j6));
    }

    public void a(String str) {
        if (this.f13643b.containsKey(str)) {
            this.f13643b.remove(str);
        }
    }
}
