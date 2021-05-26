package com.example.demo.conception;

import com.example.demo.entity.Categorie;

import java.util.List;

public interface ICategorie {
    public List<Categorie> listes();
    public Categorie store(String code, String libele);

    public Categorie show(Long id);

    public Categorie update(String code, String libele,Long id);

    public String delete(Long id);

    public Categorie store2(Categorie categorie);
}
