import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.IntStream;

public class InterestingParty {

    public int getBestInvitationPersonCount(String[] first, String[] second) {
        int size = first.length;
        Map<String, Integer> interestMap = new HashMap<>();
        IntStream.range(0, size).forEach(i -> {
            String firstKey = first[i];
            String secondKey = second[i];
            interestMap.put(firstKey, interestMap.getOrDefault(firstKey, 0) + 1);
            interestMap.put(secondKey, interestMap.getOrDefault(secondKey, 0) + 1);
        });

        Optional<Map.Entry<String, Integer>> maxEntry = interestMap.entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue));

        return maxEntry.get().getValue();
    }

    public static void main(String[] args) {
        int bestInvitationPersonCount = new InterestingParty().getBestInvitationPersonCount(
                new String[]{"fishing", "gardening", "swimming", "fishing"},
                new String[]{"hunting", "fishing", "fishing", "biting"});

//                new String[]{"snakes", "programming", "cobra", "monty"},
//                new String[]{"python", "python", "anaconda", "python"});

        System.out.println(bestInvitationPersonCount);
    }
}
