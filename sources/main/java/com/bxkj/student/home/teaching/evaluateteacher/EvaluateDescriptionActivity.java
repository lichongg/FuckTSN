package com.bxkj.student.home.teaching.evaluateteacher;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.webkit.WebSettings;
import android.widget.Button;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.student.R;
import java.util.Map;
import master.flame.danmaku.danmaku.model.android.d;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class EvaluateDescriptionActivity extends BaseActivity {
    private SmartWebView W;
    private Button X;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends HttpCallBack {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.student.home.teaching.evaluateteacher.EvaluateDescriptionActivity$a$a, reason: collision with other inner class name */
        class CountDownTimerC0217a extends CountDownTimer {
            CountDownTimerC0217a(long millisInFuture, long countDownInterval) {
                super(millisInFuture, countDownInterval);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                EvaluateDescriptionActivity.this.X.setEnabled(true);
                EvaluateDescriptionActivity.this.X.setText("开始评价");
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                EvaluateDescriptionActivity.this.X.setText("开始评价(" + (millisUntilFinished / 1000) + "秒)");
            }
        }

        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            EvaluateDescriptionActivity.this.Q().setVisibility(0);
            EvaluateDescriptionActivity.this.W.h(JsonParse.getString(data, "data"));
            EvaluateDescriptionActivity.this.W.getWebView().getSettings().setTextSize(WebSettings.TextSize.LARGEST);
            EvaluateDescriptionActivity.this.X.setEnabled(false);
            new CountDownTimerC0217a(d.f50003r, 1000L).start();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) EvaluateDescriptionActivity.this).T).setMessage(msg).show();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.X.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        Http.with(this.T).hideSuccessMessage().hideOtherStatusMessage().setObservable(((e0.a) Http.getApiService(e0.a.class)).s()).setDataListener(new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("评价说明");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_pub_description;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.X = (Button) findViewById(R.id.bt_start);
        this.W = (SmartWebView) findViewById(2131298609);
        Q().setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
        if (v5.getId() != 2131296646) {
            return;
        }
        startActivity(getIntent().setClass(this.T, EvaluateActivity.class));
        finish();
    }
}
