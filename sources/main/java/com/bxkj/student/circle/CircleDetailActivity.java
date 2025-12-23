package com.bxkj.student.circle;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.util.c0;
import com.bxkj.student.R;
import com.bxkj.student.circle.CircleDetailActivity;
import com.bxkj.student.main.CircleFragment;
import com.devlin_n.videoplayer.controller.StandardVideoController;
import com.devlin_n.videoplayer.player.IjkVideoView;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.shareboard.SnsPlatform;
import com.umeng.socialize.utils.ShareBoardlistener;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class CircleDetailActivity extends BaseActivity {
    private String W = "https://tsncs.boxkj.com/resources/upload/learn/20200227221615_883.mp4";
    private TextView X;
    private TextView Y;
    private Button Z;

    /* renamed from: a0, reason: collision with root package name */
    private ImageView f17673a0;

    /* renamed from: b0, reason: collision with root package name */
    private Button f17674b0;

    /* renamed from: c0, reason: collision with root package name */
    private IjkVideoView f17675c0;

    /* renamed from: k0, reason: collision with root package name */
    private String f17676k0;

    /* renamed from: p0, reason: collision with root package name */
    private CountDownTimer f17677p0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends HttpCallBack {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(Map map, View view) {
            CircleDetailActivity.this.C0(JsonParse.getString(map, "sysStudentName"), JsonParse.getString(map, "learnQuestionImage"));
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(final Map<String, Object> data) {
            CircleDetailActivity.this.Q().setVisibility(0);
            CircleDetailActivity.this.X.setText("票数：" + JsonParse.getString(data, "votesTotalNumber"));
            CircleDetailActivity.this.Y.setText("排名：" + JsonParse.getString(data, "rank"));
            CircleDetailActivity.this.y0(JsonParse.getString(data, "works"));
            CircleDetailActivity.this.z0(JsonParse.getInt(data, "isVote"), JsonParse.getBoolean(data, "voteFlag"), JsonParse.getLong(data, "countDown"));
            CircleDetailActivity.this.f17674b0.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.circle.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CircleDetailActivity.a.this.b(data, view);
                }
            });
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {
        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            CircleDetailActivity.this.v0();
            CircleFragment circleFragment = (CircleFragment) cn.bluemobi.dylan.base.utils.a.n().o(CircleFragment.class);
            if (circleFragment != null) {
                circleFragment.i0();
            }
        }

        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data, String msg) {
            new iOSOneButtonDialog(((BaseActivity) CircleDetailActivity.this).T).setMessage(msg).show();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends CountDownTimer {
        c(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            CircleDetailActivity.this.z0(1, false, 0L);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            CircleDetailActivity.this.A0(millisUntilFinished);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements UMShareListener {
        d() {
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(((BaseActivity) CircleDetailActivity.this).T, " 分享取消了", 0).show();
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(((BaseActivity) CircleDetailActivity.this).T, " 分享成功啦", 0).show();
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onError(SHARE_MEDIA platform, Throwable t5) {
            t5.printStackTrace();
            Toast.makeText(((BaseActivity) CircleDetailActivity.this).T, " 分享失败啦", 0).show();
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onStart(SHARE_MEDIA share_media) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0(final String name, final String learnQuestionImage) {
        new ShareAction(this).setDisplayList(SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE, SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE).setShareboardclickCallback(new ShareBoardlistener() { // from class: com.bxkj.student.circle.a
            @Override // com.umeng.socialize.utils.ShareBoardlistener
            public final void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
                CircleDetailActivity.this.x0(name, learnQuestionImage, snsPlatform, share_media);
            }
        }).open();
    }

    private void D0() {
        Http.with(this.T).hideSuccessMessage().setObservable(((e0.a) Http.getApiService(e0.a.class)).q1(this.f17676k0, 0, 1)).setDataListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0() {
        Http.with(this.T).setObservable(((e0.a) Http.getApiService(e0.a.class)).c0(this.f17676k0)).setDataListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x0(String str, String str2, SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
        UMWeb uMWeb = new UMWeb("http://sj.qq.com/myapp/detail.htm?apkName=com.bxkj.student");
        uMWeb.setTitle("请为" + str + "投上一票");
        uMWeb.setThumb(new UMImage(this.T, str2));
        uMWeb.setDescription("2020年学生“齐抗疫，云锻炼”居家锻炼模范评比活动");
        new ShareAction(this).setPlatform(share_media).setCallback(new d()).withMedia(uMWeb).share();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(String videoPath) {
        this.f17675c0.T().R().e0(c0.a(videoPath)).f0(new StandardVideoController(this)).start();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("参与投票");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(long millisUntilFinished) {
        int floor = (int) Math.floor(millisUntilFinished / 86400000);
        double d6 = millisUntilFinished % 86400000;
        int floor2 = (int) Math.floor(d6 / 3600000.0d);
        double d7 = d6 % 3600000.0d;
        int floor3 = (int) Math.floor(d7 / 60000.0d);
        int floor4 = (int) Math.floor((d7 % 60000.0d) / 1000.0d);
        StringBuilder sb = new StringBuilder();
        sb.append("距离投票开始还有");
        if (floor > 0) {
            if (floor < 10) {
                sb.append("0");
            }
            sb.append(floor);
            sb.append("天");
        }
        if (floor2 > 0) {
            if (floor2 < 10) {
                sb.append("0");
            }
            sb.append(floor2);
            sb.append("时");
        }
        if (floor3 > 0) {
            if (floor3 < 10) {
                sb.append("0");
            }
            sb.append(floor3);
            sb.append("分");
        }
        if (floor4 < 10) {
            sb.append("0");
        }
        sb.append(floor4);
        sb.append("秒");
        this.Z.setText(sb);
    }

    private void B0(long time) {
        A0(time);
        c cVar = new c(time, 1000L);
        this.f17677p0 = cVar;
        cVar.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w0(View view) {
        D0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0(int isVote, boolean voteFlag, long millisUntilFinished) {
        if (isVote == 0) {
            this.Z.setEnabled(false);
            this.Z.setBackground(ContextCompat.getDrawable(this.T, 2131231052));
            if (millisUntilFinished <= 0) {
                this.Z.setText("投票未开始");
                return;
            } else {
                A0(millisUntilFinished);
                B0(millisUntilFinished);
                return;
            }
        }
        if (isVote == 1) {
            if (voteFlag) {
                this.Z.setVisibility(8);
                this.f17673a0.setVisibility(0);
                return;
            }
            this.Z.setVisibility(0);
            this.f17673a0.setVisibility(8);
            this.Z.setEnabled(true);
            this.Z.setBackground(ContextCompat.getDrawable(this.T, 2131231062));
            this.Z.setText("投票");
            this.Z.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.circle.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CircleDetailActivity.this.w0(view);
                }
            });
            return;
        }
        this.Z.setEnabled(false);
        this.Z.setBackground(ContextCompat.getDrawable(this.T, 2131231052));
        this.Z.setText("投票已结束");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_circle_detail;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        Q().setVisibility(8);
        if (getIntent().hasExtra("learnSelectionWorkId")) {
            this.f17676k0 = getIntent().getStringExtra("learnSelectionWorkId");
            v0();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.f17675c0 = (IjkVideoView) findViewById(R.id.player);
        this.X = (TextView) findViewById(2131298996);
        this.Y = (TextView) findViewById(2131299062);
        this.Z = (Button) findViewById(R.id.bt_vote);
        this.f17673a0 = (ImageView) findViewById(R.id.iv_has_vote);
        this.f17674b0 = (Button) findViewById(R.id.bt_share);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this.T).onActivityResult(requestCode, resultCode, data);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f17675c0.Z();
        CountDownTimer countDownTimer = this.f17677p0;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.f17675c0.pause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f17675c0.d();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
