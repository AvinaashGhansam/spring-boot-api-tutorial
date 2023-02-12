package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

/**
 * There are two types of filtering: Dynamic and Static
 * This class shows an example of each
 */
@RestController
public class FilteringController {

  /**
   * This method will be used as dynamic filtering
   * 
   * @return returns a mappingJacksonValue
   */
  @GetMapping("/filtering")
  public MappingJacksonValue filtering() {
    SomeBean someBean = new SomeBean("val2", "val3", "val4");

    MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
    SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("value1", "value3");
    FilterProvider filters = new SimpleFilterProvider().addFilter("someBeanFilter", filter);
    mappingJacksonValue.setFilters(filters);
    return mappingJacksonValue;
  }

  /**
   * This method will be used for dynamic filtering
   * 
   * @return a list of SomeBean objects parse to JSON
   */
  @GetMapping("/filtering-list")
  public MappingJacksonValue filteringList() {
    List<SomeBean> list = Arrays.asList(
        new SomeBean("value1", "value2", "value3"),
        new SomeBean("value4", "value5", "value6"),
        new SomeBean("value7", "value8", "value9"));

    MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
    SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("value1");
    FilterProvider filters = new SimpleFilterProvider().addFilter("someBeanFilter", filter);
    mappingJacksonValue.setFilters(filters);
    return mappingJacksonValue;

  }

}
