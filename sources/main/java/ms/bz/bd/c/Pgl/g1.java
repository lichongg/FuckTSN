package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.util.Log;
import com.bytedance.sdk.openadsdk.api.plugin.xt;
import java.io.File;
import java.util.HashSet;
import java.util.Locale;
import ms.bz.bd.c.Pgl.e1;

/* loaded from: D:\Downloads\app\classes8.dex */
public final class g1 {

    /* renamed from: a, reason: collision with root package name */
    protected final HashSet f50290a = new HashSet();

    /* renamed from: b, reason: collision with root package name */
    protected final e1.pblb f50291b;

    /* renamed from: c, reason: collision with root package name */
    protected final e1.pgla f50292c;

    private void b(Context context, String str, String str2) {
        File file;
        char c6;
        if (this.f50290a.contains(str)) {
            String.format(Locale.US, "%s already loaded previously!", str);
            return;
        }
        try {
            ((s1) this.f50291b).getClass();
            com.bytedance.sdk.openadsdk.l.m.j(str);
            this.f50290a.add(str);
            String.format(Locale.US, "%s (%s) was loaded normally!", str, str2);
        } catch (UnsatisfiedLinkError e6) {
            Object[] objArr = {Log.getStackTraceString(e6)};
            Locale locale = Locale.US;
            String.format(locale, "Loading the library normally failed: %s", objArr);
            String.format(locale, "%s (%s) was not loaded normally, re-linking...", str, str2);
            ((s1) this.f50291b).getClass();
            String mapLibraryName = (str.startsWith("lib") && str.endsWith(".so")) ? str : System.mapLibraryName(str);
            File file2 = (str2 == null || str2.length() == 0) ? new File(xt.j(context, "lib", 0), mapLibraryName) : new File(xt.j(context, "lib", 0), mapLibraryName + "." + str2);
            if (file2.exists()) {
                file = file2;
                c6 = 1;
            } else {
                File j6 = xt.j(context, "lib", 0);
                ((s1) this.f50291b).getClass();
                String mapLibraryName2 = (str.startsWith("lib") && str.endsWith(".so")) ? str : System.mapLibraryName(str);
                File file3 = (str2 == null || str2.length() == 0) ? new File(xt.j(context, "lib", 0), mapLibraryName2) : new File(xt.j(context, "lib", 0), mapLibraryName2 + "." + str2);
                ((s1) this.f50291b).getClass();
                File[] listFiles = j6.listFiles(new f1((str.startsWith("lib") && str.endsWith(".so")) ? str : System.mapLibraryName(str)));
                if (listFiles != null) {
                    for (File file4 : listFiles) {
                        if (!file4.getAbsolutePath().equals(file3.getAbsolutePath())) {
                            file4.delete();
                        }
                    }
                }
                c6 = 1;
                e1.pgla pglaVar = this.f50292c;
                String[] a6 = ((s1) this.f50291b).a();
                ((s1) this.f50291b).getClass();
                file = file2;
                ((pbld) pglaVar).b(context, a6, (str.startsWith("lib") && str.endsWith(".so")) ? str : System.mapLibraryName(str), file, this);
            }
            e1.pblb pblbVar = this.f50291b;
            String absolutePath = file.getAbsolutePath();
            ((s1) pblbVar).getClass();
            System.load(absolutePath);
            this.f50290a.add(str);
            Object[] objArr2 = new Object[2];
            objArr2[0] = str;
            objArr2[c6] = str2;
            String.format(Locale.US, "%s (%s) was re-linked!", objArr2);
        }
    }

    public final void a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Given context is null");
        }
        String.format(Locale.US, "Beginning load of %s...", "Pglbizssdk_ml");
        b(context, "Pglbizssdk_ml", null);
    }

    protected g1(e1.pblb pblbVar, pbld pbldVar) {
        this.f50291b = pblbVar;
        this.f50292c = pbldVar;
    }
}
