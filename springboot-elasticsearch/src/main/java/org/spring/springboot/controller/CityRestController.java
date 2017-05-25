package org.spring.springboot.controller;

import org.spring.springboot.domain.City;
import org.spring.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 城市 Controller 实现 Restful HTTP 服务
 * <p>
 * Created by bysocket on 03/05/2017.
 */
@RestController
public class CityRestController {

    @Autowired
    private CityService cityService;

    /**
     * 新增
     *
     * @param city
     * @return Long City编号id
     */
    @RequestMapping(value = "/api/city", method = RequestMethod.POST)
    public Long createCity(@RequestBody City city) {
        return cityService.saveCity(city);
    }


    /**
     * 查询
     *
     * @param pageIndex  mysql中select * from t_city limit pageIndex,pageSize
     * @param pageSize
     * @param searchContent
     * @return List<City>
     */
    @RequestMapping(value = "/api/city/search", method = RequestMethod.GET)
    public List<City> searchCity(@RequestParam(value = "pageIndex") Integer pageIndex,
                                 @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                 @RequestParam(value = "searchContent") String searchContent) {
        return cityService.searchCity(pageIndex,pageSize,searchContent);
    }
}
