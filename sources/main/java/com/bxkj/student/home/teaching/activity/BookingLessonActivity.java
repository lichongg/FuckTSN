package com.bxkj.student.home.teaching.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.R;
import com.bxkj.student.home.teaching.lesson.ChooseTimeActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class BookingLessonActivity extends BaseActivity {
    private List<Map<String, Object>> W = new ArrayList();
    private RecyclerView X;
    private CommonAdapter<Map<String, Object>> Y;
    private String Z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.student.home.teaching.activity.BookingLessonActivity$a$a, reason: collision with other inner class name */
        class ViewOnClickListenerC0215a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Map f18075a;

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            /* renamed from: com.bxkj.student.home.teaching.activity.BookingLessonActivity$a$a$a, reason: collision with other inner class name */
            class C0216a extends HttpCallBack {
                C0216a() {
                }

                @Override // cn.bluemobi.dylan.http.HttpResponse
                public void netOnSuccess(Map<String, Object> data) {
                    BookingLessonActivity.this.finish();
                }
            }

            ViewOnClickListenerC0215a(final Map val$stringObjectMap) {
                this.f18075a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v5) {
                Http.with(((CommonAdapter) a.this).f1138e).hideOtherStatusMessage().setObservable(((e0.a) Http.getApiService(e0.a.class)).L0(LoginUser.getLoginUser().getUserId(), BookingLessonActivity.this.Z, JsonParse.getString(this.f18075a, "currId"))).setDataListener(new C0216a());
            }
        }

        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(2131298986, JsonParse.getString(stringObjectMap, "currName"));
            holder.N(2131298878, false);
            holder.w(R.id.tv_enter, new ViewOnClickListenerC0215a(stringObjectMap));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements cn.bluemobi.dylan.base.adapter.common.recyclerview.b {
        b() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
        public void a(ViewGroup parent, View view, Object o5, int position) {
            BookingLessonActivity.this.startActivity(new Intent(((BaseActivity) BookingLessonActivity.this).T, (Class<?>) ChooseTimeActivity.class));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            BookingLessonActivity.this.W = JsonParse.getList(data, "data");
            BookingLessonActivity.this.Y.g(BookingLessonActivity.this.W);
        }
    }

    private void m0() {
        Http.with(this.T).setObservable(((e0.a) Http.getApiService(e0.a.class)).G1(LoginUser.getLoginUser().getUserId(), this.Z)).setDataListener(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.Y.k(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.pub_recycelrview_no_refresh;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("id")) {
            this.Z = getIntent().getStringExtra("id");
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
    public void T() {
        setTitle(getString(R.string.bind_lesson));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.X = (RecyclerView) findViewById(2131298421);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
