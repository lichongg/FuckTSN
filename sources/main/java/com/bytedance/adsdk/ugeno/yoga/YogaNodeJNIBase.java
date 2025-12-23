package com.bytedance.adsdk.ugeno.yoga;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@com.bytedance.adsdk.ugeno.yoga.j.j
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class YogaNodeJNIBase extends oq implements Cloneable {
    private boolean ae;

    @com.bytedance.adsdk.ugeno.yoga.j.j
    private float[] arr;
    private List<YogaNodeJNIBase> cw;

    /* renamed from: j, reason: collision with root package name */
    protected long f23900j;

    /* renamed from: m, reason: collision with root package name */
    private Object f23901m;

    @com.bytedance.adsdk.ugeno.yoga.j.j
    private int mLayoutDirection;

    /* renamed from: r, reason: collision with root package name */
    private ae f23902r;
    private xt up;
    private YogaNodeJNIBase xt;

    private YogaNodeJNIBase(long j6) {
        this.arr = null;
        this.mLayoutDirection = 0;
        this.ae = true;
        if (j6 == 0) {
            throw new IllegalStateException("Failed to allocate native memory");
        }
        this.f23900j = j6;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.oq
    public void ae(float f6) {
        YogaNative.jni_YGNodeStyleSetHeightPercentJNI(this.f23900j, f6);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.oq
    /* renamed from: cw, reason: merged with bridge method [inline-methods] */
    public YogaNodeJNIBase j(int i6) {
        List<YogaNodeJNIBase> list = this.cw;
        if (list != null) {
            return list.get(i6);
        }
        throw new IllegalStateException("YogaNode does not have children");
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.oq
    public void g(float f6) {
        YogaNative.jni_YGNodeStyleSetMinHeightJNI(this.f23900j, f6);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.oq
    public void m(float f6) {
        YogaNative.jni_YGNodeStyleSetHeightJNI(this.f23900j, f6);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.oq
    public void oq(float f6) {
        YogaNative.jni_YGNodeStyleSetMaxWidthJNI(this.f23900j, f6);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.oq
    /* renamed from: qv, reason: merged with bridge method [inline-methods] */
    public YogaNodeJNIBase xt() {
        return this.xt;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.oq
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public YogaNodeJNIBase xt(int i6) {
        List<YogaNodeJNIBase> list = this.cw;
        if (list == null) {
            throw new IllegalStateException("Trying to remove a child of a YogaNode that does not have children");
        }
        YogaNodeJNIBase remove = list.remove(i6);
        remove.xt = null;
        YogaNative.jni_YGNodeRemoveChildJNI(this.f23900j, remove.f23900j);
        return remove;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.oq
    public void tl(float f6) {
        YogaNative.jni_YGNodeStyleSetMinWidthJNI(this.f23900j, f6);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.oq
    public void up(float f6) {
        YogaNative.jni_YGNodeStyleSetWidthPercentJNI(this.f23900j, f6);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.oq
    public void vl(float f6) {
        YogaNative.jni_YGNodeStyleSetAspectRatioJNI(this.f23900j, f6);
    }

    @com.bytedance.adsdk.ugeno.yoga.j.j
    private final long replaceChild(YogaNodeJNIBase yogaNodeJNIBase, int i6) {
        List<YogaNodeJNIBase> list = this.cw;
        if (list == null) {
            throw new IllegalStateException("Cannot replace child. YogaNode does not have children");
        }
        list.remove(i6);
        this.cw.add(i6, yogaNodeJNIBase);
        yogaNodeJNIBase.xt = this;
        return yogaNodeJNIBase.f23900j;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.oq
    public float ae() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[4];
        }
        return 0.0f;
    }

    @com.bytedance.adsdk.ugeno.yoga.j.j
    public final float baseline(float f6, float f7) {
        return this.up.j(this, f6, f7);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.oq
    public float g() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[2];
        }
        return 0.0f;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.oq
    public int j() {
        List<YogaNodeJNIBase> list = this.cw;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.oq
    public float m() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[3];
        }
        return 0.0f;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.oq
    public Object oq() {
        return this.f23901m;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.oq
    public void qv(float f6) {
        YogaNative.jni_YGNodeStyleSetMaxHeightJNI(this.f23900j, f6);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.oq
    public float tl() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[1];
        }
        return 0.0f;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.oq
    public void up() {
        YogaNative.jni_YGNodeStyleSetHeightAutoJNI(this.f23900j);
    }

    public boolean vl() {
        return this.f23902r != null;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.oq
    public void j(oq oqVar, int i6) {
        if (oqVar instanceof YogaNodeJNIBase) {
            YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) oqVar;
            if (yogaNodeJNIBase.xt == null) {
                if (this.cw == null) {
                    this.cw = new ArrayList(4);
                }
                this.cw.add(i6, yogaNodeJNIBase);
                yogaNodeJNIBase.xt = this;
                YogaNative.jni_YGNodeInsertChildJNI(this.f23900j, yogaNodeJNIBase.f23900j, i6);
                return;
            }
            throw new IllegalStateException("Child already has a parent, it must be removed first.");
        }
    }

    @com.bytedance.adsdk.ugeno.yoga.j.j
    public final long measure(float f6, int i6, float f7, int i7) {
        if (vl()) {
            return this.f23902r.j(this, f6, tl.j(i6), f7, tl.j(i7));
        }
        throw new RuntimeException("Measure function isn't defined!");
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.oq
    public void xt(j jVar) {
        YogaNative.jni_YGNodeStyleSetAlignSelfJNI(this.f23900j, jVar.j());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.oq
    public void cw(j jVar) {
        YogaNative.jni_YGNodeStyleSetAlignContentJNI(this.f23900j, jVar.j());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.oq
    public void xt(float f6) {
        YogaNative.jni_YGNodeStyleSetFlexShrinkJNI(this.f23900j, f6);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.oq
    public void cw(float f6) {
        YogaNative.jni_YGNodeStyleSetFlexBasisJNI(this.f23900j, f6);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.oq
    public void xt(r rVar, float f6) {
        YogaNative.jni_YGNodeStyleSetPaddingJNI(this.f23900j, rVar.j(), f6);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.oq
    public void cw() {
        YogaNative.jni_YGNodeStyleSetFlexBasisAutoJNI(this.f23900j);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.oq
    public void r(float f6) {
        YogaNative.jni_YGNodeStyleSetWidthJNI(this.f23900j, f6);
    }

    YogaNodeJNIBase() {
        this(YogaNative.jni_YGNodeNewJNI());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.oq
    public void cw(r rVar, float f6) {
        YogaNative.jni_YGNodeStyleSetPositionJNI(this.f23900j, rVar.j(), f6);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.oq
    public void r() {
        YogaNative.jni_YGNodeStyleSetWidthAutoJNI(this.f23900j);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.oq
    public int j(oq oqVar) {
        List<YogaNodeJNIBase> list = this.cw;
        if (list == null) {
            return -1;
        }
        return list.indexOf(oqVar);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.oq
    public void j(float f6, float f7) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            List<YogaNodeJNIBase> list = ((YogaNodeJNIBase) arrayList.get(i6)).cw;
            if (list != null) {
                Iterator<YogaNodeJNIBase> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
            }
        }
        YogaNodeJNIBase[] yogaNodeJNIBaseArr = (YogaNodeJNIBase[]) arrayList.toArray(new YogaNodeJNIBase[arrayList.size()]);
        long[] jArr = new long[yogaNodeJNIBaseArr.length];
        for (int i7 = 0; i7 < yogaNodeJNIBaseArr.length; i7++) {
            jArr[i7] = yogaNodeJNIBaseArr[i7].f23900j;
        }
        YogaNative.jni_YGNodeCalculateLayoutJNI(this.f23900j, f6, f7, jArr, yogaNodeJNIBaseArr);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.oq
    public void j(cw cwVar) {
        YogaNative.jni_YGNodeStyleSetDirectionJNI(this.f23900j, cwVar.j());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.oq
    public void j(up upVar) {
        YogaNative.jni_YGNodeStyleSetFlexDirectionJNI(this.f23900j, upVar.j());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.oq
    public void j(m mVar) {
        YogaNative.jni_YGNodeStyleSetJustifyContentJNI(this.f23900j, mVar.j());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.oq
    public void j(j jVar) {
        YogaNative.jni_YGNodeStyleSetAlignItemsJNI(this.f23900j, jVar.j());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.oq
    public void j(jy jyVar) {
        YogaNative.jni_YGNodeStyleSetPositionTypeJNI(this.f23900j, jyVar.j());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.oq
    public void j(ws wsVar) {
        YogaNative.jni_YGNodeStyleSetFlexWrapJNI(this.f23900j, wsVar.j());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.oq
    public void j(float f6) {
        YogaNative.jni_YGNodeStyleSetFlexGrowJNI(this.f23900j, f6);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.oq
    public void j(r rVar, float f6) {
        YogaNative.jni_YGNodeStyleSetMarginJNI(this.f23900j, rVar.j(), f6);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.oq
    public void j(ae aeVar) {
        this.f23902r = aeVar;
        YogaNative.jni_YGNodeSetHasMeasureFuncJNI(this.f23900j, aeVar != null);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.oq
    public void j(boolean z5) {
        YogaNative.jni_YGNodeSetAlwaysFormsContainingBlockJNI(this.f23900j, z5);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.oq
    public void j(Object obj) {
        this.f23901m = obj;
    }
}
