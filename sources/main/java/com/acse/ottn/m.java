package com.acse.ottn;

import android.view.animation.Interpolator;
import com.acse.ottn.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class m extends i {

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<i> f4743b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    public HashMap<i, f> f4744c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<f> f4745d = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<f> f4746e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    public boolean f4747f = true;

    /* renamed from: g, reason: collision with root package name */
    public b f4748g = null;

    /* renamed from: h, reason: collision with root package name */
    public boolean f4749h = false;

    /* renamed from: i, reason: collision with root package name */
    public boolean f4750i = false;

    /* renamed from: j, reason: collision with root package name */
    public long f4751j = 0;

    /* renamed from: k, reason: collision with root package name */
    public n4 f4752k = null;

    /* renamed from: l, reason: collision with root package name */
    public long f4753l = -1;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a extends k {

        /* renamed from: a, reason: collision with root package name */
        public boolean f4754a = false;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f4755b;

        @Override // com.acse.ottn.k, com.acse.ottn.i.a
        public void d(i iVar) {
            this.f4754a = true;
        }

        public a(ArrayList arrayList) {
            this.f4755b = arrayList;
        }

        @Override // com.acse.ottn.k, com.acse.ottn.i.a
        public void b(i iVar) {
            if (this.f4754a) {
                return;
            }
            int size = this.f4755b.size();
            for (int i6 = 0; i6 < size; i6++) {
                f fVar = (f) this.f4755b.get(i6);
                fVar.f4768a.k();
                m.this.f4743b.add(fVar.f4768a);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b implements i.a {

        /* renamed from: a, reason: collision with root package name */
        public m f4757a;

        public b(m mVar) {
            this.f4757a = mVar;
        }

        @Override // com.acse.ottn.i.a
        public void d(i iVar) {
            ArrayList<i.a> arrayList;
            m mVar = m.this;
            if (mVar.f4749h || mVar.f4743b.size() != 0 || (arrayList = m.this.f4629a) == null) {
                return;
            }
            int size = arrayList.size();
            for (int i6 = 0; i6 < size; i6++) {
                m.this.f4629a.get(i6).d(this.f4757a);
            }
        }

        @Override // com.acse.ottn.i.a
        public void b(i iVar) {
            iVar.b(this);
            m.this.f4743b.remove(iVar);
            ((f) this.f4757a.f4744c.get(iVar)).f4773f = true;
            if (!m.this.f4749h) {
                ArrayList arrayList = this.f4757a.f4746e;
                int size = arrayList.size();
                for (int i6 = 0; i6 < size; i6++) {
                    if (!((f) arrayList.get(i6)).f4773f) {
                        return;
                    }
                }
                ArrayList<i.a> arrayList2 = m.this.f4629a;
                if (arrayList2 != null) {
                    ArrayList arrayList3 = (ArrayList) arrayList2.clone();
                    int size2 = arrayList3.size();
                    for (int i7 = 0; i7 < size2; i7++) {
                        ((i.a) arrayList3.get(i7)).b(this.f4757a);
                    }
                }
                this.f4757a.f4750i = false;
            }
        }

        @Override // com.acse.ottn.i.a
        public void a(i iVar) {
        }

        @Override // com.acse.ottn.i.a
        public void c(i iVar) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        public f f4759a;

        public c a(i iVar) {
            f fVar = (f) m.this.f4744c.get(iVar);
            if (fVar == null) {
                fVar = new f(iVar);
                m.this.f4744c.put(iVar, fVar);
                m.this.f4745d.add(fVar);
            }
            this.f4759a.a(new d(fVar, 1));
            return this;
        }

        public c(i iVar) {
            f fVar = (f) m.this.f4744c.get(iVar);
            this.f4759a = fVar;
            if (fVar == null) {
                this.f4759a = new f(iVar);
                m.this.f4744c.put(iVar, this.f4759a);
                m.this.f4745d.add(this.f4759a);
            }
        }

        public c b(i iVar) {
            f fVar = (f) m.this.f4744c.get(iVar);
            if (fVar == null) {
                fVar = new f(iVar);
                m.this.f4744c.put(iVar, fVar);
                m.this.f4745d.add(fVar);
            }
            fVar.a(new d(this.f4759a, 1));
            return this;
        }

        public c c(i iVar) {
            f fVar = (f) m.this.f4744c.get(iVar);
            if (fVar == null) {
                fVar = new f(iVar);
                m.this.f4744c.put(iVar, fVar);
                m.this.f4745d.add(fVar);
            }
            fVar.a(new d(this.f4759a, 0));
            return this;
        }

        public c a(long j6) {
            n4 a6 = n4.a(0.0f, 1.0f);
            a6.a(j6);
            a(a6);
            return this;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class e implements i.a {

        /* renamed from: a, reason: collision with root package name */
        public m f4765a;

        /* renamed from: b, reason: collision with root package name */
        public f f4766b;

        /* renamed from: c, reason: collision with root package name */
        public int f4767c;

        @Override // com.acse.ottn.i.a
        public void a(i iVar) {
            if (this.f4767c == 0) {
                e(iVar);
            }
        }

        @Override // com.acse.ottn.i.a
        public void b(i iVar) {
            if (this.f4767c == 1) {
                e(iVar);
            }
        }

        public final void e(i iVar) {
            d dVar;
            if (this.f4765a.f4749h) {
                return;
            }
            int size = this.f4766b.f4770c.size();
            int i6 = 0;
            while (true) {
                if (i6 >= size) {
                    dVar = null;
                    break;
                }
                dVar = this.f4766b.f4770c.get(i6);
                if (dVar.f4764b == this.f4767c && dVar.f4763a.f4768a == iVar) {
                    iVar.b(this);
                    break;
                }
                i6++;
            }
            this.f4766b.f4770c.remove(dVar);
            if (this.f4766b.f4770c.size() == 0) {
                this.f4766b.f4768a.k();
                this.f4765a.f4743b.add(this.f4766b.f4768a);
            }
        }

        public e(m mVar, f fVar, int i6) {
            this.f4765a = mVar;
            this.f4766b = fVar;
            this.f4767c = i6;
        }

        @Override // com.acse.ottn.i.a
        public void c(i iVar) {
        }

        @Override // com.acse.ottn.i.a
        public void d(i iVar) {
        }
    }

    @Override // com.acse.ottn.i
    public void cancel() {
        ArrayList arrayList;
        this.f4749h = true;
        if (g()) {
            ArrayList<i.a> arrayList2 = this.f4629a;
            if (arrayList2 != null) {
                arrayList = (ArrayList) arrayList2.clone();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((i.a) it.next()).d(this);
                }
            } else {
                arrayList = null;
            }
            n4 n4Var = this.f4752k;
            if (n4Var != null && n4Var.f()) {
                this.f4752k.cancel();
            } else if (this.f4746e.size() > 0) {
                Iterator<f> it2 = this.f4746e.iterator();
                while (it2.hasNext()) {
                    it2.next().f4768a.cancel();
                }
            }
            if (arrayList != null) {
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    ((i.a) it3.next()).b(this);
                }
            }
            this.f4750i = false;
        }
    }

    @Override // com.acse.ottn.i
    public void k() {
        this.f4749h = false;
        this.f4750i = true;
        n();
        int size = this.f4746e.size();
        for (int i6 = 0; i6 < size; i6++) {
            f fVar = this.f4746e.get(i6);
            ArrayList<i.a> d6 = fVar.f4768a.d();
            if (d6 != null && d6.size() > 0) {
                Iterator it = new ArrayList(d6).iterator();
                while (it.hasNext()) {
                    i.a aVar = (i.a) it.next();
                    if ((aVar instanceof e) || (aVar instanceof b)) {
                        fVar.f4768a.b(aVar);
                    }
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i7 = 0; i7 < size; i7++) {
            f fVar2 = this.f4746e.get(i7);
            if (this.f4748g == null) {
                this.f4748g = new b(this);
            }
            ArrayList<d> arrayList2 = fVar2.f4769b;
            if (arrayList2 == null || arrayList2.size() == 0) {
                arrayList.add(fVar2);
            } else {
                int size2 = fVar2.f4769b.size();
                for (int i8 = 0; i8 < size2; i8++) {
                    d dVar = fVar2.f4769b.get(i8);
                    dVar.f4763a.f4768a.a((i.a) new e(this, fVar2, dVar.f4764b));
                }
                fVar2.f4770c = (ArrayList) fVar2.f4769b.clone();
            }
            fVar2.f4768a.a((i.a) this.f4748g);
        }
        if (this.f4751j <= 0) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                f fVar3 = (f) it2.next();
                fVar3.f4768a.k();
                this.f4743b.add(fVar3.f4768a);
            }
        } else {
            n4 a6 = n4.a(0.0f, 1.0f);
            this.f4752k = a6;
            a6.a(this.f4751j);
            this.f4752k.a((i.a) new a(arrayList));
            this.f4752k.k();
        }
        ArrayList<i.a> arrayList3 = this.f4629a;
        if (arrayList3 != null) {
            ArrayList arrayList4 = (ArrayList) arrayList3.clone();
            int size3 = arrayList4.size();
            for (int i9 = 0; i9 < size3; i9++) {
                ((i.a) arrayList4.get(i9)).a(this);
            }
        }
        if (this.f4745d.size() == 0 && this.f4751j == 0) {
            this.f4750i = false;
            ArrayList<i.a> arrayList5 = this.f4629a;
            if (arrayList5 != null) {
                ArrayList arrayList6 = (ArrayList) arrayList5.clone();
                int size4 = arrayList6.size();
                for (int i10 = 0; i10 < size4; i10++) {
                    ((i.a) arrayList6.get(i10)).b(this);
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class d {

        /* renamed from: c, reason: collision with root package name */
        public static final int f4761c = 0;

        /* renamed from: d, reason: collision with root package name */
        public static final int f4762d = 1;

        /* renamed from: a, reason: collision with root package name */
        public f f4763a;

        /* renamed from: b, reason: collision with root package name */
        public int f4764b;

        public d(f fVar, int i6) {
            this.f4763a = fVar;
            this.f4764b = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class f implements Cloneable {

        /* renamed from: a, reason: collision with root package name */
        public i f4768a;

        /* renamed from: b, reason: collision with root package name */
        public ArrayList<d> f4769b = null;

        /* renamed from: c, reason: collision with root package name */
        public ArrayList<d> f4770c = null;

        /* renamed from: d, reason: collision with root package name */
        public ArrayList<f> f4771d = null;

        /* renamed from: e, reason: collision with root package name */
        public ArrayList<f> f4772e = null;

        /* renamed from: f, reason: collision with root package name */
        public boolean f4773f = false;

        public void a(d dVar) {
            if (this.f4769b == null) {
                this.f4769b = new ArrayList<>();
                this.f4771d = new ArrayList<>();
            }
            this.f4769b.add(dVar);
            if (!this.f4771d.contains(dVar.f4763a)) {
                this.f4771d.add(dVar.f4763a);
            }
            f fVar = dVar.f4763a;
            if (fVar.f4772e == null) {
                fVar.f4772e = new ArrayList<>();
            }
            fVar.f4772e.add(this);
        }

        public f(i iVar) {
            this.f4768a = iVar;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public f clone() {
            try {
                f fVar = (f) super.clone();
                fVar.f4768a = this.f4768a.clone();
                return fVar;
            } catch (CloneNotSupportedException unused) {
                throw new AssertionError();
            }
        }
    }

    public void b(i... iVarArr) {
        if (iVarArr != null) {
            this.f4747f = true;
            c a6 = a(iVarArr[0]);
            for (int i6 = 1; i6 < iVarArr.length; i6++) {
                a6.c(iVarArr[i6]);
            }
        }
    }

    @Override // com.acse.ottn.i
    public long c() {
        return this.f4753l;
    }

    @Override // com.acse.ottn.i
    public long e() {
        return this.f4751j;
    }

    @Override // com.acse.ottn.i
    public boolean f() {
        Iterator<f> it = this.f4745d.iterator();
        while (it.hasNext()) {
            if (it.next().f4768a.f()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.acse.ottn.i
    public boolean g() {
        return this.f4750i;
    }

    @Override // com.acse.ottn.i
    public void i() {
        Iterator<f> it = this.f4745d.iterator();
        while (it.hasNext()) {
            it.next().f4768a.i();
        }
    }

    @Override // com.acse.ottn.i
    public void j() {
        Iterator<f> it = this.f4745d.iterator();
        while (it.hasNext()) {
            it.next().f4768a.j();
        }
    }

    public ArrayList<i> m() {
        ArrayList<i> arrayList = new ArrayList<>();
        Iterator<f> it = this.f4745d.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().f4768a);
        }
        return arrayList;
    }

    public final void n() {
        if (!this.f4747f) {
            int size = this.f4745d.size();
            for (int i6 = 0; i6 < size; i6++) {
                f fVar = this.f4745d.get(i6);
                ArrayList<d> arrayList = fVar.f4769b;
                if (arrayList != null && arrayList.size() > 0) {
                    int size2 = fVar.f4769b.size();
                    for (int i7 = 0; i7 < size2; i7++) {
                        d dVar = fVar.f4769b.get(i7);
                        if (fVar.f4771d == null) {
                            fVar.f4771d = new ArrayList<>();
                        }
                        if (!fVar.f4771d.contains(dVar.f4763a)) {
                            fVar.f4771d.add(dVar.f4763a);
                        }
                    }
                }
                fVar.f4773f = false;
            }
            return;
        }
        this.f4746e.clear();
        ArrayList arrayList2 = new ArrayList();
        int size3 = this.f4745d.size();
        for (int i8 = 0; i8 < size3; i8++) {
            f fVar2 = this.f4745d.get(i8);
            ArrayList<d> arrayList3 = fVar2.f4769b;
            if (arrayList3 == null || arrayList3.size() == 0) {
                arrayList2.add(fVar2);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        while (arrayList2.size() > 0) {
            int size4 = arrayList2.size();
            for (int i9 = 0; i9 < size4; i9++) {
                f fVar3 = (f) arrayList2.get(i9);
                this.f4746e.add(fVar3);
                ArrayList<f> arrayList5 = fVar3.f4772e;
                if (arrayList5 != null) {
                    int size5 = arrayList5.size();
                    for (int i10 = 0; i10 < size5; i10++) {
                        f fVar4 = fVar3.f4772e.get(i10);
                        fVar4.f4771d.remove(fVar3);
                        if (fVar4.f4771d.size() == 0) {
                            arrayList4.add(fVar4);
                        }
                    }
                }
            }
            arrayList2.clear();
            arrayList2.addAll(arrayList4);
            arrayList4.clear();
        }
        this.f4747f = false;
        if (this.f4746e.size() != this.f4745d.size()) {
            throw new IllegalStateException("Circular dependencies cannot exist in AnimatorSet");
        }
    }

    @Override // com.acse.ottn.i
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public m a(long j6) {
        if (j6 >= 0) {
            Iterator<f> it = this.f4745d.iterator();
            while (it.hasNext()) {
                it.next().f4768a.a(j6);
            }
            this.f4753l = j6;
            return this;
        }
        throw new IllegalArgumentException("duration must be a value of zero or greater");
    }

    @Override // com.acse.ottn.i
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public m clone() {
        m mVar = (m) super.clone();
        mVar.f4747f = true;
        mVar.f4749h = false;
        mVar.f4750i = false;
        mVar.f4743b = new ArrayList<>();
        mVar.f4744c = new HashMap<>();
        mVar.f4745d = new ArrayList<>();
        mVar.f4746e = new ArrayList<>();
        HashMap hashMap = new HashMap();
        Iterator<f> it = this.f4745d.iterator();
        while (it.hasNext()) {
            f next = it.next();
            f clone = next.clone();
            hashMap.put(next, clone);
            mVar.f4745d.add(clone);
            mVar.f4744c.put(clone.f4768a, clone);
            ArrayList arrayList = null;
            clone.f4769b = null;
            clone.f4770c = null;
            clone.f4772e = null;
            clone.f4771d = null;
            ArrayList<i.a> d6 = clone.f4768a.d();
            if (d6 != null) {
                Iterator<i.a> it2 = d6.iterator();
                while (it2.hasNext()) {
                    i.a next2 = it2.next();
                    if (next2 instanceof b) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(next2);
                    }
                }
                if (arrayList != null) {
                    Iterator it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        d6.remove((i.a) it3.next());
                    }
                }
            }
        }
        Iterator<f> it4 = this.f4745d.iterator();
        while (it4.hasNext()) {
            f next3 = it4.next();
            f fVar = (f) hashMap.get(next3);
            ArrayList<d> arrayList2 = next3.f4769b;
            if (arrayList2 != null) {
                Iterator<d> it5 = arrayList2.iterator();
                while (it5.hasNext()) {
                    d next4 = it5.next();
                    fVar.a(new d((f) hashMap.get(next4.f4763a), next4.f4764b));
                }
            }
        }
        return mVar;
    }

    public void a(Collection<i> collection) {
        if (collection == null || collection.size() <= 0) {
            return;
        }
        this.f4747f = true;
        c cVar = null;
        for (i iVar : collection) {
            if (cVar == null) {
                cVar = a(iVar);
            } else {
                cVar.c(iVar);
            }
        }
    }

    @Override // com.acse.ottn.i
    public void b() {
        this.f4749h = true;
        if (g()) {
            if (this.f4746e.size() != this.f4745d.size()) {
                n();
                Iterator<f> it = this.f4746e.iterator();
                while (it.hasNext()) {
                    f next = it.next();
                    if (this.f4748g == null) {
                        this.f4748g = new b(this);
                    }
                    next.f4768a.a((i.a) this.f4748g);
                }
            }
            n4 n4Var = this.f4752k;
            if (n4Var != null) {
                n4Var.cancel();
            }
            if (this.f4746e.size() > 0) {
                Iterator<f> it2 = this.f4746e.iterator();
                while (it2.hasNext()) {
                    it2.next().f4768a.b();
                }
            }
            ArrayList<i.a> arrayList = this.f4629a;
            if (arrayList != null) {
                Iterator it3 = ((ArrayList) arrayList.clone()).iterator();
                while (it3.hasNext()) {
                    ((i.a) it3.next()).b(this);
                }
            }
            this.f4750i = false;
        }
    }

    public void a(i... iVarArr) {
        if (iVarArr != null) {
            this.f4747f = true;
            int i6 = 0;
            if (iVarArr.length == 1) {
                a(iVarArr[0]);
                return;
            }
            while (i6 < iVarArr.length - 1) {
                c a6 = a(iVarArr[i6]);
                i6++;
                a6.b(iVarArr[i6]);
            }
        }
    }

    public void a(List<i> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f4747f = true;
        int i6 = 0;
        if (list.size() == 1) {
            a(list.get(0));
            return;
        }
        while (i6 < list.size() - 1) {
            c a6 = a(list.get(i6));
            i6++;
            a6.b(list.get(i6));
        }
    }

    @Override // com.acse.ottn.i
    public void a(Object obj) {
        Iterator<f> it = this.f4745d.iterator();
        while (it.hasNext()) {
            i iVar = it.next().f4768a;
            if (iVar instanceof m) {
                ((m) iVar).a(obj);
            } else if (iVar instanceof v2) {
                ((v2) iVar).a(obj);
            }
        }
    }

    @Override // com.acse.ottn.i
    public void b(long j6) {
        this.f4751j = j6;
    }

    @Override // com.acse.ottn.i
    public void a(Interpolator interpolator) {
        Iterator<f> it = this.f4745d.iterator();
        while (it.hasNext()) {
            it.next().f4768a.a(interpolator);
        }
    }

    public c a(i iVar) {
        if (iVar == null) {
            return null;
        }
        this.f4747f = true;
        return new c(iVar);
    }
}
