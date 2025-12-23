package com.bxkj.student.home.teaching.lesson;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
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
public class ChooseTimeActivity extends BaseActivity {
    private List<Map<String, Object>> W = new ArrayList();
    private RecyclerView X;
    private CommonAdapter<Map<String, Object>> Y;
    private String Z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.student.home.teaching.lesson.ChooseTimeActivity$a$a, reason: collision with other inner class name */
        class ViewOnClickListenerC0230a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Map f18887a;

            ViewOnClickListenerC0230a(final Map val$stringObjectMap) {
                this.f18887a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v5) {
                if (TextUtils.isEmpty(ChooseTimeActivity.this.Z)) {
                    ChooseTimeActivity.this.startActivity(new Intent(((CommonAdapter) a.this).f1138e, (Class<?>) ChooseLessonActivity.class).putExtra("timeId", JsonParse.getString(this.f18887a, "id")));
                } else {
                    ChooseTimeActivity.this.startActivity(new Intent(((CommonAdapter) a.this).f1138e, (Class<?>) OnLineLessonActivity.class).putExtra("timeId", JsonParse.getString(this.f18887a, "id")).putExtra("teachingId", ChooseTimeActivity.this.Z));
                }
            }
        }

        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(2131298986, JsonParse.getString(stringObjectMap, CommonNetImpl.NAME));
            holder.w(2131298986, new ViewOnClickListenerC0230a(stringObjectMap));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ChooseTimeActivity.this.W = JsonParse.getList(data, "data");
            ChooseTimeActivity.this.Y.g(ChooseTimeActivity.this.W);
        }
    }

    private void l0() {
        Http.with(this.T).setObservable(((e0.a) Http.getApiService(e0.a.class)).U0(LoginUser.getLoginUser().getUserId(), this.Z)).setDataListener(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("选择上课时间");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.pub_recycelrview_no_refresh;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("teachingId")) {
            this.Z = getIntent().getStringExtra("teachingId");
        }
        this.X.setLayoutManager(new GridLayoutManager(this.T, 3));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.T, 2130772096));
        layoutAnimationController.setOrder(0);
        this.X.setLayoutAnimation(layoutAnimationController);
        a aVar = new a(this.T, R.layout.item_for_choose_time_list, this.W);
        this.Y = aVar;
        this.X.setAdapter(aVar);
        l0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.X = (RecyclerView) findViewById(2131298421);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
