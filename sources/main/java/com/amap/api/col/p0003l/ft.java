package com.amap.api.col.p0003l;

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
public final class ft {

    /* renamed from: a, reason: collision with root package name */
    private static volatile b f6226a = b.Unknow;

    /* renamed from: b, reason: collision with root package name */
    private static volatile d f6227b = d.Unknow;

    /* renamed from: c, reason: collision with root package name */
    private static volatile String f6228c = "";

    /* renamed from: d, reason: collision with root package name */
    private static volatile String f6229d = "";

    /* renamed from: e, reason: collision with root package name */
    private static volatile long f6230e = -1;

    /* renamed from: f, reason: collision with root package name */
    private static volatile a f6231f = a.Unknow;

    /* renamed from: g, reason: collision with root package name */
    private static volatile long f6232g = -1;

    /* renamed from: h, reason: collision with root package name */
    private static volatile String f6233h = "";

    /* renamed from: i, reason: collision with root package name */
    private static volatile String f6234i = "";

    /* renamed from: j, reason: collision with root package name */
    private static volatile long f6235j = 0;

    /* renamed from: k, reason: collision with root package name */
    private static volatile long f6236k = 0;

    /* renamed from: l, reason: collision with root package name */
    private static volatile boolean f6237l = false;

    /* renamed from: m, reason: collision with root package name */
    private static volatile boolean f6238m = true;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum a {
        Unknow(-1),
        NotAgree(0),
        DidAgree(1);


        /* renamed from: d, reason: collision with root package name */
        private int f6243d;

        public final int a() {
            return this.f6243d;
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
            this.f6243d = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum b {
        Unknow(-1),
        NotContain(0),
        DidContain(1);


        /* renamed from: d, reason: collision with root package name */
        private int f6248d;

        public final int a() {
            return this.f6248d;
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
            this.f6248d = i6;
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
        private final int f6259j;

        public final int a() {
            return this.f6259j;
        }

        c(int i6) {
            this.f6259j = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum d {
        Unknow(-1),
        NotShow(0),
        DidShow(1);


        /* renamed from: d, reason: collision with root package name */
        private int f6264d;

        public final int a() {
            return this.f6264d;
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
            this.f6264d = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class e extends b8 {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f6265d;

        e(Context context) {
            this.f6265d = context;
        }

        @Override // com.amap.api.col.p0003l.b8
        public final void runTask() {
            Iterator it = ft.m(ft.t(this.f6265d)).iterator();
            while (it.hasNext()) {
                ft.g(this.f6265d, ((File) it.next()).getName());
            }
            ft.n(this.f6265d);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class f extends b8 {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f6266d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f6267e;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f6268g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ JSONObject f6269h;

        f(boolean z5, Context context, long j6, JSONObject jSONObject) {
            this.f6266d = z5;
            this.f6267e = context;
            this.f6268g = j6;
            this.f6269h = jSONObject;
        }

        @Override // com.amap.api.col.p0003l.b8
        public final void runTask() {
            if (this.f6266d) {
                Iterator it = ft.m(ft.t(this.f6267e)).iterator();
                while (it.hasNext()) {
                    ft.g(this.f6267e, ((File) it.next()).getName());
                }
            }
            ft.r(this.f6267e);
            ft.h(this.f6267e, this.f6269h, this.f6268g);
            boolean p5 = ft.p(this.f6267e, this.f6269h);
            if (p5) {
                ft.o(this.f6267e, ft.l(this.f6268g));
            }
            if (this.f6266d) {
                ft.n(this.f6267e);
            }
            if (p5) {
                return;
            }
            ft.g(this.f6267e, ft.l(this.f6268g));
        }
    }

    static /* synthetic */ void h(Context context, JSONObject jSONObject, long j6) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                byte[] n6 = g6.n(context, jSONObject.toString().getBytes());
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

    public static synchronized n4 a(Context context, p4 p4Var) {
        boolean z5;
        Context context2;
        synchronized (ft.class) {
            try {
                if (context == null || p4Var == null) {
                    return new n4(c.IllegalArgument, p4Var);
                }
                if (!f6237l) {
                    s(context);
                    f6237l = true;
                }
                n4 n4Var = null;
                if (f6227b != d.DidShow) {
                    if (f6227b == d.Unknow) {
                        n4Var = new n4(c.ShowUnknowCode, p4Var);
                    } else if (f6227b == d.NotShow) {
                        n4Var = new n4(c.ShowNoShowCode, p4Var);
                    }
                    z5 = false;
                } else {
                    z5 = true;
                }
                if (z5 && f6226a != b.DidContain) {
                    if (f6226a == b.Unknow) {
                        n4Var = new n4(c.InfoUnknowCode, p4Var);
                    } else if (f6226a == b.NotContain) {
                        n4Var = new n4(c.InfoNotContainCode, p4Var);
                    }
                    z5 = false;
                }
                if (z5 && f6231f != a.DidAgree) {
                    if (f6231f == a.Unknow) {
                        n4Var = new n4(c.AgreeUnknowCode, p4Var);
                    } else if (f6231f == a.NotAgree) {
                        n4Var = new n4(c.AgreeNotAgreeCode, p4Var);
                    }
                    z5 = false;
                }
                if (f6236k != f6235j) {
                    long j6 = f6235j;
                    f6236k = f6235j;
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("privacyInfo", f6226a.a());
                        jSONObject.put("privacyShow", f6227b.a());
                        jSONObject.put("showTime", f6230e);
                        jSONObject.put("show2SDK", f6228c);
                        jSONObject.put("show2SDKVer", f6229d);
                        jSONObject.put("privacyAgree", f6231f.a());
                        jSONObject.put("agreeTime", f6232g);
                        jSONObject.put("agree2SDK", f6233h);
                        jSONObject.put("agree2SDKVer", f6234i);
                        context2 = context;
                        a8.h().b(new f(f6238m, context2, j6, jSONObject));
                    } catch (Throwable unused) {
                        context2 = context;
                    }
                } else {
                    context2 = context;
                    if (f6238m) {
                        a8.h().b(new e(context2));
                    }
                }
                f6238m = false;
                String j7 = f4.j(context2);
                if (j7 == null || j7.length() <= 0) {
                    n4Var = new n4(c.InvaildUserKeyCode, p4Var);
                    p4Var.a();
                    String.format("获取apikey失败：\nerrorCode : %d\n原因：%s", Integer.valueOf(n4Var.f6803a.a()), n4Var.f6804b);
                }
                if (z5) {
                    n4Var = new n4(c.SuccessCode, p4Var);
                } else {
                    p4Var.a();
                    String.format("隐私合规校验失败：\nerrorCode : %d\n原因：%s", Integer.valueOf(n4Var.f6803a.a()), n4Var.f6804b);
                }
                return n4Var;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static synchronized void e(Context context, a aVar, p4 p4Var) {
        synchronized (ft.class) {
            if (context == null || p4Var == null) {
                return;
            }
            try {
                if (!f6237l) {
                    s(context);
                    f6237l = true;
                }
                if (aVar != f6231f) {
                    f6231f = aVar;
                    f6233h = p4Var.a();
                    f6234i = p4Var.e();
                    long currentTimeMillis = System.currentTimeMillis();
                    f6232g = currentTimeMillis;
                    f6235j = currentTimeMillis;
                    r(context);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static synchronized void f(Context context, d dVar, b bVar, p4 p4Var) {
        synchronized (ft.class) {
            if (context == null || p4Var == null) {
                return;
            }
            try {
                if (!f6237l) {
                    s(context);
                    f6237l = true;
                }
                Boolean bool = Boolean.FALSE;
                if (dVar != f6227b) {
                    bool = Boolean.TRUE;
                    f6227b = dVar;
                }
                if (bVar != f6226a) {
                    bool = Boolean.TRUE;
                    f6226a = bVar;
                }
                if (bool.booleanValue()) {
                    f6228c = p4Var.a();
                    f6229d = p4Var.e();
                    long currentTimeMillis = System.currentTimeMillis();
                    f6230e = currentTimeMillis;
                    f6235j = currentTimeMillis;
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

    public static void i(Context context, boolean z5, p4 p4Var) {
        e(context, z5 ? a.DidAgree : a.NotAgree, p4Var);
    }

    public static void j(Context context, boolean z5, boolean z6, p4 p4Var) {
        f(context, z6 ? d.DidShow : d.NotShow, z5 ? b.DidContain : b.NotContain, p4Var);
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
            c6 c6Var = new c6();
            c6Var.f5848s = context;
            c6Var.f5847r = jSONObject;
            new r6();
            z6 d6 = r6.d(c6Var);
            if (d6 != null) {
                JSONObject jSONObject2 = new JSONObject(q4.g(d6.f7800a));
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
        synchronized (ft.class) {
            if (context == null) {
                return;
            }
            if (!f6237l) {
                s(context);
                f6237l = true;
            }
            try {
                g6.e(context, "AMap.privacy.data", "AMap.privacy.data", String.format("%d&%d&%d&%s&%s&%d&%d&%s&%s&%d&%d", Integer.valueOf(f6226a.a()), Integer.valueOf(f6227b.a()), Long.valueOf(f6230e), f6228c, f6229d, Integer.valueOf(f6231f.a()), Long.valueOf(f6232g), f6233h, f6234i, Long.valueOf(f6235j), Long.valueOf(f6236k)));
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
            str = g6.d(context, "AMap.privacy.data", "AMap.privacy.data");
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
            f6226a = b.a(Integer.parseInt(split[0]));
            f6227b = d.a(Integer.parseInt(split[1]));
            f6230e = Long.parseLong(split[2]);
            f6229d = split[3];
            f6229d = split[4];
            f6231f = a.a(Integer.parseInt(split[5]));
            f6232g = Long.parseLong(split[6]);
            f6233h = split[7];
            f6234i = split[8];
            f6235j = Long.parseLong(split[9]);
            f6236k = Long.parseLong(split[10]);
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
                            if (p(context, new JSONObject(new String(g6.q(context, bArr))))) {
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
