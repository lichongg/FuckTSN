package com.devlin_n.videoplayer.controller;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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
import h1.c;
import h1.f;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class FullScreenController extends BaseVideoController implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    protected ImageView A;
    protected ImageView B;
    protected ImageView C;
    protected TextView D;
    private boolean E;
    private boolean F;
    private ProgressBar G;
    private ImageView H;
    private ProgressBar I;
    private LinearLayout J;
    private Animation K;
    private Animation L;
    private PopupMenu M;

    /* renamed from: v, reason: collision with root package name */
    protected TextView f32320v;

    /* renamed from: w, reason: collision with root package name */
    protected TextView f32321w;

    /* renamed from: x, reason: collision with root package name */
    protected LinearLayout f32322x;

    /* renamed from: y, reason: collision with root package name */
    protected LinearLayout f32323y;

    /* renamed from: z, reason: collision with root package name */
    protected SeekBar f32324z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements PopupMenu.OnMenuItemClickListener {
        a() {
        }

        @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            int itemId = menuItem.getItemId();
            if (itemId == R.id.scale_default) {
                FullScreenController.this.f32290b.f(0);
            } else if (itemId == R.id.scale_original) {
                FullScreenController.this.f32290b.f(4);
            } else if (itemId == R.id.scale_match) {
                FullScreenController.this.f32290b.f(3);
            } else if (itemId == R.id.scale_16_9) {
                FullScreenController.this.f32290b.f(1);
            } else if (itemId == R.id.scale_4_3) {
                FullScreenController.this.f32290b.f(2);
            }
            FullScreenController.this.M.dismiss();
            return false;
        }
    }

    public FullScreenController(@NonNull Context context) {
        this(context, null);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        this.F = true;
        removeCallbacks(this.f32304p);
        removeCallbacks(this.f32305q);
    }

    public FullScreenController(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void m() {
        if (this.f32294f) {
            this.f32294f = false;
            this.f32291c = false;
            this.f32299k = true;
            g();
            this.C.setSelected(false);
            Toast.makeText(getContext(), R.string.unlocked, 0).show();
        } else {
            d();
            this.f32294f = true;
            this.f32299k = false;
            this.C.setSelected(true);
            Toast.makeText(getContext(), R.string.locked, 0).show();
        }
        this.f32290b.setLock(this.f32294f);
    }

    private void n() {
        this.f32323y.setVisibility(8);
        this.f32323y.startAnimation(this.L);
        this.f32322x.setVisibility(8);
        this.f32322x.startAnimation(this.L);
    }

    private void o(int i6) {
        if (!this.f32291c) {
            if (this.f32290b.a()) {
                this.C.setVisibility(0);
                if (!this.f32294f) {
                    p();
                }
            } else {
                p();
            }
            if (!this.f32294f && !this.E) {
                this.G.setVisibility(8);
                this.G.startAnimation(this.L);
            }
            this.f32291c = true;
        }
        removeCallbacks(this.f32305q);
        if (i6 != 0) {
            postDelayed(this.f32305q, i6);
        }
    }

    private void p() {
        this.f32322x.setVisibility(0);
        this.f32322x.startAnimation(this.K);
        this.f32323y.setVisibility(0);
        this.f32323y.startAnimation(this.K);
        f.n(getContext());
        f.m(getContext());
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    public void d() {
        if (this.f32291c) {
            if (this.f32290b.a()) {
                this.C.setVisibility(8);
                if (!this.f32294f) {
                    n();
                    f.j(getContext());
                    f.i(getContext());
                }
            } else {
                n();
            }
            if (!this.E && !this.f32294f) {
                this.G.setVisibility(0);
                this.G.startAnimation(this.K);
            }
            this.f32291c = false;
        }
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    protected int f() {
        BaseVideoController.d dVar = this.f32290b;
        if (dVar == null || this.F) {
            return 0;
        }
        int currentPosition = dVar.getCurrentPosition();
        int duration = this.f32290b.getDuration();
        SeekBar seekBar = this.f32324z;
        if (seekBar != null) {
            if (duration > 0) {
                seekBar.setEnabled(true);
                int max = (int) (((currentPosition * 1.0d) / duration) * this.f32324z.getMax());
                this.f32324z.setProgress(max);
                this.G.setProgress(max);
            } else {
                seekBar.setEnabled(false);
            }
            int bufferPercentage = this.f32290b.getBufferPercentage();
            if (bufferPercentage >= 95) {
                SeekBar seekBar2 = this.f32324z;
                seekBar2.setSecondaryProgress(seekBar2.getMax());
                ProgressBar progressBar = this.G;
                progressBar.setSecondaryProgress(progressBar.getMax());
            } else {
                int i6 = bufferPercentage * 10;
                this.f32324z.setSecondaryProgress(i6);
                this.G.setSecondaryProgress(i6);
            }
        }
        TextView textView = this.f32320v;
        if (textView != null) {
            textView.setText(k(duration));
        }
        TextView textView2 = this.f32321w;
        if (textView2 != null) {
            textView2.setText(k(currentPosition));
        }
        TextView textView3 = this.D;
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
        return R.layout.layout_fullscreen_controller;
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    protected void i(float f6) {
        if (this.E) {
            this.f32309u = false;
        } else {
            super.i(f6);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i6, boolean z5) {
        if (z5) {
            long duration = (this.f32290b.getDuration() * i6) / this.f32324z.getMax();
            TextView textView = this.f32321w;
            if (textView != null) {
                textView.setText(k((int) duration));
            }
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        this.f32290b.seekTo((int) ((this.f32290b.getDuration() * seekBar.getProgress()) / this.f32324z.getMax()));
        this.F = false;
        post(this.f32304p);
        g();
    }

    public void q() {
        this.D.setVisibility(0);
    }

    public void setLive(boolean z5) {
        this.E = z5;
        this.G.setVisibility(8);
        this.f32324z.setVisibility(4);
        this.f32320v.setVisibility(4);
    }

    public FullScreenController(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i6) {
        super(context, attributeSet, i6);
        this.K = AnimationUtils.loadAnimation(getContext(), R.anim.anim_alpha_in);
        this.L = AnimationUtils.loadAnimation(getContext(), R.anim.anim_alpha_out);
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    protected void e() {
        super.e();
        ImageView imageView = (ImageView) this.f32289a.findViewById(R.id.more_menu);
        this.A = imageView;
        imageView.setOnClickListener(this);
        this.f32322x = (LinearLayout) this.f32289a.findViewById(R.id.bottom_container);
        this.f32323y = (LinearLayout) this.f32289a.findViewById(R.id.top_container);
        SeekBar seekBar = (SeekBar) this.f32289a.findViewById(R.id.seekBar);
        this.f32324z = seekBar;
        seekBar.setOnSeekBarChangeListener(this);
        this.f32320v = (TextView) this.f32289a.findViewById(R.id.total_time);
        this.f32321w = (TextView) this.f32289a.findViewById(R.id.curr_time);
        ImageView imageView2 = (ImageView) this.f32289a.findViewById(R.id.back);
        this.B = imageView2;
        imageView2.setOnClickListener(this);
        ImageView imageView3 = (ImageView) this.f32289a.findViewById(R.id.lock);
        this.C = imageView3;
        imageView3.setOnClickListener(this);
        ImageView imageView4 = (ImageView) this.f32289a.findViewById(R.id.iv_play);
        this.H = imageView4;
        imageView4.setOnClickListener(this);
        this.I = (ProgressBar) this.f32289a.findViewById(R.id.loading);
        this.G = (ProgressBar) this.f32289a.findViewById(R.id.bottom_progress);
        ((ImageView) this.f32289a.findViewById(R.id.iv_replay)).setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) this.f32289a.findViewById(R.id.complete_container);
        this.J = linearLayout;
        linearLayout.setOnClickListener(this);
        this.D = (TextView) this.f32289a.findViewById(R.id.title);
        PopupMenu popupMenu = new PopupMenu(getContext(), this.A, GravityCompat.END);
        this.M = popupMenu;
        popupMenu.getMenuInflater().inflate(R.menu.controller_menu, this.M.getMenu());
        this.M.setOnMenuItemClickListener(new a());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.lock) {
            m();
            return;
        }
        if (id != R.id.iv_play && id != R.id.iv_replay) {
            if (id == R.id.more_menu) {
                this.M.show();
                g();
                return;
            } else {
                if (id == R.id.back) {
                    f.l(getContext()).finish();
                    return;
                }
                return;
            }
        }
        b();
    }

    @Override // com.devlin_n.videoplayer.controller.BaseVideoController
    public void setPlayState(int i6) {
        super.setPlayState(i6);
        switch (i6) {
            case -1:
                c.b("STATE_ERROR");
                break;
            case 0:
                c.b("STATE_IDLE");
                d();
                this.f32294f = false;
                this.C.setSelected(false);
                this.f32290b.setLock(false);
                this.J.setVisibility(8);
                this.G.setVisibility(8);
                this.I.setVisibility(8);
                break;
            case 1:
                c.b("STATE_PREPARING");
                this.J.setVisibility(8);
                this.I.setVisibility(0);
                break;
            case 2:
                c.b("STATE_PREPARED");
                if (!this.E) {
                    this.G.setVisibility(0);
                }
                this.I.setVisibility(8);
                break;
            case 3:
                c.b("STATE_PLAYING");
                post(this.f32304p);
                this.H.setSelected(true);
                this.J.setVisibility(8);
                break;
            case 4:
                c.b("STATE_PAUSED");
                this.H.setSelected(false);
                break;
            case 5:
                c.b("STATE_PLAYBACK_COMPLETED");
                d();
                this.J.setVisibility(0);
                this.G.setProgress(0);
                this.G.setSecondaryProgress(0);
                this.f32294f = false;
                this.f32290b.setLock(false);
                break;
            case 6:
                c.b("STATE_BUFFERING");
                this.I.setVisibility(0);
                break;
            case 7:
                this.I.setVisibility(8);
                c.b("STATE_BUFFERED");
                break;
        }
    }
}
