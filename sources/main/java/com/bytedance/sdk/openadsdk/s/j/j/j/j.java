package com.bytedance.sdk.openadsdk.s.j.j.j;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private final TTNativeExpressAd.AdInteractionListener f31828j;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x006b, code lost:
    
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
            com.bytedance.sdk.openadsdk.TTNativeExpressAd$AdInteractionListener r0 = r6.f31828j
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
                case 151101: goto L5c;
                case 151102: goto L4c;
                case 151103: goto L38;
                case 151104: goto L24;
                case 151105: goto L1e;
                default: goto L1d;
            }
        L1d:
            goto L6b
        L1e:
            com.bytedance.sdk.openadsdk.TTNativeExpressAd$AdInteractionListener r7 = r6.f31828j
            r7.onAdDismiss()
            goto L6b
        L24:
            java.lang.Object r0 = r7.objectValue(r5, r4)
            android.view.View r0 = (android.view.View) r0
            float r3 = r7.floatValue(r3)
            float r7 = r7.floatValue(r2)
            com.bytedance.sdk.openadsdk.TTNativeExpressAd$AdInteractionListener r2 = r6.f31828j
            r2.onRenderSuccess(r0, r3, r7)
            goto L6b
        L38:
            java.lang.Object r0 = r7.objectValue(r5, r4)
            android.view.View r0 = (android.view.View) r0
            java.lang.String r3 = r7.stringValue(r3)
            int r7 = r7.intValue(r2)
            com.bytedance.sdk.openadsdk.TTNativeExpressAd$AdInteractionListener r2 = r6.f31828j
            r2.onRenderFail(r0, r3, r7)
            goto L6b
        L4c:
            java.lang.Object r0 = r7.objectValue(r5, r4)
            android.view.View r0 = (android.view.View) r0
            int r7 = r7.intValue(r3)
            com.bytedance.sdk.openadsdk.TTNativeExpressAd$AdInteractionListener r2 = r6.f31828j
            r2.onAdShow(r0, r7)
            goto L6b
        L5c:
            java.lang.Object r0 = r7.objectValue(r5, r4)
            android.view.View r0 = (android.view.View) r0
            int r7 = r7.intValue(r3)
            com.bytedance.sdk.openadsdk.TTNativeExpressAd$AdInteractionListener r2 = r6.f31828j
            r2.onAdClicked(r0, r7)
        L6b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.s.j.j.j.j.apply(android.util.SparseArray):java.lang.Object");
    }

    public j(TTNativeExpressAd.AdInteractionListener adInteractionListener) {
        this.f31828j = adInteractionListener;
    }
}
