package com.bytedance.sdk.openadsdk.mediation.xt.j.xt;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.mediation.IMediationDrawAdTokenCallback;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private final IMediationDrawAdTokenCallback f31783j;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0049, code lost:
    
        return null;
     */
    @Override // java.util.function.Function
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object apply(android.util.SparseArray<java.lang.Object> r6) {
        /*
            r5 = this;
            com.bytedance.sdk.openadsdk.mediation.IMediationDrawAdTokenCallback r0 = r5.f31783j
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            com.bykv.j.j.j.j.a r6 = com.bykv.j.j.j.j.a.j(r6)
            com.bykv.vk.openvk.api.proto.ValueSet r6 = r6.k()
            r0 = -99999987(0xfffffffffa0a1f0d, float:-1.7929169E35)
            int r0 = r6.intValue(r0)
            r2 = -99999985(0xfffffffffa0a1f0f, float:-1.7929173E35)
            java.lang.Class<java.lang.Class> r3 = java.lang.Class.class
            r6.objectValue(r2, r3)
            r2 = 1
            r3 = 0
            switch(r0) {
                case 270029: goto L31;
                case 270030: goto L23;
                default: goto L22;
            }
        L22:
            goto L49
        L23:
            int r0 = r6.intValue(r3)
            java.lang.String r6 = r6.stringValue(r2)
            com.bytedance.sdk.openadsdk.mediation.IMediationDrawAdTokenCallback r2 = r5.f31783j
            r2.onAdTokenLoadedFail(r0, r6)
            goto L49
        L31:
            java.lang.String r0 = r6.stringValue(r3)
            com.bytedance.sdk.openadsdk.mediation.xt.j.j.j r3 = new com.bytedance.sdk.openadsdk.mediation.xt.j.j.j
            java.lang.Class<java.lang.Object> r4 = java.lang.Object.class
            java.lang.Object r6 = r6.objectValue(r2, r4)
            java.util.function.Function r6 = com.bytedance.sdk.openadsdk.i.j.j.az.j(r6)
            r3.<init>(r6)
            com.bytedance.sdk.openadsdk.mediation.IMediationDrawAdTokenCallback r6 = r5.f31783j
            r6.onAdTokenLoaded(r0, r3)
        L49:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.mediation.xt.j.xt.j.apply(android.util.SparseArray):java.lang.Object");
    }

    public j(IMediationDrawAdTokenCallback iMediationDrawAdTokenCallback) {
        this.f31783j = iMediationDrawAdTokenCallback;
    }
}
