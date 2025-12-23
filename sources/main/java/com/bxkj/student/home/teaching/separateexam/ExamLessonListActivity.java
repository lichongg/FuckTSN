package com.bxkj.student.home.teaching.separateexam;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.R;
import com.bxkj.student.home.teaching.separateexam.ExamLessonListActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class ExamLessonListActivity extends BaseActivity {
    private SmartRefreshLayout W;
    private EmptyRecyclerView X;
    private TextView Y;
    private List<Map<String, Object>> Z = new ArrayList();

    /* renamed from: a0, reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f19015a0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(Map map, View view) {
            ExamLessonListActivity.this.startActivity(new Intent(this.f1138e, (Class<?>) ExamLessonDescriptionActivity.class).putExtra("stuid", JsonParse.getString(map, "stuid")));
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void c(ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(R.id.tv_lesson_name, "课程：" + JsonParse.getString(stringObjectMap, "curriculumName"));
            holder.J(R.id.tv_teacher_name, "教师：" + JsonParse.getString(stringObjectMap, "teacherName"));
            holder.w(R.id.bt_start, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.separateexam.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExamLessonListActivity.a.this.o(stringObjectMap, view);
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
            ExamLessonListActivity.this.Z = JsonParse.getList(data, "data");
            ExamLessonListActivity.this.f19015a0.g(ExamLessonListActivity.this.Z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0() {
        startActivity(new Intent(this.T, (Class<?>) MyAppointExamListActivity.class));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        this.X.setLayoutManager(new LinearLayoutManager(this.T));
        a aVar = new a(this.T, R.layout.item_for_exam_lesson_list, this.Z);
        this.f19015a0 = aVar;
        this.X.setAdapter(aVar);
        this.X.setEmptyView(this.Y);
        l0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("选择约考课程");
        c0("我的约考", new BaseActivity.c() { // from class: com.bxkj.student.home.teaching.separateexam.b
            @Override // cn.bluemobi.dylan.base.BaseActivity.c
            public final void onClick() {
                ExamLessonListActivity.this.m0();
            }
        });
    }

    public void l0() {
        Http.with(this.T).setObservable(((e0.a) Http.getApiService(e0.a.class)).i1(LoginUser.getLoginUser().getUserId())).setDataListener(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return 2131493640;
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
