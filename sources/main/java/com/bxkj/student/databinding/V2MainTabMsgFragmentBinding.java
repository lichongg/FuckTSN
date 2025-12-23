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

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class V2MainTabMsgFragmentBinding extends ViewDataBinding {

    @NonNull
    public final SmartWebView smartWebView;

    @NonNull
    public final TextView tvTitle;

    public static V2MainTabMsgFragmentBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static V2MainTabMsgFragmentBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static V2MainTabMsgFragmentBinding bind(@NonNull View view, @Nullable Object component) {
        return (V2MainTabMsgFragmentBinding) ViewDataBinding.bind(component, view, R.layout.v2_main_tab_msg_fragment);
    }

    @NonNull
    @Deprecated
    public static V2MainTabMsgFragmentBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (V2MainTabMsgFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.v2_main_tab_msg_fragment, root, attachToRoot, component);
    }

    protected V2MainTabMsgFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, SmartWebView smartWebView, TextView tvTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.smartWebView = smartWebView;
        this.tvTitle = tvTitle;
    }

    @NonNull
    public static V2MainTabMsgFragmentBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static V2MainTabMsgFragmentBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (V2MainTabMsgFragmentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.v2_main_tab_msg_fragment, null, false, component);
    }
}
