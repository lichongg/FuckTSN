package com.kwad.sdk.core.network;

import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c {
    public int aEi = -1;
    public Exception aEj;
    public String aEk;
    public int code;

    public final boolean Hx() {
        return this.code == 200;
    }

    @NonNull
    public final String toString() {
        return "BaseResponse{code=" + this.code + ", rawCode=" + this.aEi + ", rawException=" + this.aEj + ", body='" + this.aEk + "'}";
    }
}
