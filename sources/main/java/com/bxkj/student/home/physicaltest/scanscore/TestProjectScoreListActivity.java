package com.bxkj.student.home.physicaltest.scanscore;

import android.content.Context;
import android.content.Intent;
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
import com.bxkj.student.home.physicaltest.apply.ScoreDoubtActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class TestProjectScoreListActivity extends BaseActivity {
    private EmptyRecyclerView W;
    private TextView X;
    private List<Map<String, Object>> Y = new ArrayList();
    private CommonAdapter<Map<String, Object>> Z;

    /* renamed from: a0, reason: collision with root package name */
    private String f18050a0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(2131298922, JsonParse.getString(stringObjectMap, "examName"));
            holder.J(2131298986, JsonParse.getString(stringObjectMap, "actualScore") + JsonParse.getString(stringObjectMap, "examunit"));
            holder.J(2131299093, JsonParse.getString(stringObjectMap, "score") + "分");
            holder.J(2131299062, JsonParse.getString(stringObjectMap, "rank"));
            holder.h(2131299116).setVisibility(4);
            holder.N(2131297100, false);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            TestProjectScoreListActivity.this.Y = (List) data.get("data");
            TestProjectScoreListActivity.this.Z.g(TestProjectScoreListActivity.this.Y);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) TestProjectScoreListActivity.this).T).setMessage(msg).show();
        }
    }

    private void m0() {
        Http.with(this.T).hideOtherStatusMessage().setObservable(((e0.a) Http.getApiService(e0.a.class)).P(this.f18050a0)).setDataListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0() {
        startActivity(new Intent(this.T, (Class<?>) ScoreDoubtActivity.class).putExtra("meaScoreId", this.f18050a0));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("体测分项汇总");
        a0(R.mipmap.question, new BaseActivity.c() { // from class: com.bxkj.student.home.physicaltest.scanscore.a
            @Override // cn.bluemobi.dylan.base.BaseActivity.c
            public final void onClick() {
                TestProjectScoreListActivity.this.n0();
            }
        });
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
        if (getIntent().hasExtra("meaScoreId")) {
            this.f18050a0 = getIntent().getStringExtra("meaScoreId");
        }
        this.W.setLayoutManager(new LinearLayoutManager(this.T));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, 2130772096));
        layoutAnimationController.setOrder(0);
        this.W.setLayoutAnimation(layoutAnimationController);
        a aVar = new a(this.T, R.layout.item_for_test_score_list, this.Y);
        this.Z = aVar;
        this.W.setAdapter(aVar);
        this.W.setEmptyView(findViewById(2131298892));
        m0();
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
