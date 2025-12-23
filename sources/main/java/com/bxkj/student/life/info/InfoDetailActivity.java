package com.bxkj.student.life.info;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.student.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.shareboard.SnsPlatform;
import com.umeng.socialize.utils.ShareBoardlistener;
import java.io.PrintStream;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class InfoDetailActivity extends BaseActivity {
    private String F0;
    private String G0;
    private String W;
    private String X;
    private CoordinatorLayout Y;
    private FloatingActionButton Z;

    /* renamed from: a0, reason: collision with root package name */
    private SmartWebView f19034a0;

    /* renamed from: b0, reason: collision with root package name */
    private LinearLayout f19035b0;

    /* renamed from: c0, reason: collision with root package name */
    private LinearLayout f19036c0;

    /* renamed from: k0, reason: collision with root package name */
    private LinearLayout f19037k0;

    /* renamed from: p0, reason: collision with root package name */
    private LinearLayout f19038p0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        private boolean f19039a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f19040b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            this.f19039a = true;
        }

        a(final View val$view) {
            this.f19040b = val$view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            if (this.f19039a) {
                return;
            }
            this.f19040b.setVisibility(4);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            this.f19040b.setVisibility(0);
            this.f19039a = false;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            InfoDetailActivity.this.Y.setVisibility(0);
            String string = JsonParse.getString(data, "html5Url");
            InfoDetailActivity.this.f19034a0.j(string);
            InfoDetailActivity.this.f19034a0.setTag(string);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements ShareBoardlistener {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements UMShareListener {
            a() {
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onCancel(SHARE_MEDIA platform) {
                Toast.makeText(((BaseActivity) InfoDetailActivity.this).T, " 分享取消了", 0).show();
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onResult(SHARE_MEDIA platform) {
                Toast.makeText(((BaseActivity) InfoDetailActivity.this).T, " 分享成功啦", 0).show();
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onError(SHARE_MEDIA platform, Throwable t5) {
                t5.printStackTrace();
                Toast.makeText(((BaseActivity) InfoDetailActivity.this).T, " 分享失败啦", 0).show();
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onStart(SHARE_MEDIA share_media) {
            }
        }

        c() {
        }

        @Override // com.umeng.socialize.utils.ShareBoardlistener
        public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
            UMWeb uMWeb = new UMWeb(InfoDetailActivity.this.f19034a0.getTag().toString());
            uMWeb.setTitle(InfoDetailActivity.this.X);
            uMWeb.setThumb(new UMImage(((BaseActivity) InfoDetailActivity.this).T, "http://m.boxkj.com/resources/wechat/images/xiaowei.png"));
            uMWeb.setDescription("校园生活如此简单");
            new ShareAction(InfoDetailActivity.this).setPlatform(share_media).setCallback(new a()).withMedia(uMWeb).share();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements UMShareListener {
        d() {
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(((BaseActivity) InfoDetailActivity.this).T, " 分享取消了", 0).show();
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(((BaseActivity) InfoDetailActivity.this).T, " 分享成功啦", 0).show();
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onError(SHARE_MEDIA platform, Throwable t5) {
            t5.printStackTrace();
            Toast.makeText(((BaseActivity) InfoDetailActivity.this).T, " 分享失败啦", 0).show();
        }

        @Override // com.umeng.socialize.UMShareListener
        public void onStart(SHARE_MEDIA share_media) {
        }
    }

    private void t0() {
        Http.with(this.T).setObservable(((x.c) Http.getApiService(x.c.class)).e(this.W)).setDataListener(new b());
    }

    private void u0() {
        new ShareAction(this).setDisplayList(SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE, SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE).setShareboardclickCallback(new c()).open();
    }

    private void v0(SHARE_MEDIA platform) {
        UMWeb uMWeb = new UMWeb(this.f19034a0.getTag().toString());
        uMWeb.setTitle(this.X);
        if (TextUtils.isEmpty(this.G0)) {
            this.G0 = "http://m.boxkj.com/resources/wechat/images/xiaowei.png";
        }
        uMWeb.setThumb(new UMImage(this.T, this.G0));
        uMWeb.setDescription("校园生活如此简单");
        new ShareAction(this).setPlatform(platform).setCallback(new d()).withMedia(uMWeb).share();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.f19035b0.setOnClickListener(this);
        this.f19036c0.setOnClickListener(this);
        this.f19037k0.setOnClickListener(this);
        this.f19038p0.setOnClickListener(this);
        this.Z.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("资讯详情");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        SmartWebView smartWebView = this.f19034a0;
        if (smartWebView != null) {
            ViewParent parent = smartWebView.getParent();
            if (parent != null) {
                ((ViewGroup) parent).removeView(this.f19034a0);
            }
            try {
                this.f19034a0.getWebView().stopLoading();
                this.f19034a0.getWebView().clearHistory();
                this.f19034a0.getWebView().clearView();
                this.f19034a0.removeAllViews();
                this.f19034a0.getWebView().destroy();
            } catch (Throwable unused) {
            }
        }
        super.onDestroy();
    }

    public String s0(String inputString) {
        String str;
        try {
            str = Pattern.compile("<[^>]+>", 2).matcher(Pattern.compile("<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>", 2).matcher(Pattern.compile("<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>", 2).matcher(inputString).replaceAll("")).replaceAll("")).replaceAll("");
        } catch (Exception e6) {
            PrintStream printStream = System.err;
            e6.getMessage();
            printStream.getClass();
            str = "";
        }
        return str.replaceAll("[ ]+", " ").replaceAll("(?m)^\\s*$(\\n|\\r\\n)", "");
    }

    private void r0(final View view) {
        view.animate().cancel();
        view.animate().scaleX(0.0f).scaleY(0.0f).alpha(0.0f).setDuration(200L).setInterpolator(new FastOutLinearInInterpolator()).setListener(new a(view));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_info_detail;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("infoId")) {
            this.W = getIntent().getStringExtra("infoId");
        }
        if (getIntent().hasExtra("imageUrl")) {
            this.G0 = getIntent().getStringExtra("imageUrl");
        }
        if (getIntent().hasExtra("inforTitle")) {
            this.X = getIntent().getStringExtra("inforTitle");
        }
        t0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.f19034a0 = (SmartWebView) findViewById(2131298609);
        this.Y = (CoordinatorLayout) findViewById(R.id.cl_root);
        this.f19035b0 = (LinearLayout) findViewById(2131298085);
        this.f19036c0 = (LinearLayout) findViewById(2131298053);
        this.f19037k0 = (LinearLayout) findViewById(2131298063);
        this.f19038p0 = (LinearLayout) findViewById(2131298066);
        this.Z = (FloatingActionButton) findViewById(R.id.fb_go_top);
        this.Y.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
        switch (v5.getId()) {
            case R.id.fb_go_top /* 2131296971 */:
                r0(this.Z);
                break;
            case 2131298053:
                v0(SHARE_MEDIA.WEIXIN_CIRCLE);
                break;
            case 2131298063:
                v0(SHARE_MEDIA.QQ);
                break;
            case 2131298066:
                v0(SHARE_MEDIA.QZONE);
                break;
            case 2131298085:
                v0(SHARE_MEDIA.WEIXIN);
                break;
        }
    }
}
