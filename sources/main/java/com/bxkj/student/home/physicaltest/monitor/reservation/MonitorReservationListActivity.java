package com.bxkj.student.home.physicaltest.monitor.reservation;

import android.app.Activity;
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
public class MonitorReservationListActivity extends BaseActivity {
    private SmartRefreshLayout W;
    private EmptyRecyclerView X;
    private List<Map<String, Object>> Y = new ArrayList();
    private int Z = 1;

    /* renamed from: a0, reason: collision with root package name */
    private int f18000a0 = 1;

    /* renamed from: b0, reason: collision with root package name */
    private int f18001b0 = 10;

    /* renamed from: c0, reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f18002c0;

    /* renamed from: k0, reason: collision with root package name */
    private long f18003k0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements e {
        a() {
        }

        @Override // n2.d
        public void a(h refreshlayout) {
            MonitorReservationListActivity.this.f18000a0 = 1;
            MonitorReservationListActivity.this.s0();
        }

        @Override // n2.b
        public void f(h refreshlayout) {
            int i6 = MonitorReservationListActivity.this.Z / MonitorReservationListActivity.this.f18001b0;
            int i7 = MonitorReservationListActivity.this.f18000a0;
            if (MonitorReservationListActivity.this.Z % MonitorReservationListActivity.this.f18001b0 != 0) {
                i6++;
            }
            if (i7 >= i6) {
                MonitorReservationListActivity.this.W.Q();
                MonitorReservationListActivity.this.g0("没有了");
            } else {
                MonitorReservationListActivity.this.f18000a0++;
                MonitorReservationListActivity.this.s0();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends CommonAdapter<Map<String, Object>> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Map f18006a;

            a(final Map val$stringObjectMap) {
                this.f18006a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v5) {
                MonitorReservationListActivity.this.startActivity(new Intent(((CommonAdapter) b.this).f1138e, (Class<?>) MonitorReservationDetailActivity.class).putExtra("id", JsonParse.getString(this.f18006a, "id")));
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.student.home.physicaltest.monitor.reservation.MonitorReservationListActivity$b$b, reason: collision with other inner class name */
        class ViewOnClickListenerC0211b implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Map f18008a;

            ViewOnClickListenerC0211b(final Map val$stringObjectMap) {
                this.f18008a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v5) {
                b bVar = b.this;
                MonitorReservationListActivity.this.t0(((CommonAdapter) bVar).f1138e, JsonParse.getString(this.f18008a, "id"));
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
            holder.J(R.id.tv_femail, "班级数:" + JsonParse.getString(stringObjectMap, "appliedClasses") + "/" + JsonParse.getInt(stringObjectMap, "appClassAmount"));
            holder.J(2131299171, JsonParse.getString(stringObjectMap, "appointmentType").equals("2") ? "个人预约" : "班长预约");
            holder.w(R.id.bt_detail, new a(stringObjectMap));
            Button button = (Button) holder.h(R.id.bt_reservation);
            try {
                if (MonitorReservationListActivity.this.f18003k0 >= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(JsonParse.getString(stringObjectMap, "appointmentEndTime")).getTime()) {
                    button.setText("预约已结束");
                    button.setEnabled(false);
                } else if (JsonParse.getInt(stringObjectMap, "appliedClasses") >= JsonParse.getInt(stringObjectMap, "appClassAmount")) {
                    button.setText("预约班级已满");
                    button.setEnabled(false);
                } else {
                    button.setEnabled(true);
                    button.setText("立即预约");
                }
            } catch (ParseException e6) {
                e6.printStackTrace();
            }
            button.setOnClickListener(new ViewOnClickListenerC0211b(stringObjectMap));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            MonitorReservationListActivity.this.W.Y();
            MonitorReservationListActivity.this.W.Q();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            MonitorReservationListActivity.this.f18003k0 = Long.parseLong(JsonParse.getString(data, "currentTime"));
            MonitorReservationListActivity.this.Y = (List) data.get("meaScheduleList");
            MonitorReservationListActivity.this.f18002c0.g(MonitorReservationListActivity.this.Y);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d extends HttpCallBack {
        d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            MonitorReservationListActivity.this.g0("预约成功");
            Activity activity = cn.bluemobi.dylan.base.utils.a.n().getActivity(MonitorReservationDetailActivity.class);
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        Http.with(this.T).setObservable(((e0.a) Http.getApiService(e0.a.class)).k0(LoginUser.getLoginUser().getUserId(), this.f18000a0, this.f18001b0)).setDataListener(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        this.W.D(new a());
        this.X.setLayoutManager(new LinearLayoutManager(this.T));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, 2130772096));
        layoutAnimationController.setOrder(0);
        this.X.setLayoutAnimation(layoutAnimationController);
        b bVar = new b(this.T, R.layout.item_for_reserve_list, this.Y);
        this.f18002c0 = bVar;
        this.X.setAdapter(bVar);
        this.W.h0(true);
        this.W.v(false);
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
