package com.bxkj.student.home.teaching.healthstatus;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.view.MyGridView;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.photoview.ImagePagerActivity;
import com.bxkj.student.R;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class ApplyHealthStatusDetailActivity extends BaseActivity {
    private List<String> F0;
    private cn.bluemobi.dylan.base.adapter.common.abslistview.a<String> G0;
    private TextView W;
    private TextView X;
    private TextView Y;
    private TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    private TextView f18279a0;

    /* renamed from: b0, reason: collision with root package name */
    private MyGridView f18280b0;

    /* renamed from: c0, reason: collision with root package name */
    private TextView f18281c0;

    /* renamed from: k0, reason: collision with root package name */
    private TextView f18282k0;

    /* renamed from: p0, reason: collision with root package name */
    private String f18283p0;

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
            ApplyHealthStatusDetailActivity.this.Q().setVisibility(0);
            ApplyHealthStatusDetailActivity.this.W.setText("姓名：" + JsonParse.getString(data, "applyerName"));
            ApplyHealthStatusDetailActivity.this.X.setText("学号：" + JsonParse.getString(data, "userNum"));
            ApplyHealthStatusDetailActivity.this.Z.setText("类型：" + JsonParse.getString(data, "type"));
            ApplyHealthStatusDetailActivity.this.f18279a0.setText("原因：" + JsonParse.getString(data, "applyMemo"));
            ApplyHealthStatusDetailActivity.this.f18282k0.setText("状态：" + JsonParse.getString(data, NotificationCompat.CATEGORY_STATUS));
            ApplyHealthStatusDetailActivity.this.f18281c0.setText("时间：" + JsonParse.getString(data, "applyDate"));
            ApplyHealthStatusDetailActivity.this.F0 = JsonParse.getList(data, "imgs", String.class);
            ApplyHealthStatusDetailActivity.this.G0.c(ApplyHealthStatusDetailActivity.this.F0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r0(AdapterView adapterView, View view, int i6, long j6) {
        s0((String[]) this.F0.toArray(new String[this.F0.size()]), i6);
    }

    private void s0(String[] arr, int position) {
        Intent intent = new Intent(this.T, (Class<?>) ImagePagerActivity.class);
        intent.putExtra(ImagePagerActivity.T, arr);
        intent.putExtra(ImagePagerActivity.S, position);
        startActivity(intent);
        overridePendingTransition(2130772094, 2130772095);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.f18280b0.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bxkj.student.home.teaching.healthstatus.a
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i6, long j6) {
                ApplyHealthStatusDetailActivity.this.r0(adapterView, view, i6, j6);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("申请状态详情");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_apply_mc_detail;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("id")) {
            this.f18283p0 = getIntent().getStringExtra("id");
        }
        a aVar = new a(this.T, R.layout.item_for_lost_img, this.F0);
        this.G0 = aVar;
        this.f18280b0.setAdapter((ListAdapter) aVar);
        Http.with(this.T).setObservable(((e0.a) Http.getApiService(e0.a.class)).x(this.f18283p0)).setDataListener(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (TextView) findViewById(2131298986);
        this.X = (TextView) findViewById(2131298997);
        this.Y = (TextView) findViewById(R.id.tv_team);
        this.Z = (TextView) findViewById(2131299171);
        this.f18279a0 = (TextView) findViewById(R.id.tv_reason);
        this.f18280b0 = (MyGridView) findViewById(R.id.gv_img);
        this.f18281c0 = (TextView) findViewById(2131299158);
        this.f18282k0 = (TextView) findViewById(2131299116);
        this.Y.setVisibility(8);
        Q().setVisibility(4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
