package com.kwad.sdk.a.a;

import android.content.Context;
import com.baidu.mobads.sdk.internal.bn;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.be;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.utils.w;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Stack;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class b {
    private static volatile b asX;
    private Stack<AdTemplate> asV = new Stack<>();
    private File asW;
    private boolean mHasInit;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void CT();

        void hy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized File CQ() {
        try {
            File file = this.asW;
            if (file != null) {
                return file;
            }
            String dI = be.dI(ServiceProvider.getContext());
            File file2 = new File(dI);
            if (!file2.exists()) {
                file2.mkdir();
            }
            File file3 = new File(dI + File.separator + "uninstall_ad");
            this.asW = file3;
            if (!file3.exists()) {
                try {
                    this.asW.createNewFile();
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }
            return this.asW;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Iterator] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.io.Closeable] */
    public synchronized void aS(AdTemplate adTemplate) {
        Throwable th;
        ObjectOutputStream objectOutputStream;
        Exception e6;
        ?? it = this.asV.iterator();
        boolean z5 = false;
        while (it.hasNext()) {
            if (com.kwad.sdk.core.response.b.e.ev((AdTemplate) it.next()) == com.kwad.sdk.core.response.b.e.ev(adTemplate)) {
                it.remove();
                z5 = true;
            }
        }
        if (z5) {
            try {
                try {
                    objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.asW));
                } catch (Exception e7) {
                    objectOutputStream = null;
                    e6 = e7;
                } catch (Throwable th2) {
                    it = 0;
                    th = th2;
                    com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) it);
                    throw th;
                }
                try {
                    objectOutputStream.writeObject(this.asV);
                    com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                } catch (Exception e8) {
                    e6 = e8;
                    com.kwad.sdk.core.d.c.d("InstallTipsDataManager", " removeApkDownloadedData e" + e6);
                    com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                }
            } catch (Throwable th3) {
                th = th3;
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) it);
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.AbstractCollection, java.util.Stack<com.kwad.sdk.core.response.model.AdTemplate>] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.Closeable] */
    public synchronized void aT(AdTemplate adTemplate) {
        Throwable th;
        ObjectOutputStream objectOutputStream;
        Exception e6;
        ?? r02 = this.asV;
        r02.add(adTemplate);
        try {
            try {
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(CQ()));
            } catch (Exception e7) {
                objectOutputStream = null;
                e6 = e7;
            } catch (Throwable th2) {
                r02 = 0;
                th = th2;
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) r02);
                throw th;
            }
            try {
                objectOutputStream.writeObject(this.asV);
                com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
            } catch (Exception e8) {
                e6 = e8;
                com.kwad.sdk.core.d.c.printStackTrace(e6);
                com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
            }
        } catch (Throwable th3) {
            th = th3;
            com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) r02);
            throw th;
        }
    }

    public final synchronized AdTemplate CS() {
        AdTemplate adTemplate;
        Stack stack = (Stack) this.asV.clone();
        while (true) {
            if (stack.isEmpty()) {
                adTemplate = null;
                break;
            }
            adTemplate = (AdTemplate) stack.pop();
            if (adTemplate != null) {
                String str = com.kwad.sdk.core.response.b.e.el(adTemplate).adBaseInfo.appPackageName;
                Context context = ServiceProvider.getContext();
                File aW = aW(adTemplate);
                if (aW != null && aW.exists() && aW.lastModified() + bn.f10748d > System.currentTimeMillis() && !as.ap(context, str)) {
                    break;
                }
            }
        }
        return adTemplate;
    }

    public static b CR() {
        if (asX == null) {
            synchronized (b.class) {
                try {
                    if (asX == null) {
                        asX = new b();
                    }
                } finally {
                }
            }
        }
        return asX;
    }

    public final void aU(final AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        h.execute(new bg() { // from class: com.kwad.sdk.a.a.b.2
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                b.this.aT(adTemplate);
            }
        });
    }

    public final void aV(final AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        h.execute(new bg() { // from class: com.kwad.sdk.a.a.b.3
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                b.this.aS(adTemplate);
            }
        });
    }

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static File aW(AdTemplate adTemplate) {
        File file = new File(com.kwad.sdk.core.download.a.H(com.kwad.sdk.core.response.b.e.el(adTemplate)));
        if (w.O(file)) {
            return file;
        }
        return null;
    }

    public final synchronized void a(final a aVar) {
        if (this.mHasInit) {
            return;
        }
        this.mHasInit = true;
        h.execute(new bg() { // from class: com.kwad.sdk.a.a.b.1
            /* JADX WARN: Not initialized variable reg: 4, insn: 0x00a3: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:164), block:B:86:0x00a3 */
            /* JADX WARN: Removed duplicated region for block: B:59:0x0121 A[Catch: all -> 0x00c8, TryCatch #5 {all -> 0x00c8, blocks: (B:3:0x0002, B:8:0x000a, B:12:0x0012, B:50:0x00c4, B:56:0x00fc, B:57:0x011d, B:59:0x0121, B:73:0x0125, B:74:0x0128, B:68:0x0116, B:70:0x011a, B:87:0x0129, B:88:0x012c, B:82:0x00e5), top: B:2:0x0002 }] */
            /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
            @Override // com.kwad.sdk.utils.bg
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void doTask() {
                /*
                    Method dump skipped, instructions count: 305
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.a.a.b.AnonymousClass1.doTask():void");
            }
        });
    }
}
