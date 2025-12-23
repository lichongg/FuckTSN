package com.kwad.components.ad.reward.c;

import com.ksad.json.annotation.KsJson;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsJson
/* loaded from: D:\Downloads\app\classes6.dex */
public class b extends com.kwad.sdk.core.response.a.a {
    public static int STATUS_NONE = 2;
    public static int uk = 1;
    public static int ul = 3;
    public int um;
    public int un;

    public b() {
        this.um = STATUS_NONE;
    }

    public final void aa(int i6) {
        this.un = i6;
    }

    public final int getType() {
        return this.um;
    }

    public final int hY() {
        return this.un;
    }

    public b(int i6) {
        this.um = 1;
    }
}
