package com.kwad.sdk.mvp;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.o.m;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.d;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class Presenter {
    private Object aTA;
    private View mRootView;
    private final List<Presenter> aTz = new CopyOnWriteArrayList();
    private PresenterState aTB = PresenterState.INIT;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.sdk.mvp.Presenter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'INIT' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static abstract class PresenterState {
        private static final /* synthetic */ PresenterState[] $VALUES;
        public static final PresenterState BIND;
        public static final PresenterState CREATE;
        public static final PresenterState DESTROY;
        public static final PresenterState INIT;
        public static final PresenterState UNBIND;
        private int mIndex;

        /* synthetic */ PresenterState(String str, int i6, int i7, AnonymousClass1 anonymousClass1) {
            this(str, i6, i7);
        }

        abstract void performCallState(Presenter presenter);

        static {
            int i6 = 0;
            PresenterState presenterState = new PresenterState("INIT", i6, i6) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.1
                {
                    AnonymousClass1 anonymousClass1 = null;
                }

                @Override // com.kwad.sdk.mvp.Presenter.PresenterState
                public final void performCallState(Presenter presenter) {
                }
            };
            INIT = presenterState;
            int i7 = 1;
            PresenterState presenterState2 = new PresenterState("CREATE", i7, i7) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.2
                {
                    AnonymousClass1 anonymousClass1 = null;
                }

                @Override // com.kwad.sdk.mvp.Presenter.PresenterState
                public final void performCallState(Presenter presenter) {
                    Iterator it = presenter.aTz.iterator();
                    while (it.hasNext()) {
                        try {
                            ((Presenter) it.next()).K(presenter.mRootView);
                        } catch (Exception e6) {
                            d.gatherException(e6);
                            c.printStackTrace(e6);
                        }
                    }
                }
            };
            CREATE = presenterState2;
            int i8 = 2;
            PresenterState presenterState3 = new PresenterState("BIND", i8, i8) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.3
                {
                    AnonymousClass1 anonymousClass1 = null;
                }

                @Override // com.kwad.sdk.mvp.Presenter.PresenterState
                final void performCallState(Presenter presenter) {
                    Iterator it = presenter.aTz.iterator();
                    while (it.hasNext()) {
                        try {
                            ((Presenter) it.next()).n(presenter.aTA);
                        } catch (Throwable th) {
                            d.gatherException(th);
                            c.printStackTrace(th);
                        }
                    }
                }
            };
            BIND = presenterState3;
            int i9 = 3;
            PresenterState presenterState4 = new PresenterState("UNBIND", i9, i9) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.4
                {
                    AnonymousClass1 anonymousClass1 = null;
                }

                @Override // com.kwad.sdk.mvp.Presenter.PresenterState
                final void performCallState(Presenter presenter) {
                    Iterator it = presenter.aTz.iterator();
                    while (it.hasNext()) {
                        try {
                            ((Presenter) it.next()).ny();
                        } catch (Exception e6) {
                            d.gatherException(e6);
                            c.printStackTrace(e6);
                        }
                    }
                }
            };
            UNBIND = presenterState4;
            int i10 = 4;
            PresenterState presenterState5 = new PresenterState("DESTROY", i10, i10) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.5
                {
                    AnonymousClass1 anonymousClass1 = null;
                }

                @Override // com.kwad.sdk.mvp.Presenter.PresenterState
                final void performCallState(Presenter presenter) {
                    Iterator it = presenter.aTz.iterator();
                    while (it.hasNext()) {
                        try {
                            ((Presenter) it.next()).destroy();
                        } catch (Exception e6) {
                            d.gatherException(e6);
                            c.printStackTrace(e6);
                        }
                    }
                }
            };
            DESTROY = presenterState5;
            $VALUES = new PresenterState[]{presenterState, presenterState2, presenterState3, presenterState4, presenterState5};
        }

        private PresenterState(String str, int i6, int i7) {
            this.mIndex = i7;
        }

        public static PresenterState valueOf(String str) {
            return (PresenterState) Enum.valueOf(PresenterState.class, str);
        }

        public static PresenterState[] values() {
            return (PresenterState[]) $VALUES.clone();
        }

        public int index() {
            return this.mIndex;
        }
    }

    public final void a(Presenter presenter) {
        this.aTz.add(presenter);
        if (!NL() || presenter.NL()) {
            return;
        }
        K(this.mRootView);
    }

    private boolean NL() {
        return this.aTB.index() >= PresenterState.CREATE.index();
    }

    private void b(Presenter presenter) {
        Object obj;
        View view;
        int index = this.aTB.index();
        PresenterState presenterState = PresenterState.UNBIND;
        if (index >= presenterState.index() || presenter.aTB.index() >= presenterState.index()) {
            return;
        }
        if (NL() && !presenter.NL() && (view = this.mRootView) != null) {
            presenter.K(view);
        }
        if (!isBound() || !presenter.NL() || presenter.isBound() || (obj = this.aTA) == null) {
            return;
        }
        presenter.n(obj);
    }

    private boolean isBound() {
        return this.aTB == PresenterState.BIND;
    }

    @UiThread
    public final void K(View view) {
        try {
            this.aTB = PresenterState.CREATE;
            this.mRootView = view;
            onCreate();
            this.aTB.performCallState(this);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final List<Presenter> NM() {
        return this.aTz;
    }

    public final Object NN() {
        return this.aTA;
    }

    @UiThread
    public final void destroy() {
        try {
            if (this.aTB == PresenterState.BIND) {
                ny();
            }
            this.aTB = PresenterState.DESTROY;
            onDestroy();
            this.aTB.performCallState(this);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final <T extends View> T findViewById(int i6) {
        return (T) this.mRootView.findViewById(i6);
    }

    @NonNull
    public final Context getContext() {
        return this.mRootView.getContext();
    }

    public final View getRootView() {
        return this.mRootView;
    }

    @UiThread
    public final void n(@NonNull Object obj) {
        try {
            PresenterState presenterState = this.aTB;
            if (presenterState != PresenterState.INIT) {
                PresenterState presenterState2 = PresenterState.DESTROY;
            }
            PresenterState presenterState3 = PresenterState.BIND;
            if (presenterState == presenterState3) {
                ny();
            }
            this.aTB = presenterState3;
            this.aTA = obj;
            at();
            this.aTB.performCallState(this);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @UiThread
    public final void ny() {
        try {
            this.aTB = PresenterState.UNBIND;
            onUnbind();
            this.aTB.performCallState(this);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Nullable
    @UiThread
    public final Activity getActivity() {
        return m.ej(getContext());
    }

    public final void a(Presenter presenter, boolean z5) {
        this.aTz.add(presenter);
        try {
            b(presenter);
        } catch (Throwable th) {
            d.gatherException(th);
            c.printStackTrace(th);
        }
    }

    protected void at() {
    }

    protected void onCreate() {
    }

    protected void onDestroy() {
    }

    protected void onUnbind() {
    }
}
