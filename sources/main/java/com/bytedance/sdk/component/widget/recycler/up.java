package com.bytedance.sdk.component.widget.recycler;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.umeng.socialize.common.SocializeConstants;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up extends RecyclerView.g implements RecyclerView.mi.xt {
    final j ae;
    private int ch;
    boolean cw;

    /* renamed from: f, reason: collision with root package name */
    private boolean f27102f;

    /* renamed from: j, reason: collision with root package name */
    int f27103j;
    private boolean kt;

    /* renamed from: m, reason: collision with root package name */
    r f27104m;
    private boolean mi;

    /* renamed from: r, reason: collision with root package name */
    int f27105r;
    private boolean tj;
    int up;

    /* renamed from: v, reason: collision with root package name */
    private boolean f27106v;

    /* renamed from: w, reason: collision with root package name */
    private cw f27107w;

    /* renamed from: x, reason: collision with root package name */
    private final xt f27108x;
    tl xt;

    static class cw {
        int ae;
        int cw;

        /* renamed from: m, reason: collision with root package name */
        int f27111m;
        int oq;

        /* renamed from: r, reason: collision with root package name */
        int f27112r;
        int up;
        boolean vl;
        int xt;

        /* renamed from: j, reason: collision with root package name */
        boolean f27110j = true;
        int tl = 0;

        /* renamed from: g, reason: collision with root package name */
        boolean f27109g = false;
        List<RecyclerView.v> qv = null;

        private View xt() {
            int size = this.qv.size();
            for (int i6 = 0; i6 < size; i6++) {
                View view = this.qv.get(i6).f27042j;
                RecyclerView.oq oqVar = (RecyclerView.oq) view.getLayoutParams();
                if (!oqVar.xt() && this.f27112r == oqVar.r()) {
                    j(view);
                    return view;
                }
            }
            return null;
        }

        boolean j(RecyclerView.kt ktVar) {
            int i6 = this.f27112r;
            return i6 >= 0 && i6 < ktVar.r();
        }

        View j(RecyclerView.av avVar) {
            if (this.qv != null) {
                return xt();
            }
            View xt = avVar.xt(this.f27112r);
            this.f27112r += this.up;
            return xt;
        }

        cw() {
        }

        public void j() {
            j((View) null);
        }

        public View xt(View view) {
            int r5;
            int size = this.qv.size();
            View view2 = null;
            int i6 = Integer.MAX_VALUE;
            for (int i7 = 0; i7 < size; i7++) {
                View view3 = this.qv.get(i7).f27042j;
                RecyclerView.oq oqVar = (RecyclerView.oq) view3.getLayoutParams();
                if (view3 != view && !oqVar.xt() && (r5 = (oqVar.r() - this.f27112r) * this.up) >= 0 && r5 < i6) {
                    if (r5 == 0) {
                        return view3;
                    }
                    view2 = view3;
                    i6 = r5;
                }
            }
            return view2;
        }

        public void j(View view) {
            View xt = xt(view);
            if (xt == null) {
                this.f27112r = -1;
            } else {
                this.f27112r = ((RecyclerView.oq) xt.getLayoutParams()).r();
            }
        }
    }

    static class j {
        int cw;

        /* renamed from: j, reason: collision with root package name */
        tl f27113j;

        /* renamed from: r, reason: collision with root package name */
        boolean f27114r;
        boolean up;
        int xt;

        void j() {
            this.xt = -1;
            this.cw = Integer.MIN_VALUE;
            this.f27114r = false;
            this.up = false;
        }

        void xt() {
            this.cw = this.f27114r ? this.f27113j.r() : this.f27113j.cw();
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.xt + ", mCoordinate=" + this.cw + ", mLayoutFromEnd=" + this.f27114r + ", mValid=" + this.up + '}';
        }

        public void xt(View view, int i6) {
            if (this.f27114r) {
                this.cw = this.f27113j.xt(view) + this.f27113j.xt();
            } else {
                this.cw = this.f27113j.j(view);
            }
            this.xt = i6;
        }

        j() {
            j();
        }

        boolean j(View view, RecyclerView.kt ktVar) {
            RecyclerView.oq oqVar = (RecyclerView.oq) view.getLayoutParams();
            return !oqVar.xt() && oqVar.r() >= 0 && oqVar.r() < ktVar.r();
        }

        public void j(View view, int i6) {
            int xt = this.f27113j.xt();
            if (xt >= 0) {
                xt(view, i6);
                return;
            }
            this.xt = i6;
            if (this.f27114r) {
                int r5 = (this.f27113j.r() - xt) - this.f27113j.xt(view);
                this.cw = this.f27113j.r() - r5;
                if (r5 > 0) {
                    int up = this.cw - this.f27113j.up(view);
                    int cw = this.f27113j.cw();
                    int min = up - (cw + Math.min(this.f27113j.j(view) - cw, 0));
                    if (min < 0) {
                        this.cw += Math.min(r5, -min);
                        return;
                    }
                    return;
                }
                return;
            }
            int j6 = this.f27113j.j(view);
            int cw2 = j6 - this.f27113j.cw();
            this.cw = j6;
            if (cw2 > 0) {
                int r6 = (this.f27113j.r() - Math.min(0, (this.f27113j.r() - xt) - this.f27113j.xt(view))) - (j6 + this.f27113j.up(view));
                if (r6 < 0) {
                    this.cw -= Math.min(cw2, -r6);
                }
            }
        }
    }

    public static class r implements Parcelable {
        public static final Parcelable.Creator<r> CREATOR = new Parcelable.Creator<r>() { // from class: com.bytedance.sdk.component.widget.recycler.up.r.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public r createFromParcel(Parcel parcel) {
                return new r(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public r[] newArray(int i6) {
                return new r[i6];
            }
        };
        boolean cw;

        /* renamed from: j, reason: collision with root package name */
        int f27115j;
        int xt;

        public r() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        void xt() {
            this.f27115j = -1;
        }

        r(Parcel parcel) {
            this.f27115j = parcel.readInt();
            this.xt = parcel.readInt();
            this.cw = parcel.readInt() == 1;
        }

        boolean j() {
            return this.f27115j >= 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            parcel.writeInt(this.f27115j);
            parcel.writeInt(this.xt);
            parcel.writeInt(this.cw ? 1 : 0);
        }
    }

    public up(Context context) {
        this(context, 1, false);
    }

    private void ae(int i6, int i7) {
        this.f27107w.cw = i7 - this.xt.cw();
        cw cwVar = this.f27107w;
        cwVar.f27112r = i6;
        cwVar.up = this.cw ? 1 : -1;
        cwVar.f27111m = -1;
        cwVar.xt = i7;
        cwVar.ae = Integer.MIN_VALUE;
    }

    private int g(RecyclerView.kt ktVar) {
        if (mi() == 0) {
            return 0;
        }
        m();
        return oq.j(ktVar, this.xt, j(!this.f27102f, true), xt(!this.f27102f, true), this, this.f27102f, this.cw);
    }

    private void m(int i6, int i7) {
        this.f27107w.cw = this.xt.r() - i7;
        cw cwVar = this.f27107w;
        cwVar.up = this.cw ? -1 : 1;
        cwVar.f27112r = i6;
        cwVar.f27111m = 1;
        cwVar.xt = i7;
        cwVar.ae = Integer.MIN_VALUE;
    }

    private int oq(RecyclerView.kt ktVar) {
        if (mi() == 0) {
            return 0;
        }
        m();
        return oq.j(ktVar, this.xt, j(!this.f27102f, true), xt(!this.f27102f, true), this, this.f27102f);
    }

    private int qv(RecyclerView.kt ktVar) {
        if (mi() == 0) {
            return 0;
        }
        m();
        return oq.xt(ktVar, this.xt, j(!this.f27102f, true), xt(!this.f27102f, true), this, this.f27102f);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.g
    public boolean cw() {
        return this.f27103j == 0;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.g
    public boolean j() {
        return true;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.g
    public boolean r() {
        return this.f27103j == 1;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.g
    public int tl(RecyclerView.kt ktVar) {
        return qv(ktVar);
    }

    protected boolean up() {
        return i() == 1;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.g
    public RecyclerView.oq xt() {
        return new RecyclerView.oq(-2, -2);
    }

    protected static class xt {
        public boolean cw;

        /* renamed from: j, reason: collision with root package name */
        public int f27116j;

        /* renamed from: r, reason: collision with root package name */
        public boolean f27117r;
        public boolean xt;

        void j() {
            this.f27116j = 0;
            this.xt = false;
            this.cw = false;
            this.f27117r = false;
        }

        protected xt() {
        }
    }

    public up(Context context, int i6, boolean z5) {
        this.f27103j = 1;
        this.kt = false;
        this.cw = false;
        this.tj = false;
        this.f27102f = true;
        this.f27105r = -1;
        this.up = Integer.MIN_VALUE;
        this.f27104m = null;
        this.ae = new j();
        this.f27108x = new xt();
        this.ch = 2;
        j(i6);
        j(z5);
    }

    private View ed() {
        return tl(this.cw ? 0 : mi() - 1);
    }

    private View uf() {
        return tl(this.cw ? mi() - 1 : 0);
    }

    private void wq() {
        if (this.f27103j == 1 || !up()) {
            this.cw = this.kt;
        } else {
            this.cw = !this.kt;
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.mi.xt
    public PointF cw(int i6) {
        if (mi() == 0) {
            return null;
        }
        int i7 = (i6 < r(tl(0))) != this.cw ? -1 : 1;
        return this.f27103j == 0 ? new PointF(i7, 0.0f) : new PointF(0.0f, i7);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.g
    public void j(RecyclerView recyclerView, RecyclerView.av avVar) {
        super.j(recyclerView, avVar);
        if (this.f27106v) {
            cw(avVar);
            avVar.j();
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.g
    public void r(int i6) {
        this.f27105r = i6;
        this.up = Integer.MIN_VALUE;
        r rVar = this.f27104m;
        if (rVar != null) {
            rVar.xt();
        }
        jy();
    }

    boolean tl() {
        return this.xt.tl() == 0 && this.xt.up() == 0;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.g
    public int up(RecyclerView.kt ktVar) {
        return oq(ktVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.g
    public boolean vl() {
        return this.f27104m == null && this.mi == this.tj;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.g
    public View xt(int i6) {
        int mi = mi();
        if (mi == 0) {
            return null;
        }
        int r5 = i6 - r(tl(0));
        if (r5 >= 0 && r5 < mi) {
            View tl = tl(r5);
            if (r(tl) == i6) {
                return tl;
            }
        }
        return super.xt(i6);
    }

    private View tl(RecyclerView.av avVar, RecyclerView.kt ktVar) {
        return j(0, mi());
    }

    int up(int i6) {
        return i6 != 1 ? i6 != 2 ? i6 != 17 ? i6 != 33 ? i6 != 66 ? (i6 == 130 && this.f27103j == 1) ? 1 : Integer.MIN_VALUE : this.f27103j == 0 ? 1 : Integer.MIN_VALUE : this.f27103j == 1 ? -1 : Integer.MIN_VALUE : this.f27103j == 0 ? -1 : Integer.MIN_VALUE : (this.f27103j != 1 && up()) ? -1 : 1 : (this.f27103j != 1 && up()) ? 1 : -1;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.g
    boolean g() {
        return (tj() == 1073741824 || kt() == 1073741824 || !rn()) ? false : true;
    }

    public int oq() {
        View j6 = j(0, mi(), false, true);
        if (j6 == null) {
            return -1;
        }
        return r(j6);
    }

    public int qv() {
        View j6 = j(mi() - 1, -1, false, true);
        if (j6 == null) {
            return -1;
        }
        return r(j6);
    }

    private View g(RecyclerView.av avVar, RecyclerView.kt ktVar) {
        return j(mi() - 1, -1);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.g
    public int cw(RecyclerView.kt ktVar) {
        return g(ktVar);
    }

    public void j(int i6) {
        if (i6 != 0 && i6 != 1) {
            throw new IllegalArgumentException("invalid orientation:".concat(String.valueOf(i6)));
        }
        j((String) null);
        if (i6 != this.f27103j || this.xt == null) {
            tl j6 = tl.j(this, i6);
            this.xt = j6;
            this.ae.f27113j = j6;
            this.f27103j = i6;
            jy();
        }
    }

    cw ae() {
        return new cw();
    }

    int cw(int i6, RecyclerView.av avVar, RecyclerView.kt ktVar) {
        if (mi() == 0 || i6 == 0) {
            return 0;
        }
        this.f27107w.f27110j = true;
        m();
        int i7 = i6 > 0 ? 1 : -1;
        int abs = Math.abs(i6);
        j(i7, abs, true, ktVar);
        cw cwVar = this.f27107w;
        int j6 = cwVar.ae + j(avVar, cwVar, ktVar, false);
        if (j6 < 0) {
            return 0;
        }
        if (abs > j6) {
            i6 = i7 * j6;
        }
        this.xt.j(-i6);
        this.f27107w.oq = i6;
        return i6;
    }

    void m() {
        if (this.f27107w == null) {
            this.f27107w = ae();
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.g
    public int r(RecyclerView.kt ktVar) {
        return g(ktVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.g
    public void xt(RecyclerView.kt ktVar) {
        super.xt(ktVar);
        this.f27104m = null;
        this.f27105r = -1;
        this.up = Integer.MIN_VALUE;
        this.ae.j();
    }

    private View r(RecyclerView.av avVar, RecyclerView.kt ktVar) {
        return j(avVar, ktVar, 0, mi(), ktVar.r());
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.g
    public int ae(RecyclerView.kt ktVar) {
        return qv(ktVar);
    }

    private View ae(RecyclerView.av avVar, RecyclerView.kt ktVar) {
        return this.cw ? g(avVar, ktVar) : tl(avVar, ktVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.g
    public int m(RecyclerView.kt ktVar) {
        return oq(ktVar);
    }

    private View m(RecyclerView.av avVar, RecyclerView.kt ktVar) {
        return this.cw ? tl(avVar, ktVar) : g(avVar, ktVar);
    }

    private View up(RecyclerView.av avVar, RecyclerView.kt ktVar) {
        return j(avVar, ktVar, mi() - 1, -1, ktVar.r());
    }

    private void xt(RecyclerView.av avVar, RecyclerView.kt ktVar, int i6, int i7) {
        if (!ktVar.xt() || mi() == 0 || ktVar.j() || !vl()) {
            return;
        }
        List<RecyclerView.v> cw2 = avVar.cw();
        int size = cw2.size();
        int r5 = r(tl(0));
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            RecyclerView.v vVar = cw2.get(i10);
            if (!vVar.i()) {
                if ((vVar.r() < r5) != this.cw) {
                    i8 += this.xt.up(vVar.f27042j);
                } else {
                    i9 += this.xt.up(vVar.f27042j);
                }
            }
        }
        this.f27107w.qv = cw2;
        if (i8 > 0) {
            ae(r(uf()), i6);
            cw cwVar = this.f27107w;
            cwVar.tl = i8;
            cwVar.cw = 0;
            cwVar.j();
            j(avVar, this.f27107w, ktVar, false);
        }
        if (i9 > 0) {
            m(r(ed()), i7);
            cw cwVar2 = this.f27107w;
            cwVar2.tl = i9;
            cwVar2.cw = 0;
            cwVar2.j();
            j(avVar, this.f27107w, ktVar, false);
        }
        this.f27107w.qv = null;
    }

    public void j(boolean z5) {
        j((String) null);
        if (z5 != this.kt) {
            this.kt = z5;
            jy();
        }
    }

    private View cw(RecyclerView.av avVar, RecyclerView.kt ktVar) {
        return this.cw ? up(avVar, ktVar) : r(avVar, ktVar);
    }

    protected int j(RecyclerView.kt ktVar) {
        if (ktVar.cw()) {
            return this.xt.m();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.g
    public void j(RecyclerView recyclerView, RecyclerView.kt ktVar, int i6) {
        m mVar = new m(recyclerView.getContext());
        mVar.cw(i6);
        j(mVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.g
    public void j(RecyclerView.av avVar, RecyclerView.kt ktVar) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int j6;
        int i11;
        View xt2;
        int j7;
        int i12;
        if ((this.f27104m != null || this.f27105r != -1) && ktVar.r() == 0) {
            cw(avVar);
            return;
        }
        r rVar = this.f27104m;
        if (rVar != null && rVar.j()) {
            this.f27105r = this.f27104m.f27115j;
        }
        m();
        this.f27107w.f27110j = false;
        wq();
        View l6 = l();
        j jVar = this.ae;
        if (jVar.up && this.f27105r == -1 && this.f27104m == null) {
            if (l6 != null && (this.xt.j(l6) >= this.xt.r() || this.xt.xt(l6) <= this.xt.cw())) {
                this.ae.j(l6, r(l6));
            }
        } else {
            jVar.j();
            j jVar2 = this.ae;
            jVar2.f27114r = this.cw ^ this.tj;
            j(avVar, ktVar, jVar2);
            this.ae.up = true;
        }
        int j8 = j(ktVar);
        if (this.f27107w.oq >= 0) {
            i6 = j8;
            j8 = 0;
        } else {
            i6 = 0;
        }
        int cw2 = j8 + this.xt.cw();
        int ae = i6 + this.xt.ae();
        if (ktVar.j() && (i11 = this.f27105r) != -1 && this.up != Integer.MIN_VALUE && (xt2 = xt(i11)) != null) {
            if (this.cw) {
                i12 = this.xt.r() - this.xt.xt(xt2);
                j7 = this.up;
            } else {
                j7 = this.xt.j(xt2) - this.xt.cw();
                i12 = this.up;
            }
            int i13 = i12 - j7;
            if (i13 > 0) {
                cw2 += i13;
            } else {
                ae -= i13;
            }
        }
        j(avVar);
        this.f27107w.vl = tl();
        this.f27107w.f27109g = ktVar.j();
        j jVar3 = this.ae;
        if (jVar3.f27114r) {
            xt(jVar3);
            cw cwVar = this.f27107w;
            cwVar.tl = cw2;
            j(avVar, cwVar, ktVar, false);
            cw cwVar2 = this.f27107w;
            i8 = cwVar2.xt;
            int i14 = cwVar2.f27112r;
            int i15 = cwVar2.cw;
            if (i15 > 0) {
                ae += i15;
            }
            j(this.ae);
            cw cwVar3 = this.f27107w;
            cwVar3.tl = ae;
            cwVar3.f27112r += cwVar3.up;
            j(avVar, cwVar3, ktVar, false);
            cw cwVar4 = this.f27107w;
            i7 = cwVar4.xt;
            int i16 = cwVar4.cw;
            if (i16 > 0) {
                ae(i14, i8);
                cw cwVar5 = this.f27107w;
                cwVar5.tl = i16;
                j(avVar, cwVar5, ktVar, false);
                i8 = this.f27107w.xt;
            }
        } else {
            j(jVar3);
            cw cwVar6 = this.f27107w;
            cwVar6.tl = ae;
            j(avVar, cwVar6, ktVar, false);
            cw cwVar7 = this.f27107w;
            i7 = cwVar7.xt;
            int i17 = cwVar7.f27112r;
            int i18 = cwVar7.cw;
            if (i18 > 0) {
                cw2 += i18;
            }
            xt(this.ae);
            cw cwVar8 = this.f27107w;
            cwVar8.tl = cw2;
            cwVar8.f27112r += cwVar8.up;
            j(avVar, cwVar8, ktVar, false);
            cw cwVar9 = this.f27107w;
            i8 = cwVar9.xt;
            int i19 = cwVar9.cw;
            if (i19 > 0) {
                m(i17, i7);
                cw cwVar10 = this.f27107w;
                cwVar10.tl = i19;
                j(avVar, cwVar10, ktVar, false);
                i7 = this.f27107w.xt;
            }
        }
        if (mi() > 0) {
            if (this.cw ^ this.tj) {
                int j9 = j(i7, avVar, ktVar, true);
                i9 = i8 + j9;
                i10 = i7 + j9;
                j6 = xt(i9, avVar, ktVar, false);
            } else {
                int xt3 = xt(i8, avVar, ktVar, true);
                i9 = i8 + xt3;
                i10 = i7 + xt3;
                j6 = j(i10, avVar, ktVar, false);
            }
            i8 = i9 + j6;
            i7 = i10 + j6;
        }
        xt(avVar, ktVar, i8, i7);
        if (!ktVar.j()) {
            this.xt.j();
        } else {
            this.ae.j();
        }
        this.mi = this.tj;
    }

    private boolean xt(RecyclerView.av avVar, RecyclerView.kt ktVar, j jVar) {
        if (mi() == 0) {
            return false;
        }
        View l6 = l();
        if (l6 != null && jVar.j(l6, ktVar)) {
            jVar.j(l6, r(l6));
            return true;
        }
        if (this.mi != this.tj) {
            return false;
        }
        View xt2 = jVar.f27114r ? xt(avVar, ktVar) : cw(avVar, ktVar);
        if (xt2 == null) {
            return false;
        }
        jVar.xt(xt2, r(xt2));
        if (!ktVar.j() && vl() && (this.xt.j(xt2) >= this.xt.r() || this.xt.xt(xt2) < this.xt.cw())) {
            jVar.cw = jVar.f27114r ? this.xt.r() : this.xt.cw();
        }
        return true;
    }

    private int xt(int i6, RecyclerView.av avVar, RecyclerView.kt ktVar, boolean z5) {
        int cw2;
        int cw3 = i6 - this.xt.cw();
        if (cw3 <= 0) {
            return 0;
        }
        int i7 = -cw(cw3, avVar, ktVar);
        int i8 = i6 + i7;
        if (!z5 || (cw2 = i8 - this.xt.cw()) <= 0) {
            return i7;
        }
        this.xt.j(-cw2);
        return i7 - cw2;
    }

    private void xt(j jVar) {
        ae(jVar.xt, jVar.cw);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.g
    public int xt(int i6, RecyclerView.av avVar, RecyclerView.kt ktVar) {
        if (this.f27103j == 0) {
            return 0;
        }
        return cw(i6, avVar, ktVar);
    }

    private void xt(RecyclerView.av avVar, int i6) {
        int mi = mi();
        if (i6 >= 0) {
            int up = this.xt.up() - i6;
            if (this.cw) {
                for (int i7 = 0; i7 < mi; i7++) {
                    View tl = tl(i7);
                    if (this.xt.j(tl) < up || this.xt.r(tl) < up) {
                        j(avVar, 0, i7);
                        return;
                    }
                }
                return;
            }
            int i8 = mi - 1;
            for (int i9 = i8; i9 >= 0; i9--) {
                View tl2 = tl(i9);
                if (this.xt.j(tl2) < up || this.xt.r(tl2) < up) {
                    j(avVar, i8, i9);
                    return;
                }
            }
        }
    }

    private View xt(boolean z5, boolean z6) {
        int mi;
        int i6;
        if (this.cw) {
            mi = 0;
            i6 = mi();
        } else {
            mi = mi() - 1;
            i6 = -1;
        }
        return j(mi, i6, z5, z6);
    }

    private View xt(RecyclerView.av avVar, RecyclerView.kt ktVar) {
        return this.cw ? r(avVar, ktVar) : up(avVar, ktVar);
    }

    private void j(RecyclerView.av avVar, RecyclerView.kt ktVar, j jVar) {
        if (j(ktVar, jVar) || xt(avVar, ktVar, jVar)) {
            return;
        }
        jVar.xt();
        jVar.xt = this.tj ? ktVar.r() - 1 : 0;
    }

    private boolean j(RecyclerView.kt ktVar, j jVar) {
        int i6;
        if (!ktVar.j() && (i6 = this.f27105r) != -1) {
            if (i6 >= 0 && i6 < ktVar.r()) {
                jVar.xt = this.f27105r;
                r rVar = this.f27104m;
                if (rVar != null && rVar.j()) {
                    boolean z5 = this.f27104m.cw;
                    jVar.f27114r = z5;
                    if (z5) {
                        jVar.cw = this.xt.r() - this.f27104m.xt;
                    } else {
                        jVar.cw = this.xt.cw() + this.f27104m.xt;
                    }
                    return true;
                }
                if (this.up == Integer.MIN_VALUE) {
                    View xt2 = xt(this.f27105r);
                    if (xt2 != null) {
                        if (this.xt.up(xt2) > this.xt.m()) {
                            jVar.xt();
                            return true;
                        }
                        if (this.xt.j(xt2) - this.xt.cw() < 0) {
                            jVar.cw = this.xt.cw();
                            jVar.f27114r = false;
                            return true;
                        }
                        if (this.xt.r() - this.xt.xt(xt2) < 0) {
                            jVar.cw = this.xt.r();
                            jVar.f27114r = true;
                            return true;
                        }
                        jVar.cw = jVar.f27114r ? this.xt.xt(xt2) + this.xt.xt() : this.xt.j(xt2);
                    } else {
                        if (mi() > 0) {
                            jVar.f27114r = (this.f27105r < r(tl(0))) == this.cw;
                        }
                        jVar.xt();
                    }
                    return true;
                }
                boolean z6 = this.cw;
                jVar.f27114r = z6;
                if (z6) {
                    jVar.cw = this.xt.r() - this.up;
                } else {
                    jVar.cw = this.xt.cw() + this.up;
                }
                return true;
            }
            this.f27105r = -1;
            this.up = Integer.MIN_VALUE;
        }
        return false;
    }

    private int j(int i6, RecyclerView.av avVar, RecyclerView.kt ktVar, boolean z5) {
        int r5;
        int r6 = this.xt.r() - i6;
        if (r6 <= 0) {
            return 0;
        }
        int i7 = -cw(-r6, avVar, ktVar);
        int i8 = i6 + i7;
        if (!z5 || (r5 = this.xt.r() - i8) <= 0) {
            return i7;
        }
        this.xt.j(r5);
        return r5 + i7;
    }

    private void j(j jVar) {
        m(jVar.xt, jVar.cw);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.g
    public int j(int i6, RecyclerView.av avVar, RecyclerView.kt ktVar) {
        if (this.f27103j == 1) {
            return 0;
        }
        return cw(i6, avVar, ktVar);
    }

    private void j(int i6, int i7, boolean z5, RecyclerView.kt ktVar) {
        int cw2;
        this.f27107w.vl = tl();
        this.f27107w.tl = j(ktVar);
        cw cwVar = this.f27107w;
        cwVar.f27111m = i6;
        if (i6 == 1) {
            cwVar.tl += this.xt.ae();
            View ed = ed();
            cw cwVar2 = this.f27107w;
            cwVar2.up = this.cw ? -1 : 1;
            int r5 = r(ed);
            cw cwVar3 = this.f27107w;
            cwVar2.f27112r = r5 + cwVar3.up;
            cwVar3.xt = this.xt.xt(ed);
            cw2 = this.xt.xt(ed) - this.xt.r();
        } else {
            View uf = uf();
            this.f27107w.tl += this.xt.cw();
            cw cwVar4 = this.f27107w;
            cwVar4.up = this.cw ? 1 : -1;
            int r6 = r(uf);
            cw cwVar5 = this.f27107w;
            cwVar4.f27112r = r6 + cwVar5.up;
            cwVar5.xt = this.xt.j(uf);
            cw2 = (-this.xt.j(uf)) + this.xt.cw();
        }
        cw cwVar6 = this.f27107w;
        cwVar6.cw = i7;
        if (z5) {
            cwVar6.cw = i7 - cw2;
        }
        cwVar6.ae = cw2;
    }

    void j(RecyclerView.kt ktVar, cw cwVar, RecyclerView.g.j jVar) {
        int i6 = cwVar.f27112r;
        if (i6 < 0 || i6 >= ktVar.r()) {
            return;
        }
        jVar.xt(i6, Math.max(0, cwVar.ae));
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.g
    public void j(int i6, RecyclerView.g.j jVar) {
        boolean z5;
        int i7;
        r rVar = this.f27104m;
        if (rVar != null && rVar.j()) {
            r rVar2 = this.f27104m;
            z5 = rVar2.cw;
            i7 = rVar2.f27115j;
        } else {
            wq();
            z5 = this.cw;
            i7 = this.f27105r;
            if (i7 == -1) {
                i7 = z5 ? i6 - 1 : 0;
            }
        }
        int i8 = z5 ? -1 : 1;
        for (int i9 = 0; i9 < this.ch && i7 >= 0 && i7 < i6; i9++) {
            jVar.xt(i7, 0);
            i7 += i8;
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.g
    public void j(int i6, int i7, RecyclerView.kt ktVar, RecyclerView.g.j jVar) {
        if (this.f27103j != 0) {
            i6 = i7;
        }
        if (mi() == 0 || i6 == 0) {
            return;
        }
        m();
        j(i6 > 0 ? 1 : -1, Math.abs(i6), true, ktVar);
        j(ktVar, this.f27107w, jVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.g
    public void j(String str) {
        if (this.f27104m == null) {
            super.j(str);
        }
    }

    private void j(RecyclerView.av avVar, int i6, int i7) {
        if (i6 != i7) {
            if (i7 <= i6) {
                while (i6 > i7) {
                    j(i6, avVar);
                    i6--;
                }
            } else {
                for (int i8 = i7 - 1; i8 >= i6; i8--) {
                    j(i8, avVar);
                }
            }
        }
    }

    private void j(RecyclerView.av avVar, int i6) {
        if (i6 >= 0) {
            int mi = mi();
            if (!this.cw) {
                for (int i7 = 0; i7 < mi; i7++) {
                    View tl = tl(i7);
                    if (this.xt.xt(tl) > i6 || this.xt.cw(tl) > i6) {
                        j(avVar, 0, i7);
                        return;
                    }
                }
                return;
            }
            int i8 = mi - 1;
            for (int i9 = i8; i9 >= 0; i9--) {
                View tl2 = tl(i9);
                if (this.xt.xt(tl2) > i6 || this.xt.cw(tl2) > i6) {
                    j(avVar, i8, i9);
                    return;
                }
            }
        }
    }

    private void j(RecyclerView.av avVar, cw cwVar) {
        if (!cwVar.f27110j || cwVar.vl) {
            return;
        }
        if (cwVar.f27111m == -1) {
            xt(avVar, cwVar.ae);
        } else {
            j(avVar, cwVar.ae);
        }
    }

    int j(RecyclerView.av avVar, cw cwVar, RecyclerView.kt ktVar, boolean z5) {
        int i6 = cwVar.cw;
        int i7 = cwVar.ae;
        if (i7 != Integer.MIN_VALUE) {
            if (i6 < 0) {
                cwVar.ae = i7 + i6;
            }
            j(avVar, cwVar);
        }
        int i8 = cwVar.cw + cwVar.tl;
        xt xtVar = this.f27108x;
        while (true) {
            if ((!cwVar.vl && i8 <= 0) || !cwVar.j(ktVar)) {
                break;
            }
            xtVar.j();
            j(avVar, ktVar, cwVar, xtVar);
            if (!xtVar.xt) {
                cwVar.xt += xtVar.f27116j * cwVar.f27111m;
                if (!xtVar.cw || this.f27107w.qv != null || !ktVar.j()) {
                    int i9 = cwVar.cw;
                    int i10 = xtVar.f27116j;
                    cwVar.cw = i9 - i10;
                    i8 -= i10;
                }
                int i11 = cwVar.ae;
                if (i11 != Integer.MIN_VALUE) {
                    int i12 = i11 + xtVar.f27116j;
                    cwVar.ae = i12;
                    int i13 = cwVar.cw;
                    if (i13 < 0) {
                        cwVar.ae = i12 + i13;
                    }
                    j(avVar, cwVar);
                }
                if (z5 && xtVar.f27117r) {
                    break;
                }
            } else {
                break;
            }
        }
        return i6 - cwVar.cw;
    }

    void j(RecyclerView.av avVar, RecyclerView.kt ktVar, cw cwVar, xt xtVar) {
        int i6;
        int i7;
        int i8;
        int i9;
        int x5;
        int m6;
        int i10;
        int i11;
        View j6 = cwVar.j(avVar);
        if (j6 == null) {
            xtVar.xt = true;
            return;
        }
        RecyclerView.oq oqVar = (RecyclerView.oq) j6.getLayoutParams();
        if (cwVar.qv == null) {
            if (this.cw == (cwVar.f27111m == -1)) {
                xt(j6);
            } else {
                xt(j6, 0);
            }
        } else {
            if (this.cw == (cwVar.f27111m == -1)) {
                j(j6);
            } else {
                j(j6, 0);
            }
        }
        j(j6, 0, 0);
        xtVar.f27116j = this.xt.up(j6);
        if (this.f27103j == 1) {
            if (up()) {
                m6 = f() - s();
                x5 = m6 - this.xt.m(j6);
            } else {
                x5 = x();
                m6 = this.xt.m(j6) + x5;
            }
            if (cwVar.f27111m == -1) {
                i11 = cwVar.xt;
                i10 = i11 - xtVar.f27116j;
            } else {
                i10 = cwVar.xt;
                i11 = xtVar.f27116j + i10;
            }
            int i12 = x5;
            i9 = i10;
            i8 = i12;
            i7 = i11;
            i6 = m6;
        } else {
            int ch = ch();
            int m7 = this.xt.m(j6) + ch;
            if (cwVar.f27111m == -1) {
                int i13 = cwVar.xt;
                i8 = i13 - xtVar.f27116j;
                i6 = i13;
                i7 = m7;
            } else {
                int i14 = cwVar.xt;
                i6 = xtVar.f27116j + i14;
                i7 = m7;
                i8 = i14;
            }
            i9 = ch;
        }
        j(j6, i8, i9, i6, i7);
        if (oqVar.xt() || oqVar.cw()) {
            xtVar.cw = true;
        }
        xtVar.f27117r = j6.hasFocusable();
    }

    private View j(boolean z5, boolean z6) {
        int i6;
        int mi;
        if (this.cw) {
            i6 = mi() - 1;
            mi = -1;
        } else {
            i6 = 0;
            mi = mi();
        }
        return j(i6, mi, z5, z6);
    }

    View j(RecyclerView.av avVar, RecyclerView.kt ktVar, int i6, int i7, int i8) {
        m();
        int cw2 = this.xt.cw();
        int r5 = this.xt.r();
        int i9 = i7 > i6 ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i6 != i7) {
            View tl = tl(i6);
            int r6 = r(tl);
            if (r6 >= 0 && r6 < i8) {
                if (((RecyclerView.oq) tl.getLayoutParams()).xt()) {
                    if (view2 == null) {
                        view2 = tl;
                    }
                } else {
                    if (this.xt.j(tl) < r5 && this.xt.xt(tl) >= cw2) {
                        return tl;
                    }
                    if (view == null) {
                        view = tl;
                    }
                }
            }
            i6 += i9;
        }
        return view != null ? view : view2;
    }

    View j(int i6, int i7, boolean z5, boolean z6) {
        m();
        return (this.f27103j == 0 ? this.oq : this.qv).j(i6, i7, z5 ? SocializeConstants.AUTH_EVENT : 320, z6 ? 320 : 0);
    }

    View j(int i6, int i7) {
        int i8;
        int i9;
        m();
        if (i7 > i6 || i7 < i6) {
            if (this.xt.j(tl(i6)) < this.xt.cw()) {
                i8 = 16644;
                i9 = 16388;
            } else {
                i8 = 4161;
                i9 = 4097;
            }
            return (this.f27103j == 0 ? this.oq : this.qv).j(i6, i7, i8, i9);
        }
        return tl(i6);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.g
    public View j(View view, int i6, RecyclerView.av avVar, RecyclerView.kt ktVar) {
        int up;
        View m6;
        View ed;
        wq();
        if (mi() == 0 || (up = up(i6)) == Integer.MIN_VALUE) {
            return null;
        }
        m();
        m();
        j(up, (int) (this.xt.m() * 0.33333334f), false, ktVar);
        cw cwVar = this.f27107w;
        cwVar.ae = Integer.MIN_VALUE;
        cwVar.f27110j = false;
        j(avVar, cwVar, ktVar, true);
        if (up == -1) {
            m6 = ae(avVar, ktVar);
        } else {
            m6 = m(avVar, ktVar);
        }
        if (up == -1) {
            ed = uf();
        } else {
            ed = ed();
        }
        if (!ed.hasFocusable()) {
            return m6;
        }
        if (m6 == null) {
            return null;
        }
        return ed;
    }
}
