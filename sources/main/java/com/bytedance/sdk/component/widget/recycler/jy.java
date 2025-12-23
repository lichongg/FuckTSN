package com.bytedance.sdk.component.widget.recycler;

import android.view.View;

/* loaded from: D:\Downloads\app\classes4.dex */
class jy {

    /* renamed from: j, reason: collision with root package name */
    final xt f27088j;
    j xt = new j();

    static class j {
        int cw;

        /* renamed from: j, reason: collision with root package name */
        int f27089j = 0;

        /* renamed from: r, reason: collision with root package name */
        int f27090r;
        int up;
        int xt;

        int j(int i6, int i7) {
            if (i6 > i7) {
                return 1;
            }
            return i6 == i7 ? 2 : 4;
        }

        void j(int i6, int i7, int i8, int i9) {
            this.xt = i6;
            this.cw = i7;
            this.f27090r = i8;
            this.up = i9;
        }

        boolean xt() {
            int i6 = this.f27089j;
            if ((i6 & 7) != 0 && (i6 & j(this.f27090r, this.xt)) == 0) {
                return false;
            }
            int i7 = this.f27089j;
            if ((i7 & 112) != 0 && (i7 & (j(this.f27090r, this.cw) << 4)) == 0) {
                return false;
            }
            int i8 = this.f27089j;
            if ((i8 & 1792) != 0 && (i8 & (j(this.up, this.xt) << 8)) == 0) {
                return false;
            }
            int i9 = this.f27089j;
            return (i9 & 28672) == 0 || (i9 & (j(this.up, this.cw) << 12)) != 0;
        }

        j() {
        }

        void j(int i6) {
            this.f27089j = i6 | this.f27089j;
        }

        void j() {
            this.f27089j = 0;
        }
    }

    interface xt {
        int j();

        int j(View view);

        View j(int i6);

        int xt();

        int xt(View view);
    }

    View j(int i6, int i7, int i8, int i9) {
        int j6 = this.f27088j.j();
        int xt2 = this.f27088j.xt();
        int i10 = i7 > i6 ? 1 : -1;
        View view = null;
        while (i6 != i7) {
            View j7 = this.f27088j.j(i6);
            this.xt.j(j6, xt2, this.f27088j.j(j7), this.f27088j.xt(j7));
            if (i8 != 0) {
                this.xt.j();
                this.xt.j(i8);
                if (this.xt.xt()) {
                    return j7;
                }
            }
            if (i9 != 0) {
                this.xt.j();
                this.xt.j(i9);
                if (this.xt.xt()) {
                    view = j7;
                }
            }
            i6 += i10;
        }
        return view;
    }

    jy(xt xtVar) {
        this.f27088j = xtVar;
    }
}
