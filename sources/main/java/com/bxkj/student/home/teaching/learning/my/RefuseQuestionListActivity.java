package com.bxkj.student.home.teaching.learning.my;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.home.teaching.learning.m;
import com.bxkj.student.home.teaching.learning.question.list.QuestionListAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import m2.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class RefuseQuestionListActivity extends BaseActivity {
    private SmartRefreshLayout W;
    private EmptyRecyclerView X;
    private TextView Y;

    /* renamed from: a0, reason: collision with root package name */
    private QuestionListAdapter f18727a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f18728b0;

    /* renamed from: c0, reason: collision with root package name */
    private String f18729c0;
    private List<Map<String, Object>> Z = new ArrayList();

    /* renamed from: k0, reason: collision with root package name */
    private int f18730k0 = 1;

    /* renamed from: p0, reason: collision with root package name */
    private int f18731p0 = 10;
    private int F0 = 0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements n2.e {
        a() {
        }

        @Override // n2.d
        public void a(h refreshlayout) {
            RefuseQuestionListActivity.this.f18730k0 = 1;
            RefuseQuestionListActivity.this.r0();
        }

        @Override // n2.b
        public void f(h refreshlayout) {
            int i6 = RefuseQuestionListActivity.this.F0 / RefuseQuestionListActivity.this.f18731p0;
            int i7 = RefuseQuestionListActivity.this.f18730k0;
            if (RefuseQuestionListActivity.this.F0 % RefuseQuestionListActivity.this.f18731p0 != 0) {
                i6++;
            }
            if (i7 >= i6) {
                RefuseQuestionListActivity.this.W.Q();
                RefuseQuestionListActivity.this.g0("没有了");
            } else {
                RefuseQuestionListActivity.this.f18730k0++;
                RefuseQuestionListActivity.this.r0();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            RefuseQuestionListActivity.this.F0 = JsonParse.getInt(data, "total");
            if (RefuseQuestionListActivity.this.f18730k0 == 1) {
                RefuseQuestionListActivity.this.Z.clear();
            }
            RefuseQuestionListActivity.this.Z.addAll(JsonParse.getList(data, "data"));
            RefuseQuestionListActivity.this.f18727a0.g(RefuseQuestionListActivity.this.Z);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (RefuseQuestionListActivity.this.W != null && RefuseQuestionListActivity.this.W.x()) {
                RefuseQuestionListActivity.this.W.Y();
            }
            if (RefuseQuestionListActivity.this.W != null && RefuseQuestionListActivity.this.W.isLoading()) {
                RefuseQuestionListActivity.this.W.Q();
            }
        }
    }

    private void s0() {
        this.W.D(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0(ViewGroup viewGroup, View view, Object obj, int i6) {
        this.f18727a0.v(i6);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.f18727a0.k(new cn.bluemobi.dylan.base.adapter.common.recyclerview.b() { // from class: com.bxkj.student.home.teaching.learning.my.g
            @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
            public final void a(ViewGroup viewGroup, View view, Object obj, int i6) {
                RefuseQuestionListActivity.this.t0(viewGroup, view, obj, i6);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("待处理作业列表");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0() {
        if (isDestroyed()) {
            return;
        }
        Http.with(this.T).hideLoadingDialog().setObservable(((m) Http.getApiService(m.class)).j(Integer.valueOf(this.f18731p0), Integer.valueOf(this.f18730k0))).setDataListener(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return 2131493640;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("type")) {
            this.f18728b0 = getIntent().getIntExtra("type", 0);
        }
        if (getIntent().hasExtra("resourceId")) {
            this.f18729c0 = getIntent().getStringExtra("resourceId");
        }
        this.X.setLayoutManager(new LinearLayoutManager(this.T));
        QuestionListAdapter questionListAdapter = new QuestionListAdapter(this.T, this.Z);
        this.f18727a0 = questionListAdapter;
        this.X.setAdapter(questionListAdapter);
        this.X.setEmptyView(this.Y);
        s0();
        this.W.F();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (SmartRefreshLayout) findViewById(2131298352);
        this.X = (EmptyRecyclerView) findViewById(2131298351);
        this.Y = (TextView) findViewById(2131298892);
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        this.W.F();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
