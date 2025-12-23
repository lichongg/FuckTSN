package cn.jiguang.common.app.helper;

import cn.jiguang.common.app.entity.Cgroup;
import cn.jiguang.common.app.entity.ControlGroup;
import cn.jiguang.common.app.entity.Stat;
import cn.jiguang.common.app.entity.Status;
import java.io.File;
import java.util.regex.Pattern;

/* loaded from: D:\Downloads\app\classes2.dex */
public class AndroidAppProcess extends AndroidProcess {

    /* renamed from: e, reason: collision with root package name */
    private static final boolean f2872e = new File("/dev/cpuctl/tasks").exists();

    /* renamed from: f, reason: collision with root package name */
    private static final Pattern f2873f = Pattern.compile("^([A-Za-z]{1}[A-Za-z0-9_]*[\\.|:])*[A-Za-z][A-Za-z0-9_]*$");

    /* renamed from: a, reason: collision with root package name */
    public final boolean f2874a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2875b;

    public static final class a extends Exception {
        public a(int i6) {
            super(String.format("The process %d does not belong to any application", Integer.valueOf(i6)));
        }
    }

    public String a() {
        return this.f2876c.split(":")[0];
    }

    public AndroidAppProcess(int i6) {
        super(i6);
        int a6;
        boolean z5;
        String str = this.f2876c;
        if (str != null && f2873f.matcher(str).matches() && new File("/data/data", a()).exists()) {
            if (f2872e) {
                Cgroup b6 = b();
                ControlGroup a7 = b6.a("cpuacct");
                ControlGroup a8 = b6.a("cpu");
                if (a8 != null && a7 != null && a7.f2817c.contains("pid_")) {
                    z5 = !a8.f2817c.contains("bg_non_interactive");
                    try {
                        a6 = Integer.parseInt(a7.f2817c.split("/")[1].replace("uid_", ""));
                    } catch (Throwable unused) {
                        a6 = g().a();
                    }
                } else {
                    throw new a(i6);
                }
            } else {
                Stat f6 = f();
                Status g6 = g();
                boolean z6 = f6.m() == 0;
                a6 = g6.a();
                z5 = z6;
            }
            this.f2874a = z5;
            this.f2875b = a6;
            return;
        }
        throw new a(i6);
    }
}
