package com.kwad.sdk.core.network;

import androidx.annotation.Nullable;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public interface f {
    JSONObject getBody();

    Map<String, String> getBodyMap();

    Map<String, String> getHeader();

    @Nullable
    SceneImpl getScene();

    String getUrl();
}
