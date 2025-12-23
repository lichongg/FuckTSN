package com.bxkj.place.history;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.place.R;
import com.bxkj.place.history.ApplyHistoryListActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.List;
import java.util.Map;
import m2.h;
import n2.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class ApplyHistoryListActivity extends BaseActivity {
    private int W;
    private EmptyRecyclerView X;
    private TextView Y;
    private SmartRefreshLayout Z;

    /* renamed from: a0, reason: collision with root package name */
    private List<Map<String, Object>> f17555a0;

    /* renamed from: b0, reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f17556b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f17557c0 = 1;

    /* renamed from: k0, reason: collision with root package name */
    private int f17558k0 = 10;

    /* renamed from: p0, reason: collision with root package name */
    private int f17559p0 = 1;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.place.history.ApplyHistoryListActivity$a$a, reason: collision with other inner class name */
        class C0200a extends HttpCallBack {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Map f17561a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ ViewHolder f17562b;

            C0200a(final Map val$holder, final ViewHolder val$stringObjectMap) {
                this.f17561a = val$holder;
                this.f17562b = val$stringObjectMap;
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
                this.f17561a.put(NotificationCompat.CATEGORY_STATUS, 2);
                a.this.notifyItemChanged(this.f17562b.f());
            }
        }

        a(Context x02, int x12, List x22) {
            super(x02, x12, x22);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(final Map stringObjectMap, final ViewHolder holder) {
            Http.with(this.f1138e).setObservable(((d0.b) Http.getApiService(d0.b.class)).c(LoginUser.getLoginUser().getUserId(), JsonParse.getString(stringObjectMap, "fieldPlanDateId"), JsonParse.getString(stringObjectMap, "detailId"), "2")).setDataListener(new C0200a(stringObjectMap, holder));
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(R.id.tv_feild_name, "场地名称：" + u.O(stringObjectMap, "fieldname"));
            holder.J(R.id.tv_day, "时间：" + u.O(stringObjectMap, "date"));
            holder.J(R.id.tv_time, u.O(stringObjectMap, "starttime") + "-" + u.O(stringObjectMap, "stoptime"));
            holder.J(R.id.tv_type, "状态:" + JsonParse.getString(stringObjectMap, "statusStr"));
            holder.J(R.id.tv_status, "签到状态:" + JsonParse.getString(stringObjectMap, "signStatusStr"));
            Button button = (Button) holder.h(R.id.bt_cancel);
            String string = JsonParse.getString(stringObjectMap, "isCanCancel");
            String string2 = JsonParse.getString(stringObjectMap, NotificationCompat.CATEGORY_STATUS);
            if (string.equals("1") && string2.equals("1")) {
                button.setEnabled(true);
                button.setText(ApplyHistoryListActivity.this.W == 2 ? "取消申请" : "取消预约");
            } else {
                button.setEnabled(false);
                button.setText("取消");
            }
            button.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.place.history.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ApplyHistoryListActivity.a.m(ApplyHistoryListActivity.a.this, stringObjectMap, holder, view);
                }
            });
        }

        public static /* synthetic */ void m(final a aVar, final Map map, final ViewHolder viewHolder, View view) {
            aVar.getClass();
            new iOSTwoButtonDialog(aVar.f1138e).setMessage("确定要取消吗？").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.place.history.b
                @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                public final void buttonRightOnClick() {
                    ApplyHistoryListActivity.a.this.p(map, viewHolder);
                }
            }).show();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements e {
        b() {
        }

        @Override // n2.d
        public void a(h refreshlayout) {
            ApplyHistoryListActivity.this.f17557c0 = 1;
            ApplyHistoryListActivity.this.t0();
        }

        @Override // n2.b
        public void f(h refreshlayout) {
            int i6 = ApplyHistoryListActivity.this.f17559p0 / ApplyHistoryListActivity.this.f17558k0;
            int i7 = ApplyHistoryListActivity.this.f17557c0;
            if (ApplyHistoryListActivity.this.f17559p0 % ApplyHistoryListActivity.this.f17558k0 != 0) {
                i6++;
            }
            if (i7 >= i6) {
                ApplyHistoryListActivity.this.Z.Q();
                ApplyHistoryListActivity.this.g0("没有了");
            } else {
                ApplyHistoryListActivity.n0(ApplyHistoryListActivity.this);
                ApplyHistoryListActivity.this.t0();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ApplyHistoryListActivity.this.f17559p0 = Integer.parseInt(u.O(data, "total"));
            List list = (List) data.get("data");
            if (ApplyHistoryListActivity.this.f17557c0 == 1) {
                ApplyHistoryListActivity.this.f17555a0 = list;
            } else {
                ApplyHistoryListActivity.this.f17555a0.addAll(list);
            }
            ApplyHistoryListActivity.this.f17556b0.g(ApplyHistoryListActivity.this.f17555a0);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            ApplyHistoryListActivity.this.Z.Y();
            ApplyHistoryListActivity.this.Z.Q();
        }
    }

    static /* synthetic */ int n0(ApplyHistoryListActivity applyHistoryListActivity) {
        int i6 = applyHistoryListActivity.f17557c0;
        applyHistoryListActivity.f17557c0 = i6 + 1;
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0() {
        Http.with(this.T).hideLoadingDialog().setObservable(((d0.b) Http.getApiService(d0.b.class)).a(LoginUser.getLoginUser().getUserId(), this.W, this.f17557c0, this.f17558k0)).setDataListener(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.pub_recyclerview_with_empty_view;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("我的申请记录");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.X = (EmptyRecyclerView) findViewById(R.id.recyclerView);
        this.Z = (SmartRefreshLayout) findViewById(R.id.refresh);
        this.Y = (TextView) findViewById(R.id.tv_emptyView);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        String str;
        if (getIntent().hasExtra("appointType")) {
            this.W = getIntent().getIntExtra("appointType", 1);
        }
        if (this.W == 2) {
            str = "我的场馆申请记录";
        } else {
            str = "我的场馆预约记录";
        }
        setTitle(str);
        this.X.setLayoutManager(new LinearLayoutManager(this.T));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.T, R.anim.zoom_in));
        layoutAnimationController.setOrder(0);
        this.X.setLayoutAnimation(layoutAnimationController);
        a aVar = new a(this.T, R.layout.item_for_apply_place_list, this.f17555a0);
        this.f17556b0 = aVar;
        this.X.setAdapter(aVar);
        this.X.setEmptyView(this.Y);
        this.Z.D(new b());
        this.Z.F();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
