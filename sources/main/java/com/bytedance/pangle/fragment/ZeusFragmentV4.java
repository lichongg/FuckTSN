package com.bytedance.pangle.fragment;

import android.app.Application;
import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.sdk.openadsdk.api.m;
import java.lang.reflect.InvocationTargetException;

@Keep
/* loaded from: D:\Downloads\app\classes3.dex */
public class ZeusFragmentV4 extends Fragment {
    Application.ActivityLifecycleCallbacks callbacks = new xt(this);

    public ZeusFragmentV4() {
        j.j(getClass());
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public Context getContext() {
        try {
            return ZeusTransformUtils.wrapperContext(super.getContext(), (String) MethodUtils.invokeStaticMethod(getClass(), "_GET_PLUGIN_PKG", new Object[0]));
        } catch (IllegalAccessException e6) {
            m.j(e6);
            return super.getContext();
        } catch (NoSuchMethodException e7) {
            m.j(e7);
            return super.getContext();
        } catch (InvocationTargetException e8) {
            m.j(e8);
            return super.getContext();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        Zeus.getAppApplication().registerActivityLifecycleCallbacks(this.callbacks);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        Zeus.getAppApplication().unregisterActivityLifecycleCallbacks(this.callbacks);
        super.onDetach();
    }
}
