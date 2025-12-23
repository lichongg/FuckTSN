package cn.bluemobi.dylan.base.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    public static final int f1236a = 111;

    /* renamed from: b, reason: collision with root package name */
    public static final int f1237b = 222;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f1238a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f1239b;

        a(boolean z5, Activity activity) {
            this.f1238a = z5;
            this.f1239b = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i6) {
            dialogInterface.dismiss();
            if (this.f1238a) {
                this.f1239b.finish();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f1240a;

        b(Activity activity) {
            this.f1240a = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i6) {
            p.o(this.f1240a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface c {
        void a();

        void b(String... strArr);

        void c(String... strArr);
    }

    public static boolean g(int[] iArr) {
        return iArr.length > 0 && iArr[0] == 0;
    }

    public static void h(Activity activity, String[] strArr, boolean z5) {
        for (int i6 = 0; i6 < strArr.length; i6++) {
            if (strArr[i6].equals(com.kuaishou.weapon.p0.g.f36050j)) {
                n(activity, "存储", z5);
                return;
            }
            if (strArr[i6].equals("android.permission.CAMERA")) {
                n(activity, "相机", z5);
                return;
            } else if (strArr[i6].equals("android.permission.READ_CONTACTS")) {
                n(activity, "通讯录", z5);
                return;
            } else {
                if (strArr[i6].equals("android.permission.RECORD_AUDIO")) {
                    n(activity, "麦克风", z5);
                    return;
                }
            }
        }
    }

    public static List<String> c(Context context, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < strArr.length; i6++) {
            if (!f(context, strArr[i6])) {
                arrayList.add(strArr[i6]);
            }
        }
        return arrayList;
    }

    public static boolean i(Context context, String str) {
        return ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, str);
    }

    public static void m(Context context, String str, int i6) {
        ActivityCompat.requestPermissions((Activity) context, new String[]{str}, i6);
    }

    public static void n(Activity activity, String str, boolean z5) {
        new AlertDialog.Builder(activity).setTitle(str + "权限不可用").setMessage("请在设置中打开" + str + "权限").setPositiveButton("立即开启", new b(activity)).setNegativeButton("取消", new a(z5, activity)).setCancelable(false).show();
    }

    public static void o(Activity activity) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts(WiseOpenHianalyticsData.UNION_PACKAGE, activity.getPackageName(), null));
        activity.startActivityForResult(intent, 222);
    }

    public static void a(Context context, String[] strArr, int i6) {
        List<String> c6 = c(context, strArr);
        if (c6.size() > 0) {
            l(context, c6, i6);
        }
    }

    public static void b(Context context, String str, int i6) {
        if (!f(context, str)) {
            m(context, str, i6);
        }
    }

    public static void d(Context context, String[] strArr, c cVar) {
        List<String> c6 = c(context, strArr);
        if (c6.size() == 0) {
            cVar.a();
            return;
        }
        boolean z5 = false;
        int i6 = 0;
        while (true) {
            if (i6 < c6.size()) {
                if (i(context, c6.get(i6))) {
                    break;
                } else {
                    i6++;
                }
            } else {
                z5 = true;
                break;
            }
        }
        String[] strArr2 = (String[]) c6.toArray(new String[c6.size()]);
        if (z5) {
            cVar.c(strArr2);
        } else {
            cVar.b(strArr2);
        }
    }

    public static void e(Context context, String str, c cVar) {
        if (f(context, str)) {
            cVar.a();
        } else if (i(context, str)) {
            cVar.c(str);
        } else {
            cVar.b(str);
        }
    }

    public static boolean f(Context context, String str) {
        if (ContextCompat.checkSelfPermission(context, str) == 0) {
            return true;
        }
        return false;
    }

    public static void j(Context context, String[] strArr, c cVar) {
        List<String> c6 = c(context, strArr);
        if (c6.size() == 0) {
            cVar.a();
            return;
        }
        for (int i6 = 0; i6 < c6.size(); i6++) {
            if (!i(context, c6.get(i6))) {
                cVar.b(strArr);
                return;
            }
        }
        cVar.c(strArr);
    }

    public static void k(Context context, String str, int[] iArr, c cVar) {
        if (g(iArr)) {
            cVar.a();
        } else if (i(context, str)) {
            cVar.c(str);
        } else {
            cVar.b(str);
        }
    }

    public static void l(Context context, List list, int i6) {
        ActivityCompat.requestPermissions((Activity) context, (String[]) list.toArray(new String[list.size()]), i6);
    }
}
