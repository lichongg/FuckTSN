package com.bxkj.student.common.utils.video;

import android.os.Bundle;
import android.view.View;
import cn.bluemobi.dylan.base.BaseActivity;
import com.bxkj.base.util.c0;
import com.bxkj.student.R;
import com.devlin_n.videoplayer.controller.StandardVideoController;
import com.devlin_n.videoplayer.player.IjkVideoView;
import com.tencent.connect.share.QzonePublish;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class OnLinePlayVideoActivity extends BaseActivity {
    private IjkVideoView W;

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("播放视频");
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    /* renamed from: onBackPressed */
    public void r1() {
        if (this.W.X()) {
            return;
        }
        super.r1();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_play_video;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH)) {
            String stringExtra = getIntent().getStringExtra(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH);
            this.W.T().R().e0(c0.a(stringExtra)).f0(new StandardVideoController(this)).start();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (IjkVideoView) findViewById(R.id.player);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.W.Z();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.W.pause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.W.d();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
