package com.bxkj.student.home.teaching.leave;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.R;
import com.bxkj.student.home.teaching.leave.SelectLessenListActivity;
import com.bxkj.student.home.teaching.leave.recorder.LeaveRecordListActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.List;
import java.util.Map;
import m2.h;
import n2.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class SelectLessenListActivity extends BaseActivity {
    private RecyclerView W;
    private SmartRefreshLayout X;
    private List<Map<String, Object>> Y;
    private CommonAdapter<Map<String, Object>> Z;

    /* renamed from: a0, reason: collision with root package name */
    private int f18846a0 = 1;

    /* renamed from: b0, reason: collision with root package name */
    private int f18847b0 = 10;

    /* renamed from: c0, reason: collision with root package name */
    private int f18848c0 = 1;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(ViewHolder viewHolder, Map map, View view) {
            Intent intent = new Intent(this.f1138e, (Class<?>) LeaveActivity.class);
            intent.putExtra("position", viewHolder.f());
            intent.putExtra("id", u.O(map, "id"));
            SelectLessenListActivity.this.startActivity(intent);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void q(Map map, View view) {
            Intent intent = new Intent(this.f1138e, (Class<?>) LeaveRecordListActivity.class);
            intent.putExtra("id", u.O(map, "id"));
            SelectLessenListActivity.this.startActivity(intent);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(R.id.tv_term, u.O(stringObjectMap, "termName"));
            holder.J(2131299158, u.O(stringObjectMap, "schoolTimeName"));
            holder.J(R.id.tv_teacher, u.O(stringObjectMap, "teacherName"));
            holder.J(R.id.tv_lessen_name, u.O(stringObjectMap, "curriculumName"));
            holder.w(R.id.bt_leave, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.leave.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SelectLessenListActivity.a.this.p(holder, stringObjectMap, view);
                }
            });
            holder.w(R.id.bt_recorder, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.leave.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SelectLessenListActivity.a.this.q(stringObjectMap, view);
                }
            });
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements e {
        b() {
        }

        @Override // n2.d
        public void a(h refreshlayout) {
            SelectLessenListActivity.this.f18846a0 = 1;
            SelectLessenListActivity.this.r0();
        }

        @Override // n2.b
        public void f(h refreshlayout) {
            int i6 = SelectLessenListActivity.this.f18848c0 / SelectLessenListActivity.this.f18847b0;
            int i7 = SelectLessenListActivity.this.f18846a0;
            if (SelectLessenListActivity.this.f18848c0 % SelectLessenListActivity.this.f18847b0 != 0) {
                i6++;
            }
            if (i7 >= i6) {
                SelectLessenListActivity.this.X.Q();
                SelectLessenListActivity.this.g0("没有了");
            } else {
                SelectLessenListActivity.this.f18846a0++;
                SelectLessenListActivity.this.r0();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            SelectLessenListActivity.this.f18848c0 = Integer.parseInt(u.O(data, "total"));
            List list = (List) data.get("data");
            if (SelectLessenListActivity.this.f18846a0 == 1) {
                SelectLessenListActivity.this.Y = list;
            } else {
                SelectLessenListActivity.this.Y.addAll(list);
            }
            SelectLessenListActivity.this.Z.g(SelectLessenListActivity.this.Y);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            SelectLessenListActivity.this.X.Y();
            SelectLessenListActivity.this.X.Q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0() {
        Http.with(this.T).hideLoadingDialog().setObservable(((e0.a) Http.getApiService(e0.a.class)).m0(LoginUser.getLoginUser().getUserId())).setDataListener(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        this.W.setLayoutManager(new LinearLayoutManager(this.T));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.T, 2130772096));
        layoutAnimationController.setOrder(0);
        this.W.setLayoutAnimation(layoutAnimationController);
        a aVar = new a(this.T, R.layout.item_for_leave_list, this.Y);
        this.Z = aVar;
        this.W.setAdapter(aVar);
        this.X.D(new b());
        this.X.F();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("选择要请假的课程");
    }

    public void s0(int position) {
        CommonAdapter<Map<String, Object>> commonAdapter = this.Z;
        if (commonAdapter == null || position >= commonAdapter.getItemCount() || position < 0) {
            return;
        }
        this.Z.getItem(position).put(NotificationCompat.CATEGORY_STATUS, "待审核");
        this.Z.notifyItemChanged(position);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return 2131492999;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (RecyclerView) findViewById(2131298351);
        this.X = (SmartRefreshLayout) findViewById(2131298352);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
