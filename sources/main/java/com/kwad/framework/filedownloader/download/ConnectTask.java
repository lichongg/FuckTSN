package com.kwad.framework.filedownloader.download;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ConnectTask {
    final int amZ;
    final com.kwad.framework.filedownloader.d.b ana;
    private com.kwad.framework.filedownloader.download.a anb;
    private String anc;
    private Map<String, List<String>> and;
    private List<String> ane;
    final String url;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class Reconnect extends Throwable {
        private static final long serialVersionUID = 2940866805654257562L;

        Reconnect() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a {
        private com.kwad.framework.filedownloader.d.b ana;
        private String anc;
        private Integer anf;
        private com.kwad.framework.filedownloader.download.a ang;
        private String url;

        public final a a(com.kwad.framework.filedownloader.d.b bVar) {
            this.ana = bVar;
            return this;
        }

        public final a a(com.kwad.framework.filedownloader.download.a aVar) {
            this.ang = aVar;
            return this;
        }

        public final a bp(String str) {
            this.url = str;
            return this;
        }

        public final a bq(String str) {
            this.anc = str;
            return this;
        }

        final ConnectTask yb() {
            com.kwad.framework.filedownloader.download.a aVar;
            Integer num = this.anf;
            if (num == null || (aVar = this.ang) == null || this.url == null) {
                throw new IllegalArgumentException();
            }
            return new ConnectTask(aVar, num.intValue(), this.url, this.anc, this.ana, (byte) 0);
        }

        a() {
        }

        public final a bL(int i6) {
            this.anf = Integer.valueOf(i6);
            return this;
        }
    }

    /* synthetic */ ConnectTask(com.kwad.framework.filedownloader.download.a aVar, int i6, String str, String str2, com.kwad.framework.filedownloader.d.b bVar, byte b6) {
        this(aVar, i6, str, str2, bVar);
    }

    private ConnectTask(com.kwad.framework.filedownloader.download.a aVar, int i6, String str, String str2, com.kwad.framework.filedownloader.d.b bVar) {
        this.amZ = i6;
        this.url = str;
        this.anc = str2;
        this.ana = bVar;
        this.anb = aVar;
    }

    private void a(com.kwad.framework.filedownloader.a.b bVar) {
        HashMap<String, List<String>> yY;
        com.kwad.framework.filedownloader.d.b bVar2 = this.ana;
        if (bVar2 == null || (yY = bVar2.yY()) == null) {
            return;
        }
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.e(this, "%d add outside header: %s", Integer.valueOf(this.amZ), yY);
        }
        for (Map.Entry<String, List<String>> entry : yY.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if (value != null) {
                Iterator<String> it = value.iterator();
                while (it.hasNext()) {
                    bVar.addHeader(key, it.next());
                }
            }
        }
    }

    private void b(com.kwad.framework.filedownloader.a.b bVar) {
        if (!TextUtils.isEmpty(this.anc)) {
            bVar.addHeader("If-Match", this.anc);
        }
        com.kwad.framework.filedownloader.download.a aVar = this.anb;
        bVar.addHeader("Range", aVar.anj == 0 ? com.kwad.framework.filedownloader.f.f.c("bytes=%d-", Long.valueOf(aVar.ani)) : com.kwad.framework.filedownloader.f.f.c("bytes=%d-%d", Long.valueOf(aVar.ani), Long.valueOf(this.anb.anj)));
    }

    private void c(com.kwad.framework.filedownloader.a.b bVar) {
        com.kwad.framework.filedownloader.d.b bVar2 = this.ana;
        if (bVar2 == null || bVar2.yY().get("User-Agent") == null) {
            bVar.addHeader("User-Agent", com.kwad.framework.filedownloader.f.f.zH());
        }
    }

    public final Map<String, List<String>> getRequestHeader() {
        return this.and;
    }

    final boolean xY() {
        return this.anb.ani > 0;
    }

    final String xZ() {
        List<String> list = this.ane;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return this.ane.get(r0.size() - 1);
    }

    public final com.kwad.framework.filedownloader.download.a ya() {
        return this.anb;
    }

    final com.kwad.framework.filedownloader.a.b xX() {
        com.kwad.framework.filedownloader.a.b br = b.yc().br(this.url);
        a(br);
        b(br);
        c(br);
        this.and = br.xQ();
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.c(this, "%s request header %s", Integer.valueOf(this.amZ), this.and);
        }
        br.execute();
        ArrayList arrayList = new ArrayList();
        this.ane = arrayList;
        return com.kwad.framework.filedownloader.a.d.a(this.and, br, arrayList);
    }
}
