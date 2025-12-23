package cn.jiguang.ar;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import cn.jiguang.bb.f;
import cn.jiguang.bz.y;
import com.stub.StubApp;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a extends cn.jiguang.by.b {

    /* renamed from: e, reason: collision with root package name */
    private static long f1678e;

    /* renamed from: a, reason: collision with root package name */
    private Context f1679a;

    /* renamed from: b, reason: collision with root package name */
    private cn.jiguang.as.a f1680b;

    /* renamed from: c, reason: collision with root package name */
    private String f1681c;

    /* renamed from: d, reason: collision with root package name */
    private final HashMap<String, Boolean> f1682d = new HashMap<>();

    /* renamed from: cn.jiguang.ar.a$a, reason: collision with other inner class name */
    private static class C0027a extends cn.jiguang.by.b {

        /* renamed from: a, reason: collision with root package name */
        private Context f1683a;

        @Override // cn.jiguang.by.b
        public void a() {
            a.e(this.f1683a);
        }

        public C0027a(Context context) {
            this.f1683a = context;
            this.f2653h = "JWake#RequestConfigAction";
        }
    }

    private static class b implements ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        private Context f1684a;

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                f.c("JWake", "unbind wake ServiceConnection");
                StubApp.getOrigApplicationContext(this.f1684a.getApplicationContext()).unbindService(this);
            } catch (Throwable th) {
                f.i("JWake", "onServiceConnected throwable" + th.getMessage());
            }
        }

        public b(Context context) {
            this.f1684a = context;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    private static Intent a(String str, int i6) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Intent parseUri = Intent.parseUri(str, i6);
        Intent intent = new Intent(parseUri);
        parseUri.addCategory("android.intent.category.BROWSABLE");
        parseUri.setComponent(null);
        parseUri.setSelector(null);
        return intent;
    }

    public static Integer b() {
        return 1;
    }

    public static Object c(Context context) {
        boolean c6 = cn.jiguang.m.b.c(context);
        f.c("JWake", "isActionUserEnable :" + c6);
        return Boolean.valueOf(c6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static cn.jiguang.as.a e(Context context) {
        try {
            JSONObject a6 = cn.jiguang.au.b.a(context);
            if (a6 == null) {
                return null;
            }
            cn.jiguang.au.b.a(context, y.b(a6.toString()));
            return cn.jiguang.au.b.a(context, a6);
        } catch (Throwable th) {
            f.i("JWake", "[requestConfigNow] failed:" + th.getMessage());
            return null;
        }
    }

    public static Object a(Context context, Object obj) {
        if (!(obj instanceof List)) {
            return obj;
        }
        return cn.jiguang.au.c.a(cn.jiguang.au.b.b(context), (List<String>) obj);
    }

    public static void b(Context context) {
        a(context);
    }

    private boolean c() {
        boolean c6 = cn.jiguang.m.b.c(this.f1679a);
        f.c("JWake", "isActionUserEnable :" + c6);
        return c6;
    }

    private void d() {
        long j6 = this.f1680b.f1701l;
        f1678e = cn.jiguang.m.b.f(this.f1679a, "JWakeConfigHelper");
        long currentTimeMillis = System.currentTimeMillis();
        f.c("JWake", "[refeshWakeConfig] currentTimeMillis:" + currentTimeMillis + ",lastBusinessTime:" + f1678e + ",wakeConfigInterval:" + j6);
        if (currentTimeMillis - f1678e < j6) {
            f.c("JWake", "need not get wake config");
            return;
        }
        cn.jiguang.as.a e6 = e(this.f1679a);
        if (e6 != null) {
            this.f1680b = e6;
        }
        c.a(this.f1679a);
    }

    @TargetApi(15)
    private List<cn.jiguang.as.c> e() {
        HashMap<String, cn.jiguang.as.c> a6 = cn.jiguang.au.c.a(this.f1679a);
        return a(a6, cn.jiguang.au.c.a(this.f1679a, a6), false);
    }

    public a(Context context, String str) {
        this.f1679a = context;
        this.f1681c = str;
        this.f2653h = "JWake";
    }

    public static List<cn.jiguang.as.c> a(Context context, cn.jiguang.as.a aVar, List<cn.jiguang.as.c> list) {
        if (cn.jiguang.ba.c.e()) {
            f.c("JWake", "is only JOperate sdk cmd");
            return new ArrayList();
        }
        if (list == null) {
            return new ArrayList();
        }
        a aVar2 = new a(context, "start");
        aVar2.f1680b = aVar;
        HashMap<String, cn.jiguang.as.c> hashMap = new HashMap<>();
        for (int i6 = 0; i6 < list.size(); i6++) {
            cn.jiguang.as.c cVar = list.get(i6);
            if (cVar != null) {
                hashMap.put(cVar.f1718a, cVar);
            }
        }
        List<cn.jiguang.as.c> a6 = aVar2.a(hashMap, (HashMap<String, cn.jiguang.as.c>) null, true);
        f.c("JWake", "cmdPrepareWakeTargets:" + a6);
        if (a6 == null) {
            a6 = new ArrayList<>();
        }
        for (int i7 = 0; i7 < list.size(); i7++) {
            cn.jiguang.as.c cVar2 = list.get(i7);
            if (cVar2 != null) {
                int i8 = 0;
                while (true) {
                    if (i8 >= a6.size()) {
                        cVar2.f1724g = 4;
                        a6.add(cVar2);
                        break;
                    }
                    cn.jiguang.as.c cVar3 = a6.get(i8);
                    cVar3.f1724g = 4 | cVar3.f1724g;
                    if (cVar2.f1718a == cVar3.f1718a) {
                        break;
                    }
                    i8++;
                }
            }
        }
        return a6;
    }

    private static boolean b(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.startsWith("content://")) {
            str = "content://" + str;
        }
        Uri parse = Uri.parse(str);
        f.c("JWake", " provider: " + str + ", uri: " + parse);
        return StubApp.getOrigApplicationContext(context.getApplicationContext()).getContentResolver().insert(parse, new ContentValues()) != null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:298:0x0232, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:299:0x0233, code lost:
    
        r28 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:302:0x0236, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01f7, code lost:
    
        r0 = cn.jiguang.au.c.a((java.util.HashMap<java.lang.String, java.lang.String>) r27);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01fd, code lost:
    
        r0.putInt("type", 16);
        r31.addAccount(r15.type, "cn.jiguang.sdk.wake", null, r0, null, null, null);
        cn.jiguang.bb.f.c("JWake", "use ACCOUNT wake up ,start add account to:" + r15.type);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0229, code lost:
    
        cn.jiguang.m.b.e(r45, "JWake_account");
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x022e, code lost:
    
        r0 = true;
        r28 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:107:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x04f6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0552 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0399 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:293:0x02a2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:313:0x0170 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0198 A[Catch: all -> 0x0157, TRY_ENTER, TRY_LEAVE, TryCatch #27 {all -> 0x0157, blocks: (B:44:0x0142, B:46:0x0198), top: B:43:0x0142 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02b9 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<cn.jiguang.as.b> a(android.content.Context r45, java.util.List<cn.jiguang.as.c> r46) {
        /*
            Method dump skipped, instructions count: 1704
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.ar.a.a(android.content.Context, java.util.List):java.util.List");
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0255 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<cn.jiguang.as.c> a(java.util.HashMap<java.lang.String, cn.jiguang.as.c> r31, java.util.HashMap<java.lang.String, cn.jiguang.as.c> r32, boolean r33) {
        /*
            Method dump skipped, instructions count: 810
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.ar.a.a(java.util.HashMap, java.util.HashMap, boolean):java.util.List");
    }

    @Override // cn.jiguang.by.b
    public void a() {
        String str;
        List<cn.jiguang.as.c> e6;
        cn.jiguang.au.f a6;
        Context context;
        try {
            f.c("JWake", "wake with:" + this.f1681c);
            if (!cn.jiguang.d.b.a(this.f1679a)) {
                f.i("JWake", "can't w because not r yet");
                return;
            }
            this.f1680b = cn.jiguang.au.b.b(this.f1679a);
            d();
            f.c("JWake", "use config:" + this.f1680b);
            a(this.f1679a, this.f1680b);
            if (c()) {
                cn.jiguang.as.a aVar = this.f1680b;
                if (aVar.f1690a && aVar.f1692c) {
                    if (aVar.f1714y == 7) {
                        str = "all wakeup type is unsupported of app, not wakeup any package";
                    } else {
                        if (aVar.f1698i && this.f1681c.equals("start")) {
                            if (a(this.f1680b.f1715z)) {
                                e6 = e();
                                a6 = cn.jiguang.au.f.a();
                                context = this.f1679a;
                                a6.a(context, this.f1680b, e6);
                                return;
                            }
                            f.c("JWake", "wake is disabled by unsafe package");
                            return;
                        }
                        if (this.f1680b.f1697h) {
                            long f6 = cn.jiguang.m.b.f(this.f1679a, "JWake");
                            long j6 = this.f1680b.f1696g;
                            long currentTimeMillis = System.currentTimeMillis();
                            f.c("JWake", "[wakeUp]currentTimeMillis:" + currentTimeMillis + ",lastBusinessTime:" + f6 + ",wakeInterval:" + j6);
                            if (currentTimeMillis - f6 >= j6) {
                                if (!a(this.f1680b.f1715z)) {
                                    f.c("JWake", "wake is disabled by unsafe package");
                                    return;
                                }
                                e6 = e();
                                a6 = cn.jiguang.au.f.a();
                                context = this.f1679a;
                                a6.a(context, this.f1680b, e6);
                                return;
                            }
                            str = "need not wake up";
                        } else {
                            str = "time disabled";
                        }
                    }
                }
                str = "wake is disabled by server";
            } else {
                str = "wake is disabled by user";
            }
            f.c("JWake", str);
        } catch (Throwable th) {
            f.i("JWake", "wake failed:" + th.getMessage());
        }
    }

    public static void a(Context context) {
        try {
            if (cn.jiguang.ba.c.e()) {
                f.c("JWake", "is only JOperate sdk reConfig");
            } else {
                cn.jiguang.be.b.b(new C0027a(context));
            }
        } catch (Throwable th) {
            f.i("JWake", "[requestConfig failed] " + th.getMessage());
        }
    }

    private static void a(Context context, cn.jiguang.as.a aVar) {
        boolean z5 = false;
        boolean z6 = aVar.f1691b && aVar.f1693d;
        boolean c6 = cn.jiguang.m.b.c(context);
        if (z6 && c6) {
            z5 = true;
        }
        cn.jiguang.au.a.a(context, z5);
        c.a(context, aVar.f1701l);
    }

    public static void a(Context context, String str) {
        try {
            if (!cn.jiguang.ba.c.e()) {
                cn.jiguang.be.b.b(new a(context, str));
                return;
            }
            f.c("JWake", "[doAction ] " + str + " : is only JOperate sdk");
        } catch (Throwable th) {
            f.i("JWake", "[doAction failed] " + str + " :" + th.getMessage());
        }
    }

    private static boolean a(Context context, Bundle bundle, Intent intent) {
        String str;
        try {
            if (intent == null) {
                f.i("JWake", "Fail to start activity ,activityIntent is null !!");
                return false;
            }
            intent.addFlags(276824064);
            intent.putExtras(bundle);
            context.startActivity(intent);
            if (intent.getComponent() == null) {
                return true;
            }
            String className = intent.getComponent().getClassName();
            if (!"cn.jpush.android.service.DActivity".equals(className) && !"cn.jpush.android.service.BActivity".equals(className)) {
                str = "JWake_activity";
                cn.jiguang.m.b.e(context, str);
                return true;
            }
            str = "JWake_dactivity";
            cn.jiguang.m.b.e(context, str);
            return true;
        } catch (Throwable th) {
            f.c("JWake", "Fail to start activity caused by:" + th);
            return false;
        }
    }

    private boolean a(Intent intent, String str, boolean z5) {
        return cn.jiguang.au.a.a(this.f1679a, str, intent, z5);
    }

    private boolean a(String str) {
        StringBuilder sb;
        String str2;
        List<String> list = this.f1680b.f1705p;
        if (list != null && list.contains(str)) {
            sb = new StringBuilder();
            sb.append(str);
            str2 = " is in black list";
        } else {
            if (TextUtils.isEmpty(this.f1680b.f1703n)) {
                return false;
            }
            if (this.f1680b.f1703n.equals(SocialConstants.PARAM_EXCLUDE)) {
                if (!this.f1680b.f1704o.contains(str)) {
                    return false;
                }
                sb = new StringBuilder();
                sb.append(str);
                str2 = " is in excloude list";
            } else {
                if (!this.f1680b.f1703n.equals("include") || this.f1680b.f1704o.contains(str)) {
                    return false;
                }
                sb = new StringBuilder();
                sb.append(str);
                str2 = " is not in include list";
            }
        }
        sb.append(str2);
        f.c("JWake", sb.toString());
        return true;
    }

    private boolean a(List<String> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    for (String str : list) {
                        if (this.f1682d.containsKey(str)) {
                            Boolean bool = this.f1682d.get(str);
                            if (bool == null || !bool.booleanValue()) {
                                return true;
                            }
                            f.c("JWake", "checkSafeStatus blackPkgName = " + str);
                            return false;
                        }
                        boolean h6 = cn.jiguang.bz.a.h(this.f1679a, str);
                        this.f1682d.put(str, Boolean.valueOf(h6));
                        if (h6) {
                            f.c("JWake", "checkSafeStatus blackPkgName = " + str);
                            return false;
                        }
                    }
                }
            } catch (Throwable th) {
                f.i("JWake", "checkSafeStatus error:" + th);
            }
        }
        return true;
    }
}
