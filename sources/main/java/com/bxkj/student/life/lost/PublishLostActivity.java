package com.bxkj.student.life.lost;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.cardview.widget.CardView;
import androidx.collection.ArrayMap;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
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

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class PublishLostActivity extends BaseActivity {
    private RecyclerView F0;
    private RadioGroup G0;
    private int H0;
    private Spinner I0;
    private MyGridView J0;
    private cn.bluemobi.dylan.base.adapter.c M0;
    private cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> N0;
    private CommonAdapter<Map<String, Object>> Q0;
    private EditText W;
    private EditText X;
    private EditText Y;
    private EditText Z;

    /* renamed from: a0, reason: collision with root package name */
    private EditText f19114a0;

    /* renamed from: b0, reason: collision with root package name */
    private Button f19115b0;

    /* renamed from: c0, reason: collision with root package name */
    private CheckBox f19116c0;

    /* renamed from: k0, reason: collision with root package name */
    private CardView f19117k0;

    /* renamed from: p0, reason: collision with root package name */
    private LinearLayout f19118p0;
    private List<String> K0 = new ArrayList();
    private final int L0 = 204;
    private List<Map<String, Object>> O0 = new ArrayList();
    private List<Map<String, Object>> P0 = new ArrayList();

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
    class b extends CommonAdapter<Map<String, Object>> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Map f19121a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ ViewHolder f19122b;

            a(final Map val$stringObjectMap, final ViewHolder val$holder) {
                this.f19121a = val$stringObjectMap;
                this.f19122b = val$holder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v5) {
                PublishLostActivity.this.P0.remove(this.f19121a);
                b.this.notifyItemRemoved(this.f19122b.f());
            }
        }

        b(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(R.id.tv_question, JsonParse.getString(stringObjectMap, "question"));
            holder.J(R.id.tv_answer, JsonParse.getString(stringObjectMap, "answer"));
            holder.w(2131296602, new a(stringObjectMap, holder));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements CompoundButton.OnCheckedChangeListener {
        c() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            PublishLostActivity.this.f19117k0.setVisibility(isChecked ? 0 : 8);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d extends HttpCallBack {
        d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            PublishLostActivity.this.O0 = JsonParse.getList(data, "data");
            ArrayMap arrayMap = new ArrayMap();
            arrayMap.put(CommonNetImpl.NAME, "请选择物品类型");
            PublishLostActivity.this.O0.add(0, arrayMap);
            PublishLostActivity.this.N0.c(PublishLostActivity.this.O0);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e extends HttpCallBack {
        e() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            PublishLostActivity.this.finish();
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

    private void o0() {
        Http.with(this.T).hideLoadingDialog().setObservable(((x.e) Http.getApiService(x.e.class)).c()).setDataListener(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ n1 p0(File file) {
        this.K0.add(file.getPath());
        this.M0.c(this.K0);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q0(AdapterView adapterView, View view, int i6, long j6) {
        b0.f16879a.r(this.U, new Function1() { // from class: com.bxkj.student.life.lost.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 p02;
                p02 = PublishLostActivity.this.p0((File) obj);
                return p02;
            }
        });
    }

    private void r0() {
        String str;
        int i6;
        if (this.I0.getSelectedItemPosition() == -1 || this.I0.getSelectedItemPosition() == 0) {
            g0("请选择物品类型");
            return;
        }
        String string = JsonParse.getString(this.N0.getItem(this.I0.getSelectedItemPosition()), "id");
        String trim = this.W.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            g0("请简单描述一下哦");
            return;
        }
        String trim2 = this.X.getText().toString().trim();
        String trim3 = this.Y.getText().toString().trim();
        String trim4 = this.Z.getText().toString().trim();
        String trim5 = this.f19114a0.getText().toString().trim();
        if (TextUtils.isEmpty(trim3) && TextUtils.isEmpty(trim4) && TextUtils.isEmpty(trim5)) {
            g0("至少填写一种联系方式哦");
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<String> it = this.K0.iterator();
        while (it.hasNext()) {
            File file = new File(it.next());
            String b6 = cn.bluemobi.dylan.base.utils.b.b(s0(file.getPath()));
            arrayList2.add(b6);
            HashMap hashMap = new HashMap(2);
            hashMap.put("imageName", file.getName());
            hashMap.put("imageBase64", b6);
            arrayList.add(hashMap);
        }
        String jSONString = JSON.toJSONString(arrayList2);
        if (this.H0 != 0 || !this.f19116c0.isChecked()) {
            str = "0";
        } else {
            if (this.P0.size() == 0) {
                g0("至少添加一个问题和答案");
                return;
            }
            str = "1";
        }
        String str2 = str;
        if (this.G0.getCheckedRadioButtonId() != this.G0.getChildAt(0).getId()) {
            if (this.G0.getCheckedRadioButtonId() == this.G0.getChildAt(1).getId()) {
                i6 = 2;
            } else if (this.G0.getCheckedRadioButtonId() == this.G0.getChildAt(2).getId()) {
                i6 = 1;
            }
            Http.with(this.T).setObservable(((x.e) Http.getApiService(x.e.class)).i(LoginUser.getLoginUser().getOpenId(), string, this.H0, trim, jSONString, trim3, trim5, trim4, trim2, str2, i6, JSON.toJSONString(this.P0))).setDataListener(new e());
        }
        i6 = 3;
        Http.with(this.T).setObservable(((x.e) Http.getApiService(x.e.class)).i(LoginUser.getLoginUser().getOpenId(), string, this.H0, trim, jSONString, trim3, trim5, trim4, trim2, str2, i6, JSON.toJSONString(this.P0))).setDataListener(new e());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.f19115b0.setOnClickListener(this);
        this.f19118p0.setOnClickListener(this);
        this.J0.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bxkj.student.life.lost.b
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i6, long j6) {
                PublishLostActivity.this.q0(adapterView, view, i6, j6);
            }
        });
        this.f19116c0.setOnCheckedChangeListener(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("发布寻物启事");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_publish_lost;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("type")) {
            int intExtra = getIntent().getIntExtra("type", 1);
            this.H0 = intExtra;
            if (intExtra == 1) {
                setTitle("发布寻物启示");
                this.f19116c0.setVisibility(8);
            } else {
                setTitle("发布失物招领");
            }
        }
        List<String> list = this.K0;
        Context context = this.T;
        cn.bluemobi.dylan.base.adapter.c cVar = new cn.bluemobi.dylan.base.adapter.c(list, context, 4, u.a(10.0f, context));
        this.M0 = cVar;
        cVar.e(3);
        this.J0.setAdapter((ListAdapter) this.M0);
        a aVar = new a(this.T, com.bxkj.place.R.layout.item_for_school_district_list, this.O0);
        this.N0 = aVar;
        this.I0.setAdapter((SpinnerAdapter) aVar);
        o0();
        this.F0.setLayoutManager(new LinearLayoutManager(this.T));
        b bVar = new b(this.T, R.layout.item_for_question, this.P0);
        this.Q0 = bVar;
        this.F0.setAdapter(bVar);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.J0 = (MyGridView) findViewById(2131297030);
        this.I0 = (Spinner) findViewById(2131298550);
        this.W = (EditText) findViewById(R.id.et_desc);
        this.J0 = (MyGridView) findViewById(2131297030);
        this.X = (EditText) findViewById(R.id.et_price);
        this.Y = (EditText) findViewById(2131296941);
        this.Z = (EditText) findViewById(R.id.et_wechat);
        this.f19114a0 = (EditText) findViewById(R.id.et_qq);
        this.f19115b0 = (Button) findViewById(R.id.bt_publish);
        this.f19116c0 = (CheckBox) findViewById(R.id.cb_show_question);
        this.f19117k0 = (CardView) findViewById(R.id.cardView_question);
        this.f19118p0 = (LinearLayout) findViewById(R.id.ll_add);
        this.F0 = (RecyclerView) findViewById(R.id.rv_question_answer);
        this.G0 = (RadioGroup) findViewById(R.id.rg_count);
        this.f19117k0.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
        int id = v5.getId();
        if (id != 2131296629) {
            if (id != 2131298011) {
                return;
            }
            if (this.Q0.getItemCount() < 3) {
                startActivityForResult(new Intent(this.T, (Class<?>) AddQuestionActivity.class), 204);
                return;
            } else {
                g0("最多三个问题哦！");
                return;
            }
        }
        r0();
    }
}
