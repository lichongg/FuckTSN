package com.bxkj.student.home.teaching.learning.ready;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.LinearLayout;
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
import com.bxkj.student.R;
import com.bxkj.student.home.teaching.learning.LearnHomeListActivity;
import com.bxkj.student.home.teaching.learning.m;
import com.bxkj.student.home.teaching.learning.ready.SelectLessonActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class SelectLessonActivity extends BaseActivity {
    private List<Map<String, Object>> W;
    private RecyclerView X;
    private CommonAdapter<Map<String, Object>> Y;
    private List<Map<String, Object>> Z;

    /* renamed from: a0, reason: collision with root package name */
    private RecyclerView f18824a0;

    /* renamed from: b0, reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f18825b0;

    /* renamed from: c0, reason: collision with root package name */
    private TextView f18826c0;

    /* renamed from: k0, reason: collision with root package name */
    private int f18827k0 = 0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            Drawable drawable;
            ((TextView) holder.h(2131298986)).setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            holder.J(2131298986, JsonParse.getString(stringObjectMap, "typeName"));
            if (holder.f() == SelectLessonActivity.this.f18827k0) {
                drawable = SelectLessonActivity.this.getResources().getDrawable(2131231950);
            } else {
                drawable = null;
            }
            holder.q(R.id.iv, drawable);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends CommonAdapter<Map<String, Object>> {
        b(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(Map map, View view) {
            SelectLessonActivity.this.A0(JsonParse.getString(map, "id"), JsonParse.getString(map, "typeName"));
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void c(ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(2131298986, JsonParse.getString(stringObjectMap, "typeName"));
            holder.w(2131296688, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.ready.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SelectLessonActivity.b.this.o(stringObjectMap, view);
                }
            });
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            SelectLessonActivity.this.W = (List) data.get("data");
            SelectLessonActivity.this.Y.g(SelectLessonActivity.this.W);
            if (SelectLessonActivity.this.W == null || SelectLessonActivity.this.W.size() <= 0) {
                return;
            }
            Map map = (Map) SelectLessonActivity.this.W.get(0);
            if (JsonParse.getInt(map, "isCurriculum") == 0) {
                SelectLessonActivity.this.x0(JsonParse.getString(map, "id"));
                return;
            }
            SelectLessonActivity.this.f18824a0.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
            layoutParams.weight = 5.0f;
            SelectLessonActivity.this.X.setLayoutParams(layoutParams);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d extends HttpCallBack {
        d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            SelectLessonActivity.this.Z = (List) data.get("data");
            SelectLessonActivity.this.f18825b0.g(SelectLessonActivity.this.Z);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e extends HttpCallBack {
        e() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            SelectLessonActivity.this.startActivity(new Intent(((BaseActivity) SelectLessonActivity.this).T, (Class<?>) LearnHomeListActivity.class));
            SelectLessonActivity.this.finish();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        Z(false);
        setTitle("选择课程");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(final String id, String name) {
        new iOSTwoButtonDialog(this.T).setTitle("提示").setMessage("确定您要选择" + name + "吗?").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.learning.ready.b
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public final void buttonRightOnClick() {
                SelectLessonActivity.this.z0(id);
            }
        }).show();
    }

    private void w0() {
        Http.with(this.T).setObservable(((m) Http.getApiService(m.class)).n()).setDataListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(String pid) {
        Http.with(this.T).setObservable(((m) Http.getApiService(m.class)).e(pid)).setDataListener(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y0(ViewGroup viewGroup, View view, Object obj, int i6) {
        this.f18827k0 = i6;
        this.Y.notifyDataSetChanged();
        this.Z.clear();
        this.f18825b0.notifyDataSetChanged();
        Map<String, Object> item = this.Y.getItem(i6);
        String string = JsonParse.getString(item, "id");
        String string2 = JsonParse.getString(item, "typeName");
        if (JsonParse.getInt(item, "isCurriculum") == 0) {
            x0(string);
        } else {
            A0(string, string2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z0(String str) {
        Http.with(this.T).setObservable(((m) Http.getApiService(m.class)).u(str)).setDataListener(new e());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.Y.k(new cn.bluemobi.dylan.base.adapter.common.recyclerview.b() { // from class: com.bxkj.student.home.teaching.learning.ready.a
            @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
            public final void a(ViewGroup viewGroup, View view, Object obj, int i6) {
                SelectLessonActivity.this.y0(viewGroup, view, obj, i6);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        this.W = new ArrayList();
        this.X.setLayoutManager(new LinearLayoutManager(this.T));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, 2130772096));
        layoutAnimationController.setOrder(0);
        this.X.setLayoutAnimation(layoutAnimationController);
        this.X.addItemDecoration(new DividerItemDecoration(this.T, 1));
        a aVar = new a(this.T, R.layout.item_for_select_learn_lesson_list, this.W);
        this.Y = aVar;
        this.X.setAdapter(aVar);
        this.Z = new ArrayList();
        this.f18824a0.setLayoutManager(new LinearLayoutManager(this.T));
        LayoutAnimationController layoutAnimationController2 = new LayoutAnimationController(AnimationUtils.loadAnimation(this.T, 2130772096));
        layoutAnimationController2.setOrder(0);
        this.f18824a0.setLayoutAnimation(layoutAnimationController2);
        b bVar = new b(this.T, R.layout.item_for_school_list, this.Z);
        this.f18825b0 = bVar;
        this.f18824a0.setAdapter(bVar);
        w0();
    }

    private void v0() {
        this.f18824a0 = (RecyclerView) findViewById(2131298421);
        this.X = (RecyclerView) findViewById(2131298429);
        this.f18826c0 = (TextView) findViewById(R.id.tv_other);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_select_lesson;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        v0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
