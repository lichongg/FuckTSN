package androidx.navigation;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import androidx.annotation.IdRes;
import androidx.navigation.ActivityNavigator;
import kotlin.jvm.internal.g0;
import kotlin.reflect.d;
import l3.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@NavDestinationDsl
/* loaded from: D:\Downloads\app\classes.dex */
public final class ActivityNavigatorDestinationBuilder extends NavDestinationBuilder<ActivityNavigator.Destination> {

    @Nullable
    private String action;

    @Nullable
    private d<? extends Activity> activityClass;
    private final Context context;

    @Nullable
    private Uri data;

    @Nullable
    private String dataPattern;

    @Nullable
    private String targetPackage;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityNavigatorDestinationBuilder(@NotNull ActivityNavigator navigator, @IdRes int i6) {
        super(navigator, i6);
        g0.q(navigator, "navigator");
        Context context = navigator.getContext();
        g0.h(context, "navigator.context");
        this.context = context;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.navigation.NavDestinationBuilder
    @NotNull
    public ActivityNavigator.Destination build() {
        ActivityNavigator.Destination destination = (ActivityNavigator.Destination) super.build();
        destination.setTargetPackage(this.targetPackage);
        d<? extends Activity> dVar = this.activityClass;
        if (dVar != null) {
            destination.setComponentName(new ComponentName(this.context, (Class<?>) a.e(dVar)));
        }
        destination.setAction(this.action);
        destination.setData(this.data);
        destination.setDataPattern(this.dataPattern);
        return destination;
    }

    @Nullable
    public final String getAction() {
        return this.action;
    }

    @Nullable
    public final d<? extends Activity> getActivityClass() {
        return this.activityClass;
    }

    @Nullable
    public final Uri getData() {
        return this.data;
    }

    @Nullable
    public final String getDataPattern() {
        return this.dataPattern;
    }

    @Nullable
    public final String getTargetPackage() {
        return this.targetPackage;
    }

    public final void setAction(@Nullable String str) {
        this.action = str;
    }

    public final void setActivityClass(@Nullable d<? extends Activity> dVar) {
        this.activityClass = dVar;
    }

    public final void setData(@Nullable Uri uri) {
        this.data = uri;
    }

    public final void setDataPattern(@Nullable String str) {
        this.dataPattern = str;
    }

    public final void setTargetPackage(@Nullable String str) {
        this.targetPackage = str;
    }
}
