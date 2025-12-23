package com.kwad.library.solder.lib;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.w;
import com.stub.StubApp;
import java.io.File;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class d implements com.kwad.library.solder.lib.a.c {
    private final ConcurrentHashMap<String, com.kwad.library.solder.lib.a.a> aqq = new ConcurrentHashMap<>();
    private final Context mContext;

    private synchronized void a(String str, com.kwad.library.solder.lib.a.a aVar) {
        if (aVar != null) {
            if (aVar.isLoaded()) {
                this.aqq.put(str, aVar);
            }
        }
    }

    private static void b(com.kwad.library.solder.lib.a.e eVar) {
        eVar.getState();
        eVar.ch(7);
        eVar.zZ().zQ().r(eVar);
    }

    @Override // com.kwad.library.solder.lib.a.c
    public final synchronized com.kwad.library.solder.lib.a.a bP(String str) {
        com.kwad.library.solder.lib.a.a aVar = this.aqq.get(str);
        if (aVar != null) {
            if (!aVar.isLoaded()) {
                return null;
            }
        }
        return aVar;
    }

    d(Context context) {
        this.mContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    private static void c(com.kwad.library.solder.lib.a.e eVar) {
        eVar.getState();
        eVar.zZ().zQ().q(eVar);
    }

    private static void f(com.kwad.library.solder.lib.a.e eVar) {
        eVar.getState();
        eVar.ch(0);
        eVar.zZ().zQ().n(eVar);
    }

    private com.kwad.library.solder.lib.a.a h(com.kwad.library.solder.lib.a.e eVar) {
        b(eVar);
        com.kwad.library.solder.lib.a.a a6 = eVar.bY(eVar.Ag()).a(eVar.Al());
        String zX = a6.zX();
        File file = new File(zX);
        eVar.Ad();
        com.kwad.library.solder.lib.a.d zZ = eVar.zZ();
        if (file.exists()) {
            String Ad = eVar.Ad();
            String version = eVar.getVersion();
            com.kwad.library.solder.lib.a.a bP = bP(Ad);
            if (bP != null) {
                a(eVar);
                return bP;
            }
            a6.bT(Ad);
            a6.bS(version);
            if (zZ.zP().a(Ad, version, eVar.Ak())) {
                String G = zZ.zP().G(Ad, version);
                if (w.gQ(G)) {
                    a6.bU(G);
                    a6.n(this.mContext, G);
                    a(Ad, a6);
                    a(eVar);
                    return a6;
                }
            }
            String b6 = zZ.zP().b(a6);
            a6.bU(b6);
            a6.n(this.mContext, b6);
            a(Ad, a6);
            if (zX.endsWith(zZ.zM().As())) {
                w.delete(zX);
            }
            a(eVar);
            return a6;
        }
        throw new PluginError.LoadError("Apk file not exist.", 3001);
    }

    @Override // com.kwad.library.solder.lib.a.c
    public final void g(@NonNull com.kwad.library.solder.lib.a.e eVar) {
        eVar.Ad();
        eVar.bV("Load");
        c(eVar);
        if (eVar.isCanceled()) {
            f(eVar);
            return;
        }
        com.kwad.library.solder.lib.a.a aVar = this.aqq.get(eVar.Ad());
        if (aVar != null && aVar.isLoaded()) {
            eVar.c(aVar);
            eVar.Ad();
            aVar.zX();
            a(eVar, aVar);
            return;
        }
        com.kwad.library.solder.lib.c.b Al = eVar.Al();
        if (Al == null) {
            b(eVar, new PluginError.LoadError("not pluginInfo", PluginError.ERROR_UPD_REQUEST));
            return;
        }
        List<com.kwad.library.solder.lib.c.a> Am = eVar.Am();
        com.kwad.library.solder.lib.c.a aVar2 = null;
        if (Am != null && !Am.isEmpty()) {
            for (com.kwad.library.solder.lib.c.a aVar3 : Am) {
                if (eVar.getVersion().equals(aVar3.version)) {
                    aVar2 = aVar3;
                } else {
                    eVar.zZ().zP().E(eVar.Ad(), aVar3.version);
                }
            }
        }
        if (aVar2 == null) {
            if (!ao.isWifiConnected(this.mContext) && (Al.arB || (Al.arC && eVar.Af() > 0))) {
                b(eVar, new PluginError.NotWifiDownloadError("It can be downloaded only on WiFi", PluginError.ERROR_UPD_NOT_WIFI_DOWNLOAD));
                return;
            }
            try {
                if (!eVar.zZ().zO().k(eVar)) {
                    return;
                }
            } catch (Throwable th) {
                b(eVar, new PluginError.UpdateError(th, PluginError.ERROR_UPD_REQUEST));
                return;
            }
        } else {
            String G = eVar.zZ().zP().G(aVar2.arx, aVar2.version);
            eVar.bW(G);
            eVar.bX(G);
            eVar.ch(2);
            eVar.bS(aVar2.version);
        }
        if (eVar.getState() != 2 && eVar.getState() != 3 && eVar.getState() != 4) {
            b(eVar, new PluginError.InstallError("state exception", 2002));
            return;
        }
        String Ag = eVar.Ag();
        eVar.Ad();
        if (TextUtils.isEmpty(Ag)) {
            b(eVar, new PluginError.LoadError("path not found", PluginError.ERROR_UPD_FILE_NOT_FOUND));
            return;
        }
        if (eVar.isCanceled()) {
            f(eVar);
            return;
        }
        try {
            com.kwad.library.solder.lib.a.a h6 = h(eVar);
            eVar.c(h6);
            eVar.Ad();
            a(eVar, h6);
        } catch (PluginError.InstallError e6) {
            e = e6;
            b(eVar, e);
        } catch (PluginError.LoadError e7) {
            e = e7;
            b(eVar, e);
        } catch (Throwable th2) {
            a.e("PluginLoaderImpl", "load plugin failed, path = " + Ag, th2);
            b(eVar, new PluginError.InstallError("load or install plugin failed:" + th2.getMessage(), 4004));
        }
    }

    private static void b(com.kwad.library.solder.lib.a.e eVar, PluginError pluginError) {
        eVar.getState();
        eVar.ch(6);
        eVar.j(pluginError);
        eVar.zZ().zQ().c(eVar, pluginError);
    }

    private static void a(com.kwad.library.solder.lib.a.e eVar) {
        eVar.getState();
        eVar.ch(8);
        eVar.zZ().zQ().a(eVar);
    }

    private static void a(com.kwad.library.solder.lib.a.e eVar, com.kwad.library.solder.lib.a.a aVar) {
        eVar.getState();
        eVar.ch(5);
        eVar.zZ().zQ().b(eVar, aVar);
    }
}
