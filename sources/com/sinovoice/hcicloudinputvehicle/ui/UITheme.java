package com.sinovoice.hcicloudinputvehicle.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import java.util.HashMap;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class UITheme {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f289a = true;

    /* renamed from: b  reason: collision with root package name */
    private final Context f290b;
    private Context c;
    LinkedList<OnThemeChangedBroadcastReceiver> e = new LinkedList<>();
    private String f = "";
    private HashMap<a, Object> d = new HashMap<>();

    /* loaded from: classes.dex */
    public interface OnThemeChangedBroadcastReceiver {
        boolean onThemeChangedReceive(UITheme uITheme);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        int f291a;

        /* renamed from: b  reason: collision with root package name */
        String f292b;

        public a(int i, String str) {
            this.f291a = i;
            this.f292b = str;
        }

        public boolean equals(Object obj) {
            a aVar = (a) obj;
            return aVar.f292b.equals(this.f292b) && aVar.f291a == this.f291a;
        }

        public int hashCode() {
            return this.f292b.hashCode() * (this.f291a + 1);
        }
    }

    public UITheme(Context context) {
        this.f290b = context;
        this.c = context;
    }

    private Object f(int i, String str) {
        return g(i, str, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0033, code lost:
        if ((r1 instanceof android.graphics.drawable.StateListDrawable) != false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x007d, code lost:
        if ((r1 instanceof android.graphics.drawable.StateListDrawable) != false) goto L11;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.Object g(int r7, java.lang.String r8, boolean r9) {
        /*
            r6 = this;
            com.sinovoice.hcicloudinputvehicle.ui.UITheme$a r0 = new com.sinovoice.hcicloudinputvehicle.ui.UITheme$a
            r0.<init>(r7, r8)
            r1 = 0
            if (r9 != 0) goto Lf
            java.util.HashMap<com.sinovoice.hcicloudinputvehicle.ui.UITheme$a, java.lang.Object> r2 = r6.d
            java.lang.Object r2 = r2.get(r0)
            goto L10
        Lf:
            r2 = r1
        L10:
            r3 = 1
            if (r2 != 0) goto L9c
            java.lang.String r2 = r6.f
            java.lang.String r2 = r6.j(r2, r8)
            r4 = 0
            switch(r7) {
                case 0: goto L80;
                case 1: goto L73;
                case 2: goto L6a;
                case 3: goto L5d;
                case 4: goto L50;
                case 5: goto L43;
                case 6: goto L36;
                case 7: goto L29;
                case 8: goto L1d;
                case 9: goto L1e;
                default: goto L1d;
            }
        L1d:
            return r1
        L1e:
            android.content.Context r1 = r6.c
            android.content.Context r5 = r6.f290b
            android.content.res.ColorStateList r1 = com.sinovoice.hcicloudinputvehicle.ui.UITools.n(r1, r5, r2, r8)
        L26:
            r2 = r1
            r1 = 0
            goto L8a
        L29:
            android.content.Context r1 = r6.c
            android.content.Context r5 = r6.f290b
            java.lang.String[] r1 = com.sinovoice.hcicloudinputvehicle.ui.UITools.l(r1, r5, r2, r8)
            boolean r2 = r1 instanceof android.graphics.drawable.StateListDrawable
            if (r2 == 0) goto L88
            goto L7f
        L36:
            android.content.Context r1 = r6.c
            android.content.Context r5 = r6.f290b
            int r1 = com.sinovoice.hcicloudinputvehicle.ui.UITools.r(r1, r5, r2, r8)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L88
        L43:
            android.content.Context r1 = r6.c
            android.content.Context r5 = r6.f290b
            float r1 = com.sinovoice.hcicloudinputvehicle.ui.UITools.q(r1, r5, r2, r8)
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            goto L88
        L50:
            android.content.Context r1 = r6.c
            android.content.Context r5 = r6.f290b
            float r1 = com.sinovoice.hcicloudinputvehicle.ui.UITools.o(r1, r5, r2, r8)
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            goto L88
        L5d:
            android.content.Context r1 = r6.c
            android.content.Context r5 = r6.f290b
            int r1 = com.sinovoice.hcicloudinputvehicle.ui.UITools.m(r1, r5, r2, r8)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L88
        L6a:
            android.content.Context r1 = r6.c
            android.content.Context r5 = r6.f290b
            java.lang.String r1 = com.sinovoice.hcicloudinputvehicle.ui.UITools.t(r1, r5, r2, r8)
            goto L88
        L73:
            android.content.Context r1 = r6.c
            android.content.Context r5 = r6.f290b
            android.graphics.drawable.Drawable r1 = com.sinovoice.hcicloudinputvehicle.ui.UITools.p(r1, r5, r2, r8)
            boolean r2 = r1 instanceof android.graphics.drawable.StateListDrawable
            if (r2 == 0) goto L88
        L7f:
            goto L26
        L80:
            android.content.Context r1 = r6.c
            android.content.Context r5 = r6.f290b
            java.lang.Integer r1 = com.sinovoice.hcicloudinputvehicle.ui.UITools.u(r1, r5, r2, r8)
        L88:
            r2 = r1
            r1 = 1
        L8a:
            if (r2 != 0) goto L93
            com.sinovoice.hcicloudinputvehicle.ui.UITheme.f289a = r4
            java.lang.Object r7 = r6.g(r7, r8, r9)
            return r7
        L93:
            if (r1 == 0) goto L9c
            if (r9 != 0) goto L9c
            java.util.HashMap<com.sinovoice.hcicloudinputvehicle.ui.UITheme$a, java.lang.Object> r7 = r6.d
            r7.put(r0, r2)
        L9c:
            com.sinovoice.hcicloudinputvehicle.ui.UITheme.f289a = r3
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sinovoice.hcicloudinputvehicle.ui.UITheme.g(int, java.lang.String, boolean):java.lang.Object");
    }

    private String j(String str, String str2) {
        if (str == null || !f289a) {
            return str2;
        }
        return str2 + str;
    }

    public void a() {
        this.e.clear();
    }

    public int b(String str) {
        return ((Integer) f(3, str)).intValue();
    }

    public ColorStateList c(String str) {
        return (ColorStateList) f(9, str);
    }

    public float d(String str) {
        return ((Float) f(4, str)).floatValue();
    }

    public Drawable e(String str) {
        return (Drawable) g(1, str, false);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || UITheme.class != obj.getClass()) {
            return false;
        }
        return this.f.equals(((UITheme) obj).f);
    }

    public String h(String str) {
        return (String) f(2, str);
    }

    public int hashCode() {
        return this.f.hashCode();
    }

    public String[] i(String str) {
        return (String[]) f(7, str);
    }

    public int k(String str) {
        return ((Integer) f(0, str)).intValue();
    }

    public void l() {
        a();
        this.d.clear();
    }

    public void m(String str) {
        this.f = str;
        l();
    }
}
