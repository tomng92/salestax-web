package com.coding_exercise.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.coding_exercise.data.ItemList;
import com.coding_exercise.primefacestuff.EditorBean;
import com.coding_exercise.service.ItemListService;
import com.coding_exercise.service.ItemListServiceImpl;
import com.coding_exercise.tax.ImportDutyCalculator;
import com.coding_exercise.tax.ImportDutyCalculatorImpl;
import com.coding_exercise.tax.SalesTaxCalculator;
import com.coding_exercise.tax.SalesTaxCalculatorImpl;
import com.coding_exercise.util.Utils;


/**
 * Spring Configuration class.
 * @author thanh nguyen
 *
 */
@ImportResource(value = {"classpath:applicationContext.xml"})
@Configuration
@ComponentScan("com.coding_exercise")
public class AppSpringConfig {
	
   @Bean	
   public SalesTaxCalculator salesTaxCalculator(){
	   return new SalesTaxCalculatorImpl();
   }
   @Bean	
   public ImportDutyCalculator importDutyCalculator(){
	   return new ImportDutyCalculatorImpl();
   }

    @Bean	
   public Utils utils(){
	   return new Utils();
   }
      
   @Bean
   public ItemList itemList() {
	   return new ItemList();
   }
   
   @Bean
   public ItemListService itemListService() {
	   return new ItemListServiceImpl();
   }
   
   @Bean
   public EditorBean getEditor() {
	   return new EditorBean();
   }
} 