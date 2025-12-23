package com.bytedance.sdk.component.m.cw.j;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.File;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements com.bytedance.sdk.component.m.xt, Cloneable {
    private static volatile com.bytedance.sdk.component.m.xt ae;
    private int cw;

    /* renamed from: j, reason: collision with root package name */
    private long f26547j;

    /* renamed from: m, reason: collision with root package name */
    private File f26548m;

    /* renamed from: r, reason: collision with root package name */
    private boolean f26549r;
    private boolean up;
    private int xt;

    public j(int i6, long j6, File file) {
        this(i6, 0, j6, i6 != 0, j6 != 0, file);
    }

    @Override // com.bytedance.sdk.component.m.xt
    @ATSMethod(1)
    public long j() {
        return this.f26547j;
    }

    @Override // com.bytedance.sdk.component.m.xt
    @ATSMethod(6)
    public boolean m() {
        return true;
    }

    public j(int i6, int i7, long j6, boolean z5, boolean z6, File file) {
        this.f26547j = j6;
        this.xt = i6;
        this.cw = i7;
        this.f26549r = z5;
        this.up = z6;
        this.f26548m = file;
    }

    public static com.bytedance.sdk.component.m.xt g() {
        return ae;
    }

    public static void j(Context context, com.bytedance.sdk.component.m.xt xtVar) {
        if (xtVar != null) {
            ae = xtVar;
        } else {
            ae = j(new File(com.bytedance.sdk.openadsdk.api.plugin.xt.xt(context), SocializeProtocolConstants.IMAGE));
        }
    }

    @Override // com.bytedance.sdk.component.m.xt
    @ATSMethod(8)
    public boolean ae() {
        return this.cw > 0;
    }

    @Override // com.bytedance.sdk.component.m.xt
    @ATSMethod(3)
    public boolean cw() {
        return this.f26549r;
    }

    @Override // com.bytedance.sdk.component.m.xt
    @ATSMethod(4)
    public boolean r() {
        return this.up;
    }

    @Override // com.bytedance.sdk.component.m.xt
    @ATSMethod(7)
    public int tl() {
        return this.cw;
    }

    @Override // com.bytedance.sdk.component.m.xt
    @ATSMethod(5)
    public File up() {
        return this.f26548m;
    }

    @Override // com.bytedance.sdk.component.m.xt
    @ATSMethod(2)
    public int xt() {
        return this.xt;
    }

    private static long oq() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return statFs.getAvailableBlocks() * statFs.getBlockSize();
    }

    public static com.bytedance.sdk.component.m.xt j(File file) {
        int min;
        long min2;
        file.mkdirs();
        if (ae == null) {
            min = Math.min(Long.valueOf(Runtime.getRuntime().maxMemory()).intValue() / 16, 10485760);
            min2 = Math.min(oq() / 16, 31457280L);
        } else {
            min = Math.min(ae.xt() / 2, 10485760);
            min2 = Math.min(ae.j() / 2, 31457280L);
        }
        return new j(Math.max(min, 5242880), Math.max(min2, 10485760L), file);
    }
}
