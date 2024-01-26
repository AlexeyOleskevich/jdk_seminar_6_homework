package game;

import doors.Door;
import doors.DoorsGenerator;

public class Game {
    private static final int AMOUNT_OF_DOORS = 3;

    private DoorsGenerator generator;
    private Door[] doors;

    public boolean didParticipantWin;

    public Game() {
        doors = new Door[AMOUNT_OF_DOORS];
        generator = new DoorsGenerator();
        initDoors();
        simulateGame();
    }

    private void simulateGame() {
        int selectedDoorId = participantMakesFirstChoice();
        int openDoorId = hostOpensDoor(selectedDoorId);
        int finalChoiceId = participantMakesFinalChoice(selectedDoorId, openDoorId);

        Door doorWithPrize = getDoorWithPrize();

        didParticipantWin = finalChoiceId == doorWithPrize.getId();
    }

    private void initDoors() {
       int[] doorsId = generator.generateDoorsId();
       boolean[] containsPrize = generator.generateDoorWithPrize();
        for (int i = 0; i < AMOUNT_OF_DOORS; i++) {
            doors[i] = new Door(doorsId[i], containsPrize[i]);
        }
    }

    private int participantMakesFirstChoice() {
        int selectedDoorId = (int)(Math.random() * 3 + 1);
        return selectedDoorId;
    }

    private int hostOpensDoor(int participantChoice) {
        int openDoorId = -1;

        for (int i = 0; i < AMOUNT_OF_DOORS; i++) {
            Door current = doors[i];
            if (!current.isContainPrize() && current.getId() != participantChoice) {
                openDoorId = current.getId();
                break;
            }
        }
        return openDoorId;
    }

    private int participantMakesFinalChoice(int firstChoiceId, int openDoorId) {
        int finalDoorId = -1;

        for (int i = 0; i < AMOUNT_OF_DOORS; i++) {
            Door current = doors[i];
            if (current.getId() != firstChoiceId && current.getId() != openDoorId) {
                finalDoorId = current.getId();
                break;
            }
        }
        return finalDoorId;
    }

    private Door getDoorWithPrize() {
        Door doorWithPrize = null;
        for (Door door : doors) {
            if (door.isContainPrize()) {
                doorWithPrize = door;
                break;
            }
        }
        return doorWithPrize;
    }

}
