package com.example.accessingdatamysql.Repository;

import com.example.accessingdatamysql.Model.ProprietarBasic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import com.example.accessingdatamysql.Model.Proprietar;
import org.springframework.stereotype.Repository;

/**
 * // This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
 * // CRUD refers Create, Read, Update, Delete
 */
@Repository
public interface ProprietarRepository extends CrudRepository<Proprietar, Integer> {

}