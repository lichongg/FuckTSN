package com.amap.api.col.s;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class cf {

    /* renamed from: a, reason: collision with root package name */
    private static volatile b f7940a = b.Unknow;

    /* renamed from: b, reason: collision with root package name */
    private static volatile d f7941b = d.Unknow;

    /* renamed from: c, reason: collision with root package name */
    private static volatile String f7942c = "";

    /* renamed from: d, reason: collision with root package name */
    private static volatile String f7943d = "";

    /* renamed from: e, reason: collision with root package name */
    private static volatile long f7944e = -1;

    /* renamed from: f, reason: collision with root package name */
    private static volatile a f7945f = a.Unknow;

    /* renamed from: g, reason: collision with root package name */
    private static volatile long f7946g = -1;

    /* renamed from: h, reason: collision with root package name */
    private static volatile String f7947h = "";

    /* renamed from: i, reason: collision with root package name */
    private static volatile String f7948i = "";

    /* renamed from: j, reason: collision with root package name */
    private static volatile long f7949j = 0;

    /* renamed from: k, reason: collision with root package name */
    private static volatile long f7950k = 0;

    /* renamed from: l, reason: collision with root package name */
    private static volatile boolean f7951l = false;

    /* renamed from: m, reason: collision with root package name */
    private static volatile boolean f7952m = true;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum a {
        Unknow(-1),
        NotAgree(0),
        DidAgree(1);


        /* renamed from: d, reason: collision with root package name */
        private int f7957d;

        public final int a() {
            return this.f7957d;
        }

        public static a a(int i6) {
            a aVar = NotAgree;
            if (i6 == aVar.a()) {
                return aVar;
            }
            a aVar2 = DidAgree;
            return i6 == aVar2.a() ? aVar2 : Unknow;
        }

        a(int i6) {
            this.f7957d = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum b {
        Unknow(-1),
        NotContain(0),
        DidContain(1);


        /* renamed from: d, reason: collision with root package name */
        private int f7962d;

        public final int a() {
            return this.f7962d;
        }

        public static b a(int i6) {
            b bVar = NotContain;
            if (i6 == bVar.a()) {
                return bVar;
            }
            b bVar2 = DidContain;
            return i6 == bVar2.a() ? bVar2 : Unknow;
        }

        b(int i6) {
            this.f7962d = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum c {
        SuccessCode(0),
        ShowUnknowCode(555570),
        ShowNoShowCode(555571),
        InfoUnknowCode(555572),
        InfoNotContainCode(555573),
        AgreeUnknowCode(555574),
        AgreeNotAgreeCode(555575),
        InvaildUserKeyCode(10001),
        IllegalArgument(IjkMediaPlayer.FFP_PROP_INT64_SELECTED_VIDEO_STREAM);


        /* renamed from: j, reason: collision with root package name */
        private final int f7973j;

        public final int a() {
            return this.f7973j;
        }

        c(int i6) {
            this.f7973j = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum d {
        Unknow(-1),
        NotShow(0),
        DidShow(1);


        /* renamed from: d, reason: collision with root package name */
        private int f7978d;

        public final int a() {
            return this.f7978d;
        }

        public static d a(int i6) {
            d dVar = NotShow;
            if (i6 == dVar.a()) {
                return dVar;
            }
            d dVar2 = DidShow;
            return i6 == dVar2.a() ? dVar2 : Unknow;
        }

        d(int i6) {
            this.f7978d = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class e extends z3 {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f7979b;

        e(Context context) {
            this.f7979b = context;
        }

        @Override // com.amap.api.col.s.z3
        public final void a() {
            Iterator it = cf.m(cf.t(this.f7979b)).iterator();
            while (it.hasNext()) {
                cf.g(this.f7979b, ((File) it.next()).getName());
            }
            cf.n(this.f7979b);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class f extends z3 {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f7980b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f7981c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f7982d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ JSONObject f7983e;

        f(boolean z5, Context context, long j6, JSONObject jSONObject) {
            this.f7980b = z5;
            this.f7981c = context;
            this.f7982d = j6;
            this.f7983e = jSONObject;
        }

        @Override // com.amap.api.col.s.z3
        public final void a() {
            if (this.f7980b) {
                Iterator it = cf.m(cf.t(this.f7981c)).iterator();
                while (it.hasNext()) {
                    cf.g(this.f7981c, ((File) it.next()).getName());
                }
            }
            cf.r(this.f7981c);
            cf.h(this.f7981c, this.f7983e, this.f7982d);
            boolean p5 = cf.p(this.f7981c, this.f7983e);
            if (p5) {
                cf.o(this.f7981c, cf.l(this.f7982d));
            }
            if (this.f7980b) {
                cf.n(this.f7981c);
            }
            if (p5) {
                return;
            }
            cf.g(this.f7981c, cf.l(this.f7982d));
        }
    }

    static /* synthetic */ void h(Context context, JSONObject jSONObject, long j6) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                byte[] n6 = j2.n(context, jSONObject.toString().getBytes());
                String l6 = l(j6);
                File file = new File(t(context) + "/" + l6);
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(n6);
                    fileOutputStream2.close();
                } catch (Throwable th) {
                    fileOutputStream = fileOutputStream2;
                    th = th;
                    try {
                        th.printStackTrace();
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } catch (Throwable th2) {
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable th3) {
                                th3.printStackTrace();
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public static synchronized h1 a(Context context, i1 i1Var) {
        boolean z5;
        Context context2;
        synchronized (cf.class) {
            try {
                if (context == null || i1Var == null) {
                    return new h1(c.IllegalArgument, i1Var);
                }
                if (!f7951l) {
                    s(context);
                    f7951l = true;
                }
                h1 h1Var = null;
                if (f7941b != d.DidShow) {
                    if (f7941b == d.Unknow) {
                        h1Var = new h1(c.ShowUnknowCode, i1Var);
                    } else if (f7941b == d.NotShow) {
                        h1Var = new h1(c.ShowNoShowCode, i1Var);
                    }
                    z5 = false;
                } else {
                    z5 = true;
                }
                if (z5 && f7940a != b.DidContain) {
                    if (f7940a == b.Unknow) {
                        h1Var = new h1(c.InfoUnknowCode, i1Var);
                    } else if (f7940a == b.NotContain) {
                        h1Var = new h1(c.InfoNotContainCode, i1Var);
                    }
                    z5 = false;
                }
                if (z5 && f7945f != a.DidAgree) {
                    if (f7945f == a.Unknow) {
                        h1Var = new h1(c.AgreeUnknowCode, i1Var);
                    } else if (f7945f == a.NotAgree) {
                        h1Var = new h1(c.AgreeNotAgreeCode, i1Var);
                    }
                    z5 = false;
                }
                if (f7950k != f7949j) {
                    long j6 = f7949j;
                    f7950k = f7949j;
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("privacyInfo", f7940a.a());
                        jSONObject.put("privacyShow", f7941b.a());
                        jSONObject.put("showTime", f7944e);
                        jSONObject.put("show2SDK", f7942c);
                        jSONObject.put("show2SDKVer", f7943d);
                        jSONObject.put("privacyAgree", f7945f.a());
                        jSONObject.put("agreeTime", f7946g);
                        jSONObject.put("agree2SDK", f7947h);
                        jSONObject.put("agree2SDKVer", f7948i);
                        context2 = context;
                        y3.e().c(new f(f7952m, context2, j6, jSONObject));
                    } catch (Throwable unused) {
                        context2 = context;
                    }
                } else {
                    context2 = context;
                    if (f7952m) {
                        y3.e().c(new e(context2));
                    }
                }
                f7952m = false;
                String i6 = x0.i(context2);
                if (i6 == null || i6.length() <= 0) {
                    h1Var = new h1(c.InvaildUserKeyCode, i1Var);
                    i1Var.d();
                    String.format("获取apikey失败：\nerrorCode : %d\n原因：%s", Integer.valueOf(h1Var.f8108a.a()), h1Var.f8109b);
                }
                if (z5) {
                    h1Var = new h1(c.SuccessCode, i1Var);
                } else {
                    i1Var.d();
                    String.format("隐私合规校验失败：\nerrorCode : %d\n原因：%s", Integer.valueOf(h1Var.f8108a.a()), h1Var.f8109b);
                }
                return h1Var;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static synchronized void e(Context context, a aVar, i1 i1Var) {
        synchronized (cf.class) {
            if (context == null || i1Var == null) {
                return;
            }
            try {
                if (!f7951l) {
                    s(context);
                    f7951l = true;
                }
                if (aVar != f7945f) {
                    f7945f = aVar;
                    f7947h = i1Var.d();
                    f7948i = i1Var.e();
                    long currentTimeMillis = System.currentTimeMillis();
                    f7946g = currentTimeMillis;
                    f7949j = currentTimeMillis;
                    r(context);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static synchronized void f(Context context, d dVar, b bVar, i1 i1Var) {
        synchronized (cf.class) {
            if (context == null || i1Var == null) {
                return;
            }
            try {
                if (!f7951l) {
                    s(context);
                    f7951l = true;
                }
                Boolean bool = Boolean.FALSE;
                if (dVar != f7941b) {
                    bool = Boolean.TRUE;
                    f7941b = dVar;
                }
                if (bVar != f7940a) {
                    bool = Boolean.TRUE;
                    f7940a = bVar;
                }
                if (bool.booleanValue()) {
                    f7942c = i1Var.d();
                    f7943d = i1Var.e();
                    long currentTimeMillis = System.currentTimeMillis();
                    f7944e = currentTimeMillis;
                    f7949j = currentTimeMillis;
                    r(context);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static /* synthetic */ void g(Context context, String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        try {
            File file = new File(t(context) + "/" + str);
            if (file.exists()) {
                File file2 = new File(u(context) + "/" + str);
                if (!file2.getParentFile().exists()) {
                    file2.getParentFile().mkdirs();
                }
                file.renameTo(file2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void i(Context context, boolean z5, i1 i1Var) {
        e(context, z5 ? a.DidAgree : a.NotAgree, i1Var);
    }

    public static void j(Context context, boolean z5, boolean z6, i1 i1Var) {
        f(context, z6 ? d.DidShow : d.NotShow, z5 ? b.DidContain : b.NotContain, i1Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ArrayList<File> m(String str) {
        ArrayList<File> arrayList = new ArrayList<>();
        if (str != null && str.length() != 0) {
            File file = new File(str);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        arrayList.add(file2);
                    }
                }
            }
        }
        return arrayList;
    }

    static /* synthetic */ void o(Context context, String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        try {
            File file = new File(t(context) + "/" + str);
            if (file.exists()) {
                file.delete();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean p(Context context, JSONObject jSONObject) {
        try {
            i2 i2Var = new i2();
            i2Var.f8167n = context;
            i2Var.f8166m = jSONObject;
            new u2();
            b3 d6 = u2.d(i2Var);
            if (d6 != null) {
                JSONObject jSONObject2 = new JSONObject(j1.g(d6.f7876a));
                if (jSONObject2.has(NotificationCompat.CATEGORY_STATUS)) {
                    if (jSONObject2.getInt(NotificationCompat.CATEGORY_STATUS) == 1) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void r(Context context) {
        synchronized (cf.class) {
            if (context == null) {
                return;
            }
            if (!f7951l) {
                s(context);
                f7951l = true;
            }
            try {
                j2.e(context, "AMap.privacy.data", "AMap.privacy.data", String.format("%d&%d&%d&%s&%s&%d&%d&%s&%s&%d&%d", Integer.valueOf(f7940a.a()), Integer.valueOf(f7941b.a()), Long.valueOf(f7944e), f7942c, f7943d, Integer.valueOf(f7945f.a()), Long.valueOf(f7946g), f7947h, f7948i, Long.valueOf(f7949j), Long.valueOf(f7950k)));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private static void s(Context context) {
        String str;
        if (context == null) {
            return;
        }
        try {
            str = j2.d(context, "AMap.privacy.data", "AMap.privacy.data");
        } catch (Throwable th) {
            th.printStackTrace();
            str = null;
        }
        if (str == null) {
            return;
        }
        String[] split = str.split(ContainerUtils.FIELD_DELIMITER);
        if (split.length != 11) {
            return;
        }
        try {
            f7940a = b.a(Integer.parseInt(split[0]));
            f7941b = d.a(Integer.parseInt(split[1]));
            f7944e = Long.parseLong(split[2]);
            f7943d = split[3];
            f7943d = split[4];
            f7945f = a.a(Integer.parseInt(split[5]));
            f7946g = Long.parseLong(split[6]);
            f7947h = split[7];
            f7948i = split[8];
            f7949j = Long.parseLong(split[9]);
            f7950k = Long.parseLong(split[10]);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String l(long j6) {
        return String.format("%d-%s", Long.valueOf(j6), "privacy.data");
    }

    static /* synthetic */ void n(Context context) {
        try {
            Iterator<File> it = m(u(context)).iterator();
            while (it.hasNext()) {
                File next = it.next();
                try {
                    String name = next.getName();
                    if (!name.endsWith("-privacy.data")) {
                        next.delete();
                    } else {
                        String[] split = name.split("-");
                        if (split == null && split.length != 2) {
                            next.delete();
                        } else if (Long.parseLong(split[0]) <= 0) {
                            next.delete();
                        } else {
                            FileInputStream fileInputStream = new FileInputStream(next);
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            if (p(context, new JSONObject(new String(j2.q(context, bArr))))) {
                                next.delete();
                            }
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String t(Context context) {
        return context.getFilesDir().getAbsolutePath() + "/AMap/Privacy/Upload";
    }

    private static String u(Context context) {
        return context.getFilesDir().getAbsolutePath() + "/AMap/Privacy/Reload";
    }
}
