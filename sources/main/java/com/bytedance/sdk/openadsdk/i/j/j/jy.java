package com.bytedance.sdk.openadsdk.i.j.j;

import a1.a;
import a1.b;
import android.app.Activity;
import android.util.SparseArray;
import android.view.View;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.DislikeInfo;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationNativeManager;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class jy implements TTNativeExpressAd {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f31491j;
    private ValueSet xt;

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setExpressInteractionListener(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(-99999987, 150101);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, new com.bytedance.sdk.openadsdk.s.j.j.j.xt(expressAdInteractionListener));
        this.f31491j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void destroy() {
        SparseArray sparseArray = new SparseArray(2);
        sparseArray.put(-99999987, 150105);
        sparseArray.put(-99999985, Void.class);
        this.f31491j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public TTAdDislike getDislikeDialog(Activity activity) {
        Object apply;
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(-99999987, 150108);
        sparseArray.put(-99999985, a.a());
        sparseArray.put(0, activity);
        apply = this.f31491j.apply(sparseArray);
        return new ae(az.j(apply));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public DislikeInfo getDislikeInfo() {
        return new r(b.a(this.xt.objectValue(150003, a.a())));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public View getExpressAdView() {
        return (View) this.xt.objectValue(150001, View.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public int getImageMode() {
        return this.xt.intValue(150002);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public int getInteractionType() {
        return this.xt.intValue(150004);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public Map<String, Object> getMediaExtraInfo() {
        return (Map) this.xt.objectValue(150005, Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public MediationNativeManager getMediationManager() {
        Object apply;
        SparseArray sparseArray = new SparseArray(2);
        sparseArray.put(-99999987, 150113);
        sparseArray.put(-99999985, a.a());
        apply = this.f31491j.apply(sparseArray);
        return new com.bytedance.sdk.openadsdk.mediation.manager.j.j.j.r(az.j(apply));
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void loss(Double d6, String str, String str2) {
        SparseArray sparseArray = new SparseArray(5);
        sparseArray.put(-99999987, 210102);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, d6);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        this.f31491j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void registerClickableRects(JSONObject jSONObject) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(-99999987, 150115);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, jSONObject);
        this.f31491j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void render() {
        SparseArray sparseArray = new SparseArray(2);
        sparseArray.put(-99999987, 150104);
        sparseArray.put(-99999985, Void.class);
        this.f31491j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setAdInteractionListener(TTAdInteractionListener tTAdInteractionListener) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(-99999987, 210104);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, new com.bytedance.sdk.openadsdk.i.j.xt.xt(tTAdInteractionListener));
        this.f31491j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setCanInterruptVideoPlay(boolean z5) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(-99999987, 150112);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, Boolean.valueOf(z5));
        this.f31491j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        SparseArray sparseArray = new SparseArray(4);
        sparseArray.put(-99999987, 150106);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, activity);
        sparseArray.put(1, new com.bytedance.sdk.openadsdk.kt.j.j.j.j(dislikeInteractionCallback));
        this.f31491j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        SparseArray sparseArray = new SparseArray(4);
        sparseArray.put(-99999987, 150107);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, tTDislikeDialogAbstract);
        sparseArray.put(1, az.j(tTDislikeDialogAbstract.getTTDislikeListViewIds()));
        this.f31491j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(-99999987, 150103);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, new com.bytedance.sdk.openadsdk.i.j.xt.cw(tTAppDownloadListener));
        this.f31491j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setPrice(Double d6) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(-99999987, 210103);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, d6);
        this.f31491j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setSlideIntervalTime(int i6) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(-99999987, 150110);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, Integer.valueOf(i6));
        this.f31491j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setVideoAdListener(TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(-99999987, 150111);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, new com.bytedance.sdk.openadsdk.s.j.j.j.cw(expressVideoAdListener));
        this.f31491j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void showInteractionExpressAd(Activity activity) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(-99999987, 150109);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, activity);
        this.f31491j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void unRegisterRects() {
        SparseArray sparseArray = new SparseArray(2);
        sparseArray.put(-99999987, 150116);
        sparseArray.put(-99999985, Void.class);
        this.f31491j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void uploadDislikeEvent(String str) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(-99999987, 150114);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, str);
        this.f31491j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void win(Double d6) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(-99999987, 210101);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, d6);
        this.f31491j.apply(sparseArray);
    }

    public jy(Function<SparseArray<Object>, Object> function) {
        Object apply;
        this.xt = com.bykv.j.j.j.j.a.f22763c;
        function = function == null ? com.bykv.j.j.j.j.a.f22765e : function;
        this.f31491j = function;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, -99999986);
        sparseArray.put(-99999985, SparseArray.class);
        apply = function.apply(sparseArray);
        if (apply instanceof SparseArray) {
            this.xt = com.bykv.j.j.j.j.a.j((SparseArray) apply).k();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setExpressInteractionListener(TTNativeExpressAd.AdInteractionListener adInteractionListener) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(-99999987, 150102);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, new com.bytedance.sdk.openadsdk.s.j.j.j.j(adInteractionListener));
        this.f31491j.apply(sparseArray);
    }
}
