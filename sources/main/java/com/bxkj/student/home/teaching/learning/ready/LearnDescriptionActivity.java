package com.bxkj.student.home.teaching.learning.ready;

import android.os.Bundle;
import android.text.TextUtils;
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
import com.bxkj.student.home.teaching.learning.LearnHomeListActivity;
import com.bxkj.student.home.teaching.learning.m;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class LearnDescriptionActivity extends BaseActivity {
    private Button W;
    private SmartWebView X;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            LearnDescriptionActivity.this.Q().setVisibility(0);
            LearnDescriptionActivity.this.X.h(JsonParse.getString(data, "content"));
            LearnDescriptionActivity.this.X.getWebView().getSettings().setTextSize(WebSettings.TextSize.LARGEST);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Map f18822a;

            a(final Map val$data) {
                this.f18822a = val$data;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v5) {
                LearnDescriptionActivity.this.k0(this.f18822a);
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
        }

        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data, String msg) {
            super.netOnSuccess(data, msg);
            if (TextUtils.isEmpty(msg) || "null".equalsIgnoreCase(msg)) {
                LearnDescriptionActivity.this.k0(data);
            } else {
                new iOSOneButtonDialog(((BaseActivity) LearnDescriptionActivity.this).T).setMessage(msg).setButtonOnClickListener(new a(data)).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0(Map<String, Object> data) {
        startActivity(JsonParse.getInt(data, "data") == 1 ? getIntent().setClass(this.T, SelectLessonActivity.class) : getIntent().setClass(this.T, LearnHomeListActivity.class));
        finish();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.W.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        Http.with(this.T).setObservable(((m) Http.getApiService(m.class)).s()).setDataListener(new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("在线学习说明");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_pub_description;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (Button) findViewById(R.id.bt_start);
        this.X = (SmartWebView) findViewById(2131298609);
        this.W.setText("开始学习");
        Q().setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
        if (v5.getId() != 2131296646) {
            return;
        }
        Http.with(this.T).hideSuccessMessage().setObservable(((m) Http.getApiService(m.class)).q()).setDataListener(new b());
    }
}
