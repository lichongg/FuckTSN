package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.ao;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
class ch implements ao.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ca f10871a;

    ch(ca caVar) {
        this.f10871a = caVar;
    }

    @Override // com.baidu.mobads.sdk.internal.ao.a
    public void a() {
        boolean z5;
        z5 = this.f10871a.A;
        if (z5) {
            this.f10871a.A = false;
            this.f10871a.a(false, "remote update Network access failed");
        }
    }
}
