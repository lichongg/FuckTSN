package com.bytedance.sdk.openadsdk.mediation.bridge.custom;

import android.content.Context;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.bykv.j.j.j.j.a;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.api.m;
import com.bytedance.sdk.openadsdk.i.j.cw.xt;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationLoaderConfig;
import com.bytedance.sdk.openadsdk.mediation.j.j;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class MediationCustomAdBaseLoader extends j {
    public Function<SparseArray<Object>, Object> mGmAdLoader;

    private void j() {
        if (this.mGmAdLoader != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(8405, this);
            sparseArray.put(-99999987, 8221);
            sparseArray.put(-99999985, String.class);
            this.mGmAdLoader.apply(sparseArray);
        }
    }

    public abstract <T> T callMethod(int i6, ValueSet valueSet, Class<T> cls);

    @Override // com.bytedance.sdk.openadsdk.mediation.j.j
    public SparseArray<Object> get() {
        return null;
    }

    public final void load(Context context, ValueSet valueSet) {
        MediationLoaderConfig create = MediationLoaderConfig.create(valueSet);
        ValueSet adSlotValueSet = create.getAdSlotValueSet();
        loadInner(context, xt.j(adSlotValueSet != null ? adSlotValueSet.sparseArray() : new SparseArray<>()), new com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomServiceConfig(create.getMediationCustomServiceConfigValue()), create.getGMCustomAdLoader());
    }

    public abstract void load(Context context, AdSlot adSlot, com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomServiceConfig mediationCustomServiceConfig);

    @Override // com.bytedance.sdk.openadsdk.mediation.j.j
    public <T> T applyFunction(int i6, ValueSet valueSet, Class<T> cls) {
        if (i6 == 8241) {
            load((Context) valueSet.objectValue(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, Context.class), a.j((SparseArray) valueSet.objectValue(8424, SparseArray.class)).k());
        } else if (i6 == 8225) {
            m.cw(MediationConstant.TAG, "MediationCustomBaseLoader receiveBidResult");
            receiveBidResult(valueSet.booleanValue(8406), valueSet.doubleValue(8407), valueSet.intValue(8408), (Map) valueSet.objectValue(8075, Map.class));
        } else if (i6 == 8149) {
            m.cw(MediationConstant.TAG, "MediationCustomBaseLoader onPause");
            onPause();
        } else if (i6 == 8148) {
            m.cw(MediationConstant.TAG, "MediationCustomBaseLoader onPause");
            onResume();
        } else if (i6 == 8109) {
            m.cw(MediationConstant.TAG, "MediationCustomBaseLoader onDestroy");
            onDestroy();
        }
        return (T) callMethod(i6, valueSet, cls);
    }

    public final void callLoadFail(int i6, String str) {
        if (this.mGmAdLoader != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(8014, Integer.valueOf(i6));
            sparseArray.put(8015, str);
            sparseArray.put(-99999987, 8123);
            sparseArray.put(-99999985, String.class);
            this.mGmAdLoader.apply(sparseArray);
        }
    }

    public final String getAdm() {
        Object apply;
        if (this.mGmAdLoader == null) {
            return "";
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 8137);
        sparseArray.put(-99999985, String.class);
        apply = this.mGmAdLoader.apply(sparseArray);
        return (String) apply;
    }

    public final int getBiddingType() {
        Object apply;
        if (this.mGmAdLoader == null) {
            return 0;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 8226);
        sparseArray.put(-99999985, Integer.class);
        apply = this.mGmAdLoader.apply(sparseArray);
        Integer num = (Integer) apply;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public final Object getExtraDataNoParse() {
        Object apply;
        if (this.mGmAdLoader == null) {
            return null;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 8224);
        sparseArray.put(-99999985, Object.class);
        apply = this.mGmAdLoader.apply(sparseArray);
        return apply;
    }

    public final Bridge getGMBridge() {
        Object apply;
        if (this.mGmAdLoader == null) {
            return null;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 8127);
        sparseArray.put(-99999985, Bridge.class);
        apply = this.mGmAdLoader.apply(sparseArray);
        return (Bridge) apply;
    }

    public final void loadInner(Context context, AdSlot adSlot, com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomServiceConfig mediationCustomServiceConfig, Function<SparseArray<Object>, Object> function) {
        this.mGmAdLoader = function;
        j();
        if (adSlot == null) {
            try {
                adSlot = new AdSlot.Builder().build();
            } catch (Exception e6) {
                m.j(e6);
                return;
            }
        }
        load(context, adSlot, mediationCustomServiceConfig);
    }

    public final void setMediaExtraInfo(Map<String, Object> map) {
        if (this.mGmAdLoader == null || map == null) {
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(8075, map);
        sparseArray.put(-99999987, 8227);
        sparseArray.put(-99999985, Void.class);
        this.mGmAdLoader.apply(sparseArray);
    }

    protected Integer j(MediationConstant.AdIsReadyStatus adIsReadyStatus) {
        if (adIsReadyStatus == MediationConstant.AdIsReadyStatus.ADN_NO_READY_API) {
            return 1;
        }
        if (adIsReadyStatus == MediationConstant.AdIsReadyStatus.AD_IS_READY) {
            return 2;
        }
        if (adIsReadyStatus == MediationConstant.AdIsReadyStatus.AD_IS_EXPIRED) {
            return 3;
        }
        if (adIsReadyStatus != MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY) {
            return 1;
        }
        return 4;
    }

    public void onDestroy() {
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void receiveBidResult(boolean z5, double d6, int i6, @Nullable Map<String, Object> map) {
    }
}
