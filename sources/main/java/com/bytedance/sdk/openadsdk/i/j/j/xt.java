package com.bytedance.sdk.openadsdk.i.j.j;

import a1.a;
import android.app.Activity;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationSplashManager;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt implements CSJSplashAd {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f31500j;
    private ValueSet xt;

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public int getInteractionType() {
        return this.xt.intValue(110004);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public Map<String, Object> getMediaExtraInfo() {
        return (Map) this.xt.objectValue(110005, Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public MediationSplashManager getMediationManager() {
        Object apply;
        SparseArray sparseArray = new SparseArray(2);
        sparseArray.put(-99999987, 110110);
        sparseArray.put(-99999985, a.a());
        apply = this.f31500j.apply(sparseArray);
        return new com.bytedance.sdk.openadsdk.mediation.manager.j.j.j.m(az.j(apply));
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public View getSplashCardView() {
        return (View) this.xt.objectValue(110003, View.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public View getSplashView() {
        return (View) this.xt.objectValue(110001, View.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void hideSkipButton() {
        SparseArray sparseArray = new SparseArray(2);
        sparseArray.put(-99999987, 110101);
        sparseArray.put(-99999985, Void.class);
        this.f31500j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void loss(Double d6, String str, String str2) {
        SparseArray sparseArray = new SparseArray(5);
        sparseArray.put(-99999987, 210102);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, d6);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        this.f31500j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setAdInteractionListener(TTAdInteractionListener tTAdInteractionListener) {
        SparseArray sparseArray = new SparseArray(4);
        sparseArray.put(-99999987, 210104);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, new com.bytedance.sdk.openadsdk.i.j.xt.xt(tTAdInteractionListener));
        this.f31500j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(-99999987, 110102);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, new com.bytedance.sdk.openadsdk.i.j.xt.cw(tTAppDownloadListener));
        this.f31500j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setPrice(Double d6) {
        SparseArray sparseArray = new SparseArray(4);
        sparseArray.put(-99999987, 210103);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, d6);
        this.f31500j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void setSplashAdListener(CSJSplashAd.SplashAdListener splashAdListener) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(-99999987, 110103);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, new com.bytedance.sdk.openadsdk.r.j.j.j.j(splashAdListener));
        this.f31500j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void setSplashCardListener(CSJSplashAd.SplashCardListener splashCardListener) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(-99999987, 110106);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, new com.bytedance.sdk.openadsdk.r.j.j.j.xt(splashCardListener));
        this.f31500j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void showSplashCardView(ViewGroup viewGroup, Activity activity) {
        SparseArray sparseArray = new SparseArray(4);
        sparseArray.put(-99999987, 110109);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, viewGroup);
        sparseArray.put(1, activity);
        this.f31500j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void showSplashView(ViewGroup viewGroup) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(-99999987, 110108);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, viewGroup);
        this.f31500j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void win(Double d6) {
        SparseArray sparseArray = new SparseArray(4);
        sparseArray.put(-99999987, 210101);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, d6);
        this.f31500j.apply(sparseArray);
    }

    public xt(Function<SparseArray<Object>, Object> function) {
        Object apply;
        this.xt = com.bykv.j.j.j.j.a.f22763c;
        function = function == null ? com.bykv.j.j.j.j.a.f22765e : function;
        this.f31500j = function;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, -99999986);
        sparseArray.put(-99999985, SparseArray.class);
        apply = function.apply(sparseArray);
        if (apply instanceof SparseArray) {
            this.xt = com.bykv.j.j.j.j.a.j((SparseArray) apply).k();
        }
    }
}
