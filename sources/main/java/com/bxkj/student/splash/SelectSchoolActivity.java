package com.bxkj.student.splash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.DividerItemDecoration;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.v2.common.utils.c0;
import com.bxkj.base.v2.data.b;
import com.bxkj.student.MainActivity;
import com.bxkj.student.R;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class SelectSchoolActivity extends BaseActivity {
    private List<Map<String, Object>> W;
    private RecyclerView X;
    private CommonAdapter<Map<String, Object>> Y;
    private List<Map<String, Object>> Z;

    /* renamed from: a0, reason: collision with root package name */
    private RecyclerView f20448a0;

    /* renamed from: b0, reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f20449b0;

    /* renamed from: c0, reason: collision with root package name */
    private TextView f20450c0;

    /* renamed from: k0, reason: collision with root package name */
    private iOSTwoButtonDialog f20451k0;

    /* renamed from: p0, reason: collision with root package name */
    private int f20452p0 = 0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.J(2131298986, JsonParse.getString(stringObjectMap, "province_name"));
            holder.q(R.id.iv, holder.f() == SelectSchoolActivity.this.f20452p0 ? SelectSchoolActivity.this.getResources().getDrawable(2131231950) : null);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends CommonAdapter<Map<String, Object>> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ViewHolder f20455a;

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            /* renamed from: com.bxkj.student.splash.SelectSchoolActivity$b$a$a, reason: collision with other inner class name */
            class C0274a implements iOSTwoButtonDialog.RightButtonOnClick {
                C0274a() {
                }

                @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                public void buttonRightOnClick() {
                    try {
                        LoginUser.getLoginUser().setSchoolName(JsonParse.getString((Map) SelectSchoolActivity.this.f20449b0.getItem(a.this.f20455a.f()), "school_name"));
                        LoginUser.getLoginUser().setServerUrl(JsonParse.getString((Map) SelectSchoolActivity.this.f20449b0.getItem(a.this.f20455a.f()), "school_url"));
                        LoginUser.getLoginUser().setSchoolId(JsonParse.getString((Map) SelectSchoolActivity.this.f20449b0.getItem(a.this.f20455a.f()), "school_id"));
                        LoginUser.getLoginUser().setIsOpenEncry(JsonParse.getString((Map) SelectSchoolActivity.this.f20449b0.getItem(a.this.f20455a.f()), "isOpenEncry"));
                        LoginUser.getLoginUser().setSysType(JsonParse.getInt((Map) SelectSchoolActivity.this.f20449b0.getItem(a.this.f20455a.f()), "sysType"));
                        LoginUser.getLoginUser().setIsOpenKeep(JsonParse.getInt((Map) SelectSchoolActivity.this.f20449b0.getItem(a.this.f20455a.f()), "isOpenKeep"));
                        b.a aVar = com.bxkj.base.v2.data.b.f16998d;
                        com.bxkj.base.v2.data.b a6 = aVar.a();
                        c0 c0Var = c0.f16887a;
                        a6.O0(c0Var.t((Map) SelectSchoolActivity.this.f20449b0.getItem(a.this.f20455a.f()), "school_name"));
                        aVar.a().M0(c0Var.t((Map) SelectSchoolActivity.this.f20449b0.getItem(a.this.f20455a.f()), "schoolCode"));
                        aVar.a().G0(c0Var.k((Map) SelectSchoolActivity.this.f20449b0.getItem(a.this.f20455a.f()), "isOpenLive"));
                        aVar.a().I0(c0Var.l((Map) SelectSchoolActivity.this.f20449b0.getItem(a.this.f20455a.f()), "isOpenSQZS", 1));
                        String u5 = c0Var.u((Map) SelectSchoolActivity.this.f20449b0.getItem(a.this.f20455a.f()), "lan_url", com.bxkj.student.v2.retrofit.b.f21275a.a());
                        if (LoginUser.getLoginUser().getSysType() == 2) {
                            aVar.a().P0(u5);
                            com.bxkj.student.v2.retrofit.e.f21288a.b();
                        } else {
                            Http.changeBaseUrl(LoginUser.getLoginUser().getServerUrl());
                            LoginUser.getLoginUser().setAppId(JsonParse.getString((Map) SelectSchoolActivity.this.f20449b0.getItem(a.this.f20455a.f()), "openId"));
                        }
                        ((CommonAdapter) b.this).f1138e.startActivity(new Intent(((CommonAdapter) b.this).f1138e, (Class<?>) SplashActivity.class));
                        new HashSet().add(LoginUser.getLoginUser().getSchoolName());
                        SelectSchoolActivity.this.finish();
                    } catch (Exception e6) {
                        com.orhanobut.logger.j.c(e6.getMessage());
                    }
                }
            }

            a(final ViewHolder val$holder) {
                this.f20455a = val$holder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v5) {
                new iOSTwoButtonDialog(((CommonAdapter) b.this).f1138e).setTitle("提示").setMessage("确定您要选择" + JsonParse.getString((Map) SelectSchoolActivity.this.f20449b0.getItem(this.f20455a.f()), "school_name") + "吗?").setRightButtonOnClickListener(new C0274a()).show();
            }
        }

        b(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public void c(final ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.J(2131298986, JsonParse.getString(stringObjectMap, "school_name"));
            holder.w(2131298986, new a(holder));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            SelectSchoolActivity.this.W = (List) data.get("data");
            SelectSchoolActivity.this.Y.g(SelectSchoolActivity.this.W);
            SelectSchoolActivity.this.u0();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d extends HttpCallBack {
        d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            SelectSchoolActivity.this.Z = (List) data.get("data");
            SelectSchoolActivity.this.f20449b0.g(SelectSchoolActivity.this.Z);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e implements cn.bluemobi.dylan.base.adapter.common.recyclerview.b {
        e() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
        public void a(ViewGroup parent, View view, Object o5, int position) {
            SelectSchoolActivity.this.f20452p0 = position;
            SelectSchoolActivity.this.Y.notifyDataSetChanged();
            SelectSchoolActivity.this.u0();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v5) {
            LoginUser.getLoginUser().setSchoolName(SelectSchoolActivity.this.getString(2131951695));
            LoginUser.getLoginUser().setServerUrl("https://m.boxkj.com/");
            LoginUser.getLoginUser().setSchoolId("-1");
            Http.changeBaseUrl(LoginUser.getLoginUser().getServerUrl());
            ((BaseActivity) SelectSchoolActivity.this).T.startActivity(new Intent(((BaseActivity) SelectSchoolActivity.this).T, (Class<?>) MainActivity.class));
            new HashSet().add(LoginUser.getLoginUser().getSchoolName());
            SelectSchoolActivity.this.finish();
        }
    }

    private void t0() {
        Http.with(this.T).setObservable(((x.f) Http.getApiService(x.f.class)).f()).setDataListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0() {
        Http.with(this.T).setObservable(((x.f) Http.getApiService(x.f.class)).n(JsonParse.getString(this.Y.getItem(this.f20452p0), "province_id"))).setDataListener(new d());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.Y.k(new e());
        this.f20450c0.setOnClickListener(new f());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        this.X.setLayoutManager(new LinearLayoutManager(this.T));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, 2130772096));
        layoutAnimationController.setOrder(0);
        this.X.setLayoutAnimation(layoutAnimationController);
        this.X.addItemDecoration(new DividerItemDecoration(this.T, 1));
        a aVar = new a(this.T, R.layout.item_for_province_list, this.W);
        this.Y = aVar;
        this.X.setAdapter(aVar);
        this.f20448a0.setLayoutManager(new LinearLayoutManager(this.T));
        LayoutAnimationController layoutAnimationController2 = new LayoutAnimationController(AnimationUtils.loadAnimation(this, 2130772096));
        layoutAnimationController2.setOrder(0);
        this.f20448a0.setLayoutAnimation(layoutAnimationController2);
        b bVar = new b(this.T, R.layout.item_for_school_list, this.Z);
        this.f20449b0 = bVar;
        this.f20448a0.setAdapter(bVar);
        t0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        iOSTwoButtonDialog iostwobuttondialog = this.f20451k0;
        if (iostwobuttondialog != null && iostwobuttondialog.isShowing()) {
            this.f20451k0.dismiss();
        }
        super.onDestroy();
    }

    private void s0() {
        this.f20448a0 = (RecyclerView) findViewById(2131298421);
        this.X = (RecyclerView) findViewById(2131298429);
        this.f20450c0 = (TextView) findViewById(R.id.tv_other);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_school_list;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        Z(getIntent().hasExtra("isShowBack"));
        setTitle("选择学校");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        s0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
