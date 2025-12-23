package com.bytedance.sdk.openadsdk.v.j.j.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements TTFeedAd.CustomizeVideo {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f31955j;

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public String getVideoUrl() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 162101);
        sparseArray.put(-99999985, String.class);
        apply = this.f31955j.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoAutoStart() {
        SparseArray sparseArray = new SparseArray(2);
        sparseArray.put(-99999987, 162107);
        sparseArray.put(-99999985, Void.class);
        this.f31955j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoBreak(long j6) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(-99999987, 162106);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, Long.valueOf(j6));
        this.f31955j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoContinue(long j6) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(-99999987, 162104);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, Long.valueOf(j6));
        this.f31955j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoError(long j6, int i6, int i7) {
        SparseArray sparseArray = new SparseArray(4);
        sparseArray.put(-99999987, 162109);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, Long.valueOf(j6));
        sparseArray.put(1, Integer.valueOf(i6));
        sparseArray.put(2, Integer.valueOf(i7));
        this.f31955j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoFinish() {
        SparseArray sparseArray = new SparseArray(2);
        sparseArray.put(-99999987, 162105);
        sparseArray.put(-99999985, Void.class);
        this.f31955j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoPause(long j6) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(-99999987, 162103);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, Long.valueOf(j6));
        this.f31955j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoStart() {
        SparseArray sparseArray = new SparseArray(2);
        sparseArray.put(-99999987, 162102);
        sparseArray.put(-99999985, Void.TYPE);
        this.f31955j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoStartError(int i6, int i7) {
        SparseArray sparseArray = new SparseArray(4);
        sparseArray.put(-99999987, 162108);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, Integer.valueOf(i6));
        sparseArray.put(1, Integer.valueOf(i7));
        this.f31955j.apply(sparseArray);
    }

    public j(Function<SparseArray<Object>, Object> function) {
        this.f31955j = function == null ? a.f22765e : function;
    }
}
