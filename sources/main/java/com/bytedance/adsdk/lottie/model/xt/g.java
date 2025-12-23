package com.bytedance.adsdk.lottie.model.xt;

/* loaded from: D:\Downloads\app\classes3.dex */
public class g implements cw {
    private final boolean cw;

    /* renamed from: j, reason: collision with root package name */
    private final String f23451j;
    private final j xt;

    public enum j {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static j j(int i6) {
            return i6 != 1 ? i6 != 2 ? i6 != 3 ? i6 != 4 ? i6 != 5 ? MERGE : EXCLUDE_INTERSECTIONS : INTERSECT : SUBTRACT : ADD : MERGE;
        }
    }

    public String j() {
        return this.f23451j;
    }

    public boolean cw() {
        return this.cw;
    }

    @Override // com.bytedance.adsdk.lottie.model.xt.cw
    public com.bytedance.adsdk.lottie.j.j.cw j(com.bytedance.adsdk.lottie.tl tlVar, com.bytedance.adsdk.lottie.m mVar, com.bytedance.adsdk.lottie.model.layer.cw cwVar) {
        return new com.bytedance.adsdk.lottie.j.j.vl(this);
    }

    public String toString() {
        return "MergePaths{mode=" + this.xt + '}';
    }

    public j xt() {
        return this.xt;
    }

    public g(String str, j jVar, boolean z5) {
        this.f23451j = str;
        this.xt = jVar;
        this.cw = z5;
    }
}
