package com.bytedance.sdk.component.widget.recycler;

import com.bytedance.sdk.component.widget.recycler.j;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
class ae {

    /* renamed from: j, reason: collision with root package name */
    final j f27047j;

    interface j {
        j.xt j(int i6, int i7, int i8, Object obj);

        void j(j.xt xtVar);
    }

    void j(List<j.xt> list) {
        while (true) {
            int xt = xt(list);
            if (xt == -1) {
                return;
            } else {
                j(list, xt, xt + 1);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void xt(java.util.List<com.bytedance.sdk.component.widget.recycler.j.xt> r9, int r10, com.bytedance.sdk.component.widget.recycler.j.xt r11, int r12, com.bytedance.sdk.component.widget.recycler.j.xt r13) {
        /*
            r8 = this;
            int r0 = r11.f27080r
            int r1 = r13.xt
            r2 = 4
            r3 = 1
            r4 = 0
            if (r0 >= r1) goto Ld
            int r1 = r1 - r3
            r13.xt = r1
            goto L20
        Ld:
            int r5 = r13.f27080r
            int r1 = r1 + r5
            if (r0 >= r1) goto L20
            int r5 = r5 - r3
            r13.f27080r = r5
            com.bytedance.sdk.component.widget.recycler.ae$j r0 = r8.f27047j
            int r1 = r11.xt
            java.lang.Object r5 = r13.cw
            com.bytedance.sdk.component.widget.recycler.j$xt r0 = r0.j(r2, r1, r3, r5)
            goto L21
        L20:
            r0 = r4
        L21:
            int r1 = r11.xt
            int r5 = r13.xt
            if (r1 > r5) goto L2b
            int r5 = r5 + r3
            r13.xt = r5
            goto L41
        L2b:
            int r6 = r13.f27080r
            int r7 = r5 + r6
            if (r1 >= r7) goto L41
            int r5 = r5 + r6
            int r5 = r5 - r1
            com.bytedance.sdk.component.widget.recycler.ae$j r4 = r8.f27047j
            int r1 = r1 + r3
            java.lang.Object r3 = r13.cw
            com.bytedance.sdk.component.widget.recycler.j$xt r4 = r4.j(r2, r1, r5, r3)
            int r1 = r13.f27080r
            int r1 = r1 - r5
            r13.f27080r = r1
        L41:
            r9.set(r12, r11)
            int r11 = r13.f27080r
            if (r11 <= 0) goto L4c
            r9.set(r10, r13)
            goto L54
        L4c:
            r9.remove(r10)
            com.bytedance.sdk.component.widget.recycler.ae$j r11 = r8.f27047j
            r11.j(r13)
        L54:
            if (r0 == 0) goto L59
            r9.add(r10, r0)
        L59:
            if (r4 == 0) goto L5e
            r9.add(r10, r4)
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.ae.xt(java.util.List, int, com.bytedance.sdk.component.widget.recycler.j$xt, int, com.bytedance.sdk.component.widget.recycler.j$xt):void");
    }

    private void cw(List<j.xt> list, int i6, j.xt xtVar, int i7, j.xt xtVar2) {
        int i8 = xtVar.f27080r;
        int i9 = xtVar2.xt;
        int i10 = i8 < i9 ? -1 : 0;
        int i11 = xtVar.xt;
        if (i11 < i9) {
            i10++;
        }
        if (i9 <= i11) {
            xtVar.xt = i11 + xtVar2.f27080r;
        }
        int i12 = xtVar2.xt;
        if (i12 <= i8) {
            xtVar.f27080r = i8 + xtVar2.f27080r;
        }
        xtVar2.xt = i12 + i10;
        list.set(i6, xtVar2);
        list.set(i7, xtVar);
    }

    ae(j jVar) {
        this.f27047j = jVar;
    }

    private void j(List<j.xt> list, int i6, int i7) {
        j.xt xtVar = list.get(i6);
        j.xt xtVar2 = list.get(i7);
        int i8 = xtVar2.f27079j;
        if (i8 == 1) {
            cw(list, i6, xtVar, i7, xtVar2);
        } else if (i8 == 2) {
            j(list, i6, xtVar, i7, xtVar2);
        } else {
            if (i8 != 4) {
                return;
            }
            xt(list, i6, xtVar, i7, xtVar2);
        }
    }

    void j(List<j.xt> list, int i6, j.xt xtVar, int i7, j.xt xtVar2) {
        boolean z5;
        int i8 = xtVar.xt;
        int i9 = xtVar.f27080r;
        boolean z6 = false;
        if (i8 < i9) {
            if (xtVar2.xt == i8 && xtVar2.f27080r == i9 - i8) {
                z5 = false;
                z6 = true;
            } else {
                z5 = false;
            }
        } else if (xtVar2.xt == i9 + 1 && xtVar2.f27080r == i8 - i9) {
            z5 = true;
            z6 = true;
        } else {
            z5 = true;
        }
        int i10 = xtVar2.xt;
        if (i9 < i10) {
            xtVar2.xt = i10 - 1;
        } else {
            int i11 = xtVar2.f27080r;
            if (i9 < i10 + i11) {
                xtVar2.f27080r = i11 - 1;
                xtVar.f27079j = 2;
                xtVar.f27080r = 1;
                if (xtVar2.f27080r == 0) {
                    list.remove(i7);
                    this.f27047j.j(xtVar2);
                    return;
                }
                return;
            }
        }
        int i12 = xtVar.xt;
        int i13 = xtVar2.xt;
        j.xt xtVar3 = null;
        if (i12 <= i13) {
            xtVar2.xt = i13 + 1;
        } else {
            int i14 = xtVar2.f27080r;
            if (i12 < i13 + i14) {
                xtVar3 = this.f27047j.j(2, i12 + 1, (i13 + i14) - i12, null);
                xtVar2.f27080r = xtVar.xt - xtVar2.xt;
            }
        }
        if (z6) {
            list.set(i6, xtVar2);
            list.remove(i7);
            this.f27047j.j(xtVar);
            return;
        }
        if (z5) {
            if (xtVar3 != null) {
                int i15 = xtVar.xt;
                if (i15 > xtVar3.xt) {
                    xtVar.xt = i15 - xtVar3.f27080r;
                }
                int i16 = xtVar.f27080r;
                if (i16 > xtVar3.xt) {
                    xtVar.f27080r = i16 - xtVar3.f27080r;
                }
            }
            int i17 = xtVar.xt;
            if (i17 > xtVar2.xt) {
                xtVar.xt = i17 - xtVar2.f27080r;
            }
            int i18 = xtVar.f27080r;
            if (i18 > xtVar2.xt) {
                xtVar.f27080r = i18 - xtVar2.f27080r;
            }
        } else {
            if (xtVar3 != null) {
                int i19 = xtVar.xt;
                if (i19 >= xtVar3.xt) {
                    xtVar.xt = i19 - xtVar3.f27080r;
                }
                int i20 = xtVar.f27080r;
                if (i20 >= xtVar3.xt) {
                    xtVar.f27080r = i20 - xtVar3.f27080r;
                }
            }
            int i21 = xtVar.xt;
            if (i21 >= xtVar2.xt) {
                xtVar.xt = i21 - xtVar2.f27080r;
            }
            int i22 = xtVar.f27080r;
            if (i22 >= xtVar2.xt) {
                xtVar.f27080r = i22 - xtVar2.f27080r;
            }
        }
        list.set(i6, xtVar2);
        if (xtVar.xt != xtVar.f27080r) {
            list.set(i7, xtVar);
        } else {
            list.remove(i7);
        }
        if (xtVar3 != null) {
            list.add(i6, xtVar3);
        }
    }

    private int xt(List<j.xt> list) {
        boolean z5 = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).f27079j != 8) {
                z5 = true;
            } else if (z5) {
                return size;
            }
        }
        return -1;
    }
}
