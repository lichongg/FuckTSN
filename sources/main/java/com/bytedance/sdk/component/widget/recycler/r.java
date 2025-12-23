package com.bytedance.sdk.component.widget.recycler;

import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes4.dex */
final class r implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    static final ThreadLocal<r> f27094j = new ThreadLocal<>();
    static Comparator<xt> up = new Comparator<xt>() { // from class: com.bytedance.sdk.component.widget.recycler.r.1
        @Override // java.util.Comparator
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public int compare(xt xtVar, xt xtVar2) {
            RecyclerView recyclerView = xtVar.f27100r;
            if ((recyclerView == null) != (xtVar2.f27100r == null)) {
                return recyclerView == null ? 1 : -1;
            }
            boolean z5 = xtVar.f27099j;
            if (z5 != xtVar2.f27099j) {
                return z5 ? -1 : 1;
            }
            int i6 = xtVar2.xt - xtVar.xt;
            if (i6 != 0) {
                return i6;
            }
            int i7 = xtVar.cw - xtVar2.cw;
            if (i7 != 0) {
                return i7;
            }
            return 0;
        }
    };
    long cw;

    /* renamed from: r, reason: collision with root package name */
    long f27096r;
    ArrayList<RecyclerView> xt = new ArrayList<>();

    /* renamed from: m, reason: collision with root package name */
    private ArrayList<xt> f27095m = new ArrayList<>();

    static class j implements RecyclerView.g.j {
        int[] cw;

        /* renamed from: j, reason: collision with root package name */
        int f27097j;

        /* renamed from: r, reason: collision with root package name */
        int f27098r;
        int xt;

        void j(int i6, int i7) {
            this.f27097j = i6;
            this.xt = i7;
        }

        @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.g.j
        public void xt(int i6, int i7) {
            if (i6 < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i7 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i8 = this.f27098r;
            int i9 = i8 * 2;
            int[] iArr = this.cw;
            if (iArr == null) {
                int[] iArr2 = new int[4];
                this.cw = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i9 >= iArr.length) {
                int[] iArr3 = new int[i8 * 4];
                this.cw = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            }
            int[] iArr4 = this.cw;
            iArr4[i9] = i6;
            iArr4[i9 + 1] = i7;
            this.f27098r++;
        }

        j() {
        }

        void j(RecyclerView recyclerView, boolean z5) {
            this.f27098r = 0;
            int[] iArr = this.cw;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.g gVar = recyclerView.ws;
            if (recyclerView.jy == null || gVar == null || !gVar.ws()) {
                return;
            }
            if (z5) {
                if (!recyclerView.f26986m.r()) {
                    gVar.j(recyclerView.jy.j(), this);
                }
            } else if (!recyclerView.tj()) {
                gVar.j(this.f27097j, this.xt, recyclerView.f26987p, this);
            }
            int i6 = this.f27098r;
            if (i6 > gVar.av) {
                gVar.av = i6;
                gVar.f27014i = z5;
                recyclerView.up.xt();
            }
        }

        boolean j(int i6) {
            if (this.cw != null) {
                int i7 = this.f27098r * 2;
                for (int i8 = 0; i8 < i7; i8 += 2) {
                    if (this.cw[i8] == i6) {
                        return true;
                    }
                }
            }
            return false;
        }

        void j() {
            int[] iArr = this.cw;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f27098r = 0;
        }
    }

    public void j(RecyclerView recyclerView) {
        this.xt.add(recyclerView);
    }

    public void xt(RecyclerView recyclerView) {
        this.xt.remove(recyclerView);
    }

    static class xt {
        public int cw;

        /* renamed from: j, reason: collision with root package name */
        public boolean f27099j;

        /* renamed from: r, reason: collision with root package name */
        public RecyclerView f27100r;
        public int up;
        public int xt;

        public void j() {
            this.f27099j = false;
            this.xt = 0;
            this.cw = 0;
            this.f27100r = null;
            this.up = 0;
        }

        xt() {
        }
    }

    private void xt(long j6) {
        for (int i6 = 0; i6 < this.f27095m.size(); i6++) {
            xt xtVar = this.f27095m.get(i6);
            if (xtVar.f27100r == null) {
                return;
            }
            j(xtVar, j6);
            xtVar.j();
        }
    }

    void j(RecyclerView recyclerView, int i6, int i7) {
        if (recyclerView.isAttachedToWindow() && this.cw == 0) {
            this.cw = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.f26985l.j(i6, i7);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.bytedance.sdk.component.widget.recycler.j.j.j.j("RV Prefetch");
            if (!this.xt.isEmpty()) {
                int size = this.xt.size();
                long j6 = 0;
                for (int i6 = 0; i6 < size; i6++) {
                    RecyclerView recyclerView = this.xt.get(i6);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j6 = Math.max(recyclerView.getDrawingTime(), j6);
                    }
                }
                if (j6 != 0) {
                    j(TimeUnit.MILLISECONDS.toNanos(j6) + this.f27096r);
                }
            }
        } finally {
            this.cw = 0L;
            com.bytedance.sdk.component.widget.recycler.j.j.j.j();
        }
    }

    r() {
    }

    private void j() {
        xt xtVar;
        int size = this.xt.size();
        int i6 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            RecyclerView recyclerView = this.xt.get(i7);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.f26985l.j(recyclerView, false);
                i6 += recyclerView.f26985l.f27098r;
            }
        }
        this.f27095m.ensureCapacity(i6);
        int i8 = 0;
        for (int i9 = 0; i9 < size; i9++) {
            RecyclerView recyclerView2 = this.xt.get(i9);
            if (recyclerView2.getWindowVisibility() == 0) {
                j jVar = recyclerView2.f26985l;
                int abs = Math.abs(jVar.f27097j) + Math.abs(jVar.xt);
                for (int i10 = 0; i10 < jVar.f27098r * 2; i10 += 2) {
                    if (i8 >= this.f27095m.size()) {
                        xtVar = new xt();
                        this.f27095m.add(xtVar);
                    } else {
                        xtVar = this.f27095m.get(i8);
                    }
                    int[] iArr = jVar.cw;
                    int i11 = iArr[i10 + 1];
                    xtVar.f27099j = i11 <= abs;
                    xtVar.xt = abs;
                    xtVar.cw = i11;
                    xtVar.f27100r = recyclerView2;
                    xtVar.up = iArr[i10];
                    i8++;
                }
            }
        }
        Collections.sort(this.f27095m, up);
    }

    static boolean j(RecyclerView recyclerView, int i6) {
        int cw = recyclerView.ae.cw();
        for (int i7 = 0; i7 < cw; i7++) {
            RecyclerView.v up2 = RecyclerView.up(recyclerView.ae.r(i7));
            if (up2.cw == i6 && !up2.ws()) {
                return true;
            }
        }
        return false;
    }

    private RecyclerView.v j(RecyclerView recyclerView, int i6, long j6) {
        if (j(recyclerView, i6)) {
            return null;
        }
        RecyclerView.av avVar = recyclerView.up;
        try {
            recyclerView.vl();
            RecyclerView.v j7 = avVar.j(i6, false, j6);
            if (j7 != null) {
                if (j7.av() && !j7.ws()) {
                    avVar.j(j7.f27042j);
                } else {
                    avVar.j(j7, false);
                }
            }
            recyclerView.xt(false);
            return j7;
        } catch (Throwable th) {
            recyclerView.xt(false);
            throw th;
        }
    }

    private void j(RecyclerView recyclerView, long j6) {
        if (recyclerView != null) {
            if (recyclerView.f26992v && recyclerView.ae.cw() != 0) {
                recyclerView.cw();
            }
            j jVar = recyclerView.f26985l;
            jVar.j(recyclerView, true);
            if (jVar.f27098r != 0) {
                try {
                    com.bytedance.sdk.component.widget.recycler.j.j.j.j("RV Nested Prefetch");
                    recyclerView.f26987p.j(recyclerView.jy);
                    for (int i6 = 0; i6 < jVar.f27098r * 2; i6 += 2) {
                        j(recyclerView, jVar.cw[i6], j6);
                    }
                } finally {
                    com.bytedance.sdk.component.widget.recycler.j.j.j.j();
                }
            }
        }
    }

    private void j(xt xtVar, long j6) {
        RecyclerView.v j7 = j(xtVar.f27100r, xtVar.up, xtVar.f27099j ? Long.MAX_VALUE : j6);
        if (j7 == null || j7.xt == null || !j7.av() || j7.ws()) {
            return;
        }
        j(j7.xt.get(), j6);
    }

    void j(long j6) {
        j();
        xt(j6);
    }
}
