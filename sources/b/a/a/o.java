package b.a.a;

import java.math.BigInteger;
/* compiled from: JsonPrimitive.java */
/* loaded from: classes.dex */
public final class o extends j {

    /* renamed from: a  reason: collision with root package name */
    private static final Class<?>[] f39a = {Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};

    /* renamed from: b  reason: collision with root package name */
    private Object f40b;

    public o(Boolean bool) {
        t(bool);
    }

    private static boolean p(o oVar) {
        Object obj = oVar.f40b;
        if (obj instanceof Number) {
            Number number = (Number) obj;
            return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
        }
        return false;
    }

    private static boolean r(Object obj) {
        if (obj instanceof String) {
            return true;
        }
        Class<?> cls = obj.getClass();
        for (Class<?> cls2 : f39a) {
            if (cls2.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        o oVar = (o) obj;
        if (this.f40b == null) {
            return oVar.f40b == null;
        } else if (p(this) && p(oVar)) {
            return m().longValue() == oVar.m().longValue();
        } else {
            Object obj2 = this.f40b;
            if ((obj2 instanceof Number) && (oVar.f40b instanceof Number)) {
                double doubleValue = m().doubleValue();
                double doubleValue2 = oVar.m().doubleValue();
                if (doubleValue != doubleValue2) {
                    return Double.isNaN(doubleValue) && Double.isNaN(doubleValue2);
                }
                return true;
            }
            return obj2.equals(oVar.f40b);
        }
    }

    public boolean h() {
        if (o()) {
            return i().booleanValue();
        }
        return Boolean.parseBoolean(n());
    }

    public int hashCode() {
        long doubleToLongBits;
        if (this.f40b == null) {
            return 31;
        }
        if (p(this)) {
            doubleToLongBits = m().longValue();
        } else {
            Object obj = this.f40b;
            if (obj instanceof Number) {
                doubleToLongBits = Double.doubleToLongBits(m().doubleValue());
            } else {
                return obj.hashCode();
            }
        }
        return (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
    }

    Boolean i() {
        return (Boolean) this.f40b;
    }

    public double j() {
        return q() ? m().doubleValue() : Double.parseDouble(n());
    }

    public int k() {
        return q() ? m().intValue() : Integer.parseInt(n());
    }

    public long l() {
        return q() ? m().longValue() : Long.parseLong(n());
    }

    public Number m() {
        Object obj = this.f40b;
        return obj instanceof String ? new b.a.a.w.f((String) this.f40b) : (Number) obj;
    }

    public String n() {
        if (q()) {
            return m().toString();
        }
        if (o()) {
            return i().toString();
        }
        return (String) this.f40b;
    }

    public boolean o() {
        return this.f40b instanceof Boolean;
    }

    public boolean q() {
        return this.f40b instanceof Number;
    }

    public boolean s() {
        return this.f40b instanceof String;
    }

    void t(Object obj) {
        if (obj instanceof Character) {
            this.f40b = String.valueOf(((Character) obj).charValue());
            return;
        }
        b.a.a.w.a.a((obj instanceof Number) || r(obj));
        this.f40b = obj;
    }

    public o(Number number) {
        t(number);
    }

    public o(String str) {
        t(str);
    }
}
