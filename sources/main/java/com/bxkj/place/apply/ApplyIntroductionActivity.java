package com.bxkj.place.apply;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.place.R;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class ApplyIntroductionActivity extends BaseActivity {
    private TextView W;
    private int X;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ApplyIntroductionActivity.this.W.setText(JsonParse.getString(data, "data"));
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_place_apply_description;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        Http.with(this.T).setObservable(((d0.b) Http.getApiService(d0.b.class)).e(this.X)).setDataListener(new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (TextView) findViewById(R.id.tv_description);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        String str;
        if (getIntent().hasExtra("appointType")) {
            this.X = getIntent().getIntExtra("appointType", 1);
        }
        if (this.X == 2) {
            str = "申请场地说明";
        } else {
            str = "预约场地说明";
        }
        setTitle(str);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
