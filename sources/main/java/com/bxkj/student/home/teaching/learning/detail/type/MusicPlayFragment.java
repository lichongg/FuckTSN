package com.bxkj.student.home.teaching.learning.detail.type;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import cn.bluemobi.dylan.base.BaseFragment;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.base.util.c0;
import com.bxkj.student.R;
import com.devlin_n.videoplayer.controller.StandardMusicController;
import com.devlin_n.videoplayer.player.IjkVideoView;
import com.tencent.connect.share.QzonePublish;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class MusicPlayFragment extends BaseFragment {

    /* renamed from: j, reason: collision with root package name */
    private TextView f18647j;

    /* renamed from: k, reason: collision with root package name */
    private TextView f18648k;

    /* renamed from: l, reason: collision with root package name */
    private TextView f18649l;

    /* renamed from: m, reason: collision with root package name */
    private SmartWebView f18650m;

    /* renamed from: n, reason: collision with root package name */
    private IjkVideoView f18651n;

    /* renamed from: o, reason: collision with root package name */
    private String f18652o = "";

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (com.devlin_n.floatWindowPermission.b.f().c(this.f1096g)) {
                this.f18651n.c();
            } else {
                Toast.makeText(this.f1096g, "权限授予失败，无法开启悬浮窗", 0).show();
            }
        }
    }

    private void N(String videoPath) {
        StandardMusicController standardMusicController = new StandardMusicController(this.f1096g);
        standardMusicController.q();
        this.f18651n.R().T().d0("正在播放音频：" + this.f18652o).e0(c0.a(videoPath)).f0(standardMusicController).start();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void e() {
        if (getArguments().containsKey("title")) {
            this.f18652o = getArguments().getString("title");
        }
        if (getArguments().containsKey(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH)) {
            N(getArguments().getString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH));
        }
        this.f18647j.setText("标题：" + this.f18652o);
        if (getArguments().containsKey("synopsis")) {
            this.f18649l.setText(getArguments().getString("synopsis"));
        }
        if (getArguments().containsKey("pv")) {
            String string = getArguments().getString("pv");
            this.f18648k.setText("播放量：" + string);
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void f(View view) {
        this.f18647j = (TextView) c(R.id.tv_video_title);
        this.f18650m = (SmartWebView) c(2131298538);
        this.f18651n = (IjkVideoView) c(R.id.player);
        this.f18648k = (TextView) c(R.id.tv_play_num);
        this.f18649l = (TextView) c(R.id.tv_video_introduction);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected int i() {
        return R.layout.fm_learning_music_player_detail;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f18651n.Z();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.f18651n.pause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.f18651n.d();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void b() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
