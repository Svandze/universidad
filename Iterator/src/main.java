import java.util.Random;

class RandomData {
    int[] data;

    RandomData(int length) {
        data = new int[length];
        for (int i = 0; i < data.length; i++) {
            data[i] = new Random().nextInt(500);
        }
    }

    IteratorData iterator() {
        return new IteratorData(this);
    }
}

// Iterador que permite recorrer el objeto 'RandomData' sin conocer su implementación exacta
class IteratorData {
    private int[] data;
    private int pos;

    IteratorData(RandomData randomData) {
        data = randomData.data;
        pos = 0;
    }

    boolean hasNext() {
        return pos < data.length;
    }

    Object next() {
        int valor = data[pos];
        pos++;
        return valor;
    }
}

class Client {
    public static void main(String[] args) {
        RandomData vector = new RandomData(5);

        IteratorData iterator = vector.iterator();

        while (iterator.hasNext())
            System.out.println(iterator.next());
    }
}