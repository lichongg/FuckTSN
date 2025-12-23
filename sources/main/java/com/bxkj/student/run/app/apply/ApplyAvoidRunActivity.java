package com.bxkj.student.run.app.apply;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.Spinner;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.base.view.MyGridView;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.v2.common.utils.b0;
import com.bxkj.student.R;
import com.bxkj.student.home.physicaltest.mc.ApplyMcListActivity;
import com.kuaishou.weapon.p0.t;
import com.orhanobut.logger.j;
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
public class ApplyAvoidRunActivity extends BaseActivity {
    private EditText W;
    private MyGridView X;
    private Button Y;
    private List<String> Z = new ArrayList();

    /* renamed from: a0, reason: collision with root package name */
    private cn.bluemobi.dylan.base.adapter.c f19758a0;

    /* renamed from: b0, reason: collision with root package name */
    private Spinner f19759b0;

    /* renamed from: c0, reason: collision with root package name */
    private Spinner f19760c0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ApplyAvoidRunActivity.this.g0("申请成功");
            ApplyMcListActivity applyMcListActivity = (ApplyMcListActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(ApplyMcListActivity.class);
            if (applyMcListActivity != null) {
                applyMcListActivity.m0();
            }
            ApplyAvoidRunActivity.this.finish();
        }
    }

    public static byte[] m0(String filename) {
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

    private void j0() {
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
            sb2.append(cn.bluemobi.dylan.base.utils.b.b(m0(file.getPath())));
        }
        Http.with(this.T).setObservable(((com.bxkj.student.run.app.a) Http.getApiService(com.bxkj.student.run.app.a.class)).n(LoginUser.getLoginUser().getUserId(), trim, sb.toString(), sb2.toString())).setDataListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ n1 k0(File file) {
        this.Z.add(file.getPath());
        this.f19758a0.c(this.Z);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0(AdapterView adapterView, View view, int i6, long j6) {
        b0.f16879a.r(this.U, new Function1() { // from class: com.bxkj.student.run.app.apply.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 k02;
                k02 = ApplyAvoidRunActivity.this.k0((File) obj);
                return k02;
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.X.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bxkj.student.run.app.apply.b
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i6, long j6) {
                ApplyAvoidRunActivity.this.l0(adapterView, view, i6, j6);
            }
        });
        this.Y.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        List<String> list = this.Z;
        Context context = this.T;
        cn.bluemobi.dylan.base.adapter.c cVar = new cn.bluemobi.dylan.base.adapter.c(list, context, 4, u.a(10.0f, context));
        this.f19758a0 = cVar;
        cVar.e(3);
        this.X.setAdapter((ListAdapter) this.f19758a0);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("申请免跑");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_apply_mc;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (EditText) findViewById(2131296931);
        this.X = (MyGridView) findViewById(2131297030);
        this.Y = (Button) findViewById(2131296599);
        this.f19759b0 = (Spinner) findViewById(2131298550);
        this.f19760c0 = (Spinner) findViewById(R.id.spinnerTeam);
        ((View) this.f19759b0.getParent()).setVisibility(8);
        ((View) this.f19760c0.getParent()).setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
        j0();
    }
}
