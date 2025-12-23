package com.kwad.library.solder.lib.c;

import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b implements Comparable<b> {
    public String arA;
    public boolean arB = false;
    public boolean arC = true;
    public HashMap<String, String> arD = new HashMap<>(10);
    public List<String> arE;
    public List<String> arF;
    public ClassLoader arG;
    public String ara;
    public boolean arb;
    public String arx;
    public String ary;
    public long arz;
    public boolean enable;
    public String version;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NonNull b bVar) {
        return -this.version.compareTo(bVar.version);
    }

    public final String toString() {
        return "RemotePluginInfo{pluginId='" + this.arx + "', version='" + this.version + "', downloadUrl='" + this.ary + "', fileSize=" + this.arz + ", enable=" + this.enable + ", md5sum='" + this.arA + "', onlyWifiDownload=" + this.arB + ", onlyWifiRetryDownload=" + this.arC + ", soMd5s=" + this.arD + ", hostPackages=" + this.arE + ", hostInterfaces=" + this.arF + '}';
    }
}
