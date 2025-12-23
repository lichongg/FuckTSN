package androidx.navigation.ui;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.core.app.NotificationCompat;
import androidx.customview.widget.Openable;
import androidx.navigation.FloatingWindow;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import java.lang.ref.WeakReference;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: D:\Downloads\app\classes.dex */
abstract class AbstractAppBarOnDestinationChangedListener implements NavController.OnDestinationChangedListener {
    private ValueAnimator mAnimator;
    private DrawerArrowDrawable mArrowDrawable;
    private final Context mContext;

    @Nullable
    private final WeakReference<Openable> mOpenableLayoutWeakReference;
    private final Set<Integer> mTopLevelDestinations;

    protected abstract void setNavigationIcon(Drawable drawable, @StringRes int i6);

    protected abstract void setTitle(CharSequence charSequence);

    private void setActionBarUpIndicator(boolean z5) {
        boolean z6;
        if (this.mArrowDrawable == null) {
            this.mArrowDrawable = new DrawerArrowDrawable(this.mContext);
            z6 = false;
        } else {
            z6 = true;
        }
        setNavigationIcon(this.mArrowDrawable, z5 ? R.string.nav_app_bar_open_drawer_description : R.string.nav_app_bar_navigate_up_description);
        float f6 = z5 ? 0.0f : 1.0f;
        if (!z6) {
            this.mArrowDrawable.setProgress(f6);
            return;
        }
        float progress = this.mArrowDrawable.getProgress();
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mArrowDrawable, NotificationCompat.CATEGORY_PROGRESS, progress, f6);
        this.mAnimator = ofFloat;
        ofFloat.start();
    }

    @Override // androidx.navigation.NavController.OnDestinationChangedListener
    public void onDestinationChanged(@NonNull NavController navController, @NonNull NavDestination navDestination, @Nullable Bundle bundle) {
        if (navDestination instanceof FloatingWindow) {
            return;
        }
        WeakReference<Openable> weakReference = this.mOpenableLayoutWeakReference;
        Openable openable = weakReference != null ? weakReference.get() : null;
        if (this.mOpenableLayoutWeakReference != null && openable == null) {
            navController.removeOnDestinationChangedListener(this);
            return;
        }
        CharSequence label = navDestination.getLabel();
        if (label != null) {
            StringBuffer stringBuffer = new StringBuffer();
            Matcher matcher = Pattern.compile("\\{(.+?)\\}").matcher(label);
            while (matcher.find()) {
                String group = matcher.group(1);
                if (bundle == null || !bundle.containsKey(group)) {
                    throw new IllegalArgumentException("Could not find " + group + " in " + bundle + " to fill label " + ((Object) label));
                }
                matcher.appendReplacement(stringBuffer, "");
                stringBuffer.append(bundle.get(group).toString());
            }
            matcher.appendTail(stringBuffer);
            setTitle(stringBuffer);
        }
        boolean matchDestinations = NavigationUI.matchDestinations(navDestination, this.mTopLevelDestinations);
        if (openable == null && matchDestinations) {
            setNavigationIcon(null, 0);
        } else {
            setActionBarUpIndicator(openable != null && matchDestinations);
        }
    }

    AbstractAppBarOnDestinationChangedListener(@NonNull Context context, @NonNull AppBarConfiguration appBarConfiguration) {
        this.mContext = context;
        this.mTopLevelDestinations = appBarConfiguration.getTopLevelDestinations();
        Openable openableLayout = appBarConfiguration.getOpenableLayout();
        if (openableLayout != null) {
            this.mOpenableLayoutWeakReference = new WeakReference<>(openableLayout);
        } else {
            this.mOpenableLayoutWeakReference = null;
        }
    }
}
