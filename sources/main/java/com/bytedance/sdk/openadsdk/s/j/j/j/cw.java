package com.bytedance.sdk.openadsdk.s.j.j.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private final ValueSet f31827j = a.f22763c;
    private final TTNativeExpressAd.ExpressVideoAdListener xt;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x005a, code lost:
    
        return null;
     */
    @Override // java.util.function.Function
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object apply(android.util.SparseArray<java.lang.Object> r8) {
        /*
            r7 = this;
            com.bytedance.sdk.openadsdk.TTNativeExpressAd$ExpressVideoAdListener r0 = r7.xt
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            com.bykv.j.j.j.j.a r8 = com.bykv.j.j.j.j.a.j(r8)
            com.bykv.vk.openvk.api.proto.ValueSet r8 = r8.k()
            r0 = -99999987(0xfffffffffa0a1f0d, float:-1.7929169E35)
            int r0 = r8.intValue(r0)
            r2 = 1
            r3 = 0
            switch(r0) {
                case 152101: goto L55;
                case 152102: goto L47;
                case 152103: goto L41;
                case 152104: goto L3b;
                case 152105: goto L35;
                case 152106: goto L27;
                case 152107: goto L21;
                case 152108: goto L1b;
                default: goto L1a;
            }
        L1a:
            goto L5a
        L1b:
            com.bytedance.sdk.openadsdk.TTNativeExpressAd$ExpressVideoAdListener r8 = r7.xt
            r8.onClickRetry()
            goto L5a
        L21:
            com.bytedance.sdk.openadsdk.TTNativeExpressAd$ExpressVideoAdListener r8 = r7.xt
            r8.onVideoAdComplete()
            goto L5a
        L27:
            long r3 = r8.longValue(r3)
            long r5 = r8.longValue(r2)
            com.bytedance.sdk.openadsdk.TTNativeExpressAd$ExpressVideoAdListener r8 = r7.xt
            r8.onProgressUpdate(r3, r5)
            goto L5a
        L35:
            com.bytedance.sdk.openadsdk.TTNativeExpressAd$ExpressVideoAdListener r8 = r7.xt
            r8.onVideoAdContinuePlay()
            goto L5a
        L3b:
            com.bytedance.sdk.openadsdk.TTNativeExpressAd$ExpressVideoAdListener r8 = r7.xt
            r8.onVideoAdPaused()
            goto L5a
        L41:
            com.bytedance.sdk.openadsdk.TTNativeExpressAd$ExpressVideoAdListener r8 = r7.xt
            r8.onVideoAdStartPlay()
            goto L5a
        L47:
            int r0 = r8.intValue(r3)
            int r8 = r8.intValue(r2)
            com.bytedance.sdk.openadsdk.TTNativeExpressAd$ExpressVideoAdListener r2 = r7.xt
            r2.onVideoError(r0, r8)
            goto L5a
        L55:
            com.bytedance.sdk.openadsdk.TTNativeExpressAd$ExpressVideoAdListener r8 = r7.xt
            r8.onVideoLoad()
        L5a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.s.j.j.j.cw.apply(android.util.SparseArray):java.lang.Object");
    }

    public cw(TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener) {
        this.xt = expressVideoAdListener;
    }
}
