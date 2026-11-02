/**Глава 3 Вариант В
Реализовать методы сложения, вычитания, умножения и деления объектов (для
тех классов, объекты которых могут поддерживать арифметические действия). Определить класс Точка на плоскости (в пространстве) и во времени.
 Задать движение точки в определенном направлении. Создать методы по
 определению скорости и ускорения точки. Проверить для двух точек воз
 можность пересечения траекторий. Определить расстояние между двумя
 точками в заданный момент времени.*/
import java.util.Objects;
import java.util.StringJoiner;

public class Point {
    private double x;
    private double y;
    private double t;
    private double vx;
    private double vy;
    private double ax;
    private double ay;

    public Point() {
    }

    public Point(double x, double y, double t) {
        this.x = x;
        this.y = y;
        this.t = t;
    }

    public Point(double x, double y, double t, double vx, double vy, double ax, double ay) {
        this(x, y, t);
        this.vx = vx;
        this.vy = vy;
        this.ax = ax;
        this.ay = ay;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getT() {
        return t;
    }

    public void setT(double t) {
        this.t = t;
    }

    public double getVx() {
        return vx;
    }

    public void setVx(double vx) {
        this.vx = vx;
    }

    public double getVy() {
        return vy;
    }

    public void setVy(double vy) {
        this.vy = vy;
    }

    public double getAx() {
        return ax;
    }

    public void setAx(double ax) {
        this.ax = ax;
    }

    public double getAy() {
        return ay;
    }

    public void setAy(double ay) {
        this.ay = ay;
    }

    public void move(double dt) {
        this.x += vx * dt + (ax * dt * dt) / 2;
        this.y += vy * dt + (ay * dt * dt) / 2;
        this.vx += ax * dt;
        this.vy += ay * dt;
        this.t += dt;
    }

    public double speed() {
        return Math.hypot(vx, vy);
    }

    public double acceleration() {
        return Math.hypot(ax, ay);
    }

    public static double distanceAtTime(Point a, Point b, double targetTime) {
        Point pa = new Point(a.x, a.y, a.t, a.vx, a.vy, a.ax, a.ay);
        Point pb = new Point(b.x, b.y, b.t, b.vx, b.vy, b.ax, b.ay);
        pa.move(targetTime - a.t);
        pb.move(targetTime - b.t);

        return Math.hypot(pa.x - pb.x, pa.y - pb.y);
    }

    public static boolean canIntersect(Point a, Point b) {
        double rvx = b.vx - a.vx;
        double rvy = b.vy - a.vy;
        double dx = b.x - a.x;
        double dy = b.y - a.y;
        if (rvx == 0 && rvy == 0) return false;
        double tClose = -(dx * rvx + dy * rvy) / (rvx * rvx + rvy * rvy);
        return tClose >= 0;
    }

    public Point add(Point other) {
        return new Point(x + other.x, y + other.y, Math.max(t, other.t), vx + other.vx, vy + other.vy, ax + other.ax, ay + other.ay);
    }

    public Point subtract(Point other) {
        return new Point(x - other.x, y - other.y, Math.max(t, other.t), vx - other.vx, vy - other.vy, ax - other.ax, ay - other.ay);
    }

    public Point multiply(double k) {
        return new Point(x * k, y * k, t, vx * k, vy * k, ax * k, ay * k);
    }

    public Point divide(double k) {
        if (k == 0) throw new IllegalArgumentException("делить на 0 нельзя");
        return new Point(x / k, y / k, t, vx / k, vy / k, ax / k, ay / k);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0 &&
                Double.compare(point.t, t) == 0 && Double.compare(point.vx, vx) == 0 &&
                Double.compare(point.vy, vy) == 0 && Double.compare(point.ax, ax) == 0 &&
                Double.compare(point.ay, ay) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, t, vx, vy, ax, ay);
    }

    @Override
    public String toString() {
        return String.format("точка: X=%.1f, Y=%.1f | время: %.1f | скорость: Vx=%.1f, Vy=%.1f | ускорение: Ax=%.1f, Ay=%.1f", x, y, t, vx, vy, ax, ay);
    }
}