
package com.ucx.service;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ucx.domain.Item;

@org.springframework.stereotype.Repository
public interface ItemRepository extends JpaRepository<Item, Long> {


}
