package com.bxkj.student.home.teaching.exam;

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
import com.bxkj.student.home.teaching.exam.formal.ExamActivity;
import com.bxkj.student.home.teaching.exam.mock.NewExamActivity;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class ExamDescriptionActivity extends BaseActivity {
    private Button W;
    private SmartWebView X;
    private int Y = 0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends HttpCallBack {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.student.home.teaching.exam.ExamDescriptionActivity$a$a, reason: collision with other inner class name */
        class CountDownTimerC0219a extends CountDownTimer {
            CountDownTimerC0219a(long millisInFuture, long countDownInterval) {
                super(millisInFuture, countDownInterval);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                ExamDescriptionActivity.this.W.setEnabled(true);
                ExamDescriptionActivity.this.W.setText("开始考试");
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                ExamDescriptionActivity.this.W.setText("开始考试(" + (millisUntilFinished / 1000) + "秒)");
            }
        }

        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ExamDescriptionActivity.this.Q().setVisibility(0);
            ExamDescriptionActivity.this.X.h(JsonParse.getString(data, "data"));
            ExamDescriptionActivity.this.X.getWebView().getSettings().setTextSize(WebSettings.TextSize.LARGEST);
            ExamDescriptionActivity.this.W.setEnabled(false);
            new CountDownTimerC0219a(master.flame.danmaku.danmaku.model.android.d.f50003r, 1000L).start();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) ExamDescriptionActivity.this).T).setMessage(msg).show();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            if (JsonParse.getInt(data, "isMoreCourses") == 0) {
                int i6 = JsonParse.getInt(data, "courseNum");
                ExamDescriptionActivity examDescriptionActivity = ExamDescriptionActivity.this;
                examDescriptionActivity.startActivity(examDescriptionActivity.getIntent().putExtra("courseNum", i6).setClass(((BaseActivity) ExamDescriptionActivity.this).T, SelectExamLessonActivity.class));
            } else if (ExamDescriptionActivity.this.Y == 0) {
                ExamDescriptionActivity examDescriptionActivity2 = ExamDescriptionActivity.this;
                examDescriptionActivity2.startActivity(examDescriptionActivity2.getIntent().setClass(((BaseActivity) ExamDescriptionActivity.this).T, ExamActivity.class));
            } else {
                ExamDescriptionActivity examDescriptionActivity3 = ExamDescriptionActivity.this;
                examDescriptionActivity3.startActivity(examDescriptionActivity3.getIntent().setClass(((BaseActivity) ExamDescriptionActivity.this).T, NewExamActivity.class));
            }
            ExamDescriptionActivity.this.finish();
        }
    }

    private void o0() {
        Http.with(this.T).setObservable(((e0.a) Http.getApiService(e0.a.class)).d1(getIntent().getStringExtra("stuTeacherCurriculumId"), this.Y)).setDataListener(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.W.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_pub_description;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("onlineType")) {
            this.Y = getIntent().getIntExtra("onlineType", 0);
        }
        Http.with(this.T).hideSuccessMessage().hideOtherStatusMessage().setObservable(((e0.a) Http.getApiService(e0.a.class)).H(this.Y)).setDataListener(new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("title")) {
            setTitle(getIntent().getStringExtra("title") + "说明");
            return;
        }
        setTitle("考试说明");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (Button) findViewById(R.id.bt_start);
        this.X = (SmartWebView) findViewById(2131298609);
        Q().setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
        if (v5.getId() != 2131296646) {
            return;
        }
        o0();
    }
}
