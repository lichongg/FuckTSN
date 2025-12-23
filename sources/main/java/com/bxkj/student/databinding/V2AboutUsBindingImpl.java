package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import com.bxkj.base.util.b0;
import com.bxkj.base.v2.common.view.b;
import com.bxkj.student.R;
import com.bxkj.student.common.view.ToggleButton;
import com.bxkj.student.generated.callback.a;
import com.bxkj.student.v2.ui.my.AboutUsActivity;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class V2AboutUsBindingImpl extends V2AboutUsBinding implements a.InterfaceC0207a {

    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes;

    @Nullable
    private static final SparseIntArray sViewsWithIds;

    @Nullable
    private final View.OnClickListener mCallback10;

    @Nullable
    private final View.OnClickListener mCallback5;

    @Nullable
    private final View.OnClickListener mCallback6;

    @Nullable
    private final View.OnClickListener mCallback7;

    @Nullable
    private final View.OnClickListener mCallback8;

    @Nullable
    private final View.OnClickListener mCallback9;
    private long mDirtyFlags;

    @NonNull
    private final ConstraintLayout mboundView0;

    @NonNull
    private final LinearLayoutCompat mboundView2;

    @NonNull
    private final LinearLayoutCompat mboundView3;

    @NonNull
    private final LinearLayoutCompat mboundView4;

    @NonNull
    private final LinearLayoutCompat mboundView5;

    @NonNull
    private final LinearLayoutCompat mboundView6;

    @NonNull
    private final LinearLayoutCompat mboundView7;

    public V2AboutUsBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j6;
        String str;
        synchronized (this) {
            j6 = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        b bVar = this.mBackEvent;
        String str2 = this.mTitle;
        AboutUsActivity aboutUsActivity = this.mActivity;
        long j7 = 18 & j6;
        long j8 = 20 & j6;
        long j9 = 24 & j6;
        if (j9 != 0) {
            str = "版本号：" + b0.h(aboutUsActivity);
        } else {
            str = null;
        }
        if (j7 != 0) {
            this.includeTitle.setActivity(bVar);
        }
        if (j8 != 0) {
            this.includeTitle.setTitle(str2);
        }
        if ((j6 & 16) != 0) {
            this.mboundView2.setOnClickListener(this.mCallback5);
            this.mboundView3.setOnClickListener(this.mCallback6);
            this.mboundView4.setOnClickListener(this.mCallback7);
            this.mboundView5.setOnClickListener(this.mCallback8);
            this.mboundView6.setOnClickListener(this.mCallback9);
            this.mboundView7.setOnClickListener(this.mCallback10);
        }
        if (j9 != 0) {
            TextViewBindingAdapter.setText(this.tvVersion, str);
        }
        ViewDataBinding.executeBindingsOn(this.includeTitle);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.mDirtyFlags != 0) {
                    return true;
                }
                return this.includeTitle.hasPendingBindings();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16L;
        }
        this.includeTitle.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (4 == variableId) {
            setBackEvent((b) variable);
            return true;
        }
        if (29 == variableId) {
            setTitle((String) variable);
            return true;
        }
        if (1 != variableId) {
            return false;
        }
        setActivity((AboutUsActivity) variable);
        return true;
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(14);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"v2_pub_title"}, new int[]{8}, new int[]{R.layout.v2_pub_title});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.fl_top, 9);
        sparseIntArray.put(2131297182, 10);
        sparseIntArray.put(2131297155, 11);
        sparseIntArray.put(2131298986, 12);
        sparseIntArray.put(R.id.tag_float_button, 13);
    }

    private V2AboutUsBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (FrameLayout) bindings[9], (V2PubTitleBinding) bindings[8], (ImageView) bindings[11], (ImageView) bindings[10], (ToggleButton) bindings[13], (TextView) bindings[12], (TextView) bindings[1]);
        this.mDirtyFlags = -1L;
        setContainedBinding(this.includeTitle);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) bindings[2];
        this.mboundView2 = linearLayoutCompat;
        linearLayoutCompat.setTag(null);
        LinearLayoutCompat linearLayoutCompat2 = (LinearLayoutCompat) bindings[3];
        this.mboundView3 = linearLayoutCompat2;
        linearLayoutCompat2.setTag(null);
        LinearLayoutCompat linearLayoutCompat3 = (LinearLayoutCompat) bindings[4];
        this.mboundView4 = linearLayoutCompat3;
        linearLayoutCompat3.setTag(null);
        LinearLayoutCompat linearLayoutCompat4 = (LinearLayoutCompat) bindings[5];
        this.mboundView5 = linearLayoutCompat4;
        linearLayoutCompat4.setTag(null);
        LinearLayoutCompat linearLayoutCompat5 = (LinearLayoutCompat) bindings[6];
        this.mboundView6 = linearLayoutCompat5;
        linearLayoutCompat5.setTag(null);
        LinearLayoutCompat linearLayoutCompat6 = (LinearLayoutCompat) bindings[7];
        this.mboundView7 = linearLayoutCompat6;
        linearLayoutCompat6.setTag(null);
        this.tvVersion.setTag(null);
        setRootTag(root);
        this.mCallback10 = new a(this, 6);
        this.mCallback9 = new a(this, 5);
        this.mCallback7 = new a(this, 3);
        this.mCallback8 = new a(this, 4);
        this.mCallback5 = new a(this, 1);
        this.mCallback6 = new a(this, 2);
        invalidateAll();
    }

    private boolean onChangeIncludeTitle(V2PubTitleBinding IncludeTitle, int fieldId) {
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
        return onChangeIncludeTitle((V2PubTitleBinding) object, fieldId);
    }

    @Override // com.bxkj.student.databinding.V2AboutUsBinding
    public void setActivity(@Nullable AboutUsActivity Activity) {
        this.mActivity = Activity;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    @Override // com.bxkj.student.databinding.V2AboutUsBinding
    public void setBackEvent(@Nullable b BackEvent) {
        this.mBackEvent = BackEvent;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(4);
        super.requestRebind();
    }

    @Override // com.bxkj.student.databinding.V2AboutUsBinding
    public void setTitle(@Nullable String Title) {
        this.mTitle = Title;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(29);
        super.requestRebind();
    }

    @Override // com.bxkj.student.generated.callback.a.InterfaceC0207a
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        switch (sourceId) {
            case 1:
                AboutUsActivity aboutUsActivity = this.mActivity;
                if (aboutUsActivity != null) {
                    aboutUsActivity.U();
                    break;
                }
                break;
            case 2:
                AboutUsActivity aboutUsActivity2 = this.mActivity;
                if (aboutUsActivity2 != null) {
                    aboutUsActivity2.S();
                    break;
                }
                break;
            case 3:
                AboutUsActivity aboutUsActivity3 = this.mActivity;
                if (aboutUsActivity3 != null) {
                    aboutUsActivity3.N();
                    break;
                }
                break;
            case 4:
                AboutUsActivity aboutUsActivity4 = this.mActivity;
                if (aboutUsActivity4 != null) {
                    aboutUsActivity4.R();
                    break;
                }
                break;
            case 5:
                AboutUsActivity aboutUsActivity5 = this.mActivity;
                if (aboutUsActivity5 != null) {
                    aboutUsActivity5.M();
                    break;
                }
                break;
            case 6:
                AboutUsActivity aboutUsActivity6 = this.mActivity;
                if (aboutUsActivity6 != null) {
                    aboutUsActivity6.O();
                    break;
                }
                break;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.includeTitle.setLifecycleOwner(lifecycleOwner);
    }
}
