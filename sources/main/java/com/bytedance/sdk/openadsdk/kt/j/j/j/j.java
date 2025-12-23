package com.bytedance.sdk.openadsdk.kt.j.j.j;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private final TTAdDislike.DislikeInteractionCallback f31552j;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0039, code lost:
    
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
            com.bytedance.sdk.openadsdk.TTAdDislike$DislikeInteractionCallback r0 = r4.f31552j
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            com.bykv.j.j.j.j.a r5 = com.bykv.j.j.j.j.a.j(r5)
            com.bykv.vk.openvk.api.proto.ValueSet r5 = r5.k()
            r0 = -99999987(0xfffffffffa0a1f0d, float:-1.7929169E35)
            int r0 = r5.intValue(r0)
            switch(r0) {
                case 244101: goto L34;
                case 244102: goto L1f;
                case 244103: goto L19;
                default: goto L18;
            }
        L18:
            goto L39
        L19:
            com.bytedance.sdk.openadsdk.TTAdDislike$DislikeInteractionCallback r5 = r4.f31552j
            r5.onCancel()
            goto L39
        L1f:
            r0 = 0
            int r0 = r5.intValue(r0)
            r2 = 1
            java.lang.String r2 = r5.stringValue(r2)
            r3 = 2
            boolean r5 = r5.booleanValue(r3)
            com.bytedance.sdk.openadsdk.TTAdDislike$DislikeInteractionCallback r3 = r4.f31552j
            r3.onSelected(r0, r2, r5)
            goto L39
        L34:
            com.bytedance.sdk.openadsdk.TTAdDislike$DislikeInteractionCallback r5 = r4.f31552j
            r5.onShow()
        L39:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.kt.j.j.j.j.apply(android.util.SparseArray):java.lang.Object");
    }

    public j(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        this.f31552j = dislikeInteractionCallback;
    }
}
