package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
class p implements IOAdEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ o f11077a;

    p(o oVar) {
        this.f11077a = oVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        bj.a(new q(this, iOAdEvent));
    }
}
