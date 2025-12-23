package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigator;
import androidx.navigation.NavigatorProvider;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Navigator.Name("fragment")
/* loaded from: D:\Downloads\app\classes.dex */
public class FragmentNavigator extends Navigator<Destination> {
    private static final String KEY_BACK_STACK_IDS = "androidx-nav-fragment:navigator:backStackIds";
    private static final String TAG = "FragmentNavigator";
    private ArrayDeque<Integer> mBackStack = new ArrayDeque<>();
    private final int mContainerId;
    private final Context mContext;
    private final FragmentManager mFragmentManager;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @NavDestination.ClassType(Fragment.class)
    public static class Destination extends NavDestination {
        private String mClassName;

        public Destination(@NonNull NavigatorProvider navigatorProvider) {
            this((Navigator<? extends Destination>) navigatorProvider.getNavigator(FragmentNavigator.class));
        }

        public Destination(@NonNull Navigator<? extends Destination> navigator) {
            super(navigator);
        }

        @NonNull
        public final String getClassName() {
            String str = this.mClassName;
            if (str != null) {
                return str;
            }
            throw new IllegalStateException("Fragment class was not set");
        }

        @NonNull
        public final Destination setClassName(@NonNull String str) {
            this.mClassName = str;
            return this;
        }

        @Override // androidx.navigation.NavDestination
        @NonNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            sb.append(" class=");
            String str = this.mClassName;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            return sb.toString();
        }

        @Override // androidx.navigation.NavDestination
        @CallSuper
        public void onInflate(@NonNull Context context, @NonNull AttributeSet attributeSet) {
            super.onInflate(context, attributeSet);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.FragmentNavigator);
            String string = obtainAttributes.getString(R.styleable.FragmentNavigator_android_name);
            if (string != null) {
                setClassName(string);
            }
            obtainAttributes.recycle();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Extras implements Navigator.Extras {
        private final LinkedHashMap<View, String> mSharedElements;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class Builder {
            private final LinkedHashMap<View, String> mSharedElements = new LinkedHashMap<>();

            @NonNull
            public Builder addSharedElement(@NonNull View view, @NonNull String str) {
                this.mSharedElements.put(view, str);
                return this;
            }

            @NonNull
            public Extras build() {
                return new Extras(this.mSharedElements);
            }

            @NonNull
            public Builder addSharedElements(@NonNull Map<View, String> map) {
                for (Map.Entry<View, String> entry : map.entrySet()) {
                    View key = entry.getKey();
                    String value = entry.getValue();
                    if (key != null && value != null) {
                        addSharedElement(key, value);
                    }
                }
                return this;
            }
        }

        @NonNull
        public Map<View, String> getSharedElements() {
            return Collections.unmodifiableMap(this.mSharedElements);
        }

        Extras(Map<View, String> map) {
            LinkedHashMap<View, String> linkedHashMap = new LinkedHashMap<>();
            this.mSharedElements = linkedHashMap;
            linkedHashMap.putAll(map);
        }
    }

    @NonNull
    private String generateBackStackName(int i6, int i7) {
        return i6 + "-" + i7;
    }

    @Override // androidx.navigation.Navigator
    @NonNull
    public Destination createDestination() {
        return new Destination(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x012d A[RETURN] */
    @Override // androidx.navigation.Navigator
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public androidx.navigation.NavDestination navigate(@androidx.annotation.NonNull androidx.navigation.fragment.FragmentNavigator.Destination r9, @androidx.annotation.Nullable android.os.Bundle r10, @androidx.annotation.Nullable androidx.navigation.NavOptions r11, @androidx.annotation.Nullable androidx.navigation.Navigator.Extras r12) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.fragment.FragmentNavigator.navigate(androidx.navigation.fragment.FragmentNavigator$Destination, android.os.Bundle, androidx.navigation.NavOptions, androidx.navigation.Navigator$Extras):androidx.navigation.NavDestination");
    }

    @Override // androidx.navigation.Navigator
    public void onRestoreState(@Nullable Bundle bundle) {
        int[] intArray;
        if (bundle == null || (intArray = bundle.getIntArray(KEY_BACK_STACK_IDS)) == null) {
            return;
        }
        this.mBackStack.clear();
        for (int i6 : intArray) {
            this.mBackStack.add(Integer.valueOf(i6));
        }
    }

    @Override // androidx.navigation.Navigator
    @Nullable
    public Bundle onSaveState() {
        Bundle bundle = new Bundle();
        int[] iArr = new int[this.mBackStack.size()];
        Iterator<Integer> it = this.mBackStack.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            iArr[i6] = it.next().intValue();
            i6++;
        }
        bundle.putIntArray(KEY_BACK_STACK_IDS, iArr);
        return bundle;
    }

    @Override // androidx.navigation.Navigator
    public boolean popBackStack() {
        if (this.mBackStack.isEmpty() || this.mFragmentManager.isStateSaved()) {
            return false;
        }
        this.mFragmentManager.popBackStack(generateBackStackName(this.mBackStack.size(), this.mBackStack.peekLast().intValue()), 1);
        this.mBackStack.removeLast();
        return true;
    }

    public FragmentNavigator(@NonNull Context context, @NonNull FragmentManager fragmentManager, int i6) {
        this.mContext = context;
        this.mFragmentManager = fragmentManager;
        this.mContainerId = i6;
    }

    @NonNull
    @Deprecated
    public Fragment instantiateFragment(@NonNull Context context, @NonNull FragmentManager fragmentManager, @NonNull String str, @Nullable Bundle bundle) {
        return fragmentManager.getFragmentFactory().instantiate(context.getClassLoader(), str);
    }
}
