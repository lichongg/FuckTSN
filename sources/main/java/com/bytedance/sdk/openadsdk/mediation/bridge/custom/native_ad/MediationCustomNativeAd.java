package com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad;

import android.app.Activity;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.api.m;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationViewBinder;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationValueUtil;
import com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomNativeDislikeDialog;
import com.bytedance.sdk.openadsdk.mediation.j.j;
import com.bytedance.sdk.openadsdk.mediation.j.xt;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class MediationCustomNativeAd extends j implements IMediationCustomNativeAd {
    private int ae;
    private boolean av;
    private String az;
    private String cw;

    /* renamed from: g, reason: collision with root package name */
    private String f31685g;

    /* renamed from: i, reason: collision with root package name */
    private int f31686i;

    /* renamed from: j, reason: collision with root package name */
    private double f31687j;
    private double jy;
    private Function kt;

    /* renamed from: m, reason: collision with root package name */
    private String f31688m;
    private MediationNativeAdAppInfo mi;
    private String oq;
    private int qv;

    /* renamed from: r, reason: collision with root package name */
    private String f31689r;
    private MediationCustomNativeDislikeDialog tj;
    private int tl;
    private String up;
    private int vl;

    /* renamed from: w, reason: collision with root package name */
    private int f31690w;
    private List<String> ws;
    private Map<String, Object> xt;

    private Integer j() {
        MediationConstant.AdIsReadyStatus isReadyCondition = isReadyCondition();
        if (isReadyCondition == MediationConstant.AdIsReadyStatus.ADN_NO_READY_API) {
            return 1;
        }
        if (isReadyCondition == MediationConstant.AdIsReadyStatus.AD_IS_READY) {
            return 2;
        }
        if (isReadyCondition == MediationConstant.AdIsReadyStatus.AD_IS_EXPIRED) {
            return 3;
        }
        return isReadyCondition == MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY ? 4 : 1;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public View getExpressView() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public TTFeedAd.CustomizeVideo getNativeCustomVideoReporter() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public String getVideoUrl() {
        return null;
    }

    public View getVideoView() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public boolean hasDislike() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.j.j
    public <T> T applyFunction(int i6, ValueSet valueSet, Class<T> cls) {
        MediationAdDislike dislikeDialog;
        if (i6 == 8127) {
            this.kt = xt.j(valueSet.objectValue(8034, Object.class));
        } else if (i6 == 6083) {
            render();
        } else {
            if (i6 == 6081) {
                return (T) getExpressView();
            }
            if (i6 == 8159) {
                registerView((Activity) valueSet.objectValue(20033, Activity.class), (ViewGroup) valueSet.objectValue(8067, ViewGroup.class), (List) valueSet.objectValue(8068, List.class), (List) valueSet.objectValue(8069, List.class), (List) valueSet.objectValue(8070, List.class), BridgeUtil.buildViewBinder(xt.j(valueSet.objectValue(8071, Object.class))));
            } else {
                if (i6 == 8135) {
                    return (T) Boolean.valueOf(hasDislike());
                }
                if (i6 == 8149) {
                    onPause();
                } else if (i6 == 8148) {
                    onResume();
                } else if (i6 == 8109) {
                    onDestroy();
                } else {
                    if (i6 == 8121) {
                        return (T) j();
                    }
                    if (i6 == 8194) {
                        String stringValue = valueSet.stringValue(8036, null);
                        Map<String, Object> map = (Map) valueSet.objectValue(8075, Map.class);
                        MediationCustomNativeDislikeDialog mediationCustomNativeDislikeDialog = this.tj;
                        if (mediationCustomNativeDislikeDialog != null) {
                            mediationCustomNativeDislikeDialog.dislikeClick(stringValue, map);
                        }
                    } else if (i6 == 6072) {
                        Activity activity = (Activity) valueSet.objectValue(20033, Activity.class);
                        Map<String, Object> map2 = (Map) valueSet.objectValue(8075, Map.class);
                        MediationCustomNativeDislikeDialog mediationCustomNativeDislikeDialog2 = this.tj;
                        if (mediationCustomNativeDislikeDialog2 != null && (dislikeDialog = mediationCustomNativeDislikeDialog2.getDislikeDialog(activity, map2)) != null) {
                            return (T) new com.bytedance.sdk.openadsdk.mediation.xt.j.xt(dislikeDialog);
                        }
                    } else {
                        if (i6 == 8320) {
                            return (T) new MediationCustomizeVideoImpl(getNativeCustomVideoReporter());
                        }
                        if (i6 == 8228) {
                            return (T) getVideoUrl();
                        }
                        if (i6 == 8225) {
                            m.cw(MediationConstant.TAG, "MediationCustomNativeAd receiveBidResult");
                            receiveBidResult(valueSet.booleanValue(8406), valueSet.doubleValue(8407), valueSet.intValue(8408), (Map) valueSet.objectValue(8075, Map.class));
                        } else if (i6 == 6164) {
                            return (T) getVideoView();
                        }
                    }
                }
            }
        }
        return (T) MediationValueUtil.checkClassType(cls);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callAdClick() {
        if (this.kt != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8130);
            sparseArray.put(-99999985, Void.class);
            this.kt.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callAdShow() {
        if (this.kt != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8113);
            sparseArray.put(-99999985, Void.class);
            this.kt.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callDislikeCancel() {
        if (this.kt != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8184);
            sparseArray.put(-99999985, Void.class);
            this.kt.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callDislikeSelected(int i6, String str) {
        if (this.kt != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8132);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8038, Integer.valueOf(i6));
            sparseArray.put(8039, str);
            this.kt.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callDislikeShow() {
        if (this.kt != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8185);
            sparseArray.put(-99999985, Void.class);
            this.kt.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callOnDownloadActive(long j6, long j7) {
        if (this.kt != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8187);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8062, Long.valueOf(j6));
            sparseArray.put(8063, Long.valueOf(j7));
            this.kt.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callOnDownloadFailed(long j6, long j7, String str, String str2) {
        if (this.kt != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8157);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8062, Long.valueOf(j6));
            sparseArray.put(8063, Long.valueOf(j7));
            sparseArray.put(8066, str);
            sparseArray.put(8056, str2);
            this.kt.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callOnDownloadFinished(long j6, String str, String str2) {
        if (this.kt != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8155);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8062, Long.valueOf(j6));
            sparseArray.put(8066, str);
            sparseArray.put(8056, str2);
            this.kt.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callOnDownloadPaused(long j6, long j7, String str, String str2) {
        if (this.kt != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8158);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8062, Long.valueOf(j6));
            sparseArray.put(8063, Long.valueOf(j7));
            sparseArray.put(8066, str);
            sparseArray.put(8056, str2);
            this.kt.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callOnIdle() {
        if (this.kt != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8152);
            sparseArray.put(-99999985, Void.class);
            this.kt.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callOnInstalled(String str, String str2) {
        if (this.kt != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8156);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8066, str);
            sparseArray.put(8056, str2);
            this.kt.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callRenderFail(View view, int i6, String str) {
        if (this.kt != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8134);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8042, view);
            sparseArray.put(8014, Integer.valueOf(i6));
            sparseArray.put(8015, str);
            this.kt.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callRenderSuccess(float f6, float f7) {
        if (this.kt != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8133);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8040, Float.valueOf(f6));
            sparseArray.put(8041, Float.valueOf(f7));
            this.kt.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callVideoCompleted() {
        if (this.kt != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8118);
            sparseArray.put(-99999985, Void.class);
            this.kt.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callVideoError(int i6, String str) {
        if (this.kt != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8117);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8014, Integer.valueOf(i6));
            sparseArray.put(8015, str);
            this.kt.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callVideoPause() {
        if (this.kt != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8146);
            sparseArray.put(-99999985, Void.class);
            this.kt.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callVideoProgressUpdate(long j6, long j7) {
        if (this.kt != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8154);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8072, Long.valueOf(j6));
            sparseArray.put(8073, Long.valueOf(j7));
            this.kt.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callVideoResume() {
        if (this.kt != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8150);
            sparseArray.put(-99999985, Void.class);
            this.kt.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callVideoStart() {
        if (this.kt != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8145);
            sparseArray.put(-99999985, Void.class);
            this.kt.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public int getBiddingType() {
        Object apply;
        if (this.kt != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8226);
            sparseArray.put(-99999985, Integer.class);
            apply = this.kt.apply(sparseArray);
            Integer num = (Integer) apply;
            if (num != null) {
                return num.intValue();
            }
        }
        return 0;
    }

    public SparseArray<Object> getValues() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(8016, Double.valueOf(this.f31687j));
        sparseArray.put(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p, this.xt);
        sparseArray.put(8045, this.cw);
        sparseArray.put(8046, this.f31689r);
        sparseArray.put(8048, this.up);
        sparseArray.put(8050, this.f31688m);
        sparseArray.put(8051, Integer.valueOf(this.tl));
        sparseArray.put(8052, Integer.valueOf(this.ae));
        sparseArray.put(8061, this.f31685g);
        sparseArray.put(8054, this.oq);
        sparseArray.put(8420, Integer.valueOf(this.qv));
        sparseArray.put(8421, Integer.valueOf(this.vl));
        sparseArray.put(8082, Double.valueOf(this.jy));
        sparseArray.put(8053, this.ws);
        sparseArray.put(8049, this.az);
        sparseArray.put(8033, Boolean.valueOf(this.av));
        sparseArray.put(8060, Integer.valueOf(this.f31686i));
        sparseArray.put(8059, Integer.valueOf(this.f31690w));
        MediationNativeAdAppInfo mediationNativeAdAppInfo = this.mi;
        if (mediationNativeAdAppInfo != null) {
            sparseArray.put(8315, new MediationNativeAppInfoImpl(mediationNativeAdAppInfo));
        }
        return sparseArray;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public boolean isClientBidding() {
        Object apply;
        if (this.kt != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8110);
            sparseArray.put(-99999985, Boolean.class);
            apply = this.kt.apply(sparseArray);
            Boolean bool = (Boolean) apply;
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public MediationConstant.AdIsReadyStatus isReadyCondition() {
        return MediationConstant.AdIsReadyStatus.ADN_NO_READY_API;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public boolean isServerBidding() {
        Object apply;
        if (this.kt != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8136);
            sparseArray.put(-99999985, Boolean.class);
            apply = this.kt.apply(sparseArray);
            Boolean bool = (Boolean) apply;
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public boolean isUseCustomVideo() {
        Object apply;
        if (this.kt != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8160);
            sparseArray.put(-99999985, Boolean.class);
            apply = this.kt.apply(sparseArray);
            Boolean bool = (Boolean) apply;
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setActionText(String str) {
        this.f31685g = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setAdImageMode(int i6) {
        this.f31686i = i6;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setBiddingPrice(double d6) {
        this.f31687j = d6;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setDescription(String str) {
        this.f31689r = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setDislikeDialogCallBack(MediationCustomNativeDislikeDialog mediationCustomNativeDislikeDialog) {
        if (this.kt != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 6085);
            sparseArray.put(-99999985, Void.class);
            this.kt.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setExpressAd(boolean z5) {
        this.av = z5;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setIconUrl(String str) {
        this.up = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setImageHeight(int i6) {
        this.tl = i6;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setImageList(List<String> list) {
        this.ws = list;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setImageUrl(String str) {
        this.f31688m = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setImageWidth(int i6) {
        this.ae = i6;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setInteractionType(int i6) {
        this.f31690w = i6;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setMediaExtraInfo(Map<String, Object> map) {
        this.xt = map;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setNativeAdAppInfo(MediationNativeAdAppInfo mediationNativeAdAppInfo) {
        this.mi = mediationNativeAdAppInfo;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setPackageName(String str) {
        this.oq = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setSource(String str) {
        this.az = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setStarRating(double d6) {
        this.jy = d6;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setTitle(String str) {
        this.cw = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setVideoHeight(int i6) {
        this.vl = i6;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setVideoWidth(int i6) {
        this.qv = i6;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.j.j
    public SparseArray<Object> get() {
        return getValues();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void onDestroy() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void onPause() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void onResume() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void render() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void registerView(@Nullable Activity activity, @Nullable ViewGroup viewGroup, @Nullable List<View> list, @Nullable List<View> list2, @Nullable List<View> list3, @Nullable MediationViewBinder mediationViewBinder) {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void receiveBidResult(boolean z5, double d6, int i6, Map<String, Object> map) {
    }
}
