package com.huawei.hms.scankit.p;

import android.hardware.Camera;
import com.huawei.hms.scankit.p.j0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class f6 implements Camera.PreviewCallback {

    /* renamed from: a, reason: collision with root package name */
    private j0.e f34264a;

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        this.f34264a.a(bArr);
    }

    public f6(j0.e eVar) {
        this.f34264a = eVar;
    }
}
