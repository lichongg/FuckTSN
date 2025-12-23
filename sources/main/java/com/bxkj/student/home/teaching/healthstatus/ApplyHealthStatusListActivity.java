package com.bxkj.student.home.teaching.healthstatus;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class ApplyHealthStatusListActivity extends BaseActivity {
    private List<Map<String, Object>> W = new ArrayList();
    private EmptyRecyclerView X;
    private CommonAdapter<Map<String, Object>> Y;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements BaseActivity.c {
        a() {
        }

        @Override // cn.bluemobi.dylan.base.BaseActivity.c
        public void onClick() {
            ApplyHealthStatusListActivity.this.startActivity(new Intent(((BaseActivity) ApplyHealthStatusListActivity.this).T, (Class<?>) ApplyHealthStudentActivity.class));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends CommonAdapter<Map<String, Object>> {
        b(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(2131298986, JsonParse.getString(stringObjectMap, "applyerName"));
            holder.J(R.id.tv_team, JsonParse.getString(stringObjectMap, "applyDate"));
            holder.J(2131299171, JsonParse.getString(stringObjectMap, "type"));
            holder.J(2131299116, JsonParse.getString(stringObjectMap, NotificationCompat.CATEGORY_STATUS));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ApplyHealthStatusListActivity.this.W = JsonParse.getList(data, "data");
            ApplyHealthStatusListActivity.this.Y.g(ApplyHealthStatusListActivity.this.W);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(ViewGroup viewGroup, View view, Object obj, int i6) {
        startActivity(new Intent(this.T, (Class<?>) ApplyHealthStatusDetailActivity.class).putExtra("id", JsonParse.getString(this.Y.getItem(i6), "id")));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.Y.k(new cn.bluemobi.dylan.base.adapter.common.recyclerview.b() { // from class: com.bxkj.student.home.teaching.healthstatus.b
            @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
            public final void a(ViewGroup viewGroup, View view, Object obj, int i6) {
                ApplyHealthStatusListActivity.this.n0(viewGroup, view, obj, i6);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        this.X.setLayoutManager(new LinearLayoutManager(this.T));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.T, 2130772096));
        layoutAnimationController.setOrder(0);
        this.X.setLayoutAnimation(layoutAnimationController);
        b bVar = new b(this.T, R.layout.item_for_apply_mc_list, this.W);
        this.Y = bVar;
        this.X.setAdapter(bVar);
        this.X.setEmptyView(findViewById(2131298892));
        m0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("状态申请列表");
        a0(2131231169, new a());
    }

    public void m0() {
        Http.with(this.T).setObservable(((e0.a) Http.getApiService(e0.a.class)).l(LoginUser.getLoginUser().getUserId())).setDataListener(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return 2131493639;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.X = (EmptyRecyclerView) findViewById(2131298351);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
