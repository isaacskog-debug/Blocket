package com.example.securitystart;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class AdvertRepository {

    private List<Advert>adverts;

    public AdvertRepository(){
        adverts=new ArrayList<>();
        adverts.add(new Advert(1L,"Space ship",5000000,"Fying in space super great ship, you buy now","Holder"));
        adverts.add(new Advert(2L,"Space ship2",5000000,"Fying in space super great ship, you buy now","Holder2"));
        adverts.add(new Advert(3L,"Space ship3",5000000,"Fying in space super great ship, you buy now","Holder3"));
    }
    public Advert getAdvert(long id) {
        for (Advert advert : adverts) {
            if (advert.getId()==id) {
                return advert;
            }
        }
        return null;
    }

    public List<Advert> getAllAdverts(){

        return adverts;
    }

    public Advert addAdvert (Advert advert){
        Advert lastadvert = adverts.get(adverts.size()-1);
        advert.setId(lastadvert.getId()+1);
        adverts.add(advert);
        return advert;
    }

    public Advert editAdvert (Advert advert) {
        Advert advertToEdit = this.getAdvert(advert.getId());
        if (advertToEdit != null) {
            advertToEdit.setName(advert.getName());
            advertToEdit.setPrice(advert.getPrice());
            advertToEdit.setDescription(advert.getDescription());
        }
        return advert;
    }

    public void deleteAdvert(int id) {
        Advert advertToDelete = this.getAdvert(Math.toIntExact(id));
        if (advertToDelete != null) {
            adverts.remove(advertToDelete);
        }
    }



}
