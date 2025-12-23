package com.kwad.sdk.service.a;

import android.content.Context;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public interface f {
    boolean Bk();

    boolean Bl();

    boolean Bm();

    boolean Bn();

    String Bo();

    com.kwad.sdk.core.b Bp();

    List<AdTemplate> Bq();

    String Br();

    JSONObject Bs();

    JSONObject Bt();

    Map<String, String> Bu();

    void a(String str, Map<String, String> map, String str2);

    boolean aR(AdTemplate adTemplate);

    String as(String str);

    String getApiVersion();

    int getApiVersionCode();

    String getAppId();

    String getAppName();

    Context getContext();

    String getSDKVersion();

    boolean qt();

    boolean qu();

    com.kwad.sdk.core.response.b.g wp();
}
