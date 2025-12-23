package com.bytedance.sdk.openadsdk.i.j.j;

import android.app.Activity;
import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.mediation.IMediationInterstitialFullAdListener;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationFullScreenManager;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class oq implements TTFullScreenVideoAd {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f31493j;
    private ValueSet xt;

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void showFullScreenVideoAd(Activity activity) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(-99999987, 130103);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, activity);
        this.f31493j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public long getExpirationTimestamp() {
        return this.xt.longValue(130004);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public int getFullVideoAdType() {
        return this.xt.intValue(130003);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public int getInteractionType() {
        return this.xt.intValue(130001);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public Map<String, Object> getMediaExtraInfo() {
        return (Map) this.xt.objectValue(130002, Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public MediationFullScreenManager getMediationManager() {
        Object apply;
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(-99999987, 130106);
        sparseArray.put(-99999985, Object.class);
        apply = this.f31493j.apply(sparseArray);
        return new com.bytedance.sdk.openadsdk.mediation.manager.j.j.j.cw(az.j(apply));
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void loss(Double d6, String str, String str2) {
        SparseArray sparseArray = new SparseArray(5);
        sparseArray.put(-99999987, 210102);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, d6);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        this.f31493j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setAdInteractionListener(TTAdInteractionListener tTAdInteractionListener) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(-99999987, 210104);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, new com.bytedance.sdk.openadsdk.i.j.xt.xt(tTAdInteractionListener));
        this.f31493j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(-99999987, 130102);
        sparseArray.put(0, new com.bytedance.sdk.openadsdk.i.j.xt.cw(tTAppDownloadListener));
        sparseArray.put(-99999985, Void.class);
        this.f31493j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setFullScreenVideoAdInteractionListener(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        SparseArray sparseArray = new SparseArray(4);
        sparseArray.put(-99999987, 130101);
        sparseArray.put(-99999985, Void.class);
        if (fullScreenVideoAdInteractionListener instanceof IMediationInterstitialFullAdListener) {
            sparseArray.put(0, new com.bytedance.sdk.openadsdk.mediation.xt.j.xt.xt((IMediationInterstitialFullAdListener) fullScreenVideoAdInteractionListener));
            sparseArray.put(1, 1);
        } else {
            sparseArray.put(0, new com.bytedance.sdk.openadsdk.x.j.j.j.j(fullScreenVideoAdInteractionListener));
            sparseArray.put(1, 0);
        }
        this.f31493j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setPrice(Double d6) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(-99999987, 210103);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, d6);
        this.f31493j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void win(Double d6) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(-99999987, 210101);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, d6);
        this.f31493j.apply(sparseArray);
    }

    public oq(Function<SparseArray<Object>, Object> function) {
        Object apply;
        this.xt = a.f22763c;
        function = function == null ? a.f22765e : function;
        this.f31493j = function;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, -99999986);
        sparseArray.put(-99999985, SparseArray.class);
        apply = function.apply(sparseArray);
        if (apply instanceof SparseArray) {
            this.xt = a.j((SparseArray) apply).k();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void showFullScreenVideoAd(Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        SparseArray sparseArray = new SparseArray(5);
        sparseArray.put(-99999987, 130104);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, activity);
        sparseArray.put(1, ritScenes == null ? null : ritScenes.getScenesName());
        sparseArray.put(2, str);
        this.f31493j.apply(sparseArray);
    }
}
