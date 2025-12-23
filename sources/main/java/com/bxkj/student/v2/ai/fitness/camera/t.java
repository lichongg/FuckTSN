package com.bxkj.student.v2.ai.fitness.camera;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.widget.Toast;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.ExperimentalGetImage;
import androidx.camera.core.ImageProxy;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.tasks.Tasks;
import com.google.android.odml.image.BitmapMlImageBuilder;
import com.google.android.odml.image.ByteBufferMlImageBuilder;
import com.google.android.odml.image.MediaMlImageBuilder;
import com.google.android.odml.image.MlImage;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.vision.common.InputImage;
import java.nio.ByteBuffer;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class t<T> implements m {

    /* renamed from: s, reason: collision with root package name */
    protected static final String f20578s = "LogTagForTest";

    /* renamed from: t, reason: collision with root package name */
    private static final String f20579t = "VisionProcessorBase";

    /* renamed from: a, reason: collision with root package name */
    private final ActivityManager f20580a;

    /* renamed from: b, reason: collision with root package name */
    private final Timer f20581b;

    /* renamed from: c, reason: collision with root package name */
    private final k f20582c;

    /* renamed from: d, reason: collision with root package name */
    private final l f20583d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f20584e;

    /* renamed from: f, reason: collision with root package name */
    private int f20585f;

    /* renamed from: g, reason: collision with root package name */
    private long f20586g;

    /* renamed from: h, reason: collision with root package name */
    private long f20587h;

    /* renamed from: i, reason: collision with root package name */
    private long f20588i;

    /* renamed from: j, reason: collision with root package name */
    private long f20589j;

    /* renamed from: k, reason: collision with root package name */
    private long f20590k;

    /* renamed from: l, reason: collision with root package name */
    private long f20591l;

    /* renamed from: m, reason: collision with root package name */
    private int f20592m;

    /* renamed from: n, reason: collision with root package name */
    private int f20593n;

    /* renamed from: o, reason: collision with root package name */
    @GuardedBy("this")
    private ByteBuffer f20594o;

    /* renamed from: p, reason: collision with root package name */
    @GuardedBy("this")
    private f f20595p;

    /* renamed from: q, reason: collision with root package name */
    @GuardedBy("this")
    private ByteBuffer f20596q;

    /* renamed from: r, reason: collision with root package name */
    @GuardedBy("this")
    private f f20597r;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            t tVar = t.this;
            tVar.f20593n = tVar.f20592m;
            t.this.f20592m = 0;
        }
    }

    private synchronized void w(final GraphicOverlay graphicOverlay) {
        ByteBuffer byteBuffer = this.f20594o;
        this.f20596q = byteBuffer;
        f fVar = this.f20595p;
        this.f20597r = fVar;
        this.f20594o = null;
        this.f20595p = null;
        if (byteBuffer != null && fVar != null && !this.f20584e) {
            v(byteBuffer, fVar, graphicOverlay);
        }
    }

    private void z() {
        this.f20585f = 0;
        this.f20586g = 0L;
        this.f20587h = 0L;
        this.f20588i = Long.MAX_VALUE;
        this.f20589j = 0L;
        this.f20590k = 0L;
        this.f20591l = Long.MAX_VALUE;
    }

    @Override // com.bxkj.student.v2.ai.fitness.camera.m
    public synchronized void a(ByteBuffer data, final f frameMetadata, final GraphicOverlay graphicOverlay) {
        this.f20594o = data;
        this.f20595p = frameMetadata;
        if (this.f20596q == null && this.f20597r == null) {
            w(graphicOverlay);
        }
    }

    protected abstract Task<T> n(InputImage image);

    protected boolean o(Context context) {
        return false;
    }

    protected abstract void t(@NonNull Exception e6);

    protected abstract void u(@NonNull T results, @NonNull GraphicOverlay graphicOverlay);

    protected Task<T> m(MlImage image) {
        return Tasks.forException(new MlKitException("MlImage is currently not demonstrated for this feature", 3));
    }

    @Override // com.bxkj.student.v2.ai.fitness.camera.m
    public void stop() {
        this.f20582c.shutdown();
        this.f20584e = true;
        z();
        this.f20581b.cancel();
        this.f20583d.b();
    }

    protected t(Context context) {
        Timer timer = new Timer();
        this.f20581b = timer;
        this.f20585f = 0;
        this.f20586g = 0L;
        this.f20587h = 0L;
        this.f20588i = Long.MAX_VALUE;
        this.f20589j = 0L;
        this.f20590k = 0L;
        this.f20591l = Long.MAX_VALUE;
        this.f20592m = 0;
        this.f20593n = 0;
        this.f20580a = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
        this.f20582c = new k(TaskExecutors.MAIN_THREAD);
        timer.scheduleAtFixedRate(new a(), 0L, 1000L);
        this.f20583d = new l(context);
    }

    private Task<T> A(Task<T> task, final GraphicOverlay graphicOverlay, @Nullable final Bitmap originalCameraImage, final boolean shouldShowFps, final long frameStartMs) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        return task.addOnSuccessListener(this.f20582c, new OnSuccessListener() { // from class: com.bxkj.student.v2.ai.fitness.camera.n
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                t.this.r(frameStartMs, elapsedRealtime, graphicOverlay, originalCameraImage, shouldShowFps, obj);
            }
        }).addOnFailureListener(this.f20582c, new OnFailureListener() { // from class: com.bxkj.student.v2.ai.fitness.camera.o
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                t.this.s(graphicOverlay, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(GraphicOverlay graphicOverlay, Object obj) {
        w(graphicOverlay);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(GraphicOverlay graphicOverlay, Object obj) {
        w(graphicOverlay);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void r(long j6, long j7, GraphicOverlay graphicOverlay, Bitmap bitmap, boolean z5, Object obj) {
        GraphicOverlay graphicOverlay2;
        Integer num;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j8 = elapsedRealtime - j6;
        long j9 = elapsedRealtime - j7;
        if (this.f20585f >= 500) {
            z();
        }
        this.f20585f++;
        this.f20592m++;
        this.f20586g += j8;
        this.f20587h = Math.max(j8, this.f20587h);
        this.f20588i = Math.min(j8, this.f20588i);
        this.f20589j += j9;
        this.f20590k = Math.max(j9, this.f20590k);
        this.f20591l = Math.min(j9, this.f20591l);
        if (this.f20592m == 1) {
            long j10 = this.f20586g / this.f20585f;
            long j11 = this.f20589j / this.f20585f;
            this.f20580a.getMemoryInfo(new ActivityManager.MemoryInfo());
            this.f20583d.a();
        }
        graphicOverlay.h();
        if (bitmap != null) {
            graphicOverlay.g(new b(graphicOverlay, bitmap));
        }
        u(obj, graphicOverlay);
        if (!com.bxkj.student.v2.ai.fitness.preference.a.g(graphicOverlay.getContext())) {
            if (z5) {
                num = Integer.valueOf(this.f20593n);
            } else {
                num = null;
            }
            Integer num2 = num;
            graphicOverlay2 = graphicOverlay;
            graphicOverlay2.g(new i(graphicOverlay2, j8, j9, num2));
        } else {
            graphicOverlay2 = graphicOverlay;
        }
        graphicOverlay2.postInvalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(GraphicOverlay graphicOverlay, Exception exc) {
        graphicOverlay.h();
        graphicOverlay.postInvalidate();
        String str = "Failed to process. Error: " + exc.getLocalizedMessage();
        Toast.makeText(graphicOverlay.getContext(), str + "\nCause: " + exc.getCause(), 0).show();
        exc.printStackTrace();
        t(exc);
    }

    private void v(ByteBuffer data, final f frameMetadata, final GraphicOverlay graphicOverlay) {
        Bitmap c6;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (com.bxkj.student.v2.ai.fitness.preference.a.d(graphicOverlay.getContext())) {
            c6 = null;
        } else {
            c6 = com.bxkj.student.v2.ai.fitness.camera.a.c(data, frameMetadata);
        }
        Bitmap bitmap = c6;
        if (o(graphicOverlay.getContext())) {
            MlImage build = new ByteBufferMlImageBuilder(data, frameMetadata.c(), frameMetadata.a(), 4).setRotation(frameMetadata.b()).build();
            x(build, graphicOverlay, bitmap, true, elapsedRealtime).addOnSuccessListener(this.f20582c, new OnSuccessListener() { // from class: com.bxkj.student.v2.ai.fitness.camera.r
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    t.this.p(graphicOverlay, obj);
                }
            });
            build.close();
            return;
        }
        y(InputImage.fromByteBuffer(data, frameMetadata.c(), frameMetadata.a(), frameMetadata.b(), 17), graphicOverlay, bitmap, true, elapsedRealtime).addOnSuccessListener(this.f20582c, new OnSuccessListener() { // from class: com.bxkj.student.v2.ai.fitness.camera.s
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                t.this.q(graphicOverlay, obj);
            }
        });
    }

    private Task<T> x(final MlImage image, final GraphicOverlay graphicOverlay, @Nullable final Bitmap originalCameraImage, boolean shouldShowFps, long frameStartMs) {
        return A(m(image), graphicOverlay, originalCameraImage, shouldShowFps, frameStartMs);
    }

    private Task<T> y(final InputImage image, final GraphicOverlay graphicOverlay, @Nullable final Bitmap originalCameraImage, boolean shouldShowFps, long frameStartMs) {
        return A(n(image), graphicOverlay, originalCameraImage, shouldShowFps, frameStartMs);
    }

    @Override // com.bxkj.student.v2.ai.fitness.camera.m
    @ExperimentalGetImage
    @RequiresApi(21)
    public void b(final ImageProxy image, GraphicOverlay graphicOverlay) {
        Bitmap bitmap;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.f20584e) {
            image.close();
            return;
        }
        if (!com.bxkj.student.v2.ai.fitness.preference.a.d(graphicOverlay.getContext())) {
            bitmap = com.bxkj.student.v2.ai.fitness.camera.a.b(image);
        } else {
            bitmap = null;
        }
        Bitmap bitmap2 = bitmap;
        if (o(graphicOverlay.getContext())) {
            x(new MediaMlImageBuilder(image.getImage()).setRotation(image.getImageInfo().getRotationDegrees()).build(), graphicOverlay, bitmap2, true, elapsedRealtime).addOnCompleteListener(new OnCompleteListener() { // from class: com.bxkj.student.v2.ai.fitness.camera.p
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    ImageProxy.this.close();
                }
            });
        } else {
            y(InputImage.fromMediaImage(image.getImage(), image.getImageInfo().getRotationDegrees()), graphicOverlay, bitmap2, true, elapsedRealtime).addOnCompleteListener(new OnCompleteListener() { // from class: com.bxkj.student.v2.ai.fitness.camera.q
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    ImageProxy.this.close();
                }
            });
        }
    }

    @Override // com.bxkj.student.v2.ai.fitness.camera.m
    public void c(Bitmap bitmap, final GraphicOverlay graphicOverlay) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (o(graphicOverlay.getContext())) {
            MlImage build = new BitmapMlImageBuilder(bitmap).build();
            x(build, graphicOverlay, null, false, elapsedRealtime);
            build.close();
            return;
        }
        y(InputImage.fromBitmap(bitmap, 0), graphicOverlay, null, false, elapsedRealtime);
    }
}
