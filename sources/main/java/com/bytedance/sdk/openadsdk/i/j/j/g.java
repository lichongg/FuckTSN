package com.bytedance.sdk.openadsdk.i.j.j;

import a1.a;
import android.app.Activity;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.ComplianceInfo;
import com.bytedance.sdk.openadsdk.DislikeInfo;
import com.bytedance.sdk.openadsdk.DownloadStatusController;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationNativeManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class g implements TTFeedAd {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f31487j;
    private ValueSet xt;

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTAdDislike getDislikeDialog(Activity activity) {
        Object apply;
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(-99999987, 140101);
        sparseArray.put(-99999985, Object.class);
        sparseArray.put(0, activity);
        apply = this.f31487j.apply(sparseArray);
        return new ae(az.j(apply));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        SparseArray sparseArray = new SparseArray(5);
        sparseArray.put(-99999987, 140103);
        sparseArray.put(0, viewGroup);
        sparseArray.put(1, view);
        sparseArray.put(2, new com.bytedance.sdk.openadsdk.ch.j.j.j.j(adInteractionListener));
        sparseArray.put(-99999985, Void.class);
        this.f31487j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void destroy() {
        SparseArray sparseArray = new SparseArray(2);
        sparseArray.put(-99999987, 140114);
        sparseArray.put(-99999985, Void.class);
        this.f31487j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public Bitmap getAdLogo() {
        return (Bitmap) this.xt.objectValue(140002, Bitmap.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public View getAdView() {
        View view = (View) this.xt.objectValue(140016, View.class);
        com.bytedance.sdk.openadsdk.api.m.up("wzj", "1-ApiFeed:view=".concat(String.valueOf(view)));
        return view;
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd
    public int getAdViewHeight() {
        return this.xt.intValue(160004);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd
    public int getAdViewWidth() {
        return this.xt.intValue(160003);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getAppCommentNum() {
        return this.xt.intValue(140006);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getAppScore() {
        return this.xt.intValue(140005);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getAppSize() {
        return this.xt.intValue(140007);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getButtonText() {
        return this.xt.stringValue(140018);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public ComplianceInfo getComplianceInfo() {
        return new cw(az.j(this.xt.objectValue(140014, Object.class)));
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd
    public TTFeedAd.CustomizeVideo getCustomVideo() {
        return new com.bytedance.sdk.openadsdk.v.j.j.j.j(az.j(this.xt.objectValue(160002, Object.class)));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getDescription() {
        return this.xt.stringValue(140004);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public DislikeInfo getDislikeInfo() {
        return new r(az.j(this.xt.objectValue(140013, Object.class)));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public DownloadStatusController getDownloadStatusController() {
        return new up(az.j(this.xt.objectValue(140015, Object.class)));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTImage getIcon() {
        return new qv(az.j(this.xt.objectValue(140009, Object.class)));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public List<TTImage> getImageList() {
        List list = (List) this.xt.objectValue(140010, List.class);
        if (list == null) {
            list = new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new qv(az.j(it.next())));
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getImageMode() {
        return this.xt.intValue(140012);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getInteractionType() {
        return this.xt.intValue(140011);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public Map<String, Object> getMediaExtraInfo() {
        return (Map) this.xt.objectValue(140017, Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public MediationNativeManager getMediationManager() {
        Object apply;
        SparseArray sparseArray = new SparseArray(2);
        sparseArray.put(-99999987, 140116);
        sparseArray.put(-99999985, a.a());
        apply = this.f31487j.apply(sparseArray);
        return new com.bytedance.sdk.openadsdk.mediation.manager.j.j.j.r(az.j(apply));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getSource() {
        return this.xt.stringValue(140008);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getTitle() {
        return this.xt.stringValue(140003);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTImage getVideoCoverImage() {
        return new qv(az.j(this.xt.objectValue(140001, Object.class)));
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd
    public double getVideoDuration() {
        return this.xt.doubleValue(160001);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void loss(Double d6, String str, String str2) {
        SparseArray sparseArray = new SparseArray(5);
        sparseArray.put(-99999987, 210102);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, d6);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        this.f31487j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void render() {
        SparseArray sparseArray = new SparseArray(2);
        sparseArray.put(-99999987, 140110);
        sparseArray.put(-99999985, Void.class);
        this.f31487j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setActivityForDownloadApp(Activity activity) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(-99999987, 140109);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, activity);
        this.f31487j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setAdInteractionListener(TTAdInteractionListener tTAdInteractionListener) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(-99999987, 210104);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, new com.bytedance.sdk.openadsdk.i.j.xt.xt(tTAdInteractionListener));
        this.f31487j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        SparseArray sparseArray = new SparseArray(4);
        sparseArray.put(-99999987, 140112);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, activity);
        sparseArray.put(1, new com.bytedance.sdk.openadsdk.kt.j.j.j.j(dislikeInteractionCallback));
        this.f31487j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        SparseArray sparseArray = new SparseArray(4);
        sparseArray.put(-99999987, 140113);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, tTDislikeDialogAbstract);
        sparseArray.put(1, az.j(tTDislikeDialogAbstract.getTTDislikeListViewIds()));
        this.f31487j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(-99999987, 140108);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, new com.bytedance.sdk.openadsdk.i.j.xt.cw(tTAppDownloadListener));
        this.f31487j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setEasyPlayWidgetListener(TTNativeAd.EasyPlayWidgetListener easyPlayWidgetListener) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(-99999987, 140119);
        sparseArray.put(0, new com.bytedance.sdk.openadsdk.ch.j.j.j.xt(easyPlayWidgetListener));
        sparseArray.put(-99999985, Void.class);
        this.f31487j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setExpressRenderListener(TTNativeAd.ExpressRenderListener expressRenderListener) {
        SparseArray sparseArray = new SparseArray(4);
        sparseArray.put(-99999987, 140111);
        sparseArray.put(-99999985, Void.class);
        if (expressRenderListener instanceof MediationExpressRenderListener) {
            sparseArray.put(0, new com.bytedance.sdk.openadsdk.mediation.ad.j.j.xt.m((MediationExpressRenderListener) expressRenderListener));
            sparseArray.put(1, 1);
        } else {
            sparseArray.put(0, new com.bytedance.sdk.openadsdk.ch.j.j.j.cw(expressRenderListener));
            sparseArray.put(1, 0);
        }
        this.f31487j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setPrice(Double d6) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(-99999987, 210103);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, d6);
        this.f31487j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd
    public void setVideoAdListener(TTFeedAd.VideoAdListener videoAdListener) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(-99999987, 160101);
        sparseArray.put(0, new com.bytedance.sdk.openadsdk.v.j.j.xt.j(videoAdListener));
        sparseArray.put(-99999985, Void.class);
        this.f31487j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd
    public void setVideoRewardListener(TTFeedAd.VideoRewardListener videoRewardListener) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(-99999987, 160102);
        sparseArray.put(0, new com.bytedance.sdk.openadsdk.v.j.j.xt.xt(videoRewardListener));
        sparseArray.put(-99999985, Void.class);
        this.f31487j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void showInteractionExpressAd(Activity activity) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(-99999987, 140115);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, activity);
        this.f31487j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void uploadDislikeEvent(String str) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(-99999987, 140118);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, str);
        this.f31487j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void win(Double d6) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(-99999987, 210101);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, d6);
        this.f31487j.apply(sparseArray);
    }

    public g(Function<SparseArray<Object>, Object> function) {
        Object apply;
        this.xt = com.bykv.j.j.j.j.a.f22763c;
        function = function == null ? com.bykv.j.j.j.j.a.f22765e : function;
        this.f31487j = function;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, -99999986);
        sparseArray.put(-99999985, SparseArray.class);
        apply = function.apply(sparseArray);
        if (apply instanceof SparseArray) {
            this.xt = com.bykv.j.j.j.j.a.j((SparseArray) apply).k();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTAdDislike getDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        Object apply;
        SparseArray sparseArray = new SparseArray(4);
        sparseArray.put(-99999987, 140102);
        sparseArray.put(-99999985, Object.class);
        sparseArray.put(0, tTDislikeDialogAbstract);
        sparseArray.put(1, az.j(tTDislikeDialogAbstract.getTTDislikeListViewIds()));
        apply = this.f31487j.apply(sparseArray);
        return new ae(az.j(apply));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, TTNativeAd.AdInteractionListener adInteractionListener) {
        SparseArray sparseArray = new SparseArray(6);
        sparseArray.put(-99999987, 140104);
        sparseArray.put(0, viewGroup);
        sparseArray.put(1, list);
        sparseArray.put(2, list2);
        sparseArray.put(3, new com.bytedance.sdk.openadsdk.ch.j.j.j.j(adInteractionListener));
        sparseArray.put(-99999985, Void.class);
        this.f31487j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        SparseArray sparseArray = new SparseArray(7);
        sparseArray.put(-99999987, 140105);
        sparseArray.put(0, viewGroup);
        sparseArray.put(1, list);
        sparseArray.put(2, list2);
        sparseArray.put(3, view);
        sparseArray.put(4, new com.bytedance.sdk.openadsdk.ch.j.j.j.j(adInteractionListener));
        sparseArray.put(-99999985, Void.class);
        this.f31487j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        SparseArray sparseArray = new SparseArray(8);
        sparseArray.put(-99999987, 140106);
        sparseArray.put(0, viewGroup);
        sparseArray.put(1, list);
        sparseArray.put(2, list2);
        sparseArray.put(3, list3);
        sparseArray.put(4, view);
        sparseArray.put(5, new com.bytedance.sdk.openadsdk.ch.j.j.j.j(adInteractionListener));
        sparseArray.put(-99999985, Void.class);
        this.f31487j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        SparseArray sparseArray = new SparseArray(9);
        sparseArray.put(-99999987, 140107);
        sparseArray.put(0, viewGroup);
        sparseArray.put(1, list);
        sparseArray.put(2, list2);
        sparseArray.put(3, list3);
        sparseArray.put(4, list4);
        sparseArray.put(5, view);
        sparseArray.put(6, new com.bytedance.sdk.openadsdk.ch.j.j.j.j(adInteractionListener));
        sparseArray.put(-99999985, Void.class);
        this.f31487j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, TTNativeAd.AdInteractionListener adInteractionListener, IMediationViewBinder iMediationViewBinder) {
        SparseArray sparseArray = new SparseArray(9);
        sparseArray.put(-99999987, 140117);
        sparseArray.put(0, activity);
        sparseArray.put(1, viewGroup);
        sparseArray.put(2, list);
        sparseArray.put(3, list2);
        sparseArray.put(4, list3);
        sparseArray.put(5, new com.bytedance.sdk.openadsdk.ch.j.j.j.j(adInteractionListener));
        sparseArray.put(6, new com.bytedance.sdk.openadsdk.mediation.ad.j.j.xt.up(iMediationViewBinder));
        sparseArray.put(-99999985, Void.class);
        this.f31487j.apply(sparseArray);
    }
}
