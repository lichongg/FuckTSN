package com.bytedance.sdk.openadsdk.mediation.xt.j;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private final MediationAdDislike f31781j;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0034, code lost:
    
        return null;
     */
    @Override // java.util.function.Function
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object apply(android.util.SparseArray<java.lang.Object> r5) {
        /*
            r4 = this;
            com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike r0 = r4.f31781j
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            com.bykv.j.j.j.j.a r5 = com.bykv.j.j.j.j.a.j(r5)
            com.bykv.vk.openvk.api.proto.ValueSet r5 = r5.k()
            r0 = -99999987(0xfffffffffa0a1f0d, float:-1.7929169E35)
            int r0 = r5.intValue(r0)
            switch(r0) {
                case 270032: goto L2f;
                case 270033: goto L19;
                default: goto L18;
            }
        L18:
            goto L34
        L19:
            com.bytedance.sdk.openadsdk.mediation.xt.j.j r0 = new com.bytedance.sdk.openadsdk.mediation.xt.j.j
            r2 = 0
            java.lang.Class<java.lang.Object> r3 = java.lang.Object.class
            java.lang.Object r5 = r5.objectValue(r2, r3)
            java.util.function.Function r5 = com.bytedance.sdk.openadsdk.i.j.j.az.j(r5)
            r0.<init>(r5)
            com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike r5 = r4.f31781j
            r5.setDislikeCallback(r0)
            goto L34
        L2f:
            com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike r5 = r4.f31781j
            r5.showDislikeDialog()
        L34:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.mediation.xt.j.xt.apply(android.util.SparseArray):java.lang.Object");
    }

    public xt(MediationAdDislike mediationAdDislike) {
        this.f31781j = mediationAdDislike;
    }
}
