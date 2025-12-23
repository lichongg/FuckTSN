package com.bxkj.student.home.teaching.resultfinal;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class AllScoreForTeamActivity extends BaseActivity {
    private EmptyRecyclerView W;
    private TextView X;
    private List<Map<String, Object>> Y = new ArrayList();
    private CommonAdapter<Map<String, Object>> Z;

    /* renamed from: a0, reason: collision with root package name */
    private String f18944a0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(R.id.tv_exam, JsonParse.getString(stringObjectMap, "exam"));
            holder.J(R.id.tv_fenshu, JsonParse.getString(stringObjectMap, "fenshu"));
            holder.J(R.id.tv_duizhaofen, JsonParse.getString(stringObjectMap, "duizhaofen"));
            holder.J(R.id.tv_bili, JsonParse.getString(stringObjectMap, "bili"));
            holder.J(2131299093, JsonParse.getString(stringObjectMap, "score"));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            AllScoreForTeamActivity.this.Y = (List) data.get("data");
            AllScoreForTeamActivity.this.Z.g(AllScoreForTeamActivity.this.Y);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) AllScoreForTeamActivity.this).T).setMessage(msg).show();
        }
    }

    private void l0() {
        Http.with(this.T).hideOtherStatusMessage().setObservable(((e0.a) Http.getApiService(e0.a.class)).D(this.f18944a0)).setDataListener(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("期末分项成绩汇总");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_test_project_score_list;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("stuName")) {
            String stringExtra = getIntent().getStringExtra("stuName");
            String stringExtra2 = getIntent().getStringExtra("stuNum");
            this.X.setText("姓名：" + stringExtra + "\u3000\u3000\u3000学号：" + stringExtra2);
        }
        if (getIntent().hasExtra("stuTeamScoreId")) {
            this.f18944a0 = getIntent().getStringExtra("stuTeamScoreId");
        }
        this.W.setLayoutManager(new LinearLayoutManager(this.T));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, 2130772096));
        layoutAnimationController.setOrder(0);
        this.W.setLayoutAnimation(layoutAnimationController);
        a aVar = new a(this.T, R.layout.item_for_result_score_all, this.Y);
        this.Z = aVar;
        this.W.setAdapter(aVar);
        this.W.setEmptyView(findViewById(2131298892));
        l0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (EmptyRecyclerView) findViewById(2131298351);
        this.X = (TextView) findViewById(2131298986);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
