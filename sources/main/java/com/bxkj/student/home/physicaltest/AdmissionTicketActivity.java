package com.bxkj.student.home.physicaltest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.photoview.ImagePagerActivity;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.student.R;
import com.bxkj.student.common.utils.UniversalItemDecoration;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class AdmissionTicketActivity extends BaseActivity {
    private ImageView F0;
    private RecyclerView G0;
    private SmartWebView H0;
    private List<Map<String, Object>> I0;
    private String J0;
    private CommonAdapter<Map<String, Object>> K0;
    private TextView W;
    private TextView X;
    private TextView Y;
    private TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    private TextView f17897a0;

    /* renamed from: b0, reason: collision with root package name */
    private TextView f17898b0;

    /* renamed from: c0, reason: collision with root package name */
    private TextView f17899c0;

    /* renamed from: k0, reason: collision with root package name */
    private TextView f17900k0;

    /* renamed from: p0, reason: collision with root package name */
    private ImageView f17901p0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends CommonAdapter<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.J(2131298986, JsonParse.getString(stringObjectMap, "scheduleName"));
            holder.J(2131299113, "开始时间：" + JsonParse.getString(stringObjectMap, "beginTime"));
            holder.J(R.id.tv_end_time, "结束时间：" + JsonParse.getString(stringObjectMap, "endTime"));
            holder.J(R.id.tv_appointment_time, "预约时间：" + JsonParse.getString(stringObjectMap, "appTime"));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends UniversalItemDecoration {
        b() {
        }

        @Override // com.bxkj.student.common.utils.UniversalItemDecoration
        public UniversalItemDecoration.b a(int position) {
            if (position == AdmissionTicketActivity.this.K0.getItemCount()) {
                return null;
            }
            UniversalItemDecoration.a aVar = new UniversalItemDecoration.a();
            aVar.f17791d = u.a(1.0f, ((BaseActivity) AdmissionTicketActivity.this).T);
            aVar.f17787f = ContextCompat.getColor(((BaseActivity) AdmissionTicketActivity.this).T, R.color.defaultBackgroundColor);
            return aVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            AdmissionTicketActivity.this.Q().setVisibility(0);
            AdmissionTicketActivity.this.r0(data);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) AdmissionTicketActivity.this).T).setMessage(msg).show();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v5) {
            AdmissionTicketActivity admissionTicketActivity = AdmissionTicketActivity.this;
            admissionTicketActivity.q0(admissionTicketActivity.J0);
        }
    }

    private void o0() {
        Http.with(this.T).hideOtherStatusMessage().setObservable(((e0.a) Http.getApiService(e0.a.class)).C1()).setDataListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(String imageUrl) {
        Intent intent = new Intent(this.T, (Class<?>) ImagePagerActivity.class);
        intent.putExtra(ImagePagerActivity.T, new String[]{imageUrl});
        intent.putExtra(ImagePagerActivity.S, 1);
        startActivity(intent);
        overridePendingTransition(2130772094, 2130772095);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0(Map<String, Object> data) {
        this.W.setText("姓名：" + JsonParse.getString(data, CommonNetImpl.NAME));
        this.X.setText("学号：" + JsonParse.getString(data, "userNum"));
        this.Y.setText("性别：" + JsonParse.getString(data, "sex"));
        this.Z.setText("年级：" + JsonParse.getString(data, "grade"));
        this.f17897a0.setText("院系：" + JsonParse.getString(data, "dept"));
        this.f17898b0.setText("专业：" + JsonParse.getString(data, "major"));
        this.f17899c0.setText("班级：" + JsonParse.getString(data, "class"));
        String string = JsonParse.getString(data, "IDCard");
        if (!TextUtils.isEmpty(string)) {
            this.f17900k0.setVisibility(0);
            this.f17900k0.setText(string);
        }
        this.J0 = JsonParse.getString(data, "collectPhoto");
        com.bumptech.glide.b.D(this.T).a(this.J0).y0(2131690097).z(2131690097).m1(this.F0);
        p0(JsonParse.getString(data, "erWeiMaCode"));
        this.F0.setOnClickListener(new d());
        List<Map<String, Object>> list = JsonParse.getList(data, "meaInfo");
        this.I0 = list;
        this.K0.g(list);
        this.H0.h(JsonParse.getString(data, "specification"));
        this.H0.getWebView().getSettings().setTextSize(WebSettings.TextSize.LARGEST);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        s0(this, 1.0f);
        Q().setVisibility(8);
        this.K0 = new a(this.T, R.layout.item_for_physical_exam_admission_ticket, this.I0);
        this.G0.setLayoutManager(new LinearLayoutManager(this.T));
        this.G0.setAdapter(this.K0);
        this.G0.addItemDecoration(new b());
        o0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("体测准考证");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        s0(this, -1.0f);
        super.onDestroy();
    }

    public void p0(String cardNum) {
        this.f17901p0.setImageBitmap(new com.bxkj.base.v2.common.qrcode.b(this.U).f(cardNum, 2131689689));
    }

    private void s0(Activity activity, float brightness) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = brightness;
        window.setAttributes(attributes);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_physical_exam_admission_ticket;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (TextView) findViewById(2131298986);
        this.X = (TextView) findViewById(2131298997);
        this.Y = (TextView) findViewById(2131299099);
        this.Z = (TextView) findViewById(2131298922);
        this.f17897a0 = (TextView) findViewById(2131299200);
        this.f17898b0 = (TextView) findViewById(2131298971);
        this.f17899c0 = (TextView) findViewById(2131298835);
        this.f17900k0 = (TextView) findViewById(R.id.tv_idcard);
        this.f17901p0 = (ImageView) findViewById(2131297216);
        this.F0 = (ImageView) findViewById(2131297240);
        this.G0 = (RecyclerView) findViewById(R.id.rv_list);
        this.H0 = (SmartWebView) findViewById(2131298609);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
