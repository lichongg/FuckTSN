package com.bytedance.sdk.openadsdk.i.j.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ae implements TTAdDislike {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f31485j;

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public boolean isShow() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 240105);
        sparseArray.put(-99999985, Boolean.class);
        apply = this.f31485j.apply(sparseArray);
        Boolean bool = (Boolean) apply;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void resetDislikeStatus() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 240104);
        sparseArray.put(-99999985, Void.class);
        this.f31485j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void setDislikeInteractionCallback(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 240102);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, new com.bytedance.sdk.openadsdk.kt.j.j.j.j(dislikeInteractionCallback));
        this.f31485j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void setDislikeSource(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 240103);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, str);
        this.f31485j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void showDislikeDialog() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 240101);
        sparseArray.put(-99999985, Void.class);
        this.f31485j.apply(sparseArray);
    }

    public ae(Function<SparseArray<Object>, Object> function) {
        this.f31485j = function == null ? a.f22765e : function;
    }
}
