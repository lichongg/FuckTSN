package com.kwad.sdk.export.proxy;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.network.c;
import java.io.OutputStream;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public interface AdHttpProxy {
    c doGet(String str, Map<String, String> map);

    c doGetWithoutResponse(String str, Map<String, String> map, boolean z5);

    c doPost(String str, Map<String, String> map, AdHttpBodyBuilder adHttpBodyBuilder);

    c doPost(String str, Map<String, String> map, Map<String, String> map2);

    c doPost(String str, Map<String, String> map, JSONObject jSONObject);

    boolean downloadUrlToStream(String str, OutputStream outputStream, long j6, boolean z5, @Nullable AdHttpResponseListener adHttpResponseListener);
}
