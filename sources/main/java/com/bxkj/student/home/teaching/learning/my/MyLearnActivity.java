package com.bxkj.student.home.teaching.learning.my;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.R;
import com.bxkj.student.home.teaching.learning.m;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class MyLearnActivity extends BaseActivity {
    private TextView F0;
    private TextView G0;
    private TextView W;
    private LinearLayout X;
    private TextView Y;
    private LinearLayout Z;

    /* renamed from: a0, reason: collision with root package name */
    private TextView f18706a0;

    /* renamed from: b0, reason: collision with root package name */
    private ListView f18707b0;

    /* renamed from: c0, reason: collision with root package name */
    private TextView f18708c0;

    /* renamed from: k0, reason: collision with root package name */
    private TextView f18709k0;

    /* renamed from: p0, reason: collision with root package name */
    private TextView f18710p0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            MyLearnActivity.this.Q().setVisibility(0);
            MyLearnActivity.this.z0(data);
            MyLearnActivity.this.f18709k0.setText("我的点赞(" + JsonParse.getString(data, "sumLike") + ")");
            MyLearnActivity.this.f18710p0.setText("我的收藏(" + JsonParse.getString(data, "sumCollection") + ")");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            int i6 = JsonParse.getInt(data, "data");
            MyLearnActivity.this.f18708c0.setText("待处理作业(" + i6 + ")");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> {
        c(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.J(R.id.tv_term, JsonParse.getString(stringObjectMap, "termSysTerm"));
            holder.J(R.id.tv_duration, "时长：" + JsonParse.getString(stringObjectMap, "termSumDuration"));
            holder.J(R.id.tv_integral, "积分：" + JsonParse.getString(stringObjectMap, "termSumIntegral"));
        }
    }

    private void s0() {
        Http.with(this.T).hideLoadingDialog().hideSuccessMessage().hideOtherStatusMessage().hideFailMessage().setObservable(((m) Http.getApiService(m.class)).t()).setDataListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0(View view) {
        startActivity(new Intent(this.T, (Class<?>) RefuseQuestionListActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0(View view) {
        startActivity(new Intent(this.T, (Class<?>) MyRecordListActivity.class).putExtra("title", "我的点赞").putExtra("resultType", "3"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v0(View view) {
        startActivity(new Intent(this.T, (Class<?>) MyRecordListActivity.class).putExtra("title", "我的收藏").putExtra("resultType", "2"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w0(View view) {
        startActivity(new Intent(this.T, (Class<?>) MyRecordListActivity.class).putExtra("title", "浏览记录").putExtra("resultType", "1"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x0(View view) {
        startActivity(new Intent(this.T, (Class<?>) MyRecordListActivity.class).putExtra("title", "分享记录").putExtra("resultType", "4"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y0(View view) {
        startActivity(new Intent(this.T, (Class<?>) MyIntegralListActivity.class).putExtra("title", "我的积分").putExtra("resultType", "5"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0(Map<String, Object> data) {
        this.W.setText(JsonParse.getString(data, "sumDuration") + "分钟");
        this.Y.setText(JsonParse.getString(data, "sumIntegral"));
        this.f18706a0.setText(JsonParse.getString(data, "rank"));
        this.f18707b0.setAdapter((ListAdapter) new c(this.T, R.layout.item_for_my_term_learn, JsonParse.getList(data, "termData")));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.f18708c0.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.my.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyLearnActivity.this.t0(view);
            }
        });
        this.f18709k0.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.my.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyLearnActivity.this.u0(view);
            }
        });
        this.f18710p0.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.my.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyLearnActivity.this.v0(view);
            }
        });
        this.F0.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.my.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyLearnActivity.this.w0(view);
            }
        });
        this.G0.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.my.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyLearnActivity.this.x0(view);
            }
        });
        this.X.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.my.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyLearnActivity.this.y0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("我的学习");
    }

    private void r0() {
        s0();
        Http.with(this.T).setObservable(((m) Http.getApiService(m.class)).h(LoginUser.getLoginUser().getUserId())).setDataListener(new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_my_learn;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        Q().setVisibility(8);
        r0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (TextView) findViewById(R.id.tv_duration);
        this.X = (LinearLayout) findViewById(R.id.ll_integral);
        this.Y = (TextView) findViewById(R.id.tv_integral);
        this.Z = (LinearLayout) findViewById(R.id.ll_rank);
        this.f18706a0 = (TextView) findViewById(2131299062);
        this.f18707b0 = (ListView) findViewById(2131298421);
        this.f18708c0 = (TextView) findViewById(R.id.tv_refuse_work);
        this.f18709k0 = (TextView) findViewById(R.id.tv_like);
        this.f18710p0 = (TextView) findViewById(R.id.tv_collect);
        this.F0 = (TextView) findViewById(R.id.tv_record);
        this.G0 = (TextView) findViewById(R.id.tv_share);
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        r0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
