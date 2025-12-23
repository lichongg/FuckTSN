package com.bxkj.student.v2.ai.fitness.posedetector;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bxkj.student.v2.ai.fitness.camera.GraphicOverlay;
import com.bxkj.student.v2.ai.fitness.camera.t;
import com.bxkj.student.v2.ai.fitness.posedetector.c;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.odml.image.MlImage;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.pose.Pose;
import com.google.mlkit.vision.pose.PoseDetection;
import com.google.mlkit.vision.pose.PoseDetector;
import com.google.mlkit.vision.pose.PoseDetectorOptionsBase;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import k0.g;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class c extends t<b> {
    private static final String G = "PoseDetectorProcessor";
    private final Context A;
    private final Executor B;
    private g C;
    private String D;
    private String[] E;
    private a F;

    /* renamed from: u, reason: collision with root package name */
    private final PoseDetector f20606u;

    /* renamed from: v, reason: collision with root package name */
    private final boolean f20607v;

    /* renamed from: w, reason: collision with root package name */
    private final boolean f20608w;

    /* renamed from: x, reason: collision with root package name */
    private final boolean f20609x;

    /* renamed from: y, reason: collision with root package name */
    private final boolean f20610y;

    /* renamed from: z, reason: collision with root package name */
    private final boolean f20611z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a(List<String> classificationResult);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    protected static class b {

        /* renamed from: a, reason: collision with root package name */
        private final Pose f20612a;

        /* renamed from: b, reason: collision with root package name */
        private final List<String> f20613b;

        public List<String> c() {
            return this.f20613b;
        }

        public Pose d() {
            return this.f20612a;
        }

        public b(Pose pose, List<String> classificationResult) {
            this.f20612a = pose;
            this.f20613b = classificationResult;
        }
    }

    public c(Context context, boolean runClassification, boolean isStreamMode) {
        super(context);
        PoseDetectorOptionsBase c6 = com.bxkj.student.v2.ai.fitness.preference.a.c(context);
        Objects.toString(c6);
        this.f20607v = com.bxkj.student.v2.ai.fitness.preference.a.j(context);
        this.f20608w = com.bxkj.student.v2.ai.fitness.preference.a.i(context);
        this.f20609x = com.bxkj.student.v2.ai.fitness.preference.a.h(context);
        this.f20606u = PoseDetection.getClient(c6);
        this.f20610y = runClassification;
        this.f20611z = isStreamMode;
        this.A = context;
        this.B = Executors.newSingleThreadExecutor();
    }

    @Override // com.bxkj.student.v2.ai.fitness.camera.t
    protected boolean o(Context context) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bxkj.student.v2.ai.fitness.camera.t
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public void u(@NonNull b poseWithClassification, @NonNull GraphicOverlay graphicOverlay) {
        a aVar;
        graphicOverlay.g(new d(graphicOverlay, poseWithClassification.f20612a, this.f20607v, this.f20608w, this.f20609x, poseWithClassification.f20613b, this.f20611z, this.E[0]));
        if (poseWithClassification.d().getAllPoseLandmarks().isEmpty() || (aVar = this.F) == null) {
            return;
        }
        aVar.a(poseWithClassification.c());
    }

    public c G(a listener) {
        this.F = listener;
        return this;
    }

    @Override // com.bxkj.student.v2.ai.fitness.camera.t
    protected Task<b> m(MlImage image) {
        return this.f20606u.process(image).continueWith(this.B, new Continuation() { // from class: com.bxkj.student.v2.ai.fitness.posedetector.b
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                c.b E;
                E = c.this.E(task);
                return E;
            }
        });
    }

    @Override // com.bxkj.student.v2.ai.fitness.camera.t
    protected Task<b> n(InputImage image) {
        return this.f20606u.process(image).continueWith(this.B, new Continuation() { // from class: com.bxkj.student.v2.ai.fitness.posedetector.a
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                c.b D;
                D = c.this.D(task);
                return D;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ b D(Task task) throws Exception {
        Pose pose = (Pose) task.getResult();
        List<String> arrayList = new ArrayList<>();
        if (this.f20610y) {
            if (this.C == null) {
                this.C = new g(this.A, this.f20611z, this.D, this.E);
            }
            arrayList = this.C.a(pose);
        }
        return new b(pose, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ b E(Task task) throws Exception {
        Pose pose = (Pose) task.getResult();
        List<String> arrayList = new ArrayList<>();
        if (this.f20610y) {
            if (this.C == null) {
                this.C = new g(this.A, this.f20611z, this.D, this.E);
            }
            arrayList = this.C.a(pose);
        }
        return new b(pose, arrayList);
    }

    @Override // com.bxkj.student.v2.ai.fitness.camera.t, com.bxkj.student.v2.ai.fitness.camera.m
    public void stop() {
        super.stop();
        this.f20606u.close();
    }

    public c(Context context, boolean runClassification, boolean isStreamMode, String poseSamplesFile, String[] poseClasses) {
        this(context, runClassification, isStreamMode);
        this.D = poseSamplesFile;
        this.E = poseClasses;
    }

    public c(Context context, boolean runClassification, boolean isStreamMode, String poseSamplesFile, String poseClass) {
        this(context, runClassification, isStreamMode);
        this.D = poseSamplesFile;
        this.E = new String[]{poseClass};
    }

    @Override // com.bxkj.student.v2.ai.fitness.camera.t
    protected void t(@NonNull Exception e6) {
    }
}
