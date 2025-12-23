package com.bxkj.student.study;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.base.util.c0;
import com.bxkj.student.R;
import com.devlin_n.floatWindowPermission.b;
import com.devlin_n.videoplayer.controller.StandardVideoController;
import com.devlin_n.videoplayer.player.IjkVideoView;
import com.stub.StubApp;
import com.tencent.connect.share.QzonePublish;
import java.util.Map;
import x.f;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class VideoPlayActivity extends BaseActivity {
    private TextView W;
    private TextView X;
    private SmartWebView Y;
    private IjkVideoView Z;

    /* renamed from: a0, reason: collision with root package name */
    private String f20482a0 = "https://media.w3.org/2010/05/sintel/trailer.mp4";

    /* renamed from: b0, reason: collision with root package name */
    private String f20483b0;

    /* renamed from: c0, reason: collision with root package name */
    private String f20484c0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            VideoPlayActivity.this.W.setText("标题：" + JsonParse.getString(data, "title"));
            VideoPlayActivity.this.Y.h(JsonParse.getString(data, "memo"));
            VideoPlayActivity.this.f20482a0 = JsonParse.getString(data, QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH);
            VideoPlayActivity.this.X.setText("播放量：" + JsonParse.getString(data, "playNum"));
            VideoPlayActivity.this.n0();
        }
    }

    static {
        StubApp.interface11(16946);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (b.f().c(this)) {
                this.Z.c();
            } else {
                Toast.makeText(this.T, "权限授予失败，无法开启悬浮窗", 0).show();
            }
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle savedInstanceState);

    private void m0() {
        Http.with(this.T).setObservable(((f) Http.getApiService(f.class)).c(this.f20483b0)).setDataListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0() {
        this.Z.T().R().e0(c0.a(this.f20482a0)).f0(new StandardVideoController(this)).start();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle(this.f20484c0);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    /* renamed from: onBackPressed */
    public void r1() {
        if (this.Z.X()) {
            return;
        }
        super.r1();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_video_player_detail;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("videoName")) {
            String stringExtra = getIntent().getStringExtra("videoName");
            this.f20484c0 = stringExtra;
            setTitle(stringExtra);
        }
        if (getIntent().hasExtra("videoId")) {
            this.f20483b0 = getIntent().getStringExtra("videoId");
        }
        m0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (TextView) findViewById(R.id.tv_video_title);
        this.Y = (SmartWebView) findViewById(2131298538);
        this.Z = (IjkVideoView) findViewById(R.id.player);
        this.X = (TextView) findViewById(R.id.tv_play_num);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.Z.Z();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.Z.pause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.Z.d();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
