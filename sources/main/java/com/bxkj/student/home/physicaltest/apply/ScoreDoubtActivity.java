package com.bxkj.student.home.physicaltest.apply;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
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
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class ScoreDoubtActivity extends BaseActivity {
    private List<Map<String, Object>> W;
    private EmptyRecyclerView X;
    private TextView Y;
    private CommonAdapter<Map<String, Object>> Z;

    /* renamed from: a0, reason: collision with root package name */
    private String f17931a0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements BaseActivity.c {
        a() {
        }

        @Override // cn.bluemobi.dylan.base.BaseActivity.c
        public void onClick() {
            ScoreDoubtActivity scoreDoubtActivity = ScoreDoubtActivity.this;
            scoreDoubtActivity.startActivity(scoreDoubtActivity.getIntent().setClass(((BaseActivity) ScoreDoubtActivity.this).T, ApplyScoreDoubtActivity.class));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends CommonAdapter<Map<String, Object>> {
        b(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.J(2131298922, JsonParse.getString(stringObjectMap, "year"));
            holder.J(2131299053, JsonParse.getString(stringObjectMap, "examName"));
            holder.J(2131299093, "原始成绩:" + JsonParse.getString(stringObjectMap, "rawScores"));
            holder.J(2131299062, "申诉成绩:" + JsonParse.getString(stringObjectMap, "complaintResults"));
            holder.J(2131299158, JsonParse.getString(stringObjectMap, "createTime"));
            holder.J(2131299116, JsonParse.getString(stringObjectMap, NotificationCompat.CATEGORY_STATUS));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ScoreDoubtActivity.this.W = JsonParse.getList(data, "data");
            ScoreDoubtActivity.this.Z.g(ScoreDoubtActivity.this.W);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(ViewGroup viewGroup, View view, Object obj, int i6) {
        startActivity(new Intent(this.T, (Class<?>) ApplyTestScoreDetailActivity.class).putExtra("id", JsonParse.getString(this.Z.getItem(i6), "id")));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.Z.k(new cn.bluemobi.dylan.base.adapter.common.recyclerview.b() { // from class: com.bxkj.student.home.physicaltest.apply.c
            @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
            public final void a(ViewGroup viewGroup, View view, Object obj, int i6) {
                ScoreDoubtActivity.this.n0(viewGroup, view, obj, i6);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("我的体测成绩申诉列表");
        a0(2131231169, new a());
    }

    public void m0() {
        Http.with(this.T).setObservable(((e0.a) Http.getApiService(e0.a.class)).H0(LoginUser.getLoginUser().getUserId(), this.f17931a0)).setDataListener(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return 2131493639;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("meaScoreId")) {
            this.f17931a0 = getIntent().getStringExtra("meaScoreId");
        }
        this.X.setLayoutManager(new LinearLayoutManager(this.T));
        b bVar = new b(this.T, R.layout.item_for_apply_test_score_list, this.W);
        this.Z = bVar;
        this.X.setAdapter(bVar);
        this.Y.setText("如果对成绩有异议，请点击右上角+号反馈");
        this.X.setEmptyView(this.Y);
        m0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.X = (EmptyRecyclerView) findViewById(2131298351);
        this.Y = (TextView) findViewById(2131298892);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
