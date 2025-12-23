package com.kwad.components.core.webview.tachikoma;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class h {
    private final Map<String, HashMap<Integer, String>> afd = new ConcurrentHashMap();
    private Map<String, Integer> afe = new ConcurrentSkipListMap();
    private int aff = 0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a {
        private static final h afg = new h();
    }

    private void bh(int i6) {
        if (this.aff + i6 > com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aBz)) {
            ArrayList arrayList = new ArrayList();
            Iterator<Map.Entry<String, Integer>> it = this.afe.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, Integer> next = it.next();
                arrayList.add(next.getKey());
                this.aff -= next.getValue().intValue();
                it.remove();
                if (this.aff <= com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aBz) - i6) {
                    break;
                }
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                this.afd.remove((String) it2.next());
            }
        }
    }

    public final String n(String str, int i6) {
        HashMap<Integer, String> hashMap;
        return (com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aBz) != 0 && this.afd.containsKey(str) && (hashMap = this.afd.get(str)) != null && hashMap.containsKey(Integer.valueOf(i6))) ? hashMap.get(Integer.valueOf(i6)) : "";
    }

    private static int ba(String str) {
        return ((str.length() * 2) + 44) / 1024;
    }

    private void r(String str, String str2) {
        int ba = ba(str2);
        this.aff += ba;
        this.afe.put(str, Integer.valueOf(ba));
    }

    public static h uS() {
        return a.afg;
    }

    public final void b(String str, int i6, String str2) {
        if (!TextUtils.isEmpty(str2) && com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aBz) != 0) {
            if (this.afd.containsKey(str)) {
                HashMap<Integer, String> hashMap = this.afd.get(str);
                if (hashMap == null || !hashMap.containsKey(Integer.valueOf(i6))) {
                    this.afd.remove(str);
                } else {
                    return;
                }
            }
            bh(ba(str2));
            HashMap<Integer, String> hashMap2 = new HashMap<>();
            hashMap2.put(Integer.valueOf(i6), str2);
            this.afd.put(str, hashMap2);
            r(str, str2);
        }
    }
}
