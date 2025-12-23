package com.bxkj.student.home.teaching.learning.detail;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.R;
import com.bxkj.student.home.teaching.learning.detail.type.H5Fragment;
import com.bxkj.student.home.teaching.learning.detail.type.MusicPlayFragment;
import com.bxkj.student.home.teaching.learning.detail.type.PdfFragment;
import com.bxkj.student.home.teaching.learning.detail.type.VideoPlayFragment;
import com.tencent.connect.share.QzonePublish;
import com.umeng.socialize.media.BaseMediaObject;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class LearnDetailActivity extends BaseActivity {
    private FrameLayout W;
    private FrameLayout X;
    private FrameLayout Y;
    private String Z;

    /* renamed from: a0, reason: collision with root package name */
    private String f18506a0;

    /* renamed from: b0, reason: collision with root package name */
    private BottomFragment f18507b0;

    /* renamed from: c0, reason: collision with root package name */
    private Fragment f18508c0;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f18509k0 = false;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends HttpCallBack {
        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data, String msg) {
            super.netOnSuccess(data, msg);
        }

        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            LearnDetailActivity.this.Q().setVisibility(0);
            LearnDetailActivity.this.o0(data);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void r0(Map<String, Object> data) {
        UMWeb uMWeb = new UMWeb(JsonParse.getString(data, "content"));
        uMWeb.setTitle(this.Z);
        String string = JsonParse.getString(data, "indexImg");
        if (TextUtils.isEmpty(string)) {
            string = "http://m.boxkj.com/resources/wechat/images/xiaowei.png";
        }
        uMWeb.setThumb(new UMImage(this.T, string));
        uMWeb.setDescription(JsonParse.getString(data, "synopsis"));
        n0(JsonParse.getString(data, "detailId"), JsonParse.getInt(data, "isLike"), JsonParse.getInt(data, "isCollection"), JsonParse.getInt(data, "duration"), JsonParse.getInt(data, "popTime"), JsonParse.getInt(data, "hasQuestion"), JsonParse.getInt(data, "isComplete"), JsonParse.getInt(data, "isOk"), JsonParse.getInt(data, "opreateFlag"), JsonParse.getInt(data, "valType"), JsonParse.getInt(data, "integral"), uMWeb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0() {
        BottomFragment bottomFragment = this.f18507b0;
        if (bottomFragment != null) {
            bottomFragment.u0(false);
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("在线学习详情");
        Y(new BaseActivity.c() { // from class: com.bxkj.student.home.teaching.learning.detail.z
            @Override // cn.bluemobi.dylan.base.BaseActivity.c
            public final void onClick() {
                LearnDetailActivity.this.s0();
            }
        });
    }

    public void q0() {
        Http.with(this.T).setObservable(((com.bxkj.student.home.teaching.learning.m) Http.getApiService(com.bxkj.student.home.teaching.learning.m.class)).k(LoginUser.getLoginUser().getUserId(), this.f18506a0)).setDataListener(new a());
    }

    public void v0(boolean isTimeCountDown) {
        this.f18509k0 = isTimeCountDown;
    }

    private void n0(String detailId, int isLike, int isCollection, int duration, int popTime, int hasQuestion, int isComplete, int isOk, int opreateFlag, int valType, int integral, BaseMediaObject baseMediaObject) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        this.f18507b0 = new BottomFragment();
        Bundle bundle = new Bundle();
        bundle.putString("id", this.f18506a0);
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
        bundle.putInt("integral", integral);
        this.f18507b0.setArguments(bundle);
        this.f18507b0.v0(baseMediaObject);
        beginTransaction.add(R.id.fl_bottom, this.f18507b0);
        beginTransaction.commitAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0(final Map<String, Object> data) {
        p0(data);
        int i6 = JsonParse.getInt(data, "type");
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putString("id", this.f18506a0);
        if (i6 == 1) {
            this.f18508c0 = new H5Fragment();
            bundle.putString("url", JsonParse.getString(data, "content"));
        } else if (i6 == 2) {
            this.f18508c0 = new VideoPlayFragment();
            bundle.putString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH, JsonParse.getString(data, "content"));
            bundle.putString("title", this.Z);
            bundle.putString("pv", JsonParse.getString(data, "pv"));
        } else if (i6 == 3) {
            this.f18508c0 = new PdfFragment();
            bundle.putString("url", JsonParse.getString(data, "content"));
        } else if (i6 == 4) {
            this.f18508c0 = new MusicPlayFragment();
            bundle.putString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH, JsonParse.getString(data, "content"));
            bundle.putString("title", this.Z);
            bundle.putString("pv", JsonParse.getString(data, "pv"));
        } else {
            this.f18508c0 = new H5Fragment();
        }
        this.f18508c0.setArguments(bundle);
        beginTransaction.add(R.id.fl_content, this.f18508c0);
        beginTransaction.commitAllowingStateLoss();
        Fragment fragment = this.f18508c0;
        if (fragment instanceof PdfFragment) {
            ((PdfFragment) fragment).a0(new PdfFragment.b() { // from class: com.bxkj.student.home.teaching.learning.detail.w
                @Override // com.bxkj.student.home.teaching.learning.detail.type.PdfFragment.b
                public final void onSuccess() {
                    LearnDetailActivity.this.r0(data);
                }
            });
        } else {
            r0(data);
        }
    }

    private void p0(Map<String, Object> data) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        TopTipsFragment topTipsFragment = new TopTipsFragment();
        Bundle bundle = new Bundle();
        bundle.putString("duration", JsonParse.getString(data, "duration"));
        bundle.putString("integral", JsonParse.getString(data, "integral"));
        topTipsFragment.setArguments(bundle);
        beginTransaction.add(R.id.fl_top, topTipsFragment);
        beginTransaction.commitAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0() {
        finish();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_learn_detail;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        Q().setVisibility(8);
        if (getIntent().hasExtra("id")) {
            this.f18506a0 = getIntent().getStringExtra("id");
        }
        if (getIntent().hasExtra("title")) {
            this.Z = getIntent().getStringExtra("title");
        }
        q0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (FrameLayout) findViewById(R.id.fl_top);
        this.X = (FrameLayout) findViewById(R.id.fl_content);
        this.Y = (FrameLayout) findViewById(R.id.fl_bottom);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    /* renamed from: onBackPressed, reason: merged with bridge method [inline-methods] */
    public void s0() {
        Fragment fragment;
        if (getResources().getConfiguration().orientation == 2 && (fragment = this.f18508c0) != null && (fragment instanceof VideoPlayFragment)) {
            ((VideoPlayFragment) fragment).N();
            return;
        }
        if (this.f18509k0) {
            BottomFragment bottomFragment = this.f18507b0;
            if (bottomFragment != null) {
                bottomFragment.u0(true);
            }
            new iOSTwoButtonDialog(this.T).setMessage("正在学习,如果离开将不积分,确定离开？").setLeftButtonText("继续学习").setRightButtonText("确定离开").setLeftButtonOnClickListener(new iOSTwoButtonDialog.LeftButtonOnClick() { // from class: com.bxkj.student.home.teaching.learning.detail.x
                @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.LeftButtonOnClick
                public final void buttonLeftOnClick() {
                    LearnDetailActivity.this.t0();
                }
            }).setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.learning.detail.y
                @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                public final void buttonRightOnClick() {
                    LearnDetailActivity.this.u0();
                }
            }).show();
            return;
        }
        super.s0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
