package com.bxkj.student.home.teaching.healthstatus;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.base.view.MyGridView;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.v2.common.utils.b0;
import com.bxkj.place.R;
import com.kuaishou.weapon.p0.t;
import com.orhanobut.logger.j;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.n1;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class ApplyHealthStudentActivity extends BaseActivity {
    private EditText W;
    private MyGridView X;
    private Button Y;

    /* renamed from: a0, reason: collision with root package name */
    private cn.bluemobi.dylan.base.adapter.c f18289a0;

    /* renamed from: b0, reason: collision with root package name */
    private Spinner f18290b0;

    /* renamed from: c0, reason: collision with root package name */
    private cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> f18291c0;
    private List<String> Z = new ArrayList();

    /* renamed from: k0, reason: collision with root package name */
    private List<Map<String, Object>> f18292k0 = new ArrayList();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.J(2131298986, JsonParse.getString(stringObjectMap, CommonNetImpl.NAME));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ApplyHealthStudentActivity.this.Q().setVisibility(0);
            ApplyHealthStudentActivity.this.f18292k0 = (List) data.get("data");
            ApplyHealthStudentActivity.this.f18291c0.c(ApplyHealthStudentActivity.this.f18292k0);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ApplyHealthStudentActivity.this.g0("申请成功");
            ApplyHealthStatusListActivity applyHealthStatusListActivity = (ApplyHealthStatusListActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(ApplyHealthStatusListActivity.class);
            if (applyHealthStatusListActivity != null) {
                applyHealthStatusListActivity.m0();
            }
            ApplyHealthStudentActivity.this.finish();
        }
    }

    public static byte[] q0(String filename) {
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

    private void m0() {
        String trim = this.W.getText().toString().trim();
        if (trim.isEmpty()) {
            g0("申请理由不能为空");
            return;
        }
        if (this.Z.size() == 0) {
            g0("至少上传一张图片");
            return;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        Iterator<String> it = this.Z.iterator();
        while (it.hasNext()) {
            File file = new File(it.next());
            String str = ",";
            sb.append(sb.toString().isEmpty() ? "" : ",");
            sb.append(file.getName());
            if (sb2.toString().isEmpty()) {
                str = "";
            }
            sb2.append(str);
            sb2.append(cn.bluemobi.dylan.base.utils.b.b(q0(file.getPath())));
        }
        Http.with(this.T).setObservable(((e0.a) Http.getApiService(e0.a.class)).y0(LoginUser.getLoginUser().getUserId(), trim, sb.toString(), sb2.toString(), JsonParse.getString(this.f18291c0.getItem(this.f18290b0.getSelectedItemPosition()), "id"))).setDataListener(new c());
    }

    private void n0() {
        Http.with(this.T).setObservable(((e0.a) Http.getApiService(e0.a.class)).h0()).setDataListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ n1 o0(File file) {
        this.Z.add(file.getPath());
        this.f18289a0.c(this.Z);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p0(AdapterView adapterView, View view, int i6, long j6) {
        b0.f16879a.r(this.U, new Function1() { // from class: com.bxkj.student.home.teaching.healthstatus.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 o02;
                o02 = ApplyHealthStudentActivity.this.o0((File) obj);
                return o02;
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.X.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bxkj.student.home.teaching.healthstatus.d
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i6, long j6) {
                ApplyHealthStudentActivity.this.p0(adapterView, view, i6, j6);
            }
        });
        this.Y.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        List<String> list = this.Z;
        Context context = this.T;
        cn.bluemobi.dylan.base.adapter.c cVar = new cn.bluemobi.dylan.base.adapter.c(list, context, 4, u.a(10.0f, context));
        this.f18289a0 = cVar;
        cVar.e(3);
        this.X.setAdapter((ListAdapter) this.f18289a0);
        a aVar = new a(this.T, R.layout.item_for_school_district_list, this.f18292k0);
        this.f18291c0 = aVar;
        this.f18290b0.setAdapter((SpinnerAdapter) aVar);
        Q().setVisibility(4);
        n0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("申请状态");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return com.bxkj.student.R.layout.ac_apply_health_status;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (EditText) findViewById(2131296931);
        this.X = (MyGridView) findViewById(2131297030);
        this.Y = (Button) findViewById(2131296599);
        Spinner spinner = (Spinner) findViewById(2131298550);
        this.f18290b0 = spinner;
        spinner.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
        m0();
    }
}
