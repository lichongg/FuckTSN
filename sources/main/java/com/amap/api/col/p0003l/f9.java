package com.amap.api.col.p0003l;

import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class f9 {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a implements d9 {

        /* renamed from: a, reason: collision with root package name */
        private int f6192a;

        /* renamed from: b, reason: collision with root package name */
        private int f6193b;

        /* renamed from: c, reason: collision with root package name */
        private int f6194c;

        @Override // com.amap.api.col.p0003l.d9
        public final long a() {
            return f9.a(this.f6192a, this.f6193b);
        }

        @Override // com.amap.api.col.p0003l.d9
        public final int b() {
            return this.f6194c;
        }

        a(int i6, int i7, int i8) {
            this.f6192a = i6;
            this.f6193b = i7;
            this.f6194c = i8;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b implements d9 {

        /* renamed from: a, reason: collision with root package name */
        private long f6195a;

        /* renamed from: b, reason: collision with root package name */
        private int f6196b;

        @Override // com.amap.api.col.p0003l.d9
        public final long a() {
            return this.f6195a;
        }

        @Override // com.amap.api.col.p0003l.d9
        public final int b() {
            return this.f6196b;
        }

        b(long j6, int i6) {
            this.f6195a = j6;
            this.f6196b = i6;
        }
    }

    public static long a(int i6, int i7) {
        return (i7 & 4294967295L) | ((i6 & 4294967295L) << 32);
    }

    public static synchronized short b(long j6) {
        short b6;
        synchronized (f9.class) {
            b6 = e9.a().b(j6);
        }
        return b6;
    }

    public static synchronized void c(List<ko> list) {
        synchronized (f9.class) {
            if (list != null) {
                try {
                    if (!list.isEmpty()) {
                        ArrayList arrayList = new ArrayList(list.size());
                        for (ko koVar : list) {
                            if (koVar instanceof kq) {
                                kq kqVar = (kq) koVar;
                                arrayList.add(new a(kqVar.f6713j, kqVar.f6714k, kqVar.f6701c));
                            } else if (koVar instanceof kr) {
                                kr krVar = (kr) koVar;
                                arrayList.add(new a(krVar.f6719j, krVar.f6720k, krVar.f6701c));
                            } else if (koVar instanceof ks) {
                                ks ksVar = (ks) koVar;
                                arrayList.add(new a(ksVar.f6724j, ksVar.f6725k, ksVar.f6701c));
                            } else if (koVar instanceof kp) {
                                kp kpVar = (kp) koVar;
                                arrayList.add(new a(kpVar.f6709k, kpVar.f6710l, kpVar.f6701c));
                            }
                        }
                        e9.a().d(arrayList);
                    }
                } finally {
                }
            }
        }
    }

    public static synchronized short d(long j6) {
        short g6;
        synchronized (f9.class) {
            g6 = e9.a().g(j6);
        }
        return g6;
    }

    public static synchronized void e(List<l9> list) {
        synchronized (f9.class) {
            if (list != null) {
                try {
                    if (!list.isEmpty()) {
                        ArrayList arrayList = new ArrayList(list.size());
                        for (l9 l9Var : list) {
                            arrayList.add(new b(l9Var.f6745a, l9Var.f6747c));
                        }
                        e9.a().h(arrayList);
                    }
                } finally {
                }
            }
        }
    }
}
