package androidx.core.view;

import android.R;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class SoftwareKeyboardControllerCompat {
    private final Impl mImpl;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(20)
    static class Impl20 extends Impl {

        @Nullable
        private final View mView;

        @Override // androidx.core.view.SoftwareKeyboardControllerCompat.Impl
        void hide() {
            View view = this.mView;
            if (view != null) {
                ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.mView.getWindowToken(), 0);
            }
        }

        @Override // androidx.core.view.SoftwareKeyboardControllerCompat.Impl
        void show() {
            final View view = this.mView;
            if (view == null) {
                return;
            }
            if (view.isInEditMode() || view.onCheckIsTextEditor()) {
                view.requestFocus();
            } else {
                view = view.getRootView().findFocus();
            }
            if (view == null) {
                view = this.mView.getRootView().findViewById(R.id.content);
            }
            if (view == null || !view.hasWindowFocus()) {
                return;
            }
            view.post(new Runnable() { // from class: androidx.core.view.y
                @Override // java.lang.Runnable
                public final void run() {
                    ((InputMethodManager) r0.getContext().getSystemService("input_method")).showSoftInput(view, 0);
                }
            });
        }

        Impl20(@Nullable View view) {
            this.mView = view;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(30)
    static class Impl30 extends Impl20 {

        @Nullable
        private View mView;

        @Nullable
        private WindowInsetsController mWindowInsetsController;

        Impl30(@NonNull View view) {
            super(view);
            this.mView = view;
        }

        @Override // androidx.core.view.SoftwareKeyboardControllerCompat.Impl20, androidx.core.view.SoftwareKeyboardControllerCompat.Impl
        void hide() {
            int ime;
            View view;
            WindowInsetsController windowInsetsController = this.mWindowInsetsController;
            if (windowInsetsController == null) {
                View view2 = this.mView;
                windowInsetsController = view2 != null ? view2.getWindowInsetsController() : null;
            }
            if (windowInsetsController == null) {
                super.hide();
                return;
            }
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            WindowInsetsController.OnControllableInsetsChangedListener onControllableInsetsChangedListener = new WindowInsetsController.OnControllableInsetsChangedListener() { // from class: androidx.core.view.f0
                @Override // android.view.WindowInsetsController.OnControllableInsetsChangedListener
                public final void onControllableInsetsChanged(WindowInsetsController windowInsetsController2, int i6) {
                    atomicBoolean.set((r2 & 8) != 0);
                }
            };
            windowInsetsController.addOnControllableInsetsChangedListener(onControllableInsetsChangedListener);
            if (!atomicBoolean.get() && (view = this.mView) != null) {
                ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.mView.getWindowToken(), 0);
            }
            windowInsetsController.removeOnControllableInsetsChangedListener(onControllableInsetsChangedListener);
            ime = WindowInsets.Type.ime();
            windowInsetsController.hide(ime);
        }

        @Override // androidx.core.view.SoftwareKeyboardControllerCompat.Impl20, androidx.core.view.SoftwareKeyboardControllerCompat.Impl
        void show() {
            int ime;
            View view = this.mView;
            if (view != null && Build.VERSION.SDK_INT < 33) {
                ((InputMethodManager) view.getContext().getSystemService("input_method")).isActive();
            }
            WindowInsetsController windowInsetsController = this.mWindowInsetsController;
            if (windowInsetsController == null) {
                View view2 = this.mView;
                windowInsetsController = view2 != null ? view2.getWindowInsetsController() : null;
            }
            if (windowInsetsController != null) {
                ime = WindowInsets.Type.ime();
                windowInsetsController.show(ime);
            }
            super.show();
        }

        Impl30(@Nullable WindowInsetsController windowInsetsController) {
            super(null);
            this.mWindowInsetsController = windowInsetsController;
        }
    }

    public SoftwareKeyboardControllerCompat(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.mImpl = new Impl30(view);
        } else {
            this.mImpl = new Impl20(view);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class Impl {
        Impl() {
        }

        void hide() {
        }

        void show() {
        }
    }

    public void hide() {
        this.mImpl.hide();
    }

    public void show() {
        this.mImpl.show();
    }

    @RequiresApi(30)
    @Deprecated
    SoftwareKeyboardControllerCompat(@NonNull WindowInsetsController windowInsetsController) {
        this.mImpl = new Impl30(windowInsetsController);
    }
}
