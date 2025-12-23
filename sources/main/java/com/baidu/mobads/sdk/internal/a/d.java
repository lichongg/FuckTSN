package com.baidu.mobads.sdk.internal.a;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
class d implements IOAdEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f10542a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ c f10543b;

    d(c cVar, a aVar) {
        this.f10543b = cVar;
        this.f10542a = aVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (iOAdEvent == null || !c.f10533h.equals(iOAdEvent.getType()) || (data = iOAdEvent.getData()) == null || data.isEmpty()) {
            return;
        }
        Object obj = data.get("e_t");
        Object obj2 = data.get("e_n");
        Object obj3 = data.get("e_a");
        if ((obj instanceof String) && (obj2 instanceof String)) {
            data.put("e_r", this.f10542a.handleEvent((String) obj, (String) obj2, obj3 instanceof Object[] ? (Object[]) obj3 : null));
        }
    }
}
