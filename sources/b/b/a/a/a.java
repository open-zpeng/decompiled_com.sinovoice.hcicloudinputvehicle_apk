package b.b.a.a;

import junit.framework.Assert;
/* compiled from: JTAssert.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f147a = true;

    public static void a(String str, boolean z) {
        if (!f147a || z) {
            return;
        }
        Assert.assertTrue(str, z);
    }
}
