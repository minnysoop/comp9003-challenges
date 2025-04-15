public class Plant {
    private double height;
    private String species;
    private boolean alive = true;
    private boolean uprooted = false;

    public Plant(double height, String species) {
        this.height = height;
        this.species = species;
    }

    public boolean isWeed() {
        return false;
    }

    public void uproot() {
        this.uprooted = true;
    }

    public boolean isAlive() {
        return this.alive;
    }

    public void kill() {
        this.alive = false;
    }

    public double getHeight() {
        return this.height;
    }

    public String getSpecies() {
        return this.species;
    }

    public boolean uprooted() {
        return this.uprooted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plant)) return false;

        Plant plant = (Plant) o;

        return this.alive == plant.alive &&
               Double.compare(this.height, plant.height) == 0 &&
               this.uprooted == plant.uprooted &&
               this.species.equals(plant.species);
    }
}
