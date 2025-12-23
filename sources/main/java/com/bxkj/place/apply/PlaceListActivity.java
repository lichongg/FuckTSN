package com.bxkj.place.apply;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.collection.ArrayMap;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.view.ObservableHorizontalScrollView;
import com.bxkj.place.R;
import com.bxkj.place.apply.PlaceListActivity;
import com.bxkj.place.view.MyRecyclerViewOnScrollListener;
import com.google.android.material.tabs.TabLayout;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class PlaceListActivity extends BaseActivity {
    private Button F0;
    private CommonAdapter<Map<String, Object>> G0;
    private List<Map<String, Object>> H0;
    private int I0;
    private String J0;
    private String K0;
    private String L0 = "";
    private String M0;
    private MyRecyclerViewOnScrollListener N0;
    private MyRecyclerViewOnScrollListener O0;
    private TextView W;
    private TabLayout X;
    private RecyclerView Y;
    private RecyclerView Z;

    /* renamed from: a0, reason: collision with root package name */
    private RecyclerView f17525a0;

    /* renamed from: b0, reason: collision with root package name */
    private ObservableHorizontalScrollView f17526b0;

    /* renamed from: c0, reason: collision with root package name */
    private List<Map<String, Object>> f17527c0;

    /* renamed from: k0, reason: collision with root package name */
    private CommonAdapter<String> f17528k0;

    /* renamed from: p0, reason: collision with root package name */
    private List<String> f17529p0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<String> {
        a(Context x02, int x12, List x22) {
            super(x02, x12, x22);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(final ViewHolder holder, final String s5) {
            holder.J(R.id.tv_name, s5);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends CommonAdapter<Map<String, Object>> {
        b(Context x02, int x12, List x22) {
            super(x02, x12, x22);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            if (JsonParse.getString(stringObjectMap, "id").isEmpty()) {
                ((LinearLayout) holder.h(R.id.ll_root)).setPadding(0, 0, 0, 0);
                holder.N(R.id.tv_name, false);
            } else {
                ((LinearLayout) holder.h(R.id.ll_root)).setPadding(1, 1, 1, 1);
                int i6 = R.id.tv_name;
                holder.N(i6, true);
                holder.J(i6, JsonParse.getString(stringObjectMap, AnalyticsConfig.RTD_START_TIME) + "-" + JsonParse.getString(stringObjectMap, "endTime"));
            }
            String str = (String) PlaceListActivity.this.W.getTag();
            final String string = JsonParse.getString(stringObjectMap, "showStatus");
            if (str != null && str.equals(JsonParse.getString(stringObjectMap, "id"))) {
                holder.k(R.id.tv_name, PlaceListActivity.this.getResources().getColor(R.color.themeColor));
            } else if ("0".equals(string)) {
                holder.k(R.id.tv_name, PlaceListActivity.this.getResources().getColor(R.color.colorWhite));
            } else if ("1".equals(string)) {
                holder.k(R.id.tv_name, PlaceListActivity.this.getResources().getColor(R.color.textColorGray));
            } else if ("2".equals(string)) {
                holder.k(R.id.tv_name, PlaceListActivity.this.getResources().getColor(R.color.cardBlue));
            } else if ("3".equals(string)) {
                holder.k(R.id.tv_name, PlaceListActivity.this.getResources().getColor(R.color.cardYellow));
            } else if ("4".equals(string)) {
                holder.k(R.id.tv_name, PlaceListActivity.this.getResources().getColor(R.color.color_red));
            }
            holder.w(R.id.tv_name, new View.OnClickListener() { // from class: com.bxkj.place.apply.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PlaceListActivity.b.m(PlaceListActivity.b.this, string, stringObjectMap, view);
                }
            });
        }

        public static /* synthetic */ void m(b bVar, String str, Map map, View view) {
            bVar.getClass();
            if ("1".equals(str)) {
                PlaceListActivity.this.g0("已被预约");
                return;
            }
            if ("2".equals(str)) {
                PlaceListActivity.this.g0("时间已过");
                return;
            }
            if ("3".equals(str)) {
                PlaceListActivity.this.g0("未开放");
                return;
            }
            if ("4".equals(str)) {
                PlaceListActivity.this.g0("已禁用");
                return;
            }
            PlaceListActivity.this.W.setVisibility(0);
            PlaceListActivity.this.W.setText(JsonParse.getString(map, "fieldName") + "\u3000" + JsonParse.getString(map, AnalyticsConfig.RTD_START_TIME) + "-" + JsonParse.getString(map, "endTime"));
            PlaceListActivity.this.W.setTag(JsonParse.getString(map, "id"));
            PlaceListActivity.this.F0.setTag(JsonParse.getString(map, "isParty"));
            PlaceListActivity.this.F0.setEnabled(true);
            PlaceListActivity.this.G0.g(PlaceListActivity.this.f17527c0);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {

        /* renamed from: a, reason: collision with root package name */
        private TabLayout.OnTabSelectedListener f17532a = new a();

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements TabLayout.OnTabSelectedListener {
            a() {
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                PlaceListActivity.this.L0 = tab.getText().toString().trim();
                PlaceListActivity.this.D0();
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabReselected(TabLayout.Tab tab) {
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
        }

        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data, String msg) {
            if (!u.b0(msg)) {
                new iOSOneButtonDialog(((BaseActivity) PlaceListActivity.this).T).setMessage(msg).show();
            }
            PlaceListActivity.this.Q().setVisibility(0);
            List list = JsonParse.getList(data, "dateList", String.class);
            PlaceListActivity.this.X.clearOnTabSelectedListeners();
            PlaceListActivity.this.X.removeAllTabs();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String replace = ((String) it.next()).replace("/", com.snail.antifake.deviceid.e.f37542d);
                TabLayout.Tab text = PlaceListActivity.this.X.newTab().setText(replace);
                PlaceListActivity.this.X.addTab(text);
                if (replace.equals(PlaceListActivity.this.L0)) {
                    text.select();
                }
            }
            PlaceListActivity.this.X.addOnTabSelectedListener(this.f17532a);
            PlaceListActivity.this.H0 = JsonParse.getList(data, "fieldPlanList");
            PlaceListActivity.this.f17529p0 = new ArrayList();
            int i6 = 0;
            for (Map map : PlaceListActivity.this.H0) {
                PlaceListActivity.this.f17529p0.add(JsonParse.getString(map, CommonNetImpl.NAME));
                List<Map<String, Object>> list2 = JsonParse.getList(map, "time");
                if (list2.size() > i6) {
                    i6 = list2.size();
                }
            }
            PlaceListActivity.this.f17528k0.g(PlaceListActivity.this.f17529p0);
            PlaceListActivity.this.f17527c0 = new ArrayList();
            int size = PlaceListActivity.this.f17529p0.size();
            for (int i7 = 0; i7 < i6; i7++) {
                for (int i8 = 0; i8 < size; i8++) {
                    List<Map<String, Object>> list3 = JsonParse.getList((Map) PlaceListActivity.this.H0.get(i8), "time");
                    Map<String, Object> arrayMap = new ArrayMap<>();
                    if (i7 < list3.size()) {
                        arrayMap = list3.get(i7);
                    }
                    PlaceListActivity.this.f17527c0.add(arrayMap);
                }
            }
            if (PlaceListActivity.this.f17527c0.size() > 0) {
                PlaceListActivity.this.f17525a0.setLayoutManager(new GridLayoutManager(((BaseActivity) PlaceListActivity.this).T, PlaceListActivity.this.f17529p0.size(), 1, false));
            }
            PlaceListActivity.this.G0.g(PlaceListActivity.this.f17527c0);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            if (!TextUtils.isEmpty(msg)) {
                new iOSOneButtonDialog(((BaseActivity) PlaceListActivity.this).T).setMessage(msg).show();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements RecyclerView.OnItemTouchListener {

        /* renamed from: a, reason: collision with root package name */
        private int f17535a;

        d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e6) {
            if (rv.getScrollState() == 0) {
                onTouchEvent(rv, e6);
                return false;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(RecyclerView rv, MotionEvent e6) {
            if (e6.getAction() == 0 && PlaceListActivity.this.f17525a0.getScrollState() == 0) {
                this.f17535a = rv.getScrollY();
                rv.addOnScrollListener(PlaceListActivity.this.N0);
            } else if (e6.getAction() == 1 && rv.getScrollY() == this.f17535a) {
                rv.removeOnScrollListener(PlaceListActivity.this.N0);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e implements RecyclerView.OnItemTouchListener {

        /* renamed from: a, reason: collision with root package name */
        private int f17537a;

        e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e6) {
            if (rv.getScrollState() == 0) {
                onTouchEvent(rv, e6);
                return false;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(RecyclerView rv, MotionEvent e6) {
            if (e6.getAction() == 0 && PlaceListActivity.this.Y.getScrollState() == 0) {
                this.f17537a = rv.getScrollY();
                rv.addOnScrollListener(PlaceListActivity.this.O0);
            } else if (e6.getAction() == 1 && rv.getScrollY() == this.f17537a) {
                rv.removeOnScrollListener(PlaceListActivity.this.O0);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class f extends HttpCallBack {
        f() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            PlaceListActivity.this.D0();
        }
    }

    public static /* synthetic */ void h0(PlaceListActivity placeListActivity, ObservableHorizontalScrollView observableHorizontalScrollView, int i6, int i7, int i8, int i9) {
        placeListActivity.f17525a0.removeOnScrollListener(placeListActivity.O0);
        placeListActivity.Y.removeOnScrollListener(placeListActivity.N0);
    }

    public void D0() {
        this.W.setVisibility(8);
        this.W.setText("");
        this.W.setTag(null);
        this.F0.setEnabled(false);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(new Date());
        TabLayout tabLayout = this.X;
        if (tabLayout.getTabAt(tabLayout.getSelectedTabPosition()) != null) {
            try {
                TabLayout tabLayout2 = this.X;
                format = simpleDateFormat.format(simpleDateFormat.parse(tabLayout2.getTabAt(tabLayout2.getSelectedTabPosition()).getText().toString().trim()));
            } catch (ParseException e6) {
                e6.printStackTrace();
            }
        }
        Http.with(this.T).hideSuccessMessage().hideOtherStatusMessage().setObservable(((d0.b) Http.getApiService(d0.b.class)).f(LoginUser.getLoginUser().getUserId(), this.I0, this.K0, format)).setDataListener(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.N0 = new MyRecyclerViewOnScrollListener(this.f17525a0);
        this.O0 = new MyRecyclerViewOnScrollListener(this.Y);
        this.Y.addOnItemTouchListener(new d());
        this.f17525a0.addOnItemTouchListener(new e());
        this.f17526b0.setScrollViewListener(new ObservableHorizontalScrollView.a() { // from class: com.bxkj.place.apply.b
            @Override // com.bxkj.base.view.ObservableHorizontalScrollView.a
            public final void a(ObservableHorizontalScrollView observableHorizontalScrollView, int i6, int i7, int i8, int i9) {
                PlaceListActivity.h0(PlaceListActivity.this, observableHorizontalScrollView, i6, i7, i8, i9);
            }
        });
        this.F0.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_place_list;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("申请场地");
        a0(R.mipmap.help, new BaseActivity.c() { // from class: com.bxkj.place.apply.a
            @Override // cn.bluemobi.dylan.base.BaseActivity.c
            public final void onClick() {
                r0.startActivity(r0.getIntent().setClass(PlaceListActivity.this.T, ApplyIntroductionActivity.class));
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (TextView) findViewById(R.id.tv_order);
        this.X = (TabLayout) findViewById(R.id.tb_date);
        this.Z = (RecyclerView) findViewById(R.id.rv_top);
        this.f17525a0 = (RecyclerView) findViewById(R.id.recyclerView);
        this.Y = (RecyclerView) findViewById(R.id.rv_left);
        this.f17526b0 = (ObservableHorizontalScrollView) findViewById(R.id.hs);
        this.F0 = (Button) findViewById(R.id.bt_ok);
        Q().setVisibility(4);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        String str;
        String str2;
        String str3;
        if (getIntent().hasExtra("id")) {
            this.K0 = getIntent().getStringExtra("id");
        }
        if (getIntent().hasExtra("appointType")) {
            this.I0 = getIntent().getIntExtra("appointType", 1);
        }
        Button button = this.F0;
        if (this.I0 == 2) {
            str = "立即申请";
        } else {
            str = "立即预约";
        }
        button.setText(str);
        int i6 = this.I0;
        if (i6 == 2) {
            str2 = "申请";
        } else {
            str2 = "立预约";
        }
        this.J0 = str2;
        if (i6 == 2) {
            str3 = "申请场地";
        } else {
            str3 = "预约场地";
        }
        setTitle(str3);
        this.Z.setLayoutManager(new LinearLayoutManager(this.T, 0, false));
        a aVar = new a(this.T, R.layout.item_for_place_name, this.f17529p0);
        this.f17528k0 = aVar;
        this.Z.setAdapter(aVar);
        b bVar = new b(this.T, R.layout.item_for_place_checked, this.f17527c0);
        this.G0 = bVar;
        this.f17525a0.setAdapter(bVar);
        D0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
        if (v5.getId() == R.id.bt_ok && this.F0.getTag() != null) {
            if (!this.F0.getTag().toString().trim().equals("1") && this.I0 != 2) {
                Http.with(this.T).setObservable(((d0.b) Http.getApiService(d0.b.class)).g(LoginUser.getLoginUser().getUserId(), (String) this.W.getTag(), "", "", this.I0, "1")).setDataListener(new f());
                return;
            }
            Intent intent = new Intent(this.T, (Class<?>) ApplyPlaceActivity.class);
            TabLayout tabLayout = this.X;
            startActivity(intent.putExtra("date", tabLayout.getTabAt(tabLayout.getSelectedTabPosition()).getText()).putExtra("id", (String) this.W.getTag()).putExtra("appointType", this.I0));
        }
    }
}
