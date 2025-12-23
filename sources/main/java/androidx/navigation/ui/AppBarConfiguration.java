package androidx.navigation.ui;

import android.annotation.SuppressLint;
import android.view.Menu;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.customview.widget.Openable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavGraph;
import java.util.HashSet;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class AppBarConfiguration {

    @Nullable
    private final OnNavigateUpListener mFallbackOnNavigateUpListener;

    @Nullable
    private final Openable mOpenableLayout;

    @NonNull
    private final Set<Integer> mTopLevelDestinations;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Builder {

        @Nullable
        private OnNavigateUpListener mFallbackOnNavigateUpListener;

        @Nullable
        private Openable mOpenableLayout;

        @NonNull
        private final Set<Integer> mTopLevelDestinations;

        public Builder(@NonNull NavGraph navGraph) {
            HashSet hashSet = new HashSet();
            this.mTopLevelDestinations = hashSet;
            hashSet.add(Integer.valueOf(NavigationUI.findStartDestination(navGraph).getId()));
        }

        @NonNull
        @SuppressLint({"SyntheticAccessor"})
        public AppBarConfiguration build() {
            return new AppBarConfiguration(this.mTopLevelDestinations, this.mOpenableLayout, this.mFallbackOnNavigateUpListener);
        }

        @NonNull
        @Deprecated
        public Builder setDrawerLayout(@Nullable DrawerLayout drawerLayout) {
            this.mOpenableLayout = drawerLayout;
            return this;
        }

        @NonNull
        public Builder setFallbackOnNavigateUpListener(@Nullable OnNavigateUpListener onNavigateUpListener) {
            this.mFallbackOnNavigateUpListener = onNavigateUpListener;
            return this;
        }

        @NonNull
        public Builder setOpenableLayout(@Nullable Openable openable) {
            this.mOpenableLayout = openable;
            return this;
        }

        public Builder(@NonNull Menu menu) {
            this.mTopLevelDestinations = new HashSet();
            int size = menu.size();
            for (int i6 = 0; i6 < size; i6++) {
                this.mTopLevelDestinations.add(Integer.valueOf(menu.getItem(i6).getItemId()));
            }
        }

        public Builder(@NonNull int... iArr) {
            this.mTopLevelDestinations = new HashSet();
            for (int i6 : iArr) {
                this.mTopLevelDestinations.add(Integer.valueOf(i6));
            }
        }

        public Builder(@NonNull Set<Integer> set) {
            HashSet hashSet = new HashSet();
            this.mTopLevelDestinations = hashSet;
            hashSet.addAll(set);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface OnNavigateUpListener {
        boolean onNavigateUp();
    }

    private AppBarConfiguration(@NonNull Set<Integer> set, @Nullable Openable openable, @Nullable OnNavigateUpListener onNavigateUpListener) {
        this.mTopLevelDestinations = set;
        this.mOpenableLayout = openable;
        this.mFallbackOnNavigateUpListener = onNavigateUpListener;
    }

    @Nullable
    @Deprecated
    public DrawerLayout getDrawerLayout() {
        Openable openable = this.mOpenableLayout;
        if (openable instanceof DrawerLayout) {
            return (DrawerLayout) openable;
        }
        return null;
    }

    @Nullable
    public OnNavigateUpListener getFallbackOnNavigateUpListener() {
        return this.mFallbackOnNavigateUpListener;
    }

    @Nullable
    public Openable getOpenableLayout() {
        return this.mOpenableLayout;
    }

    @NonNull
    public Set<Integer> getTopLevelDestinations() {
        return this.mTopLevelDestinations;
    }
}
