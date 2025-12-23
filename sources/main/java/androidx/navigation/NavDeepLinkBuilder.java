package androidx.navigation;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.IdRes;
import androidx.annotation.NavigationRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.TaskStackBuilder;
import androidx.navigation.Navigator;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import java.util.ArrayDeque;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class NavDeepLinkBuilder {
    private Bundle mArgs;
    private final Context mContext;
    private int mDestId;
    private NavGraph mGraph;
    private final Intent mIntent;

    public NavDeepLinkBuilder(@NonNull Context context) {
        this.mContext = context;
        if (context instanceof Activity) {
            this.mIntent = new Intent(context, context.getClass());
        } else {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            this.mIntent = launchIntentForPackage == null ? new Intent() : launchIntentForPackage;
        }
        this.mIntent.addFlags(268468224);
    }

    @NonNull
    public NavDeepLinkBuilder setComponentName(@NonNull Class<? extends Activity> cls) {
        return setComponentName(new ComponentName(this.mContext, cls));
    }

    @NonNull
    public NavDeepLinkBuilder setGraph(@NavigationRes int i6) {
        return setGraph(new NavInflater(this.mContext, new PermissiveNavigatorProvider()).inflate(i6));
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class PermissiveNavigatorProvider extends NavigatorProvider {
        private final Navigator<NavDestination> mDestNavigator = new Navigator<NavDestination>() { // from class: androidx.navigation.NavDeepLinkBuilder.PermissiveNavigatorProvider.1
            @Override // androidx.navigation.Navigator
            @NonNull
            public NavDestination createDestination() {
                return new NavDestination("permissive");
            }

            @Override // androidx.navigation.Navigator
            @Nullable
            public NavDestination navigate(@NonNull NavDestination navDestination, @Nullable Bundle bundle, @Nullable NavOptions navOptions, @Nullable Navigator.Extras extras) {
                throw new IllegalStateException("navigate is not supported");
            }

            @Override // androidx.navigation.Navigator
            public boolean popBackStack() {
                throw new IllegalStateException("popBackStack is not supported");
            }
        };

        PermissiveNavigatorProvider() {
            addNavigator(new NavGraphNavigator(this));
        }

        @Override // androidx.navigation.NavigatorProvider
        @NonNull
        public Navigator<? extends NavDestination> getNavigator(@NonNull String str) {
            try {
                return super.getNavigator(str);
            } catch (IllegalStateException unused) {
                return this.mDestNavigator;
            }
        }
    }

    private void fillInIntent() {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(this.mGraph);
        NavDestination navDestination = null;
        while (!arrayDeque.isEmpty() && navDestination == null) {
            NavDestination navDestination2 = (NavDestination) arrayDeque.poll();
            if (navDestination2.getId() == this.mDestId) {
                navDestination = navDestination2;
            } else if (navDestination2 instanceof NavGraph) {
                Iterator<NavDestination> it = ((NavGraph) navDestination2).iterator();
                while (it.hasNext()) {
                    arrayDeque.add(it.next());
                }
            }
        }
        if (navDestination != null) {
            this.mIntent.putExtra("android-support-nav:controller:deepLinkIds", navDestination.buildDeepLinkIds());
            return;
        }
        throw new IllegalArgumentException("Navigation destination " + NavDestination.getDisplayName(this.mContext, this.mDestId) + " cannot be found in the navigation graph " + this.mGraph);
    }

    @NonNull
    public PendingIntent createPendingIntent() {
        Bundle bundle = this.mArgs;
        int i6 = 0;
        if (bundle != null) {
            Iterator<String> it = bundle.keySet().iterator();
            int i7 = 0;
            while (it.hasNext()) {
                Object obj = this.mArgs.get(it.next());
                i7 = (i7 * 31) + (obj != null ? obj.hashCode() : 0);
            }
            i6 = i7;
        }
        return createTaskStackBuilder().getPendingIntent((i6 * 31) + this.mDestId, AMapEngineUtils.HALF_MAX_P20_WIDTH);
    }

    @NonNull
    public TaskStackBuilder createTaskStackBuilder() {
        if (this.mIntent.getIntArrayExtra("android-support-nav:controller:deepLinkIds") == null) {
            if (this.mGraph == null) {
                throw new IllegalStateException("You must call setGraph() before constructing the deep link");
            }
            throw new IllegalStateException("You must call setDestination() before constructing the deep link");
        }
        TaskStackBuilder addNextIntentWithParentStack = TaskStackBuilder.create(this.mContext).addNextIntentWithParentStack(new Intent(this.mIntent));
        for (int i6 = 0; i6 < addNextIntentWithParentStack.getIntentCount(); i6++) {
            addNextIntentWithParentStack.editIntentAt(i6).putExtra(NavController.KEY_DEEP_LINK_INTENT, this.mIntent);
        }
        return addNextIntentWithParentStack;
    }

    @NonNull
    public NavDeepLinkBuilder setArguments(@Nullable Bundle bundle) {
        this.mArgs = bundle;
        this.mIntent.putExtra("android-support-nav:controller:deepLinkExtras", bundle);
        return this;
    }

    @NonNull
    public NavDeepLinkBuilder setComponentName(@NonNull ComponentName componentName) {
        this.mIntent.setComponent(componentName);
        return this;
    }

    @NonNull
    public NavDeepLinkBuilder setDestination(@IdRes int i6) {
        this.mDestId = i6;
        if (this.mGraph != null) {
            fillInIntent();
        }
        return this;
    }

    @NonNull
    public NavDeepLinkBuilder setGraph(@NonNull NavGraph navGraph) {
        this.mGraph = navGraph;
        if (this.mDestId != 0) {
            fillInIntent();
        }
        return this;
    }

    NavDeepLinkBuilder(@NonNull NavController navController) {
        this(navController.getContext());
        this.mGraph = navController.getGraph();
    }
}
