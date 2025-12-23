package com.bytedance.sdk.openadsdk.mediation.ad.j.j.xt;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private final MediationExpressRenderListener f31659j;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0056, code lost:
    
        return null;
     */
    @Override // java.util.function.Function
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object apply(android.util.SparseArray<java.lang.Object> r7) {
        /*
            r6 = this;
            com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener r0 = r6.f31659j
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            com.bykv.j.j.j.j.a r7 = com.bykv.j.j.j.j.a.j(r7)
            com.bykv.vk.openvk.api.proto.ValueSet r7 = r7.k()
            r0 = -99999987(0xfffffffffa0a1f0d, float:-1.7929169E35)
            int r0 = r7.intValue(r0)
            r2 = 2
            r3 = 1
            java.lang.Class<android.view.View> r4 = android.view.View.class
            r5 = 0
            switch(r0) {
                case 142101: goto L3e;
                case 142102: goto L2a;
                case 142103: goto L24;
                case 142104: goto L1e;
                default: goto L1d;
            }
        L1d:
            goto L56
        L1e:
            com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener r7 = r6.f31659j
            r7.onAdShow()
            goto L56
        L24:
            com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener r7 = r6.f31659j
            r7.onAdClick()
            goto L56
        L2a:
            java.lang.Object r0 = r7.objectValue(r5, r4)
            android.view.View r0 = (android.view.View) r0
            java.lang.String r3 = r7.stringValue(r3)
            int r7 = r7.intValue(r2)
            com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener r2 = r6.f31659j
            r2.onRenderFail(r0, r3, r7)
            goto L56
        L3e:
            java.lang.Object r0 = r7.objectValue(r5, r4)
            android.view.View r0 = (android.view.View) r0
            float r3 = r7.floatValue(r3)
            float r2 = r7.floatValue(r2)
            r4 = 3
            boolean r7 = r7.booleanValue(r4)
            com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener r4 = r6.f31659j
            r4.onRenderSuccess(r0, r3, r2, r7)
        L56:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.mediation.ad.j.j.xt.m.apply(android.util.SparseArray):java.lang.Object");
    }

    public m(MediationExpressRenderListener mediationExpressRenderListener) {
        this.f31659j = mediationExpressRenderListener;
    }
}
