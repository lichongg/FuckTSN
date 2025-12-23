package com.huawei.hms.scankit.p;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class g7 extends d0 {
    @Override // com.huawei.hms.scankit.p.d0
    public int a() {
        return 2;
    }

    @Override // com.huawei.hms.scankit.p.d0
    int a(char c6, StringBuilder sb) {
        if (c6 == ' ') {
            sb.append((char) 3);
            return 1;
        }
        if (c6 >= '0' && c6 <= '9') {
            sb.append((char) (c6 - ','));
            return 1;
        }
        if (c6 >= 'a' && c6 <= 'z') {
            sb.append((char) (c6 - 'S'));
            return 1;
        }
        if (c6 < ' ') {
            sb.append((char) 0);
            sb.append(c6);
            return 2;
        }
        if (c6 >= '!' && c6 <= '/') {
            sb.append((char) 1);
            sb.append((char) (c6 - '!'));
            return 2;
        }
        if (c6 >= ':' && c6 <= '@') {
            sb.append((char) 1);
            sb.append((char) (c6 - '+'));
            return 2;
        }
        if (c6 >= '[' && c6 <= '_') {
            sb.append((char) 1);
            sb.append((char) (c6 - 'E'));
            return 2;
        }
        if (c6 == '`') {
            sb.append((char) 2);
            sb.append((char) (c6 - '`'));
            return 2;
        }
        if (c6 >= 'A' && c6 <= 'Z') {
            sb.append((char) 2);
            sb.append((char) (c6 - '@'));
            return 2;
        }
        if (c6 < '{' || c6 > 127) {
            sb.append("\u0001\u001e");
            return a((char) (c6 - 128), sb) + 2;
        }
        sb.append((char) 2);
        sb.append((char) (c6 - '`'));
        return 2;
    }

    g7() {
    }
}
