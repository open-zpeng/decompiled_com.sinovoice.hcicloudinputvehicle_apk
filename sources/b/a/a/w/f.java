package b.a.a.w;

import java.math.BigDecimal;
/* compiled from: LazilyParsedNumber.java */
/* loaded from: classes.dex */
public final class f extends Number {

    /* renamed from: a  reason: collision with root package name */
    private final String f74a;

    public f(String str) {
        this.f74a = str;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.f74a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            String str = this.f74a;
            String str2 = ((f) obj).f74a;
            return str == str2 || str.equals(str2);
        }
        return false;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.f74a);
    }

    public int hashCode() {
        return this.f74a.hashCode();
    }

    @Override // java.lang.Number
    public int intValue() {
        try {
            try {
                return Integer.parseInt(this.f74a);
            } catch (NumberFormatException unused) {
                return (int) Long.parseLong(this.f74a);
            }
        } catch (NumberFormatException unused2) {
            return new BigDecimal(this.f74a).intValue();
        }
    }

    @Override // java.lang.Number
    public long longValue() {
        try {
            return Long.parseLong(this.f74a);
        } catch (NumberFormatException unused) {
            return new BigDecimal(this.f74a).longValue();
        }
    }

    public String toString() {
        return this.f74a;
    }
}
