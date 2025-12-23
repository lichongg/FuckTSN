package com.kwad.framework.filedownloader.b;

import android.util.SparseArray;
import com.kwad.framework.filedownloader.b.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b implements com.kwad.framework.filedownloader.b.a {
    final SparseArray<com.kwad.framework.filedownloader.d.c> amG = new SparseArray<>();
    final SparseArray<List<com.kwad.framework.filedownloader.d.a>> amH = new SparseArray<>();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements a.InterfaceC0654a {
        a() {
        }

        @Override // java.lang.Iterable
        public final Iterator<com.kwad.framework.filedownloader.d.c> iterator() {
            return b.this.new C0655b();
        }

        @Override // com.kwad.framework.filedownloader.b.a.InterfaceC0654a
        public final void xU() {
        }

        @Override // com.kwad.framework.filedownloader.b.a.InterfaceC0654a
        public final void c(com.kwad.framework.filedownloader.d.c cVar) {
        }

        @Override // com.kwad.framework.filedownloader.b.a.InterfaceC0654a
        public final void a(int i6, com.kwad.framework.filedownloader.d.c cVar) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.framework.filedownloader.b.b$b, reason: collision with other inner class name */
    class C0655b implements Iterator<com.kwad.framework.filedownloader.d.c> {
        @Override // java.util.Iterator
        public final boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public final /* bridge */ /* synthetic */ com.kwad.framework.filedownloader.d.c next() {
            return null;
        }

        C0655b() {
        }

        @Override // java.util.Iterator
        public final void remove() {
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i6, long j6, String str, String str2) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void b(int i6, long j6) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void d(int i6, long j6) {
    }

    private void d(com.kwad.framework.filedownloader.d.c cVar) {
        synchronized (this.amG) {
            this.amG.put(cVar.getId(), cVar);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i6, String str, long j6, long j7, int i7) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void b(com.kwad.framework.filedownloader.d.c cVar) {
        if (cVar == null) {
            com.kwad.framework.filedownloader.f.d.d(this, "update but model == null!", new Object[0]);
            return;
        }
        if (bD(cVar.getId()) == null) {
            d(cVar);
            return;
        }
        synchronized (this.amG) {
            this.amG.remove(cVar.getId());
            this.amG.put(cVar.getId(), cVar);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final com.kwad.framework.filedownloader.d.c bD(int i6) {
        com.kwad.framework.filedownloader.d.c cVar;
        synchronized (this.amG) {
            cVar = this.amG.get(i6);
        }
        return cVar;
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final List<com.kwad.framework.filedownloader.d.a> bE(int i6) {
        List<com.kwad.framework.filedownloader.d.a> list;
        try {
            ArrayList arrayList = new ArrayList();
            synchronized (this.amH) {
                list = this.amH.get(i6);
            }
            if (list != null) {
                arrayList.addAll(list);
            }
            return arrayList;
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bF(int i6) {
        try {
            synchronized (this.amH) {
                this.amH.remove(i6);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final boolean bG(int i6) {
        synchronized (this.amG) {
            this.amG.remove(i6);
        }
        return true;
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void clear() {
        synchronized (this.amG) {
            this.amG.clear();
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final a.InterfaceC0654a xT() {
        return new a();
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i6, Throwable th) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void c(int i6, long j6) {
        bG(i6);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i6, Throwable th, long j6) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(com.kwad.framework.filedownloader.d.a aVar) {
        List<com.kwad.framework.filedownloader.d.a> list;
        try {
            int id = aVar.getId();
            synchronized (this.amH) {
                try {
                    list = this.amH.get(id);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.amH.put(id, list);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            list.add(aVar);
        } catch (Exception unused) {
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i6, int i7, long j6) {
        List<com.kwad.framework.filedownloader.d.a> list;
        synchronized (this.amH) {
            list = this.amH.get(i6);
        }
        if (list == null) {
            return;
        }
        for (com.kwad.framework.filedownloader.d.a aVar : list) {
            if (aVar.getIndex() == i7) {
                aVar.X(j6);
                return;
            }
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bC(int i6) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bH(int i6) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void t(int i6, int i7) {
    }
}
