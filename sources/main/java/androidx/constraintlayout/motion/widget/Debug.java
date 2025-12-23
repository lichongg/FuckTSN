package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class Debug {
    public static void dumpLayoutParams(ViewGroup viewGroup, String str) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        StringBuilder sb = new StringBuilder();
        sb.append(".(");
        sb.append(stackTraceElement.getFileName());
        sb.append(":");
        sb.append(stackTraceElement.getLineNumber());
        sb.append(") ");
        sb.append(str);
        sb.append("  ");
        int childCount = viewGroup.getChildCount();
        System.out.getClass();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = viewGroup.getChildAt(i6);
            PrintStream printStream = System.out;
            getName(childAt);
            printStream.getClass();
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            for (Field field : layoutParams.getClass().getFields()) {
                try {
                    Object obj = field.get(layoutParams);
                    if (field.getName().contains("To") && !obj.toString().equals("-1")) {
                        PrintStream printStream2 = System.out;
                        field.getName();
                        obj.toString();
                        printStream2.getClass();
                    }
                } catch (IllegalAccessException unused) {
                }
            }
        }
    }

    public static String getName(View view) {
        try {
            return view.getContext().getResources().getResourceEntryName(view.getId());
        } catch (Exception unused) {
            return "UNKNOWN";
        }
    }

    public static String getState(MotionLayout motionLayout, int i6) {
        return i6 == -1 ? "UNDEFINED" : motionLayout.getContext().getResources().getResourceEntryName(i6);
    }

    public static void dumpPoc(Object obj) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        StringBuilder sb = new StringBuilder();
        sb.append(".(");
        sb.append(stackTraceElement.getFileName());
        sb.append(":");
        sb.append(stackTraceElement.getLineNumber());
        sb.append(")");
        Class<?> cls = obj.getClass();
        System.out.getClass();
        for (Field field : cls.getFields()) {
            try {
                Object obj2 = field.get(obj);
                if (field.getName().startsWith("layout_constraint") && ((!(obj2 instanceof Integer) || !obj2.toString().equals("-1")) && ((!(obj2 instanceof Integer) || !obj2.toString().equals("0")) && ((!(obj2 instanceof Float) || !obj2.toString().equals("1.0")) && (!(obj2 instanceof Float) || !obj2.toString().equals("0.5")))))) {
                    PrintStream printStream = System.out;
                    field.getName();
                    Objects.toString(obj2);
                    printStream.getClass();
                }
            } catch (IllegalAccessException unused) {
            }
        }
        System.out.getClass();
    }

    public static String getCallFrom(int i6) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[i6 + 2];
        return ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ")";
    }

    public static String getLoc() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        return ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName() + "()";
    }

    public static String getLocation() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        return ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ")";
    }

    public static String getLocation2() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[2];
        return ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ")";
    }

    public static void logStack(String str, String str2, int i6) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int min = Math.min(i6, stackTrace.length - 1);
        String str3 = " ";
        for (int i7 = 1; i7 <= min; i7++) {
            StackTraceElement stackTraceElement = stackTrace[i7];
            StringBuilder sb = new StringBuilder();
            sb.append(".(");
            sb.append(stackTrace[i7].getFileName());
            sb.append(":");
            sb.append(stackTrace[i7].getLineNumber());
            sb.append(") ");
            sb.append(stackTrace[i7].getMethodName());
            str3 = str3 + " ";
        }
    }

    public static void printStack(String str, int i6) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int min = Math.min(i6, stackTrace.length - 1);
        String str2 = " ";
        for (int i7 = 1; i7 <= min; i7++) {
            StackTraceElement stackTraceElement = stackTrace[i7];
            StringBuilder sb = new StringBuilder();
            sb.append(".(");
            sb.append(stackTrace[i7].getFileName());
            sb.append(":");
            sb.append(stackTrace[i7].getLineNumber());
            sb.append(") ");
            str2 = str2 + " ";
            System.out.getClass();
        }
    }

    public static String getActionType(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        for (Field field : MotionEvent.class.getFields()) {
            try {
                if (Modifier.isStatic(field.getModifiers()) && field.getType().equals(Integer.TYPE) && field.getInt(null) == action) {
                    return field.getName();
                }
            } catch (IllegalAccessException unused) {
            }
        }
        return "---";
    }

    public static String getName(Context context, int i6) {
        if (i6 != -1) {
            try {
                return context.getResources().getResourceEntryName(i6);
            } catch (Exception unused) {
                return "?" + i6;
            }
        }
        return "UNKNOWN";
    }

    public static String getName(Context context, int[] iArr) {
        String str;
        try {
            String str2 = iArr.length + "[";
            int i6 = 0;
            while (i6 < iArr.length) {
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                sb.append(i6 == 0 ? "" : " ");
                String sb2 = sb.toString();
                try {
                    str = context.getResources().getResourceEntryName(iArr[i6]);
                } catch (Resources.NotFoundException unused) {
                    str = "? " + iArr[i6] + " ";
                }
                str2 = sb2 + str;
                i6++;
            }
            return str2 + "]";
        } catch (Exception e6) {
            e6.toString();
            return "UNKNOWN";
        }
    }

    public static void dumpLayoutParams(ViewGroup.LayoutParams layoutParams, String str) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        StringBuilder sb = new StringBuilder();
        sb.append(".(");
        sb.append(stackTraceElement.getFileName());
        sb.append(":");
        sb.append(stackTraceElement.getLineNumber());
        sb.append(") ");
        sb.append(str);
        sb.append("  ");
        PrintStream printStream = System.out;
        layoutParams.getClass();
        printStream.getClass();
        for (Field field : layoutParams.getClass().getFields()) {
            try {
                Object obj = field.get(layoutParams);
                if (field.getName().contains("To") && !obj.toString().equals("-1")) {
                    PrintStream printStream2 = System.out;
                    obj.toString();
                    printStream2.getClass();
                }
            } catch (IllegalAccessException unused) {
            }
        }
        System.out.getClass();
    }
}
