package com.bytedance.sdk.openadsdk.i.j.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bytedance.sdk.openadsdk.DownloadStatusController;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up implements DownloadStatusController {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f31497j;

    @Override // com.bytedance.sdk.openadsdk.DownloadStatusController
    public void cancelDownload() {
        SparseArray sparseArray = new SparseArray(1);
        sparseArray.put(-99999987, 222102);
        sparseArray.put(-99999985, Void.class);
        this.f31497j.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.DownloadStatusController
    public void changeDownloadStatus() {
        SparseArray sparseArray = new SparseArray(1);
        sparseArray.put(-99999987, 222101);
        sparseArray.put(-99999985, Void.class);
        this.f31497j.apply(sparseArray);
    }

    public up(Function<SparseArray<Object>, Object> function) {
        this.f31497j = function == null ? a.f22765e : function;
    }
}
