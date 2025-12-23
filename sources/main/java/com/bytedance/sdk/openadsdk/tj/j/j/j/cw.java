package com.bytedance.sdk.openadsdk.tj.j.j.j;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.TTAdNative;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private final TTAdNative.FullScreenVideoAdListener f31833j;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x005c, code lost:
    
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
            com.bytedance.sdk.openadsdk.TTAdNative$FullScreenVideoAdListener r0 = r4.f31833j
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            com.bykv.j.j.j.j.a r5 = com.bykv.j.j.j.j.a.j(r5)
            com.bykv.vk.openvk.api.proto.ValueSet r5 = r5.k()
            r0 = -99999987(0xfffffffffa0a1f0d, float:-1.7929169E35)
            int r0 = r5.intValue(r0)
            r2 = 0
            switch(r0) {
                case 132101: goto L4e;
                case 132102: goto L37;
                case 132103: goto L20;
                case 132104: goto L1a;
                default: goto L19;
            }
        L19:
            goto L5c
        L1a:
            com.bytedance.sdk.openadsdk.TTAdNative$FullScreenVideoAdListener r5 = r4.f31833j
            r5.onFullScreenVideoCached()
            goto L5c
        L20:
            com.bytedance.sdk.openadsdk.i.j.j.oq r0 = new com.bytedance.sdk.openadsdk.i.j.j.oq
            java.lang.Class r3 = a1.a.a()
            java.lang.Object r5 = r5.objectValue(r2, r3)
            java.util.function.Function r5 = a1.b.a(r5)
            r0.<init>(r5)
            com.bytedance.sdk.openadsdk.TTAdNative$FullScreenVideoAdListener r5 = r4.f31833j
            r5.onFullScreenVideoCached(r0)
            goto L5c
        L37:
            com.bytedance.sdk.openadsdk.i.j.j.oq r0 = new com.bytedance.sdk.openadsdk.i.j.j.oq
            java.lang.Class r3 = a1.a.a()
            java.lang.Object r5 = r5.objectValue(r2, r3)
            java.util.function.Function r5 = a1.b.a(r5)
            r0.<init>(r5)
            com.bytedance.sdk.openadsdk.TTAdNative$FullScreenVideoAdListener r5 = r4.f31833j
            r5.onFullScreenVideoAdLoad(r0)
            goto L5c
        L4e:
            int r0 = r5.intValue(r2)
            r2 = 1
            java.lang.String r5 = r5.stringValue(r2)
            com.bytedance.sdk.openadsdk.TTAdNative$FullScreenVideoAdListener r2 = r4.f31833j
            r2.onError(r0, r5)
        L5c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.tj.j.j.j.cw.apply(android.util.SparseArray):java.lang.Object");
    }

    public cw(TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        this.f31833j = fullScreenVideoAdListener;
    }
}
