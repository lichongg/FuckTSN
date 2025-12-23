package com.bjtsn.dylan.requestpermission;

import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class PermissionDispatcherFragment extends Fragment {

    /* renamed from: c, reason: collision with root package name */
    private SparseArray<b.a> f14547c = new SparseArray<>();

    private final List<String> c(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (!b(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i6, @NotNull String[] permissions, @NotNull int[] grantResults) {
        StubApp.interface22(i6, permissions, grantResults);
        g0.p(permissions, "permissions");
        g0.p(grantResults, "grantResults");
        super.onRequestPermissionsResult(i6, permissions, grantResults);
        b.a aVar = this.f14547c.get(i6);
        this.f14547c.remove(i6);
        if (aVar == null) {
            return;
        }
        List<String> c6 = c(permissions);
        if (c6.isEmpty()) {
            aVar.a();
            return;
        }
        Iterator<String> it = c6.iterator();
        while (it.hasNext()) {
            if (!d(it.next())) {
                aVar.b(permissions);
                return;
            }
        }
        aVar.c(permissions);
    }

    public final void requestPermissions(@NotNull String[] permissions, @NotNull b.a callBack) {
        g0.p(permissions, "permissions");
        g0.p(callBack, "callBack");
        if (c(permissions).isEmpty()) {
            callBack.a();
            return;
        }
        int size = this.f14547c.size() + 1;
        this.f14547c.put(size, callBack);
        requestPermissions(permissions, size);
    }

    private final boolean b(String str) {
        Context context = getContext();
        if (context != null && ContextCompat.checkSelfPermission(context, str) == 0) {
            return true;
        }
        return false;
    }

    private final boolean d(String str) {
        FragmentActivity activity = getActivity();
        if (activity != null && ActivityCompat.shouldShowRequestPermissionRationale(activity, str)) {
            return true;
        }
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }
}
