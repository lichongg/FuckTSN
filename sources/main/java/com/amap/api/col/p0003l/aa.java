package com.amap.api.col.p0003l;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class aa {

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<Integer, a> f5635a = new ConcurrentHashMap<>();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class a<T> {

        /* renamed from: a, reason: collision with root package name */
        public List<T> f5636a = Collections.synchronizedList(new ArrayList());

        /* renamed from: b, reason: collision with root package name */
        public T f5637b = null;

        public a() {
        }
    }

    public final <T> List<T> a(int i6) {
        try {
            a aVar = this.f5635a.get(Integer.valueOf(i6));
            if (aVar != null) {
                return aVar.f5636a;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public final <T> void b() {
        ConcurrentHashMap<Integer, a> concurrentHashMap = this.f5635a;
        if (concurrentHashMap == null) {
            return;
        }
        try {
            Iterator<Map.Entry<Integer, a>> it = concurrentHashMap.entrySet().iterator();
            while (it.hasNext()) {
                a value = it.next().getValue();
                value.f5636a.clear();
                value.f5637b = null;
            }
            this.f5635a.clear();
        } catch (Throwable unused) {
        }
    }

    public final <T> void c(int i6, T t5) {
        ConcurrentHashMap<Integer, a> concurrentHashMap = this.f5635a;
        if (concurrentHashMap == null) {
            return;
        }
        try {
            a aVar = concurrentHashMap.get(Integer.valueOf(i6));
            if (aVar == null) {
                aVar = new a();
                this.f5635a.putIfAbsent(Integer.valueOf(i6), aVar);
            }
            if (aVar.f5637b == t5) {
                return;
            }
            f(Integer.valueOf(i6), aVar.f5637b);
            aVar.f5637b = t5;
            e(Integer.valueOf(i6), t5);
        } catch (Throwable unused) {
        }
    }

    public final <T> void d(Integer num) {
        a aVar;
        List<T> list;
        try {
            if (!this.f5635a.containsKey(num) || (aVar = this.f5635a.get(num)) == null || (list = aVar.f5636a) == null) {
                return;
            }
            list.clear();
        } catch (Throwable unused) {
        }
    }

    public final <T> void e(Integer num, T t5) {
        ConcurrentHashMap<Integer, a> concurrentHashMap;
        if (t5 == null || (concurrentHashMap = this.f5635a) == null) {
            return;
        }
        try {
            a aVar = concurrentHashMap.get(num);
            if (aVar == null) {
                aVar = new a();
                this.f5635a.putIfAbsent(num, aVar);
            }
            List<T> list = aVar.f5636a;
            if (list == null || list.contains(t5)) {
                return;
            }
            aVar.f5636a.add(t5);
        } catch (Throwable unused) {
        }
    }

    public final <T> void f(Integer num, T t5) {
        ConcurrentHashMap<Integer, a> concurrentHashMap;
        a aVar;
        List<T> list;
        if (t5 == null || (concurrentHashMap = this.f5635a) == null) {
            return;
        }
        try {
            if (!concurrentHashMap.containsKey(num) || (aVar = this.f5635a.get(num)) == null || (list = aVar.f5636a) == null || !list.contains(t5)) {
                return;
            }
            aVar.f5636a.remove(t5);
        } catch (Throwable unused) {
        }
    }
}
