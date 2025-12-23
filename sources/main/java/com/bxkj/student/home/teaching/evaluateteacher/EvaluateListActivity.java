package com.bxkj.student.home.teaching.evaluateteacher;

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
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import m2.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class EvaluateListActivity extends BaseActivity {
    private SmartRefreshLayout W;
    private EmptyRecyclerView X;
    private List<Map<String, Object>> Y = new ArrayList();
    private CommonAdapter<Map<String, Object>> Z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.student.home.teaching.evaluateteacher.EvaluateListActivity$a$a, reason: collision with other inner class name */
        class ViewOnClickListenerC0218a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Map f18118a;

            ViewOnClickListenerC0218a(final Map val$stringObjectMap) {
                this.f18118a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v5) {
                EvaluateListActivity evaluateListActivity = EvaluateListActivity.this;
                Map map = this.f18118a;
                evaluateListActivity.p0(map, JsonParse.getString(map, "id"));
            }
        }

        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(2131298922, JsonParse.getString(stringObjectMap, "term"));
            holder.J(R.id.tv_course_name, JsonParse.getString(stringObjectMap, "courseName"));
            holder.J(R.id.tv_teacher_name, JsonParse.getString(stringObjectMap, "teacherName"));
            holder.N(2131299093, !JsonParse.getString(stringObjectMap, "score").isEmpty());
            holder.N(R.id.bt_evaluate, JsonParse.getString(stringObjectMap, "score").isEmpty());
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
            holder.J(2131299116, str);
            holder.w(R.id.bt_evaluate, new ViewOnClickListenerC0218a(stringObjectMap));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements n2.d {
        b() {
        }

        @Override // n2.d
        public void a(h refreshlayout) {
            EvaluateListActivity.this.q0();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map f18121a;

        c(final Map val$stringObjectMap) {
            this.f18121a = val$stringObjectMap;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            EvaluateListActivity.this.startActivity(new Intent(((BaseActivity) EvaluateListActivity.this).T, (Class<?>) EvaluateDescriptionActivity.class).putExtra("stuTeacherCurriculumId", JsonParse.getString(this.f18121a, "id")));
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) EvaluateListActivity.this).T).setMessage(msg).show();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d extends HttpCallBack {
        d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            EvaluateListActivity.this.Y = (List) data.get("data");
            EvaluateListActivity.this.Z.g(EvaluateListActivity.this.Y);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            EvaluateListActivity.this.W.Y();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0(final Map<String, Object> stringObjectMap, String stuTeacherCurriculumId) {
        Http.with(this.T).hideSuccessMessage().hideOtherStatusMessage().setObservable(((e0.a) Http.getApiService(e0.a.class)).b0(LoginUser.getLoginUser().getUserId(), stuTeacherCurriculumId)).setDataListener(new c(stringObjectMap));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0() {
        Http.with(this.T).hideLoadingDialog().setObservable(((e0.a) Http.getApiService(e0.a.class)).Z0(LoginUser.getLoginUser().getUserId())).setDataListener(new d());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
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
        setTitle("评价课程列表");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return 2131492999;
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
