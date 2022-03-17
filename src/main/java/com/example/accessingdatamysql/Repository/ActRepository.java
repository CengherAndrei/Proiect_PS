package com.example.accessingdatamysql.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.accessingdatamysql.Model.Act;
import org.springframework.stereotype.Repository;

/**
 * // This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
 * // CRUD refers Create, Read, Update, Delete
 */
@Repository
public interface ActRepository extends CrudRepository<Act, Integer> {

}