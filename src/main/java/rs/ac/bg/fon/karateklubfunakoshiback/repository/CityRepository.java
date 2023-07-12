/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rs.ac.bg.fon.karateklubfunakoshiback.repository;

import java.util.List;
import rs.ac.bg.fon.karateklubfunakoshiback.model.City;

/**
 *
 * @author Jeks
 */
public interface CityRepository {

    public List<City> getAll();

    public City getById(Long id);
    
}
