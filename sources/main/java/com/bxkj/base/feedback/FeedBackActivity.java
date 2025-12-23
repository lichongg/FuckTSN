package com.bxkj.base.feedback;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.base.view.MyGridView;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.bxkj.base.R;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.b0;
import com.bxkj.base.util.n;
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
import x.f;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class FeedBackActivity extends BaseActivity {
    private EditText W;
    private EditText X;
    private MyGridView Y;
    private Button Z;

    /* renamed from: a0, reason: collision with root package name */
    private List<String> f16497a0 = new ArrayList();

    /* renamed from: b0, reason: collision with root package name */
    private cn.bluemobi.dylan.base.adapter.c f16498b0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> map) {
            FeedBackActivity.this.g0("反馈成功");
            FeedBackActivity.this.finish();
        }
    }

    public static byte[] o0(String str) {
        Throwable th;
        IOException iOException;
        FileChannel fileChannel;
        FileChannel fileChannel2 = null;
        try {
            fileChannel = new RandomAccessFile(str, t.f36150k).getChannel();
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

    private void k0() {
        String trim = this.W.getText().toString().trim();
        if (trim.isEmpty()) {
            g0("申请理由不能为空");
            return;
        }
        if (this.f16497a0.size() == 0) {
            g0("至少上传一张图片");
            return;
        }
        String trim2 = this.X.getText().toString().trim();
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        Iterator<String> it = this.f16497a0.iterator();
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
        Http.with(this.T).setObservable(((f) Http.getApiService(f.class)).j(b0.h(this.T), "Android", LoginUser.getLoginUser().getSchoolId(), trim, LoginUser.getLoginUser().getUserId(), trim2, sb.toString(), sb2.toString(), "0")).setDataListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ n1 l0(File file) {
        this.f16497a0.add(file.getPath());
        this.f16498b0.c(this.f16497a0);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(AdapterView adapterView, View view, int i6, long j6) {
        if (i6 == this.f16497a0.size()) {
            com.bxkj.base.v2.common.utils.b0.f16879a.r(this.U, new Function1() { // from class: com.bxkj.base.feedback.c
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    n1 l02;
                    l02 = FeedBackActivity.this.l0((File) obj);
                    return l02;
                }
            });
        } else {
            n.c(this.T, this.f16497a0, i6);
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.Y.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bxkj.base.feedback.a
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i6, long j6) {
                FeedBackActivity.this.m0(adapterView, view, i6, j6);
            }
        });
        this.Z.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.base.feedback.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedBackActivity.this.n0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_feedback;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("反馈求助");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle bundle) {
        this.W = (EditText) findViewById(R.id.et_content);
        this.X = (EditText) findViewById(R.id.et_phone);
        this.Y = (MyGridView) findViewById(R.id.gv_images);
        this.Z = (Button) findViewById(R.id.bt_commit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(View view) {
        k0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("imagePath")) {
            this.f16497a0.add(getIntent().getStringExtra("imagePath"));
        }
        List<String> list = this.f16497a0;
        Context context = this.T;
        cn.bluemobi.dylan.base.adapter.c cVar = new cn.bluemobi.dylan.base.adapter.c(list, context, 4, u.a(10.0f, context));
        this.f16498b0 = cVar;
        cVar.e(4);
        this.Y.setAdapter((ListAdapter) this.f16498b0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
