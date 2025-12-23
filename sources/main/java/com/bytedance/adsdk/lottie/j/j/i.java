package com.bytedance.adsdk.lottie.j.j;

import android.graphics.PointF;
import com.bytedance.adsdk.lottie.j.xt.j;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class i implements mi, j.InterfaceC0316j {
    private final com.bytedance.adsdk.lottie.j.xt.j<Float, Float> cw;

    /* renamed from: j, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.tl f23255j;

    /* renamed from: r, reason: collision with root package name */
    private com.bytedance.adsdk.lottie.model.xt.ws f23256r;
    private final String xt;

    @Override // com.bytedance.adsdk.lottie.j.j.cw
    public void j(List<cw> list, List<cw> list2) {
    }

    public com.bytedance.adsdk.lottie.j.xt.j<Float, Float> xt() {
        return this.cw;
    }

    private com.bytedance.adsdk.lottie.model.xt.ws xt(com.bytedance.adsdk.lottie.model.xt.ws wsVar) {
        List<com.bytedance.adsdk.lottie.model.j> cw = wsVar.cw();
        boolean xt = wsVar.xt();
        int size = cw.size() - 1;
        int i6 = 0;
        while (size >= 0) {
            com.bytedance.adsdk.lottie.model.j jVar = cw.get(size);
            com.bytedance.adsdk.lottie.model.j jVar2 = cw.get(j(size - 1, cw.size()));
            PointF cw2 = (size != 0 || xt) ? jVar2.cw() : wsVar.j();
            i6 = (((size != 0 || xt) ? jVar2.xt() : cw2).equals(cw2) && jVar.j().equals(cw2) && !(!wsVar.xt() && size == 0 && size == cw.size() - 1)) ? i6 + 2 : i6 + 1;
            size--;
        }
        com.bytedance.adsdk.lottie.model.xt.ws wsVar2 = this.f23256r;
        if (wsVar2 == null || wsVar2.cw().size() != i6) {
            ArrayList arrayList = new ArrayList(i6);
            for (int i7 = 0; i7 < i6; i7++) {
                arrayList.add(new com.bytedance.adsdk.lottie.model.j());
            }
            this.f23256r = new com.bytedance.adsdk.lottie.model.xt.ws(new PointF(0.0f, 0.0f), false, arrayList);
        }
        this.f23256r.j(xt);
        return this.f23256r;
    }

    @Override // com.bytedance.adsdk.lottie.j.xt.j.InterfaceC0316j
    public void j() {
        this.f23255j.invalidateSelf();
    }

    public i(com.bytedance.adsdk.lottie.tl tlVar, com.bytedance.adsdk.lottie.model.layer.cw cwVar, com.bytedance.adsdk.lottie.model.xt.jy jyVar) {
        this.f23255j = tlVar;
        this.xt = jyVar.j();
        com.bytedance.adsdk.lottie.j.xt.j<Float, Float> j6 = jyVar.xt().j();
        this.cw = j6;
        cwVar.j(j6);
        j6.j(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x009e, code lost:
    
        if (r7 == (r0.size() - 1)) goto L27;
     */
    @Override // com.bytedance.adsdk.lottie.j.j.mi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.bytedance.adsdk.lottie.model.xt.ws j(com.bytedance.adsdk.lottie.model.xt.ws r19) {
        /*
            Method dump skipped, instructions count: 416
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.j.j.i.j(com.bytedance.adsdk.lottie.model.xt.ws):com.bytedance.adsdk.lottie.model.xt.ws");
    }

    private static int xt(int i6, int i7) {
        int i8 = i6 / i7;
        return ((i6 ^ i7) >= 0 || i7 * i8 == i6) ? i8 : i8 - 1;
    }

    private static int j(int i6, int i7) {
        return i6 - (xt(i6, i7) * i7);
    }
}
