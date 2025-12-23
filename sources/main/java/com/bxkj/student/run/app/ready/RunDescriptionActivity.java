package com.bxkj.student.run.app.ready;

import android.content.Intent;
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
import com.bxkj.base.v2.common.ext.b0;
import com.bxkj.student.R;
import com.bxkj.student.run.app.exam.QuestionActivity;
import com.bxkj.student.run.app.face.FaceDetectExpActivity;
import com.bxkj.student.run.app.ready.RunRoleSetBean;
import com.umeng.analytics.AnalyticsConfig;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.n1;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class RunDescriptionActivity extends BaseActivity {
    private Button W;
    private SmartWebView X;
    private RunRoleSetBean.DataBean Y;
    private final int Z = 255;

    /* renamed from: a0, reason: collision with root package name */
    private final int f19931a0 = 170;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends HttpCallBack {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.student.run.app.ready.RunDescriptionActivity$a$a, reason: collision with other inner class name */
        class CountDownTimerC0268a extends CountDownTimer {
            CountDownTimerC0268a(long millisInFuture, long countDownInterval) {
                super(millisInFuture, countDownInterval);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                RunDescriptionActivity.this.W.setEnabled(true);
                RunDescriptionActivity.this.W.setText("开始跑步");
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                RunDescriptionActivity.this.W.setText("开始跑步(" + (millisUntilFinished / 1000) + "秒)");
            }
        }

        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            RunDescriptionActivity.this.Q().setVisibility(0);
            RunDescriptionActivity.this.X.h(JsonParse.getString(data, "data"));
            RunDescriptionActivity.this.X.getWebView().getSettings().setTextSize(WebSettings.TextSize.LARGEST);
            RunDescriptionActivity.this.W.setEnabled(false);
            new CountDownTimerC0268a(master.flame.danmaku.danmaku.model.android.d.f50003r, 1000L).start();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            Intent intent = RunDescriptionActivity.this.getIntent().setClass(((BaseActivity) RunDescriptionActivity.this).T, ThreeTwoOneActivity.class);
            intent.putExtra(AnalyticsConfig.RTD_START_TIME, JsonParse.getLong(data, AnalyticsConfig.RTD_START_TIME));
            RunDescriptionActivity.this.startActivity(intent);
            RunDescriptionActivity.this.overridePendingTransition(2130771987, 2130771986);
            RunDescriptionActivity.this.finish();
        }
    }

    private void l0() {
        if (this.Y.getIsStartFace() == 1) {
            b0.x(this.U, "人脸识别", new Function0() { // from class: com.bxkj.student.run.app.ready.a
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    n1 m02;
                    m02 = RunDescriptionActivity.this.m0();
                    return m02;
                }
            });
        } else {
            n0();
        }
    }

    private void n0() {
        Http.with(this.T).hideSuccessMessage().setObservable(((com.bxkj.student.run.app.a) Http.getApiService(com.bxkj.student.run.app.a.class)).f(this.Y.getIdentify())).setDataListener(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.W.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("跑步说明");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ n1 m0() {
        Intent intent = getIntent().setClass(this.T, FaceDetectExpActivity.class);
        intent.putExtra("identify", this.Y.getIdentify());
        startActivityForResult(intent, 255);
        overridePendingTransition(2130771987, 2130771986);
        return null;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_pub_description;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("dataBean")) {
            this.Y = (RunRoleSetBean.DataBean) getIntent().getParcelableExtra("dataBean");
        }
        Http.with(this.T).setObservable(((com.bxkj.student.run.app.a) Http.getApiService(com.bxkj.student.run.app.a.class)).e(this.Y.getRunType())).setDataListener(new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (Button) findViewById(R.id.bt_start);
        this.X = (SmartWebView) findViewById(2131298609);
        this.W.setText("开始跑步");
        Q().setVisibility(8);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 255 && resultCode == -1) {
            n0();
            return;
        }
        if (requestCode == 255 && resultCode == 170) {
            Intent intent = getIntent().setClass(this.T, FaceDetectExpActivity.class);
            intent.putExtra("identify", this.Y.getIdentify());
            startActivityForResult(intent, 255);
            overridePendingTransition(2130771987, 2130771986);
            return;
        }
        if (requestCode == 170 && resultCode == -1) {
            l0();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
        if (v5.getId() != 2131296646) {
            return;
        }
        if (this.Y.getIsQuestion() == 1) {
            startActivityForResult(getIntent().setClass(this.T, QuestionActivity.class), 170);
            overridePendingTransition(2130771987, 2130771986);
        } else {
            l0();
        }
    }
}
