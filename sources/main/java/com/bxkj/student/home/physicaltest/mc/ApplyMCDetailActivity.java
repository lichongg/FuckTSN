package com.bxkj.student.home.physicaltest.mc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.view.MyGridView;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.photoview.ImagePagerActivity;
import com.bxkj.student.R;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class ApplyMCDetailActivity extends BaseActivity {
    private TextView F0;
    private String G0;
    private List<String> H0;
    private cn.bluemobi.dylan.base.adapter.common.abslistview.a<String> I0;
    private TextView W;
    private TextView X;
    private TextView Y;
    private TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    private TextView f17960a0;

    /* renamed from: b0, reason: collision with root package name */
    private MyGridView f17961b0;

    /* renamed from: c0, reason: collision with root package name */
    private TextView f17962c0;

    /* renamed from: k0, reason: collision with root package name */
    private TextView f17963k0;

    /* renamed from: p0, reason: collision with root package name */
    private TextView f17964p0;

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
            ApplyMCDetailActivity.this.Q().setVisibility(0);
            ApplyMCDetailActivity.this.W.setText("姓名：" + JsonParse.getString(data, "userName"));
            ApplyMCDetailActivity.this.X.setText("学号：" + JsonParse.getString(data, "userNum"));
            ApplyMCDetailActivity.this.Y.setText("学期：" + JsonParse.getString(data, "year"));
            ApplyMCDetailActivity.this.Z.setText("类型：" + JsonParse.getString(data, "meaStatusName"));
            ApplyMCDetailActivity.this.f17960a0.setText("原因：" + JsonParse.getString(data, "applyMemo"));
            ApplyMCDetailActivity.this.f17963k0.setText("状态：" + JsonParse.getString(data, NotificationCompat.CATEGORY_STATUS));
            ApplyMCDetailActivity.this.f17962c0.setText("时间：" + JsonParse.getString(data, "applyDate"));
            String string = JsonParse.getString(data, "auditMemo");
            if (TextUtils.isEmpty(string)) {
                ApplyMCDetailActivity.this.f17964p0.setVisibility(8);
            } else {
                ApplyMCDetailActivity.this.f17964p0.setVisibility(0);
                ApplyMCDetailActivity.this.f17964p0.setText("审批意见：" + string);
            }
            ApplyMCDetailActivity.this.H0 = JsonParse.getList(data, "imgs", String.class);
            ApplyMCDetailActivity.this.I0.c(ApplyMCDetailActivity.this.H0);
            if (JsonParse.getInt(data, "statusCode") == 0) {
                ApplyMCDetailActivity.this.F0.setVisibility(0);
            } else {
                ApplyMCDetailActivity.this.F0.setVisibility(8);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ApplyMCDetailActivity.this.y0();
            ApplyMcListActivity applyMcListActivity = (ApplyMcListActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(ApplyMcListActivity.class);
            if (applyMcListActivity != null) {
                applyMcListActivity.m0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B0(View view) {
        new iOSTwoButtonDialog(this.T).setMessage("确定要取消申请吗？").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.physicaltest.mc.c
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public final void buttonRightOnClick() {
                ApplyMCDetailActivity.this.A0();
            }
        }).show();
    }

    private void C0(String[] arr, int position) {
        Intent intent = new Intent(this.T, (Class<?>) ImagePagerActivity.class);
        intent.putExtra(ImagePagerActivity.T, arr);
        intent.putExtra(ImagePagerActivity.S, position);
        startActivity(intent);
        overridePendingTransition(2130772094, 2130772095);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public void A0() {
        Http.with(this.T).setObservable(((e0.a) Http.getApiService(e0.a.class)).y1(this.G0)).setDataListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0() {
        Http.with(this.T).setObservable(((e0.a) Http.getApiService(e0.a.class)).w(this.G0)).setDataListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z0(AdapterView adapterView, View view, int i6, long j6) {
        C0((String[]) this.H0.toArray(new String[this.H0.size()]), i6);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.f17961b0.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bxkj.student.home.physicaltest.mc.d
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i6, long j6) {
                ApplyMCDetailActivity.this.z0(adapterView, view, i6, j6);
            }
        });
        this.F0.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.physicaltest.mc.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ApplyMCDetailActivity.this.B0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("申请免测详情");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_apply_mc_detail;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("meaNonStuApplyId")) {
            this.G0 = getIntent().getStringExtra("meaNonStuApplyId");
        }
        a aVar = new a(this.T, R.layout.item_for_lost_img, this.H0);
        this.I0 = aVar;
        this.f17961b0.setAdapter((ListAdapter) aVar);
        y0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (TextView) findViewById(2131298986);
        this.X = (TextView) findViewById(2131298997);
        this.Y = (TextView) findViewById(R.id.tv_team);
        this.Z = (TextView) findViewById(2131299171);
        this.f17960a0 = (TextView) findViewById(R.id.tv_reason);
        this.f17961b0 = (MyGridView) findViewById(R.id.gv_img);
        this.f17962c0 = (TextView) findViewById(2131299158);
        this.f17963k0 = (TextView) findViewById(2131299116);
        this.f17964p0 = (TextView) findViewById(R.id.tv_approval_comments);
        this.F0 = (TextView) findViewById(2131296591);
        Q().setVisibility(4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
