package com.jmolsmobile.landscapevideocapture;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;
import com.jmolsmobile.landscapevideocapture.configuration.CaptureConfiguration;
import com.jmolsmobile.landscapevideocapture.recorder.AlreadyUsedException;
import com.jmolsmobile.landscapevideocapture.view.VideoCaptureView;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class VideoCaptureActivity extends Activity implements com.jmolsmobile.landscapevideocapture.view.a, com.jmolsmobile.landscapevideocapture.recorder.b {

    /* renamed from: g, reason: collision with root package name */
    public static final int f35573g = 753245;

    /* renamed from: h, reason: collision with root package name */
    private static final int f35574h = 578465;

    /* renamed from: i, reason: collision with root package name */
    public static final String f35575i = "com.jmolsmobile.extraoutputfilename";

    /* renamed from: j, reason: collision with root package name */
    public static final String f35576j = "com.jmolsmobile.extracaptureconfiguration";

    /* renamed from: k, reason: collision with root package name */
    public static final String f35577k = "com.jmolsmobile.extraerrormessage";

    /* renamed from: l, reason: collision with root package name */
    private static final String f35578l = "com.jmolsmobile.extracamerafacing";

    /* renamed from: m, reason: collision with root package name */
    private static final String f35579m = "com.jmolsmobile.savedrecordedboolean";

    /* renamed from: n, reason: collision with root package name */
    protected static final String f35580n = "com.jmolsmobile.savedoutputfilename";

    /* renamed from: a, reason: collision with root package name */
    private boolean f35581a = false;

    /* renamed from: b, reason: collision with root package name */
    c f35582b = null;

    /* renamed from: c, reason: collision with root package name */
    private CaptureConfiguration f35583c;

    /* renamed from: d, reason: collision with root package name */
    private VideoCaptureView f35584d;

    /* renamed from: e, reason: collision with root package name */
    private com.jmolsmobile.landscapevideocapture.recorder.a f35585e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f35586f;

    static {
        StubApp.interface11(34951);
    }

    private void i() {
        setResult(0);
        finish();
    }

    private boolean o(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        return bundle.getBoolean(f35579m, false);
    }

    @Override // com.jmolsmobile.landscapevideocapture.recorder.b
    public void g() {
        this.f35581a = true;
    }

    @Override // android.app.Activity
    public native void onCreate(Bundle bundle);

    private void j() {
        Intent intent = new Intent();
        intent.putExtra(f35575i, this.f35582b.d());
        setResult(-1, intent);
        finish();
    }

    private void r() {
        this.f35585e = new com.jmolsmobile.landscapevideocapture.recorder.a(this, this.f35583c, this.f35582b, new com.jmolsmobile.landscapevideocapture.camera.b(new com.jmolsmobile.landscapevideocapture.camera.c(), ((WindowManager) getSystemService("window")).getDefaultDisplay().getRotation()), this.f35584d.getPreviewSurfaceHolder(), this.f35586f);
        this.f35584d.setRecordingButtonInterface(this);
        this.f35584d.setCameraSwitchingEnabled(this.f35583c.i());
        this.f35584d.setCameraFacing(this.f35586f);
        if (this.f35581a) {
            this.f35584d.i(p());
        } else {
            this.f35584d.h();
        }
        this.f35584d.f(this.f35583c.s());
    }

    private void s() {
        com.jmolsmobile.landscapevideocapture.recorder.a aVar = this.f35585e;
        if (aVar != null) {
            aVar.h();
        }
    }

    @Override // com.jmolsmobile.landscapevideocapture.view.a
    public void a() {
        try {
            this.f35585e.n();
        } catch (AlreadyUsedException unused) {
            b.a(b.f35595b, "Cannot toggle recording after cleaning up all resources");
        }
    }

    @Override // com.jmolsmobile.landscapevideocapture.recorder.b
    public void c(String str) {
        if (str != null) {
            Toast.makeText(this, str, 1).show();
        }
        this.f35584d.i(p());
        s();
    }

    @Override // com.jmolsmobile.landscapevideocapture.recorder.b
    public void f() {
        this.f35584d.j();
    }

    @Override // com.jmolsmobile.landscapevideocapture.view.a
    public void h(boolean z5) {
        Intent intent = new Intent(this, (Class<?>) VideoCaptureActivity.class);
        intent.putExtras(getIntent().getExtras());
        intent.putExtra(f35578l, z5);
        startActivityForResult(intent, f35574h);
        overridePendingTransition(R.anim.from_middle, R.anim.to_middle);
    }

    protected c n(Bundle bundle) {
        return bundle != null ? new c(bundle.getString(f35580n)) : new c(getIntent().getStringExtra(f35575i));
    }

    @Override // android.app.Activity
    protected void onPause() {
        com.jmolsmobile.landscapevideocapture.recorder.a aVar = this.f35585e;
        if (aVar != null) {
            aVar.m(null);
        }
        s();
        super.onPause();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(f35579m, this.f35581a);
        bundle.putString(f35580n, this.f35582b.d());
        super.onSaveInstanceState(bundle);
    }

    public Bitmap p() {
        Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(this.f35582b.d(), 2);
        if (createVideoThumbnail == null) {
            b.a(b.f35595b, "Failed to generate video preview");
        }
        return createVideoThumbnail;
    }

    private void k(String str) {
        Toast.makeText(StubApp.getOrigApplicationContext(getApplicationContext()), "Can't capture video: " + str, 1).show();
        Intent intent = new Intent();
        intent.putExtra(f35577k, str);
        setResult(f35573g, intent);
        finish();
    }

    private boolean m() {
        return getIntent().getBooleanExtra(f35578l, false);
    }

    private void q(Bundle bundle) {
        this.f35583c = l();
        this.f35581a = o(bundle);
        this.f35582b = n(bundle);
        this.f35586f = m();
    }

    @Override // com.jmolsmobile.landscapevideocapture.view.a
    public void b() {
        j();
    }

    @Override // com.jmolsmobile.landscapevideocapture.view.a
    public void d() {
        i();
    }

    @Override // com.jmolsmobile.landscapevideocapture.recorder.b
    public void e(String str) {
        k(str);
    }

    protected CaptureConfiguration l() {
        CaptureConfiguration captureConfiguration = (CaptureConfiguration) getIntent().getParcelableExtra(f35576j);
        if (captureConfiguration == null) {
            CaptureConfiguration n6 = CaptureConfiguration.n();
            b.a(b.f35595b, "No captureconfiguration passed - using default configuration");
            return n6;
        }
        return captureConfiguration;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i6, int i7, Intent intent) {
        setResult(i7, intent);
        finish();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        i();
    }
}
