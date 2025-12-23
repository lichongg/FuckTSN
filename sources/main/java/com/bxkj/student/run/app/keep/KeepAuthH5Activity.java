package com.bxkj.student.run.app.keep;

import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.R;
import com.orhanobut.logger.j;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class KeepAuthH5Activity extends BaseActivity {

    @NotNull
    private final String W = "https://open.gotokeep.com/v1/oauth2/authorize?client_id=6005515ea85bc94dde5e3df7&redirect_uri=https://keep.boxkj.com/redirect&response_type=code&state=STATE";
    private SmartWebView X;

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        SmartWebView smartWebView = this.X;
        SmartWebView smartWebView2 = null;
        if (smartWebView == null) {
            g0.S("smartWebView");
            smartWebView = null;
        }
        WebView webView = smartWebView.getWebView();
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        SmartWebView smartWebView3 = this.X;
        if (smartWebView3 == null) {
            g0.S("smartWebView");
        } else {
            smartWebView2 = smartWebView3;
        }
        smartWebView2.j(this.W);
        webView.addJavascriptInterface(this, "keep");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("绑定Keep账号");
    }

    @JavascriptInterface
    public final void getKeepToken(@NotNull String token) {
        g0.p(token, "token");
        j.d("token=" + token, new Object[0]);
        LoginUser.getLoginUser().setKeepToken(token);
        new iOSOneButtonDialog(this.T).setMessage("绑定keep账号成功！").setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.keep.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                KeepAuthH5Activity.i0(KeepAuthH5Activity.this, view);
            }
        }).show();
    }

    @NotNull
    public final String j0() {
        return this.W;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(KeepAuthH5Activity keepAuthH5Activity, View view) {
        keepAuthH5Activity.finish();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_keep_auth_h5;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(@Nullable Bundle bundle) {
        View findViewById = findViewById(2131298538);
        g0.o(findViewById, "findViewById(...)");
        this.X = (SmartWebView) findViewById;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
    }
}
