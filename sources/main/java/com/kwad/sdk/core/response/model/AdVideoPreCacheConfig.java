package com.kwad.sdk.core.response.model;

import com.ksad.json.annotation.KsJson;
import java.io.Serializable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsJson
/* loaded from: D:\Downloads\app\classes6.dex */
public class AdVideoPreCacheConfig extends com.kwad.sdk.core.response.a.a implements Serializable {
    public static final int DEFAULT_PRE_CACHE_SIZE = 800;
    private static final long serialVersionUID = -3793189825357939577L;
    public int adVideoPreCacheSize;
    public boolean continueLoadingAll;

    public AdVideoPreCacheConfig(int i6, boolean z5) {
        this.adVideoPreCacheSize = i6;
        this.continueLoadingAll = z5;
    }

    public int getAdVideoPreCacheSize() {
        return this.adVideoPreCacheSize;
    }

    public boolean isContinueLoadingAll() {
        return this.continueLoadingAll;
    }

    public void setAdVideoPreCacheSize(int i6) {
        this.adVideoPreCacheSize = i6;
    }

    public void setContinueLoadingAll(boolean z5) {
        this.continueLoadingAll = z5;
    }

    public AdVideoPreCacheConfig() {
        this.adVideoPreCacheSize = 800;
    }
}
