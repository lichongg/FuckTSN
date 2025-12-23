package com.amap.api.col.p0003l;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class g0 extends Thread {

    /* renamed from: a, reason: collision with root package name */
    private Context f6283a;

    /* renamed from: b, reason: collision with root package name */
    private s0 f6284b;

    private n0 b(String str) {
        if (str.equals("quanguo")) {
            str = "quanguogaiyaotu";
        }
        c0 b6 = c0.b(this.f6283a);
        n0 n0Var = null;
        if (b6 != null) {
            String E = b6.E(str);
            File[] listFiles = new File(b3.f0(this.f6283a)).listFiles();
            if (listFiles == null) {
                return null;
            }
            for (File file : listFiles) {
                if ((file.getName().contains(E) || file.getName().contains(str)) && file.getName().endsWith(".zip.tmp.dt")) {
                    n0Var = a(file);
                    if (n0Var.a() != null) {
                        return n0Var;
                    }
                }
            }
        }
        return n0Var;
    }

    private void c() {
        n0 b6;
        String i6;
        int indexOf;
        boolean z5;
        String i7;
        int indexOf2;
        String i8;
        int indexOf3;
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<n0> c6 = this.f6284b.c();
        d(arrayList, "vmap/");
        d(arrayList, "map/");
        g(arrayList, "map/");
        ArrayList<String> f6 = f();
        Iterator<n0> it = c6.iterator();
        while (it.hasNext()) {
            n0 next = it.next();
            if (next != null && next.a() != null) {
                int i9 = next.f6947l;
                boolean z6 = true;
                if (i9 == 4 || i9 == 7) {
                    boolean contains = arrayList.contains(next.j());
                    if (contains || (i6 = a1.i(next.g())) == null || (indexOf = arrayList.indexOf(i6)) == -1) {
                        z6 = contains;
                    } else {
                        arrayList.set(indexOf, next.j());
                    }
                    if (!z6) {
                        this.f6284b.k(next);
                    }
                } else {
                    if (i9 == 0 || i9 == 1) {
                        z5 = f6.contains(next.e()) || f6.contains(next.j());
                        if (z5 || (i7 = a1.i(next.g())) == null || (indexOf2 = f6.indexOf(i7)) == -1) {
                            z6 = z5;
                        } else {
                            f6.set(indexOf2, next.j());
                        }
                        if (!z6) {
                            this.f6284b.k(next);
                        }
                    } else if (i9 == 3 && next.i() != 0) {
                        z5 = f6.contains(next.e()) || f6.contains(next.j());
                        if (z5 || (i8 = a1.i(next.g())) == null || (indexOf3 = f6.indexOf(i8)) == -1) {
                            z6 = z5;
                        } else {
                            f6.set(indexOf3, next.j());
                        }
                        if (!z6) {
                            this.f6284b.k(next);
                        }
                    }
                }
            }
        }
        Iterator<String> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            String next2 = it2.next();
            if (!e(next2, c6) && (b6 = b(next2)) != null) {
                this.f6284b.e(b6);
            }
        }
        c0 b7 = c0.b(this.f6283a);
        if (b7 != null) {
            b7.j();
        }
    }

    private void d(ArrayList<String> arrayList, String str) {
        File[] listFiles;
        String name;
        int lastIndexOf;
        File file = new File(b3.X(this.f6283a) + str);
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.getName().endsWith(".dat") && (lastIndexOf = (name = file2.getName()).lastIndexOf(46)) >= 0 && lastIndexOf < name.length()) {
                    String substring = name.substring(0, lastIndexOf);
                    if (!arrayList.contains(substring)) {
                        arrayList.add(substring);
                    }
                }
            }
        }
    }

    private ArrayList<String> f() {
        File[] listFiles;
        String name;
        int lastIndexOf;
        ArrayList<String> arrayList = new ArrayList<>();
        File file = new File(b3.f0(this.f6283a));
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.getName().endsWith(".zip") && (lastIndexOf = (name = file2.getName()).lastIndexOf(46)) >= 0 && lastIndexOf < name.length()) {
                    arrayList.add(name.substring(0, lastIndexOf));
                }
            }
        }
        return arrayList;
    }

    private void g(ArrayList<String> arrayList, String str) {
        File[] listFiles;
        String[] list;
        File file = new File(b3.v(this.f6283a) + str);
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    String name = file2.getName();
                    if (!TextUtils.isEmpty(name) && (list = file2.list()) != null && list.length > 0 && !arrayList.contains(name)) {
                        if (!name.equals("a0")) {
                            boolean z5 = false;
                            boolean z6 = false;
                            for (String str2 : list) {
                                if ("m1.ans".equals(str2)) {
                                    z5 = true;
                                }
                                if ("m3.ans".equals(str2)) {
                                    z6 = true;
                                }
                            }
                            if (z5) {
                                if (!z6) {
                                }
                                arrayList.add(name);
                                break;
                                break;
                            }
                        } else {
                            for (String str3 : list) {
                                if ("m1.ans".equals(str3)) {
                                    arrayList.add(name);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public g0(Context context) {
        this.f6283a = context;
        this.f6284b = s0.b(context);
    }

    private static n0 a(File file) {
        String w5 = b3.w(file);
        n0 n0Var = new n0();
        n0Var.o(w5);
        return n0Var;
    }

    private static boolean e(String str, ArrayList<n0> arrayList) {
        Iterator<n0> it = arrayList.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next().j())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            c();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
