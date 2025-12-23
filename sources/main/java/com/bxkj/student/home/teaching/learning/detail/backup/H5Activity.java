package com.bxkj.student.home.teaching.learning.detail.backup;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.R;
import com.umeng.socialize.media.BaseMediaObject;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class H5Activity extends BaseActivity {
    private String W;
    private String X;
    private SmartWebView Y;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            H5Activity.this.Q().setVisibility(0);
            String string = JsonParse.getString(data, "content");
            HashMap hashMap = new HashMap();
            hashMap.put(JThirdPlatFormInterface.KEY_TOKEN, LoginUser.getLoginUser().getToken());
            hashMap.put("channel", "Android");
            hashMap.put("version", String.valueOf(H5Activity.this.n0()));
            hashMap.put("type", LoginUser.getLoginUser().getUserType() == 2 ? "1" : "0");
            H5Activity.this.Y.getWebView().loadUrl(string, hashMap);
            H5Activity.this.l0(data, string);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int n0() {
        try {
            return getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
        } catch (Exception e6) {
            e6.printStackTrace();
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0(Map<String, Object> data, String url) {
        UMWeb uMWeb = new UMWeb(url);
        uMWeb.setTitle(this.W);
        String string = JsonParse.getString(data, "indexImg");
        if (TextUtils.isEmpty(string)) {
            string = "http://m.boxkj.com/resources/wechat/images/xiaowei.png";
        }
        uMWeb.setThumb(new UMImage(this.T, string));
        uMWeb.setDescription(JsonParse.getString(data, "synopsis"));
        k0(JsonParse.getString(data, "detailId"), JsonParse.getInt(data, "isLike"), JsonParse.getInt(data, "isCollection"), JsonParse.getInt(data, "duration"), JsonParse.getInt(data, "popTime"), JsonParse.getInt(data, "hasQuestion"), JsonParse.getInt(data, "isComplete"), JsonParse.getInt(data, "isOk"), JsonParse.getInt(data, "opreateFlag"), JsonParse.getInt(data, "valType"), uMWeb);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("在线学习");
    }

    public void m0() {
        Http.with(this.T).setObservable(((com.bxkj.student.home.teaching.learning.m) Http.getApiService(com.bxkj.student.home.teaching.learning.m.class)).k(LoginUser.getLoginUser().getUserId(), this.X)).setDataListener(new a());
    }

    private void k0(String detailId, int isLike, int isCollection, int duration, int popTime, int hasQuestion, int isComplete, int isOk, int opreateFlag, int valType, BaseMediaObject baseMediaObject) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        BottomFragment bottomFragment = new BottomFragment();
        Bundle bundle = new Bundle();
        bundle.putString("id", this.X);
        bundle.putString("detailId", detailId);
        bundle.putInt("isLike", isLike);
        bundle.putInt("isCollection", isCollection);
        bundle.putInt("duration", duration);
        bundle.putInt("popTime", popTime);
        bundle.putInt("hasQuestion", hasQuestion);
        bundle.putInt("isComplete", isComplete);
        bundle.putInt("isOk", isOk);
        bundle.putInt("opreateFlag", opreateFlag);
        bundle.putInt("valType", valType);
        bottomFragment.setArguments(bundle);
        bottomFragment.s0(baseMediaObject);
        beginTransaction.add(R.id.fl_bottom, bottomFragment);
        beginTransaction.commit();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_learn_h5;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        Q().setVisibility(8);
        if (getIntent().hasExtra("id")) {
            this.X = getIntent().getStringExtra("id");
        }
        if (getIntent().hasExtra("title")) {
            this.W = getIntent().getStringExtra("title");
        }
        m0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.Y = (SmartWebView) findViewById(2131298538);
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
