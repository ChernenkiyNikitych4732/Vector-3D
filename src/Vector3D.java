import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Vector3D {
    private double x, y, z;

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public double dotProduct(Vector3D other) {
        return x * other.x + y * other.y + z * other.z;
    }

    public Vector3D crossProduct(Vector3D other) {
        double newX = y * other.z - z * other.y;
        double newY = z * other.x - x * other.z;
        double newZ = x * other.y - y * other.x;
        return new Vector3D(newX, newY, newZ);
    }

    public double angle(Vector3D other) {
        double dotProduct = dotProduct(other);
        double cosAngle = dotProduct / (length() * other.length());
        return Math.acos(cosAngle);
    }

    public Vector3D add(Vector3D other) {
        return new Vector3D(x + other.x, y + other.y, z + other.z);
    }

    public Vector3D subtract(Vector3D other) {
        return new Vector3D(x - other.x, y - other.y, z - other.z);
    }

    public static List<Vector3D> randomVectors(int N) {
        Random random = new Random();
        List<Vector3D> vectors = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            double x = random.nextDouble();
            double y = random.nextDouble();
            double z = random.nextDouble();
            vectors.add(new Vector3D(x, y, z));
        }
        return vectors;
    }

    public static void main(String[] args) {
        Vector3D v1 = new Vector3D(1, 2, 3);
        Vector3D v2 = new Vector3D(4, 5, 6);

        System.out.println("Длина вектора v1: " + v1.length());
        System.out.println("Скалярное произведение v1 и v2: " + v1.dotProduct(v2));
        System.out.println("Векторное произведение v1 и v2: (" + v1.crossProduct(v2).x + ", " +
                v1.crossProduct(v2).y + ", " + v1.crossProduct(v2).z + ")");
        System.out.println("Угол между v1 и v2 в радианах: " + v1.angle(v2));
        System.out.println("Сумма v1 и v2: (" + v1.add(v2).x + ", " + v1.add(v2).y + ", " + v1.add(v2).z + ")");
        System.out.println("Разность v1 и v2: (" + v1.subtract(v2).x + ", " + v1.subtract(v2).y + ", " +
                v1.subtract(v2).z + ")");

        List<Vector3D> randomVectors = Vector3D.randomVectors(5);
        System.out.println("Случайные векторы:");
        for (Vector3D vec : randomVectors) {
            System.out.println("(" + vec.x + ", " + vec.y + ", " + vec.z + ")");
        }
    }
}
