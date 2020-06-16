import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

public class Cryptography {

    public long encrypt(int[] numbers) {
        Arrays.sort(numbers);
        AtomicLong answer = new AtomicLong(1);
        numbers[0]++;

        Arrays.stream(numbers)
                .forEach(i -> answer.updateAndGet(v -> v * i));

        return answer.get();
    }

    public static void main(String[] args) {
        System.out.println(new Cryptography().encrypt(new int[]{1, 2, 3}));
        System.out.println(new Cryptography().encrypt(new int[]{1, 3, 2, 1, 1, 3}));
        System.out.println(new Cryptography().encrypt(new int[]{1000, 999, 998, 997, 996, 995}));
    }
}
