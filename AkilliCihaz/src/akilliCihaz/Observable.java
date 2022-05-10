package akilliCihaz;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {
    private List<Observer> observerList;

    public Observable() {
        observerList=new ArrayList<>();
    }

    public void attach(Observer observer) {
        observerList.add(observer);
    }

    public void detach(Observer observer) {
        observerList.remove(observer);
    }

    public void haberVer() {
        for(Observer observer: observerList) {
            observer.update(this);
        }
    }
}
