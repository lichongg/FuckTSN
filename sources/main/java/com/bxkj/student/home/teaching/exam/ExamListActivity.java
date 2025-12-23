package com.bxkj.student.home.teaching.exam;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.R;
import com.bxkj.student.home.teaching.evaluateteacher.EvaluateListActivity;
import com.bxkj.student.home.teaching.exam.ExamListActivity;
import com.bxkj.student.home.teaching.exam.record.ExamRecordActivity;
import com.bxkj.student.run.app.face.widget.FaceDetect5ExpActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import m2.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class ExamListActivity extends BaseActivity {
    private SmartRefreshLayout W;
    private EmptyRecyclerView X;
    private CommonAdapter<Map<String, Object>> Z;
    private List<Map<String, Object>> Y = new ArrayList();

    /* renamed from: a0, reason: collision with root package name */
    private int f18127a0 = 0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(Map map, boolean z5, View view) {
            ExamListActivity.this.v0(JsonParse.getString(map, "id"), z5);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void q(Map map, View view) {
            ExamListActivity examListActivity = ExamListActivity.this;
            examListActivity.startActivity(examListActivity.getIntent().setClass(this.f1138e, ExamRecordActivity.class).putExtra("studentChooseLessonId", JsonParse.getString(map, "id")));
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(2131298922, JsonParse.getString(stringObjectMap, "term"));
            holder.J(R.id.tv_course_name, JsonParse.getString(stringObjectMap, "courseName"));
            holder.J(R.id.tv_teacher_name, JsonParse.getString(stringObjectMap, "teacherName"));
            holder.N(2131299093, !JsonParse.getString(stringObjectMap, "score").isEmpty());
            holder.N(R.id.bt_evaluate, JsonParse.getBoolean(stringObjectMap, "isExam"));
            holder.N(R.id.tv_arrow_right, JsonParse.getBoolean(stringObjectMap, "isExam"));
            holder.J(2131299093, JsonParse.getString(stringObjectMap, "score"));
            String string = JsonParse.getString(stringObjectMap, "type");
            String str = "0";
            if ("0".equals(string)) {
                str = "正常";
            } else if ("1".equals(string)) {
                str = "保健";
            } else if ("2".equals(string)) {
                str = "特招";
            } else if ("3".equals(string)) {
                str = "出国";
            } else if ("4".equals(string)) {
                str = "服役";
            } else if ("5".equals(string)) {
                str = "休学";
            }
            final boolean z5 = JsonParse.getBoolean(stringObjectMap, "isShowList");
            holder.J(2131299116, str);
            holder.J(R.id.bt_evaluate, "开始考试");
            holder.w(R.id.bt_evaluate, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.exam.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExamListActivity.a.this.p(stringObjectMap, z5, view);
                }
            });
            holder.N(R.id.bt_recorder, z5);
            holder.w(R.id.bt_recorder, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.exam.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExamListActivity.a.this.q(stringObjectMap, view);
                }
            });
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements n2.d {
        b() {
        }

        @Override // n2.d
        public void a(h refreshlayout) {
            ExamListActivity.this.u0();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ExamListActivity.this.Y = (List) data.get("data");
            ExamListActivity.this.Z.g(ExamListActivity.this.Y);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            ExamListActivity.this.W.Y();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d extends HttpCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f18131a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f18132b;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements iOSTwoButtonDialog.RightButtonOnClick {
            a() {
            }

            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public void buttonRightOnClick() {
                ((BaseActivity) ExamListActivity.this).T.startActivity(new Intent(((BaseActivity) ExamListActivity.this).T, (Class<?>) EvaluateListActivity.class));
            }
        }

        d(final String val$stuTeacherCurriculumId, final boolean val$isShowList) {
            this.f18131a = val$stuTeacherCurriculumId;
            this.f18132b = val$isShowList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(View view) {
            ExamListActivity.this.startActivity(new Intent(((BaseActivity) ExamListActivity.this).T, (Class<?>) FaceDetect5ExpActivity.class));
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            if (!JsonParse.getBoolean(data, "data")) {
                new iOSTwoButtonDialog(((BaseActivity) ExamListActivity.this).T).setTitle("提示").setMessage("您还未评价教师，请先去评价教师").setRightButtonOnClickListener(new a()).show();
            } else {
                ExamListActivity examListActivity = ExamListActivity.this;
                examListActivity.startActivity(examListActivity.getIntent().setClass(((BaseActivity) ExamListActivity.this).T, ExamDescriptionActivity.class).putExtra("stuTeacherCurriculumId", this.f18131a).putExtra("isShowList", this.f18132b));
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            if (status == 202) {
                new iOSOneButtonDialog(((BaseActivity) ExamListActivity.this).T).setMessage(msg).setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.exam.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ExamListActivity.d.this.b(view);
                    }
                }).show();
            } else {
                new iOSOneButtonDialog(((BaseActivity) ExamListActivity.this).T).setMessage(msg).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0() {
        Http.with(this.T).hideLoadingDialog().hideOtherStatusMessage().setObservable(((e0.a) Http.getApiService(e0.a.class)).I(LoginUser.getLoginUser().getUserId(), this.f18127a0)).setDataListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0(final String stuTeacherCurriculumId, boolean isShowList) {
        Http.with(this.T).hideOtherStatusMessage().setObservable(((e0.a) Http.getApiService(e0.a.class)).N0(stuTeacherCurriculumId, LoginUser.getLoginUser().getUserId(), this.f18127a0)).setDataListener(new d(stuTeacherCurriculumId, isShowList));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return 2131492999;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("onlineType")) {
            this.f18127a0 = getIntent().getIntExtra("onlineType", 0);
        }
        this.X.setLayoutManager(new LinearLayoutManager(this.T));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, 2130772096));
        layoutAnimationController.setOrder(0);
        this.X.setLayoutAnimation(layoutAnimationController);
        a aVar = new a(this.T, R.layout.item_for_evaluate_techaer_list, this.Y);
        this.Z = aVar;
        this.X.setAdapter(aVar);
        this.W.p(new b());
        this.W.h0(true);
        this.W.v(false);
        this.X.setEmptyView(findViewById(2131298892));
        this.W.F();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("title")) {
            setTitle(getIntent().getStringExtra("title"));
        } else {
            setTitle("考试课程");
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (SmartRefreshLayout) findViewById(2131298352);
        this.X = (EmptyRecyclerView) findViewById(2131298351);
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
