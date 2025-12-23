package cn.jiguang.bh;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\Downloads\app\classes2.dex */
public class h implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private List f2192a;

    /* renamed from: b, reason: collision with root package name */
    private short f2193b;

    /* renamed from: c, reason: collision with root package name */
    private short f2194c;

    public h() {
        this.f2192a = new ArrayList(1);
        this.f2193b = (short) 0;
        this.f2194c = (short) 0;
    }

    private String a(Iterator it) {
        StringBuffer stringBuffer = new StringBuffer();
        while (it.hasNext()) {
            i iVar = (i) it.next();
            stringBuffer.append("[");
            stringBuffer.append(iVar.c());
            stringBuffer.append("]");
            if (it.hasNext()) {
                stringBuffer.append(" ");
            }
        }
        return stringBuffer.toString();
    }

    public g b() {
        return f().d();
    }

    public synchronized long e() {
        return f().h();
    }

    public synchronized i f() {
        if (this.f2192a.size() == 0) {
            throw new IllegalStateException("rrset is empty");
        }
        return (i) this.f2192a.get(0);
    }

    public h(i iVar) {
        this();
        b(iVar);
    }

    private void b(i iVar) {
        if (this.f2193b == 0) {
            this.f2192a.add(iVar);
        } else {
            List list = this.f2192a;
            list.add(list.size() - this.f2193b, iVar);
        }
    }

    public synchronized Iterator a() {
        return a(true, true);
    }

    public String toString() {
        if (this.f2192a.size() == 0) {
            return "{empty}";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{ ");
        stringBuffer.append(b() + " ");
        stringBuffer.append(e() + " ");
        stringBuffer.append(a(a(true, false)));
        if (this.f2193b > 0) {
            stringBuffer.append(" sigs: ");
            stringBuffer.append(a(a(false, false)));
        }
        stringBuffer.append(" }");
        return stringBuffer.toString();
    }

    private synchronized Iterator a(boolean z5, boolean z6) {
        int i6;
        List subList;
        try {
            int size = this.f2192a.size();
            int i7 = z5 ? size - this.f2193b : this.f2193b;
            if (i7 == 0) {
                return Collections.EMPTY_LIST.iterator();
            }
            if (!z5) {
                i6 = size - this.f2193b;
            } else if (z6) {
                if (this.f2194c >= i7) {
                    this.f2194c = (short) 0;
                }
                i6 = this.f2194c;
                this.f2194c = (short) (i6 + 1);
            } else {
                i6 = 0;
            }
            ArrayList arrayList = new ArrayList(i7);
            if (z5) {
                arrayList.addAll(this.f2192a.subList(i6, i7));
                if (i6 != 0) {
                    subList = this.f2192a.subList(0, i6);
                }
                return arrayList.iterator();
            }
            subList = this.f2192a.subList(i6, size);
            arrayList.addAll(subList);
            return arrayList.iterator();
        } catch (Throwable th) {
            throw th;
        }
    }

    public int c() {
        return f().f();
    }

    public int d() {
        return f().g();
    }

    public synchronized void a(i iVar) {
        if (this.f2192a.size() == 0) {
            b(iVar);
            return;
        }
        i f6 = f();
        if (!iVar.a(f6)) {
            throw new IllegalArgumentException("record does not match rrset");
        }
        if (iVar.h() != f6.h()) {
            if (iVar.h() > f6.h()) {
                iVar = iVar.i();
                iVar.a(f6.h());
            } else {
                for (int i6 = 0; i6 < this.f2192a.size(); i6++) {
                    i i7 = ((i) this.f2192a.get(i6)).i();
                    i7.a(iVar.h());
                    this.f2192a.set(i6, i7);
                }
            }
        }
        if (!this.f2192a.contains(iVar)) {
            b(iVar);
        }
    }
}
