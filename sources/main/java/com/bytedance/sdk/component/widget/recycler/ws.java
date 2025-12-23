package com.bytedance.sdk.component.widget.recycler;

import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.component.widget.recycler.j.xt.r;

/* loaded from: D:\Downloads\app\classes4.dex */
class ws {

    /* renamed from: j, reason: collision with root package name */
    final com.bytedance.sdk.component.widget.recycler.j.xt.j<RecyclerView.v, j> f27121j = new com.bytedance.sdk.component.widget.recycler.j.xt.j<>();
    final com.bytedance.sdk.component.widget.recycler.j.xt.cw<RecyclerView.v> xt = new com.bytedance.sdk.component.widget.recycler.j.xt.cw<>();

    static class j {

        /* renamed from: r, reason: collision with root package name */
        static r.j<j> f27122r = new r.xt(20);
        RecyclerView.m.xt cw;

        /* renamed from: j, reason: collision with root package name */
        int f27123j;
        RecyclerView.m.xt xt;

        static j j() {
            j j6 = f27122r.j();
            return j6 == null ? new j() : j6;
        }

        static void xt() {
            while (f27122r.j() != null) {
            }
        }

        private j() {
        }

        static void j(j jVar) {
            jVar.f27123j = 0;
            jVar.xt = null;
            jVar.cw = null;
            f27122r.j(jVar);
        }
    }

    interface xt {
        void cw(RecyclerView.v vVar, RecyclerView.m.xt xtVar, RecyclerView.m.xt xtVar2);

        void j(RecyclerView.v vVar);

        void j(RecyclerView.v vVar, RecyclerView.m.xt xtVar, RecyclerView.m.xt xtVar2);

        void xt(RecyclerView.v vVar, RecyclerView.m.xt xtVar, RecyclerView.m.xt xtVar2);
    }

    RecyclerView.m.xt cw(RecyclerView.v vVar) {
        return j(vVar, 8);
    }

    void j() {
        this.f27121j.clear();
        this.xt.cw();
    }

    RecyclerView.m.xt xt(RecyclerView.v vVar) {
        return j(vVar, 4);
    }

    void ae(RecyclerView.v vVar) {
        int xt2 = this.xt.xt() - 1;
        while (true) {
            if (xt2 < 0) {
                break;
            }
            if (vVar == this.xt.cw(xt2)) {
                this.xt.j(xt2);
                break;
            }
            xt2--;
        }
        j remove = this.f27121j.remove(vVar);
        if (remove != null) {
            j.j(remove);
        }
    }

    void cw(RecyclerView.v vVar, RecyclerView.m.xt xtVar) {
        j jVar = this.f27121j.get(vVar);
        if (jVar == null) {
            jVar = j.j();
            this.f27121j.put(vVar, jVar);
        }
        jVar.cw = xtVar;
        jVar.f27123j |= 8;
    }

    void m(RecyclerView.v vVar) {
        j jVar = this.f27121j.get(vVar);
        if (jVar != null) {
            jVar.f27123j &= -2;
        }
    }

    boolean r(RecyclerView.v vVar) {
        j jVar = this.f27121j.get(vVar);
        return (jVar == null || (jVar.f27123j & 4) == 0) ? false : true;
    }

    void up(RecyclerView.v vVar) {
        j jVar = this.f27121j.get(vVar);
        if (jVar == null) {
            jVar = j.j();
            this.f27121j.put(vVar, jVar);
        }
        jVar.f27123j |= 1;
    }

    void xt(RecyclerView.v vVar, RecyclerView.m.xt xtVar) {
        j jVar = this.f27121j.get(vVar);
        if (jVar == null) {
            jVar = j.j();
            this.f27121j.put(vVar, jVar);
        }
        jVar.f27123j |= 2;
        jVar.xt = xtVar;
    }

    ws() {
    }

    void j(RecyclerView.v vVar, RecyclerView.m.xt xtVar) {
        j jVar = this.f27121j.get(vVar);
        if (jVar == null) {
            jVar = j.j();
            this.f27121j.put(vVar, jVar);
        }
        jVar.xt = xtVar;
        jVar.f27123j |= 4;
    }

    public void tl(RecyclerView.v vVar) {
        m(vVar);
    }

    void xt() {
        j.xt();
    }

    boolean j(RecyclerView.v vVar) {
        j jVar = this.f27121j.get(vVar);
        return (jVar == null || (jVar.f27123j & 1) == 0) ? false : true;
    }

    private RecyclerView.m.xt j(RecyclerView.v vVar, int i6) {
        j xt2;
        RecyclerView.m.xt xtVar;
        int j6 = this.f27121j.j(vVar);
        if (j6 >= 0 && (xt2 = this.f27121j.xt(j6)) != null) {
            int i7 = xt2.f27123j;
            if ((i7 & i6) != 0) {
                int i8 = (~i6) & i7;
                xt2.f27123j = i8;
                if (i6 == 4) {
                    xtVar = xt2.xt;
                } else if (i6 == 8) {
                    xtVar = xt2.cw;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((i8 & 12) == 0) {
                    this.f27121j.cw(j6);
                    j.j(xt2);
                }
                return xtVar;
            }
        }
        return null;
    }

    void j(long j6, RecyclerView.v vVar) {
        this.xt.xt(j6, vVar);
    }

    RecyclerView.v j(long j6) {
        return this.xt.j(j6);
    }

    void j(xt xtVar) {
        for (int size = this.f27121j.size() - 1; size >= 0; size--) {
            RecyclerView.v j6 = this.f27121j.j(size);
            j cw = this.f27121j.cw(size);
            int i6 = cw.f27123j;
            if ((i6 & 3) == 3) {
                xtVar.j(j6);
            } else if ((i6 & 1) != 0) {
                RecyclerView.m.xt xtVar2 = cw.xt;
                if (xtVar2 == null) {
                    xtVar.j(j6);
                } else {
                    xtVar.j(j6, xtVar2, cw.cw);
                }
            } else if ((i6 & 14) == 14) {
                xtVar.xt(j6, cw.xt, cw.cw);
            } else if ((i6 & 12) == 12) {
                xtVar.cw(j6, cw.xt, cw.cw);
            } else if ((i6 & 4) != 0) {
                xtVar.j(j6, cw.xt, null);
            } else if ((i6 & 8) != 0) {
                xtVar.xt(j6, cw.xt, cw.cw);
            }
            j.j(cw);
        }
    }
}
