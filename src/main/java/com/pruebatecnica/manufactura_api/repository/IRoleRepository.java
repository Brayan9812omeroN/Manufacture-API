package com.pruebatecnica.manufactura_api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pruebatecnica.manufactura_api.model.RoleEntity;

@Repository
public interface IRoleRepository extends CrudRepository<RoleEntity, Long>  {

    List<RoleEntity> findRoleEntitiesByRoleEnumIn(List<String> roleNames);

}