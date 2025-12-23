package com.kwad.library.solder.lib.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.library.solder.lib.a.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class e<P extends a> {
    protected int aqS;
    protected String aqU;
    protected String aqV;
    protected boolean aqW;
    protected P aqX;
    protected com.kwad.library.solder.lib.ext.b aqY;
    protected Throwable aqZ;
    protected String aqj;
    protected d aqz;
    protected String ara;
    protected boolean arb;
    protected long arc;
    protected String ard;
    protected List<com.kwad.library.solder.lib.c.a> are;
    protected com.kwad.library.solder.lib.c.b arf;
    protected String mDownloadUrl;
    protected String mVersion;
    protected int mState = -1;
    protected int aqR = 0;
    private final byte[] aqO = new byte[0];
    protected StringBuffer aqT = new StringBuffer(String.valueOf(-1));

    public final boolean Ac() {
        ch(-1);
        this.are = null;
        int i6 = this.aqR + 1;
        this.aqR = i6;
        return i6 <= this.aqS;
    }

    public final e a(d dVar) {
        this.aqz = dVar;
        return this;
    }

    public abstract P bY(String str);

    private List<com.kwad.library.solder.lib.c.a> b(String str, String str2, String str3) {
        String[] list;
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(this.aqz.zP().bO(str));
            if (file.exists() && (list = file.list()) != null && list.length != 0) {
                for (String str4 : list) {
                    if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str2) || !str2.equals(str4)) {
                        this.aqz.zP().E(str, str4);
                    } else if (this.aqz.zP().a(str, str4, str3)) {
                        com.kwad.library.solder.lib.c.a aVar = new com.kwad.library.solder.lib.c.a();
                        aVar.arx = str;
                        aVar.version = str4;
                        aVar.tq = true;
                        arrayList.add(aVar);
                    } else {
                        this.aqz.zP().E(str, str4);
                    }
                }
                Collections.sort(arrayList);
            }
        }
        return arrayList;
    }

    public final String Aa() {
        return this.aqT.toString();
    }

    @Nullable
    public final Throwable Ab() {
        return this.aqZ;
    }

    @Nullable
    public final String Ad() {
        return this.aqj;
    }

    public final boolean Ae() {
        return this.aqW;
    }

    public final int Af() {
        return this.aqR;
    }

    @Nullable
    public final String Ag() {
        return !TextUtils.isEmpty(this.aqU) ? this.aqU : this.aqV;
    }

    @Nullable
    public final com.kwad.library.solder.lib.ext.b Ah() {
        return this.aqY;
    }

    public final boolean Ai() {
        return this.arb;
    }

    public final String Aj() {
        return this.ara;
    }

    public final String Ak() {
        return this.ard;
    }

    public final com.kwad.library.solder.lib.c.b Al() {
        return this.arf;
    }

    public final void a(com.kwad.library.solder.lib.ext.b bVar) {
        this.aqY = bVar;
    }

    public final void bS(String str) {
        this.mVersion = str;
    }

    public final void bW(String str) {
        this.aqU = str;
    }

    public final void bX(String str) {
        this.aqV = str;
    }

    public final void c(P p5) {
        this.aqX = p5;
    }

    public final void cancel() {
        synchronized (this.aqO) {
            ch(0);
        }
    }

    public final e ch(int i6) {
        synchronized (this.aqO) {
            this.mState = i6;
        }
        return bV(String.valueOf(i6));
    }

    public final void ci(int i6) {
        if (i6 > 0) {
            this.aqS = i6;
        }
    }

    @Nullable
    public final String getDownloadUrl() {
        return this.mDownloadUrl;
    }

    public final int getState() {
        int i6;
        synchronized (this.aqO) {
            i6 = this.mState;
        }
        return i6;
    }

    public final String getVersion() {
        return this.mVersion;
    }

    public final boolean isCanceled() {
        return this.mState == 0;
    }

    public final e j(@NonNull Throwable th) {
        this.aqZ = th;
        return bV(th.getLocalizedMessage());
    }

    @NonNull
    public String toString() {
        return "PluginRequest{mId='" + this.aqj + "'}";
    }

    public final d zZ() {
        return this.aqz;
    }

    public e(com.kwad.library.solder.lib.c.b bVar) {
        this.arf = bVar;
        this.aqj = bVar.arx;
        this.mVersion = bVar.version;
        this.ard = bVar.arA;
        this.arb = bVar.arb;
        this.ara = bVar.ara;
        this.arc = bVar.arz;
        this.mDownloadUrl = bVar.ary;
    }

    public final List<com.kwad.library.solder.lib.c.a> Am() {
        String Ad = Ad();
        if (!TextUtils.isEmpty(Ad) && this.are == null) {
            this.are = b(Ad, getVersion(), Ak());
        }
        return this.are;
    }

    public final e bV(String str) {
        if (!TextUtils.isEmpty(str)) {
            StringBuffer stringBuffer = this.aqT;
            stringBuffer.append(" --> ");
            stringBuffer.append(str);
        }
        return this;
    }
}
