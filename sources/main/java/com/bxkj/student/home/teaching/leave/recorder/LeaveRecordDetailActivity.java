package com.bxkj.student.home.teaching.leave.recorder;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.view.MyGridView;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.photoview.ImagePagerActivity;
import com.bxkj.student.R;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class LeaveRecordDetailActivity extends BaseActivity {
    private String F0;
    private List<String> G0;
    private TextView W;
    private TextView X;
    private TextView Y;
    private TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    private TextView f18859a0;

    /* renamed from: b0, reason: collision with root package name */
    private TextView f18860b0;

    /* renamed from: c0, reason: collision with root package name */
    private TextView f18861c0;

    /* renamed from: k0, reason: collision with root package name */
    private TextView f18862k0;

    /* renamed from: p0, reason: collision with root package name */
    private MyGridView f18863p0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends HttpCallBack {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.student.home.teaching.leave.recorder.LeaveRecordDetailActivity$a$a, reason: collision with other inner class name */
        class C0228a extends cn.bluemobi.dylan.base.adapter.common.abslistview.a<String> {
            C0228a(Context context, int layoutId, List datas) {
                super(context, layoutId, datas);
            }

            @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.a
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public void a(ViewHolder holder, String s5) {
                holder.s(R.id.iv_img, s5);
            }
        }

        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            LeaveRecordDetailActivity.this.Q().setVisibility(0);
            LeaveRecordDetailActivity.this.W.setText(JsonParse.getString(data, "week"));
            LeaveRecordDetailActivity.this.X.setText(JsonParse.getString(data, "teacherCurriculumName"));
            LeaveRecordDetailActivity.this.Y.setText(JsonParse.getString(data, "auditorName"));
            LeaveRecordDetailActivity.this.Z.setText(JsonParse.getString(data, "applyDate"));
            LeaveRecordDetailActivity.this.f18859a0.setText(JsonParse.getString(data, "applyMemo"));
            LeaveRecordDetailActivity.this.f18860b0.setText(JsonParse.getString(data, NotificationCompat.CATEGORY_STATUS));
            String string = JsonParse.getString(data, "auditDate");
            if (TextUtils.isEmpty(string)) {
                ((View) LeaveRecordDetailActivity.this.f18861c0.getParent()).setVisibility(8);
            } else {
                ((View) LeaveRecordDetailActivity.this.f18861c0.getParent()).setVisibility(0);
            }
            LeaveRecordDetailActivity.this.f18861c0.setText(string);
            String string2 = JsonParse.getString(data, "auditMemo");
            if (TextUtils.isEmpty(string2)) {
                ((View) LeaveRecordDetailActivity.this.f18862k0.getParent()).setVisibility(8);
            } else {
                ((View) LeaveRecordDetailActivity.this.f18862k0.getParent()).setVisibility(0);
            }
            LeaveRecordDetailActivity.this.f18862k0.setText(string2);
            LeaveRecordDetailActivity.this.G0 = JsonParse.getList(data, "imgs", String.class);
            LeaveRecordDetailActivity.this.f18863p0.setAdapter((ListAdapter) new C0228a(((BaseActivity) LeaveRecordDetailActivity.this).T, R.layout.item_for_lost_img, LeaveRecordDetailActivity.this.G0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0(AdapterView adapterView, View view, int i6, long j6) {
        v0((String[]) this.G0.toArray(new String[this.G0.size()]), i6);
    }

    private void v0(String[] arr, int position) {
        Intent intent = new Intent(this.T, (Class<?>) ImagePagerActivity.class);
        intent.putExtra(ImagePagerActivity.T, arr);
        intent.putExtra(ImagePagerActivity.S, position);
        startActivity(intent);
        overridePendingTransition(2130772094, 2130772095);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.f18863p0.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bxkj.student.home.teaching.leave.recorder.a
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i6, long j6) {
                LeaveRecordDetailActivity.this.u0(adapterView, view, i6, j6);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("请假记录详情");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_leave_record_detail;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        Q().setVisibility(8);
        if (getIntent().hasExtra("id")) {
            this.F0 = getIntent().getStringExtra("id");
        }
        Http.with(this.T).setLoadingMessage("加载中...").setObservable(((e0.a) Http.getApiService(e0.a.class)).C0(this.F0)).setDataListener(new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (TextView) findViewById(R.id.tv_week);
        this.X = (TextView) findViewById(R.id.tv_lesson);
        this.Y = (TextView) findViewById(R.id.tv_teacher);
        this.Z = (TextView) findViewById(2131299158);
        this.f18859a0 = (TextView) findViewById(R.id.tv_reason);
        this.f18860b0 = (TextView) findViewById(2131299116);
        this.f18861c0 = (TextView) findViewById(R.id.tv_check_time);
        this.f18862k0 = (TextView) findViewById(R.id.tv_check_reason);
        this.f18863p0 = (MyGridView) findViewById(2131297030);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
