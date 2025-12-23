package pl.droidsonroids.relinker;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import pl.droidsonroids.relinker.c;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class d {

    /* renamed from: g, reason: collision with root package name */
    private static final String f51872g = "lib";

    /* renamed from: a, reason: collision with root package name */
    protected final Set<String> f51873a;

    /* renamed from: b, reason: collision with root package name */
    protected final c.b f51874b;

    /* renamed from: c, reason: collision with root package name */
    protected final c.a f51875c;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f51876d;

    /* renamed from: e, reason: collision with root package name */
    protected boolean f51877e;

    /* renamed from: f, reason: collision with root package name */
    protected c.d f51878f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f51879a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f51880b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f51881c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ c.InterfaceC1001c f51882d;

        a(Context context, String str, String str2, c.InterfaceC1001c interfaceC1001c) {
            this.f51879a = context;
            this.f51880b = str;
            this.f51881c = str2;
            this.f51882d = interfaceC1001c;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.this.j(this.f51879a, this.f51880b, this.f51881c);
                this.f51882d.success();
            } catch (UnsatisfiedLinkError e6) {
                this.f51882d.a(e6);
            } catch (MissingLibraryException e7) {
                this.f51882d.a(e7);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements FilenameFilter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f51884a;

        b(String str) {
            this.f51884a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.startsWith(this.f51884a);
        }
    }

    protected d() {
        this(new e(), new pl.droidsonroids.relinker.a());
    }

    public d c() {
        this.f51876d = true;
        return this;
    }

    public void f(Context context, String str) {
        h(context, str, null, null);
    }

    public void g(Context context, String str, String str2) {
        h(context, str, str2, null);
    }

    public void i(Context context, String str, c.InterfaceC1001c interfaceC1001c) {
        h(context, str, null, interfaceC1001c);
    }

    public d n() {
        this.f51877e = true;
        return this;
    }

    protected d(c.b bVar, c.a aVar) {
        this.f51873a = new HashSet();
        if (bVar == null) {
            throw new IllegalArgumentException("Cannot pass null library loader");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("Cannot pass null library installer");
        }
        this.f51874b = bVar;
        this.f51875c = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Context context, String str, String str2) {
        d dVar;
        Context context2;
        pl.droidsonroids.relinker.elf.f fVar;
        if (this.f51873a.contains(str) && !this.f51876d) {
            m("%s already loaded previously!", str);
            return;
        }
        try {
            this.f51874b.loadLibrary(str);
            this.f51873a.add(str);
            m("%s (%s) was loaded normally!", str, str2);
        } catch (UnsatisfiedLinkError e6) {
            m("Loading the library normally failed: %s", Log.getStackTraceString(e6));
            m("%s (%s) was not loaded normally, re-linking...", str, str2);
            File e7 = e(context, str, str2);
            if (!e7.exists() || this.f51876d) {
                if (this.f51876d) {
                    m("Forcing a re-link of %s (%s)...", str, str2);
                }
                b(context, str, str2);
                dVar = this;
                context2 = context;
                this.f51875c.a(context2, this.f51874b.b(), this.f51874b.d(str), e7, dVar);
            } else {
                dVar = this;
                context2 = context;
            }
            try {
                if (dVar.f51877e) {
                    try {
                        fVar = new pl.droidsonroids.relinker.elf.f(e7);
                    } catch (Throwable th) {
                        th = th;
                        fVar = null;
                    }
                    try {
                        List<String> c6 = fVar.c();
                        fVar.close();
                        Iterator<String> it = c6.iterator();
                        while (it.hasNext()) {
                            f(context2, dVar.f51874b.a(it.next()));
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        Throwable th3 = th;
                        fVar.close();
                        throw th3;
                    }
                }
            } catch (IOException unused) {
            }
            dVar.f51874b.c(e7.getAbsolutePath());
            dVar.f51873a.add(str);
            m("%s (%s) was re-linked!", str, str2);
        }
    }

    protected File d(Context context) {
        return context.getDir(f51872g, 0);
    }

    protected File e(Context context, String str, String str2) {
        String d6 = this.f51874b.d(str);
        if (f.a(str2)) {
            return new File(d(context), d6);
        }
        return new File(d(context), d6 + "." + str2);
    }

    public void h(Context context, String str, String str2, c.InterfaceC1001c interfaceC1001c) {
        if (context == null) {
            throw new IllegalArgumentException("Given context is null");
        }
        if (f.a(str)) {
            throw new IllegalArgumentException("Given library is either null or empty");
        }
        m("Beginning load of %s...", str);
        if (interfaceC1001c == null) {
            j(context, str, str2);
        } else {
            new Thread(new a(context, str, str2, interfaceC1001c)).start();
        }
    }

    public d k(c.d dVar) {
        this.f51878f = dVar;
        return this;
    }

    public void l(String str) {
        c.d dVar = this.f51878f;
        if (dVar != null) {
            dVar.log(str);
        }
    }

    public void m(String str, Object... objArr) {
        l(String.format(Locale.US, str, objArr));
    }

    protected void b(Context context, String str, String str2) {
        File d6 = d(context);
        File e6 = e(context, str, str2);
        File[] listFiles = d6.listFiles(new b(this.f51874b.d(str)));
        if (listFiles != null) {
            for (File file : listFiles) {
                if (this.f51876d || !file.getAbsolutePath().equals(e6.getAbsolutePath())) {
                    file.delete();
                }
            }
        }
    }
}
