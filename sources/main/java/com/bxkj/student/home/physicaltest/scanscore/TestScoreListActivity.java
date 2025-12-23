package com.bxkj.student.home.physicaltest.scanscore;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
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
import com.bxkj.student.home.physicaltest.scanscore.TestScoreListActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class TestScoreListActivity extends BaseActivity {
    private SmartRefreshLayout W;
    private EmptyRecyclerView X;
    private List<Map<String, Object>> Y = new ArrayList();
    private CommonAdapter<Map<String, Object>> Z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            final String string = JsonParse.getString(stringObjectMap, "meaScoreId");
            holder.N(R.id.tv_rule, TextUtils.isEmpty(string));
            if (TextUtils.isEmpty(string)) {
                holder.J(2131298922, JsonParse.getString(stringObjectMap, "year"));
                holder.J(R.id.tv_rule, JsonParse.getString(stringObjectMap, "gradeType"));
            } else {
                holder.J(2131298922, JsonParse.getString(stringObjectMap, "year") + "年" + JsonParse.getString(stringObjectMap, "gradeType"));
            }
            holder.J(2131298986, JsonParse.getString(stringObjectMap, "stuName"));
            holder.J(2131299093, JsonParse.getString(stringObjectMap, "totalScore") + "分");
            holder.J(2131299062, JsonParse.getString(stringObjectMap, "rank"));
            holder.J(2131299116, JsonParse.getString(stringObjectMap, "meaStatus"));
            holder.N(2131297100, TextUtils.isEmpty(string) ^ true);
            holder.w(2131296688, new View.OnClickListener() { // from class: com.bxkj.student.home.physicaltest.scanscore.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TestScoreListActivity.a.this.o(string, stringObjectMap, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(String str, Map map, View view) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            TestScoreListActivity.this.startActivity(new Intent(this.f1138e, (Class<?>) TestProjectScoreListActivity.class).putExtra("meaScoreId", str).putExtra("stuName", JsonParse.getString(map, "stuName")).putExtra("stuNum", JsonParse.getString(map, "stuNum")));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            TestScoreListActivity.this.Y = (List) data.get("data");
            TestScoreListActivity.this.Z.g(TestScoreListActivity.this.Y);
        }
    }

    private void k0() {
        Http.with(this.T).setObservable(((e0.a) Http.getApiService(e0.a.class)).p0(LoginUser.getLoginUser().getUserId())).setDataListener(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        this.X.setLayoutManager(new LinearLayoutManager(this.T));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, 2130772096));
        layoutAnimationController.setOrder(0);
        this.X.setLayoutAnimation(layoutAnimationController);
        a aVar = new a(this.T, R.layout.item_for_test_score_list, this.Y);
        this.Z = aVar;
        this.X.setAdapter(aVar);
        this.W.h0(false);
        this.W.v(false);
        this.W.setOverScrollMode(2);
        this.X.setEmptyView(findViewById(2131298892));
        k0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("体测成绩汇总");
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

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
