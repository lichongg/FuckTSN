package com.kwad.library.solder.lib;

import android.content.Context;
import com.kwad.library.solder.lib.ext.PluginError;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class g extends com.kwad.library.solder.lib.a.a {
    @Override // com.kwad.library.solder.lib.a.a
    public void i(Context context, String str) {
        e(new File(str));
    }

    public g(String str) {
        super(str);
    }

    private static void e(File file) {
        if (file.exists()) {
            if (!file.getAbsolutePath().trim().startsWith("/data/")) {
                file.getAbsolutePath();
                return;
            }
            return;
        }
        throw new PluginError.LoadError("Apk file not exist.", 4001);
    }
}
