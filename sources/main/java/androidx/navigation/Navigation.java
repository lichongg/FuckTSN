package androidx.navigation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class Navigation {
    @NonNull
    public static View.OnClickListener createNavigateOnClickListener(@IdRes int i6) {
        return createNavigateOnClickListener(i6, null);
    }

    @NonNull
    public static NavController findNavController(@NonNull Activity activity, @IdRes int i6) {
        NavController findViewNavController = findViewNavController(ActivityCompat.requireViewById(activity, i6));
        if (findViewNavController != null) {
            return findViewNavController;
        }
        throw new IllegalStateException("Activity " + activity + " does not have a NavController set on " + i6);
    }

    @Nullable
    private static NavController findViewNavController(@NonNull View view) {
        while (view != null) {
            NavController viewNavController = getViewNavController(view);
            if (viewNavController != null) {
                return viewNavController;
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return null;
    }

    @NonNull
    public static View.OnClickListener createNavigateOnClickListener(@IdRes final int i6, @Nullable final Bundle bundle) {
        return new View.OnClickListener() { // from class: androidx.navigation.Navigation.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(i6, bundle);
            }
        };
    }

    @Nullable
    private static NavController getViewNavController(@NonNull View view) {
        Object tag = view.getTag(R.id.nav_controller_view_tag);
        if (tag instanceof WeakReference) {
            return (NavController) ((WeakReference) tag).get();
        }
        if (tag instanceof NavController) {
            return (NavController) tag;
        }
        return null;
    }

    public static void setViewNavController(@NonNull View view, @Nullable NavController navController) {
        view.setTag(R.id.nav_controller_view_tag, navController);
    }

    private Navigation() {
    }

    @NonNull
    public static View.OnClickListener createNavigateOnClickListener(@NonNull final NavDirections navDirections) {
        return new View.OnClickListener() { // from class: androidx.navigation.Navigation.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(NavDirections.this);
            }
        };
    }

    @NonNull
    public static NavController findNavController(@NonNull View view) {
        NavController findViewNavController = findViewNavController(view);
        if (findViewNavController != null) {
            return findViewNavController;
        }
        throw new IllegalStateException("View " + view + " does not have a NavController set");
    }
}
