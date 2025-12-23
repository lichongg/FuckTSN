package com.bxkj.competition.score.teacher;

import android.content.Context;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.method.DigitsKeyListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RadioGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.alibaba.fastjson.JSON;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.w;
import com.bxkj.competition.R;
import com.google.android.material.tabs.TabLayout;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class TrackScoreListActivity extends BaseActivity {
    private com.bxkj.base.keyboard.c F0;
    private String W;
    private TabLayout X;
    private RecyclerView Y;
    private List<Map<String, Object>> Z = new ArrayList();

    /* renamed from: a0, reason: collision with root package name */
    private List<Map<String, Object>> f17362a0 = new ArrayList();

    /* renamed from: b0, reason: collision with root package name */
    private cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> f17363b0;

    /* renamed from: c0, reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f17364c0;

    /* renamed from: k0, reason: collision with root package name */
    private String f17365k0;

    /* renamed from: p0, reason: collision with root package name */
    private int f17366p0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {
        a(Context x02, int x12, List x22) {
            super(x02, x12, x22);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.J(R.id.tv_no, JsonParse.getString(stringObjectMap, "passNum"));
            holder.J(R.id.tv_name, JsonParse.getString(stringObjectMap, CommonNetImpl.NAME));
            holder.J(R.id.tv_num, JsonParse.getString(stringObjectMap, "num"));
            holder.J(R.id.tv_stateName, JsonParse.getString(stringObjectMap, "stateName"));
            holder.J(R.id.tv_value, TrackScoreListActivity.this.f17365k0.equals(ScoreMenu.START) ? JsonParse.getString(stringObjectMap, "start") : TrackScoreListActivity.this.f17365k0.equals(ScoreMenu.CHECK) ? JsonParse.getString(stringObjectMap, "check") : TrackScoreListActivity.this.f17365k0.equals(ScoreMenu.RANK) ? JsonParse.getString(stringObjectMap, "rank") : TrackScoreListActivity.this.f17365k0.equals(ScoreMenu.TIME) ? JsonParse.getString(stringObjectMap, "time") : "");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            int i6 = JsonParse.getInt(data, "data");
            for (int i7 = 1; i7 <= i6; i7++) {
                TrackScoreListActivity.this.X.addTab(TrackScoreListActivity.this.X.newTab().setText("第" + i7 + "组"));
            }
            TrackScoreListActivity.this.w0();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) TrackScoreListActivity.this).T).setMessage(msg).show();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            TrackScoreListActivity.this.f17362a0 = JsonParse.getList(data, "data");
            TrackScoreListActivity.this.f17364c0.g(TrackScoreListActivity.this.f17362a0);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) TrackScoreListActivity.this).T).setMessage(msg).show();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements TabLayout.OnTabSelectedListener {
        d() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            TrackScoreListActivity.this.w0();
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e implements cn.bluemobi.dylan.base.adapter.common.recyclerview.b {
        e() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
        public void a(ViewGroup parent, View view, Object o5, final int position) {
            TrackScoreListActivity.this.x0(position);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class f implements iOSTwoButtonDialog.RightButtonOnClick {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f17372a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ EditText f17373b;

        f(final int val$et_value, final EditText val$position) {
            this.f17372a = val$et_value;
            this.f17373b = val$position;
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            if (TextUtils.isEmpty(JsonParse.getString((Map) TrackScoreListActivity.this.f17364c0.getItem(this.f17372a), "traffId"))) {
                new iOSOneButtonDialog(((BaseActivity) TrackScoreListActivity.this).T).setMessage("该道次为空,不能添加成绩").show();
                return;
            }
            String trim = this.f17373b.getText().toString().trim();
            String str = TrackScoreListActivity.this.f17365k0.equals(ScoreMenu.TIME) ? "time" : TrackScoreListActivity.this.f17365k0.equals(ScoreMenu.RANK) ? "rank" : "";
            HashMap hashMap = new HashMap(3);
            hashMap.put("_state", "modified");
            hashMap.put("traffId", JsonParse.getString((Map) TrackScoreListActivity.this.f17364c0.getItem(this.f17372a), "traffId"));
            hashMap.put(str, trim);
            TrackScoreListActivity.this.u0(hashMap, this.f17372a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class g implements RadioGroup.OnCheckedChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RadioGroup f17375a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ EditText f17376b;

        g(final RadioGroup val$et_value, final EditText val$rg) {
            this.f17375a = val$et_value;
            this.f17376b = val$rg;
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId == this.f17375a.getChildAt(1).getId()) {
                this.f17376b.setVisibility(0);
            } else {
                this.f17376b.setVisibility(8);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class h implements iOSTwoButtonDialog.RightButtonOnClick {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f17378a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ EditText f17379b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ RadioGroup f17380c;

        h(final int val$rg, final EditText val$et_value, final RadioGroup val$position) {
            this.f17378a = val$rg;
            this.f17379b = val$et_value;
            this.f17380c = val$position;
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            if (TextUtils.isEmpty(JsonParse.getString((Map) TrackScoreListActivity.this.f17364c0.getItem(this.f17378a), "traffId"))) {
                new iOSOneButtonDialog(((BaseActivity) TrackScoreListActivity.this).T).setMessage("该道次为空,不能添加成绩").show();
                return;
            }
            String trim = this.f17379b.getText().toString().trim();
            String str = TrackScoreListActivity.this.f17365k0.equals(ScoreMenu.START) ? "start" : TrackScoreListActivity.this.f17365k0.equals(ScoreMenu.CHECK) ? "check" : "";
            HashMap hashMap = new HashMap(3);
            hashMap.put("_state", "modified");
            hashMap.put("traffId", JsonParse.getString((Map) TrackScoreListActivity.this.f17364c0.getItem(this.f17378a), "traffId"));
            hashMap.put(str, Boolean.valueOf(this.f17380c.getCheckedRadioButtonId() == this.f17380c.getChildAt(1).getId()));
            if (!TextUtils.isEmpty(trim)) {
                hashMap.put("memo", trim);
            }
            TrackScoreListActivity.this.u0(hashMap, this.f17378a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class i extends HttpCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map f17382a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f17383b;

        i(final Map val$position, final int val$map) {
            this.f17382a = val$position;
            this.f17383b = val$map;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            if (this.f17382a.containsKey("start")) {
                Map map = this.f17382a;
                map.put("start", JsonParse.getBoolean(map, "start") ? "犯规" : "未犯规");
            }
            if (this.f17382a.containsKey("check")) {
                Map map2 = this.f17382a;
                map2.put("check", JsonParse.getBoolean(map2, "check") ? "犯规" : "未犯规");
            }
            if (this.f17382a.containsKey("time")) {
                Map map3 = this.f17382a;
                map3.put("time", JsonParse.getString(map3, "time"));
            }
            if (this.f17382a.containsKey("rank")) {
                Map map4 = this.f17382a;
                map4.put("rank", JsonParse.getString(map4, "rank"));
            }
            ((Map) TrackScoreListActivity.this.f17364c0.getItem(this.f17383b)).putAll(this.f17382a);
            TrackScoreListActivity.this.f17364c0.notifyItemChanged(this.f17383b);
            TrackScoreListActivity.this.x0(this.f17383b + 1);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) TrackScoreListActivity.this).T).setMessage(msg).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0(final Map<String, Object> map, final int position) {
        Http.with(this.T).setObservable(((com.bxkj.competition.b) Http.getApiService(com.bxkj.competition.b.class)).m(LoginUser.getLoginUser().getUserId(), JSON.toJSONString(map))).setDataListener(new i(map, position));
    }

    private void v0() {
        Http.with(this.T).hideOtherStatusMessage().setObservable(((com.bxkj.competition.b) Http.getApiService(com.bxkj.competition.b.class)).k(this.W)).setDataListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0() {
        Http.with(this.T).hideOtherStatusMessage().setObservable(((com.bxkj.competition.b) Http.getApiService(com.bxkj.competition.b.class)).l(this.W, this.X.getSelectedTabPosition() + 1, "1")).setDataListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(final int position) {
        if (position >= this.f17364c0.getItemCount()) {
            new iOSOneButtonDialog(this.T).setMessage("最后一条已录入完毕").show();
            return;
        }
        Map<String, Object> item = this.f17364c0.getItem(position);
        String string = this.f17365k0.equals(ScoreMenu.START) ? JsonParse.getString(item, "start") : this.f17365k0.equals(ScoreMenu.CHECK) ? JsonParse.getString(item, "check") : this.f17365k0.equals(ScoreMenu.RANK) ? JsonParse.getString(item, "rank") : this.f17365k0.equals(ScoreMenu.TIME) ? JsonParse.getString(item, "time") : "";
        int i6 = this.f17366p0;
        if (i6 != 0) {
            if (i6 == 1) {
                iOSTwoButtonDialog centerCustomView = new iOSTwoButtonDialog(this.T).setTitle("姓名：" + JsonParse.getString(this.f17364c0.getItem(position), CommonNetImpl.NAME)).setCenterCustomView(R.layout.dialog_add_score_radiot);
                EditText editText = (EditText) centerCustomView.findViewById(R.id.et_value);
                RadioGroup radioGroup = (RadioGroup) centerCustomView.findViewById(R.id.rg);
                radioGroup.setOnCheckedChangeListener(new g(radioGroup, editText));
                if ("犯规".equals(string)) {
                    radioGroup.check(radioGroup.getChildAt(1).getId());
                }
                editText.setText(JsonParse.getString(item, "memo"));
                centerCustomView.setRightButtonOnClickListener(new h(position, editText, radioGroup));
                centerCustomView.show();
                return;
            }
            return;
        }
        iOSTwoButtonDialog centerCustomView2 = new iOSTwoButtonDialog(this.T).setTitle("道次：" + JsonParse.getString(this.f17364c0.getItem(position), "passNum") + "\u3000姓名：" + JsonParse.getString(this.f17364c0.getItem(position), CommonNetImpl.NAME)).setCenterCustomView(R.layout.dialog_add_score_input);
        EditText editText2 = (EditText) centerCustomView2.findViewById(R.id.et_value);
        editText2.setText(string);
        editText2.setHint("请输入" + this.f17365k0);
        if (this.f17365k0.equals(ScoreMenu.TIME)) {
            editText2.setKeyListener(DigitsKeyListener.getInstance("0123456789:."));
            editText2.setFilters(new InputFilter[]{new w()});
        } else if (this.f17365k0.equals(ScoreMenu.RANK)) {
            editText2.setKeyListener(DigitsKeyListener.getInstance("0123456789"));
        }
        Window window = centerCustomView2.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        window.setGravity(17);
        attributes.width = -1;
        attributes.height = -1;
        centerCustomView2.onWindowAttributesChanged(attributes);
        window.setAttributes(attributes);
        this.F0.a(editText2);
        centerCustomView2.setRightButtonOnClickListener(new f(position, editText2));
        centerCustomView2.show();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.X.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new d());
        this.f17364c0.k(new e());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_student_list_add_score;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        this.F0 = new com.bxkj.base.keyboard.c(this);
        if (getIntent().hasExtra("scheduleId")) {
            this.W = getIntent().getStringExtra("scheduleId");
        }
        if (getIntent().hasExtra("type")) {
            this.f17366p0 = getIntent().getIntExtra("type", 0);
        }
        this.Y.setLayoutManager(new LinearLayoutManager(this.T));
        a aVar = new a(this.T, R.layout.item_for_student_score_list, this.f17362a0);
        this.f17364c0 = aVar;
        this.Y.setAdapter(aVar);
        v0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("录入成绩");
        if (getIntent().hasExtra("menu")) {
            this.f17365k0 = getIntent().getStringExtra("menu");
            setTitle(this.f17365k0 + "录入");
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.Y = (RecyclerView) findViewById(R.id.rv);
        this.X = (TabLayout) findViewById(R.id.tb_group);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
