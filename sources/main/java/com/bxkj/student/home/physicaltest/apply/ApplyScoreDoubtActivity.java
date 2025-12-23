package com.bxkj.student.home.physicaltest.apply;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.base.view.MyGridView;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.v2.common.utils.b0;
import com.bxkj.student.R;
import com.kuaishou.weapon.p0.t;
import com.orhanobut.logger.j;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.n1;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class ApplyScoreDoubtActivity extends BaseActivity {
    private cn.bluemobi.dylan.base.adapter.c F0;
    private Spinner G0;
    private cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> H0;
    private String J0;
    private EditText W;
    private EditText X;
    private EditText Y;
    private TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    private EditText f17916a0;

    /* renamed from: b0, reason: collision with root package name */
    private EditText f17917b0;

    /* renamed from: c0, reason: collision with root package name */
    private MyGridView f17918c0;

    /* renamed from: k0, reason: collision with root package name */
    private Button f17919k0;

    /* renamed from: p0, reason: collision with root package name */
    private List<String> f17920p0 = new ArrayList();
    private List<Map<String, Object>> I0 = new ArrayList();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(2131298922, JsonParse.getString(stringObjectMap, "examName"));
            holder.J(2131298986, JsonParse.getString(stringObjectMap, "actualScore") + JsonParse.getString(stringObjectMap, "examunit"));
            holder.J(2131299093, JsonParse.getString(stringObjectMap, "score") + "分");
            holder.J(2131299062, JsonParse.getString(stringObjectMap, "rank"));
            holder.h(2131299116).setVisibility(4);
            holder.N(2131297100, false);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ApplyScoreDoubtActivity.this.Q().setVisibility(0);
            ApplyScoreDoubtActivity.this.I0 = (List) data.get("data");
            ApplyScoreDoubtActivity.this.H0.c(ApplyScoreDoubtActivity.this.I0);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) ApplyScoreDoubtActivity.this).T).setMessage(msg).show();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements AdapterView.OnItemSelectedListener {
        c() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String string = JsonParse.getString((Map) ApplyScoreDoubtActivity.this.H0.getItem(position), "examName");
            String string2 = JsonParse.getString((Map) ApplyScoreDoubtActivity.this.H0.getItem(position), "examunit");
            if (string.contains("身高") && string.contains("体重")) {
                ((View) ApplyScoreDoubtActivity.this.X.getParent()).setVisibility(0);
                ((View) ApplyScoreDoubtActivity.this.Y.getParent()).setVisibility(0);
                ((View) ApplyScoreDoubtActivity.this.W.getParent()).setVisibility(8);
            } else {
                ((View) ApplyScoreDoubtActivity.this.X.getParent()).setVisibility(8);
                ((View) ApplyScoreDoubtActivity.this.Y.getParent()).setVisibility(8);
                ((View) ApplyScoreDoubtActivity.this.W.getParent()).setVisibility(0);
                ApplyScoreDoubtActivity.this.Z.setText(string2);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d extends HttpCallBack {
        d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ApplyScoreDoubtActivity.this.g0("申请成功");
            ScoreDoubtActivity scoreDoubtActivity = (ScoreDoubtActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(ScoreDoubtActivity.class);
            if (scoreDoubtActivity != null) {
                scoreDoubtActivity.m0();
            }
            ApplyScoreDoubtActivity.this.finish();
        }
    }

    public static byte[] v0(String filename) {
        Throwable th;
        IOException iOException;
        FileChannel fileChannel;
        FileChannel fileChannel2 = null;
        try {
            fileChannel = new RandomAccessFile(filename, t.f36150k).getChannel();
        } catch (IOException e6) {
            iOException = e6;
            fileChannel = null;
        } catch (Throwable th2) {
            th = th2;
            try {
                fileChannel2.close();
                throw th;
            } catch (IOException e7) {
                e7.printStackTrace();
                throw th;
            }
        }
        try {
            try {
                MappedByteBuffer load = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0L, fileChannel.size()).load();
                j.c(Boolean.valueOf(load.isLoaded()));
                byte[] bArr = new byte[(int) fileChannel.size()];
                if (load.remaining() > 0) {
                    load.get(bArr, 0, load.remaining());
                }
                try {
                    fileChannel.close();
                    return bArr;
                } catch (IOException e8) {
                    e8.printStackTrace();
                    return bArr;
                }
            } catch (Throwable th3) {
                th = th3;
                fileChannel2 = fileChannel;
                fileChannel2.close();
                throw th;
            }
        } catch (IOException e9) {
            iOException = e9;
            iOException.printStackTrace();
            try {
                fileChannel.close();
            } catch (IOException e10) {
                e10.printStackTrace();
            }
            return null;
        }
    }

    private void r0() {
        String trim = this.f17916a0.getText().toString().trim();
        String trim2 = this.f17917b0.getText().toString().trim();
        if (trim.isEmpty()) {
            g0("申请理由不能为空");
            return;
        }
        if (TextUtils.isEmpty(trim2)) {
            g0("联系电话不能为空");
            return;
        }
        String string = JsonParse.getString(this.H0.getItem(this.G0.getSelectedItemPosition()), "examName");
        String string2 = JsonParse.getString(this.H0.getItem(this.G0.getSelectedItemPosition()), "actualScore");
        String trim3 = this.W.getText().toString().trim();
        if (string.contains("身高") && string.contains("体重")) {
            trim3 = this.X.getText().toString().trim() + "/" + this.Y.getText().toString().trim();
        }
        Http.with(this.T).setObservable(((e0.a) Http.getApiService(e0.a.class)).B(LoginUser.getLoginUser().getUserId(), this.J0, JsonParse.getString(this.H0.getItem(this.G0.getSelectedItemPosition()), "examid"), string2, trim3, trim2, trim)).setDataListener(new d());
    }

    private void s0() {
        Http.with(this.T).hideOtherStatusMessage().setObservable(((e0.a) Http.getApiService(e0.a.class)).P(this.J0)).setDataListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ n1 t0(File file) {
        this.f17920p0.add(file.getPath());
        this.F0.c(this.f17920p0);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0(AdapterView adapterView, View view, int i6, long j6) {
        b0.f16879a.r(this.U, new Function1() { // from class: com.bxkj.student.home.physicaltest.apply.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 t02;
                t02 = ApplyScoreDoubtActivity.this.t0((File) obj);
                return t02;
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.G0.setOnItemSelectedListener(new c());
        this.f17918c0.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bxkj.student.home.physicaltest.apply.b
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i6, long j6) {
                ApplyScoreDoubtActivity.this.u0(adapterView, view, i6, j6);
            }
        });
        this.f17919k0.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("体测成绩申诉");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_apply_test_score;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("meaScoreId")) {
            this.J0 = getIntent().getStringExtra("meaScoreId");
        }
        List<String> list = this.f17920p0;
        Context context = this.T;
        cn.bluemobi.dylan.base.adapter.c cVar = new cn.bluemobi.dylan.base.adapter.c(list, context, 4, u.a(10.0f, context));
        this.F0 = cVar;
        cVar.e(3);
        this.f17918c0.setAdapter((ListAdapter) this.F0);
        a aVar = new a(this.T, R.layout.item_for_apply_test_score, this.I0);
        this.H0 = aVar;
        this.G0.setAdapter((SpinnerAdapter) aVar);
        Q().setVisibility(4);
        s0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (EditText) findViewById(R.id.et_score);
        this.X = (EditText) findViewById(R.id.et_height);
        this.Y = (EditText) findViewById(R.id.et_weight);
        this.Z = (TextView) findViewById(R.id.tv_unit);
        this.f17916a0 = (EditText) findViewById(2131296931);
        this.f17917b0 = (EditText) findViewById(2131296941);
        this.f17918c0 = (MyGridView) findViewById(2131297030);
        this.f17919k0 = (Button) findViewById(2131296599);
        this.G0 = (Spinner) findViewById(2131298550);
        this.f17918c0.setVisibility(8);
        this.G0.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
        r0();
    }
}
