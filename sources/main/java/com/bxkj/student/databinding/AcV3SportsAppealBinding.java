package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import cn.bluemobi.dylan.base.view.MyGridView;
import com.bxkj.base.v2.common.view.b;
import com.bxkj.student.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class AcV3SportsAppealBinding extends ViewDataBinding {

    @NonNull
    public final Button btCommit;

    @NonNull
    public final EditText etReason;

    @NonNull
    public final MyGridView gvImages;

    @Bindable
    protected b mBackEvent;

    @NonNull
    public final V3PubTitleBinding titleLayout;

    public static AcV3SportsAppealBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static AcV3SportsAppealBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    public abstract void setBackEvent(@Nullable b backEvent);

    @Deprecated
    public static AcV3SportsAppealBinding bind(@NonNull View view, @Nullable Object component) {
        return (AcV3SportsAppealBinding) ViewDataBinding.bind(component, view, R.layout.ac_v3_sports_appeal);
    }

    @NonNull
    @Deprecated
    public static AcV3SportsAppealBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (AcV3SportsAppealBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ac_v3_sports_appeal, root, attachToRoot, component);
    }

    @Nullable
    public b getBackEvent() {
        return this.mBackEvent;
    }

    protected AcV3SportsAppealBinding(Object _bindingComponent, View _root, int _localFieldCount, Button btCommit, EditText etReason, MyGridView gvImages, V3PubTitleBinding titleLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.btCommit = btCommit;
        this.etReason = etReason;
        this.gvImages = gvImages;
        this.titleLayout = titleLayout;
    }

    @NonNull
    public static AcV3SportsAppealBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static AcV3SportsAppealBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (AcV3SportsAppealBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ac_v3_sports_appeal, null, false, component);
    }
}
