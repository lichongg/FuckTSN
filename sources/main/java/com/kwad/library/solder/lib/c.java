package com.kwad.library.solder.lib;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.w;
import com.stub.StubApp;
import java.io.File;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class c implements com.kwad.library.solder.lib.a.b {
    private final File aqn;
    private final File aqo;
    private final com.kwad.library.solder.lib.ext.c aqp;
    private final Context mContext;

    @Nullable
    private String a(com.kwad.library.solder.lib.a.a aVar) {
        return G(aVar.getId(), aVar.getVersion());
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final File e(String str, boolean z5) {
        String md5;
        if (str == null || (md5 = com.kwad.library.solder.lib.d.b.getMD5(str)) == null) {
            return null;
        }
        if (!z5) {
            return File.createTempFile(md5 + System.currentTimeMillis(), this.aqp.As(), this.aqo);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(md5);
        if (this.aqp.As() != null) {
            sb.append(this.aqp.As());
        }
        File file = new File(this.aqo, sb.toString());
        if (file.exists() || file.createNewFile()) {
            return file;
        }
        return null;
    }

    private String F(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(zL());
        String str3 = File.separator;
        sb.append(str3);
        sb.append(str);
        sb.append(str3);
        sb.append(str2);
        return sb.toString();
    }

    private String zL() {
        return this.aqn.getAbsolutePath();
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final void E(String str, String str2) {
        File file = new File(F(str, str2));
        if (file.exists()) {
            w.T(file);
        }
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final String G(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(zL());
        String str3 = File.separator;
        sb.append(str3);
        sb.append(str);
        sb.append(str3);
        sb.append(str2);
        sb.append(str3);
        sb.append(this.aqp.At());
        return sb.toString();
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final boolean a(String str, String str2, String str3) {
        if (this.aqp.Au()) {
            return false;
        }
        return i(G(str, str2), str3, true);
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final String b(com.kwad.library.solder.lib.a.a aVar) {
        String a6 = a(aVar);
        if (TextUtils.isEmpty(a6)) {
            throw new PluginError.InstallError("Can not get install path.", PluginError.ERROR_INS_INSTALL_PATH);
        }
        aVar.getId();
        File file = new File(a6);
        if (file.exists() && !this.aqp.Au() && i(file.getAbsolutePath(), aVar.zY(), true)) {
            return a6;
        }
        String zX = aVar.zX();
        aVar.getId();
        File file2 = new File(zX);
        if (!file2.exists()) {
            throw new PluginError.InstallError("Plugin file not exist.", 3001);
        }
        aVar.getId();
        if (!i(zX, aVar.zY(), true)) {
            aVar.zY();
            throw new PluginError.InstallError("check plugin md5 fail:" + aVar.zY() + " " + zX, 3003);
        }
        if (file2.renameTo(file)) {
            aVar.getId();
            return a6;
        }
        try {
            zK();
            try {
                w.f(file2, file);
                w.T(file2);
                return a6;
            } catch (Throwable th) {
                a.e("PluginInstallerImpl", th);
                throw new PluginError.InstallError(th, 3004);
            }
        } catch (Throwable th2) {
            a.e("PluginInstallerImpl", th2);
            throw new PluginError.InstallError(th2, 3005);
        }
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final void bN(String str) {
        File file = new File(bO(str));
        if (file.exists()) {
            w.T(file);
        }
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final String bO(@NonNull String str) {
        return zL() + File.separator + str;
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final void zK() {
        if (this.aqn.getFreeSpace() < 10000000) {
            throw new IOException("No enough capacity.");
        }
    }

    c(Context context, com.kwad.library.solder.lib.ext.c cVar) {
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.mContext = origApplicationContext;
        this.aqp = cVar;
        this.aqn = origApplicationContext.getDir(cVar.Ao(), 0);
        this.aqo = origApplicationContext.getCacheDir();
    }

    private static void delete(String str) {
        w.delete(str);
    }

    private boolean i(String str, String str2, boolean z5) {
        if (!w.gR(str)) {
            return false;
        }
        if (TextUtils.isEmpty(str2) || TextUtils.equals(str2, al.getFileMD5Digest(str))) {
            return true;
        }
        delete(str);
        return false;
    }
}
