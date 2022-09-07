package com.example.securitystart;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class AdvertRepository {

    private List<Advert>adverts;

    public AdvertRepository(){
        adverts=new ArrayList<>();
        adverts.add(new Advert(1,"Space ship",5000000,"Fying in space super great ship, you buy now","Holder"));
        adverts.add(new Advert(2,"Space ship2",5000000,"Fying in space super great ship, you buy now","Holder2"));
        adverts.add(new Advert(3,"Space ship3",5000000,"Fying in space super great ship, you buy now","Holder3"));
    }
    public Advert getAdvert(int id) {
        for (Advert advert : adverts) {
            if (advert.getId()==id) {
                return advert;
            }
        }
        return null;
    }

    public List<Advert> getAdverts() {
        return adverts;
    }
}
