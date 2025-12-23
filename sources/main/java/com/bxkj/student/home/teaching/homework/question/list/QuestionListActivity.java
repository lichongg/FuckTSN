package com.bxkj.student.home.teaching.homework.question.list;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.collection.ArrayMap;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.util.i;
import com.bxkj.student.R;
import com.bxkj.student.home.teaching.homework.question.list.QuestionListAdapter;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class QuestionListActivity extends BaseActivity {
    private TextView W;
    private EmptyRecyclerView X;
    private TextView Y;
    private List<Map<String, Object>> Z = new ArrayList();

    /* renamed from: a0, reason: collision with root package name */
    private QuestionListAdapter f18388a0;

    /* renamed from: b0, reason: collision with root package name */
    private String f18389b0;

    /* renamed from: c0, reason: collision with root package name */
    private Integer f18390c0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends HttpCallBack {
        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            QuestionListActivity.this.Z = JsonParse.getList(data, "data");
            QuestionListActivity.this.f18388a0.g(QuestionListActivity.this.Z);
        }

        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data, String msg) {
            super.netOnSuccess(data, msg);
            if (TextUtils.isEmpty(msg)) {
                return;
            }
            QuestionListActivity.this.f18390c0 = Integer.valueOf(Integer.parseInt(msg));
            QuestionListActivity.this.W.setText("第" + msg + "周");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public void r0() {
        Http.with(this.T).hideSuccessMessage().setObservable(((com.bxkj.student.home.teaching.homework.a) Http.getApiService(com.bxkj.student.home.teaching.homework.a.class)).e(this.f18389b0, this.f18390c0)).setDataListener(new a());
    }

    private void q0() {
        final ArrayList arrayList = new ArrayList();
        for (int i6 = 1; i6 < 31; i6++) {
            ArrayMap arrayMap = new ArrayMap();
            arrayMap.put("id", Integer.valueOf(i6));
            arrayMap.put(CommonNetImpl.NAME, "第" + i6 + "周");
            arrayList.add(arrayMap);
        }
        this.W.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.homework.question.list.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QuestionListActivity.this.t0(arrayList, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0(List list, View view) {
        new i(this.T).h(this.W, "请选择周", list, "id", CommonNetImpl.NAME, new i.c() { // from class: com.bxkj.student.home.teaching.homework.question.list.c
            @Override // com.bxkj.base.util.i.c
            public final void a(String str, String str2, Map map) {
                QuestionListActivity.this.s0(str, str2, map);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.f18388a0.u(new QuestionListAdapter.b() { // from class: com.bxkj.student.home.teaching.homework.question.list.a
            @Override // com.bxkj.student.home.teaching.homework.question.list.QuestionListAdapter.b
            public final void onRefresh() {
                QuestionListActivity.this.r0();
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        this.X.setLayoutManager(new LinearLayoutManager(this.T));
        QuestionListAdapter questionListAdapter = new QuestionListAdapter(this.T, this.Z);
        this.f18388a0 = questionListAdapter;
        this.X.setAdapter(questionListAdapter);
        this.X.setEmptyView(this.Y);
        if (getIntent().hasExtra("teacherCurriculumId")) {
            this.f18389b0 = getIntent().getStringExtra("teacherCurriculumId");
            r0();
        }
        q0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("课后作业列表");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s0(String str, String str2, Map map) {
        int parseInt = Integer.parseInt(str);
        if (parseInt != 0) {
            this.f18390c0 = Integer.valueOf(parseInt);
            this.W.setText("第" + this.f18390c0 + "周");
            this.Z.clear();
            this.f18388a0.notifyDataSetChanged();
            r0();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_homewrok_list;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (TextView) findViewById(R.id.tv_week_type);
        this.X = (EmptyRecyclerView) findViewById(2131298351);
        this.Y = (TextView) findViewById(2131298892);
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        r0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
