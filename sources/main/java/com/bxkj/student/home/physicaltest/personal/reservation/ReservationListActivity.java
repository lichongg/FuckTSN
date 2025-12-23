package com.bxkj.student.home.physicaltest.personal.reservation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
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
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import m2.h;
import n2.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class ReservationListActivity extends BaseActivity {
    private SmartRefreshLayout W;
    private EmptyRecyclerView X;
    private List<Map<String, Object>> Y = new ArrayList();
    private int Z = 1;

    /* renamed from: a0, reason: collision with root package name */
    private int f18035a0 = 1;

    /* renamed from: b0, reason: collision with root package name */
    private int f18036b0 = 10;

    /* renamed from: c0, reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f18037c0;

    /* renamed from: k0, reason: collision with root package name */
    private long f18038k0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements e {
        a() {
        }

        @Override // n2.d
        public void a(h refreshlayout) {
            ReservationListActivity.this.f18035a0 = 1;
            ReservationListActivity.this.s0();
        }

        @Override // n2.b
        public void f(h refreshlayout) {
            int i6 = ReservationListActivity.this.Z / ReservationListActivity.this.f18036b0;
            int i7 = ReservationListActivity.this.f18035a0;
            if (ReservationListActivity.this.Z % ReservationListActivity.this.f18036b0 != 0) {
                i6++;
            }
            if (i7 >= i6) {
                ReservationListActivity.this.W.Q();
                ReservationListActivity.this.g0("没有了");
            } else {
                ReservationListActivity.this.f18035a0++;
                ReservationListActivity.this.s0();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends CommonAdapter<Map<String, Object>> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Map f18041a;

            a(final Map val$stringObjectMap) {
                this.f18041a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v5) {
                ReservationListActivity.this.startActivity(new Intent(((CommonAdapter) b.this).f1138e, (Class<?>) ReservationDetailActivity.class).putExtra("id", JsonParse.getString(this.f18041a, "id")));
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.student.home.physicaltest.personal.reservation.ReservationListActivity$b$b, reason: collision with other inner class name */
        class ViewOnClickListenerC0214b implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Map f18043a;

            ViewOnClickListenerC0214b(final Map val$stringObjectMap) {
                this.f18043a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v5) {
                b bVar = b.this;
                ReservationListActivity.this.t0(((CommonAdapter) bVar).f1138e, JsonParse.getString(this.f18043a, "id"));
            }
        }

        b(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(2131298922, JsonParse.getString(stringObjectMap, "scheduleName"));
            holder.J(R.id.tv_reserve_time, JsonParse.getString(stringObjectMap, "appointmentBeginTime") + com.snail.antifake.deviceid.e.f37542d + JsonParse.getString(stringObjectMap, "appointmentEndTime"));
            holder.J(R.id.tv_measure_time, JsonParse.getString(stringObjectMap, "meaBeginTime") + com.snail.antifake.deviceid.e.f37542d + JsonParse.getString(stringObjectMap, "meaEndTime"));
            String string = JsonParse.getString(stringObjectMap, "classType");
            if (string.equals("0")) {
                holder.J(R.id.tv_femail, "混合:" + JsonParse.getInt(stringObjectMap, "totalAppliedNumber") + "/" + JsonParse.getInt(stringObjectMap, "totalNumber"));
            } else if (string.equals("1")) {
                holder.J(R.id.tv_femail, "男生：" + JsonParse.getInt(stringObjectMap, "maleAppliedNumber") + "/" + JsonParse.getInt(stringObjectMap, "totalNumber"));
            } else if (string.equals("2")) {
                holder.J(R.id.tv_femail, "女生：" + JsonParse.getInt(stringObjectMap, "femaleAppliedNumber") + "/" + JsonParse.getInt(stringObjectMap, "totalNumber"));
            } else if (string.equals("3")) {
                holder.J(R.id.tv_femail, "比例:男:" + JsonParse.getString(stringObjectMap, "maleAppliedNumber") + "/" + JsonParse.getInt(stringObjectMap, "maleTotalNumber") + "\u3000女:" + JsonParse.getString(stringObjectMap, "femaleAppliedNumber") + "/" + JsonParse.getString(stringObjectMap, "femaleTotalNumber"));
            }
            holder.J(2131299171, JsonParse.getString(stringObjectMap, "appointmentType").equals("2") ? "个人预约" : "班长预约");
            holder.w(R.id.bt_detail, new a(stringObjectMap));
            Button button = (Button) holder.h(R.id.bt_reservation);
            String string2 = JsonParse.getString(stringObjectMap, "appointmentEndTime");
            if ("1".equals(JsonParse.getString(stringObjectMap, "ismeastate"))) {
                button.setText("已预约");
                button.setEnabled(false);
            } else {
                try {
                    if (ReservationListActivity.this.f18038k0 >= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(string2).getTime()) {
                        button.setText("预约已结束");
                        button.setEnabled(false);
                    } else if (JsonParse.getInt(stringObjectMap, "totalAppliedNumber") >= JsonParse.getInt(stringObjectMap, "totalNumber")) {
                        button.setText("预约人数已满");
                        button.setEnabled(false);
                    } else {
                        button.setEnabled(true);
                        button.setText("立即预约");
                    }
                } catch (ParseException e6) {
                    e6.printStackTrace();
                }
            }
            button.setOnClickListener(new ViewOnClickListenerC0214b(stringObjectMap));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            ReservationListActivity.this.W.Y();
            ReservationListActivity.this.W.Q();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ReservationListActivity.this.f18038k0 = Long.parseLong(JsonParse.getString(data, "currentTime"));
            ReservationListActivity.this.Y = (List) data.get("meaScheduleList");
            ReservationListActivity.this.f18037c0.g(ReservationListActivity.this.Y);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d extends HttpCallBack {
        d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ReservationListActivity.this.g0("预约成功");
            ReservationListActivity.this.s0();
            ReservationDetailActivity reservationDetailActivity = (ReservationDetailActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(ReservationDetailActivity.class);
            if (reservationDetailActivity != null) {
                reservationDetailActivity.S();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        Http.with(this.T).setObservable(((e0.a) Http.getApiService(e0.a.class)).O0(LoginUser.getLoginUser().getUserId(), "2", this.f18035a0, this.f18036b0)).setDataListener(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        this.W.D(new a());
        this.X.setLayoutManager(new LinearLayoutManager(this.T));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, 2130772096));
        layoutAnimationController.setOrder(0);
        this.X.setLayoutAnimation(layoutAnimationController);
        b bVar = new b(this.T, R.layout.item_for_reserve_list, this.Y);
        this.f18037c0 = bVar;
        this.X.setAdapter(bVar);
        this.W.h0(true);
        this.W.v(true);
        this.W.F();
        this.X.setEmptyView(findViewById(2131298892));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("预约体测列表");
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

    public void t0(Context mContext, String id) {
        Http.with(mContext).setObservable(((e0.a) Http.getApiService(e0.a.class)).b1(id, LoginUser.getLoginUser().getUserId())).setDataListener(new d());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
