package com.google.mlkit.vision.mediapipe;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zzee;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zzfw;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zzgc;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zzgf;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zzgk;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zzgl;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zzhk;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zzhl;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zzhp;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zzhu;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zzhv;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zziq;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zzis;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zzkb;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zzlb;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.mlkit.common.MlKitException;
import com.google.research.xeno.effect.AssetRegistry;
import com.google.research.xeno.effect.AssetRegistryService;
import com.snail.antifake.deviceid.e;
import com.stub.StubApp;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzg {
    public static final /* synthetic */ int zza = 0;
    private static final String zzb = "zzg";
    private final MediaPipeGraphRunnerConfig zzc;

    @Nullable
    private zzhp zzd;
    private zzhl zze;
    private final AtomicBoolean zzf = new AtomicBoolean(false);
    private long zzg = -1;
    private ConcurrentHashMap zzh;

    private final void zzg() {
        ((zzhp) Preconditions.checkNotNull(this.zzd)).zzk();
        ((zzhp) Preconditions.checkNotNull(this.zzd)).zzn();
    }

    public final Object zza(List list, Converter converter) throws MlKitException {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        zze zzeVar = new zze(this, taskCompletionSource, converter);
        if (this.zzd == null) {
            throw new MlKitException("Couldn't send input frame. Possible reason: load() hasn't been called yet.", 13);
        }
        if (!this.zzf.getAndSet(true)) {
            zzg();
        }
        Preconditions.checkArgument(list.size() == this.zzc.zzc().size());
        int i6 = 0;
        while (i6 < list.size() - 1) {
            long zza2 = ((MediaPipeInput) list.get(i6)).zza();
            i6++;
            Preconditions.checkArgument(zza2 == ((MediaPipeInput) list.get(i6)).zza(), "MediaPipeInputs doesn't have same timestamp.");
        }
        long zza3 = ((MediaPipeInput) list.get(0)).zza();
        this.zzh.put(Long.valueOf(zza3), zzeVar);
        for (int i7 = 0; i7 < list.size(); i7++) {
            zzhv zzb2 = ((MediaPipeInput) list.get(i7)).zzb(this.zze);
            try {
                if (zza3 <= this.zzg) {
                    throw new MlKitException("Timestamp must be monotonically increasing. Last timestampUs: " + this.zzg + ", Current: " + zza3, 13);
                }
                ((zzhp) Preconditions.checkNotNull(this.zzd)).zzc((String) this.zzc.zzc().get(i7), zzb2, zza3);
            } catch (zzhu e6) {
                zzb2.zze();
                this.zzh.remove(Long.valueOf(zza3));
                String valueOf = String.valueOf(e6.getMessage());
                TaskCompletionSource taskCompletionSource2 = zzeVar.zza;
                String concat = "Mediapipe failed with message: ".concat(valueOf);
                taskCompletionSource2.setException(new Exception(concat));
                throw new MlKitException(concat, 13);
            }
        }
        zziq.zze("From creating image packet to addConsumablePacketToInputStream").zzd(zza3);
        this.zzg = zza3;
        try {
            return Tasks.await(taskCompletionSource.getTask());
        } catch (InterruptedException | ExecutionException e7) {
            throw new MlKitException(com.google.android.gms.internal.mlkit_vision_mediapipe.zzc.zzb(e7.getMessage()), 13);
        }
    }

    final void zzc() {
        String str;
        if (this.zzf.getAndSet(false)) {
            try {
                zzis.zza();
                if (zzis.zzb()) {
                    List<zzfw> zza2 = ((zzhp) Preconditions.checkNotNull(this.zzd)).zzb().zza();
                    Collections.sort(zza2, new Comparator() { // from class: com.google.mlkit.vision.mediapipe.zzd
                        @Override // java.util.Comparator
                        public final int compare(Object obj, Object obj2) {
                            int i6 = zzg.zza;
                            return ((zzfw) obj).zze().compareTo(((zzfw) obj2).zze());
                        }
                    });
                    long j6 = 0;
                    for (zzfw zzfwVar : zza2) {
                        if (zzfwVar.zzd().zza() > 0 && zzfwVar.zzd().zzc(0) > 0) {
                            j6 += zzfwVar.zzd().zze();
                        }
                    }
                    String str2 = "\n\t\t\t\tPercent\tCount\tAvgProcessUs\n--------------------------------------------------------------------";
                    for (zzfw zzfwVar2 : zza2) {
                        String str3 = str2 + e.f37542d + zzfwVar2.zze() + ":\n\t\t\t\t";
                        if (zzfwVar2.zzd().zza() <= 0 || zzfwVar2.zzd().zzc(0) <= 0) {
                            str = "---";
                        } else {
                            Preconditions.checkState(zzfwVar2.zzd().zzd() == 1);
                            long zze = zzfwVar2.zzd().zze();
                            long zzc = zzfwVar2.zzd().zzc(0);
                            str = String.format(Locale.US, "%d\t%d\t%d", Long.valueOf((100 * zze) / j6), Long.valueOf(zzc), Long.valueOf(zze / zzc));
                        }
                        str2 = str3.concat(str);
                    }
                    zzis.zza();
                }
                ((zzhp) Preconditions.checkNotNull(this.zzd)).zzf();
                ((zzhp) Preconditions.checkNotNull(this.zzd)).zzm();
            } catch (zzhu unused) {
            }
            try {
                ((zzhp) Preconditions.checkNotNull(this.zzd)).zzl();
            } catch (zzhu unused2) {
            }
        }
    }

    final void zzd() throws MlKitException {
        try {
            zzhk.zza(StubApp.getOrigApplicationContext(this.zzc.zza().getApplicationContext()));
            try {
                try {
                    InputStream open = StubApp.getOrigApplicationContext(this.zzc.zza().getApplicationContext()).getAssets().open(this.zzc.zzb());
                    byte[] zza2 = zzee.zza(open);
                    open.close();
                    zzgf zzc = zzgf.zzc(zza2, zzkb.zza());
                    zzis.zza();
                    if (zzis.zzb()) {
                        zzgk zza3 = zzgl.zza();
                        zza3.zza(true);
                        zzgl zzglVar = (zzgl) zza3.zzk();
                        zzgc zzgcVar = (zzgc) zzc.zzq();
                        zzgcVar.zza(zzglVar);
                        zzc = (zzgf) zzgcVar.zzk();
                    }
                    zzhp zzhpVar = new zzhp();
                    zzhpVar.zzg(zzc);
                    Map zze = this.zzc.zze();
                    if (zze != null) {
                        zzhpVar.zzj(new AssetRegistryService(), new AssetRegistry(zze));
                    }
                    this.zzd = zzhpVar;
                    this.zzh = new ConcurrentHashMap();
                    this.zze = new zzhl(this.zzd);
                    Preconditions.checkState(!this.zzf.get(), "setInputSidePackets must be called before the graph is started");
                    Preconditions.checkState(this.zze != null, "setInputSidePackets must be called after packetCreator is created");
                    Map zzf = this.zzc.zzf();
                    if (zzf != null && !zzf.isEmpty()) {
                        HashMap hashMap = new HashMap();
                        for (Map.Entry entry : zzf.entrySet()) {
                            hashMap.put((String) entry.getKey(), ((MediaPipeInput) entry.getValue()).zzb(this.zze));
                        }
                        ((zzhp) Preconditions.checkNotNull(this.zzd)).zzi(hashMap);
                    }
                    ((zzhp) Preconditions.checkNotNull(this.zzd)).zzd(this.zzc.zzd(), new zzf(this));
                } catch (IOException e6) {
                    throw new RuntimeException(e6);
                }
            } catch (zzlb e7) {
                throw new MlKitException(com.google.android.gms.internal.mlkit_vision_mediapipe.zzc.zzb(e7.getLocalizedMessage()), 13);
            }
        } catch (zzhu e8) {
            throw new MlKitException("Error loading MediaPipe graph. ".concat(String.valueOf(e8.getLocalizedMessage())), 13);
        }
    }

    final void zze() {
        if (this.zzf.getAndSet(true)) {
            return;
        }
        zzg();
    }

    final void zzf(String str, MediaPipeInput mediaPipeInput) throws MlKitException {
        zzhv zzb2 = mediaPipeInput.zzb((zzhl) Preconditions.checkNotNull(this.zze));
        try {
            ((zzhp) Preconditions.checkNotNull(this.zzd)).zzc(str, zzb2, mediaPipeInput.zza());
        } catch (zzhu e6) {
            zzb2.zze();
            throw new MlKitException("Mediapipe failed with message: ".concat(String.valueOf(e6.getMessage())), 13);
        }
    }

    static {
        try {
            zzis.zza();
            System.loadLibrary("xeno_native");
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    zzg(MediaPipeGraphRunnerConfig mediaPipeGraphRunnerConfig) {
        this.zzc = mediaPipeGraphRunnerConfig;
    }
}
