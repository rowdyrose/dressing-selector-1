package com.tessasanders.dressingselector.models.data;

import com.tessasanders.dressingselector.models.forms.Dressing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface DressingDao extends CrudRepository<Dressing, Integer> {

}
