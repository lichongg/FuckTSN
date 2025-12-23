package com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class MediationCustomNativeLoader extends MediationCustomAdBaseLoader {
    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public <T> T callMethod(int i6, ValueSet valueSet, Class<T> cls) {
        return null;
    }

    public final void callLoadSuccess(List<? extends MediationCustomNativeAd> list) {
        if (this.mGmAdLoader != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8107);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8303, list);
            this.mGmAdLoader.apply(sparseArray);
        }
    }

    public final boolean isExpressRender() {
        Object apply;
        if (this.mGmAdLoader != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8222);
            sparseArray.put(-99999985, Boolean.class);
            apply = this.mGmAdLoader.apply(sparseArray);
            Boolean bool = (Boolean) apply;
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        return false;
    }

    public final boolean isNativeAd() {
        Object apply;
        if (this.mGmAdLoader != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8223);
            sparseArray.put(-99999985, Boolean.class);
            apply = this.mGmAdLoader.apply(sparseArray);
            Boolean bool = (Boolean) apply;
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        return false;
    }
}
