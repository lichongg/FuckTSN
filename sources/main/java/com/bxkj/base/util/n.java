package com.bxkj.base.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import cn.bluemobi.dylan.photoview.ImagePagerActivity;
import com.bxkj.base.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class n {
    public static void b(Context context, List<String> list) {
        c(context, list, 0);
    }

    public static void a(Context context, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        c(context, arrayList, 0);
    }

    public static void c(Context context, List<String> list, int i6) {
        Intent intent = new Intent(context, (Class<?>) ImagePagerActivity.class);
        String[] strArr = (String[]) list.toArray(new String[list.size()]);
        intent.putExtra(ImagePagerActivity.U, true);
        intent.putExtra(ImagePagerActivity.T, strArr);
        intent.putExtra(ImagePagerActivity.S, i6);
        context.startActivity(intent);
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(R.anim.zoom_ente, R.anim.zoom_exit);
        }
    }
}
