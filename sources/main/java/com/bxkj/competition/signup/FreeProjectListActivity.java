package com.bxkj.competition.signup;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.MultiItemCommonAdapter;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.competition.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import m2.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class FreeProjectListActivity extends BaseActivity {
    private StickyDecoration F0;
    private String G0;
    private SmartRefreshLayout W;
    private EmptyRecyclerView X;
    private TextView Y;
    private List<Map<String, Object>> Z = new ArrayList();

    /* renamed from: a0, reason: collision with root package name */
    private int f17433a0 = 1;

    /* renamed from: b0, reason: collision with root package name */
    private int f17434b0 = 0;

    /* renamed from: c0, reason: collision with root package name */
    private int f17435c0 = 10;

    /* renamed from: k0, reason: collision with root package name */
    private MultiItemCommonAdapter<Map<String, Object>> f17436k0;

    /* renamed from: p0, reason: collision with root package name */
    private String f17437p0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements n2.e {
        a() {
        }

        @Override // n2.d
        public void a(h refreshlayout) {
            FreeProjectListActivity.this.f17434b0 = 1;
            FreeProjectListActivity.this.C0();
        }

        @Override // n2.b
        public void f(h refreshlayout) {
            int i6 = FreeProjectListActivity.this.f17433a0 / FreeProjectListActivity.this.f17435c0;
            int i7 = FreeProjectListActivity.this.f17434b0;
            if (FreeProjectListActivity.this.f17433a0 % FreeProjectListActivity.this.f17435c0 != 0) {
                i6++;
            }
            if (i7 >= i6) {
                FreeProjectListActivity.this.W.Q();
                FreeProjectListActivity.this.g0("没有了");
            } else {
                FreeProjectListActivity.v0(FreeProjectListActivity.this);
                FreeProjectListActivity.this.C0();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements cn.bluemobi.dylan.base.adapter.common.recyclerview.a<Map<String, Object>> {
        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int a(int position, Map<String, Object> stringObjectMap) {
            return 0;
        }

        b() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.a
        public int b(int itemType) {
            return R.layout.item_for_competition_project_list_free;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends MultiItemCommonAdapter<Map<String, Object>> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f17441a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ ViewHolder f17442b;

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            /* renamed from: com.bxkj.competition.signup.FreeProjectListActivity$c$a$a, reason: collision with other inner class name */
            class C0197a implements iOSTwoButtonDialog.RightButtonOnClick {
                C0197a() {
                }

                @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                public void buttonRightOnClick() {
                    a aVar = a.this;
                    c cVar = c.this;
                    FreeProjectListActivity.this.B0(cVar.e(aVar.f17442b));
                }
            }

            a(final int val$holder, final ViewHolder val$operation) {
                this.f17441a = val$holder;
                this.f17442b = val$operation;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v5) {
                if (this.f17441a != 0) {
                    new iOSTwoButtonDialog(((CommonAdapter) c.this).f1138e).setMessage("确定要取消报名吗？").setRightButtonOnClickListener(new C0197a()).show();
                } else {
                    c cVar = c.this;
                    FreeProjectListActivity.this.A0(cVar.e(this.f17442b));
                }
            }
        }

        c(Context x02, List x12, cn.bluemobi.dylan.base.adapter.common.recyclerview.a x22) {
            super(x02, x12, x22);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public void c(final ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.J(R.id.tv_name, JsonParse.getString(stringObjectMap, "itemName"));
            int i6 = JsonParse.getInt(stringObjectMap, "operation");
            int i7 = R.id.bt_ok;
            Button button = (Button) holder.h(i7);
            if (i6 == 0) {
                button.setBackground(AppCompatResources.getDrawable(this.f1138e, R.drawable.button_bg));
                button.setEnabled(true);
                holder.J(i7, "报名");
            } else if (i6 == 1) {
                button.setEnabled(true);
                button.setBackground(AppCompatResources.getDrawable(this.f1138e, R.drawable.button_red));
                button.setBackgroundColor(FreeProjectListActivity.this.getResources().getColor(R.color.color_red));
                holder.J(i7, "取消报名");
            } else if (i6 == 2) {
                button.setBackground(AppCompatResources.getDrawable(this.f1138e, R.drawable.button_bg));
                button.setEnabled(false);
                holder.J(i7, "驳回");
            } else if (i6 == 3) {
                button.setBackground(AppCompatResources.getDrawable(this.f1138e, R.drawable.button_bg));
                button.setEnabled(false);
                holder.J(i7, "院系通过");
            } else if (i6 == 4) {
                button.setBackground(AppCompatResources.getDrawable(this.f1138e, R.drawable.button_bg));
                button.setEnabled(false);
                holder.J(i7, "体育部审核");
            } else if (i6 == 5) {
                button.setBackground(AppCompatResources.getDrawable(this.f1138e, R.drawable.button_bg));
                button.setEnabled(false);
                holder.J(i7, "体育部通过");
            } else {
                button.setBackground(AppCompatResources.getDrawable(this.f1138e, R.drawable.button_bg));
                button.setEnabled(false);
                holder.J(i7, JsonParse.getString(stringObjectMap, NotificationCompat.CATEGORY_STATUS));
            }
            holder.w(i7, new a(i6, holder));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d extends HttpCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f17445a;

        d(final int val$position) {
            this.f17445a = val$position;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ((Map) FreeProjectListActivity.this.f17436k0.getItem(this.f17445a)).put("operation", 1);
            ((Map) FreeProjectListActivity.this.f17436k0.getItem(this.f17445a)).put(NotificationCompat.CATEGORY_STATUS, "待审核");
            FreeProjectListActivity.this.f17436k0.notifyItemChanged(this.f17445a);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) FreeProjectListActivity.this).T).setMessage(msg).show();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e extends HttpCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f17447a;

        e(final int val$position) {
            this.f17447a = val$position;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            if (!TextUtils.isEmpty(FreeProjectListActivity.this.G0)) {
                FreeProjectListActivity.this.f17436k0.d().remove(this.f17447a);
                FreeProjectListActivity.this.f17436k0.notifyItemRemoved(this.f17447a);
            } else {
                ((Map) FreeProjectListActivity.this.f17436k0.getItem(this.f17447a)).put("operation", 0);
                ((Map) FreeProjectListActivity.this.f17436k0.getItem(this.f17447a)).put(NotificationCompat.CATEGORY_STATUS, "未报名");
                FreeProjectListActivity.this.f17436k0.notifyItemChanged(this.f17447a);
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) FreeProjectListActivity.this).T).setMessage(msg).show();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class f extends HttpCallBack {
        f() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            FreeProjectListActivity.this.f17433a0 = Integer.parseInt(u.O(data, "total"));
            List list = (List) data.get("itemDetail");
            if (FreeProjectListActivity.this.f17434b0 == 1) {
                FreeProjectListActivity.this.Z = list;
            } else {
                FreeProjectListActivity.this.Z.addAll(list);
            }
            FreeProjectListActivity.this.f17436k0.g(FreeProjectListActivity.this.Z);
            try {
                FreeProjectListActivity.this.X.removeItemDecoration(FreeProjectListActivity.this.F0);
            } catch (Exception e6) {
                e6.printStackTrace();
            }
            FreeProjectListActivity.this.X.addItemDecoration(FreeProjectListActivity.this.F0);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            FreeProjectListActivity.this.W.Y();
            FreeProjectListActivity.this.W.Q();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) FreeProjectListActivity.this).T).setMessage(msg).show();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class g extends HttpCallBack {
        g() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            FreeProjectListActivity.this.f17433a0 = Integer.parseInt(u.O(data, "total"));
            List list = (List) data.get("data");
            if (FreeProjectListActivity.this.f17434b0 == 1) {
                FreeProjectListActivity.this.Z = list;
            } else {
                FreeProjectListActivity.this.Z.addAll(list);
            }
            FreeProjectListActivity.this.f17436k0.g(FreeProjectListActivity.this.Z);
            try {
                FreeProjectListActivity.this.X.removeItemDecoration(FreeProjectListActivity.this.F0);
            } catch (Exception e6) {
                e6.printStackTrace();
            }
            FreeProjectListActivity.this.X.addItemDecoration(FreeProjectListActivity.this.F0);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            FreeProjectListActivity.this.W.Y();
            FreeProjectListActivity.this.W.Q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(final int position) {
        Http.with(this.T).hideOtherStatusMessage().setObservable(((com.bxkj.competition.b) Http.getApiService(com.bxkj.competition.b.class)).d(JsonParse.getString(this.f17436k0.getItem(position), "id"), LoginUser.getLoginUser().getUserId())).setDataListener(new d(position));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0(final int position) {
        Http.with(this.T).hideOtherStatusMessage().setObservable(((com.bxkj.competition.b) Http.getApiService(com.bxkj.competition.b.class)).f(JsonParse.getString(this.f17436k0.getItem(position), "id"), LoginUser.getLoginUser().getUserId())).setDataListener(new e(position));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0() {
        Http.with(this.T).hideOtherStatusMessage().setObservable(((com.bxkj.competition.b) Http.getApiService(com.bxkj.competition.b.class)).b(this.f17437p0, LoginUser.getLoginUser().getUserId())).setDataListener(new f());
    }

    private void D0() {
        Http.with(this.T).setObservable(((com.bxkj.competition.b) Http.getApiService(com.bxkj.competition.b.class)).h(this.f17437p0, LoginUser.getLoginUser().getUserId())).setDataListener(new g());
    }

    private void E0() {
        b bVar = new b();
        this.X.setLayoutManager(new LinearLayoutManager(this.T));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, R.anim.zoom_in));
        layoutAnimationController.setOrder(0);
        this.X.setLayoutAnimation(layoutAnimationController);
        c cVar = new c(this.T, this.Z, bVar);
        this.f17436k0 = cVar;
        this.X.setAdapter(cVar);
        this.X.setEmptyView(findViewById(R.id.tv_emptyView));
        this.F0 = new StickyDecoration(this.T, this.Z);
    }

    private void F0() {
        this.W.D(new a());
    }

    static /* synthetic */ int v0(FreeProjectListActivity freeProjectListActivity) {
        int i6 = freeProjectListActivity.f17434b0;
        freeProjectListActivity.f17434b0 = i6 + 1;
        return i6;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.Y.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_competition_project_list;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("竞赛报名项目列表");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (SmartRefreshLayout) findViewById(R.id.refresh);
        this.X = (EmptyRecyclerView) findViewById(R.id.recyclerView);
        this.Y = (TextView) findViewById(R.id.tv_ok);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("competitionId")) {
            this.f17437p0 = getIntent().getStringExtra("competitionId");
        }
        if (getIntent().hasExtra(Constants.FROM)) {
            this.G0 = getIntent().getStringExtra(Constants.FROM);
        }
        F0();
        E0();
        this.W.h0(false);
        this.W.v(false);
        if (!TextUtils.isEmpty(this.G0)) {
            setTitle("我报名的竞赛项目");
            D0();
        } else {
            C0();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
