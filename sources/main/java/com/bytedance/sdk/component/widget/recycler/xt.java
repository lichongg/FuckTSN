package com.bytedance.sdk.component.widget.recycler;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
class xt {

    /* renamed from: j, reason: collision with root package name */
    final InterfaceC0422xt f27124j;
    final j xt = new j();
    final List<View> cw = new ArrayList();

    static class j {

        /* renamed from: j, reason: collision with root package name */
        long f27125j = 0;
        j xt;

        private void xt() {
            if (this.xt == null) {
                this.xt = new j();
            }
        }

        void j(int i6) {
            if (i6 < 64) {
                this.f27125j |= 1 << i6;
            } else {
                xt();
                this.xt.j(i6 - 64);
            }
        }

        boolean cw(int i6) {
            if (i6 < 64) {
                return (this.f27125j & (1 << i6)) != 0;
            }
            xt();
            return this.xt.cw(i6 - 64);
        }

        void insert(int i6, boolean z5) {
            if (i6 >= 64) {
                xt();
                this.xt.insert(i6 - 64, z5);
                return;
            }
            long j6 = this.f27125j;
            boolean z6 = (Long.MIN_VALUE & j6) != 0;
            long j7 = (1 << i6) - 1;
            this.f27125j = ((j6 & (~j7)) << 1) | (j6 & j7);
            if (z5) {
                j(i6);
            } else {
                xt(i6);
            }
            if (z6 || this.xt != null) {
                xt();
                this.xt.insert(0, z6);
            }
        }

        boolean r(int i6) {
            if (i6 >= 64) {
                xt();
                return this.xt.r(i6 - 64);
            }
            long j6 = 1 << i6;
            long j7 = this.f27125j;
            boolean z5 = (j7 & j6) != 0;
            long j8 = j7 & (~j6);
            this.f27125j = j8;
            long j9 = j6 - 1;
            this.f27125j = (j8 & j9) | Long.rotateRight((~j9) & j8, 1);
            j jVar = this.xt;
            if (jVar != null) {
                if (jVar.cw(0)) {
                    j(63);
                }
                this.xt.r(0);
            }
            return z5;
        }

        public String toString() {
            if (this.xt == null) {
                return Long.toBinaryString(this.f27125j);
            }
            return this.xt.toString() + "xx" + Long.toBinaryString(this.f27125j);
        }

        int up(int i6) {
            j jVar = this.xt;
            return jVar == null ? i6 >= 64 ? Long.bitCount(this.f27125j) : Long.bitCount(this.f27125j & ((1 << i6) - 1)) : i6 < 64 ? Long.bitCount(this.f27125j & ((1 << i6) - 1)) : jVar.up(i6 - 64) + Long.bitCount(this.f27125j);
        }

        j() {
        }

        void xt(int i6) {
            if (i6 >= 64) {
                j jVar = this.xt;
                if (jVar != null) {
                    jVar.xt(i6 - 64);
                    return;
                }
                return;
            }
            this.f27125j &= ~(1 << i6);
        }

        void j() {
            this.f27125j = 0L;
            j jVar = this.xt;
            if (jVar != null) {
                jVar.j();
            }
        }
    }

    /* renamed from: com.bytedance.sdk.component.widget.recycler.xt$xt, reason: collision with other inner class name */
    interface InterfaceC0422xt {
        void cw(int i6);

        void cw(View view);

        int j();

        int j(View view);

        void j(int i6);

        void j(View view, int i6);

        void j(View view, int i6, ViewGroup.LayoutParams layoutParams);

        void r(View view);

        View xt(int i6);

        RecyclerView.v xt(View view);

        void xt();
    }

    private int m(int i6) {
        if (i6 < 0) {
            return -1;
        }
        int j6 = this.f27124j.j();
        int i7 = i6;
        while (i7 < j6) {
            int up = i6 - (i7 - this.xt.up(i7));
            if (up == 0) {
                while (this.xt.cw(i7)) {
                    i7++;
                }
                return i7;
            }
            i7 += up;
        }
        return -1;
    }

