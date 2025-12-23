package androidx.navigation;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigator;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Navigator.Name(TTDownloadField.TT_ACTIVITY)
/* loaded from: D:\Downloads\app\classes.dex */
public class ActivityNavigator extends Navigator<Destination> {
    private static final String EXTRA_NAV_CURRENT = "android-support-navigation:ActivityNavigator:current";
    private static final String EXTRA_NAV_SOURCE = "android-support-navigation:ActivityNavigator:source";
    private static final String EXTRA_POP_ENTER_ANIM = "android-support-navigation:ActivityNavigator:popEnterAnim";
    private static final String EXTRA_POP_EXIT_ANIM = "android-support-navigation:ActivityNavigator:popExitAnim";
    private static final String LOG_TAG = "ActivityNavigator";
    private Context mContext;
    private Activity mHostActivity;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @NavDestination.ClassType(Activity.class)
    public static class Destination extends NavDestination {
        private String mDataPattern;
        private Intent mIntent;

        public Destination(@NonNull NavigatorProvider navigatorProvider) {
            this((Navigator<? extends Destination>) navigatorProvider.getNavigator(ActivityNavigator.class));
        }

        @Override // androidx.navigation.NavDestination
        boolean supportsActions() {
            return false;
        }

        public Destination(@NonNull Navigator<? extends Destination> navigator) {
            super(navigator);
        }

        @Nullable
        public final String getAction() {
            Intent intent = this.mIntent;
            if (intent == null) {
                return null;
            }
            return intent.getAction();
        }

        @Nullable
        public final ComponentName getComponent() {
            Intent intent = this.mIntent;
            if (intent == null) {
                return null;
            }
            return intent.getComponent();
        }

        @Nullable
        public final Uri getData() {
            Intent intent = this.mIntent;
            if (intent == null) {
                return null;
            }
            return intent.getData();
        }

        @Nullable
        public final String getDataPattern() {
            return this.mDataPattern;
        }

        @Nullable
        public final Intent getIntent() {
            return this.mIntent;
        }

        @Nullable
        public final String getTargetPackage() {
            Intent intent = this.mIntent;
            if (intent == null) {
                return null;
            }
            return intent.getPackage();
        }

        @NonNull
        public final Destination setAction(@Nullable String str) {
            if (this.mIntent == null) {
                this.mIntent = new Intent();
            }
            this.mIntent.setAction(str);
            return this;
        }

        @NonNull
        public final Destination setComponentName(@Nullable ComponentName componentName) {
            if (this.mIntent == null) {
                this.mIntent = new Intent();
            }
            this.mIntent.setComponent(componentName);
            return this;
        }

        @NonNull
        public final Destination setData(@Nullable Uri uri) {
            if (this.mIntent == null) {
                this.mIntent = new Intent();
            }
            this.mIntent.setData(uri);
            return this;
        }

        @NonNull
        public final Destination setDataPattern(@Nullable String str) {
            this.mDataPattern = str;
            return this;
        }

        @NonNull
        public final Destination setIntent(@Nullable Intent intent) {
            this.mIntent = intent;
            return this;
        }

        @NonNull
        public final Destination setTargetPackage(@Nullable String str) {
            if (this.mIntent == null) {
                this.mIntent = new Intent();
            }
            this.mIntent.setPackage(str);
            return this;
        }

        @Override // androidx.navigation.NavDestination
        @CallSuper
        public void onInflate(@NonNull Context context, @NonNull AttributeSet attributeSet) {
            super.onInflate(context, attributeSet);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.ActivityNavigator);
            String string = obtainAttributes.getString(R.styleable.ActivityNavigator_targetPackage);
            if (string != null) {
                string = string.replace(NavInflater.APPLICATION_ID_PLACEHOLDER, context.getPackageName());
            }
            setTargetPackage(string);
            String string2 = obtainAttributes.getString(R.styleable.ActivityNavigator_android_name);
            if (string2 != null) {
                if (string2.charAt(0) == '.') {
                    string2 = context.getPackageName() + string2;
                }
                setComponentName(new ComponentName(context, string2));
            }
            setAction(obtainAttributes.getString(R.styleable.ActivityNavigator_action));
            String string3 = obtainAttributes.getString(R.styleable.ActivityNavigator_data);
            if (string3 != null) {
                setData(Uri.parse(string3));
            }
            setDataPattern(obtainAttributes.getString(R.styleable.ActivityNavigator_dataPattern));
            obtainAttributes.recycle();
        }

