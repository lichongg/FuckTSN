package com.kwad.sdk.core.download;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.LruHashMap;
import com.kwad.sdk.utils.al;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b {
    public static final WeakHashMap<String, Integer> aDk = new WeakHashMap<>();
    private static final Map<String, Integer> aDl = Collections.synchronizedMap(new LruHashMap(10));
    private static final Map<String, String> aDm = new LruHashMap(10);
    private final com.kwad.sdk.app.a aDn;
    private final WeakHashMap<c, AdTemplate> awF;
    private final Map<c, AdTemplate> awG;
    private volatile boolean mHasInit;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a {
        static final b aDv = new b(0);
    }

    /* synthetic */ b(byte b6) {
        this();
    }

    public final synchronized void bx(Context context) {
        if (!this.mHasInit || context == null) {
            return;
        }
        try {
            com.kwad.sdk.app.b.Dw().b(this.aDn);
            this.awG.clear();
            this.mHasInit = false;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }

    public final synchronized void init(Context context) {
        if (!this.mHasInit && context != null) {
            com.kwad.sdk.c.AA().a(new com.kwad.sdk.b() { // from class: com.kwad.sdk.core.download.b.1
                @Override // com.kwad.sdk.b, com.kwad.sdk.a
                public final void a(DownloadTask downloadTask, int i6, int i7) {
                    b.this.a(l(downloadTask), i7 > 0 ? (int) ((i6 * 100.0f) / i7) : 0, i6, i7);
                }

                @Override // com.kwad.sdk.b, com.kwad.sdk.a
                public final void a(DownloadTask downloadTask) {
                    b.this.P(l(downloadTask), downloadTask.getTargetFilePath());
                }

                @Override // com.kwad.sdk.b, com.kwad.sdk.a
                public final void c(DownloadTask downloadTask) {
                    b.this.dQ(l(downloadTask));
                }

                @Override // com.kwad.sdk.b, com.kwad.sdk.a
                public final void d(DownloadTask downloadTask) {
                    b.this.dS(l(downloadTask));
                }

                @Override // com.kwad.sdk.b, com.kwad.sdk.a
                public final void f(DownloadTask downloadTask) {
                    b.this.dU(l(downloadTask));
                }

                private static String l(DownloadTask downloadTask) {
                    String url = downloadTask.getUrl();
                    String str = (String) b.aDm.get(url);
                    if (TextUtils.isEmpty(str)) {
                        String md5 = al.md5(downloadTask.getUrl());
                        b.aDm.put(url, md5);
                        return md5;
                    }
                    return str;
                }

                @Override // com.kwad.sdk.b, com.kwad.sdk.a
                public final void a(DownloadTask downloadTask, Throwable th) {
                    String str;
                    if (th != null && th.getStackTrace().length > 0) {
                        str = th.getMessage() + " @ " + th.getStackTrace()[0].getFileName() + th.getStackTrace()[0].getClassName() + th.getStackTrace()[0].getLineNumber();
                    } else {
                        str = "";
                    }
                    b.this.c(l(downloadTask), 0, str);
                }

                @Override // com.kwad.sdk.b, com.kwad.sdk.a
                public final void b(DownloadTask downloadTask) {
                    if (downloadTask.getSmallFileSoFarBytes() == 0) {
                        if (com.kwad.framework.a.a.oz.booleanValue()) {
                            com.kwad.sdk.core.d.c.d("DownloadStatusManager", "onDownloadStart(), id=" + l(downloadTask));
                        }
                        b.this.dP(l(downloadTask));
                    }
                }

                @Override // com.kwad.sdk.b, com.kwad.sdk.a
                public final void e(DownloadTask downloadTask) {
                    String l6 = l(downloadTask);
                    int i6 = downloadTask.downloadType;
                    if (i6 != 0) {
                        b.aDk.put(l6, Integer.valueOf(i6));
                    }
                    b.this.dR(l6);
                }
            });
            com.kwad.sdk.app.b.Dw().a(this.aDn);
            this.mHasInit = true;
        }
    }

    private b() {
        WeakHashMap<c, AdTemplate> weakHashMap = new WeakHashMap<>();
        this.awF = weakHashMap;
        this.awG = Collections.synchronizedMap(weakHashMap);
        this.mHasInit = false;
        this.aDn = new com.kwad.sdk.app.a() { // from class: com.kwad.sdk.core.download.b.6
            @Override // com.kwad.sdk.app.a
            public final void U(String str) {
                b.this.dV(str);
            }

            @Override // com.kwad.sdk.app.a
            public final void V(String str) {
                b.this.cv(str);
            }
        };
    }

    public static b GR() {
        return a.aDv;
    }

    private void U(final String str) {
        final e eVar = new e();
        b(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                String pC = cVar.pC();
                b.aDl.put(pC, 12);
                cVar.b(pC, str, eVar);
            }
        });
    }

    private void V(final String str) {
        final e eVar = new e();
        b(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                String pC = cVar.pC();
                b.aDl.put(pC, 0);
                cVar.f(pC, eVar);
            }
        });
    }

    private void b(String str, com.kwad.sdk.g.a<c> aVar) {
        Set<c> keySet = this.awG.keySet();
        synchronized (this.awG) {
            for (c cVar : keySet) {
                if (cVar != null && TextUtils.equals(str, cVar.pD())) {
                    try {
                        aVar.accept(cVar);
                    } catch (Exception e6) {
                        com.kwad.sdk.core.d.c.printStackTrace(e6);
                    }
                }
            }
        }
    }

    public final List<AdTemplate> Bq() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.awG) {
            try {
                for (AdTemplate adTemplate : this.awG.values()) {
                    if (adTemplate != null) {
                        arrayList.add(adTemplate);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }

    public final void P(final String str, final String str2) {
        final e eVar = new e();
        aDl.put(str, 8);
        a(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.9
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.a(str, str2, eVar);
            }
        });
    }

    public final void a(c cVar, AdTemplate adTemplate) {
        this.awG.put(cVar, adTemplate);
    }

    public final void c(final String str, int i6, final String str2) {
        aDl.put(str, 7);
        final e eVar = new e();
        final int i7 = 0;
        a(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.10
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.a(str, i7, str2, eVar);
            }
        });
    }

    public final void dP(final String str) {
        aDl.put(str, 1);
        final e eVar = new e();
        a(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.7
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.a(str, eVar);
            }
        });
    }

    public final void dQ(final String str) {
        final e eVar = new e();
        aDl.put(str, 4);
        a(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.11
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.b(str, eVar);
            }
        });
    }

    public final void dR(final String str) {
        final e eVar = new e();
        aDl.put(str, 1);
        a(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.12
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.c(str, eVar);
            }
        });
    }

    public final void dS(final String str) {
        final e eVar = new e();
        aDl.put(str, 5);
        a(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.13
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.d(str, eVar);
            }
        });
    }

    public final void dT(final String str) {
        final e eVar = new e();
        aDl.put(str, 9);
        a(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.14
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.e(str, eVar);
            }
        });
    }

    public final void dU(final String str) {
        final e eVar = new e();
        a(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.5
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.g(str, eVar);
            }
        });
    }

    public final void g(final String str, final Throwable th) {
        final e eVar = new e();
        aDl.put(str, 11);
        a(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.4
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.a(str, th, eVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cv(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        V(str);
    }

    public static int dO(String str) {
        Integer num;
        if (!TextUtils.isEmpty(str) && (num = aDl.get(str)) != null) {
            return num.intValue();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dV(String str) {
        if (!TextUtils.isEmpty(str)) {
            U(str);
            com.kwad.sdk.d AC = com.kwad.sdk.c.AA().AC();
            if (AC != null) {
                AC.cd(str);
            }
        }
    }

    public final void a(c cVar) {
        this.awG.remove(cVar);
    }

    public final void a(final String str, final int i6, final int i7, final int i8) {
        aDl.put(str, 2);
        a(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.8
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.a(str, i6, i7, i8);
            }
        });
    }

    private void a(String str, com.kwad.sdk.g.a<c> aVar) {
        Set<c> keySet = this.awG.keySet();
        synchronized (this.awG) {
            for (c cVar : keySet) {
                if (cVar != null && TextUtils.equals(cVar.pC(), str)) {
                    try {
                        aVar.accept(cVar);
                    } catch (Exception e6) {
                        com.kwad.sdk.core.d.c.printStackTrace(e6);
                    }
                }
            }
        }
    }
}
