package com.bxkj.student.home.teaching.learning.detail.backup;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentTransaction;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.c0;
import com.bxkj.base.view.TimeView;
import com.bxkj.student.R;
import com.devlin_n.videoplayer.controller.StandardVideoController;
import com.devlin_n.videoplayer.player.IjkVideoView;
import com.umeng.socialize.media.BaseMediaObject;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMVideo;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class VideoPlayActivity extends BaseActivity {
    private String F0;
    private Timer G0;
    private TimerTask H0;
    private String I0;
    private CountDownTimer J0;
    private ProgressBar W;
    private TimeView X;
    private TextView Y;
    private TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    private TextView f18536a0;

    /* renamed from: b0, reason: collision with root package name */
    private SmartWebView f18537b0;

    /* renamed from: c0, reason: collision with root package name */
    private IjkVideoView f18538c0;

    /* renamed from: p0, reason: collision with root package name */
    private String f18540p0;

    /* renamed from: k0, reason: collision with root package name */
    private String f18539k0 = "http://xttp.xidian.edu.cn:1221/Upload/69045f62-a3eb-4c05-a1c0-7e1d92c05565.flv";
    private int K0 = 120000;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            VideoPlayActivity.this.Q().setVisibility(0);
            StringBuilder sb = new StringBuilder();
            sb.append("标题：");
            String string = JsonParse.getString(data, "title");
            sb.append(string);
            VideoPlayActivity.this.Y.setText(sb.toString());
            String string2 = JsonParse.getString(data, "synopsis");
            VideoPlayActivity.this.f18536a0.setText(string2);
            VideoPlayActivity.this.f18539k0 = JsonParse.getString(data, "content");
            VideoPlayActivity.this.Z.setText("播放量：" + JsonParse.getString(data, "pv"));
            VideoPlayActivity.this.I0 = JsonParse.getString(data, "detailId");
            VideoPlayActivity.this.w0();
            int i6 = JsonParse.getInt(data, "duration");
            String string3 = JsonParse.getString(data, "indexImg");
            if (TextUtils.isEmpty(string3)) {
                string3 = "http://m.boxkj.com/resources/wechat/images/xiaowei.png";
            }
            UMVideo uMVideo = new UMVideo(VideoPlayActivity.this.f18539k0);
            uMVideo.setTitle(string);
            uMVideo.setThumb(new UMImage(((BaseActivity) VideoPlayActivity.this).T, string3));
            uMVideo.setDescription(string2);
            VideoPlayActivity videoPlayActivity = VideoPlayActivity.this;
            videoPlayActivity.u0(videoPlayActivity.I0, JsonParse.getInt(data, "isLike"), JsonParse.getInt(data, "isCollection"), i6, JsonParse.getInt(data, "popTime"), JsonParse.getInt(data, "hasQuestion"), JsonParse.getInt(data, "isComplete"), JsonParse.getInt(data, "isOk"), JsonParse.getInt(data, "opreateFlag"), JsonParse.getInt(data, "valType"), uMVideo);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends CountDownTimer {
        b(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            VideoPlayActivity.this.X.i(VideoPlayActivity.this.K0 / 1000, VideoPlayActivity.this.K0 / 1000);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            int i6 = ((int) (VideoPlayActivity.this.K0 - millisUntilFinished)) / 1000;
            VideoPlayActivity.this.X.i(VideoPlayActivity.this.K0 / 1000, i6);
            VideoPlayActivity.this.W.setProgress(i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0() {
        StandardVideoController standardVideoController = new StandardVideoController(this);
        standardVideoController.setCanFast(false);
        this.f18538c0.R().T().e0(c0.a(this.f18539k0)).f0(standardVideoController).start();
    }

    private void x0() {
        this.W.setVisibility(0);
        this.X.setVisibility(0);
        this.W.setMax(this.K0 / 1000);
        new SimpleDateFormat("HH:mm:ss").setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
        b bVar = new b(this.K0, 1000L);
        this.J0 = bVar;
        bVar.start();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle(this.F0);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    /* renamed from: onBackPressed */
    public void r1() {
        if (this.f18538c0.X()) {
            return;
        }
        super.r1();
    }

    public void v0() {
        Http.with(this.T).setObservable(((com.bxkj.student.home.teaching.learning.m) Http.getApiService(com.bxkj.student.home.teaching.learning.m.class)).k(LoginUser.getLoginUser().getUserId(), this.f18540p0)).setDataListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0(String detailId, int isLike, int isCollection, int duration, int popTime, int hasQuestion, int isComplete, int isOk, int opreateFlag, int valType, BaseMediaObject baseMediaObject) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        BottomFragment bottomFragment = new BottomFragment();
        Bundle bundle = new Bundle();
        bundle.putString("id", this.f18540p0);
        bundle.putString("detailId", detailId);
        bundle.putInt("isLike", isLike);
        bundle.putInt("isCollection", isCollection);
        bundle.putInt("duration", duration);
        bundle.putInt("popTime", popTime);
        bundle.putInt("hasQuestion", hasQuestion);
        bundle.putInt("isComplete", isComplete);
        bundle.putInt("isOk", isOk);
        bundle.putInt("opreateFlag", opreateFlag);
        bundle.putInt("valType", valType);
        bottomFragment.setArguments(bundle);
        bottomFragment.s0(baseMediaObject);
        beginTransaction.add(R.id.fl_bottom, bottomFragment);
        beginTransaction.commit();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_learning_video_player_detail;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("title")) {
            String stringExtra = getIntent().getStringExtra("title");
            this.F0 = stringExtra;
            setTitle(stringExtra);
        }
        if (getIntent().hasExtra("id")) {
            this.f18540p0 = getIntent().getStringExtra("id");
        }
        v0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (ProgressBar) findViewById(R.id.pb);
        this.X = (TimeView) findViewById(R.id.cdtv);
        this.Y = (TextView) findViewById(R.id.tv_video_title);
        this.f18537b0 = (SmartWebView) findViewById(2131298538);
        this.f18538c0 = (IjkVideoView) findViewById(R.id.player);
        this.Z = (TextView) findViewById(R.id.tv_play_num);
        this.f18536a0 = (TextView) findViewById(R.id.tv_video_introduction);
        Q().setVisibility(8);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (com.devlin_n.floatWindowPermission.b.f().c(this)) {
                this.f18538c0.c();
            } else {
                Toast.makeText(this.T, "权限授予失败，无法开启悬浮窗", 0).show();
            }
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f18538c0.Z();
        TimerTask timerTask = this.H0;
        if (timerTask != null) {
            timerTask.cancel();
        }
        Timer timer = this.G0;
        if (timer != null) {
            timer.cancel();
        }
        CountDownTimer countDownTimer = this.J0;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.f18538c0.pause();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.f18538c0.d();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
