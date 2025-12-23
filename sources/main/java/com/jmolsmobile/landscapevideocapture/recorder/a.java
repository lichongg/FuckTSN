package com.jmolsmobile.landscapevideocapture.recorder;

import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.view.SurfaceHolder;
import com.jmolsmobile.landscapevideocapture.c;
import com.jmolsmobile.landscapevideocapture.camera.OpenCameraException;
import com.jmolsmobile.landscapevideocapture.camera.PrepareCameraException;
import com.jmolsmobile.landscapevideocapture.camera.d;
import com.jmolsmobile.landscapevideocapture.configuration.CaptureConfiguration;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class a implements MediaRecorder.OnInfoListener, com.jmolsmobile.landscapevideocapture.preview.b {

    /* renamed from: a, reason: collision with root package name */
    private com.jmolsmobile.landscapevideocapture.camera.b f35664a;

    /* renamed from: b, reason: collision with root package name */
    private com.jmolsmobile.landscapevideocapture.preview.a f35665b;

    /* renamed from: c, reason: collision with root package name */
    private final CaptureConfiguration f35666c;

    /* renamed from: d, reason: collision with root package name */
    private final c f35667d;

    /* renamed from: e, reason: collision with root package name */
    private MediaRecorder f35668e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f35669f = false;

    /* renamed from: g, reason: collision with root package name */
    private final b f35670g;

    protected void l() {
        this.f35669f = false;
        if (d() && g() && k()) {
            this.f35669f = true;
            this.f35670g.f();
            com.jmolsmobile.landscapevideocapture.b.a(com.jmolsmobile.landscapevideocapture.b.f35598e, "Successfully started recording - outputfile: " + this.f35667d.d());
        }
    }

    private boolean d() {
        try {
            this.f35664a.k();
            j(new MediaRecorder());
            b(c(), this.f35664a.d());
            com.jmolsmobile.landscapevideocapture.b.a(com.jmolsmobile.landscapevideocapture.b.f35598e, "MediaRecorder successfully initialized");
            return true;
        } catch (PrepareCameraException e6) {
            e6.printStackTrace();
            this.f35670g.e("Unable to record video");
            com.jmolsmobile.landscapevideocapture.b.b(com.jmolsmobile.landscapevideocapture.b.f35598e, "Failed to initialize recorder - " + e6.toString());
            return false;
        }
    }

    private boolean g() {
        try {
            c().prepare();
            com.jmolsmobile.landscapevideocapture.b.a(com.jmolsmobile.landscapevideocapture.b.f35598e, "MediaRecorder successfully prepared");
            return true;
        } catch (IOException e6) {
            e6.printStackTrace();
            com.jmolsmobile.landscapevideocapture.b.b(com.jmolsmobile.landscapevideocapture.b.f35598e, "MediaRecorder preparation failed - " + e6.toString());
            return false;
        } catch (IllegalStateException e7) {
            e7.printStackTrace();
            com.jmolsmobile.landscapevideocapture.b.b(com.jmolsmobile.landscapevideocapture.b.f35598e, "MediaRecorder preparation failed - " + e7.toString());
            return false;
        }
    }

    private boolean k() {
        try {
            c().start();
            com.jmolsmobile.landscapevideocapture.b.a(com.jmolsmobile.landscapevideocapture.b.f35598e, "MediaRecorder successfully started");
            return true;
        } catch (IllegalStateException e6) {
            e6.printStackTrace();
            com.jmolsmobile.landscapevideocapture.b.b(com.jmolsmobile.landscapevideocapture.b.f35598e, "MediaRecorder start failed - " + e6.toString());
            return false;
        } catch (RuntimeException e7) {
            e7.printStackTrace();
            com.jmolsmobile.landscapevideocapture.b.b(com.jmolsmobile.landscapevideocapture.b.f35598e, "MediaRecorder start failed - " + e7.toString());
            this.f35670g.e("Unable to record video with given settings");
            return false;
        }
    }

    @Override // com.jmolsmobile.landscapevideocapture.preview.b
    public void a() {
        this.f35670g.e("Unable to show camera preview");
    }

    protected void b(MediaRecorder mediaRecorder, Camera camera) throws IllegalStateException, IllegalArgumentException {
        mediaRecorder.setCamera(camera);
        mediaRecorder.setAudioSource(this.f35666c.l());
        mediaRecorder.setVideoSource(this.f35666c.x());
        CamcorderProfile c6 = this.f35664a.c();
        c6.fileFormat = this.f35666c.q();
        d h6 = this.f35664a.h(this.f35666c.y(), this.f35666c.w());
        c6.videoFrameWidth = h6.f35614a;
        c6.videoFrameHeight = h6.f35615b;
        c6.videoBitRate = this.f35666c.t();
        c6.audioCodec = this.f35666c.k();
        c6.videoCodec = this.f35666c.u();
        mediaRecorder.setProfile(c6);
        mediaRecorder.setMaxDuration(this.f35666c.o());
        mediaRecorder.setOutputFile(this.f35667d.d());
        mediaRecorder.setOrientationHint(this.f35664a.g());
        mediaRecorder.setVideoFrameRate(this.f35666c.v());
        try {
            mediaRecorder.setMaxFileSize(this.f35666c.p());
        } catch (IllegalArgumentException unused) {
            com.jmolsmobile.landscapevideocapture.b.b(com.jmolsmobile.landscapevideocapture.b.f35598e, "Failed to set max filesize - illegal argument: " + this.f35666c.p());
        } catch (RuntimeException unused2) {
            com.jmolsmobile.landscapevideocapture.b.b(com.jmolsmobile.landscapevideocapture.b.f35598e, "Failed to set max filesize - runtime exception");
        }
        mediaRecorder.setOnInfoListener(this);
    }

    protected MediaRecorder c() {
        return this.f35668e;
    }

    protected void e(SurfaceHolder surfaceHolder, boolean z5) {
        try {
            this.f35664a.j(z5);
            this.f35665b = new com.jmolsmobile.landscapevideocapture.preview.a(this, this.f35664a, surfaceHolder);
        } catch (OpenCameraException e6) {
            e6.printStackTrace();
            this.f35670g.e(e6.getMessage());
        }
    }

    protected boolean f() {
        return this.f35669f;
    }

    public void h() {
        com.jmolsmobile.landscapevideocapture.preview.a aVar = this.f35665b;
        if (aVar != null) {
            aVar.c();
        }
        com.jmolsmobile.landscapevideocapture.camera.b bVar = this.f35664a;
        if (bVar != null) {
            bVar.l();
            this.f35664a = null;
        }
        i();
        com.jmolsmobile.landscapevideocapture.b.a(com.jmolsmobile.landscapevideocapture.b.f35598e, "Released all resources");
    }

    protected void j(MediaRecorder mediaRecorder) {
        this.f35668e = mediaRecorder;
    }

    public void m(String str) {
        if (f()) {
            try {
                c().stop();
                this.f35670g.g();
                com.jmolsmobile.landscapevideocapture.b.a(com.jmolsmobile.landscapevideocapture.b.f35598e, "Successfully stopped recording - outputfile: " + this.f35667d.d());
            } catch (RuntimeException unused) {
                com.jmolsmobile.landscapevideocapture.b.a(com.jmolsmobile.landscapevideocapture.b.f35598e, "Failed to stop recording");
            }
            this.f35669f = false;
            this.f35670g.c(str);
        }
    }

    public void n() throws AlreadyUsedException {
        if (this.f35664a == null) {
            throw new AlreadyUsedException();
        }
        if (f()) {
            m(null);
        } else {
            l();
        }
    }

    @Override // android.media.MediaRecorder.OnInfoListener
    public void onInfo(MediaRecorder mediaRecorder, int i6, int i7) {
        if (i6 != 800) {
            if (i6 != 801) {
                return;
            }
            com.jmolsmobile.landscapevideocapture.b.a(com.jmolsmobile.landscapevideocapture.b.f35598e, "MediaRecorder max filesize reached");
            m("Capture stopped - Max file size reached");
            return;
        }
        com.jmolsmobile.landscapevideocapture.b.a(com.jmolsmobile.landscapevideocapture.b.f35598e, "MediaRecorder max duration reached");
        m("录制完成,已达最大" + (this.f35666c.o() / 1000) + "秒限制");
    }

    public a(b bVar, CaptureConfiguration captureConfiguration, c cVar, com.jmolsmobile.landscapevideocapture.camera.b bVar2, SurfaceHolder surfaceHolder, boolean z5) {
        this.f35666c = captureConfiguration;
        this.f35670g = bVar;
        this.f35667d = cVar;
        this.f35664a = bVar2;
        e(surfaceHolder, z5);
    }

    private void i() {
        MediaRecorder c6 = c();
        if (c6 != null) {
            c6.release();
            j(null);
        }
    }
}
