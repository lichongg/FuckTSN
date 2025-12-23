package com.bxkj.student.home.teaching.rollcall.term;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.R;
import com.bxkj.student.home.teaching.rollcall.SignActivity;
import com.bxkj.student.home.teaching.rollcall.term.ViewLessonActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import m2.h;
import n2.e;
import okhttp3.ResponseBody;
import retrofit2.c0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class ViewLessonActivity extends BaseActivity {
    private SmartRefreshLayout W;
    private RecyclerView X;
    private CommonAdapter<Map<String, Object>> Z;
    private List<Map<String, Object>> Y = new ArrayList();

    /* renamed from: a0, reason: collision with root package name */
    protected int f18988a0 = 10;

    /* renamed from: b0, reason: collision with root package name */
    protected int f18989b0 = 1;

    /* renamed from: c0, reason: collision with root package name */
    protected int f18990c0 = 1;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(Map map, View view) {
            ViewLessonActivity.this.startActivity(new Intent(this.f1138e, (Class<?>) SignActivity.class).putExtra("id", JsonParse.getString(map, "id")));
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(R.id.tv_lesson_name, JsonParse.getString(stringObjectMap, "teacherCurriculumTeachingCurriculumName"));
            holder.J(2131298861, JsonParse.getString(stringObjectMap, "teacherCurriculumSysTermName"));
            holder.J(2131299158, JsonParse.getString(stringObjectMap, "teacherCurriculumTeachingSchoolTimeName"));
            holder.J(2131298922, JsonParse.getString(stringObjectMap, "teacherCurriculumSysOrgName"));
            holder.J(R.id.tv_school_area, JsonParse.getString(stringObjectMap, "teacherCurriculumSysCampusName"));
            holder.J(R.id.tv_week, "第" + JsonParse.getString(stringObjectMap, "parameter") + "周");
            holder.J(2131299171, JsonParse.getString(stringObjectMap, "teacherCurriculumType"));
            holder.J(R.id.tv_feature, JsonParse.getString(stringObjectMap, "teacherCurriculumFeature"));
            holder.J(R.id.tv_teacher, "教师：" + JsonParse.getString(stringObjectMap, "teacherCurriculumSysUserName"));
            holder.N(2131298773, TextUtils.isEmpty(JsonParse.getString(stringObjectMap, "address")) ^ true);
            holder.J(2131298773, JsonParse.getString(stringObjectMap, "address"));
            holder.N(2131296623, false);
            holder.N(R.id.bt_qrcode, false);
            holder.N(R.id.bt_certificate, true);
            holder.J(R.id.bt_certificate, "上课签到");
            holder.w(R.id.bt_certificate, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.rollcall.term.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ViewLessonActivity.a.this.o(stringObjectMap, view);
                }
            });
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f18992a;

        b(final int val$position) {
            this.f18992a = val$position;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ViewLessonActivity.this.Z.d().remove(this.f18992a);
            ViewLessonActivity.this.Z.notifyItemRemoved(this.f18992a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements e {
        c() {
        }

        @Override // n2.d
        public void a(h refreshlayout) {
            ViewLessonActivity viewLessonActivity = ViewLessonActivity.this;
            viewLessonActivity.f18989b0 = 1;
            viewLessonActivity.l0();
        }

        @Override // n2.b
        public void f(h refreshlayout) {
            ViewLessonActivity viewLessonActivity = ViewLessonActivity.this;
            int i6 = viewLessonActivity.f18990c0;
            int i7 = viewLessonActivity.f18988a0;
            int i8 = i6 / i7;
            int i9 = viewLessonActivity.f18989b0;
            if (i6 % i7 != 0) {
                i8++;
            }
            if (i9 >= i8) {
                viewLessonActivity.W.Q();
                Toast.makeText(((BaseActivity) ViewLessonActivity.this).T, "没有了", 0).show();
            } else {
                viewLessonActivity.f18989b0 = i9 + 1;
                viewLessonActivity.l0();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d extends HttpCallBack {
        d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ViewLessonActivity.this.f18990c0 = Integer.parseInt(u.O(data, "total"));
            List list = (List) data.get("data");
            List d6 = ViewLessonActivity.this.Z.d();
            if (ViewLessonActivity.this.f18989b0 != 1) {
                d6.addAll(list);
                list = d6;
            }
            ViewLessonActivity.this.Z.g(list);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            ViewLessonActivity.this.W.Y();
            ViewLessonActivity.this.W.Q();
        }
    }

    private void k0(final int position) {
        Http.with(this.T).setObservable(((e0.a) Http.getApiService(e0.a.class)).o0(JsonParse.getString(this.Z.getItem(position), "id"))).setDataListener(new b(position));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        this.W.v(false);
        this.X.setLayoutManager(new LinearLayoutManager(this.T, 1, false));
        a aVar = new a(this.T, R.layout.item_for_lesson_list, this.Y);
        this.Z = aVar;
        this.X.setAdapter(aVar);
        n0();
        this.W.F();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("上课签到-查看" + LoginUser.getLoginUser().getViewAfterLabelName());
    }

    public void n0() {
        this.W.D(new c());
    }

    private rx.e<c0<ResponseBody>> m0() {
        return ((e0.a) Http.getApiService(e0.a.class)).m1(LoginUser.getLoginUser().getUserId(), getIntent().getStringExtra("id"));
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

    public void l0() {
        Http.with(this.T).hideLoadingDialog().setObservable(m0()).setDataListener(new d());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
