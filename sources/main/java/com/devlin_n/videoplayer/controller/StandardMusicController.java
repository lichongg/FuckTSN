package com.devlin_n.videoplayer.controller;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.PopupMenu;
import androidx.core.view.GravityCompat;
import com.devlin_n.videoplayer.R;
import com.devlin_n.videoplayer.controller.BaseVideoController;
import h1.f;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class StandardMusicController extends BaseVideoController implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    protected SeekBar A;
    protected ImageView B;
    protected ImageView C;
    protected ImageView D;
    protected TextView E;
    private boolean F;
    private boolean G;
    private View H;
    private ProgressBar I;
    private ImageView J;
    private ImageView K;
    private ProgressBar L;
    private ImageView M;
    private LinearLayout N;
    private Animation O;
    private Animation P;
    private PopupMenu Q;

    /* renamed from: v, reason: collision with root package name */
    protected TextView f32326v;

    /* renamed from: w, reason: collision with root package name */
    protected TextView f32327w;

    /* renamed from: x, reason: collision with root package name */
    protected ImageView f32328x;

    /* renamed from: y, reason: collision with root package name */
    protected LinearLayout f32329y;

    /* renamed from: z, reason: collision with root package name */
    protected LinearLayout f32330z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements PopupMenu.OnMenuItemClickListener {
        a() {
        }

        @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            int itemId = menuItem.getItemId();
            if (itemId == R.id.scale_default) {
                StandardMusicController.this.f32290b.f(0);
            } else if (itemId == R.id.scale_original) {
                StandardMusicController.this.f32290b.f(4);
            } else if (itemId == R.id.scale_match) {
                StandardMusicController.this.f32290b.f(3);
            } else if (itemId == R.id.scale_16_9) {
                StandardMusicController.this.f32290b.f(1);
            } else if (itemId == R.id.scale_4_3) {
                StandardMusicController.this.f32290b.f(2);
            }
            StandardMusicController.this.Q.dismiss();
            return false;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StandardMusicController.this.setLayoutParams(new FrameLayout.LayoutParams(h1.a.f43026b, h1.a.f43025a));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements View.OnTouchListener {
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }

        c() {
        }
    }

    public StandardMusicController(@NonNull Context context) {
        this(context, null);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        this.G = true;
        removeCallbacks(this.f32304p);
        removeCallbacks(this.f32305q);
    }

    public StandardMusicController(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void m() {
        if (this.f32294f) {
            this.f32294f = false;
            this.f32291c = false;
            this.f32299k = true;
            g();
            this.D.setSelected(false);
            Toast.makeText(getContext(), R.string.unlocked, 0).show();
        } else {
            d();
            this.f32294f = true;
            this.f32299k = false;
            this.D.setSelected(true);
            Toast.makeText(getContext(), R.string.locked, 0).show();
        }
        this.f32290b.setLock(this.f32294f);
    }

    private void o(int i6) {
        if (!this.f32291c) {
            if (this.f32290b.a()) {
                this.D.setVisibility(0);
                if (!this.f32294f) {
                    p();
                }
            } else {
                p();
            }
            if (!this.f32294f && !this.F) {
                this.I.setVisibility(8);
                this.I.startAnimation(this.P);
            }
            this.f32291c = true;
        }
        removeCallbacks(this.f32305q);
        if (i6 != 0) {
            postDelayed(this.f32305q, i6);
        }
    }

    private void p() {
        this.f32329y.setVisibility(0);
        this.f32329y.startAnimation(this.O);
        this.f32330z.setVisibility(0);
        this.f32330z.startAnimation(this.O);
        f.n(getContext());
        f.m(getContext());
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    public void d() {
        if (this.f32291c) {
            if (this.f32290b.a()) {
                this.D.setVisibility(8);
                if (!this.f32294f) {
                    n();
                    f.j(getContext());
                    f.i(getContext());
                }
            } else {
                n();
            }
            if (!this.F && !this.f32294f) {
                this.I.setVisibility(0);
                this.I.startAnimation(this.O);
            }
            this.f32291c = false;
        }
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    protected int f() {
        BaseVideoController.d dVar = this.f32290b;
        if (dVar == null || this.G) {
            return 0;
        }
        int currentPosition = dVar.getCurrentPosition();
        int duration = this.f32290b.getDuration();
        SeekBar seekBar = this.A;
        if (seekBar != null) {
            if (duration > 0) {
                seekBar.setEnabled(true);
                int max = (int) (((currentPosition * 1.0d) / duration) * this.A.getMax());
                this.A.setProgress(max);
                this.I.setProgress(max);
            } else {
                seekBar.setEnabled(false);
            }
            int bufferPercentage = this.f32290b.getBufferPercentage();
            if (bufferPercentage >= 95) {
                SeekBar seekBar2 = this.A;
                seekBar2.setSecondaryProgress(seekBar2.getMax());
                ProgressBar progressBar = this.I;
                progressBar.setSecondaryProgress(progressBar.getMax());
            } else {
                int i6 = bufferPercentage * 10;
                this.A.setSecondaryProgress(i6);
                this.I.setSecondaryProgress(i6);
            }
        }
        TextView textView = this.f32326v;
        if (textView != null) {
            textView.setText(k(duration));
        }
        TextView textView2 = this.f32327w;
        if (textView2 != null) {
            textView2.setText(k(currentPosition));
        }
        TextView textView3 = this.E;
        if (textView3 != null) {
            textView3.setText(this.f32290b.getTitle());
        }
        return currentPosition;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    public void g() {
        o(this.f32295g);
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    protected int getLayoutId() {
        return R.layout.layout_standard_music_controller;
    }

    public ImageView getThumb() {
        return this.M;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    protected void i(float f6) {
        if (this.F) {
            this.f32309u = false;
        } else {
            super.i(f6);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i6, boolean z5) {
        if (z5) {
            long duration = (this.f32290b.getDuration() * i6) / this.A.getMax();
            TextView textView = this.f32327w;
            if (textView != null) {
                textView.setText(k((int) duration));
            }
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        this.f32290b.seekTo((int) ((this.f32290b.getDuration() * seekBar.getProgress()) / this.A.getMax()));
        this.G = false;
        post(this.f32304p);
        g();
    }

    public void q() {
        this.E.setVisibility(0);
    }

    public void setCanFast(boolean z5) {
        this.A.setOnTouchListener(new c());
    }

    public void setLive(boolean z5) {
        this.F = z5;
        this.I.setVisibility(8);
        this.A.setVisibility(4);
        this.f32326v.setVisibility(4);
        this.B.setVisibility(0);
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    public void setPlayerState(int i6) {
        if (i6 == 10) {
            h1.c.b("PLAYER_NORMAL");
            if (this.f32294f) {
                return;
            }
            setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.f32299k = false;
            this.f32328x.setSelected(false);
            this.C.setVisibility(8);
            this.D.setVisibility(8);
            this.H.setVisibility(8);
            return;
        }
        if (i6 != 11) {
            return;
        }
        h1.c.b("PLAYER_FULL_SCREEN");
        if (this.f32294f) {
            return;
        }
        postDelayed(new b(), 300L);
        this.f32299k = true;
        this.f32328x.setSelected(true);
        this.H.setVisibility(0);
        this.C.setVisibility(0);
        this.E.setVisibility(0);
        if (!this.f32291c) {
            this.D.setVisibility(8);
            return;
        }
        this.D.setVisibility(0);
        f.m(getContext());
        f.n(getContext());
    }

    public StandardMusicController(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i6) {
        super(context, attributeSet, i6);
        this.O = AnimationUtils.loadAnimation(getContext(), R.anim.anim_alpha_in);
        this.P = AnimationUtils.loadAnimation(getContext(), R.anim.anim_alpha_out);
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    protected void e() {
        super.e();
        ImageView imageView = (ImageView) this.f32289a.findViewById(R.id.more_menu);
        this.B = imageView;
        imageView.setOnClickListener(this);
        ImageView imageView2 = (ImageView) this.f32289a.findViewById(R.id.fullscreen);
        this.f32328x = imageView2;
        imageView2.setOnClickListener(this);
        this.f32329y = (LinearLayout) this.f32289a.findViewById(R.id.bottom_container);
        this.f32330z = (LinearLayout) this.f32289a.findViewById(R.id.top_container);
        SeekBar seekBar = (SeekBar) this.f32289a.findViewById(R.id.seekBar);
        this.A = seekBar;
        seekBar.setOnSeekBarChangeListener(this);
        this.f32326v = (TextView) this.f32289a.findViewById(R.id.total_time);
        this.f32327w = (TextView) this.f32289a.findViewById(R.id.curr_time);
        ImageView imageView3 = (ImageView) this.f32289a.findViewById(R.id.back);
        this.C = imageView3;
        imageView3.setOnClickListener(this);
        ImageView imageView4 = (ImageView) this.f32289a.findViewById(R.id.lock);
        this.D = imageView4;
        imageView4.setOnClickListener(this);
        ImageView imageView5 = (ImageView) this.f32289a.findViewById(R.id.thumb);
        this.M = imageView5;
        imageView5.setOnClickListener(this);
        ImageView imageView6 = (ImageView) this.f32289a.findViewById(R.id.iv_play);
        this.J = imageView6;
        imageView6.setOnClickListener(this);
        this.K = (ImageView) this.f32289a.findViewById(R.id.start_play);
        this.L = (ProgressBar) this.f32289a.findViewById(R.id.loading);
        this.I = (ProgressBar) this.f32289a.findViewById(R.id.bottom_progress);
        ((ImageView) this.f32289a.findViewById(R.id.iv_replay)).setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) this.f32289a.findViewById(R.id.complete_container);
        this.N = linearLayout;
        linearLayout.setOnClickListener(this);
        this.E = (TextView) this.f32289a.findViewById(R.id.title);
        View findViewById = this.f32289a.findViewById(R.id.status_holder);
        this.H = findViewById;
        findViewById.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) f.f(getContext())));
        PopupMenu popupMenu = new PopupMenu(getContext(), this.B, GravityCompat.END);
        this.Q = popupMenu;
        popupMenu.getMenuInflater().inflate(R.menu.controller_menu, this.Q.getMenu());
        this.Q.setOnMenuItemClickListener(new a());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.fullscreen && id != R.id.back) {
            if (id == R.id.lock) {
                m();
                return;
            }
            if (id != R.id.iv_play && id != R.id.thumb && id != R.id.iv_replay) {
                if (id == R.id.more_menu) {
                    this.Q.show();
                    g();
                    return;
                }
                return;
            }
            b();
            return;
        }
        c();
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    public void setPlayState(int i6) {
        super.setPlayState(i6);
        switch (i6) {
            case -1:
                h1.c.b("STATE_ERROR");
                break;
            case 0:
                h1.c.b("STATE_IDLE");
                d();
                this.f32294f = false;
                this.D.setSelected(false);
                this.f32290b.setLock(false);
                this.N.setVisibility(8);
                this.I.setVisibility(8);
                this.L.setVisibility(8);
                this.K.setVisibility(0);
                this.M.setVisibility(0);
                break;
            case 1:
                h1.c.b("STATE_PREPARING");
                this.N.setVisibility(8);
                this.K.setVisibility(8);
                this.L.setVisibility(0);
                break;
            case 2:
                h1.c.b("STATE_PREPARED");
                if (!this.F) {
                    this.I.setVisibility(0);
                }
                this.L.setVisibility(8);
                break;
            case 3:
                h1.c.b("STATE_PLAYING");
                post(this.f32304p);
                this.J.setSelected(true);
                this.N.setVisibility(8);
                this.M.setVisibility(8);
                break;
            case 4:
                h1.c.b("STATE_PAUSED");
                this.J.setSelected(false);
                break;
            case 5:
                h1.c.b("STATE_PLAYBACK_COMPLETED");
                d();
                this.M.setVisibility(0);
                this.N.setVisibility(0);
                this.I.setProgress(0);
                this.I.setSecondaryProgress(0);
                this.f32294f = false;
                this.f32290b.setLock(false);
                break;
            case 6:
                h1.c.b("STATE_BUFFERING");
                this.K.setVisibility(8);
                this.L.setVisibility(0);
                break;
            case 7:
                this.L.setVisibility(8);
                h1.c.b("STATE_BUFFERED");
                break;
        }
    }

    private void n() {
    }
}
