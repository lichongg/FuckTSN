package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.bxkj.base.v2.data.b;
import com.bxkj.student.R;
import com.bxkj.student.generated.callback.a;
import com.bxkj.student.v2.ui.main.MyFragment;
import com.google.android.material.button.MaterialButton;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class V2MainTabMyFragmentBindingImpl extends V2MainTabMyFragmentBinding implements a.InterfaceC0207a {

    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;

    @Nullable
    private static final SparseIntArray sViewsWithIds;

    @Nullable
    private final View.OnClickListener mCallback20;
    private long mDirtyFlags;

    @NonNull
    private final ConstraintLayout mboundView0;

    public V2MainTabMyFragmentBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j6;
        String str;
        String str2;
        String str3;
        synchronized (this) {
            j6 = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        b bVar = this.mLoggedInUser;
        long j7 = 6 & j6;
        if (j7 == 0 || bVar == null) {
            str = null;
            str2 = null;
            str3 = null;
        } else {
            str = bVar.U();
            str3 = bVar.L();
            str2 = bVar.S();
        }
        if ((j6 & 4) != 0) {
            this.btLogout.setOnClickListener(this.mCallback20);
        }
        if (j7 != 0) {
            TextViewBindingAdapter.setText(this.tvName, str);
            TextViewBindingAdapter.setText(this.tvSchool, str3);
            TextViewBindingAdapter.setText(this.tvUserNumber, str2);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                return this.mDirtyFlags != 0;
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
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131299164, 5);
        sparseIntArray.put(2131298412, 6);
        sparseIntArray.put(R.id.card_head, 7);
        sparseIntArray.put(2131297148, 8);
        sparseIntArray.put(R.id.rv_menu, 9);
    }

    private V2MainTabMyFragmentBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (MaterialButton) bindings[4], (CardView) bindings[7], (ImageView) bindings[8], (NestedScrollView) bindings[6], (RecyclerView) bindings[9], (TextView) bindings[2], (TextView) bindings[1], (TextView) bindings[5], (TextView) bindings[3]);
        this.mDirtyFlags = -1L;
        this.btLogout.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.tvName.setTag(null);
        this.tvSchool.setTag(null);
        this.tvUserNumber.setTag(null);
        setRootTag(root);
        this.mCallback20 = new a(this, 1);
        invalidateAll();
    }

    @Override // com.bxkj.student.generated.callback.a.InterfaceC0207a
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        MyFragment myFragment = this.mMyFragment;
        if (myFragment != null) {
            myFragment.i();
        }
    }

    @Override // com.bxkj.student.databinding.V2MainTabMyFragmentBinding
    public void setLoggedInUser(@Nullable b LoggedInUser) {
        this.mLoggedInUser = LoggedInUser;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(14);
        super.requestRebind();
    }

    @Override // com.bxkj.student.databinding.V2MainTabMyFragmentBinding
    public void setMyFragment(@Nullable MyFragment MyFragment) {
        this.mMyFragment = MyFragment;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(21);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (21 == variableId) {
            setMyFragment((MyFragment) variable);
            return true;
        }
        if (14 != variableId) {
            return false;
        }
        setLoggedInUser((b) variable);
        return true;
    }
}
