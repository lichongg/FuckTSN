package com.google.android.gms.internal.mlkit_vision_mediapipe;

import com.google.research.xeno.effect.AssetRegistry;
import com.google.research.xeno.effect.AssetRegistryService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzhp {
    private static final zzo zza = zzo.zzh("com/google/mediapipe/framework/Graph");
    private final List zzc = new ArrayList();
    private final Map zzd = new HashMap();
    private final Map zze = new HashMap();
    private boolean zzf = false;
    private boolean zzg = false;
    private final Map zzh = new HashMap();
    private final Object zzi = new Object();
    private long zzb = zzo();

    private final native long zzo();

    private final native long zzp(long j6);

    private final native void zzq(long j6, List list, zzhz zzhzVar, boolean z5);

    private final native void zzr(long j6);

    private final native void zzs(long j6, byte[] bArr);

    private final native void zzt(long j6, String str, long j7, long j8);

    private final native void zzu(long j6);

    private final native void zzv(long j6, String[] strArr, long[] jArr, String[] strArr2, long[] jArr2);

    private final native void zzw(long j6);

    private final native void zzx(long j6);

    public final synchronized long zza() {
        return this.zzb;
    }

    public final synchronized void zzc(String str, zzhv zzhvVar, long j6) {
        Throwable th;
        try {
            try {
                zzb.zzc(this.zzb != 0, "Invalid context, tearDown() might have been called.");
                if (this.zzg) {
                    zzt(this.zzb, str, zzhvVar.zza(), j6);
                    zzhvVar.zze();
                    return;
                }
                try {
                    zzhv zzc = zzhvVar.zzc();
                    if (!this.zzh.containsKey(str)) {
                        this.zzh.put(str, new ArrayList());
                    }
                    List list = (List) this.zzh.get(str);
                    if (list.size() <= 20) {
                        list.add(new zzho(zzc, Long.valueOf(j6), null));
                        zzhvVar.zze();
                        return;
                    }
                    for (Map.Entry entry : this.zze.entrySet()) {
                        if (entry.getValue() == null) {
                            ((zzk) ((zzk) zza.zzc()).zzg("com/google/mediapipe/framework/Graph", "addPacketToBuffer", IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED_BASELINE, "Graph.java")).zzn("Stream: %s might be missing.", entry.getKey());
                        }
                    }
                    throw new RuntimeException("Graph is not started because of missing streams");
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            th = th;
            throw th;
        }
    }

    public final synchronized void zzd(List list, zzhz zzhzVar) {
        zze(list, zzhzVar, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0019, code lost:
    
        if (r7.zzf == false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void zze(java.util.List r8, com.google.android.gms.internal.mlkit_vision_mediapipe.zzhz r9, boolean r10) {
        /*
            r7 = this;
            monitor-enter(r7)
            long r0 = r7.zzb     // Catch: java.lang.Throwable -> L38
            r2 = 0
            r10 = 1
            r4 = 0
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto Ld
            r0 = 1
            goto Le
        Ld:
            r0 = 0
        Le:
            java.lang.String r1 = "Invalid context, tearDown() might have been called already."
            com.google.android.gms.internal.mlkit_vision_mediapipe.zzb.zzc(r0, r1)     // Catch: java.lang.Throwable -> L38
            boolean r0 = r7.zzg     // Catch: java.lang.Throwable -> L38
            if (r0 != 0) goto L1c
            boolean r0 = r7.zzf     // Catch: java.lang.Throwable -> L1e
            if (r0 != 0) goto L1c
            goto L22
        L1c:
            r10 = 0
            goto L22
        L1e:
            r0 = move-exception
            r8 = r0
            r1 = r7
            goto L3b
        L22:
            com.google.android.gms.internal.mlkit_vision_mediapipe.zzb.zzb(r10)     // Catch: java.lang.Throwable -> L38
            java.util.List r10 = r7.zzc     // Catch: java.lang.Throwable -> L38
            r10.add(r9)     // Catch: java.lang.Throwable -> L38
            long r2 = r7.zzb     // Catch: java.lang.Throwable -> L38
            r6 = 0
            r1 = r7
            r4 = r8
            r5 = r9
            r1.zzq(r2, r4, r5, r6)     // Catch: java.lang.Throwable -> L35
            monitor-exit(r7)
            return
        L35:
            r0 = move-exception
        L36:
            r8 = r0
            goto L3b
        L38:
            r0 = move-exception
            r1 = r7
            goto L36
        L3b:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L35
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_mediapipe.zzhp.zze(java.util.List, com.google.android.gms.internal.mlkit_vision_mediapipe.zzhz, boolean):void");
    }

    public final synchronized void zzf() {
        zzb.zzc(this.zzb != 0, "Invalid context, tearDown() might have been called.");
        zzr(this.zzb);
    }

    public final synchronized void zzg(zzgf zzgfVar) {
        zzh(zzgfVar.zzk());
    }

    public final synchronized void zzh(byte[] bArr) {
        zzb.zzc(this.zzb != 0, "Invalid context, tearDown() might have been called already.");
        zzs(this.zzb, bArr);
    }

    public final synchronized void zzi(Map map) {
        try {
            boolean z5 = true;
            zzb.zzc(this.zzb != 0, "Invalid context, tearDown() might have been called.");
            if (this.zzg || this.zzf) {
                z5 = false;
            }
            zzb.zzb(z5);
            for (Map.Entry entry : map.entrySet()) {
                this.zzd.put((String) entry.getKey(), ((zzhv) entry.getValue()).zzc());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zzj(zzhs zzhsVar, Object obj) {
        ((AssetRegistryService) zzhsVar).nativeInstallServiceObject(this.zzb, ((AssetRegistry) obj).zza());
    }

    public final synchronized void zzk() {
        zzb.zzc(this.zzb != 0, "Invalid context, tearDown() might have been called.");
        this.zzf = true;
        Iterator it = this.zze.entrySet().iterator();
        while (it.hasNext()) {
            if (((Map.Entry) it.next()).getValue() == null) {
                ((zzk) ((zzk) zza.zzb()).zzg("com/google/mediapipe/framework/Graph", "startRunningGraph", 333, "Graph.java")).zzm("MediaPipe graph won't start until all stream headers are available.");
                return;
            }
        }
        String[] strArr = new String[this.zzd.size()];
        long[] jArr = new long[this.zzd.size()];
        zzy(this.zzd, strArr, jArr);
        String[] strArr2 = new String[this.zze.size()];
        long[] jArr2 = new long[this.zze.size()];
        zzy(this.zze, strArr2, jArr2);
        zzv(this.zzb, strArr, jArr, strArr2, jArr2);
        this.zzg = true;
        if (this.zzh.isEmpty()) {
            return;
        }
        for (Map.Entry entry : this.zzh.entrySet()) {
            ArrayList arrayList = (ArrayList) entry.getValue();
            int size = arrayList.size();
            for (int i6 = 0; i6 < size; i6++) {
                zzho zzhoVar = (zzho) arrayList.get(i6);
                try {
                    zzt(this.zzb, (String) entry.getKey(), zzhoVar.zza.zza(), zzhoVar.zzb.longValue());
                    zzhoVar.zza.zze();
                } catch (zzhu e6) {
                    ((zzk) ((zzk) zza.zzc()).zzg("com/google/mediapipe/framework/Graph", "moveBufferedPacketsToInputStream", 597, "Graph.java")).zzo("AddPacket for stream: %s failed: %s.", entry.getKey(), e6.getMessage());
                    throw e6;
                }
            }
        }
        this.zzh.clear();
    }

    public final synchronized void zzl() {
        try {
            zzb.zzc(this.zzb != 0, "Invalid context, tearDown() might have been called already.");
            Iterator it = this.zzd.entrySet().iterator();
            while (it.hasNext()) {
                ((zzhv) ((Map.Entry) it.next()).getValue()).zze();
            }
            this.zzd.clear();
            for (Map.Entry entry : this.zze.entrySet()) {
                if (entry.getValue() != null) {
                    ((zzhv) entry.getValue()).zze();
                }
            }
            this.zze.clear();
            Iterator it2 = this.zzh.entrySet().iterator();
            while (it2.hasNext()) {
                ArrayList arrayList = (ArrayList) ((Map.Entry) it2.next()).getValue();
                int size = arrayList.size();
                for (int i6 = 0; i6 < size; i6++) {
                    ((zzho) arrayList.get(i6)).zza.zze();
                }
            }
            this.zzh.clear();
            synchronized (this.zzi) {
                try {
                    long j6 = this.zzb;
                    if (j6 != 0) {
                        zzu(j6);
                        this.zzb = 0L;
                    }
                } finally {
                }
            }
            this.zzc.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zzm() {
        zzb.zzc(this.zzb != 0, "Invalid context, tearDown() might have been called.");
        zzw(this.zzb);
    }

    public final synchronized void zzn() {
        zzb.zzc(this.zzb != 0, "Invalid context, tearDown() might have been called.");
        zzx(this.zzb);
    }

    public final zzhr zzb() {
        zzb.zzc(this.zzb != 0, "Invalid context, tearDown() might have been called already.");
        return new zzhr(zzp(this.zzb), this);
    }

    private static void zzy(Map map, String[] strArr, long[] jArr) {
        if (map.size() == strArr.length && map.size() == jArr.length) {
            int i6 = 0;
            for (Map.Entry entry : map.entrySet()) {
                strArr[i6] = (String) entry.getKey();
                jArr[i6] = ((zzhv) entry.getValue()).zza();
                i6++;
            }
            return;
        }
        throw new RuntimeException("Input array length doesn't match the map size!");
    }
}
