package com.bxkj.student.v2.ui.sports.v3.dxyy.ar.helloar;

import android.opengl.GLES20;
import cn.easyar.Buffer;
import cn.easyar.CameraDevice;
import cn.easyar.CameraDeviceSelector;
import cn.easyar.CameraParameters;
import cn.easyar.DelayedCallbackScheduler;
import cn.easyar.FeedbackFrameFork;
import cn.easyar.FeedbackFrameSource;
import cn.easyar.FunctorOfVoidFromTargetAndBool;
import cn.easyar.Image;
import cn.easyar.ImageTarget;
import cn.easyar.ImageTracker;
import cn.easyar.ImageTrackerResult;
import cn.easyar.InputFrame;
import cn.easyar.InputFrameFork;
import cn.easyar.InputFrameSource;
import cn.easyar.InputFrameThrottler;
import cn.easyar.InputFrameToFeedbackFrameAdapter;
import cn.easyar.InputFrameToOutputFrameAdapter;
import cn.easyar.Matrix44F;
import cn.easyar.OutputFrame;
import cn.easyar.OutputFrameBuffer;
import cn.easyar.OutputFrameFork;
import cn.easyar.OutputFrameJoin;
import cn.easyar.OutputFrameSource;
import cn.easyar.SignalSource;
import cn.easyar.Target;
import cn.easyar.TargetInstance;
import cn.easyar.Vec2F;
import cn.easyar.Vec2I;
import cn.easyar.o;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private CameraDevice f21751b;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private BGRenderer f21753d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private a f21754e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private InputFrameThrottler f21755f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    private FeedbackFrameFork f21756g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    private InputFrameToOutputFrameAdapter f21757h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    private InputFrameFork f21758i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    private OutputFrameJoin f21759j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    private OutputFrameBuffer f21760k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    private InputFrameToFeedbackFrameAdapter f21761l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    private OutputFrameFork f21762m;

    /* renamed from: o, reason: collision with root package name */
    @Nullable
    private byte[] f21764o;

    /* renamed from: n, reason: collision with root package name */
    private int f21763n = -1;

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private DelayedCallbackScheduler f21750a = new DelayedCallbackScheduler();

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final ArrayList<ImageTracker> f21752c = new ArrayList<>();

    private final void d(ImageTracker imageTracker, String str, String str2) {
        ImageTarget createFromImageFile = ImageTarget.createFromImageFile(str, 1, str2, "", "", 1.0f);
        if (createFromImageFile == null) {
            return;
        }
        DelayedCallbackScheduler delayedCallbackScheduler = this.f21750a;
        g0.m(delayedCallbackScheduler);
        imageTracker.loadTarget(createFromImageFile, delayedCallbackScheduler, new FunctorOfVoidFromTargetAndBool() { // from class: com.bxkj.student.v2.ui.sports.v3.dxyy.ar.helloar.b
            @Override // cn.easyar.FunctorOfVoidFromTargetAndBool
            public final void a(Target target, boolean z5) {
                c.e(target, z5);
            }
        });
        createFromImageFile.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Target t5, boolean z5) {
        g0.p(t5, "t");
        t0 t0Var = t0.f44062a;
        g0.o(String.format("load target (%b): %s (%d)", Arrays.copyOf(new Object[]{Boolean.valueOf(z5), t5.name(), Integer.valueOf(t5.runtimeID())}, 3)), "format(...)");
    }

    public final void b() {
        Iterator<ImageTracker> it = this.f21752c.iterator();
        g0.o(it, "iterator(...)");
        while (it.hasNext()) {
            ImageTracker next = it.next();
            g0.o(next, "next(...)");
            next.a();
        }
        this.f21752c.clear();
        BGRenderer bGRenderer = this.f21753d;
        if (bGRenderer != null) {
            g0.m(bGRenderer);
            bGRenderer.a();
            this.f21753d = null;
        }
        a aVar = this.f21754e;
        if (aVar != null) {
            g0.m(aVar);
            aVar.c();
            this.f21754e = null;
        }
        CameraDevice cameraDevice = this.f21751b;
        if (cameraDevice != null) {
            g0.m(cameraDevice);
            cameraDevice.a();
            this.f21751b = null;
        }
        DelayedCallbackScheduler delayedCallbackScheduler = this.f21750a;
        if (delayedCallbackScheduler != null) {
            g0.m(delayedCallbackScheduler);
            delayedCallbackScheduler.a();
            this.f21750a = null;
        }
    }

    public final void f() {
        BGRenderer bGRenderer = this.f21753d;
        if (bGRenderer != null) {
            g0.m(bGRenderer);
            bGRenderer.a();
            this.f21753d = null;
        }
        a aVar = this.f21754e;
        if (aVar != null) {
            g0.m(aVar);
            aVar.c();
            this.f21754e = null;
        }
        this.f21763n = -1;
        this.f21753d = new BGRenderer();
        this.f21754e = new a();
    }

    public final void g(int i6, int i7, int i8) {
        DelayedCallbackScheduler delayedCallbackScheduler;
        Image image;
        do {
            delayedCallbackScheduler = this.f21750a;
            g0.m(delayedCallbackScheduler);
        } while (delayedCallbackScheduler.runOne());
        int i9 = 0;
        GLES20.glViewport(0, 0, i6, i7);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(16640);
        OutputFrameBuffer outputFrameBuffer = this.f21760k;
        g0.m(outputFrameBuffer);
        OutputFrame peek = outputFrameBuffer.peek();
        if (peek == null) {
            return;
        }
        InputFrame inputFrame = peek.inputFrame();
        g0.o(inputFrame, "inputFrame(...)");
        CameraParameters cameraParameters = inputFrame.cameraParameters();
        g0.o(cameraParameters, "cameraParameters(...)");
        float f6 = i6 / i7;
        Matrix44F imageProjection = cameraParameters.imageProjection(f6, i8, true, false);
        g0.o(imageProjection, "imageProjection(...)");
        Image image2 = inputFrame.image();
        g0.o(image2, "image(...)");
        try {
            if (inputFrame.index() != this.f21763n) {
                Buffer buffer = image2.buffer();
                g0.o(buffer, "buffer(...)");
                try {
                    byte[] bArr = this.f21764o;
                    if (bArr != null) {
                        g0.m(bArr);
                        if (bArr.length != buffer.size()) {
                        }
                        byte[] bArr2 = this.f21764o;
                        g0.m(bArr2);
                        buffer.h(bArr2);
                        BGRenderer bGRenderer = this.f21753d;
                        g0.m(bGRenderer);
                        int format = image2.format();
                        int width = image2.width();
                        int height = image2.height();
                        int pixelWidth = image2.pixelWidth();
                        int pixelHeight = image2.pixelHeight();
                        byte[] bArr3 = this.f21764o;
                        g0.m(bArr3);
                        ByteBuffer wrap = ByteBuffer.wrap(bArr3);
                        g0.o(wrap, "wrap(...)");
                        bGRenderer.g(format, width, height, pixelWidth, pixelHeight, wrap);
                        buffer.a();
                        this.f21763n = inputFrame.index();
                    }
                    this.f21764o = new byte[buffer.size()];
                    byte[] bArr22 = this.f21764o;
                    g0.m(bArr22);
                    buffer.h(bArr22);
                    BGRenderer bGRenderer2 = this.f21753d;
                    g0.m(bGRenderer2);
                    int format2 = image2.format();
                    int width2 = image2.width();
                    int height2 = image2.height();
                    int pixelWidth2 = image2.pixelWidth();
                    int pixelHeight2 = image2.pixelHeight();
                    byte[] bArr32 = this.f21764o;
                    g0.m(bArr32);
                    ByteBuffer wrap2 = ByteBuffer.wrap(bArr32);
                    g0.o(wrap2, "wrap(...)");
                    bGRenderer2.g(format2, width2, height2, pixelWidth2, pixelHeight2, wrap2);
                    buffer.a();
                    this.f21763n = inputFrame.index();
                } finally {
                    buffer.a();
                }
            }
            BGRenderer bGRenderer3 = this.f21753d;
            g0.m(bGRenderer3);
            bGRenderer3.e(imageProjection);
            Matrix44F projection = cameraParameters.projection(0.01f, 1000.0f, f6, i8, true, false);
            g0.o(projection, "projection(...)");
            Iterator<o> it = peek.results().iterator();
            g0.o(it, "iterator(...)");
            while (it.hasNext()) {
                o next = it.next();
                ImageTrackerResult imageTrackerResult = next instanceof ImageTrackerResult ? (ImageTrackerResult) next : null;
                if (imageTrackerResult != null) {
                    Iterator<TargetInstance> it2 = imageTrackerResult.targetInstances().iterator();
                    g0.o(it2, "iterator(...)");
                    while (it2.hasNext()) {
                        TargetInstance next2 = it2.next();
                        g0.o(next2, "next(...)");
                        TargetInstance targetInstance = next2;
                        Target target = targetInstance.target();
                        g0.o(target, "target(...)");
                        ImageTarget imageTarget = target instanceof ImageTarget ? (ImageTarget) target : null;
                        if (imageTarget != null) {
                            ArrayList<Image> images = ((ImageTarget) target).images();
                            g0.o(images, "images(...)");
                            Image image3 = images.get(i9);
                            g0.o(image3, "get(...)");
                            Image image4 = image3;
                            float scale = imageTarget.scale();
                            image = image2;
                            try {
                                Vec2F vec2F = new Vec2F(scale, (image4.height() * scale) / image4.width());
                                a aVar = this.f21754e;
                                g0.m(aVar);
                                Matrix44F pose = targetInstance.pose();
                                g0.o(pose, "pose(...)");
                                aVar.j(projection, pose, vec2F);
                                Iterator<Image> it3 = images.iterator();
                                g0.o(it3, "iterator(...)");
                                while (it3.hasNext()) {
                                    Image next3 = it3.next();
                                    g0.o(next3, "next(...)");
                                    next3.a();
                                }
                                image2 = image;
                                i9 = 0;
                            } catch (Throwable th) {
                                th = th;
                                inputFrame.a();
                                peek.a();
                                cameraParameters.a();
                                image.a();
                                throw th;
                            }
                        }
                    }
                    Image image5 = image2;
                    imageTrackerResult.a();
                    image2 = image5;
                    i9 = 0;
                }
            }
            inputFrame.a();
            peek.a();
            cameraParameters.a();
            image2.a();
        } catch (Throwable th2) {
            th = th2;
            image = image2;
        }
    }

    public final boolean h() {
        boolean z5;
        CameraDevice cameraDevice = this.f21751b;
        if (cameraDevice != null) {
            g0.m(cameraDevice);
            z5 = cameraDevice.start();
        } else {
            z5 = false;
        }
        Iterator<ImageTracker> it = this.f21752c.iterator();
        g0.o(it, "iterator(...)");
        while (it.hasNext()) {
            ImageTracker next = it.next();
            g0.o(next, "next(...)");
            z5 &= next.start();
        }
        return z5;
    }

    public final void i() {
        CameraDevice cameraDevice = this.f21751b;
        if (cameraDevice != null) {
            g0.m(cameraDevice);
            cameraDevice.stop();
        }
        Iterator<ImageTracker> it = this.f21752c.iterator();
        g0.o(it, "iterator(...)");
        while (it.hasNext()) {
            ImageTracker next = it.next();
            g0.o(next, "next(...)");
            next.stop();
        }
    }

    public final void c() {
        f();
        this.f21751b = CameraDeviceSelector.createCameraDevice(0);
        this.f21755f = InputFrameThrottler.create();
        this.f21758i = InputFrameFork.create(2);
        this.f21759j = OutputFrameJoin.create(2);
        this.f21760k = OutputFrameBuffer.create();
        this.f21757h = InputFrameToOutputFrameAdapter.create();
        this.f21761l = InputFrameToFeedbackFrameAdapter.create();
        this.f21762m = OutputFrameFork.create(2);
        CameraDevice cameraDevice = this.f21751b;
        g0.m(cameraDevice);
        boolean openWithPreferredType = cameraDevice.openWithPreferredType(1);
        CameraDevice cameraDevice2 = this.f21751b;
        g0.m(cameraDevice2);
        cameraDevice2.setSize(new Vec2I(PredefinedCaptureConfigurations.f35648o, 960));
        CameraDevice cameraDevice3 = this.f21751b;
        g0.m(cameraDevice3);
        cameraDevice3.setFocusMode(2);
        if (!openWithPreferredType) {
            return;
        }
        ImageTracker create = ImageTracker.create();
        g0.o(create, "create(...)");
        d(create, "sightplus/argame00.jpg", "argame00");
        d(create, "sightplus/argame01.jpg", "argame01");
        d(create, "sightplus/argame02.jpg", "argame02");
        d(create, "sightplus/argame03.jpg", "argame03");
        d(create, "idback.jpg", "idback");
        d(create, "namecard.jpg", "namecard");
        create.setSimultaneousNum(6);
        this.f21752c.add(create);
        this.f21756g = FeedbackFrameFork.create(this.f21752c.size());
        CameraDevice cameraDevice4 = this.f21751b;
        g0.m(cameraDevice4);
        InputFrameSource inputFrameSource = cameraDevice4.inputFrameSource();
        InputFrameThrottler inputFrameThrottler = this.f21755f;
        g0.m(inputFrameThrottler);
        inputFrameSource.connect(inputFrameThrottler.input());
        InputFrameThrottler inputFrameThrottler2 = this.f21755f;
        g0.m(inputFrameThrottler2);
        InputFrameSource output = inputFrameThrottler2.output();
        InputFrameFork inputFrameFork = this.f21758i;
        g0.m(inputFrameFork);
        output.connect(inputFrameFork.input());
        InputFrameFork inputFrameFork2 = this.f21758i;
        g0.m(inputFrameFork2);
        InputFrameSource output2 = inputFrameFork2.output(0);
        InputFrameToOutputFrameAdapter inputFrameToOutputFrameAdapter = this.f21757h;
        g0.m(inputFrameToOutputFrameAdapter);
        output2.connect(inputFrameToOutputFrameAdapter.input());
        InputFrameToOutputFrameAdapter inputFrameToOutputFrameAdapter2 = this.f21757h;
        g0.m(inputFrameToOutputFrameAdapter2);
        OutputFrameSource output3 = inputFrameToOutputFrameAdapter2.output();
        OutputFrameJoin outputFrameJoin = this.f21759j;
        g0.m(outputFrameJoin);
        output3.connect(outputFrameJoin.input(0));
        InputFrameFork inputFrameFork3 = this.f21758i;
        g0.m(inputFrameFork3);
        InputFrameSource output4 = inputFrameFork3.output(1);
        InputFrameToFeedbackFrameAdapter inputFrameToFeedbackFrameAdapter = this.f21761l;
        g0.m(inputFrameToFeedbackFrameAdapter);
        output4.connect(inputFrameToFeedbackFrameAdapter.input());
        InputFrameToFeedbackFrameAdapter inputFrameToFeedbackFrameAdapter2 = this.f21761l;
        g0.m(inputFrameToFeedbackFrameAdapter2);
        FeedbackFrameSource output5 = inputFrameToFeedbackFrameAdapter2.output();
        FeedbackFrameFork feedbackFrameFork = this.f21756g;
        g0.m(feedbackFrameFork);
        output5.connect(feedbackFrameFork.input());
        Iterator<ImageTracker> it = this.f21752c.iterator();
        g0.o(it, "iterator(...)");
        int i6 = 0;
        int i7 = 0;
        while (it.hasNext()) {
            ImageTracker next = it.next();
            g0.o(next, "next(...)");
            ImageTracker imageTracker = next;
            FeedbackFrameFork feedbackFrameFork2 = this.f21756g;
            g0.m(feedbackFrameFork2);
            feedbackFrameFork2.output(i7).connect(imageTracker.feedbackFrameSink());
            OutputFrameSource outputFrameSource = imageTracker.outputFrameSource();
            OutputFrameJoin outputFrameJoin2 = this.f21759j;
            g0.m(outputFrameJoin2);
            i7++;
            outputFrameSource.connect(outputFrameJoin2.input(i7));
            i6 += imageTracker.bufferRequirement();
        }
        OutputFrameJoin outputFrameJoin3 = this.f21759j;
        g0.m(outputFrameJoin3);
        OutputFrameSource output6 = outputFrameJoin3.output();
        OutputFrameFork outputFrameFork = this.f21762m;
        g0.m(outputFrameFork);
        output6.connect(outputFrameFork.input());
        OutputFrameFork outputFrameFork2 = this.f21762m;
        g0.m(outputFrameFork2);
        OutputFrameSource output7 = outputFrameFork2.output(0);
        OutputFrameBuffer outputFrameBuffer = this.f21760k;
        g0.m(outputFrameBuffer);
        output7.connect(outputFrameBuffer.input());
        OutputFrameFork outputFrameFork3 = this.f21762m;
        g0.m(outputFrameFork3);
        OutputFrameSource output8 = outputFrameFork3.output(1);
        InputFrameToFeedbackFrameAdapter inputFrameToFeedbackFrameAdapter3 = this.f21761l;
        g0.m(inputFrameToFeedbackFrameAdapter3);
        output8.connect(inputFrameToFeedbackFrameAdapter3.sideInput());
        OutputFrameBuffer outputFrameBuffer2 = this.f21760k;
        g0.m(outputFrameBuffer2);
        SignalSource signalOutput = outputFrameBuffer2.signalOutput();
        InputFrameThrottler inputFrameThrottler3 = this.f21755f;
        g0.m(inputFrameThrottler3);
        signalOutput.connect(inputFrameThrottler3.signalInput());
        CameraDevice cameraDevice5 = this.f21751b;
        g0.m(cameraDevice5);
        InputFrameThrottler inputFrameThrottler4 = this.f21755f;
        g0.m(inputFrameThrottler4);
        int bufferRequirement = inputFrameThrottler4.bufferRequirement();
        InputFrameToFeedbackFrameAdapter inputFrameToFeedbackFrameAdapter4 = this.f21761l;
        g0.m(inputFrameToFeedbackFrameAdapter4);
        int bufferRequirement2 = bufferRequirement + inputFrameToFeedbackFrameAdapter4.bufferRequirement();
        OutputFrameBuffer outputFrameBuffer3 = this.f21760k;
        g0.m(outputFrameBuffer3);
        cameraDevice5.setBufferCapacity(bufferRequirement2 + outputFrameBuffer3.bufferRequirement() + i6 + 2);
    }
}
