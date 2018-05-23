/**
 * 
 */
package com.amydegregorio.modelmapperskipexample.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.amydegregorio.modelmapperskipexample.domain.Item;
import com.amydegregorio.modelmapperskipexample.dto.ItemDto;
import com.amydegregorio.modelmapperskipexample.repository.ItemRepository;

/**
 * Controller for dealing with Items.
 * 
 * @author AMD
 */
@Controller
public class ItemController {

   @Autowired
   private ItemRepository itemRepository;
   private ModelMapper modelMapper;
   
   @Autowired
   public ItemController(ModelMapper modelMapper) {
      this.modelMapper = modelMapper;
      this.modelMapper.addMappings(skipModifiedFieldsMap);
   }
   
   PropertyMap<ItemDto, Item> skipModifiedFieldsMap = new PropertyMap<ItemDto, Item>() {
      protected void configure() {
         skip().setModifiedBy(null);
         skip().setModifiedDate(null);
      }
   };
   
   @RequestMapping("/")
   public String listAll(Model model) {
      List<Item> items = itemRepository.findAll();
      List<ItemDto> itemDtos = items.stream().map(item -> modelMapper.map(item, ItemDto.class)).collect(Collectors.toList());
      model.addAttribute("items", itemDtos);
      return "item/list";
   }
   
   @RequestMapping(value="/item/add", method=RequestMethod.GET)
   public String addItem(ItemDto itemDto, Model model) {
      model.addAttribute("action", "item/add");
      return "item/entry";
   }
   
   @RequestMapping(value="/item/add",  params={"save"}, method=RequestMethod.POST)
   public String saveNewItem(@Valid ItemDto itemDto, BindingResult bindingResult, Model model) {
      if (bindingResult.hasErrors()) {
         model.addAttribute("action", "item/add");
         return "item/entry";
      }
      
      Item item = modelMapper.map(itemDto, Item.class);
      itemRepository.save(item);
      return "redirect:/";
   }
   
   @RequestMapping(value="/item/add", params={"cancel"}, method=RequestMethod.POST)
   public String cancelNewItem() {
      return "redirect:/";
   }
   
   @RequestMapping(value="/item/edit", method=RequestMethod.GET)
   public String editItem(ItemDto itemDto, Model model, @RequestParam("id") Long id) {
      model.addAttribute("action", "item/edit");
      Item item = itemRepository.getOne(id);
      itemDto = modelMapper.map(item, ItemDto.class);
      model.addAttribute("itemDto", itemDto);
      return "item/entry";
   }
   
   @RequestMapping(value="/item/edit",  params={"save"}, method=RequestMethod.POST)
   public String saveItem(@Valid ItemDto itemDto, BindingResult bindingResult, Model model) {
      if (bindingResult.hasErrors()) {
         model.addAttribute("action", "item/edit");
         return "item/entry";
      }
      
      System.out.println("Item DTO from entry form: " + itemDto.toString());
      Item item = modelMapper.map(itemDto, Item.class);
      System.out.println("Item after mapping from form with Modified fields skipped: " + item.toString());
      itemRepository.save(item);
      return "redirect:/";
   }
   
   @RequestMapping(value="/item/edit", params={"cancel"}, method=RequestMethod.POST)
   public String cancelItem() {
      return "redirect:/";
   }
   
}
