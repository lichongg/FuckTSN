package com.bxkj.student.v2.ui;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.v2.base.BaseActivity;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.base.v2.common.utils.c0;
import com.bxkj.base.v2.data.ParcelableMap;
import com.bxkj.base.v2.data.b;
import com.bxkj.student.App;
import com.bxkj.student.R;
import com.bxkj.student.databinding.V2MainBinding;
import com.bxkj.student.v2.ui.dialog.NoticeDialog;
import com.bxkj.student.v2.ui.main.ClassifyFragment;
import com.bxkj.student.v2.ui.main.H5Fragment;
import com.bxkj.student.v2.ui.main.HomeFragment;
import com.bxkj.student.v2.ui.main.MyFragment;
import com.bxkj.student.v2.vm.MainViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.stub.StubApp;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.f0;
import kotlin.collections.i1;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nMainActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainActivity.kt\ncom/bxkj/student/v2/ui/MainActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,425:1\n1#2:426\n216#3,2:427\n1878#4,3:429\n360#4,7:432\n774#4:439\n865#4,2:440\n785#4:442\n796#4:443\n1878#4,2:444\n797#4,2:446\n1880#4:448\n799#4:449\n1878#4,3:450\n*S KotlinDebug\n*F\n+ 1 MainActivity.kt\ncom/bxkj/student/v2/ui/MainActivity\n*L\n102#1:427,2\n306#1:429,3\n397#1:432,7\n188#1:439\n188#1:440,2\n189#1:442\n189#1:443\n189#1:444,2\n189#1:446,2\n189#1:448\n189#1:449\n190#1:450,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class MainActivity extends BaseActivity<V2MainBinding, MainViewModel> {

    @Nullable
    private HomeFragment U;

    @Nullable
    private ClassifyFragment V;

    @Nullable
    private MyFragment W;

    @Nullable
    private Fragment Y;

    /* renamed from: a0, reason: collision with root package name */
    private int f21298a0;

    /* renamed from: c0, reason: collision with root package name */
    private int f21300c0;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f21301k0;

    /* renamed from: p0, reason: collision with root package name */
    private long f21302p0;

    @NotNull
    private Map<String, H5Fragment> X = new LinkedHashMap();

    @NotNull
    private List<Map<String, Object>> Z = new ArrayList();

    /* renamed from: b0, reason: collision with root package name */
    @NotNull
    private final MainActivity$refreshTokenBroadCastReceiver$1 f21299b0 = new BroadcastReceiver() { // from class: com.bxkj.student.v2.ui.MainActivity$refreshTokenBroadCastReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Map map;
            com.orhanobut.logger.j.d("接收到了刷新Token成功通知", new Object[0]);
            MainActivity.this.D().X();
            map = MainActivity.this.X;
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                ((H5Fragment) ((Map.Entry) it.next()).getValue()).f();
            }
        }
    };

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a implements Observer, b0 {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f21303a;

        a(Function1 function) {
            g0.p(function, "function");
            this.f21303a = function;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof b0)) {
                return g0.g(getFunctionDelegate(), ((b0) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.b0
        @NotNull
        public final kotlin.n<?> getFunctionDelegate() {
            return this.f21303a;
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21303a.invoke(obj);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }
    }

    static {
        StubApp.interface11(17259);
    }

    private final void S() {
        this.f21301k0 = true;
        final com.bxkj.base.v2.base.p pVar = new com.bxkj.base.v2.base.p(H());
        Dialog h6 = pVar.h();
        h6.setCancelable(false);
        h6.setCanceledOnTouchOutside(false);
        D().f0(new Function1() { // from class: com.bxkj.student.v2.ui.m
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 T;
                T = MainActivity.T(com.bxkj.base.v2.base.p.this, this, (Map) obj);
                return T;
            }
        });
    }

    @Override // com.bxkj.base.v2.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(@Nullable Bundle bundle);

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 R(MainActivity mainActivity, iOSTwoButtonDialog it) {
        g0.p(it, "it");
        com.bxkj.base.util.u.b(mainActivity.r());
        return n1.f44123a;
    }

    private final void Y(int i6) {
        this.f21300c0 = i6;
        String[] strArr = new String[this.Z.size()];
        int i7 = 0;
        for (Object obj : this.Z) {
            int i8 = i7 + 1;
            if (i7 < 0) {
                f0.b0();
            }
            Map<String, ? extends Object> map = (Map) obj;
            if (i6 == i7) {
                strArr[i7] = c0.f16887a.t(map, "iconS");
            } else {
                strArr[i7] = c0.f16887a.t(map, "icon");
            }
            i7 = i8;
        }
        com.bxkj.student.v2.common.utils.d.a(L().navView, strArr);
    }

    private final void Z(Intent intent) {
        if (intent != null) {
            Intent intent2 = intent.hasExtra("LoginSuccess") ? intent : null;
            if (intent2 != null) {
                if ((intent.getBooleanExtra("LoginSuccess", false) ? intent2 : null) != null) {
                    D().h0();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(MainActivity mainActivity, View view) {
        b.a aVar = com.bxkj.base.v2.data.b.f16998d;
        aVar.a().t0(0L);
        aVar.a().u0(0L);
        aVar.a().v0(0L);
        aVar.a().d();
        aVar.a().k0("1");
        mainActivity.H().startActivity(new Intent(mainActivity.H(), (Class<?>) LoginActivity.class));
        mainActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 d0(MainActivity mainActivity, Map map) {
        c0 c0Var = c0.f16887a;
        String t5 = c0Var.t(map, "updateStatus");
        if (g0.g(t5, "1")) {
            com.bxkj.base.v2.data.b.f16998d.a().z0(false);
            g0.m(map);
            Map<String, ? extends Object> J0 = i1.J0(map);
            J0.put("needUpdatePasswordStatus", t5);
            J0.put(CommonNetImpl.NAME, "修改密码");
            com.bxkj.student.v2.common.utils.i.f20904a.b(mainActivity.H(), J0);
        } else if (g0.g(c0Var.t(map, "openPhoneLogin"), "1")) {
            if (com.bxkj.base.v2.data.b.f16998d.a().P()) {
                return n1.f44123a;
            }
            com.bxkj.student.v2.common.utils.i iVar = com.bxkj.student.v2.common.utils.i.f20904a;
            FragmentActivity r5 = mainActivity.r();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(CommonNetImpl.NAME, "绑定手机号");
            linkedHashMap.put("linkUrl", c0Var.t(map, "changePhoneUrl"));
            n1 n1Var = n1.f44123a;
            iVar.b(r5, linkedHashMap);
        }
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 f0(MainActivity mainActivity, Map map) {
        com.orhanobut.logger.j.d("latestUnreadNotice=" + map, new Object[0]);
        NoticeDialog noticeDialog = new NoticeDialog();
        Bundle bundle = new Bundle();
        g0.m(map);
        bundle.putParcelable("data", new ParcelableMap(i1.J0(map)));
        noticeDialog.setArguments(bundle);
        FragmentManager supportFragmentManager = mainActivity.getSupportFragmentManager();
        g0.o(supportFragmentManager, "getSupportFragmentManager(...)");
        noticeDialog.i(supportFragmentManager, "TSNDialog", true);
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00b9, code lost:
    
        if (r8.equals("navKey5") == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00f4, code lost:
    
        if (r7.W != null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00f6, code lost:
    
        r7.W = new com.bxkj.student.v2.ui.main.MyFragment();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00fd, code lost:
    
        r8 = r7.W;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00ff, code lost:
    
        if (r8 == null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0101, code lost:
    
        r8.m();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0104, code lost:
    
        r8 = r7.Y;
        r0 = r7.W;
        kotlin.jvm.internal.g0.m(r0);
        r7.l0(r8, r0, "navKey5");
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00e6, code lost:
    
        if (r8.equals("navKey1") == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x016e, code lost:
    
        if (r7.U != null) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0170, code lost:
    
        r7.U = new com.bxkj.student.v2.ui.main.HomeFragment();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0177, code lost:
    
        r8 = r7.Y;
        r0 = r7.U;
        kotlin.jvm.internal.g0.m(r0);
        r7.l0(r8, r0, "navKey1");
        r7 = r7.U;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0183, code lost:
    
        if (r7 == null) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0185, code lost:
    
        r7.N();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ef, code lost:
    
        if (r8.equals("ts-navKey55") == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0115, code lost:
    
        if (r8.equals("ts-navKey11") == false) goto L50;
     */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0168  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean i0(final com.bxkj.student.v2.ui.MainActivity r7, android.view.MenuItem r8) {
        /*
            Method dump skipped, instructions count: 416
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.ui.MainActivity.i0(com.bxkj.student.v2.ui.MainActivity, android.view.MenuItem):boolean");
    }

    private final void l0(Fragment fragment, Fragment fragment2, String str) {
        if (this.Y != fragment2) {
            this.Y = fragment2;
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            g0.o(supportFragmentManager, "getSupportFragmentManager(...)");
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            g0.o(beginTransaction, "beginTransaction(...)");
            if (fragment != null) {
                beginTransaction.hide(fragment);
            }
            if (fragment2.isAdded()) {
                beginTransaction.show(fragment2);
            } else {
                beginTransaction.add(R.id.fl_content, fragment2, str);
            }
            beginTransaction.commit();
        }
    }

    public final int U() {
        return this.f21300c0;
    }

    public final void V() {
        Object obj;
        Iterator<T> it = this.Z.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (g0.g(c0.f16887a.t((Map) obj, "mkey"), "navKey2")) {
                break;
            }
        }
        Map<String, ? extends Object> map = (Map) obj;
        if (map != null) {
            c0 c0Var = c0.f16887a;
            if (!g0.g(c0Var.t(map, "isEnabled"), "1")) {
                ContextExtKt.t(this, "暂未开通此权限");
                return;
            }
            if (c0Var.d(map, "isLogin") && !com.bxkj.base.v2.data.b.f16998d.a().Y()) {
                startActivity(new Intent(r(), (Class<?>) LoginActivity.class));
                return;
            }
            Iterator<Map<String, Object>> it2 = this.Z.iterator();
            int i6 = 0;
            while (true) {
                if (!it2.hasNext()) {
                    i6 = -1;
                    break;
                }
                if (g0.g(c0.f16887a.t(it2.next(), "mkey"), "navKey2")) {
                    break;
                } else {
                    i6++;
                }
            }
            L().navView.setSelectedItemId(i6);
        }
    }

    public final void g0(int i6) {
        this.f21300c0 = i6;
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(@NotNull Bundle outState) {
        g0.p(outState, "outState");
        outState.putInt("selectedItemId", L().navView.getSelectedItemId());
        super.onSaveInstanceState(outState);
    }

    @Override // com.bxkj.base.v2.base.a
    public void t() {
        if (!c0.b.f1042a.c(H())) {
            iOSOneButtonDialog m6 = ContextExtKt.m(this, "系统内部错误，错误码【1001】");
            m6.setCancelable(false);
            m6.setClickAutoCancel(false);
            m6.setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.ui.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MainActivity.W(MainActivity.this, view);
                }
            });
        }
        b.a aVar = com.bxkj.base.v2.data.b.f16998d;
        if (aVar.a().r() == 1 && !aVar.a().p()) {
            final iOSOneButtonDialog m7 = ContextExtKt.m(this, aVar.a().s());
            m7.setCancelable(false);
            m7.setClickAutoCancel(false).setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.ui.v
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MainActivity.X(iOSOneButtonDialog.this, view);
                }
            });
        }
        Q();
        S();
        h0();
        D().S();
        D().X();
        Z(getIntent());
        registerReceiver(this.f21299b0, new IntentFilter(App.f17573d.a().getPackageName() + ".REFRESH_TOKEN_FINISH"), com.bxkj.student.v2.common.data.k.f20685b, null);
        com.bxkj.student.v2.common.utils.safe.e.f20940a.a(r());
    }

    private final void Q() {
        if (!com.bxkj.base.util.u.a(H())) {
            ContextExtKt.h(H(), null, "为了能够让你不错过重要的通知消息,强烈建议你开启允许推送通知功能", new Function1() { // from class: com.bxkj.student.v2.ui.r
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    n1 R;
                    R = MainActivity.R(MainActivity.this, (iOSTwoButtonDialog) obj);
                    return R;
                }
            }, null, "不了", "去开启", 9, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 T(com.bxkj.base.v2.base.p pVar, MainActivity mainActivity, Map map) {
        boolean z5;
        pVar.b();
        int i6 = JsonParse.getInt(map, "versions");
        String string = JsonParse.getString(map, "versionsName");
        String string2 = JsonParse.getString(map, "instruction");
        String string3 = JsonParse.getString(map, "filePath");
        if (i6 > c0.b.f1042a.m(mainActivity.H())) {
            new com.bxkj.student.common.versionupdate.a(mainActivity.H()).d(string, string3, string2);
        }
        if (i6 > 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        mainActivity.f21301k0 = z5;
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(MainActivity mainActivity, View view) {
        mainActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(iOSOneButtonDialog iosonebuttondialog, View view) {
        iosonebuttondialog.dismiss();
        com.bxkj.base.v2.data.b.f16998d.a().n0(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 a0(MainActivity mainActivity, Boolean bool) {
        mainActivity.L().navView.setSelectedItemId(0);
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 b0(final MainActivity mainActivity, Boolean bool) {
        if (bool.booleanValue()) {
            iOSOneButtonDialog m6 = ContextExtKt.m(mainActivity, "暂未开通该APP使用权限，请联系管理员");
            m6.setCancelable(false);
            m6.setCanceledOnTouchOutside(false);
            m6.setClickAutoCancel(false);
            m6.setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.ui.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MainActivity.c0(MainActivity.this, view);
                }
            });
        }
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 e0(MainActivity mainActivity, List list) {
        mainActivity.L().navView.getMenu().clear();
        g0.m(list);
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (g0.g(c0.f16887a.t((Map) obj, "isShow"), "1")) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        int i6 = 0;
        for (Object obj2 : arrayList) {
            int i7 = i6 + 1;
            if (i6 < 0) {
                f0.b0();
            }
            if (i6 < 5) {
                arrayList2.add(obj2);
            }
            i6 = i7;
        }
        List<Map<String, Object>> d6 = f0.d6(arrayList2);
        mainActivity.Z = d6;
        int i8 = 0;
        for (Object obj3 : d6) {
            int i9 = i8 + 1;
            if (i8 < 0) {
                f0.b0();
            }
            mainActivity.L().navView.getMenu().add(0, i8, i8, c0.f16887a.t((Map) obj3, CommonNetImpl.NAME));
            i8 = i9;
        }
        com.orhanobut.logger.j.d(" mViewModel.bottomNavigationMenu.observe", new Object[0]);
        mainActivity.L().navView.setSelectedItemId(mainActivity.f21298a0);
        return n1.f44123a;
    }

    private final void h0() {
        L().navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() { // from class: com.bxkj.student.v2.ui.s
            @Override // com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener
            public final boolean onNavigationItemSelected(MenuItem menuItem) {
                boolean i02;
                i02 = MainActivity.i0(MainActivity.this, menuItem);
                return i02;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(MainActivity mainActivity) {
        mainActivity.L().navView.setSelectedItemId(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(MainActivity mainActivity) {
        mainActivity.L().navView.setSelectedItemId(0);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    /* renamed from: onBackPressed */
    public void r1() {
        if (System.currentTimeMillis() - this.f21302p0 > 2000) {
            ContextExtKt.t(this, "再按一次退出程序");
            this.f21302p0 = System.currentTimeMillis();
        } else {
            finish();
        }
    }

    @Override // com.bxkj.base.v2.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.f21299b0);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(@Nullable Intent intent) {
        super.onNewIntent(intent);
        Z(intent);
        MyFragment myFragment = this.W;
        if (myFragment != null) {
            myFragment.h();
        }
        Iterator<Map.Entry<String, H5Fragment>> it = this.X.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().f();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (!this.f21301k0) {
            S();
        }
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
        D().Z().observe(r(), new a(new Function1() { // from class: com.bxkj.student.v2.ui.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 a02;
                a02 = MainActivity.a0(MainActivity.this, (Boolean) obj);
                return a02;
            }
        }));
        D().R().observe(r(), new a(new Function1() { // from class: com.bxkj.student.v2.ui.n
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 b02;
                b02 = MainActivity.b0(MainActivity.this, (Boolean) obj);
                return b02;
            }
        }));
        D().i0().observe(r(), new a(new Function1() { // from class: com.bxkj.student.v2.ui.o
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 d02;
                d02 = MainActivity.d0(MainActivity.this, (Map) obj);
                return d02;
            }
        }));
        D().O().observe(r(), new a(new Function1() { // from class: com.bxkj.student.v2.ui.p
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 e02;
                e02 = MainActivity.e0(MainActivity.this, (List) obj);
                return e02;
            }
        }));
        D().W().observe(this, new a(new Function1() { // from class: com.bxkj.student.v2.ui.q
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 f02;
                f02 = MainActivity.f0(MainActivity.this, (Map) obj);
                return f02;
            }
        }));
    }
}
