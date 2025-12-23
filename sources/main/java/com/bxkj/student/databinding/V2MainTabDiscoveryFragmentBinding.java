package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.student.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class V2MainTabDiscoveryFragmentBinding extends ViewDataBinding {

    @NonNull
    public final SmartWebView smartWebView;

    @NonNull
    public final SmartRefreshLayout srl;

    @NonNull
    public final TextView tvTitle;

    public static V2MainTabDiscoveryFragmentBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static V2MainTabDiscoveryFragmentBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static V2MainTabDiscoveryFragmentBinding bind(@NonNull View view, @Nullable Object component) {
        return (V2MainTabDiscoveryFragmentBinding) ViewDataBinding.bind(component, view, R.layout.v2_main_tab_discovery_fragment);
    }

    @NonNull
    @Deprecated
    public static V2MainTabDiscoveryFragmentBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (V2MainTabDiscoveryFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.v2_main_tab_discovery_fragment, root, attachToRoot, component);
    }

    protected V2MainTabDiscoveryFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, SmartWebView smartWebView, SmartRefreshLayout srl, TextView tvTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.smartWebView = smartWebView;
        this.srl = srl;
        this.tvTitle = tvTitle;
    }

    @NonNull
    public static V2MainTabDiscoveryFragmentBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static V2MainTabDiscoveryFragmentBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (V2MainTabDiscoveryFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.v2_main_tab_discovery_fragment, null, false, component);
    }
}
