package com.kwad.sdk.n;

import com.ksad.json.annotation.KsJson;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsJson
/* loaded from: D:\Downloads\app\classes6.dex */
public class d extends com.kwad.sdk.core.response.a.a {
    public List<com.kwad.sdk.n.a.a> aWU;
    public List<String> aXc;
    public List<a> aXd;
    public List<com.kwad.sdk.n.a.b> aXe;
    public long funcSwitch;
    public long byteCount = 1000;
    public double sampleRate = 1.0d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public String aXf;
        public String aXg;
    }

    public final boolean OY() {
        return eH(4);
    }

    public final boolean OX() {
        return (this.funcSwitch & 1) == 0;
    }

    public final boolean OZ() {
        return eH(16);
    }

    public final boolean Pa() {
        return eH(32);
    }

    private boolean eH(int i6) {
        if (OX() || (this.funcSwitch & i6) == 0) {
            return false;
        }
        return true;
    }
}
