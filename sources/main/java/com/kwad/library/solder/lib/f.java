package com.kwad.library.solder.lib;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.library.solder.lib.a.f;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.w;
import com.stub.StubApp;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class f implements com.kwad.library.solder.lib.a.f {
    private f.a aqC;
    private final Context mContext;

    @Override // com.kwad.library.solder.lib.a.f
    public final com.kwad.library.solder.lib.a.f a(f.a aVar) {
        this.aqC = aVar;
        return this;
    }

    private static void a(com.kwad.library.solder.lib.a.e eVar, PluginError.UpdateError updateError) {
        eVar.getState();
        eVar.ch(1);
        eVar.j(updateError);
        eVar.zZ().zQ().c(eVar, updateError);
    }

    @Override // com.kwad.library.solder.lib.a.f
    public final boolean k(@NonNull com.kwad.library.solder.lib.a.e eVar) {
        eVar.Ad();
        eVar.bV("Update");
        e(eVar);
        if (eVar.Ae()) {
            eVar.zZ().zP().bN(eVar.Ad());
        }
        if (eVar.isCanceled()) {
            f(eVar);
            return false;
        }
        try {
            eVar.zZ().zP().zK();
            if (eVar.Ai()) {
                try {
                    File e6 = eVar.zZ().zP().e(eVar.Aj(), false);
                    if (eVar.isCanceled()) {
                        f(eVar);
                        return false;
                    }
                    try {
                        w.a(this.mContext, eVar.Aj(), e6);
                        eVar.bW(e6.getAbsolutePath());
                        eVar.ch(3);
                        l(eVar);
                    } catch (Throwable th) {
                        a.e("PluginUpdaterImpl", th);
                        a(eVar, new PluginError.UpdateError(th, PluginError.ERROR_UPD_EXTRACT));
                    }
                } catch (Throwable th2) {
                    th2.getLocalizedMessage();
                    a(eVar, new PluginError.UpdateError(th2, 2003));
                    return false;
                }
            } else {
                eVar.Ad();
                eVar.getDownloadUrl();
                try {
                    File e7 = eVar.zZ().zP().e(eVar.getDownloadUrl(), eVar.zZ().zM().Av());
                    if (eVar.Ak() != null && e7.exists() && TextUtils.equals(al.getFileMD5Digest(e7), eVar.Ak())) {
                        eVar.bW(e7.getAbsolutePath());
                        eVar.ch(4);
                        l(eVar);
                        return true;
                    }
                    try {
                        a(eVar, e7);
                        eVar.bW(e7.getAbsolutePath());
                        eVar.ch(4);
                        l(eVar);
                    } catch (PluginError.CancelError unused) {
                        f(eVar);
                        return false;
                    } catch (PluginError.UpdateError e8) {
                        a.e("PluginUpdaterImpl", "Download plugin fail, error = " + e8.getLocalizedMessage());
                        eVar.j(e8);
                        a(eVar, e8);
                        return false;
                    }
                } catch (Throwable th3) {
                    a.e("PluginUpdaterImpl", "Can not get temp file, error = " + th3.getLocalizedMessage());
                    a(eVar, new PluginError.UpdateError(th3, 2003));
                    return false;
                }
            }
            return true;
        } catch (Throwable th4) {
            a.e("PluginUpdaterImpl", th4);
            a(eVar, new PluginError.UpdateError(th4, PluginError.ERROR_UPD_CAPACITY));
            return false;
        }
    }

    f(Context context) {
        this.mContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    private static void e(com.kwad.library.solder.lib.a.e eVar) {
        eVar.getState();
        eVar.zZ().zQ().o(eVar);
    }

    private static void f(com.kwad.library.solder.lib.a.e eVar) {
        eVar.getState();
        eVar.ch(0);
        eVar.zZ().zQ().n(eVar);
    }

    private static void l(com.kwad.library.solder.lib.a.e eVar) {
        eVar.getState();
        eVar.zZ().zQ().p(eVar);
    }

    private void a(com.kwad.library.solder.lib.a.e eVar, File file) {
        System.currentTimeMillis();
        eVar.Ad();
        f.a aVar = this.aqC;
        if (aVar != null) {
            aVar.a(eVar, file);
            System.currentTimeMillis();
            eVar.Ad();
            return;
        }
        throw new PluginError.UpdateError("update ", PluginError.ERROR_UPD_NO_DOWNLOADER);
    }
}
