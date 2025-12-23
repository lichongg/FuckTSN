package androidx.databinding;

import android.R;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class DataBindingUtil {
    private static DataBinderMapper sMapper = new DataBinderMapperImpl();
    private static DataBindingComponent sDefaultComponent = null;

    @Nullable
    public static <T extends ViewDataBinding> T bind(@NonNull View view) {
        return (T) bind(view, sDefaultComponent);
    }

    @Nullable
    public static <T extends ViewDataBinding> T findBinding(@NonNull View view) {
        while (view != null) {
            T t5 = (T) ViewDataBinding.getBinding(view);
            if (t5 != null) {
                return t5;
            }
            Object tag = view.getTag();
            if (tag instanceof String) {
                String str = (String) tag;
                if (str.startsWith(ResIdentify.RES_TYPE_LAYOUT) && str.endsWith("_0")) {
                    char charAt = str.charAt(6);
                    int indexOf = str.indexOf(47, 7);
                    if (charAt == '/') {
                        if (indexOf == -1) {
                            return null;
                        }
                    } else if (charAt == '-' && indexOf != -1 && str.indexOf(47, indexOf + 1) == -1) {
                        return null;
                    }
                }
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return null;
    }

    public static <T extends ViewDataBinding> T inflate(@NonNull LayoutInflater layoutInflater, int i6, @Nullable ViewGroup viewGroup, boolean z5) {
        return (T) inflate(layoutInflater, i6, viewGroup, z5, sDefaultComponent);
    }

    public static <T extends ViewDataBinding> T setContentView(@NonNull Activity activity, int i6) {
        return (T) setContentView(activity, i6, sDefaultComponent);
    }

    @Nullable
    public static <T extends ViewDataBinding> T bind(@NonNull View view, DataBindingComponent dataBindingComponent) {
        T t5 = (T) getBinding(view);
        if (t5 != null) {
            return t5;
        }
        Object tag = view.getTag();
        if (!(tag instanceof String)) {
            throw new IllegalArgumentException("View is not a binding layout");
        }
        int layoutId = sMapper.getLayoutId((String) tag);
        if (layoutId != 0) {
            return (T) sMapper.getDataBinder(dataBindingComponent, view, layoutId);
        }
        throw new IllegalArgumentException("View is not a binding layout. Tag: " + tag);
    }

    @Nullable
    public static String convertBrIdToString(int i6) {
        return sMapper.convertBrIdToString(i6);
    }

    @Nullable
    public static DataBindingComponent getDefaultComponent() {
        return sDefaultComponent;
    }

    public static <T extends ViewDataBinding> T inflate(@NonNull LayoutInflater layoutInflater, int i6, @Nullable ViewGroup viewGroup, boolean z5, @Nullable DataBindingComponent dataBindingComponent) {
        boolean z6 = viewGroup != null && z5;
        return z6 ? (T) bindToAddedViews(dataBindingComponent, viewGroup, z6 ? viewGroup.getChildCount() : 0, i6) : (T) bind(dataBindingComponent, layoutInflater.inflate(i6, viewGroup, z5), i6);
    }

    public static <T extends ViewDataBinding> T setContentView(@NonNull Activity activity, int i6, @Nullable DataBindingComponent dataBindingComponent) {
        activity.setContentView(i6);
        return (T) bindToAddedViews(dataBindingComponent, (ViewGroup) activity.getWindow().getDecorView().findViewById(R.id.content), 0, i6);
    }

    public static void setDefaultComponent(@Nullable DataBindingComponent dataBindingComponent) {
        sDefaultComponent = dataBindingComponent;
    }

    private DataBindingUtil() {
    }

    private static <T extends ViewDataBinding> T bindToAddedViews(DataBindingComponent dataBindingComponent, ViewGroup viewGroup, int i6, int i7) {
        int childCount = viewGroup.getChildCount();
        int i8 = childCount - i6;
        if (i8 == 1) {
            return (T) bind(dataBindingComponent, viewGroup.getChildAt(childCount - 1), i7);
        }
        View[] viewArr = new View[i8];
        for (int i9 = 0; i9 < i8; i9++) {
            viewArr[i9] = viewGroup.getChildAt(i9 + i6);
        }
        return (T) bind(dataBindingComponent, viewArr, i7);
    }

    @Nullable
    public static <T extends ViewDataBinding> T getBinding(@NonNull View view) {
        return (T) ViewDataBinding.getBinding(view);
    }

    static <T extends ViewDataBinding> T bind(DataBindingComponent dataBindingComponent, View[] viewArr, int i6) {
        return (T) sMapper.getDataBinder(dataBindingComponent, viewArr, i6);
    }

    static <T extends ViewDataBinding> T bind(DataBindingComponent dataBindingComponent, View view, int i6) {
        return (T) sMapper.getDataBinder(dataBindingComponent, view, i6);
    }
}
