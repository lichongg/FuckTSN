package com.bxkj.student.main;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import cn.bluemobi.dylan.base.BaseFragment;
import cn.bluemobi.dylan.base.utils.o;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.v2.common.ext.b0;
import com.bxkj.base.webview.H5DetailActivity;
import com.bxkj.student.R;
import com.bxkj.student.main.MyFragment;
import com.bxkj.student.personal.MyQRCodeActivity;
import com.bxkj.student.personal.SystemSetActivity;
import com.bxkj.student.personal.UserInfoActivity;
import com.bxkj.student.personal.login.LoginActivity;
import com.bxkj.student.personal.sign.SignInActivity;
import com.bxkj.student.run.app.face.FaceDetectExpActivity;
import com.bxkj.student.run.app.face.widget.FaceDetect5ExpActivity;
import com.bxkj.student.v2.ui.my.AdSwitchActivity;
import com.orhanobut.logger.j;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.shareboard.SnsPlatform;
import com.umeng.socialize.utils.ShareBoardlistener;
import java.util.Map;
import java.util.UUID;
import kotlin.jvm.functions.Function0;
import kotlin.n1;
import u.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class MyFragment extends BaseFragment {
    private TextView A;
    private TextView B;
    private Button C;
    private LinearLayout D;
    private LinearLayout E;
    private LinearLayout F;
    private LinearLayout G;
    private LinearLayout H;
    private LinearLayout I;

    /* renamed from: j, reason: collision with root package name */
    private Button f19489j;

    /* renamed from: k, reason: collision with root package name */
    private TextView f19490k;

    /* renamed from: l, reason: collision with root package name */
    private TextView f19491l;

    /* renamed from: m, reason: collision with root package name */
    private TextView f19492m;

    /* renamed from: n, reason: collision with root package name */
    private TextView f19493n;

    /* renamed from: o, reason: collision with root package name */
    private TextView f19494o;

    /* renamed from: p, reason: collision with root package name */
    private TextView f19495p;

    /* renamed from: q, reason: collision with root package name */
    private TextView f19496q;

    /* renamed from: r, reason: collision with root package name */
    private TextView f19497r;

    /* renamed from: s, reason: collision with root package name */
    private ImageView f19498s;

    /* renamed from: t, reason: collision with root package name */
    private LinearLayout f19499t;

    /* renamed from: u, reason: collision with root package name */
    private LinearLayout f19500u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f19501v = false;

    /* renamed from: w, reason: collision with root package name */
    private ImageView f19502w;

    /* renamed from: x, reason: collision with root package name */
    private LinearLayout f19503x;

    /* renamed from: y, reason: collision with root package name */
    private LinearLayout f19504y;

    /* renamed from: z, reason: collision with root package name */
    private LinearLayout f19505z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements iOSTwoButtonDialog.RightButtonOnClick {
        a() {
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            com.bxkj.student.personal.login.c.c();
            MyFragment.this.startActivity(new Intent(((BaseFragment) MyFragment.this).f1096g, (Class<?>) LoginActivity.class));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a extends HttpCallBack {
            a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ n1 b() {
                MyFragment.this.startActivity(new Intent(((BaseFragment) MyFragment.this).f1096g, (Class<?>) FaceDetect5ExpActivity.class));
                return null;
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
                b0.x(MyFragment.this.getActivity(), "人脸采集", new Function0() { // from class: com.bxkj.student.main.f
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        n1 b6;
                        b6 = MyFragment.b.a.this.b();
                        return b6;
                    }
                });
            }
        }

        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            Http.with(((BaseFragment) MyFragment.this).f1096g).hideSuccessMessage().setObservable(((e0.a) Http.getApiService(e0.a.class)).p(LoginUser.getLoginUser().getUserId())).setDataListener(new a());
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
                Toast.makeText(((BaseFragment) MyFragment.this).f1096g, " 分享取消了", 0).show();
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onError(SHARE_MEDIA platform, Throwable t5) {
                t5.printStackTrace();
                Toast.makeText(((BaseFragment) MyFragment.this).f1096g, " 分享失败啦", 0).show();
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onResult(SHARE_MEDIA platform) {
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onStart(SHARE_MEDIA share_media) {
            }
        }

        c() {
        }

        @Override // com.umeng.socialize.utils.ShareBoardlistener
        public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
            UMWeb uMWeb = new UMWeb("http://sj.qq.com/myapp/detail.htm?apkName=com.bxkj.student");
            uMWeb.setTitle("校园生活如此简单");
            uMWeb.setThumb(new UMImage(((BaseFragment) MyFragment.this).f1096g, "http://m.boxkj.com/resources/wechat/images/xiaowei.png"));
            uMWeb.setDescription(MyFragment.this.getString(R.string.welcome_user_app));
            new ShareAction(MyFragment.this.getActivity()).setPlatform(share_media).setCallback(new a()).withMedia(uMWeb).share();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d extends HttpCallBack {
        d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            MyFragment.this.f19498s.setVisibility(JsonParse.getInt(data, "data") > 0 ? 0 : 8);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e extends HttpCallBack {
        e() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            LoginUser.getLoginUser().setAccount(JsonParse.getString(data, "userNum"));
            LoginUser.getLoginUser().setRealName(JsonParse.getString(data, CommonNetImpl.NAME));
            LoginUser.getLoginUser().setPhone(JsonParse.getString(data, "phone"));
            LoginUser.getLoginUser().setSex(JsonParse.getString(data, "sex"));
            LoginUser.getLoginUser().setSchoolName(JsonParse.getString(data, "schoolName"));
            LoginUser.getLoginUser().setHeadImageUrl(JsonParse.getString(data, "collectPhoto"));
            MyFragment.this.f0();
        }
    }

    private void X() {
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("mqqwpa://im/chat?chat_type=wpa&uin=884165111")));
        } catch (Exception unused) {
            new iOSOneButtonDialog(this.f1096g).setMessage("请先安装QQ！").show();
        }
    }

    private void Y() {
        Http.with(this.f1096g).hideSuccessMessage().setObservable(((e0.a) Http.getApiService(e0.a.class)).c1("2")).setDataListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(View view) {
        startActivity(new Intent(this.f1096g, (Class<?>) AdSwitchActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(int i6, Intent intent) {
        j.c("人脸识别回调resultCode=" + i6);
        if (i6 == -1) {
            new iOSOneButtonDialog(this.f1096g).setMessage("人脸验证成功").show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ n1 d0() {
        Intent intent = new Intent(this.f1096g, (Class<?>) FaceDetectExpActivity.class);
        intent.putExtra("identify", UUID.randomUUID().toString());
        intent.putExtra("isShowSuccessMessage", false);
        new u.b(this).startActivityForResult(intent).c(new b.a() { // from class: com.bxkj.student.main.c
            @Override // u.b.a
            public final void a(int i6, Intent intent2) {
                MyFragment.this.c0(i6, intent2);
            }
        });
        return null;
    }

    private void e0() {
        if (this.f19501v) {
            if (LoginUser.getLoginUser().isLogin()) {
                f0();
                this.C.setText("退出");
            } else {
                o.f(this.f1096g, LoginUser.getLoginUser().getHeadImageUrl(), this.f19502w, 2131689689, 2131689689);
                this.A.setText("未登录");
                this.B.setText("请登录");
                this.C.setText("登录");
            }
        }
    }

    private void g0() {
        new ShareAction(getActivity()).setDisplayList(SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE, SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE).setShareboardclickCallback(new c()).open();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void b() {
        this.f19489j.setOnClickListener(this);
        this.f19490k.setOnClickListener(this);
        this.f19491l.setOnClickListener(this);
        this.f19492m.setOnClickListener(this);
        this.f19493n.setOnClickListener(this);
        this.f19494o.setOnClickListener(this);
        this.f19495p.setOnClickListener(this);
        this.f19496q.setOnClickListener(this);
        this.f19497r.setOnClickListener(this);
        this.f19502w.setOnClickListener(this);
        this.A.setOnClickListener(this);
        this.B.setOnClickListener(this);
        this.C.setOnClickListener(this);
        this.D.setOnClickListener(this);
        this.F.setOnClickListener(this);
        this.E.setOnClickListener(this);
        this.G.setOnClickListener(this);
        this.f19499t.setOnClickListener(this);
        this.H.setOnClickListener(this);
        this.I.setOnClickListener(this);
        this.f19503x.setOnClickListener(this);
        this.f19504y.setOnClickListener(this);
        this.f19500u.setOnClickListener(this);
        this.f19505z.setOnClickListener(this);
        c(R.id.ll_privacy_set).setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.main.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyFragment.this.b0(view);
            }
        });
    }

    public void f0() {
        o.f(this.f1096g, LoginUser.getLoginUser().getHeadImageUrl(), this.f19502w, 2131689689, 2131689689);
        this.A.setText(LoginUser.getLoginUser().getRealName());
        this.B.setText(LoginUser.getLoginUser().getAccount());
    }

    public void Z() {
        if (LoginUser.getLoginUser().isLogin()) {
            Http.with(this.f1096g).hideLoadingDialog().hideSuccessMessage().hideOtherStatusMessage().hideFailMessage().setObservable(((x.f) Http.getApiService(x.f.class)).s(LoginUser.getLoginUser().getSchoolId(), LoginUser.getLoginUser().getUserId())).setDataListener(new d());
        }
    }

    public void a0() {
        if (LoginUser.getLoginUser().isLogin()) {
            Http.with(this.f1096g).setObservable(((e0.a) Http.getApiService(e0.a.class)).j1()).setDataListener(new e());
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void e() {
        a0();
        e0();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void f(View view) {
        this.f19489j = (Button) c(R.id.bt_login_out);
        this.f19490k = (TextView) c(R.id.tv_user_info);
        this.f19491l = (TextView) c(R.id.tv_safe_set);
        this.f19492m = (TextView) c(R.id.tv_system_set);
        this.f19493n = (TextView) c(R.id.about_us);
        this.f19494o = (TextView) c(R.id.tv_help_center);
        this.f19495p = (TextView) c(R.id.tv_share);
        this.f19496q = (TextView) c(R.id.tv_my_qrcode);
        this.f19497r = (TextView) c(R.id.tv_feedback);
        this.f19502w = (ImageView) c(2131297148);
        this.A = (TextView) c(2131298986);
        this.B = (TextView) c(2131298997);
        this.C = (Button) c(R.id.bt_logout);
        this.D = (LinearLayout) c(R.id.ll_feedback);
        this.F = (LinearLayout) c(R.id.ll_share);
        this.E = (LinearLayout) c(R.id.ll_set);
        this.G = (LinearLayout) c(R.id.ll_myinfo);
        this.f19499t = (LinearLayout) c(R.id.ll_collect);
        this.H = (LinearLayout) c(R.id.ll_integral);
        this.I = (LinearLayout) c(R.id.ll_qr_code);
        this.f19503x = (LinearLayout) c(R.id.ll_face);
        this.f19504y = (LinearLayout) c(R.id.ll_agreement);
        this.f19500u = (LinearLayout) c(R.id.ll_face_confirm);
        this.f19505z = (LinearLayout) c(R.id.ll_privacy_policy);
        this.f19498s = (ImageView) c(R.id.iv_not_read);
        this.f19501v = true;
        Z();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected int i() {
        return R.layout.fm_my;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
        if (v5.getId() == 2131298014) {
            startActivity(new Intent(this.f1096g, (Class<?>) H5DetailActivity.class).putExtra("title", "用户协议").putExtra("url", "https://www.boxkj.com/resources/user_agreement_info.html"));
        }
        if (v5.getId() == 2131298061) {
            startActivity(new Intent(this.f1096g, (Class<?>) H5DetailActivity.class).putExtra("title", "隐私政策").putExtra("url", "https://www.boxkj.com/resources/user_agreement.html"));
            return;
        }
        if (!LoginUser.getLoginUser().isLogin()) {
            startActivity(new Intent(this.f1096g, (Class<?>) LoginActivity.class));
            return;
        }
        switch (v5.getId()) {
            case R.id.bt_logout /* 2131296619 */:
                new iOSTwoButtonDialog(this.f1096g).setTitle("提示").setMessage("您确定要退出登录吗？").setRightButtonOnClickListener(new a()).show();
                break;
            case 2131297148:
            case 2131298986:
            case 2131298997:
                startActivity(new Intent(this.f1096g, (Class<?>) UserInfoActivity.class));
                break;
            case R.id.ll_face /* 2131298035 */:
                Y();
                break;
            case R.id.ll_face_confirm /* 2131298036 */:
                b0.x(getActivity(), "人脸验证", new Function0() { // from class: com.bxkj.student.main.e
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        n1 d02;
                        d02 = MyFragment.this.d0();
                        return d02;
                    }
                });
                break;
            case R.id.ll_feedback /* 2131298037 */:
                X();
                break;
            case R.id.ll_integral /* 2131298047 */:
                startActivity(new Intent(this.f1096g, (Class<?>) SignInActivity.class));
                break;
            case R.id.ll_myinfo /* 2131298055 */:
            case R.id.tv_user_info /* 2131299178 */:
                startActivity(new Intent(this.f1096g, (Class<?>) UserInfoActivity.class));
                break;
            case R.id.ll_qr_code /* 2131298064 */:
            case R.id.tv_my_qrcode /* 2131298983 */:
                startActivity(new Intent(this.f1096g, (Class<?>) MyQRCodeActivity.class));
                break;
            case R.id.ll_set /* 2131298075 */:
                startActivity(new Intent(this.f1096g, (Class<?>) SystemSetActivity.class));
                break;
            case R.id.ll_share /* 2131298077 */:
                g0();
                break;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        e0();
    }
}
