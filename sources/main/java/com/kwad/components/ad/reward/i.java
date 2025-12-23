package com.kwad.components.ad.reward;

import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class i {
    private Map<String, List<AdTemplate>> ta;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a {
        private static final i tb = new i(0);
    }

    /* synthetic */ i(byte b6) {
        this();
    }

    private i() {
        this.ta = new ConcurrentHashMap();
    }

    public final void H(String str) {
        this.ta.remove(str);
    }

    public static i hs() {
        return a.tb;
    }
}
