package org.junit.internal.runners.statements;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.runners.model.MultipleFailureException;
import org.junit.runners.model.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class e extends h {

    /* renamed from: a, reason: collision with root package name */
    private final h f51445a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f51446b;

    /* renamed from: c, reason: collision with root package name */
    private final List<org.junit.runners.model.d> f51447c;

    @Override // org.junit.runners.model.h
    public void a() throws Throwable {
        ArrayList arrayList = new ArrayList();
        try {
            this.f51445a.a();
            Iterator<org.junit.runners.model.d> it = this.f51447c.iterator();
            while (it.hasNext()) {
                try {
                    it.next().l(this.f51446b, new Object[0]);
                } catch (Throwable th) {
                    arrayList.add(th);
                }
            }
        } catch (Throwable th2) {
            try {
                arrayList.add(th2);
                Iterator<org.junit.runners.model.d> it2 = this.f51447c.iterator();
                while (it2.hasNext()) {
                    try {
                        it2.next().l(this.f51446b, new Object[0]);
                    } catch (Throwable th3) {
                        arrayList.add(th3);
                    }
                }
            } catch (Throwable th4) {
                Iterator<org.junit.runners.model.d> it3 = this.f51447c.iterator();
                while (it3.hasNext()) {
                    try {
                        it3.next().l(this.f51446b, new Object[0]);
                    } catch (Throwable th5) {
                        arrayList.add(th5);
                    }
                }
                throw th4;
            }
        }
        MultipleFailureException.assertEmpty(arrayList);
    }

    public e(h hVar, List<org.junit.runners.model.d> list, Object obj) {
        this.f51445a = hVar;
        this.f51447c = list;
        this.f51446b = obj;
    }
}
