package com.bxkj.competition.signup;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.CycleViewPager;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.webview.H5DetailActivity;
import com.bxkj.competition.R;
import com.orhanobut.logger.j;
import com.qq.e.comm.constants.Constants;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.shareboard.SnsPlatform;
import com.umeng.socialize.utils.ShareBoardlistener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.ResponseBody;
import rx.l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class CompetitionDetailActivity extends BaseActivity {
    private TextView F0;
    private TextView G0;
    private TextView H0;
    private CheckBox I0;
    private SmartWebView J0;
    private LinearLayout K0;
    private LinearLayout L0;
    private LinearLayout M0;
    private LinearLayout N0;
    private LinearLayout O0;
    private LinearLayout P0;
    private String Q0;
    private CountDownTimer R0;
    private String S0;
    private Map<String, Object> T0;
    private RelativeLayout W;
    private CycleViewPager X;
    private TextView Y;
    private TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    private TextView f17385a0;

    /* renamed from: b0, reason: collision with root package name */
    private TextView f17386b0;

    /* renamed from: c0, reason: collision with root package name */
    private TextView f17387c0;

    /* renamed from: k0, reason: collision with root package name */
    private TextView f17388k0;

    /* renamed from: p0, reason: collision with root package name */
    private TextView f17389p0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements iOSTwoButtonDialog.RightButtonOnClick {
        a() {
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + CompetitionDetailActivity.this.F0.getText().toString().trim()));
            intent.setFlags(268435456);
            CompetitionDetailActivity.this.startActivity(intent);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            CompetitionDetailActivity.this.y0(data);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f17392a;

        c(final String val$url) {
            this.f17392a = val$url;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v5) {
            CompetitionDetailActivity.this.startActivity(new Intent(((BaseActivity) CompetitionDetailActivity.this).T, (Class<?>) H5DetailActivity.class).putExtra("title", "赛事规程协议").putExtra("url", this.f17392a));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements BaseActivity.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f17394a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f17395b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f17396c;

        d(final String val$majorImg, final String val$url, final String val$name) {
            this.f17394a = val$majorImg;
            this.f17395b = val$url;
            this.f17396c = val$name;
        }

        @Override // cn.bluemobi.dylan.base.BaseActivity.c
        public void onClick() {
            CompetitionDetailActivity competitionDetailActivity = CompetitionDetailActivity.this;
            competitionDetailActivity.B0(this.f17394a, competitionDetailActivity.getString(R.string.wanzhuan_app), this.f17395b, this.f17396c);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e extends CountDownTimer {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f17398a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(long x02, long x12, final boolean val$isStart) {
            super(x02, x12);
            this.f17398a = val$isStart;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            if (this.f17398a) {
                CompetitionDetailActivity.this.H0.setEnabled(true);
                CompetitionDetailActivity.this.H0.setBackgroundColor(CompetitionDetailActivity.this.getResources().getColor(R.color.themeColor));
                CompetitionDetailActivity.this.H0.setText("报名参赛");
            } else {
                CompetitionDetailActivity.this.H0.setText("报名已结束");
                CompetitionDetailActivity.this.f17388k0.setText("报名已结束");
                CompetitionDetailActivity.this.H0.setEnabled(false);
                CompetitionDetailActivity.this.H0.setBackgroundColor(CompetitionDetailActivity.this.getResources().getColor(R.color.app_title4));
                CompetitionDetailActivity.this.f17389p0.setVisibility(8);
                CompetitionDetailActivity.this.L0.setVisibility(8);
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            CompetitionDetailActivity.this.z0(millisUntilFinished);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class f implements CycleViewPager.ImageCycleViewListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f17400a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a extends l<ResponseBody> {
            @Override // rx.f
            public void onCompleted() {
                j.d("onCompleted", new Object[0]);
            }

            a() {
            }

            @Override // rx.f
            /* renamed from: g, reason: merged with bridge method [inline-methods] */
            public void onNext(ResponseBody responseBody) {
                j.d("onNext=" + responseBody.toString(), new Object[0]);
            }

            @Override // rx.f
            public void onError(Throwable e6) {
                e6.printStackTrace();
                j.d("Throwable", new Object[0]);
            }
        }

        f(final List val$ads) {
            this.f17400a = val$ads;
        }

        @Override // cn.bluemobi.dylan.base.view.CycleViewPager.ImageCycleViewListener
        public void onImageClick(String url, int position, View imageView) {
            List list = this.f17400a;
            if (list == null || list.size() <= position) {
                return;
            }
            Intent intent = new Intent(((BaseActivity) CompetitionDetailActivity.this).T, (Class<?>) H5DetailActivity.class);
            intent.putExtra("url", JsonParse.getString((Map) this.f17400a.get(position), Constants.KEYS.EXPOSED_CLICK_URL_KEY));
            intent.putExtra("title", JsonParse.getString((Map) this.f17400a.get(position), "advertiesTitle"));
            CompetitionDetailActivity.this.startActivity(intent);
            ((x.f) Http.getApiService(x.f.class)).v(JsonParse.getString((Map) this.f17400a.get(0), "id"), LoginUser.getLoginUser().getSchoolId(), LoginUser.getLoginUser().getUserId()).w5(rx.schedulers.c.e()).I3(rx.android.schedulers.a.b()).r5(new a());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class g implements ShareBoardlistener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f17403a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f17404b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f17405c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f17406d;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements UMShareListener {
            a() {
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onCancel(SHARE_MEDIA platform) {
                Toast.makeText(((BaseActivity) CompetitionDetailActivity.this).T, " 分享取消了", 0).show();
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onResult(SHARE_MEDIA platform) {
                Toast.makeText(((BaseActivity) CompetitionDetailActivity.this).T, " 分享成功啦", 0).show();
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onError(SHARE_MEDIA platform, Throwable t5) {
                t5.printStackTrace();
                Toast.makeText(((BaseActivity) CompetitionDetailActivity.this).T, " 分享失败啦", 0).show();
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onStart(SHARE_MEDIA share_media) {
            }
        }

        g(final String val$content, final String val$imgUrl, final String val$title, final String val$url) {
            this.f17403a = val$content;
            this.f17404b = val$imgUrl;
            this.f17405c = val$title;
            this.f17406d = val$url;
        }

        @Override // com.umeng.socialize.utils.ShareBoardlistener
        public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
            UMWeb uMWeb = new UMWeb(this.f17403a);
            uMWeb.setTitle(this.f17404b);
            uMWeb.setThumb(new UMImage(((BaseActivity) CompetitionDetailActivity.this).T, this.f17405c));
            uMWeb.setDescription(this.f17406d);
            new ShareAction(CompetitionDetailActivity.this).setPlatform(share_media).setCallback(new a()).withMedia(uMWeb).share();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0(final String title, final String content, final String url, final String imgUrl) {
        new ShareAction(this).setDisplayList(SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE, SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE).setShareboardclickCallback(new g(url, title, imgUrl, content)).open();
    }

    private void v0() {
        if (this.I0.isChecked()) {
            startActivity((JsonParse.getInt(this.T0, "signupType") == 0 ? new Intent(this.T, (Class<?>) FreeProjectListActivity.class) : new Intent(this.T, (Class<?>) CostProjectListActivity.class)).putExtra("competitionId", this.Q0));
        } else {
            new iOSOneButtonDialog(this.T).setMessage("请同意赛事规程协议").show();
        }
    }

    private void w0() {
        Http.with(this.T).setObservable(((com.bxkj.competition.b) Http.getApiService(com.bxkj.competition.b.class)).e(this.Q0)).setDataListener(new b());
    }

    private void x0(final List<Map<String, Object>> ads) {
        ArrayList arrayList = new ArrayList();
        if (ads == null || ads.size() == 0) {
            arrayList.add("http://www.boxkj.com/resources/upload/photo/15fffd1a-12db-42d9-aeda-f94e179d277d.jpg");
            arrayList.add("http://www.boxkj.com/resources/upload/photo/f95cc0e8-4cdd-4011-a573-1070b7d76a0b.jpg");
            arrayList.add("http://www.boxkj.com/resources/upload/photo/6b63fa83-98c8-48ef-91b2-ce9c6d37e8ce.jpg");
        } else {
            Iterator<Map<String, Object>> it = ads.iterator();
            while (it.hasNext()) {
                arrayList.add(JsonParse.getString(it.next(), "advertiesUrl"));
            }
        }
        this.X.setIndicators(R.drawable.dot_focus_blue, R.drawable.dot_normal_blue);
        this.X.setData(arrayList, new f(ads));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(Map<String, Object> data) {
        this.T0 = data;
        this.W.setVisibility(0);
        String string = JsonParse.getString(data, CommonNetImpl.NAME);
        this.Y.setText(string);
        this.Z.setText("竞赛地点：" + JsonParse.getString(data, "address"));
        this.f17385a0.setText("竞赛时间：" + JsonParse.getString(data, "startDate"));
        this.f17386b0.setText("报名开始时间：" + JsonParse.getString(data, "signupBeginTime"));
        this.f17387c0.setText("报名结束时间：" + JsonParse.getString(data, "signupEndTime"));
        List<String> list = JsonParse.getList(data, "sideImg", String.class);
        this.X.setIndicators(R.drawable.dot_focus_blue, R.drawable.dot_normal_blue);
        this.X.setData(list, null);
        String string2 = JsonParse.getString(data, "content");
        this.J0.j(string2);
        this.G0.setOnClickListener(new c(string2));
        String string3 = JsonParse.getString(data, "majorImg");
        try {
            if (!getApplication().getPackageName().equalsIgnoreCase("com.bxkj.teacher")) {
                b0("分享", R.mipmap.share, new d(string, string2, string3));
                invalidateOptionsMenu();
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        if (!TextUtils.isEmpty(this.S0)) {
            this.K0.setVisibility(8);
            this.I0.setChecked(true);
            this.I0.setClickable(false);
            this.H0.setText("查看我报名的项目");
            return;
        }
        String string4 = JsonParse.getString(data, "timeStatus");
        if ("1".equals(string4)) {
            this.f17388k0.setText("距离报名开始还有");
            this.H0.setText("报名未开始");
            this.H0.setEnabled(false);
            this.H0.setBackgroundColor(getResources().getColor(R.color.app_title4));
            this.L0.setVisibility(8);
            A0(JsonParse.getLong(data, "timeValue"), true);
            return;
        }
        if ("2".equals(string4)) {
            this.f17388k0.setText("距离报名结束还有");
            A0(JsonParse.getLong(data, "timeValue"), true);
        } else if ("3".equals(string4)) {
            this.H0.setText("报名已结束");
            this.f17388k0.setText("报名已结束");
            this.H0.setEnabled(false);
            this.H0.setBackgroundColor(getResources().getColor(R.color.app_title4));
            this.f17389p0.setVisibility(8);
            this.L0.setVisibility(8);
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.F0.setOnClickListener(this);
        this.H0.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_competition_detail;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("竞赛详情");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (RelativeLayout) findViewById(R.id.rl_root);
        this.X = (CycleViewPager) findViewById(R.id.cy);
        this.Y = (TextView) findViewById(R.id.tv_title);
        this.Z = (TextView) findViewById(R.id.tv_address);
        this.f17388k0 = (TextView) findViewById(R.id.tv_status);
        this.f17389p0 = (TextView) findViewById(R.id.tv_time);
        this.f17385a0 = (TextView) findViewById(R.id.tv_start_time);
        this.f17386b0 = (TextView) findViewById(R.id.tv_apply_time);
        this.f17387c0 = (TextView) findViewById(R.id.tv_apply_end_time);
        this.F0 = (TextView) findViewById(R.id.tv_phone);
        this.H0 = (TextView) findViewById(R.id.tv_ok);
        this.J0 = (SmartWebView) findViewById(R.id.swv);
        this.K0 = (LinearLayout) findViewById(R.id.ll_time);
        this.L0 = (LinearLayout) findViewById(R.id.ll_xy);
        this.G0 = (TextView) findViewById(R.id.tv_xy);
        this.M0 = (LinearLayout) findViewById(R.id.ll_wechat);
        this.N0 = (LinearLayout) findViewById(R.id.ll_moments);
        this.O0 = (LinearLayout) findViewById(R.id.ll_qq);
        this.P0 = (LinearLayout) findViewById(R.id.ll_qzone);
        this.I0 = (CheckBox) findViewById(R.id.cb_agree);
        this.W.setVisibility(8);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        CountDownTimer countDownTimer = this.R0;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        super.onDestroy();
    }

    private void A0(long time, final boolean isStart) {
        z0(time);
        e eVar = new e(time, 1000L, isStart);
        this.R0 = eVar;
        eVar.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0(long millisUntilFinished) {
        int floor = (int) Math.floor(millisUntilFinished / 86400000);
        double d6 = millisUntilFinished % 86400000;
        int floor2 = (int) Math.floor(d6 / 3600000.0d);
        double d7 = d6 % 3600000.0d;
        int floor3 = (int) Math.floor(d7 / 60000.0d);
        int floor4 = (int) Math.floor((d7 % 60000.0d) / 1000.0d);
        this.f17389p0.setText(floor + "天 " + floor2 + "时 " + floor3 + " 分" + floor4 + " 秒");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("competitionId")) {
            this.Q0 = getIntent().getStringExtra("competitionId");
        }
        if (getIntent().hasExtra(com.tencent.connect.common.Constants.FROM)) {
            this.S0 = getIntent().getStringExtra(com.tencent.connect.common.Constants.FROM);
        }
        w0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
        Intent intent;
        int id = v5.getId();
        if (id == R.id.tv_phone) {
            new iOSTwoButtonDialog(this.T).setTitle("提示").setMessage(getString(R.string.you_sure_call_phone)).setRightButtonOnClickListener(new a()).show();
            return;
        }
        if (id == R.id.tv_ok) {
            String trim = this.H0.getText().toString().trim();
            if (trim.equals("报名参赛")) {
                v0();
            } else if (trim.equals("查看我报名的项目")) {
                if (JsonParse.getString(this.T0, "signupType").equals("0")) {
                    intent = new Intent(this.T, (Class<?>) FreeProjectListActivity.class);
                } else {
                    intent = new Intent(this.T, (Class<?>) CostProjectListActivity.class);
                }
                startActivity(intent.putExtra("competitionId", this.Q0).putExtra(com.tencent.connect.common.Constants.FROM, "my"));
            }
        }
    }
}
