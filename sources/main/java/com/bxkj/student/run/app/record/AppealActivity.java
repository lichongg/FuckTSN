package com.bxkj.student.run.app.record;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import androidx.collection.ArrayMap;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.base.view.MyGridView;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.alibaba.fastjson.JSON;
import com.bxkj.base.v2.common.utils.b0;
import com.bxkj.student.R;
import com.bxkj.student.run.app.record.AppealActivity;
import com.kuaishou.weapon.p0.t;
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
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class AppealActivity extends BaseActivity {
    private EditText W;
    private iOSOneButtonDialog X;
    private MyGridView Y;
    private Button Z;

    /* renamed from: a0, reason: collision with root package name */
    private List<String> f19966a0 = new ArrayList();

    /* renamed from: b0, reason: collision with root package name */
    private cn.bluemobi.dylan.base.adapter.c f19967b0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends HttpCallBack {
        public static /* synthetic */ boolean b(DialogInterface dialogInterface, int i6, KeyEvent keyEvent) {
            return i6 == 4;
        }

        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(View view) {
            AppealActivity.this.finish();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            RunRecorderListActivity runRecorderListActivity = (RunRecorderListActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(RunRecorderListActivity.class);
            if (runRecorderListActivity != null) {
                runRecorderListActivity.J0();
            }
            AppealActivity.this.X = new iOSOneButtonDialog(((BaseActivity) AppealActivity.this).T).setMessage("申诉成功，等待管理员审核，请耐心等待！").setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.record.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AppealActivity.a.this.c(view);
                }
            });
            AppealActivity.this.X.setCanceledOnTouchOutside(false);
            AppealActivity.this.X.show();
            AppealActivity.this.X.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.bxkj.student.run.app.record.e
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i6, KeyEvent keyEvent) {
                    return AppealActivity.a.b(dialogInterface, i6, keyEvent);
                }
            });
        }
    }

    public static byte[] s0(String filename) {
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
                com.orhanobut.logger.j.c(Boolean.valueOf(load.isLoaded()));
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

    private void n0() {
        String trim = this.W.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            new iOSOneButtonDialog(this.T).setMessage(this.W.getHint()).show();
            return;
        }
        String[] strArr = new String[this.f19966a0.size()];
        for (int i6 = 0; i6 < this.f19966a0.size(); i6++) {
            strArr[i6] = com.bxkj.base.util.j.b(this.f19966a0.get(i6));
        }
        Http.with(this.T).setObservable(((com.bxkj.student.run.app.a) Http.getApiService(com.bxkj.student.run.app.a.class)).b(getIntent().getStringExtra("id"), trim, JSON.toJSONString(strArr))).setDataListener(new a());
    }

    public static Map<String, RequestBody> o0(String key, List<File> files) {
        ArrayMap arrayMap = new ArrayMap();
        for (int i6 = 0; i6 < files.size(); i6++) {
            File file = files.get(i6);
            arrayMap.put(key + "\"; filename=\"" + file.getName(), RequestBody.create(MediaType.parse("image/png"), file));
        }
        return arrayMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ n1 q0(File file) {
        this.f19966a0.add(file.getPath());
        this.f19967b0.c(this.f19966a0);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r0(AdapterView adapterView, View view, int i6, long j6) {
        b0.f16879a.r(this.U, new Function1() { // from class: com.bxkj.student.run.app.record.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 q02;
                q02 = AppealActivity.this.q0((File) obj);
                return q02;
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.Z.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.record.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppealActivity.this.p0(view);
            }
        });
        this.Y.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bxkj.student.run.app.record.b
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i6, long j6) {
                AppealActivity.this.r0(adapterView, view, i6, j6);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        List<String> list = this.f19966a0;
        Context context = this.T;
        cn.bluemobi.dylan.base.adapter.c cVar = new cn.bluemobi.dylan.base.adapter.c(list, context, 4, u.a(10.0f, context));
        this.f19967b0 = cVar;
        cVar.e(3);
        this.Y.setAdapter((ListAdapter) this.f19967b0);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("我要申诉");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p0(View view) {
        n0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_appeal;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (EditText) findViewById(2131296947);
        this.Z = (Button) findViewById(2131296599);
        this.Y = (MyGridView) findViewById(2131297030);
        this.Z = (Button) findViewById(2131296599);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
