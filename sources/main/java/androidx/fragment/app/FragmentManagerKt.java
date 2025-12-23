package androidx.fragment.app;

import kotlin.Deprecated;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class FragmentManagerKt {
    public static final void commit(@NotNull FragmentManager commit, boolean z5, @NotNull Function1<? super FragmentTransaction, n1> body) {
        g0.q(commit, "$this$commit");
        g0.q(body, "body");
        FragmentTransaction beginTransaction = commit.beginTransaction();
        g0.h(beginTransaction, "beginTransaction()");
        body.invoke(beginTransaction);
        if (z5) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }

    public static /* synthetic */ void commit$default(FragmentManager commit, boolean z5, Function1 body, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            z5 = false;
        }
        g0.q(commit, "$this$commit");
        g0.q(body, "body");
        FragmentTransaction beginTransaction = commit.beginTransaction();
        g0.h(beginTransaction, "beginTransaction()");
        body.invoke(beginTransaction);
        if (z5) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }

    public static final void commitNow(@NotNull FragmentManager commitNow, boolean z5, @NotNull Function1<? super FragmentTransaction, n1> body) {
        g0.q(commitNow, "$this$commitNow");
        g0.q(body, "body");
        FragmentTransaction beginTransaction = commitNow.beginTransaction();
        g0.h(beginTransaction, "beginTransaction()");
        body.invoke(beginTransaction);
        if (z5) {
            beginTransaction.commitNowAllowingStateLoss();
        } else {
            beginTransaction.commitNow();
        }
    }

    public static /* synthetic */ void commitNow$default(FragmentManager commitNow, boolean z5, Function1 body, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            z5 = false;
        }
        g0.q(commitNow, "$this$commitNow");
        g0.q(body, "body");
        FragmentTransaction beginTransaction = commitNow.beginTransaction();
        g0.h(beginTransaction, "beginTransaction()");
        body.invoke(beginTransaction);
        if (z5) {
            beginTransaction.commitNowAllowingStateLoss();
        } else {
            beginTransaction.commitNow();
        }
    }

    @Deprecated(message = "Use commit { .. } or commitNow { .. } extensions")
    public static final void transaction(@NotNull FragmentManager transaction, boolean z5, boolean z6, @NotNull Function1<? super FragmentTransaction, n1> body) {
        g0.q(transaction, "$this$transaction");
        g0.q(body, "body");
        FragmentTransaction beginTransaction = transaction.beginTransaction();
        g0.h(beginTransaction, "beginTransaction()");
        body.invoke(beginTransaction);
        if (z5) {
            if (z6) {
                beginTransaction.commitNowAllowingStateLoss();
                return;
            } else {
                beginTransaction.commitNow();
                return;
            }
        }
        if (z6) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }

    public static /* synthetic */ void transaction$default(FragmentManager transaction, boolean z5, boolean z6, Function1 body, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            z5 = false;
        }
        if ((i6 & 2) != 0) {
            z6 = false;
        }
        g0.q(transaction, "$this$transaction");
        g0.q(body, "body");
        FragmentTransaction beginTransaction = transaction.beginTransaction();
        g0.h(beginTransaction, "beginTransaction()");
        body.invoke(beginTransaction);
        if (z5) {
            if (z6) {
                beginTransaction.commitNowAllowingStateLoss();
                return;
            } else {
                beginTransaction.commitNow();
                return;
            }
        }
        if (z6) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }
}
