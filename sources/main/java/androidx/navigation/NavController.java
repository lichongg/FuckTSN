package androidx.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.annotation.CallSuper;
import androidx.annotation.IdRes;
import androidx.annotation.NavigationRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.app.TaskStackBuilder;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class NavController {
    private static final String KEY_BACK_STACK = "android-support-nav:controller:backStack";
    static final String KEY_DEEP_LINK_EXTRAS = "android-support-nav:controller:deepLinkExtras";
    static final String KEY_DEEP_LINK_HANDLED = "android-support-nav:controller:deepLinkHandled";
    static final String KEY_DEEP_LINK_IDS = "android-support-nav:controller:deepLinkIds";

    @NonNull
    public static final String KEY_DEEP_LINK_INTENT = "android-support-nav:controller:deepLinkIntent";
    private static final String KEY_NAVIGATOR_STATE = "android-support-nav:controller:navigatorState";
    private static final String KEY_NAVIGATOR_STATE_NAMES = "android-support-nav:controller:navigatorState:names";
    private static final String TAG = "NavController";
    private Activity mActivity;
    private Parcelable[] mBackStackToRestore;
    private final Context mContext;
    private boolean mDeepLinkHandled;
    NavGraph mGraph;
    private NavInflater mInflater;
    private LifecycleOwner mLifecycleOwner;
    private Bundle mNavigatorStateToRestore;
    private NavControllerViewModel mViewModel;
    final Deque<NavBackStackEntry> mBackStack = new ArrayDeque();
    private NavigatorProvider mNavigatorProvider = new NavigatorProvider();
    private final CopyOnWriteArrayList<OnDestinationChangedListener> mOnDestinationChangedListeners = new CopyOnWriteArrayList<>();
    private final LifecycleObserver mLifecycleObserver = new LifecycleEventObserver() { // from class: androidx.navigation.NavController.1
        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
            NavController navController = NavController.this;
            if (navController.mGraph != null) {
                Iterator<NavBackStackEntry> it = navController.mBackStack.iterator();
                while (it.hasNext()) {
                    it.next().handleLifecycleEvent(event);
                }
            }
        }
    };
    private final OnBackPressedCallback mOnBackPressedCallback = new OnBackPressedCallback(false) { // from class: androidx.navigation.NavController.2
        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackPressed() {
            NavController.this.popBackStack();
        }
    };
    private boolean mEnableOnBackPressedCallback = true;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface OnDestinationChangedListener {
        void onDestinationChanged(@NonNull NavController navController, @NonNull NavDestination navDestination, @Nullable Bundle bundle);
    }

    public boolean handleDeepLink(@Nullable Intent intent) {
        NavDestination.DeepLinkMatch matchDeepLink;
        NavGraph navGraph;
        if (intent == null) {
            return false;
        }
        Bundle extras = intent.getExtras();
        int[] intArray = extras != null ? extras.getIntArray(KEY_DEEP_LINK_IDS) : null;
        Bundle bundle = new Bundle();
        Bundle bundle2 = extras != null ? extras.getBundle(KEY_DEEP_LINK_EXTRAS) : null;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        if ((intArray == null || intArray.length == 0) && intent.getData() != null && (matchDeepLink = this.mGraph.matchDeepLink(new NavDeepLinkRequest(intent))) != null) {
            NavDestination destination = matchDeepLink.getDestination();
            int[] buildDeepLinkIds = destination.buildDeepLinkIds();
            bundle.putAll(destination.addInDefaultArgs(matchDeepLink.getMatchingArgs()));
            intArray = buildDeepLinkIds;
        }
        if (intArray == null || intArray.length == 0) {
            return false;
        }
        if (findInvalidDestinationDisplayNameInDeepLink(intArray) != null) {
            intent.toString();
            return false;
        }
        bundle.putParcelable(KEY_DEEP_LINK_INTENT, intent);
        int flags = intent.getFlags();
        int i6 = 268435456 & flags;
        if (i6 != 0 && (flags & 32768) == 0) {
            intent.addFlags(32768);
            TaskStackBuilder.create(this.mContext).addNextIntentWithParentStack(intent).startActivities();
            Activity activity = this.mActivity;
            if (activity != null) {
                activity.finish();
                this.mActivity.overridePendingTransition(0, 0);
            }
            return true;
        }
        if (i6 != 0) {
            if (!this.mBackStack.isEmpty()) {
                popBackStackInternal(this.mGraph.getId(), true);
            }
            int i7 = 0;
            while (i7 < intArray.length) {
                int i8 = i7 + 1;
                int i9 = intArray[i7];
                NavDestination findDestination = findDestination(i9);
                if (findDestination == null) {
                    throw new IllegalStateException("Deep Linking failed: destination " + NavDestination.getDisplayName(this.mContext, i9) + " cannot be found from the current destination " + getCurrentDestination());
                }
                navigate(findDestination, bundle, new NavOptions.Builder().setEnterAnim(0).setExitAnim(0).build(), (Navigator.Extras) null);
                i7 = i8;
            }
            return true;
        }
        NavGraph navGraph2 = this.mGraph;
        int i10 = 0;
        while (i10 < intArray.length) {
            int i11 = intArray[i10];
            NavDestination findNode = i10 == 0 ? this.mGraph : navGraph2.findNode(i11);
            if (findNode == null) {
                throw new IllegalStateException("Deep Linking failed: destination " + NavDestination.getDisplayName(this.mContext, i11) + " cannot be found in graph " + navGraph2);
            }
            if (i10 != intArray.length - 1) {
                while (true) {
                    navGraph = (NavGraph) findNode;
                    if (!(navGraph.findNode(navGraph.getStartDestination()) instanceof NavGraph)) {
                        break;
                    }
                    findNode = navGraph.findNode(navGraph.getStartDestination());
                }
                navGraph2 = navGraph;
            } else {
                navigate(findNode, findNode.addInDefaultArgs(bundle), new NavOptions.Builder().setPopUpTo(this.mGraph.getId(), true).setEnterAnim(0).setExitAnim(0).build(), (Navigator.Extras) null);
            }
            i10++;
        }
        this.mDeepLinkHandled = true;
        return true;
    }

    public void navigate(@IdRes int i6) {
        navigate(i6, (Bundle) null);
    }

    public boolean popBackStack() {
        if (this.mBackStack.isEmpty()) {
            return false;
        }
        return popBackStack(getCurrentDestination().getId(), true);
    }

    @CallSuper
    public void setGraph(@NavigationRes int i6) {
        setGraph(i6, (Bundle) null);
    }

    private boolean dispatchOnDestinationChanged() {
        NavDestination navDestination;
        while (!this.mBackStack.isEmpty() && (this.mBackStack.peekLast().getDestination() instanceof NavGraph) && popBackStackInternal(this.mBackStack.peekLast().getDestination().getId(), true)) {
        }
        if (this.mBackStack.isEmpty()) {
            return false;
        }
        NavDestination destination = this.mBackStack.peekLast().getDestination();
        if (destination instanceof FloatingWindow) {
            Iterator<NavBackStackEntry> descendingIterator = this.mBackStack.descendingIterator();
            while (descendingIterator.hasNext()) {
                navDestination = descendingIterator.next().getDestination();
                if (!(navDestination instanceof NavGraph) && !(navDestination instanceof FloatingWindow)) {
                    break;
                }
            }
        }
        navDestination = null;
        HashMap hashMap = new HashMap();
        Iterator<NavBackStackEntry> descendingIterator2 = this.mBackStack.descendingIterator();
        while (descendingIterator2.hasNext()) {
            NavBackStackEntry next = descendingIterator2.next();
            Lifecycle.State maxLifecycle = next.getMaxLifecycle();
            NavDestination destination2 = next.getDestination();
            if (destination != null && destination2.getId() == destination.getId()) {
                Lifecycle.State state = Lifecycle.State.RESUMED;
                if (maxLifecycle != state) {
                    hashMap.put(next, state);
                }
                destination = destination.getParent();
            } else if (navDestination == null || destination2.getId() != navDestination.getId()) {
                next.setMaxLifecycle(Lifecycle.State.CREATED);
            } else {
                if (maxLifecycle == Lifecycle.State.RESUMED) {
                    next.setMaxLifecycle(Lifecycle.State.STARTED);
                } else {
                    Lifecycle.State state2 = Lifecycle.State.STARTED;
                    if (maxLifecycle != state2) {
                        hashMap.put(next, state2);
                    }
                }
                navDestination = navDestination.getParent();
            }
        }
        for (NavBackStackEntry navBackStackEntry : this.mBackStack) {
            Lifecycle.State state3 = (Lifecycle.State) hashMap.get(navBackStackEntry);
            if (state3 != null) {
                navBackStackEntry.setMaxLifecycle(state3);
            } else {
                navBackStackEntry.updateState();
            }
        }
        NavBackStackEntry peekLast = this.mBackStack.peekLast();
        Iterator<OnDestinationChangedListener> it = this.mOnDestinationChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().onDestinationChanged(this, peekLast.getDestination(), peekLast.getArguments());
        }
        return true;
    }

    @Nullable
    private String findInvalidDestinationDisplayNameInDeepLink(@NonNull int[] iArr) {
        NavGraph navGraph;
        NavGraph navGraph2 = this.mGraph;
        int i6 = 0;
        while (true) {
            NavDestination navDestination = null;
            if (i6 >= iArr.length) {
                return null;
            }
            int i7 = iArr[i6];
            if (i6 != 0) {
                navDestination = navGraph2.findNode(i7);
            } else if (this.mGraph.getId() == i7) {
                navDestination = this.mGraph;
            }
            if (navDestination == null) {
                return NavDestination.getDisplayName(this.mContext, i7);
            }
            if (i6 != iArr.length - 1) {
                while (true) {
                    navGraph = (NavGraph) navDestination;
                    if (!(navGraph.findNode(navGraph.getStartDestination()) instanceof NavGraph)) {
                        break;
                    }
                    navDestination = navGraph.findNode(navGraph.getStartDestination());
                }
                navGraph2 = navGraph;
            }
            i6++;
        }
    }

    private int getDestinationCountOnBackStack() {
        Iterator<NavBackStackEntry> it = this.mBackStack.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            if (!(it.next().getDestination() instanceof NavGraph)) {
                i6++;
            }
        }
        return i6;
    }

    private void onGraphCreated(@Nullable Bundle bundle) {
        Activity activity;
        ArrayList<String> stringArrayList;
        Bundle bundle2 = this.mNavigatorStateToRestore;
        if (bundle2 != null && (stringArrayList = bundle2.getStringArrayList(KEY_NAVIGATOR_STATE_NAMES)) != null) {
            Iterator<String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                Navigator navigator = this.mNavigatorProvider.getNavigator(next);
                Bundle bundle3 = this.mNavigatorStateToRestore.getBundle(next);
                if (bundle3 != null) {
                    navigator.onRestoreState(bundle3);
                }
            }
        }
        Parcelable[] parcelableArr = this.mBackStackToRestore;
        if (parcelableArr != null) {
            for (Parcelable parcelable : parcelableArr) {
                NavBackStackEntryState navBackStackEntryState = (NavBackStackEntryState) parcelable;
                NavDestination findDestination = findDestination(navBackStackEntryState.getDestinationId());
                if (findDestination == null) {
                    throw new IllegalStateException("Restoring the Navigation back stack failed: destination " + NavDestination.getDisplayName(this.mContext, navBackStackEntryState.getDestinationId()) + " cannot be found from the current destination " + getCurrentDestination());
                }
                Bundle args = navBackStackEntryState.getArgs();
                if (args != null) {
                    args.setClassLoader(this.mContext.getClassLoader());
                }
                this.mBackStack.add(new NavBackStackEntry(this.mContext, findDestination, args, this.mLifecycleOwner, this.mViewModel, navBackStackEntryState.getUUID(), navBackStackEntryState.getSavedState()));
            }
            updateOnBackPressedCallbackEnabled();
            this.mBackStackToRestore = null;
        }
        if (this.mGraph == null || !this.mBackStack.isEmpty()) {
            dispatchOnDestinationChanged();
        } else if (this.mDeepLinkHandled || (activity = this.mActivity) == null || !handleDeepLink(activity.getIntent())) {
            navigate(this.mGraph, bundle, (NavOptions) null, (Navigator.Extras) null);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000b, code lost:
    
        if (getDestinationCountOnBackStack() > 1) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void updateOnBackPressedCallbackEnabled() {
        /*
            r3 = this;
            androidx.activity.OnBackPressedCallback r0 = r3.mOnBackPressedCallback
            boolean r1 = r3.mEnableOnBackPressedCallback
            if (r1 == 0) goto Le
            int r1 = r3.getDestinationCountOnBackStack()
            r2 = 1
            if (r1 <= r2) goto Le
            goto Lf
        Le:
            r2 = 0
        Lf:
            r0.setEnabled(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.updateOnBackPressedCallbackEnabled():void");
    }

    public void addOnDestinationChangedListener(@NonNull OnDestinationChangedListener onDestinationChangedListener) {
        if (!this.mBackStack.isEmpty()) {
            NavBackStackEntry peekLast = this.mBackStack.peekLast();
            onDestinationChangedListener.onDestinationChanged(this, peekLast.getDestination(), peekLast.getArguments());
        }
        this.mOnDestinationChangedListeners.add(onDestinationChangedListener);
    }

    @NonNull
    public NavDeepLinkBuilder createDeepLink() {
        return new NavDeepLinkBuilder(this);
    }

    void enableOnBackPressed(boolean z5) {
        this.mEnableOnBackPressedCallback = z5;
        updateOnBackPressedCallbackEnabled();
    }

    NavDestination findDestination(@IdRes int i6) {
        NavGraph navGraph = this.mGraph;
        if (navGraph == null) {
            return null;
        }
        if (navGraph.getId() == i6) {
            return this.mGraph;
        }
        NavGraph destination = this.mBackStack.isEmpty() ? this.mGraph : this.mBackStack.getLast().getDestination();
        return (destination instanceof NavGraph ? destination : destination.getParent()).findNode(i6);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Deque<NavBackStackEntry> getBackStack() {
        return this.mBackStack;
    }

    @NonNull
    public NavBackStackEntry getBackStackEntry(@IdRes int i6) {
        NavBackStackEntry navBackStackEntry;
        Iterator<NavBackStackEntry> descendingIterator = this.mBackStack.descendingIterator();
        while (true) {
            if (!descendingIterator.hasNext()) {
                navBackStackEntry = null;
                break;
            }
            navBackStackEntry = descendingIterator.next();
            if (navBackStackEntry.getDestination().getId() == i6) {
                break;
            }
        }
        if (navBackStackEntry != null) {
            return navBackStackEntry;
        }
        throw new IllegalArgumentException("No destination with ID " + i6 + " is on the NavController's back stack. The current destination is " + getCurrentDestination());
    }

    @NonNull
    Context getContext() {
        return this.mContext;
    }

    @Nullable
    public NavBackStackEntry getCurrentBackStackEntry() {
        if (this.mBackStack.isEmpty()) {
            return null;
        }
        return this.mBackStack.getLast();
    }

    @NonNull
    public NavGraph getGraph() {
        NavGraph navGraph = this.mGraph;
        if (navGraph != null) {
            return navGraph;
        }
        throw new IllegalStateException("You must call setGraph() before calling getGraph()");
    }

    @NonNull
    public NavInflater getNavInflater() {
        if (this.mInflater == null) {
            this.mInflater = new NavInflater(this.mContext, this.mNavigatorProvider);
        }
        return this.mInflater;
    }

    @NonNull
    public NavigatorProvider getNavigatorProvider() {
        return this.mNavigatorProvider;
    }

    @Nullable
    public NavBackStackEntry getPreviousBackStackEntry() {
        Iterator<NavBackStackEntry> descendingIterator = this.mBackStack.descendingIterator();
        if (descendingIterator.hasNext()) {
            descendingIterator.next();
        }
        while (descendingIterator.hasNext()) {
            NavBackStackEntry next = descendingIterator.next();
            if (!(next.getDestination() instanceof NavGraph)) {
                return next;
            }
        }
        return null;
    }

    @NonNull
    public ViewModelStoreOwner getViewModelStoreOwner(@IdRes int i6) {
        if (this.mViewModel == null) {
            throw new IllegalStateException("You must call setViewModelStore() before calling getViewModelStoreOwner().");
        }
        NavBackStackEntry backStackEntry = getBackStackEntry(i6);
        if (backStackEntry.getDestination() instanceof NavGraph) {
            return backStackEntry;
        }
        throw new IllegalArgumentException("No NavGraph with ID " + i6 + " is on the NavController's back stack");
    }

    public void navigate(@IdRes int i6, @Nullable Bundle bundle) {
        navigate(i6, bundle, (NavOptions) null);
    }

    boolean popBackStackInternal(@IdRes int i6, boolean z5) {
        boolean z6 = false;
        if (this.mBackStack.isEmpty()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<NavBackStackEntry> descendingIterator = this.mBackStack.descendingIterator();
        while (descendingIterator.hasNext()) {
            NavDestination destination = descendingIterator.next().getDestination();
            Navigator navigator = this.mNavigatorProvider.getNavigator(destination.getNavigatorName());
            if (z5 || destination.getId() != i6) {
                arrayList.add(navigator);
            }
            if (destination.getId() == i6) {
                Iterator it = arrayList.iterator();
                while (it.hasNext() && ((Navigator) it.next()).popBackStack()) {
                    NavBackStackEntry removeLast = this.mBackStack.removeLast();
                    if (removeLast.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
                        removeLast.setMaxLifecycle(Lifecycle.State.DESTROYED);
                    }
                    NavControllerViewModel navControllerViewModel = this.mViewModel;
                    if (navControllerViewModel != null) {
                        navControllerViewModel.clear(removeLast.mId);
                    }
                    z6 = true;
                }
                updateOnBackPressedCallbackEnabled();
                return z6;
            }
        }
        NavDestination.getDisplayName(this.mContext, i6);
        return false;
    }

    public void removeOnDestinationChangedListener(@NonNull OnDestinationChangedListener onDestinationChangedListener) {
        this.mOnDestinationChangedListeners.remove(onDestinationChangedListener);
    }

    @CallSuper
    public void restoreState(@Nullable Bundle bundle) {
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(this.mContext.getClassLoader());
        this.mNavigatorStateToRestore = bundle.getBundle(KEY_NAVIGATOR_STATE);
        this.mBackStackToRestore = bundle.getParcelableArray(KEY_BACK_STACK);
        this.mDeepLinkHandled = bundle.getBoolean(KEY_DEEP_LINK_HANDLED);
    }

    @Nullable
    @CallSuper
    public Bundle saveState() {
        Bundle bundle;
        ArrayList<String> arrayList = new ArrayList<>();
        Bundle bundle2 = new Bundle();
        for (Map.Entry<String, Navigator<? extends NavDestination>> entry : this.mNavigatorProvider.getNavigators().entrySet()) {
            String key = entry.getKey();
            Bundle onSaveState = entry.getValue().onSaveState();
            if (onSaveState != null) {
                arrayList.add(key);
                bundle2.putBundle(key, onSaveState);
            }
        }
        if (arrayList.isEmpty()) {
            bundle = null;
        } else {
            bundle = new Bundle();
            bundle2.putStringArrayList(KEY_NAVIGATOR_STATE_NAMES, arrayList);
            bundle.putBundle(KEY_NAVIGATOR_STATE, bundle2);
        }
        if (!this.mBackStack.isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            Parcelable[] parcelableArr = new Parcelable[this.mBackStack.size()];
            Iterator<NavBackStackEntry> it = this.mBackStack.iterator();
            int i6 = 0;
            while (it.hasNext()) {
                parcelableArr[i6] = new NavBackStackEntryState(it.next());
                i6++;
            }
            bundle.putParcelableArray(KEY_BACK_STACK, parcelableArr);
        }
        if (this.mDeepLinkHandled) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean(KEY_DEEP_LINK_HANDLED, this.mDeepLinkHandled);
        }
        return bundle;
    }

    @CallSuper
    public void setGraph(@NavigationRes int i6, @Nullable Bundle bundle) {
        setGraph(getNavInflater().inflate(i6), bundle);
    }

    void setLifecycleOwner(@NonNull LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner == this.mLifecycleOwner) {
            return;
        }
        this.mLifecycleOwner = lifecycleOwner;
        lifecycleOwner.getLifecycle().addObserver(this.mLifecycleObserver);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setNavigatorProvider(@NonNull NavigatorProvider navigatorProvider) {
        if (!this.mBackStack.isEmpty()) {
            throw new IllegalStateException("NavigatorProvider must be set before setGraph call");
        }
        this.mNavigatorProvider = navigatorProvider;
    }

    void setOnBackPressedDispatcher(@NonNull OnBackPressedDispatcher onBackPressedDispatcher) {
        if (this.mLifecycleOwner == null) {
            throw new IllegalStateException("You must call setLifecycleOwner() before calling setOnBackPressedDispatcher()");
        }
        this.mOnBackPressedCallback.remove();
        onBackPressedDispatcher.addCallback(this.mLifecycleOwner, this.mOnBackPressedCallback);
        this.mLifecycleOwner.getLifecycle().removeObserver(this.mLifecycleObserver);
        this.mLifecycleOwner.getLifecycle().addObserver(this.mLifecycleObserver);
    }

    void setViewModelStore(@NonNull ViewModelStore viewModelStore) {
        if (this.mViewModel == NavControllerViewModel.getInstance(viewModelStore)) {
            return;
        }
        if (!this.mBackStack.isEmpty()) {
            throw new IllegalStateException("ViewModelStore should be set before setGraph call");
        }
        this.mViewModel = NavControllerViewModel.getInstance(viewModelStore);
    }

    public NavController(@NonNull Context context) {
        this.mContext = context;
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                break;
            }
            if (context instanceof Activity) {
                this.mActivity = (Activity) context;
                break;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        NavigatorProvider navigatorProvider = this.mNavigatorProvider;
        navigatorProvider.addNavigator(new NavGraphNavigator(navigatorProvider));
        this.mNavigatorProvider.addNavigator(new ActivityNavigator(this.mContext));
    }

    @Nullable
    public NavDestination getCurrentDestination() {
        NavBackStackEntry currentBackStackEntry = getCurrentBackStackEntry();
        if (currentBackStackEntry != null) {
            return currentBackStackEntry.getDestination();
        }
        return null;
    }

    public void navigate(@IdRes int i6, @Nullable Bundle bundle, @Nullable NavOptions navOptions) {
        navigate(i6, bundle, navOptions, (Navigator.Extras) null);
    }

    public boolean navigateUp() {
        if (getDestinationCountOnBackStack() == 1) {
            NavDestination currentDestination = getCurrentDestination();
            int id = currentDestination.getId();
            for (NavGraph parent = currentDestination.getParent(); parent != null; parent = parent.getParent()) {
                if (parent.getStartDestination() != id) {
                    Bundle bundle = new Bundle();
                    Activity activity = this.mActivity;
                    if (activity != null && activity.getIntent() != null && this.mActivity.getIntent().getData() != null) {
                        bundle.putParcelable(KEY_DEEP_LINK_INTENT, this.mActivity.getIntent());
                        NavDestination.DeepLinkMatch matchDeepLink = this.mGraph.matchDeepLink(new NavDeepLinkRequest(this.mActivity.getIntent()));
                        if (matchDeepLink != null) {
                            bundle.putAll(matchDeepLink.getDestination().addInDefaultArgs(matchDeepLink.getMatchingArgs()));
                        }
                    }
                    new NavDeepLinkBuilder(this).setDestination(parent.getId()).setArguments(bundle).createTaskStackBuilder().startActivities();
                    Activity activity2 = this.mActivity;
                    if (activity2 != null) {
                        activity2.finish();
                    }
                    return true;
                }
                id = parent.getId();
            }
            return false;
        }
        return popBackStack();
    }

    public boolean popBackStack(@IdRes int i6, boolean z5) {
        return popBackStackInternal(i6, z5) && dispatchOnDestinationChanged();
    }

    @CallSuper
    public void setGraph(@NonNull NavGraph navGraph) {
        setGraph(navGraph, (Bundle) null);
    }

    public void navigate(@IdRes int i6, @Nullable Bundle bundle, @Nullable NavOptions navOptions, @Nullable Navigator.Extras extras) {
        NavDestination destination;
        int i7;
        if (this.mBackStack.isEmpty()) {
            destination = this.mGraph;
        } else {
            destination = this.mBackStack.getLast().getDestination();
        }
        if (destination != null) {
            NavAction action = destination.getAction(i6);
            Bundle bundle2 = null;
            if (action != null) {
                if (navOptions == null) {
                    navOptions = action.getNavOptions();
                }
                i7 = action.getDestinationId();
                Bundle defaultArguments = action.getDefaultArguments();
                if (defaultArguments != null) {
                    bundle2 = new Bundle();
                    bundle2.putAll(defaultArguments);
                }
            } else {
                i7 = i6;
            }
            if (bundle != null) {
                if (bundle2 == null) {
                    bundle2 = new Bundle();
                }
                bundle2.putAll(bundle);
            }
            if (i7 == 0 && navOptions != null && navOptions.getPopUpTo() != -1) {
                popBackStack(navOptions.getPopUpTo(), navOptions.isPopUpToInclusive());
                return;
            }
            if (i7 != 0) {
                NavDestination findDestination = findDestination(i7);
                if (findDestination == null) {
                    String displayName = NavDestination.getDisplayName(this.mContext, i7);
                    if (action == null) {
                        throw new IllegalArgumentException("Navigation action/destination " + displayName + " cannot be found from the current destination " + destination);
                    }
                    throw new IllegalArgumentException("Navigation destination " + displayName + " referenced from action " + NavDestination.getDisplayName(this.mContext, i6) + " cannot be found from the current destination " + destination);
                }
                navigate(findDestination, bundle2, navOptions, extras);
                return;
            }
            throw new IllegalArgumentException("Destination id == 0 can only be used in conjunction with a valid navOptions.popUpTo");
        }
        throw new IllegalStateException("no current navigation node");
    }

    @CallSuper
    public void setGraph(@NonNull NavGraph navGraph, @Nullable Bundle bundle) {
        NavGraph navGraph2 = this.mGraph;
        if (navGraph2 != null) {
            popBackStackInternal(navGraph2.getId(), true);
        }
        this.mGraph = navGraph;
        onGraphCreated(bundle);
    }

    public void navigate(@NonNull Uri uri) {
        navigate(new NavDeepLinkRequest(uri, null, null));
    }

    public void navigate(@NonNull Uri uri, @Nullable NavOptions navOptions) {
        navigate(new NavDeepLinkRequest(uri, null, null), navOptions);
    }

    public void navigate(@NonNull Uri uri, @Nullable NavOptions navOptions, @Nullable Navigator.Extras extras) {
        navigate(new NavDeepLinkRequest(uri, null, null), navOptions, extras);
    }

    public void navigate(@NonNull NavDeepLinkRequest navDeepLinkRequest) {
        navigate(navDeepLinkRequest, (NavOptions) null);
    }

    public void navigate(@NonNull NavDeepLinkRequest navDeepLinkRequest, @Nullable NavOptions navOptions) {
        navigate(navDeepLinkRequest, navOptions, (Navigator.Extras) null);
    }

    public void navigate(@NonNull NavDeepLinkRequest navDeepLinkRequest, @Nullable NavOptions navOptions, @Nullable Navigator.Extras extras) {
        NavDestination.DeepLinkMatch matchDeepLink = this.mGraph.matchDeepLink(navDeepLinkRequest);
        if (matchDeepLink != null) {
            Bundle addInDefaultArgs = matchDeepLink.getDestination().addInDefaultArgs(matchDeepLink.getMatchingArgs());
            if (addInDefaultArgs == null) {
                addInDefaultArgs = new Bundle();
            }
            NavDestination destination = matchDeepLink.getDestination();
            Intent intent = new Intent();
            intent.setDataAndType(navDeepLinkRequest.getUri(), navDeepLinkRequest.getMimeType());
            intent.setAction(navDeepLinkRequest.getAction());
            addInDefaultArgs.putParcelable(KEY_DEEP_LINK_INTENT, intent);
            navigate(destination, addInDefaultArgs, navOptions, extras);
            return;
        }
        throw new IllegalArgumentException("Navigation destination that matches request " + navDeepLinkRequest + " cannot be found in the navigation graph " + this.mGraph);
    }

    private void navigate(@NonNull NavDestination navDestination, @Nullable Bundle bundle, @Nullable NavOptions navOptions, @Nullable Navigator.Extras extras) {
        boolean z5 = false;
        boolean popBackStackInternal = (navOptions == null || navOptions.getPopUpTo() == -1) ? false : popBackStackInternal(navOptions.getPopUpTo(), navOptions.isPopUpToInclusive());
        Navigator navigator = this.mNavigatorProvider.getNavigator(navDestination.getNavigatorName());
        Bundle addInDefaultArgs = navDestination.addInDefaultArgs(bundle);
        NavDestination navigate = navigator.navigate(navDestination, addInDefaultArgs, navOptions, extras);
        if (navigate != null) {
            if (!(navigate instanceof FloatingWindow)) {
                while (!this.mBackStack.isEmpty() && (this.mBackStack.peekLast().getDestination() instanceof FloatingWindow) && popBackStackInternal(this.mBackStack.peekLast().getDestination().getId(), true)) {
                }
            }
            ArrayDeque arrayDeque = new ArrayDeque();
            if (navDestination instanceof NavGraph) {
                NavDestination navDestination2 = navigate;
                while (true) {
                    NavGraph parent = navDestination2.getParent();
                    if (parent != null) {
                        arrayDeque.addFirst(new NavBackStackEntry(this.mContext, parent, addInDefaultArgs, this.mLifecycleOwner, this.mViewModel));
                        if (!this.mBackStack.isEmpty() && this.mBackStack.getLast().getDestination() == parent) {
                            popBackStackInternal(parent.getId(), true);
                        }
                    }
                    if (parent == null || parent == navDestination) {
                        break;
                    } else {
                        navDestination2 = parent;
                    }
                }
            }
            NavDestination destination = arrayDeque.isEmpty() ? navigate : ((NavBackStackEntry) arrayDeque.getFirst()).getDestination();
            while (destination != null && findDestination(destination.getId()) == null) {
                NavGraph parent2 = destination.getParent();
                if (parent2 != null) {
                    arrayDeque.addFirst(new NavBackStackEntry(this.mContext, parent2, addInDefaultArgs, this.mLifecycleOwner, this.mViewModel));
                }
                destination = parent2;
            }
            NavDestination destination2 = arrayDeque.isEmpty() ? navigate : ((NavBackStackEntry) arrayDeque.getLast()).getDestination();
            while (!this.mBackStack.isEmpty() && (this.mBackStack.getLast().getDestination() instanceof NavGraph) && ((NavGraph) this.mBackStack.getLast().getDestination()).findNode(destination2.getId(), false) == null && popBackStackInternal(this.mBackStack.getLast().getDestination().getId(), true)) {
            }
            this.mBackStack.addAll(arrayDeque);
            if (this.mBackStack.isEmpty() || this.mBackStack.getFirst().getDestination() != this.mGraph) {
                this.mBackStack.addFirst(new NavBackStackEntry(this.mContext, this.mGraph, addInDefaultArgs, this.mLifecycleOwner, this.mViewModel));
            }
            this.mBackStack.add(new NavBackStackEntry(this.mContext, navigate, navigate.addInDefaultArgs(addInDefaultArgs), this.mLifecycleOwner, this.mViewModel));
        } else if (navOptions != null && navOptions.shouldLaunchSingleTop()) {
            NavBackStackEntry peekLast = this.mBackStack.peekLast();
            if (peekLast != null) {
                peekLast.replaceArguments(addInDefaultArgs);
            }
            z5 = true;
        }
        updateOnBackPressedCallbackEnabled();
        if (popBackStackInternal || navigate != null || z5) {
            dispatchOnDestinationChanged();
        }
    }

    public void navigate(@NonNull NavDirections navDirections) {
        navigate(navDirections.getActionId(), navDirections.getArguments());
    }

    public void navigate(@NonNull NavDirections navDirections, @Nullable NavOptions navOptions) {
        navigate(navDirections.getActionId(), navDirections.getArguments(), navOptions);
    }

    public void navigate(@NonNull NavDirections navDirections, @NonNull Navigator.Extras extras) {
        navigate(navDirections.getActionId(), navDirections.getArguments(), (NavOptions) null, extras);
    }
}
