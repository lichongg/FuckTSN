package androidx.core.transition;

import android.transition.Transition;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nTransition.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Transition.kt\nandroidx/core/transition/TransitionKt\n*L\n1#1,76:1\n59#1,16:77\n59#1,16:93\n59#1,16:109\n59#1,16:125\n59#1,16:141\n*S KotlinDebug\n*F\n+ 1 Transition.kt\nandroidx/core/transition/TransitionKt\n*L\n26#1:77,16\n33#1:93,16\n40#1:109,16\n47#1:125,16\n54#1:141,16\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class TransitionKt {
    @NotNull
    public static final Transition.TransitionListener addListener(@NotNull Transition transition, @NotNull Function1<? super Transition, n1> function1, @NotNull Function1<? super Transition, n1> function12, @NotNull Function1<? super Transition, n1> function13, @NotNull Function1<? super Transition, n1> function14, @NotNull Function1<? super Transition, n1> function15) {
        TransitionKt$addListener$listener$1 transitionKt$addListener$listener$1 = new TransitionKt$addListener$listener$1(function1, function14, function15, function13, function12);
        transition.addListener(transitionKt$addListener$listener$1);
        return transitionKt$addListener$listener$1;
    }

    public static /* synthetic */ Transition.TransitionListener addListener$default(Transition transition, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            function1 = new Function1<Transition, n1>() { // from class: androidx.core.transition.TransitionKt$addListener$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Transition transition2) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ n1 invoke(Transition transition2) {
                    invoke2(transition2);
                    return n1.f44123a;
                }
            };
        }
        if ((i6 & 2) != 0) {
            function12 = new Function1<Transition, n1>() { // from class: androidx.core.transition.TransitionKt$addListener$2
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Transition transition2) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ n1 invoke(Transition transition2) {
                    invoke2(transition2);
                    return n1.f44123a;
                }
            };
        }
        Function1 function16 = function12;
        if ((i6 & 4) != 0) {
            function13 = new Function1<Transition, n1>() { // from class: androidx.core.transition.TransitionKt$addListener$3
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Transition transition2) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ n1 invoke(Transition transition2) {
                    invoke2(transition2);
                    return n1.f44123a;
                }
            };
        }
        if ((i6 & 8) != 0) {
            function14 = new Function1<Transition, n1>() { // from class: androidx.core.transition.TransitionKt$addListener$4
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Transition transition2) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ n1 invoke(Transition transition2) {
                    invoke2(transition2);
                    return n1.f44123a;
                }
            };
        }
        if ((i6 & 16) != 0) {
            function15 = new Function1<Transition, n1>() { // from class: androidx.core.transition.TransitionKt$addListener$5
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Transition transition2) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ n1 invoke(Transition transition2) {
                    invoke2(transition2);
                    return n1.f44123a;
                }
            };
        }
        TransitionKt$addListener$listener$1 transitionKt$addListener$listener$1 = new TransitionKt$addListener$listener$1(function1, function14, function15, function13, function16);
        transition.addListener(transitionKt$addListener$listener$1);
        return transitionKt$addListener$listener$1;
    }

    @NotNull
    public static final Transition.TransitionListener doOnCancel(@NotNull Transition transition, @NotNull final Function1<? super Transition, n1> function1) {
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnCancel$$inlined$addListener$default$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(@NotNull Transition transition2) {
                Function1.this.invoke(transition2);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(@NotNull Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(@NotNull Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(@NotNull Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(@NotNull Transition transition2) {
            }
        };
        transition.addListener(transitionListener);
        return transitionListener;
    }

    @NotNull
    public static final Transition.TransitionListener doOnEnd(@NotNull Transition transition, @NotNull final Function1<? super Transition, n1> function1) {
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnEnd$$inlined$addListener$default$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(@NotNull Transition transition2) {
                Function1.this.invoke(transition2);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(@NotNull Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(@NotNull Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(@NotNull Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(@NotNull Transition transition2) {
            }
        };
        transition.addListener(transitionListener);
        return transitionListener;
    }

    @NotNull
    public static final Transition.TransitionListener doOnPause(@NotNull Transition transition, @NotNull final Function1<? super Transition, n1> function1) {
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnPause$$inlined$addListener$default$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(@NotNull Transition transition2) {
                Function1.this.invoke(transition2);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(@NotNull Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(@NotNull Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(@NotNull Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(@NotNull Transition transition2) {
            }
        };
        transition.addListener(transitionListener);
        return transitionListener;
    }

    @NotNull
    public static final Transition.TransitionListener doOnResume(@NotNull Transition transition, @NotNull final Function1<? super Transition, n1> function1) {
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnResume$$inlined$addListener$default$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(@NotNull Transition transition2) {
                Function1.this.invoke(transition2);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(@NotNull Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(@NotNull Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(@NotNull Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(@NotNull Transition transition2) {
            }
        };
        transition.addListener(transitionListener);
        return transitionListener;
    }

    @NotNull
    public static final Transition.TransitionListener doOnStart(@NotNull Transition transition, @NotNull final Function1<? super Transition, n1> function1) {
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnStart$$inlined$addListener$default$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(@NotNull Transition transition2) {
                Function1.this.invoke(transition2);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(@NotNull Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(@NotNull Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(@NotNull Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(@NotNull Transition transition2) {
            }
        };
        transition.addListener(transitionListener);
        return transitionListener;
    }
}
