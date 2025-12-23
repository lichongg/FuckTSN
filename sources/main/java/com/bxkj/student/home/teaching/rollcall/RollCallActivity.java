package com.bxkj.student.home.teaching.rollcall;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import okhttp3.ResponseBody;
import retrofit2.c0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class RollCallActivity extends BaseActivity {
    private SmartRefreshLayout W;
    private RecyclerView X;
    private CommonAdapter<Map<String, Object>> Z;
    private List<Map<String, Object>> Y = new ArrayList();

    /* renamed from: a0, reason: collision with root package name */
    protected int f18972a0 = 10;

    /* renamed from: b0, reason: collision with root package name */
    protected int f18973b0 = 1;

    /* renamed from: c0, reason: collision with root package name */
    protected int f18974c0 = 1;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(R.id.tv_lessen_name, "课程：" + JsonParse.getString(stringObjectMap, "className"));
            holder.J(R.id.tv_teacher_name, "教师：" + JsonParse.getString(stringObjectMap, "tcheNmae"));
            holder.J(R.id.tv_week, "周数：第" + JsonParse.getString(stringObjectMap, "parameter") + "周");
            StringBuilder sb = new StringBuilder();
            sb.append("时间：");
            sb.append(JsonParse.getString(stringObjectMap, "teachingSchoolTime"));
            holder.J(R.id.tv_teachingSchoolTime, sb.toString());
            holder.J(2131299116, "状态：" + JsonParse.getString(stringObjectMap, "type"));
            holder.J(2131299093, "分数：" + JsonParse.getString(stringObjectMap, "score"));
            holder.J(R.id.tv_escore, "额外分数：" + JsonParse.getString(stringObjectMap, "eScore"));
            holder.N(R.id.tv_escore, JsonParse.getString(stringObjectMap, "eScore").isEmpty() ^ true);
            holder.J(R.id.tv_note, "备注：" + JsonParse.getString(stringObjectMap, "note"));
            holder.N(R.id.tv_note, JsonParse.getString(stringObjectMap, "note").isEmpty() ^ true);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements n2.e {
        b() {
        }

        @Override // n2.d
        public void a(m2.h refreshlayout) {
            RollCallActivity rollCallActivity = RollCallActivity.this;
            rollCallActivity.f18973b0 = 1;
            rollCallActivity.k0();
        }

        @Override // n2.b
        public void f(m2.h refreshlayout) {
            RollCallActivity rollCallActivity = RollCallActivity.this;
            int i6 = rollCallActivity.f18974c0;
            int i7 = rollCallActivity.f18972a0;
            int i8 = i6 / i7;
            int i9 = rollCallActivity.f18973b0;
            if (i6 % i7 != 0) {
                i8++;
            }
            if (i9 >= i8) {
                rollCallActivity.W.Q();
                Toast.makeText(((BaseActivity) RollCallActivity.this).T, "没有了", 0).show();
            } else {
                rollCallActivity.f18973b0 = i9 + 1;
                rollCallActivity.k0();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            RollCallActivity.this.f18974c0 = Integer.parseInt(u.O(data, "total"));
            List list = (List) data.get("data");
            List d6 = RollCallActivity.this.Z.d();
            if (RollCallActivity.this.f18973b0 != 1) {
                d6.addAll(list);
                list = d6;
            }
            RollCallActivity.this.Z.g(list);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            RollCallActivity.this.W.Y();
            RollCallActivity.this.W.Q();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        this.W.v(false);
        this.X.setLayoutManager(new LinearLayoutManager(this.T, 1, false));
        a aVar = new a(this.T, R.layout.item_for_view_call, this.Y);
        this.Z = aVar;
        this.X.setAdapter(aVar);
        m0();
        this.W.F();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("查看点名");
    }

    public void m0() {
        this.W.D(new b());
    }

    private rx.e<c0<ResponseBody>> l0() {
        return ((e0.a) Http.getApiService(e0.a.class)).A0(getIntent().getStringExtra("id"));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_online_lesson;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        ((Spinner) findViewById(2131298550)).setVisibility(8);
        this.W = (SmartRefreshLayout) findViewById(2131298353);
        this.X = (RecyclerView) findViewById(2131298351);
    }

    public void k0() {
        Http.with(this.T).hideLoadingDialog().setObservable(l0()).setDataListener(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
