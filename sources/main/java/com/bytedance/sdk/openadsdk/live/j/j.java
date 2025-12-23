package com.bytedance.sdk.openadsdk.live.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bytedance.android.live.base.api.IHostPermission;
import com.bytedance.android.live.base.api.LocationProvider;
import com.bytedance.sdk.openadsdk.i.j.cw.cw;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements IHostPermission {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f31571j;

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean alist() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 262103);
        sparseArray.put(-99999985, Boolean.TYPE);
        apply = this.f31571j.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public String getAndroidID() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 262112);
        sparseArray.put(-99999985, String.class);
        apply = this.f31571j.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public String getDevImei() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 262105);
        sparseArray.put(-99999985, String.class);
        apply = this.f31571j.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public String getDevOaid() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 262109);
        sparseArray.put(-99999985, String.class);
        apply = this.f31571j.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public String getMacAddress() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 262107);
        sparseArray.put(-99999985, String.class);
        apply = this.f31571j.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public LocationProvider getTTLocation() {
        Object apply;
        SparseArray sparseArray = new SparseArray(1);
        sparseArray.put(-99999987, 262102);
        sparseArray.put(-99999985, com.bytedance.sdk.openadsdk.LocationProvider.class);
        apply = this.f31571j.apply(sparseArray);
        final cw cwVar = apply instanceof SparseArray ? new cw(a.j((SparseArray) apply).k()) : null;
        if (cwVar == null) {
            return null;
        }
        return new LocationProvider() { // from class: com.bytedance.sdk.openadsdk.live.j.j.1
            @Override // com.bytedance.android.live.base.api.LocationProvider
            public double getLatitude() {
                return cwVar.getLatitude();
            }

            @Override // com.bytedance.android.live.base.api.LocationProvider
            public double getLongitude() {
                return cwVar.getLongitude();
            }
        };
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean isCanGetAndUseAndroidID() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 262110);
        sparseArray.put(-99999985, Boolean.TYPE);
        apply = this.f31571j.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean isCanUseLocation() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 262101);
        sparseArray.put(-99999985, Boolean.TYPE);
        apply = this.f31571j.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean isCanUsePhoneState() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 262104);
        sparseArray.put(-99999985, Boolean.TYPE);
        apply = this.f31571j.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean isCanUseWifiState() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 262106);
        sparseArray.put(-99999985, Boolean.TYPE);
        apply = this.f31571j.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean isCanUseWriteExternal() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 262108);
        sparseArray.put(-99999985, Boolean.TYPE);
        apply = this.f31571j.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
    }

    public j(Function<SparseArray<Object>, Object> function) {
        this.f31571j = function == null ? a.f22765e : function;
    }
}
