package com.bxkj.student.home.teaching.leave.recorder;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class LeaveRecordListActivity extends BaseActivity {
    private EmptyRecyclerView W;
    private TextView X;
    private List<Map<String, Object>> Y = new ArrayList();
    private String Z;

    /* renamed from: a0, reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f18866a0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.J(R.id.tv_week, "周数：" + JsonParse.getString(stringObjectMap, "week"));
            holder.J(2131299116, "状态：" + JsonParse.getString(stringObjectMap, NotificationCompat.CATEGORY_STATUS));
            holder.J(R.id.tv_teacher, "教师：" + JsonParse.getString(stringObjectMap, "auditorName"));
            holder.J(R.id.tv_lessen_name, "课程：" + JsonParse.getString(stringObjectMap, "teacherCurriculumName"));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            LeaveRecordListActivity.this.Y = JsonParse.getList(data, "data");
            LeaveRecordListActivity.this.f18866a0.g(LeaveRecordListActivity.this.Y);
        }
    }

    private void l0() {
        Http.with(this.T).setLoadingMessage("加载中...").setObservable(((e0.a) Http.getApiService(e0.a.class)).A(this.Z)).setDataListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(ViewGroup viewGroup, View view, Object obj, int i6) {
        startActivity(new Intent(this.T, (Class<?>) LeaveRecordDetailActivity.class).putExtra("id", JsonParse.getString(this.f18866a0.getItem(i6), "id")));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.f18866a0.k(new cn.bluemobi.dylan.base.adapter.common.recyclerview.b() { // from class: com.bxkj.student.home.teaching.leave.recorder.b
            @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
            public final void a(ViewGroup viewGroup, View view, Object obj, int i6) {
                LeaveRecordListActivity.this.m0(viewGroup, view, obj, i6);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("请假记录列表");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return 2131493639;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("id")) {
            this.Z = getIntent().getStringExtra("id");
        }
        this.W.setLayoutManager(new LinearLayoutManager(this.T));
        a aVar = new a(this.T, R.layout.item_for_leave_record, this.Y);
        this.f18866a0 = aVar;
        this.W.setAdapter(aVar);
        this.W.setEmptyView(this.X);
        l0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (EmptyRecyclerView) findViewById(2131298351);
        this.X = (TextView) findViewById(2131298892);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
