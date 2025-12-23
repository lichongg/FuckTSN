package com.bxkj.student.home.teaching.lesson;

import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.collection.ArrayMap;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.R;
import com.orhanobut.logger.j;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import m2.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class OnLineLessonActivity extends BaseActivity {
    private String W;
    private String X;
    private Spinner Y;
    private cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> Z;

    /* renamed from: a0, reason: collision with root package name */
    private SmartRefreshLayout f18893a0;

    /* renamed from: b0, reason: collision with root package name */
    private RecyclerView f18894b0;

    /* renamed from: p0, reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f18897p0;

    /* renamed from: c0, reason: collision with root package name */
    private List<Map<String, Object>> f18895c0 = new ArrayList();

    /* renamed from: k0, reason: collision with root package name */
    private List<Map<String, Object>> f18896k0 = new ArrayList();
    private int F0 = 0;
    protected int G0 = 10;
    protected int H0 = 1;
    protected int I0 = 1;
    String J0 = null;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.J(2131298986, JsonParse.getString(stringObjectMap, CommonNetImpl.NAME));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends CommonAdapter<Map<String, Object>> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Map f18900a;

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            /* renamed from: com.bxkj.student.home.teaching.lesson.OnLineLessonActivity$b$a$a, reason: collision with other inner class name */
            class C0232a extends HttpCallBack {
                C0232a() {
                }

                @Override // cn.bluemobi.dylan.http.HttpResponse
                public void netOnSuccess(Map<String, Object> data) {
                    iOSOneButtonDialog oneButtonText = new iOSOneButtonDialog(((CommonAdapter) b.this).f1138e).setTitle("教师介绍").setOneButtonText("知道了");
                    TextView textView = (TextView) oneButtonText.findViewById(2131298672);
                    textView.setVisibility(0);
                    textView.setText(OnLineLessonActivity.this.q0(JsonParse.getString(data, "data")));
                    textView.setLinkTextColor(ContextCompat.getColor(((CommonAdapter) b.this).f1138e, 2131099730));
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                    oneButtonText.show();
                    oneButtonText.setMessageGrivity(3);
                }
            }

            a(final Map val$stringObjectMap) {
                this.f18900a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v5) {
                Http.with(((CommonAdapter) b.this).f1138e).setObservable(((e0.a) Http.getApiService(e0.a.class)).J(JsonParse.getString(this.f18900a, "teacherId"))).setDataListener(new C0232a());
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.student.home.teaching.lesson.OnLineLessonActivity$b$b, reason: collision with other inner class name */
        class ViewOnClickListenerC0233b implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Map f18903a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ ViewHolder f18904b;

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            /* renamed from: com.bxkj.student.home.teaching.lesson.OnLineLessonActivity$b$b$a */
            class a implements iOSTwoButtonDialog.RightButtonOnClick {
                a() {
                }

                @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                public void buttonRightOnClick() {
                    ViewOnClickListenerC0233b viewOnClickListenerC0233b = ViewOnClickListenerC0233b.this;
                    OnLineLessonActivity.this.p0(viewOnClickListenerC0233b.f18904b.f());
                }
            }

            ViewOnClickListenerC0233b(final Map val$stringObjectMap, final ViewHolder val$holder) {
                this.f18903a = val$stringObjectMap;
                this.f18904b = val$holder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v5) {
                StringBuilder sb = new StringBuilder();
                sb.append("确定要选择该" + LoginUser.getLoginUser().getXuanZeAfterLabelName() + "吗？");
                sb.append(com.snail.antifake.deviceid.e.f37542d);
                sb.append(JsonParse.getString(this.f18903a, "sysTermName"));
                sb.append(com.snail.antifake.deviceid.e.f37542d);
                sb.append(JsonParse.getString(this.f18903a, "sysOrgName"));
                sb.append(com.snail.antifake.deviceid.e.f37542d);
                sb.append(JsonParse.getString(this.f18903a, "sysCampusName"));
                sb.append(com.snail.antifake.deviceid.e.f37542d);
                sb.append(JsonParse.getString(this.f18903a, "teachingSchoolTimeName"));
                sb.append(com.snail.antifake.deviceid.e.f37542d);
                sb.append(JsonParse.getString(this.f18903a, "sysUserName"));
                sb.append(com.snail.antifake.deviceid.e.f37542d);
                sb.append(JsonParse.getString(this.f18903a, "teachingCurriculumName"));
                sb.append(com.snail.antifake.deviceid.e.f37542d);
                sb.append(JsonParse.getString(this.f18903a, "address"));
                new iOSTwoButtonDialog(((CommonAdapter) b.this).f1138e).setMessageGrivity(3).setMessage(sb.toString()).setRightButtonOnClickListener(new a()).show();
            }
        }

        b(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(R.id.tv_man, JsonParse.getString(stringObjectMap, "manNum"));
            holder.J(R.id.tv_women, JsonParse.getString(stringObjectMap, "womanNum"));
            holder.J(R.id.tv_blend, JsonParse.getString(stringObjectMap, "blendNum"));
            holder.J(R.id.tv_lesson_name, JsonParse.getString(stringObjectMap, "teachingCurriculumName"));
            holder.J(2131298861, JsonParse.getString(stringObjectMap, "sysTermName"));
            holder.J(2131299158, JsonParse.getString(stringObjectMap, "teachingSchoolTimeName"));
            holder.J(2131298922, JsonParse.getString(stringObjectMap, "sysOrgName"));
            holder.J(2131299171, JsonParse.getString(stringObjectMap, "type"));
            holder.J(R.id.tv_school_area, JsonParse.getString(stringObjectMap, "sysCampusName"));
            holder.J(R.id.tv_week, JsonParse.getString(stringObjectMap, "parameter"));
            holder.J(2131299171, JsonParse.getString(stringObjectMap, "type"));
            holder.J(R.id.tv_feature, JsonParse.getString(stringObjectMap, "feature"));
            holder.J(2131298773, JsonParse.getString(stringObjectMap, "address"));
            holder.J(R.id.tv_teacher, JsonParse.getString(stringObjectMap, "sysUserName") + "(点击查看)");
            String string = JsonParse.getString(stringObjectMap, "canshu");
            holder.w(R.id.tv_teacher, new a(stringObjectMap));
            Button button = (Button) holder.h(2131296623);
            if (string.equals("1")) {
                button.setEnabled(false);
                button.setText(LoginUser.getLoginUser().getXuanZeAfterLabelName() + "已满");
                return;
            }
            if (string.equals("2")) {
                button.setEnabled(false);
                button.setText("时间已过");
            } else if (string.equals("3")) {
                button.setEnabled(false);
                button.setText("已选择");
            } else {
                button.setEnabled(true);
                button.setText("选择");
                button.setOnClickListener(new ViewOnClickListenerC0233b(stringObjectMap, holder));
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            OnLineLessonActivity.this.f18893a0.F();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            OnLineLessonActivity.this.f18893a0.F();
            new iOSOneButtonDialog(((BaseActivity) OnLineLessonActivity.this).T).setMessage(msg).show();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements AdapterView.OnItemSelectedListener {
        d() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            OnLineLessonActivity.this.F0 = position;
            OnLineLessonActivity.this.J0 = String.valueOf(position);
            OnLineLessonActivity onLineLessonActivity = OnLineLessonActivity.this;
            onLineLessonActivity.H0 = 1;
            onLineLessonActivity.r0(true);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e implements n2.e {
        e() {
        }

        @Override // n2.d
        public void a(h refreshlayout) {
            OnLineLessonActivity onLineLessonActivity = OnLineLessonActivity.this;
            onLineLessonActivity.J0 = null;
            onLineLessonActivity.H0 = 1;
            onLineLessonActivity.r0(false);
        }

        @Override // n2.b
        public void f(h refreshlayout) {
            OnLineLessonActivity onLineLessonActivity = OnLineLessonActivity.this;
            int i6 = onLineLessonActivity.I0 / onLineLessonActivity.G0;
            if ("8".equals(LoginUser.getLoginUser().getSchoolId())) {
                OnLineLessonActivity onLineLessonActivity2 = OnLineLessonActivity.this;
                int i7 = onLineLessonActivity2.H0;
                if (onLineLessonActivity2.I0 % onLineLessonActivity2.G0 != 0) {
                    i6++;
                }
                if (i7 < i6) {
                    onLineLessonActivity2.J0 = null;
                } else if (onLineLessonActivity2.f18897p0.d() == null || OnLineLessonActivity.this.f18897p0.d().size() <= 0) {
                    OnLineLessonActivity.this.J0 = null;
                } else {
                    OnLineLessonActivity onLineLessonActivity3 = OnLineLessonActivity.this;
                    onLineLessonActivity3.J0 = String.valueOf(JsonParse.getInt((Map) onLineLessonActivity3.f18897p0.getItem(OnLineLessonActivity.this.f18897p0.d().size() - 1), "parameter") + 1);
                }
            } else {
                OnLineLessonActivity onLineLessonActivity4 = OnLineLessonActivity.this;
                int i8 = onLineLessonActivity4.H0;
                if (onLineLessonActivity4.I0 % onLineLessonActivity4.G0 != 0) {
                    i6++;
                }
                if (i8 >= i6) {
                    onLineLessonActivity4.f18893a0.Q();
                    OnLineLessonActivity.this.g0("没有了");
                    return;
                }
            }
            OnLineLessonActivity onLineLessonActivity5 = OnLineLessonActivity.this;
            onLineLessonActivity5.H0++;
            onLineLessonActivity5.r0(false);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class f extends HttpCallBack {
        f() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            OnLineLessonActivity.this.I0 = Integer.parseInt(u.O(data, "total"));
            List list = (List) data.get("data");
            List d6 = OnLineLessonActivity.this.f18897p0.d();
            if (OnLineLessonActivity.this.H0 == 1) {
                d6 = list;
            } else {
                d6.addAll(list);
            }
            if ("8".equals(LoginUser.getLoginUser().getSchoolId()) && list != null && list.size() > 0) {
                OnLineLessonActivity.this.Y.setSelection(JsonParse.getInt((Map) list.get(0), "parameter"));
            }
            OnLineLessonActivity.this.f18897p0.g(d6);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            OnLineLessonActivity.this.f18893a0.Y();
            OnLineLessonActivity.this.f18893a0.Q();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) OnLineLessonActivity.this).T).setMessage(msg).show();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class g extends ClickableSpan {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ URLSpan f18911a;

        g(final URLSpan val$urlSpan) {
            this.f18911a = val$urlSpan;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            j.g("URL-click:" + this.f18911a.getURL(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0(final int positon) {
        Http.with(this.T).hideOtherStatusMessage().setObservable(((e0.a) Http.getApiService(e0.a.class)).u1(LoginUser.getLoginUser().getUserId(), JsonParse.getString(this.f18897p0.getItem(positon), "id"))).setDataListener(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.Y.setOnItemSelectedListener(new d());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("在线选" + LoginUser.getLoginUser().getXuanAfterLabelName());
    }

    public void r0(boolean isShowLoading) {
        Http.with(this.T).hideOtherStatusMessage().setShowLoadingDialog(isShowLoading).setObservable(((e0.a) Http.getApiService(e0.a.class)).v1(LoginUser.getLoginUser().getUserId(), this.X, this.J0, this.W, this.H0, this.G0)).setDataListener(new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CharSequence q0(String html) {
        Spanned fromHtml = Html.fromHtml(html);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(fromHtml);
        for (URLSpan uRLSpan : (URLSpan[]) spannableStringBuilder.getSpans(0, fromHtml.length(), URLSpan.class)) {
            t0(spannableStringBuilder, uRLSpan);
        }
        return spannableStringBuilder;
    }

    private void t0(final SpannableStringBuilder clickableHtmlBuilder, final URLSpan urlSpan) {
        clickableHtmlBuilder.setSpan(new g(urlSpan), clickableHtmlBuilder.getSpanStart(urlSpan), clickableHtmlBuilder.getSpanEnd(urlSpan), clickableHtmlBuilder.getSpanFlags(urlSpan));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_online_lesson;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("teachingId")) {
            this.W = getIntent().getStringExtra("teachingId");
        }
        if (getIntent().hasExtra("timeId")) {
            this.X = getIntent().getStringExtra("timeId");
        }
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put(CommonNetImpl.NAME, "请选择");
        this.f18895c0.add(arrayMap);
        for (int i6 = 1; i6 < 31; i6++) {
            ArrayMap arrayMap2 = new ArrayMap();
            arrayMap2.put(CommonNetImpl.NAME, "第" + i6 + "周");
            this.f18895c0.add(arrayMap2);
        }
        a aVar = new a(this.T, com.bxkj.place.R.layout.item_for_school_district_list, this.f18895c0);
        this.Z = aVar;
        this.Y.setAdapter((SpinnerAdapter) aVar);
        this.f18894b0.setLayoutManager(new LinearLayoutManager(this.T, 1, false));
        b bVar = new b(this.T, R.layout.item_for_lesson_list, this.f18896k0);
        this.f18897p0 = bVar;
        this.f18894b0.setAdapter(bVar);
        s0();
        this.f18893a0.F();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.Y = (Spinner) findViewById(2131298550);
        this.f18893a0 = (SmartRefreshLayout) findViewById(2131298353);
        this.f18894b0 = (RecyclerView) findViewById(2131298351);
    }

    public void s0() {
        if ("8".equals(LoginUser.getLoginUser().getSchoolId())) {
            this.Y.setVisibility(0);
            this.f18893a0.v(false);
        } else {
            this.Y.setVisibility(8);
        }
        this.f18893a0.D(new e());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
