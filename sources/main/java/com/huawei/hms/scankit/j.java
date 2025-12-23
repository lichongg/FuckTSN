package com.huawei.hms.scankit;

import com.huawei.hms.scankit.p.j0;
import com.huawei.hms.scankit.p.o4;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class j implements j0.e {

    /* renamed from: a, reason: collision with root package name */
    private d f33957a;

    @Override // com.huawei.hms.scankit.p.j0.e
    public void a(byte[] bArr) {
        o4.a("scan-time", "request frame time:" + System.currentTimeMillis());
        this.f33957a.a().obtainMessage(R.id.scankit_decode, bArr).sendToTarget();
    }

    public j(d dVar) {
        this.f33957a = dVar;
    }
}
