package com.bytedance.sdk.openadsdk.mediation.ad.j.j.j;

import android.app.Activity;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.j.j.j.j.a;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.DislikeInfo;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.i.j.j.ae;
import com.bytedance.sdk.openadsdk.i.j.j.az;
import com.bytedance.sdk.openadsdk.i.j.j.r;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo;
import com.bytedance.sdk.openadsdk.mediation.ad.j.j.xt.up;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements IMediationNativeAdInfo {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f31654j;
    private ValueSet xt;

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public MediationAdDislike getDislikeDialog(Activity activity) {
        Object apply;
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(-99999987, 268102);
        sparseArray.put(-99999985, Object.class);
        sparseArray.put(0, activity);
        apply = this.f31654j.apply(sparseArray);
        return new xt(az.j(apply));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public String getActionText() {
        Object apply;
        SparseArray sparseArray = new SparseArray(2);
        sparseArray.put(-99999987, 268005);
        sparseArray.put(-99999985, String.class);
        apply = this.f31654j.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public int getAdImageMode() {
        Object apply;
        SparseArray sparseArray = new SparseArray(2);
        sparseArray.put(-99999987, 268009);
        sparseArray.put(-99999985, Integer.TYPE);
        apply = this.f31654j.apply(sparseArray);
        return ((Integer) apply).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public String getDescription() {
        Object apply;
        SparseArray sparseArray = new SparseArray(2);
        sparseArray.put(-99999987, 268002);
        sparseArray.put(-99999985, String.class);
        apply = this.f31654j.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public TTAdDislike getDislikeDialog2(Activity activity) {
        Object apply;
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(-99999987, 268018);
        sparseArray.put(-99999985, Object.class);
        sparseArray.put(0, activity);
        apply = this.f31654j.apply(sparseArray);
        return new ae(az.j(apply));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public DislikeInfo getDislikeInfo() {
        Object apply;
        SparseArray sparseArray = new SparseArray(1);
        sparseArray.put(-99999987, 268020);
        sparseArray.put(-99999985, Object.class);
        apply = this.f31654j.apply(sparseArray);
        return new r(az.j(apply));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public String getIconUrl() {
        Object apply;
        SparseArray sparseArray = new SparseArray(2);
        sparseArray.put(-99999987, 268003);
        sparseArray.put(-99999985, String.class);
        apply = this.f31654j.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public List<String> getImageList() {
        Object apply;
        SparseArray sparseArray = new SparseArray(2);
        sparseArray.put(-99999987, 268007);
        sparseArray.put(-99999985, List.class);
        apply = this.f31654j.apply(sparseArray);
        return (List) apply;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public String getImageUrl() {
        Object apply;
        SparseArray sparseArray = new SparseArray(2);
        sparseArray.put(-99999987, 268004);
        sparseArray.put(-99999985, String.class);
        apply = this.f31654j.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public int getInteractionType() {
        Object apply;
        SparseArray sparseArray = new SparseArray(2);
        sparseArray.put(-99999987, 268010);
        sparseArray.put(-99999985, Integer.TYPE);
        apply = this.f31654j.apply(sparseArray);
        return ((Integer) apply).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public MediationNativeAdAppInfo getNativeAdAppInfo() {
        return new cw(az.j(this.xt.objectValue(268101, Object.class)));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public String getSource() {
        Object apply;
        SparseArray sparseArray = new SparseArray(2);
        sparseArray.put(-99999987, 268008);
        sparseArray.put(-99999985, String.class);
        apply = this.f31654j.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public double getStarRating() {
        Object apply;
        SparseArray sparseArray = new SparseArray(2);
        sparseArray.put(-99999987, 268006);
        sparseArray.put(-99999985, String.class);
        apply = this.f31654j.apply(sparseArray);
        return ((Double) apply).doubleValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public String getTitle() {
        Object apply;
        SparseArray sparseArray = new SparseArray(2);
        sparseArray.put(-99999987, 268001);
        sparseArray.put(-99999985, String.class);
        apply = this.f31654j.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public boolean hasDislike() {
        Object apply;
        SparseArray sparseArray = new SparseArray(2);
        sparseArray.put(-99999987, 268012);
        sparseArray.put(-99999985, Boolean.TYPE);
        apply = this.f31654j.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public void registerView(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, IMediationViewBinder iMediationViewBinder) {
        SparseArray sparseArray = new SparseArray(8);
        sparseArray.put(-99999987, 268011);
        sparseArray.put(0, activity);
        sparseArray.put(1, viewGroup);
        sparseArray.put(2, list);
        sparseArray.put(3, list2);
        sparseArray.put(4, list3);
        sparseArray.put(5, new up(iMediationViewBinder));
        sparseArray.put(-99999985, Void.class);
        this.f31654j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        SparseArray sparseArray = new SparseArray(4);
        sparseArray.put(-99999987, 268016);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, activity);
        sparseArray.put(1, new com.bytedance.sdk.openadsdk.kt.j.j.j.j(dislikeInteractionCallback));
        this.f31654j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        SparseArray sparseArray = new SparseArray(4);
        sparseArray.put(-99999987, 268017);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, tTDislikeDialogAbstract);
        sparseArray.put(1, az.j(tTDislikeDialogAbstract.getTTDislikeListViewIds()));
        this.f31654j.apply(sparseArray);
    }

    public j(Function<SparseArray<Object>, Object> function) {
        Object apply;
        this.xt = a.f22763c;
        function = function == null ? a.f22765e : function;
        this.f31654j = function;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, -99999986);
        sparseArray.put(-99999985, SparseArray.class);
        apply = function.apply(sparseArray);
        if (apply instanceof SparseArray) {
            this.xt = a.j((SparseArray) apply).k();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public MediationAdDislike getDislikeDialog(Activity activity, Map<String, Object> map) {
        Object apply;
        SparseArray sparseArray = new SparseArray(4);
        sparseArray.put(-99999987, 268103);
        sparseArray.put(-99999985, Object.class);
        sparseArray.put(0, activity);
        sparseArray.put(1, map);
        apply = this.f31654j.apply(sparseArray);
        return new xt(az.j(apply));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public TTAdDislike getDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        Object apply;
        SparseArray sparseArray = new SparseArray(4);
        sparseArray.put(-99999987, 268019);
        sparseArray.put(-99999985, Object.class);
        sparseArray.put(0, tTDislikeDialogAbstract);
        sparseArray.put(1, az.j(tTDislikeDialogAbstract.getTTDislikeListViewIds()));
        apply = this.f31654j.apply(sparseArray);
        return new ae(az.j(apply));
    }
}
