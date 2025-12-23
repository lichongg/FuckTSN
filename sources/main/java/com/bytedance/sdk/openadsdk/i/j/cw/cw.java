package com.bytedance.sdk.openadsdk.i.j.cw;

import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.LocationProvider;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw implements LocationProvider {

    /* renamed from: j, reason: collision with root package name */
    private ValueSet f31461j;

    public static SparseArray<Object> j(LocationProvider locationProvider) {
        if (locationProvider == null) {
            return null;
        }
        a a6 = a.a();
        a6.c(262001, locationProvider.getLatitude());
        a6.c(262002, locationProvider.getLongitude());
        return a6.k().sparseArray();
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLatitude() {
        return this.f31461j.doubleValue(262001);
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLongitude() {
        return this.f31461j.doubleValue(262002);
    }

    public cw(ValueSet valueSet) {
        this.f31461j = valueSet == null ? a.f22763c : valueSet;
    }
}
