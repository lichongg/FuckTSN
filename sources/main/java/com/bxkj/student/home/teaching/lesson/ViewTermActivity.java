package com.bxkj.student.home.teaching.lesson;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.R;
import com.bxkj.student.home.teaching.rollcall.RollCallActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import m2.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class ViewTermActivity extends BaseActivity {
    private SmartRefreshLayout W;
    private RecyclerView X;
    private CommonAdapter<Map<String, Object>> Z;

    /* renamed from: a0, reason: collision with root package name */
    private String f18921a0;
    private List<Map<String, Object>> Y = new ArrayList();

    /* renamed from: b0, reason: collision with root package name */
    protected int f18922b0 = 10;

    /* renamed from: c0, reason: collision with root package name */
    protected int f18923c0 = 1;

    /* renamed from: k0, reason: collision with root package name */
    protected int f18924k0 = 1;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.student.home.teaching.lesson.ViewTermActivity$a$a, reason: collision with other inner class name */
        class ViewOnClickListenerC0234a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Map f18926a;

            ViewOnClickListenerC0234a(final Map val$stringObjectMap) {
                this.f18926a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v5) {
                if (("查看" + LoginUser.getLoginUser().getViewAfterLabelName()).equals(ViewTermActivity.this.f18921a0)) {
                    ViewTermActivity.this.startActivity(new Intent(((CommonAdapter) a.this).f1138e, (Class<?>) ViewLessonActivity.class).putExtra("id", JsonParse.getString(this.f18926a, "id")));
                } else if ("查看点名".equals(ViewTermActivity.this.f18921a0)) {
                    ViewTermActivity.this.startActivity(new Intent(((CommonAdapter) a.this).f1138e, (Class<?>) RollCallActivity.class).putExtra("id", JsonParse.getString(this.f18926a, "id")));
                }
            }
        }

        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(2131298861, JsonParse.getString(stringObjectMap, "sysTermName"));
            holder.J(2131298986, JsonParse.getString(stringObjectMap, "sysUserName"));
            holder.J(2131298991, JsonParse.getString(stringObjectMap, "sysUserUserNum"));
            holder.J(2131299116, JsonParse.getString(stringObjectMap, "type"));
            holder.J(2131299093, JsonParse.getString(stringObjectMap, "score"));
            holder.J(2131296623, ViewTermActivity.this.f18921a0);
            holder.w(2131296623, new ViewOnClickListenerC0234a(stringObjectMap));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements n2.e {
        b() {
        }

        @Override // n2.d
        public void a(h refreshlayout) {
            ViewTermActivity viewTermActivity = ViewTermActivity.this;
            viewTermActivity.f18923c0 = 1;
            viewTermActivity.l0();
        }

        @Override // n2.b
        public void f(h refreshlayout) {
            ViewTermActivity viewTermActivity = ViewTermActivity.this;
            int i6 = viewTermActivity.f18924k0;
            int i7 = viewTermActivity.f18922b0;
            int i8 = i6 / i7;
            int i9 = viewTermActivity.f18923c0;
            if (i6 % i7 != 0) {
                i8++;
            }
            if (i9 >= i8) {
                viewTermActivity.W.Q();
                Toast.makeText(((BaseActivity) ViewTermActivity.this).T, "没有了", 0).show();
            } else {
                viewTermActivity.f18923c0 = i9 + 1;
                viewTermActivity.l0();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ViewTermActivity.this.f18924k0 = Integer.parseInt(u.O(data, "total"));
            List list = (List) data.get("data");
            List d6 = ViewTermActivity.this.Z.d();
            if (ViewTermActivity.this.f18923c0 != 1) {
                d6.addAll(list);
                list = d6;
            }
            ViewTermActivity.this.Z.g(list);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            ViewTermActivity.this.W.Y();
            ViewTermActivity.this.W.Q();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("查看学期");
    }

    public void l0() {
        Http.with(this.T).hideLoadingDialog().setObservable(((e0.a) Http.getApiService(e0.a.class)).M(LoginUser.getLoginUser().getUserId(), this.f18923c0, this.f18922b0)).setDataListener(new c());
    }

    public void m0() {
        this.W.D(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_online_lesson;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        this.f18921a0 = getIntent().getStringExtra(Constants.FROM);
        this.X.setLayoutManager(new LinearLayoutManager(this.T, 1, false));
        a aVar = new a(this.T, R.layout.item_for_term_lesson_list, this.Y);
        this.Z = aVar;
        this.X.setAdapter(aVar);
        m0();
        this.W.F();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        ((Spinner) findViewById(2131298550)).setVisibility(8);
        this.W = (SmartRefreshLayout) findViewById(2131298353);
        this.X = (RecyclerView) findViewById(2131298351);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
