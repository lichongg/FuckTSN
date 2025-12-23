package com.bxkj.student.run.punchcard;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class TotalActivity extends BaseActivity {
    private SmartRefreshLayout W;
    private EmptyRecyclerView X;
    private TextView Y;
    private TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    private List<Map<String, Object>> f20442a0 = new ArrayList();

    /* renamed from: b0, reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f20443b0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.student.run.punchcard.TotalActivity$a$a, reason: collision with other inner class name */
        class ViewOnClickListenerC0273a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Map f20445a;

            ViewOnClickListenerC0273a(final Map val$stringObjectMap) {
                this.f20445a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v5) {
                TotalActivity.this.startActivity(new Intent(((CommonAdapter) a.this).f1138e, (Class<?>) RecorderListActivity.class).putExtra("termId", JsonParse.getString(this.f20445a, "sysTermId")));
            }
        }

        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(2131298922, JsonParse.getString(stringObjectMap, "sysTerm"));
            holder.J(2131299093, JsonParse.getDouble(stringObjectMap, "score") + "分");
            holder.J(2131299062, "合格次数：" + JsonParse.getString(stringObjectMap, "goodNum"));
            holder.w(2131296688, new ViewOnClickListenerC0273a(stringObjectMap));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            new iOSOneButtonDialog(((BaseActivity) TotalActivity.this).T).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            TotalActivity.this.f20442a0 = (List) data.get("data");
            TotalActivity.this.f20443b0.g(TotalActivity.this.f20442a0);
        }
    }

    private void l0() {
        Http.with(this.T).hideOtherStatusMessage().setObservable(((e0.a) Http.getApiService(e0.a.class)).W(LoginUser.getLoginUser().getUserId())).setDataListener(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        this.Y.setText("姓名：" + LoginUser.getLoginUser().getRealName() + "\u3000学号：" + LoginUser.getLoginUser().getAccount());
        this.X.setLayoutManager(new LinearLayoutManager(this.T));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, 2130772096));
        layoutAnimationController.setOrder(0);
        this.X.setLayoutAnimation(layoutAnimationController);
        a aVar = new a(this.T, R.layout.item_for_punchcard_score_list, this.f20442a0);
        this.f20443b0 = aVar;
        this.X.setAdapter(aVar);
        this.W.h0(false);
        this.W.v(false);
        this.W.setOverScrollMode(2);
        this.X.setEmptyView(findViewById(2131298892));
        l0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("刷脸记录");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_punchcard_total;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (SmartRefreshLayout) findViewById(2131298352);
        this.X = (EmptyRecyclerView) findViewById(2131298351);
        this.Y = (TextView) findViewById(2131298986);
        TextView textView = (TextView) findViewById(R.id.tv_notice);
        this.Z = textView;
        textView.setVisibility(0);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
