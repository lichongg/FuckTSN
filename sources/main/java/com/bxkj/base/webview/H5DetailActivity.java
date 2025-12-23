package com.bxkj.base.webview;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.JavascriptInterface;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.bxkj.base.R;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.d;
import com.orhanobut.logger.j;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class H5DetailActivity extends BaseActivity {
    public static boolean Y;
    private SmartWebView W;
    private String X;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements BaseActivity.c {
        a() {
        }

        @Override // cn.bluemobi.dylan.base.BaseActivity.c
        public void onClick() {
            H5DetailActivity.this.r1();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b {
        b() {
        }

        @JavascriptInterface
        public void jsinvoke(String str) {
            H5DetailActivity.this.startActivity(new Intent().setClassName(d.f17843b, "com.bxkj.student.life.mall.GoodsDetailActivity").putExtra("goodsId", str));
        }
    }

    static {
        StubApp.interface11(14907);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i6, KeyEvent keyEvent) {
        if (i6 == 4) {
            if (this.W.getWebView().canGoBack()) {
                this.W.getWebView().goBack();
                return true;
            }
            if (cn.bluemobi.dylan.base.utils.a.n().m() != null && cn.bluemobi.dylan.base.utils.a.n().m().size() == 1) {
                startActivity(new Intent().setClassName(d.f17843b, "com.bxkj.student.MainActivity"));
                finish();
                return true;
            }
        }
        return super.onKeyDown(i6, keyEvent);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        Y = false;
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        Y = true;
        super.onResume();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_h5;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        this.X = "http://www.boxkj.com";
        String stringExtra = getIntent().hasExtra("title") ? getIntent().getStringExtra("title") : "消息详情";
        if (getIntent().hasExtra("url")) {
            this.X = getIntent().getStringExtra("url");
            j.c("smartWebView.url=" + this.X);
            this.W.j(this.X);
        } else if (getIntent().hasExtra("content")) {
            String stringExtra2 = getIntent().getStringExtra("content");
            j.c("smartWebView.content=" + stringExtra2);
            this.W.h(stringExtra2);
        }
        this.W.getWebView().addJavascriptInterface(new b(), FaceEnvironment.OS);
        setTitle(stringExtra);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        Y(new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle bundle) {
        this.W = (SmartWebView) findViewById(R.id.smartWebView);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    /* renamed from: onBackPressed */
    public void r1() {
        if (this.W.getWebView().canGoBack()) {
            this.W.getWebView().goBack();
            return;
        }
        if (cn.bluemobi.dylan.base.utils.a.n().m().size() != 1) {
            super.r1();
            return;
        }
        if (u.b0(LoginUser.getLoginUser().getSchoolName()) || u.b0(LoginUser.getLoginUser().getServerUrl())) {
            startActivity(new Intent().setClassName(d.f17843b, "com.bxkj.student.splash.SelectSchoolActivity"));
        } else {
            startActivity(new Intent().setClassName(d.f17843b, "com.bxkj.student.MainActivity"));
            finish();
        }
        finish();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        ViewParent parent;
        SmartWebView smartWebView = this.W;
        if (smartWebView != null && (parent = smartWebView.getParent()) != null) {
            ((ViewGroup) parent).removeView(this.W);
        }
        this.W.getWebView().stopLoading();
        this.W.getWebView().getSettings().setJavaScriptEnabled(false);
        this.W.getWebView().clearHistory();
        this.W.removeAllViews();
        this.W.getWebView().destroy();
        super.onDestroy();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
