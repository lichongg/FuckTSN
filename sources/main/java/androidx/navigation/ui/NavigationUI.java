package androidx.navigation.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.widget.Openable;
import androidx.navigation.ActivityNavigator;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.NavOptions;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.navigation.NavigationView;
import java.lang.ref.WeakReference;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class NavigationUI {
    public static boolean navigateUp(@NonNull NavController navController, @Nullable Openable openable) {
        return navigateUp(navController, new AppBarConfiguration.Builder(navController.getGraph()).setOpenableLayout(openable).build());
    }

    public static void setupActionBarWithNavController(@NonNull AppCompatActivity appCompatActivity, @NonNull NavController navController) {
        setupActionBarWithNavController(appCompatActivity, navController, new AppBarConfiguration.Builder(navController.getGraph()).build());
    }

    public static void setupWithNavController(@NonNull Toolbar toolbar, @NonNull NavController navController) {
        setupWithNavController(toolbar, navController, new AppBarConfiguration.Builder(navController.getGraph()).build());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [androidx.navigation.NavDestination] */
    static NavDestination findStartDestination(@NonNull NavGraph navGraph) {
        NavGraph navGraph2 = navGraph;
        while (navGraph2 instanceof NavGraph) {
            NavGraph navGraph3 = navGraph2;
            navGraph2 = navGraph3.findNode(navGraph3.getStartDestination());
        }
        return navGraph2;
    }

    public static boolean onNavDestinationSelected(@NonNull MenuItem menuItem, @NonNull NavController navController) {
        NavOptions.Builder launchSingleTop = new NavOptions.Builder().setLaunchSingleTop(true);
        if (navController.getCurrentDestination().getParent().findNode(menuItem.getItemId()) instanceof ActivityNavigator.Destination) {
            launchSingleTop.setEnterAnim(R.anim.nav_default_enter_anim).setExitAnim(R.anim.nav_default_exit_anim).setPopEnterAnim(R.anim.nav_default_pop_enter_anim).setPopExitAnim(R.anim.nav_default_pop_exit_anim);
        } else {
            launchSingleTop.setEnterAnim(R.animator.nav_default_enter_anim).setExitAnim(R.animator.nav_default_exit_anim).setPopEnterAnim(R.animator.nav_default_pop_enter_anim).setPopExitAnim(R.animator.nav_default_pop_exit_anim);
        }
        if ((menuItem.getOrder() & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            launchSingleTop.setPopUpTo(findStartDestination(navController.getGraph()).getId(), false);
        }
        try {
            navController.navigate(menuItem.getItemId(), (Bundle) null, launchSingleTop.build());
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    private NavigationUI() {
    }

    static BottomSheetBehavior findBottomSheetBehavior(@NonNull View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof CoordinatorLayout.LayoutParams)) {
            Object parent = view.getParent();
            if (!(parent instanceof View)) {
                return null;
            }
            return findBottomSheetBehavior((View) parent);
        }
        CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
        if (!(behavior instanceof BottomSheetBehavior)) {
            return null;
        }
        return (BottomSheetBehavior) behavior;
    }

    static boolean matchDestination(@NonNull NavDestination navDestination, @IdRes int i6) {
        while (navDestination.getId() != i6 && navDestination.getParent() != null) {
            navDestination = navDestination.getParent();
        }
        if (navDestination.getId() == i6) {
            return true;
        }
        return false;
    }

    static boolean matchDestinations(@NonNull NavDestination navDestination, @NonNull Set<Integer> set) {
        while (!set.contains(Integer.valueOf(navDestination.getId()))) {
            navDestination = navDestination.getParent();
            if (navDestination == null) {
                return false;
            }
        }
        return true;
    }

    public static void setupWithNavController(@NonNull Toolbar toolbar, @NonNull NavController navController, @Nullable Openable openable) {
        setupWithNavController(toolbar, navController, new AppBarConfiguration.Builder(navController.getGraph()).setOpenableLayout(openable).build());
    }

    public static boolean navigateUp(@NonNull NavController navController, @NonNull AppBarConfiguration appBarConfiguration) {
        Openable openableLayout = appBarConfiguration.getOpenableLayout();
        NavDestination currentDestination = navController.getCurrentDestination();
        Set<Integer> topLevelDestinations = appBarConfiguration.getTopLevelDestinations();
        if (openableLayout != null && currentDestination != null && matchDestinations(currentDestination, topLevelDestinations)) {
            openableLayout.open();
            return true;
        }
        if (navController.navigateUp()) {
            return true;
        }
        if (appBarConfiguration.getFallbackOnNavigateUpListener() != null) {
            return appBarConfiguration.getFallbackOnNavigateUpListener().onNavigateUp();
        }
        return false;
    }

    public static void setupActionBarWithNavController(@NonNull AppCompatActivity appCompatActivity, @NonNull NavController navController, @Nullable Openable openable) {
        setupActionBarWithNavController(appCompatActivity, navController, new AppBarConfiguration.Builder(navController.getGraph()).setOpenableLayout(openable).build());
    }

    public static void setupWithNavController(@NonNull Toolbar toolbar, @NonNull final NavController navController, @NonNull final AppBarConfiguration appBarConfiguration) {
        navController.addOnDestinationChangedListener(new ToolbarOnDestinationChangedListener(toolbar, appBarConfiguration));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: androidx.navigation.ui.NavigationUI.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NavigationUI.navigateUp(NavController.this, appBarConfiguration);
            }
        });
    }

    public static void setupActionBarWithNavController(@NonNull AppCompatActivity appCompatActivity, @NonNull NavController navController, @NonNull AppBarConfiguration appBarConfiguration) {
        navController.addOnDestinationChangedListener(new ActionBarOnDestinationChangedListener(appCompatActivity, appBarConfiguration));
    }

    public static void setupWithNavController(@NonNull CollapsingToolbarLayout collapsingToolbarLayout, @NonNull Toolbar toolbar, @NonNull NavController navController) {
        setupWithNavController(collapsingToolbarLayout, toolbar, navController, new AppBarConfiguration.Builder(navController.getGraph()).build());
    }

    public static void setupWithNavController(@NonNull CollapsingToolbarLayout collapsingToolbarLayout, @NonNull Toolbar toolbar, @NonNull NavController navController, @Nullable Openable openable) {
        setupWithNavController(collapsingToolbarLayout, toolbar, navController, new AppBarConfiguration.Builder(navController.getGraph()).setOpenableLayout(openable).build());
    }

    public static void setupWithNavController(@NonNull CollapsingToolbarLayout collapsingToolbarLayout, @NonNull Toolbar toolbar, @NonNull final NavController navController, @NonNull final AppBarConfiguration appBarConfiguration) {
        navController.addOnDestinationChangedListener(new CollapsingToolbarOnDestinationChangedListener(collapsingToolbarLayout, toolbar, appBarConfiguration));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: androidx.navigation.ui.NavigationUI.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NavigationUI.navigateUp(NavController.this, appBarConfiguration);
            }
        });
    }

    public static void setupWithNavController(@NonNull final NavigationView navigationView, @NonNull final NavController navController) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() { // from class: androidx.navigation.ui.NavigationUI.3
            @Override // com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                boolean onNavDestinationSelected = NavigationUI.onNavDestinationSelected(menuItem, NavController.this);
                if (onNavDestinationSelected) {
                    ViewParent parent = navigationView.getParent();
                    if (parent instanceof Openable) {
                        ((Openable) parent).close();
                        return onNavDestinationSelected;
                    }
                    BottomSheetBehavior findBottomSheetBehavior = NavigationUI.findBottomSheetBehavior(navigationView);
                    if (findBottomSheetBehavior != null) {
                        findBottomSheetBehavior.setState(5);
                    }
                }
                return onNavDestinationSelected;
            }
        });
        final WeakReference weakReference = new WeakReference(navigationView);
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() { // from class: androidx.navigation.ui.NavigationUI.4
            @Override // androidx.navigation.NavController.OnDestinationChangedListener
            public void onDestinationChanged(@NonNull NavController navController2, @NonNull NavDestination navDestination, @Nullable Bundle bundle) {
                NavigationView navigationView2 = (NavigationView) weakReference.get();
                if (navigationView2 == null) {
                    navController.removeOnDestinationChangedListener(this);
                    return;
                }
                Menu menu = navigationView2.getMenu();
                int size = menu.size();
                for (int i6 = 0; i6 < size; i6++) {
                    MenuItem item = menu.getItem(i6);
                    item.setChecked(NavigationUI.matchDestination(navDestination, item.getItemId()));
                }
            }
        });
    }

    public static void setupWithNavController(@NonNull BottomNavigationView bottomNavigationView, @NonNull final NavController navController) {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() { // from class: androidx.navigation.ui.NavigationUI.5
            @Override // com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                return NavigationUI.onNavDestinationSelected(menuItem, NavController.this);
            }
        });
        final WeakReference weakReference = new WeakReference(bottomNavigationView);
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() { // from class: androidx.navigation.ui.NavigationUI.6
            @Override // androidx.navigation.NavController.OnDestinationChangedListener
            public void onDestinationChanged(@NonNull NavController navController2, @NonNull NavDestination navDestination, @Nullable Bundle bundle) {
                BottomNavigationView bottomNavigationView2 = (BottomNavigationView) weakReference.get();
                if (bottomNavigationView2 == null) {
                    navController.removeOnDestinationChangedListener(this);
                    return;
                }
                Menu menu = bottomNavigationView2.getMenu();
                int size = menu.size();
                for (int i6 = 0; i6 < size; i6++) {
                    MenuItem item = menu.getItem(i6);
                    if (NavigationUI.matchDestination(navDestination, item.getItemId())) {
                        item.setChecked(true);
                    }
                }
            }
        });
    }
}
