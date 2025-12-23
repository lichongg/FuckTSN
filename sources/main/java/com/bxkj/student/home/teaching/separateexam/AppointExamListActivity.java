package com.bxkj.student.home.teaching.separateexam;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.R;
import com.bxkj.student.home.teaching.separateexam.AppointExamListActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class AppointExamListActivity extends BaseActivity {
    private SmartRefreshLayout W;
    private EmptyRecyclerView X;
    private TextView Y;
    private List<Map<String, Object>> Z = new ArrayList();

    /* renamed from: a0, reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f19006a0;

    /* renamed from: b0, reason: collision with root package name */
    private String f19007b0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.student.home.teaching.separateexam.AppointExamListActivity$a$a, reason: collision with other inner class name */
        class C0235a implements iOSTwoButtonDialog.RightButtonOnClick {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Map f19009a;

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            /* renamed from: com.bxkj.student.home.teaching.separateexam.AppointExamListActivity$a$a$a, reason: collision with other inner class name */
            class C0236a extends HttpCallBack {
                C0236a() {
                }

                @Override // cn.bluemobi.dylan.http.HttpResponse
                public void netOnSuccess(Map<String, Object> data) {
                    AppointExamListActivity.this.l0();
                }
            }

            C0235a(final Map val$stringObjectMap) {
                this.f19009a = val$stringObjectMap;
            }

            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public void buttonRightOnClick() {
                Http.with(((CommonAdapter) a.this).f1138e).setObservable(((e0.a) Http.getApiService(e0.a.class)).B1(AppointExamListActivity.this.f19007b0, JsonParse.getString(this.f19009a, "id"))).setDataListener(new C0236a());
            }
        }

        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(Map map, View view) {
            new iOSTwoButtonDialog(this.f1138e).setMessage("确定选择？").setRightButtonOnClickListener(new C0235a(map)).show();
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public void c(ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(2131298986, JsonParse.getString(stringObjectMap, CommonNetImpl.NAME));
            holder.J(2131298922, JsonParse.getString(stringObjectMap, "sysOrgId"));
            holder.J(R.id.tv_lesson, JsonParse.getString(stringObjectMap, "TeachingId"));
            holder.J(R.id.tv_teacher_name, JsonParse.getString(stringObjectMap, "teacherId"));
            holder.J(R.id.tv_lesson_all, JsonParse.getString(stringObjectMap, "teachingCurriculumTotalName"));
            holder.J(2131298773, JsonParse.getString(stringObjectMap, "address"));
            holder.J(R.id.tv_appoint_time, JsonParse.getString(stringObjectMap, "appointmentTime"));
            holder.J(R.id.tv_exam_time, JsonParse.getString(stringObjectMap, "examTime"));
            holder.w(R.id.bt_start, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.separateexam.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AppointExamListActivity.a.this.p(stringObjectMap, view);
                }
            });
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            AppointExamListActivity.this.Z = JsonParse.getList(data, "data");
            AppointExamListActivity.this.f19006a0.g(AppointExamListActivity.this.Z);
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("预约考试");
    }

    public void l0() {
        Http.with(this.T).setObservable(((e0.a) Http.getApiService(e0.a.class)).Q0(this.f19007b0)).setDataListener(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return 2131493640;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("stuid")) {
            this.f19007b0 = getIntent().getStringExtra("stuid");
        }
        this.X.setLayoutManager(new LinearLayoutManager(this.T));
        a aVar = new a(this.T, R.layout.item_for_choose_exam_list, this.Z);
        this.f19006a0 = aVar;
        this.X.setAdapter(aVar);
        this.X.setEmptyView(this.Y);
        l0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (SmartRefreshLayout) findViewById(2131298352);
        this.X = (EmptyRecyclerView) findViewById(2131298351);
        this.Y = (TextView) findViewById(2131298892);
        this.W.h0(false);
        this.W.v(false);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
