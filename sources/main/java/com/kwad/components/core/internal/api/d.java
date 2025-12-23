package com.kwad.components.core.internal.api;

import android.text.TextUtils;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.api.KsImage;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class d implements KsImage {
    private int height;
    private String imageUrl;
    private int width;

    @InvokeBy(invokerClass = com.kwad.sdk.service.c.class, methodId = "initModeImplForInvoker")
    public static void register() {
        com.kwad.sdk.service.c.b(KsImage.class, d.class);
    }

    @Override // com.kwad.sdk.api.KsImage
    public int getHeight() {
        return this.height;
    }

    @Override // com.kwad.sdk.api.KsImage
    public String getImageUrl() {
        return this.imageUrl;
    }

    @Override // com.kwad.sdk.api.KsImage
    public int getWidth() {
        return this.width;
    }

    @Override // com.kwad.sdk.api.KsImage
    public boolean isValid() {
        return this.width > 0 && this.height > 0 && !TextUtils.isEmpty(this.imageUrl);
    }

    public d(int i6, int i7, String str) {
        this.width = i6;
        this.height = i7;
        this.imageUrl = str;
    }
}
