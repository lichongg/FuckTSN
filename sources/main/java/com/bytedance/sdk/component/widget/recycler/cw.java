package com.bytedance.sdk.component.widget.recycler;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw extends qv {

    /* renamed from: g, reason: collision with root package name */
    private static TimeInterpolator f27048g;
    private ArrayList<RecyclerView.v> oq = new ArrayList<>();
    private ArrayList<RecyclerView.v> qv = new ArrayList<>();
    private ArrayList<xt> vl = new ArrayList<>();
    private ArrayList<j> jy = new ArrayList<>();

    /* renamed from: j, reason: collision with root package name */
    ArrayList<ArrayList<RecyclerView.v>> f27049j = new ArrayList<>();
    ArrayList<ArrayList<xt>> xt = new ArrayList<>();
    ArrayList<ArrayList<j>> cw = new ArrayList<>();

    /* renamed from: r, reason: collision with root package name */
    ArrayList<RecyclerView.v> f27051r = new ArrayList<>();
    ArrayList<RecyclerView.v> up = new ArrayList<>();

    /* renamed from: m, reason: collision with root package name */
    ArrayList<RecyclerView.v> f27050m = new ArrayList<>();
    ArrayList<RecyclerView.v> ae = new ArrayList<>();

    private static class j {
        public int cw;

        /* renamed from: j, reason: collision with root package name */
        public RecyclerView.v f27066j;

        /* renamed from: m, reason: collision with root package name */
        public int f27067m;

        /* renamed from: r, reason: collision with root package name */
        public int f27068r;
        public int up;
        public RecyclerView.v xt;

        private j(RecyclerView.v vVar, RecyclerView.v vVar2) {
            this.f27066j = vVar;
            this.xt = vVar2;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f27066j + ", newHolder=" + this.xt + ", fromX=" + this.cw + ", fromY=" + this.f27068r + ", toX=" + this.up + ", toY=" + this.f27067m + '}';
        }

        j(RecyclerView.v vVar, RecyclerView.v vVar2, int i6, int i7, int i8, int i9) {
            this(vVar, vVar2);
            this.cw = i6;
            this.f27068r = i7;
            this.up = i8;
            this.f27067m = i9;
        }
    }

    void cw(final RecyclerView.v vVar) {
        final View view = vVar.f27042j;
        final ViewPropertyAnimator animate = view.animate();
        this.f27051r.add(vVar);
        animate.alpha(1.0f).setDuration(m()).setListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.widget.recycler.cw.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                view.setAlpha(1.0f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                animate.setListener(null);
                cw.this.oq(vVar);
                cw.this.f27051r.remove(vVar);
                cw.this.cw();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }).start();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.m
    public void j() {
        boolean isEmpty = this.oq.isEmpty();
        boolean isEmpty2 = this.vl.isEmpty();
        boolean isEmpty3 = this.jy.isEmpty();
        boolean isEmpty4 = this.qv.isEmpty();
        if (isEmpty && isEmpty2 && isEmpty4 && isEmpty3) {
            return;
        }
        Iterator<RecyclerView.v> it = this.oq.iterator();
        while (it.hasNext()) {
            qv(it.next());
        }
        this.oq.clear();
        if (!isEmpty2) {
            final ArrayList<xt> arrayList = new ArrayList<>();
            arrayList.addAll(this.vl);
            this.xt.add(arrayList);
            this.vl.clear();
            Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.component.widget.recycler.cw.1
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        xt xtVar = (xt) it2.next();
                        cw.this.xt(xtVar.f27069j, xtVar.xt, xtVar.cw, xtVar.f27070r, xtVar.up);
                    }
                    arrayList.clear();
                    cw.this.xt.remove(arrayList);
                }
            };
            if (isEmpty) {
                runnable.run();
            } else {
                com.bytedance.sdk.component.widget.recycler.j.cw.ae.j(arrayList.get(0).f27069j.f27042j, runnable, ae());
            }
        }
        if (!isEmpty3) {
            final ArrayList<j> arrayList2 = new ArrayList<>();
            arrayList2.addAll(this.jy);
            this.cw.add(arrayList2);
            this.jy.clear();
            Runnable runnable2 = new Runnable() { // from class: com.bytedance.sdk.component.widget.recycler.cw.2
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        cw.this.j((j) it2.next());
                    }
                    arrayList2.clear();
                    cw.this.cw.remove(arrayList2);
                }
            };
            if (isEmpty) {
                runnable2.run();
            } else {
                com.bytedance.sdk.component.widget.recycler.j.cw.ae.j(arrayList2.get(0).f27066j.f27042j, runnable2, ae());
            }
        }
        if (isEmpty4) {
            return;
        }
        final ArrayList<RecyclerView.v> arrayList3 = new ArrayList<>();
        arrayList3.addAll(this.qv);
        this.f27049j.add(arrayList3);
        this.qv.clear();
        Runnable runnable3 = new Runnable() { // from class: com.bytedance.sdk.component.widget.recycler.cw.3
            @Override // java.lang.Runnable
            public void run() {
                Iterator it2 = arrayList3.iterator();
                while (it2.hasNext()) {
                    cw.this.cw((RecyclerView.v) it2.next());
                }
                arrayList3.clear();
                cw.this.f27049j.remove(arrayList3);
            }
        };
        if (isEmpty && isEmpty2 && isEmpty3) {
            runnable3.run();
        } else {
            com.bytedance.sdk.component.widget.recycler.j.cw.ae.j(arrayList3.get(0).f27042j, runnable3, (!isEmpty ? ae() : 0L) + Math.max(!isEmpty2 ? up() : 0L, isEmpty3 ? 0L : tl()));
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.m
    public void r(RecyclerView.v vVar) {
        View view = vVar.f27042j;
        view.animate().cancel();
        int size = this.vl.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (this.vl.get(size).f27069j == vVar) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                g(vVar);
                this.vl.remove(size);
            }
        }
        j(this.jy, vVar);
        if (this.oq.remove(vVar)) {
            view.setAlpha(1.0f);
            tl(vVar);
        }
        if (this.qv.remove(vVar)) {
            view.setAlpha(1.0f);
            oq(vVar);
        }
        for (int size2 = this.cw.size() - 1; size2 >= 0; size2--) {
            ArrayList<j> arrayList = this.cw.get(size2);
            j(arrayList, vVar);
            if (arrayList.isEmpty()) {
                this.cw.remove(size2);
            }
        }
        for (int size3 = this.xt.size() - 1; size3 >= 0; size3--) {
            ArrayList<xt> arrayList2 = this.xt.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (arrayList2.get(size4).f27069j == vVar) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    g(vVar);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.xt.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.f27049j.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.v> arrayList3 = this.f27049j.get(size5);
            if (arrayList3.remove(vVar)) {
                view.setAlpha(1.0f);
                oq(vVar);
                if (arrayList3.isEmpty()) {
                    this.f27049j.remove(size5);
                }
            }
        }
        this.f27050m.remove(vVar);
        this.f27051r.remove(vVar);
        this.ae.remove(vVar);
        this.up.remove(vVar);
        cw();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.qv
    public boolean xt(RecyclerView.v vVar) {
        vl(vVar);
        vVar.f27042j.setAlpha(0.0f);
        this.qv.add(vVar);
        return true;
    }

    private static class xt {
        public int cw;

        /* renamed from: j, reason: collision with root package name */
        public RecyclerView.v f27069j;

        /* renamed from: r, reason: collision with root package name */
        public int f27070r;
        public int up;
        public int xt;

        xt(RecyclerView.v vVar, int i6, int i7, int i8, int i9) {
            this.f27069j = vVar;
            this.xt = i6;
            this.cw = i7;
            this.f27070r = i8;
            this.up = i9;
        }
    }

    private void qv(final RecyclerView.v vVar) {
        final View view = vVar.f27042j;
        final ViewPropertyAnimator animate = view.animate();
        this.f27050m.add(vVar);
        animate.setDuration(ae()).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.widget.recycler.cw.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                animate.setListener(null);
                view.setAlpha(1.0f);
                cw.this.tl(vVar);
                cw.this.f27050m.remove(vVar);
                cw.this.cw();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }).start();
    }

    private void vl(RecyclerView.v vVar) {
        if (f27048g == null) {
            f27048g = new ValueAnimator().getInterpolator();
        }
        vVar.f27042j.animate().setInterpolator(f27048g);
        r(vVar);
    }

    void xt(final RecyclerView.v vVar, int i6, int i7, int i8, int i9) {
        final View view = vVar.f27042j;
        final int i10 = i8 - i6;
        final int i11 = i9 - i7;
        if (i10 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i11 != 0) {
            view.animate().translationY(0.0f);
        }
        final ViewPropertyAnimator animate = view.animate();
        this.up.add(vVar);
        animate.setDuration(up()).setListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.widget.recycler.cw.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (i10 != 0) {
                    view.setTranslationX(0.0f);
                }
                if (i11 != 0) {
                    view.setTranslationY(0.0f);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                animate.setListener(null);
                cw.this.g(vVar);
                cw.this.up.remove(vVar);
                cw.this.cw();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }).start();
    }

    void cw() {
        if (xt()) {
            return;
        }
        g();
    }

    private void xt(j jVar) {
        RecyclerView.v vVar = jVar.f27066j;
        if (vVar != null) {
            j(jVar, vVar);
        }
        RecyclerView.v vVar2 = jVar.xt;
        if (vVar2 != null) {
            j(jVar, vVar2);
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.m
    public boolean xt() {
        return (this.qv.isEmpty() && this.jy.isEmpty() && this.vl.isEmpty() && this.oq.isEmpty() && this.up.isEmpty() && this.f27050m.isEmpty() && this.f27051r.isEmpty() && this.ae.isEmpty() && this.xt.isEmpty() && this.f27049j.isEmpty() && this.cw.isEmpty()) ? false : true;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.qv
    public boolean j(RecyclerView.v vVar) {
        vl(vVar);
        this.oq.add(vVar);
        return true;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.qv
    public boolean j(RecyclerView.v vVar, int i6, int i7, int i8, int i9) {
        View view = vVar.f27042j;
        int translationX = i6 + ((int) view.getTranslationX());
        int translationY = i7 + ((int) vVar.f27042j.getTranslationY());
        vl(vVar);
        int i10 = i8 - translationX;
        int i11 = i9 - translationY;
        if (i10 == 0 && i11 == 0) {
            g(vVar);
            return false;
        }
        if (i10 != 0) {
            view.setTranslationX(-i10);
        }
        if (i11 != 0) {
            view.setTranslationY(-i11);
        }
        this.vl.add(new xt(vVar, translationX, translationY, i8, i9));
        return true;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.m
    public void r() {
        int size = this.vl.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            xt xtVar = this.vl.get(size);
            View view = xtVar.f27069j.f27042j;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            g(xtVar.f27069j);
            this.vl.remove(size);
        }
        for (int size2 = this.oq.size() - 1; size2 >= 0; size2--) {
            tl(this.oq.get(size2));
            this.oq.remove(size2);
        }
        int size3 = this.qv.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.v vVar = this.qv.get(size3);
            vVar.f27042j.setAlpha(1.0f);
            oq(vVar);
            this.qv.remove(size3);
        }
        for (int size4 = this.jy.size() - 1; size4 >= 0; size4--) {
            xt(this.jy.get(size4));
        }
        this.jy.clear();
        if (xt()) {
            for (int size5 = this.xt.size() - 1; size5 >= 0; size5--) {
                ArrayList<xt> arrayList = this.xt.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    xt xtVar2 = arrayList.get(size6);
                    View view2 = xtVar2.f27069j.f27042j;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    g(xtVar2.f27069j);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.xt.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.f27049j.size() - 1; size7 >= 0; size7--) {
                ArrayList<RecyclerView.v> arrayList2 = this.f27049j.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.v vVar2 = arrayList2.get(size8);
                    vVar2.f27042j.setAlpha(1.0f);
                    oq(vVar2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.f27049j.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.cw.size() - 1; size9 >= 0; size9--) {
                ArrayList<j> arrayList3 = this.cw.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    xt(arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.cw.remove(arrayList3);
                    }
                }
            }
            j(this.f27050m);
            j(this.up);
            j(this.f27051r);
            j(this.ae);
            g();
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.qv
    public boolean j(RecyclerView.v vVar, RecyclerView.v vVar2, int i6, int i7, int i8, int i9) {
        if (vVar == vVar2) {
            return j(vVar, i6, i7, i8, i9);
        }
        float translationX = vVar.f27042j.getTranslationX();
        float translationY = vVar.f27042j.getTranslationY();
        float alpha = vVar.f27042j.getAlpha();
        vl(vVar);
        int i10 = (int) ((i8 - i6) - translationX);
        int i11 = (int) ((i9 - i7) - translationY);
        vVar.f27042j.setTranslationX(translationX);
        vVar.f27042j.setTranslationY(translationY);
        vVar.f27042j.setAlpha(alpha);
        if (vVar2 != null) {
            vl(vVar2);
            vVar2.f27042j.setTranslationX(-i10);
            vVar2.f27042j.setTranslationY(-i11);
            vVar2.f27042j.setAlpha(0.0f);
        }
        this.jy.add(new j(vVar, vVar2, i6, i7, i8, i9));
        return true;
    }

    void j(final j jVar) {
        RecyclerView.v vVar = jVar.f27066j;
        final View view = vVar == null ? null : vVar.f27042j;
        RecyclerView.v vVar2 = jVar.xt;
        final View view2 = vVar2 != null ? vVar2.f27042j : null;
        if (view != null) {
            final ViewPropertyAnimator duration = view.animate().setDuration(tl());
            this.ae.add(jVar.f27066j);
            duration.translationX(jVar.up - jVar.cw);
            duration.translationY(jVar.f27067m - jVar.f27068r);
            duration.alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.widget.recycler.cw.7
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    duration.setListener(null);
                    view.setAlpha(1.0f);
                    view.setTranslationX(0.0f);
                    view.setTranslationY(0.0f);
                    cw.this.j(jVar.f27066j, true);
                    cw.this.ae.remove(jVar.f27066j);
                    cw.this.cw();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            }).start();
        }
        if (view2 != null) {
            final ViewPropertyAnimator animate = view2.animate();
            this.ae.add(jVar.xt);
            animate.translationX(0.0f).translationY(0.0f).setDuration(tl()).alpha(1.0f).setListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.widget.recycler.cw.8
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    animate.setListener(null);
                    view2.setAlpha(1.0f);
                    view2.setTranslationX(0.0f);
                    view2.setTranslationY(0.0f);
                    cw.this.j(jVar.xt, false);
                    cw.this.ae.remove(jVar.xt);
                    cw.this.cw();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            }).start();
        }
    }

    private void j(List<j> list, RecyclerView.v vVar) {
        for (int size = list.size() - 1; size >= 0; size--) {
            j jVar = list.get(size);
            if (j(jVar, vVar) && jVar.f27066j == null && jVar.xt == null) {
                list.remove(jVar);
            }
        }
    }

    private boolean j(j jVar, RecyclerView.v vVar) {
        boolean z5 = false;
        if (jVar.xt == vVar) {
            jVar.xt = null;
        } else {
            if (jVar.f27066j != vVar) {
                return false;
            }
            jVar.f27066j = null;
            z5 = true;
        }
        vVar.f27042j.setAlpha(1.0f);
        vVar.f27042j.setTranslationX(0.0f);
        vVar.f27042j.setTranslationY(0.0f);
        j(vVar, z5);
        return true;
    }

    void j(List<RecyclerView.v> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).f27042j.animate().cancel();
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.m
    public boolean j(RecyclerView.v vVar, List<Object> list) {
        return !list.isEmpty() || super.j(vVar, list);
    }
}
