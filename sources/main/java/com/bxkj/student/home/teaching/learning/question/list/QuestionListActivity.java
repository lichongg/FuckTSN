package com.bxkj.student.home.teaching.learning.question.list;

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
import com.bxkj.student.home.teaching.homework.question.list.QuestionListAdapter;
import com.bxkj.student.home.teaching.learning.LearnHomeListActivity;
import com.bxkj.student.home.teaching.learning.m;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class QuestionListActivity extends BaseActivity {
    private EmptyRecyclerView W;
    private TextView X;
    private List<Map<String, Object>> Y = new ArrayList();
    private QuestionListAdapter Z;

    /* renamed from: a0, reason: collision with root package name */
    private int f18800a0;

    /* renamed from: b0, reason: collision with root package name */
    private String f18801b0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            QuestionListActivity.this.Y = JsonParse.getList(data, "data");
            QuestionListActivity.this.Z.g(QuestionListActivity.this.Y);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void o0() {
        Http.with(this.T).setObservable(((m) Http.getApiService(m.class)).l(this.f18800a0, this.f18801b0)).setDataListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(ViewGroup viewGroup, View view, Object obj, int i6) {
        this.Z.v(i6);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.Z.k(new cn.bluemobi.dylan.base.adapter.common.recyclerview.b() { // from class: com.bxkj.student.home.teaching.learning.question.list.a
            @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
            public final void a(ViewGroup viewGroup, View view, Object obj, int i6) {
                QuestionListActivity.this.n0(viewGroup, view, obj, i6);
            }
        });
        this.Z.u(new QuestionListAdapter.b() { // from class: com.bxkj.student.home.teaching.learning.question.list.b
            @Override // com.bxkj.student.home.teaching.homework.question.list.QuestionListAdapter.b
            public final void onRefresh() {
                QuestionListActivity.this.o0();
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("问题列表");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return 2131493639;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("type")) {
            this.f18800a0 = getIntent().getIntExtra("type", 0);
        }
        if (getIntent().hasExtra("resourceId")) {
            this.f18801b0 = getIntent().getStringExtra("resourceId");
        }
        this.W.setLayoutManager(new LinearLayoutManager(this.T));
        QuestionListAdapter questionListAdapter = new QuestionListAdapter(this.T, this.Y);
        this.Z = questionListAdapter;
        this.W.setAdapter(questionListAdapter);
        o0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (EmptyRecyclerView) findViewById(2131298351);
        this.X = (TextView) findViewById(2131298892);
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        o0();
        LearnHomeListActivity learnHomeListActivity = (LearnHomeListActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(LearnHomeListActivity.class);
        if (learnHomeListActivity != null) {
            learnHomeListActivity.T0();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
