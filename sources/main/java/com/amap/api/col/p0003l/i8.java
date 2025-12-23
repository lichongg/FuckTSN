package com.amap.api.col.p0003l;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class i8 {

    /* renamed from: a, reason: collision with root package name */
    private ko f6521a;

    /* renamed from: b, reason: collision with root package name */
    private ko f6522b;

    /* renamed from: c, reason: collision with root package name */
    private k9 f6523c;

    /* renamed from: d, reason: collision with root package name */
    private a f6524d = new a();

    /* renamed from: e, reason: collision with root package name */
    private final List<ko> f6525e = new ArrayList(3);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public byte f6526a;

        /* renamed from: b, reason: collision with root package name */
        public String f6527b;

        /* renamed from: c, reason: collision with root package name */
        public ko f6528c;

        /* renamed from: d, reason: collision with root package name */
        public ko f6529d;

        /* renamed from: e, reason: collision with root package name */
        public ko f6530e;

        /* renamed from: f, reason: collision with root package name */
        public List<ko> f6531f = new ArrayList();

        /* renamed from: g, reason: collision with root package name */
        public List<ko> f6532g = new ArrayList();

        public static boolean c(ko koVar, ko koVar2) {
            if (koVar == null || koVar2 == null) {
                return (koVar == null) == (koVar2 == null);
            }
            if ((koVar instanceof kq) && (koVar2 instanceof kq)) {
                kq kqVar = (kq) koVar;
                kq kqVar2 = (kq) koVar2;
                return kqVar.f6713j == kqVar2.f6713j && kqVar.f6714k == kqVar2.f6714k;
            }
            if ((koVar instanceof kp) && (koVar2 instanceof kp)) {
                kp kpVar = (kp) koVar;
                kp kpVar2 = (kp) koVar2;
                return kpVar.f6710l == kpVar2.f6710l && kpVar.f6709k == kpVar2.f6709k && kpVar.f6708j == kpVar2.f6708j;
            }
            if ((koVar instanceof kr) && (koVar2 instanceof kr)) {
                kr krVar = (kr) koVar;
                kr krVar2 = (kr) koVar2;
                return krVar.f6719j == krVar2.f6719j && krVar.f6720k == krVar2.f6720k;
            }
            if ((koVar instanceof ks) && (koVar2 instanceof ks)) {
                ks ksVar = (ks) koVar;
                ks ksVar2 = (ks) koVar2;
                if (ksVar.f6724j == ksVar2.f6724j && ksVar.f6725k == ksVar2.f6725k) {
                    return true;
                }
            }
            return false;
        }

        public final void a() {
            this.f6526a = (byte) 0;
            this.f6527b = "";
            this.f6528c = null;
            this.f6529d = null;
            this.f6530e = null;
            this.f6531f.clear();
            this.f6532g.clear();
        }

        public final String toString() {
            return "CellInfo{radio=" + ((int) this.f6526a) + ", operator='" + this.f6527b + "', mainCell=" + this.f6528c + ", mainOldInterCell=" + this.f6529d + ", mainNewInterCell=" + this.f6530e + ", cells=" + this.f6531f + ", historyMainCellList=" + this.f6532g + '}';
        }

        public final void b(byte b6, String str, List<ko> list) {
            a();
            this.f6526a = b6;
            this.f6527b = str;
            if (list != null) {
                this.f6531f.addAll(list);
                for (ko koVar : this.f6531f) {
                    boolean z5 = koVar.f6707i;
                    if (!z5 && koVar.f6706h) {
                        this.f6529d = koVar;
                    } else if (z5 && koVar.f6706h) {
                        this.f6530e = koVar;
                    }
                }
            }
            ko koVar2 = this.f6529d;
            if (koVar2 == null) {
                koVar2 = this.f6530e;
            }
            this.f6528c = koVar2;
        }
    }

    final a a(k9 k9Var, boolean z5, byte b6, String str, List<ko> list) {
        if (z5) {
            this.f6524d.a();
            return null;
        }
        this.f6524d.b(b6, str, list);
        if (this.f6524d.f6528c == null) {
            return null;
        }
        if (this.f6523c != null && !d(k9Var) && a.c(this.f6524d.f6529d, this.f6521a) && a.c(this.f6524d.f6530e, this.f6522b)) {
            return null;
        }
        a aVar = this.f6524d;
        this.f6521a = aVar.f6529d;
        this.f6522b = aVar.f6530e;
        this.f6523c = k9Var;
        f9.c(aVar.f6531f);
        b(this.f6524d);
        return this.f6524d;
    }

    private void b(a aVar) {
        synchronized (this.f6525e) {
            try {
                for (ko koVar : aVar.f6531f) {
                    if (koVar != null && koVar.f6706h) {
                        ko clone = koVar.clone();
                        clone.f6703e = SystemClock.elapsedRealtime();
                        c(clone);
                    }
                }
                this.f6524d.f6532g.clear();
                this.f6524d.f6532g.addAll(this.f6525e);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void c(ko koVar) {
        if (koVar == null) {
            return;
        }
        int size = this.f6525e.size();
        if (size == 0) {
            this.f6525e.add(koVar);
            return;
        }
        int i6 = -1;
        long j6 = Long.MAX_VALUE;
        int i7 = 0;
        int i8 = -1;
        while (true) {
            if (i7 >= size) {
                i6 = i8;
                break;
            }
            ko koVar2 = this.f6525e.get(i7);
            if (koVar.equals(koVar2)) {
                int i9 = koVar.f6701c;
                if (i9 != koVar2.f6701c) {
                    koVar2.f6703e = i9;
                    koVar2.f6701c = i9;
                }
            } else {
                j6 = Math.min(j6, koVar2.f6703e);
                if (j6 == koVar2.f6703e) {
                    i8 = i7;
                }
                i7++;
            }
        }
        if (i6 >= 0) {
            if (size < 3) {
                this.f6525e.add(koVar);
            } else {
                if (koVar.f6703e <= j6 || i6 >= size) {
                    return;
                }
                this.f6525e.remove(i6);
                this.f6525e.add(koVar);
            }
        }
    }

    private boolean d(k9 k9Var) {
        float f6 = k9Var.f6659g;
        return k9Var.a(this.f6523c) > ((double) ((f6 > 10.0f ? 1 : (f6 == 10.0f ? 0 : -1)) > 0 ? 2000.0f : (f6 > 2.0f ? 1 : (f6 == 2.0f ? 0 : -1)) > 0 ? 500.0f : 100.0f));
    }
}
