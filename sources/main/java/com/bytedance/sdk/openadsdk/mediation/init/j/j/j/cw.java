package com.bytedance.sdk.openadsdk.mediation.init.j.j.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw {
    public static final SparseArray<Object> j(MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment) {
        a a6 = a.a();
        if (mediationConfigUserInfoForSegment == null) {
            return null;
        }
        a6.g(265007, mediationConfigUserInfoForSegment.getCustomInfos());
        a6.h(265001, mediationConfigUserInfoForSegment.getUserId());
        a6.h(265002, mediationConfigUserInfoForSegment.getChannel());
        a6.h(265003, mediationConfigUserInfoForSegment.getSubChannel());
        a6.e(265004, mediationConfigUserInfoForSegment.getAge());
        a6.h(265005, mediationConfigUserInfoForSegment.getGender());
        a6.h(265006, mediationConfigUserInfoForSegment.getUserValueGroup());
        return a6.k().sparseArray();
    }
}
