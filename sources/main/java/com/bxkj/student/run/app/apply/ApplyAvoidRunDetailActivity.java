package com.bxkj.student.run.app.apply;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.view.MyGridView;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.photoview.ImagePagerActivity;
import com.bxkj.student.R;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class ApplyAvoidRunDetailActivity extends BaseActivity {
    private List<String> F0;
    private cn.bluemobi.dylan.base.adapter.common.abslistview.a<String> G0;
    private TextView W;
    private TextView X;
    private TextView Y;
    private TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    private TextView f19762a0;

    /* renamed from: b0, reason: collision with root package name */
    private MyGridView f19763b0;

    /* renamed from: c0, reason: collision with root package name */
    private TextView f19764c0;

    /* renamed from: k0, reason: collision with root package name */
    private TextView f19765k0;

    /* renamed from: p0, reason: collision with root package name */
    private String f19766p0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends cn.bluemobi.dylan.base.adapter.common.abslistview.a<String> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(ViewHolder holder, String s5) {
            holder.s(R.id.iv_img, s5);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ApplyAvoidRunDetailActivity.this.Q().setVisibility(0);
            ApplyAvoidRunDetailActivity.this.W.setText("姓名：" + JsonParse.getString(data, CommonNetImpl.NAME));
            ApplyAvoidRunDetailActivity.this.X.setText("学号：" + JsonParse.getString(data, "userNum"));
            ApplyAvoidRunDetailActivity.this.Y.setText("学期：" + JsonParse.getString(data, "sysTermName"));
            ApplyAvoidRunDetailActivity.this.f19762a0.setText("原因：" + JsonParse.getString(data, "applyReason"));
            ApplyAvoidRunDetailActivity.this.f19765k0.setText("状态：" + JsonParse.getString(data, "avoidRunningState"));
            ApplyAvoidRunDetailActivity.this.f19764c0.setText("时间：" + JsonParse.getString(data, "applyTime"));
            ApplyAvoidRunDetailActivity.this.F0 = JsonParse.getList(data, "imgs", String.class);
            ApplyAvoidRunDetailActivity.this.G0.c(ApplyAvoidRunDetailActivity.this.F0);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements AdapterView.OnItemClickListener {
        c() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String[] strArr = new String[ApplyAvoidRunDetailActivity.this.F0.size()];
            ApplyAvoidRunDetailActivity applyAvoidRunDetailActivity = ApplyAvoidRunDetailActivity.this;
            applyAvoidRunDetailActivity.r0((String[]) applyAvoidRunDetailActivity.F0.toArray(strArr), position);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0(String[] arr, int position) {
        Intent intent = new Intent(this.T, (Class<?>) ImagePagerActivity.class);
        intent.putExtra(ImagePagerActivity.T, arr);
        intent.putExtra(ImagePagerActivity.S, position);
        startActivity(intent);
        overridePendingTransition(2130772094, 2130772095);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.f19763b0.setOnItemClickListener(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("申请免跑详情");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_apply_mc_detail;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("id")) {
            this.f19766p0 = getIntent().getStringExtra("id");
        }
        a aVar = new a(this.T, R.layout.item_for_lost_img, this.F0);
        this.G0 = aVar;
        this.f19763b0.setAdapter((ListAdapter) aVar);
        Http.with(this.T).setObservable(((com.bxkj.student.run.app.a) Http.getApiService(com.bxkj.student.run.app.a.class)).o(this.f19766p0)).setDataListener(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (TextView) findViewById(2131298986);
        this.X = (TextView) findViewById(2131298997);
        this.Y = (TextView) findViewById(R.id.tv_team);
        this.Z = (TextView) findViewById(2131299171);
        this.f19762a0 = (TextView) findViewById(R.id.tv_reason);
        this.f19763b0 = (MyGridView) findViewById(R.id.gv_img);
        this.f19764c0 = (TextView) findViewById(2131299158);
        this.f19765k0 = (TextView) findViewById(2131299116);
        this.Z.setVisibility(8);
        Q().setVisibility(4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
