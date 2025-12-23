package cn.jiguang.bo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\Downloads\app\classes2.dex */
final class k {
    List<cn.jiguang.bp.f> a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr == null || stackTraceElementArr.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            if (stackTraceElement != null) {
                String className = stackTraceElement.getClassName();
                cn.jiguang.bp.f fVar = new cn.jiguang.bp.f();
                fVar.a(Boolean.valueOf(a(className)));
                fVar.c(className);
                fVar.b(stackTraceElement.getMethodName());
                fVar.a(stackTraceElement.getFileName());
                if (stackTraceElement.getLineNumber() >= 0) {
                    fVar.a(Integer.valueOf(stackTraceElement.getLineNumber()));
                }
                fVar.b(Boolean.valueOf(stackTraceElement.isNativeMethod()));
                arrayList.add(fVar);
            }
        }
        Collections.reverse(arrayList);
        return arrayList;
    }

    boolean a(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return str.contains("cn.jiguang") || str.contains("cn.jpush");
    }
}
