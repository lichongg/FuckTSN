package com.bxkj.competition.score.student;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.util.UniversalItemDecoration;
import com.bxkj.base.view.MyOnScrollListener;
import com.bxkj.base.view.ObservableHorizontalScrollView;
import com.bxkj.competition.R;
import com.bxkj.competition.score.teacher.ScoreMenu;
import com.google.android.material.tabs.TabLayout;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class StudentScoreListActivity extends BaseActivity {
    private List<Map<String, Object>> G0;
    private String W;
    private ObservableHorizontalScrollView X;
    private LinearLayout Y;
    private TabLayout Z;

    /* renamed from: a0, reason: collision with root package name */
    private RecyclerView f17319a0;

    /* renamed from: b0, reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f17320b0;

    /* renamed from: k0, reason: collision with root package name */
    private RecyclerView f17322k0;

    /* renamed from: p0, reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f17323p0;

    /* renamed from: c0, reason: collision with root package name */
    private List<Map<String, Object>> f17321c0 = new ArrayList();
    private List<Map<String, Object>> F0 = new ArrayList();
    private final RecyclerView.OnScrollListener H0 = new k();
    private final RecyclerView.OnScrollListener I0 = new l();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements RecyclerView.OnItemTouchListener {

        /* renamed from: a, reason: collision with root package name */
        private int f17324a;

        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e6) {
            if (rv.getScrollState() == 0) {
                onTouchEvent(rv, e6);
                return false;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(RecyclerView rv, MotionEvent e6) {
            if (e6.getAction() == 0 && StudentScoreListActivity.this.f17322k0.getScrollState() == 0) {
                this.f17324a = rv.getScrollY();
                rv.addOnScrollListener(StudentScoreListActivity.this.H0);
            } else if (e6.getAction() == 1 && rv.getScrollY() == this.f17324a) {
                rv.removeOnScrollListener(StudentScoreListActivity.this.H0);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements RecyclerView.OnItemTouchListener {

        /* renamed from: a, reason: collision with root package name */
        private int f17326a;

        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e6) {
            if (rv.getScrollState() == 0) {
                onTouchEvent(rv, e6);
                return false;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(RecyclerView rv, MotionEvent e6) {
            if (e6.getAction() == 0 && StudentScoreListActivity.this.f17322k0.getScrollState() == 0) {
                this.f17326a = rv.getScrollY();
                rv.addOnScrollListener(StudentScoreListActivity.this.I0);
            } else if (e6.getAction() == 1 && rv.getScrollY() == this.f17326a) {
                rv.removeOnScrollListener(StudentScoreListActivity.this.I0);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements ObservableHorizontalScrollView.a {
        c() {
        }

        @Override // com.bxkj.base.view.ObservableHorizontalScrollView.a
        public void a(ObservableHorizontalScrollView scrollView, int x5, int y5, int oldx, int oldy) {
            StudentScoreListActivity.this.f17322k0.removeOnScrollListener(StudentScoreListActivity.this.H0);
            StudentScoreListActivity.this.f17322k0.removeOnScrollListener(StudentScoreListActivity.this.I0);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d extends CommonAdapter<Map<String, Object>> {
        d(Context x02, int x12, List x22) {
            super(x02, x12, x22);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.J(R.id.tv_score, JsonParse.getString(stringObjectMap, CommonNetImpl.NAME));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e extends CommonAdapter<Map<String, Object>> {
        e(Context x02, int x12, List x22) {
            super(x02, x12, x22);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.J(R.id.tv_score, JsonParse.getString(stringObjectMap, JsonParse.getString((Map) StudentScoreListActivity.this.G0.get(holder.f() % StudentScoreListActivity.this.G0.size()), "key")));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class f extends UniversalItemDecoration {
        f() {
        }

        @Override // com.bxkj.base.util.UniversalItemDecoration
        public UniversalItemDecoration.b a(int position) {
            UniversalItemDecoration.a aVar = new UniversalItemDecoration.a();
            aVar.f16568d = u.a(1.0f, ((BaseActivity) StudentScoreListActivity.this).T);
            aVar.f16564f = R.color.cardDivider;
            return aVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class g extends UniversalItemDecoration {
        public boolean c(int rowNum, int index) {
            return index % rowNum == 0;
        }

        public boolean d(int rowNum, int index) {
            return index % rowNum == rowNum - 1;
        }

        g() {
        }

        @Override // com.bxkj.base.util.UniversalItemDecoration
        public UniversalItemDecoration.b a(int position) {
            UniversalItemDecoration.a aVar = new UniversalItemDecoration.a();
            int a6 = u.a(1.0f, ((BaseActivity) StudentScoreListActivity.this).T);
            aVar.f16568d = a6;
            aVar.f16566b = a6;
            aVar.f16564f = R.color.cardDivider;
            return aVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class h extends HttpCallBack {
        h() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            int i6 = JsonParse.getInt(data, "data");
            for (int i7 = 1; i7 <= i6; i7++) {
                StudentScoreListActivity.this.Z.addTab(StudentScoreListActivity.this.Z.newTab().setText("第" + i7 + "组"));
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) StudentScoreListActivity.this).T).setMessage(msg).show();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class i extends HttpCallBack {
        i() {
        }

        private void a() {
            StudentScoreListActivity.this.f17321c0.clear();
            StudentScoreListActivity.this.f17320b0.g(StudentScoreListActivity.this.f17321c0);
            StudentScoreListActivity.this.F0.clear();
            StudentScoreListActivity.this.f17323p0.g(StudentScoreListActivity.this.F0);
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            StudentScoreListActivity.this.f17321c0 = JsonParse.getList(data, "data");
            StudentScoreListActivity.this.f17320b0.g(StudentScoreListActivity.this.f17321c0);
            StudentScoreListActivity.this.F0.clear();
            for (Map map : StudentScoreListActivity.this.f17321c0) {
                Iterator it = StudentScoreListActivity.this.G0.iterator();
                while (it.hasNext()) {
                    String string = JsonParse.getString((Map) it.next(), "key");
                    String string2 = JsonParse.getString(map, string);
                    HashMap hashMap = new HashMap(2);
                    hashMap.put(string, string2);
                    StudentScoreListActivity.this.F0.add(hashMap);
                }
            }
            StudentScoreListActivity.this.f17323p0.g(StudentScoreListActivity.this.F0);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable ex) {
            super.netOnFailure(ex);
            a();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            a();
            new iOSOneButtonDialog(((BaseActivity) StudentScoreListActivity.this).T).setMessage(msg).show();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class j implements TabLayout.OnTabSelectedListener {
        j() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            StudentScoreListActivity.this.y0();
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class k extends MyOnScrollListener {
        k() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            StudentScoreListActivity.this.f17322k0.scrollBy(dx, dy);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class l extends MyOnScrollListener {
        l() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            StudentScoreListActivity.this.f17319a0.scrollBy(dx, dy);
        }
    }

    private void A0() {
        this.G0 = new ArrayList();
        new HashMap(2);
        HashMap hashMap = new HashMap(2);
        hashMap.put(CommonNetImpl.NAME, "道次");
        hashMap.put("key", "passNum");
        this.G0.add(hashMap);
        HashMap hashMap2 = new HashMap(2);
        hashMap2.put(CommonNetImpl.NAME, "号码簿");
        hashMap2.put("key", "num");
        this.G0.add(hashMap2);
        HashMap hashMap3 = new HashMap(2);
        hashMap3.put(CommonNetImpl.NAME, "单位");
        hashMap3.put("key", "areaName");
        this.G0.add(hashMap3);
        HashMap hashMap4 = new HashMap(2);
        hashMap4.put(CommonNetImpl.NAME, "检录");
        hashMap4.put("key", "stateName");
        this.G0.add(hashMap4);
        HashMap hashMap5 = new HashMap(2);
        hashMap5.put(CommonNetImpl.NAME, ScoreMenu.START);
        hashMap5.put("key", "start");
        this.G0.add(hashMap5);
        HashMap hashMap6 = new HashMap(2);
        hashMap6.put(CommonNetImpl.NAME, ScoreMenu.CHECK);
        hashMap6.put("key", "check");
        this.G0.add(hashMap6);
        HashMap hashMap7 = new HashMap(2);
        hashMap7.put(CommonNetImpl.NAME, ScoreMenu.RANK);
        hashMap7.put("key", "rank");
        this.G0.add(hashMap7);
        HashMap hashMap8 = new HashMap(2);
        hashMap8.put(CommonNetImpl.NAME, "成绩");
        hashMap8.put("key", "time");
        this.G0.add(hashMap8);
        HashMap hashMap9 = new HashMap(2);
        hashMap9.put(CommonNetImpl.NAME, "备注");
        hashMap9.put("key", "memo");
        this.G0.add(hashMap9);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -2);
        for (Map<String, Object> map : this.G0) {
            View inflate = LayoutInflater.from(this.T).inflate(R.layout.item_score, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.tv_score);
            textView.setText(JsonParse.getString(map, CommonNetImpl.NAME));
            textView.setTag(JsonParse.getString(map, "key"));
            this.Y.addView(inflate, layoutParams);
        }
    }

    private void B0() {
        this.f17319a0.addOnItemTouchListener(new a());
        this.f17322k0.addOnItemTouchListener(new b());
        this.X.setScrollViewListener(new c());
    }

    private void x0() {
        Http.with(this.T).setObservable(((com.bxkj.competition.b) Http.getApiService(com.bxkj.competition.b.class)).k(this.W)).setDataListener(new h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0() {
        Http.with(this.T).hideOtherStatusMessage().setObservable(((com.bxkj.competition.b) Http.getApiService(com.bxkj.competition.b.class)).n(this.W, this.Z.getSelectedTabPosition() + 1)).setDataListener(new i());
    }

    private void z0() {
        this.f17319a0.setLayoutManager(new LinearLayoutManager(this.T));
        Context context = this.T;
        int i6 = R.layout.item_score;
        d dVar = new d(context, i6, this.f17321c0);
        this.f17320b0 = dVar;
        this.f17319a0.setAdapter(dVar);
        this.f17322k0.setLayoutManager(new GridLayoutManager(this.T, this.G0.size()));
        e eVar = new e(this.T, i6, this.F0);
        this.f17323p0 = eVar;
        this.f17322k0.setAdapter(eVar);
        this.f17319a0.addItemDecoration(new f());
        this.f17322k0.addItemDecoration(new g());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.Z.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new j());
        B0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_student_score_list;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("查看成绩");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.Z = (TabLayout) findViewById(R.id.tb_group);
        this.Y = (LinearLayout) findViewById(R.id.ll_top);
        this.f17319a0 = (RecyclerView) findViewById(R.id.rv_student);
        this.f17322k0 = (RecyclerView) findViewById(R.id.rv_score);
        this.X = (ObservableHorizontalScrollView) findViewById(R.id.sv_room);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("scheduleId")) {
            this.W = getIntent().getStringExtra("scheduleId");
        }
        A0();
        z0();
        x0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
