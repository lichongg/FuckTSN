package com.bytedance.sdk.openadsdk.mediation.ad.j.j.xt;

import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private final IMediationAdSlot f31658j;

    @Override // java.util.function.Function
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.f31658j == null) {
            return null;
        }
        int intValue = a.j(sparseArray).k().intValue(-99999987);
        if (intValue == 8260031) {
            return this.f31658j;
        }
        switch (intValue) {
            case 266001:
                break;
            case 266002:
                break;
            case 266003:
                break;
            case 266004:
                break;
            case 266005:
                break;
            case 266006:
                break;
            case 266007:
                break;
            case 266008:
                break;
            case 266009:
                break;
            case 266010:
                break;
            case 266011:
                break;
            case 266012:
                break;
            default:
                switch (intValue) {
                }
        }
        return null;
    }

    public j(IMediationAdSlot iMediationAdSlot) {
        this.f31658j = iMediationAdSlot;
    }
}
