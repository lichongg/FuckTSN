package com.bxkj.student.home.teaching.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.R;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class BookingDetailActivity extends BaseActivity {
    private TextView F0;
    private Button G0;
    private String H0;
    private String I0;
    private TextView W;
    private TextView X;
    private TextView Y;
    private TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    private TextView f18066a0;

    /* renamed from: b0, reason: collision with root package name */
    private TextView f18067b0;

    /* renamed from: c0, reason: collision with root package name */
    private TextView f18068c0;

    /* renamed from: k0, reason: collision with root package name */
    private TextView f18069k0;

    /* renamed from: p0, reason: collision with root package name */
    private TextView f18070p0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            BookingDetailActivity.this.Q().setVisibility(0);
            BookingDetailActivity.this.I0 = JsonParse.getString(data, "activityId");
            BookingDetailActivity.this.W.setText(JsonParse.getString(data, CommonNetImpl.NAME));
            BookingDetailActivity.this.X.setText(JsonParse.getString(data, "term"));
            BookingDetailActivity.this.Y.setText(JsonParse.getString(data, "totalNum"));
            BookingDetailActivity.this.Z.setText(JsonParse.getString(data, "defaultRoleScore"));
            BookingDetailActivity.this.f18066a0.setText(JsonParse.getString(data, "defaultCourseNum"));
            BookingDetailActivity.this.f18067b0.setText(JsonParse.getString(data, "type"));
            BookingDetailActivity.this.f18068c0.setText(JsonParse.getString(data, "address"));
            BookingDetailActivity.this.f18069k0.setText(JsonParse.getString(data, "appointmentBeginTime") + "-" + JsonParse.getString(data, "appointmentEndTime"));
            BookingDetailActivity.this.f18070p0.setText(JsonParse.getString(data, "actBeginTime") + "-" + JsonParse.getString(data, "actEndTime"));
            BookingDetailActivity.this.F0.setText(Html.fromHtml(JsonParse.getString(data, "memo")));
            if (JsonParse.getInt(data, "zhuangtai") == 0) {
                BookingDetailActivity.this.G0.setEnabled(true);
                BookingDetailActivity.this.G0.setText("预约");
            } else if (JsonParse.getInt(data, "zhuangtai") == 1) {
                BookingDetailActivity.this.G0.setEnabled(true);
                BookingDetailActivity.this.G0.setText("取消预约");
            } else if (JsonParse.getInt(data, "zhuangtai") == 2) {
                BookingDetailActivity.this.G0.setEnabled(false);
                BookingDetailActivity.this.G0.setText("人数已满");
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            BookingDetailActivity.this.G0.setText("取消预约");
            BookingDetailActivity.this.A0();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            if (status == 202) {
                BookingDetailActivity.this.startActivity(new Intent(((BaseActivity) BookingDetailActivity.this).T, (Class<?>) BookingLessonActivity.class).putExtra("id", BookingDetailActivity.this.H0));
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            BookingDetailActivity.this.G0.setText("预约");
            BookingDetailActivity.this.A0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0() {
        Http.with(this.T).setObservable(((e0.a) Http.getApiService(e0.a.class)).q(LoginUser.getLoginUser().getUserId(), this.H0)).setDataListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C0(View view) {
        if (this.G0.getText().toString().trim().equals("预约")) {
            y0();
        } else if (this.G0.getText().toString().trim().equals("取消预约")) {
            new iOSTwoButtonDialog(this.T).setMessage("确定要取消预约吗?").setLeftButtonText("我再想想").setRightButtonText("直接取消").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.activity.c
                @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                public final void buttonRightOnClick() {
                    BookingDetailActivity.this.B0();
                }
            }).show();
        }
    }

    private void y0() {
        Http.with(this.T).hideOtherStatusMessage().setObservable(((e0.a) Http.getApiService(e0.a.class)).i0(LoginUser.getLoginUser().getUserId(), this.H0)).setDataListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z0, reason: merged with bridge method [inline-methods] */
    public void B0() {
        Http.with(this.T).hideOtherStatusMessage().setObservable(((e0.a) Http.getApiService(e0.a.class)).u(LoginUser.getLoginUser().getUserId(), this.I0)).setDataListener(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.G0.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.activity.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookingDetailActivity.this.C0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("活动详情");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_booking_activity_detail;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("id")) {
            this.H0 = getIntent().getStringExtra("id");
        }
        Q().setVisibility(4);
        A0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (TextView) findViewById(R.id.tv1);
        this.X = (TextView) findViewById(R.id.tv2);
        this.Y = (TextView) findViewById(R.id.tv3);
        this.Z = (TextView) findViewById(R.id.tv4);
        this.f18066a0 = (TextView) findViewById(R.id.tv5);
        this.f18067b0 = (TextView) findViewById(R.id.tv6);
        this.f18068c0 = (TextView) findViewById(R.id.tv7);
        this.f18069k0 = (TextView) findViewById(R.id.tv8);
        this.f18070p0 = (TextView) findViewById(R.id.tv9);
        this.F0 = (TextView) findViewById(R.id.tv10);
        this.G0 = (Button) findViewById(R.id.bt);
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        A0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
