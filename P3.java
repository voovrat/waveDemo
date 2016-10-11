/**
 * Created by volodymyr.sergiievsk on 11.10.2016.
 */
public class P3 {
    public double x,y,z;
    public P3() {x=y=z=0.0;}

    public P3(double x,double y,double z) {
        this.x = x; this.y=y; this.z=z;
    }

    void set(double x,double y,double z) {
        this.x = x; this.y = y; this.z = z;
    }
}