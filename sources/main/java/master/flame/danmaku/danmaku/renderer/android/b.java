package master.flame.danmaku.danmaku.renderer.android;

import master.flame.danmaku.danmaku.model.m;
import master.flame.danmaku.danmaku.model.n;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private e f50171a = null;

    /* renamed from: b, reason: collision with root package name */
    private e f50172b = null;

    /* renamed from: c, reason: collision with root package name */
    private e f50173c = null;

    /* renamed from: d, reason: collision with root package name */
    private e f50174d = null;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: master.flame.danmaku.danmaku.renderer.android.b$b, reason: collision with other inner class name */
    private static class C0974b extends d {

        /* renamed from: d, reason: collision with root package name */
        protected a f50175d;

        /* renamed from: e, reason: collision with root package name */
        protected master.flame.danmaku.danmaku.model.android.e f50176e;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: master.flame.danmaku.danmaku.renderer.android.b$b$a */
        protected class a extends m.b<master.flame.danmaku.danmaku.model.d, f> {

            /* renamed from: e, reason: collision with root package name */
            public n f50177e;

            /* renamed from: f, reason: collision with root package name */
            int f50178f = 0;

            /* renamed from: g, reason: collision with root package name */
            public master.flame.danmaku.danmaku.model.d f50179g = null;

            /* renamed from: h, reason: collision with root package name */
            public master.flame.danmaku.danmaku.model.d f50180h = null;

            /* renamed from: i, reason: collision with root package name */
            public master.flame.danmaku.danmaku.model.d f50181i = null;

            /* renamed from: j, reason: collision with root package name */
            boolean f50182j = false;

            /* renamed from: k, reason: collision with root package name */
            float f50183k;

            @Override // master.flame.danmaku.danmaku.model.m.b
            public void c() {
                this.f50178f = 0;
                this.f50180h = null;
                this.f50179g = null;
                this.f50182j = false;
            }

            protected a() {
            }

            @Override // master.flame.danmaku.danmaku.model.m.b
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public int a(master.flame.danmaku.danmaku.model.d dVar) {
                if (C0974b.this.f50186b) {
                    return 1;
                }
                this.f50178f++;
                if (dVar == this.f50181i) {
                    this.f50179g = null;
                    this.f50182j = false;
                    return 1;
                }
                if (this.f50180h == null) {
                    this.f50180h = dVar;
                    if (dVar.d() != this.f50177e.getHeight()) {
                        return 1;
                    }
                }
                if (this.f50183k < this.f50177e.k()) {
                    this.f50179g = null;
                    return 1;
                }
                n nVar = this.f50177e;
                master.flame.danmaku.danmaku.model.d dVar2 = this.f50181i;
                boolean i6 = w4.a.i(nVar, dVar, dVar2, dVar2.f(), this.f50181i.k().f50080a);
                this.f50182j = i6;
                if (i6) {
                    this.f50183k = (dVar.l() - this.f50177e.h()) - this.f50181i.f50070q;
                    return 0;
                }
                this.f50179g = dVar;
                return 1;
            }

            @Override // master.flame.danmaku.danmaku.model.m.b
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public f d() {
                f fVar = new f(null);
                fVar.f50199a = this.f50178f;
                fVar.f50201c = this.f50180h;
                fVar.f50204f = this.f50179g;
                fVar.f50207i = this.f50182j;
                return fVar;
            }
        }

        private C0974b() {
            super(null);
            this.f50175d = new a();
            this.f50176e = new master.flame.danmaku.danmaku.model.android.e(2);
        }

        @Override // master.flame.danmaku.danmaku.renderer.android.b.c, master.flame.danmaku.danmaku.renderer.android.b.e
        public void clear() {
            this.f50186b = true;
            this.f50176e.clear();
        }

        @Override // master.flame.danmaku.danmaku.renderer.android.b.c, master.flame.danmaku.danmaku.renderer.android.b.e
        public void a(master.flame.danmaku.danmaku.model.d dVar, n nVar, g gVar) {
            n nVar2;
            boolean z5;
            boolean z6;
            master.flame.danmaku.danmaku.model.d dVar2;
            int i6;
            if (dVar.s()) {
                return;
            }
            boolean v5 = dVar.v();
            float l6 = v5 ? dVar.l() : -1.0f;
            int i7 = 1;
            boolean z7 = false;
            boolean z8 = (v5 || this.f50176e.isEmpty()) ? false : true;
            if (l6 < nVar.k()) {
                l6 = nVar.getHeight() - dVar.f50070q;
            }
            master.flame.danmaku.danmaku.model.d dVar3 = null;
            if (v5) {
                nVar2 = nVar;
                i7 = 0;
            } else {
                this.f50186b = false;
                a aVar = this.f50175d;
                aVar.f50183k = l6;
                aVar.f50177e = nVar;
                aVar.f50181i = dVar;
                this.f50176e.a(aVar);
                f d6 = this.f50175d.d();
                float f6 = this.f50175d.f50183k;
                if (d6 != null) {
                    int i8 = d6.f50199a;
                    dVar3 = d6.f50201c;
                    master.flame.danmaku.danmaku.model.d dVar4 = d6.f50204f;
                    boolean z9 = d6.f50206h;
                    z6 = d6.f50207i;
                    dVar2 = dVar4;
                    z5 = z9;
                    i6 = i8;
                } else {
                    z5 = v5;
                    z6 = z8;
                    dVar2 = null;
                    i6 = 0;
                }
                boolean b6 = b(false, dVar, nVar, f6, dVar3, null);
                nVar2 = nVar;
                if (b6) {
                    z7 = b6;
                    dVar3 = dVar2;
                    z8 = true;
                    l6 = nVar2.getHeight() - dVar.f50070q;
                } else {
                    boolean z10 = f6 >= ((float) nVar2.k()) ? false : z6;
                    if (dVar2 != null) {
                        z7 = b6;
                        l6 = f6;
                        z8 = z10;
                        dVar3 = dVar2;
                        i7 = i6 - 1;
                    } else {
                        z7 = b6;
                        l6 = f6;
                        z8 = z10;
                        i7 = i6;
                        v5 = z5;
                        dVar3 = dVar2;
                    }
                }
                v5 = z5;
            }
            if (gVar == null || !gVar.a(dVar, l6, i7, z8)) {
                if (z7) {
                    clear();
                }
                dVar.y(nVar2, dVar.g(), l6);
                if (v5) {
                    return;
                }
                this.f50176e.e(dVar3);
                this.f50176e.j(dVar);
            }
        }

        @Override // master.flame.danmaku.danmaku.renderer.android.b.d, master.flame.danmaku.danmaku.renderer.android.b.c
        protected boolean b(boolean z5, master.flame.danmaku.danmaku.model.d dVar, n nVar, float f6, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            if (f6 >= nVar.k()) {
                if (dVar2 == null || dVar2.d() == nVar.getHeight()) {
                    return false;
                }
                return true;
            }
            return true;
        }

        /* synthetic */ C0974b(a aVar) {
            this();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class c implements e {

        /* renamed from: a, reason: collision with root package name */
        protected master.flame.danmaku.danmaku.model.android.e f50185a;

        /* renamed from: b, reason: collision with root package name */
        protected boolean f50186b;

        /* renamed from: c, reason: collision with root package name */
        protected a f50187c;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        protected class a extends m.b<master.flame.danmaku.danmaku.model.d, f> {

            /* renamed from: e, reason: collision with root package name */
            public n f50188e;

            /* renamed from: f, reason: collision with root package name */
            int f50189f = 0;

            /* renamed from: g, reason: collision with root package name */
            public master.flame.danmaku.danmaku.model.d f50190g = null;

            /* renamed from: h, reason: collision with root package name */
            public master.flame.danmaku.danmaku.model.d f50191h = null;

            /* renamed from: i, reason: collision with root package name */
            public master.flame.danmaku.danmaku.model.d f50192i = null;

            /* renamed from: j, reason: collision with root package name */
            public master.flame.danmaku.danmaku.model.d f50193j = null;

            /* renamed from: k, reason: collision with root package name */
            public master.flame.danmaku.danmaku.model.d f50194k = null;

            /* renamed from: l, reason: collision with root package name */
            boolean f50195l = false;

            /* renamed from: m, reason: collision with root package name */
            boolean f50196m = false;

            /* renamed from: n, reason: collision with root package name */
            boolean f50197n = false;

            @Override // master.flame.danmaku.danmaku.model.m.b
            public void c() {
                this.f50189f = 0;
                this.f50193j = null;
                this.f50192i = null;
                this.f50191h = null;
                this.f50190g = null;
                this.f50197n = false;
                this.f50196m = false;
                this.f50195l = false;
            }

            protected a() {
            }

            @Override // master.flame.danmaku.danmaku.model.m.b
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public int a(master.flame.danmaku.danmaku.model.d dVar) {
                if (c.this.f50186b) {
                    return 1;
                }
                this.f50189f++;
                master.flame.danmaku.danmaku.model.d dVar2 = this.f50194k;
                if (dVar == dVar2) {
                    this.f50190g = dVar;
                    this.f50192i = null;
                    this.f50196m = true;
                    this.f50197n = false;
                    return 1;
                }
                if (this.f50191h == null) {
                    this.f50191h = dVar;
                }
                if (dVar2.f50070q + dVar.l() > this.f50188e.getHeight()) {
                    this.f50195l = true;
                    return 1;
                }
                master.flame.danmaku.danmaku.model.d dVar3 = this.f50193j;
                if (dVar3 == null) {
                    this.f50193j = dVar;
                } else if (dVar3.i() >= dVar.i()) {
                    this.f50193j = dVar;
                }
                n nVar = this.f50188e;
                master.flame.danmaku.danmaku.model.d dVar4 = this.f50194k;
                boolean i6 = w4.a.i(nVar, dVar, dVar4, dVar4.f(), this.f50194k.k().f50080a);
                this.f50197n = i6;
                if (i6) {
                    this.f50192i = dVar;
                    return 0;
                }
                this.f50190g = dVar;
                return 1;
            }

            @Override // master.flame.danmaku.danmaku.model.m.b
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public f d() {
                f fVar = new f(null);
                fVar.f50199a = this.f50189f;
                fVar.f50201c = this.f50191h;
                fVar.f50200b = this.f50190g;
                fVar.f50202d = this.f50192i;
                fVar.f50203e = this.f50193j;
                fVar.f50205g = this.f50195l;
                fVar.f50206h = this.f50196m;
                fVar.f50207i = this.f50197n;
                return fVar;
            }
        }

        private c() {
            this.f50185a = new master.flame.danmaku.danmaku.model.android.e(1);
            this.f50186b = false;
            this.f50187c = new a();
        }

        @Override // master.flame.danmaku.danmaku.renderer.android.b.e
        public void clear() {
            this.f50186b = true;
            this.f50185a.clear();
        }

        @Override // master.flame.danmaku.danmaku.renderer.android.b.e
        public void a(master.flame.danmaku.danmaku.model.d dVar, n nVar, g gVar) {
            boolean z5;
            boolean z6;
            master.flame.danmaku.danmaku.model.d dVar2;
            master.flame.danmaku.danmaku.model.d dVar3;
            master.flame.danmaku.danmaku.model.d dVar4;
            master.flame.danmaku.danmaku.model.d dVar5;
            int i6;
            boolean z7;
            float k6;
            boolean z8;
            master.flame.danmaku.danmaku.model.d dVar6;
            boolean z9;
            float d6;
            boolean z10;
            if (dVar.s()) {
                return;
            }
            float k7 = nVar.k();
            boolean v5 = dVar.v();
            int i7 = 1;
            int i8 = 0;
            boolean z11 = (v5 || this.f50185a.isEmpty()) ? false : true;
            int h6 = nVar.h();
            master.flame.danmaku.danmaku.model.d dVar7 = null;
            if (v5) {
                z5 = false;
            } else {
                this.f50186b = false;
                a aVar = this.f50187c;
                aVar.f50188e = nVar;
                aVar.f50194k = dVar;
                this.f50185a.a(aVar);
                f d7 = this.f50187c.d();
                if (d7 != null) {
                    int i9 = d7.f50199a;
                    dVar2 = d7.f50200b;
                    master.flame.danmaku.danmaku.model.d dVar8 = d7.f50201c;
                    master.flame.danmaku.danmaku.model.d dVar9 = d7.f50202d;
                    master.flame.danmaku.danmaku.model.d dVar10 = d7.f50203e;
                    boolean z12 = d7.f50205g;
                    boolean z13 = d7.f50206h;
                    z6 = d7.f50207i;
                    i6 = i9;
                    v5 = z13;
                    z7 = z12;
                    dVar5 = dVar10;
                    dVar4 = dVar9;
                    dVar3 = dVar8;
                } else {
                    z6 = z11;
                    dVar2 = null;
                    dVar3 = null;
                    dVar4 = null;
                    dVar5 = null;
                    i6 = 0;
                    z7 = false;
                }
                if (dVar2 != null) {
                    k6 = dVar4 != null ? dVar4.d() + h6 : dVar2.l();
                    if (dVar2 != dVar) {
                        z8 = z6;
                        dVar6 = dVar2;
                        d6 = k6;
                        z10 = true;
                        z9 = false;
                    }
                    float f6 = k6;
                    z9 = v5;
                    d6 = f6;
                    dVar6 = null;
                    z8 = z6;
                    z10 = true;
                } else if (z7 && dVar5 != null) {
                    dVar6 = null;
                    d6 = dVar5.l();
                    z9 = false;
                    z8 = z6;
                    z10 = false;
                } else if (dVar4 != null) {
                    z9 = v5;
                    d6 = dVar4.d() + h6;
                    dVar6 = null;
                    z10 = true;
                    z8 = false;
                } else if (dVar3 != null) {
                    k6 = dVar3.l();
                    z8 = z6;
                    dVar6 = dVar3;
                    d6 = k6;
                    z10 = true;
                    z9 = false;
                } else {
                    k6 = nVar.k();
                    float f62 = k6;
                    z9 = v5;
                    d6 = f62;
                    dVar6 = null;
                    z8 = z6;
                    z10 = true;
                }
                boolean b6 = z10 ? b(z7, dVar, nVar, d6, dVar3, dVar4) : false;
                if (b6) {
                    d6 = nVar.k();
                    z8 = true;
                } else {
                    i7 = dVar6 != null ? i6 - 1 : i6;
                }
                z5 = b6;
                k7 = d6;
                i8 = i7;
                if (d6 == nVar.k()) {
                    z11 = z8;
                    dVar7 = dVar6;
                    v5 = false;
                } else {
                    z11 = z8;
                    v5 = z9;
                    dVar7 = dVar6;
                }
            }
            if (gVar == null || !gVar.a(dVar, k7, i8, z11)) {
                if (z5) {
                    clear();
                }
                dVar.y(nVar, dVar.g(), k7);
                if (v5) {
                    return;
                }
                this.f50185a.e(dVar7);
                this.f50185a.j(dVar);
            }
        }

        protected boolean b(boolean z5, master.flame.danmaku.danmaku.model.d dVar, n nVar, float f6, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            if (f6 >= nVar.k()) {
                if ((dVar2 == null || dVar2.l() <= 0.0f) && f6 + dVar.f50070q <= nVar.getHeight()) {
                    return false;
                }
                return true;
            }
            return true;
        }

        /* synthetic */ c(a aVar) {
            this();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class d extends c {
        private d() {
            super(null);
        }

        /* synthetic */ d(a aVar) {
            this();
        }

        @Override // master.flame.danmaku.danmaku.renderer.android.b.c
        protected boolean b(boolean z5, master.flame.danmaku.danmaku.model.d dVar, n nVar, float f6, master.flame.danmaku.danmaku.model.d dVar2, master.flame.danmaku.danmaku.model.d dVar3) {
            return f6 + dVar.f50070q > ((float) nVar.getHeight());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface e {
        void a(master.flame.danmaku.danmaku.model.d dVar, n nVar, g gVar);

        void clear();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface g {
        boolean a(master.flame.danmaku.danmaku.model.d dVar, float f6, int i6, boolean z5);
    }

    public void a(boolean z5) {
        a aVar = null;
        this.f50171a = z5 ? new C0974b(aVar) : new c(aVar);
        this.f50172b = z5 ? new C0974b(aVar) : new c(aVar);
        if (this.f50173c == null) {
            this.f50173c = new d(aVar);
        }
        if (this.f50174d == null) {
            this.f50174d = new C0974b(aVar);
        }
    }

    public void b() {
        e eVar = this.f50171a;
        if (eVar != null) {
            eVar.clear();
        }
        e eVar2 = this.f50172b;
        if (eVar2 != null) {
            eVar2.clear();
        }
        e eVar3 = this.f50173c;
        if (eVar3 != null) {
            eVar3.clear();
        }
        e eVar4 = this.f50174d;
        if (eVar4 != null) {
            eVar4.clear();
        }
    }

    public b(boolean z5) {
        a(z5);
    }

    public void c(master.flame.danmaku.danmaku.model.d dVar, n nVar, g gVar) {
        int type = dVar.getType();
        if (type != 1) {
            if (type != 4) {
                if (type != 5) {
                    if (type != 6) {
                        if (type != 7) {
                            return;
                        }
                        dVar.y(nVar, 0.0f, 0.0f);
                        return;
                    }
                    this.f50172b.a(dVar, nVar, gVar);
                    return;
                }
                this.f50173c.a(dVar, nVar, gVar);
                return;
            }
            this.f50174d.a(dVar, nVar, gVar);
            return;
        }
        this.f50171a.a(dVar, nVar, gVar);
    }

    public void d() {
        b();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class f {

        /* renamed from: a, reason: collision with root package name */
        public int f50199a;

        /* renamed from: b, reason: collision with root package name */
        public master.flame.danmaku.danmaku.model.d f50200b;

        /* renamed from: c, reason: collision with root package name */
        public master.flame.danmaku.danmaku.model.d f50201c;

        /* renamed from: d, reason: collision with root package name */
        public master.flame.danmaku.danmaku.model.d f50202d;

        /* renamed from: e, reason: collision with root package name */
        public master.flame.danmaku.danmaku.model.d f50203e;

        /* renamed from: f, reason: collision with root package name */
        public master.flame.danmaku.danmaku.model.d f50204f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f50205g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f50206h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f50207i;

        private f() {
            this.f50199a = 0;
            this.f50200b = null;
            this.f50201c = null;
            this.f50202d = null;
            this.f50203e = null;
            this.f50204f = null;
            this.f50205g = false;
            this.f50206h = false;
            this.f50207i = false;
        }

        /* synthetic */ f(a aVar) {
            this();
        }
    }
}
