package com.kwad.framework.filedownloader.a;

import com.kwad.framework.filedownloader.f.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class d {
    public static b a(Map<String, List<String>> map, b bVar, List<String> list) {
        int responseCode = bVar.getResponseCode();
        String bn = bVar.bn("Location");
        ArrayList arrayList = new ArrayList();
        int i6 = 0;
        while (bB(responseCode)) {
            if (bn == null) {
                throw new IllegalAccessException(f.c("receive %d (redirect) but the location is null with response [%s]", Integer.valueOf(responseCode), bVar.xR()));
            }
            if (com.kwad.framework.filedownloader.f.d.apD) {
                com.kwad.framework.filedownloader.f.d.c(d.class, "redirect to %s with %d, %s", bn, Integer.valueOf(responseCode), arrayList);
            }
            bVar.xS();
            bVar = a(map, bn);
            arrayList.add(bn);
            bVar.execute();
            responseCode = bVar.getResponseCode();
            bn = bVar.bn("Location");
            i6++;
            if (i6 >= 10) {
                throw new IllegalAccessException(f.c("redirect too many times! %s", arrayList));
            }
        }
        if (list != null) {
            list.addAll(arrayList);
        }
        return bVar;
    }

    private static boolean bB(int i6) {
        return i6 == 301 || i6 == 302 || i6 == 303 || i6 == 300 || i6 == 307 || i6 == 308;
    }

    private static b a(Map<String, List<String>> map, String str) {
        b br = com.kwad.framework.filedownloader.download.b.yc().br(str);
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if (value != null) {
                Iterator<String> it = value.iterator();
                while (it.hasNext()) {
                    br.addHeader(key, it.next());
                }
            }
        }
        return br;
    }
}
