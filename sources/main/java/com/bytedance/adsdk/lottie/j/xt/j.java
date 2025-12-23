package com.bytedance.adsdk.lottie.j.xt;

import android.view.animation.Interpolator;
import com.bytedance.component.sdk.annotation.FloatRange;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class j<K, A> {
    protected com.bytedance.adsdk.lottie.m.cw<A> cw;
    private final cw<K> up;

    /* renamed from: j, reason: collision with root package name */
    final List<InterfaceC0316j> f23302j = new ArrayList(1);

    /* renamed from: r, reason: collision with root package name */
    private boolean f23304r = false;
    protected float xt = 0.0f;

    /* renamed from: m, reason: collision with root package name */
    private A f23303m = null;
    private float ae = -1.0f;
    private float tl = -1.0f;

    /* renamed from: com.bytedance.adsdk.lottie.j.xt.j$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private interface cw<T> {
        @FloatRange(from = 0.0d, to = 1.0d)
        float cw();

        boolean j();

        boolean j(float f6);

        @FloatRange(from = 0.0d, to = 1.0d)
        float r();

        com.bytedance.adsdk.lottie.m.j<T> xt();

        boolean xt(float f6);
    }

    /* renamed from: com.bytedance.adsdk.lottie.j.xt.j$j, reason: collision with other inner class name */
    public interface InterfaceC0316j {
        void j();
    }

    private static final class r<T> implements cw<T> {

        /* renamed from: j, reason: collision with root package name */
        private final List<? extends com.bytedance.adsdk.lottie.m.j<T>> f23305j;
        private com.bytedance.adsdk.lottie.m.j<T> cw = null;

        /* renamed from: r, reason: collision with root package name */
        private float f23306r = -1.0f;
        private com.bytedance.adsdk.lottie.m.j<T> xt = cw(0.0f);

        private com.bytedance.adsdk.lottie.m.j<T> cw(float f6) {
            com.bytedance.adsdk.lottie.m.j<T> jVar = this.f23305j.get(r0.size() - 1);
            if (f6 >= jVar.cw()) {
                return jVar;
            }
            for (int size = this.f23305j.size() - 2; size > 0; size--) {
                com.bytedance.adsdk.lottie.m.j<T> jVar2 = this.f23305j.get(size);
                if (this.xt != jVar2 && jVar2.j(f6)) {
                    return jVar2;
                }
            }
            return this.f23305j.get(0);
        }

        @Override // com.bytedance.adsdk.lottie.j.xt.j.cw
        public boolean j() {
            return false;
        }

        @Override // com.bytedance.adsdk.lottie.j.xt.j.cw
        public com.bytedance.adsdk.lottie.m.j<T> xt() {
            return this.xt;
        }

        @Override // com.bytedance.adsdk.lottie.j.xt.j.cw
        public boolean j(float f6) {
            if (this.xt.j(f6)) {
                return !this.xt.up();
            }
            this.xt = cw(f6);
            return true;
        }

        @Override // com.bytedance.adsdk.lottie.j.xt.j.cw
        public float r() {
            return this.f23305j.get(r0.size() - 1).r();
        }

        @Override // com.bytedance.adsdk.lottie.j.xt.j.cw
        public boolean xt(float f6) {
            com.bytedance.adsdk.lottie.m.j<T> jVar = this.cw;
            com.bytedance.adsdk.lottie.m.j<T> jVar2 = this.xt;
            if (jVar == jVar2 && this.f23306r == f6) {
                return true;
            }
            this.cw = jVar2;
            this.f23306r = f6;
            return false;
        }

        r(List<? extends com.bytedance.adsdk.lottie.m.j<T>> list) {
            this.f23305j = list;
        }

        @Override // com.bytedance.adsdk.lottie.j.xt.j.cw
        public float cw() {
            return this.f23305j.get(0).cw();
        }
    }

    private static final class up<T> implements cw<T> {

        /* renamed from: j, reason: collision with root package name */
        private final com.bytedance.adsdk.lottie.m.j<T> f23307j;
        private float xt = -1.0f;

        @Override // com.bytedance.adsdk.lottie.j.xt.j.cw
        public boolean j() {
            return false;
        }

        @Override // com.bytedance.adsdk.lottie.j.xt.j.cw
        public com.bytedance.adsdk.lottie.m.j<T> xt() {
            return this.f23307j;
        }

        @Override // com.bytedance.adsdk.lottie.j.xt.j.cw
        public float cw() {
            return this.f23307j.cw();
        }

        @Override // com.bytedance.adsdk.lottie.j.xt.j.cw
        public boolean j(float f6) {
            return !this.f23307j.up();
        }

        @Override // com.bytedance.adsdk.lottie.j.xt.j.cw
        public float r() {
            return this.f23307j.r();
        }

        @Override // com.bytedance.adsdk.lottie.j.xt.j.cw
        public boolean xt(float f6) {
            if (this.xt == f6) {
                return true;
            }
            this.xt = f6;
            return false;
        }

        up(List<? extends com.bytedance.adsdk.lottie.m.j<T>> list) {
            this.f23307j = list.get(0);
        }
    }

    private static final class xt<T> implements cw<T> {
        private xt() {
        }

        @Override // com.bytedance.adsdk.lottie.j.xt.j.cw
        public float cw() {
            return 0.0f;
        }

        @Override // com.bytedance.adsdk.lottie.j.xt.j.cw
        public boolean j() {
            return true;
        }

        @Override // com.bytedance.adsdk.lottie.j.xt.j.cw
        public com.bytedance.adsdk.lottie.m.j<T> xt() {
            throw new IllegalStateException("not implemented");
        }

        /* synthetic */ xt(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.bytedance.adsdk.lottie.j.xt.j.cw
        public boolean j(float f6) {
            return false;
        }

        @Override // com.bytedance.adsdk.lottie.j.xt.j.cw
        public float r() {
            return 1.0f;
        }

        @Override // com.bytedance.adsdk.lottie.j.xt.j.cw
        public boolean xt(float f6) {
            throw new IllegalStateException("not implemented");
        }
    }

    abstract A j(com.bytedance.adsdk.lottie.m.j<K> jVar, float f6);

    public void j() {
        this.f23304r = true;
    }

    public void xt() {
        for (int i6 = 0; i6 < this.f23302j.size(); i6++) {
            this.f23302j.get(i6).j();
        }
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    private float g() {
        if (this.ae == -1.0f) {
            this.ae = this.up.cw();
        }
        return this.ae;
    }

    protected com.bytedance.adsdk.lottie.m.j<K> cw() {
        com.bytedance.adsdk.lottie.up.j("BaseKeyframeAnimation#getCurrentKeyframe");
        com.bytedance.adsdk.lottie.m.j<K> xt2 = this.up.xt();
        com.bytedance.adsdk.lottie.up.xt("BaseKeyframeAnimation#getCurrentKeyframe");
        return xt2;
    }

    public void j(InterfaceC0316j interfaceC0316j) {
        this.f23302j.add(interfaceC0316j);
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    float m() {
        if (this.tl == -1.0f) {
            this.tl = this.up.r();
        }
        return this.tl;
    }

    float r() {
        if (this.f23304r) {
            return 0.0f;
        }
        com.bytedance.adsdk.lottie.m.j<K> cw2 = cw();
        if (cw2.up()) {
            return 0.0f;
        }
        return (this.xt - cw2.cw()) / (cw2.r() - cw2.cw());
    }

    public float tl() {
        return this.xt;
    }

    j(List<? extends com.bytedance.adsdk.lottie.m.j<K>> list) {
        this.up = j(list);
    }

    public A ae() {
        A j6;
        float r5 = r();
        if (this.cw == null && this.up.xt(r5)) {
            return this.f23303m;
        }
        com.bytedance.adsdk.lottie.m.j<K> cw2 = cw();
        Interpolator interpolator = cw2.f23339r;
        if (interpolator != null && cw2.up != null) {
            j6 = j(cw2, r5, interpolator.getInterpolation(r5), cw2.up.getInterpolation(r5));
        } else {
            j6 = j(cw2, up());
        }
        this.f23303m = j6;
        return j6;
    }

    public void j(@FloatRange(from = 0.0d, to = 1.0d) float f6) {
        if (this.up.j()) {
            return;
        }
        if (f6 < g()) {
            f6 = g();
        } else if (f6 > m()) {
            f6 = m();
        }
        if (f6 == this.xt) {
            return;
        }
        this.xt = f6;
        if (this.up.j(f6)) {
            xt();
        }
    }

    protected float up() {
        com.bytedance.adsdk.lottie.m.j<K> cw2 = cw();
        if (cw2 != null && !cw2.up()) {
            return cw2.cw.getInterpolation(r());
        }
        return 0.0f;
    }

    protected A j(com.bytedance.adsdk.lottie.m.j<K> jVar, float f6, float f7, float f8) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }

    private static <T> cw<T> j(List<? extends com.bytedance.adsdk.lottie.m.j<T>> list) {
        if (list.isEmpty()) {
            return new xt(null);
        }
        if (list.size() == 1) {
            return new up(list);
        }
        return new r(list);
    }
}
