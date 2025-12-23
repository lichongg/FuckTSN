package com.baidu.idl.face.platform.ui;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.kuaishou.weapon.p0.g;
import com.stub.StubApp;
import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class BaseActivity extends Activity {
    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i6, String[] strArr, int[] iArr) {
        StubApp.interface22(i6, strArr, iArr);
        for (int i7 = 0; i7 < strArr.length; i7++) {
            int i8 = iArr[i7];
        }
    }

    public void requestPermissions(int i6) {
        int checkSelfPermission;
        int checkSelfPermission2;
        int checkSelfPermission3;
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                ArrayList arrayList = new ArrayList();
                checkSelfPermission = checkSelfPermission("android.permission.CAMERA");
                if (checkSelfPermission != 0) {
                    arrayList.add("android.permission.CAMERA");
                }
                checkSelfPermission2 = checkSelfPermission(g.f36049i);
                if (checkSelfPermission2 != 0) {
                    arrayList.add(g.f36049i);
                }
                checkSelfPermission3 = checkSelfPermission(g.f36050j);
                if (checkSelfPermission3 != 0) {
                    arrayList.add(g.f36050j);
                }
                if (arrayList.size() >= 1) {
                    int size = arrayList.size();
                    String[] strArr = new String[size];
                    for (int i7 = 0; i7 < size; i7++) {
                        strArr[i7] = (String) arrayList.get(i7);
                    }
                    requestPermissions(strArr, i6);
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestPermissions(99);
    }

    public void showCustomToast(String str) {
        View inflate = getLayoutInflater().inflate(R.layout.setting_toast_layout, (ViewGroup) findViewById(R.id.toast_layout));
        ((TextView) inflate.findViewById(R.id.toast_txt)).setText(str);
        Toast toast = new Toast(this);
        toast.setDuration(0);
        toast.setGravity(17, 0, 0);
        toast.setView(inflate);
        toast.show();
    }
}
