package com.bxkj.student.home.teaching.learning.detail.type;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import cn.bluemobi.dylan.base.BaseFragment;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.base.util.c0;
import com.bxkj.student.R;
import com.devlin_n.videoplayer.controller.StandardVideoController;
import com.devlin_n.videoplayer.player.IjkVideoView;
import com.tencent.connect.share.QzonePublish;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class VideoPlayFragment extends BaseFragment {

    /* renamed from: j, reason: collision with root package name */
    private TextView f18668j;

    /* renamed from: k, reason: collision with root package name */
    private TextView f18669k;

    /* renamed from: l, reason: collision with root package name */
    private TextView f18670l;

    /* renamed from: m, reason: collision with root package name */
    private SmartWebView f18671m;

    /* renamed from: n, reason: collision with root package name */
    private IjkVideoView f18672n;

    /* renamed from: o, reason: collision with root package name */
    private StandardVideoController f18673o;

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (com.devlin_n.floatWindowPermission.b.f().c(this.f1096g)) {
                this.f18672n.c();
            } else {
                Toast.makeText(this.f1096g, "权限授予失败，无法开启悬浮窗", 0).show();
            }
        }
    }

    private void O(String videoPath) {
        StandardVideoController standardVideoController = new StandardVideoController(this.f1096g);
        this.f18673o = standardVideoController;
        standardVideoController.setCanFast(false);
        this.f18672n.R().T().e0(c0.a(videoPath)).f0(this.f18673o).start();
    }

    public void N() {
        StandardVideoController standardVideoController = this.f18673o;
        if (standardVideoController != null) {
            standardVideoController.c();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void e() {
        if (getArguments().containsKey(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH)) {
            O(getArguments().getString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("标题：");
        if (getArguments().containsKey("title")) {
            sb.append(getArguments().getString("title"));
        }
        this.f18668j.setText(sb.toString());
        if (getArguments().containsKey("synopsis")) {
            this.f18670l.setText(getArguments().getString("synopsis"));
        }
        if (getArguments().containsKey("pv")) {
            String string = getArguments().getString("pv");
            this.f18669k.setText("播放量：" + string);
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void f(View view) {
        this.f18668j = (TextView) c(R.id.tv_video_title);
        this.f18671m = (SmartWebView) c(2131298538);
        this.f18672n = (IjkVideoView) c(R.id.player);
        this.f18669k = (TextView) c(R.id.tv_play_num);
        this.f18670l = (TextView) c(R.id.tv_video_introduction);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected int i() {
        return R.layout.ac_learning_video_player_detail;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f18672n.Z();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.f18672n.pause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.f18672n.d();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void b() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
