package com.bytedance.sdk.openadsdk.mediation.xt.j.xt;

import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationAppDialogClickListener;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private final MediationAppDialogClickListener f31785j;

    @Override // java.util.function.Function
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.f31785j == null) {
            return null;
        }
        ValueSet k6 = a.j(sparseArray).k();
        if (k6.intValue(-99999987) == 270025) {
            this.f31785j.onButtonClick(k6.intValue(0));
        }
        return null;
    }

    public up(MediationAppDialogClickListener mediationAppDialogClickListener) {
        this.f31785j = mediationAppDialogClickListener;
    }
}
