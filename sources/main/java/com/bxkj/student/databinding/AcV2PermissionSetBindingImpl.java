package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.base.util.b0;
import com.bxkj.student.R;
import com.bxkj.student.generated.callback.a;
import com.bxkj.student.v2.ui.sports.set.PermissionSetActivity;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class AcV2PermissionSetBindingImpl extends AcV2PermissionSetBinding implements a.InterfaceC0207a {

    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes;

    @Nullable
    private static final SparseIntArray sViewsWithIds;

    @Nullable
    private final View.OnClickListener mCallback62;

    @Nullable
    private final View.OnClickListener mCallback63;

    @Nullable
    private final View.OnClickListener mCallback64;

    @Nullable
    private final View.OnClickListener mCallback65;
    private long mDirtyFlags;

    @NonNull
    private final RelativeLayout mboundView0;

    @NonNull
    private final Button mboundView3;

    @NonNull
    private final Button mboundView4;

    @NonNull
    private final Button mboundView5;

    public AcV2PermissionSetBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds));
    }

    @Override // com.bxkj.student.generated.callback.a.InterfaceC0207a
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        PermissionSetActivity permissionSetActivity;
        if (sourceId == 1) {
            PermissionSetActivity permissionSetActivity2 = this.mMActivity;
            if (permissionSetActivity2 != null) {
                permissionSetActivity2.N();
                return;
            }
            return;
        }
        if (sourceId == 2) {
            PermissionSetActivity permissionSetActivity3 = this.mMActivity;
            if (permissionSetActivity3 != null) {
                permissionSetActivity3.O();
                return;
            }
            return;
        }
        if (sourceId != 3) {
            if (sourceId == 4 && (permissionSetActivity = this.mMActivity) != null) {
                permissionSetActivity.P();
                return;
            }
            return;
        }
        PermissionSetActivity permissionSetActivity4 = this.mMActivity;
        if (permissionSetActivity4 != null) {
            permissionSetActivity4.P();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j6;
        synchronized (this) {
            j6 = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        PermissionSetActivity permissionSetActivity = this.mMActivity;
        long j7 = 6 & j6;
        if ((j6 & 4) != 0) {
            this.btFastSet.setOnClickListener(this.mCallback62);
            this.mboundView3.setOnClickListener(this.mCallback63);
            this.mboundView4.setOnClickListener(this.mCallback64);
            this.mboundView5.setOnClickListener(this.mCallback65);
            this.titleLayout.setTitle("权限设置");
            TextViewBindingAdapter.setText(this.tvHint2, "您的手机" + b0.d() + "-" + b0.e() + "设置步骤如下：");
        }
        if (j7 != 0) {
            this.titleLayout.setActivity(permissionSetActivity);
        }
        ViewDataBinding.executeBindingsOn(this.titleLayout);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.mDirtyFlags != 0) {
                    return true;
                }
                return this.titleLayout.hasPendingBindings();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4L;
        }
        this.titleLayout.invalidateAll();
        requestRebind();
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(13);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"v3_pub_title"}, new int[]{6}, new int[]{R.layout.v3_pub_title});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.card_why, 7);
        sparseIntArray.put(R.id.tv_hint, 8);
        sparseIntArray.put(R.id.sw, 9);
        sparseIntArray.put(R.id.card_save_model, 10);
        sparseIntArray.put(R.id.card_battery_optimizations, 11);
        sparseIntArray.put(R.id.card_gps_always, 12);
    }

    private AcV2PermissionSetBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (Button) bindings[1], (CardView) bindings[11], (CardView) bindings[12], (CardView) bindings[10], (CardView) bindings[7], (SmartWebView) bindings[9], (V3PubTitleBinding) bindings[6], (TextView) bindings[8], (TextView) bindings[2]);
        this.mDirtyFlags = -1L;
        this.btFastSet.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        Button button = (Button) bindings[3];
        this.mboundView3 = button;
        button.setTag(null);
        Button button2 = (Button) bindings[4];
        this.mboundView4 = button2;
        button2.setTag(null);
        Button button3 = (Button) bindings[5];
        this.mboundView5 = button3;
        button3.setTag(null);
        setContainedBinding(this.titleLayout);
        this.tvHint2.setTag(null);
        setRootTag(root);
        this.mCallback65 = new a(this, 4);
        this.mCallback64 = new a(this, 3);
        this.mCallback62 = new a(this, 1);
        this.mCallback63 = new a(this, 2);
        invalidateAll();
    }

    private boolean onChangeTitleLayout(V3PubTitleBinding TitleLayout, int fieldId) {
        if (fieldId != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId != 0) {
            return false;
        }
        return onChangeTitleLayout((V3PubTitleBinding) object, fieldId);
    }

    @Override // com.bxkj.student.databinding.AcV2PermissionSetBinding
    public void setMActivity(@Nullable PermissionSetActivity MActivity) {
        this.mMActivity = MActivity;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(17);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (17 != variableId) {
            return false;
        }
        setMActivity((PermissionSetActivity) variable);
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.titleLayout.setLifecycleOwner(lifecycleOwner);
    }
}
