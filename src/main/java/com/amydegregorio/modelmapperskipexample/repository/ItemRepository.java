/**
 * 
 */
package com.amydegregorio.modelmapperskipexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amydegregorio.modelmapperskipexample.domain.Item;

/**
 * @author AMD
 *
 */
public interface ItemRepository extends JpaRepository<Item, Long> {

}
