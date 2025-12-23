package com.bxkj.student.home.teaching.homework;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
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
import cn.bluemobi.dylan.photoview.ImagePagerActivity;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.R;
import com.bxkj.student.home.teaching.homework.ViewLessonActivity;
import com.bxkj.student.home.teaching.homework.question.list.QuestionListActivity;
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
    protected int f18300a0 = 10;

    /* renamed from: b0, reason: collision with root package name */
    protected int f18301b0 = 1;

    /* renamed from: c0, reason: collision with root package name */
    protected int f18302c0 = 1;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.student.home.teaching.homework.ViewLessonActivity$a$a, reason: collision with other inner class name */
        class ViewOnClickListenerC0220a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Map f18304a;

            ViewOnClickListenerC0220a(final Map val$stringObjectMap) {
                this.f18304a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v5) {
                ViewLessonActivity.this.startActivity(new Intent(((CommonAdapter) a.this).f1138e, (Class<?>) QuestionListActivity.class).putExtra("teacherCurriculumId", JsonParse.getString(this.f18304a, "id")));
            }
        }

        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(Map map, View view) {
            ViewLessonActivity.this.p0(JsonParse.getString(map, "classimg"));
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(R.id.tv_lesson_name, JsonParse.getString(stringObjectMap, "teacherCurriculumTeachingCurriculumName"));
            holder.J(2131298861, JsonParse.getString(stringObjectMap, "teacherCurriculumSysTermName"));
            holder.J(2131299158, JsonParse.getString(stringObjectMap, "teacherCurriculumTeachingSchoolTimeName"));
            holder.J(2131298922, JsonParse.getString(stringObjectMap, "teacherCurriculumSysOrgName"));
            holder.J(R.id.tv_school_area, JsonParse.getString(stringObjectMap, "teacherCurriculumSysCampusName"));
            holder.J(2131299171, JsonParse.getString(stringObjectMap, "teacherCurriculumType"));
            holder.J(R.id.tv_feature, JsonParse.getString(stringObjectMap, "teacherCurriculumFeature"));
            holder.J(R.id.tv_teacher, "教师：" + JsonParse.getString(stringObjectMap, "teacherCurriculumSysUserName"));
            holder.N(2131298773, TextUtils.isEmpty(JsonParse.getString(stringObjectMap, "address")) ^ true);
            holder.J(2131298773, JsonParse.getString(stringObjectMap, "address"));
            ((Button) holder.h(2131296623)).setText("课后作业");
            holder.N(R.id.bt_qrcode, true);
            holder.w(R.id.bt_qrcode, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.homework.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ViewLessonActivity.a.this.p(stringObjectMap, view);
                }
            });
            holder.w(2131296623, new ViewOnClickListenerC0220a(stringObjectMap));
            holder.N(R.id.bt_qrcode, false);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f18306a;

        b(final int val$position) {
            this.f18306a = val$position;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ViewLessonActivity.this.Z.d().remove(this.f18306a);
            ViewLessonActivity.this.Z.notifyItemRemoved(this.f18306a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements e {
        c() {
        }

        @Override // n2.d
        public void a(h refreshlayout) {
            ViewLessonActivity viewLessonActivity = ViewLessonActivity.this;
            viewLessonActivity.f18301b0 = 1;
            viewLessonActivity.m0();
        }

        @Override // n2.b
        public void f(h refreshlayout) {
            ViewLessonActivity viewLessonActivity = ViewLessonActivity.this;
            int i6 = viewLessonActivity.f18302c0;
            int i7 = viewLessonActivity.f18300a0;
            int i8 = i6 / i7;
            int i9 = viewLessonActivity.f18301b0;
            if (i6 % i7 != 0) {
                i8++;
            }
            if (i9 >= i8) {
                viewLessonActivity.W.Q();
                Toast.makeText(((BaseActivity) ViewLessonActivity.this).T, "没有了", 0).show();
            } else {
                viewLessonActivity.f18301b0 = i9 + 1;
                viewLessonActivity.m0();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d extends HttpCallBack {
        d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ViewLessonActivity.this.f18302c0 = Integer.parseInt(u.O(data, "total"));
            List list = (List) data.get("data");
            List d6 = ViewLessonActivity.this.Z.d();
            if (ViewLessonActivity.this.f18301b0 != 1) {
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

    private void l0(final int position) {
        Http.with(this.T).setObservable(((e0.a) Http.getApiService(e0.a.class)).o0(JsonParse.getString(this.Z.getItem(position), "id"))).setDataListener(new b(position));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0(String url) {
        Intent intent = new Intent(this.T, (Class<?>) ImagePagerActivity.class);
        intent.putExtra(ImagePagerActivity.T, new String[]{url});
        intent.putExtra(ImagePagerActivity.S, 1);
        intent.putExtra(ImagePagerActivity.U, true);
        startActivity(intent);
        overridePendingTransition(2130772094, 2130772095);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        this.W.v(false);
        this.X.setLayoutManager(new LinearLayoutManager(this.T, 1, false));
        a aVar = new a(this.T, R.layout.item_for_lesson_list, this.Y);
        this.Z = aVar;
        this.X.setAdapter(aVar);
        o0();
        this.W.F();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("课后作业-查看" + LoginUser.getLoginUser().getViewAfterLabelName());
    }

    public void o0() {
        this.W.D(new c());
    }

    private rx.e<c0<ResponseBody>> n0() {
        return ((e0.a) Http.getApiService(e0.a.class)).m1(LoginUser.getLoginUser().getUserId(), getIntent().getStringExtra("id"));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_my_lesson;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        ((Spinner) findViewById(2131298550)).setVisibility(8);
        this.W = (SmartRefreshLayout) findViewById(2131298353);
        this.X = (RecyclerView) findViewById(2131298351);
    }

    public void m0() {
        Http.with(this.T).hideLoadingDialog().setObservable(n0()).setDataListener(new d());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
