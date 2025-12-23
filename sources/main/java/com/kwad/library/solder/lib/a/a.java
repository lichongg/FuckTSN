package com.kwad.library.solder.lib.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.library.solder.lib.i;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class a {
    protected File aqK;
    protected String aqL;
    protected String aqM;
    private final String aqP;
    protected com.kwad.library.solder.lib.c.b aqQ;
    protected String mVersion;
    private final byte[] aqO = new byte[0];
    private boolean aqN = false;
    protected com.kwad.library.solder.lib.ext.c aqp = i.zS().zM();

    protected abstract void i(Context context, String str);

    private void zW() {
        if (this.aqN) {
            return;
        }
        synchronized (this.aqO) {
            this.aqN = true;
        }
    }

    public final a a(@NonNull com.kwad.library.solder.lib.c.b bVar) {
        this.aqQ = bVar;
        return this;
    }

    public final void bS(String str) {
        this.mVersion = str;
    }

    public final void bT(String str) {
        this.aqM = str;
    }

    public final void bU(String str) {
        this.aqL = str;
    }

    public final String getId() {
        return this.aqM;
    }

    public final String getVersion() {
        return this.mVersion;
    }

    public final boolean isLoaded() {
        boolean z5;
        if (this.aqN) {
            return true;
        }
        synchronized (this.aqO) {
            z5 = this.aqN;
        }
        return z5;
    }

    public String toString() {
        return "Plugin{, ApkPath = '" + this.aqP + "'}";
    }

    public final String zX() {
        return this.aqP;
    }

    public final String zY() {
        com.kwad.library.solder.lib.c.b bVar = this.aqQ;
        if (bVar != null) {
            return bVar.arA;
        }
        return null;
    }

    public a(String str) {
        this.aqP = str;
        this.aqL = str;
    }

    public final void n(Context context, String str) {
        i(context, str);
        zW();
    }
}
