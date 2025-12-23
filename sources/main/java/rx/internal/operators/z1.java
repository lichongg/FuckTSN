package rx.internal.operators;

import rx.Notification;
import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class z1<T> implements e.b<T, Notification<T>> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends rx.l<Notification<T>> {

        /* renamed from: a, reason: collision with root package name */
        boolean f53917a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ rx.l f53918b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.l lVar, rx.l lVar2) {
            super(lVar);
            this.f53918b = lVar2;
        }

        @Override // rx.f
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public void onNext(Notification<T> notification) {
            int i6 = b.f53920a[notification.f().ordinal()];
            if (i6 == 1) {
                if (this.f53917a) {
                    return;
                }
                this.f53918b.onNext(notification.h());
            } else {
                if (i6 == 2) {
                    onError(notification.g());
                    return;
                }
                if (i6 == 3) {
                    onCompleted();
                    return;
                }
                onError(new IllegalArgumentException("Unsupported notification type: " + notification));
            }
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f53917a) {
                return;
            }
            this.f53917a = true;
            this.f53918b.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f53917a) {
                return;
            }
            this.f53917a = true;
            this.f53918b.onError(th);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f53920a;

        static {
            int[] iArr = new int[Notification.Kind.values().length];
            f53920a = iArr;
            try {
                iArr[Notification.Kind.OnNext.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f53920a[Notification.Kind.OnError.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f53920a[Notification.Kind.OnCompleted.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class c {

        /* renamed from: a, reason: collision with root package name */
        static final z1<Object> f53921a = new z1<>();

        c() {
        }
    }

    public static z1 a() {
        return c.f53921a;
    }

    @Override // rx.functions.p
    public rx.l<? super Notification<T>> call(rx.l<? super T> lVar) {
        return new a(lVar, lVar);
    }

    z1() {
    }
}
