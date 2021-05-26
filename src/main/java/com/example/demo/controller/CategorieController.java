package com.example.demo.controller;

import com.example.demo.dto.DtoCategorie;
import com.example.demo.entity.Categorie;
import com.example.demo.services.ServiceCategorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategorieController {

    @Autowired
    ServiceCategorie serviceCategorie;

    @GetMapping("/categorie")
    public List<Categorie> liste(){
        return  serviceCategorie.listes();
    }

    @PostMapping("/categorie")
   public Categorie store(@RequestBody DtoCategorie dtoCategorie){
    return serviceCategorie.store(dtoCategorie.getCode(),dtoCategorie.getLibelle());
   }

   @PutMapping("/categorie")
   public Categorie update(@RequestBody DtoCategorie dtoCategorie){
        return serviceCategorie.update(dtoCategorie.getCode(),dtoCategorie.getLibelle(),dtoCategorie.getId());
   }

   @GetMapping("/categorie/{id}")
   public Categorie show(@PathVariable Long id){
        return serviceCategorie.show(id);
   }


   @DeleteMapping("/categorie/{id}")
    public String delete(@PathVariable Long id){
        return  serviceCategorie.delete(id);
   }



    @PostMapping("/categorie2")
    public Categorie store2(@RequestBody Categorie categorie){
        return serviceCategorie.store2(categorie);
    }


}
