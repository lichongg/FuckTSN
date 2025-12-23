package com.bxkj.student.life.secondhand;

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
import androidx.collection.ArrayMap;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.base.view.MyGridView;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.alibaba.fastjson.JSON;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.n1;
import x.e;
import x.i;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class PublishBuyActivity extends BaseActivity {
    private cn.bluemobi.dylan.base.adapter.c G0;
    private cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> H0;
    private EditText W;
    private EditText X;
    private EditText Y;
    private EditText Z;

    /* renamed from: a0, reason: collision with root package name */
    private EditText f19408a0;

    /* renamed from: b0, reason: collision with root package name */
    private Button f19409b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f19410c0;

    /* renamed from: k0, reason: collision with root package name */
    private Spinner f19411k0;

    /* renamed from: p0, reason: collision with root package name */
    private MyGridView f19412p0;
    private List<String> F0 = new ArrayList();
    private List<Map<String, Object>> I0 = new ArrayList();

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
            PublishBuyActivity.this.I0 = JsonParse.getList(data, "data");
            ArrayMap arrayMap = new ArrayMap();
            arrayMap.put(CommonNetImpl.NAME, "请选择物品类型");
            PublishBuyActivity.this.I0.add(0, arrayMap);
            PublishBuyActivity.this.H0.c(PublishBuyActivity.this.I0);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            PublishBuyActivity.this.finish();
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
        Http.with(this.T).hideLoadingDialog().setObservable(((e) Http.getApiService(e.class)).c()).setDataListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ n1 n0(File file) {
        this.F0.add(file.getPath());
        this.G0.c(this.F0);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(AdapterView adapterView, View view, int i6, long j6) {
        b0.f16879a.r(this.U, new Function1() { // from class: com.bxkj.student.life.secondhand.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 n02;
                n02 = PublishBuyActivity.this.n0((File) obj);
                return n02;
            }
        });
    }

    private void p0() {
        if (this.f19411k0.getSelectedItemPosition() == -1 || this.f19411k0.getSelectedItemPosition() == 0) {
            g0("请选择物品类型");
            return;
        }
        String string = JsonParse.getString(this.H0.getItem(this.f19411k0.getSelectedItemPosition()), "id");
        String trim = this.W.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            g0("请简单描述一下哦");
            return;
        }
        String trim2 = this.X.getText().toString().trim();
        if (TextUtils.isEmpty(trim2)) {
            g0("请定一个合适的价格哦");
            return;
        }
        String trim3 = this.Y.getText().toString().trim();
        String trim4 = this.Z.getText().toString().trim();
        String trim5 = this.f19408a0.getText().toString().trim();
        if (TextUtils.isEmpty(trim3) && TextUtils.isEmpty(trim4) && TextUtils.isEmpty(trim5)) {
            g0("至少填写一种联系方式哦");
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<String> it = this.F0.iterator();
        while (it.hasNext()) {
            File file = new File(it.next());
            String b6 = cn.bluemobi.dylan.base.utils.b.b(q0(file.getPath()));
            arrayList2.add(b6);
            HashMap hashMap = new HashMap(2);
            hashMap.put("imageName", file.getName());
            hashMap.put("imageBase64", b6);
            arrayList.add(hashMap);
        }
        Http.with(this.T).setObservable(((i) Http.getApiService(i.class)).e(LoginUser.getLoginUser().getOpenId(), string, this.f19410c0, trim, JSON.toJSONString(arrayList2), trim3, trim5, trim4, trim2)).setDataListener(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.f19409b0.setOnClickListener(this);
        this.f19412p0.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bxkj.student.life.secondhand.b
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i6, long j6) {
                PublishBuyActivity.this.o0(adapterView, view, i6, j6);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("发布求购信息");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_publish_buy;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("type")) {
            int intExtra = getIntent().getIntExtra("type", 0);
            this.f19410c0 = intExtra;
            if (intExtra == 0) {
                setTitle("发布求购信息");
            } else {
                setTitle("发布出售信息");
            }
        }
        List<String> list = this.F0;
        Context context = this.T;
        cn.bluemobi.dylan.base.adapter.c cVar = new cn.bluemobi.dylan.base.adapter.c(list, context, 4, u.a(10.0f, context));
        this.G0 = cVar;
        cVar.e(3);
        this.f19412p0.setAdapter((ListAdapter) this.G0);
        a aVar = new a(this.T, com.bxkj.place.R.layout.item_for_school_district_list, this.I0);
        this.H0 = aVar;
        this.f19411k0.setAdapter((SpinnerAdapter) aVar);
        m0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.f19412p0 = (MyGridView) findViewById(2131297030);
        this.f19411k0 = (Spinner) findViewById(2131298550);
        this.W = (EditText) findViewById(R.id.et_desc);
        this.f19412p0 = (MyGridView) findViewById(2131297030);
        this.X = (EditText) findViewById(R.id.et_price);
        this.Y = (EditText) findViewById(2131296941);
        this.Z = (EditText) findViewById(R.id.et_wechat);
        this.f19408a0 = (EditText) findViewById(R.id.et_qq);
        this.f19409b0 = (Button) findViewById(R.id.bt_publish);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
        if (v5.getId() != 2131296629) {
            return;
        }
        p0();
    }
}
