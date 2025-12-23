package com.trello.rxlifecycle2.android;

import android.view.View;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.trello.rxlifecycle2.OutsideLifecycleException;
import com.trello.rxlifecycle2.d;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final Function<ActivityEvent, ActivityEvent> f40706a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static final Function<FragmentEvent, FragmentEvent> f40707b = new C0818b();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements Function<ActivityEvent, ActivityEvent> {
        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ActivityEvent apply(ActivityEvent activityEvent) throws Exception {
            switch (c.f40708a[activityEvent.ordinal()]) {
                case 1:
                    return ActivityEvent.DESTROY;
                case 2:
                    return ActivityEvent.STOP;
                case 3:
                    return ActivityEvent.PAUSE;
                case 4:
                    return ActivityEvent.STOP;
                case 5:
                    return ActivityEvent.DESTROY;
                case 6:
                    throw new OutsideLifecycleException("Cannot bind to Activity lifecycle when outside of it.");
                default:
                    throw new UnsupportedOperationException("Binding to " + activityEvent + " not yet implemented");
            }
        }

        a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.trello.rxlifecycle2.android.b$b, reason: collision with other inner class name */
    static class C0818b implements Function<FragmentEvent, FragmentEvent> {
        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FragmentEvent apply(FragmentEvent fragmentEvent) throws Exception {
            switch (c.f40709b[fragmentEvent.ordinal()]) {
                case 1:
                    return FragmentEvent.DETACH;
                case 2:
                    return FragmentEvent.DESTROY;
                case 3:
                    return FragmentEvent.DESTROY_VIEW;
                case 4:
                    return FragmentEvent.STOP;
                case 5:
                    return FragmentEvent.PAUSE;
                case 6:
                    return FragmentEvent.STOP;
                case 7:
                    return FragmentEvent.DESTROY_VIEW;
                case 8:
                    return FragmentEvent.DESTROY;
                case 9:
                    return FragmentEvent.DETACH;
                case 10:
                    throw new OutsideLifecycleException("Cannot bind to Fragment lifecycle when outside of it.");
                default:
                    throw new UnsupportedOperationException("Binding to " + fragmentEvent + " not yet implemented");
            }
        }

        C0818b() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f40708a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f40709b;

        static {
            int[] iArr = new int[FragmentEvent.values().length];
            f40709b = iArr;
            try {
                iArr[FragmentEvent.ATTACH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f40709b[FragmentEvent.CREATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f40709b[FragmentEvent.CREATE_VIEW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f40709b[FragmentEvent.START.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f40709b[FragmentEvent.RESUME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f40709b[FragmentEvent.PAUSE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f40709b[FragmentEvent.STOP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f40709b[FragmentEvent.DESTROY_VIEW.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f40709b[FragmentEvent.DESTROY.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f40709b[FragmentEvent.DETACH.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            int[] iArr2 = new int[ActivityEvent.values().length];
            f40708a = iArr2;
            try {
                iArr2[ActivityEvent.CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f40708a[ActivityEvent.START.ordinal()] = 2;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f40708a[ActivityEvent.RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f40708a[ActivityEvent.PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f40708a[ActivityEvent.STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f40708a[ActivityEvent.DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused16) {
            }
        }
    }

    @NonNull
    @CheckResult
    public static <T> com.trello.rxlifecycle2.c<T> a(@NonNull Observable<ActivityEvent> observable) {
        return d.b(observable, f40706a);
    }

    @NonNull
    @CheckResult
    public static <T> com.trello.rxlifecycle2.c<T> b(@NonNull Observable<FragmentEvent> observable) {
        return d.b(observable, f40707b);
    }

    @NonNull
    @CheckResult
    public static <T> com.trello.rxlifecycle2.c<T> c(@NonNull View view) {
        a3.a.a(view, "view == null");
        return d.a(Observable.create(new com.trello.rxlifecycle2.android.c(view)));
    }

    private b() {
        throw new AssertionError("No instances");
    }
}
