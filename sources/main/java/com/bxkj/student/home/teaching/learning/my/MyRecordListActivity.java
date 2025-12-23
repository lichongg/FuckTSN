package com.bxkj.student.home.teaching.learning.my;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.home.teaching.learning.LearnHomeListAdapter;
import com.bxkj.student.home.teaching.learning.m;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import m2.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class MyRecordListActivity extends BaseActivity {
    private SmartRefreshLayout W;
    private EmptyRecyclerView X;
    private TextView Y;
    private List<Map<String, Object>> Z = new ArrayList();

    /* renamed from: a0, reason: collision with root package name */
    private int f18714a0 = 10;

    /* renamed from: b0, reason: collision with root package name */
    private int f18715b0 = 1;

    /* renamed from: c0, reason: collision with root package name */
    private int f18716c0 = 0;

    /* renamed from: k0, reason: collision with root package name */
    private LearnHomeListAdapter f18717k0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements n2.e {
        a() {
        }

        @Override // n2.d
        public void a(h refreshlayout) {
            MyRecordListActivity.this.f18715b0 = 1;
            MyRecordListActivity.this.q0();
        }

        @Override // n2.b
        public void f(h refreshlayout) {
            int i6 = MyRecordListActivity.this.f18716c0 / MyRecordListActivity.this.f18714a0;
            int i7 = MyRecordListActivity.this.f18715b0;
            if (MyRecordListActivity.this.f18716c0 % MyRecordListActivity.this.f18714a0 != 0) {
                i6++;
            }
            if (i7 >= i6) {
                MyRecordListActivity.this.W.Q();
                MyRecordListActivity.this.g0("没有了");
            } else {
                MyRecordListActivity.this.f18715b0++;
                MyRecordListActivity.this.q0();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            MyRecordListActivity.this.f18716c0 = JsonParse.getInt(data, "total");
            if (MyRecordListActivity.this.f18715b0 == 1) {
                MyRecordListActivity.this.Z.clear();
            }
            MyRecordListActivity.this.Z.addAll(JsonParse.getList(data, "data"));
            MyRecordListActivity.this.f18717k0.g(MyRecordListActivity.this.Z);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (MyRecordListActivity.this.W != null && MyRecordListActivity.this.W.x()) {
                MyRecordListActivity.this.W.Y();
            }
            if (MyRecordListActivity.this.W != null && MyRecordListActivity.this.W.isLoading()) {
                MyRecordListActivity.this.W.Q();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0() {
        Http.with(this.T).hideLoadingDialog().setObservable(((m) Http.getApiService(m.class)).d(LoginUser.getLoginUser().getUserId(), getIntent().getStringExtra("resultType"), Integer.valueOf(this.f18714a0), Integer.valueOf(this.f18715b0))).setDataListener(new b());
    }

    private void r0() {
        this.W.D(new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        this.X.setLayoutManager(new LinearLayoutManager(this.T));
        LearnHomeListAdapter learnHomeListAdapter = new LearnHomeListAdapter(this.T, this.Z);
        this.f18717k0 = learnHomeListAdapter;
        this.X.setAdapter(learnHomeListAdapter);
        this.X.setEmptyView(this.Y);
        r0();
        this.W.F();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return 2131493640;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("title")) {
            setTitle(getIntent().getStringExtra("title"));
        }
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

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
