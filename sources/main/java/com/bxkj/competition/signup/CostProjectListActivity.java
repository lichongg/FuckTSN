package com.bxkj.competition.signup;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.MultiItemCommonAdapter;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.competition.R;
import com.bxkj.competition.signup.pay.CompetitionPayActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.tencent.connect.common.Constants;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import m2.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class CostProjectListActivity extends BaseActivity {
    private MultiItemCommonAdapter<Map<String, Object>> I0;
    private String J0;
    private StickyDecoration K0;
    private String L0;
    private int M0;
    private double O0;
    private double P0;
    private int Q0;
    private StringBuilder R0;
    private SmartRefreshLayout W;
    private EmptyRecyclerView X;
    private TextView Y;
    private TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    private TextView f17420a0;

    /* renamed from: b0, reason: collision with root package name */
    private TextView f17421b0;

    /* renamed from: c0, reason: collision with root package name */
    private CheckBox f17422c0;

    /* renamed from: k0, reason: collision with root package name */
    private LinearLayout f17423k0;

    /* renamed from: p0, reason: collision with root package name */
    private List<Map<String, Object>> f17424p0 = new ArrayList();
    private int F0 = 1;
    private int G0 = 0;
    private int H0 = 10;
    private double N0 = 0.0d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements n2.e {
        a() {
        }

        @Override // n2.d
        public void a(h refreshlayout) {
            CostProjectListActivity.this.G0 = 1;
            CostProjectListActivity.this.E0();
        }

        @Override // n2.b
        public void f(h refreshlayout) {
            int i6 = CostProjectListActivity.this.F0 / CostProjectListActivity.this.H0;
            int i7 = CostProjectListActivity.this.G0;
            if (CostProjectListActivity.this.F0 % CostProjectListActivity.this.H0 != 0) {
                i6++;
            }
            if (i7 >= i6) {
                CostProjectListActivity.this.W.Q();
                CostProjectListActivity.this.g0("没有了");
            } else {
                CostProjectListActivity.u0(CostProjectListActivity.this);
                CostProjectListActivity.this.E0();
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
            return R.layout.item_for_competition_cost;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends MultiItemCommonAdapter<Map<String, Object>> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements CompoundButton.OnCheckedChangeListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Map f17428a;

            a(final Map val$stringObjectMap) {
                this.f17428a = val$stringObjectMap;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean b6) {
                this.f17428a.put("isChecked", Boolean.valueOf(b6));
                CostProjectListActivity.this.G0();
            }
        }

        c(Context x02, List x12, cn.bluemobi.dylan.base.adapter.common.recyclerview.a x22) {
            super(x02, x12, x22);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(R.id.tv_name, JsonParse.getString(stringObjectMap, "itemName"));
            int i6 = JsonParse.getInt(stringObjectMap, "operation");
            CheckBox checkBox = (CheckBox) holder.h(R.id.cb);
            if (TextUtils.isEmpty(CostProjectListActivity.this.L0)) {
                int i7 = R.id.tv_price;
                holder.N(i7, CostProjectListActivity.this.M0 == 1);
                checkBox.setChecked(JsonParse.getBoolean(stringObjectMap, "isChecked"));
                checkBox.setOnCheckedChangeListener(new a(stringObjectMap));
                checkBox.setChecked(i6 != 0);
                checkBox.setEnabled(i6 == 0);
                holder.J(i7, "￥" + JsonParse.getMoney(stringObjectMap, "itemEntryFee"));
                return;
            }
            if (i6 == 1) {
                checkBox.setChecked(true);
                checkBox.setEnabled(false);
                holder.J(R.id.tv_price, "待审核");
                return;
            }
            if (i6 == 2) {
                checkBox.setChecked(true);
                checkBox.setEnabled(false);
                holder.J(R.id.tv_price, "驳回");
                return;
            }
            if (i6 == 3) {
                checkBox.setChecked(true);
                checkBox.setEnabled(false);
                holder.J(R.id.tv_price, "院系通过");
            } else if (i6 == 4) {
                checkBox.setChecked(true);
                checkBox.setEnabled(false);
                holder.J(R.id.tv_price, "体育部审核");
            } else if (i6 == 5) {
                checkBox.setChecked(true);
                checkBox.setEnabled(false);
                holder.J(R.id.tv_price, "体育部通过");
            } else {
                checkBox.setChecked(true);
                checkBox.setEnabled(false);
                holder.J(R.id.tv_price, JsonParse.getString(stringObjectMap, NotificationCompat.CATEGORY_STATUS));
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d extends HttpCallBack {
        d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            CostProjectListActivity.this.M0 = JsonParse.getInt(data, "signupType");
            CostProjectListActivity.this.F0 = Integer.parseInt(u.O(data, "total"));
            if (CostProjectListActivity.this.M0 == 2) {
                CostProjectListActivity.this.f17420a0.setText("￥" + JsonParse.getMoney(data, "competitionEntryFee"));
            }
            CostProjectListActivity.this.O0 = JsonParse.getDouble(data, "competitionEntryFee");
            CostProjectListActivity.this.N0 = JsonParse.getDouble(data, "insuranceFee");
            CostProjectListActivity.this.f17421b0.setText("￥" + JsonParse.getMoney(data, "insuranceFee"));
            List list = (List) data.get("itemDetail");
            if (CostProjectListActivity.this.G0 == 1) {
                CostProjectListActivity.this.f17424p0 = list;
            } else {
                CostProjectListActivity.this.f17424p0.addAll(list);
            }
            CostProjectListActivity.this.I0.g(CostProjectListActivity.this.f17424p0);
            try {
                CostProjectListActivity.this.X.removeItemDecoration(CostProjectListActivity.this.K0);
            } catch (Exception e6) {
                e6.printStackTrace();
            }
            CostProjectListActivity.this.X.addItemDecoration(CostProjectListActivity.this.K0);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            CostProjectListActivity.this.W.Y();
            CostProjectListActivity.this.W.Q();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) CostProjectListActivity.this).T).setMessage(msg).show();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e extends HttpCallBack {
        e() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            CostProjectListActivity.this.F0 = Integer.parseInt(u.O(data, "total"));
            List list = (List) data.get("data");
            if (CostProjectListActivity.this.G0 == 1) {
                CostProjectListActivity.this.f17424p0 = list;
            } else {
                CostProjectListActivity.this.f17424p0.addAll(list);
            }
            CostProjectListActivity.this.I0.g(CostProjectListActivity.this.f17424p0);
            try {
                CostProjectListActivity.this.X.removeItemDecoration(CostProjectListActivity.this.K0);
            } catch (Exception e6) {
                e6.printStackTrace();
            }
            CostProjectListActivity.this.X.addItemDecoration(CostProjectListActivity.this.K0);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            CostProjectListActivity.this.W.Y();
            CostProjectListActivity.this.W.Q();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class f implements CompoundButton.OnCheckedChangeListener {
        f() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean b6) {
            CostProjectListActivity.this.G0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0() {
        Http.with(this.T).hideOtherStatusMessage().setObservable(((com.bxkj.competition.b) Http.getApiService(com.bxkj.competition.b.class)).b(this.J0, LoginUser.getLoginUser().getUserId())).setDataListener(new d());
    }

    private void F0() {
        Http.with(this.T).setObservable(((com.bxkj.competition.b) Http.getApiService(com.bxkj.competition.b.class)).h(this.J0, LoginUser.getLoginUser().getUserId())).setDataListener(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0() {
        new BigDecimal(1.0d);
        this.Q0 = 0;
        this.R0 = new StringBuilder();
        double d6 = 0.0d;
        for (Map<String, Object> map : this.f17424p0) {
            if (JsonParse.getBoolean(map, "isChecked")) {
                this.Q0++;
                d6 += new BigDecimal(JsonParse.getDouble(map, "itemEntryFee")).setScale(2, 4).doubleValue();
                if (!TextUtils.isEmpty(this.R0)) {
                    this.R0.append(",");
                }
                this.R0.append(JsonParse.getString(map, "id"));
            }
        }
        this.Z.setText("共" + this.Q0 + "项合计：");
        if (this.M0 == 2) {
            d6 = this.O0;
        }
        double d7 = this.f17422c0.isChecked() ? this.N0 : 0.0d;
        this.f17420a0.setText("￥" + new DecimalFormat("0.00").format(d6));
        this.P0 = new BigDecimal(d6).setScale(2, 4).doubleValue() + new BigDecimal(d7).setScale(2, 4).doubleValue();
        this.Y.setText("确认报名(￥" + new DecimalFormat("0.00").format(new BigDecimal(this.P0).setScale(2, 4).doubleValue()) + ")");
    }

    private void H0() {
        b bVar = new b();
        this.X.setLayoutManager(new LinearLayoutManager(this.T));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, R.anim.zoom_in));
        layoutAnimationController.setOrder(0);
        this.X.setLayoutAnimation(layoutAnimationController);
        c cVar = new c(this.T, this.f17424p0, bVar);
        this.I0 = cVar;
        this.X.setAdapter(cVar);
        this.X.setEmptyView(findViewById(R.id.tv_emptyView));
        this.K0 = new StickyDecoration(this.T, this.f17424p0);
    }

    private void I0() {
        this.W.D(new a());
    }

    static /* synthetic */ int u0(CostProjectListActivity costProjectListActivity) {
        int i6 = costProjectListActivity.G0;
        costProjectListActivity.G0 = i6 + 1;
        return i6;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.Y.setOnClickListener(this);
        this.f17422c0.setOnCheckedChangeListener(new f());
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
        this.Z = (TextView) findViewById(R.id.tv_count);
        this.f17420a0 = (TextView) findViewById(R.id.tv_price);
        this.f17421b0 = (TextView) findViewById(R.id.tv_bx_price);
        this.f17422c0 = (CheckBox) findViewById(R.id.cb_insurance);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll_bottom);
        this.f17423k0 = linearLayout;
        linearLayout.setVisibility(0);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("competitionId")) {
            this.J0 = getIntent().getStringExtra("competitionId");
        }
        if (getIntent().hasExtra(Constants.FROM)) {
            this.L0 = getIntent().getStringExtra(Constants.FROM);
        }
        I0();
        H0();
        this.W.h0(false);
        this.W.v(false);
        if (!TextUtils.isEmpty(this.L0)) {
            setTitle("我报名的竞赛项目");
            this.f17423k0.setVisibility(8);
            F0();
            return;
        }
        E0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
        double d6;
        if (v5.getId() == R.id.tv_ok) {
            if (TextUtils.isEmpty(this.R0)) {
                g0("请选择项目");
                return;
            }
            Intent putExtra = new Intent(this.T, (Class<?>) CompetitionPayActivity.class).putExtra("competitionId", this.J0).putExtra("itemIds", this.R0.toString().trim());
            if (this.f17422c0.isChecked()) {
                d6 = this.N0;
            } else {
                d6 = 0.0d;
            }
            startActivity(putExtra.putExtra("insuranceFee", d6).putExtra("competitionFee", this.O0).putExtra("totalPrice", this.P0).putExtra("payPrize", this.P0));
        }
    }

    private void D0() {
    }
}
