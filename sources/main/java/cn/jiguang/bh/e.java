package cn.jiguang.bh;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes2.dex */
public class e implements Cloneable {

    /* renamed from: d, reason: collision with root package name */
    private static i[] f2169d = new i[0];

    /* renamed from: e, reason: collision with root package name */
    private static h[] f2170e = new h[0];

    /* renamed from: a, reason: collision with root package name */
    private d f2171a;

    /* renamed from: b, reason: collision with root package name */
    private List[] f2172b;

    /* renamed from: c, reason: collision with root package name */
    private int f2173c;

    public e() {
        this(new d());
    }

    private int a(c cVar, int i6, a aVar, int i7) {
        int size = this.f2172b[i6].size();
        int a6 = cVar.a();
        i iVar = null;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            i iVar2 = (i) this.f2172b[i6].get(i10);
            if (i6 == 3) {
                i8++;
            } else {
                if (iVar != null && !a(iVar2, iVar)) {
                    a6 = cVar.a();
                    i9 = i10;
                }
                iVar2.a(cVar, i6, aVar);
                if (cVar.a() > i7) {
                    cVar.a(a6);
                    return (size - i9) + i8;
                }
                iVar = iVar2;
            }
        }
        return i8;
    }

    e(b bVar) {
        this(new d(bVar));
        for (int i6 = 0; i6 < 4; i6++) {
            int c6 = this.f2171a.c(i6);
            if (c6 > 0) {
                this.f2172b[i6] = new ArrayList(c6);
            }
            for (int i7 = 0; i7 < c6; i7++) {
                this.f2172b[i6].add(i.a(bVar, i6));
            }
        }
        this.f2173c = bVar.a();
    }

    public static e a(i iVar) {
        e eVar = new e();
        eVar.a(iVar, 0);
        return eVar;
    }

    public h[] b(int i6) {
        if (this.f2172b[i6] == null) {
            return f2170e;
        }
        LinkedList linkedList = new LinkedList();
        i[] a6 = a(i6);
        HashSet hashSet = new HashSet();
        for (int i7 = 0; i7 < a6.length; i7++) {
            g d6 = a6[i7].d();
            if (hashSet.contains(d6)) {
                for (int size = linkedList.size() - 1; size >= 0; size--) {
                    h hVar = (h) linkedList.get(size);
                    if (hVar.c() == a6[i7].f() && hVar.d() == a6[i7].g() && hVar.b().equals(d6)) {
                        hVar.a(a6[i7]);
                        break;
                    }
                }
            }
            linkedList.add(new h(a6[i7]));
            hashSet.add(d6);
        }
        return (h[]) linkedList.toArray(new h[linkedList.size()]);
    }

    public byte[] c(int i6) {
        c cVar = new c();
        a(cVar, i6);
        this.f2173c = cVar.a();
        return cVar.b();
    }

    public Object clone() {
        e eVar = new e();
        int i6 = 0;
        while (true) {
            List[] listArr = this.f2172b;
            if (i6 >= listArr.length) {
                eVar.f2171a = (d) this.f2171a.clone();
                eVar.f2173c = this.f2173c;
                return eVar;
            }
            if (listArr[i6] != null) {
                eVar.f2172b[i6] = new LinkedList(this.f2172b[i6]);
            }
            i6++;
        }
    }

    private e(d dVar) {
        this.f2172b = new List[4];
        this.f2171a = dVar;
    }

    public i a() {
        List list = this.f2172b[0];
        if (list == null || list.size() == 0) {
            return null;
        }
        return (i) list.get(0);
    }

    public e(byte[] bArr) {
        this(new b(bArr));
    }

    public void a(i iVar, int i6) {
        List[] listArr = this.f2172b;
        if (listArr[i6] == null) {
            listArr[i6] = new LinkedList();
        }
        this.f2171a.b(i6);
        this.f2172b[i6].add(iVar);
    }

    private boolean a(c cVar, int i6) {
        if (i6 < 12) {
            return false;
        }
        cVar.a();
        this.f2171a.a(cVar);
        a aVar = new a();
        this.f2171a.c();
        for (int i7 = 0; i7 < 4; i7++) {
            if (this.f2172b[i7] != null) {
                a(cVar, i7, aVar, i6);
            }
        }
        return true;
    }

    private static boolean a(i iVar, i iVar2) {
        return iVar.f() == iVar2.f() && iVar.g() == iVar2.g() && iVar.d().equals(iVar2.d());
    }

    public i[] a(int i6) {
        List list = this.f2172b[i6];
        return list == null ? f2169d : (i[]) list.toArray(new i[list.size()]);
    }
}
