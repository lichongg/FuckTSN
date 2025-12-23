package kotlinx.coroutines.internal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nFastServiceLoader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastServiceLoader.kt\nkotlinx/coroutines/internal/FastServiceLoader\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,161:1\n77#1,5:162\n77#1,5:168\n131#1,13:183\n1#2:167\n1360#3:173\n1446#3,5:174\n1549#3:179\n1620#3,3:180\n1064#4,2:196\n*S KotlinDebug\n*F\n+ 1 FastServiceLoader.kt\nkotlinx/coroutines/internal/FastServiceLoader\n*L\n60#1:162,5\n61#1:168,5\n117#1:183,13\n99#1:173\n99#1:174,5\n101#1:179\n101#1:180,3\n153#1:196,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final o f49292a = new o();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final String f49293b = "META-INF/services/";

    private final c0 a(Class<c0> cls, String str) {
        try {
            return cls.cast(Class.forName(str, true, cls.getClassLoader()).getDeclaredConstructor(null).newInstance(null));
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private final <S> S b(String str, ClassLoader classLoader, Class<S> cls) {
        Class<?> cls2 = Class.forName(str, false, classLoader);
        if (cls.isAssignableFrom(cls2)) {
            return cls.cast(cls2.getDeclaredConstructor(null).newInstance(null));
        }
        throw new IllegalArgumentException(("Expected service of class " + cls + ", but found " + cls2).toString());
    }

    private final <R> R h(JarFile jarFile, Function1<? super JarFile, ? extends R> function1) {
        try {
            R invoke = function1.invoke(jarFile);
            kotlin.jvm.internal.d0.d(1);
            jarFile.close();
            kotlin.jvm.internal.d0.c(1);
            return invoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                kotlin.jvm.internal.d0.d(1);
                try {
                    jarFile.close();
                    kotlin.jvm.internal.d0.c(1);
                    throw th2;
                } catch (Throwable th3) {
                    kotlin.l.a(th, th3);
                    throw th;
                }
            }
        }
    }

    private final List<String> g(BufferedReader bufferedReader) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return kotlin.collections.f0.a6(linkedHashSet);
            }
            String obj = kotlin.text.u.Z5(kotlin.text.u.S5(readLine, "#", null, 2, null)).toString();
            for (int i6 = 0; i6 < obj.length(); i6++) {
                char charAt = obj.charAt(i6);
                if (charAt != '.' && !Character.isJavaIdentifierPart(charAt)) {
                    throw new IllegalArgumentException(("Illegal service provider class name: " + obj).toString());
                }
            }
            if (obj.length() > 0) {
                linkedHashSet.add(obj);
            }
        }
    }

    @NotNull
    public final <S> List<S> e(@NotNull Class<S> cls, @NotNull ClassLoader classLoader) {
        ArrayList list = Collections.list(classLoader.getResources(f49293b + cls.getName()));
        kotlin.jvm.internal.g0.o(list, "list(this)");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            kotlin.collections.f0.s0(arrayList, f49292a.f((URL) it.next()));
        }
        Set f6 = kotlin.collections.f0.f6(arrayList);
        if (f6.isEmpty()) {
            throw new IllegalArgumentException("No providers were loaded with FastServiceLoader");
        }
        ArrayList arrayList2 = new ArrayList(kotlin.collections.f0.d0(f6, 10));
        Iterator it2 = f6.iterator();
        while (it2.hasNext()) {
            arrayList2.add(f49292a.b((String) it2.next(), classLoader, cls));
        }
        return arrayList2;
    }

    private o() {
    }

    private final <S> List<S> c(Class<S> cls, ClassLoader classLoader) {
        try {
            return e(cls, classLoader);
        } catch (Throwable unused) {
            return kotlin.collections.f0.a6(ServiceLoader.load(cls, classLoader));
        }
    }

    private final List<String> f(URL url) {
        BufferedReader bufferedReader;
        String url2 = url.toString();
        if (kotlin.text.u.H2(url2, "jar", false, 2, null)) {
            String R5 = kotlin.text.u.R5(kotlin.text.u.K5(url2, "jar:file:", null, 2, null), '!', null, 2, null);
            String K5 = kotlin.text.u.K5(url2, "!/", null, 2, null);
            JarFile jarFile = new JarFile(R5, false);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(jarFile.getInputStream(new ZipEntry(K5)), "UTF-8"));
                try {
                    List<String> g6 = f49292a.g(bufferedReader);
                    kotlin.io.b.a(bufferedReader, null);
                    jarFile.close();
                    return g6;
                } finally {
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        jarFile.close();
                        throw th2;
                    } catch (Throwable th3) {
                        kotlin.l.a(th, th3);
                        throw th;
                    }
                }
            }
        } else {
            bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            try {
                List<String> g7 = f49292a.g(bufferedReader);
                kotlin.io.b.a(bufferedReader, null);
                return g7;
            } catch (Throwable th4) {
                try {
                    throw th4;
                } finally {
                }
            }
        }
    }

    @NotNull
    public final List<c0> d() {
        c0 c0Var;
        if (!p.a()) {
            return c(c0.class, c0.class.getClassLoader());
        }
        try {
            ArrayList arrayList = new ArrayList(2);
            c0 c0Var2 = null;
            try {
                c0Var = (c0) c0.class.cast(Class.forName("kotlinx.coroutines.android.a", true, c0.class.getClassLoader()).getDeclaredConstructor(null).newInstance(null));
            } catch (ClassNotFoundException unused) {
                c0Var = null;
            }
            if (c0Var != null) {
                arrayList.add(c0Var);
            }
            try {
                c0Var2 = (c0) c0.class.cast(Class.forName("kotlinx.coroutines.test.internal.TestMainDispatcherFactory", true, c0.class.getClassLoader()).getDeclaredConstructor(null).newInstance(null));
            } catch (ClassNotFoundException unused2) {
            }
            if (c0Var2 != null) {
                arrayList.add(c0Var2);
                return arrayList;
            }
            return arrayList;
        } catch (Throwable unused3) {
            return c(c0.class, c0.class.getClassLoader());
        }
    }
}
