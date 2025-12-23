package androidx.navigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.SparseArrayCompat;
import androidx.navigation.NavDestination;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class NavGraph extends NavDestination implements Iterable<NavDestination> {
    final SparseArrayCompat<NavDestination> mNodes;
    private int mStartDestId;
    private String mStartDestIdName;

    public final void addDestinations(@NonNull Collection<NavDestination> collection) {
        for (NavDestination navDestination : collection) {
            if (navDestination != null) {
                addDestination(navDestination);
            }
        }
    }

    @Nullable
    public final NavDestination findNode(@IdRes int i6) {
        return findNode(i6, true);
    }

    @Nullable
    final NavDestination findNode(@IdRes int i6, boolean z5) {
        NavDestination navDestination = this.mNodes.get(i6);
        if (navDestination != null) {
            return navDestination;
        }
        if (!z5 || getParent() == null) {
            return null;
        }
        return getParent().findNode(i6);
    }

    @NonNull
    String getStartDestDisplayName() {
        if (this.mStartDestIdName == null) {
            this.mStartDestIdName = Integer.toString(this.mStartDestId);
        }
        return this.mStartDestIdName;
    }

    @IdRes
    public final int getStartDestination() {
        return this.mStartDestId;
    }

    @Override // java.lang.Iterable
    @NonNull
    public final Iterator<NavDestination> iterator() {
        return new Iterator<NavDestination>() { // from class: androidx.navigation.NavGraph.1
            private int mIndex = -1;
            private boolean mWentToNext = false;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.mIndex + 1 < NavGraph.this.mNodes.size();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.Iterator
            public NavDestination next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                this.mWentToNext = true;
                SparseArrayCompat<NavDestination> sparseArrayCompat = NavGraph.this.mNodes;
                int i6 = this.mIndex + 1;
                this.mIndex = i6;
                return sparseArrayCompat.valueAt(i6);
            }

            @Override // java.util.Iterator
            public void remove() {
                if (!this.mWentToNext) {
                    throw new IllegalStateException("You must call next() before you can remove an element");
                }
                NavGraph.this.mNodes.valueAt(this.mIndex).setParent(null);
                NavGraph.this.mNodes.removeAt(this.mIndex);
                this.mIndex--;
                this.mWentToNext = false;
            }
        };
    }

    public final void remove(@NonNull NavDestination navDestination) {
        int indexOfKey = this.mNodes.indexOfKey(navDestination.getId());
        if (indexOfKey >= 0) {
            this.mNodes.valueAt(indexOfKey).setParent(null);
            this.mNodes.removeAt(indexOfKey);
        }
    }

    @Override // androidx.navigation.NavDestination
    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" startDestination=");
        NavDestination findNode = findNode(getStartDestination());
        if (findNode == null) {
            String str = this.mStartDestIdName;
            if (str == null) {
                sb.append("0x");
                sb.append(Integer.toHexString(this.mStartDestId));
            } else {
                sb.append(str);
            }
        } else {
            sb.append("{");
            sb.append(findNode.toString());
            sb.append("}");
        }
        return sb.toString();
    }

    public NavGraph(@NonNull Navigator<? extends NavGraph> navigator) {
        super(navigator);
        this.mNodes = new SparseArrayCompat<>();
    }

    public final void addAll(@NonNull NavGraph navGraph) {
        Iterator<NavDestination> it = navGraph.iterator();
        while (it.hasNext()) {
            NavDestination next = it.next();
            it.remove();
            addDestination(next);
        }
    }

    public final void addDestination(@NonNull NavDestination navDestination) {
        int id = navDestination.getId();
        if (id != 0) {
            if (id != getId()) {
                NavDestination navDestination2 = this.mNodes.get(id);
                if (navDestination2 == navDestination) {
                    return;
                }
                if (navDestination.getParent() == null) {
                    if (navDestination2 != null) {
                        navDestination2.setParent(null);
                    }
                    navDestination.setParent(this);
                    this.mNodes.put(navDestination.getId(), navDestination);
                    return;
                }
                throw new IllegalStateException("Destination already has a parent set. Call NavGraph.remove() to remove the previous parent.");
            }
            throw new IllegalArgumentException("Destination " + navDestination + " cannot have the same id as graph " + this);
        }
        throw new IllegalArgumentException("Destinations must have an id. Call setId() or include an android:id in your navigation XML.");
    }

    public final void addDestinations(@NonNull NavDestination... navDestinationArr) {
        for (NavDestination navDestination : navDestinationArr) {
            if (navDestination != null) {
                addDestination(navDestination);
            }
        }
    }

    public final void clear() {
        Iterator<NavDestination> it = iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    @Override // androidx.navigation.NavDestination
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public String getDisplayName() {
        if (getId() != 0) {
            return super.getDisplayName();
        }
        return "the root navigation";
    }

    @Override // androidx.navigation.NavDestination
    @Nullable
    NavDestination.DeepLinkMatch matchDeepLink(@NonNull NavDeepLinkRequest navDeepLinkRequest) {
        NavDestination.DeepLinkMatch matchDeepLink = super.matchDeepLink(navDeepLinkRequest);
        Iterator<NavDestination> it = iterator();
        while (it.hasNext()) {
            NavDestination.DeepLinkMatch matchDeepLink2 = it.next().matchDeepLink(navDeepLinkRequest);
            if (matchDeepLink2 != null && (matchDeepLink == null || matchDeepLink2.compareTo(matchDeepLink) > 0)) {
                matchDeepLink = matchDeepLink2;
            }
        }
        return matchDeepLink;
    }

    @Override // androidx.navigation.NavDestination
    public void onInflate(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super.onInflate(context, attributeSet);
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, androidx.navigation.common.R.styleable.NavGraphNavigator);
        setStartDestination(obtainAttributes.getResourceId(androidx.navigation.common.R.styleable.NavGraphNavigator_startDestination, 0));
        this.mStartDestIdName = NavDestination.getDisplayName(context, this.mStartDestId);
        obtainAttributes.recycle();
    }

    public final void setStartDestination(@IdRes int i6) {
        if (i6 != getId()) {
            this.mStartDestId = i6;
            this.mStartDestIdName = null;
            return;
        }
        throw new IllegalArgumentException("Start destination " + i6 + " cannot use the same id as the graph " + this);
    }
}
