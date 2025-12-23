package com.bytedance.sdk.openadsdk.mediation.manager.j.j.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.i.j.j.az;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationShakeViewListener;
import com.bytedance.sdk.openadsdk.mediation.ad.j.j.xt.ae;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationNativeManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r implements MediationNativeManager {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f31744j;
    private ValueSet xt;

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public List<MediationAdLoadInfo> getAdLoadInfo() {
        Object apply;
        SparseArray sparseArray = new SparseArray(1);
        sparseArray.put(-99999987, 270002);
        sparseArray.put(-99999985, List.class);
        apply = this.f31744j.apply(sparseArray);
        List list = (List) apply;
        if (list == null) {
            list = new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new xt(az.j(it.next())));
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public MediationAdEcpmInfo getBestEcpm() {
        Object apply;
        SparseArray sparseArray = new SparseArray(1);
        sparseArray.put(-99999987, 270004);
        sparseArray.put(-99999985, Object.class);
        apply = this.f31744j.apply(sparseArray);
        return new j(az.j(apply));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public List<MediationAdEcpmInfo> getCacheList() {
        Object apply;
        SparseArray sparseArray = new SparseArray(1);
        sparseArray.put(-99999987, 270005);
        sparseArray.put(-99999985, List.class);
        apply = this.f31744j.apply(sparseArray);
        List list = (List) apply;
        if (list == null) {
            list = new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new j(az.j(it.next())));
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public List<MediationAdEcpmInfo> getMultiBiddingEcpm() {
        Object apply;
        SparseArray sparseArray = new SparseArray(1);
        sparseArray.put(-99999987, 270003);
        sparseArray.put(-99999985, List.class);
        apply = this.f31744j.apply(sparseArray);
        List list = (List) apply;
        if (list == null) {
            list = new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new j(az.j(it.next())));
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public MediationAdEcpmInfo getShowEcpm() {
        Object apply;
        SparseArray sparseArray = new SparseArray(1);
        sparseArray.put(-99999987, 270006);
        sparseArray.put(-99999985, Object.class);
        apply = this.f31744j.apply(sparseArray);
        return new j(az.j(apply));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationNativeManager
    public boolean hasDislike() {
        return this.xt.booleanValue(270008);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationNativeManager
    public boolean isExpress() {
        return this.xt.booleanValue(270011);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public boolean isReady() {
        Object apply;
        SparseArray sparseArray = new SparseArray(1);
        sparseArray.put(-99999987, 270001);
        sparseArray.put(-99999985, Boolean.TYPE);
        apply = this.f31744j.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationNativeManager
    public void onPause() {
        SparseArray sparseArray = new SparseArray(1);
        sparseArray.put(-99999987, 271049);
        sparseArray.put(-99999985, Void.class);
        this.f31744j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationNativeManager
    public void onResume() {
        SparseArray sparseArray = new SparseArray(1);
        sparseArray.put(-99999987, 271048);
        sparseArray.put(-99999985, Void.class);
        this.f31744j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationNativeManager
    public void setShakeViewListener(MediationShakeViewListener mediationShakeViewListener) {
        SparseArray sparseArray = new SparseArray(2);
        sparseArray.put(-99999987, 270010);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, new ae(mediationShakeViewListener));
        this.f31744j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationNativeManager
    public void setUseCustomVideo(boolean z5) {
        SparseArray sparseArray = new SparseArray(2);
        sparseArray.put(-99999987, 270009);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, Boolean.valueOf(z5));
        this.f31744j.apply(sparseArray);
    }

    public r(Function<SparseArray<Object>, Object> function) {
        Object apply;
        this.xt = a.f22763c;
        function = function == null ? a.f22765e : function;
        this.f31744j = function;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, -99999986);
        sparseArray.put(-99999985, SparseArray.class);
        apply = function.apply(sparseArray);
        if (apply instanceof SparseArray) {
            this.xt = a.j((SparseArray) apply).k();
        }
    }
}
