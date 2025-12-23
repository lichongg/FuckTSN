package com.kwad.sdk.core.b.a;

import androidx.core.app.NotificationCompat;
import com.kwad.components.core.webview.jshandler.WebCardRegisterLiveShopListener;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ab implements com.kwad.sdk.core.d<WebCardRegisterLiveShopListener.AdLiveItemShopInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(WebCardRegisterLiveShopListener.AdLiveItemShopInfo adLiveItemShopInfo, JSONObject jSONObject) {
        a2(adLiveItemShopInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(WebCardRegisterLiveShopListener.AdLiveItemShopInfo adLiveItemShopInfo, JSONObject jSONObject) {
        return b2(adLiveItemShopInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(WebCardRegisterLiveShopListener.AdLiveItemShopInfo adLiveItemShopInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adLiveItemShopInfo.status = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
        adLiveItemShopInfo.title = jSONObject.optString("title");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(adLiveItemShopInfo.title)) {
            adLiveItemShopInfo.title = "";
        }
        adLiveItemShopInfo.url = jSONObject.optString("url");
        if (obj.toString().equals(adLiveItemShopInfo.url)) {
            adLiveItemShopInfo.url = "";
        }
        adLiveItemShopInfo.price = jSONObject.optString("price");
        if (obj.toString().equals(adLiveItemShopInfo.price)) {
            adLiveItemShopInfo.price = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(WebCardRegisterLiveShopListener.AdLiveItemShopInfo adLiveItemShopInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i6 = adLiveItemShopInfo.status;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, NotificationCompat.CATEGORY_STATUS, i6);
        }
        String str = adLiveItemShopInfo.title;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "title", adLiveItemShopInfo.title);
        }
        String str2 = adLiveItemShopInfo.url;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "url", adLiveItemShopInfo.url);
        }
        String str3 = adLiveItemShopInfo.price;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "price", adLiveItemShopInfo.price);
        }
        return jSONObject;
    }
}
