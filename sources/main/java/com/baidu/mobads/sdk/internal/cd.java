package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.co;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
class cd implements co.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ca f10864a;

    cd(ca caVar) {
        this.f10864a = caVar;
    }

    @Override // com.baidu.mobads.sdk.internal.co.a
    public void a(String str) {
        try {
            this.f10864a.b();
            this.f10864a.a(str);
        } catch (Throwable th) {
            bu.a().a(th);
        }
    }
}
