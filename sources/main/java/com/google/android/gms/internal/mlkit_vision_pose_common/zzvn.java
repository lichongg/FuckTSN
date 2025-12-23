package com.google.android.gms.internal.mlkit_vision_pose_common;

import androidx.annotation.Nullable;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzvn {
    private static final MediaType zzb = MediaType.parse("application/json; charset=utf-8");
    public final zzvo zza;
    private final OkHttpClient zzc;

    @Nullable
    private zzvv zzd;
    private final zzvs zze;
    private final String zzf;

    private static long zze(long j6, String str) {
        return j6 + (Long.parseLong(str.replaceFirst("s$", "")) * 1000);
    }

    @Nullable
    private final String zzf(Headers headers, String str, String str2, zzvr zzvrVar, zzvr zzvrVar2) {
        String str3;
        ResponseBody body;
        try {
            Response execute = this.zzc.newCall(new Request.Builder().headers(headers).url(str).post(RequestBody.create(zzb, str2)).build()).execute();
            int code = execute.code();
            zzvrVar2.zzf(code);
            if (code >= 200 && code < 300) {
                try {
                    body = execute.body();
                    try {
                        String string = body.string();
                        body.close();
                        return string;
                    } finally {
                    }
                } catch (IOException unused) {
                    zztd zztdVar = zztd.RPC_ERROR;
                    zzvrVar2.zzd(zztdVar);
                    zzvrVar.zzb(zztdVar);
                    return null;
                }
            }
            try {
                body = execute.body();
            } catch (IOException unused2) {
                str3 = "<none>";
            }
            try {
                str3 = body.string();
                body.close();
                "HTTP Response Body:\n".concat(String.valueOf(str3));
                zztd zztdVar2 = zztd.RPC_ERROR;
                zzvrVar2.zzd(zztdVar2);
                zzvrVar.zzb(zztdVar2);
                return null;
            } finally {
                if (body != null) {
                    try {
                        body.close();
                    } catch (Throwable th) {
                        th.addSuppressed(th);
                    }
                }
            }
        } catch (IOException unused3) {
            zzvrVar2.zzd(zztd.NO_CONNECTION);
            zzvrVar.zzb(zztd.NO_CONNECTION);
            return null;
        }
    }

    @Nullable
    public final zzvv zza() {
        return this.zzd;
    }

    final /* synthetic */ boolean zzb(zzvk zzvkVar, zzvr zzvrVar) throws zzxm, IOException, InterruptedException {
        boolean z5 = false;
        String format = String.format("%s/projects/%s/installations", this.zzf, this.zza.zzc());
        Headers build = new Headers.Builder().add("x-goog-api-key", this.zza.zza()).build();
        String format2 = String.format("{fid: '%s', appId: '%s', authVersion: '%s', sdkVersion: '%s'}", zzvkVar.zza(), this.zza.zzb(), "FIS_v2", "o:a:mlkit:1.0.0");
        long currentTimeMillis = System.currentTimeMillis();
        zzvr zzvrVar2 = new zzvr();
        zzvrVar2.zzg();
        String zzf = zzf(build, format, format2, zzvrVar, zzvrVar2);
        zzvrVar2.zze();
        try {
            if (zzf != null) {
                try {
                    zzcy zzb2 = zzda.zzb(zzf).zzb();
                    try {
                        zzb2.zzc(CommonNetImpl.NAME).zze();
                        zzvk zzvkVar2 = new zzvk(zzb2.zzc("fid").zze());
                        String zze = zzb2.zzc("refreshToken").zze();
                        zzcy zza = zzb2.zza("authToken");
                        String zze2 = zza.zzc(JThirdPlatFormInterface.KEY_TOKEN).zze();
                        long zze3 = zze(currentTimeMillis, zza.zzc("expiresIn").zze());
                        zzvkVar2.zza();
                        String.valueOf(zza);
                        this.zzd = new zzvv(zzvkVar2, zze, zze2, zze3);
                        z5 = true;
                    } catch (ClassCastException | IllegalStateException | NullPointerException unused) {
                        zzb2.toString();
                        zztd zztdVar = zztd.RPC_RETURNED_INVALID_RESULT;
                        zzvrVar2.zzd(zztdVar);
                        zzvrVar.zzb(zztdVar);
                    }
                } catch (zzdc | IllegalStateException | NullPointerException unused2) {
                    zztd zztdVar2 = zztd.RPC_RETURNED_MALFORMED_RESULT;
                    zzvrVar2.zzd(zztdVar2);
                    zzvrVar.zzb(zztdVar2);
                }
            }
            return z5;
        } finally {
            this.zze.zza(zzpp.INSTALLATION_ID_FIS_CREATE_INSTALLATION, zzvrVar2);
        }
    }

    public final boolean zzc(final zzvr zzvrVar) throws InterruptedException {
        if (this.zzd == null) {
            return false;
        }
        boolean zza = zzxo.zza(new zzxn() { // from class: com.google.android.gms.internal.mlkit_vision_pose_common.zzvl
            @Override // com.google.android.gms.internal.mlkit_vision_pose_common.zzxn
            public final boolean zza() {
                return zzvn.this.zzd(zzvrVar);
            }
        });
        if (!zza) {
            zzvrVar.zzc(zztd.RPC_EXPONENTIAL_BACKOFF_FAILED);
        }
        return zza;
    }

    public final boolean zzd(zzvr zzvrVar) {
        System.out.getClass();
        return false;
    }

    public zzvn(zzvo zzvoVar, zzvs zzvsVar) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.zzc = builder.connectTimeout(10000L, timeUnit).readTimeout(10000L, timeUnit).writeTimeout(10000L, timeUnit).build();
        this.zza = zzvoVar;
        this.zze = zzvsVar;
        this.zzd = null;
        this.zzf = "https://firebaseinstallations.googleapis.com/v1";
    }
}
