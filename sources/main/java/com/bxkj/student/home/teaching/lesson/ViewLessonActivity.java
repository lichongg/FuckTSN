package com.bxkj.student.home.teaching.lesson;

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
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.n;
import com.bxkj.student.R;
import com.bxkj.student.home.teaching.lesson.ViewLessonActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import m2.h;
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
    protected int f18913a0 = 10;

    /* renamed from: b0, reason: collision with root package name */
    protected int f18914b0 = 1;

    /* renamed from: c0, reason: collision with root package name */
    protected int f18915c0 = 1;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void r(ViewHolder viewHolder) {
            ViewLessonActivity.this.l0(viewHolder.getAdapterPosition());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void u(String str, float f6, View view) {
            ViewLessonActivity.this.startActivity(new Intent(this.f1138e, (Class<?>) CertificateActivity.class).putExtra("lessonName", str).putExtra("score", f6));
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            final String string = JsonParse.getString(stringObjectMap, "teacherCurriculumTeachingCurriculumName");
            holder.J(R.id.tv_lesson_name, string);
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
            String string2 = JsonParse.getString(stringObjectMap, "canshu");
            final Button button = (Button) holder.h(2131296623);
            if (string2.equals("0")) {
                button.setEnabled(true);
                button.setText("取消");
                button.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.lesson.e
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ViewLessonActivity.a.this.s(button, holder, view);
                    }
                });
            } else {
                button.setEnabled(false);
                button.setText("不可取消");
            }
            final String string3 = JsonParse.getString(stringObjectMap, "classimg");
            holder.N(R.id.bt_qrcode, true);
            holder.w(R.id.bt_qrcode, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.lesson.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ViewLessonActivity.a.this.t(string3, view);
                }
            });
            final float f6 = JsonParse.getFloat(stringObjectMap, "scores");
            holder.N(R.id.bt_certificate, (LoginUser.getLoginUser().getSchoolId().equalsIgnoreCase("85") || LoginUser.getLoginUser().getSchoolId().equalsIgnoreCase("2") || LoginUser.getLoginUser().getSchoolId().equalsIgnoreCase("85") || LoginUser.getLoginUser().getSchoolId().equalsIgnoreCase("131")) && f6 >= 60.0f);
            holder.w(R.id.bt_certificate, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.lesson.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ViewLessonActivity.a.this.u(string, f6, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void s(Button button, final ViewHolder viewHolder, View view) {
            if (button.getText().toString().trim().equals("取消")) {
                new iOSTwoButtonDialog(this.f1138e).setMessage("确定要取消吗？").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.lesson.d
                    @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                    public final void buttonRightOnClick() {
                        ViewLessonActivity.a.this.r(viewHolder);
                    }
                }).show();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void t(String str, View view) {
            if (TextUtils.isEmpty(str)) {
                new iOSOneButtonDialog(this.f1138e).setMessage("教师未上传二维码").show();
            } else {
                n.a(this.f1138e, str);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f18917a;

        b(final int val$position) {
            this.f18917a = val$position;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ViewLessonActivity.this.Z.d().remove(this.f18917a);
            ViewLessonActivity.this.Z.notifyItemRemoved(this.f18917a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements n2.e {
        c() {
        }

        @Override // n2.d
        public void a(h refreshlayout) {
            ViewLessonActivity viewLessonActivity = ViewLessonActivity.this;
            viewLessonActivity.f18914b0 = 1;
            viewLessonActivity.m0();
        }

        @Override // n2.b
        public void f(h refreshlayout) {
            ViewLessonActivity viewLessonActivity = ViewLessonActivity.this;
            int i6 = viewLessonActivity.f18915c0;
            int i7 = viewLessonActivity.f18913a0;
            int i8 = i6 / i7;
            int i9 = viewLessonActivity.f18914b0;
            if (i6 % i7 != 0) {
                i8++;
            }
            if (i9 >= i8) {
                viewLessonActivity.W.Q();
                Toast.makeText(((BaseActivity) ViewLessonActivity.this).T, "没有了", 0).show();
            } else {
                viewLessonActivity.f18914b0 = i9 + 1;
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
            ViewLessonActivity.this.f18915c0 = Integer.parseInt(u.O(data, "total"));
            List list = (List) data.get("data");
            List d6 = ViewLessonActivity.this.Z.d();
            if (ViewLessonActivity.this.f18914b0 != 1) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void l0(final int position) {
        Http.with(this.T).setObservable(((e0.a) Http.getApiService(e0.a.class)).o0(JsonParse.getString(this.Z.getItem(position), "id"))).setDataListener(new b(position));
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
        setTitle("查看" + LoginUser.getLoginUser().getViewAfterLabelName());
    }

    public void o0() {
        this.W.D(new c());
    }

    private rx.e<c0<ResponseBody>> n0() {
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
