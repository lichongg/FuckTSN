package com.bytedance.sdk.openadsdk.mediation.manager.j.j.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bytedance.sdk.openadsdk.i.j.j.az;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationRewardManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up implements MediationRewardManager {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f31745j;

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationRewardManager
    public void destroy() {
        SparseArray sparseArray = new SparseArray(1);
        sparseArray.put(-99999987, 270007);
        sparseArray.put(-99999985, Void.class);
        this.f31745j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public List<MediationAdLoadInfo> getAdLoadInfo() {
        Object apply;
        SparseArray sparseArray = new SparseArray(1);
        sparseArray.put(-99999987, 270002);
        sparseArray.put(-99999985, List.class);
        apply = this.f31745j.apply(sparseArray);
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
        sparseArray.put(-99999985, Object.class);
        sparseArray.put(-99999987, 270004);
        apply = this.f31745j.apply(sparseArray);
        return new j(az.j(apply));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public List<MediationAdEcpmInfo> getCacheList() {
        Object apply;
        SparseArray sparseArray = new SparseArray(1);
        sparseArray.put(-99999987, 270005);
        apply = this.f31745j.apply(sparseArray);
        List list = (List) apply;
        sparseArray.put(-99999985, List.class);
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
        apply = this.f31745j.apply(sparseArray);
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
        apply = this.f31745j.apply(sparseArray);
        return new j(az.j(apply));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public boolean isReady() {
        Object apply;
        SparseArray sparseArray = new SparseArray(1);
        sparseArray.put(-99999987, 270001);
        sparseArray.put(-99999985, Boolean.TYPE);
        apply = this.f31745j.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
    }

    public up(Function<SparseArray<Object>, Object> function) {
        this.f31745j = function == null ? a.f22765e : function;
    }
}