        @Override // androidx.navigation.NavDestination
        @NonNull
        public String toString() {
            ComponentName component = getComponent();
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            if (component != null) {
                sb.append(" class=");
                sb.append(component.getClassName());
            } else {
                String action = getAction();
                if (action != null) {
                    sb.append(" action=");
                    sb.append(action);
                }
            }
            return sb.toString();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Extras implements Navigator.Extras {
        private final ActivityOptionsCompat mActivityOptions;
        private final int mFlags;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class Builder {
            private ActivityOptionsCompat mActivityOptions;
            private int mFlags;

            @NonNull
            public Builder addFlags(int i6) {
                this.mFlags = i6 | this.mFlags;
                return this;
            }

            @NonNull
            public Extras build() {
                return new Extras(this.mFlags, this.mActivityOptions);
            }

            @NonNull
            public Builder setActivityOptions(@NonNull ActivityOptionsCompat activityOptionsCompat) {
                this.mActivityOptions = activityOptionsCompat;
                return this;
            }
        }

        @Nullable
        public ActivityOptionsCompat getActivityOptions() {
            return this.mActivityOptions;
        }

        public int getFlags() {
            return this.mFlags;
        }

        Extras(int i6, @Nullable ActivityOptionsCompat activityOptionsCompat) {
            this.mFlags = i6;
            this.mActivityOptions = activityOptionsCompat;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.navigation.Navigator
    @NonNull
    public Destination createDestination() {
        return new Destination(this);
    }

    @NonNull
    final Context getContext() {
        return this.mContext;
    }

    @Override // androidx.navigation.Navigator
    @Nullable
    public NavDestination navigate(@NonNull Destination destination, @Nullable Bundle bundle, @Nullable NavOptions navOptions, @Nullable Navigator.Extras extras) {
        Intent intent;
        int intExtra;
        if (destination.getIntent() == null) {
            throw new IllegalStateException("Destination " + destination.getId() + " does not have an Intent set.");
        }
        Intent intent2 = new Intent(destination.getIntent());
        if (bundle != null) {
            intent2.putExtras(bundle);
            String dataPattern = destination.getDataPattern();
            if (!TextUtils.isEmpty(dataPattern)) {
                StringBuffer stringBuffer = new StringBuffer();
                Matcher matcher = Pattern.compile("\\{(.+?)\\}").matcher(dataPattern);
                while (matcher.find()) {
                    String group = matcher.group(1);
                    if (!bundle.containsKey(group)) {
                        throw new IllegalArgumentException("Could not find " + group + " in " + bundle + " to fill data pattern " + dataPattern);
                    }
                    matcher.appendReplacement(stringBuffer, "");
                    stringBuffer.append(Uri.encode(bundle.get(group).toString()));
                }
                matcher.appendTail(stringBuffer);
                intent2.setData(Uri.parse(stringBuffer.toString()));
            }
        }
        boolean z5 = extras instanceof Extras;
        if (z5) {
            intent2.addFlags(((Extras) extras).getFlags());
        }
        if (!(this.mContext instanceof Activity)) {
            intent2.addFlags(268435456);
        }
        if (navOptions != null && navOptions.shouldLaunchSingleTop()) {
            intent2.addFlags(536870912);
        }
        Activity activity = this.mHostActivity;
        if (activity != null && (intent = activity.getIntent()) != null && (intExtra = intent.getIntExtra(EXTRA_NAV_CURRENT, 0)) != 0) {
            intent2.putExtra(EXTRA_NAV_SOURCE, intExtra);
        }
        intent2.putExtra(EXTRA_NAV_CURRENT, destination.getId());
        Resources resources = getContext().getResources();
        if (navOptions != null) {
            int popEnterAnim = navOptions.getPopEnterAnim();
            int popExitAnim = navOptions.getPopExitAnim();
            if ((popEnterAnim <= 0 || !resources.getResourceTypeName(popEnterAnim).equals("animator")) && (popExitAnim <= 0 || !resources.getResourceTypeName(popExitAnim).equals("animator"))) {
                intent2.putExtra(EXTRA_POP_ENTER_ANIM, popEnterAnim);
                intent2.putExtra(EXTRA_POP_EXIT_ANIM, popExitAnim);
            } else {
                resources.getResourceName(popEnterAnim);
                resources.getResourceName(popExitAnim);
                destination.toString();
            }
        }
        if (z5) {
            ActivityOptionsCompat activityOptions = ((Extras) extras).getActivityOptions();
            if (activityOptions != null) {
                ContextCompat.startActivity(this.mContext, intent2, activityOptions.toBundle());
            } else {
                this.mContext.startActivity(intent2);
            }
        } else {
            this.mContext.startActivity(intent2);
        }
        if (navOptions == null || this.mHostActivity == null) {
            return null;
        }
        int enterAnim = navOptions.getEnterAnim();
        int exitAnim = navOptions.getExitAnim();
        if ((enterAnim > 0 && resources.getResourceTypeName(enterAnim).equals("animator")) || (exitAnim > 0 && resources.getResourceTypeName(exitAnim).equals("animator"))) {
            resources.getResourceName(enterAnim);
            resources.getResourceName(exitAnim);
            destination.toString();
            return null;
        }
        if (enterAnim < 0 && exitAnim < 0) {
            return null;
        }
        this.mHostActivity.overridePendingTransition(Math.max(enterAnim, 0), Math.max(exitAnim, 0));
        return null;
    }

    @Override // androidx.navigation.Navigator
    public boolean popBackStack() {
        Activity activity = this.mHostActivity;
        if (activity == null) {
            return false;
        }
        activity.finish();
        return true;
    }

    public ActivityNavigator(@NonNull Context context) {
        this.mContext = context;
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                this.mHostActivity = (Activity) context;
                return;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
    }

    public static void applyPopAnimationsToPendingTransition(@NonNull Activity activity) {
        Intent intent = activity.getIntent();
        if (intent != null) {
            int intExtra = intent.getIntExtra(EXTRA_POP_ENTER_ANIM, -1);
            int intExtra2 = intent.getIntExtra(EXTRA_POP_EXIT_ANIM, -1);
            if (intExtra == -1 && intExtra2 == -1) {
                return;
            }
            if (intExtra == -1) {
                intExtra = 0;
            }
            if (intExtra2 == -1) {
                intExtra2 = 0;
            }
            activity.overridePendingTransition(intExtra, intExtra2);
        }
    }
}
