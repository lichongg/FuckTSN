package com.kwad.sdk.pngencrypt.chunk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class w {
    private final e aWC;
    private final boolean aWD;

    private List<? extends t> gC(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.aWC.am("tEXt", str));
        arrayList.addAll(this.aWC.am("zTXt", str));
        arrayList.addAll(this.aWC.am("iTXt", str));
        return arrayList;
    }

    public w(e eVar) {
        this.aWC = eVar;
        if (eVar instanceof f) {
            this.aWD = false;
        } else {
            this.aWD = true;
        }
    }

    public final String gD(String str) {
        List<? extends t> gC = gC(str);
        if (gC.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<? extends t> it = gC.iterator();
        while (it.hasNext()) {
            sb.append(it.next().ON());
            sb.append(com.snail.antifake.deviceid.e.f37542d);
        }
        return sb.toString().trim();
    }
}
