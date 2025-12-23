package com.bxkj.student.home.teaching.exam.record;

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
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.R;
import com.bxkj.student.home.teaching.exam.record.ExamRecordActivity;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class ExamRecordActivity extends BaseActivity {
    private String F0;
    private CommonAdapter<Map<String, Object>> G0;
    private int H0 = 0;
    private TextView W;
    private TextView X;
    private TextView Y;
    private TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    private TextView f18261a0;

    /* renamed from: b0, reason: collision with root package name */
    private TextView f18262b0;

    /* renamed from: c0, reason: collision with root package name */
    private EmptyRecyclerView f18263c0;

    /* renamed from: k0, reason: collision with root package name */
    private TextView f18264k0;

    /* renamed from: p0, reason: collision with root package name */
    private List<Map<String, Object>> f18265p0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void q(ViewHolder viewHolder, Map map) {
            ExamRecordActivity.this.p0(viewHolder.f(), JsonParse.getString(map, "stuId"), JsonParse.getString(map, "identify"));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void r(final ViewHolder viewHolder, final Map map, View view) {
            new iOSTwoButtonDialog(this.f1138e).setMessage("确定要删除吗？").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.exam.record.c
                @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                public final void buttonRightOnClick() {
                    ExamRecordActivity.a.this.q(viewHolder, map);
                }
            }).show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void s(boolean z5, Map map, View view) {
            if (z5) {
                ExamRecordActivity.this.startActivity(new Intent(this.f1138e, (Class<?>) ExamDetailActivity.class).putExtra("stuTeacherCurriculumId", JsonParse.getString(map, "stuId")).putExtra("identify", JsonParse.getString(map, "identify")));
            }
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(2131298991, (holder.f() + 1) + "");
            holder.J(R.id.tv_lesson, JsonParse.getString(stringObjectMap, "createTime"));
            holder.J(R.id.tv_teacher, JsonParse.getString(stringObjectMap, "teaUser"));
            holder.J(2131299093, JsonParse.getString(stringObjectMap, "score"));
            holder.N(R.id.bt_delete, JsonParse.getBoolean(stringObjectMap, "isDelete"));
            final boolean z5 = JsonParse.getBoolean(stringObjectMap, "isToView");
            holder.N(R.id.iv_arrow_right, z5);
            holder.n(2131298068, z5);
            holder.w(R.id.bt_delete, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.exam.record.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExamRecordActivity.a.this.r(holder, stringObjectMap, view);
                }
            });
            holder.w(2131298068, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.exam.record.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExamRecordActivity.a.this.s(z5, stringObjectMap, view);
                }
            });
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f18267a;

        b(final int val$position) {
            this.f18267a = val$position;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ExamRecordActivity.this.f18265p0.remove(this.f18267a);
            ExamRecordActivity.this.G0.notifyItemRemoved(this.f18267a);
            ExamRecordActivity.this.G0.notifyItemRangeChanged(this.f18267a, ExamRecordActivity.this.G0.getItemCount());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ExamRecordActivity.this.f18265p0 = JsonParse.getList(data, "li");
            ExamRecordActivity.this.G0.g(ExamRecordActivity.this.f18265p0);
            Map<String, Object> map = JsonParse.getMap(data, "av");
            ExamRecordActivity.this.Y.setText("考试次数：" + JsonParse.getString(map, "total"));
            ExamRecordActivity.this.Z.setText("平均分：" + JsonParse.getString(map, "avg"));
            ExamRecordActivity.this.f18261a0.setText("总排名：" + JsonParse.getString(map, "rank"));
            ExamRecordActivity.this.f18262b0.setText("年级排名：" + JsonParse.getString(map, "gradeRank"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0(int position, String stuId, String identify) {
        Http.with(this.T).setObservable(((e0.a) Http.getApiService(e0.a.class)).e0(stuId, identify)).setDataListener(new b(position));
    }

    private void q0() {
        Http.with(this.T).setObservable(((e0.a) Http.getApiService(e0.a.class)).F(this.F0, this.H0)).setDataListener(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("查看考试记录");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_exam_record;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("onlineType")) {
            this.H0 = getIntent().getIntExtra("onlineType", 0);
        }
        if (getIntent().hasExtra("studentChooseLessonId")) {
            this.F0 = getIntent().getStringExtra("studentChooseLessonId");
        }
        this.f18263c0.setLayoutManager(new LinearLayoutManager(this.T));
        a aVar = new a(this.T, R.layout.item_for_exam_record, this.f18265p0);
        this.G0 = aVar;
        this.f18263c0.setAdapter(aVar);
        this.f18263c0.setEmptyView(this.f18264k0);
        q0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (TextView) findViewById(2131298986);
        this.X = (TextView) findViewById(2131298997);
        this.Y = (TextView) findViewById(2131298848);
        this.Z = (TextView) findViewById(R.id.tv_avg);
        this.f18261a0 = (TextView) findViewById(R.id.tv_total_rank);
        this.f18262b0 = (TextView) findViewById(R.id.tv_grade_rank);
        this.f18263c0 = (EmptyRecyclerView) findViewById(2131298351);
        this.f18264k0 = (TextView) findViewById(2131298892);
        this.W.setText("姓名：" + LoginUser.getLoginUser().getRealName());
        this.X.setText("学号：" + LoginUser.getLoginUser().getAccount());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
