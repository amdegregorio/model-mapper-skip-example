/**
 * 
 */
package com.amydegregorio.modelmapperskipexample.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 * Data Transfer Object for Items.
 * 
 * @author AMD
 *
 */
public class ItemDto {
   private Long id;
   private String name;
   private String description;
   private Integer quantity;
   private String createdBy;
   private String modifiedBy;
   private LocalDate createdDate;
   private LocalDate modifiedDate;
   private String auditFields;
   
   /**
    * Gets id.
    * @return the id
    */
   public Long getId() {
      return id;
   }
   
   /**
    * Sets id.
    * @param id the id to set
    */
   public void setId(Long id) {
      this.id = id;
   }
   
   /**
    * Gets name.
    * @return the name
    */
   public String getName() {
      return name;
   }
   
   /**
    * Sets name.
    * @param name the name to set
    */
   public void setName(String name) {
      this.name = name;
   }
   
   /**
    * Gets description.
    * @return the description
    */
   public String getDescription() {
      return description;
   }
   
   /**
    * Sets description.
    * @param description the description to set
    */
   public void setDescription(String description) {
      this.description = description;
   }
   
   /**
    * Gets quantity.
    * @return the quantity
    */
   public Integer getQuantity() {
      return quantity;
   }
   
   /**
    * Sets quantity.
    * @param quantity the quantity to set
    */
   public void setQuantity(Integer quantity) {
      this.quantity = quantity;
   }
   
   /**
    * Gets createdBy.
    * @return the createdBy
    */
   public String getCreatedBy() {
      return createdBy;
   }
   
   /**
    * Sets createdBy.
    * @param createdBy the createdBy to set
    */
   public void setCreatedBy(String createdBy) {
      this.createdBy = createdBy;
   }
   
   /**
    * Gets modifiedBy.
    * @return the modifiedBy
    */
   public String getModifiedBy() {
      return modifiedBy;
   }
   
   /**
    * Sets modifiedBy.
    * @param modifiedBy the modifiedBy to set
    */
   public void setModifiedBy(String modifiedBy) {
      this.modifiedBy = modifiedBy;
   }
   
   /**
    * Gets createdDate.
    * @return the createdDate
    */
   public LocalDate getCreatedDate() {
      return createdDate;
   }
   
   /**
    * Sets createdDate.
    * @param createdDate the createdDate to set
    */
   public void setCreatedDate(LocalDate createdDate) {
      this.createdDate = createdDate;
   }
   
   /**
    * Gets modifiedDate.
    * @return the modifiedDate
    */
   public LocalDate getModifiedDate() {
      return modifiedDate;
   }
   
   /**
    * Sets modifiedDate.
    * @param modifiedDate the modifiedDate to set
    */
   public void setModifiedDate(LocalDate modifiedDate) {
      this.modifiedDate = modifiedDate;
   }

   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      return "ItemDto [id=" + id + ", name=" + name + ", description=" + description + ", quantity=" + quantity
               + ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy + ", createdDate=" + createdDate
               + ", modifiedDate=" + modifiedDate + "]";
   }

   
   /**
    * Gets auditFields.
    * @return the auditFields
    */
   public String getAuditFields() {
      if (auditFields == null || auditFields.length() == 0) {
         auditFields = "Created By: " + (createdBy != null ? createdBy : "");
         auditFields += " Created Date: " + (createdDate != null ? createdDate.format(DateTimeFormatter.ISO_DATE) : "");
         auditFields += " Modified By: " + (modifiedBy != null ? modifiedBy : "");
         auditFields += " Modified Date: " + (modifiedDate != null ? modifiedDate.format(DateTimeFormatter.ISO_DATE) : "");
      }
      return auditFields;
   }
}
