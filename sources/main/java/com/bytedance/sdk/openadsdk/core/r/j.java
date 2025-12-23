package com.bytedance.sdk.openadsdk.core.r;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.oq;
import com.bytedance.sdk.openadsdk.core.v;
import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private static AtomicBoolean f30015j;

    public static boolean j() {
        boolean z5;
        try {
            AtomicBoolean atomicBoolean = f30015j;
            if (atomicBoolean != null) {
                return atomicBoolean.get();
            }
            File file = new File(com.bytedance.sdk.openadsdk.api.plugin.xt.j(v.getContext()).getParent(), "/pangle_p/com.byted.pangle");
            file.getAbsolutePath();
            if (file.exists()) {
                final StringBuilder sb = new StringBuilder("^version-(\\d+)$");
                file.listFiles();
                File[] listFiles = file.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.core.r.j.1
                    @Override // java.io.FileFilter
                    public boolean accept(File file2) {
                        if (file2 == null) {
                            return false;
                        }
                        try {
                            int i6 = h.xt;
                            Matcher matcher = Pattern.compile(sb.toString()).matcher(file2.getName());
                            String group = matcher.find() ? matcher.group() : "";
                            return (TextUtils.isEmpty(group) ? 0 : Integer.parseInt(group.substring(8))) > i6;
                        } catch (Exception e6) {
                            vl.j(e6);
                            return file2.getName().matches(sb.toString());
                        }
                    }
                });
                if (listFiles != null && listFiles.length != 0) {
                    z5 = true;
                    j(z5);
                    return z5;
                }
            }
            z5 = false;
            j(z5);
            return z5;
        } catch (Throwable th) {
            vl.j(th);
            return false;
        }
    }

    public static boolean cw() {
        boolean z5 = h.f29116j;
        return false;
    }

    public static int r() {
        return h.f29116j ? 1 : 0;
    }

    public static boolean up() {
        return h.f29116j;
    }

    public static boolean ae() {
        return com.bytedance.sdk.openadsdk.core.cw.cw.j().g();
    }

    public static boolean m() {
        if (up() && oq.i().la()) {
            return true;
        }
        return false;
    }

    public static boolean tl() {
        if (!oq.i().vl() && oq.i().ae()) {
            return true;
        }
        return false;
    }

    public static boolean xt() {
        if (up() && !com.bytedance.sdk.openadsdk.core.cw.cw.j().tl() && j()) {
            return true;
        }
        return false;
    }

    public static void j(boolean z5) {
        if (f30015j == null) {
            f30015j = new AtomicBoolean();
        }
        f30015j.set(z5);
        oq.i().av();
    }
}
