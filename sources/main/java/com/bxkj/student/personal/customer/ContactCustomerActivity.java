package com.bxkj.student.personal.customer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.MultiItemCommonAdapter;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.photoview.ImagePagerActivity;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.v2.common.utils.b0;
import com.bxkj.student.R;
import com.kuaishou.weapon.p0.t;
import com.orhanobut.logger.j;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.n1;
import m2.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class ContactCustomerActivity extends BaseActivity {
    private EditText W;
    private Button X;
    private ImageView Y;
    private MultiItemCommonAdapter<Map<String, Object>> Z;

    /* renamed from: a0, reason: collision with root package name */
    private LinearLayoutManager f19602a0;

    /* renamed from: b0, reason: collision with root package name */
    private RecyclerView f19603b0;

    /* renamed from: c0, reason: collision with root package name */
    private SmartRefreshLayout f19604c0;

    /* renamed from: k0, reason: collision with root package name */
    private List<Map<String, Object>> f19605k0 = new ArrayList();

    /* renamed from: p0, reason: collision with root package name */
    protected int f19606p0 = 10;
    protected int F0 = 1;
    protected int G0 = 1;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s5) {
            if (ContactCustomerActivity.this.W.getText().toString().trim().isEmpty()) {
                ContactCustomerActivity.this.Y.setVisibility(0);
                ContactCustomerActivity.this.X.setVisibility(8);
            } else {
                ContactCustomerActivity.this.Y.setVisibility(8);
                ContactCustomerActivity.this.X.setVisibility(0);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s5, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s5, int start, int before, int count) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements cn.bluemobi.dylan.base.adapter.common.recyclerview.a<Map<String, Object>> {
        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.a
        public int b(int itemType) {
            return itemType == 1 ? R.layout.item_for_say : R.layout.item_for_reply;
        }

        b() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int a(int i6, Map<String, Object> map) {
            return LoginUser.getLoginUser().getUserId().equals(JsonParse.getString(map, "userId")) ? 1 : 0;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends MultiItemCommonAdapter<Map<String, Object>> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Map f19610a;

            a(final Map val$stringObjectMap) {
                this.f19610a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v5) {
                ContactCustomerActivity.this.x0(JsonParse.getString(this.f19610a, "content"));
            }
        }

        c(Context context, List datas, cn.bluemobi.dylan.base.adapter.common.recyclerview.a multiItemTypeSupport) {
            super(context, datas, multiItemTypeSupport);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void c(ViewHolder holder, final Map<String, Object> stringObjectMap) {
            if (JsonParse.getString(stringObjectMap, "isImg").equals("1")) {
                holder.N(2131298048, true);
                holder.N(R.id.tv_reply, false);
                try {
                    holder.s(R.id.iv, JsonParse.getString(stringObjectMap, "content"));
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            } else {
                holder.N(2131298048, false);
                holder.N(R.id.tv_reply, true);
                holder.J(R.id.tv_reply, JsonParse.getString(stringObjectMap, "content"));
            }
            if (LoginUser.getLoginUser().getUserId().equals(JsonParse.getString(stringObjectMap, "userId"))) {
                holder.J(2131299176, LoginUser.getLoginUser().getRealName());
            } else {
                holder.J(2131299176, "系统");
            }
            holder.J(2131298860, JsonParse.getString(stringObjectMap, "replyTime"));
            holder.w(R.id.iv, new a(stringObjectMap));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d extends HttpCallBack {
        d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ContactCustomerActivity.this.W.setText("");
            ContactCustomerActivity.this.f19604c0.T();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e implements n2.e {
        e() {
        }

        @Override // n2.d
        public void a(h refreshlayout) {
            ContactCustomerActivity contactCustomerActivity = ContactCustomerActivity.this;
            int i6 = contactCustomerActivity.G0;
            int i7 = contactCustomerActivity.f19606p0;
            int i8 = i6 / i7;
            int i9 = contactCustomerActivity.F0;
            if (i6 % i7 != 0) {
                i8++;
            }
            if (i9 >= i8) {
                contactCustomerActivity.f19604c0.Y();
                Toast.makeText(((BaseActivity) ContactCustomerActivity.this).T, "已全部加载完毕", 0).show();
            } else {
                contactCustomerActivity.F0 = i9 + 1;
                contactCustomerActivity.t0();
            }
        }

        @Override // n2.b
        public void f(h refreshlayout) {
            ContactCustomerActivity.this.y0();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class f extends HttpCallBack {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ContactCustomerActivity.this.f19603b0.smoothScrollToPosition(ContactCustomerActivity.this.Z.getItemCount() - 1);
            }
        }

        f() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ContactCustomerActivity.this.G0 = Integer.parseInt(u.O(data, "total"));
            List<Map<String, Object>> list = JsonParse.getList(data, "data");
            ContactCustomerActivity contactCustomerActivity = ContactCustomerActivity.this;
            if (contactCustomerActivity.F0 != 1) {
                contactCustomerActivity.f19605k0.addAll(0, list);
                ContactCustomerActivity.this.Z.notifyItemRangeInserted(-list.size(), list.size());
                ContactCustomerActivity.this.f19603b0.getChildAt(ContactCustomerActivity.this.f19602a0.findFirstVisibleItemPosition());
                LinearLayoutManager linearLayoutManager = ContactCustomerActivity.this.f19602a0;
                int itemCount = ContactCustomerActivity.this.Z.getItemCount();
                ContactCustomerActivity contactCustomerActivity2 = ContactCustomerActivity.this;
                linearLayoutManager.scrollToPositionWithOffset(itemCount - (contactCustomerActivity2.f19606p0 * (contactCustomerActivity2.F0 - 1)), -u.a(50.0f, ((BaseActivity) contactCustomerActivity2).T));
                return;
            }
            contactCustomerActivity.f19605k0.clear();
            ContactCustomerActivity.this.f19605k0.addAll(list);
            if (ContactCustomerActivity.this.f19605k0.isEmpty()) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
                HashMap hashMap = new HashMap(2);
                hashMap.put("replyTime", simpleDateFormat.format(new Date()));
                hashMap.put("content", "为了服务质量，我们将采取实名制，请认真反馈");
                ContactCustomerActivity.this.f19605k0.add(hashMap);
                HashMap hashMap2 = new HashMap(2);
                hashMap2.put("replyTime", simpleDateFormat.format(new Date()));
                hashMap2.put("content", "请输入您的宝贵意见或建议,我们将努力改进");
                ContactCustomerActivity.this.f19605k0.add(hashMap2);
                HashMap hashMap3 = new HashMap(2);
                hashMap3.put("replyTime", simpleDateFormat.format(new Date()));
                hashMap3.put("content", "请留下您的联系方式，以便我们回复您");
                ContactCustomerActivity.this.f19605k0.add(hashMap3);
            }
            ContactCustomerActivity.this.Z.notifyDataSetChanged();
            if (ContactCustomerActivity.this.Z.getItemCount() > 0) {
                ContactCustomerActivity.this.f19603b0.post(new a());
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            ContactCustomerActivity.this.f19604c0.B(0);
            ContactCustomerActivity.this.f19604c0.Q();
        }
    }

    public static byte[] A0(String filename) {
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

    public void y0() {
        this.F0 = 1;
        t0();
    }

    private String u0() {
        try {
            return this.T.getPackageManager().getPackageInfo(this.T.getPackageName(), 0).versionName;
        } catch (Exception e6) {
            e6.printStackTrace();
            return "0.1";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(String showUrl) {
        if (this.f19605k0 == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < this.f19605k0.size(); i6++) {
            if (JsonParse.getString(this.f19605k0.get(i6), "isImg").equals("1")) {
                arrayList.add(JsonParse.getString(this.f19605k0.get(i6), "content"));
            }
        }
        Intent intent = new Intent(this.T, (Class<?>) ImagePagerActivity.class);
        intent.putExtra(ImagePagerActivity.T, (String[]) arrayList.toArray(new String[arrayList.size()]));
        intent.putExtra(ImagePagerActivity.S, arrayList.indexOf(showUrl));
        startActivity(intent);
        overridePendingTransition(2130772094, 2130772095);
    }

    private void z0(File file) {
        String trim;
        if (file == null || !file.exists()) {
            trim = this.W.getText().toString().trim();
            if (trim.isEmpty()) {
                g0("内容不能为空");
                return;
            }
        } else {
            trim = cn.bluemobi.dylan.base.utils.b.b(A0(file.getPath()));
        }
        String str = trim;
        String userId = LoginUser.getLoginUser().getUserId();
        if (!LoginUser.getLoginUser().isLogin()) {
            userId = LoginUser.getLoginUser().getTempUserId();
        }
        Http.with(this.T).setObservable(((x.f) Http.getApiService(x.f.class)).x(LoginUser.getLoginUser().getSchoolId(), userId, u0(), "Android", str, file == null ? null : file.getName(), LoginUser.getLoginUser().getTempUserName(), LoginUser.getLoginUser().getTempUserNumber(), LoginUser.getLoginUser().getTempUserPhone())).setDataListener(new d());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.X.setOnClickListener(this);
        this.Y.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        this.W.addTextChangedListener(new a());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.T);
        this.f19602a0 = linearLayoutManager;
        this.f19603b0.setLayoutManager(linearLayoutManager);
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, 2130772096));
        layoutAnimationController.setOrder(1);
        this.f19603b0.setLayoutAnimation(layoutAnimationController);
        c cVar = new c(this.T, this.f19605k0, new b());
        this.Z = cVar;
        this.f19603b0.setAdapter(cVar);
        v0();
        this.f19604c0.T();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("联系客服");
    }

    public void v0() {
        this.f19604c0.E(2.0f);
        this.f19604c0.c0(u.a(50.0f, this.T));
        this.f19604c0.D(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ n1 w0(File file) {
        z0(file);
        return null;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_feedback_repay;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.f19603b0 = (RecyclerView) findViewById(2131298351);
        this.f19604c0 = (SmartRefreshLayout) findViewById(2131298352);
        this.W = (EditText) findViewById(2131296948);
        this.X = (Button) findViewById(2131296623);
        this.Y = (ImageView) findViewById(2131296581);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
        int id = v5.getId();
        if (id != 2131296581) {
            if (id != 2131296623) {
                return;
            }
            z0(null);
            return;
        }
        b0.f16879a.r(this.U, new Function1() { // from class: com.bxkj.student.personal.customer.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 w02;
                w02 = ContactCustomerActivity.this.w0((File) obj);
                return w02;
            }
        });
    }

    public void t0() {
        String userId = LoginUser.getLoginUser().getUserId();
        if (!LoginUser.getLoginUser().isLogin()) {
            userId = LoginUser.getLoginUser().getTempUserId();
        }
        Http.with(this.T).hideLoadingDialog().setObservable(((x.f) Http.getApiService(x.f.class)).p(LoginUser.getLoginUser().getSchoolId(), userId, this.F0, this.f19606p0)).setDataListener(new f());
    }
}
