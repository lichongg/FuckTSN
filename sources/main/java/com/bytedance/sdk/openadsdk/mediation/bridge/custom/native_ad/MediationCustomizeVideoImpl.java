package com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo;
import com.bytedance.sdk.openadsdk.mediation.j.j;

/* loaded from: D:\Downloads\app\classes4.dex */
public class MediationCustomizeVideoImpl extends j implements IMediationCustomizeVideo {

    /* renamed from: j, reason: collision with root package name */
    private TTFeedAd.CustomizeVideo f31691j;

    @Override // com.bytedance.sdk.openadsdk.mediation.j.j
    public SparseArray<Object> get() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
    public String getVideoUrl() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.j.j
    public <T> T applyFunction(int i6, ValueSet valueSet, Class<T> cls) {
        if (i6 == 8165) {
            reportVideoStart();
            return null;
        }
        if (i6 == 8168) {
            reportVideoFinish();
            return null;
        }
        if (i6 == 8166) {
            reportVideoPause(valueSet.longValue(8074));
            return null;
        }
        if (i6 == 8167) {
            reportVideoContinue(valueSet.longValue(8074));
            return null;
        }
        if (i6 == 8169) {
            reportVideoBreak(valueSet.longValue(8074));
            return null;
        }
        if (i6 == 8170) {
            reportVideoAutoStart();
            return null;
        }
        if (i6 == 8171) {
            reportVideoStartError(valueSet.intValue(8014), valueSet.intValue(8075));
            return null;
        }
        if (i6 != 8172) {
            return null;
        }
        reportVideoError(valueSet.longValue(8074), valueSet.intValue(8014), valueSet.intValue(8075));
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
    public void reportVideoAutoStart() {
        TTFeedAd.CustomizeVideo customizeVideo = this.f31691j;
        if (customizeVideo != null) {
            customizeVideo.reportVideoAutoStart();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
    public void reportVideoBreak(long j6) {
        TTFeedAd.CustomizeVideo customizeVideo = this.f31691j;
        if (customizeVideo != null) {
            customizeVideo.reportVideoBreak(j6);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
    public void reportVideoContinue(long j6) {
        TTFeedAd.CustomizeVideo customizeVideo = this.f31691j;
        if (customizeVideo != null) {
            customizeVideo.reportVideoContinue(j6);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
    public void reportVideoError(long j6, int i6, int i7) {
        TTFeedAd.CustomizeVideo customizeVideo = this.f31691j;
        if (customizeVideo != null) {
            customizeVideo.reportVideoError(j6, i6, i7);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
    public void reportVideoFinish() {
        TTFeedAd.CustomizeVideo customizeVideo = this.f31691j;
        if (customizeVideo != null) {
            customizeVideo.reportVideoFinish();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
    public void reportVideoPause(long j6) {
        TTFeedAd.CustomizeVideo customizeVideo = this.f31691j;
        if (customizeVideo != null) {
            customizeVideo.reportVideoPause(j6);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
    public void reportVideoStart() {
        TTFeedAd.CustomizeVideo customizeVideo = this.f31691j;
        if (customizeVideo != null) {
            customizeVideo.reportVideoStart();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
    public void reportVideoStartError(int i6, int i7) {
        TTFeedAd.CustomizeVideo customizeVideo = this.f31691j;
        if (customizeVideo != null) {
            customizeVideo.reportVideoStartError(i6, i7);
        }
    }

    public MediationCustomizeVideoImpl(TTFeedAd.CustomizeVideo customizeVideo) {
        this.f31691j = customizeVideo;
    }
}
