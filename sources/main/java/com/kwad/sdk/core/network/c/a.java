package com.kwad.sdk.core.network.c;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.network.c;
import com.kwad.sdk.export.proxy.AdHttpBodyBuilder;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.export.proxy.AdHttpResponseListener;
import java.io.OutputStream;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a implements AdHttpProxy {
    @Override // com.kwad.sdk.export.proxy.AdHttpProxy
    public final c doGetWithoutResponse(String str, Map<String, String> map, boolean z5) {
        return com.kwad.sdk.core.network.a.b.a(str, map, false, z5);
    }

    @Override // com.kwad.sdk.export.proxy.AdHttpProxy
    public final c doPost(String str, Map<String, String> map, JSONObject jSONObject) {
        return com.kwad.sdk.core.network.a.b.doPost(str, map, jSONObject);
    }

    @Override // com.kwad.sdk.export.proxy.AdHttpProxy
    public final c doPost(String str, Map<String, String> map, Map<String, String> map2) {
        return com.kwad.sdk.core.network.a.b.doPost(str, map, map2);
    }

    @Override // com.kwad.sdk.export.proxy.AdHttpProxy
    public final c doGet(String str, Map<String, String> map) {
        return com.kwad.sdk.core.network.a.b.doGet(str, map);
    }

    @Override // com.kwad.sdk.export.proxy.AdHttpProxy
    public final c doPost(String str, Map<String, String> map, AdHttpBodyBuilder adHttpBodyBuilder) {
        return new c();
    }

    @Override // com.kwad.sdk.export.proxy.AdHttpProxy
    public final boolean downloadUrlToStream(String str, OutputStream outputStream, long j6, boolean z5, @Nullable AdHttpResponseListener adHttpResponseListener) {
        return com.kwad.sdk.core.network.a.b.downloadUrlToStream(str, outputStream, j6, z5, adHttpResponseListener);
    }
}
