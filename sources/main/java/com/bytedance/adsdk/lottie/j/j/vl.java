package com.bytedance.adsdk.lottie.j.j;

import android.annotation.TargetApi;
import android.graphics.Path;
import com.bytedance.adsdk.lottie.model.xt.g;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@TargetApi(19)
/* loaded from: D:\Downloads\app\classes3.dex */
public class vl implements jy, oq {

    /* renamed from: m, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.model.xt.g f23282m;

    /* renamed from: r, reason: collision with root package name */
    private final String f23283r;

    /* renamed from: j, reason: collision with root package name */
    private final Path f23281j = new Path();
    private final Path xt = new Path();
    private final Path cw = new Path();
    private final List<jy> up = new ArrayList();

    @Override // com.bytedance.adsdk.lottie.j.j.oq
    public void j(ListIterator<cw> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            cw previous = listIterator.previous();
            if (previous instanceof jy) {
                this.up.add((jy) previous);
                listIterator.remove();
            }
        }
    }

    /* renamed from: com.bytedance.adsdk.lottie.j.j.vl$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: j, reason: collision with root package name */
        static final /* synthetic */ int[] f23284j;

        static {
            int[] iArr = new int[g.j.values().length];
            f23284j = iArr;
            try {
                iArr[g.j.MERGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23284j[g.j.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f23284j[g.j.SUBTRACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f23284j[g.j.INTERSECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f23284j[g.j.EXCLUDE_INTERSECTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    @Override // com.bytedance.adsdk.lottie.j.j.jy
    public Path r() {
        this.cw.reset();
        if (this.f23282m.cw()) {
            return this.cw;
        }
        int i6 = AnonymousClass1.f23284j[this.f23282m.xt().ordinal()];
        if (i6 == 1) {
            j();
        } else if (i6 == 2) {
            j(Path.Op.UNION);
        } else if (i6 == 3) {
            j(Path.Op.REVERSE_DIFFERENCE);
        } else if (i6 == 4) {
            j(Path.Op.INTERSECT);
        } else if (i6 == 5) {
            j(Path.Op.XOR);
        }
        return this.cw;
    }

    public vl(com.bytedance.adsdk.lottie.model.xt.g gVar) {
        this.f23283r = gVar.j();
        this.f23282m = gVar;
    }

    @Override // com.bytedance.adsdk.lottie.j.j.cw
    public void j(List<cw> list, List<cw> list2) {
        for (int i6 = 0; i6 < this.up.size(); i6++) {
            this.up.get(i6).j(list, list2);
        }
    }

    private void j() {
        for (int i6 = 0; i6 < this.up.size(); i6++) {
            this.cw.addPath(this.up.get(i6).r());
        }
    }

    @TargetApi(19)
    private void j(Path.Op op) {
        this.xt.reset();
        this.f23281j.reset();
        for (int size = this.up.size() - 1; size > 0; size--) {
            jy jyVar = this.up.get(size);
            if (jyVar instanceof r) {
                r rVar = (r) jyVar;
                List<jy> xt = rVar.xt();
                for (int size2 = xt.size() - 1; size2 >= 0; size2--) {
                    Path r5 = xt.get(size2).r();
                    r5.transform(rVar.cw());
                    this.xt.addPath(r5);
                }
            } else {
                this.xt.addPath(jyVar.r());
            }
        }
        jy jyVar2 = this.up.get(0);
        if (jyVar2 instanceof r) {
            r rVar2 = (r) jyVar2;
            List<jy> xt2 = rVar2.xt();
            for (int i6 = 0; i6 < xt2.size(); i6++) {
                Path r6 = xt2.get(i6).r();
                r6.transform(rVar2.cw());
                this.f23281j.addPath(r6);
            }
        } else {
            this.f23281j.set(jyVar2.r());
        }
        this.cw.op(this.f23281j, this.xt, op);
    }
}
