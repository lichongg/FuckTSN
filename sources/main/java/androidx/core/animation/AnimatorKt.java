package androidx.core.animation;

import android.animation.Animator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nAnimator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Animator.kt\nandroidx/core/animation/AnimatorKt\n*L\n1#1,123:1\n91#1,14:124\n91#1,14:138\n91#1,14:152\n91#1,14:166\n*S KotlinDebug\n*F\n+ 1 Animator.kt\nandroidx/core/animation/AnimatorKt\n*L\n30#1:124,14\n41#1:138,14\n52#1:152,14\n62#1:166,14\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class AnimatorKt {
    @NotNull
    public static final Animator.AnimatorPauseListener doOnPause(@NotNull Animator animator, @NotNull Function1<? super Animator, n1> function1) {
        return addPauseListener$default(animator, null, function1, 1, null);
    }

    @NotNull
    public static final Animator.AnimatorPauseListener doOnResume(@NotNull Animator animator, @NotNull Function1<? super Animator, n1> function1) {
        return addPauseListener$default(animator, function1, null, 2, null);
    }

    @NotNull
    public static final Animator.AnimatorListener addListener(@NotNull Animator animator, @NotNull Function1<? super Animator, n1> function1, @NotNull Function1<? super Animator, n1> function12, @NotNull Function1<? super Animator, n1> function13, @NotNull Function1<? super Animator, n1> function14) {
        AnimatorKt$addListener$listener$1 animatorKt$addListener$listener$1 = new AnimatorKt$addListener$listener$1(function14, function1, function13, function12);
        animator.addListener(animatorKt$addListener$listener$1);
        return animatorKt$addListener$listener$1;
    }

    public static /* synthetic */ Animator.AnimatorListener addListener$default(Animator animator, Function1 function1, Function1 function12, Function1 function13, Function1 function14, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            function1 = new Function1<Animator, n1>() { // from class: androidx.core.animation.AnimatorKt$addListener$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Animator animator2) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ n1 invoke(Animator animator2) {
                    invoke2(animator2);
                    return n1.f44123a;
                }
            };
        }
        if ((i6 & 2) != 0) {
            function12 = new Function1<Animator, n1>() { // from class: androidx.core.animation.AnimatorKt$addListener$2
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Animator animator2) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ n1 invoke(Animator animator2) {
                    invoke2(animator2);
                    return n1.f44123a;
                }
            };
        }
        if ((i6 & 4) != 0) {
            function13 = new Function1<Animator, n1>() { // from class: androidx.core.animation.AnimatorKt$addListener$3
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Animator animator2) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ n1 invoke(Animator animator2) {
                    invoke2(animator2);
                    return n1.f44123a;
                }
            };
        }
        if ((i6 & 8) != 0) {
            function14 = new Function1<Animator, n1>() { // from class: androidx.core.animation.AnimatorKt$addListener$4
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Animator animator2) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ n1 invoke(Animator animator2) {
                    invoke2(animator2);
                    return n1.f44123a;
                }
            };
        }
        AnimatorKt$addListener$listener$1 animatorKt$addListener$listener$1 = new AnimatorKt$addListener$listener$1(function14, function1, function13, function12);
        animator.addListener(animatorKt$addListener$listener$1);
        return animatorKt$addListener$listener$1;
    }

    @NotNull
    public static final Animator.AnimatorPauseListener addPauseListener(@NotNull Animator animator, @NotNull final Function1<? super Animator, n1> function1, @NotNull final Function1<? super Animator, n1> function12) {
        Animator.AnimatorPauseListener animatorPauseListener = new Animator.AnimatorPauseListener() { // from class: androidx.core.animation.AnimatorKt$addPauseListener$listener$1
            @Override // android.animation.Animator.AnimatorPauseListener
            public void onAnimationPause(@NotNull Animator animator2) {
                function12.invoke(animator2);
            }

            @Override // android.animation.Animator.AnimatorPauseListener
            public void onAnimationResume(@NotNull Animator animator2) {
                function1.invoke(animator2);
            }
        };
        animator.addPauseListener(animatorPauseListener);
        return animatorPauseListener;
    }

    public static /* synthetic */ Animator.AnimatorPauseListener addPauseListener$default(Animator animator, Function1 function1, Function1 function12, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            function1 = new Function1<Animator, n1>() { // from class: androidx.core.animation.AnimatorKt$addPauseListener$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Animator animator2) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ n1 invoke(Animator animator2) {
                    invoke2(animator2);
                    return n1.f44123a;
                }
            };
        }
        if ((i6 & 2) != 0) {
            function12 = new Function1<Animator, n1>() { // from class: androidx.core.animation.AnimatorKt$addPauseListener$2
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Animator animator2) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ n1 invoke(Animator animator2) {
                    invoke2(animator2);
                    return n1.f44123a;
                }
            };
        }
        return addPauseListener(animator, function1, function12);
    }

    @NotNull
    public static final Animator.AnimatorListener doOnCancel(@NotNull Animator animator, @NotNull final Function1<? super Animator, n1> function1) {
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: androidx.core.animation.AnimatorKt$doOnCancel$$inlined$addListener$default$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@NotNull Animator animator2) {
                Function1.this.invoke(animator2);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NotNull Animator animator2) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@NotNull Animator animator2) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@NotNull Animator animator2) {
            }
        };
        animator.addListener(animatorListener);
        return animatorListener;
    }

    @NotNull
    public static final Animator.AnimatorListener doOnEnd(@NotNull Animator animator, @NotNull final Function1<? super Animator, n1> function1) {
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: androidx.core.animation.AnimatorKt$doOnEnd$$inlined$addListener$default$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NotNull Animator animator2) {
                Function1.this.invoke(animator2);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@NotNull Animator animator2) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@NotNull Animator animator2) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@NotNull Animator animator2) {
            }
        };
        animator.addListener(animatorListener);
        return animatorListener;
    }

    @NotNull
    public static final Animator.AnimatorListener doOnRepeat(@NotNull Animator animator, @NotNull final Function1<? super Animator, n1> function1) {
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: androidx.core.animation.AnimatorKt$doOnRepeat$$inlined$addListener$default$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@NotNull Animator animator2) {
                Function1.this.invoke(animator2);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@NotNull Animator animator2) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NotNull Animator animator2) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@NotNull Animator animator2) {
            }
        };
        animator.addListener(animatorListener);
        return animatorListener;
    }

    @NotNull
    public static final Animator.AnimatorListener doOnStart(@NotNull Animator animator, @NotNull final Function1<? super Animator, n1> function1) {
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: androidx.core.animation.AnimatorKt$doOnStart$$inlined$addListener$default$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@NotNull Animator animator2) {
                Function1.this.invoke(animator2);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@NotNull Animator animator2) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NotNull Animator animator2) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@NotNull Animator animator2) {
            }
        };
        animator.addListener(animatorListener);
        return animatorListener;
    }
}
