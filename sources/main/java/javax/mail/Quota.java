package javax.mail;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class Quota {
    public String quotaRoot;
    public Resource[] resources;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Resource {
        public long limit;
        public String name;
        public long usage;

        public Resource(String str, long j6, long j7) {
            this.name = str;
            this.usage = j6;
            this.limit = j7;
        }
    }

    public void setResourceLimit(String str, long j6) {
        if (this.resources == null) {
            this.resources = new Resource[]{new Resource(str, 0L, j6)};
            return;
        }
        int i6 = 0;
        while (true) {
            Resource[] resourceArr = this.resources;
            if (i6 >= resourceArr.length) {
                int length = resourceArr.length;
                Resource[] resourceArr2 = new Resource[length + 1];
                System.arraycopy(resourceArr, 0, resourceArr2, 0, resourceArr.length);
                resourceArr2[length] = new Resource(str, 0L, j6);
                this.resources = resourceArr2;
                return;
            }
            if (resourceArr[i6].name.equalsIgnoreCase(str)) {
                this.resources[i6].limit = j6;
                return;
            }
            i6++;
        }
    }

    public Quota(String str) {
        this.quotaRoot = str;
    }
}