    View cw(int i6) {
        int size = this.cw.size();
        for (int i7 = 0; i7 < size; i7++) {
            View view = this.cw.get(i7);
            RecyclerView.v xt = this.f27124j.xt(view);
            if (xt.r() == i6 && !xt.ws() && !xt.i()) {
                return view;
            }
        }
        return null;
    }

    void j(View view, boolean z5) {
        j(view, -1, z5);
    }

    View r(int i6) {
        return this.f27124j.xt(i6);
    }

    void up(int i6) {
        int m6 = m(i6);
        this.xt.r(m6);
        this.f27124j.cw(m6);
    }

    View xt(int i6) {
        return this.f27124j.xt(m(i6));
    }

    private void ae(View view) {
        this.cw.add(view);
        this.f27124j.cw(view);
    }

    private boolean tl(View view) {
        if (!this.cw.remove(view)) {
            return false;
        }
        this.f27124j.r(view);
        return true;
    }

    void j(View view, int i6, boolean z5) {
        int j6 = i6 < 0 ? this.f27124j.j() : m(i6);
        this.xt.insert(j6, z5);
        if (z5) {
            ae(view);
        }
        this.f27124j.j(view, j6);
    }

    void r(View view) {
        int j6 = this.f27124j.j(view);
        if (j6 < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide ".concat(String.valueOf(view)));
        }
        this.xt.j(j6);
        ae(view);
    }

    public String toString() {
        return this.xt.toString() + ", hidden list:" + this.cw.size();
    }

    xt(InterfaceC0422xt interfaceC0422xt) {
        this.f27124j = interfaceC0422xt;
    }

    int xt() {
        return this.f27124j.j() - this.cw.size();
    }

    boolean m(View view) {
        int j6 = this.f27124j.j(view);
        if (j6 == -1) {
            tl(view);
            return true;
        }
        if (!this.xt.cw(j6)) {
            return false;
        }
        this.xt.r(j6);
        tl(view);
        this.f27124j.j(j6);
        return true;
    }

    void up(View view) {
        int j6 = this.f27124j.j(view);
        if (j6 >= 0) {
            if (this.xt.cw(j6)) {
                this.xt.xt(j6);
                tl(view);
                return;
            }
            throw new RuntimeException("trying to unhide a view that was not hidden".concat(String.valueOf(view)));
        }
        throw new IllegalArgumentException("view is not a child, cannot hide ".concat(String.valueOf(view)));
    }

    int xt(View view) {
        int j6 = this.f27124j.j(view);
        if (j6 == -1 || this.xt.cw(j6)) {
            return -1;
        }
        return j6 - this.xt.up(j6);
    }

    int cw() {
        return this.f27124j.j();
    }

    boolean cw(View view) {
        return this.cw.contains(view);
    }

    void j(View view) {
        int j6 = this.f27124j.j(view);
        if (j6 >= 0) {
            if (this.xt.r(j6)) {
                tl(view);
            }
            this.f27124j.j(j6);
        }
    }

    void j(int i6) {
        int m6 = m(i6);
        View xt = this.f27124j.xt(m6);
        if (xt != null) {
            if (this.xt.r(m6)) {
                tl(xt);
            }
            this.f27124j.j(m6);
        }
    }

    void j() {
        this.xt.j();
        for (int size = this.cw.size() - 1; size >= 0; size--) {
            this.f27124j.r(this.cw.get(size));
            this.cw.remove(size);
        }
        this.f27124j.xt();
    }

    void j(View view, int i6, ViewGroup.LayoutParams layoutParams, boolean z5) {
        int m6;
        if (i6 < 0) {
            m6 = this.f27124j.j();
        } else {
            m6 = m(i6);
        }
        this.xt.insert(m6, z5);
        if (z5) {
            ae(view);
        }
        this.f27124j.j(view, m6, layoutParams);
    }
}
