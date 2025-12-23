package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.RestrictTo;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class Lifecycle {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    private AtomicReference<Object> internalScopeRef = new AtomicReference<>();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum Event {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY;


        @NotNull
        public static final Companion Companion = new Companion(null);

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class Companion {
            public /* synthetic */ Companion(v vVar) {
                this();
            }

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[State.values().length];
                    try {
                        iArr[State.CREATED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[State.STARTED.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[State.RESUMED.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[State.DESTROYED.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[State.INITIALIZED.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            private Companion() {
            }

            @JvmStatic
            @Nullable
            public final Event downFrom(@NotNull State state) {
                g0.p(state, "state");
                int i6 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
                if (i6 == 1) {
                    return Event.ON_DESTROY;
                }
                if (i6 == 2) {
                    return Event.ON_STOP;
                }
                if (i6 != 3) {
                    return null;
                }
                return Event.ON_PAUSE;
            }

            @JvmStatic
            @Nullable
            public final Event downTo(@NotNull State state) {
                g0.p(state, "state");
                int i6 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
                if (i6 == 1) {
                    return Event.ON_STOP;
                }
                if (i6 == 2) {
                    return Event.ON_PAUSE;
                }
                if (i6 != 4) {
                    return null;
                }
                return Event.ON_DESTROY;
            }

            @JvmStatic
            @Nullable
            public final Event upFrom(@NotNull State state) {
                g0.p(state, "state");
                int i6 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
                if (i6 == 1) {
                    return Event.ON_START;
                }
                if (i6 == 2) {
                    return Event.ON_RESUME;
                }
                if (i6 != 5) {
                    return null;
                }
                return Event.ON_CREATE;
            }

            @JvmStatic
            @Nullable
            public final Event upTo(@NotNull State state) {
                g0.p(state, "state");
                int i6 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
                if (i6 == 1) {
                    return Event.ON_CREATE;
                }
                if (i6 == 2) {
                    return Event.ON_START;
                }
                if (i6 != 3) {
                    return null;
                }
                return Event.ON_RESUME;
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Event.values().length];
                try {
                    iArr[Event.ON_CREATE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Event.ON_STOP.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Event.ON_START.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[Event.ON_PAUSE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[Event.ON_RESUME.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[Event.ON_DESTROY.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[Event.ON_ANY.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        @JvmStatic
        @Nullable
        public static final Event downFrom(@NotNull State state) {
            return Companion.downFrom(state);
        }

        @JvmStatic
        @Nullable
        public static final Event downTo(@NotNull State state) {
            return Companion.downTo(state);
        }

        @JvmStatic
        @Nullable
        public static final Event upFrom(@NotNull State state) {
            return Companion.upFrom(state);
        }

        @JvmStatic
        @Nullable
        public static final Event upTo(@NotNull State state) {
            return Companion.upTo(state);
        }

        @NotNull
        public final State getTargetState() {
            switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
                case 1:
                case 2:
                    return State.CREATED;
                case 3:
                case 4:
                    return State.STARTED;
                case 5:
                    return State.RESUMED;
                case 6:
                    return State.DESTROYED;
                default:
                    throw new IllegalArgumentException(this + " has no target state");
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum State {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public final boolean isAtLeast(@NotNull State state) {
            g0.p(state, "state");
            return compareTo(state) >= 0;
        }
    }

    @MainThread
    public abstract void addObserver(@NotNull LifecycleObserver lifecycleObserver);

    @MainThread
    @NotNull
    public abstract State getCurrentState();

    @MainThread
    public abstract void removeObserver(@NotNull LifecycleObserver lifecycleObserver);

    @NotNull
    public final AtomicReference<Object> getInternalScopeRef() {
        return this.internalScopeRef;
    }

    public final void setInternalScopeRef(@NotNull AtomicReference<Object> atomicReference) {
        g0.p(atomicReference, "<set-?>");
        this.internalScopeRef = atomicReference;
    }
}
