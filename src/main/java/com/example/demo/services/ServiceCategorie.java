package com.example.demo.services;

import com.example.demo.conception.ICategorie;
import com.example.demo.entity.Categorie;
import com.example.demo.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ServiceCategorie implements ICategorie {

    @Autowired
    CategorieRepository categorieRepository;

    @Override
    public List<Categorie> listes() {
        return categorieRepository.findAll();
    }

    @Override
    public Categorie store(String code, String libele) {
         Categorie categorie=categorieRepository.findByCode(code);
        if (categorie!=null) throw new RuntimeException("Le code existe");
         Categorie c=new Categorie();
         c.setCode(code);
         c.setLibelle(libele);
         categorieRepository.save(c);
         return c;
    }

    @Override
    public Categorie show(Long id) {
        return categorieRepository.findById(id).get();
    }

    @Override
    public Categorie update(String code, String libele, Long id) {
        Categorie c= show(id);
        c.setCode(code);
        c.setLibelle(libele);
        return categorieRepository.save(c);
    }

    @Override
    public String delete(Long id) {
        categorieRepository.deleteById(id);
        return "Suppression";
    }

    @Override
    public Categorie store2(Categorie categorie) {

        Categorie c=categorieRepository.findByCode(categorie.getCode());
        if (c!=null) throw new RuntimeException("Le code existe");

        return categorieRepository.save(categorie);
    }
}
