package com.bumptech.glide;

import android.app.Activity;
import android.app.Fragment;
import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.View;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.c;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.data.k;
import com.bumptech.glide.load.engine.k;
import com.bumptech.glide.load.engine.prefill.d;
import com.bumptech.glide.load.model.a;
import com.bumptech.glide.load.model.b;
import com.bumptech.glide.load.model.d;
import com.bumptech.glide.load.model.e;
import com.bumptech.glide.load.model.f;
import com.bumptech.glide.load.model.k;
import com.bumptech.glide.load.model.s;
import com.bumptech.glide.load.model.stream.b;
import com.bumptech.glide.load.model.stream.d;
import com.bumptech.glide.load.model.stream.e;
import com.bumptech.glide.load.model.stream.f;
import com.bumptech.glide.load.model.stream.i;
import com.bumptech.glide.load.model.t;
import com.bumptech.glide.load.model.u;
import com.bumptech.glide.load.model.v;
import com.bumptech.glide.load.model.w;
import com.bumptech.glide.load.model.x;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.a0;
import com.bumptech.glide.load.resource.bitmap.c0;
import com.bumptech.glide.load.resource.bitmap.e0;
import com.bumptech.glide.load.resource.bitmap.g0;
import com.bumptech.glide.load.resource.bitmap.j0;
import com.bumptech.glide.load.resource.bitmap.l;
import com.bumptech.glide.load.resource.bitmap.l0;
import com.bumptech.glide.load.resource.bitmap.o0;
import com.bumptech.glide.load.resource.bitmap.u;
import com.bumptech.glide.load.resource.bitmap.x;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.manager.q;
import com.bumptech.glide.request.target.p;
import com.stub.StubApp;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import v.a;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class b implements ComponentCallbacks2 {

    /* renamed from: m, reason: collision with root package name */
    private static final String f14687m = "image_manager_disk_cache";

    /* renamed from: n, reason: collision with root package name */
    private static final String f14688n = "Glide";

    /* renamed from: o, reason: collision with root package name */
    @GuardedBy("Glide.class")
    private static volatile b f14689o;

    /* renamed from: p, reason: collision with root package name */
    private static volatile boolean f14690p;

    /* renamed from: a, reason: collision with root package name */
    private final k f14691a;

    /* renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.e f14692b;

    /* renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.cache.j f14693c;

    /* renamed from: d, reason: collision with root package name */
    private final d f14694d;

    /* renamed from: e, reason: collision with root package name */
    private final Registry f14695e;

    /* renamed from: f, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.b f14696f;

    /* renamed from: g, reason: collision with root package name */
    private final q f14697g;

    /* renamed from: h, reason: collision with root package name */
    private final com.bumptech.glide.manager.d f14698h;

    /* renamed from: j, reason: collision with root package name */
    private final a f14700j;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    @GuardedBy("this")
    private com.bumptech.glide.load.engine.prefill.b f14702l;

    /* renamed from: i, reason: collision with root package name */
    @GuardedBy("managers")
    private final List<i> f14699i = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    private MemoryCategory f14701k = MemoryCategory.NORMAL;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        @NonNull
        com.bumptech.glide.request.h build();
    }

    b(@NonNull Context context, @NonNull k kVar, @NonNull com.bumptech.glide.load.engine.cache.j jVar, @NonNull com.bumptech.glide.load.engine.bitmap_recycle.e eVar, @NonNull com.bumptech.glide.load.engine.bitmap_recycle.b bVar, @NonNull q qVar, @NonNull com.bumptech.glide.manager.d dVar, int i6, @NonNull a aVar, @NonNull Map<Class<?>, j<?, ?>> map, @NonNull List<com.bumptech.glide.request.g<Object>> list, e eVar2) {
        com.bumptech.glide.load.g jVar2;
        com.bumptech.glide.load.g j0Var;
        Registry registry;
        this.f14691a = kVar;
        this.f14692b = eVar;
        this.f14696f = bVar;
        this.f14693c = jVar;
        this.f14697g = qVar;
        this.f14698h = dVar;
        this.f14700j = aVar;
        Resources resources = context.getResources();
        Registry registry2 = new Registry();
        this.f14695e = registry2;
        registry2.t(new DefaultImageHeaderParser());
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 27) {
            registry2.t(new x());
        }
        List<ImageHeaderParser> g6 = registry2.g();
        com.bumptech.glide.load.resource.gif.a aVar2 = new com.bumptech.glide.load.resource.gif.a(context, g6, eVar, bVar);
        com.bumptech.glide.load.g<ParcelFileDescriptor, Bitmap> h6 = o0.h(eVar);
        u uVar = new u(registry2.g(), resources.getDisplayMetrics(), eVar, bVar);
        if (!eVar2.b(c.C0148c.class) || i7 < 28) {
            jVar2 = new com.bumptech.glide.load.resource.bitmap.j(uVar);
            j0Var = new j0(uVar, bVar);
        } else {
            j0Var = new c0();
            jVar2 = new l();
        }
        com.bumptech.glide.load.resource.drawable.e eVar3 = new com.bumptech.glide.load.resource.drawable.e(context);
        s.c cVar = new s.c(resources);
        s.d dVar2 = new s.d(resources);
        s.b bVar2 = new s.b(resources);
        s.a aVar3 = new s.a(resources);
        com.bumptech.glide.load.resource.bitmap.e eVar4 = new com.bumptech.glide.load.resource.bitmap.e(bVar);
        com.bumptech.glide.load.resource.transcode.a aVar4 = new com.bumptech.glide.load.resource.transcode.a();
        com.bumptech.glide.load.resource.transcode.d dVar3 = new com.bumptech.glide.load.resource.transcode.d();
        ContentResolver contentResolver = context.getContentResolver();
        registry2.a(ByteBuffer.class, new com.bumptech.glide.load.model.c()).a(InputStream.class, new t(bVar)).e(Registry.f14551l, ByteBuffer.class, Bitmap.class, jVar2).e(Registry.f14551l, InputStream.class, Bitmap.class, j0Var);
        if (ParcelFileDescriptorRewinder.c()) {
            registry2.e(Registry.f14551l, ParcelFileDescriptor.class, Bitmap.class, new e0(uVar));
        }
        registry2.e(Registry.f14551l, ParcelFileDescriptor.class, Bitmap.class, h6).e(Registry.f14551l, AssetFileDescriptor.class, Bitmap.class, o0.c(eVar)).d(Bitmap.class, Bitmap.class, v.a.a()).e(Registry.f14551l, Bitmap.class, Bitmap.class, new l0()).b(Bitmap.class, eVar4).e(Registry.f14552m, ByteBuffer.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a(resources, jVar2)).e(Registry.f14552m, InputStream.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a(resources, j0Var)).e(Registry.f14552m, ParcelFileDescriptor.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a(resources, h6)).b(BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.b(eVar, eVar4)).e(Registry.f14550k, InputStream.class, GifDrawable.class, new com.bumptech.glide.load.resource.gif.i(g6, aVar2, bVar)).e(Registry.f14550k, ByteBuffer.class, GifDrawable.class, aVar2).b(GifDrawable.class, new com.bumptech.glide.load.resource.gif.c()).d(GifDecoder.class, GifDecoder.class, v.a.a()).e(Registry.f14551l, GifDecoder.class, Bitmap.class, new com.bumptech.glide.load.resource.gif.g(eVar)).c(Uri.class, Drawable.class, eVar3).c(Uri.class, Bitmap.class, new g0(eVar3, eVar)).u(new a.C1082a()).d(File.class, ByteBuffer.class, new d.b()).d(File.class, InputStream.class, new f.e()).c(File.class, File.class, new w.a()).d(File.class, ParcelFileDescriptor.class, new f.b()).d(File.class, File.class, v.a.a()).u(new k.a(bVar));
        if (ParcelFileDescriptorRewinder.c()) {
            registry = registry2;
            registry.u(new ParcelFileDescriptorRewinder.a());
        } else {
            registry = registry2;
        }
        Class cls = Integer.TYPE;
        registry.d(cls, InputStream.class, cVar).d(cls, ParcelFileDescriptor.class, bVar2).d(Integer.class, InputStream.class, cVar).d(Integer.class, ParcelFileDescriptor.class, bVar2).d(Integer.class, Uri.class, dVar2).d(cls, AssetFileDescriptor.class, aVar3).d(Integer.class, AssetFileDescriptor.class, aVar3).d(cls, Uri.class, dVar2).d(String.class, InputStream.class, new e.c()).d(Uri.class, InputStream.class, new e.c()).d(String.class, InputStream.class, new u.c()).d(String.class, ParcelFileDescriptor.class, new u.b()).d(String.class, AssetFileDescriptor.class, new u.a()).d(Uri.class, InputStream.class, new a.c(context.getAssets())).d(Uri.class, ParcelFileDescriptor.class, new a.b(context.getAssets())).d(Uri.class, InputStream.class, new d.a(context)).d(Uri.class, InputStream.class, new e.a(context));
        if (i7 >= 29) {
            registry.d(Uri.class, InputStream.class, new f.c(context));
            registry.d(Uri.class, ParcelFileDescriptor.class, new f.b(context));
        }
        registry.d(Uri.class, InputStream.class, new w.d(contentResolver)).d(Uri.class, ParcelFileDescriptor.class, new w.b(contentResolver)).d(Uri.class, AssetFileDescriptor.class, new w.a(contentResolver)).d(Uri.class, InputStream.class, new x.a()).d(URL.class, InputStream.class, new i.a()).d(Uri.class, File.class, new k.a(context)).d(com.bumptech.glide.load.model.g.class, InputStream.class, new b.a()).d(byte[].class, ByteBuffer.class, new b.a()).d(byte[].class, InputStream.class, new b.d()).d(Uri.class, Uri.class, v.a.a()).d(Drawable.class, Drawable.class, v.a.a()).c(Drawable.class, Drawable.class, new com.bumptech.glide.load.resource.drawable.f()).x(Bitmap.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.transcode.b(resources)).x(Bitmap.class, byte[].class, aVar4).x(Drawable.class, byte[].class, new com.bumptech.glide.load.resource.transcode.c(eVar, aVar4, dVar3)).x(GifDrawable.class, byte[].class, dVar3);
        if (i7 >= 23) {
            com.bumptech.glide.load.g<ByteBuffer, Bitmap> d6 = o0.d(eVar);
            registry.c(ByteBuffer.class, Bitmap.class, d6);
            registry.c(ByteBuffer.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a(resources, d6));
        }
        this.f14694d = new d(context, bVar, registry, new com.bumptech.glide.request.target.k(), aVar, map, list, kVar, eVar2, i6);
    }

    public synchronized void t(@NonNull d.a... aVarArr) {
        try {
            if (this.f14702l == null) {
                this.f14702l = new com.bumptech.glide.load.engine.prefill.b(this.f14693c, this.f14692b, (DecodeFormat) this.f14700j.build().M().c(com.bumptech.glide.load.resource.bitmap.u.f15660g));
            }
            this.f14702l.c(aVarArr);
        } catch (Throwable th) {
            throw th;
        }
    }

    @GuardedBy("Glide.class")
    private static void a(@NonNull Context context, @Nullable GeneratedAppGlideModule generatedAppGlideModule) {
        if (f14690p) {
            throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
        }
        f14690p = true;
        r(context, generatedAppGlideModule);
        f14690p = false;
    }

    @NonNull
    public static b e(@NonNull Context context) {
        if (f14689o == null) {
            GeneratedAppGlideModule f6 = f(StubApp.getOrigApplicationContext(context.getApplicationContext()));
            synchronized (b.class) {
                try {
                    if (f14689o == null) {
                        a(context, f6);
                    }
                } finally {
                }
            }
        }
        return f14689o;
    }

    @Nullable
    private static GeneratedAppGlideModule f(Context context) {
        try {
            return (GeneratedAppGlideModule) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(Context.class).newInstance(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        } catch (ClassNotFoundException unused) {
            Log.isLoggable(f14688n, 5);
            return null;
        } catch (IllegalAccessException e6) {
            y(e6);
            return null;
        } catch (InstantiationException e7) {
            y(e7);
            return null;
        } catch (NoSuchMethodException e8) {
            y(e8);
            return null;
        } catch (InvocationTargetException e9) {
            y(e9);
            return null;
        }
    }

    @Nullable
    public static File k(@NonNull Context context) {
        return l(context, "image_manager_disk_cache");
    }

    @NonNull
    private static q o(@Nullable Context context) {
        com.bumptech.glide.util.k.e(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return e(context).n();
    }

    @VisibleForTesting
    @Deprecated
    public static synchronized void q(b bVar) {
        synchronized (b.class) {
            try {
                if (f14689o != null) {
                    x();
                }
                f14689o = bVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @GuardedBy("Glide.class")
    private static void r(@NonNull Context context, @Nullable GeneratedAppGlideModule generatedAppGlideModule) {
        s(context, new c(), generatedAppGlideModule);
    }

    @VisibleForTesting
    public static void x() {
        synchronized (b.class) {
            try {
                if (f14689o != null) {
                    StubApp.getOrigApplicationContext(f14689o.getContext().getApplicationContext()).unregisterComponentCallbacks(f14689o);
                    f14689o.f14691a.m();
                }
                f14689o = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void y(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    void A(i iVar) {
        synchronized (this.f14699i) {
            try {
                if (!this.f14699i.contains(iVar)) {
                    throw new IllegalStateException("Cannot unregister not yet registered manager");
                }
                this.f14699i.remove(iVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NonNull
    public com.bumptech.glide.load.engine.bitmap_recycle.b g() {
        return this.f14696f;
    }

    @NonNull
    public Context getContext() {
        return this.f14694d.getBaseContext();
    }

    @NonNull
    public com.bumptech.glide.load.engine.bitmap_recycle.e h() {
        return this.f14692b;
    }

    com.bumptech.glide.manager.d i() {
        return this.f14698h;
    }

    @NonNull
    d j() {
        return this.f14694d;
    }

    @NonNull
    public Registry m() {
        return this.f14695e;
    }

    @NonNull
    public q n() {
        return this.f14697g;
    }

    void u(i iVar) {
        synchronized (this.f14699i) {
            try {
                if (this.f14699i.contains(iVar)) {
                    throw new IllegalStateException("Cannot register already registered manager");
                }
                this.f14699i.add(iVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    boolean v(@NonNull p<?> pVar) {
        synchronized (this.f14699i) {
            try {
                Iterator<i> it = this.f14699i.iterator();
                while (it.hasNext()) {
                    if (it.next().Z(pVar)) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NonNull
    public static i B(@NonNull Activity activity) {
        return o(activity).j(activity);
    }

    @NonNull
    @Deprecated
    public static i C(@NonNull Fragment fragment) {
        return o(fragment.getActivity()).k(fragment);
    }

    @NonNull
    public static i D(@NonNull Context context) {
        return o(context).l(context);
    }

    @NonNull
    public static i E(@NonNull View view) {
        return o(view.getContext()).m(view);
    }

    @NonNull
    public static i F(@NonNull androidx.fragment.app.Fragment fragment) {
        return o(fragment.getContext()).n(fragment);
    }

    @NonNull
    public static i G(@NonNull FragmentActivity fragmentActivity) {
        return o(fragmentActivity).o(fragmentActivity);
    }

    @VisibleForTesting
    public static void d() {
        a0.d().l();
    }

    @Nullable
    public static File l(@NonNull Context context, @NonNull String str) {
        File cacheDir = context.getCacheDir();
        if (cacheDir != null) {
            File file = new File(cacheDir, str);
            if (!file.isDirectory() && !file.mkdirs()) {
                return null;
            }
            return file;
        }
        Log.isLoggable(f14688n, 6);
        return null;
    }

    @VisibleForTesting
    public static void p(@NonNull Context context, @NonNull c cVar) {
        GeneratedAppGlideModule f6 = f(context);
        synchronized (b.class) {
            try {
                if (f14689o != null) {
                    x();
                }
                s(context, cVar, f6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @GuardedBy("Glide.class")
    private static void s(@NonNull Context context, @NonNull c cVar, @Nullable GeneratedAppGlideModule generatedAppGlideModule) {
        q.b bVar;
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        List<com.bumptech.glide.module.c> list = Collections.EMPTY_LIST;
        if (generatedAppGlideModule == null || generatedAppGlideModule.c()) {
            list = new com.bumptech.glide.module.e(origApplicationContext).a();
        }
        if (generatedAppGlideModule != null && !generatedAppGlideModule.d().isEmpty()) {
            Set<Class<?>> d6 = generatedAppGlideModule.d();
            Iterator<com.bumptech.glide.module.c> it = list.iterator();
            while (it.hasNext()) {
                com.bumptech.glide.module.c next = it.next();
                if (d6.contains(next.getClass())) {
                    if (Log.isLoggable(f14688n, 3)) {
                        next.toString();
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable(f14688n, 3)) {
            Iterator<com.bumptech.glide.module.c> it2 = list.iterator();
            while (it2.hasNext()) {
                it2.next().getClass().toString();
            }
        }
        if (generatedAppGlideModule != null) {
            bVar = generatedAppGlideModule.e();
        } else {
            bVar = null;
        }
        cVar.t(bVar);
        Iterator<com.bumptech.glide.module.c> it3 = list.iterator();
        while (it3.hasNext()) {
            it3.next().a(origApplicationContext, cVar);
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.a(origApplicationContext, cVar);
        }
        b b6 = cVar.b(origApplicationContext);
        for (com.bumptech.glide.module.c cVar2 : list) {
            try {
                cVar2.b(origApplicationContext, b6, b6.f14695e);
            } catch (AbstractMethodError e6) {
                throw new IllegalStateException("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: " + cVar2.getClass().getName(), e6);
            }
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.b(origApplicationContext, b6, b6.f14695e);
        }
        origApplicationContext.registerComponentCallbacks(b6);
        f14689o = b6;
    }

    public void b() {
        com.bumptech.glide.util.l.a();
        this.f14691a.e();
    }

    public void c() {
        com.bumptech.glide.util.l.b();
        this.f14693c.b();
        this.f14692b.b();
        this.f14696f.b();
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        c();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i6) {
        z(i6);
    }

    @NonNull
    public MemoryCategory w(@NonNull MemoryCategory memoryCategory) {
        com.bumptech.glide.util.l.b();
        this.f14693c.c(memoryCategory.getMultiplier());
        this.f14692b.c(memoryCategory.getMultiplier());
        MemoryCategory memoryCategory2 = this.f14701k;
        this.f14701k = memoryCategory;
        return memoryCategory2;
    }

    public void z(int i6) {
        com.bumptech.glide.util.l.b();
        synchronized (this.f14699i) {
            try {
                Iterator<i> it = this.f14699i.iterator();
                while (it.hasNext()) {
                    it.next().onTrimMemory(i6);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f14693c.a(i6);
        this.f14692b.a(i6);
        this.f14696f.a(i6);
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }
}
