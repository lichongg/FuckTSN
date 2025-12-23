package com.bxkj.student.v2.ai.fitness.camera;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;
import com.google.android.gms.common.images.Size;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class CameraSourcePreview extends ViewGroup {

    /* renamed from: g, reason: collision with root package name */
    private static final String f20492g = "MIDemoApp:Preview";

    /* renamed from: a, reason: collision with root package name */
    private final Context f20493a;

    /* renamed from: b, reason: collision with root package name */
    private final SurfaceView f20494b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f20495c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f20496d;

    /* renamed from: e, reason: collision with root package name */
    private c f20497e;

    /* renamed from: f, reason: collision with root package name */
    private GraphicOverlay f20498f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class a implements SurfaceHolder.Callback {
        /* synthetic */ a(CameraSourcePreview cameraSourcePreview, e eVar) {
            this();
        }

        private a() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surface) {
            CameraSourcePreview.this.f20496d = true;
            try {
                CameraSourcePreview.this.g();
            } catch (IOException unused) {
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surface) {
            CameraSourcePreview.this.f20496d = false;
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        }
    }

    private boolean c() {
        int i6 = this.f20493a.getResources().getConfiguration().orientation;
        return i6 != 2 && i6 == 1;
    }

    private void e(c cameraSource) throws IOException {
        this.f20497e = cameraSource;
        if (cameraSource != null) {
            this.f20495c = true;
            g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() throws IOException, SecurityException {
        if (this.f20495c && this.f20496d) {
            if (com.bxkj.student.v2.ai.fitness.preference.a.d(this.f20493a)) {
                this.f20497e.w(this.f20494b.getHolder());
            } else {
                this.f20497e.v();
            }
            requestLayout();
            if (this.f20498f != null) {
                Size o5 = this.f20497e.o();
                int min = Math.min(o5.getWidth(), o5.getHeight());
                int max = Math.max(o5.getWidth(), o5.getHeight());
                boolean z5 = this.f20497e.m() == 1;
                if (c()) {
                    this.f20498f.k(min, max, z5);
                } else {
                    this.f20498f.k(max, min, z5);
                }
                this.f20498f.h();
            }
            this.f20495c = false;
        }
    }

    public void d() {
        c cVar = this.f20497e;
        if (cVar != null) {
            cVar.p();
            this.f20497e = null;
        }
        this.f20494b.getHolder().getSurface().release();
    }

    public void f(c cameraSource, GraphicOverlay overlay) throws IOException {
        this.f20498f = overlay;
        e(cameraSource);
    }

    public void h() {
        c cVar = this.f20497e;
        if (cVar != null) {
            cVar.x();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top2, int right, int bottom) {
        int i6;
        int i7;
        Size o5;
        c cVar = this.f20497e;
        if (cVar == null || (o5 = cVar.o()) == null) {
            i6 = 320;
            i7 = 240;
        } else {
            i6 = o5.getWidth();
            i7 = o5.getHeight();
        }
        if (!c()) {
            int i8 = i6;
            i6 = i7;
            i7 = i8;
        }
        float f6 = i7 / i6;
        int i9 = right - left;
        int i10 = bottom - top2;
        float f7 = i9;
        float f8 = i10;
        if (f6 > f7 / f8) {
            int i11 = ((int) ((f6 * f8) - f7)) / 2;
            this.f20494b.layout(-i11, 0, i9 + i11, i10);
        } else {
            int i12 = ((int) ((f7 / f6) - f8)) / 2;
            this.f20494b.layout(0, -i12, i9, i10 + i12);
        }
    }

    public CameraSourcePreview(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f20493a = context;
        this.f20495c = false;
        this.f20496d = false;
        SurfaceView surfaceView = new SurfaceView(context);
        this.f20494b = surfaceView;
        surfaceView.getHolder().addCallback(new a(this, null));
        addView(surfaceView);
    }
}
