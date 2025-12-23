package com.bytedance.sdk.openadsdk.i.j.j;

import a1.a;
import android.app.Activity;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationRewardManager;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ws implements TTRewardVideoAd {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f31499j;
    private ValueSet xt;

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void showRewardVideoAd(Activity activity) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(-99999987, 120105);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, activity);
        this.f31499j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public long getExpirationTimestamp() {
        return this.xt.longValue(120004);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public int getInteractionType() {
        return this.xt.intValue(120001);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public Map<String, Object> getMediaExtraInfo() {
        return (Map) this.xt.objectValue(120002, Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public MediationRewardManager getMediationManager() {
        Object apply;
        SparseArray sparseArray = new SparseArray(2);
        sparseArray.put(-99999987, 121109);
        sparseArray.put(-99999985, a.a());
        apply = this.f31499j.apply(sparseArray);
        return new com.bytedance.sdk.openadsdk.mediation.manager.j.j.j.up(az.j(apply));
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public int getRewardVideoAdType() {
        return this.xt.intValue(120003);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void loss(Double d6, String str, String str2) {
        SparseArray sparseArray = new SparseArray(5);
        sparseArray.put(-99999987, 210102);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, d6);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        this.f31499j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setAdInteractionListener(TTAdInteractionListener tTAdInteractionListener) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(-99999987, 210104);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, new com.bytedance.sdk.openadsdk.i.j.xt.xt(tTAdInteractionListener));
        this.f31499j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(-99999987, 120104);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, new com.bytedance.sdk.openadsdk.i.j.xt.cw(tTAppDownloadListener));
        this.f31499j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setPrice(Double d6) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(-99999987, 210103);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, d6);
        this.f31499j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setRewardAdInteractionListener(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(-99999987, 120101);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, new com.bytedance.sdk.openadsdk.a.j.j.j.j(rewardAdInteractionListener));
        this.f31499j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setRewardPlayAgainController(TTRewardVideoAd.RewardAdPlayAgainController rewardAdPlayAgainController) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(-99999987, 120103);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, new com.bytedance.sdk.openadsdk.a.j.j.j.xt(rewardAdPlayAgainController));
        this.f31499j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setRewardPlayAgainInteractionListener(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(-99999987, 120102);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, new com.bytedance.sdk.openadsdk.a.j.j.j.j(rewardAdInteractionListener));
        this.f31499j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void win(Double d6) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(-99999987, 210101);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, d6);
        this.f31499j.apply(sparseArray);
    }

    public ws(Function<SparseArray<Object>, Object> function) {
        Object apply;
        this.xt = com.bykv.j.j.j.j.a.f22763c;
        function = function == null ? com.bykv.j.j.j.j.a.f22765e : function;
        this.f31499j = function;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, -99999986);
        sparseArray.put(-99999985, SparseArray.class);
        apply = function.apply(sparseArray);
        if (apply instanceof SparseArray) {
            this.xt = com.bykv.j.j.j.j.a.j((SparseArray) apply).k();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void showRewardVideoAd(Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        SparseArray sparseArray = new SparseArray(5);
        sparseArray.put(-99999987, 120106);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, activity);
        sparseArray.put(1, ritScenes == null ? null : ritScenes.getScenesName());
        sparseArray.put(2, str);
        this.f31499j.apply(sparseArray);
    }
}
