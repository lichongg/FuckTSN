package com.jmolsmobile.landscapevideocapture.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.timepicker.TimeModel;
import com.jmolsmobile.landscapevideocapture.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class VideoCaptureView extends FrameLayout implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private ImageView f35671a;

    /* renamed from: b, reason: collision with root package name */
    private ImageView f35672b;

    /* renamed from: c, reason: collision with root package name */
    private ImageView f35673c;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f35674d;

    /* renamed from: e, reason: collision with root package name */
    private SurfaceView f35675e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f35676f;

    /* renamed from: g, reason: collision with root package name */
    private TextView f35677g;

    /* renamed from: h, reason: collision with root package name */
    private Handler f35678h;

    /* renamed from: i, reason: collision with root package name */
    private long f35679i;

    /* renamed from: j, reason: collision with root package name */
    private com.jmolsmobile.landscapevideocapture.view.a f35680j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f35681k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f35682l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f35683m;

    /* renamed from: n, reason: collision with root package name */
    private Runnable f35684n;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int uptimeMillis = (int) ((SystemClock.uptimeMillis() - VideoCaptureView.this.f35679i) / 1000);
            VideoCaptureView videoCaptureView = VideoCaptureView.this;
            videoCaptureView.g(uptimeMillis % 60, uptimeMillis / 60);
            VideoCaptureView.this.f35678h.postDelayed(this, 1000L);
        }
    }

    public VideoCaptureView(Context context) {
        super(context);
        this.f35678h = new Handler();
        this.f35679i = 0L;
        this.f35684n = new a();
        e(context);
    }

    private void e(Context context) {
        View inflate = View.inflate(context, R.layout.view_videocapture, this);
        this.f35673c = (ImageView) inflate.findViewById(R.id.videocapture_recordbtn_iv);
        this.f35672b = (ImageView) inflate.findViewById(R.id.videocapture_acceptbtn_iv);
        this.f35671a = (ImageView) inflate.findViewById(R.id.videocapture_declinebtn_iv);
        this.f35674d = (ImageView) inflate.findViewById(R.id.change_camera_iv);
        this.f35673c.setOnClickListener(this);
        this.f35672b.setOnClickListener(this);
        this.f35671a.setOnClickListener(this);
        this.f35674d.setOnClickListener(this);
        this.f35676f = (ImageView) inflate.findViewById(R.id.videocapture_preview_iv);
        this.f35675e = (SurfaceView) inflate.findViewById(R.id.videocapture_preview_sv);
        this.f35677g = (TextView) inflate.findViewById(R.id.videocapture_timer_tv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i6, int i7) {
        this.f35677g.setText(String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i7)) + ":" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i6)));
    }

    public void f(boolean z5) {
        this.f35681k = z5;
    }

    public SurfaceHolder getPreviewSurfaceHolder() {
        return this.f35675e.getHolder();
    }

    public void h() {
        this.f35673c.setSelected(false);
        this.f35674d.setVisibility(d() ? 0 : 4);
        this.f35673c.setVisibility(0);
        this.f35672b.setVisibility(8);
        this.f35671a.setVisibility(8);
        this.f35676f.setVisibility(8);
        this.f35675e.setVisibility(0);
    }

    public void i(Bitmap bitmap) {
        this.f35673c.setVisibility(4);
        this.f35672b.setVisibility(0);
        this.f35674d.setVisibility(4);
        this.f35671a.setVisibility(0);
        this.f35676f.setVisibility(0);
        this.f35675e.setVisibility(8);
        if (bitmap != null) {
            this.f35676f.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f35676f.setImageBitmap(bitmap);
        }
        this.f35678h.removeCallbacks(this.f35684n);
    }

    public void j() {
        this.f35673c.setSelected(true);
        this.f35673c.setVisibility(0);
        this.f35674d.setVisibility(4);
        this.f35672b.setVisibility(8);
        this.f35671a.setVisibility(8);
        this.f35676f.setVisibility(8);
        this.f35675e.setVisibility(0);
        if (this.f35681k) {
            this.f35677g.setVisibility(0);
            this.f35679i = SystemClock.uptimeMillis();
            g(0, 0);
            this.f35678h.postDelayed(this.f35684n, 1000L);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f35680j == null) {
            return;
        }
        if (view.getId() == this.f35673c.getId()) {
            this.f35680j.a();
            return;
        }
        if (view.getId() == this.f35672b.getId()) {
            this.f35680j.b();
            return;
        }
        if (view.getId() == this.f35671a.getId()) {
            this.f35680j.d();
        } else if (view.getId() == this.f35674d.getId()) {
            boolean z5 = this.f35682l;
            this.f35682l = !z5;
            this.f35674d.setImageResource(!z5 ? R.drawable.ic_change_camera_front : R.drawable.ic_change_camera_back);
            this.f35680j.h(this.f35682l);
        }
    }

    public void setCameraFacing(boolean z5) {
        if (this.f35683m) {
            this.f35682l = z5;
            this.f35674d.setImageResource(z5 ? R.drawable.ic_change_camera_back : R.drawable.ic_change_camera_front);
        }
    }

    public void setCameraSwitchingEnabled(boolean z5) {
        this.f35683m = z5;
        this.f35674d.setVisibility(z5 ? 0 : 4);
    }

    public void setRecordingButtonInterface(com.jmolsmobile.landscapevideocapture.view.a aVar) {
        this.f35680j = aVar;
    }

    private boolean d() {
        if (com.jmolsmobile.landscapevideocapture.preview.a.b() && this.f35683m) {
            return true;
        }
        return false;
    }

    public VideoCaptureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f35678h = new Handler();
        this.f35679i = 0L;
        this.f35684n = new a();
        e(context);
    }

    public VideoCaptureView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f35678h = new Handler();
        this.f35679i = 0L;
        this.f35684n = new a();
        e(context);
    }
}
