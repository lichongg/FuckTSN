package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
class cu implements IOAdEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ct f10969a;

    cu(ct ctVar) {
        this.f10969a = ctVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            this.f10969a.c((Map<String, Object>) iOAdEvent.getData());
        }
    }
}
