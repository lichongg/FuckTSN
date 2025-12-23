package androidx.databinding.adapters;

import android.widget.TabHost;
import androidx.annotation.RestrictTo;
import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;
import androidx.databinding.InverseBindingListener;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: D:\Downloads\app\classes.dex */
public class TabHostBindingAdapter {
    @BindingAdapter(requireAll = false, value = {"android:onTabChanged", "android:currentTabAttrChanged"})
    public static void setListeners(TabHost tabHost, final TabHost.OnTabChangeListener onTabChangeListener, final InverseBindingListener inverseBindingListener) {
        if (inverseBindingListener == null) {
            tabHost.setOnTabChangedListener(onTabChangeListener);
        } else {
            tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() { // from class: androidx.databinding.adapters.TabHostBindingAdapter.1
                @Override // android.widget.TabHost.OnTabChangeListener
                public void onTabChanged(String str) {
                    TabHost.OnTabChangeListener onTabChangeListener2 = onTabChangeListener;
                    if (onTabChangeListener2 != null) {
                        onTabChangeListener2.onTabChanged(str);
                    }
                    inverseBindingListener.onChange();
                }
            });
        }
    }

    @InverseBindingAdapter(attribute = "android:currentTab")
    public static int getCurrentTab(TabHost tabHost) {
        return tabHost.getCurrentTab();
    }

    @InverseBindingAdapter(attribute = "android:currentTab")
    public static String getCurrentTabTag(TabHost tabHost) {
        return tabHost.getCurrentTabTag();
    }

    @BindingAdapter({"android:currentTab"})
    public static void setCurrentTab(TabHost tabHost, int i6) {
        if (tabHost.getCurrentTab() != i6) {
            tabHost.setCurrentTab(i6);
        }
    }

    @BindingAdapter({"android:currentTab"})
    public static void setCurrentTabTag(TabHost tabHost, String str) {
        String currentTabTag = tabHost.getCurrentTabTag();
        if ((currentTabTag != null && !currentTabTag.equals(str)) || (currentTabTag == null && str != null)) {
            tabHost.setCurrentTabByTag(str);
        }
    }
}
