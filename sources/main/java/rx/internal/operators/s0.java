package rx.internal.operators;

import rx.e;
import rx.exceptions.AssemblyStackTraceException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class s0<T> implements e.a<T> {

    /* renamed from: c, reason: collision with root package name */
    public static volatile boolean f53476c;

    /* renamed from: a, reason: collision with root package name */
    final e.a<T> f53477a;

    /* renamed from: b, reason: collision with root package name */
    final String f53478b = a();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<T> extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        final rx.l<? super T> f53479a;

        /* renamed from: b, reason: collision with root package name */
        final String f53480b;

        @Override // rx.f
        public void onCompleted() {
            this.f53479a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            new AssemblyStackTraceException(this.f53480b).attachTo(th);
            this.f53479a.onError(th);
        }

        @Override // rx.f
        public void onNext(T t5) {
            this.f53479a.onNext(t5);
        }

        public a(rx.l<? super T> lVar, String str) {
            super(lVar);
            this.f53479a = lVar;
            this.f53480b = str;
        }
    }

    @Override // rx.functions.b
    public void call(rx.l<? super T> lVar) {
        this.f53477a.call(new a(lVar, this.f53478b));
    }

    public s0(e.a<T> aVar) {
        this.f53477a = aVar;
    }

    static String a() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StringBuilder sb = new StringBuilder("Assembly trace:");
        for (StackTraceElement stackTraceElement : stackTrace) {
            String stackTraceElement2 = stackTraceElement.toString();
            if (f53476c || (stackTraceElement.getLineNumber() > 1 && !stackTraceElement2.contains("RxJavaHooks.") && !stackTraceElement2.contains("OnSubscribeOnAssembly") && !stackTraceElement2.contains(".junit.runner") && !stackTraceElement2.contains(".junit4.runner") && !stackTraceElement2.contains(".junit.internal") && !stackTraceElement2.contains("sun.reflect") && !stackTraceElement2.contains("java.lang.Thread.") && !stackTraceElement2.contains("ThreadPoolExecutor") && !stackTraceElement2.contains("org.apache.catalina.") && !stackTraceElement2.contains("org.apache.tomcat."))) {
                sb.append("\n at ");
                sb.append(stackTraceElement2);
            }
        }
        sb.append("\nOriginal exception:");
        return sb.toString();
    }
}
