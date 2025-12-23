package com.bytedance.sdk.openadsdk.mediation.bridge.valueset;

import android.content.Context;
import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.j.xt;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class MediationLoaderConfig {

    /* renamed from: j, reason: collision with root package name */
    private ValueSet f31699j;

    public static MediationLoaderConfig create(ValueSet valueSet) {
        return new MediationLoaderConfig(valueSet);
    }

    private boolean j() {
        ValueSet valueSet = this.f31699j;
        return (valueSet == null || valueSet.isEmpty()) ? false : true;
    }

    private MediationLoaderConfig(ValueSet valueSet) {
        ValueSet valueSet2;
        if (valueSet != null) {
            SparseArray sparseArray = (SparseArray) valueSet.objectValue(8424, SparseArray.class);
            if (sparseArray != null && sparseArray.size() > 0) {
                valueSet2 = a.j(sparseArray).k();
            } else {
                valueSet2 = null;
            }
            if (valueSet2 != null) {
                this.f31699j = valueSet2;
            } else {
                this.f31699j = valueSet;
            }
        }
    }

    public String getADNName() {
        if (j()) {
            return this.f31699j.stringValue(8003);
        }
        return "";
    }

    public ValueSet getAdSlotValueSet() {
        if (j()) {
            return a.j((SparseArray) this.f31699j.objectValue(8548, SparseArray.class)).k();
        }
        return null;
    }

    public int getAdType() {
        if (j()) {
            return this.f31699j.intValue(AVMDLDataLoader.KeyIsLiveMaxTrySwitchP2pTimes);
        }
        return 0;
    }

    public String getClassName() {
        if (j()) {
            return this.f31699j.stringValue(AVMDLDataLoader.KeyIsLiveMobileUploadAllow);
        }
        return "";
    }

    public Context getContext() {
        if (j()) {
            return (Context) this.f31699j.objectValue(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, Context.class);
        }
        return null;
    }

    public Function<SparseArray<Object>, Object> getGMCustomAdLoader() {
        if (j()) {
            return xt.j(this.f31699j.objectValue(AVMDLDataLoader.KeyIsLiveMobileDownloadAllow, Object.class));
        }
        return null;
    }

    public int getManagerLoaderType() {
        if (j()) {
            return this.f31699j.intValue(8561);
        }
        return 0;
    }

    public ValueSet getMediationCustomServiceConfigValue() {
        if (j()) {
            return a.j((SparseArray) this.f31699j.objectValue(8546, SparseArray.class)).k();
        }
        return null;
    }
}
