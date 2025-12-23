package com.umeng.analytics.pro;

import java.nio.ByteBuffer;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class bs {

    /* renamed from: a, reason: collision with root package name */
    private static final Comparator f41064a = new a(null);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.umeng.analytics.pro.bs$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a implements Comparator {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            if (obj == null && obj2 == null) {
                return 0;
            }
            if (obj == null) {
                return -1;
            }
            if (obj2 == null) {
                return 1;
            }
            return obj instanceof List ? bs.a((List) obj, (List) obj2) : obj instanceof Set ? bs.a((Set) obj, (Set) obj2) : obj instanceof Map ? bs.a((Map) obj, (Map) obj2) : obj instanceof byte[] ? bs.a((byte[]) obj, (byte[]) obj2) : bs.a((Comparable) obj, (Comparable) obj2);
        }
    }

    public static int a(byte b6, byte b7) {
        if (b6 < b7) {
            return -1;
        }
        return b7 < b6 ? 1 : 0;
    }

    public static int a(double d6, double d7) {
        if (d6 < d7) {
            return -1;
        }
        return d7 < d6 ? 1 : 0;
    }

    public static ByteBuffer c(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return null;
        }
        return b(byteBuffer) ? byteBuffer : ByteBuffer.wrap(a(byteBuffer));
    }

    public static ByteBuffer d(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return null;
        }
        ByteBuffer wrap = ByteBuffer.wrap(new byte[byteBuffer.remaining()]);
        if (byteBuffer.hasArray()) {
            System.arraycopy(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), wrap.array(), 0, byteBuffer.remaining());
            return wrap;
        }
        byteBuffer.slice().get(wrap.array());
        return wrap;
    }

    private bs() {
    }

    public static int a(int i6, int i7) {
        if (i6 < i7) {
            return -1;
        }
        return i7 < i6 ? 1 : 0;
    }

    public static boolean b(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray() && byteBuffer.position() == 0 && byteBuffer.arrayOffset() == 0 && byteBuffer.remaining() == byteBuffer.capacity()) {
            return true;
        }
        return false;
    }

    public static int a(long j6, long j7) {
        if (j6 < j7) {
            return -1;
        }
        return j7 < j6 ? 1 : 0;
    }

    public static int a(short s5, short s6) {
        if (s5 < s6) {
            return -1;
        }
        return s6 < s5 ? 1 : 0;
    }

    public static int a(Object obj, Object obj2) {
        if (obj instanceof Comparable) {
            return a((Comparable) obj, (Comparable) obj2);
        }
        if (obj instanceof List) {
            return a((List) obj, (List) obj2);
        }
        if (obj instanceof Set) {
            return a((Set) obj, (Set) obj2);
        }
        if (obj instanceof Map) {
            return a((Map) obj, (Map) obj2);
        }
        if (obj instanceof byte[]) {
            return a((byte[]) obj, (byte[]) obj2);
        }
        throw new IllegalArgumentException("Cannot compare objects of type " + obj.getClass());
    }

    public static int a(boolean z5, boolean z6) {
        return Boolean.valueOf(z5).compareTo(Boolean.valueOf(z6));
    }

    public static int a(String str, String str2) {
        return str.compareTo(str2);
    }

    public static int a(byte[] bArr, byte[] bArr2) {
        int a6 = a(bArr.length, bArr2.length);
        if (a6 != 0) {
            return a6;
        }
        for (int i6 = 0; i6 < bArr.length; i6++) {
            int a7 = a(bArr[i6], bArr2[i6]);
            if (a7 != 0) {
                return a7;
            }
        }
        return 0;
    }

    public static int a(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }

    public static int a(List list, List list2) {
        int a6 = a(list.size(), list2.size());
        if (a6 != 0) {
            return a6;
        }
        for (int i6 = 0; i6 < list.size(); i6++) {
            int compare = f41064a.compare(list.get(i6), list2.get(i6));
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }

    public static int a(Set set, Set set2) {
        int a6 = a(set.size(), set2.size());
        if (a6 != 0) {
            return a6;
        }
        Comparator comparator = f41064a;
        TreeSet treeSet = new TreeSet(comparator);
        treeSet.addAll(set);
        TreeSet treeSet2 = new TreeSet(comparator);
        treeSet2.addAll(set2);
        Iterator it = treeSet.iterator();
        Iterator it2 = treeSet2.iterator();
        while (it.hasNext() && it2.hasNext()) {
            int compare = f41064a.compare(it.next(), it2.next());
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }

    public static int a(Map map, Map map2) {
        int a6 = a(map.size(), map2.size());
        if (a6 != 0) {
            return a6;
        }
        Comparator comparator = f41064a;
        TreeMap treeMap = new TreeMap(comparator);
        treeMap.putAll(map);
        Iterator it = treeMap.entrySet().iterator();
        TreeMap treeMap2 = new TreeMap(comparator);
        treeMap2.putAll(map2);
        Iterator it2 = treeMap2.entrySet().iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Map.Entry entry2 = (Map.Entry) it2.next();
            Comparator comparator2 = f41064a;
            int compare = comparator2.compare(entry.getKey(), entry2.getKey());
            if (compare != 0) {
                return compare;
            }
            int compare2 = comparator2.compare(entry.getValue(), entry2.getValue());
            if (compare2 != 0) {
                return compare2;
            }
        }
        return 0;
    }

    public static void a(ByteBuffer byteBuffer, StringBuilder sb) {
        byte[] array = byteBuffer.array();
        int arrayOffset = byteBuffer.arrayOffset();
        int position = byteBuffer.position() + arrayOffset;
        int limit = arrayOffset + byteBuffer.limit();
        int i6 = limit - position > 128 ? position + 128 : limit;
        for (int i7 = position; i7 < i6; i7++) {
            if (i7 > position) {
                sb.append(" ");
            }
            sb.append(a(array[i7]));
        }
        if (limit != i6) {
            sb.append("...");
        }
    }

    public static String a(byte b6) {
        return Integer.toHexString((b6 | 256) & 511).toUpperCase().substring(1);
    }

    public static byte[] a(ByteBuffer byteBuffer) {
        if (b(byteBuffer)) {
            return byteBuffer.array();
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        a(byteBuffer, bArr, 0);
        return bArr;
    }

    public static int a(ByteBuffer byteBuffer, byte[] bArr, int i6) {
        int remaining = byteBuffer.remaining();
        System.arraycopy(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), bArr, i6, remaining);
        return remaining;
    }

    public static byte[] a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }
}
