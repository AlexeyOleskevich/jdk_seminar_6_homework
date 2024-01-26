package doors;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Random;

public class DoorsGenerator {
    private static final int AMOUNT_OF_DOORS = 3;
    private Random rnd = new Random();

    public int[] generateDoorsId() {
        int[] doorsId = new int[AMOUNT_OF_DOORS];

        for (int i = 0; i < AMOUNT_OF_DOORS; i++) {
            int id = rnd.nextInt(AMOUNT_OF_DOORS) + 1;
            while (alreadyExists(doorsId, id)) {
                id = rnd.nextInt(AMOUNT_OF_DOORS) + 1;
            }
            doorsId[i] = id;
        }
        return doorsId;
    }

    public boolean[] generateDoorWithPrize() {
        boolean[] containsPrize = new boolean[AMOUNT_OF_DOORS];

        while (!ArrayUtils.contains(containsPrize, true)) {
            for (int i = 0; i < AMOUNT_OF_DOORS; i++) {
                boolean contains = rnd.nextBoolean();
                if (contains) {
                    containsPrize[i] = contains;
                    break;
                }
            }
        }

        return containsPrize;
    }

    private boolean alreadyExists(int[] doorsId, int id) {
        return ArrayUtils.contains(doorsId, id);
    }


}
