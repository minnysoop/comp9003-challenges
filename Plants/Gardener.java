import java.util.*;

public class Gardener {
	public void uprootWeeds(List<Plant> garden) {
        for (Plant plant : garden) {
            if (plant.isWeed()) {
                plant.uproot();
            }
        }
    }

    public void removeUndesirables(List<Plant> garden) {
		for (int i = 0; i < garden.size(); i++) {
			if (!garden.get(i).isAlive() || garden.get(i).isWeed()) {
                garden.remove(i);
            }
		}
    }
	
	public static void main(String[] args) {
		//Use this for your own tests
		
	}
}
