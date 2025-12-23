package com.kwad.sdk.core.videocache.d;

import com.kwad.sdk.core.videocache.n;
import java.util.HashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b implements c {
    private HashMap<String, n> aLI = new HashMap<>();

    @Override // com.kwad.sdk.core.videocache.d.c
    public final void a(String str, n nVar) {
        this.aLI.put(str, nVar);
    }

    @Override // com.kwad.sdk.core.videocache.d.c
    public final n eS(String str) {
        if (this.aLI.containsKey(str)) {
            return this.aLI.get(str);
        }
        return null;
    }
}
