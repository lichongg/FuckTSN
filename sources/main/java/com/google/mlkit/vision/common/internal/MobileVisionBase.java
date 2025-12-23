package com.google.mlkit.vision.common.internal;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.Image;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_vision_common.zzlx;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.odml.image.MlImage;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.MLTask;
import com.google.mlkit.vision.common.InputImage;
import java.io.Closeable;
import java.nio.ByteBuffer;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public class MobileVisionBase<DetectionResultT> implements Closeable, LifecycleObserver {
    public static final /* synthetic */ int zza = 0;
    private static final GmsLogger zzb = new GmsLogger("MobileVisionBase", "");
    private final AtomicBoolean zzc = new AtomicBoolean(false);
    private final MLTask zzd;
    private final CancellationTokenSource zze;
    private final Executor zzf;
    private final Task zzg;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    @KeepForSdk
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public synchronized void close() {
        if (this.zzc.getAndSet(true)) {
            return;
        }
        this.zze.cancel();
        this.zzd.unpin(this.zzf);
    }

    @NonNull
    @KeepForSdk
    public synchronized Task<Void> closeWithTask() {
        if (this.zzc.getAndSet(true)) {
            return Tasks.forResult(null);
        }
        this.zze.cancel();
        return this.zzd.unpinWithTask(this.zzf);
    }

    @NonNull
    @KeepForSdk
    public synchronized Task<Void> getInitTaskBase() {
        return this.zzg;
    }

    @NonNull
    @KeepForSdk
    public Task<DetectionResultT> process(@NonNull Bitmap bitmap, int i6) {
        return processBase(InputImage.fromBitmap(bitmap, i6));
    }

    @NonNull
    @KeepForSdk
    public synchronized Task<DetectionResultT> processBase(@NonNull final MlImage mlImage) {
        Preconditions.checkNotNull(mlImage, "MlImage can not be null");
        if (this.zzc.get()) {
            return Tasks.forException(new MlKitException("This detector is already closed!", 14));
        }
        if (mlImage.getWidth() < 32 || mlImage.getHeight() < 32) {
            return Tasks.forException(new MlKitException("MlImage width and height should be at least 32!", 3));
        }
        mlImage.getInternal().acquire();
        return this.zzd.callAfterLoad(this.zzf, new Callable() { // from class: com.google.mlkit.vision.common.internal.zzd
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return MobileVisionBase.this.zzb(mlImage);
            }
        }, this.zze.getToken()).addOnCompleteListener(new OnCompleteListener() { // from class: com.google.mlkit.vision.common.internal.zze
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                MlImage mlImage2 = MlImage.this;
                int i6 = MobileVisionBase.zza;
                mlImage2.close();
            }
        });
    }

    @NonNull
    @KeepForSdk
    public Task<DetectionResultT> process(@NonNull Image image, int i6) {
        return processBase(InputImage.fromMediaImage(image, i6));
    }

    final /* synthetic */ Object zza(InputImage inputImage) throws Exception {
        zzlx zze = zzlx.zze("detectorTaskWithResource#run");
        zze.zzb();
        try {
            Object run = this.zzd.run(inputImage);
            zze.close();
            return run;
        } catch (Throwable th) {
            try {
                zze.close();
            } catch (Throwable th2) {
                try {
                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                } catch (Exception unused) {
                }
            }
            throw th;
        }
    }

    @KeepForSdk
    public MobileVisionBase(@NonNull MLTask<DetectionResultT, InputImage> mLTask, @NonNull Executor executor) {
        this.zzd = mLTask;
        CancellationTokenSource cancellationTokenSource = new CancellationTokenSource();
        this.zze = cancellationTokenSource;
        this.zzf = executor;
        mLTask.pin();
        this.zzg = mLTask.callAfterLoad(executor, new Callable() { // from class: com.google.mlkit.vision.common.internal.zzb
            @Override // java.util.concurrent.Callable
            public final Object call() {
                int i6 = MobileVisionBase.zza;
                return null;
            }
        }, cancellationTokenSource.getToken()).addOnFailureListener(new OnFailureListener() { // from class: com.google.mlkit.vision.common.internal.zzc
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                MobileVisionBase.zzb.e("MobileVisionBase", "Error preloading model resource", exc);
            }
        });
    }

    @NonNull
    @KeepForSdk
    public Task<DetectionResultT> process(@NonNull Image image, int i6, @NonNull Matrix matrix) {
        return processBase(InputImage.fromMediaImage(image, i6, matrix));
    }

    final /* synthetic */ Object zzb(MlImage mlImage) throws Exception {
        InputImage convertMlImagetoInputImage = CommonConvertUtils.convertMlImagetoInputImage(mlImage);
        if (convertMlImagetoInputImage != null) {
            return this.zzd.run(convertMlImagetoInputImage);
        }
        throw new MlKitException("Current type of MlImage is not supported.", 13);
    }

    @NonNull
    @KeepForSdk
    public Task<DetectionResultT> process(@NonNull ByteBuffer byteBuffer, int i6, int i7, int i8, int i9) {
        return processBase(InputImage.fromByteBuffer(byteBuffer, i6, i7, i8, i9));
    }

    @NonNull
    @KeepForSdk
    public synchronized Task<DetectionResultT> processBase(@NonNull final InputImage inputImage) {
        Preconditions.checkNotNull(inputImage, "InputImage can not be null");
        if (this.zzc.get()) {
            return Tasks.forException(new MlKitException("This detector is already closed!", 14));
        }
        if (inputImage.getWidth() >= 32 && inputImage.getHeight() >= 32) {
            return this.zzd.callAfterLoad(this.zzf, new Callable() { // from class: com.google.mlkit.vision.common.internal.zza
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return MobileVisionBase.this.zza(inputImage);
                }
            }, this.zze.getToken());
        }
        return Tasks.forException(new MlKitException("InputImage width and height should be at least 32!", 3));
    }
}
