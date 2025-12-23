package okhttp3.internal;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.Field;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.collections.d1;
import kotlin.collections.f0;
import kotlin.collections.n;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.t0;
import kotlin.n1;
import kotlin.ranges.m;
import kotlin.ranges.t;
import kotlin.text.e;
import kotlin.text.u;
import kotlin.time.h;
import okhttp3.Call;
import okhttp3.Dispatcher;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.internal.http2.Header;
import okio.Buffer;
import okio.BufferedSource;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\n-UtilJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 -UtilJvm.kt\nokhttp3/internal/_UtilJvmKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,355:1\n242#1:361\n242#1:362\n1#2:356\n1563#3:357\n1634#3,3:358\n*S KotlinDebug\n*F\n+ 1 -UtilJvm.kt\nokhttp3/internal/_UtilJvmKt\n*L\n260#1:361\n272#1:362\n131#1:357\n131#1:358,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class _UtilJvmKt {

    @JvmField
    @NotNull
    public static final TimeZone UTC;

    @JvmField
    public static final boolean assertionsEnabled;

    @JvmField
    @NotNull
    public static final String okHttpName;

    public static final void closeQuietly(@NotNull Socket socket) {
        g0.p(socket, "<this>");
        try {
            socket.close();
        } catch (AssertionError e6) {
            throw e6;
        } catch (RuntimeException e7) {
            if (!g0.g(e7.getMessage(), "bio == null")) {
                throw e7;
            }
        } catch (Exception unused) {
        }
    }

    public static final boolean skipAll(@NotNull Source source, int i6, @NotNull TimeUnit timeUnit) throws IOException {
        g0.p(source, "<this>");
        g0.p(timeUnit, "timeUnit");
        long nanoTime = System.nanoTime();
        long deadlineNanoTime = source.timeout().hasDeadline() ? source.timeout().deadlineNanoTime() - nanoTime : Long.MAX_VALUE;
        source.timeout().deadlineNanoTime(Math.min(deadlineNanoTime, timeUnit.toNanos(i6)) + nanoTime);
        try {
            Buffer buffer = new Buffer();
            while (source.read(buffer, 8192L) != -1) {
                buffer.clear();
            }
            if (deadlineNanoTime == Long.MAX_VALUE) {
                source.timeout().clearDeadline();
                return true;
            }
            source.timeout().deadlineNanoTime(nanoTime + deadlineNanoTime);
            return true;
        } catch (InterruptedIOException unused) {
            if (deadlineNanoTime == Long.MAX_VALUE) {
                source.timeout().clearDeadline();
                return false;
            }
            source.timeout().deadlineNanoTime(nanoTime + deadlineNanoTime);
            return false;
        } catch (Throwable th) {
            if (deadlineNanoTime == Long.MAX_VALUE) {
                source.timeout().clearDeadline();
            } else {
                source.timeout().deadlineNanoTime(nanoTime + deadlineNanoTime);
            }
            throw th;
        }
    }

    @NotNull
    public static final String toHexString(long j6) {
        String hexString = Long.toHexString(j6);
        g0.o(hexString, "toHexString(...)");
        return hexString;
    }

    @NotNull
    public static final <T> List<T> toImmutableList(@NotNull List<? extends T> list) {
        g0.p(list, "<this>");
        if (list.isEmpty()) {
            return f0.J();
        }
        if (list.size() == 1) {
            List<T> singletonList = Collections.singletonList(list.get(0));
            g0.o(singletonList, "singletonList(...)");
            return singletonList;
        }
        Object[] array = list.toArray();
        g0.o(array, "toArray(...)");
        List<T> unmodifiableList = Collections.unmodifiableList(n.t(array));
        g0.o(unmodifiableList, "unmodifiableList(...)");
        g0.n(unmodifiableList, "null cannot be cast to non-null type kotlin.collections.List<T of okhttp3.internal._UtilJvmKt.toImmutableList>");
        return unmodifiableList;
    }

    @NotNull
    public static final <T> List<T> unmodifiable(@NotNull List<? extends T> list) {
        g0.p(list, "<this>");
        List<T> unmodifiableList = Collections.unmodifiableList(list);
        g0.o(unmodifiableList, "unmodifiableList(...)");
        return unmodifiableList;
    }

    static {
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        g0.m(timeZone);
        UTC = timeZone;
        assertionsEnabled = false;
        String name = OkHttpClient.class.getName();
        g0.o(name, "getName(...)");
        okHttpName = u.B4(u.v4(name, "okhttp3."), "Client");
    }

    @NotNull
    public static final EventListener.Factory asFactory(@NotNull final EventListener eventListener) {
        g0.p(eventListener, "<this>");
        return new EventListener.Factory() { // from class: okhttp3.internal.c
            @Override // okhttp3.EventListener.Factory
            public final EventListener create(Call call) {
                EventListener asFactory$lambda$0;
                asFactory$lambda$0 = _UtilJvmKt.asFactory$lambda$0(EventListener.this, call);
                return asFactory$lambda$0;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventListener asFactory$lambda$0(EventListener eventListener, Call it) {
        g0.p(it, "it");
        return eventListener;
    }

    public static final void assertLockNotHeld(@NotNull Dispatcher dispatcher) {
        g0.p(dispatcher, "<this>");
        if (assertionsEnabled && Thread.holdsLock(dispatcher)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + dispatcher);
        }
    }

    public static final boolean canReuseConnectionFor(@NotNull HttpUrl httpUrl, @NotNull HttpUrl other) {
        g0.p(httpUrl, "<this>");
        g0.p(other, "other");
        return g0.g(httpUrl.host(), other.host()) && httpUrl.port() == other.port() && g0.g(httpUrl.scheme(), other.scheme());
    }

    public static final int checkDuration(@NotNull String name, long j6, @NotNull TimeUnit unit) {
        g0.p(name, "name");
        g0.p(unit, "unit");
        if (j6 < 0) {
            throw new IllegalStateException((name + " < 0").toString());
        }
        long millis = unit.toMillis(j6);
        if (millis > 2147483647L) {
            throw new IllegalArgumentException((name + " too large").toString());
        }
        if (millis != 0 || j6 <= 0) {
            return (int) millis;
        }
        throw new IllegalArgumentException((name + " too small").toString());
    }

    /* renamed from: checkDuration-HG0u8IE, reason: not valid java name */
    public static final int m288checkDurationHG0u8IE(@NotNull String name, long j6) {
        g0.p(name, "name");
        if (h.V(j6)) {
            throw new IllegalStateException((name + " < 0").toString());
        }
        long x5 = h.x(j6);
        if (x5 > 2147483647L) {
            throw new IllegalArgumentException((name + " too large").toString());
        }
        if (x5 != 0 || !h.W(j6)) {
            return (int) x5;
        }
        throw new IllegalArgumentException((name + " too small").toString());
    }

    public static final boolean discard(@NotNull Source source, int i6, @NotNull TimeUnit timeUnit) {
        g0.p(source, "<this>");
        g0.p(timeUnit, "timeUnit");
        try {
            return skipAll(source, i6, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    @NotNull
    public static final String format(@NotNull String format, @NotNull Object... args) {
        g0.p(format, "format");
        g0.p(args, "args");
        t0 t0Var = t0.f44062a;
        Locale locale = Locale.US;
        Object[] copyOf = Arrays.copyOf(args, args.length);
        String format2 = String.format(locale, format, Arrays.copyOf(copyOf, copyOf.length));
        g0.o(format2, "format(...)");
        return format2;
    }

    public static final long headersContentLength(@NotNull Response response) {
        g0.p(response, "<this>");
        String str = response.headers().get("Content-Length");
        if (str != null) {
            return _UtilCommonKt.toLongOrDefault(str, -1L);
        }
        return -1L;
    }

    @SafeVarargs
    @NotNull
    public static final <T> List<T> immutableListOf(@NotNull T... elements) {
        g0.p(elements, "elements");
        return toImmutableList(elements);
    }

    public static final boolean isHealthy(@NotNull Socket socket, @NotNull BufferedSource source) {
        g0.p(socket, "<this>");
        g0.p(source, "source");
        try {
            int soTimeout = socket.getSoTimeout();
            try {
                socket.setSoTimeout(1);
                return !source.exhausted();
            } finally {
                socket.setSoTimeout(soTimeout);
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    @NotNull
    public static final Charset readBomAsCharset(@NotNull BufferedSource bufferedSource, @NotNull Charset charset) throws IOException {
        g0.p(bufferedSource, "<this>");
        g0.p(charset, "default");
        int select = bufferedSource.select(_UtilCommonKt.getUNICODE_BOMS());
        if (select == -1) {
            return charset;
        }
        if (select == 0) {
            return e.f47851b;
        }
        if (select == 1) {
            return e.f47853d;
        }
        if (select == 2) {
            return e.f47850a.c();
        }
        if (select == 3) {
            return e.f47854e;
        }
        if (select == 4) {
            return e.f47850a.b();
        }
        throw new AssertionError();
    }

    @Nullable
    public static final <T> T readFieldOrNull(@NotNull Object instance, @NotNull Class<T> fieldType, @NotNull String fieldName) {
        T t5;
        Object readFieldOrNull;
        g0.p(instance, "instance");
        g0.p(fieldType, "fieldType");
        g0.p(fieldName, "fieldName");
        Class<?> cls = instance.getClass();
        while (true) {
            t5 = null;
            if (g0.g(cls, Object.class)) {
                if (g0.g(fieldName, "delegate") || (readFieldOrNull = readFieldOrNull(instance, Object.class, "delegate")) == null) {
                    return null;
                }
                return (T) readFieldOrNull(readFieldOrNull, fieldType, fieldName);
            }
            try {
                Field declaredField = cls.getDeclaredField(fieldName);
                declaredField.setAccessible(true);
                Object obj = declaredField.get(instance);
                if (!fieldType.isInstance(obj)) {
                    break;
                }
                t5 = fieldType.cast(obj);
                break;
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
                g0.o(cls, "getSuperclass(...)");
            }
        }
        return t5;
    }

    @NotNull
    public static final ThreadFactory threadFactory(@NotNull final String name, final boolean z5) {
        g0.p(name, "name");
        return new ThreadFactory() { // from class: okhttp3.internal.d
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread threadFactory$lambda$0;
                threadFactory$lambda$0 = _UtilJvmKt.threadFactory$lambda$0(name, z5, runnable);
                return threadFactory$lambda$0;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread threadFactory$lambda$0(String str, boolean z5, Runnable runnable) {
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(z5);
        return thread;
    }

    public static final void threadName(@NotNull String name, @NotNull Function0<n1> block) {
        g0.p(name, "name");
        g0.p(block, "block");
        Thread currentThread = Thread.currentThread();
        String name2 = currentThread.getName();
        currentThread.setName(name);
        try {
            block.invoke();
        } finally {
            d0.d(1);
            currentThread.setName(name2);
            d0.c(1);
        }
    }

    @NotNull
    public static final List<Header> toHeaderList(@NotNull Headers headers) {
        g0.p(headers, "<this>");
        m W1 = t.W1(0, headers.size());
        ArrayList arrayList = new ArrayList(f0.d0(W1, 10));
        Iterator<Integer> it = W1.iterator();
        while (it.hasNext()) {
            int nextInt = ((d1) it).nextInt();
            arrayList.add(new Header(headers.name(nextInt), headers.value(nextInt)));
        }
        return arrayList;
    }

    @NotNull
    public static final Headers toHeaders(@NotNull List<Header> list) {
        g0.p(list, "<this>");
        Headers.Builder builder = new Headers.Builder();
        for (Header header : list) {
            builder.addLenient$okhttp(header.component1().utf8(), header.component2().utf8());
        }
        return builder.build();
    }

    @NotNull
    public static final String toHexString(int i6) {
        String hexString = Integer.toHexString(i6);
        g0.o(hexString, "toHexString(...)");
        return hexString;
    }

    @NotNull
    public static final String toHostHeader(@NotNull HttpUrl httpUrl, boolean z5) {
        String host;
        g0.p(httpUrl, "<this>");
        if (u.l3(httpUrl.host(), ":", false, 2, null)) {
            host = '[' + httpUrl.host() + ']';
        } else {
            host = httpUrl.host();
        }
        if (!z5 && httpUrl.port() == HttpUrl.Companion.defaultPort(httpUrl.scheme())) {
            return host;
        }
        return host + ':' + httpUrl.port();
    }

    public static /* synthetic */ String toHostHeader$default(HttpUrl httpUrl, boolean z5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            z5 = false;
        }
        return toHostHeader(httpUrl, z5);
    }

    @NotNull
    public static final <T> Set<T> unmodifiable(@NotNull Set<? extends T> set) {
        g0.p(set, "<this>");
        Set<T> unmodifiableSet = Collections.unmodifiableSet(set);
        g0.o(unmodifiableSet, "unmodifiableSet(...)");
        return unmodifiableSet;
    }

    @NotNull
    public static final <K, V> Map<K, V> unmodifiable(@NotNull Map<K, ? extends V> map) {
        g0.p(map, "<this>");
        Map<K, V> unmodifiableMap = Collections.unmodifiableMap(map);
        g0.o(unmodifiableMap, "unmodifiableMap(...)");
        return unmodifiableMap;
    }

    public static final void closeQuietly(@NotNull ServerSocket serverSocket) {
        g0.p(serverSocket, "<this>");
        try {
            serverSocket.close();
        } catch (RuntimeException e6) {
            throw e6;
        } catch (Exception unused) {
        }
    }

    @NotNull
    public static final <T> List<T> toImmutableList(@Nullable T[] tArr) {
        if (tArr != null && tArr.length != 0) {
            if (tArr.length == 1) {
                List<T> singletonList = Collections.singletonList(tArr[0]);
                g0.o(singletonList, "singletonList(...)");
                return singletonList;
            }
            List<T> unmodifiableList = Collections.unmodifiableList(n.t((Object[]) tArr.clone()));
            g0.o(unmodifiableList, "unmodifiableList(...)");
            return unmodifiableList;
        }
        return f0.J();
    }

    public static final void skipAll(@NotNull BufferedSource bufferedSource) throws IOException {
        g0.p(bufferedSource, "<this>");
        while (!bufferedSource.exhausted()) {
            bufferedSource.skip(bufferedSource.getBuffer().size());
        }
    }
}
