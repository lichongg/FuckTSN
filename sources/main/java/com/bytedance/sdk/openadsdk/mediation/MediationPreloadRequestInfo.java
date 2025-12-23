package com.bytedance.sdk.openadsdk.mediation;

import com.bytedance.sdk.openadsdk.AdSlot;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class MediationPreloadRequestInfo implements IMediationPreloadRequestInfo {
    private List<String> cw;

    /* renamed from: j, reason: collision with root package name */
    private int f31633j;
    private AdSlot xt;

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo
    public AdSlot getAdSlot() {
        return this.xt;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo
    public int getAdType() {
        return this.f31633j;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo
    public List<String> getPrimeRitList() {
        return this.cw;
    }

    public MediationPreloadRequestInfo(int i6, AdSlot adSlot, List<String> list) {
        this.f31633j = i6;
        this.xt = adSlot;
        this.cw = list;
    }
}
