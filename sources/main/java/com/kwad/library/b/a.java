package com.kwad.library.b;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import com.kwad.library.b.a.b;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.h;
import com.kwad.sdk.utils.w;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends h {
    private b apS;
    private Resources apT;

    private b a(File file, File file2) {
        if (Build.VERSION.SDK_INT < 26) {
            if (!file.canRead()) {
                file.setReadable(true);
            }
            if (!file.canWrite()) {
                file.setWritable(true);
            }
            if (!file.canRead() || !file.canWrite()) {
                file = null;
            }
        }
        File file3 = file;
        com.kwad.library.b.a.a aVar = new com.kwad.library.b.a.a((BaseDexClassLoader) a.class.getClassLoader());
        String absolutePath = file2.getAbsolutePath();
        String absolutePath2 = this.aqK.getAbsolutePath();
        com.kwad.library.solder.lib.c.b bVar = this.aqQ;
        return new b(aVar, absolutePath, file3, absolutePath2, bVar.arF, bVar.arE);
    }

    private File d(File file) {
        File file2 = new File(file.getParentFile(), this.aqp.Ap());
        w.Y(file2);
        return file2;
    }

    public final Resources getResources() {
        return this.apT;
    }

    public final b zI() {
        return this.apS;
    }

    public a(String str) {
        super(str);
    }

    @Override // com.kwad.library.solder.lib.h, com.kwad.library.solder.lib.g, com.kwad.library.solder.lib.a.a
    public final void i(Context context, String str) {
        super.i(context, str);
        File file = new File(str);
        try {
            File d6 = d(file);
            try {
                if (Build.VERSION.SDK_INT >= 34 && context != null && context.getApplicationInfo().targetSdkVersion >= 34) {
                    file.setReadOnly();
                    d6.setReadOnly();
                }
            } catch (Throwable unused) {
            }
            this.apS = a(d6, file);
            try {
                this.apT = com.kwad.library.b.b.a.a(context, context.getResources(), str);
                Objects.toString(this.apS);
                Objects.toString(this.apT);
            } catch (Exception e6) {
                Log.getStackTraceString(e6);
                throw new PluginError.LoadError(e6, 4006);
            }
        } catch (IOException e7) {
            throw new PluginError.LoadError(e7, 4002);
        }
    }
}
