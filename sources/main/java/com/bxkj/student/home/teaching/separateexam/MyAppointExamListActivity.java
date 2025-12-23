package com.bxkj.student.home.teaching.separateexam;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.R;
import com.bxkj.student.home.teaching.separateexam.MyAppointExamListActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class MyAppointExamListActivity extends BaseActivity {
    private SmartRefreshLayout W;
    private EmptyRecyclerView X;
    private TextView Y;
    private List<Map<String, Object>> Z = new ArrayList();

    /* renamed from: a0, reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f19018a0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.student.home.teaching.separateexam.MyAppointExamListActivity$a$a, reason: collision with other inner class name */
        class C0238a extends HttpCallBack {
            C0238a() {
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
                MyAppointExamListActivity.this.k0();
            }
        }

        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(Map map) {
            Http.with(this.f1138e).setObservable(((e0.a) Http.getApiService(e0.a.class)).C(JsonParse.getString(map, "id"))).setDataListener(new C0238a());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void q(final Map map, View view) {
            new iOSTwoButtonDialog(this.f1138e).setMessage("确定取消？").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.separateexam.d
                @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                public final void buttonRightOnClick() {
                    MyAppointExamListActivity.a.this.p(map);
                }
            }).show();
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public void c(ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(2131298986, JsonParse.getString(stringObjectMap, CommonNetImpl.NAME));
            ((View) holder.h(2131298922).getParent()).setVisibility(8);
            holder.J(R.id.tv_lesson, JsonParse.getString(stringObjectMap, "teaching"));
            holder.J(R.id.tv_teacher_name, JsonParse.getString(stringObjectMap, "teacher"));
            ((View) holder.h(R.id.tv_lesson_all).getParent()).setVisibility(8);
            holder.J(2131298773, JsonParse.getString(stringObjectMap, "address"));
            ((View) holder.h(R.id.tv_appoint_time).getParent()).setVisibility(8);
            holder.J(R.id.tv_exam_time, JsonParse.getString(stringObjectMap, "time"));
            holder.J(2131299116, JsonParse.getString(stringObjectMap, "state"));
            holder.J(R.id.tv_remark, JsonParse.getString(stringObjectMap, "remark"));
            holder.J(R.id.bt_start, "取消约考");
            Button button = (Button) holder.h(R.id.bt_start);
            String string = JsonParse.getString(stringObjectMap, "stateid");
            holder.N(R.id.bt_start, "0".equals(string));
            button.setEnabled("0".equals(string));
            holder.w(R.id.bt_start, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.separateexam.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MyAppointExamListActivity.a.this.q(stringObjectMap, view);
                }
            });
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            MyAppointExamListActivity.this.Z = JsonParse.getList(data, "data");
            MyAppointExamListActivity.this.f19018a0.g(MyAppointExamListActivity.this.Z);
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        this.X.setLayoutManager(new LinearLayoutManager(this.T));
        a aVar = new a(this.T, R.layout.item_for_my_appoint_exam_list, this.Z);
        this.f19018a0 = aVar;
        this.X.setAdapter(aVar);
        this.X.setEmptyView(this.Y);
        k0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("我的预约考试");
    }

    public void k0() {
        Http.with(this.T).setObservable(((e0.a) Http.getApiService(e0.a.class)).W0(LoginUser.getLoginUser().getUserId())).setDataListener(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return 2131493640;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (SmartRefreshLayout) findViewById(2131298352);
        this.X = (EmptyRecyclerView) findViewById(2131298351);
        this.Y = (TextView) findViewById(2131298892);
        this.W.h0(false);
        this.W.v(false);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
