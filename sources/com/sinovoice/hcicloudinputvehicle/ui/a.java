package com.sinovoice.hcicloudinputvehicle.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.support.annotation.XmlRes;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import com.sinovoice.hcicloudinputvehicle.R;
import com.sinovoice.hcicloudinputvehicle.R$styleable;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/* compiled from: Keyboard.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static int[] f296a;

    /* renamed from: b  reason: collision with root package name */
    private static int[] f297b;
    private static int[] c;
    private static float d;
    private static int e;
    private int g;
    private int h;
    private boolean j;
    private int m;
    private int n;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int[][] v;
    private int w;
    private boolean y;
    private C0015a z;
    private C0015a[] k = {null, null};
    private int[] l = {-1, -1};
    private ArrayList<b> x = new ArrayList<>();
    private int f = 0;
    private int i = 0;
    private List<C0015a> o = new ArrayList();
    private List<C0015a> p = new ArrayList();

    /* compiled from: Keyboard.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f300a;

        /* renamed from: b  reason: collision with root package name */
        public int f301b;
        public int c;
        public int d;
        ArrayList<C0015a> e = new ArrayList<>();
        public int f;
        public int g;
        public int h;
        private a i;

        public b(Resources resources, a aVar, XmlResourceParser xmlResourceParser) {
            this.i = aVar;
            TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlResourceParser), R$styleable.Keyboard);
            this.f300a = a.l(obtainAttributes, 2, aVar.q, aVar.g);
            this.f301b = a.l(obtainAttributes, 1, aVar.r, aVar.h);
            this.c = a.l(obtainAttributes, 0, aVar.q, aVar.f);
            this.d = a.l(obtainAttributes, 3, aVar.r, aVar.i);
            obtainAttributes.recycle();
            TypedArray obtainAttributes2 = resources.obtainAttributes(Xml.asAttributeSet(xmlResourceParser), R$styleable.Keyboard_Row);
            this.f = obtainAttributes2.getInt(2, 0);
            this.g = obtainAttributes2.getInt(1, 0);
            this.h = a.l(obtainAttributes2, 0, aVar.q, 0);
        }
    }

    static {
        int[] iArr = {R.drawable.icon_confirm, R.drawable.icon_go, R.drawable.icon_search, R.drawable.icon_confirm, R.drawable.icon_next, R.drawable.icon_confirm, R.drawable.icon_last, R.drawable.icon_confirm};
        f296a = iArr;
        f297b = iArr;
        c = new int[]{R.drawable.icon_confirm_night, R.drawable.icon_go_night, R.drawable.icon_search_night, R.drawable.icon_confirm_night, R.drawable.icon_next_night, R.drawable.icon_confirm_night, R.drawable.icon_last_night, R.drawable.icon_confirm_night};
        d = 1.8f;
    }

    public a(Context context, @XmlRes int i, int i2, int i3, int i4) {
        this.q = i3;
        this.r = i4;
        int i5 = i3 / 10;
        this.g = i5;
        this.h = i5;
        this.s = i2;
        u(context, context.getResources().getXml(i));
    }

    private void B(XmlResourceParser xmlResourceParser) {
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1) {
                return;
            }
            if (next == 3 && xmlResourceParser.getName().equals("Row")) {
                return;
            }
        }
    }

    private void i() {
        this.t = ((p() + 10) - 1) / 10;
        this.u = ((n() + 5) - 1) / 5;
        this.v = new int[50];
        int[] iArr = new int[this.o.size()];
        int i = this.t * 10;
        int i2 = this.u * 5;
        int i3 = 0;
        while (i3 < i) {
            int i4 = 0;
            while (i4 < i2) {
                int i5 = 0;
                for (int i6 = 0; i6 < this.o.size(); i6++) {
                    C0015a c0015a = this.o.get(i6);
                    if (c0015a.k(i3, i4) < this.w || c0015a.k((this.t + i3) - 1, i4) < this.w || c0015a.k((this.t + i3) - 1, (this.u + i4) - 1) < this.w || c0015a.k(i3, (this.u + i4) - 1) < this.w) {
                        iArr[i5] = i6;
                        i5++;
                    }
                }
                int[] iArr2 = new int[i5];
                System.arraycopy(iArr, 0, iArr2, 0, i5);
                int[][] iArr3 = this.v;
                int i7 = this.u;
                iArr3[((i4 / i7) * 10) + (i3 / this.t)] = iArr2;
                i4 += i7;
            }
            i3 += this.t;
        }
    }

    static int l(TypedArray typedArray, int i, int i2, int i3) {
        TypedValue peekValue = typedArray.peekValue(i);
        if (peekValue == null) {
            return i3;
        }
        int i4 = peekValue.type;
        if (i4 == 5) {
            return typedArray.getDimensionPixelOffset(i, i3);
        }
        return i4 == 6 ? Math.round(typedArray.getFraction(i, i2, i2, i3)) : i3;
    }

    private void u(Context context, XmlResourceParser xmlResourceParser) {
        int i;
        Resources resources = context.getResources();
        C0015a c0015a = null;
        b bVar = null;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        while (true) {
            try {
                int next = xmlResourceParser.next();
                if (next == 1) {
                    break;
                } else if (next == 2) {
                    String name = xmlResourceParser.getName();
                    if ("Row".equals(name)) {
                        b k = k(resources, xmlResourceParser);
                        int i4 = k.h;
                        int i5 = i4 + 0;
                        e = i4;
                        this.x.add(k);
                        int i6 = k.g;
                        if ((i6 == 0 || i6 == this.s) ? false : true) {
                            B(xmlResourceParser);
                            bVar = k;
                            i3 = i5;
                            z2 = false;
                        } else {
                            bVar = k;
                            i3 = i5;
                            z2 = true;
                        }
                    } else if ("Key".equals(name)) {
                        c0015a = j(resources, bVar, i3, i2, xmlResourceParser);
                        this.o.add(c0015a);
                        int[] iArr = c0015a.k;
                        if (iArr[0] == -1) {
                            int i7 = 0;
                            while (true) {
                                C0015a[] c0015aArr = this.k;
                                if (i7 >= c0015aArr.length) {
                                    break;
                                } else if (c0015aArr[i7] == null) {
                                    c0015aArr[i7] = c0015a;
                                    this.l[i7] = this.o.size() - 1;
                                    break;
                                } else {
                                    i7++;
                                }
                            }
                        } else if (iArr[0] == -20) {
                            this.p.add(c0015a);
                        } else if (c0015a.e()) {
                            this.z = c0015a;
                        }
                        bVar.e.add(c0015a);
                        z = true;
                    } else if ("Keyboard".equals(name)) {
                        w(resources, xmlResourceParser);
                    }
                } else if (next == 3) {
                    if (z) {
                        if (i3 != 0 && i3 != bVar.h) {
                            i = c0015a.s + c0015a.q;
                        } else {
                            i = c0015a.q;
                        }
                        i3 += i;
                        if (i3 > this.n) {
                            this.n = i3;
                        }
                        z = false;
                    } else if (z2) {
                        i2 = i2 + bVar.d + bVar.f301b;
                        z2 = false;
                    }
                }
            } catch (Exception e2) {
                Log.e("Keyboard", "Parse error:" + e2);
                e2.printStackTrace();
            }
        }
        this.m = i2 - this.i;
    }

    private void w(Resources resources, XmlResourceParser xmlResourceParser) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlResourceParser), R$styleable.Keyboard);
        int i = this.q;
        this.g = l(obtainAttributes, 2, i, i / 10);
        this.h = l(obtainAttributes, 1, this.r, 50);
        this.f = l(obtainAttributes, 0, this.q, 0);
        this.i = l(obtainAttributes, 3, this.r, 0);
        int i2 = (int) (this.g * d);
        this.w = i2;
        this.w = i2 * i2;
        obtainAttributes.recycle();
    }

    public static void y() {
        f297b = f296a;
    }

    public static void z() {
        f297b = c;
    }

    public boolean A(boolean z) {
        C0015a[] c0015aArr;
        for (C0015a c0015a : this.k) {
            if (c0015a != null) {
                if (z) {
                    c0015a.v = true;
                } else {
                    c0015a.A = false;
                    c0015a.v = false;
                }
            }
        }
        if (this.j != z) {
            this.j = z;
            return true;
        }
        return false;
    }

    protected C0015a j(Resources resources, b bVar, int i, int i2, XmlResourceParser xmlResourceParser) {
        return new C0015a(resources, bVar, i, i2, xmlResourceParser);
    }

    protected b k(Resources resources, XmlResourceParser xmlResourceParser) {
        return new b(resources, this, xmlResourceParser);
    }

    public C0015a m() {
        return this.z;
    }

    public int n() {
        return this.m;
    }

    public List<C0015a> o() {
        return this.o;
    }

    public int p() {
        return this.n;
    }

    public int[] q(int i, int i2) {
        int i3;
        if (this.v == null) {
            i();
        }
        return (i < 0 || i >= p() || i2 < 0 || i2 >= n() || (i3 = ((i2 / this.u) * 10) + (i / this.t)) >= 50) ? new int[0] : this.v[i3];
    }

    public int r() {
        C0015a c0015a = this.k[0];
        if (c0015a != null) {
            boolean z = c0015a.v;
            if (z || c0015a.A) {
                return !z ? 2 : 1;
            }
            return 0;
        }
        return 0;
    }

    public boolean s() {
        C0015a[] c0015aArr;
        for (C0015a c0015a : this.k) {
            if (c0015a != null) {
                Log.d("Keyboard", "shiftKey.on:" + c0015a.A);
                return c0015a.A;
            }
        }
        return false;
    }

    public boolean t() {
        return this.j;
    }

    public void v() {
        C0015a[] c0015aArr;
        for (C0015a c0015a : this.k) {
            if (c0015a != null) {
                c0015a.A = true;
                c0015a.v = false;
            }
        }
        this.j = true;
    }

    public boolean x(boolean z) {
        for (C0015a c0015a : this.p) {
            if (c0015a != null) {
                c0015a.A = z;
            }
        }
        if (this.y != z) {
            this.y = z;
            return true;
        }
        return false;
    }

    /* compiled from: Keyboard.java */
    /* renamed from: com.sinovoice.hcicloudinputvehicle.ui.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0015a {

        /* renamed from: a  reason: collision with root package name */
        private static final int[] f298a = {16842911, 16842912};

        /* renamed from: b  reason: collision with root package name */
        public static final int[] f299b = {16842919, 16842911, 16842912};
        private static final int[] c = {16842911};
        private static final int[] d = {16842919, 16842911, 16842912};
        private static final int[] e = {16842919, 16843518, 16842914};
        private static final int[] f = {16843518, 16842914};
        private static final int[] g = {16842919, 16843518};
        private static final int[] h = {16843518};
        private static final int[] i = new int[0];
        private static final int[] j = {16842919};
        public boolean A;
        public CharSequence B;
        public CharSequence C;
        public int D;
        public int E;
        public boolean F;
        private a G;
        public int H;
        public boolean I;
        public int[] k;
        public CharSequence l;
        public CharSequence m;
        public Drawable n;
        public Drawable o;
        public int p;
        public int q;
        public int r;
        public int s;
        public boolean t;
        public boolean u;
        public boolean v;
        public boolean w;
        public int x;
        public int y;
        public boolean z;

        public C0015a(b bVar) {
            this.G = bVar.i;
            this.r = bVar.f301b;
            this.q = bVar.f300a;
            this.s = bVar.c;
            this.E = bVar.f;
        }

        public Drawable a(Drawable drawable, Drawable drawable2) {
            return this.D == 1 ? drawable : drawable2;
        }

        public int b(int i2, int i3) {
            return this.D == 1 ? i2 : i3;
        }

        public int[] c() {
            int[] iArr = i;
            if (this.A) {
                if (this.z) {
                    return f299b;
                }
                return f298a;
            } else if (this.w) {
                boolean z = this.v;
                if (z) {
                    if (this.z) {
                        return e;
                    }
                    return f;
                } else if (z) {
                    return iArr;
                } else {
                    if (this.z) {
                        return g;
                    }
                    return h;
                }
            } else if (this.z) {
                return j;
            } else {
                return h;
            }
        }

        public int d(int i2) {
            return (i2 <= 0 || i2 > 7) ? a.f297b[0] : a.f297b[i2 - 1];
        }

        public boolean e() {
            return this.k[0] == -2;
        }

        public boolean f(int i2, int i3) {
            int i4 = this.E;
            boolean z = (i4 & 1) > 0;
            boolean z2 = (i4 & 2) > 0;
            boolean z3 = (i4 & 4) > 0;
            boolean z4 = (i4 & 8) > 0;
            int i5 = this.x;
            if (i2 >= i5 || (z && i2 <= this.q + i5)) {
                if (i2 < this.q + i5 || (z2 && i2 >= i5)) {
                    int i6 = this.y;
                    if (i3 >= i6 || (z3 && i3 <= this.r + i6)) {
                        return i3 < this.r + i6 || (z4 && i3 >= i6);
                    }
                    return false;
                }
                return false;
            }
            return false;
        }

        public boolean g() {
            int[] iArr = this.k;
            return iArr.length > 1 && iArr[iArr.length - 1] == -11;
        }

        public void h() {
            this.z = !this.z;
        }

        public void i(boolean z) {
            this.z = !this.z;
            boolean z2 = this.t;
            if (z2 && !this.w && z) {
                this.A = !this.A;
            } else if (z2 && this.w && z) {
                this.v = !this.v;
            }
        }

        int[] j(String str) {
            int i2;
            int i3 = 0;
            if (str.length() > 0) {
                int i4 = 0;
                i2 = 1;
                while (true) {
                    i4 = str.indexOf(",", i4 + 1);
                    if (i4 <= 0) {
                        break;
                    }
                    i2++;
                }
            } else {
                i2 = 0;
            }
            int[] iArr = new int[i2];
            StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
            while (stringTokenizer.hasMoreTokens()) {
                int i5 = i3 + 1;
                try {
                    iArr[i3] = Integer.parseInt(stringTokenizer.nextToken());
                } catch (NumberFormatException unused) {
                    Log.e("Keyboard", "Error parsing keycodes " + str);
                }
                i3 = i5;
            }
            return iArr;
        }

        public int k(int i2, int i3) {
            int i4 = (this.x + (this.q / 2)) - i2;
            int i5 = (this.y + (this.r / 2)) - i3;
            return (i4 * i4) + (i5 * i5);
        }

        public C0015a(Resources resources, b bVar, int i2, int i3, XmlResourceParser xmlResourceParser) {
            this(bVar);
            this.x = i2;
            this.y = i3;
            TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlResourceParser), R$styleable.Keyboard);
            this.q = a.l(obtainAttributes, 2, this.G.q, bVar.f300a);
            this.r = a.l(obtainAttributes, 1, this.G.r, bVar.f301b);
            this.s = a.l(obtainAttributes, 0, this.G.q, bVar.c);
            obtainAttributes.recycle();
            TypedArray obtainAttributes2 = resources.obtainAttributes(Xml.asAttributeSet(xmlResourceParser), R$styleable.Keyboard_Key);
            if (i2 != 0 && i2 != a.e) {
                this.x += this.s;
            }
            TypedValue typedValue = new TypedValue();
            obtainAttributes2.getValue(1, typedValue);
            int i4 = typedValue.type;
            if (i4 == 16 || i4 == 17) {
                this.k = new int[]{typedValue.data};
            } else if (i4 == 3) {
                this.k = j(typedValue.string.toString());
            }
            Drawable drawable = obtainAttributes2.getDrawable(2);
            this.o = drawable;
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.o.getIntrinsicHeight());
            }
            this.C = obtainAttributes2.getText(14);
            this.H = obtainAttributes2.getResourceId(15, 0);
            this.I = obtainAttributes2.getBoolean(5, false);
            this.F = obtainAttributes2.getBoolean(4, false);
            this.t = obtainAttributes2.getBoolean(6, false);
            this.u = obtainAttributes2.getBoolean(16, false);
            this.w = obtainAttributes2.getBoolean(3, false);
            this.A = this.u;
            int i5 = obtainAttributes2.getInt(7, 0);
            this.E = i5;
            this.E = bVar.f | i5;
            Drawable drawable2 = obtainAttributes2.getDrawable(8);
            this.n = drawable2;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), this.n.getIntrinsicHeight());
            }
            this.p = obtainAttributes2.getInt(9, 0);
            this.l = obtainAttributes2.getText(10);
            this.m = obtainAttributes2.getText(12);
            this.B = obtainAttributes2.getText(11);
            this.D = obtainAttributes2.getInt(0, 1);
            if (this.k == null && !TextUtils.isEmpty(this.l)) {
                this.k = new int[]{this.l.charAt(0)};
            }
            obtainAttributes2.recycle();
        }
    }
}
