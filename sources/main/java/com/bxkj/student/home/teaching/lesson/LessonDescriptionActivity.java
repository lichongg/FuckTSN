package com.bxkj.student.home.teaching.lesson;

import android.content.Intent;
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
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.R;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class LessonDescriptionActivity extends BaseActivity {
    private SmartWebView W;
    private Button X;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends HttpCallBack {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.student.home.teaching.lesson.LessonDescriptionActivity$a$a, reason: collision with other inner class name */
        class CountDownTimerC0231a extends CountDownTimer {
            CountDownTimerC0231a(long millisInFuture, long countDownInterval) {
                super(millisInFuture, countDownInterval);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                LessonDescriptionActivity.this.X.setEnabled(true);
                LessonDescriptionActivity.this.X.setText("开始选" + LoginUser.getLoginUser().getXuanAfterLabelName());
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                LessonDescriptionActivity.this.X.setText("开始选" + LoginUser.getLoginUser().getXuanAfterLabelName() + "(" + (millisUntilFinished / 1000) + "秒)");
            }
        }

        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            LessonDescriptionActivity.this.Q().setVisibility(0);
            LessonDescriptionActivity.this.W.i(JsonParse.getString(data, "content"), LoginUser.getLoginUser().getServerUrl());
            LessonDescriptionActivity.this.W.getWebView().getSettings().setTextSize(WebSettings.TextSize.LARGEST);
            LessonDescriptionActivity.this.X.setEnabled(false);
            new CountDownTimerC0231a(master.flame.danmaku.danmaku.model.android.d.f50003r, 1000L).start();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            LessonDescriptionActivity.this.X.setEnabled(false);
            new iOSOneButtonDialog(((BaseActivity) LessonDescriptionActivity.this).T).setMessage(msg).show();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            int i6 = JsonParse.getInt(data, "data");
            if (i6 == 0) {
                ((BaseActivity) LessonDescriptionActivity.this).T.startActivity(new Intent(((BaseActivity) LessonDescriptionActivity.this).T, (Class<?>) OnLineLessonActivity.class));
            } else if (i6 == 1) {
                ((BaseActivity) LessonDescriptionActivity.this).T.startActivity(new Intent(((BaseActivity) LessonDescriptionActivity.this).T, (Class<?>) ChooseTimeActivity.class));
            } else if (i6 == 2) {
                ((BaseActivity) LessonDescriptionActivity.this).T.startActivity(new Intent(((BaseActivity) LessonDescriptionActivity.this).T, (Class<?>) ChooseLessonActivity.class));
            } else {
                ((BaseActivity) LessonDescriptionActivity.this).T.startActivity(new Intent(((BaseActivity) LessonDescriptionActivity.this).T, (Class<?>) ChooseTimeActivity.class));
            }
            LessonDescriptionActivity.this.finish();
        }
    }

    private void s0() {
        Http.with(this.T).setObservable(((e0.a) Http.getApiService(e0.a.class)).E(LoginUser.getLoginUser().getUserId())).setDataListener(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.X.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        Http.with(this.T).hideOtherStatusMessage().setObservable(((e0.a) Http.getApiService(e0.a.class)).z("2", LoginUser.getLoginUser().getUserId())).setDataListener(new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("选" + LoginUser.getLoginUser().getXuanAfterLabelName() + "说明");
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
        this.X.setText("开始选" + LoginUser.getLoginUser().getXuanAfterLabelName());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
        if (v5.getId() != 2131296646) {
            return;
        }
        s0();
    }
}
