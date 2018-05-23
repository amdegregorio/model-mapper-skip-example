/**
 * 
 */
package com.amydegregorio.modelmapperskipexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.amydegregorio.modelmapperskipexample.domain.Item;
import com.amydegregorio.modelmapperskipexample.repository.ItemRepository;

/**
 * Command Line Runner implementation for adding some sample data when the
 * app starts up.
 * 
 * @author AMD
 */
@Component
public class DataLoader implements CommandLineRunner {
   @Autowired
   private ItemRepository itemRepository;

   @Override
   public void run(String... args) throws Exception {
      Item widget = new Item();
      widget.setName("Widget L");
      widget.setDescription("Widget (Large)");
      widget.setQuantity(new Integer(5));
      itemRepository.save(widget);
      
      Item wocket = new Item();
      wocket.setName("Wocket 5mm");
      wocket.setDescription("Wocket (5mm)");
      wocket.setQuantity(new Integer(12));
      itemRepository.save(wocket);
      
      Item wocket12 = new Item();
      wocket12.setName("Wocket 12mm");
      wocket12.setDescription("Wocket (12mm)");
      wocket12.setQuantity(new Integer(7));
      itemRepository.save(wocket12);
      
   }

}
