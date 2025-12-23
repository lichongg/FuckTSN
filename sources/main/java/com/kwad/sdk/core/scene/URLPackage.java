package com.kwad.sdk.core.scene;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.a.a;
import com.kwad.sdk.utils.ab;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsJson
/* loaded from: D:\Downloads\app\classes6.dex */
public class URLPackage extends a implements Serializable {
    public static final String KEY_AUTHOR_ID = "authorId";
    public static final String KEY_CHANNEL_ID = "channelId";
    private static final long serialVersionUID = -7365796297335816787L;
    public String identity;
    public transient JSONObject mJsonObjectParams;
    public int page;

    public URLPackage() {
    }

    public URLPackage(@NonNull String str, int i6) {
        this.page = i6;
        this.identity = str;
    }

    public void putParams(String str, long j6) {
        if (this.mJsonObjectParams == null) {
            this.mJsonObjectParams = new JSONObject();
        }
        ab.putValue(this.mJsonObjectParams, str, j6);
    }

    @Override // com.kwad.sdk.core.response.a.a
    public void afterParseJson(@Nullable JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        if (jSONObject != null) {
            String optString = jSONObject.optString("params");
            if (!TextUtils.isEmpty(optString)) {
                try {
                    this.mJsonObjectParams = new JSONObject(optString);
                } catch (JSONException e6) {
                    c.printStackTrace(e6);
                }
            }
        }
    }

    @Override // com.kwad.sdk.core.response.a.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        JSONObject jSONObject2 = this.mJsonObjectParams;
        if (jSONObject2 != null) {
            ab.putValue(jSONObject, "params", jSONObject2.toString());
        }
    }

    public URLPackage(int i6) {
        this.page = i6;
        this.identity = String.valueOf(hashCode());
    }
}
