package com.bxkj.student.home.physicaltest.apply;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.MyGridView;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.R;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class ApplyTestScoreDetailActivity extends BaseActivity {
    private TextView F0;
    private TextView G0;
    private TextView W;
    private TextView X;
    private TextView Y;
    private TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    private TextView f17925a0;

    /* renamed from: b0, reason: collision with root package name */
    private TextView f17926b0;

    /* renamed from: c0, reason: collision with root package name */
    private TextView f17927c0;

    /* renamed from: k0, reason: collision with root package name */
    private MyGridView f17928k0;

    /* renamed from: p0, reason: collision with root package name */
    private TextView f17929p0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ApplyTestScoreDetailActivity.this.Q().setVisibility(0);
            ApplyTestScoreDetailActivity.this.W.setText("姓\u3000\u3000名：" + JsonParse.getString(data, "userName"));
            ApplyTestScoreDetailActivity.this.X.setText("学\u3000\u3000号：" + JsonParse.getString(data, "userNum"));
            ApplyTestScoreDetailActivity.this.f17927c0.setText("原\u3000\u3000因：" + JsonParse.getString(data, "applyReason"));
            ApplyTestScoreDetailActivity.this.F0.setText("状\u3000\u3000态：" + JsonParse.getString(data, NotificationCompat.CATEGORY_STATUS));
            ApplyTestScoreDetailActivity.this.G0.setText("时\u3000\u3000间：" + JsonParse.getString(data, "createTime"));
            ApplyTestScoreDetailActivity.this.Y.setText("学\u3000\u3000年：" + JsonParse.getString(data, "year"));
            ApplyTestScoreDetailActivity.this.Z.setText("项\u3000\u3000目：" + JsonParse.getString(data, "examName"));
            ApplyTestScoreDetailActivity.this.f17925a0.setText("原始成绩：" + JsonParse.getString(data, "rawScores"));
            ApplyTestScoreDetailActivity.this.f17926b0.setText("申诉成绩：" + JsonParse.getString(data, "complaintResults"));
            ApplyTestScoreDetailActivity.this.f17929p0.setText("联系电话：" + JsonParse.getString(data, "userPhone"));
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("体测成绩申诉详情");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_apply_test_score_detail;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("id")) {
            Http.with(this.T).setObservable(((e0.a) Http.getApiService(e0.a.class)).B0(getIntent().getStringExtra("id"))).setDataListener(new a());
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (TextView) findViewById(2131298986);
        this.X = (TextView) findViewById(2131298997);
        this.Y = (TextView) findViewById(R.id.tv_team);
        this.Z = (TextView) findViewById(2131299053);
        this.f17925a0 = (TextView) findViewById(2131299093);
        this.f17926b0 = (TextView) findViewById(R.id.tv_score_apply);
        this.f17927c0 = (TextView) findViewById(R.id.tv_reason);
        this.f17928k0 = (MyGridView) findViewById(R.id.gv_img);
        this.f17929p0 = (TextView) findViewById(2131299035);
        this.F0 = (TextView) findViewById(2131299116);
        this.G0 = (TextView) findViewById(2131299158);
        Q().setVisibility(4);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
