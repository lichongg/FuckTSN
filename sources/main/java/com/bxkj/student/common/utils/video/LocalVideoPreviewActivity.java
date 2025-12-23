package com.bxkj.student.common.utils.video;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;
import cn.bluemobi.dylan.base.BaseActivity;
import com.bxkj.student.R;
import com.bxkj.student.run.app.utils.i;
import java.text.SimpleDateFormat;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class LocalVideoPreviewActivity extends BaseActivity {
    private VideoView W;
    private SeekBar X;
    private TextView Y;
    private TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    private int f17816a0;

    /* renamed from: b0, reason: collision with root package name */
    private final String f17817b0 = "filepath";

    /* renamed from: c0, reason: collision with root package name */
    private Runnable f17818c0 = new b();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements SeekBar.OnSeekBarChangeListener {
        a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            if (fromUser) {
                LocalVideoPreviewActivity.this.W.seekTo(progress);
                LocalVideoPreviewActivity.this.Y.setText(LocalVideoPreviewActivity.this.o0(progress));
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LocalVideoPreviewActivity.this.Y.setText(LocalVideoPreviewActivity.this.o0(r1.W.getCurrentPosition()));
            if (LocalVideoPreviewActivity.this.X != null) {
                LocalVideoPreviewActivity.this.X.setProgress(LocalVideoPreviewActivity.this.W.getCurrentPosition());
            }
            if (LocalVideoPreviewActivity.this.W.isPlaying()) {
                LocalVideoPreviewActivity.this.X.postDelayed(LocalVideoPreviewActivity.this.f17818c0, 1000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q0(MediaPlayer mediaPlayer) {
        mediaPlayer.setLooping(true);
        int duration = this.W.getDuration();
        this.Y.setText(o0(0L));
        this.Z.setText(o0(duration));
        this.X.setMax(duration);
        this.X.postDelayed(this.f17818c0, 1000L);
        mediaPlayer.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() { // from class: com.bxkj.student.common.utils.video.a
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public final void onBufferingUpdate(MediaPlayer mediaPlayer2, int i6) {
                LocalVideoPreviewActivity.this.p0(mediaPlayer2, i6);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String o0(long needFromatTime) {
        return new SimpleDateFormat("mm:ss").format(Long.valueOf(needFromatTime));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p0(MediaPlayer mediaPlayer, int i6) {
        this.Y.setText(i.g(this.W.getCurrentPosition()));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.W.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.bxkj.student.common.utils.video.b
            @Override // android.media.MediaPlayer.OnPreparedListener
            public final void onPrepared(MediaPlayer mediaPlayer) {
                LocalVideoPreviewActivity.this.q0(mediaPlayer);
            }
        });
        this.X.setOnSeekBarChangeListener(new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("播放视频");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_video_preview;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        this.W.setVideoURI(Uri.parse(getIntent().getStringExtra("filepath")));
        this.W.start();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (VideoView) findViewById(R.id.videoView);
        this.X = (SeekBar) findViewById(2131298505);
        this.Y = (TextView) findViewById(R.id.tv_start);
        this.Z = (TextView) findViewById(R.id.tv_end);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == 16908332) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.f17816a0 = this.W.getCurrentPosition();
        this.W.pause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.W.seekTo(this.f17816a0);
        this.W.start();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
