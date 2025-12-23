package com.baidu.mobads.sdk.internal;

import androidx.core.app.NotificationCompat;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import com.kwad.sdk.core.scene.URLPackage;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
class cw implements IOAdEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ct f10971a;

    cw(ct ctVar) {
        this.f10971a = ctVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            try {
                if (iOAdEvent.getData() != null) {
                    Object obj = iOAdEvent.getData().get("intervalpages");
                    Object obj2 = iOAdEvent.getData().get("bannerseconds");
                    Object obj3 = iOAdEvent.getData().get("novelrouter");
                    Object obj4 = iOAdEvent.getData().get("entry");
                    Object obj5 = iOAdEvent.getData().get(URLPackage.KEY_CHANNEL_ID);
                    Object obj6 = iOAdEvent.getData().get("contentId");
                    if (obj3 != null) {
                        int intValue = obj != null ? ((Integer) obj).intValue() : 6;
                        int intValue2 = obj2 != null ? ((Integer) obj2).intValue() : 10;
                        int intValue3 = obj4 != null ? ((Integer) obj4).intValue() : 0;
                        int intValue4 = obj5 != null ? ((Integer) obj5).intValue() : 1022;
                        String str = obj6 != null ? (String) obj6 : null;
                        JSONObject jSONObject = new JSONObject();
                        if (ao.f()) {
                            jSONObject.put(NotificationCompat.CATEGORY_STATUS, "0");
                        } else {
                            jSONObject.put(NotificationCompat.CATEGORY_STATUS, "1");
                        }
                        this.f10971a.a(jSONObject);
                        this.f10971a.a(intValue, intValue2, (String) obj3, intValue3, intValue4, str);
                    }
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
    }
}
