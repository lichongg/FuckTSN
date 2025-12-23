package com.google.android.gms.internal.mlkit_vision_pose_common;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzxf {

    @Nullable
    private static zzxf zzd;
    private final Executor zze;
    private final Executor zzf;
    private final zzvp zzg;
    private final zzwz zzh;

    @Nullable
    private volatile zzbg zzi;

    @Nullable
    private volatile zzbg zzj;
    private final Map zzk;
    private final zzxk zzl;
    private final zzxi zzm;

    @Nullable
    private String zzn;
    private static final ExecutorService zzb = Executors.newSingleThreadExecutor();
    private static final ExecutorService zzc = Executors.newSingleThreadExecutor();
    public static final long zza = TimeUnit.HOURS.toSeconds(12);

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0026, code lost:
    
        if (r6.after(new java.util.Date(((java.util.Date) r10.second).getTime() + java.util.concurrent.TimeUnit.SECONDS.toMillis(r7))) != false) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final /* synthetic */ void zzi(java.util.Date r6, long r7, com.google.android.gms.internal.mlkit_vision_pose_common.zzvr r9, boolean r10, com.google.android.gms.tasks.TaskCompletionSource r11) {
        /*
            r5 = this;
            r10 = 0
            android.util.Pair r10 = r5.zzl(r9, r10)     // Catch: java.lang.Throwable -> L47 com.google.android.gms.internal.mlkit_vision_pose_common.zzxh -> L49 java.lang.InterruptedException -> L4b java.lang.RuntimeException -> L4d
            r0 = 0
            if (r10 != 0) goto La
        L8:
            r1 = r0
            goto L29
        La:
            java.lang.Object r1 = r10.first     // Catch: java.lang.Throwable -> L47 com.google.android.gms.internal.mlkit_vision_pose_common.zzxh -> L49 java.lang.InterruptedException -> L4b java.lang.RuntimeException -> L4d
            com.google.android.gms.internal.mlkit_vision_pose_common.zzbg r1 = (com.google.android.gms.internal.mlkit_vision_pose_common.zzbg) r1     // Catch: java.lang.Throwable -> L47 com.google.android.gms.internal.mlkit_vision_pose_common.zzxh -> L49 java.lang.InterruptedException -> L4b java.lang.RuntimeException -> L4d
            java.lang.Object r10 = r10.second     // Catch: java.lang.Throwable -> L47 com.google.android.gms.internal.mlkit_vision_pose_common.zzxh -> L49 java.lang.InterruptedException -> L4b java.lang.RuntimeException -> L4d
            java.util.Date r10 = (java.util.Date) r10     // Catch: java.lang.Throwable -> L47 com.google.android.gms.internal.mlkit_vision_pose_common.zzxh -> L49 java.lang.InterruptedException -> L4b java.lang.RuntimeException -> L4d
            java.util.Date r2 = new java.util.Date     // Catch: java.lang.Throwable -> L47 com.google.android.gms.internal.mlkit_vision_pose_common.zzxh -> L49 java.lang.InterruptedException -> L4b java.lang.RuntimeException -> L4d
            long r3 = r10.getTime()     // Catch: java.lang.Throwable -> L47 com.google.android.gms.internal.mlkit_vision_pose_common.zzxh -> L49 java.lang.InterruptedException -> L4b java.lang.RuntimeException -> L4d
            java.util.concurrent.TimeUnit r10 = java.util.concurrent.TimeUnit.SECONDS     // Catch: java.lang.Throwable -> L47 com.google.android.gms.internal.mlkit_vision_pose_common.zzxh -> L49 java.lang.InterruptedException -> L4b java.lang.RuntimeException -> L4d
            long r7 = r10.toMillis(r7)     // Catch: java.lang.Throwable -> L47 com.google.android.gms.internal.mlkit_vision_pose_common.zzxh -> L49 java.lang.InterruptedException -> L4b java.lang.RuntimeException -> L4d
            long r3 = r3 + r7
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L47 com.google.android.gms.internal.mlkit_vision_pose_common.zzxh -> L49 java.lang.InterruptedException -> L4b java.lang.RuntimeException -> L4d
            boolean r7 = r6.after(r2)     // Catch: java.lang.Throwable -> L47 com.google.android.gms.internal.mlkit_vision_pose_common.zzxh -> L49 java.lang.InterruptedException -> L4b java.lang.RuntimeException -> L4d
            if (r7 == 0) goto L29
            goto L8
        L29:
            if (r1 != 0) goto L6d
            com.google.android.gms.internal.mlkit_vision_pose_common.zzvp r7 = r5.zzg     // Catch: java.lang.Throwable -> L47 com.google.android.gms.internal.mlkit_vision_pose_common.zzxh -> L49 java.lang.InterruptedException -> L4b java.lang.RuntimeException -> L4d java.io.IOException -> L68
            r7.zzd()     // Catch: java.lang.Throwable -> L47 com.google.android.gms.internal.mlkit_vision_pose_common.zzxh -> L49 java.lang.InterruptedException -> L4b java.lang.RuntimeException -> L4d java.io.IOException -> L68
            com.google.android.gms.internal.mlkit_vision_pose_common.zzvp r7 = r5.zzg     // Catch: java.lang.Throwable -> L47 com.google.android.gms.internal.mlkit_vision_pose_common.zzxh -> L49 java.lang.InterruptedException -> L4b java.lang.RuntimeException -> L4d
            java.lang.String r7 = r7.zzc()     // Catch: java.lang.Throwable -> L47 com.google.android.gms.internal.mlkit_vision_pose_common.zzxh -> L49 java.lang.InterruptedException -> L4b java.lang.RuntimeException -> L4d
            com.google.android.gms.internal.mlkit_vision_pose_common.zzxe r8 = new com.google.android.gms.internal.mlkit_vision_pose_common.zzxe     // Catch: java.lang.Throwable -> L47 com.google.android.gms.internal.mlkit_vision_pose_common.zzxh -> L49 java.lang.InterruptedException -> L4b java.lang.RuntimeException -> L4d
            r8.<init>(r5, r7, r6, r9)     // Catch: java.lang.Throwable -> L47 com.google.android.gms.internal.mlkit_vision_pose_common.zzxh -> L49 java.lang.InterruptedException -> L4b java.lang.RuntimeException -> L4d
            boolean r6 = com.google.android.gms.internal.mlkit_vision_pose_common.zzxo.zza(r8)     // Catch: java.lang.Throwable -> L47 com.google.android.gms.internal.mlkit_vision_pose_common.zzxh -> L49 java.lang.InterruptedException -> L4b java.lang.RuntimeException -> L4d
            if (r6 != 0) goto L4f
            com.google.android.gms.internal.mlkit_vision_pose_common.zztd r6 = com.google.android.gms.internal.mlkit_vision_pose_common.zztd.RPC_EXPONENTIAL_BACKOFF_FAILED     // Catch: java.lang.Throwable -> L47 com.google.android.gms.internal.mlkit_vision_pose_common.zzxh -> L49 java.lang.InterruptedException -> L4b java.lang.RuntimeException -> L4d
            r9.zzd(r6)     // Catch: java.lang.Throwable -> L47 com.google.android.gms.internal.mlkit_vision_pose_common.zzxh -> L49 java.lang.InterruptedException -> L4b java.lang.RuntimeException -> L4d
            goto L6d
        L47:
            r6 = move-exception
            goto L7d
        L49:
            r6 = move-exception
            goto L71
        L4b:
            r6 = move-exception
            goto L71
        L4d:
            r6 = move-exception
            goto L71
        L4f:
            com.google.android.gms.internal.mlkit_vision_pose_common.zzbg r6 = r8.zzb()     // Catch: java.lang.Throwable -> L47 com.google.android.gms.internal.mlkit_vision_pose_common.zzxh -> L49 java.lang.InterruptedException -> L4b java.lang.RuntimeException -> L4d
            java.lang.String r7 = java.lang.String.valueOf(r6)     // Catch: java.lang.Throwable -> L47 com.google.android.gms.internal.mlkit_vision_pose_common.zzxh -> L49 java.lang.InterruptedException -> L4b java.lang.RuntimeException -> L4d
            java.lang.String r10 = "writeAndSetFetchedConfig: "
            r10.concat(r7)     // Catch: java.lang.Throwable -> L47 com.google.android.gms.internal.mlkit_vision_pose_common.zzxh -> L49 java.lang.InterruptedException -> L4b java.lang.RuntimeException -> L4d
            com.google.android.gms.internal.mlkit_vision_pose_common.zzxk r7 = r5.zzl     // Catch: java.lang.Throwable -> L47 com.google.android.gms.internal.mlkit_vision_pose_common.zzxh -> L49 java.lang.InterruptedException -> L4b java.lang.RuntimeException -> L4d
            com.google.android.gms.internal.mlkit_vision_pose_common.zzwy r8 = r8.zzc()     // Catch: java.lang.Throwable -> L47 com.google.android.gms.internal.mlkit_vision_pose_common.zzxh -> L49 java.lang.InterruptedException -> L4b java.lang.RuntimeException -> L4d
            r7.zzb(r8, r9)     // Catch: java.lang.Throwable -> L47 com.google.android.gms.internal.mlkit_vision_pose_common.zzxh -> L49 java.lang.InterruptedException -> L4b java.lang.RuntimeException -> L4d
            r5.zzj = r6     // Catch: java.lang.Throwable -> L47 com.google.android.gms.internal.mlkit_vision_pose_common.zzxh -> L49 java.lang.InterruptedException -> L4b java.lang.RuntimeException -> L4d
            goto L6d
        L68:
            com.google.android.gms.internal.mlkit_vision_pose_common.zztd r6 = com.google.android.gms.internal.mlkit_vision_pose_common.zztd.UNKNOWN_ERROR     // Catch: java.lang.Throwable -> L47 com.google.android.gms.internal.mlkit_vision_pose_common.zzxh -> L49 java.lang.InterruptedException -> L4b java.lang.RuntimeException -> L4d
            r9.zzd(r6)     // Catch: java.lang.Throwable -> L47 com.google.android.gms.internal.mlkit_vision_pose_common.zzxh -> L49 java.lang.InterruptedException -> L4b java.lang.RuntimeException -> L4d
        L6d:
            r11.setResult(r0)     // Catch: java.lang.Throwable -> L47 com.google.android.gms.internal.mlkit_vision_pose_common.zzxh -> L49 java.lang.InterruptedException -> L4b java.lang.RuntimeException -> L4d
            goto L74
        L71:
            r11.setException(r6)     // Catch: java.lang.Throwable -> L47
        L74:
            r9.zze()
            com.google.android.gms.internal.mlkit_vision_pose_common.zzxi r6 = r5.zzm
            r6.zzc(r9)
            return
        L7d:
            r9.zze()
            com.google.android.gms.internal.mlkit_vision_pose_common.zzxi r7 = r5.zzm
            r7.zzc(r9)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_pose_common.zzxf.zzi(java.util.Date, long, com.google.android.gms.internal.mlkit_vision_pose_common.zzvr, boolean, com.google.android.gms.tasks.TaskCompletionSource):void");
    }

    final /* synthetic */ void zzj(zzvr zzvrVar, boolean z5, TaskCompletionSource taskCompletionSource) {
        try {
            try {
                zzl(zzvrVar, true);
                taskCompletionSource.setResult(null);
            } catch (RuntimeException e6) {
                taskCompletionSource.setException(e6);
            }
        } finally {
            zzvrVar.zze();
            this.zzm.zze(zzvrVar);
        }
    }

    private zzxf(Context context, zzvp zzvpVar, zzxi zzxiVar, zzvo zzvoVar) {
        ExecutorService executorService = zzb;
        ExecutorService executorService2 = zzc;
        this.zzk = new TreeMap();
        context.getApplicationContext();
        this.zzg = zzvpVar;
        this.zze = executorService;
        this.zzf = executorService2;
        this.zzm = zzxiVar;
        this.zzh = new zzwz(context, zzvoVar.zzb(), zzvoVar.zza(), "firebase", 5L, 5L, zzxiVar);
        this.zzl = new zzxk(context);
    }

    public static synchronized zzxf zzf(Context context) {
        zzxf zzxfVar;
        synchronized (zzxf.class) {
            try {
                if (zzd == null) {
                    zzd = new zzxf(context, zzvp.zzb(context), new zzxi(context), zzvw.zza);
                }
                zzxfVar = zzd;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzxfVar;
    }

    @Nullable
    private final Pair zzl(zzvr zzvrVar, boolean z5) {
        zzwy zza2 = this.zzl.zza(zzvrVar);
        if (zza2 == null) {
            return null;
        }
        JSONObject zzc2 = zza2.zzc();
        try {
            zzbg zzm = zzm(zzc2);
            this.zzj = zzm;
            if (z5) {
                zzvr zzvrVar2 = new zzvr();
                zzvrVar2.zzg();
                this.zzi = this.zzj;
                zzvrVar2.zze();
                this.zzm.zzb(zzvrVar2);
            }
            zzvrVar.zzh();
            return Pair.create(zzm, zza2.zzb());
        } catch (JSONException unused) {
            zzvrVar.zzc(zztd.FILE_READ_RETURNED_MALFORMED_DATA);
            "Saved remote config setting has invalid format: ".concat(String.valueOf(zzc2));
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzbg zzm(JSONObject jSONObject) throws JSONException {
        String string;
        zzxc zzxcVar = new zzxc(jSONObject);
        zzbf zzbfVar = new zzbf();
        Iterator<String> keys = zzxcVar.zza.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String string2 = jSONObject.getString(next);
            if (string2 == null) {
                string = null;
            } else if (string2.isEmpty()) {
                string = "";
            } else {
                string = new JSONObject("{ \"value\": " + string2 + " }").getString("value");
            }
            zzbfVar.zza(next, string);
        }
        return zzbfVar.zzb();
    }

    @NonNull
    public final Task zza(final long j6) {
        final Date date = new Date(System.currentTimeMillis());
        final zzvr zzvrVar = new zzvr();
        zzvrVar.zzg();
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        final boolean z5 = false;
        this.zzf.execute(new Runnable(date, j6, zzvrVar, z5, taskCompletionSource) { // from class: com.google.android.gms.internal.mlkit_vision_pose_common.zzxd
            public final /* synthetic */ Date zzb;
            public final /* synthetic */ long zzc;
            public final /* synthetic */ zzvr zzd;
            public final /* synthetic */ TaskCompletionSource zze;

            @Override // java.lang.Runnable
            public final void run() {
                zzxf.this.zzi(this.zzb, this.zzc, this.zzd, false, this.zze);
            }

            {
                this.zze = taskCompletionSource;
            }
        });
        return taskCompletionSource.getTask();
    }

    public final Task zzb() {
        final zzvr zzvrVar = new zzvr();
        zzvrVar.zzg();
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        final boolean z5 = true;
        this.zze.execute(new Runnable(zzvrVar, z5, taskCompletionSource) { // from class: com.google.android.gms.internal.mlkit_vision_pose_common.zzxb
            public final /* synthetic */ zzvr zzb;
            public final /* synthetic */ TaskCompletionSource zzc;

            @Override // java.lang.Runnable
            public final void run() {
                zzxf.this.zzj(this.zzb, true, this.zzc);
            }

            {
                this.zzc = taskCompletionSource;
            }
        });
        return taskCompletionSource.getTask();
    }

    public final String zzh(@NonNull String str) {
        String str2;
        zzbg zzbgVar = this.zzi;
        if (zzbgVar != null && zzbgVar.containsKey(str)) {
            return (String) zzbgVar.get(str);
        }
        synchronized (this.zzk) {
            str2 = (String) this.zzk.get(str);
        }
        return str2;
    }

    public final void zzk(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.zzn = str;
    }
}
