package pl.pjwstk.services;

import pl.pjwstk.models.service.CarServiceSpot;
import pl.pjwstk.models.service.IndependentCarServiceSpot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpotService {
    private List<CarServiceSpot> carServiceSpots;
    private IndependentCarServiceSpot independentCarServiceSpot;


    public SpotService() {
        this.carServiceSpots = new ArrayList<>(8);
        Collections.fill(carServiceSpots, new CarServiceSpot());
        this.independentCarServiceSpot = new IndependentCarServiceSpot();

    }

    public List<CarServiceSpot> getCarServiceSpots() {
        return carServiceSpots;
    }

    public void setCarServiceSpots(List<CarServiceSpot> carServiceSpots) {
        this.carServiceSpots = carServiceSpots;
    }

    public IndependentCarServiceSpot getIndependentCarServiceSpot() {
        return independentCarServiceSpot;
    }

    public void setIndependentCarServiceSpot(IndependentCarServiceSpot independentCarServiceSpot) {
        this.independentCarServiceSpot = independentCarServiceSpot;
    }


}
