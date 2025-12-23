package com.bxkj.student.home.teaching.lesson;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
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
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.R;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class ChooseLessonActivity extends BaseActivity {
    private List<Map<String, Object>> W = new ArrayList();
    private RecyclerView X;
    private CommonAdapter<Map<String, Object>> Y;
    private String Z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.student.home.teaching.lesson.ChooseLessonActivity$a$a, reason: collision with other inner class name */
        class ViewOnClickListenerC0229a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Map f18878a;

            ViewOnClickListenerC0229a(final Map val$stringObjectMap) {
                this.f18878a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v5) {
                iOSOneButtonDialog oneButtonText = new iOSOneButtonDialog(((CommonAdapter) a.this).f1138e).setTitle(LoginUser.getLoginUser().getXuanZeAfterLabelName() + "介绍").setOneButtonText("知道了");
                TextView textView = (TextView) oneButtonText.findViewById(2131298672);
                textView.setVisibility(0);
                textView.setText(Html.fromHtml(JsonParse.getString(this.f18878a, "introduce")));
                oneButtonText.show();
                oneButtonText.setMessageGrivity(3);
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class b implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Map f18880a;

            b(final Map val$stringObjectMap) {
                this.f18880a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v5) {
                ChooseLessonActivity.this.n0(this.f18880a);
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class c implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Map f18882a;

            c(final Map val$stringObjectMap) {
                this.f18882a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v5) {
                ChooseLessonActivity.this.n0(this.f18882a);
            }
        }

        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(2131298986, JsonParse.getString(stringObjectMap, CommonNetImpl.NAME));
            holder.w(2131298878, new ViewOnClickListenerC0229a(stringObjectMap));
            holder.w(R.id.tv_enter, new b(stringObjectMap));
            holder.w(2131298986, new c(stringObjectMap));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements cn.bluemobi.dylan.base.adapter.common.recyclerview.b {
        b() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
        public void a(ViewGroup parent, View view, Object o5, int position) {
            ChooseLessonActivity.this.startActivity(new Intent(((BaseActivity) ChooseLessonActivity.this).T, (Class<?>) ChooseTimeActivity.class));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ChooseLessonActivity.this.W = JsonParse.getList(data, "data");
            ChooseLessonActivity.this.Y.g(ChooseLessonActivity.this.W);
        }
    }

    private void m0() {
        Http.with(this.T).setObservable(((e0.a) Http.getApiService(e0.a.class)).o(LoginUser.getLoginUser().getUserId(), this.Z)).setDataListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0(Map<String, Object> stringObjectMap) {
        if (TextUtils.isEmpty(this.Z)) {
            startActivity(new Intent(this.T, (Class<?>) ChooseTimeActivity.class).putExtra("teachingId", JsonParse.getString(stringObjectMap, "id")));
        } else {
            startActivity(new Intent(this.T, (Class<?>) OnLineLessonActivity.class).putExtra("teachingId", JsonParse.getString(stringObjectMap, "id")).putExtra("timeId", this.Z));
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.Y.k(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("选择" + LoginUser.getLoginUser().getXuanZeAfterLabelName());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.pub_recycelrview_no_refresh;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("timeId")) {
            this.Z = getIntent().getStringExtra("timeId");
        }
        this.X.setLayoutManager(new LinearLayoutManager(this.T));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.T, 2130772096));
        layoutAnimationController.setOrder(0);
        this.X.setLayoutAnimation(layoutAnimationController);
        a aVar = new a(this.T, R.layout.item_for_lesson2_list, this.W);
        this.Y = aVar;
        this.X.setAdapter(aVar);
        m0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.X = (RecyclerView) findViewById(2131298421);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
