package com.bxkj.student.home.physicaltest.personal.record;

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
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
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
public class MyReservationListActivity extends BaseActivity {
    private SmartRefreshLayout W;
    private EmptyRecyclerView X;
    private List<Map<String, Object>> Y = new ArrayList();
    private int Z = 1;

    /* renamed from: a0, reason: collision with root package name */
    private int f18014a0 = 1;

    /* renamed from: b0, reason: collision with root package name */
    private int f18015b0 = 10;

    /* renamed from: c0, reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f18016c0;

    /* renamed from: k0, reason: collision with root package name */
    private long f18017k0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements e {
        a() {
        }

        @Override // n2.d
        public void a(h refreshlayout) {
            MyReservationListActivity.this.f18014a0 = 1;
            MyReservationListActivity.this.s0();
        }

        @Override // n2.b
        public void f(h refreshlayout) {
            int i6 = MyReservationListActivity.this.Z / MyReservationListActivity.this.f18015b0;
            int i7 = MyReservationListActivity.this.f18014a0;
            if (MyReservationListActivity.this.Z % MyReservationListActivity.this.f18015b0 != 0) {
                i6++;
            }
            if (i7 >= i6) {
                MyReservationListActivity.this.W.Q();
                MyReservationListActivity.this.g0("没有了");
            } else {
                MyReservationListActivity.this.f18014a0++;
                MyReservationListActivity.this.s0();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends CommonAdapter<Map<String, Object>> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Map f18020a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ ViewHolder f18021b;

            a(final Map val$stringObjectMap, final ViewHolder val$holder) {
                this.f18020a = val$stringObjectMap;
                this.f18021b = val$holder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v5) {
                MyReservationListActivity.this.startActivity(new Intent(((CommonAdapter) b.this).f1138e, (Class<?>) MyReservationDetailActivity.class).putExtra("id", JsonParse.getString(this.f18020a, "id")).putExtra("position", this.f18021b.f()));
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.student.home.physicaltest.personal.record.MyReservationListActivity$b$b, reason: collision with other inner class name */
        class ViewOnClickListenerC0212b implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Map f18023a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ ViewHolder f18024b;

            ViewOnClickListenerC0212b(final Map val$stringObjectMap, final ViewHolder val$holder) {
                this.f18023a = val$stringObjectMap;
                this.f18024b = val$holder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v5) {
                b bVar = b.this;
                MyReservationListActivity.this.t0(((CommonAdapter) bVar).f1138e, JsonParse.getString(this.f18023a, "id"), this.f18024b.f());
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
            if ("0".equals(string)) {
                holder.J(R.id.tv_femail, "混合:" + JsonParse.getInt(stringObjectMap, "totalAppliedNumber") + "/" + JsonParse.getInt(stringObjectMap, "totalNumber"));
            } else if ("1".equals(string)) {
                holder.J(R.id.tv_femail, "男生：" + JsonParse.getInt(stringObjectMap, "maleAppliedNumber") + "/" + JsonParse.getInt(stringObjectMap, "totalNumber"));
            } else if ("2".equals(string)) {
                holder.J(R.id.tv_femail, "女生：" + JsonParse.getInt(stringObjectMap, "femaleAppliedNumber") + "/" + JsonParse.getInt(stringObjectMap, "totalNumber"));
            } else if ("3".equals(string)) {
                holder.J(R.id.tv_femail, "比例:男:" + JsonParse.getString(stringObjectMap, "maleAppliedNumber") + "/" + JsonParse.getInt(stringObjectMap, "totalNumber") + "\u3000女:" + JsonParse.getString(stringObjectMap, "femaleAppliedNumber") + "/" + JsonParse.getString(stringObjectMap, "totalNumber"));
            }
            holder.J(2131299171, "2".equals(JsonParse.getString(stringObjectMap, "appointmentType")) ? "个人预约" : "班长预约");
            holder.w(R.id.bt_detail, new a(stringObjectMap, holder));
            Button button = (Button) holder.h(R.id.bt_reservation);
            button.setText("取消预约");
            try {
                if (MyReservationListActivity.this.f18017k0 > new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(JsonParse.getString(stringObjectMap, "meaBeginTime")).getTime()) {
                    button.setText("体测已开始");
                    button.setEnabled(false);
                } else {
                    button.setEnabled(true);
                    button.setText("取消预约");
                }
            } catch (ParseException e6) {
                e6.printStackTrace();
            }
            button.setOnClickListener(new ViewOnClickListenerC0212b(stringObjectMap, holder));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            MyReservationListActivity.this.W.Y();
            MyReservationListActivity.this.W.Q();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            MyReservationListActivity.this.f18017k0 = Long.parseLong(JsonParse.getString(data, "currentTime"));
            MyReservationListActivity.this.Y = (List) data.get("meaScheduleList");
            MyReservationListActivity.this.f18016c0.g(MyReservationListActivity.this.Y);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements iOSTwoButtonDialog.RightButtonOnClick {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f18027a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f18028b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f18029c;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a extends HttpCallBack {
            a() {
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
                MyReservationListActivity.this.g0("取消预约成功");
                MyReservationListActivity.this.f18016c0.d().remove(MyReservationListActivity.this.f18016c0.getItem(d.this.f18029c));
                MyReservationListActivity.this.f18016c0.notifyItemRemoved(d.this.f18029c);
                Activity activity = cn.bluemobi.dylan.base.utils.a.n().getActivity(MyReservationDetailActivity.class);
                if (activity != null) {
                    activity.finish();
                }
            }
        }

        d(final Context val$mContext, final String val$id, final int val$position) {
            this.f18027a = val$mContext;
            this.f18028b = val$id;
            this.f18029c = val$position;
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            Http.with(this.f18027a).setObservable(((e0.a) Http.getApiService(e0.a.class)).M0(this.f18028b, LoginUser.getLoginUser().getUserId())).setDataListener(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        Http.with(this.T).hideLoadingDialog().setObservable(((e0.a) Http.getApiService(e0.a.class)).I0(LoginUser.getLoginUser().getUserId(), "1", this.f18014a0, this.f18015b0)).setDataListener(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        this.W.D(new a());
        this.X.setLayoutManager(new LinearLayoutManager(this.T));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, 2130772096));
        layoutAnimationController.setOrder(0);
        this.X.setLayoutAnimation(layoutAnimationController);
        b bVar = new b(this.T, R.layout.item_for_reserve_list, this.Y);
        this.f18016c0 = bVar;
        this.X.setAdapter(bVar);
        this.W.h0(true);
        this.W.v(true);
        this.W.F();
        this.X.setEmptyView(findViewById(2131298892));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("我的预约体测列表");
    }

    public void t0(final Context mContext, final String id, final int position) {
        new iOSTwoButtonDialog(mContext).setTitle("提示").setMessage("确定要取消预约吗？").setRightButtonOnClickListener(new d(mContext, id, position)).show();
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
