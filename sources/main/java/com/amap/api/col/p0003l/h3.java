package com.amap.api.col.p0003l;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class h3 implements f3 {

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, a> f6399a = new ConcurrentHashMap();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a {

        /* renamed from: a, reason: collision with root package name */
        String f6400a;

        /* renamed from: b, reason: collision with root package name */
        String f6401b;

        /* renamed from: c, reason: collision with root package name */
        int f6402c;

        /* renamed from: d, reason: collision with root package name */
        final AtomicInteger f6403d = new AtomicInteger(0);

        public a(int i6, String str, String str2) {
            this.f6400a = str;
            this.f6401b = str2;
            this.f6402c = i6;
        }

        public final int a() {
            return this.f6403d.incrementAndGet();
        }
    }

    @Override // com.amap.api.col.p0003l.f3
    public final void a(int i6, String str, String str2) {
        try {
            String c6 = c(i6, str, str2);
            a aVar = f6399a.get(c6);
            if (aVar == null) {
                aVar = new a(i6, str, str2);
                f6399a.put(c6, aVar);
            }
            if (aVar.a() > 100) {
                b(aVar.f6402c, aVar.f6400a, aVar.f6401b, aVar.f6403d.get());
                f6399a.remove(c6);
            }
        } catch (Throwable unused) {
        }
    }

    private static void b(int i6, String str, String str2, int i7) {
        if (i6 == 0) {
            b5.c(b3.s()).h(a5.b(str, str2 + " counter " + i7));
        } else {
            b5.c(b3.s()).h(a5.b(str, str2 + " counter " + i7));
        }
        if (c3.f5802b) {
            d(i6, str, str2 + " counter " + i7);
        }
    }

    private static String c(int i6, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(i6);
        if (str == null) {
            str = "";
        }
        sb.append(str);
        if (str2 == null) {
            str2 = "";
        }
        sb.append(str2);
        return sb.toString();
    }

    @Override // com.amap.api.col.p0003l.f3
    public final void a() {
        try {
            Iterator<Map.Entry<String, a>> it = f6399a.entrySet().iterator();
            while (it.hasNext()) {
                a value = it.next().getValue();
                if (value != null) {
                    b(value.f6402c, value.f6400a, value.f6401b, value.f6403d.get());
                }
            }
            f6399a.clear();
            b5.c(b3.s()).e();
        } catch (Throwable unused) {
        }
    }

    private static void d(int i6, String str, String str2) {
    }
}
