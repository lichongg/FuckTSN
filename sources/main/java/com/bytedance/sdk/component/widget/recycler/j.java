package com.bytedance.sdk.component.widget.recycler;

import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.component.widget.recycler.ae;
import com.bytedance.sdk.component.widget.recycler.j.xt.r;
import com.kuaishou.weapon.p0.t;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
class j implements ae.j {
    private r.j<xt> ae;
    final InterfaceC0421j cw;

    /* renamed from: j, reason: collision with root package name */
    final ArrayList<xt> f27072j;

    /* renamed from: m, reason: collision with root package name */
    final ae f27073m;

    /* renamed from: r, reason: collision with root package name */
    Runnable f27074r;
    private int tl;
    final boolean up;
    final ArrayList<xt> xt;

    /* renamed from: com.bytedance.sdk.component.widget.recycler.j$j, reason: collision with other inner class name */
    interface InterfaceC0421j {
        void cw(int i6, int i7);

        RecyclerView.v j(int i6);

        void j(int i6, int i7);

        void j(int i6, int i7, Object obj);

        void r(int i6, int i7);

        void xt(int i6, int i7);
    }

    static class xt {
        Object cw;

        /* renamed from: j, reason: collision with root package name */
        int f27079j;

        /* renamed from: r, reason: collision with root package name */
        int f27080r;
        int xt;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            xt xtVar = (xt) obj;
            int i6 = this.f27079j;
            if (i6 != xtVar.f27079j) {
                return false;
            }
            if (i6 == 8 && Math.abs(this.f27080r - this.xt) == 1 && this.f27080r == xtVar.xt && this.xt == xtVar.f27080r) {
                return true;
            }
            if (this.f27080r != xtVar.f27080r || this.xt != xtVar.xt) {
                return false;
            }
            Object obj2 = this.cw;
            if (obj2 != null) {
                if (!obj2.equals(xtVar.cw)) {
                    return false;
                }
            } else if (xtVar.cw != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f27079j * 31) + this.xt) * 31) + this.f27080r;
        }

        String j() {
            int i6 = this.f27079j;
            return i6 != 1 ? i6 != 2 ? i6 != 4 ? i6 != 8 ? "??" : "mv" : "up" : t.f36162w : "add";
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + j() + ",s:" + this.xt + "c:" + this.f27080r + ",p:" + this.cw + "]";
        }

        xt(int i6, int i7, int i8, Object obj) {
            this.f27079j = i6;
            this.xt = i7;
            this.f27080r = i8;
            this.cw = obj;
        }
    }

    j(InterfaceC0421j interfaceC0421j) {
        this(interfaceC0421j, false);
    }

    private void m(xt xtVar) {
        ae(xtVar);
    }

    private void r(xt xtVar) {
        int i6 = xtVar.xt;
        int i7 = xtVar.f27080r + i6;
        int i8 = i6;
        char c6 = 65535;
        int i9 = 0;
        while (i6 < i7) {
            if (this.cw.j(i6) != null || r(i6)) {
                if (c6 == 0) {
                    up(j(4, i8, i9, xtVar.cw));
                    i8 = i6;
                    i9 = 0;
                }
                c6 = 1;
            } else {
                if (c6 == 1) {
                    ae(j(4, i8, i9, xtVar.cw));
                    i8 = i6;
                    i9 = 0;
                }
                c6 = 0;
            }
            i9++;
            i6++;
        }
        if (i9 != xtVar.f27080r) {
            Object obj = xtVar.cw;
            j(xtVar);
            xtVar = j(4, i8, i9, obj);
        }
        if (c6 == 0) {
            up(xtVar);
        } else {
            ae(xtVar);
        }
    }

    private void up(xt xtVar) {
        int i6;
        int i7 = xtVar.f27079j;
        if (i7 == 1 || i7 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int xt2 = xt(xtVar.xt, i7);
        int i8 = xtVar.xt;
        int i9 = xtVar.f27079j;
        if (i9 == 2) {
            i6 = 0;
        } else {
            if (i9 != 4) {
                throw new IllegalArgumentException("op should be remove or update.".concat(String.valueOf(xtVar)));
            }
            i6 = 1;
        }
        int i10 = 1;
        for (int i11 = 1; i11 < xtVar.f27080r; i11++) {
            int xt3 = xt(xtVar.xt + (i6 * i11), xtVar.f27079j);
            int i12 = xtVar.f27079j;
            if (i12 == 2 ? xt3 != xt2 : !(i12 == 4 && xt3 == xt2 + 1)) {
                xt j6 = j(i12, xt2, i10, xtVar.cw);
                j(j6, i8);
                j(j6);
                if (xtVar.f27079j == 4) {
                    i8 += i10;
                }
                xt2 = xt3;
                i10 = 1;
            } else {
                i10++;
            }
        }
        Object obj = xtVar.cw;
        j(xtVar);
        if (i10 > 0) {
            xt j7 = j(xtVar.f27079j, xt2, i10, obj);
            j(j7, i8);
            j(j7);
        }
    }

    void cw() {
        int size = this.xt.size();
        for (int i6 = 0; i6 < size; i6++) {
            this.xt.get(i6);
        }
        j(this.xt);
        this.tl = 0;
    }

    void j() {
        j(this.f27072j);
        j(this.xt);
        this.tl = 0;
    }

    void xt() {
        this.f27073m.j(this.f27072j);
        int size = this.f27072j.size();
        for (int i6 = 0; i6 < size; i6++) {
            xt xtVar = this.f27072j.get(i6);
            int i7 = xtVar.f27079j;
            if (i7 == 1) {
                m(xtVar);
            } else if (i7 == 2) {
                cw(xtVar);
            } else if (i7 == 4) {
                r(xtVar);
            } else if (i7 == 8) {
                xt(xtVar);
            }
            Runnable runnable = this.f27074r;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f27072j.clear();
    }

    j(InterfaceC0421j interfaceC0421j, boolean z5) {
        this.ae = new r.xt(30);
        this.f27072j = new ArrayList<>();
        this.xt = new ArrayList<>();
        this.tl = 0;
        this.cw = interfaceC0421j;
        this.up = z5;
        this.f27073m = new ae(this);
    }

    private void ae(xt xtVar) {
        this.xt.add(xtVar);
        int i6 = xtVar.f27079j;
        if (i6 == 1) {
            this.cw.cw(xtVar.xt, xtVar.f27080r);
            return;
        }
        if (i6 == 2) {
            this.cw.xt(xtVar.xt, xtVar.f27080r);
        } else if (i6 == 4) {
            this.cw.j(xtVar.xt, xtVar.f27080r, xtVar.cw);
        } else {
            if (i6 != 8) {
                throw new IllegalArgumentException("Unknown update op type for ".concat(String.valueOf(xtVar)));
            }
            this.cw.r(xtVar.xt, xtVar.f27080r);
        }
    }

    boolean m() {
        return (this.xt.isEmpty() || this.f27072j.isEmpty()) ? false : true;
    }

    void j(xt xtVar, int i6) {
        int i7 = xtVar.f27079j;
        if (i7 == 2) {
            this.cw.j(i6, xtVar.f27080r);
        } else {
            if (i7 == 4) {
                this.cw.j(i6, xtVar.f27080r, xtVar.cw);
                return;
            }
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    private void cw(xt xtVar) {
        boolean z5;
        char c6;
        int i6 = xtVar.xt;
        int i7 = xtVar.f27080r + i6;
        char c7 = 65535;
        int i8 = i6;
        int i9 = 0;
        while (i8 < i7) {
            if (this.cw.j(i8) != null || r(i8)) {
                if (c7 == 0) {
                    up(j(2, i6, i9, null));
                    z5 = true;
                } else {
                    z5 = false;
                }
                c6 = 1;
            } else {
                if (c7 == 1) {
                    ae(j(2, i6, i9, null));
                    z5 = true;
                } else {
                    z5 = false;
                }
                c6 = 0;
            }
            if (z5) {
                i8 -= i9;
                i7 -= i9;
                i9 = 1;
            } else {
                i9++;
            }
            i8++;
            c7 = c6;
        }
        if (i9 != xtVar.f27080r) {
            j(xtVar);
            xtVar = j(2, i6, i9, null);
        }
        if (c7 == 0) {
            up(xtVar);
        } else {
            ae(xtVar);
        }
    }

    boolean j(int i6) {
        return (i6 & this.tl) != 0;
    }

    int j(int i6, int i7) {
        int size = this.xt.size();
        while (i7 < size) {
            xt xtVar = this.xt.get(i7);
            int i8 = xtVar.f27079j;
            if (i8 == 8) {
                int i9 = xtVar.xt;
                if (i9 == i6) {
                    i6 = xtVar.f27080r;
                } else {
                    if (i9 < i6) {
                        i6--;
                    }
                    if (xtVar.f27080r <= i6) {
                        i6++;
                    }
                }
            } else {
                int i10 = xtVar.xt;
                if (i10 > i6) {
                    continue;
                } else if (i8 == 2) {
                    int i11 = xtVar.f27080r;
                    if (i6 < i10 + i11) {
                        return -1;
                    }
                    i6 -= i11;
                } else if (i8 == 1) {
                    i6 += xtVar.f27080r;
                }
            }
            i7++;
        }
        return i6;
    }

    private void xt(xt xtVar) {
        ae(xtVar);
    }

    private int xt(int i6, int i7) {
        int i8;
        int i9;
        for (int size = this.xt.size() - 1; size >= 0; size--) {
            xt xtVar = this.xt.get(size);
            int i10 = xtVar.f27079j;
            if (i10 == 8) {
                int i11 = xtVar.xt;
                int i12 = xtVar.f27080r;
                if (i11 < i12) {
                    i9 = i11;
                    i8 = i12;
                } else {
                    i8 = i11;
                    i9 = i12;
                }
                if (i6 < i9 || i6 > i8) {
                    if (i6 < i11) {
                        if (i7 == 1) {
                            xtVar.xt = i11 + 1;
                            xtVar.f27080r = i12 + 1;
                        } else if (i7 == 2) {
                            xtVar.xt = i11 - 1;
                            xtVar.f27080r = i12 - 1;
                        }
                    }
                } else if (i9 == i11) {
                    if (i7 == 1) {
                        xtVar.f27080r = i12 + 1;
                    } else if (i7 == 2) {
                        xtVar.f27080r = i12 - 1;
                    }
                    i6++;
                } else {
                    if (i7 == 1) {
                        xtVar.xt = i11 + 1;
                    } else if (i7 == 2) {
                        xtVar.xt = i11 - 1;
                    }
                    i6--;
                }
            } else {
                int i13 = xtVar.xt;
                if (i13 <= i6) {
                    if (i10 == 1) {
                        i6 -= xtVar.f27080r;
                    } else if (i10 == 2) {
                        i6 += xtVar.f27080r;
                    }
                } else if (i7 == 1) {
                    xtVar.xt = i13 + 1;
                } else if (i7 == 2) {
                    xtVar.xt = i13 - 1;
                }
            }
        }
        for (int size2 = this.xt.size() - 1; size2 >= 0; size2--) {
            xt xtVar2 = this.xt.get(size2);
            if (xtVar2.f27079j == 8) {
                int i14 = xtVar2.f27080r;
                if (i14 == xtVar2.xt || i14 < 0) {
                    this.xt.remove(size2);
                    j(xtVar2);
                }
            } else if (xtVar2.f27080r <= 0) {
                this.xt.remove(size2);
                j(xtVar2);
            }
        }
        return i6;
    }

    private boolean r(int i6) {
        int size = this.xt.size();
        for (int i7 = 0; i7 < size; i7++) {
            xt xtVar = this.xt.get(i7);
            int i8 = xtVar.f27079j;
            if (i8 == 8) {
                if (j(xtVar.f27080r, i7 + 1) == i6) {
                    return true;
                }
            } else if (i8 == 1) {
                int i9 = xtVar.xt;
                int i10 = xtVar.f27080r + i9;
                while (i9 < i10) {
                    if (j(i9, i7 + 1) == i6) {
                        return true;
                    }
                    i9++;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    public int cw(int i6) {
        int size = this.f27072j.size();
        for (int i7 = 0; i7 < size; i7++) {
            xt xtVar = this.f27072j.get(i7);
            int i8 = xtVar.f27079j;
            if (i8 != 1) {
                if (i8 == 2) {
                    int i9 = xtVar.xt;
                    if (i9 <= i6) {
                        int i10 = xtVar.f27080r;
                        if (i9 + i10 > i6) {
                            return -1;
                        }
                        i6 -= i10;
                    } else {
                        continue;
                    }
                } else if (i8 == 8) {
                    int i11 = xtVar.xt;
                    if (i11 == i6) {
                        i6 = xtVar.f27080r;
                    } else {
                        if (i11 < i6) {
                            i6--;
                        }
                        if (xtVar.f27080r <= i6) {
                            i6++;
                        }
                    }
                }
            } else if (xtVar.xt <= i6) {
                i6 += xtVar.f27080r;
            }
        }
        return i6;
    }

    boolean j(int i6, int i7, Object obj) {
        if (i7 <= 0) {
            return false;
        }
        this.f27072j.add(j(4, i6, i7, obj));
        this.tl |= 4;
        return this.f27072j.size() == 1;
    }

    void up() {
        cw();
        int size = this.f27072j.size();
        for (int i6 = 0; i6 < size; i6++) {
            xt xtVar = this.f27072j.get(i6);
            int i7 = xtVar.f27079j;
            if (i7 == 1) {
                this.cw.cw(xtVar.xt, xtVar.f27080r);
            } else if (i7 == 2) {
                this.cw.j(xtVar.xt, xtVar.f27080r);
            } else if (i7 == 4) {
                this.cw.j(xtVar.xt, xtVar.f27080r, xtVar.cw);
            } else if (i7 == 8) {
                this.cw.r(xtVar.xt, xtVar.f27080r);
            }
            Runnable runnable = this.f27074r;
            if (runnable != null) {
                runnable.run();
            }
        }
        j(this.f27072j);
        this.tl = 0;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.ae.j
    public xt j(int i6, int i7, int i8, Object obj) {
        xt j6 = this.ae.j();
        if (j6 == null) {
            return new xt(i6, i7, i8, obj);
        }
        j6.f27079j = i6;
        j6.xt = i7;
        j6.f27080r = i8;
        j6.cw = obj;
        return j6;
    }

    boolean r() {
        return this.f27072j.size() > 0;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.ae.j
    public void j(xt xtVar) {
        if (this.up) {
            return;
        }
        xtVar.cw = null;
        this.ae.j(xtVar);
    }

    void j(List<xt> list) {
        int size = list.size();
        for (int i6 = 0; i6 < size; i6++) {
            j(list.get(i6));
        }
        list.clear();
    }

    int xt(int i6) {
        return j(i6, 0);
    }
}
