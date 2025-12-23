package com.bytedance.sdk.component.widget.recycler.j.cw;

import android.view.View;
import android.view.ViewParent;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r {
    private final View cw;

    /* renamed from: j, reason: collision with root package name */
    private ViewParent f27077j;

    /* renamed from: r, reason: collision with root package name */
    private boolean f27078r;
    private int[] up;
    private ViewParent xt;

    public void cw() {
        cw(0);
    }

    public void j(boolean z5) {
        if (this.f27078r) {
            ae.oq(this.cw);
        }
        this.f27078r = z5;
    }

    public boolean xt() {
        return j(0);
    }

    private ViewParent r(int i6) {
        if (i6 == 0) {
            return this.f27077j;
        }
        if (i6 != 1) {
            return null;
        }
        return this.xt;
    }

    public void cw(int i6) {
        ViewParent r5 = r(i6);
        if (r5 != null) {
            tl.j(r5, this.cw, i6);
            j(i6, (ViewParent) null);
        }
    }

    public boolean xt(int i6) {
        return j(i6, 0);
    }

    public r(View view) {
        this.cw = view;
    }

    public boolean j() {
        return this.f27078r;
    }

    public boolean j(int i6) {
        return r(i6) != null;
    }

    public boolean j(int i6, int i7) {
        if (j(i7)) {
            return true;
        }
        if (!j()) {
            return false;
        }
        View view = this.cw;
        for (ViewParent parent = this.cw.getParent(); parent != null; parent = parent.getParent()) {
            if (tl.j(parent, view, this.cw, i6, i7)) {
                j(i7, parent);
                tl.xt(parent, view, this.cw, i6, i7);
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    public boolean j(int i6, int i7, int i8, int i9, int[] iArr) {
        return j(i6, i7, i8, i9, iArr, 0);
    }

    public boolean j(int i6, int i7, int i8, int i9, int[] iArr, int i10) {
        ViewParent r5;
        int i11;
        int i12;
        if (!j() || (r5 = r(i10)) == null) {
            return false;
        }
        if (i6 == 0 && i7 == 0 && i8 == 0 && i9 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        if (iArr != null) {
            this.cw.getLocationInWindow(iArr);
            i11 = iArr[0];
            i12 = iArr[1];
        } else {
            i11 = 0;
            i12 = 0;
        }
        tl.j(r5, this.cw, i6, i7, i8, i9, i10);
        if (iArr != null) {
            this.cw.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i11;
            iArr[1] = iArr[1] - i12;
        }
        return true;
    }

    public boolean j(int i6, int i7, int[] iArr, int[] iArr2) {
        return j(i6, i7, iArr, iArr2, 0);
    }

    public boolean j(int i6, int i7, int[] iArr, int[] iArr2, int i8) {
        ViewParent r5;
        int i9;
        int i10;
        if (!j() || (r5 = r(i8)) == null) {
            return false;
        }
        if (i6 == 0 && i7 == 0) {
            if (iArr2 != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
            }
            return false;
        }
        if (iArr2 != null) {
            this.cw.getLocationInWindow(iArr2);
            i9 = iArr2[0];
            i10 = iArr2[1];
        } else {
            i9 = 0;
            i10 = 0;
        }
        if (iArr == null) {
            if (this.up == null) {
                this.up = new int[2];
            }
            iArr = this.up;
        }
        int[] iArr3 = iArr;
        iArr3[0] = 0;
        iArr3[1] = 0;
        tl.j(r5, this.cw, i6, i7, iArr3, i8);
        if (iArr2 != null) {
            this.cw.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i9;
            iArr2[1] = iArr2[1] - i10;
        }
        return (iArr3[0] == 0 && iArr3[1] == 0) ? false : true;
    }

    public boolean j(float f6, float f7, boolean z5) {
        ViewParent r5;
        if (!j() || (r5 = r(0)) == null) {
            return false;
        }
        return tl.j(r5, this.cw, f6, f7, z5);
    }

    public boolean j(float f6, float f7) {
        ViewParent r5;
        if (!j() || (r5 = r(0)) == null) {
            return false;
        }
        return tl.j(r5, this.cw, f6, f7);
    }

    private void j(int i6, ViewParent viewParent) {
        if (i6 == 0) {
            this.f27077j = viewParent;
        } else {
            if (i6 != 1) {
                return;
            }
            this.xt = viewParent;
        }
    }
}
