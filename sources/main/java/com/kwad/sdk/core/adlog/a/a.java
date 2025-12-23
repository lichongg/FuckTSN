package com.kwad.sdk.core.adlog.a;

import androidx.annotation.NonNull;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    public JSONObject axq;
    public com.kwad.sdk.core.adlog.c.a axr;
    public long axs;
    public int axt;
    public String axu;
    public int retryCount;
    public String url;

    public static a Ez() {
        return new a();
    }

    public final a as(long j6) {
        this.axs = j6;
        return this;
    }

    public final a c(com.kwad.sdk.core.adlog.c.a aVar) {
        this.axr = aVar;
        return this;
    }

    public final a cK(int i6) {
        this.axt = i6;
        return this;
    }

    public final a dm(String str) {
        this.url = str;
        return this;
    }

    public final a dn(String str) {
        this.axu = str;
        return this;
    }

    public final a i(JSONObject jSONObject) {
        this.axq = jSONObject;
        return this;
    }

    @NonNull
    public final String toString() {
        return "AdLogCache {actionType=" + this.axr.awx + ", retryCount=" + this.retryCount + ", retryErrorCode=" + this.axt + ", retryErrorMsg=" + this.axu + '}';
    }
}
