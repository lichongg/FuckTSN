package cn.bluemobi.dylan.sqlitelibrary;

import android.os.Parcelable;
import com.acse.ottn.l3;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class b {
    public static Object e(Object obj, String str) {
        if (obj != null && str != null && !str.isEmpty()) {
            try {
                return obj.getClass().getMethod(l3.f4736f + str.substring(0, 1).toUpperCase() + str.substring(1), null).invoke(obj, null);
            } catch (IllegalAccessException e6) {
                e6.printStackTrace();
            } catch (NoSuchMethodException unused) {
                try {
                    return obj.getClass().getMethod("is" + str.substring(0, 1).toUpperCase() + str.substring(1), null).invoke(obj, null);
                } catch (IllegalAccessException e7) {
                    e7.printStackTrace();
                } catch (NoSuchMethodException e8) {
                    e8.printStackTrace();
                } catch (InvocationTargetException e9) {
                    e9.printStackTrace();
                }
            } catch (InvocationTargetException e10) {
                e10.printStackTrace();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        return null;
    }

    public static List<Map<String, Object>> a(Object obj) {
        if (obj == null) {
            return null;
        }
        String[] b6 = b(obj.getClass());
        Class[] c6 = c(obj.getClass());
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < b6.length; i6++) {
            HashMap hashMap = new HashMap();
            hashMap.put(CommonNetImpl.NAME, b6[i6]);
            hashMap.put("type", c6[i6]);
            hashMap.put("value", e(obj, b6[i6]));
            arrayList.add(hashMap);
        }
        return arrayList;
    }

    public static String[] b(Class cls) {
        if (cls == null) {
            return null;
        }
        Field[] fieldArr = new Field[0];
        try {
            fieldArr = cls.getDeclaredFields();
        } catch (SecurityException e6) {
            e6.printStackTrace();
        }
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < fieldArr.length; i6++) {
            if (!fieldArr[i6].isSynthetic() && !fieldArr[i6].getName().equals("serialVersionUID")) {
                try {
                    if (fieldArr[i6].getType().equals(Class.forName(Parcelable.Creator.class.getName()))) {
                    }
                } catch (ClassNotFoundException unused) {
                }
                arrayList.add(fieldArr[i6].getName());
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static Class[] c(Class cls) {
        if (cls == null) {
            return null;
        }
        Field[] fieldArr = new Field[0];
        try {
            fieldArr = cls.getDeclaredFields();
        } catch (SecurityException e6) {
            e6.printStackTrace();
        }
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < fieldArr.length; i6++) {
            if (!fieldArr[i6].isSynthetic() && !fieldArr[i6].getName().equals("serialVersionUID")) {
                try {
                    if (fieldArr[i6].getType().equals(Class.forName(Parcelable.Creator.class.getName()))) {
                    }
                } catch (ClassNotFoundException unused) {
                }
                arrayList.add(fieldArr[i6].getType());
            }
        }
        return (Class[]) arrayList.toArray(new Class[arrayList.size()]);
    }

    public static String d(Class cls) {
        if (cls == null) {
            return null;
        }
        return cls.getSimpleName();
    }
}
