package com.bxkj.student.home.teaching.learning;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.R;
import com.bxkj.student.home.teaching.learning.LearnHomeListActivity;
import com.bxkj.student.home.teaching.learning.my.MyLearnActivity;
import com.bxkj.student.home.teaching.learning.my.RefuseQuestionListActivity;
import com.bxkj.student.home.teaching.learning.question.list.QuestionListActivity;
import com.google.android.material.tabs.TabLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class LearnHomeListActivity extends BaseActivity {
    private Button F0;
    private Button G0;
    private ImageView H0;
    private LearnHomeListAdapter N0;
    private SmartRefreshLayout W;
    private EmptyRecyclerView X;
    private LinearLayout Y;
    private CardView Z;

    /* renamed from: a0, reason: collision with root package name */
    private TextView f18418a0;

    /* renamed from: b0, reason: collision with root package name */
    private TextView f18419b0;

    /* renamed from: c0, reason: collision with root package name */
    private TextView f18420c0;

    /* renamed from: k0, reason: collision with root package name */
    private ProgressBar f18421k0;

    /* renamed from: p0, reason: collision with root package name */
    private TextView f18422p0;
    private List<List<Map<String, Object>>> I0 = new ArrayList();
    private List<Map<String, Object>> J0 = new ArrayList();
    private int K0 = 10;
    private int L0 = 1;
    private int M0 = 0;
    private final int O0 = 170;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            LearnHomeListActivity.this.Q().setVisibility(0);
            List<Map<String, Object>> list = JsonParse.getList(data, "data");
            if (list.isEmpty()) {
                LearnHomeListActivity.this.U0(data);
                LearnHomeListActivity.this.H0.setVisibility(8);
            } else {
                LearnHomeListActivity.this.V0(list);
                LearnHomeListActivity.this.H0.setVisibility(0);
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            LearnHomeListActivity.this.startActivity(new Intent(((BaseActivity) LearnHomeListActivity.this).T, (Class<?>) MyLearnActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d() {
            LearnHomeListActivity.this.startActivity(new Intent(((BaseActivity) LearnHomeListActivity.this).T, (Class<?>) RefuseQuestionListActivity.class));
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            if (JsonParse.getInt(data, "data") > 0) {
                LearnHomeListActivity.this.a0(R.mipmap.my_write_rad_dot, new BaseActivity.c() { // from class: com.bxkj.student.home.teaching.learning.h
                    @Override // cn.bluemobi.dylan.base.BaseActivity.c
                    public final void onClick() {
                        LearnHomeListActivity.b.this.c();
                    }
                });
                LearnHomeListActivity.this.invalidateOptionsMenu();
                new iOSTwoButtonDialog(((BaseActivity) LearnHomeListActivity.this).T).setMessage("您有教师批改后不合格题目，请到个人学习中心处理").setLeftButtonText("稍后再说").setRightButtonText("现在处理").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.learning.i
                    @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                    public final void buttonRightOnClick() {
                        LearnHomeListActivity.b.this.d();
                    }
                }).show();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            LearnHomeListActivity.this.startActivity(new Intent(((BaseActivity) LearnHomeListActivity.this).T, (Class<?>) MyLearnActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d() {
            LearnHomeListActivity.this.startActivity(new Intent(((BaseActivity) LearnHomeListActivity.this).T, (Class<?>) MyLearnActivity.class));
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            if (JsonParse.getInt(data, "data") > 0) {
                LearnHomeListActivity.this.a0(R.mipmap.my_write_rad_dot, new BaseActivity.c() { // from class: com.bxkj.student.home.teaching.learning.j
                    @Override // cn.bluemobi.dylan.base.BaseActivity.c
                    public final void onClick() {
                        LearnHomeListActivity.c.this.c();
                    }
                });
            } else {
                LearnHomeListActivity.this.a0(2131689955, new BaseActivity.c() { // from class: com.bxkj.student.home.teaching.learning.k
                    @Override // cn.bluemobi.dylan.base.BaseActivity.c
                    public final void onClick() {
                        LearnHomeListActivity.c.this.d();
                    }
                });
            }
            LearnHomeListActivity.this.invalidateOptionsMenu();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d extends HttpCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f18426a;

        d(final String val$pId) {
            this.f18426a = val$pId;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            LearnHomeListActivity.this.Q().setVisibility(0);
            List<Map<String, Object>> list = JsonParse.getList(data, "data");
            if (!list.isEmpty()) {
                LearnHomeListActivity.this.V0(list);
            } else {
                data.put("id", this.f18426a);
                LearnHomeListActivity.this.U0(data);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e extends HttpCallBack {
        e() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            if (JsonParse.getInt(data, "data") == 1) {
                LearnHomeListActivity.this.G0.setText("已完成本章节学习");
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class f implements TabLayout.OnTabSelectedListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TabLayout f18429a;

        f(final TabLayout val$tb) {
            this.f18429a = val$tb;
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            LearnHomeListActivity.this.Z.setVisibility(8);
            LearnHomeListActivity.this.J0.clear();
            LearnHomeListActivity.this.N0.g(LearnHomeListActivity.this.J0);
            int indexOfChild = LearnHomeListActivity.this.Y.indexOfChild(this.f18429a);
            while (LearnHomeListActivity.this.I0.size() > indexOfChild + 1) {
                int size = LearnHomeListActivity.this.I0.size() - 1;
                LearnHomeListActivity.this.I0.remove(size);
                LearnHomeListActivity.this.Y.removeViewAt(size);
            }
            LearnHomeListActivity.this.L0(JsonParse.getString((Map) ((List) LearnHomeListActivity.this.I0.get(indexOfChild)).get(this.f18429a.getSelectedTabPosition()), "id"));
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class g implements n2.e {
        g() {
        }

        @Override // n2.d
        public void a(m2.h refreshlayout) {
            LearnHomeListActivity.this.L0 = 1;
        }

        @Override // n2.b
        public void f(m2.h refreshlayout) {
            int i6 = LearnHomeListActivity.this.M0 / LearnHomeListActivity.this.K0;
            int i7 = LearnHomeListActivity.this.L0;
            if (LearnHomeListActivity.this.M0 % LearnHomeListActivity.this.K0 != 0) {
                i6++;
            }
            if (i7 >= i6) {
                LearnHomeListActivity.this.W.Q();
                LearnHomeListActivity.this.g0("没有了");
            } else {
                LearnHomeListActivity.this.L0++;
            }
        }
    }

    private void J0() {
        for (int i6 = 0; i6 < this.Y.getChildCount(); i6++) {
            TabLayout tabLayout = (TabLayout) this.Y.getChildAt(i6);
            tabLayout.setOnTabSelectedListener((TabLayout.OnTabSelectedListener) new f(tabLayout));
        }
    }

    private void K0() {
        Http.with(this.T).setObservable(((m) Http.getApiService(m.class)).f()).setDataListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L0(String pId) {
        Http.with(this.T).setObservable(((m) Http.getApiService(m.class)).m(pId)).setDataListener(new d(pId));
    }

    private void M0() {
        Http.with(this.T).hideLoadingDialog().hideSuccessMessage().hideOtherStatusMessage().hideFailMessage().setObservable(((m) Http.getApiService(m.class)).t()).setDataListener(new b());
    }

    private void N0() {
        this.W.D(new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P0(View view) {
        List<List<Map<String, Object>>> list = this.I0;
        if (list == null || list.size() == 0) {
            return;
        }
        startActivityForResult(new Intent(this.T, (Class<?>) LearningCategoryActivity.class).putExtra("list", new ArrayList(this.I0.get(0))), 170);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q0(View view) {
        Http.with(this.T).setObservable(((m) Http.getApiService(m.class)).r(this.G0.getTag().toString())).setDataListener(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R0(View view) {
        startActivity(new Intent(this.T, (Class<?>) QuestionListActivity.class).putExtra("type", 2).putExtra("resourceId", this.F0.getTag().toString()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S0() {
        startActivity(new Intent(this.T, (Class<?>) MyLearnActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U0(Map<String, Object> data) {
        List<Map<String, Object>> list = JsonParse.getList(data, "articles");
        this.J0 = list;
        if (list.isEmpty()) {
            this.Z.setVisibility(8);
            return;
        }
        this.Z.setVisibility(0);
        this.N0.g(this.J0);
        this.f18418a0.setText("当前章节积分：" + JsonParse.getString(data, "leafTotalScore"));
        this.f18419b0.setText("总积分：" + JsonParse.getString(data, "sumIntegral"));
        this.f18420c0.setText("目标积分：" + JsonParse.getString(data, "desIntegral"));
        int i6 = JsonParse.getInt(data, "completedAmount");
        int i7 = JsonParse.getInt(data, "totalAmount");
        this.f18421k0.setMax(i7);
        this.f18421k0.setProgress(i6);
        this.f18422p0.setText(i6 + "/" + i7);
        if (JsonParse.getInt(data, "hasQuestion") == 1) {
            this.F0.setVisibility(0);
            this.F0.setTag(JsonParse.getString(data, "id"));
        } else {
            this.F0.setVisibility(8);
        }
        if (JsonParse.getInt(data, "showButton") != 1) {
            this.G0.setVisibility(8);
            return;
        }
        this.G0.setVisibility(0);
        this.G0.setTag(JsonParse.getString(data, "id"));
        if (JsonParse.getInt(data, "competedType") == 1) {
            this.G0.setText("已完成本章节学习");
            return;
        }
        this.G0.setText("结束本章节学习");
        this.G0.setVisibility(0);
        this.G0.setTag(JsonParse.getString(data, "id"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V0(List<Map<String, Object>> dataList) {
        if (dataList == null || dataList.size() == 0) {
            return;
        }
        Map<String, Object> map = dataList.get(0);
        this.I0.add(dataList);
        TabLayout tabLayout = (TabLayout) LayoutInflater.from(this.T).inflate(R.layout.item_for_list_tab, (ViewGroup) null);
        Iterator<Map<String, Object>> it = dataList.iterator();
        while (it.hasNext()) {
            tabLayout.addTab(tabLayout.newTab().setText(JsonParse.getString(it.next(), "typeName")));
        }
        this.Y.addView(tabLayout);
        int i6 = JsonParse.getInt(map, "isLeaf");
        List<Map<String, Object>> list = JsonParse.getList(map, "childNode");
        if (i6 != 0 || list == null || list.size() <= 0) {
            U0(map);
        } else {
            V0(list);
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.Y.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.bxkj.student.home.teaching.learning.c
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
                LearnHomeListActivity.this.O0(view, i6, i7, i8, i9, i10, i11, i12, i13);
            }
        });
        this.H0.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LearnHomeListActivity.this.P0(view);
            }
        });
        this.G0.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LearnHomeListActivity.this.Q0(view);
            }
        });
        this.F0.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LearnHomeListActivity.this.R0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        this.X.setLayoutManager(new LinearLayoutManager(this.T));
        LearnHomeListAdapter learnHomeListAdapter = new LearnHomeListAdapter(this.T, this.J0);
        this.N0 = learnHomeListAdapter;
        this.X.setAdapter(learnHomeListAdapter);
        this.X.setEmptyView(findViewById(2131298892));
        Q().setVisibility(8);
        K0();
        M0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("在线学习");
        a0(2131689955, new BaseActivity.c() { // from class: com.bxkj.student.home.teaching.learning.g
            @Override // cn.bluemobi.dylan.base.BaseActivity.c
            public final void onClick() {
                LearnHomeListActivity.this.S0();
            }
        });
        invalidateOptionsMenu();
    }

    public void T0() {
        List<List<Map<String, Object>>> list = this.I0;
        if (list == null || list.size() <= 0 || this.Y.getChildCount() <= 0) {
            return;
        }
        int size = this.I0.size() - 1;
        List<Map<String, Object>> list2 = this.I0.get(size);
        TabLayout tabLayout = (TabLayout) this.Y.getChildAt(size);
        if (list2 == null || list2.size() <= 0 || tabLayout == null) {
            return;
        }
        L0(JsonParse.getString(list2.get(tabLayout.getSelectedTabPosition()), "id"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O0(View view, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
        J0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_learning_home_list;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.Y = (LinearLayout) findViewById(R.id.ll_menus);
        this.W = (SmartRefreshLayout) findViewById(2131298353);
        this.X = (EmptyRecyclerView) findViewById(R.id.rv_goods_list);
        this.Z = (CardView) findViewById(R.id.card_bottom);
        this.f18418a0 = (TextView) findViewById(R.id.tv_current_score);
        this.f18419b0 = (TextView) findViewById(R.id.tv_total_score);
        this.f18420c0 = (TextView) findViewById(R.id.tv_target_score);
        this.f18421k0 = (ProgressBar) findViewById(R.id.pb_process);
        this.f18422p0 = (TextView) findViewById(R.id.tv_process);
        this.F0 = (Button) findViewById(R.id.bt_question);
        this.G0 = (Button) findViewById(R.id.bt_finish);
        this.H0 = (ImageView) findViewById(R.id.iv_more);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null && resultCode == -1 && requestCode == 170) {
            ((TabLayout) this.Y.getChildAt(0)).getTabAt(data.getIntExtra("index", 0)).select();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        Http.with(this.T).hideLoadingDialog().hideSuccessMessage().hideOtherStatusMessage().hideFailMessage().setObservable(((m) Http.getApiService(m.class)).t()).setDataListener(new c());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
