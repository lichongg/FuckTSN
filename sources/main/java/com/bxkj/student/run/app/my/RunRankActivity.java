package com.bxkj.student.run.app.my;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.R;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class RunRankActivity extends BaseActivity {
    private TextView W;
    private TextView X;
    private TextView Y;
    private TextView Z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            RunRankActivity.this.W.setText(JsonParse.getString(data, "clazzRank"));
            RunRankActivity.this.X.setText(JsonParse.getString(data, "majorRank"));
            RunRankActivity.this.Y.setText(JsonParse.getString(data, "deptRank"));
            RunRankActivity.this.Z.setText(JsonParse.getString(data, "schoolRank"));
        }
    }

    private void l0() {
        Http.with(this.T).setObservable(((com.bxkj.student.run.app.a) Http.getApiService(com.bxkj.student.run.app.a.class)).c(LoginUser.getLoginUser().getUserId())).setDataListener(new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("跑步排名");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_run_rank;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        l0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (TextView) findViewById(R.id.tv_run_class_rank);
        this.X = (TextView) findViewById(R.id.tv_run_major_rank);
        this.Y = (TextView) findViewById(R.id.tv_run_department_rank);
        this.Z = (TextView) findViewById(R.id.tv_run_school_rank);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
