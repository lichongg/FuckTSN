package com.bytedance.sdk.openadsdk.v.j.j.xt;

import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private ValueSet f31956j = a.f22763c;
    private final TTFeedAd.VideoAdListener xt;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0098, code lost:
    
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
            com.bytedance.sdk.openadsdk.TTFeedAd$VideoAdListener r0 = r7.xt
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            com.bykv.j.j.j.j.a r8 = com.bykv.j.j.j.j.a.j(r8)
            com.bykv.vk.openvk.api.proto.ValueSet r8 = r8.k()
            r0 = -99999987(0xfffffffffa0a1f0d, float:-1.7929169E35)
            int r0 = r8.intValue(r0)
            r2 = 1
            java.lang.Class<java.lang.Object> r3 = java.lang.Object.class
            r4 = 0
            switch(r0) {
                case 161101: goto L86;
                case 161102: goto L78;
                case 161103: goto L65;
                case 161104: goto L52;
                case 161105: goto L3f;
                case 161106: goto L31;
                case 161107: goto L1e;
                default: goto L1c;
            }
        L1c:
            goto L98
        L1e:
            com.bytedance.sdk.openadsdk.i.j.j.g r0 = new com.bytedance.sdk.openadsdk.i.j.j.g
            java.lang.Object r8 = r8.objectValue(r4, r3)
            java.util.function.Function r8 = com.bytedance.sdk.openadsdk.i.j.j.az.j(r8)
            r0.<init>(r8)
            com.bytedance.sdk.openadsdk.TTFeedAd$VideoAdListener r8 = r7.xt
            r8.onVideoAdComplete(r0)
            goto L98
        L31:
            long r3 = r8.longValue(r4)
            long r5 = r8.longValue(r2)
            com.bytedance.sdk.openadsdk.TTFeedAd$VideoAdListener r8 = r7.xt
            r8.onProgressUpdate(r3, r5)
            goto L98
        L3f:
            com.bytedance.sdk.openadsdk.i.j.j.g r0 = new com.bytedance.sdk.openadsdk.i.j.j.g
            java.lang.Object r8 = r8.objectValue(r4, r3)
            java.util.function.Function r8 = com.bytedance.sdk.openadsdk.i.j.j.az.j(r8)
            r0.<init>(r8)
            com.bytedance.sdk.openadsdk.TTFeedAd$VideoAdListener r8 = r7.xt
            r8.onVideoAdContinuePlay(r0)
            goto L98
        L52:
            com.bytedance.sdk.openadsdk.i.j.j.g r0 = new com.bytedance.sdk.openadsdk.i.j.j.g
            java.lang.Object r8 = r8.objectValue(r4, r3)
            java.util.function.Function r8 = com.bytedance.sdk.openadsdk.i.j.j.az.j(r8)
            r0.<init>(r8)
            com.bytedance.sdk.openadsdk.TTFeedAd$VideoAdListener r8 = r7.xt
            r8.onVideoAdStartPlay(r0)
            goto L98
        L65:
            com.bytedance.sdk.openadsdk.i.j.j.g r0 = new com.bytedance.sdk.openadsdk.i.j.j.g
            java.lang.Object r8 = r8.objectValue(r4, r3)
            java.util.function.Function r8 = com.bytedance.sdk.openadsdk.i.j.j.az.j(r8)
            r0.<init>(r8)
            com.bytedance.sdk.openadsdk.TTFeedAd$VideoAdListener r8 = r7.xt
            r8.onVideoAdPaused(r0)
            goto L98
        L78:
            int r0 = r8.intValue(r4)
            int r8 = r8.intValue(r2)
            com.bytedance.sdk.openadsdk.TTFeedAd$VideoAdListener r2 = r7.xt
            r2.onVideoError(r0, r8)
            goto L98
        L86:
            com.bytedance.sdk.openadsdk.i.j.j.g r0 = new com.bytedance.sdk.openadsdk.i.j.j.g
            java.lang.Object r8 = r8.objectValue(r4, r3)
            java.util.function.Function r8 = com.bytedance.sdk.openadsdk.i.j.j.az.j(r8)
            r0.<init>(r8)
            com.bytedance.sdk.openadsdk.TTFeedAd$VideoAdListener r8 = r7.xt
            r8.onVideoLoad(r0)
        L98:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.v.j.j.xt.j.apply(android.util.SparseArray):java.lang.Object");
    }

    public j(TTFeedAd.VideoAdListener videoAdListener) {
        this.xt = videoAdListener;
    }
}
