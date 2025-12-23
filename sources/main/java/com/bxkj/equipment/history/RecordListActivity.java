package com.bxkj.equipment.history;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.bxkj.equipment.R;
import com.bxkj.equipment.history.RecordListActivity;
import com.bxkj.equipment.i;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.List;
import java.util.Map;
import m2.h;
import n2.e;
import okhttp3.ResponseBody;
import retrofit2.c0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class RecordListActivity extends BaseActivity {
    private EmptyRecyclerView W;
    private TextView X;
    private SmartRefreshLayout Y;
    private List<Map<String, Object>> Z;

    /* renamed from: a0, reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f17494a0;

    /* renamed from: b0, reason: collision with root package name */
    private String f17495b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f17496c0 = 0;

    /* renamed from: k0, reason: collision with root package name */
    private int f17497k0 = 1;

    /* renamed from: p0, reason: collision with root package name */
    private int f17498p0 = 10;
    private int F0 = 1;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.equipment.history.RecordListActivity$a$a, reason: collision with other inner class name */
        class C0198a extends HttpCallBack {
            C0198a() {
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
                RecordListActivity.this.Y.F();
            }
        }

        a(Context x02, int x12, List x22) {
            super(x02, x12, x22);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(final Map stringObjectMap) {
            Http.with(this.f1138e).setObservable(((i) Http.getApiService(i.class)).d(LoginUser.getLoginUser().getUserId(), null, null, null, null, null, null, "6", JsonParse.getString(stringObjectMap, "id"))).setDataListener(new C0198a());
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(R.id.tv_feild_name, "器材名称：" + u.O(stringObjectMap, "equInfo"));
            holder.J(R.id.tv_day, "预计领取时间：" + u.O(stringObjectMap, "forReceiveTime"));
            holder.J(R.id.tv_time, "预计归还时间：" + u.O(stringObjectMap, "forBackTime"));
            int i6 = R.id.tv_receive_date;
            holder.N(i6, TextUtils.isEmpty(JsonParse.getString(stringObjectMap, "receiveTime")) ^ true);
            holder.J(i6, "实际领取时间：" + u.O(stringObjectMap, "receiveTime"));
            int i7 = R.id.tv_return_date;
            holder.N(i7, TextUtils.isEmpty(JsonParse.getString(stringObjectMap, "backTime")) ^ true);
            holder.J(i7, "实际归还时间：" + JsonParse.getString(stringObjectMap, "backTime"));
            holder.J(R.id.tv_type, "状态:" + JsonParse.getString(stringObjectMap, "statusStr"));
            Button button = (Button) holder.h(R.id.bt_cancel);
            button.setEnabled(JsonParse.getString(stringObjectMap, NotificationCompat.CATEGORY_STATUS).equals("0"));
            button.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.equipment.history.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RecordListActivity.a.m(RecordListActivity.a.this, stringObjectMap, view);
                }
            });
        }

        public static /* synthetic */ void m(final a aVar, final Map map, View view) {
            aVar.getClass();
            new iOSTwoButtonDialog(aVar.f1138e).setMessage("确定要取消吗？").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.equipment.history.b
                @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                public final void buttonRightOnClick() {
                    RecordListActivity.a.this.p(map);
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
            RecordListActivity.this.f17497k0 = 1;
            RecordListActivity.this.s0();
        }

        @Override // n2.b
        public void f(h refreshlayout) {
            int i6 = RecordListActivity.this.F0 / RecordListActivity.this.f17498p0;
            int i7 = RecordListActivity.this.f17497k0;
            if (RecordListActivity.this.F0 % RecordListActivity.this.f17498p0 != 0) {
                i6++;
            }
            if (i7 >= i6) {
                RecordListActivity.this.Y.Q();
                RecordListActivity.this.g0("没有了");
            } else {
                RecordListActivity.n0(RecordListActivity.this);
                RecordListActivity.this.s0();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            RecordListActivity.this.F0 = Integer.parseInt(u.O(data, "total"));
            List list = (List) data.get("data");
            if (RecordListActivity.this.f17497k0 == 1) {
                RecordListActivity.this.Z = list;
            } else {
                RecordListActivity.this.Z.addAll(list);
            }
            RecordListActivity.this.f17494a0.g(RecordListActivity.this.Z);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            RecordListActivity.this.Y.Y();
            RecordListActivity.this.Y.Q();
        }
    }

    static /* synthetic */ int n0(RecordListActivity recordListActivity) {
        int i6 = recordListActivity.f17497k0;
        recordListActivity.f17497k0 = i6 + 1;
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        rx.e<c0<ResponseBody>> c6 = ((i) Http.getApiService(i.class)).c(LoginUser.getLoginUser().getUserId(), this.f17497k0, this.f17498p0);
        if (LoginUser.getLoginUser().getUserType() == 2) {
            c6 = ((i) Http.getApiService(i.class)).a(this.f17495b0, this.f17496c0, this.f17497k0, this.f17498p0);
        }
        Http.with(this.T).hideLoadingDialog().setObservable(c6).setDataListener(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.pub_recyclerview_with_empty_view;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("我的器材申请记录");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (EmptyRecyclerView) findViewById(R.id.recyclerView);
        this.Y = (SmartRefreshLayout) findViewById(R.id.refresh);
        this.X = (TextView) findViewById(R.id.tv_emptyView);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("teacherCurriculumId")) {
            this.f17495b0 = getIntent().getStringExtra("teacherCurriculumId");
        }
        if (getIntent().hasExtra("week")) {
            this.f17496c0 = getIntent().getIntExtra("week", 0);
        }
        this.W.setLayoutManager(new LinearLayoutManager(this.T));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.T, R.anim.zoom_in));
        layoutAnimationController.setOrder(0);
        this.W.setLayoutAnimation(layoutAnimationController);
        a aVar = new a(this.T, R.layout.item_for_record_list, this.Z);
        this.f17494a0 = aVar;
        this.W.setAdapter(aVar);
        this.W.setEmptyView(this.X);
        this.Y.D(new b());
        this.Y.F();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
