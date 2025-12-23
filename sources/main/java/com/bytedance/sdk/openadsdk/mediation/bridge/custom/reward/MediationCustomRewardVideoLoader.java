package com.bytedance.sdk.openadsdk.mediation.bridge.custom.reward;

import android.app.Activity;
import android.util.SparseArray;
import androidx.core.view.PointerIconCompat;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.api.m;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationRewardItem;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class MediationCustomRewardVideoLoader extends MediationCustomAdBaseLoader {
    public final void callLoadSuccess() {
        if (this.mGmAdLoader != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8107);
            sparseArray.put(-99999985, String.class);
            this.mGmAdLoader.apply(sparseArray);
        }
    }

    public abstract void showAd(Activity activity);

    public final void callAdVideoCache() {
        if (this.mGmAdLoader != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8112);
            sparseArray.put(-99999985, String.class);
            this.mGmAdLoader.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public <T> T callMethod(int i6, ValueSet valueSet, Class<T> cls) {
        if (i6 != 8113) {
            if (i6 != 8121) {
                return null;
            }
            m.cw(MediationConstant.TAG, "MediationCustomBaseLoader isReadyCondition");
            return (T) j(isReadyCondition());
        }
        m.cw(MediationConstant.TAG, "MediationCustomRewardVideoLoader showAd");
        Activity activity = (Activity) valueSet.objectValue(20033, Activity.class);
        if (activity == null) {
            return null;
        }
        showAd(activity);
        return null;
    }

    public final void callRewardVideoAdClick() {
        if (this.mGmAdLoader != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 1009);
            sparseArray.put(-99999985, String.class);
            this.mGmAdLoader.apply(sparseArray);
        }
    }

    public final void callRewardVideoAdClosed() {
        if (this.mGmAdLoader != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, Integer.valueOf(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW));
            sparseArray.put(-99999985, String.class);
            this.mGmAdLoader.apply(sparseArray);
        }
    }

    public final void callRewardVideoAdShow() {
        if (this.mGmAdLoader != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 1008);
            sparseArray.put(-99999985, String.class);
            this.mGmAdLoader.apply(sparseArray);
        }
    }

    public final void callRewardVideoComplete() {
        if (this.mGmAdLoader != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 1026);
            sparseArray.put(-99999985, String.class);
            this.mGmAdLoader.apply(sparseArray);
        }
    }

    public final void callRewardVideoError() {
        if (this.mGmAdLoader != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 1021);
            sparseArray.put(-99999985, String.class);
            this.mGmAdLoader.apply(sparseArray);
        }
    }

    public final void callRewardVideoRewardVerify(MediationRewardItem mediationRewardItem) {
        if (this.mGmAdLoader == null || mediationRewardItem == null) {
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, Integer.valueOf(PointerIconCompat.TYPE_ZOOM_IN));
        sparseArray.put(-99999985, String.class);
        sparseArray.put(8017, Boolean.valueOf(mediationRewardItem.rewardVerify()));
        sparseArray.put(8018, Float.valueOf(mediationRewardItem.getAmount()));
        sparseArray.put(8019, mediationRewardItem.getRewardName());
        sparseArray.put(8075, mediationRewardItem.getCustomData());
        this.mGmAdLoader.apply(sparseArray);
    }

    public final void callRewardVideoSkippedVideo() {
        if (this.mGmAdLoader != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 1037);
            sparseArray.put(-99999985, String.class);
            this.mGmAdLoader.apply(sparseArray);
        }
    }

    public MediationConstant.AdIsReadyStatus isReadyCondition() {
        return MediationConstant.AdIsReadyStatus.ADN_NO_READY_API;
    }

    public final void callLoadSuccess(double d6) {
        if (this.mGmAdLoader != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8107);
            sparseArray.put(-99999985, String.class);
            sparseArray.put(8409, Double.valueOf(d6));
            this.mGmAdLoader.apply(sparseArray);
        }
    }

    public final void callLoadSuccess(Map<String, Object> map) {
        if (this.mGmAdLoader != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8107);
            sparseArray.put(-99999985, String.class);
            sparseArray.put(8075, map);
            this.mGmAdLoader.apply(sparseArray);
        }
    }

    public final void callLoadSuccess(double d6, Map<String, Object> map) {
        if (this.mGmAdLoader != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8107);
            sparseArray.put(-99999985, String.class);
            sparseArray.put(8409, Double.valueOf(d6));
            sparseArray.put(8075, map);
            this.mGmAdLoader.apply(sparseArray);
        }
    }
}
