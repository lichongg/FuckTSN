package com.devlin_n.videoplayer.controller;

import android.content.Context;
import android.media.AudioManager;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.devlin_n.videoplayer.R;
import com.devlin_n.videoplayer.widget.CenterView;
import h1.f;
import java.util.Formatter;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class BaseVideoController extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    protected View f32289a;

    /* renamed from: b, reason: collision with root package name */
    protected d f32290b;

    /* renamed from: c, reason: collision with root package name */
    protected boolean f32291c;

    /* renamed from: d, reason: collision with root package name */
    protected CenterView f32292d;

    /* renamed from: e, reason: collision with root package name */
    protected AudioManager f32293e;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f32294f;

    /* renamed from: g, reason: collision with root package name */
    protected int f32295g;

    /* renamed from: h, reason: collision with root package name */
    private StringBuilder f32296h;

    /* renamed from: i, reason: collision with root package name */
    private Formatter f32297i;

    /* renamed from: j, reason: collision with root package name */
    private GestureDetector f32298j;

    /* renamed from: k, reason: collision with root package name */
    protected boolean f32299k;

    /* renamed from: l, reason: collision with root package name */
    private float f32300l;

    /* renamed from: m, reason: collision with root package name */
    private float f32301m;

    /* renamed from: n, reason: collision with root package name */
    protected g1.a f32302n;

    /* renamed from: o, reason: collision with root package name */
    protected int f32303o;

    /* renamed from: p, reason: collision with root package name */
    protected Runnable f32304p;

    /* renamed from: q, reason: collision with root package name */
    protected final Runnable f32305q;

    /* renamed from: r, reason: collision with root package name */
    protected int f32306r;

    /* renamed from: s, reason: collision with root package name */
    protected float f32307s;

    /* renamed from: t, reason: collision with root package name */
    protected int f32308t;

    /* renamed from: u, reason: collision with root package name */
    protected boolean f32309u;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return BaseVideoController.this.f32298j.onTouchEvent(motionEvent);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int f6 = BaseVideoController.this.f();
            if (BaseVideoController.this.f32290b.isPlaying()) {
                BaseVideoController baseVideoController = BaseVideoController.this;
                baseVideoController.postDelayed(baseVideoController.f32304p, 1000 - (f6 % 1000));
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseVideoController.this.d();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface d {
        boolean a();

        void b();

        void c();

        void d();

        void e();

        d f(int i6);

        void g();

        int getBufferPercentage();

        int getCurrentPosition();

        int getDuration();

        String getTitle();

        void h();

        void i();

        boolean isMute();

        boolean isPlaying();

        void pause();

        void seekTo(int i6);

        void setLock(boolean z5);

        void start();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class e extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: a, reason: collision with root package name */
        private boolean f32313a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f32314b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f32315c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f32316d;

        private e() {
        }

        /* synthetic */ e(BaseVideoController baseVideoController, a aVar) {
            this();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            BaseVideoController baseVideoController = BaseVideoController.this;
            if (baseVideoController.f32294f) {
                return true;
            }
            baseVideoController.b();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            BaseVideoController baseVideoController = BaseVideoController.this;
            if (!baseVideoController.f32299k) {
                return super.onDown(motionEvent);
            }
            baseVideoController.f32306r = baseVideoController.f32293e.getStreamVolume(3);
            BaseVideoController baseVideoController2 = BaseVideoController.this;
            baseVideoController2.f32307s = f.l(baseVideoController2.getContext()).getWindow().getAttributes().screenBrightness;
            this.f32313a = true;
            this.f32314b = false;
            this.f32315c = false;
            this.f32316d = false;
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f6, float f7) {
            if (!BaseVideoController.this.f32299k) {
                return super.onScroll(motionEvent, motionEvent2, f6, f7);
            }
            float x5 = motionEvent.getX() - motionEvent2.getX();
            float y5 = motionEvent.getY() - motionEvent2.getY();
            if (this.f32313a) {
                boolean z5 = Math.abs(f6) >= Math.abs(f7);
                this.f32314b = z5;
                if (!z5) {
                    if (motionEvent2.getX() > h1.a.f43026b / 2) {
                        this.f32315c = true;
                    } else {
                        this.f32316d = true;
                    }
                }
                this.f32313a = false;
            }
            if (this.f32314b) {
                BaseVideoController.this.i(x5);
            } else if (this.f32315c) {
                BaseVideoController.this.h(y5);
            } else if (this.f32316d) {
                BaseVideoController.this.j(y5);
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            BaseVideoController baseVideoController = BaseVideoController.this;
            if (baseVideoController.f32291c) {
                baseVideoController.d();
                return true;
            }
            baseVideoController.g();
            return true;
        }
    }

    public BaseVideoController(@NonNull Context context) {
        this(context, null);
    }

    protected int f() {
        return 0;
    }

    protected abstract int getLayoutId();

    public BaseVideoController(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    protected void b() {
        if (this.f32303o == 6) {
            return;
        }
        if (this.f32290b.isPlaying()) {
            this.f32290b.pause();
        } else {
            this.f32290b.start();
        }
    }

    public void c() {
        if (this.f32290b.a()) {
            f.l(getContext()).setRequestedOrientation(1);
            this.f32290b.g();
        } else {
            f.l(getContext()).setRequestedOrientation(0);
            this.f32290b.i();
        }
    }

    protected void h(float f6) {
        this.f32292d.setVisibility(0);
        d();
        this.f32292d.setProVisibility(0);
        Window window = f.l(getContext()).getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        this.f32292d.setIcon(R.drawable.ic_action_brightness);
        int measuredHeight = getMeasuredHeight();
        if (this.f32307s == -1.0f) {
            this.f32307s = 0.5f;
        }
        float f7 = (((f6 * 2.0f) / measuredHeight) * 1.0f) + this.f32307s;
        if (f7 < 0.0f) {
            f7 = 0.0f;
        }
        float f8 = f7 <= 1.0f ? f7 : 1.0f;
        int i6 = (int) (100.0f * f8);
        this.f32292d.setTextView(i6 + "%");
        this.f32292d.setProPercent(i6);
        attributes.screenBrightness = f8;
        window.setAttributes(attributes);
    }

    protected void i(float f6) {
        this.f32292d.setVisibility(0);
        d();
        this.f32292d.setProVisibility(8);
        int measuredWidth = getMeasuredWidth();
        int duration = this.f32290b.getDuration();
        int currentPosition = this.f32290b.getCurrentPosition();
        int i6 = (int) ((((-f6) / measuredWidth) * duration) + currentPosition);
        if (i6 > currentPosition) {
            this.f32292d.setIcon(R.drawable.ic_action_fast_forward);
        } else {
            this.f32292d.setIcon(R.drawable.ic_action_fast_rewind);
        }
        if (i6 > duration) {
            i6 = duration;
        }
        int i7 = i6 >= 0 ? i6 : 0;
        this.f32308t = i7;
        this.f32292d.setTextView(k(i7) + "/" + k(duration));
        this.f32309u = true;
    }

    protected void j(float f6) {
        this.f32292d.setVisibility(0);
        d();
        this.f32292d.setProVisibility(0);
        float streamMaxVolume = this.f32293e.getStreamMaxVolume(3);
        float measuredHeight = this.f32306r + (((f6 * 2.0f) / getMeasuredHeight()) * streamMaxVolume);
        if (measuredHeight > streamMaxVolume) {
            measuredHeight = streamMaxVolume;
        }
        if (measuredHeight < 0.0f) {
            this.f32292d.setIcon(R.drawable.ic_action_volume_off);
            measuredHeight = 0.0f;
        } else {
            this.f32292d.setIcon(R.drawable.ic_action_volume_up);
        }
        int i6 = (int) ((measuredHeight / streamMaxVolume) * 100.0f);
        this.f32292d.setTextView(i6 + "%");
        this.f32292d.setProPercent(i6);
        this.f32293e.setStreamVolume(3, (int) measuredHeight, 0);
    }

    protected String k(int i6) {
        int i7 = i6 / 1000;
        int i8 = i7 % 60;
        int i9 = (i7 / 60) % 60;
        int i10 = i7 / 3600;
        this.f32296h.setLength(0);
        return i10 > 0 ? this.f32297i.format("%d:%02d:%02d", Integer.valueOf(i10), Integer.valueOf(i9), Integer.valueOf(i8)).toString() : this.f32297i.format("%02d:%02d", Integer.valueOf(i9), Integer.valueOf(i8)).toString();
    }

    public void setControllerListener(g1.a aVar) {
        this.f32302n = aVar;
    }

    public void setMediaPlayer(d dVar) {
        this.f32290b = dVar;
    }

    public void setPlayState(int i6) {
        this.f32303o = i6;
    }

    public BaseVideoController(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i6) {
        super(context, attributeSet, i6);
        this.f32295g = 3000;
        this.f32304p = new b();
        this.f32305q = new c();
        e();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2) {
                float abs = Math.abs(motionEvent.getX() - this.f32300l);
                float abs2 = Math.abs(motionEvent.getY() - this.f32301m);
                if (abs > ViewConfiguration.get(getContext()).getScaledTouchSlop() || abs2 > ViewConfiguration.get(getContext()).getScaledTouchSlop()) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
            }
        } else {
            this.f32300l = motionEvent.getX();
            this.f32301m = motionEvent.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    protected void e() {
        this.f32289a = LayoutInflater.from(getContext()).inflate(getLayoutId(), this);
        CenterView centerView = new CenterView(getContext());
        this.f32292d = centerView;
        centerView.setVisibility(8);
        addView(this.f32292d);
        this.f32293e = (AudioManager) getContext().getSystemService("audio");
        this.f32296h = new StringBuilder();
        this.f32297i = new Formatter(this.f32296h, Locale.getDefault());
        setClickable(true);
        setFocusable(true);
        this.f32298j = new GestureDetector(getContext(), new e(this, null));
        setOnTouchListener(new a());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        post(this.f32304p);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z5 = true;
        if (motionEvent.getAction() != 1) {
            z5 = false;
        }
        if (!this.f32298j.onTouchEvent(motionEvent) && z5) {
            if (this.f32292d.getVisibility() == 0) {
                this.f32292d.setVisibility(8);
            }
            if (this.f32309u) {
                this.f32290b.seekTo(this.f32308t);
                this.f32309u = false;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i6) {
        super.onWindowVisibilityChanged(i6);
        if (i6 == 0) {
            post(this.f32304p);
        }
    }

    public void d() {
    }

    public void g() {
    }

    public void setPlayerState(int i6) {
    }
}
