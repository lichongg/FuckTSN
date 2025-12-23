package com.bxkj.student.home.physicaltest.monitor.reservation;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.webkit.WebSettings;
import android.widget.Button;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.R;
import java.util.Map;
import master.flame.danmaku.danmaku.model.android.d;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class MonitorDescriptionActivity extends BaseActivity {
    private SmartWebView W;
    private Button X;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends HttpCallBack {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.student.home.physicaltest.monitor.reservation.MonitorDescriptionActivity$a$a, reason: collision with other inner class name */
        class CountDownTimerC0210a extends CountDownTimer {
            CountDownTimerC0210a(long millisInFuture, long countDownInterval) {
                super(millisInFuture, countDownInterval);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                MonitorDescriptionActivity.this.X.setEnabled(true);
                MonitorDescriptionActivity.this.X.setText("开始预约");
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                MonitorDescriptionActivity.this.X.setText("开始预约(" + (millisUntilFinished / 1000) + "秒)");
            }
        }

        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            MonitorDescriptionActivity.this.Q().setVisibility(0);
            MonitorDescriptionActivity.this.W.h(JsonParse.getString(data, "content"));
            MonitorDescriptionActivity.this.W.getWebView().getSettings().setTextSize(WebSettings.TextSize.LARGEST);
            MonitorDescriptionActivity.this.X.setEnabled(false);
            new CountDownTimerC0210a(d.f50003r, 1000L).start();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.X.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("预约说明");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_pub_description;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        Q().setVisibility(8);
        this.X.setText("开始预约");
        Http.with(this.T).setObservable(((e0.a) Http.getApiService(e0.a.class)).z("6", LoginUser.getLoginUser().getUserId())).setDataListener(new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.X = (Button) findViewById(R.id.bt_start);
        this.W = (SmartWebView) findViewById(2131298609);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
        if (v5.getId() != 2131296646) {
            return;
        }
        startActivity(getIntent().setClass(this.T, MonitorReservationListActivity.class));
        finish();
    }
}
