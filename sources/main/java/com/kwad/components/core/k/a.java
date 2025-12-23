package com.kwad.components.core.k;

import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    private CopyOnWriteArrayList<b> Rl = new CopyOnWriteArrayList<>();
    private volatile boolean Rm;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.components.core.k.a$a, reason: collision with other inner class name */
    static final class C0622a {
        private static final a Rn = new a();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b {
        private final c Ro;
        public boolean Rp;

        public b(c cVar) {
            this.Ro = cVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface c {
        void bF();
    }

    public static boolean b(b bVar) {
        if (bVar == null) {
            return true;
        }
        return bVar.Rp;
    }

    public final void a(b bVar) {
        if (this.Rl.contains(bVar)) {
            return;
        }
        if (!this.Rm) {
            this.Rm = true;
            bVar.Rp = true;
        }
        this.Rl.add(bVar);
    }

    public final void c(b bVar) {
        if (bVar == null) {
            return;
        }
        if (bVar.Rp) {
            bVar.Rp = false;
            this.Rm = false;
        }
        this.Rl.remove(bVar);
        if (this.Rl.size() == 0 || this.Rm) {
            return;
        }
        this.Rl.get(0).Rp = true;
        this.Rm = true;
        this.Rl.get(0).Ro.bF();
    }

    public static a qp() {
        return C0622a.Rn;
    }
}
