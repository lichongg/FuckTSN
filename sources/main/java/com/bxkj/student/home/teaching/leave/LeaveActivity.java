package com.bxkj.student.home.teaching.leave;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.collection.ArrayMap;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.base.view.MyGridView;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.v2.common.utils.b0;
import com.bxkj.student.R;
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
public class LeaveActivity extends BaseActivity {
    private int F0;
    private Integer G0;
    private EditText W;
    private MyGridView X;
    private Button Y;

    /* renamed from: a0, reason: collision with root package name */
    private cn.bluemobi.dylan.base.adapter.c f18838a0;

    /* renamed from: b0, reason: collision with root package name */
    private Spinner f18839b0;

    /* renamed from: c0, reason: collision with root package name */
    private cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> f18840c0;

    /* renamed from: p0, reason: collision with root package name */
    private String f18842p0;
    private List<String> Z = new ArrayList();

    /* renamed from: k0, reason: collision with root package name */
    private List<Map<String, Object>> f18841k0 = new ArrayList();

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
    class b implements AdapterView.OnItemSelectedListener {
        b() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            LeaveActivity.this.G0 = position == 0 ? null : Integer.valueOf(position);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ((SelectLessenListActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(SelectLessenListActivity.class)).s0(LeaveActivity.this.F0);
            LeaveActivity.this.g0("申请成功");
            LeaveActivity.this.finish();
        }
    }

    public static byte[] o0(String filename) {
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

    private void l0() {
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
            sb2.append(cn.bluemobi.dylan.base.utils.b.b(o0(file.getPath())));
        }
        Http.with(this.T).setObservable(((e0.a) Http.getApiService(e0.a.class)).t1(LoginUser.getLoginUser().getUserId(), this.f18842p0, this.G0, trim, sb.toString(), sb2.toString())).setDataListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ n1 m0(File file) {
        this.Z.add(file.getPath());
        this.f18838a0.c(this.Z);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(AdapterView adapterView, View view, int i6, long j6) {
        b0.f16879a.r(this.U, new Function1() { // from class: com.bxkj.student.home.teaching.leave.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 m02;
                m02 = LeaveActivity.this.m0((File) obj);
                return m02;
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.X.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bxkj.student.home.teaching.leave.a
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i6, long j6) {
                LeaveActivity.this.n0(adapterView, view, i6, j6);
            }
        });
        this.Y.setOnClickListener(this);
        this.f18839b0.setOnItemSelectedListener(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("上课请假");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_leave;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("id")) {
            this.f18842p0 = getIntent().getStringExtra("id");
        }
        if (getIntent().hasExtra("position")) {
            this.F0 = getIntent().getIntExtra("position", -1);
        }
        List<String> list = this.Z;
        Context context = this.T;
        cn.bluemobi.dylan.base.adapter.c cVar = new cn.bluemobi.dylan.base.adapter.c(list, context, 4, u.a(10.0f, context));
        this.f18838a0 = cVar;
        cVar.e(3);
        this.X.setAdapter((ListAdapter) this.f18838a0);
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put(CommonNetImpl.NAME, "请选择");
        this.f18841k0.add(arrayMap);
        for (int i6 = 1; i6 < 31; i6++) {
            ArrayMap arrayMap2 = new ArrayMap();
            arrayMap2.put(CommonNetImpl.NAME, "第" + i6 + "周");
            this.f18841k0.add(arrayMap2);
        }
        a aVar = new a(this.T, com.bxkj.place.R.layout.item_for_school_district_list, this.f18841k0);
        this.f18840c0 = aVar;
        this.f18839b0.setAdapter((SpinnerAdapter) aVar);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (EditText) findViewById(2131296931);
        this.X = (MyGridView) findViewById(2131297030);
        this.Y = (Button) findViewById(2131296599);
        this.f18839b0 = (Spinner) findViewById(2131298550);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
        l0();
    }
}
