package com.bytedance.sdk.component.widget.recycler;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.component.widget.recycler.j;
import com.bytedance.sdk.component.widget.recycler.jy;
import com.bytedance.sdk.component.widget.recycler.r;
import com.bytedance.sdk.component.widget.recycler.ws;
import com.bytedance.sdk.component.widget.recycler.xt;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class RecyclerView extends ViewGroup implements com.bytedance.sdk.component.widget.recycler.j.cw.cw {
    static final boolean cw;
    static final Interpolator ed;

    /* renamed from: j, reason: collision with root package name */
    static final boolean f26974j;

    /* renamed from: n, reason: collision with root package name */
    private static final boolean f26975n;
    private static final boolean nd;

    /* renamed from: r, reason: collision with root package name */
    static final boolean f26976r;
    private static final Class<?>[] rh;
    static final boolean xt;

    /* renamed from: a, reason: collision with root package name */
    com.bytedance.sdk.component.widget.recycler.r f26977a;
    com.bytedance.sdk.component.widget.recycler.xt ae;
    private int aq;
    final ArrayList<tl> av;
    i az;

    /* renamed from: b, reason: collision with root package name */
    private int f26978b;
    m ch;

    /* renamed from: e, reason: collision with root package name */
    private boolean f26979e;

    /* renamed from: f, reason: collision with root package name */
    boolean f26980f;
    private EdgeEffect ff;

    /* renamed from: g, reason: collision with root package name */
    boolean f26981g;
    boolean gq;

    /* renamed from: h, reason: collision with root package name */
    boolean f26982h;
    private final Rect hh;
    private jy hl;

    /* renamed from: i, reason: collision with root package name */
    boolean f26983i;
    private m.j ik;
    private vl im;
    j jy;

    /* renamed from: k, reason: collision with root package name */
    private up f26984k;
    private r ka;
    private EdgeEffect kc;
    private boolean ki;
    boolean kt;

    /* renamed from: l, reason: collision with root package name */
    r.j f26985l;
    boolean la;
    private final int[] ll;
    private int ln;

    /* renamed from: m, reason: collision with root package name */
    com.bytedance.sdk.component.widget.recycler.j f26986m;
    boolean mi;
    private final int nt;
    private final w ol;
    final Runnable oq;
    private Runnable oy;

    /* renamed from: p, reason: collision with root package name */
    final kt f26987p;
    private int pz;

    /* renamed from: q, reason: collision with root package name */
    private int f26988q;
    private int qa;
    private final AccessibilityManager qb;
    private final int[] qo;
    final Rect qv;
    private float ri;
    final int[] rn;
    private int rr;
    private EdgeEffect ry;

    /* renamed from: s, reason: collision with root package name */
    final f f26989s;
    private int sm;
    private VelocityTracker st;

    /* renamed from: t, reason: collision with root package name */
    private ws f26990t;
    boolean tj;
    final com.bytedance.sdk.component.widget.recycler.ws tl;

    /* renamed from: u, reason: collision with root package name */
    private final int[] f26991u;
    private float uc;
    final List<v> uf;
    final av up;
    private List<ws> uq;

    /* renamed from: v, reason: collision with root package name */
    boolean f26992v;
    final RectF vl;

    /* renamed from: w, reason: collision with root package name */
    boolean f26993w;
    private int wf;
    private com.bytedance.sdk.component.widget.recycler.j.cw.r wo;
    final int[] wq;
    g ws;

    /* renamed from: x, reason: collision with root package name */
    boolean f26994x;
    private int xp;
    private int xq;

    /* renamed from: y, reason: collision with root package name */
    private final int f26995y;
    private List<qv> ya;
    private final ws.xt yl;

    /* renamed from: z, reason: collision with root package name */
    private final ArrayList<jy> f26996z;
    private EdgeEffect zz;

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f26973c = {R.attr.nestedScrollingEnabled};
    private static final int[] gx = {R.attr.clipToPadding};

    private class ae implements m.j {
        @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.m.j
        public void j(v vVar) {
            vVar.j(true);
            if (vVar.tl != null && vVar.f27041g == null) {
                vVar.tl = null;
            }
            vVar.f27041g = null;
            if (vVar.x() || RecyclerView.this.j(vVar.f27042j) || !vVar.w()) {
                return;
            }
            RecyclerView.this.removeDetachedView(vVar.f27042j, false);
        }

        ae() {
        }
    }

    public final class av {
        private final List<v> ae;
        final ArrayList<v> cw;

        /* renamed from: g, reason: collision with root package name */
        private tj f27003g;

        /* renamed from: j, reason: collision with root package name */
        final ArrayList<v> f27004j;

        /* renamed from: r, reason: collision with root package name */
        int f27006r;
        private int tl;
        az up;
        ArrayList<v> xt;

        private void up(v vVar) {
            View view = vVar.f27042j;
            if (view instanceof ViewGroup) {
                j((ViewGroup) view, false);
            }
        }

        public List<v> cw() {
            return this.ae;
        }

        public void j() {
            this.f27004j.clear();
            r();
        }

        void r() {
            for (int size = this.cw.size() - 1; size >= 0; size--) {
                cw(size);
            }
            this.cw.clear();
            if (RecyclerView.f26976r) {
                RecyclerView.this.f26985l.j();
            }
        }

        void xt() {
            g gVar = RecyclerView.this.ws;
            this.f27006r = this.tl + (gVar != null ? gVar.av : 0);
            for (int size = this.cw.size() - 1; size >= 0 && this.cw.size() > this.f27006r; size--) {
                cw(size);
            }
        }

        public av() {
            ArrayList<v> arrayList = new ArrayList<>();
            this.f27004j = arrayList;
            this.xt = null;
            this.cw = new ArrayList<>();
            this.ae = Collections.unmodifiableList(arrayList);
            this.tl = 2;
            this.f27006r = 2;
        }

        az ae() {
            if (this.up == null) {
                this.up = new az();
            }
            return this.up;
        }

        void cw(int i6) {
            j(this.cw.get(i6), true);
            this.cw.remove(i6);
        }

        void g() {
            int size = this.cw.size();
            for (int i6 = 0; i6 < size; i6++) {
                this.cw.get(i6).j();
            }
            int size2 = this.f27004j.size();
            for (int i7 = 0; i7 < size2; i7++) {
                this.f27004j.get(i7).j();
            }
            ArrayList<v> arrayList = this.xt;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i8 = 0; i8 < size3; i8++) {
                    this.xt.get(i8).j();
                }
            }
        }

        void m() {
            this.f27004j.clear();
            ArrayList<v> arrayList = this.xt;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        void oq() {
            int size = this.cw.size();
            for (int i6 = 0; i6 < size; i6++) {
                oq oqVar = (oq) this.cw.get(i6).f27042j.getLayoutParams();
                if (oqVar != null) {
                    oqVar.cw = true;
                }
            }
        }

        void tl() {
            int size = this.cw.size();
            for (int i6 = 0; i6 < size; i6++) {
                v vVar = this.cw.get(i6);
                if (vVar != null) {
                    vVar.xt(6);
                    vVar.j((Object) null);
                }
            }
            j jVar = RecyclerView.this.jy;
            if (jVar == null || !jVar.xt()) {
                r();
            }
        }

        public void j(int i6) {
            this.tl = i6;
            xt();
        }

        int up() {
            return this.f27004j.size();
        }

        v up(int i6) {
            int size;
            int xt;
            ArrayList<v> arrayList = this.xt;
            if (arrayList != null && (size = arrayList.size()) != 0) {
                for (int i7 = 0; i7 < size; i7++) {
                    v vVar = this.xt.get(i7);
                    if (!vVar.qv() && vVar.r() == i6) {
                        vVar.xt(32);
                        return vVar;
                    }
                }
                if (RecyclerView.this.jy.xt() && (xt = RecyclerView.this.f26986m.xt(i6)) > 0 && xt < RecyclerView.this.jy.j()) {
                    long xt2 = RecyclerView.this.jy.xt(xt);
                    for (int i8 = 0; i8 < size; i8++) {
                        v vVar2 = this.xt.get(i8);
                        if (!vVar2.qv() && vVar2.ae() == xt2) {
                            vVar2.xt(32);
                            return vVar2;
                        }
                    }
                }
            }
            return null;
        }

        void cw(View view) {
            v up = RecyclerView.up(view);
            if (!up.j(12) && up.s() && !RecyclerView.this.xt(up)) {
                if (this.xt == null) {
                    this.xt = new ArrayList<>();
                }
                up.j(this, true);
                this.xt.add(up);
                return;
            }
            if (up.ws() && !up.i() && !RecyclerView.this.jy.xt()) {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.j());
            }
            up.j(this, false);
            this.f27004j.add(up);
        }

        boolean j(v vVar) {
            if (vVar.i()) {
                return RecyclerView.this.f26987p.j();
            }
            int i6 = vVar.cw;
            if (i6 >= 0 && i6 < RecyclerView.this.jy.j()) {
                if (RecyclerView.this.f26987p.j() || RecyclerView.this.jy.j(vVar.cw) == vVar.tl()) {
                    return !RecyclerView.this.jy.xt() || vVar.ae() == RecyclerView.this.jy.xt(vVar.cw);
                }
                return false;
            }
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + vVar + RecyclerView.this.j());
        }

        public View xt(int i6) {
            return j(i6, false);
        }

        View r(int i6) {
            return this.f27004j.get(i6).f27042j;
        }

        void xt(v vVar) {
            boolean z5;
            boolean z6 = true;
            if (!vVar.g() && vVar.f27042j.getParent() == null) {
                if (!vVar.w()) {
                    if (!vVar.L_()) {
                        boolean ch = vVar.ch();
                        j jVar = RecyclerView.this.jy;
                        if ((jVar != null && ch && jVar.xt((j) vVar)) || vVar.v()) {
                            if (this.f27006r <= 0 || vVar.j(526)) {
                                z5 = false;
                            } else {
                                int size = this.cw.size();
                                if (size >= this.f27006r && size > 0) {
                                    cw(0);
                                    size--;
                                }
                                if (RecyclerView.f26976r && size > 0 && !RecyclerView.this.f26985l.j(vVar.cw)) {
                                    int i6 = size - 1;
                                    while (i6 >= 0) {
                                        if (!RecyclerView.this.f26985l.j(this.cw.get(i6).cw)) {
                                            break;
                                        } else {
                                            i6--;
                                        }
                                    }
                                    size = i6 + 1;
                                }
                                this.cw.add(size, vVar);
                                z5 = true;
                            }
                            if (!z5) {
                                j(vVar, true);
                                r1 = z5;
                                RecyclerView.this.tl.ae(vVar);
                                if (r1 && !z6 && ch) {
                                    vVar.av = null;
                                    return;
                                }
                                return;
                            }
                            r1 = z5;
                        }
                        z6 = false;
                        RecyclerView.this.tl.ae(vVar);
                        if (r1) {
                            return;
                        } else {
                            return;
                        }
                    }
                    throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.j());
                }
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + vVar + RecyclerView.this.j());
            }
            StringBuilder sb = new StringBuilder("Scrapped or attached views may not be recycled. isScrap:");
            sb.append(vVar.g());
            sb.append(" isAttached:");
            sb.append(vVar.f27042j.getParent() != null);
            sb.append(RecyclerView.this.j());
            throw new IllegalArgumentException(sb.toString());
        }

        void r(v vVar) {
            j jVar = RecyclerView.this.jy;
            if (jVar != null) {
                jVar.j((j) vVar);
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f26987p != null) {
                recyclerView.tl.ae(vVar);
            }
        }

        private boolean j(v vVar, int i6, int i7, long j6) {
            vVar.av = RecyclerView.this;
            int tl = vVar.tl();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j6 != Long.MAX_VALUE && !this.up.xt(tl, nanoTime, j6)) {
                return false;
            }
            RecyclerView.this.jy.xt((j) vVar, i6);
            this.up.xt(vVar.tl(), RecyclerView.this.getNanoTime() - nanoTime);
            if (!RecyclerView.this.f26987p.j()) {
                return true;
            }
            vVar.ae = i7;
            return true;
        }

        void cw(v vVar) {
            if (vVar.ws) {
                this.xt.remove(vVar);
            } else {
                this.f27004j.remove(vVar);
            }
            vVar.jy = null;
            vVar.ws = false;
            vVar.vl();
        }

        void cw(int i6, int i7) {
            int i8;
            int i9 = i7 + i6;
            for (int size = this.cw.size() - 1; size >= 0; size--) {
                v vVar = this.cw.get(size);
                if (vVar != null && (i8 = vVar.cw) >= i6 && i8 < i9) {
                    vVar.xt(2);
                    cw(size);
                }
            }
        }

        View j(int i6, boolean z5) {
            return j(i6, z5, Long.MAX_VALUE).f27042j;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:78:0x0196  */
        /* JADX WARN: Removed duplicated region for block: B:87:0x01ed  */
        /* JADX WARN: Removed duplicated region for block: B:90:0x0217 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:94:0x01fb  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        com.bytedance.sdk.component.widget.recycler.RecyclerView.v j(int r17, boolean r18, long r19) {
            /*
                Method dump skipped, instructions count: 595
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.RecyclerView.av.j(int, boolean, long):com.bytedance.sdk.component.widget.recycler.RecyclerView$v");
        }

        void xt(View view) {
            v up = RecyclerView.up(view);
            up.jy = null;
            up.ws = false;
            up.vl();
            xt(up);
        }

        v xt(int i6, boolean z5) {
            View cw;
            int size = this.f27004j.size();
            for (int i7 = 0; i7 < size; i7++) {
                v vVar = this.f27004j.get(i7);
                if (!vVar.qv() && vVar.r() == i6 && !vVar.ws() && (RecyclerView.this.f26987p.ae || !vVar.i())) {
                    vVar.xt(32);
                    return vVar;
                }
            }
            if (!z5 && (cw = RecyclerView.this.ae.cw(i6)) != null) {
                v up = RecyclerView.up(cw);
                RecyclerView.this.ae.up(cw);
                int xt = RecyclerView.this.ae.xt(cw);
                if (xt != -1) {
                    RecyclerView.this.ae.up(xt);
                    cw(cw);
                    up.xt(8224);
                    return up;
                }
                throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + up + RecyclerView.this.j());
            }
            int size2 = this.cw.size();
            for (int i8 = 0; i8 < size2; i8++) {
                v vVar2 = this.cw.get(i8);
                if (!vVar2.ws() && vVar2.r() == i6) {
                    if (!z5) {
                        this.cw.remove(i8);
                    }
                    return vVar2;
                }
            }
            return null;
        }

        void xt(int i6, int i7) {
            int size = this.cw.size();
            for (int i8 = 0; i8 < size; i8++) {
                v vVar = this.cw.get(i8);
                if (vVar != null && vVar.cw >= i6) {
                    vVar.j(i7, true);
                }
            }
        }

        private void j(ViewGroup viewGroup, boolean z5) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    j((ViewGroup) childAt, true);
                }
            }
            if (z5) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                } else {
                    int visibility = viewGroup.getVisibility();
                    viewGroup.setVisibility(4);
                    viewGroup.setVisibility(visibility);
                }
            }
        }

        public void j(View view) {
            v up = RecyclerView.up(view);
            if (up.w()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (up.g()) {
                up.oq();
            } else if (up.qv()) {
                up.vl();
            }
            xt(up);
        }

        void j(v vVar, boolean z5) {
            RecyclerView.cw(vVar);
            if (vVar.j(16384)) {
                vVar.j(0, 16384);
            }
            if (z5) {
                r(vVar);
            }
            vVar.av = null;
            ae().j(vVar);
        }

        v j(long j6, int i6, boolean z5) {
            for (int size = this.f27004j.size() - 1; size >= 0; size--) {
                v vVar = this.f27004j.get(size);
                if (vVar.ae() == j6 && !vVar.qv()) {
                    if (i6 == vVar.tl()) {
                        vVar.xt(32);
                        if (vVar.i() && !RecyclerView.this.f26987p.j()) {
                            vVar.j(2, 14);
                        }
                        return vVar;
                    }
                    if (!z5) {
                        this.f27004j.remove(size);
                        RecyclerView.this.removeDetachedView(vVar.f27042j, false);
                        xt(vVar.f27042j);
                    }
                }
            }
            int size2 = this.cw.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                v vVar2 = this.cw.get(size2);
                if (vVar2.ae() == j6) {
                    if (i6 == vVar2.tl()) {
                        if (!z5) {
                            this.cw.remove(size2);
                        }
                        return vVar2;
                    }
                    if (!z5) {
                        cw(size2);
                        return null;
                    }
                }
            }
        }

        void j(j jVar, j jVar2, boolean z5) {
            j();
            ae().j(jVar, jVar2, z5);
        }

        void j(int i6, int i7) {
            int i8;
            int i9;
            int i10;
            int i11;
            if (i6 < i7) {
                i8 = -1;
                i10 = i6;
                i9 = i7;
            } else {
                i8 = 1;
                i9 = i6;
                i10 = i7;
            }
            int size = this.cw.size();
            for (int i12 = 0; i12 < size; i12++) {
                v vVar = this.cw.get(i12);
                if (vVar != null && (i11 = vVar.cw) >= i10 && i11 <= i9) {
                    if (i11 == i6) {
                        vVar.j(i7 - i6, false);
                    } else {
                        vVar.j(i8, false);
                    }
                }
            }
        }

        void j(int i6, int i7, boolean z5) {
            int i8 = i6 + i7;
            for (int size = this.cw.size() - 1; size >= 0; size--) {
                v vVar = this.cw.get(size);
                if (vVar != null) {
                    int i9 = vVar.cw;
                    if (i9 >= i8) {
                        vVar.j(-i7, z5);
                    } else if (i9 >= i6) {
                        vVar.xt(8);
                        cw(size);
                    }
                }
            }
        }

        void j(tj tjVar) {
            this.f27003g = tjVar;
        }

        void j(az azVar) {
            az azVar2 = this.up;
            if (azVar2 != null) {
                azVar2.cw();
            }
            this.up = azVar;
            if (azVar == null || RecyclerView.this.getAdapter() == null) {
                return;
            }
            this.up.xt();
        }
    }

    public static class az {

        /* renamed from: j, reason: collision with root package name */
        SparseArray<j> f27007j = new SparseArray<>();
        private int xt = 0;

        public void j() {
            for (int i6 = 0; i6 < this.f27007j.size(); i6++) {
                this.f27007j.valueAt(i6).f27008j.clear();
            }
        }

        void xt(int i6, long j6) {
            j xt = xt(i6);
            xt.f27009r = j(xt.f27009r, j6);
        }

        static class j {

            /* renamed from: j, reason: collision with root package name */
            final ArrayList<v> f27008j = new ArrayList<>();
            int xt = 5;
            long cw = 0;

            /* renamed from: r, reason: collision with root package name */
            long f27009r = 0;

            j() {
            }
        }

        void cw() {
            this.xt--;
        }

        boolean xt(int i6, long j6, long j7) {
            long j8 = xt(i6).f27009r;
            return j8 == 0 || j6 + j8 < j7;
        }

        public v j(int i6) {
            j jVar = this.f27007j.get(i6);
            if (jVar == null || jVar.f27008j.isEmpty()) {
                return null;
            }
            return jVar.f27008j.remove(r2.size() - 1);
        }

        void xt() {
            this.xt++;
        }

        private j xt(int i6) {
            j jVar = this.f27007j.get(i6);
            if (jVar != null) {
                return jVar;
            }
            j jVar2 = new j();
            this.f27007j.put(i6, jVar2);
            return jVar2;
        }

        public void j(v vVar) {
            int tl = vVar.tl();
            ArrayList<v> arrayList = xt(tl).f27008j;
            if (this.f27007j.get(tl).xt > arrayList.size()) {
                vVar.f();
                arrayList.add(vVar);
            }
        }

        long j(long j6, long j7) {
            return j6 == 0 ? j7 : ((j6 / 4) * 3) + (j7 / 4);
        }

        void j(int i6, long j6) {
            j xt = xt(i6);
            xt.cw = j(xt.cw, j6);
        }

        boolean j(int i6, long j6, long j7) {
            long j8 = xt(i6).cw;
            return j8 == 0 || j6 + j8 < j7;
        }

        void j(j jVar, j jVar2, boolean z5) {
            if (jVar != null) {
                cw();
            }
            if (!z5 && this.xt == 0) {
                j();
            }
            if (jVar2 != null) {
                xt();
            }
        }
    }

    public static abstract class cw {
        public void j() {
        }

        public void j(int i6, int i7, Object obj) {
        }
    }

    class f implements Runnable {
        private boolean ae;

        /* renamed from: j, reason: collision with root package name */
        OverScroller f27010j;

        /* renamed from: m, reason: collision with root package name */
        private boolean f27011m;

        /* renamed from: r, reason: collision with root package name */
        private int f27012r;
        private int up;
        Interpolator xt;

        private void cw() {
            this.ae = false;
            this.f27011m = true;
        }

        private void r() {
            this.f27011m = false;
            if (this.ae) {
                j();
            }
        }

        void j() {
            if (this.f27011m) {
                this.ae = true;
            } else {
                RecyclerView.this.removeCallbacks(this);
                com.bytedance.sdk.component.widget.recycler.j.cw.ae.j(RecyclerView.this, this);
            }
        }

        public void xt(int i6, int i7) {
            j(i6, i7, 0, 0);
        }

        f() {
            Interpolator interpolator = RecyclerView.ed;
            this.xt = interpolator;
            this.f27011m = false;
            this.ae = false;
            this.f27010j = new OverScroller(RecyclerView.this.getContext(), interpolator);
        }

        private int xt(int i6, int i7, int i8, int i9) {
            int i10;
            int abs = Math.abs(i6);
            int abs2 = Math.abs(i7);
            boolean z5 = abs > abs2;
            int sqrt = (int) Math.sqrt((i8 * i8) + (i9 * i9));
            int sqrt2 = (int) Math.sqrt((i6 * i6) + (i7 * i7));
            RecyclerView recyclerView = RecyclerView.this;
            int width = z5 ? recyclerView.getWidth() : recyclerView.getHeight();
            int i11 = width / 2;
            float f6 = width;
            float f7 = i11;
            float j6 = f7 + (j(Math.min(1.0f, (sqrt2 * 1.0f) / f6)) * f7);
            if (sqrt > 0) {
                i10 = Math.round(Math.abs(j6 / sqrt) * 1000.0f) * 4;
            } else {
                if (!z5) {
                    abs = abs2;
                }
                i10 = (int) (((abs / f6) + 1.0f) * 300.0f);
            }
            return Math.min(i10, 2000);
        }

        /* JADX WARN: Code restructure failed: missing block: B:56:0x00ec, code lost:
        
            if (r14 > 0) goto L51;
         */
        /* JADX WARN: Removed duplicated region for block: B:42:0x00e8  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00f8  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x00ff A[ADDED_TO_REGION] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 419
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.RecyclerView.f.run():void");
        }

        public void j(int i6, int i7) {
            RecyclerView.this.setScrollState(2);
            this.up = 0;
            this.f27012r = 0;
            this.f27010j.fling(0, 0, i6, i7, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            j();
        }

        public void j(int i6, int i7, int i8, int i9) {
            j(i6, i7, xt(i6, i7, i8, i9));
        }

        private float j(float f6) {
            return (float) Math.sin((f6 - 0.5f) * 0.47123894f);
        }

        public void j(int i6, int i7, int i8) {
            j(i6, i7, i8, RecyclerView.ed);
        }

        public void j(int i6, int i7, Interpolator interpolator) {
            int xt = xt(i6, i7, 0, 0);
            if (interpolator == null) {
                interpolator = RecyclerView.ed;
            }
            j(i6, i7, xt, interpolator);
        }

        public void xt() {
            RecyclerView.this.removeCallbacks(this);
            this.f27010j.abortAnimation();
        }

        public void j(int i6, int i7, int i8, Interpolator interpolator) {
            if (this.xt != interpolator) {
                this.xt = interpolator;
                this.f27010j = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            RecyclerView.this.setScrollState(2);
            this.up = 0;
            this.f27012r = 0;
            this.f27010j.startScroll(0, 0, i6, i7, i8);
            if (Build.VERSION.SDK_INT < 23) {
                this.f27010j.computeScrollOffset();
            }
            j();
        }
    }

    public static abstract class g {
        private int ae;
        int av;
        boolean az;
        private boolean cw;

        /* renamed from: g, reason: collision with root package name */
        RecyclerView f27013g;

        /* renamed from: i, reason: collision with root package name */
        boolean f27014i;

        /* renamed from: j, reason: collision with root package name */
        private final jy.xt f27015j;
        boolean jy;

        /* renamed from: m, reason: collision with root package name */
        private int f27016m;
        com.bytedance.sdk.component.widget.recycler.jy oq;
        com.bytedance.sdk.component.widget.recycler.jy qv;

        /* renamed from: r, reason: collision with root package name */
        private boolean f27017r;
        com.bytedance.sdk.component.widget.recycler.xt tl;
        private int up;
        mi vl;

        /* renamed from: w, reason: collision with root package name */
        private int f27018w;
        boolean ws;
        private final jy.xt xt;

        public interface j {
            void xt(int i6, int i7);
        }

        public int ae(kt ktVar) {
            return 0;
        }

        public int cw(kt ktVar) {
            return 0;
        }

        boolean g() {
            return false;
        }

        public int j(int i6, av avVar, kt ktVar) {
            return 0;
        }

        public void jy() {
            RecyclerView recyclerView = this.f27013g;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public int m(kt ktVar) {
            return 0;
        }

        public void oq(int i6) {
            RecyclerView recyclerView = this.f27013g;
            if (recyclerView != null) {
                recyclerView.up(i6);
            }
        }

        public void qv(int i6) {
        }

        public int r(kt ktVar) {
            return 0;
        }

        public int tl(kt ktVar) {
            return 0;
        }

        public int up(kt ktVar) {
            return 0;
        }

        public boolean vl() {
            return false;
        }

        public int w() {
            return -1;
        }

        public final boolean ws() {
            return this.f27017r;
        }

        public int xt(int i6, av avVar, kt ktVar) {
            return 0;
        }

        public abstract oq xt();

        public int a() {
            RecyclerView recyclerView = this.f27013g;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public void ae(int i6) {
            j(i6, tl(i6));
        }

        public boolean av() {
            mi miVar = this.vl;
            return miVar != null && miVar.ae();
        }

        public boolean az() {
            RecyclerView recyclerView = this.f27013g;
            return recyclerView != null && recyclerView.f26981g;
        }

        public int ch() {
            RecyclerView recyclerView = this.f27013g;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public void cw(RecyclerView recyclerView) {
        }

        public int f() {
            return this.ae;
        }

        public void g(int i6) {
            RecyclerView recyclerView = this.f27013g;
            if (recyclerView != null) {
                recyclerView.m(i6);
            }
        }

        void gq() {
            mi miVar = this.vl;
            if (miVar != null) {
                miVar.up();
            }
        }

        public int h() {
            return com.bytedance.sdk.component.widget.recycler.j.cw.ae.r(this.f27013g);
        }

        public int i() {
            return com.bytedance.sdk.component.widget.recycler.j.cw.ae.j(this.f27013g);
        }

        public View j(View view, int i6, av avVar, kt ktVar) {
            return null;
        }

        public int kt() {
            return this.up;
        }

        public View l() {
            View focusedChild;
            RecyclerView recyclerView = this.f27013g;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.tl.cw(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public int la() {
            return com.bytedance.sdk.component.widget.recycler.j.cw.ae.up(this.f27013g);
        }

        public void m(int i6) {
            if (tl(i6) != null) {
                this.tl.j(i6);
            }
        }

        public int mi() {
            com.bytedance.sdk.component.widget.recycler.xt xtVar = this.tl;
            if (xtVar != null) {
                return xtVar.xt();
            }
            return 0;
        }

        public int p() {
            RecyclerView recyclerView = this.f27013g;
            j adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.j();
            }
            return 0;
        }

        public int qv(View view) {
            return ((oq) view.getLayoutParams()).xt.top;
        }

        public View r(View view, int i6) {
            return null;
        }

        public int s() {
            RecyclerView recyclerView = this.f27013g;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public int tj() {
            return this.f27016m;
        }

        public View tl(int i6) {
            com.bytedance.sdk.component.widget.recycler.xt xtVar = this.tl;
            if (xtVar != null) {
                return xtVar.xt(i6);
            }
            return null;
        }

        public int up(View view) {
            Rect rect = ((oq) view.getLayoutParams()).xt;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int v() {
            return this.f27018w;
        }

        public int vl(View view) {
            return ((oq) view.getLayoutParams()).xt.bottom;
        }

        public int ws(View view) {
            return ((oq) view.getLayoutParams()).xt.right;
        }

        public int x() {
            RecyclerView recyclerView = this.f27013g;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public void xt(kt ktVar) {
        }

        public g() {
            jy.xt xtVar = new jy.xt() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.g.1
                @Override // com.bytedance.sdk.component.widget.recycler.jy.xt
                public View j(int i6) {
                    return g.this.tl(i6);
                }

                @Override // com.bytedance.sdk.component.widget.recycler.jy.xt
                public int xt() {
                    return g.this.f() - g.this.s();
                }

                @Override // com.bytedance.sdk.component.widget.recycler.jy.xt
                public int j() {
                    return g.this.x();
                }

                @Override // com.bytedance.sdk.component.widget.recycler.jy.xt
                public int xt(View view) {
                    return g.this.g(view) + ((ViewGroup.MarginLayoutParams) ((oq) view.getLayoutParams())).rightMargin;
                }

                @Override // com.bytedance.sdk.component.widget.recycler.jy.xt
                public int j(View view) {
                    return g.this.ae(view) - ((ViewGroup.MarginLayoutParams) ((oq) view.getLayoutParams())).leftMargin;
                }
            };
            this.f27015j = xtVar;
            jy.xt xtVar2 = new jy.xt() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.g.2
                @Override // com.bytedance.sdk.component.widget.recycler.jy.xt
                public View j(int i6) {
                    return g.this.tl(i6);
                }

                @Override // com.bytedance.sdk.component.widget.recycler.jy.xt
                public int xt() {
                    return g.this.v() - g.this.a();
                }

                @Override // com.bytedance.sdk.component.widget.recycler.jy.xt
                public int j() {
                    return g.this.ch();
                }

                @Override // com.bytedance.sdk.component.widget.recycler.jy.xt
                public int xt(View view) {
                    return g.this.oq(view) + ((ViewGroup.MarginLayoutParams) ((oq) view.getLayoutParams())).bottomMargin;
                }

                @Override // com.bytedance.sdk.component.widget.recycler.jy.xt
                public int j(View view) {
                    return g.this.tl(view) - ((ViewGroup.MarginLayoutParams) ((oq) view.getLayoutParams())).topMargin;
                }
            };
            this.xt = xtVar2;
            this.oq = new com.bytedance.sdk.component.widget.recycler.jy(xtVar);
            this.qv = new com.bytedance.sdk.component.widget.recycler.jy(xtVar2);
            this.jy = false;
            this.ws = false;
            this.az = false;
            this.cw = true;
            this.f27017r = true;
        }

        public int ae(View view) {
            return view.getLeft() - jy(view);
        }

        public boolean cw() {
            return false;
        }

        public void j(int i6, int i7, kt ktVar, j jVar) {
        }

        public int jy(View view) {
            return ((oq) view.getLayoutParams()).xt.left;
        }

        public int oq(View view) {
            return view.getBottom() + vl(view);
        }

        public void r(int i6) {
        }

        boolean rn() {
            int mi = mi();
            for (int i6 = 0; i6 < mi; i6++) {
                ViewGroup.LayoutParams layoutParams = tl(i6).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public int tl(View view) {
            return view.getTop() - qv(view);
        }

        void xt(int i6, int i7) {
            this.ae = View.MeasureSpec.getSize(i6);
            int mode = View.MeasureSpec.getMode(i6);
            this.up = mode;
            if (mode == 0 && !RecyclerView.xt) {
                this.ae = 0;
            }
            this.f27018w = View.MeasureSpec.getSize(i7);
            int mode2 = View.MeasureSpec.getMode(i7);
            this.f27016m = mode2;
            if (mode2 != 0 || RecyclerView.xt) {
                return;
            }
            this.f27018w = 0;
        }

        void cw(int i6, int i7) {
            int mi = mi();
            if (mi == 0) {
                this.f27013g.up(i6, i7);
                return;
            }
            int i8 = Integer.MIN_VALUE;
            int i9 = Integer.MIN_VALUE;
            int i10 = Integer.MAX_VALUE;
            int i11 = Integer.MAX_VALUE;
            for (int i12 = 0; i12 < mi; i12++) {
                View tl = tl(i12);
                Rect rect = this.f27013g.qv;
                j(tl, rect);
                int i13 = rect.left;
                if (i13 < i10) {
                    i10 = i13;
                }
                int i14 = rect.right;
                if (i14 > i8) {
                    i8 = i14;
                }
                int i15 = rect.top;
                if (i15 < i11) {
                    i11 = i15;
                }
                int i16 = rect.bottom;
                if (i16 > i9) {
                    i9 = i16;
                }
            }
            this.f27013g.qv.set(i10, i11, i8, i9);
            j(this.f27013g.qv, i6, i7);
        }

        public int g(View view) {
            return view.getRight() + ws(view);
        }

        public void j(int i6, j jVar) {
        }

        public int m(View view) {
            Rect rect = ((oq) view.getLayoutParams()).xt;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public boolean r() {
            return false;
        }

        public void up(int i6, int i7) {
            this.f27013g.setMeasuredDimension(i6, i7);
        }

        public void j(RecyclerView recyclerView, av avVar) {
        }

        public int r(View view) {
            return ((oq) view.getLayoutParams()).r();
        }

        public boolean j(oq oqVar) {
            return oqVar != null;
        }

        public void r(int i6, int i7) {
            View tl = tl(i6);
            if (tl != null) {
                ae(i6);
                cw(tl, i7);
            } else {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i6 + this.f27013g.toString());
            }
        }

        public boolean j(RecyclerView recyclerView, ArrayList<View> arrayList, int i6, int i7) {
            return false;
        }

        void j(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.f27013g = null;
                this.tl = null;
                this.ae = 0;
                this.f27018w = 0;
            } else {
                this.f27013g = recyclerView;
                this.tl = recyclerView.ae;
                this.ae = recyclerView.getWidth();
                this.f27018w = recyclerView.getHeight();
            }
            this.up = 1073741824;
            this.f27016m = 1073741824;
        }

        void r(RecyclerView recyclerView) {
            xt(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        void xt(RecyclerView recyclerView) {
            this.ws = true;
            cw(recyclerView);
        }

        void xt(RecyclerView recyclerView, av avVar) {
            this.ws = false;
            j(recyclerView, avVar);
        }

        public void cw(View view) {
            this.tl.j(view);
        }

        public void xt(View view) {
            xt(view, -1);
        }

        public void cw(View view, int i6) {
            j(view, i6, (oq) view.getLayoutParams());
        }

        public void xt(View view, int i6) {
            j(view, i6, false);
        }

        public void cw(av avVar) {
            for (int mi = mi() - 1; mi >= 0; mi--) {
                if (!RecyclerView.up(tl(mi)).L_()) {
                    j(mi, avVar);
                }
            }
        }

        public View xt(int i6) {
            int mi = mi();
            for (int i7 = 0; i7 < mi; i7++) {
                View tl = tl(i7);
                v up = RecyclerView.up(tl);
                if (up != null && up.r() == i6 && !up.L_() && (this.f27013g.f26987p.j() || !up.i())) {
                    return tl;
                }
            }
            return null;
        }

        public void j(Rect rect, int i6, int i7) {
            up(j(i6, rect.width() + x() + s(), h()), j(i7, rect.height() + ch() + a(), la()));
        }

        void xt(av avVar) {
            int up = avVar.up();
            for (int i6 = up - 1; i6 >= 0; i6--) {
                View r5 = avVar.r(i6);
                v up2 = RecyclerView.up(r5);
                if (!up2.L_()) {
                    up2.j(false);
                    if (up2.w()) {
                        this.f27013g.removeDetachedView(r5, false);
                    }
                    m mVar = this.f27013g.ch;
                    if (mVar != null) {
                        mVar.r(up2);
                    }
                    up2.j(true);
                    avVar.xt(r5);
                }
            }
            avVar.m();
            if (up > 0) {
                this.f27013g.invalidate();
            }
        }

        public static int j(int i6, int i7, int i8) {
            int mode = View.MeasureSpec.getMode(i6);
            int size = View.MeasureSpec.getSize(i6);
            if (mode != Integer.MIN_VALUE) {
                return mode != 1073741824 ? Math.max(i7, i8) : size;
            }
            return Math.min(size, Math.max(i7, i8));
        }

        public void j(String str) {
            RecyclerView recyclerView = this.f27013g;
            if (recyclerView != null) {
                recyclerView.j(str);
            }
        }

        public boolean j() {
            return this.az;
        }

        public void j(av avVar, kt ktVar) {
            com.bytedance.sdk.component.utils.vl.r("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public oq j(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof oq) {
                return new oq((oq) layoutParams);
            }
            return layoutParams instanceof ViewGroup.MarginLayoutParams ? new oq((ViewGroup.MarginLayoutParams) layoutParams) : new oq(layoutParams);
        }

        private static boolean xt(int i6, int i7, int i8) {
            int mode = View.MeasureSpec.getMode(i7);
            int size = View.MeasureSpec.getSize(i7);
            if (i8 > 0 && i6 != i8) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i6;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i6;
            }
            return true;
        }

        public oq j(Context context, AttributeSet attributeSet) {
            return new oq(context, attributeSet);
        }

        public void j(RecyclerView recyclerView, kt ktVar, int i6) {
            com.bytedance.sdk.component.utils.vl.r("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
        }

        private int[] xt(RecyclerView recyclerView, View view, Rect rect, boolean z5) {
            int x5 = x();
            int ch = ch();
            int f6 = f() - s();
            int v5 = v() - a();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top2 = (view.getTop() + rect.top) - view.getScrollY();
            int width = rect.width() + left;
            int height = rect.height() + top2;
            int i6 = left - x5;
            int min = Math.min(0, i6);
            int i7 = top2 - ch;
            int min2 = Math.min(0, i7);
            int i8 = width - f6;
            int max = Math.max(0, i8);
            int max2 = Math.max(0, height - v5);
            if (i() != 1) {
                if (min == 0) {
                    min = Math.min(i6, max);
                }
                max = min;
            } else if (max == 0) {
                max = Math.max(min, i8);
            }
            if (min2 == 0) {
                min2 = Math.min(i7, max2);
            }
            return new int[]{max, min2};
        }

        public void j(mi miVar) {
            mi miVar2 = this.vl;
            if (miVar2 != null && miVar != miVar2 && miVar2.ae()) {
                this.vl.up();
            }
            this.vl = miVar;
            miVar.j(this.f27013g, this);
        }

        public void j(View view) {
            j(view, -1);
        }

        public void j(View view, int i6) {
            j(view, i6, true);
        }

        private void j(View view, int i6, boolean z5) {
            v up = RecyclerView.up(view);
            if (!z5 && !up.i()) {
                this.f27013g.tl.m(up);
            } else {
                this.f27013g.tl.up(up);
            }
            oq oqVar = (oq) view.getLayoutParams();
            if (!up.qv() && !up.g()) {
                if (view.getParent() == this.f27013g) {
                    int xt = this.tl.xt(view);
                    if (i6 == -1) {
                        i6 = this.tl.xt();
                    }
                    if (xt == -1) {
                        throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f27013g.indexOfChild(view) + this.f27013g.j());
                    }
                    if (xt != i6) {
                        this.f27013g.ws.r(xt, i6);
                    }
                } else {
                    this.tl.j(view, i6, false);
                    oqVar.cw = true;
                    mi miVar = this.vl;
                    if (miVar != null && miVar.ae()) {
                        this.vl.xt(view);
                    }
                }
            } else {
                if (up.g()) {
                    up.oq();
                } else {
                    up.vl();
                }
                this.tl.j(view, i6, view.getLayoutParams(), false);
            }
            if (oqVar.f27039r) {
                up.f27042j.invalidate();
                oqVar.f27039r = false;
            }
        }

        void xt(mi miVar) {
            if (this.vl == miVar) {
                this.vl = null;
            }
        }

        private void j(int i6, View view) {
            this.tl.up(i6);
        }

        public void j(View view, int i6, oq oqVar) {
            v up = RecyclerView.up(view);
            if (up.i()) {
                this.f27013g.tl.up(up);
            } else {
                this.f27013g.tl.m(up);
            }
            this.tl.j(view, i6, oqVar, up.i());
        }

        public void j(View view, av avVar) {
            cw(view);
            avVar.j(view);
        }

        public void j(int i6, av avVar) {
            View tl = tl(i6);
            m(i6);
            avVar.j(tl);
        }

        public void j(av avVar) {
            for (int mi = mi() - 1; mi >= 0; mi--) {
                j(avVar, mi, tl(mi));
            }
        }

        private void j(av avVar, int i6, View view) {
            v up = RecyclerView.up(view);
            if (up.L_()) {
                return;
            }
            if (up.ws() && !up.i() && !this.f27013g.jy.xt()) {
                m(i6);
                avVar.xt(up);
            } else {
                ae(i6);
                avVar.cw(view);
                this.f27013g.tl.tl(up);
            }
        }

        boolean j(View view, int i6, int i7, oq oqVar) {
            return (!view.isLayoutRequested() && this.cw && xt(view.getWidth(), i6, ((ViewGroup.MarginLayoutParams) oqVar).width) && xt(view.getHeight(), i7, ((ViewGroup.MarginLayoutParams) oqVar).height)) ? false : true;
        }

        public void j(View view, int i6, int i7) {
            oq oqVar = (oq) view.getLayoutParams();
            Rect g6 = this.f27013g.g(view);
            int i8 = i6 + g6.left + g6.right;
            int i9 = i7 + g6.top + g6.bottom;
            int j6 = j(f(), kt(), x() + s() + ((ViewGroup.MarginLayoutParams) oqVar).leftMargin + ((ViewGroup.MarginLayoutParams) oqVar).rightMargin + i8, ((ViewGroup.MarginLayoutParams) oqVar).width, cw());
            int j7 = j(v(), tj(), ch() + a() + ((ViewGroup.MarginLayoutParams) oqVar).topMargin + ((ViewGroup.MarginLayoutParams) oqVar).bottomMargin + i9, ((ViewGroup.MarginLayoutParams) oqVar).height, r());
            if (j(view, j6, j7, oqVar)) {
                view.measure(j6, j7);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
        
            if (r5 == 1073741824) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static int j(int r4, int r5, int r6, int r7, boolean r8) {
            /*
                int r4 = r4 - r6
                r6 = 0
                int r4 = java.lang.Math.max(r6, r4)
                r0 = -2
                r1 = -1
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = 1073741824(0x40000000, float:2.0)
                if (r8 == 0) goto L1c
                if (r7 < 0) goto L13
            L10:
                r5 = 1073741824(0x40000000, float:2.0)
                goto L2e
            L13:
                if (r7 != r1) goto L19
                if (r5 == r2) goto L21
                if (r5 == r3) goto L21
            L19:
                r5 = 0
                r7 = 0
                goto L2e
            L1c:
                if (r7 < 0) goto L1f
                goto L10
            L1f:
                if (r7 != r1) goto L23
            L21:
                r7 = r4
                goto L2e
            L23:
                if (r7 != r0) goto L19
                if (r5 == r2) goto L2b
                if (r5 == r3) goto L2b
                r5 = 0
                goto L21
            L2b:
                r5 = -2147483648(0xffffffff80000000, float:-0.0)
                goto L21
            L2e:
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r5)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.RecyclerView.g.j(int, int, int, int, boolean):int");
        }

        public void j(View view, int i6, int i7, int i8, int i9) {
            oq oqVar = (oq) view.getLayoutParams();
            Rect rect = oqVar.xt;
            view.layout(i6 + rect.left + ((ViewGroup.MarginLayoutParams) oqVar).leftMargin, i7 + rect.top + ((ViewGroup.MarginLayoutParams) oqVar).topMargin, (i8 - rect.right) - ((ViewGroup.MarginLayoutParams) oqVar).rightMargin, (i9 - rect.bottom) - ((ViewGroup.MarginLayoutParams) oqVar).bottomMargin);
        }

        public void j(View view, boolean z5, Rect rect) {
            Matrix matrix;
            if (z5) {
                Rect rect2 = ((oq) view.getLayoutParams()).xt;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.f27013g != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.f27013g.vl;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void j(View view, Rect rect) {
            RecyclerView.j(view, rect);
        }

        public boolean j(RecyclerView recyclerView, View view, Rect rect, boolean z5) {
            return j(recyclerView, view, rect, z5, false);
        }

        public boolean j(RecyclerView recyclerView, View view, Rect rect, boolean z5, boolean z6) {
            int[] xt = xt(recyclerView, view, rect, z5);
            int i6 = xt[0];
            int i7 = xt[1];
            if ((z6 && !j(recyclerView, i6, i7)) || (i6 == 0 && i7 == 0)) {
                return false;
            }
            if (z5) {
                recyclerView.scrollBy(i6, i7);
            } else {
                recyclerView.j(i6, i7);
            }
            return true;
        }

        private boolean j(RecyclerView recyclerView, int i6, int i7) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int x5 = x();
            int ch = ch();
            int f6 = f() - s();
            int v5 = v() - a();
            Rect rect = this.f27013g.qv;
            j(focusedChild, rect);
            return rect.left - i6 < f6 && rect.right - i6 > x5 && rect.top - i7 < v5 && rect.bottom - i7 > ch;
        }

        @Deprecated
        public boolean j(RecyclerView recyclerView, View view, View view2) {
            return av() || recyclerView.ws();
        }

        public boolean j(RecyclerView recyclerView, kt ktVar, View view, View view2) {
            return j(recyclerView, view, view2);
        }

        public void j(av avVar, kt ktVar, int i6, int i7) {
            this.f27013g.up(i6, i7);
        }
    }

    public interface i {
    }

    public static abstract class j<VH extends v> {

        /* renamed from: j, reason: collision with root package name */
        private final xt f27021j = new xt();
        private boolean xt = false;

        public abstract int j();

        public int j(int i6) {
            return 0;
        }

        public abstract VH j(ViewGroup viewGroup, int i6);

        public abstract void j(VH vh, int i6);

        public long xt(int i6) {
            return -1L;
        }

        public final void cw() {
            this.f27021j.j();
        }

        public void j(VH vh) {
        }

        public boolean xt(VH vh) {
            return false;
        }

        public void j(VH vh, int i6, List<Object> list) {
            j((j<VH>) vh, i6);
        }

        public final VH xt(ViewGroup viewGroup, int i6) {
            try {
                com.bytedance.sdk.component.widget.recycler.j.j.j.j("RV CreateView");
                VH j6 = j(viewGroup, i6);
                if (j6.f27042j.getParent() == null) {
                    j6.f27043m = i6;
                    return j6;
                }
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            } finally {
                com.bytedance.sdk.component.widget.recycler.j.j.j.j();
            }
        }

        public void j(cw cwVar) {
            this.f27021j.registerObserver(cwVar);
        }

        public final void j(int i6, Object obj) {
            this.f27021j.j(i6, 1, obj);
        }

        public final void j(int i6, int i7) {
            this.f27021j.j(i6, i7);
        }

        public final void xt(VH vh, int i6) {
            vh.cw = i6;
            if (xt()) {
                vh.up = xt(i6);
            }
            vh.j(1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CURRENT_DOWNLOAD_INDEX);
            com.bytedance.sdk.component.widget.recycler.j.j.j.j("RV OnBindView");
            j(vh, i6, vh.tj());
            vh.kt();
            ViewGroup.LayoutParams layoutParams = vh.f27042j.getLayoutParams();
            if (layoutParams instanceof oq) {
                ((oq) layoutParams).cw = true;
            }
            com.bytedance.sdk.component.widget.recycler.j.j.j.j();
        }

        public final boolean xt() {
            return this.xt;
        }

        public void xt(cw cwVar) {
            this.f27021j.unregisterObserver(cwVar);
        }
    }

    public interface jy {
        boolean j(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    public static class kt {
        int av;
        int az;

        /* renamed from: i, reason: collision with root package name */
        private SparseArray<Object> f27023i;
        long jy;
        int vl;
        int ws;

        /* renamed from: j, reason: collision with root package name */
        int f27024j = -1;
        int xt = 0;
        int cw = 0;

        /* renamed from: r, reason: collision with root package name */
        int f27026r = 1;
        int up = 0;

        /* renamed from: m, reason: collision with root package name */
        boolean f27025m = false;
        boolean ae = false;
        boolean tl = false;

        /* renamed from: g, reason: collision with root package name */
        boolean f27022g = false;
        boolean oq = false;
        boolean qv = false;

        void j(int i6) {
            if ((this.f27026r & i6) != 0) {
                return;
            }
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i6) + " but it is " + Integer.toBinaryString(this.f27026r));
        }

        public boolean cw() {
            return this.f27024j != -1;
        }

        public int r() {
            return this.ae ? this.xt - this.cw : this.up;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f27024j + ", mData=" + this.f27023i + ", mItemCount=" + this.up + ", mIsMeasuring=" + this.f27022g + ", mPreviousLayoutItemCount=" + this.xt + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.cw + ", mStructureChanged=" + this.f27025m + ", mInPreLayout=" + this.ae + ", mRunSimpleAnimations=" + this.oq + ", mRunPredictiveAnimations=" + this.qv + '}';
        }

        public boolean xt() {
            return this.qv;
        }

        void j(j jVar) {
            this.f27026r = 1;
            this.up = jVar.j();
            this.ae = false;
            this.tl = false;
            this.f27022g = false;
        }

        public boolean j() {
            return this.ae;
        }
    }

    public static abstract class m {

        /* renamed from: j, reason: collision with root package name */
        private j f27027j = null;
        private ArrayList<Object> xt = new ArrayList<>();
        private long cw = 120;

        /* renamed from: r, reason: collision with root package name */
        private long f27029r = 120;
        private long up = 250;

        /* renamed from: m, reason: collision with root package name */
        private long f27028m = 250;

        interface j {
            void j(v vVar);
        }

        public static class xt {
            public int cw;

            /* renamed from: j, reason: collision with root package name */
            public int f27030j;

            /* renamed from: r, reason: collision with root package name */
            public int f27031r;
            public int xt;

            public xt j(v vVar) {
                return j(vVar, 0);
            }

            public xt j(v vVar, int i6) {
                View view = vVar.f27042j;
                this.f27030j = view.getLeft();
                this.xt = view.getTop();
                this.cw = view.getRight();
                this.f27031r = view.getBottom();
                return this;
            }
        }

        public boolean ae(v vVar) {
            return true;
        }

        public abstract boolean cw(v vVar, xt xtVar, xt xtVar2);

        public abstract void j();

        void j(j jVar) {
            this.f27027j = jVar;
        }

        public abstract boolean j(v vVar, xt xtVar, xt xtVar2);

        public abstract boolean j(v vVar, v vVar2, xt xtVar, xt xtVar2);

        public long m() {
            return this.cw;
        }

        public abstract void r();

        public abstract void r(v vVar);

        public long up() {
            return this.up;
        }

        public abstract boolean xt();

        public abstract boolean xt(v vVar, xt xtVar, xt xtVar2);

        static int up(v vVar) {
            int i6 = vVar.oq;
            int i7 = i6 & 14;
            if (vVar.ws()) {
                return 4;
            }
            if ((i6 & 4) == 0) {
                int m6 = vVar.m();
                int up = vVar.up();
                if (m6 != -1 && up != -1 && m6 != up) {
                    return i7 | 2048;
                }
            }
            return i7;
        }

        public long ae() {
            return this.f27029r;
        }

        public final void g() {
            int size = this.xt.size();
            for (int i6 = 0; i6 < size; i6++) {
                this.xt.get(i6);
            }
            this.xt.clear();
        }

        public xt j(kt ktVar, v vVar, int i6, List<Object> list) {
            return oq().j(vVar);
        }

        public final void m(v vVar) {
            j jVar = this.f27027j;
            if (jVar != null) {
                jVar.j(vVar);
            }
        }

        public xt oq() {
            return new xt();
        }

        public long tl() {
            return this.f27028m;
        }

        public xt j(kt ktVar, v vVar) {
            return oq().j(vVar);
        }

        public boolean j(v vVar, List<Object> list) {
            return ae(vVar);
        }
    }

    public static abstract class mi {
        private g cw;

        /* renamed from: m, reason: collision with root package name */
        private View f27033m;

        /* renamed from: r, reason: collision with root package name */
        private boolean f27034r;
        private boolean tl;
        private boolean up;
        private RecyclerView xt;

        /* renamed from: j, reason: collision with root package name */
        private int f27032j = -1;
        private final j ae = new j(0, 0);

        public static class j {
            private int ae;
            private int cw;

            /* renamed from: j, reason: collision with root package name */
            private int f27035j;

            /* renamed from: m, reason: collision with root package name */
            private boolean f27036m;

            /* renamed from: r, reason: collision with root package name */
            private int f27037r;
            private Interpolator up;
            private int xt;

            public j(int i6, int i7) {
                this(i6, i7, Integer.MIN_VALUE, null);
            }

            public void j(int i6) {
                this.f27037r = i6;
            }

            public j(int i6, int i7, int i8, Interpolator interpolator) {
                this.f27037r = -1;
                this.f27036m = false;
                this.ae = 0;
                this.f27035j = i6;
                this.xt = i7;
                this.cw = i8;
                this.up = interpolator;
            }

            private void xt() {
                if (this.up != null && this.cw <= 0) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (this.cw <= 0) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            boolean j() {
                return this.f27037r >= 0;
            }

            public void update(int i6, int i7, int i8, Interpolator interpolator) {
                this.f27035j = i6;
                this.xt = i7;
                this.cw = i8;
                this.up = interpolator;
                this.f27036m = true;
            }

            void j(RecyclerView recyclerView) {
                int i6 = this.f27037r;
                if (i6 >= 0) {
                    this.f27037r = -1;
                    recyclerView.j(i6);
                    this.f27036m = false;
                    return;
                }
                if (this.f27036m) {
                    xt();
                    Interpolator interpolator = this.up;
                    if (interpolator == null) {
                        int i7 = this.cw;
                        if (i7 == Integer.MIN_VALUE) {
                            recyclerView.f26989s.xt(this.f27035j, this.xt);
                        } else {
                            recyclerView.f26989s.j(this.f27035j, this.xt, i7);
                        }
                    } else {
                        recyclerView.f26989s.j(this.f27035j, this.xt, this.cw, interpolator);
                    }
                    int i8 = this.ae + 1;
                    this.ae = i8;
                    if (i8 > 10) {
                        com.bytedance.sdk.component.utils.vl.r("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f27036m = false;
                    return;
                }
                this.ae = 0;
            }
        }

        public interface xt {
            PointF cw(int i6);
        }

        protected abstract void j();

        protected abstract void j(int i6, int i7, kt ktVar, j jVar);

        protected abstract void j(View view, kt ktVar, j jVar);

        void j(RecyclerView recyclerView, g gVar) {
            if (this.tl) {
                com.bytedance.sdk.component.utils.vl.xt("RecyclerView", "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            this.xt = recyclerView;
            this.cw = gVar;
            int i6 = this.f27032j;
            if (i6 == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            recyclerView.f26987p.f27024j = i6;
            this.up = true;
            this.f27034r = true;
            this.f27033m = up(tl());
            this.xt.f26989s.j();
            this.tl = true;
        }

        public PointF r(int i6) {
            Object r5 = r();
            if (r5 instanceof xt) {
                return ((xt) r5).cw(i6);
            }
            com.bytedance.sdk.component.utils.vl.xt("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + xt.class.getCanonicalName());
            return null;
        }

        protected final void up() {
            if (this.up) {
                this.up = false;
                j();
                this.xt.f26987p.f27024j = -1;
                this.f27033m = null;
                this.f27032j = -1;
                this.f27034r = false;
                this.cw.xt(this);
                this.cw = null;
                this.xt = null;
            }
        }

        public boolean ae() {
            return this.up;
        }

        public void cw(int i6) {
            this.f27032j = i6;
        }

        public int g() {
            return this.xt.ws.mi();
        }

        public boolean m() {
            return this.f27034r;
        }

        public int tl() {
            return this.f27032j;
        }

        protected void xt(View view) {
            if (j(view) == tl()) {
                this.f27033m = view;
            }
        }

        public g r() {
            return this.cw;
        }

        public View up(int i6) {
            return this.xt.ws.xt(i6);
        }

        void j(int i6, int i7) {
            PointF r5;
            RecyclerView recyclerView = this.xt;
            if (!this.up || this.f27032j == -1 || recyclerView == null) {
                up();
            }
            if (this.f27034r && this.f27033m == null && this.cw != null && (r5 = r(this.f27032j)) != null) {
                float f6 = r5.x;
                if (f6 != 0.0f || r5.y != 0.0f) {
                    recyclerView.j((int) Math.signum(f6), (int) Math.signum(r5.y), (int[]) null);
                }
            }
            this.f27034r = false;
            View view = this.f27033m;
            if (view != null) {
                if (j(view) == this.f27032j) {
                    j(this.f27033m, recyclerView.f26987p, this.ae);
                    this.ae.j(recyclerView);
                    up();
                } else {
                    com.bytedance.sdk.component.utils.vl.r("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.f27033m = null;
                }
            }
            if (this.up) {
                j(i6, i7, recyclerView.f26987p, this.ae);
                boolean j6 = this.ae.j();
                this.ae.j(recyclerView);
                if (j6) {
                    if (this.up) {
                        this.f27034r = true;
                        recyclerView.f26989s.j();
                    } else {
                        up();
                    }
                }
            }
        }

        public int j(View view) {
            return this.xt.tl(view);
        }

        protected void j(PointF pointF) {
            float f6 = pointF.x;
            float f7 = pointF.y;
            float sqrt = (float) Math.sqrt((f6 * f6) + (f7 * f7));
            pointF.x /= sqrt;
            pointF.y /= sqrt;
        }
    }

    public static class oq extends ViewGroup.MarginLayoutParams {
        boolean cw;

        /* renamed from: j, reason: collision with root package name */
        v f27038j;

        /* renamed from: r, reason: collision with root package name */
        boolean f27039r;
        final Rect xt;

        public oq(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.xt = new Rect();
            this.cw = true;
            this.f27039r = false;
        }

        public boolean cw() {
            return this.f27038j.s();
        }

        public boolean j() {
            return this.f27038j.ws();
        }

        public int r() {
            return this.f27038j.r();
        }

        public boolean xt() {
            return this.f27038j.i();
        }

        public oq(int i6, int i7) {
            super(i6, i7);
            this.xt = new Rect();
            this.cw = true;
            this.f27039r = false;
        }

        public oq(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.xt = new Rect();
            this.cw = true;
            this.f27039r = false;
        }

        public oq(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.xt = new Rect();
            this.cw = true;
            this.f27039r = false;
        }

        public oq(oq oqVar) {
            super((ViewGroup.MarginLayoutParams) oqVar);
            this.xt = new Rect();
            this.cw = true;
            this.f27039r = false;
        }
    }

    public interface qv {
        void j(View view);

        void xt(View view);
    }

    public interface r {
        int j(int i6, int i7);
    }

    public static abstract class tj {
        public abstract View j(av avVar, int i6, int i7);
    }

    public static abstract class tl {
        @Deprecated
        public void j(Rect rect, int i6, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void j(Rect rect, View view, RecyclerView recyclerView, kt ktVar) {
            j(rect, ((oq) view.getLayoutParams()).r(), recyclerView);
        }
    }

    public static class up {
        protected EdgeEffect j(RecyclerView recyclerView, int i6) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public static abstract class v {

        /* renamed from: i, reason: collision with root package name */
        private static final List<Object> f27040i = Collections.EMPTY_LIST;
        RecyclerView av;

        /* renamed from: j, reason: collision with root package name */
        public final View f27042j;
        int oq;
        WeakReference<RecyclerView> xt;
        int cw = -1;

        /* renamed from: r, reason: collision with root package name */
        int f27044r = -1;
        long up = -1;

        /* renamed from: m, reason: collision with root package name */
        int f27043m = -1;
        int ae = -1;
        v tl = null;

        /* renamed from: g, reason: collision with root package name */
        v f27041g = null;
        List<Object> qv = null;
        List<Object> vl = null;

        /* renamed from: w, reason: collision with root package name */
        private int f27045w = 0;
        av jy = null;
        boolean ws = false;
        private int mi = 0;
        int az = -1;

        void f() {
            this.oq = 0;
            this.cw = -1;
            this.f27044r = -1;
            this.up = -1L;
            this.ae = -1;
            this.f27045w = 0;
            this.tl = null;
            this.f27041g = null;
            kt();
            this.mi = 0;
            this.az = -1;
            RecyclerView.cw(this);
        }

        void j(int i6, int i7, boolean z5) {
            xt(8);
            j(i7, z5);
            this.cw = i6;
        }

        void xt() {
            if (this.f27044r == -1) {
                this.f27044r = this.cw;
            }
        }

        private void a() {
            if (this.qv == null) {
                ArrayList arrayList = new ArrayList();
                this.qv = arrayList;
                this.vl = Collections.unmodifiableList(arrayList);
            }
        }

        boolean L_() {
            return (this.oq & 128) != 0;
        }

        public final long ae() {
            return this.up;
        }

        boolean av() {
            return (this.oq & 1) != 0;
        }

        boolean az() {
            return (this.oq & 2) != 0;
        }

        boolean ch() {
            return (this.oq & 16) == 0 && com.bytedance.sdk.component.widget.recycler.j.cw.ae.m(this.f27042j);
        }

        boolean g() {
            return this.jy != null;
        }

        boolean i() {
            return (this.oq & 8) != 0;
        }

        void jy() {
            this.oq &= -257;
        }

        void kt() {
            List<Object> list = this.qv;
            if (list != null) {
                list.clear();
            }
            this.oq &= -1025;
        }

        public final int m() {
            return this.f27044r;
        }

        boolean mi() {
            return (this.oq & 512) != 0 || ws();
        }

        void oq() {
            this.jy.cw(this);
        }

        boolean qv() {
            return (this.oq & 32) != 0;
        }

        public final int r() {
            int i6 = this.ae;
            return i6 == -1 ? this.cw : i6;
        }

        boolean s() {
            return (this.oq & 2) != 0;
        }

        List<Object> tj() {
            if ((this.oq & 1024) != 0) {
                return f27040i;
            }
            List<Object> list = this.qv;
            return (list == null || list.size() == 0) ? f27040i : this.vl;
        }

        public final int tl() {
            return this.f27043m;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.cw + " id=" + this.up + ", oldPos=" + this.f27044r + ", pLpos:" + this.ae);
            if (g()) {
                sb.append(" scrap ");
                sb.append(this.ws ? "[changeScrap]" : "[attachedScrap]");
            }
            if (ws()) {
                sb.append(" invalid");
            }
            if (!av()) {
                sb.append(" unbound");
            }
            if (az()) {
                sb.append(" update");
            }
            if (i()) {
                sb.append(" removed");
            }
            if (L_()) {
                sb.append(" ignored");
            }
            if (w()) {
                sb.append(" tmpDetached");
            }
            if (!v()) {
                sb.append(" not recyclable(" + this.f27045w + ")");
            }
            if (mi()) {
                sb.append(" undefined adapter position");
            }
            if (this.f27042j.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        public final int up() {
            RecyclerView recyclerView = this.av;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.r(this);
        }

        public final boolean v() {
            return (this.oq & 16) == 0 && !com.bytedance.sdk.component.widget.recycler.j.cw.ae.m(this.f27042j);
        }

        void vl() {
            this.oq &= -33;
        }

        boolean w() {
            return (this.oq & 256) != 0;
        }

        boolean ws() {
            return (this.oq & 4) != 0;
        }

        boolean x() {
            return (this.oq & 16) != 0;
        }

        public v(View view) {
            if (view != null) {
                this.f27042j = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        void xt(int i6) {
            this.oq = i6 | this.oq;
        }

        void j(int i6, boolean z5) {
            if (this.f27044r == -1) {
                this.f27044r = this.cw;
            }
            if (this.ae == -1) {
                this.ae = this.cw;
            }
            if (z5) {
                this.ae += i6;
            }
            this.cw += i6;
            if (this.f27042j.getLayoutParams() != null) {
                ((oq) this.f27042j.getLayoutParams()).cw = true;
            }
        }

        void xt(RecyclerView recyclerView) {
            recyclerView.j(this, this.mi);
            this.mi = 0;
        }

        void j() {
            this.f27044r = -1;
            this.ae = -1;
        }

        void j(av avVar, boolean z5) {
            this.jy = avVar;
            this.ws = z5;
        }

        boolean j(int i6) {
            return (i6 & this.oq) != 0;
        }

        void j(int i6, int i7) {
            this.oq = (i6 & i7) | (this.oq & (~i7));
        }

        void j(Object obj) {
            if (obj == null) {
                xt(1024);
            } else if ((1024 & this.oq) == 0) {
                a();
                this.qv.add(obj);
            }
        }

        void j(RecyclerView recyclerView) {
            int i6 = this.az;
            if (i6 != -1) {
                this.mi = i6;
            } else {
                this.mi = com.bytedance.sdk.component.widget.recycler.j.cw.ae.xt(this.f27042j);
            }
            recyclerView.j(this, 4);
        }

        public final void j(boolean z5) {
            int i6 = this.f27045w;
            int i7 = z5 ? i6 - 1 : i6 + 1;
            this.f27045w = i7;
            if (i7 < 0) {
                this.f27045w = 0;
                com.bytedance.sdk.component.utils.vl.r("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                return;
            }
            if (!z5 && i7 == 1) {
                this.oq |= 16;
            } else if (z5 && i7 == 0) {
                this.oq &= -17;
            }
        }
    }

    public static abstract class vl {
        public abstract boolean j(int i6, int i7);
    }

    private class w extends cw {
        @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.cw
        public void j() {
            RecyclerView.this.j((String) null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f26987p.f27025m = true;
            recyclerView.cw(true);
            if (RecyclerView.this.f26986m.r()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }

        w() {
        }

        void xt() {
            if (RecyclerView.cw) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.f26993w && recyclerView.f26983i) {
                    com.bytedance.sdk.component.widget.recycler.j.cw.ae.j(recyclerView, recyclerView.oq);
                    return;
                }
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.f26980f = true;
            recyclerView2.requestLayout();
        }

        @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.cw
        public void j(int i6, int i7, Object obj) {
            RecyclerView.this.j((String) null);
            if (RecyclerView.this.f26986m.j(i6, i7, obj)) {
                xt();
            }
        }
    }

    public static abstract class ws {
        public void j(RecyclerView recyclerView, int i6) {
        }

        public void j(RecyclerView recyclerView, int i6, int i7) {
        }
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    private void la() {
        this.f26988q = 0;
    }

    private void up(v vVar) {
        View view = vVar.f27042j;
        boolean z5 = view.getParent() == this;
        this.up.cw(xt(view));
        if (vVar.w()) {
            this.ae.j(view, -1, view.getLayoutParams(), true);
        } else if (z5) {
            this.ae.r(view);
        } else {
            this.ae.j(view, true);
        }
    }

    void ae() {
        if (this.ff == null) {
            EdgeEffect j6 = this.f26984k.j(this, 0);
            this.ff = j6;
            if (this.f26981g) {
                j6.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                j6.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    void cw() {
        m mVar = this.ch;
        if (mVar != null) {
            mVar.r();
        }
        g gVar = this.ws;
        if (gVar != null) {
            gVar.cw(this.up);
            this.ws.xt(this.up);
        }
        this.up.j();
    }

    void g() {
        if (this.ry == null) {
            EdgeEffect j6 = this.f26984k.j(this, 1);
            this.ry = j6;
            if (this.f26981g) {
                j6.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                j6.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        g gVar = this.ws;
        if (gVar != null) {
            return gVar.j(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + j());
    }

    void jy() {
        xt(true);
    }

    public void m() {
        setScrollState(0);
        a();
    }

    void oq() {
        if (this.kc == null) {
            EdgeEffect j6 = this.f26984k.j(this, 3);
            this.kc = j6;
            if (this.f26981g) {
                j6.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                j6.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    void qv() {
        this.kc = null;
        this.ry = null;
        this.zz = null;
        this.ff = null;
    }

    void r() {
        if (this.mi && !this.f26992v) {
            if (!this.f26986m.r()) {
                return;
            }
            if (this.f26986m.j(4) && !this.f26986m.j(11)) {
                com.bytedance.sdk.component.widget.recycler.j.j.j.j("RV PartialInvalidate");
                up();
                vl();
                this.f26986m.xt();
                if (!this.kt) {
                    if (s()) {
                        av();
                    } else {
                        this.f26986m.cw();
                    }
                }
                j(true);
                jy();
                com.bytedance.sdk.component.widget.recycler.j.j.j.j();
                return;
            }
            if (!this.f26986m.r()) {
                return;
            }
        }
        com.bytedance.sdk.component.widget.recycler.j.j.j.j("RV FullInvalidate");
        av();
        com.bytedance.sdk.component.widget.recycler.j.j.j.j();
    }

    public void setAdapter(j jVar) {
        setLayoutFrozen(false);
        j(jVar, false, true);
        cw(false);
        requestLayout();
    }

    void tl() {
        if (this.zz == null) {
            EdgeEffect j6 = this.f26984k.j(this, 2);
            this.zz = j6;
            if (this.f26981g) {
                j6.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                j6.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    void vl() {
        this.sm++;
    }

    void xt() {
        this.f26986m = new com.bytedance.sdk.component.widget.recycler.j(new j.InterfaceC0421j() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.5
            @Override // com.bytedance.sdk.component.widget.recycler.j.InterfaceC0421j
            public v j(int i6) {
                v j6 = RecyclerView.this.j(i6, true);
                if (j6 == null || RecyclerView.this.ae.cw(j6.f27042j)) {
                    return null;
                }
                return j6;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.j.InterfaceC0421j
            public void cw(int i6, int i7) {
                RecyclerView.this.ae(i6, i7);
                RecyclerView.this.f26982h = true;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.j.InterfaceC0421j
            public void r(int i6, int i7) {
                RecyclerView.this.m(i6, i7);
                RecyclerView.this.f26982h = true;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.j.InterfaceC0421j
            public void xt(int i6, int i7) {
                RecyclerView.this.j(i6, i7, false);
                RecyclerView.this.f26982h = true;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.j.InterfaceC0421j
            public void j(int i6, int i7) {
                RecyclerView.this.j(i6, i7, true);
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.f26982h = true;
                recyclerView.f26987p.cw += i7;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.j.InterfaceC0421j
            public void j(int i6, int i7, Object obj) {
                RecyclerView.this.j(i6, i7, obj);
                RecyclerView.this.la = true;
            }
        });
    }

    static class xt extends Observable<cw> {
        public void j() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((cw) ((Observable) this).mObservers.get(size)).j();
            }
        }

        xt() {
        }

        public void j(int i6, int i7) {
            j(i6, i7, null);
        }

        public void j(int i6, int i7, Object obj) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((cw) ((Observable) this).mObservers.get(size)).j(i6, i7, obj);
            }
        }
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a() {
        this.f26989s.xt();
        g gVar = this.ws;
        if (gVar != null) {
            gVar.gq();
        }
    }

    private void c() {
        View findViewById;
        if (!this.ki || this.jy == null || !hasFocus() || getDescendantFocusability() == 393216) {
            return;
        }
        if (getDescendantFocusability() == 131072 && isFocused()) {
            return;
        }
        if (!isFocused()) {
            View focusedChild = getFocusedChild();
            if (!nd || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                if (!this.ae.cw(focusedChild)) {
                    return;
                }
            } else if (this.ae.xt() == 0) {
                requestFocus();
                return;
            }
        }
        View view = null;
        v j6 = (this.f26987p.jy == -1 || !this.jy.xt()) ? null : j(this.f26987p.jy);
        if (j6 != null && !this.ae.cw(j6.f27042j) && j6.f27042j.hasFocusable()) {
            view = j6.f27042j;
        } else if (this.ae.xt() > 0) {
            view = ed();
        }
        if (view != null) {
            int i6 = this.f26987p.ws;
            if (i6 != -1 && (findViewById = view.findViewById(i6)) != null && findViewById.isFocusable()) {
                view = findViewById;
            }
            view.requestFocus();
        }
    }

    private void ch() {
        this.ae = new com.bytedance.sdk.component.widget.recycler.xt(new xt.InterfaceC0422xt() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.4
            @Override // com.bytedance.sdk.component.widget.recycler.xt.InterfaceC0422xt
            public void cw(int i6) {
                v up2;
                View xt2 = xt(i6);
                if (xt2 != null && (up2 = RecyclerView.up(xt2)) != null) {
                    if (up2.w() && !up2.L_()) {
                        throw new IllegalArgumentException("called detach on an already detached child " + up2 + RecyclerView.this.j());
                    }
                    up2.xt(256);
                }
                RecyclerView.this.detachViewFromParent(i6);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.xt.InterfaceC0422xt
            public int j() {
                return RecyclerView.this.getChildCount();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.xt.InterfaceC0422xt
            public View xt(int i6) {
                return RecyclerView.this.getChildAt(i6);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.xt.InterfaceC0422xt
            public void j(View view, int i6) {
                RecyclerView.this.addView(view, i6);
                RecyclerView.this.vl(view);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.xt.InterfaceC0422xt
            public void xt() {
                int j6 = j();
                for (int i6 = 0; i6 < j6; i6++) {
                    View xt2 = xt(i6);
                    RecyclerView.this.qv(xt2);
                    xt2.clearAnimation();
                }
                RecyclerView.this.removeAllViews();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.xt.InterfaceC0422xt
            public void r(View view) {
                v up2 = RecyclerView.up(view);
                if (up2 != null) {
                    up2.xt(RecyclerView.this);
                }
            }

            @Override // com.bytedance.sdk.component.widget.recycler.xt.InterfaceC0422xt
            public int j(View view) {
                return RecyclerView.this.indexOfChild(view);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.xt.InterfaceC0422xt
            public void j(int i6) {
                View childAt = RecyclerView.this.getChildAt(i6);
                if (childAt != null) {
                    RecyclerView.this.qv(childAt);
                    childAt.clearAnimation();
                }
                RecyclerView.this.removeViewAt(i6);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.xt.InterfaceC0422xt
            public void cw(View view) {
                v up2 = RecyclerView.up(view);
                if (up2 != null) {
                    up2.j(RecyclerView.this);
                }
            }

            @Override // com.bytedance.sdk.component.widget.recycler.xt.InterfaceC0422xt
            public v xt(View view) {
                return RecyclerView.up(view);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.xt.InterfaceC0422xt
            public void j(View view, int i6, ViewGroup.LayoutParams layoutParams) {
                v up2 = RecyclerView.up(view);
                if (up2 != null) {
                    if (!up2.w() && !up2.L_()) {
                        throw new IllegalArgumentException("Called attach on a child which is not detached: " + up2 + RecyclerView.this.j());
                    }
                    up2.jy();
                }
                RecyclerView.this.attachViewToParent(view, i6, layoutParams);
            }
        });
    }

    private View ed() {
        v r5;
        kt ktVar = this.f26987p;
        int i6 = ktVar.vl;
        if (i6 == -1) {
            i6 = 0;
        }
        int r6 = ktVar.r();
        for (int i7 = i6; i7 < r6; i7++) {
            v r7 = r(i7);
            if (r7 == null) {
                break;
            }
            if (r7.f27042j.hasFocusable()) {
                return r7.f27042j;
            }
        }
        int min = Math.min(r6, i6);
        do {
            min--;
            if (min < 0 || (r5 = r(min)) == null) {
                return null;
            }
        } while (!r5.f27042j.hasFocusable());
        return r5.f27042j;
    }

    private com.bytedance.sdk.component.widget.recycler.j.cw.r getScrollingChildHelper() {
        if (this.wo == null) {
            this.wo = new com.bytedance.sdk.component.widget.recycler.j.cw.r(this);
        }
        return this.wo;
    }

    private boolean gq() {
        return this.ch != null && this.ws.vl();
    }

    private void gx() {
        this.f26987p.j(1);
        j(this.f26987p);
        this.f26987p.f27022g = false;
        up();
        this.tl.j();
        vl();
        rn();
        wq();
        kt ktVar = this.f26987p;
        ktVar.tl = ktVar.oq && this.la;
        this.la = false;
        this.f26982h = false;
        ktVar.ae = ktVar.qv;
        ktVar.up = this.jy.j();
        j(this.f26991u);
        if (this.f26987p.oq) {
            int xt2 = this.ae.xt();
            for (int i6 = 0; i6 < xt2; i6++) {
                v up2 = up(this.ae.xt(i6));
                if (!up2.L_() && (!up2.ws() || this.jy.xt())) {
                    this.tl.j(up2, this.ch.j(this.f26987p, up2, m.up(up2), up2.tj()));
                    if (this.f26987p.tl && up2.s() && !up2.i() && !up2.L_() && !up2.ws()) {
                        this.tl.j(j(up2), up2);
                    }
                }
            }
        }
        if (this.f26987p.qv) {
            w();
            kt ktVar2 = this.f26987p;
            boolean z5 = ktVar2.f27025m;
            ktVar2.f27025m = false;
            this.ws.j(this.up, ktVar2);
            this.f26987p.f27025m = z5;
            for (int i7 = 0; i7 < this.ae.xt(); i7++) {
                v up3 = up(this.ae.xt(i7));
                if (!up3.L_() && !this.tl.r(up3)) {
                    int up4 = m.up(up3);
                    boolean j6 = up3.j(8192);
                    if (!j6) {
                        up4 |= 4096;
                    }
                    m.xt j7 = this.ch.j(this.f26987p, up3, up4, up3.tj());
                    if (j6) {
                        j(up3, j7);
                    } else {
                        this.tl.xt(up3, j7);
                    }
                }
            }
            mi();
        } else {
            mi();
        }
        jy();
        j(false);
        this.f26987p.f27026r = 2;
    }

    private int jy(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    private void l() {
        boolean z5;
        EdgeEffect edgeEffect = this.ff;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z5 = this.ff.isFinished();
        } else {
            z5 = false;
        }
        EdgeEffect edgeEffect2 = this.ry;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z5 |= this.ry.isFinished();
        }
        EdgeEffect edgeEffect3 = this.zz;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z5 |= this.zz.isFinished();
        }
        EdgeEffect edgeEffect4 = this.kc;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z5 |= this.kc.isFinished();
        }
        if (z5) {
            com.bytedance.sdk.component.widget.recycler.j.cw.ae.cw(this);
        }
    }

    private void nd() {
        RecyclerView recyclerView;
        this.f26987p.j(4);
        up();
        vl();
        kt ktVar = this.f26987p;
        ktVar.f27026r = 1;
        if (ktVar.oq) {
            for (int xt2 = this.ae.xt() - 1; xt2 >= 0; xt2--) {
                v up2 = up(this.ae.xt(xt2));
                if (!up2.L_()) {
                    long j6 = j(up2);
                    m.xt j7 = this.ch.j(this.f26987p, up2);
                    v j8 = this.tl.j(j6);
                    if (j8 != null && !j8.L_()) {
                        boolean j9 = this.tl.j(j8);
                        boolean j10 = this.tl.j(up2);
                        if (!j9 || j8 != up2) {
                            m.xt xt3 = this.tl.xt(j8);
                            this.tl.cw(up2, j7);
                            m.xt cw2 = this.tl.cw(up2);
                            if (xt3 == null) {
                                j(j6, up2, j8);
                            } else {
                                j(j8, up2, xt3, cw2, j9, j10);
                            }
                        }
                    }
                    this.tl.cw(up2, j7);
                }
            }
            recyclerView = this;
            recyclerView.tl.j(recyclerView.yl);
        } else {
            recyclerView = this;
        }
        recyclerView.ws.xt(recyclerView.up);
        kt ktVar2 = recyclerView.f26987p;
        ktVar2.xt = ktVar2.up;
        recyclerView.f26992v = false;
        recyclerView.f26994x = false;
        ktVar2.oq = false;
        ktVar2.qv = false;
        recyclerView.ws.jy = false;
        ArrayList<v> arrayList = recyclerView.up.xt;
        if (arrayList != null) {
            arrayList.clear();
        }
        g gVar = recyclerView.ws;
        if (gVar.f27014i) {
            gVar.av = 0;
            gVar.f27014i = false;
            recyclerView.up.xt();
        }
        recyclerView.ws.xt(recyclerView.f26987p);
        jy();
        j(false);
        recyclerView.tl.j();
        int[] iArr = recyclerView.f26991u;
        if (oq(iArr[0], iArr[1])) {
            tl(0, 0);
        }
        c();
        uf();
    }

    private void p() {
        VelocityTracker velocityTracker = this.st;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        tl(0);
        l();
    }

    private void rn() {
        boolean z5;
        if (this.f26992v) {
            this.f26986m.j();
        }
        if (gq()) {
            this.f26986m.xt();
        } else {
            this.f26986m.up();
        }
        boolean z6 = this.f26982h || this.la;
        this.f26987p.oq = this.mi && this.ch != null && ((z5 = this.f26992v) || z6 || this.ws.jy) && (!z5 || this.jy.xt());
        kt ktVar = this.f26987p;
        ktVar.qv = ktVar.oq && z6 && !this.f26992v && gq();
    }

    private boolean s() {
        int xt2 = this.ae.xt();
        for (int i6 = 0; i6 < xt2; i6++) {
            v up2 = up(this.ae.xt(i6));
            if (up2 != null && !up2.L_() && up2.s()) {
                return true;
            }
        }
        return false;
    }

    private void uf() {
        kt ktVar = this.f26987p;
        ktVar.jy = -1L;
        ktVar.vl = -1;
        ktVar.ws = -1;
    }

    private void wq() {
        View focusedChild = (this.ki && hasFocus() && this.jy != null) ? getFocusedChild() : null;
        v r5 = focusedChild != null ? r(focusedChild) : null;
        if (r5 == null) {
            uf();
            return;
        }
        this.f26987p.jy = this.jy.xt() ? r5.ae() : -1L;
        this.f26987p.vl = this.f26992v ? -1 : r5.i() ? r5.f27044r : r5.up();
        this.f26987p.ws = jy(r5.f27042j);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i6, int i7) {
        g gVar = this.ws;
        if (gVar == null || !gVar.j(this, arrayList, i6, i7)) {
            super.addFocusables(arrayList, i6, i7);
        }
    }

    void av() {
        if (this.jy == null) {
            com.bytedance.sdk.component.utils.vl.r("RecyclerView", "No adapter attached; skipping layout");
            return;
        }
        if (this.ws == null) {
            com.bytedance.sdk.component.utils.vl.r("RecyclerView", "No layout manager attached; skipping layout");
            return;
        }
        kt ktVar = this.f26987p;
        ktVar.f27022g = false;
        if (ktVar.f27026r == 1) {
            gx();
        } else if (!this.f26986m.m() && this.ws.f() == getWidth() && this.ws.v() == getHeight()) {
            this.ws.r(this);
            nd();
        }
        this.ws.r(this);
        n();
        nd();
    }

    void az() {
        if (this.gq || !this.f26983i) {
            return;
        }
        com.bytedance.sdk.component.widget.recycler.j.cw.ae.j(this, this.oy);
        this.gq = true;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof oq) && this.ws.j((oq) layoutParams);
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        g gVar = this.ws;
        if (gVar != null && gVar.cw()) {
            return this.ws.up(this.f26987p);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        g gVar = this.ws;
        if (gVar != null && gVar.cw()) {
            return this.ws.cw(this.f26987p);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        g gVar = this.ws;
        if (gVar != null && gVar.cw()) {
            return this.ws.ae(this.f26987p);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        g gVar = this.ws;
        if (gVar != null && gVar.r()) {
            return this.ws.m(this.f26987p);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        g gVar = this.ws;
        if (gVar != null && gVar.r()) {
            return this.ws.r(this.f26987p);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        g gVar = this.ws;
        if (gVar != null && gVar.r()) {
            return this.ws.tl(this.f26987p);
        }
        return 0;
    }

    void f() {
        v vVar;
        int xt2 = this.ae.xt();
        for (int i6 = 0; i6 < xt2; i6++) {
            View xt3 = this.ae.xt(i6);
            v xt4 = xt(xt3);
            if (xt4 != null && (vVar = xt4.f27041g) != null) {
                View view = vVar.f27042j;
                int left = xt3.getLeft();
                int top2 = xt3.getTop();
                if (left != view.getLeft() || top2 != view.getTop()) {
                    view.layout(left, top2, view.getWidth() + left, view.getHeight() + top2);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i6) {
        View view2;
        boolean z5;
        View r5 = this.ws.r(view, i6);
        if (r5 != null) {
            return r5;
        }
        boolean z6 = (this.jy == null || this.ws == null || ws() || this.tj) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z6 && (i6 == 2 || i6 == 1)) {
            if (this.ws.r()) {
                int i7 = i6 == 2 ? MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE : 33;
                z5 = focusFinder.findNextFocus(this, view, i7) == null;
                if (f26975n) {
                    i6 = i7;
                }
            } else {
                z5 = false;
            }
            if (!z5 && this.ws.cw()) {
                int i8 = (this.ws.i() == 1) ^ (i6 == 2) ? 66 : 17;
                boolean z7 = focusFinder.findNextFocus(this, view, i8) == null;
                if (f26975n) {
                    i6 = i8;
                }
                z5 = z7;
            }
            if (z5) {
                r();
                if (cw(view) == null) {
                    return null;
                }
                up();
                this.ws.j(view, i6, this.up, this.f26987p);
                j(false);
            }
            view2 = focusFinder.findNextFocus(this, view, i6);
        } else {
            View findNextFocus = focusFinder.findNextFocus(this, view, i6);
            if (findNextFocus == null && z6) {
                r();
                if (cw(view) == null) {
                    return null;
                }
                up();
                view2 = this.ws.j(view, i6, this.up, this.f26987p);
                j(false);
            } else {
                view2 = findNextFocus;
            }
        }
        if (view2 == null || view2.hasFocusable()) {
            return j(view, view2, i6) ? view2 : super.focusSearch(view, i6);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i6);
        }
        j(view2, (View) null);
        return view;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        g gVar = this.ws;
        if (gVar != null) {
            return gVar.xt();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + j());
    }

    public j getAdapter() {
        return this.jy;
    }

    @Override // android.view.View
    public int getBaseline() {
        g gVar = this.ws;
        return gVar != null ? gVar.w() : super.getBaseline();
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i6, int i7) {
        r rVar = this.ka;
        return rVar == null ? super.getChildDrawingOrder(i6, i7) : rVar.j(i6, i7);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.f26981g;
    }

    public up getEdgeEffectFactory() {
        return this.f26984k;
    }

    public m getItemAnimator() {
        return this.ch;
    }

    public int getItemDecorationCount() {
        return this.av.size();
    }

    public g getLayoutManager() {
        return this.ws;
    }

    public int getMaxFlingVelocity() {
        return this.nt;
    }

    public int getMinFlingVelocity() {
        return this.f26995y;
    }

    long getNanoTime() {
        if (f26976r) {
            return System.nanoTime();
        }
        return 0L;
    }

    public vl getOnFlingListener() {
        return this.im;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.ki;
    }

    public az getRecycledViewPool() {
        return this.up.ae();
    }

    public int getScrollState() {
        return this.aq;
    }

    void i() {
        int cw2 = this.ae.cw();
        for (int i6 = 0; i6 < cw2; i6++) {
            ((oq) this.ae.r(i6).getLayoutParams()).cw = true;
        }
        this.up.oq();
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.f26983i;
    }

    void kt() {
        int cw2 = this.ae.cw();
        for (int i6 = 0; i6 < cw2; i6++) {
            v up2 = up(this.ae.r(i6));
            if (up2 != null && !up2.L_()) {
                up2.xt(6);
            }
        }
        i();
        this.up.tl();
    }

    void mi() {
        int cw2 = this.ae.cw();
        for (int i6 = 0; i6 < cw2; i6++) {
            v up2 = up(this.ae.r(i6));
            if (!up2.L_()) {
                up2.j();
            }
        }
        this.up.g();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0067  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onGenericMotionEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            com.bytedance.sdk.component.widget.recycler.RecyclerView$g r0 = r5.ws
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            boolean r0 = r5.tj
            if (r0 == 0) goto Lb
            return r1
        Lb:
            int r0 = r6.getAction()
            r2 = 8
            if (r0 != r2) goto L78
            int r0 = r6.getSource()
            r0 = r0 & 2
            r2 = 0
            if (r0 == 0) goto L3e
            com.bytedance.sdk.component.widget.recycler.RecyclerView$g r0 = r5.ws
            boolean r0 = r0.r()
            if (r0 == 0) goto L2c
            r0 = 9
            float r0 = r6.getAxisValue(r0)
            float r0 = -r0
            goto L2d
        L2c:
            r0 = 0
        L2d:
            com.bytedance.sdk.component.widget.recycler.RecyclerView$g r3 = r5.ws
            boolean r3 = r3.cw()
            if (r3 == 0) goto L3c
            r3 = 10
            float r3 = r6.getAxisValue(r3)
            goto L63
        L3c:
            r3 = 0
            goto L63
        L3e:
            int r0 = r6.getSource()
            r3 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r3
            if (r0 == 0) goto L61
            r0 = 26
            float r3 = r6.getAxisValue(r0)
            com.bytedance.sdk.component.widget.recycler.RecyclerView$g r0 = r5.ws
            boolean r0 = r0.r()
            if (r0 == 0) goto L57
            float r0 = -r3
            goto L3c
        L57:
            com.bytedance.sdk.component.widget.recycler.RecyclerView$g r0 = r5.ws
            boolean r0 = r0.cw()
            if (r0 == 0) goto L61
            r0 = 0
            goto L63
        L61:
            r0 = 0
            goto L3c
        L63:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L6b
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 == 0) goto L78
        L6b:
            float r2 = r5.uc
            float r3 = r3 * r2
            int r2 = (int) r3
            float r3 = r5.ri
            float r0 = r0 * r3
            int r0 = (int) r0
            r5.j(r2, r0, r6)
        L78:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z5;
        if (this.tj) {
            return false;
        }
        if (j(motionEvent)) {
            h();
            return true;
        }
        g gVar = this.ws;
        if (gVar == null) {
            return false;
        }
        boolean cw2 = gVar.cw();
        boolean r5 = this.ws.r();
        if (this.st == null) {
            this.st = VelocityTracker.obtain();
        }
        this.st.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.f26979e) {
                this.f26979e = false;
            }
            this.rr = motionEvent.getPointerId(0);
            int x5 = (int) (motionEvent.getX() + 0.5f);
            this.wf = x5;
            this.pz = x5;
            int y5 = (int) (motionEvent.getY() + 0.5f);
            this.ln = y5;
            this.qa = y5;
            if (this.aq == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
            }
            int[] iArr = this.ll;
            iArr[1] = 0;
            iArr[0] = 0;
            int i6 = cw2;
            if (r5) {
                i6 = (cw2 ? 1 : 0) | 2;
            }
            g(i6, 0);
        } else if (actionMasked == 1) {
            this.st.clear();
            tl(0);
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.rr);
            if (findPointerIndex < 0) {
                com.bytedance.sdk.component.utils.vl.r("RecyclerView", "Error processing scroll; pointer index for id " + this.rr + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x6 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y6 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            if (this.aq != 1) {
                int i7 = x6 - this.pz;
                int i8 = y6 - this.qa;
                if (cw2 == 0 || Math.abs(i7) <= this.xp) {
                    z5 = false;
                } else {
                    this.wf = x6;
                    z5 = true;
                }
                if (r5 && Math.abs(i8) > this.xp) {
                    this.ln = y6;
                    z5 = true;
                }
                if (z5) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            h();
        } else if (actionMasked == 5) {
            this.rr = motionEvent.getPointerId(actionIndex);
            int x7 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.wf = x7;
            this.pz = x7;
            int y7 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.ln = y7;
            this.qa = y7;
        } else if (actionMasked == 6) {
            cw(motionEvent);
        }
        return this.aq == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        com.bytedance.sdk.component.widget.recycler.j.j.j.j("RV OnLayout");
        av();
        com.bytedance.sdk.component.widget.recycler.j.j.j.j();
        this.mi = true;
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        g gVar = this.ws;
        if (gVar == null) {
            up(i6, i7);
            return;
        }
        if (gVar.j()) {
            int mode = View.MeasureSpec.getMode(i6);
            int mode2 = View.MeasureSpec.getMode(i7);
            this.ws.j(this.up, this.f26987p, i6, i7);
            if ((mode == 1073741824 && mode2 == 1073741824) || this.jy == null) {
                return;
            }
            if (this.f26987p.f27026r == 1) {
                gx();
            }
            this.ws.xt(i6, i7);
            this.f26987p.f27022g = true;
            n();
            this.ws.cw(i6, i7);
            if (this.ws.g()) {
                this.ws.xt(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                this.f26987p.f27022g = true;
                n();
                this.ws.cw(i6, i7);
                return;
            }
            return;
        }
        if (this.f26993w) {
            this.ws.j(this.up, this.f26987p, i6, i7);
            return;
        }
        if (this.f26980f) {
            up();
            vl();
            rn();
            jy();
            kt ktVar = this.f26987p;
            if (ktVar.qv) {
                ktVar.ae = true;
            } else {
                this.f26986m.up();
                this.f26987p.ae = false;
            }
            this.f26980f = false;
            j(false);
        } else if (this.f26987p.qv) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        j jVar = this.jy;
        if (jVar != null) {
            this.f26987p.up = jVar.j();
        } else {
            this.f26987p.up = 0;
        }
        up();
        this.ws.j(this.up, this.f26987p, i6, i7);
        j(false);
        this.f26987p.ae = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0115  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r14) {
        /*
            Method dump skipped, instructions count: 440
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    void qv(View view) {
        up(view);
        List<qv> list = this.ya;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.ya.get(size).xt(view);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.ws.j(this, this.f26987p, view, view2) && view2 != null) {
            j(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z5) {
        return this.ws.j(this, view, rect, z5);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z5) {
        int size = this.f26996z.size();
        for (int i6 = 0; i6 < size; i6++) {
            this.f26996z.get(i6);
        }
        super.requestDisallowInterceptTouchEvent(z5);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f26978b != 0 || this.tj) {
            this.kt = true;
        } else {
            super.requestLayout();
        }
    }

    @Override // android.view.View
    public void scrollBy(int i6, int i7) {
        g gVar = this.ws;
        if (gVar == null) {
            com.bytedance.sdk.component.utils.vl.r("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.tj) {
            return;
        }
        boolean cw2 = gVar.cw();
        boolean r5 = this.ws.r();
        if (cw2 || r5) {
            if (!cw2) {
                i6 = 0;
            }
            if (!r5) {
                i7 = 0;
            }
            j(i6, i7, (MotionEvent) null);
        }
    }

    public void setChildDrawingOrderCallback(r rVar) {
        if (rVar != this.ka) {
            this.ka = rVar;
            setChildrenDrawingOrderEnabled(rVar != null);
        }
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z5) {
        if (z5 != this.f26981g) {
            qv();
        }
        this.f26981g = z5;
        super.setClipToPadding(z5);
        if (this.mi) {
            requestLayout();
        }
    }

    public void setHasFixedSize(boolean z5) {
        this.f26993w = z5;
    }

    public void setItemAnimator(m mVar) {
        m mVar2 = this.ch;
        if (mVar2 != null) {
            mVar2.r();
            this.ch.j(null);
        }
        this.ch = mVar;
        if (mVar != null) {
            mVar.j(this.ik);
        }
    }

    public void setItemViewCacheSize(int i6) {
        this.up.j(i6);
    }

    public void setLayoutFrozen(boolean z5) {
        if (z5 != this.tj) {
            j("Do not setLayoutFrozen in layout or scroll");
            if (z5) {
                long uptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                this.tj = true;
                this.f26979e = true;
                m();
                return;
            }
            this.tj = false;
            if (this.kt && this.ws != null && this.jy != null) {
                requestLayout();
            }
            this.kt = false;
        }
    }

    public void setLayoutManager(g gVar) {
        if (gVar != this.ws) {
            m();
            if (this.ws != null) {
                m mVar = this.ch;
                if (mVar != null) {
                    mVar.r();
                }
                this.ws.cw(this.up);
                this.ws.xt(this.up);
                this.up.j();
                if (this.f26983i) {
                    this.ws.xt(this, this.up);
                }
                this.ws.j((RecyclerView) null);
                this.ws = null;
            } else {
                this.up.j();
            }
            this.ae.j();
            this.ws = gVar;
            if (gVar != null) {
                if (gVar.f27013g != null) {
                    throw new IllegalArgumentException("LayoutManager " + gVar + " is already attached to a RecyclerView:" + gVar.f27013g.j());
                }
                gVar.j(this);
                if (this.f26983i) {
                    this.ws.xt(this);
                }
            }
            this.up.xt();
            requestLayout();
        }
    }

    public void setOnFlingListener(vl vlVar) {
        this.im = vlVar;
    }

    public void setPreserveFocusAfterLayout(boolean z5) {
        this.ki = z5;
    }

    public void setRecycledViewPool(az azVar) {
        this.up.j(azVar);
    }

    public void setRecyclerListener(i iVar) {
        this.az = iVar;
    }

    void setScrollState(int i6) {
        if (i6 != this.aq) {
            this.aq = i6;
            if (i6 != 2) {
                a();
            }
            ae(i6);
        }
    }

    public void setViewCacheExtension(tj tjVar) {
        this.up.j(tjVar);
    }

    public boolean tj() {
        return !this.mi || this.f26992v || this.f26986m.r();
    }

    void v() {
        int i6;
        for (int size = this.uf.size() - 1; size >= 0; size--) {
            v vVar = this.uf.get(size);
            if (vVar.f27042j.getParent() == this && !vVar.L_() && (i6 = vVar.az) != -1) {
                com.bytedance.sdk.component.widget.recycler.j.cw.ae.j(vVar.f27042j, i6);
                vVar.az = -1;
            }
        }
        this.uf.clear();
    }

    void vl(View view) {
        up(view);
        List<qv> list = this.ya;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.ya.get(size).j(view);
            }
        }
    }

    void w() {
        int cw2 = this.ae.cw();
        for (int i6 = 0; i6 < cw2; i6++) {
            v up2 = up(this.ae.r(i6));
            if (!up2.L_()) {
                up2.xt();
            }
        }
    }

    public boolean ws() {
        return this.sm > 0;
    }

    public void xt(ws wsVar) {
        List<ws> list = this.uq;
        if (list != null) {
            list.remove(wsVar);
        }
    }

    static {
        boolean z5;
        int i6 = Build.VERSION.SDK_INT;
        f26974j = false;
        if (i6 >= 23) {
            z5 = true;
        } else {
            z5 = false;
        }
        xt = z5;
        cw = true;
        f26976r = true;
        f26975n = false;
        nd = false;
        Class<?> cls = Integer.TYPE;
        rh = new Class[]{Context.class, AttributeSet.class, cls, cls};
        ed = new Interpolator() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.6
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f6) {
                float f7 = f6 - 1.0f;
                return (f7 * f7 * f7 * f7 * f7) + 1.0f;
            }
        };
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.ol = new w();
        this.up = new av();
        this.tl = new com.bytedance.sdk.component.widget.recycler.ws();
        this.oq = new Runnable() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.1
            @Override // java.lang.Runnable
            public void run() {
                RecyclerView recyclerView = RecyclerView.this;
                if (!recyclerView.mi || recyclerView.isLayoutRequested()) {
                    return;
                }
                RecyclerView recyclerView2 = RecyclerView.this;
                if (!recyclerView2.f26983i) {
                    recyclerView2.requestLayout();
                } else if (recyclerView2.tj) {
                    recyclerView2.kt = true;
                } else {
                    recyclerView2.r();
                }
            }
        };
        this.qv = new Rect();
        this.hh = new Rect();
        this.vl = new RectF();
        this.av = new ArrayList<>();
        this.f26996z = new ArrayList<>();
        this.f26978b = 0;
        this.f26992v = false;
        this.f26994x = false;
        this.sm = 0;
        this.xq = 0;
        this.f26984k = new up();
        this.ch = new com.bytedance.sdk.component.widget.recycler.cw();
        this.aq = 0;
        this.rr = -1;
        this.uc = Float.MIN_VALUE;
        this.ri = Float.MIN_VALUE;
        this.ki = true;
        this.f26989s = new f();
        this.f26985l = f26976r ? new r.j() : null;
        this.f26987p = new kt();
        this.f26982h = false;
        this.la = false;
        this.ik = new ae();
        this.gq = false;
        this.f26991u = new int[2];
        this.qo = new int[2];
        this.rn = new int[2];
        this.ll = new int[2];
        this.wq = new int[2];
        this.uf = new ArrayList();
        this.oy = new Runnable() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.2
            @Override // java.lang.Runnable
            public void run() {
                m mVar = RecyclerView.this.ch;
                if (mVar != null) {
                    mVar.j();
                }
                RecyclerView.this.gq = false;
            }
        };
        this.yl = new ws.xt() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.3
            @Override // com.bytedance.sdk.component.widget.recycler.ws.xt
            public void cw(v vVar, m.xt xtVar, m.xt xtVar2) {
                vVar.j(false);
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.f26992v) {
                    if (recyclerView.ch.j(vVar, vVar, xtVar, xtVar2)) {
                        RecyclerView.this.az();
                    }
                } else if (recyclerView.ch.cw(vVar, xtVar, xtVar2)) {
                    RecyclerView.this.az();
                }
            }

            @Override // com.bytedance.sdk.component.widget.recycler.ws.xt
            public void j(v vVar, m.xt xtVar, m.xt xtVar2) {
                RecyclerView.this.up.cw(vVar);
                RecyclerView.this.xt(vVar, xtVar, xtVar2);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.ws.xt
            public void xt(v vVar, m.xt xtVar, m.xt xtVar2) {
                RecyclerView.this.j(vVar, xtVar, xtVar2);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.ws.xt
            public void j(v vVar) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.ws.j(vVar.f27042j, recyclerView.up);
            }
        };
        if (attributeSet != null) {
            try {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, gx, i6, 0);
                this.f26981g = obtainStyledAttributes.getBoolean(0, true);
                obtainStyledAttributes.recycle();
            } catch (Exception e6) {
                com.bytedance.sdk.component.utils.vl.j(e6);
            }
        } else {
            this.f26981g = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.xp = viewConfiguration.getScaledTouchSlop();
        this.uc = com.bytedance.sdk.component.widget.recycler.j.cw.ae.j(viewConfiguration, context);
        this.ri = com.bytedance.sdk.component.widget.recycler.j.cw.ae.xt(viewConfiguration, context);
        this.f26995y = viewConfiguration.getScaledMinimumFlingVelocity();
        this.nt = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.ch.j(this.ik);
        xt();
        ch();
        x();
        if (com.bytedance.sdk.component.widget.recycler.j.cw.ae.xt(this) == 0) {
            com.bytedance.sdk.component.widget.recycler.j.cw.ae.j(this, 1);
        }
        this.qb = (AccessibilityManager) getContext().getSystemService("accessibility");
        try {
            if (attributeSet != null) {
                setDescendantFocusability(262144);
            } else {
                setDescendantFocusability(262144);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
        }
        setNestedScrollingEnabled(true);
    }

    private void h() {
        p();
        setScrollState(0);
    }

    private void n() {
        boolean z5;
        up();
        vl();
        this.f26987p.j(6);
        this.f26986m.up();
        this.f26987p.up = this.jy.j();
        kt ktVar = this.f26987p;
        ktVar.cw = 0;
        ktVar.ae = false;
        this.ws.j(this.up, ktVar);
        kt ktVar2 = this.f26987p;
        ktVar2.f27025m = false;
        if (ktVar2.oq && this.ch != null) {
            z5 = true;
        } else {
            z5 = false;
        }
        ktVar2.oq = z5;
        ktVar2.f27026r = 4;
        jy();
        j(false);
    }

    @SuppressLint({"InlinedApi"})
    private void x() {
        if (com.bytedance.sdk.component.widget.recycler.j.cw.ae.g(this) == 0) {
            com.bytedance.sdk.component.widget.recycler.j.cw.ae.xt(this, 8);
        }
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f6, float f7, boolean z5) {
        return getScrollingChildHelper().j(f6, f7, z5);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f6, float f7) {
        return getScrollingChildHelper().j(f6, f7);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i6, int i7, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().j(i6, i7, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i6, int i7, int i8, int i9, int[] iArr) {
        return getScrollingChildHelper().j(i6, i7, i8, i9, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z5;
        int i6;
        boolean z6;
        boolean z7;
        int i7;
        super.draw(canvas);
        int size = this.av.size();
        boolean z8 = false;
        for (int i8 = 0; i8 < size; i8++) {
            this.av.get(i8);
        }
        EdgeEffect edgeEffect = this.ff;
        boolean z9 = true;
        if (edgeEffect != null && !edgeEffect.isFinished()) {
            int save = canvas.save();
            if (this.f26981g) {
                i7 = getPaddingBottom();
            } else {
                i7 = 0;
            }
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + i7, 0.0f);
            EdgeEffect edgeEffect2 = this.ff;
            if (edgeEffect2 != null && edgeEffect2.draw(canvas)) {
                z5 = true;
            } else {
                z5 = false;
            }
            canvas.restoreToCount(save);
        } else {
            z5 = false;
        }
        EdgeEffect edgeEffect3 = this.ry;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.f26981g) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.ry;
            if (edgeEffect4 != null && edgeEffect4.draw(canvas)) {
                z7 = true;
            } else {
                z7 = false;
            }
            z5 |= z7;
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.zz;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            if (this.f26981g) {
                i6 = getPaddingTop();
            } else {
                i6 = 0;
            }
            canvas.rotate(90.0f);
            canvas.translate(-i6, -width);
            EdgeEffect edgeEffect6 = this.zz;
            if (edgeEffect6 != null && edgeEffect6.draw(canvas)) {
                z6 = true;
            } else {
                z6 = false;
            }
            z5 |= z6;
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.kc;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.f26981g) {
                canvas.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.kc;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z8 = true;
            }
            z5 |= z8;
            canvas.restoreToCount(save4);
        }
        if (z5 || this.ch == null || this.av.size() <= 0 || !this.ch.xt()) {
            z9 = z5;
        }
        if (z9) {
            com.bytedance.sdk.component.widget.recycler.j.cw.ae.cw(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j6) {
        return super.drawChild(canvas, view, j6);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().xt();
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().j();
    }

    void m(int i6, int i7) {
        int i8;
        int i9;
        int i10;
        int i11;
        int cw2 = this.ae.cw();
        if (i6 < i7) {
            i10 = -1;
            i9 = i6;
            i8 = i7;
        } else {
            i8 = i6;
            i9 = i7;
            i10 = 1;
        }
        for (int i12 = 0; i12 < cw2; i12++) {
            v up2 = up(this.ae.r(i12));
            if (up2 != null && (i11 = up2.cw) >= i9 && i11 <= i8) {
                if (i11 == i6) {
                    up2.j(i7 - i6, false);
                } else {
                    up2.j(i10, false);
                }
                this.f26987p.f27025m = true;
            }
        }
        this.up.j(i6, i7);
        requestLayout();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x004b, code lost:
    
        if (r1 >= 30.0f) goto L22;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onAttachedToWindow() {
        /*
            r5 = this;
            super.onAttachedToWindow()
            r0 = 0
            r5.sm = r0
            r1 = 1
            r5.f26983i = r1
            boolean r2 = r5.mi
            if (r2 == 0) goto L14
            boolean r2 = r5.isLayoutRequested()
            if (r2 != 0) goto L14
            goto L15
        L14:
            r1 = 0
        L15:
            r5.mi = r1
            com.bytedance.sdk.component.widget.recycler.RecyclerView$g r1 = r5.ws
            if (r1 == 0) goto L1e
            r1.xt(r5)
        L1e:
            r5.gq = r0
            boolean r0 = com.bytedance.sdk.component.widget.recycler.RecyclerView.f26976r
            if (r0 == 0) goto L61
            java.lang.ThreadLocal<com.bytedance.sdk.component.widget.recycler.r> r0 = com.bytedance.sdk.component.widget.recycler.r.f27094j
            java.lang.Object r1 = r0.get()
            com.bytedance.sdk.component.widget.recycler.r r1 = (com.bytedance.sdk.component.widget.recycler.r) r1
            r5.f26977a = r1
            if (r1 != 0) goto L5c
            com.bytedance.sdk.component.widget.recycler.r r1 = new com.bytedance.sdk.component.widget.recycler.r
            r1.<init>()
            r5.f26977a = r1
            android.view.Display r1 = com.bytedance.sdk.component.widget.recycler.j.cw.ae.ae(r5)
            boolean r2 = r5.isInEditMode()
            if (r2 != 0) goto L4e
            if (r1 == 0) goto L4e
            float r1 = r1.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 < 0) goto L4e
            goto L50
        L4e:
            r1 = 1114636288(0x42700000, float:60.0)
        L50:
            com.bytedance.sdk.component.widget.recycler.r r2 = r5.f26977a
            r3 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r3 = r3 / r1
            long r3 = (long) r3
            r2.f27096r = r3
            r0.set(r2)
        L5c:
            com.bytedance.sdk.component.widget.recycler.r r0 = r5.f26977a
            r0.j(r5)
        L61:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.RecyclerView.onAttachedToWindow():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        com.bytedance.sdk.component.widget.recycler.r rVar;
        super.onDetachedFromWindow();
        m mVar = this.ch;
        if (mVar != null) {
            mVar.r();
        }
        m();
        this.f26983i = false;
        g gVar = this.ws;
        if (gVar != null) {
            gVar.xt(this, this.up);
        }
        this.uf.clear();
        removeCallbacks(this.oy);
        this.tl.xt();
        if (f26976r && (rVar = this.f26977a) != null) {
            rVar.xt(this);
            this.f26977a = null;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.av.size();
        for (int i6 = 0; i6 < size; i6++) {
            this.av.get(i6);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i6, Rect rect) {
        if (ws()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i6, rect);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        if (i6 == i8 && i7 == i9) {
            return;
        }
        qv();
    }

    @Override // android.view.ViewGroup
    protected void removeDetachedView(View view, boolean z5) {
        v up2 = up(view);
        if (up2 != null) {
            if (up2.w()) {
                up2.jy();
            } else if (!up2.L_()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + up2 + j());
            }
        }
        view.clearAnimation();
        qv(view);
        super.removeDetachedView(view, z5);
    }

    public void setEdgeEffectFactory(up upVar) {
        j(upVar);
        this.f26984k = upVar;
        qv();
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z5) {
        getScrollingChildHelper().j(z5);
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i6) {
        return getScrollingChildHelper().xt(i6);
    }

    @Override // android.view.View, com.bytedance.sdk.component.widget.recycler.j.cw.xt
    public void stopNestedScroll() {
        getScrollingChildHelper().cw();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        g gVar = this.ws;
        if (gVar != null) {
            return gVar.j(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + j());
    }

    public void xt(int i6) {
        if (this.tj) {
            return;
        }
        g gVar = this.ws;
        if (gVar == null) {
            com.bytedance.sdk.component.utils.vl.r("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            gVar.j(this, this.f26987p, i6);
        }
    }

    String j() {
        return " " + super.toString() + ", adapter:" + this.jy + ", layout:" + this.ws + ", context:" + getContext();
    }

    private void j(j jVar, boolean z5, boolean z6) {
        j jVar2 = this.jy;
        if (jVar2 != null) {
            jVar2.xt(this.ol);
        }
        if (!z5 || z6) {
            cw();
        }
        this.f26986m.j();
        j jVar3 = this.jy;
        this.jy = jVar;
        if (jVar != null) {
            jVar.j(this.ol);
        }
        this.up.j(jVar3, this.jy, z5);
        this.f26987p.f27025m = true;
    }

    private boolean oq(int i6, int i7) {
        j(this.f26991u);
        int[] iArr = this.f26991u;
        return (iArr[0] == i6 && iArr[1] == i7) ? false : true;
    }

    void ae(int i6, int i7) {
        int cw2 = this.ae.cw();
        for (int i8 = 0; i8 < cw2; i8++) {
            v up2 = up(this.ae.r(i8));
            if (up2 != null && !up2.L_() && up2.cw >= i6) {
                up2.j(i7, false);
                this.f26987p.f27025m = true;
            }
        }
        this.up.xt(i6, i7);
        requestLayout();
    }

    Rect g(View view) {
        oq oqVar = (oq) view.getLayoutParams();
        if (!oqVar.cw) {
            return oqVar.xt;
        }
        if (this.f26987p.j() && (oqVar.cw() || oqVar.j())) {
            return oqVar.xt;
        }
        Rect rect = oqVar.xt;
        rect.set(0, 0, 0, 0);
        int size = this.av.size();
        for (int i6 = 0; i6 < size; i6++) {
            this.qv.set(0, 0, 0, 0);
            this.av.get(i6).j(this.qv, view, this, this.f26987p);
            int i7 = rect.left;
            Rect rect2 = this.qv;
            rect.left = i7 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        oqVar.cw = false;
        return rect;
    }

    public int tl(View view) {
        v up2 = up(view);
        if (up2 != null) {
            return up2.r();
        }
        return -1;
    }

    void cw(int i6, int i7) {
        boolean z5;
        EdgeEffect edgeEffect = this.ff;
        if (edgeEffect == null || edgeEffect.isFinished() || i6 <= 0) {
            z5 = false;
        } else {
            this.ff.onRelease();
            z5 = this.ff.isFinished();
        }
        EdgeEffect edgeEffect2 = this.zz;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i6 < 0) {
            this.zz.onRelease();
            z5 |= this.zz.isFinished();
        }
        EdgeEffect edgeEffect3 = this.ry;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i7 > 0) {
            this.ry.onRelease();
            z5 |= this.ry.isFinished();
        }
        EdgeEffect edgeEffect4 = this.kc;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i7 < 0) {
            this.kc.onRelease();
            z5 |= this.kc.isFinished();
        }
        if (z5) {
            com.bytedance.sdk.component.widget.recycler.j.cw.ae.cw(this);
        }
    }

    static RecyclerView oq(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            RecyclerView oq2 = oq(viewGroup.getChildAt(i6));
            if (oq2 != null) {
                return oq2;
            }
        }
        return null;
    }

    void tl(int i6, int i7) {
        this.xq++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        ws wsVar = this.f26990t;
        if (wsVar != null) {
            wsVar.j(this, i6, i7);
        }
        List<ws> list = this.uq;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.uq.get(size).j(this, i6, i7);
            }
        }
        this.xq--;
    }

    void up() {
        int i6 = this.f26978b + 1;
        this.f26978b = i6;
        if (i6 != 1 || this.tj) {
            return;
        }
        this.kt = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v6 */
    public boolean xt(int i6, int i7) {
        g gVar = this.ws;
        if (gVar == null) {
            com.bytedance.sdk.component.utils.vl.r("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (this.tj) {
            return false;
        }
        int cw2 = gVar.cw();
        boolean r5 = this.ws.r();
        if (cw2 == 0 || Math.abs(i6) < this.f26995y) {
            i6 = 0;
        }
        if (!r5 || Math.abs(i7) < this.f26995y) {
            i7 = 0;
        }
        if (i6 == 0 && i7 == 0) {
            return false;
        }
        float f6 = i6;
        float f7 = i7;
        if (!dispatchNestedPreFling(f6, f7)) {
            boolean z5 = cw2 != 0 || r5;
            dispatchNestedFling(f6, f7, z5);
            vl vlVar = this.im;
            if (vlVar != null && vlVar.j(i6, i7)) {
                return true;
            }
            if (z5) {
                if (r5) {
                    cw2 = (cw2 == true ? 1 : 0) | 2;
                }
                g(cw2, 1);
                int i8 = this.nt;
                int max = Math.max(-i8, Math.min(i6, i8));
                int i9 = this.nt;
                this.f26989s.j(max, Math.max(-i9, Math.min(i7, i9)));
                return true;
            }
        }
        return false;
    }

    @Deprecated
    public int m(View view) {
        return ae(view);
    }

    void up(int i6, int i7) {
        setMeasuredDimension(g.j(i6, getPaddingLeft() + getPaddingRight(), com.bytedance.sdk.component.widget.recycler.j.cw.ae.r(this)), g.j(i7, getPaddingTop() + getPaddingBottom(), com.bytedance.sdk.component.widget.recycler.j.cw.ae.up(this)));
    }

    public void m(int i6) {
        int xt2 = this.ae.xt();
        for (int i7 = 0; i7 < xt2; i7++) {
            this.ae.xt(i7).offsetLeftAndRight(i6);
        }
    }

    public int ae(View view) {
        v up2 = up(view);
        if (up2 != null) {
            return up2.up();
        }
        return -1;
    }

    static v up(View view) {
        if (view == null) {
            return null;
        }
        return ((oq) view.getLayoutParams()).f27038j;
    }

    void ae(int i6) {
        g gVar = this.ws;
        if (gVar != null) {
            gVar.qv(i6);
        }
        ws wsVar = this.f26990t;
        if (wsVar != null) {
            wsVar.j(this, i6);
        }
        List<ws> list = this.uq;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.uq.get(size).j(this, i6);
            }
        }
    }

    public void j(qv qvVar) {
        if (this.ya == null) {
            this.ya = new ArrayList();
        }
        this.ya.add(qvVar);
    }

    public void up(int i6) {
        int xt2 = this.ae.xt();
        for (int i7 = 0; i7 < xt2; i7++) {
            this.ae.xt(i7).offsetTopAndBottom(i6);
        }
    }

    boolean j(View view) {
        up();
        boolean m6 = this.ae.m(view);
        if (m6) {
            v up2 = up(view);
            this.up.cw(up2);
            this.up.xt(up2);
        }
        j(!m6);
        return m6;
    }

    public void tl(int i6) {
        getScrollingChildHelper().cw(i6);
    }

    void r(int i6, int i7) {
        if (i6 < 0) {
            ae();
            this.ff.onAbsorb(-i6);
        } else if (i6 > 0) {
            tl();
            this.zz.onAbsorb(i6);
        }
        if (i7 < 0) {
            g();
            this.ry.onAbsorb(-i7);
        } else if (i7 > 0) {
            oq();
            this.kc.onAbsorb(i7);
        }
        if (i6 == 0 && i7 == 0) {
            return;
        }
        com.bytedance.sdk.component.widget.recycler.j.cw.ae.cw(this);
    }

    private void cw(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.rr) {
            int i6 = actionIndex == 0 ? 1 : 0;
            this.rr = motionEvent.getPointerId(i6);
            int x5 = (int) (motionEvent.getX(i6) + 0.5f);
            this.wf = x5;
            this.pz = x5;
            int y5 = (int) (motionEvent.getY(i6) + 0.5f);
            this.ln = y5;
            this.qa = y5;
        }
    }

    public boolean g(int i6, int i7) {
        return getScrollingChildHelper().j(i6, i7);
    }

    private boolean xt(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.hl != null) {
            if (action != 0) {
                if (action == 3 || action == 1) {
                    this.hl = null;
                }
                return true;
            }
            this.hl = null;
        }
        if (action != 0) {
            int size = this.f26996z.size();
            for (int i6 = 0; i6 < size; i6++) {
                jy jyVar = this.f26996z.get(i6);
                if (jyVar.j(this, motionEvent)) {
                    this.hl = jyVar;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean g(int i6) {
        return getScrollingChildHelper().j(i6);
    }

    public void j(tl tlVar, int i6) {
        g gVar = this.ws;
        if (gVar != null) {
            gVar.j("Cannot add item decoration during a scroll  or layout");
        }
        if (this.av.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i6 < 0) {
            this.av.add(tlVar);
        } else {
            this.av.add(i6, tlVar);
        }
        i();
        requestLayout();
    }

    void cw(boolean z5) {
        this.f26994x = z5 | this.f26994x;
        this.f26992v = true;
        kt();
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0012, code lost:
    
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View cw(android.view.View r3) {
        /*
            r2 = this;
        L0:
            android.view.ViewParent r0 = r3.getParent()
            if (r0 == 0) goto L10
            if (r0 == r2) goto L10
            boolean r1 = r0 instanceof android.view.View
            if (r1 == 0) goto L10
            r3 = r0
            android.view.View r3 = (android.view.View) r3
            goto L0
        L10:
            if (r0 != r2) goto L13
            return r3
        L13:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.RecyclerView.cw(android.view.View):android.view.View");
    }

    public v r(View view) {
        View cw2 = cw(view);
        if (cw2 == null) {
            return null;
        }
        return xt(cw2);
    }

    public v cw(int i6) {
        return j(i6, false);
    }

    public v r(int i6) {
        v vVar = null;
        if (this.f26992v) {
            return null;
        }
        int cw2 = this.ae.cw();
        for (int i7 = 0; i7 < cw2; i7++) {
            v up2 = up(this.ae.r(i7));
            if (up2 != null && !up2.i() && r(up2) == i6) {
                if (!this.ae.cw(up2.f27042j)) {
                    return up2;
                }
                vVar = up2;
            }
        }
        return vVar;
    }

    void xt(boolean z5) {
        int i6 = this.sm - 1;
        this.sm = i6;
        if (i6 <= 0) {
            this.sm = 0;
            if (z5) {
                la();
                v();
            }
        }
    }

    static void cw(v vVar) {
        WeakReference<RecyclerView> weakReference = vVar.xt;
        if (weakReference != null) {
            RecyclerView recyclerView = weakReference.get();
            while (recyclerView != null) {
                if (recyclerView == vVar.f27042j) {
                    return;
                }
                Object parent = recyclerView.getParent();
                recyclerView = parent instanceof View ? (View) parent : null;
            }
            vVar.xt = null;
        }
    }

    public void j(tl tlVar) {
        j(tlVar, -1);
    }

    public void j(ws wsVar) {
        if (this.uq == null) {
            this.uq = new ArrayList();
        }
        this.uq.add(wsVar);
    }

    void xt(v vVar, m.xt xtVar, m.xt xtVar2) {
        up(vVar);
        vVar.j(false);
        if (this.ch.j(vVar, xtVar, xtVar2)) {
            az();
        }
    }

    int r(v vVar) {
        if (vVar.j(524) || !vVar.av()) {
            return -1;
        }
        return this.f26986m.cw(vVar.cw);
    }

    void j(int i6) {
        g gVar = this.ws;
        if (gVar != null) {
            gVar.r(i6);
            awakenScrollBars();
        }
    }

    boolean xt(v vVar) {
        m mVar = this.ch;
        return mVar == null || mVar.j(vVar, vVar.tj());
    }

    void j(int i6, int i7, int[] iArr) {
        up();
        vl();
        com.bytedance.sdk.component.widget.recycler.j.j.j.j("RV Scroll");
        j(this.f26987p);
        int j6 = i6 != 0 ? this.ws.j(i6, this.up, this.f26987p) : 0;
        int xt2 = i7 != 0 ? this.ws.xt(i7, this.up, this.f26987p) : 0;
        com.bytedance.sdk.component.widget.recycler.j.j.j.j();
        f();
        jy();
        j(false);
        if (iArr != null) {
            iArr[0] = j6;
            iArr[1] = xt2;
        }
    }

    public v xt(View view) {
        ViewParent parent = view.getParent();
        if (parent != null && parent != this) {
            throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
        }
        return up(view);
    }

    boolean j(int i6, int i7, MotionEvent motionEvent) {
        int i8;
        int i9;
        int i10;
        int i11;
        r();
        if (this.jy != null) {
            j(i6, i7, this.wq);
            int[] iArr = this.wq;
            int i12 = iArr[0];
            int i13 = iArr[1];
            i10 = i6 - i12;
            i11 = i7 - i13;
            i9 = i13;
            i8 = i12;
        } else {
            i8 = 0;
            i9 = 0;
            i10 = 0;
            i11 = 0;
        }
        if (!this.av.isEmpty()) {
            invalidate();
        }
        if (j(i8, i9, i10, i11, this.qo, 0)) {
            int i14 = this.wf;
            int[] iArr2 = this.qo;
            int i15 = iArr2[0];
            this.wf = i14 - i15;
            int i16 = this.ln;
            int i17 = iArr2[1];
            this.ln = i16 - i17;
            if (motionEvent != null) {
                motionEvent.offsetLocation(i15, i17);
            }
            int[] iArr3 = this.ll;
            int i18 = iArr3[0];
            int[] iArr4 = this.qo;
            iArr3[0] = i18 + iArr4[0];
            iArr3[1] = iArr3[1] + iArr4[1];
        } else if (getOverScrollMode() != 2) {
            if (motionEvent != null && !com.bytedance.sdk.component.widget.recycler.j.cw.ae.j(motionEvent, 8194)) {
                j(motionEvent.getX(), i10, motionEvent.getY(), i11);
            }
            cw(i6, i7);
        }
        if (i8 != 0 || i9 != 0) {
            tl(i8, i9);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (i8 == 0 && i9 == 0) ? false : true;
    }

    void j(boolean z5) {
        if (this.f26978b <= 0) {
            this.f26978b = 1;
        }
        if (!z5 && !this.tj) {
            this.kt = false;
        }
        if (this.f26978b == 1) {
            if (z5 && this.kt && !this.tj && this.ws != null && this.jy != null) {
                av();
            }
            if (!this.tj) {
                this.kt = false;
            }
        }
        this.f26978b--;
    }

    public void j(int i6, int i7) {
        j(i6, i7, (Interpolator) null);
    }

    public void j(int i6, int i7, Interpolator interpolator) {
        g gVar = this.ws;
        if (gVar == null) {
            com.bytedance.sdk.component.utils.vl.r("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.tj) {
            return;
        }
        if (!gVar.cw()) {
            i6 = 0;
        }
        if (!this.ws.r()) {
            i7 = 0;
        }
        if (i6 == 0 && i7 == 0) {
            return;
        }
        this.f26989s.j(i6, i7, interpolator);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void j(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 1065353216(0x3f800000, float:1.0)
            r1 = 1
            r2 = 0
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 >= 0) goto L21
            r6.ae()
            android.widget.EdgeEffect r3 = r6.ff
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r0 - r9
            com.bytedance.sdk.component.widget.recycler.j.cw.j.j(r3, r4, r9)
        L1f:
            r9 = 1
            goto L3c
        L21:
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 <= 0) goto L3b
            r6.tl()
            android.widget.EdgeEffect r3 = r6.zz
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            com.bytedance.sdk.component.widget.recycler.j.cw.j.j(r3, r4, r9)
            goto L1f
        L3b:
            r9 = 0
        L3c:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 >= 0) goto L56
            r6.g()
            android.widget.EdgeEffect r9 = r6.ry
            float r0 = -r10
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r0 = r0 / r3
            int r3 = r6.getWidth()
            float r3 = (float) r3
            float r7 = r7 / r3
            com.bytedance.sdk.component.widget.recycler.j.cw.j.j(r9, r0, r7)
            goto L72
        L56:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 <= 0) goto L71
            r6.oq()
            android.widget.EdgeEffect r9 = r6.kc
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r3 = r10 / r3
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r0 = r0 - r7
            com.bytedance.sdk.component.widget.recycler.j.cw.j.j(r9, r3, r0)
            goto L72
        L71:
            r1 = r9
        L72:
            if (r1 != 0) goto L7e
            int r7 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r7 != 0) goto L7e
            int r7 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r7 == 0) goto L7d
            goto L7e
        L7d:
            return
        L7e:
            com.bytedance.sdk.component.widget.recycler.j.cw.ae.cw(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.RecyclerView.j(float, float, float, float):void");
    }

    public static <T> T j(T t5) {
        t5.getClass();
        return t5;
    }

    private boolean j(View view, View view2, int i6) {
        int i7;
        if (view2 == null || view2 == this || cw(view2) == null) {
            return false;
        }
        if (view == null || cw(view) == null) {
            return true;
        }
        this.qv.set(0, 0, view.getWidth(), view.getHeight());
        this.hh.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.qv);
        offsetDescendantRectToMyCoords(view2, this.hh);
        char c6 = 65535;
        int i8 = this.ws.i() == 1 ? -1 : 1;
        Rect rect = this.qv;
        int i9 = rect.left;
        Rect rect2 = this.hh;
        int i10 = rect2.left;
        if ((i9 < i10 || rect.right <= i10) && rect.right < rect2.right) {
            i7 = 1;
        } else {
            int i11 = rect.right;
            int i12 = rect2.right;
            i7 = ((i11 > i12 || i9 >= i12) && i9 > i10) ? -1 : 0;
        }
        int i13 = rect.top;
        int i14 = rect2.top;
        if ((i13 < i14 || rect.bottom <= i14) && rect.bottom < rect2.bottom) {
            c6 = 1;
        } else {
            int i15 = rect.bottom;
            int i16 = rect2.bottom;
            if ((i15 <= i16 && i13 < i16) || i13 <= i14) {
                c6 = 0;
            }
        }
        if (i6 == 1) {
            return c6 < 0 || (c6 == 0 && i7 * i8 <= 0);
        }
        if (i6 == 2) {
            return c6 > 0 || (c6 == 0 && i7 * i8 >= 0);
        }
        if (i6 == 17) {
            return i7 < 0;
        }
        if (i6 == 33) {
            return c6 < 0;
        }
        if (i6 == 66) {
            return i7 > 0;
        }
        if (i6 == 130) {
            return c6 > 0;
        }
        throw new IllegalArgumentException("Invalid direction: " + i6 + j());
    }

    private void j(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.qv.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof oq) {
            oq oqVar = (oq) layoutParams;
            if (!oqVar.cw) {
                Rect rect = oqVar.xt;
                Rect rect2 = this.qv;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.qv);
            offsetRectIntoDescendantCoords(view, this.qv);
        }
        this.ws.j(this, view, this.qv, !this.mi, view2 == null);
    }

    void j(String str) {
        if (ws()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + j());
            }
            throw new IllegalStateException(str);
        }
        if (this.xq > 0) {
            com.bytedance.sdk.component.utils.vl.xt("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(j()));
        }
    }

    private boolean j(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.hl = null;
        }
        int size = this.f26996z.size();
        for (int i6 = 0; i6 < size; i6++) {
            jy jyVar = this.f26996z.get(i6);
            if (jyVar.j(this, motionEvent) && action != 3) {
                this.hl = jyVar;
                return true;
            }
        }
        return false;
    }

    final void j(kt ktVar) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.f26989s.f27010j;
            ktVar.az = overScroller.getFinalX() - overScroller.getCurrX();
            ktVar.av = overScroller.getFinalY() - overScroller.getCurrY();
        } else {
            ktVar.az = 0;
            ktVar.av = 0;
        }
    }

    private void j(long j6, v vVar, v vVar2) {
        int xt2 = this.ae.xt();
        for (int i6 = 0; i6 < xt2; i6++) {
            v up2 = up(this.ae.xt(i6));
            if (up2 != vVar && j(up2) == j6) {
                j jVar = this.jy;
                if (jVar != null && jVar.xt()) {
                    throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + up2 + " \n View Holder 2:" + vVar + j());
                }
                throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + up2 + " \n View Holder 2:" + vVar + j());
            }
        }
        com.bytedance.sdk.component.utils.vl.r("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + vVar2 + " cannot be found but it is necessary for " + vVar + j());
    }

    void j(v vVar, m.xt xtVar) {
        vVar.j(0, 8192);
        if (this.f26987p.tl && vVar.s() && !vVar.i() && !vVar.L_()) {
            this.tl.j(j(vVar), vVar);
        }
        this.tl.j(vVar, xtVar);
    }

    private void j(int[] iArr) {
        int xt2 = this.ae.xt();
        if (xt2 == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i6 = Integer.MAX_VALUE;
        int i7 = Integer.MIN_VALUE;
        for (int i8 = 0; i8 < xt2; i8++) {
            v up2 = up(this.ae.xt(i8));
            if (!up2.L_()) {
                int r5 = up2.r();
                if (r5 < i6) {
                    i6 = r5;
                }
                if (r5 > i7) {
                    i7 = r5;
                }
            }
        }
        iArr[0] = i6;
        iArr[1] = i7;
    }

    long j(v vVar) {
        return this.jy.xt() ? vVar.ae() : vVar.cw;
    }

    void j(v vVar, m.xt xtVar, m.xt xtVar2) {
        vVar.j(false);
        if (this.ch.xt(vVar, xtVar, xtVar2)) {
            az();
        }
    }

    private void j(v vVar, v vVar2, m.xt xtVar, m.xt xtVar2, boolean z5, boolean z6) {
        vVar.j(false);
        if (z5) {
            up(vVar);
        }
        if (vVar != vVar2) {
            if (z6) {
                up(vVar2);
            }
            vVar.tl = vVar2;
            up(vVar);
            this.up.cw(vVar);
            vVar2.j(false);
            vVar2.f27041g = vVar;
        }
        if (this.ch.j(vVar, vVar2, xtVar, xtVar2)) {
            az();
        }
    }

    void j(int i6, int i7, boolean z5) {
        int i8 = i6 + i7;
        int cw2 = this.ae.cw();
        for (int i9 = 0; i9 < cw2; i9++) {
            v up2 = up(this.ae.r(i9));
            if (up2 != null && !up2.L_()) {
                int i10 = up2.cw;
                if (i10 >= i8) {
                    up2.j(-i7, z5);
                    this.f26987p.f27025m = true;
                } else if (i10 >= i6) {
                    up2.j(i6 - 1, -i7, z5);
                    this.f26987p.f27025m = true;
                }
            }
        }
        this.up.j(i6, i7, z5);
        requestLayout();
    }

    void j(int i6, int i7, Object obj) {
        int i8;
        int cw2 = this.ae.cw();
        int i9 = i6 + i7;
        for (int i10 = 0; i10 < cw2; i10++) {
            View r5 = this.ae.r(i10);
            v up2 = up(r5);
            if (up2 != null && !up2.L_() && (i8 = up2.cw) >= i6 && i8 < i9) {
                up2.xt(2);
                up2.j(obj);
                ((oq) r5.getLayoutParams()).cw = true;
            }
        }
        this.up.cw(i6, i7);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0033 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    com.bytedance.sdk.component.widget.recycler.RecyclerView.v j(int r6, boolean r7) {
        /*
            r5 = this;
            com.bytedance.sdk.component.widget.recycler.xt r0 = r5.ae
            int r0 = r0.cw()
            r1 = 0
            r2 = 0
        L8:
            if (r2 >= r0) goto L38
            com.bytedance.sdk.component.widget.recycler.xt r3 = r5.ae
            android.view.View r3 = r3.r(r2)
            com.bytedance.sdk.component.widget.recycler.RecyclerView$v r3 = up(r3)
            if (r3 == 0) goto L35
            boolean r4 = r3.i()
            if (r4 != 0) goto L35
            if (r7 == 0) goto L23
            int r4 = r3.cw
            if (r4 == r6) goto L29
            goto L35
        L23:
            int r4 = r3.r()
            if (r4 != r6) goto L35
        L29:
            com.bytedance.sdk.component.widget.recycler.xt r1 = r5.ae
            android.view.View r4 = r3.f27042j
            boolean r1 = r1.cw(r4)
            if (r1 != 0) goto L34
            return r3
        L34:
            r1 = r3
        L35:
            int r2 = r2 + 1
            goto L8
        L38:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.RecyclerView.j(int, boolean):com.bytedance.sdk.component.widget.recycler.RecyclerView$v");
    }

    public v j(long j6) {
        j jVar = this.jy;
        v vVar = null;
        if (jVar != null && jVar.xt()) {
            int cw2 = this.ae.cw();
            for (int i6 = 0; i6 < cw2; i6++) {
                v up2 = up(this.ae.r(i6));
                if (up2 != null && !up2.i() && up2.ae() == j6) {
                    if (!this.ae.cw(up2.f27042j)) {
                        return up2;
                    }
                    vVar = up2;
                }
            }
        }
        return vVar;
    }

    static void j(View view, Rect rect) {
        oq oqVar = (oq) view.getLayoutParams();
        Rect rect2 = oqVar.xt;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) oqVar).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) oqVar).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) oqVar).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) oqVar).bottomMargin);
    }

    boolean j(v vVar, int i6) {
        if (ws()) {
            vVar.az = i6;
            this.uf.add(vVar);
            return false;
        }
        com.bytedance.sdk.component.widget.recycler.j.cw.ae.j(vVar.f27042j, i6);
        return true;
    }

    public boolean j(int i6, int i7, int i8, int i9, int[] iArr, int i10) {
        return getScrollingChildHelper().j(i6, i7, i8, i9, iArr, i10);
    }

    public boolean j(int i6, int i7, int[] iArr, int[] iArr2, int i8) {
        return getScrollingChildHelper().j(i6, i7, iArr, iArr2, i8);
    }
}
