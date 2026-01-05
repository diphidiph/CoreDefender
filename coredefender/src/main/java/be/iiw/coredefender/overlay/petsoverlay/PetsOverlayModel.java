package be.iiw.coredefender.overlay.petsoverlay;

import be.iiw.coredefender.pets.Pet;
import be.iiw.coredefender.pets.PetTypeEnum;

import java.util.ArrayList;
import java.util.List;

public class PetsOverlayModel {

    // ---------------------- PET STATE ----------------------
    public static class PetState {
        private final Pet pet;
        public boolean unlocked = false;
        public boolean selected = false;

        public PetState(Pet pet) {
            this.pet = pet;
        }

        public Pet getPet() {
            return pet;
        }
    }

    // ---------------------- DATA ----------------------
    private final List<PetState> petStates = new ArrayList<>();
    private Pet selectedPet = null;

    // ---------------------- CONSTRUCTOR ----------------------
    public PetsOverlayModel() {
        for (PetTypeEnum type : PetTypeEnum.values()) {
            petStates.add(new PetState(new Pet(type)));
        }
    }

    // ---------------------- QUERIES ----------------------
    public List<PetState> getPetStates() {
        return petStates;
    }

    public PetState getState(Pet pet) {
        for (PetState state : petStates) {
            if (state.getPet() == pet) {
                return state;
            }
        }
        return null;
    }

    public Pet getSelectedPet() {
        return selectedPet;
    }

    // ---------------------- MUTATIONS ----------------------
    public boolean unlockPet(Pet pet) {
        PetState state = getState(pet);
        if (state == null || state.unlocked) return false;

        state.unlocked = true;
        return true;
    }

    public void selectPet(Pet pet) {
        selectedPet = pet;

        for (PetState state : petStates) {
            state.selected = (state.getPet() == pet);
        }
    }
}
