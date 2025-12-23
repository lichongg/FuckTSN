package com.bytedance.sdk.openadsdk.i.j.xt;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private final TTAppDownloadListener f31502j;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x008b, code lost:
    
        return null;
     */
    @Override // java.util.function.Function
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object apply(android.util.SparseArray<java.lang.Object> r22) {
        /*
            r21 = this;
            r0 = r21
            com.bytedance.sdk.openadsdk.TTAppDownloadListener r1 = r0.f31502j
            r2 = 0
            if (r1 != 0) goto L8
            return r2
        L8:
            com.bykv.j.j.j.j.a r1 = com.bykv.j.j.j.j.a.j(r22)
            com.bykv.vk.openvk.api.proto.ValueSet r1 = r1.k()
            r3 = -99999987(0xfffffffffa0a1f0d, float:-1.7929169E35)
            int r3 = r1.intValue(r3)
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = 0
            switch(r3) {
                case 221101: goto L86;
                case 221102: goto L6c;
                case 221103: goto L56;
                case 221104: goto L40;
                case 221105: goto L2e;
                case 221106: goto L20;
                default: goto L1e;
            }
        L1e:
            goto L8b
        L20:
            java.lang.String r3 = r1.stringValue(r7)
            java.lang.String r1 = r1.stringValue(r6)
            com.bytedance.sdk.openadsdk.TTAppDownloadListener r4 = r0.f31502j
            r4.onInstalled(r3, r1)
            goto L8b
        L2e:
            long r3 = r1.longValue(r7)
            java.lang.String r6 = r1.stringValue(r6)
            java.lang.String r1 = r1.stringValue(r5)
            com.bytedance.sdk.openadsdk.TTAppDownloadListener r5 = r0.f31502j
            r5.onDownloadFinished(r3, r6, r1)
            goto L8b
        L40:
            long r8 = r1.longValue(r7)
            long r10 = r1.longValue(r6)
            java.lang.String r12 = r1.stringValue(r5)
            java.lang.String r13 = r1.stringValue(r4)
            com.bytedance.sdk.openadsdk.TTAppDownloadListener r7 = r0.f31502j
            r7.onDownloadFailed(r8, r10, r12, r13)
            goto L8b
        L56:
            long r15 = r1.longValue(r7)
            long r17 = r1.longValue(r6)
            java.lang.String r19 = r1.stringValue(r5)
            java.lang.String r20 = r1.stringValue(r4)
            com.bytedance.sdk.openadsdk.TTAppDownloadListener r14 = r0.f31502j
            r14.onDownloadPaused(r15, r17, r19, r20)
            goto L8b
        L6c:
            long r7 = r1.longValue(r7)
            long r9 = r1.longValue(r6)
            java.lang.String r3 = r1.stringValue(r5)
            java.lang.String r1 = r1.stringValue(r4)
            r4 = r7
            r8 = r3
            com.bytedance.sdk.openadsdk.TTAppDownloadListener r3 = r0.f31502j
            r6 = r9
            r9 = r1
            r3.onDownloadActive(r4, r6, r8, r9)
            goto L8b
        L86:
            com.bytedance.sdk.openadsdk.TTAppDownloadListener r1 = r0.f31502j
            r1.onIdle()
        L8b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.i.j.xt.cw.apply(android.util.SparseArray):java.lang.Object");
    }

    public cw(TTAppDownloadListener tTAppDownloadListener) {
        this.f31502j = tTAppDownloadListener;
    }
}
