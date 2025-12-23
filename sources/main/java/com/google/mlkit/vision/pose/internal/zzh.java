package com.google.mlkit.vision.pose.internal;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_vision_pose_common.zzbd;
import com.google.android.gms.internal.mlkit_vision_pose_common.zzfa;
import com.google.android.gms.internal.mlkit_vision_pose_common.zzfc;
import com.google.android.gms.internal.mlkit_vision_pose_common.zzou;
import com.google.android.gms.internal.mlkit_vision_pose_common.zzov;
import com.google.android.gms.internal.mlkit_vision_pose_common.zzpb;
import com.google.android.gms.internal.mlkit_vision_pose_common.zzpn;
import com.google.android.gms.internal.mlkit_vision_pose_common.zzpo;
import com.google.android.gms.internal.mlkit_vision_pose_common.zzpp;
import com.google.android.gms.internal.mlkit_vision_pose_common.zzpq;
import com.google.android.gms.internal.mlkit_vision_pose_common.zzsb;
import com.google.android.gms.internal.mlkit_vision_pose_common.zzsk;
import com.google.android.gms.internal.mlkit_vision_pose_common.zzwa;
import com.google.android.gms.internal.mlkit_vision_pose_common.zzwk;
import com.google.android.gms.internal.mlkit_vision_pose_common.zzwm;
import com.google.android.gms.internal.mlkit_vision_pose_common.zzwn;
import com.google.android.gms.internal.mlkit_vision_pose_common.zzxf;
import com.google.android.gms.internal.mlkit_vision_pose_common.zzxq;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.MLTask;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.common.internal.ImageConvertUtils;
import com.google.mlkit.vision.common.internal.ImageUtils;
import com.google.mlkit.vision.mediapipe.MediaPipeGraphRunner;
import com.google.mlkit.vision.mediapipe.MediaPipeInput;
import com.google.mlkit.vision.mediapipe.MediaPipeInputFactory;
import com.google.mlkit.vision.mediapipe.pose.PoseHolder;
import com.google.mlkit.vision.mediapipe.pose.PoseHolderConverter;
import com.google.mlkit.vision.mediapipe.utils.ImageConvertNativeUtils;
import com.google.mlkit.vision.pose.Pose;
import com.google.mlkit.vision.pose.PoseDetectorOptionsBase;
import com.stub.StubApp;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzh extends MLTask {
    private static final ImageUtils zzc = ImageUtils.getInstance();
    final String zza;
    final String zzb;
    private final PoseDetectorOptionsBase zzd;
    private final zzwk zze;
    private final zzwm zzf;
    private final MlKitContext zzg;
    private final zzxf zzh;
    private boolean zzi = true;
    private PoseDetectorOptionsBase zzj;
    private zzsk zzk;
    private long zzl;
    private long zzm;

    @Nullable
    private MediaPipeGraphRunner zzn;
    private boolean zzo;
    private boolean zzp;
    private boolean zzq;
    private final zzg zzr;

    private final boolean zzf(String str) {
        String zzh = this.zzh.zzh(str);
        boolean z5 = true;
        if (!TextUtils.isEmpty(zzh) && !Boolean.parseBoolean(zzh)) {
            z5 = false;
        }
        Log.isLoggable("PoseTaskWithRes", 4);
        return z5;
    }

    final /* synthetic */ zzwa zzc(long j6, zzpo zzpoVar, InputImage inputImage) {
        zzpq zzpqVar = new zzpq();
        zzpqVar.zzf(zzpn.TYPE_THICK);
        zzsb zzsbVar = new zzsb();
        zzpb zzpbVar = new zzpb();
        zzpbVar.zzc(Long.valueOf(j6));
        zzpbVar.zzd(zzpoVar);
        zzpbVar.zzf(Boolean.valueOf(this.zzi));
        Boolean bool = Boolean.TRUE;
        zzpbVar.zza(bool);
        zzpbVar.zzb(bool);
        boolean z5 = true;
        if (!this.zzo && !this.zzp) {
            z5 = false;
        }
        zzpbVar.zzg(Boolean.valueOf(z5));
        zzpbVar.zze(Boolean.valueOf(this.zzq));
        zzsbVar.zze(zzpbVar.zzh());
        int format = inputImage.getFormat();
        int mobileVisionImageSize = zzc.getMobileVisionImageSize(inputImage);
        zzou zzouVar = new zzou();
        zzouVar.zza(format != -1 ? format != 35 ? format != 842094169 ? format != 16 ? format != 17 ? zzov.UNKNOWN_FORMAT : zzov.NV21 : zzov.NV16 : zzov.YV12 : zzov.YUV_420_888 : zzov.BITMAP);
        zzouVar.zzb(Integer.valueOf(mobileVisionImageSize));
        zzsbVar.zzd(zzouVar.zzd());
        zzsbVar.zzc(this.zzk);
        zzpqVar.zzh(zzsbVar.zzi());
        return zzwn.zzf(zzpqVar);
    }

    @WorkerThread
    final void zze(zzpo zzpoVar, InputImage inputImage, long j6) {
        if (this.zzj.isForBenchmark()) {
            return;
        }
        final long elapsedRealtime = SystemClock.elapsedRealtime() - j6;
        this.zzm += elapsedRealtime;
        this.zze.zzh(new zzf(this, elapsedRealtime, zzpoVar, inputImage), zzpp.ON_DEVICE_POSE_INFERENCE);
        zzfa zzfaVar = new zzfa();
        zzfaVar.zza(this.zzk);
        zzfaVar.zzb(zzpoVar);
        zzfaVar.zzc(Boolean.valueOf(this.zzi));
        final zzfc zzd = zzfaVar.zzd();
        final zzwk zzwkVar = this.zze;
        final zzg zzgVar = this.zzr;
        final zzpp zzppVar = zzpp.AGGREGATED_ON_DEVICE_POSE_DETECTION;
        MLTaskExecutor.workerThreadExecutor().execute(new Runnable() { // from class: com.google.android.gms.internal.mlkit_vision_pose_common.zzwj
            @Override // java.lang.Runnable
            public final void run() {
                zzwk.this.zzg(zzppVar, zzd, elapsedRealtime, zzgVar);
            }
        });
        long currentTimeMillis = System.currentTimeMillis();
        boolean zzg = this.zzj.zzg();
        long j7 = currentTimeMillis - elapsedRealtime;
        if (!this.zzj.isForBenchmark()) {
            this.zzf.zzc(true != zzg ? 24313 : 24312, zzpoVar.zza(), j7, currentTimeMillis);
        }
        if (this.zzi) {
            zzxq.zza();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [com.google.mlkit.vision.pose.internal.zzg] */
    public zzh(@NonNull MlKitContext mlKitContext, @NonNull PoseDetectorOptionsBase poseDetectorOptionsBase, @NonNull zzwk zzwkVar) {
        Preconditions.checkNotNull(mlKitContext, "MlKitContext can not be null");
        Preconditions.checkNotNull(poseDetectorOptionsBase, "PoseDetectorOptionsBase can not be null");
        this.zze = zzwkVar;
        this.zzr = new Object() { // from class: com.google.mlkit.vision.pose.internal.zzg
        };
        this.zzf = zzwm.zza(StubApp.getOrigApplicationContext(mlKitContext.getApplicationContext()));
        this.zzg = mlKitContext;
        this.zzd = poseDetectorOptionsBase;
        this.zzj = poseDetectorOptionsBase;
        this.zzk = poseDetectorOptionsBase.zzb();
        this.zza = this.zzj.zzf();
        this.zzb = this.zzj.zze();
        this.zzh = zzxf.zzf(StubApp.getOrigApplicationContext(mlKitContext.getApplicationContext()));
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c8  */
    @Override // com.google.mlkit.common.sdkinternal.ModelResource
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void load() throws com.google.mlkit.common.MlKitException {
        /*
            Method dump skipped, instructions count: 510
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.vision.pose.internal.zzh.load():void");
    }

    @Override // com.google.mlkit.common.sdkinternal.ModelResource
    public final void release() {
        zzxq.zza();
        this.zze.zzi(zzpp.AGGREGATED_ON_DEVICE_POSE_DETECTION, this.zzr);
        MediaPipeGraphRunner mediaPipeGraphRunner = this.zzn;
        if (mediaPipeGraphRunner != null) {
            mediaPipeGraphRunner.close();
            this.zzn = null;
        }
        if (!this.zzj.isForBenchmark()) {
            zzwk zzwkVar = this.zze;
            zzpq zzpqVar = new zzpq();
            zzpqVar.zzf(zzpn.TYPE_THICK);
            zzsb zzsbVar = new zzsb();
            zzsbVar.zzc(this.zzk);
            zzsbVar.zzg(Long.valueOf(SystemClock.elapsedRealtime() - this.zzl));
            zzsbVar.zzh(Long.valueOf(this.zzm));
            zzpqVar.zzh(zzsbVar.zzi());
            zzwkVar.zzd(zzwn.zzf(zzpqVar), zzpp.ON_DEVICE_POSE_CLOSE);
        }
        this.zzi = true;
        PoseDetectorOptionsBase poseDetectorOptionsBase = this.zzd;
        this.zzj = poseDetectorOptionsBase;
        this.zzk = poseDetectorOptionsBase.zzb();
        this.zzl = 0L;
        this.zzm = 0L;
    }

    @Override // com.google.mlkit.common.sdkinternal.MLTask
    @NonNull
    @WorkerThread
    /* renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public final Pose run(@NonNull InputImage inputImage) throws MlKitException {
        MediaPipeInput mediaPipeInput;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        byte[] rgbBuffer = ImageConvertNativeUtils.getRgbBuffer(inputImage);
        long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos() / 1000;
        if (rgbBuffer == null) {
            mediaPipeInput = MediaPipeInputFactory.getMediaPipeInput(ImageConvertUtils.getInstance().getUpRightBitmap(inputImage), elapsedRealtimeNanos);
        } else {
            int width = inputImage.getWidth();
            int height = inputImage.getHeight();
            if ((inputImage.getRotationDegrees() / 90) % 2 == 1) {
                width = inputImage.getHeight();
                height = inputImage.getWidth();
            }
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(rgbBuffer.length);
            allocateDirect.put(rgbBuffer);
            allocateDirect.rewind();
            mediaPipeInput = MediaPipeInputFactory.getMediaPipeInput(allocateDirect, width, height, elapsedRealtimeNanos);
        }
        try {
            PoseHolder poseHolder = (PoseHolder) ((MediaPipeGraphRunner) Preconditions.checkNotNull(this.zzn)).run(zzbd.zzh(mediaPipeInput), new PoseHolderConverter());
            zze(zzpo.NO_ERROR, inputImage, elapsedRealtime);
            this.zzi = false;
            return new Pose(poseHolder, null);
        } catch (MlKitException e6) {
            zze(zzpo.MEDIAPIPE_ERROR, inputImage, elapsedRealtime);
            throw e6;
        }
    }
}
