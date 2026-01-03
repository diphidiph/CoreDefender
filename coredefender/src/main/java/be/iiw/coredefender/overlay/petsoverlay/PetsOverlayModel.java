package be.iiw.coredefender.overlay.petsoverlay;

import be.iiw.coredefender.pets.PetTypeEnum;
import java.util.ArrayList;
import java.util.List;

public class PetsOverlayModel {

    // PET STATE
    public static class PetState {
        private final PetTypeEnum pet;
        public boolean unlocked = false;
        public boolean selected = false;

        public PetState(PetTypeEnum pet) {
            this.pet = pet;
        }

        public PetTypeEnum getPet() {
            return pet;
        }
    }

    // DATA (lijst)
    private final List<PetState> petStates = new ArrayList<>();
    private PetTypeEnum selectedPet = null;

    // CONSTRUCTOR
    public PetsOverlayModel() {
        for (PetTypeEnum pet : PetTypeEnum.values()) {
            petStates.add(new PetState(pet));
        }
    }

    // QUERIES
    public List<PetState> getPetStates() {
        return petStates;
    }

    public PetTypeEnum getSelectedPet() {
        return selectedPet;
    }

    public PetState getState(PetTypeEnum pet) {
        for (PetState state : petStates) {
            if (state.getPet() == pet) {
                return state;
            }
        }
        return null;
    }

    // MUTATIONS
    public boolean unlockPet(PetTypeEnum pet) {
        PetState state = getState(pet);

        if (state.unlocked) {
            return false;
        }

        state.unlocked = true;
        return true;
    }

    public void selectPet(PetTypeEnum pet) {
        selectedPet = pet;

        for (PetState state : petStates) {
            state.selected = (state.getPet() == pet);
        }
    }
}
